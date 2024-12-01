package org.talend.designer.codegen.translators.file.output;

import org.talend.core.model.process.INode;
import org.talend.core.model.process.ElementParameterParser;
import org.talend.designer.codegen.config.CodeGeneratorArgument;
import org.talend.core.model.metadata.IMetadataTable;
import org.talend.core.model.metadata.IMetadataColumn;
import org.talend.core.model.process.IConnection;
import java.util.List;
import java.util.Map;

public class TFileOutputExcelEndJava
{
  protected static String nl;
  public static synchronized TFileOutputExcelEndJava create(String lineSeparator)
  {
    nl = lineSeparator;
    TFileOutputExcelEndJava result = new TFileOutputExcelEndJava();
    nl = null;
    return result;
  }

  public final String NL = nl == null ? (System.getProperties().getProperty("line.separator")) : nl;
  protected final String TEXT_1 = "\t\t\t\tlog.debug(\"";
  protected final String TEXT_2 = " - Retrieving records from the datasource.\");" + NL + "\t\t\t";
  protected final String TEXT_3 = NL + "\t\t\t\tlog.debug(\"";
  protected final String TEXT_4 = " - Retrieved records count: \"+ nb_line_";
  protected final String TEXT_5 = " + \" .\");" + NL + "\t\t\t";
  protected final String TEXT_6 = " - Retrieved records count: \"+ globalMap.get(\"";
  protected final String TEXT_7 = "_NB_LINE\") + \" .\");" + NL + "\t\t\t";
  protected final String TEXT_8 = " - Written records count: \" + nb_line_";
  protected final String TEXT_9 = NL + "\t\t\t\tfinal StringBuffer log4jSb_";
  protected final String TEXT_10 = " = new StringBuffer();" + NL + "\t\t\t";
  protected final String TEXT_11 = " - Retrieving the record \" + (nb_line_";
  protected final String TEXT_12 = ") + \".\");" + NL + "\t\t\t";
  protected final String TEXT_13 = " - Writing the record \" + nb_line_";
  protected final String TEXT_14 = " + \" to the file.\");" + NL + "\t\t\t";
  protected final String TEXT_15 = " - Processing the record \" + nb_line_";
  protected final String TEXT_16 = " + \".\");" + NL + "\t\t\t";
  protected final String TEXT_17 = " - Processed records count: \" + nb_line_";
  protected final String TEXT_18 = NL + "                log.error(message_";
  protected final String TEXT_19 = ");";
  protected final String TEXT_20 = NL + "                System.err.println(message_";
  protected final String TEXT_21 = NL + "\t\t\tfileOutputExcelUtil_";
  protected final String TEXT_22 = ".setColumnView_";
  protected final String TEXT_23 = "(writableSheet_";
  protected final String TEXT_24 = ",fitWidth_";
  protected final String TEXT_25 = ");" + NL + "\t";
  protected final String TEXT_26 = NL + "\t\t\t\t\t\t\tcolumnIndex_";
  protected final String TEXT_27 = " = excelDynamicUtil_";
  protected final String TEXT_28 = ".getDynamicColCount()+";
  protected final String TEXT_29 = ";" + NL + "\t\t\t\t\t\t";
  protected final String TEXT_30 = " = ";
  protected final String TEXT_31 = NL + "\t//modif start" + NL + "\t\t";
  protected final String TEXT_32 = NL + "\t\t\twritableSheet_";
  protected final String TEXT_33 = ".setColumnView(columnIndex_";
  protected final String TEXT_34 = " + ";
  protected final String TEXT_35 = ", fitWidth_";
  protected final String TEXT_36 = "[";
  protected final String TEXT_37 = "]);" + NL + "\t\t";
  protected final String TEXT_38 = NL + "\t//modif end" + NL + "\t";
  protected final String TEXT_39 = NL + "\t\t\t\t\t\t\t\t\tcolumnIndex_";
  protected final String TEXT_40 = ";" + NL + "\t\t\t\t\t\t\t\t";
  protected final String TEXT_41 = NL + "\t\twritableSheet_";
  protected final String TEXT_42 = "]);" + NL + "\t";
  protected final String TEXT_43 = NL + "\t\twriteableWorkbook_";
  protected final String TEXT_44 = ".write();" + NL + "\t\twriteableWorkbook_";
  protected final String TEXT_45 = ".close();" + NL + "\t\tif(headerIsInserted_";
  protected final String TEXT_46 = " && nb_line_";
  protected final String TEXT_47 = " > 0){" + NL + "\t\t\tnb_line_";
  protected final String TEXT_48 = " = nb_line_";
  protected final String TEXT_49 = " -1;" + NL + "\t\t}" + NL + "\t\tglobalMap.put(\"";
  protected final String TEXT_50 = "_NB_LINE\",nb_line_";
  protected final String TEXT_51 = ");" + NL + "\t\t" + NL + "\t";
  protected final String TEXT_52 = NL + "\t\tif(isFileGenerated_";
  protected final String TEXT_53 = " == 0){" + NL + "\t\t\t";
  protected final String TEXT_54 = NL + "\t\t\t\tlog.info(\"";
  protected final String TEXT_55 = " - Creating directory '\" + file_";
  protected final String TEXT_56 = ".getCanonicalPath() + \"'.\");" + NL + "\t\t\t";
  protected final String TEXT_57 = NL + "\t\t\tfile_";
  protected final String TEXT_58 = ".delete();" + NL + "\t    \t";
  protected final String TEXT_59 = " - Create directory '\"+ file_";
  protected final String TEXT_60 = ".getCanonicalPath() + \"' has succeeded.\");" + NL + "\t\t\t";
  protected final String TEXT_61 = NL + "\t\t}\t\t" + NL + "\t";
  protected final String TEXT_62 = NL + "\t\t\t\t\tfileOutputExcelUtil_";
  protected final String TEXT_63 = ".setColAutoSize_";
  protected final String TEXT_64 = "(xlsxTool_";
  protected final String TEXT_65 = NL + "\t\t\t\t\txlsxTool_";
  protected final String TEXT_66 = ".setColAutoSize(columnIndex_";
  protected final String TEXT_67 = NL + "\t" + NL + "\t";
  protected final String TEXT_68 = NL + "\t\t\t\t\tif(bufferCount_";
  protected final String TEXT_69 = "!=0){" + NL + "    \t\t\t\t\txlsxTool_";
  protected final String TEXT_70 = ".flushRowInMemory();" + NL + "    \t\t\t\t\t//flush all rocords in memory on disk." + NL + "    \t\t\t\t}" + NL + "\t";
  protected final String TEXT_71 = NL + "\t";
  protected final String TEXT_72 = NL + "\t\t\txlsxTool_";
  protected final String TEXT_73 = ".writeExcel(";
  protected final String TEXT_74 = ".writeExcel(fileName_";
  protected final String TEXT_75 = ",";
  protected final String TEXT_76 = NL + "\t\tif(headerIsInserted_";
  protected final String TEXT_77 = "\t";
  protected final String TEXT_78 = NL;

