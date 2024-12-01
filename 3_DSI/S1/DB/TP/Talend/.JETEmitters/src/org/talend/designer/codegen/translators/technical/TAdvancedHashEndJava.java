package org.talend.designer.codegen.translators.technical;

import org.talend.core.model.process.INode;
import org.talend.core.model.process.IConnection;
import org.talend.designer.codegen.config.CodeGeneratorArgument;
import org.talend.core.model.process.ElementParameterParser;
import java.util.List;
import org.talend.core.model.process.EConnectionType;
import org.talend.core.model.process.IHashableInputConnections;
import org.talend.core.model.process.IHashConfiguration;
import org.talend.core.model.process.IDataConnection;
import org.talend.designer.mapper.external.data.ExternalMapperData;
import org.talend.designer.mapper.external.data.ExternalMapperTable;

public class TAdvancedHashEndJava
{
  protected static String nl;
  public static synchronized TAdvancedHashEndJava create(String lineSeparator)
  {
    nl = lineSeparator;
    TAdvancedHashEndJava result = new TAdvancedHashEndJava();
    nl = null;
    return result;
  }

  public final String NL = nl == null ? (System.getProperties().getProperty("line.separator")) : nl;
  protected final String TEXT_1 = "";
  protected final String TEXT_2 = NL + "tHash_Lookup_";
  protected final String TEXT_3 = ".endPut();";
  protected final String TEXT_4 = NL + "java.util.List<java.util.Map<String,Object>> mapsList_";
  protected final String TEXT_5 = " = " + NL + "\t(java.util.List<java.util.Map<String,Object>>)globalMap.get(\"THREAD_MAPS_";
  protected final String TEXT_6 = "_\"+jobName);" + NL + "\tif (mapsList_";
  protected final String TEXT_7 = " != null) {" + NL + "\t" + NL + "" + NL + "\t\t\tfor (java.util.Map<String,Object> map : mapsList_";
  protected final String TEXT_8 = ") {" + NL + "\t\t\t\t\torg.talend.designer.components.lookup.memory.ConcurrentAdvancedMemoryLookup" + NL + "\t\t\t   \t\t\t\t\t\t\t<";
  protected final String TEXT_9 = "Struct> tmp = (org.talend.designer.components.lookup.memory.ConcurrentAdvancedMemoryLookup" + NL + "\t\t\t   \t\t\t\t\t\t\t<";
  protected final String TEXT_10 = "Struct>)tHash_Lookup_";
  protected final String TEXT_11 = ";" + NL + "\t\t\t\tif (globalMap != map) {" + NL + "\t\t\t\t" + NL + "\t\t\t\t\t" + NL + "\t\t\t\t\t//map.put(\"MAP_POPULATED_";
  protected final String TEXT_12 = "\",Boolean.TRUE);\t\t\t   \t\t\t\t\t\t\t" + NL + "\t\t\t\t\t" + NL + "\t\t\t\t\tmap.put(\"tHash_Lookup_";
  protected final String TEXT_13 = "\",new org.talend.designer.components.lookup.memory.ConcurrentAdvancedMemoryLookup" + NL + "\t\t\t   \t\t\t\t\t\t\t<";
  protected final String TEXT_14 = "Struct>(tmp));\t\t\t   \t\t\t\t\t\t\t" + NL + "\t\t\t   \t\twhile (map.get(\"tHash_Lookup_";
  protected final String TEXT_15 = "\") == null) {" + NL + "\t\t\t   \t\t\tThread.sleep(1);" + NL + "\t\t\t   \t\t}" + NL + "\t\t\t   \t" + NL + "\t\t\t\t} " + NL + "\t\t\t}" + NL + "" + NL + "\t}" + NL + "" + NL + "} " + NL + "} catch (java.lang.Exception ex) {" + NL + "\tglobalMap.put(\"THREADS_HAVE_ERROR\",ex);" + NL + "\tthrow ex;" + NL + "} catch (Error er) {" + NL + "\tglobalMap.put(\"THREADS_HAVE_ERROR\",er);" + NL + "\tthrow er;" + NL + "}" + NL + "" + NL + "}//end synchronized" + NL + NL;
  protected final String TEXT_16 = NL;

