package org.talend.designer.codegen.translators.file.output;

import org.talend.core.model.process.INode;
import org.talend.core.model.metadata.IMetadataTable;
import org.talend.core.model.metadata.IMetadataColumn;
import org.talend.designer.codegen.config.CodeGeneratorArgument;
import org.talend.core.model.process.ElementParameterParser;
import java.util.List;
import java.util.Map;
import org.talend.core.model.metadata.types.JavaTypesManager;
import org.talend.core.model.metadata.types.JavaType;
import org.talend.core.model.process.IConnection;
import org.talend.core.utils.TalendQuoteUtils;

public class TFileOutputXMLMainJava
{
  protected static String nl;
  public static synchronized TFileOutputXMLMainJava create(String lineSeparator)
  {
    nl = lineSeparator;
    TFileOutputXMLMainJava result = new TFileOutputXMLMainJava();
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
  protected final String TEXT_21 = NL;
  protected final String TEXT_22 = NL + "String tempSt_";
  protected final String TEXT_23 = " = null;" + NL + "" + NL + "boolean flag_";
  protected final String TEXT_24 = " = true;" + NL + " " + NL + "groupby_new_";
  protected final String TEXT_25 = " = 0;" + NL;
  protected final String TEXT_26 = "tempSt_";
  protected final String TEXT_27 = " = \"<\"+";
  protected final String TEXT_28 = "+\" \"+";
  protected final String TEXT_29 = "+\"=\\\"\"+";
  protected final String TEXT_30 = "FormatterUtils.format_Number(String.valueOf(";
  protected final String TEXT_31 = "), ";
  protected final String TEXT_32 = ", ";
  protected final String TEXT_33 = ")";
  protected final String TEXT_34 = ".";
  protected final String TEXT_35 = "((";
  protected final String TEXT_36 = " == null)?\"\":(";
  protected final String TEXT_37 = "TalendString.replaceSpecialCharForXML(";
  protected final String TEXT_38 = "FormatterUtils.format_Date(";
  protected final String TEXT_39 = "TalendString.replaceSpecialCharForXML(java.nio.charset.Charset.defaultCharset().decode(java.nio.ByteBuffer.wrap(";
  protected final String TEXT_40 = ")).toString())";
  protected final String TEXT_41 = "TalendString.replaceSpecialCharForXML(String.valueOf(";
  protected final String TEXT_42 = "))";
  protected final String TEXT_43 = "+\"\\\">\";" + NL + "" + NL + "if(!groupby_";
  protected final String TEXT_44 = "[";
  protected final String TEXT_45 = "][0].equals(tempSt_";
  protected final String TEXT_46 = ")){" + NL + "\t" + NL + "\tif(flag_";
  protected final String TEXT_47 = "){" + NL + "\t" + NL + "\t\tgroupby_new_";
  protected final String TEXT_48 = " = ";
  protected final String TEXT_49 = ";" + NL + "" + NL + "\t\tflag_";
  protected final String TEXT_50 = " = false;" + NL + "\t\t" + NL + "\t\tfor(int i_";
  protected final String TEXT_51 = "; i_";
  protected final String TEXT_52 = " >= groupby_new_";
  protected final String TEXT_53 = " && start_";
  protected final String TEXT_54 = "--){" + NL + "" + NL + "\t\t\tout_";
  protected final String TEXT_55 = ".write(groupby_";
  protected final String TEXT_56 = "[i_";
  protected final String TEXT_57 = "][1]);" + NL + "\t" + NL + "\t\t\tout_";
  protected final String TEXT_58 = ".newLine();" + NL + "\t" + NL + "\t\t}\t" + NL + "\t}" + NL + "" + NL + "\tgroupby_";
  protected final String TEXT_59 = "][0] = tempSt_";
  protected final String TEXT_60 = ";" + NL + "\t" + NL + "\tout_";
  protected final String TEXT_61 = ".write(tempSt_";
  protected final String TEXT_62 = ");" + NL + "" + NL + "\tout_";
  protected final String TEXT_63 = ".newLine();" + NL + "\t" + NL + "\tif(!start_";
  protected final String TEXT_64 = "){" + NL + "\t\t\t" + NL + "\t\tstart_";
  protected final String TEXT_65 = " = true;" + NL + "\t\t\t" + NL + "\t}" + NL + "\t\t" + NL + "}else if(!flag_";
  protected final String TEXT_66 = "){" + NL + "\t" + NL + "\tout_";
  protected final String TEXT_67 = ");" + NL + "\t" + NL + "\tout_";
  protected final String TEXT_68 = " = true;" + NL + "\t\t\t" + NL + "\t}" + NL + "\t" + NL + "}" + NL;
  protected final String TEXT_69 = "StringBuilder tempRes_";
  protected final String TEXT_70 = " = new StringBuilder(\"<\"+";
  protected final String TEXT_71 = ");" + NL;
  protected final String TEXT_72 = "tempRes_";
  protected final String TEXT_73 = ".append(\" \"+";
  protected final String TEXT_74 = "+\"\\\"\");" + NL;
  protected final String TEXT_75 = ".append(\">\");" + NL;
  protected final String TEXT_76 = ".append(\"/>\");" + NL;
  protected final String TEXT_77 = "out_";
  protected final String TEXT_78 = ".write(tempRes_";
  protected final String TEXT_79 = ".toString());" + NL + "" + NL + "out_";
  protected final String TEXT_80 = ".newLine();" + NL;
  protected final String TEXT_81 = ".write(\"<\"+";
  protected final String TEXT_82 = "+\">\"+";
  protected final String TEXT_83 = "TalendString.checkCDATAForXML(";
  protected final String TEXT_84 = "TalendString.checkCDATAForXML(java.nio.charset.Charset.defaultCharset().decode(java.nio.ByteBuffer.wrap(";
  protected final String TEXT_85 = "TalendString.checkCDATAForXML(String.valueOf(";
  protected final String TEXT_86 = ".getDocument().getRootElement().asXML()";
  protected final String TEXT_87 = "+\"</\"+";
  protected final String TEXT_88 = "+\">\");" + NL + "" + NL + "out_";
  protected final String TEXT_89 = ".write(\"</\"+";
  protected final String TEXT_90 = NL;
  protected final String TEXT_91 = NL + "    if(nb_line_";
  protected final String TEXT_92 = "%";
  protected final String TEXT_93 = " == 0) {" + NL + "    out_";
  protected final String TEXT_94 = ".flush();" + NL + "    }";
  protected final String TEXT_95 = NL + "nb_line_";
  protected final String TEXT_96 = "++;" + NL;
  protected final String TEXT_97 = NL + "resourceMap.put(\"nb_line_";
  protected final String TEXT_98 = "\", nb_line_";
  protected final String TEXT_99 = NL + "currentRowCount_";
  protected final String TEXT_100 = "++;" + NL + "if(currentRowCount_";
  protected final String TEXT_101 = " == ";
  protected final String TEXT_102 = "){";
  protected final String TEXT_103 = NL + "out_";
  protected final String TEXT_104 = "][1]);" + NL + "out_";
  protected final String TEXT_105 = ".newLine();\t\t";
  protected final String TEXT_106 = ".write(footers_";
  protected final String TEXT_107 = "]);" + NL + "out_";
  protected final String TEXT_108 = ".newLine();";
  protected final String TEXT_109 = "\t" + NL + "\tout_";
  protected final String TEXT_110 = ".close();" + NL + "\tcurrentFileCount_";
  protected final String TEXT_111 = "++;\t" + NL + "" + NL + "    sb_";
  protected final String TEXT_112 = " = new StringBuffer(canonicalPath_";
  protected final String TEXT_113 = ");" + NL + "    lastIndexOf_";
  protected final String TEXT_114 = " = canonicalPath_";
  protected final String TEXT_115 = ".lastIndexOf('.');" + NL + "    position_";
  protected final String TEXT_116 = " = lastIndexOf_";
  protected final String TEXT_117 = " > -1 ? lastIndexOf_";
  protected final String TEXT_118 = " : canonicalPath_";
  protected final String TEXT_119 = ".length();" + NL + "    sb_";
  protected final String TEXT_120 = ".insert(position_";
  protected final String TEXT_121 = ", currentFileCount_";
  protected final String TEXT_122 = ");" + NL + "    " + NL + "    fileName_";
  protected final String TEXT_123 = " = sb_";
  protected final String TEXT_124 = ".toString();" + NL + "    file_";
  protected final String TEXT_125 = " = new java.io.File(fileName_";
  protected final String TEXT_126 = ");" + NL + "    " + NL + "\tout_";
  protected final String TEXT_127 = " = new java.io.BufferedWriter(new java.io.OutputStreamWriter(new java.io.FileOutputStream(file_";
  protected final String TEXT_128 = "));" + NL + "\t";
  protected final String TEXT_129 = NL + "\tresourceMap.put(\"stream_";
  protected final String TEXT_130 = "\", out_";
  protected final String TEXT_131 = ");" + NL + "\t";
  protected final String TEXT_132 = NL + "\tstart_";
  protected final String TEXT_133 = " = false;  ";
  protected final String TEXT_134 = ".write(headers_";
  protected final String TEXT_135 = "]);" + NL + "\tout_";
  protected final String TEXT_136 = "\t" + NL + "\tgroupby_";
  protected final String TEXT_137 = "][0] = \"\";";
  protected final String TEXT_138 = "\t" + NL + "    currentRowCount_";
  protected final String TEXT_139 = " = 0;" + NL + "}";
  protected final String TEXT_140 = NL + "\t\t\t\t\tnb_line_";
  protected final String TEXT_141 = "++;" + NL + "\t\t\t\t\torg.dom4j.Document doc_";
  protected final String TEXT_142 = ".getDocument();" + NL + "\t\t\t\t\t";
  protected final String TEXT_143 = NL + "\t\t\t\t\tresourceMap.put(\"nb_line_";
  protected final String TEXT_144 = ");" + NL + "\t\t\t\t\tif((doc_";
  protected final String TEXT_145 = " != null) && (doc_";
  protected final String TEXT_146 = ".getRootElement() != null)) {" + NL + "\t\t\t\t\t\tisEmpty_";
  protected final String TEXT_147 = " = false;" + NL + "\t\t\t\t\t}" + NL + "\t\t\t\t\t";
  protected final String TEXT_148 = NL + "\t\t\t\t\twriter_";
  protected final String TEXT_149 = ".write(doc_";
  protected final String TEXT_150 = ");" + NL + "\t\t\t\t\t";

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
	
    stringBuffer.append(TEXT_21);
    
CodeGeneratorArgument codeGenArgument = (CodeGeneratorArgument) argument;
INode node = (INode)codeGenArgument.getArgument();
String cid = node.getUniqueName();

boolean inputIsDocument = "true".equals(ElementParameterParser.getValue(node, "__INPUT_IS_DOCUMENT__"));
String colDoc = ElementParameterParser.getValue(node, "__DOCUMENT_COL__");
boolean isLog4jEnabled = ("true").equals(ElementParameterParser.getValue(node.getProcess(), "__LOG4J_ACTIVATE__"));
boolean isDeleteEmptyFile = ("true").equals(ElementParameterParser.getValue(node, "__DELETE_EMPTYFILE__"));

if(!inputIsDocument) {
List<IMetadataTable> metadatas = node.getMetadataList();
if ((metadatas!=null)&&(metadatas.size()>0)) {
    IMetadataTable metadata = metadatas.get(0);
    if (metadata!=null) {
    boolean flushOnRow = ("true").equals(ElementParameterParser.getValue(node, "__FLUSHONROW__")); 
    String flushMod = ElementParameterParser.getValue(node, "__FLUSHONROW_NUM__");       
    String split = ElementParameterParser.getValue(node, "__SPLIT__");
	String encoding = ElementParameterParser.getValue(node, "__ENCODING__");
	String fileName = ElementParameterParser.getValue(node, "__FILENAME__");
	List rootTags = (List)ElementParameterParser.getObjectValue(node, "__ROOT_TAGS__");
    int footers = rootTags.size();
    List<Map<String, String>> columnMapping = 
    		(List<Map<String,String>>)ElementParameterParser.getObjectValue(
                node,
                "__MAPPING__"
            );
    String useDynamicGrouping = ElementParameterParser.getValue(
            node,
            "__USE_DYNAMIC_GROUPING__"
        );
    List<Map<String, String>> groupBys =
            (List<Map<String,String>>)ElementParameterParser.getObjectValue(
                node,
                "__GROUP_BY__"
            );
            
    String advancedSeparatorStr = ElementParameterParser.getValue(node, "__ADVANCED_SEPARATOR__");
	boolean advancedSeparator = (advancedSeparatorStr!=null&&!("").equals(advancedSeparatorStr))?("true").equals(advancedSeparatorStr):false;
	String thousandsSeparator = ElementParameterParser.getValueWithJavaType(node, "__THOUSANDS_SEPARATOR__", JavaTypesManager.CHARACTER);
	String decimalSeparator = ElementParameterParser.getValueWithJavaType(node, "__DECIMAL_SEPARATOR__", JavaTypesManager.CHARACTER);
	
    if (("false").equals(useDynamicGrouping)) {
        groupBys.clear();
    }
    if (encoding!=null) {
        if (("").equals(encoding)) {
                encoding = "ISO-8859-15";
        }
    }
    String groupby[][] = new String[groupBys.size()][3];
    for(int i = 0; i < groupBys.size(); i++){
    	groupby[i][0] = groupBys.get(i).get("COLUMN");
    	groupby[i][1] = groupBys.get(i).get("LABEL");
    }
    int atts = 0;
    int tags = 0;
    outter1:
    for(int i = 0; i < columnMapping.size(); i++){
    	Map<String, String> map = columnMapping.get(i);
    	String col = metadata.getListColumns().get(i).getLabel();
    	for(int j = 0; j < groupby.length; j++){
    		if(groupby[j][0].equals(col)){
    			if(("true").equals(map.get("SCHEMA_COLUMN_NAME"))){
    				groupby[j][2] = col;
    				groupby[j][2] = TalendQuoteUtils.addQuotes(groupby[j][2]);
    			}else{
    				groupby[j][2] = map.get("LABEL");
    			}
    			continue outter1;
    		}
    	}
    	if(("true").equals(map.get("AS_ATTRIBUTE"))){
    		atts ++;
    	}else{
    		tags ++;
    	}
    }
    String[][] attribute = new String[atts][2];
    String[][] tag = new String[tags][2];
    int ia=0;
    int it=0;
    outter2:
    for(int i = 0; i < columnMapping.size(); i++){
    	Map<String, String> map = columnMapping.get(i);
    	String col = metadata.getListColumns().get(i).getLabel();
    	for(int j = 0; j < groupby.length; j++){
    		if(groupby[j][0].equals(col)){
    			continue outter2;
    		}
    	}
    	if(("true").equals(map.get("AS_ATTRIBUTE"))){
    		if(("true").equals(map.get("SCHEMA_COLUMN_NAME"))){
    			attribute[ia][1] = col;
    			attribute[ia][1] = TalendQuoteUtils.addQuotes(attribute[ia][1]);
    		}else{
    			attribute[ia][1] = map.get("LABEL");
    		}
    		attribute[ia++][0] = col;
    	}else{
    		if(("true").equals(map.get("SCHEMA_COLUMN_NAME"))){
    			tag[it][1] = col;
    			tag[it][1] = TalendQuoteUtils.addQuotes(tag[it][1]);
    		}else{
    			tag[it][1] = map.get("LABEL");
    		}
    	    tag[it++][0] = col;
    	}
    }
	if(groupby.length>0){

    stringBuffer.append(TEXT_22);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_23);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_24);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_25);
    
	}

    
	List< ? extends IConnection> conns = node.getIncomingConnections();
	if(conns!=null && conns.size()>0){
		IConnection conn = conns.get(0);
		for(int i = 0; i < groupby.length; i++){
			boolean needReplace = false;
			boolean isDate = false;
			boolean isByteArray = false;
			String pattern = null;
			boolean isPrimitive = false;
			boolean isBigDecimal = false;
			boolean isAdvancedSeparator = false;
			Integer precision = null;
			for(IMetadataColumn column:metadata.getListColumns()) {
				if(column.getLabel().equals(groupby[i][0])){
					JavaType javaType = JavaTypesManager.getJavaTypeFromId(column.getTalendType());
					if(JavaTypesManager.getJavaTypeFromId(column.getTalendType()) == JavaTypesManager.STRING){
						needReplace = true;
					}
					if(JavaTypesManager.getJavaTypeFromId(column.getTalendType()) == JavaTypesManager.DATE){
						pattern = column.getPattern() == null || column.getPattern().trim().length() == 0 ? null : column.getPattern();
						if(pattern != null && (pattern.contains("&") || pattern.contains("<") || pattern.contains(">") || pattern.contains("'") || pattern.contains("\""))){
							needReplace = true;
						}
						isDate = true;
					}
					if(JavaTypesManager.getJavaTypeFromId(column.getTalendType()) == JavaTypesManager.BYTE_ARRAY){
						isByteArray = true;
					}else if(JavaTypesManager.getJavaTypeFromId(column.getTalendType()) == JavaTypesManager.BIGDECIMAL){
						isBigDecimal = true;
					}
					isPrimitive = JavaTypesManager.isJavaPrimitiveType( column.getTalendType(), column.isNullable());
					
					isAdvancedSeparator = advancedSeparator && JavaTypesManager.isNumberType(javaType, column.isNullable());
					
					precision = column.getPrecision();
					break;
				}
			}

    stringBuffer.append(TEXT_26);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_27);
    stringBuffer.append(groupby[i][2] );
    stringBuffer.append(TEXT_28);
    stringBuffer.append(groupby[i][1] );
    stringBuffer.append(TEXT_29);
    
							if(isAdvancedSeparator){
								if(isBigDecimal){
								
    stringBuffer.append(TEXT_30);
    stringBuffer.append(precision == null? conn.getName() + "." + groupby[i][0] : conn.getName() + "." + groupby[i][0] + ".setScale(" + precision + ", java.math.RoundingMode.HALF_UP)" );
    stringBuffer.append(TEXT_31);
    stringBuffer.append( thousandsSeparator );
    stringBuffer.append(TEXT_32);
    stringBuffer.append( decimalSeparator );
    stringBuffer.append(TEXT_33);
    
								}else {
								
    stringBuffer.append(TEXT_30);
    stringBuffer.append(conn.getName() );
    stringBuffer.append(TEXT_34);
    stringBuffer.append(groupby[i][0] );
    stringBuffer.append(TEXT_31);
    stringBuffer.append( thousandsSeparator );
    stringBuffer.append(TEXT_32);
    stringBuffer.append( decimalSeparator );
    stringBuffer.append(TEXT_33);
    
								}
							}else if(isPrimitive){
								
    stringBuffer.append(conn.getName() );
    stringBuffer.append(TEXT_34);
    stringBuffer.append(groupby[i][0] );
    
							}else{
								
    stringBuffer.append(TEXT_35);
    stringBuffer.append(conn.getName() );
    stringBuffer.append(TEXT_34);
    stringBuffer.append(groupby[i][0] );
    stringBuffer.append(TEXT_36);
    
									if(isDate && pattern != null){
									
    if(needReplace){
    stringBuffer.append(TEXT_37);
    }
    stringBuffer.append(TEXT_38);
    stringBuffer.append(conn.getName() );
    stringBuffer.append(TEXT_34);
    stringBuffer.append(groupby[i][0] );
    stringBuffer.append(TEXT_32);
    stringBuffer.append(pattern );
    stringBuffer.append(TEXT_33);
    if(needReplace){
    stringBuffer.append(TEXT_33);
    }
    
									}else if(isByteArray){
									
    stringBuffer.append(TEXT_39);
    stringBuffer.append(conn.getName() );
    stringBuffer.append(TEXT_34);
    stringBuffer.append(groupby[i][0] );
    stringBuffer.append(TEXT_40);
    
									}else if(isBigDecimal){
									
    stringBuffer.append(TEXT_41);
    stringBuffer.append(precision == null? conn.getName() + "." + tag[i][0] : conn.getName() + "." + tag[i][0] + ".setScale(" + precision + ", java.math.RoundingMode.HALF_UP)" );
    stringBuffer.append(TEXT_42);
    
									}else{
									
    if(needReplace){
    stringBuffer.append(TEXT_37);
    }
    stringBuffer.append(conn.getName() );
    stringBuffer.append(TEXT_34);
    stringBuffer.append(groupby[i][0] );
    if(needReplace){
    stringBuffer.append(TEXT_33);
    }
    
									}
    stringBuffer.append(TEXT_42);
    
							}
    stringBuffer.append(TEXT_43);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_44);
    stringBuffer.append(i );
    stringBuffer.append(TEXT_45);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_46);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_47);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_48);
    stringBuffer.append(i );
    stringBuffer.append(TEXT_49);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_50);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_48);
    stringBuffer.append(groupby.length-1 );
    stringBuffer.append(TEXT_51);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_52);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_53);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_51);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_54);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_55);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_56);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_57);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_58);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_44);
    stringBuffer.append(i );
    stringBuffer.append(TEXT_59);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_60);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_61);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_62);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_63);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_64);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_65);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_66);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_61);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_67);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_63);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_64);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_68);
    
		}

    stringBuffer.append(TEXT_69);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_70);
    stringBuffer.append(ElementParameterParser.getValue(node, "__ROW_TAG__"));
    stringBuffer.append(TEXT_71);
    
