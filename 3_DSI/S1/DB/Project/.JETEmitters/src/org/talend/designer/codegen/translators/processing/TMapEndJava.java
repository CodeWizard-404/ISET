package org.talend.designer.codegen.translators.processing;

import java.util.ArrayList;
import java.util.List;
import org.talend.designer.mapper.external.data.ExternalMapperData;
import org.talend.designer.mapper.external.data.ExternalMapperTable;
import org.talend.designer.mapper.external.data.ExternalMapperTableEntry;
import org.talend.designer.codegen.config.CodeGeneratorArgument;
import org.talend.designer.mapper.MapperComponent;
import org.talend.core.model.process.INode;
import java.util.HashMap;
import java.util.Map;
import org.talend.core.model.process.IConnection;
import org.talend.core.model.process.EConnectionType;
import org.talend.core.model.process.ElementParameterParser;
import org.talend.designer.mapper.model.tableentry.TableEntryLocation;
import org.talend.designer.mapper.utils.DataMapExpressionParser;
import org.talend.designer.mapper.language.LanguageProvider;
import org.talend.core.model.metadata.IMetadataColumn;
import org.talend.core.model.metadata.types.JavaTypesManager;

public class TMapEndJava {


  protected static String nl;
  public static synchronized TMapEndJava create(String lineSeparator)
  {
    nl = lineSeparator;
    TMapEndJava result = new TMapEndJava();
    nl = null;
    return result;
  }

  public final String NL = nl == null ? (System.getProperties().getProperty("line.separator")) : nl;
  protected final String TEXT_1 = "";
  protected final String TEXT_2 = NL;
  protected final String TEXT_3 = NL + "// ###############################" + NL + "// # Lookup hashes releasing";
  protected final String TEXT_4 = NL + "\t\t\t\t\tfsi_";
  protected final String TEXT_5 = "_";
  protected final String TEXT_6 = ".endGet();" + NL + "\t\t\t\t";
  protected final String TEXT_7 = NL + "\t\t\t\t\tif(tHash_Lookup_";
  protected final String TEXT_8 = " != null) {" + NL + "\t\t\t\t\t\ttHash_Lookup_";
  protected final String TEXT_9 = ".endGet();" + NL + "\t\t\t\t\t}" + NL + "\t\t\t\t\tglobalMap.remove( \"tHash_Lookup_";
  protected final String TEXT_10 = "\" );" + NL + "" + NL + "\t\t\t\t\t";
  protected final String TEXT_11 = NL + NL + "\t\t\t\t\t\ttHash_Lookup_Cache_";
  protected final String TEXT_12 = ".endGet();" + NL + "\t\t\t\t\t\ttHash_Lookup_Cache_";
  protected final String TEXT_13 = " = null;" + NL + "\t\t\t\t\t\ttHash_Lookup_Real_";
  protected final String TEXT_14 = " = null;" + NL + "" + NL + "\t\t\t\t\t";
  protected final String TEXT_15 = NL + "\t\t\t\t\t" + NL + "\t\t\t\t";
  protected final String TEXT_16 = NL + "// ###############################      ";
  protected final String TEXT_17 = NL + "\t\t\t\tlog.debug(\"";
  protected final String TEXT_18 = " - Written records count in the table '";
  protected final String TEXT_19 = "': \" + count_";
  protected final String TEXT_20 = " + \".\");";
  protected final String TEXT_21 = NL + NL + NL + NL;

	public boolean hasConcurrencyContext(List<IConnection> inputConnections, List<? extends INode> graphicalNodes) {

		for(IConnection connection : inputConnections) {
            EConnectionType connectionType = connection.getLineStyle();
            if (connectionType == EConnectionType.FLOW_MAIN) {
	            INode node = connection.getSource();
				return recursiveSearchIterateForConcurrency(node, graphicalNodes);
			}
		}
		return false;
	
	}

	public boolean hasIterateConnectionBefore(List<IConnection> inputConnections, List<? extends INode> graphicalNodes) {

		for(IConnection connection : inputConnections) {
            EConnectionType connectionType = connection.getLineStyle();
            if (connectionType == EConnectionType.FLOW_MAIN) {
	            INode node = connection.getSource();
				return recursiveSearchIterate(node, graphicalNodes);
			}
		}
		return false;
	
	}
	