  public String generate(Object argument)
  {
    final StringBuffer stringBuffer = new StringBuffer();
    
	//this util class use by set log4j debug paramters
	class DefaultLog4jFileUtil {
	
		INode node = null;
	    String cid = null;
 		boolean isLog4jEnabled = false;
 		String label = null;
 		
 		public DefaultLog4jFileUtil(){
 		}
 		public DefaultLog4jFileUtil(INode node) {
 			this.node = node;
 			this.cid = node.getUniqueName();
 			this.label = cid;
			this.isLog4jEnabled = ("true").equals(org.talend.core.model.process.ElementParameterParser.getValue(node.getProcess(), "__LOG4J_ACTIVATE__"));
 		}
 		
 		public void setCid(String cid) {
 			this.cid = cid;
 		}
 		
		//for all tFileinput* components 
		public void startRetriveDataInfo() {
			if (isLog4jEnabled) {
			
    stringBuffer.append(TEXT_1);
    stringBuffer.append(label);
    stringBuffer.append(TEXT_2);
    
			}
		}
		
		public void retrievedDataNumberInfo() {
			if (isLog4jEnabled) {
			
    stringBuffer.append(TEXT_3);
    stringBuffer.append(label);
    stringBuffer.append(TEXT_4);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_5);
    
			}
		}
		
		public void retrievedDataNumberInfoFromGlobalMap(INode node) {
			if (isLog4jEnabled) {
			
    stringBuffer.append(TEXT_3);
    stringBuffer.append(label);
    stringBuffer.append(TEXT_6);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_7);
    
			}
		}
		