  public String generate(Object argument)
  {
    final StringBuffer stringBuffer = new StringBuffer();
    stringBuffer.append(TEXT_1);
    
	CodeGeneratorArgument codeGenArgument = (CodeGeneratorArgument) argument;
	INode node = (INode)codeGenArgument.getArgument();
	String cid = node.getUniqueName();
	List<IConnection> connections = (List<IConnection>) node.getIncomingConnections();

	if (connections != null && connections.size() > 0) {
        for (IConnection connection : connections) {
        	String connectionName = connection.getName();
			INode validTarget = ((IDataConnection) connection).getLinkNodeForHash();
			boolean memoryStorage = true;
			
			boolean isOneOfReloadLookupMode = false;
			
			if(validTarget != null) {
				IHashConfiguration hashConfiguration = null;				
				boolean bSortOnDisk = "true".equals(ElementParameterParser.getValue(node, "__SORT_ON_DISK__")); 
				
			    if (validTarget instanceof IHashableInputConnections){
					IHashableInputConnections target = (IHashableInputConnections) validTarget;
					hashConfiguration = target.getHashConfiguration(connection.getName());
					
					if("tMap".equals(validTarget.getComponent().getName())) {
    					ExternalMapperData externalData = (ExternalMapperData) (validTarget.getExternalData());
        				List<ExternalMapperTable> inputTables = externalData.getInputTables();
    					for (ExternalMapperTable inputTable : inputTables) {
                			if (inputTable.getName().equals(connection.getName())) {
                				boolean isReloadLookupMode = org.talend.designer.mapper.model.table.LOOKUP_MODE.RELOAD.name().equals(inputTable.getLookupMode());
    							boolean isCacheOrReloadLookupMode = org.talend.designer.mapper.model.table.LOOKUP_MODE.CACHE_OR_RELOAD.name().equals(inputTable.getLookupMode());
    							isOneOfReloadLookupMode = isReloadLookupMode || isCacheOrReloadLookupMode;
                				break;
                			}
            			}
					}
				} 
				memoryStorage = !(hashConfiguration != null && hashConfiguration.isPersistent() || bSortOnDisk);
            
			boolean includeParallelComps = false;
   			INode partitionNode = validTarget.getDesignSubjobStartNode();
   			if ("tCollector".equals(partitionNode.getComponent().getName())) {
				includeParallelComps = true;
				partitionNode = partitionNode.getIncomingConnections(EConnectionType.STARTS).get(0).getSource();
			}

    stringBuffer.append(TEXT_2);
    stringBuffer.append(connectionName);
    stringBuffer.append(TEXT_3);
    
			if (includeParallelComps && memoryStorage && !isOneOfReloadLookupMode) {

    stringBuffer.append(TEXT_4);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_5);
    stringBuffer.append(partitionNode.getUniqueName());
    stringBuffer.append(TEXT_6);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_7);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_8);
    stringBuffer.append(connectionName);
    stringBuffer.append(TEXT_9);
    stringBuffer.append(connectionName);
    stringBuffer.append(TEXT_10);
    stringBuffer.append(connectionName);
    stringBuffer.append(TEXT_11);
    stringBuffer.append(connectionName);
    stringBuffer.append(TEXT_12);
    stringBuffer.append(connectionName);
    stringBuffer.append(TEXT_13);
    stringBuffer.append(connectionName);
    stringBuffer.append(TEXT_14);
    stringBuffer.append(connectionName);
    stringBuffer.append(TEXT_15);
    
			
			}
			
			}
		}
	}

    stringBuffer.append(TEXT_16);
    return stringBuffer.toString();
  }
}