	public boolean recursiveSearchIterate(INode node, List<? extends INode> graphicalNodes) {
	
		//System.out.println(node);
	
		List<IConnection> connections = (List<IConnection>) node.getIncomingConnections();

		for(IConnection connection : connections) {
            EConnectionType connectionType = connection.getLineStyle();
            if (connectionType == EConnectionType.FLOW_MAIN) {
	            node = connection.getSource();
				//System.out.println(connection.getName() + " connectionType=" + connectionType + " connection=" + String.valueOf(connection));
    	        return recursiveSearchIterate(node, graphicalNodes);
            } else if(connectionType == EConnectionType.ITERATE) {
				//System.out.println("ITERATE return true");
    	        return true;
            }else{
            	//for virtual component
            	boolean find = false;
				for(INode loopNode : graphicalNodes) {
					if(loopNode.getUniqueName().equals(node.getUniqueName())){
						find = true;
					}
				}
				if(!find){
					List<IConnection> vConnections = (List<IConnection>) node.getIncomingConnections();
					for(IConnection vConnection : vConnections) {
						node = vConnection.getSource();
						break;
					}
					return recursiveSearchIterate(node, graphicalNodes);
				}
            }
		}
		
		//System.out.println("return false");
		return false;
	
	}

	private boolean recursiveSearchIterateForConcurrency(INode node, List<? extends INode> graphicalNodes) {
		List<IConnection> connections = (List<IConnection>) node.getIncomingConnections();

		for(IConnection connection : connections) {
            EConnectionType connectionType = connection.getLineStyle();
            if (connectionType == EConnectionType.FLOW_MAIN) {
	            node = connection.getSource();
    	        return recursiveSearchIterateForConcurrency(node, graphicalNodes);
            } else if(connectionType == EConnectionType.ITERATE) {
				boolean parallelIterate = "true".equals(ElementParameterParser.getValue(connection, "__ENABLE_PARALLEL__"));
    	        if(parallelIterate) {
    	        	return true;
    	        } else {
    	        	node = connection.getSource();
        			return recursiveSearchIterateForConcurrency(node, graphicalNodes);
    	        }
            }else{
            	//for virtual component
            	boolean find = false;
				for(INode loopNode : graphicalNodes) {
					if(loopNode.getUniqueName().equals(node.getUniqueName())){
						find = true;
					}
				}
				if(!find){
					List<IConnection> vConnections = (List<IConnection>) node.getIncomingConnections();
					for(IConnection vConnection : vConnections) {
						node = vConnection.getSource();
						break;
					}
					return recursiveSearchIterateForConcurrency(node, graphicalNodes);
				}
            }
		}
		
		return false;
	
	}

	public INode searchSubProcessStartNode(IConnection connection) {
       	INode source = connection.getSource();
    	//System.out.println(" source=" +  source);
    	INode subprocessStartNode = null;
    	if(source != null) {
			String searchedComponentName = source.getUniqueName();
        	//System.out.println(" searchedComponentName=" +  searchedComponentName);
			List<? extends INode> generatedNodes = source.getProcess().getGeneratingNodes();
			for(INode loopNode : generatedNodes) {
				if(loopNode.getUniqueName().equals(searchedComponentName)) {
					subprocessStartNode = loopNode.getSubProcessStartNode(false);
		        	//System.out.println(" subprocessStartNode=" +  subprocessStartNode.getUniqueName());
				}
			}
		}
	
		return subprocessStartNode;
	}
    public boolean hasJoinedTable(String tableNameToTest, ExternalMapperData data) {
        for (ExternalMapperTable table : data.getOutputTables()) {
            if (table.getIsJoinTableOf() != null && table.getIsJoinTableOf().equals(tableNameToTest)) {
                return true;
            }
        }
        return false;
    }
    
    
  public boolean isErrorReject(ExternalMapperTable table){
        String errorMessage = null;
        String errorStackTrace = null; 
        if(table!=null&&table.getName()!=null&&table.getName().endsWith("ErrorReject")){
            for(ExternalMapperTableEntry entry:table.getMetadataTableEntries()){
                if("errorMessage".equals(entry.getName())){
                    errorMessage = entry.getName();
                }else if("errorStackTrace".equals(entry.getName())){
                    errorStackTrace = entry.getName();
                }
            }
            if(errorMessage!=null&&errorStackTrace!=null){
                return true;
            }
        }
        return false;
    }