for(int i = 0; i < attribute.length; i++){
	boolean needReplace = false;
	boolean isDate = false;
	boolean isByteArray = false;
	String pattern = null;
	boolean isPrimitive = false;
	boolean isBigDecimal = false;
	boolean isAdvancedSeparator = false;
	Integer precision = null;
	for(IMetadataColumn column:metadata.getListColumns()) {
		if(column.getLabel().equals(attribute[i][0])){
			JavaType javaType = JavaTypesManager.getJavaTypeFromId(column.getTalendType());
			if(JavaTypesManager.getJavaTypeFromId(column.getTalendType()) == JavaTypesManager.STRING){
				needReplace = true;
			}
			if(JavaTypesManager.getJavaTypeFromId(column.getTalendType()) == JavaTypesManager.DATE){
				pattern = column.getPattern() == null || column.getPattern().trim().length() == 0 ? null : column.getPattern();
				if(pattern != null && (pattern.contains("&") || pattern.contains("<") || pattern.contains(">") || pattern.contains("'") || pattern.contains("\""))){
					needReplace = true;
				}
				isDate = true;
			}
			if(JavaTypesManager.getJavaTypeFromId(column.getTalendType()) == JavaTypesManager.BYTE_ARRAY){
				isByteArray = true;
			}else if(JavaTypesManager.getJavaTypeFromId(column.getTalendType()) == JavaTypesManager.BIGDECIMAL){
				isBigDecimal = true;
			}
			isPrimitive = JavaTypesManager.isJavaPrimitiveType( column.getTalendType(), column.isNullable());
			
			isAdvancedSeparator = advancedSeparator && JavaTypesManager.isNumberType(javaType, column.isNullable());
			
			precision = column.getPrecision();
			break;
		}
	}

    stringBuffer.append(TEXT_72);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_73);
    stringBuffer.append(attribute[i][1] );
    stringBuffer.append(TEXT_29);
    
							if(isAdvancedSeparator){
								if(isBigDecimal){
								
    stringBuffer.append(TEXT_30);
    stringBuffer.append(precision == null? conn.getName() + "." + attribute[i][0] : conn.getName() + "." + attribute[i][0] + ".setScale(" + precision + ", java.math.RoundingMode.HALF_UP)" );
    stringBuffer.append(TEXT_31);
    stringBuffer.append( thousandsSeparator );
    stringBuffer.append(TEXT_32);
    stringBuffer.append( decimalSeparator );
    stringBuffer.append(TEXT_33);
    
								}else {
								
    stringBuffer.append(TEXT_30);
    stringBuffer.append(conn.getName() );
    stringBuffer.append(TEXT_34);
    stringBuffer.append(attribute[i][0] );
    stringBuffer.append(TEXT_31);
    stringBuffer.append( thousandsSeparator );
    stringBuffer.append(TEXT_32);
    stringBuffer.append( decimalSeparator );
    stringBuffer.append(TEXT_33);
    
								}
							}else if(isPrimitive){
								
    stringBuffer.append(conn.getName() );
    stringBuffer.append(TEXT_34);
    stringBuffer.append(attribute[i][0] );
    
							}else{
								
    stringBuffer.append(TEXT_35);
    stringBuffer.append(conn.getName() );
    stringBuffer.append(TEXT_34);
    stringBuffer.append(attribute[i][0] );
    stringBuffer.append(TEXT_36);
    
									if(isDate && pattern != null){
									
    if(needReplace){
    stringBuffer.append(TEXT_37);
    }
    stringBuffer.append(TEXT_38);
    stringBuffer.append(conn.getName() );
    stringBuffer.append(TEXT_34);
    stringBuffer.append(attribute[i][0] );
    stringBuffer.append(TEXT_32);
    stringBuffer.append(pattern );
    stringBuffer.append(TEXT_33);
    if(needReplace){
    stringBuffer.append(TEXT_33);
    }
    
									}else if(isByteArray){
									
    stringBuffer.append(TEXT_39);
    stringBuffer.append(conn.getName() );
    stringBuffer.append(TEXT_34);
    stringBuffer.append(attribute[i][0] );
    stringBuffer.append(TEXT_40);
    
									}else if(isBigDecimal){
									
    stringBuffer.append(TEXT_41);
    stringBuffer.append(precision == null? conn.getName() + "." + tag[i][0] : conn.getName() + "." + tag[i][0] + ".setScale(" + precision + ", java.math.RoundingMode.HALF_UP)" );
    stringBuffer.append(TEXT_42);
    
									}else{
									
    if(needReplace){
    stringBuffer.append(TEXT_37);
    }
    stringBuffer.append(conn.getName() );
    stringBuffer.append(TEXT_34);
    stringBuffer.append(attribute[i][0] );
    if(needReplace){
    stringBuffer.append(TEXT_33);
    }
    
									}
    stringBuffer.append(TEXT_42);
    
							}
    stringBuffer.append(TEXT_74);
    
}

    
if(tags > 0){

    stringBuffer.append(TEXT_72);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_75);
    
}else{

    stringBuffer.append(TEXT_72);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_76);
    
}

    stringBuffer.append(TEXT_77);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_78);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_79);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_80);
    
