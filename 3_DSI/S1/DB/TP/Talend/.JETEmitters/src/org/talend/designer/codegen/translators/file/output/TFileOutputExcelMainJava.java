package org.talend.designer.codegen.translators.file.output;

import org.talend.core.model.process.INode;
import org.talend.core.model.metadata.IMetadataTable;
import org.talend.core.model.metadata.IMetadataColumn;
import org.talend.core.model.process.IConnection;
import org.talend.core.model.process.IConnectionCategory;
import org.talend.designer.codegen.config.CodeGeneratorArgument;
import org.talend.core.model.metadata.types.JavaTypesManager;
import org.talend.core.model.metadata.types.JavaType;
import org.talend.core.model.process.ElementParameterParser;
import org.talend.core.model.utils.NodeUtil;
import java.util.List;
import java.util.Map;
import java.util.HashMap;

public class TFileOutputExcelMainJava
{
  protected static String nl;
  public static synchronized TFileOutputExcelMainJava create(String lineSeparator)
  {
    nl = lineSeparator;
    TFileOutputExcelMainJava result = new TFileOutputExcelMainJava();
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
  protected final String TEXT_21 = NL + "    \t\t\t\tint inserted_";
  protected final String TEXT_22 = " = excelDynamicUtil_";
  protected final String TEXT_23 = ".writeHeaderToExcelFile(writableSheet_";
  protected final String TEXT_24 = ",";
  protected final String TEXT_25 = "," + NL + "\t\t\t\t\t\t";
  protected final String TEXT_26 = "startRowNum_";
  protected final String TEXT_27 = "+nb_line_";
  protected final String TEXT_28 = "nb_line_";
  protected final String TEXT_29 = ",fitWidth_";
  protected final String TEXT_30 = ");" + NL + "\t\t\t\t\t\t" + NL + "\t\t\t\t\theaderIsInserted_";
  protected final String TEXT_31 = " |= inserted_";
  protected final String TEXT_32 = "==1;" + NL + "\t\t\t\t\t\t" + NL + "\t\t\t\t\tnb_line_";
  protected final String TEXT_33 = " += inserted_";
  protected final String TEXT_34 = ";" + NL + "    \t\t\t";
  protected final String TEXT_35 = NL + "\t\t\t\tfileOutputExcelUtil_";
  protected final String TEXT_36 = ".putValue_";
  protected final String TEXT_37 = "(";
  protected final String TEXT_38 = ",writableSheet_";
  protected final String TEXT_39 = "," + NL + "\t\t\t\t\tstartRowNum_";
  protected final String TEXT_40 = ",nb_line_";
  protected final String TEXT_41 = "," + NL + "\t\t\t\t\t";
  protected final String TEXT_42 = "format_";
  protected final String TEXT_43 = "null";
  protected final String TEXT_44 = NL + "\t\t\t\t";
  protected final String TEXT_45 = "\t\t\t\t";
  protected final String TEXT_46 = "   \t\t\t\t" + NL + "\t    \t\t\t\tif(";
  protected final String TEXT_47 = ".";
  protected final String TEXT_48 = " != null) {" + NL + "    \t\t\t\t";
  protected final String TEXT_49 = NL + "\t\t\t\t\t" + NL + "//modif start" + NL + "\t\t\t\t\t";
  protected final String TEXT_50 = NL + "\t\t\t\t\t\tcolumnIndex_";
  protected final String TEXT_51 = ".getDynamicColCount()+";
  protected final String TEXT_52 = ";" + NL + "\t\t\t\t\t";
  protected final String TEXT_53 = " = ";
  protected final String TEXT_54 = NL + NL + "\t\t\t\t\t";
  protected final String TEXT_55 = NL + "\t\t\t\t\t\t";
  protected final String TEXT_56 = NL + "\t\t\t\t\t\t\tjxl.write.WritableCell existingCell_";
  protected final String TEXT_57 = "_";
  protected final String TEXT_58 = " = writableSheet_";
  protected final String TEXT_59 = ".getWritableCell(columnIndex_";
  protected final String TEXT_60 = " + ";
  protected final String TEXT_61 = ", startRowNum_";
  protected final String TEXT_62 = " + nb_line_";
  protected final String TEXT_63 = ") ;" + NL + "\t\t\t\t\t\t";
  protected final String TEXT_64 = NL + "\t\t\t\t\t\tjxl.write.WritableCell cell_";
  protected final String TEXT_65 = " = new jxl.write.";
  protected final String TEXT_66 = "(columnIndex_";
  protected final String TEXT_67 = " ," + NL + "\t\t\t\t\t";
  protected final String TEXT_68 = "," + NL + "\t\t\t\t\t";
  protected final String TEXT_69 = NL + "//modif end";
  protected final String TEXT_70 = NL + "\t\t\t\t\t\t\t\t";
  protected final String TEXT_71 = ", cell_format_";
  protected final String TEXT_72 = NL + "\t\t\t\t\t\t\tString.valueOf(";
  protected final String TEXT_73 = ")";
  protected final String TEXT_74 = "\t\t\t\t\t" + NL + "\t\t\t\t\t\t\t\t";
  protected final String TEXT_75 = ".toString()";
  protected final String TEXT_76 = "\t\t\t\t\t" + NL + "\t\t\t\t\t\t\t\tjava.nio.charset.Charset.defaultCharset().decode(java.nio.ByteBuffer.wrap(";
  protected final String TEXT_77 = ")).toString()";
  protected final String TEXT_78 = NL + "\t\t\t\t\t\t\t";
  protected final String TEXT_79 = NL + "\t\t\t\t\t\t\tFormatterUtils.format_Number(String.valueOf(";
  protected final String TEXT_80 = "), ";
  protected final String TEXT_81 = ", ";
  protected final String TEXT_82 = ")\t\t\t\t" + NL + "\t\t\t\t\t\t\t";
  protected final String TEXT_83 = "\t\t" + NL + "\t\t\t\t\t\t\t(";
  protected final String TEXT_84 = ").doubleValue()";
  protected final String TEXT_85 = NL + "\t\t\t\t\t\t,format_";
  protected final String TEXT_86 = NL + "\t\t\t\t\t\t\t);" + NL + "//modif start\t\t\t\t\t" + NL + "\t\t\t\t\t\t\t//If we keep the cell format from the existing cell in sheet" + NL + "\t\t\t\t\t\t\t" + NL + "\t\t\t\t\t\t\t";
  protected final String TEXT_87 = NL + "\t\t\t\t\t\t\t\tif(existingCell_";
  protected final String TEXT_88 = ".getCellFormat()!=null)" + NL + "\t\t\t\t\t\t\t\t\tcell_";
  protected final String TEXT_89 = ".setCellFormat( existingCell_";
  protected final String TEXT_90 = ".getCellFormat());" + NL + "\t\t\t\t\t\t\t";
  protected final String TEXT_91 = NL + "//modif ends\t\t\t\t\t\t\t" + NL + "\t\t\t\t\t\t\twritableSheet_";
  protected final String TEXT_92 = ".addCell(cell_";
  protected final String TEXT_93 = NL + "\t\t\t\t\t\t\tint currentWith_";
  protected final String TEXT_94 = " = String.valueOf(((jxl.write.Number)cell_";
  protected final String TEXT_95 = ").getValue()).trim().length();" + NL + "\t\t\t\t\t\t\tcurrentWith_";
  protected final String TEXT_96 = "=currentWith_";
  protected final String TEXT_97 = ">10?10:currentWith_";
  protected final String TEXT_98 = ";";
  protected final String TEXT_99 = " = cell_";
  protected final String TEXT_100 = ".getContents().trim().length();";
  protected final String TEXT_101 = NL + "\t\t\t\t\t\t\tfitWidth_";
  protected final String TEXT_102 = "[";
  protected final String TEXT_103 = "]=fitWidth_";
  protected final String TEXT_104 = "]>currentWith_";
  protected final String TEXT_105 = "?fitWidth_";
  protected final String TEXT_106 = "]:currentWith_";
  protected final String TEXT_107 = "+2;";
  protected final String TEXT_108 = NL + "\t\t\t\t\t\t\tcurrentWith_";
  protected final String TEXT_109 = "=";
  protected final String TEXT_110 = ";" + NL + "\t\t\t\t\t\t\tfitWidth_";
  protected final String TEXT_111 = NL + "\t\t\t\t\t\texcelDynamicUtil_";
  protected final String TEXT_112 = ".writeValuesToExcelFile(";
  protected final String TEXT_113 = ", writableSheet_";
  protected final String TEXT_114 = ",columnIndex_";
  protected final String TEXT_115 = "+";
  protected final String TEXT_116 = ",startRowNum_";
  protected final String TEXT_117 = ");" + NL + "\t\t\t\t\t\t";
  protected final String TEXT_118 = NL + "\t\t\t\t\t\t\texcelDynamicUtil_";
  protected final String TEXT_119 = ".autoDynamicColumnSize(writableSheet_";
  protected final String TEXT_120 = NL + "\t    \t\t\t\t} " + NL + "\t\t\t\t\t";
  protected final String TEXT_121 = NL + "    \t\t\tnb_line_";
  protected final String TEXT_122 = "++;" + NL + "\t\t\t\t";
  protected final String TEXT_123 = ".writeHeaderToExcelFile(";
  protected final String TEXT_124 = ", xlsxTool_";
  protected final String TEXT_125 = ", nb_line_";
  protected final String TEXT_126 = ");" + NL + "    \t\t\t\t" + NL + "    \t\t\t\theaderIsInserted_";
  protected final String TEXT_127 = "==1;" + NL + "    \t\t\t\t" + NL + "    \t\t\t\tnb_line_";
  protected final String TEXT_128 = NL + "\t\t\t\txlsxTool_";
  protected final String TEXT_129 = ".addRow();";
  protected final String TEXT_130 = NL + "   \t\t\t\tfileOutputExcelUtil_";
  protected final String TEXT_131 = ",xlsxTool_";
  protected final String TEXT_132 = "\t\t\t\t\t";
  protected final String TEXT_133 = NL + "\t\t\t\t\t\t\txlsxTool_";
  protected final String TEXT_134 = ".addCellValue(";
  protected final String TEXT_135 = "\t\t\t\t\t" + NL + "\t\t\t\t\t\t\txlsxTool_";
  protected final String TEXT_136 = ".addCellValue(java.nio.charset.Charset.defaultCharset().decode(java.nio.ByteBuffer.wrap(";
  protected final String TEXT_137 = ")).toString());";
  protected final String TEXT_138 = ".addCellValue(FormatterUtils.format_Number(String.valueOf(";
  protected final String TEXT_139 = "));\t\t\t\t" + NL + "\t\t\t\t\t\t\t";
  protected final String TEXT_140 = "));" + NL + "\t\t\t\t\t\t\t";
  protected final String TEXT_141 = "\t\t" + NL + "\t\t\t\t\t\t\txlsxTool_";
  protected final String TEXT_142 = ".addCellValue((";
  protected final String TEXT_143 = ").doubleValue());";
  protected final String TEXT_144 = ".addCellValue(Double.parseDouble(String.valueOf(";
  protected final String TEXT_145 = ")));";
  protected final String TEXT_146 = ".addCellValue(String.valueOf(";
  protected final String TEXT_147 = "));";
  protected final String TEXT_148 = ".autoDynamicColumnSize(xlsxTool_";
  protected final String TEXT_149 = NL + "\t    \t\t\t\t} else {" + NL + "\t    \t\t\t\t\txlsxTool_";
  protected final String TEXT_150 = ".addCellNullValue();" + NL + "\t    \t\t\t\t}" + NL + "\t\t\t\t\t";
  protected final String TEXT_151 = NL + "\t\t\t\t\tbufferCount_";
  protected final String TEXT_152 = "++;" + NL + "\t\t\t\t\tif(bufferCount_";
  protected final String TEXT_153 = " >= flushRowNum_";
  protected final String TEXT_154 = "){" + NL + "    \t\t\t\t\txlsxTool_";
  protected final String TEXT_155 = ".flushRowInMemory();" + NL + "    \t\t\t\t\tbufferCount_";
  protected final String TEXT_156 = "=0;" + NL + "    \t\t\t\t}";

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
String advancedSeparatorStr = ElementParameterParser.getValue(node, "__ADVANCED_SEPARATOR__");
boolean advancedSeparator = (advancedSeparatorStr!=null&&!("").equals(advancedSeparatorStr))?("true").equals(advancedSeparatorStr):false;
String thousandsSeparator = ElementParameterParser.getValueWithJavaType(node, "__THOUSANDS_SEPARATOR__", JavaTypesManager.CHARACTER);
String decimalSeparator = ElementParameterParser.getValueWithJavaType(node, "__DECIMAL_SEPARATOR__", JavaTypesManager.CHARACTER); 
String font = ElementParameterParser.getValue(node, "__FONT__"); 
boolean isIncludeHeader = ("true").equals(ElementParameterParser.getValue(node, "__INCLUDEHEADER__"));
//modif start
boolean firstCellYAbsolute = ("true").equals(ElementParameterParser.getValue(node, "__FIRST_CELL_Y_ABSOLUTE__"));
String firstCellXStr = ElementParameterParser.getValue(node, "__FIRST_CELL_X__");
String firstCellYStr = ElementParameterParser.getValue(node, "__FIRST_CELL_Y__");
//modif end
boolean keepCellFormating =  ElementParameterParser.getValue(node, "__KEEP_CELL_FORMATING__").equals("true");
boolean flushOnRow=("true").equals(ElementParameterParser.getValue(node, "__FLUSHONROW__" ));
boolean useStream = ("true").equals(ElementParameterParser.getValue(node,"__USESTREAM__"));
boolean isAppendFile = ("true").equals(ElementParameterParser.getValue(node, "__APPEND_FILE__" ));

int schemaOptNum=100;
String schemaOptNumStr=ElementParameterParser.getValue(node, "__SCHEMA_OPT_NUM__");
if(schemaOptNumStr!=null && !"".equals(schemaOptNumStr) && !"\"\"".equals(schemaOptNumStr)){
	schemaOptNum  = Integer.parseInt(schemaOptNumStr);
}

boolean isAllColumnAutoSize = ("true").equals(ElementParameterParser.getValue(node, "__IS_ALL_AUTO_SZIE__" ));
List<Map<String, String>> autoSizeList = (List<Map<String,String>>)ElementParameterParser.getObjectValue(node, "__AUTO_SZIE_SETTING__");
Map<String,String> autColSizeMaping=new HashMap<String,String>();

List<IMetadataTable> metadatas = node.getMetadataList();
if ((metadatas!=null)&&(metadatas.size()>0)) {
    IMetadataTable metadata = metadatas.get(0);
    if (metadata!=null) {
		List<IMetadataColumn> columns = metadata.getListColumns();
		boolean isLog4jEnabled = ("true").equals(ElementParameterParser.getValue(node.getProcess(), "__LOG4J_ACTIVATE__"));
		
		boolean hasDynamic = false;
		int dynamic_index = 0;
		String datePattern = "\"dd-MM-yyyy\"";
		for(int i=0; columns!=null && i< columns.size(); i++) {
			IMetadataColumn column = columns.get(i);
	        if(!hasDynamic && column.getTalendType().equals("id_Dynamic")){
	            dynamic_index = i+1;
	            hasDynamic = true;
	            datePattern= column.getPattern();
	        }
	        if(isAllColumnAutoSize){
	        	autColSizeMaping.put(column.getLabel(),"true");
	        }else{
	        	autColSizeMaping.put(column.getLabel(),autoSizeList.get(i).get("IS_AUTO_SIZE"));
	        	
	        }
		}
		if(!version07){//version judgement
    	
    	List< ? extends IConnection> conns = node.getIncomingConnections();
    	for (IConnection conn : conns) {
    		if (conn.getLineStyle().hasConnectionCategory(IConnectionCategory.DATA)) {
    			if(hasDynamic && isIncludeHeader){
    			
    stringBuffer.append(TEXT_21);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_22);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_23);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_24);
    stringBuffer.append(firstCellYAbsolute?firstCellXStr:"0");
    stringBuffer.append(TEXT_25);
    if(firstCellYAbsolute){
    stringBuffer.append(TEXT_26);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_27);
    stringBuffer.append(cid);
    }else{
    stringBuffer.append(TEXT_28);
    stringBuffer.append(cid);
    }
    stringBuffer.append(TEXT_24);
    stringBuffer.append(conn.getName());
    stringBuffer.append(TEXT_29);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_30);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_31);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_32);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_33);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_34);
    
    			}
    			int sizeColumns = columns.size();
    			for (int i = 0; i < sizeColumns; i++) {
    				IMetadataColumn column = columns.get(i);
    				if(sizeColumns > schemaOptNum) {
    					if(i%schemaOptNum==0){

    stringBuffer.append(TEXT_35);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_36);
    stringBuffer.append(i/schemaOptNum);
    stringBuffer.append(TEXT_37);
    stringBuffer.append(conn.getName() );
    stringBuffer.append(TEXT_38);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_39);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_40);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_41);
    if (font !=null && font.length()!=0) {
    stringBuffer.append(TEXT_42);
    stringBuffer.append(cid );
    } else {
    stringBuffer.append(TEXT_43);
    }
    stringBuffer.append(TEXT_29);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_19);
    
    					}
    					continue;
    				}

    stringBuffer.append(TEXT_44);
    stringBuffer.append(TEXT_45);
    
					JavaType javaType = JavaTypesManager.getJavaTypeFromId(column.getTalendType());
					boolean isPrimitive = JavaTypesManager.isJavaPrimitiveType( javaType, column.isNullable());
					if(!isPrimitive) {
    				
    stringBuffer.append(TEXT_46);
    stringBuffer.append(conn.getName() );
    stringBuffer.append(TEXT_47);
    stringBuffer.append(column.getLabel() );
    stringBuffer.append(TEXT_48);
    
    				} 
    				
    stringBuffer.append(TEXT_49);
    
					//Detect the format required for the cell
					String jxlWriteType;
    				int staticWidth = 0;
    				boolean isNumber = false;
					if(javaType == JavaTypesManager.BOOLEAN){
						staticWidth=5;
						jxlWriteType="Boolean";
					}else if(javaType == JavaTypesManager.DATE){
						jxlWriteType="DateTime";
				    }else if(javaType == JavaTypesManager.STRING||
				    		 javaType == JavaTypesManager.CHARACTER||
				    		 javaType == JavaTypesManager.BYTE_ARRAY||
				    		 javaType == JavaTypesManager.LIST||
				    		 javaType == JavaTypesManager.OBJECT||
				    		 column.getTalendType().equals("id_Dynamic")||
				    		 (advancedSeparator && JavaTypesManager.isNumberType(javaType, column.isNullable()))
				    		 ){
				    	jxlWriteType="Label";
					}else{
						isNumber=true;
						jxlWriteType="Number";
					};
					if(hasDynamic && i+1>dynamic_index){
					
    stringBuffer.append(TEXT_50);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_22);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_51);
    stringBuffer.append(i-1);
    stringBuffer.append(TEXT_52);
    
					}else{
					
    stringBuffer.append(TEXT_50);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_53);
    stringBuffer.append(i);
    stringBuffer.append(TEXT_52);
    
					}
					if(!column.getTalendType().equals("id_Dynamic")){
   				
    stringBuffer.append(TEXT_54);
    if(firstCellYAbsolute){
    stringBuffer.append(TEXT_55);
    if(keepCellFormating){
    stringBuffer.append(TEXT_56);
    stringBuffer.append(i);
    stringBuffer.append(TEXT_57);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_58);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_59);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_60);
    stringBuffer.append(firstCellXStr);
    stringBuffer.append(TEXT_61);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_62);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_63);
    }
    stringBuffer.append(TEXT_64);
    stringBuffer.append(i);
    stringBuffer.append(TEXT_57);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_65);
    stringBuffer.append(jxlWriteType);
    stringBuffer.append(TEXT_66);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_60);
    stringBuffer.append(firstCellXStr);
    stringBuffer.append(TEXT_61);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_62);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_67);
    }else{
    stringBuffer.append(TEXT_64);
    stringBuffer.append(i);
    stringBuffer.append(TEXT_57);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_65);
    stringBuffer.append(jxlWriteType);
    stringBuffer.append(TEXT_66);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_61);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_62);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_68);
    }
    stringBuffer.append(TEXT_69);
    
    				String pattern = column.getPattern() == null || column.getPattern().trim().length() == 0 ? null : column.getPattern();
    				if (javaType == JavaTypesManager.DATE && pattern != null && pattern.trim().length() != 0) {
						staticWidth = pattern.trim().length();

    stringBuffer.append(TEXT_70);
    stringBuffer.append(conn.getName() );
    stringBuffer.append(TEXT_47);
    stringBuffer.append(column.getLabel() );
    stringBuffer.append(TEXT_71);
    stringBuffer.append(column.getLabel() );
    stringBuffer.append(TEXT_57);
    stringBuffer.append( cid);
    
					} else {
						if(javaType == JavaTypesManager.CHARACTER) {

    stringBuffer.append(TEXT_72);
    stringBuffer.append(conn.getName() );
    stringBuffer.append(TEXT_47);
    stringBuffer.append(column.getLabel() );
    stringBuffer.append(TEXT_73);
    
						} else if(javaType == JavaTypesManager.OBJECT || javaType == JavaTypesManager.LIST){

    stringBuffer.append(TEXT_74);
    stringBuffer.append(conn.getName() );
    stringBuffer.append(TEXT_47);
    stringBuffer.append(column.getLabel() );
    stringBuffer.append(TEXT_75);
    
						} else if(javaType == JavaTypesManager.BYTE_ARRAY){

    stringBuffer.append(TEXT_76);
    stringBuffer.append(conn.getName() );
    stringBuffer.append(TEXT_47);
    stringBuffer.append(column.getLabel() );
    stringBuffer.append(TEXT_77);
    
						} else if(advancedSeparator && JavaTypesManager.isNumberType(javaType, column.isNullable())) { 

    stringBuffer.append(TEXT_78);
     if(javaType == JavaTypesManager.BIGDECIMAL) {
    stringBuffer.append(TEXT_79);
    stringBuffer.append(column.getPrecision() == null? conn.getName() + "." + column.getLabel() : conn.getName() + "." + column.getLabel() + ".setScale(" + column.getPrecision() + ", java.math.RoundingMode.HALF_UP)" );
    stringBuffer.append(TEXT_80);
    stringBuffer.append( thousandsSeparator );
    stringBuffer.append(TEXT_81);
    stringBuffer.append( decimalSeparator );
    stringBuffer.append(TEXT_82);
     } else { 
    stringBuffer.append(TEXT_79);
    stringBuffer.append(conn.getName() );
    stringBuffer.append(TEXT_47);
    stringBuffer.append(column.getLabel() );
    stringBuffer.append(TEXT_80);
    stringBuffer.append( thousandsSeparator );
    stringBuffer.append(TEXT_81);
    stringBuffer.append( decimalSeparator );
    stringBuffer.append(TEXT_82);
     } 
    
						} else if (javaType == JavaTypesManager.BIGDECIMAL) {

    stringBuffer.append(TEXT_83);
    stringBuffer.append(column.getPrecision() == null? conn.getName() + "." + column.getLabel() : conn.getName() + "." + column.getLabel() + ".setScale(" + column.getPrecision() + ", java.math.RoundingMode.HALF_UP)" );
    stringBuffer.append(TEXT_84);
    
					}else {

    stringBuffer.append(TEXT_70);
    stringBuffer.append(conn.getName() );
    stringBuffer.append(TEXT_47);
    stringBuffer.append(column.getLabel() );
    				
					}
					if(font !=null && font.length()!=0){ 

    stringBuffer.append(TEXT_85);
    stringBuffer.append(cid);
    
					}
				}

    stringBuffer.append(TEXT_86);
    if(keepCellFormating && firstCellYAbsolute){
    stringBuffer.append(TEXT_87);
    stringBuffer.append(i);
    stringBuffer.append(TEXT_57);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_88);
    stringBuffer.append(i);
    stringBuffer.append(TEXT_57);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_89);
    stringBuffer.append(i);
    stringBuffer.append(TEXT_57);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_90);
    
							}
							
    stringBuffer.append(TEXT_91);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_92);
    stringBuffer.append(i);
    stringBuffer.append(TEXT_57);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_19);
    
					if(isNumber){

    stringBuffer.append(TEXT_93);
    stringBuffer.append(i);
    stringBuffer.append(TEXT_57);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_94);
    stringBuffer.append(i);
    stringBuffer.append(TEXT_57);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_95);
    stringBuffer.append(i);
    stringBuffer.append(TEXT_57);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_96);
    stringBuffer.append(i);
    stringBuffer.append(TEXT_57);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_97);
    stringBuffer.append(i);
    stringBuffer.append(TEXT_57);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_98);
    
					}else{

    stringBuffer.append(TEXT_93);
    stringBuffer.append(i);
    stringBuffer.append(TEXT_57);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_99);
    stringBuffer.append(i);
    stringBuffer.append(TEXT_57);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_100);
    
					}
					if(staticWidth ==0){

    stringBuffer.append(TEXT_101);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_102);
    stringBuffer.append(i);
    stringBuffer.append(TEXT_103);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_102);
    stringBuffer.append(i);
    stringBuffer.append(TEXT_104);
    stringBuffer.append(i);
    stringBuffer.append(TEXT_57);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_105);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_102);
    stringBuffer.append(i);
    stringBuffer.append(TEXT_106);
    stringBuffer.append(i);
    stringBuffer.append(TEXT_57);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_107);
    
					}else{

    stringBuffer.append(TEXT_108);
    stringBuffer.append(i);
    stringBuffer.append(TEXT_57);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_109);
    stringBuffer.append(staticWidth);
    stringBuffer.append(TEXT_110);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_102);
    stringBuffer.append(i);
    stringBuffer.append(TEXT_103);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_102);
    stringBuffer.append(i);
    stringBuffer.append(TEXT_104);
    stringBuffer.append(i);
    stringBuffer.append(TEXT_57);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_105);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_102);
    stringBuffer.append(i);
    stringBuffer.append(TEXT_106);
    stringBuffer.append(i);
    stringBuffer.append(TEXT_57);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_107);
    
					}
					}else{
					
    stringBuffer.append(TEXT_111);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_112);
    stringBuffer.append(conn.getName() );
    stringBuffer.append(TEXT_47);
    stringBuffer.append(column.getLabel() );
    stringBuffer.append(TEXT_113);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_114);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_115);
    stringBuffer.append(firstCellYAbsolute?firstCellXStr:"0");
    stringBuffer.append(TEXT_116);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_62);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_117);
    
						if("true".equalsIgnoreCase(autColSizeMaping.get(column.getLabel()))){
						
    stringBuffer.append(TEXT_118);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_119);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_114);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_115);
    stringBuffer.append(firstCellYAbsolute?firstCellXStr:"0");
    stringBuffer.append(TEXT_117);
    
						}
					}
					if(!isPrimitive) {
    				
    stringBuffer.append(TEXT_120);
    
    				} 
    			
    
				}

    stringBuffer.append(TEXT_121);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_122);
    log4jFileUtil.debugWriteData(node);
    
    		}
    	}
    	}else{ //version judgement /***excel 2007 xlsx*****/

		List< ? extends IConnection> conns = node.getIncomingConnections();
    	for (IConnection conn : conns) {
    		if (conn.getLineStyle().hasConnectionCategory(IConnectionCategory.DATA)) {
    			if(hasDynamic && isIncludeHeader){
    			
    stringBuffer.append(TEXT_21);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_22);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_123);
    stringBuffer.append(conn.getName() );
    stringBuffer.append(TEXT_124);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_125);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_126);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_31);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_127);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_33);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_34);
    
    			}
    			int sizeColumns = columns.size();

    stringBuffer.append(TEXT_128);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_129);
    
    			for (int i = 0; i < sizeColumns; i++) {
    				IMetadataColumn column = columns.get(i);
    				if(sizeColumns > schemaOptNum) {
    					if(i%schemaOptNum==0){

    stringBuffer.append(TEXT_130);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_36);
    stringBuffer.append(i/schemaOptNum);
    stringBuffer.append(TEXT_37);
    stringBuffer.append(conn.getName() );
    stringBuffer.append(TEXT_131);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_19);
    
    					}
    					continue;
	        		}

    stringBuffer.append(TEXT_44);
    stringBuffer.append(TEXT_132);
    
					JavaType javaType = JavaTypesManager.getJavaTypeFromId(column.getTalendType());
					boolean isPrimitive = JavaTypesManager.isJavaPrimitiveType( javaType, column.isNullable());
					if(!isPrimitive) {
    				
    stringBuffer.append(TEXT_46);
    stringBuffer.append(conn.getName() );
    stringBuffer.append(TEXT_47);
    stringBuffer.append(column.getLabel() );
    stringBuffer.append(TEXT_48);
    
    				} 
    				
    
					if(!column.getTalendType().equals("id_Dynamic")){
					
    				String pattern = column.getPattern() == null || column.getPattern().trim().length() == 0 ? null : column.getPattern();
    				if (javaType == JavaTypesManager.DATE && pattern != null && pattern.trim().length() != 0) {

    stringBuffer.append(TEXT_133);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_134);
    stringBuffer.append(conn.getName() );
    stringBuffer.append(TEXT_47);
    stringBuffer.append(column.getLabel() );
    stringBuffer.append(TEXT_81);
    stringBuffer.append(pattern);
    stringBuffer.append(TEXT_19);
    
					} else if(javaType == JavaTypesManager.BYTE_ARRAY){

    stringBuffer.append(TEXT_135);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_136);
    stringBuffer.append(conn.getName() );
    stringBuffer.append(TEXT_47);
    stringBuffer.append(column.getLabel() );
    stringBuffer.append(TEXT_137);
    
					} else if(advancedSeparator && JavaTypesManager.isNumberType(javaType, column.isNullable())) { 

    stringBuffer.append(TEXT_78);
     if(javaType == JavaTypesManager.BIGDECIMAL) {
    stringBuffer.append(TEXT_133);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_138);
    stringBuffer.append(column.getPrecision() == null? conn.getName() + "." + column.getLabel() : conn.getName() + "." + column.getLabel() + ".setScale(" + column.getPrecision() + ", java.math.RoundingMode.HALF_UP)" );
    stringBuffer.append(TEXT_80);
    stringBuffer.append( thousandsSeparator );
    stringBuffer.append(TEXT_81);
    stringBuffer.append( decimalSeparator );
    stringBuffer.append(TEXT_139);
     } else { 
    stringBuffer.append(TEXT_133);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_138);
    stringBuffer.append(conn.getName() );
    stringBuffer.append(TEXT_47);
    stringBuffer.append(column.getLabel() );
    stringBuffer.append(TEXT_80);
    stringBuffer.append( thousandsSeparator );
    stringBuffer.append(TEXT_81);
    stringBuffer.append( decimalSeparator );
    stringBuffer.append(TEXT_140);
     } 
    
					} else if (javaType == JavaTypesManager.BIGDECIMAL) {

    stringBuffer.append(TEXT_141);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_142);
    stringBuffer.append(column.getPrecision() == null? conn.getName() + "." + column.getLabel() : conn.getName() + "." + column.getLabel() + ".setScale(" + column.getPrecision() + ", java.math.RoundingMode.HALF_UP)" );
    stringBuffer.append(TEXT_143);
    
					}else if (javaType == JavaTypesManager.BOOLEAN){

    stringBuffer.append(TEXT_133);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_134);
    stringBuffer.append(conn.getName() );
    stringBuffer.append(TEXT_47);
    stringBuffer.append(column.getLabel());
    stringBuffer.append(TEXT_19);
    
					}else if (javaType == JavaTypesManager.DOUBLE){

    stringBuffer.append(TEXT_133);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_134);
    stringBuffer.append(conn.getName() );
    stringBuffer.append(TEXT_47);
    stringBuffer.append(column.getLabel());
    stringBuffer.append(TEXT_19);
    					}else if(JavaTypesManager.isNumberType(javaType)){

    stringBuffer.append(TEXT_133);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_144);
    stringBuffer.append(conn.getName() );
    stringBuffer.append(TEXT_47);
    stringBuffer.append(column.getLabel());
    stringBuffer.append(TEXT_145);
    
					}else{	

    stringBuffer.append(TEXT_133);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_146);
    stringBuffer.append(conn.getName() );
    stringBuffer.append(TEXT_47);
    stringBuffer.append(column.getLabel());
    stringBuffer.append(TEXT_147);
    				
					}
					}else{
					
    stringBuffer.append(TEXT_111);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_112);
    stringBuffer.append(conn.getName() );
    stringBuffer.append(TEXT_47);
    stringBuffer.append(column.getLabel() );
    stringBuffer.append(TEXT_124);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_117);
    
						if("true".equalsIgnoreCase(autColSizeMaping.get(column.getLabel()))){
						
    stringBuffer.append(TEXT_118);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_148);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_117);
    
						}
					}
					if(!isPrimitive) {
    				
    stringBuffer.append(TEXT_149);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_150);
    
    				} 
    				
    
    			}
    			
    stringBuffer.append(TEXT_121);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_122);
    log4jFileUtil.debugWriteData(node);
    
				if(flushOnRow && (useStream || !isAppendFile)){

    stringBuffer.append(TEXT_151);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_152);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_153);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_154);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_155);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_156);
    
				}
    		}
    	}

    	}
    }
}

    return stringBuffer.toString();
  }
}