	public String getExpressionWithAutoConvertFunction(
		String expression, 
		ExternalMapperTableEntry targetTableEntry, 
		IMetadataColumn targetColumn,
		DataMapExpressionParser expressionParser, 
		Map<TableEntryLocation, ExternalMapperTableEntry> locationMap4Entry,
		Map<TableEntryLocation, IMetadataColumn> locationMap4Column, 
		Map<String,String> autoConverterMap, 
		boolean enable_auto_convert_type) {
		
		if(!enable_auto_convert_type) {
			return expression;
		}
		
		if(expression == null || expression.isEmpty()) {
			return expression;
		}
	
		TableEntryLocation uniqueLocation = getUniqueEntryLocation(expression);
		
        if(uniqueLocation == null) {
        	return expression;
        }
        
    	ExternalMapperTableEntry uniqueSourceEntry = locationMap4Entry.get(uniqueLocation);
    	
    	if(uniqueSourceEntry == null) {
    		return expression;
    	}
    	
    	String source_talend_type = uniqueSourceEntry.getType();
        String target_talend_type = targetTableEntry.getType();
        
        String convertFunction = autoConverterMap.get(contact(source_talend_type, ":", target_talend_type));
        
        if(convertFunction!=null && !convertFunction.isEmpty()) {
        	StringBuilder strbuilder = new StringBuilder();
        	
	        if(uniqueSourceEntry.isNullable()) {
	      		strbuilder.append("(((").append(expression).append(") == null) ? null : (");
	        }
        
        	expression = convertFunction.replace("${0}", expression);
        	
        	String pattern = null;
        	if((JavaTypesManager.STRING.getId().equals(source_talend_type)||JavaTypesManager.OBJECT.getId().equals(source_talend_type)) && JavaTypesManager.DATE.getId().equals(target_talend_type)) {
        		if(targetColumn!=null) {
        			pattern = targetColumn.getPattern();
        		}
        		
        		if(pattern == null || pattern.isEmpty()) {
        			pattern = "\"dd-MM-yyyy\"";
        		}
        		
        	} else if(JavaTypesManager.DATE.getId().equals(source_talend_type) && JavaTypesManager.STRING.getId().equals(target_talend_type)) {
        		IMetadataColumn sourceColumn = locationMap4Column.get(uniqueLocation);
        		
        		if(sourceColumn!=null) {
        			pattern = sourceColumn.getPattern();
        		}
        		
        		if(pattern == null || pattern.isEmpty()) {
        			pattern = "\"dd-MM-yyyy\"";
        		}
        	}
        	
        	if(pattern != null) {
        		expression = expression.replace("${1}", pattern);
        	}
        	
        	strbuilder.append(expression);
        	
        	if(uniqueSourceEntry.isNullable()) {
      			strbuilder.append("))");
        	}
        	
        	return strbuilder.toString();
        }
        
        return expression;
	}
	
	java.util.regex.Pattern locationPattern = java.util.regex.Pattern.compile(LanguageProvider.getJavaLanguage().getLocationPattern());
	
	private TableEntryLocation getUniqueEntryLocation(String expression) {
		java.util.regex.Matcher matcher = locationPattern.matcher(expression);
		if(matcher.matches()) {
			return new TableEntryLocation(matcher.group(1), matcher.group(2));
		}
		return null;
	}
	
	StringBuilder strbuilder = new StringBuilder(20);
	
	private String contact(String... content) {
		strbuilder.setLength(0);
		for(String each : content) {
			strbuilder.append(each);
		}
		return strbuilder.toString();
	}

