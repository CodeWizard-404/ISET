package org.talend.designer.codegen.translators.technical;

import org.talend.core.model.process.INode;
import org.talend.core.model.process.IConnection;
import org.talend.designer.codegen.config.CodeGeneratorArgument;
import org.talend.core.model.process.ElementParameterParser;
import java.util.List;
import java.util.ArrayList;
import org.talend.core.model.process.IHashableInputConnections;
import org.talend.core.model.process.IHashConfiguration;
import org.talend.core.model.process.IHashableColumn;
import org.talend.core.model.process.IMatchingMode;
import org.talend.core.model.process.IDataConnection;
import org.talend.designer.mapper.external.data.ExternalMapperData;
import org.talend.designer.mapper.external.data.ExternalMapperTable;

public class TAdvancedHashBeginJava
{
  protected static String nl;
  public static synchronized TAdvancedHashBeginJava create(String lineSeparator)
  {
    nl = lineSeparator;
    TAdvancedHashBeginJava result = new TAdvancedHashBeginJava();
    nl = null;
    return result;
  }

  public final String NL = nl == null ? (System.getProperties().getProperty("line.separator")) : nl;
  protected final String TEXT_1 = "";
  protected final String TEXT_2 = NL + "\t\t\t   \t\t// connection name:";
  protected final String TEXT_3 = NL + "\t\t\t   \t\t// source node:";
  protected final String TEXT_4 = " | target node:";
  protected final String TEXT_5 = NL + "\t\t\t   \t\t// linked node: ";
  protected final String TEXT_6 = NL + "\t\t\t   ";
  protected final String TEXT_7 = NL + "\t\t\t   \t\torg.talend.designer.components.lookup.common.ICommonLookup.MATCHING_MODE matchingModeEnum_";
  protected final String TEXT_8 = " = " + NL + "\t\t\t   \t\t\torg.talend.designer.components.lookup.common.ICommonLookup.MATCHING_MODE.";
  protected final String TEXT_9 = ";" + NL + "\t\t\t   \t\t\t" + NL + "\t\t\t   ";
  protected final String TEXT_10 = NL + "\t\t\t   synchronized(this) {" + NL + "\t\t\t   \t\ttry {  " + NL + "\t\t\t   \t\tif (globalMap.get(\"tHash_Lookup_";
  protected final String TEXT_11 = "\") == null) {" + NL + "\t\t\t   \t\t" + NL + "\t\t\t   ";
  protected final String TEXT_12 = NL + "\t\t\t\t\torg.talend.designer.components.lookup.persistent.Persistent";
  protected final String TEXT_13 = "LookupManager<";
  protected final String TEXT_14 = "Struct> tHash_Lookup_";
  protected final String TEXT_15 = " = " + NL + "\t   \t\t\t\t\tnew org.talend.designer.components.lookup.persistent.Persistent";
  protected final String TEXT_16 = "Struct>(matchingModeEnum_";
  protected final String TEXT_17 = ", ";
  protected final String TEXT_18 = " + \"/\"+ jobName +\"_tMapData_\" + pid +\"_Lookup_";
  protected final String TEXT_19 = "_\"" + NL + "\t   \t\t\t\t\t, new org.talend.designer.components.persistent.IRowCreator() {" + NL + "\t   \t\t\t\t\t\tpublic ";
  protected final String TEXT_20 = "Struct createRowInstance() {" + NL + "\t   \t\t\t\t\t\t\treturn new ";
  protected final String TEXT_21 = "Struct();" + NL + "\t   \t\t\t\t\t\t}" + NL + "\t   \t\t\t\t\t}" + NL + "\t   \t\t\t\t\t";
  protected final String TEXT_22 = NL + "\t   \t\t\t\t\t\t, ";
  protected final String TEXT_23 = NL + "\t   \t\t\t\t\t";
  protected final String TEXT_24 = NL + "\t   \t\t\t\t\t); " + NL + "" + NL + "\t   \t\t\t\ttHash_Lookup_";
  protected final String TEXT_25 = ".initPut();" + NL + "" + NL + "\t\t   \t   \t   globalMap.put(\"tHash_Lookup_";
  protected final String TEXT_26 = "\", tHash_Lookup_";
  protected final String TEXT_27 = ");" + NL + "\t\t   \t   \t   " + NL + "\t   \t\t\t";
  protected final String TEXT_28 = NL + "\t   \t\t\t" + NL + "\t   \t\t\torg.talend.designer.components.lookup.memory.AdvancedMemoryLookup<";
  protected final String TEXT_29 = " = " + NL + "\t   \t\t\t\t\t\torg.talend.designer.components.lookup.memory.ConcurrentAdvancedMemoryLookup." + NL + "\t   \t\t\t\t\t\t\t<";
  protected final String TEXT_30 = "Struct>getLookup(matchingModeEnum_";
  protected final String TEXT_31 = ");" + NL + "\t   \t\t\t";
  protected final String TEXT_32 = NL + "\t   \t\t\torg.talend.designer.components.lookup.memory.AdvancedMemoryLookup<";
  protected final String TEXT_33 = " =org.talend.designer.components.lookup.memory.AdvancedMemoryLookup." + NL + "\t   \t\t\t\t\t\t<";
  protected final String TEXT_34 = "\t\t\t   " + NL + "\t\t   \t   \t   globalMap.put(\"tHash_Lookup_";
  protected final String TEXT_35 = ");" + NL + "\t\t   \t   \t   " + NL + "\t\t\t\t";
  protected final String TEXT_36 = " " + NL + "\t\t\t\t/*" + NL + "\t\t\t\t * Valid target not found for connection \"";
  protected final String TEXT_37 = "\"" + NL + "\t\t\t\t */ " + NL + "\t\t\t\t";
  protected final String TEXT_38 = NL + "           ";
  protected final String TEXT_39 = NL;

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
        	