for(int i = 0; i < tag.length; i++){
	boolean needReplace = false;
	boolean isDate = false;
	boolean isByteArray = false;
	String pattern = null;
	boolean isPrimitive = false;
	boolean isBigDecimal = false;
	boolean isAdvancedSeparator = false;
	boolean isDocument = false;
	Integer precision = null;
	for(IMetadataColumn column:metadata.getListColumns()) {
		if(column.getLabel().equals(tag[i][0])){
			JavaType javaType = JavaTypesManager.getJavaTypeFromId(column.getTalendType());
			if(JavaTypesManager.getJavaTypeFromId(column.getTalendType()) == JavaTypesManager.STRING){
				needReplace = true;
			}
			if(JavaTypesManager.getJavaTypeFromId(column.getTalendType()) == JavaTypesManager.DATE){
				pattern = column.getPattern() == null || column.getPattern().trim().length() == 0 ? null : column.getPattern();
				if(pattern != null && (pattern.contains("&") || pattern.contains("<") || pattern.contains(">") || pattern.contains("'") || pattern.contains("\""))){
					needReplace = true;
				}
				isDate = true;
			}
			if(JavaTypesManager.getJavaTypeFromId(column.getTalendType()) == JavaTypesManager.BYTE_ARRAY){
				isByteArray = true;
			}else if(JavaTypesManager.getJavaTypeFromId(column.getTalendType()) == JavaTypesManager.BIGDECIMAL){
				isBigDecimal = true;
			}
			isPrimitive = JavaTypesManager.isJavaPrimitiveType( column.getTalendType(), column.isNullable());
			isAdvancedSeparator = advancedSeparator && JavaTypesManager.isNumberType(javaType, column.isNullable());
						
			precision = column.getPrecision();

			isDocument = "id_Document".equals(column.getTalendType());
			break;
		}
	}

    stringBuffer.append(TEXT_77);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_81);
    stringBuffer.append(tag[i][1]);
    stringBuffer.append(TEXT_82);
    
							if(isAdvancedSeparator){
								if(isBigDecimal){
								
    stringBuffer.append(TEXT_30);
    stringBuffer.append(precision == null? conn.getName() + "." + tag[i][0] : conn.getName() + "." + tag[i][0] + ".setScale(" + precision + ", java.math.RoundingMode.HALF_UP)" );
    stringBuffer.append(TEXT_31);
    stringBuffer.append( thousandsSeparator );
    stringBuffer.append(TEXT_32);
    stringBuffer.append( decimalSeparator );
    stringBuffer.append(TEXT_33);
    
								}else {
								
    stringBuffer.append(TEXT_30);
    stringBuffer.append(conn.getName() );
    stringBuffer.append(TEXT_34);
    stringBuffer.append(tag[i][0] );
    stringBuffer.append(TEXT_31);
    stringBuffer.append( thousandsSeparator );
    stringBuffer.append(TEXT_32);
    stringBuffer.append( decimalSeparator );
    stringBuffer.append(TEXT_33);
    
								}
							}else if(isPrimitive){
								
    stringBuffer.append(conn.getName() );
    stringBuffer.append(TEXT_34);
    stringBuffer.append(tag[i][0] );
    
							}else{
								
    stringBuffer.append(TEXT_35);
    stringBuffer.append(conn.getName() );
    stringBuffer.append(TEXT_34);
    stringBuffer.append(tag[i][0] );
    stringBuffer.append(TEXT_36);
    
									if(isDate && pattern != null){
									
    if(needReplace){
    stringBuffer.append(TEXT_83);
    }
    stringBuffer.append(TEXT_38);
    stringBuffer.append(conn.getName() );
    stringBuffer.append(TEXT_34);
    stringBuffer.append(tag[i][0] );
    stringBuffer.append(TEXT_32);
    stringBuffer.append(pattern );
    stringBuffer.append(TEXT_33);
    if(needReplace){
    stringBuffer.append(TEXT_33);
    }
    
									}else if(isByteArray){
									
    stringBuffer.append(TEXT_84);
    stringBuffer.append(conn.getName() );
    stringBuffer.append(TEXT_34);
    stringBuffer.append(tag[i][0] );
    stringBuffer.append(TEXT_40);
    
									}else if(isBigDecimal){
									
    stringBuffer.append(TEXT_85);
    stringBuffer.append(precision == null? conn.getName() + "." + tag[i][0] : conn.getName() + "." + tag[i][0] + ".setScale(" + precision + ", java.math.RoundingMode.HALF_UP)" );
    stringBuffer.append(TEXT_42);
    
									}else if(isDocument){
									
    if(needReplace){
    stringBuffer.append(TEXT_83);
    }
    stringBuffer.append(conn.getName() );
    stringBuffer.append(TEXT_34);
    stringBuffer.append(tag[i][0] );
    if(needReplace){
    stringBuffer.append(TEXT_33);
    }
    stringBuffer.append(TEXT_86);
    
									}else{
									
    if(needReplace){
    stringBuffer.append(TEXT_83);
    }
    stringBuffer.append(conn.getName() );
    stringBuffer.append(TEXT_34);
    stringBuffer.append(tag[i][0] );
    if(needReplace){
    stringBuffer.append(TEXT_33);
    }
    
									}
    stringBuffer.append(TEXT_42);
    
							}
    stringBuffer.append(TEXT_87);
    stringBuffer.append(tag[i][1]);
    stringBuffer.append(TEXT_88);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_80);
    
	if(i == tag.length -1){

    stringBuffer.append(TEXT_77);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_89);
    stringBuffer.append(ElementParameterParser.getValue(node, "__ROW_TAG__"));
    stringBuffer.append(TEXT_88);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_80);
    
	}
}

    stringBuffer.append(TEXT_90);
     if(flushOnRow) { 
    stringBuffer.append(TEXT_91);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_92);
    stringBuffer.append(flushMod );
    stringBuffer.append(TEXT_93);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_94);
    
	}

    stringBuffer.append(TEXT_95);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_96);
    if(isDeleteEmptyFile) {
    stringBuffer.append(TEXT_97);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_98);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_19);
    }
    stringBuffer.append(TEXT_90);
    log4jFileUtil.debugWriteData(node);
    
    if(("true").equals(split)){

    stringBuffer.append(TEXT_99);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_100);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_101);
    stringBuffer.append(ElementParameterParser.getValue(node, "__SPLIT_EVERY__") );
    stringBuffer.append(TEXT_102);
    
		for(int i = groupby.length - 1; i >=0; i--){

    stringBuffer.append(TEXT_103);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_55);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_44);
    stringBuffer.append(i );
    stringBuffer.append(TEXT_104);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_105);
    
		}
		for(int i = footers - 1; i >= 0 ;i--){

    stringBuffer.append(TEXT_103);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_106);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_44);
    stringBuffer.append(i );
    stringBuffer.append(TEXT_107);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_108);
    
		}

    stringBuffer.append(TEXT_109);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_110);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_111);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_112);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_113);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_114);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_115);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_116);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_117);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_118);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_119);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_120);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_121);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_122);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_123);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_124);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_125);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_126);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_127);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_31);
    stringBuffer.append(encoding);
    stringBuffer.append(TEXT_128);
    if(isDeleteEmptyFile) {
    stringBuffer.append(TEXT_129);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_130);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_131);
    }
    stringBuffer.append(TEXT_90);
    
	if(groupby.length > 0){

    stringBuffer.append(TEXT_132);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_133);
    
	}
	for(int i = 0; i <= footers;i++){

    stringBuffer.append(TEXT_109);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_134);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_44);
    stringBuffer.append(i );
    stringBuffer.append(TEXT_135);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_108);
    
	}
	for(int i = 0; i < groupby.length; i++){

    stringBuffer.append(TEXT_136);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_44);
    stringBuffer.append(i );
    stringBuffer.append(TEXT_137);
    
	}

    stringBuffer.append(TEXT_138);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_139);
    
	}
		}
	}
}
} else {
	List<IMetadataTable> metadatas = node.getMetadataList();
	if ((metadatas!=null)&&(metadatas.size()>0)) {
		IMetadataTable metadata = metadatas.get(0);
		if (metadata!=null) {
			List< ? extends IConnection> conns = node.getIncomingConnections();
			if(conns!=null && conns.size()>0){
				IConnection conn = conns.get(0);

    stringBuffer.append(TEXT_140);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_141);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_48);
    stringBuffer.append(conn.getName());
    stringBuffer.append(TEXT_34);
    stringBuffer.append(colDoc);
    stringBuffer.append(TEXT_142);
    if(isDeleteEmptyFile) {
    stringBuffer.append(TEXT_143);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_98);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_144);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_145);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_146);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_147);
    }
    stringBuffer.append(TEXT_148);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_149);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_150);
    log4jFileUtil.debugWriteData(node);
    
			}
		}
	}
}

    stringBuffer.append(TEXT_90);
    return stringBuffer.toString();
  }
}