    public String generate(Object argument)
  {
    final StringBuffer stringBuffer = new StringBuffer();
    stringBuffer.append(TEXT_1);
    stringBuffer.append(TEXT_2);
     

	CodeGeneratorArgument codeGenArgument = (CodeGeneratorArgument) argument;
	MapperComponent node = (MapperComponent) codeGenArgument.getArgument();
	boolean stats = codeGenArgument.isStatistics();
	
/////////////////////////////////////////////////////////////////////////////////////////////////////////////////////

    ExternalMapperData data = (ExternalMapperData) node.getExternalData();

	String componentName = node.getUniqueName();
	boolean isVirtualIn = componentName.endsWith("TMAP_IN");
	boolean isVirtualOut = componentName.endsWith("TMAP_OUT");

    List<IConnection> inputConnections = (List<IConnection>) node.getIncomingConnections();
	
	boolean isLog4jEnabled = ("true").equals(ElementParameterParser.getValue(node.getProcess(), "__LOG4J_ACTIVATE__"));

	String uniqueNameComponent = componentName.replaceAll("_TMAP_IN", "");
	uniqueNameComponent = uniqueNameComponent.replaceAll("_TMAP_OUT", "");
	
	if(isVirtualIn) {
		String searchedComponentName = componentName.replaceAll("TMAP_IN", "TMAP_OUT");
		List<? extends INode> generatedNodes = node.getProcess().getGeneratingNodes();
		for(INode loopNode : generatedNodes) {
			if(loopNode.getUniqueName().equals(searchedComponentName)) {
				inputConnections = (List<IConnection>) loopNode.getIncomingConnections();
				break;
			}
		}
	}
	

		// Bug partially fixed, see bug:785	
		// Bug partially fixed, see bug:3966	
		
		boolean hasIterate = hasIterateConnectionBefore(inputConnections, node.getProcess().getGraphicalNodes());
        
        

    stringBuffer.append(TEXT_3);
    

		if(!isVirtualOut) {

	        HashMap<String, IConnection> hNameToConnection = new HashMap<String, IConnection>();
        	for (IConnection connection : inputConnections) {
	            hNameToConnection.put(connection.getName(), connection);
        	}

	        List<ExternalMapperTable> inputTablesList = new ArrayList<ExternalMapperTable>(data.getInputTables());
	        int lstSizeInputs = inputTablesList.size();
	        
	        if(lstSizeInputs > 1) {
	        	String mainTableName = inputTablesList.get(0).getName();
	    
	    		int joinedTableIndex = 0;    	
	    		int tmpJoinedTableIndex = 0;    	
	    		boolean hasPersistentLookup = false;
		        for (int i = 0; i < lstSizeInputs; i++) {
		            ExternalMapperTable inputTable = (ExternalMapperTable) inputTablesList.get(i);

					if(hNameToConnection.get(inputTable.getName()) != null) {
	        			if(inputTable.isPersistent() 
		        			&& !"ALL_ROWS".equals(inputTable.getMatchingMode()) 
	        			) {
		        			joinedTableIndex = tmpJoinedTableIndex;
	        				hasPersistentLookup = true;
	        			}

	        			tmpJoinedTableIndex++;
	        		}

	        	}

	        	if(hasPersistentLookup) {
				
    stringBuffer.append(TEXT_4);
    stringBuffer.append(uniqueNameComponent);
    stringBuffer.append(TEXT_5);
    stringBuffer.append(joinedTableIndex);
    stringBuffer.append(TEXT_6);
    
	        	}
	        	
	        }
	        
	        for (int i = 1; i < lstSizeInputs; i++) {
	            ExternalMapperTable inputTable = (ExternalMapperTable) inputTablesList.get(i);


	            List<ExternalMapperTableEntry> tableEntries = inputTable.getMetadataTableEntries();
	            if (tableEntries == null) {
	                continue;
	            }
	            String tableName = inputTable.getName();
	            IConnection connection = hNameToConnection.get(tableName);
	            if(connection == null) {
	            	continue;
	            }

				String lookupMode = inputTable.getLookupMode();
				boolean isCacheOrReload = org.talend.designer.mapper.model.table.LOOKUP_MODE.CACHE_OR_RELOAD.name().equals(lookupMode);

				if(!hasIterate) {
				
    stringBuffer.append(TEXT_7);
    stringBuffer.append(tableName);
    stringBuffer.append(TEXT_8);
    stringBuffer.append(tableName);
    stringBuffer.append(TEXT_9);
    stringBuffer.append(tableName);
    stringBuffer.append(TEXT_10);
    					
					if(isCacheOrReload) {
					
    stringBuffer.append(TEXT_11);
    stringBuffer.append(tableName);
    stringBuffer.append(TEXT_12);
    stringBuffer.append(tableName);
    stringBuffer.append(TEXT_13);
    stringBuffer.append(tableName);
    stringBuffer.append(TEXT_14);
    					
					}
					
    stringBuffer.append(TEXT_15);
    
				}
	        }
		}

    stringBuffer.append(TEXT_16);
    
	List<IConnection> outputConnections = (List<IConnection>) node.getOutgoingConnections();
	Map<String, IConnection> nameToOutputConnection = new HashMap<String, IConnection>();
	for (IConnection connection : outputConnections) {
		nameToOutputConnection.put(connection.getName(), connection);
	}

	List<ExternalMapperTable> outputTables = data.getOutputTables();
	for(ExternalMapperTable outputTable : outputTables){
		String outputTableName = outputTable.getName();
		List<ExternalMapperTableEntry> tableEntries = outputTable.getMetadataTableEntries();
		if (tableEntries == null || nameToOutputConnection.get(outputTable.getName()) == null) {
			continue;
		}
	
		if(isLog4jEnabled){
			if(!isVirtualOut) {

    stringBuffer.append(TEXT_17);
    stringBuffer.append(uniqueNameComponent);
    stringBuffer.append(TEXT_18);
    stringBuffer.append(outputTableName);
    stringBuffer.append(TEXT_19);
    stringBuffer.append(outputTableName);
    stringBuffer.append(TEXT_5);
    stringBuffer.append(uniqueNameComponent);
    stringBuffer.append(TEXT_20);
    
			}
		}
	}

    stringBuffer.append(TEXT_21);
    stringBuffer.append(TEXT_2);
    return stringBuffer.toString();
  }
}