    stringBuffer.append(TEXT_2);
    stringBuffer.append(connectionName);
    stringBuffer.append(TEXT_3);
    stringBuffer.append(connection.getSource());
    stringBuffer.append(TEXT_4);
    stringBuffer.append(connection.getTarget());
    stringBuffer.append(TEXT_5);
    stringBuffer.append(((IDataConnection) connection).getLinkNodeForHash());
    stringBuffer.append(TEXT_6);
    
			INode validTarget = ((IDataConnection) connection).getLinkNodeForHash();

			if(validTarget != null) {
				List<IHashableColumn> hashableColumns = null;
				IMatchingMode matchingMode = null;
				String tempFolder = null;
				String rowsBufferSize = null;
				IHashConfiguration hashConfiguration = null;				
				String matchingModeStr = null;
				boolean bSortOnDisk = "true".equals(ElementParameterParser.getValue(node, "__SORT_ON_DISK__")); 
				
				boolean isOneOfReloadLookupMode = false;
				
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
				} else{
				    List<java.util.Map<String, String>> listBlockings = (List<java.util.Map<String, String>>)ElementParameterParser.getObjectValue(node, "__BLOCKING_DEFINITION__");
				  	matchingModeStr = (listBlockings == null || listBlockings.size() == 0) ? "ALL_ROWS" : "ALL_MATCHES";
                    tempFolder = ElementParameterParser.getValue(node, "__TMP_DIRECTORY__");
				  	rowsBufferSize = ElementParameterParser.getValue(node, "__ROWS_BUFFER_SIZE__");
				}

					if(hashConfiguration == null) {
						hashableColumns = new ArrayList(0);
						
						//System.out.println(connectionName + " ### " + hashConfiguration + "IS NULL ##### " + validTarget + " " + validTarget.getClass());
						
					} else {
						tempFolder = hashConfiguration.getTemporaryDataDirectory();
						hashableColumns = hashConfiguration.getHashableColumns();
						matchingMode = hashConfiguration.getMatchingMode();
						rowsBufferSize = hashConfiguration.getRowsBufferSize();
					}
					