		//for all tFileinput* components 
		public void retrievedDataNumberInfo(INode node) {
			if (isLog4jEnabled) {
			
    stringBuffer.append(TEXT_3);
    stringBuffer.append(label);
    stringBuffer.append(TEXT_4);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_5);
    
			}
		}
		
		public void writeDataFinishInfo(INode node) {
			if(isLog4jEnabled){
			
    stringBuffer.append(TEXT_3);
    stringBuffer.append(label);
    stringBuffer.append(TEXT_8);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_5);
    
			}
		}
		
 		//TODO delete it and remove all log4jSb parameter from components
		public void componentStartInfo(INode node) {
			if (isLog4jEnabled) {
			
    stringBuffer.append(TEXT_9);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_10);
    
			}
		}
		
		//TODO rename or delete it
		public void debugRetriveData(INode node,boolean hasIncreased) {
			if(isLog4jEnabled){
			
    stringBuffer.append(TEXT_3);
    stringBuffer.append(label);
    stringBuffer.append(TEXT_11);
    stringBuffer.append(cid);
    stringBuffer.append(hasIncreased?"":"+1");
    stringBuffer.append(TEXT_12);
    
			}
		}
		
		//TODO rename or delete it
		public void debugRetriveData(INode node) {
			debugRetriveData(node,true);
		}
		
		//TODO rename or delete it
		public void debugWriteData(INode node) {
			if(isLog4jEnabled){
			
    stringBuffer.append(TEXT_3);
    stringBuffer.append(label);
    stringBuffer.append(TEXT_13);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_14);
    
			}
		}
		
		public void logCurrentRowNumberInfo() {
			if(isLog4jEnabled){
			
    stringBuffer.append(TEXT_3);
    stringBuffer.append(label);
    stringBuffer.append(TEXT_15);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_16);
    
			}
		}
		
		public void logDataCountInfo() {
			if(isLog4jEnabled){
			
    stringBuffer.append(TEXT_3);
    stringBuffer.append(label);
    stringBuffer.append(TEXT_17);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_5);
    
			}
		}

        public void logErrorMessage() {
            if(isLog4jEnabled){
            
    stringBuffer.append(TEXT_18);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_19);
    
            } else {
            
    stringBuffer.append(TEXT_20);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_19);
    
            }
        }
	}
	
	final DefaultLog4jFileUtil log4jFileUtil = new DefaultLog4jFileUtil((INode)(((org.talend.designer.codegen.config.CodeGeneratorArgument)argument).getArgument()));
	
    
	CodeGeneratorArgument codeGenArgument = (CodeGeneratorArgument) argument;
	INode node = (INode)codeGenArgument.getArgument();
	String cid = node.getUniqueName();
	boolean version07 = ("true").equals(ElementParameterParser.getValue(node,"__VERSION_2007__"));

	boolean useStream = ("true").equals(ElementParameterParser.getValue(node,"__USESTREAM__"));
	String outStream = ElementParameterParser.getValue(node,"__STREAMNAME__");
	boolean createDir = ("true").equals(ElementParameterParser.getValue(node,"__CREATE__"));	
	boolean isDeleteEmptyFile = ("true").equals(ElementParameterParser.getValue(node, "__DELETE_EMPTYFILE__"));	
	boolean isAppend = ("true").equals(ElementParameterParser.getValue(node,"__APPEND_FILE__"));
	boolean isIncludeHeader = ("true").equals(ElementParameterParser.getValue(node, "__INCLUDEHEADER__"));
	
	String allColumnAutoSize = ElementParameterParser.getValue(node, "__IS_ALL_AUTO_SZIE__");
	boolean flushOnRow=("true").equals(ElementParameterParser.getValue(node, "__FLUSHONROW__" ));
	boolean isAppendFile = ("true").equals(ElementParameterParser.getValue(node, "__APPEND_FILE__" ));
	//modif start
	boolean firstCellYAbsolute = ("true").equals(ElementParameterParser.getValue(node, "__FIRST_CELL_Y_ABSOLUTE__"));
	String firstCellXStr = ElementParameterParser.getValue(node, "__FIRST_CELL_X__");
	String firstCellYStr = ElementParameterParser.getValue(node, "__FIRST_CELL_Y__");
	//modif end
	
	boolean isAllColumnAutoSize = (allColumnAutoSize!=null&&!("").equals(allColumnAutoSize))?("true").equals(allColumnAutoSize):false;
	List<Map<String, String>> autoSizeList = (List<Map<String,String>>)ElementParameterParser.getObjectValue(node, "__AUTO_SZIE_SETTING__");
	
	int schemaOptNum=100;
    String schemaOptNumStr=ElementParameterParser.getValue(node, "__SCHEMA_OPT_NUM__");
    if(schemaOptNumStr!=null && !"".equals(schemaOptNumStr) && !"\"\"".equals(schemaOptNumStr)){
    	schemaOptNum  = Integer.parseInt(schemaOptNumStr);
    }
	
	List< ? extends IConnection> conns = node.getIncomingConnections();
	if((conns == null) || (conns.size() < 1) || (conns.get(0) == null)) {
		return "";
	}
	
	boolean isLog4jEnabled = ("true").equals(ElementParameterParser.getValue(node.getProcess(), "__LOG4J_ACTIVATE__"));
	int dynamic_index = 1;
	boolean hasDynamic = false;
	if(!version07){//version judgement
		List<IMetadataTable> metadatas = node.getMetadataList();
		if ((metadatas!=null)&&(metadatas.size()>0)) {
	    	IMetadataTable metadata = metadatas.get(0);
	        if (metadata!=null) {
	        	List<IMetadataColumn> columns = metadata.getListColumns();
				for(int i=0; columns!=null && i< columns.size(); i++) {
					IMetadataColumn column = columns.get(i);
			        if(column.getTalendType().equals("id_Dynamic")){
			            dynamic_index = i+1;
			            hasDynamic = true;
			            break;
			        }
				}
	        	int sizeColumns = columns.size();
	        	if(isAllColumnAutoSize){
	        		for(int i=0;i<columns.size();i++){
	        			IMetadataColumn column = columns.get(i);
                		if(column.getTalendType().equals("id_Dynamic")){
							continue;
						}
	        			if(sizeColumns > schemaOptNum) {
	        				if(i%schemaOptNum==0){
	
    stringBuffer.append(TEXT_21);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_22);
    stringBuffer.append(i/schemaOptNum);
    stringBuffer.append(TEXT_23);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_24);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_25);
    
	        				}
	        				continue;
	        			}
						if(hasDynamic && i+1>dynamic_index){
						
    stringBuffer.append(TEXT_26);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_27);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_28);
    stringBuffer.append(i-1);
    stringBuffer.append(TEXT_29);
    
						}else{
						
    stringBuffer.append(TEXT_26);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_30);
    stringBuffer.append(i);
    stringBuffer.append(TEXT_29);
    
						}
	
    stringBuffer.append(TEXT_31);
    if(firstCellYAbsolute){
    stringBuffer.append(TEXT_32);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_33);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_34);
    stringBuffer.append(firstCellXStr);
    stringBuffer.append(TEXT_35);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_36);
    stringBuffer.append(i);
    stringBuffer.append(TEXT_37);
    }else{
    stringBuffer.append(TEXT_32);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_33);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_35);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_36);
    stringBuffer.append(i);
    stringBuffer.append(TEXT_37);
    }
    stringBuffer.append(TEXT_38);
    
	    			}
	    		}else{
	    			if(autoSizeList.size() == columns.size()){
	                	for(int i=0;i<columns.size();i++){
	                		IMetadataColumn column = columns.get(i);
	                		if(column.getTalendType().equals("id_Dynamic")){
								continue;
							}
	        				if(sizeColumns > schemaOptNum) {
	        					if(i%schemaOptNum==0){
	        						boolean emptyMethod = true;
	        						for(int j=0;(j<schemaOptNum) && (i+j<sizeColumns);j++) {
                						Map<String,String> tmp= autoSizeList.get(i+j);
                						if(("true").equals(tmp.get("IS_AUTO_SIZE")) && (!columns.get(i+j).getTalendType().equals("id_Dynamic"))){
                							emptyMethod = false;
                							break;
                						}
									}
									
									if(!emptyMethod) {
	
    stringBuffer.append(TEXT_21);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_22);
    stringBuffer.append(i/schemaOptNum);
    stringBuffer.append(TEXT_23);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_24);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_25);
    
									}
	        					}
	        					continue;
	        				}
	                		Map<String,String> tmp= autoSizeList.get(i);
	                		if(("true").equals(tmp.get("IS_AUTO_SIZE"))){ 
								if(hasDynamic && i+1>dynamic_index){
								
    stringBuffer.append(TEXT_39);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_27);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_28);
    stringBuffer.append(i-1);
    stringBuffer.append(TEXT_40);
    
								}else{
								
    stringBuffer.append(TEXT_39);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_30);
    stringBuffer.append(i);
    stringBuffer.append(TEXT_40);
    
								}
	
    stringBuffer.append(TEXT_41);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_33);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_35);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_36);
    stringBuffer.append(i);
    stringBuffer.append(TEXT_42);
    
	                		}
	                	}
	                }
	    		}
	    	}
	    }
	
    stringBuffer.append(TEXT_43);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_44);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_45);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_46);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_47);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_48);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_49);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_50);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_51);
    if(!useStream && isDeleteEmptyFile){
	
    stringBuffer.append(TEXT_52);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_46);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_53);
    if(isLog4jEnabled){
    stringBuffer.append(TEXT_54);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_55);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_56);
    }
    stringBuffer.append(TEXT_57);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_58);
    if(isLog4jEnabled){
    stringBuffer.append(TEXT_54);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_59);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_60);
    }
    stringBuffer.append(TEXT_61);
    }
		log4jFileUtil.writeDataFinishInfo(node);
	}else{//version judgement /***excel 2007 xlsx*****/
		List<IMetadataTable> metadatas = node.getMetadataList();
		if ((metadatas!=null)&&(metadatas.size()>0)) {
	    	IMetadataTable metadata = metadatas.get(0);
	        if (metadata!=null) {
	        	List<IMetadataColumn> columns = metadata.getListColumns();
	        	for(int i=0; columns!=null && i< columns.size(); i++) {
					IMetadataColumn column = columns.get(i);
			        if(column.getTalendType().equals("id_Dynamic")){
			            dynamic_index = i+1;
			            hasDynamic = true;
			            break;
			        }
				}
	        	int sizeColumns = columns.size();
	        	if(isAllColumnAutoSize){
	        		for(int i=0;i<columns.size();i++){
	        			IMetadataColumn column = columns.get(i);
                		if(column.getTalendType().equals("id_Dynamic")){
							continue;
						}
	        			if(sizeColumns > schemaOptNum) {
	        				if(i%schemaOptNum==0){
	
    stringBuffer.append(TEXT_62);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_63);
    stringBuffer.append(i/schemaOptNum);
    stringBuffer.append(TEXT_64);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_25);
    
	        				}
	        				continue;
	        			}
						if(hasDynamic && i+1>dynamic_index){
						
    stringBuffer.append(TEXT_26);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_27);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_28);
    stringBuffer.append(i-1);
    stringBuffer.append(TEXT_29);
    
						}else{
						
    stringBuffer.append(TEXT_26);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_30);
    stringBuffer.append(i);
    stringBuffer.append(TEXT_29);
    
						}
	
    stringBuffer.append(TEXT_65);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_66);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_25);
    
	    			}
	    		}else{
	    			if(autoSizeList.size() == columns.size()){
	                	for(int i=0;i<columns.size();i++){
	                		IMetadataColumn column = columns.get(i);
	                		if(column.getTalendType().equals("id_Dynamic")){
								continue;
							}
	                		if(sizeColumns > schemaOptNum) {
	        					if(i%schemaOptNum==0){
	        						boolean emptyMethod = true;
	        						for(int j=0;(j<schemaOptNum) && (i+j<sizeColumns);j++) {
                						Map<String,String> tmp= autoSizeList.get(i+j);
                						if(("true").equals(tmp.get("IS_AUTO_SIZE")) && (!columns.get(i+j).getTalendType().equals("id_Dynamic"))){
                							emptyMethod = false;
                							break;
                						}
									}
									
									if(!emptyMethod) {
	
    stringBuffer.append(TEXT_62);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_63);
    stringBuffer.append(i/schemaOptNum);
    stringBuffer.append(TEXT_64);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_25);
    
									}
	        					}
	        					continue;
	        				}
	                		Map<String,String> tmp= autoSizeList.get(i);
	                		if(("true").equals(tmp.get("IS_AUTO_SIZE"))){ 
								if(hasDynamic && i+1>dynamic_index){
								
    stringBuffer.append(TEXT_39);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_27);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_28);
    stringBuffer.append(i-1);
    stringBuffer.append(TEXT_40);
    
								}else{
								
    stringBuffer.append(TEXT_39);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_30);
    stringBuffer.append(i);
    stringBuffer.append(TEXT_40);
    
								}
	
    stringBuffer.append(TEXT_65);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_66);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_25);
    
	                		}
	                	}
	                }
	    		}
	    	}
	    }
	
    stringBuffer.append(TEXT_67);
    
				if(flushOnRow && (useStream || !isAppendFile)){
	
    stringBuffer.append(TEXT_68);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_69);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_70);
    
				}
	
    stringBuffer.append(TEXT_71);
    
		if(useStream){
	
    stringBuffer.append(TEXT_72);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_73);
    stringBuffer.append(outStream);
    stringBuffer.append(TEXT_25);
    
		}else{	
	
    stringBuffer.append(TEXT_72);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_74);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_75);
    stringBuffer.append(createDir);
    stringBuffer.append(TEXT_25);
    
		}
	
    stringBuffer.append(TEXT_76);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_46);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_47);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_48);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_49);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_50);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_51);
    if(!useStream && isDeleteEmptyFile){
	
    stringBuffer.append(TEXT_52);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_46);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_53);
    if(isLog4jEnabled){
    stringBuffer.append(TEXT_54);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_55);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_56);
    }
    stringBuffer.append(TEXT_57);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_58);
    if(isLog4jEnabled){
    stringBuffer.append(TEXT_54);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_59);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_60);
    }
    stringBuffer.append(TEXT_61);
    }
log4jFileUtil.writeDataFinishInfo(node);
	}
	
    stringBuffer.append(TEXT_77);
    stringBuffer.append(TEXT_78);
    return stringBuffer.toString();
  }
}