					if (matchingModeStr == null){
					  if(matchingMode == null) {
						  if(hashableColumns.size() > 0) {
							matchingModeStr = "UNIQUE_MATCH";
						  } else {
							matchingModeStr = "ALL_ROWS";
						  }
					  } else {
						matchingModeStr = matchingMode.toString();
					  }
					}
					
					boolean isAllRows = "ALL_ROWS".equals(matchingModeStr);
					
					boolean includeParallelComps = false;
					INode collectorNode = validTarget.getDesignSubjobStartNode();
           			if ("tCollector".equals(collectorNode.getComponent().getName())) {
        				includeParallelComps = true;
        			}
			   
    stringBuffer.append(TEXT_7);
    stringBuffer.append(connectionName);
    stringBuffer.append(TEXT_8);
    stringBuffer.append( matchingModeStr );
    stringBuffer.append(TEXT_9);
    if (includeParallelComps && !(hashConfiguration != null && hashConfiguration.isPersistent() || bSortOnDisk) && !isOneOfReloadLookupMode) {
    stringBuffer.append(TEXT_10);
    stringBuffer.append(connectionName);
    stringBuffer.append(TEXT_11);
    
			   	}
				if (hashConfiguration != null && hashConfiguration.isPersistent() || bSortOnDisk) {
				
    stringBuffer.append(TEXT_12);
    stringBuffer.append( isAllRows ? "" : "Sorted" );
    stringBuffer.append(TEXT_13);
    stringBuffer.append(connectionName);
    stringBuffer.append(TEXT_14);
    stringBuffer.append(connectionName);
    stringBuffer.append(TEXT_15);
    stringBuffer.append( isAllRows ? "" : "Sorted" );
    stringBuffer.append(TEXT_13);
    stringBuffer.append(connectionName);
    stringBuffer.append(TEXT_16);
    stringBuffer.append(connectionName);
    stringBuffer.append(TEXT_17);
    stringBuffer.append( tempFolder );
    stringBuffer.append(TEXT_18);
    stringBuffer.append(connectionName);
    stringBuffer.append(TEXT_19);
    stringBuffer.append(connectionName);
    stringBuffer.append(TEXT_20);
    stringBuffer.append(connectionName);
    stringBuffer.append(TEXT_21);
     if(!isAllRows) { 
    stringBuffer.append(TEXT_22);
    stringBuffer.append( rowsBufferSize );
    stringBuffer.append(TEXT_23);
     } 
    stringBuffer.append(TEXT_24);
    stringBuffer.append(connectionName);
    stringBuffer.append(TEXT_25);
    stringBuffer.append(connectionName);
    stringBuffer.append(TEXT_26);
    stringBuffer.append(connectionName);
    stringBuffer.append(TEXT_27);
    	
	   			} else {
	   				if (includeParallelComps && !isOneOfReloadLookupMode) {
	   			
    stringBuffer.append(TEXT_28);
    stringBuffer.append(connectionName);
    stringBuffer.append(TEXT_14);
    stringBuffer.append(connectionName);
    stringBuffer.append(TEXT_29);
    stringBuffer.append(connectionName);
    stringBuffer.append(TEXT_30);
    stringBuffer.append(connectionName);
    stringBuffer.append(TEXT_31);
    
	   				} else {
	   			
    stringBuffer.append(TEXT_32);
    stringBuffer.append(connectionName);
    stringBuffer.append(TEXT_14);
    stringBuffer.append(connectionName);
    stringBuffer.append(TEXT_33);
    stringBuffer.append(connectionName);
    stringBuffer.append(TEXT_30);
    stringBuffer.append(connectionName);
    stringBuffer.append(TEXT_31);
    
	   				}
	   			
    stringBuffer.append(TEXT_34);
    stringBuffer.append(connectionName);
    stringBuffer.append(TEXT_26);
    stringBuffer.append(connectionName);
    stringBuffer.append(TEXT_35);
    
				}
			} else {
				
    stringBuffer.append(TEXT_36);
    stringBuffer.append( connectionName);
    stringBuffer.append(TEXT_37);
    
			}
		}
	}


    stringBuffer.append(TEXT_38);
    stringBuffer.append(TEXT_39);
    return stringBuffer.toString();
  }
}
