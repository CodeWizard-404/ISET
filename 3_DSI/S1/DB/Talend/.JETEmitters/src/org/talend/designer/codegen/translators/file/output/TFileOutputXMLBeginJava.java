package org.talend.designer.codegen.translators.file.output;

import org.talend.core.model.process.INode;
import org.talend.core.model.process.ElementParameterParser;
import org.talend.designer.codegen.config.CodeGeneratorArgument;
import org.talend.core.model.metadata.IMetadataTable;
import org.talend.core.utils.TalendQuoteUtils;
import java.util.List;
import java.util.Map;
import java.util.HashMap;

public class TFileOutputXMLBeginJava
{
  protected static String nl;
  public static synchronized TFileOutputXMLBeginJava create(String lineSeparator)
  {
    nl = lineSeparator;
    TFileOutputXMLBeginJava result = new TFileOutputXMLBeginJava();
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
  protected final String TEXT_22 = NL + "\tString originalFileName_";
  protected final String TEXT_23 = " = ";
  protected final String TEXT_24 = ";" + NL + "\tjava.io.File originalFile_";
  protected final String TEXT_25 = " = new java.io.File(originalFileName_";
  protected final String TEXT_26 = "); " + NL + "" + NL + "\tString fileName_";
  protected final String TEXT_27 = " = originalFileName_";
  protected final String TEXT_28 = ";" + NL + "\tjava.io.File file_";
  protected final String TEXT_29 = " = new java.io.File(fileName_";
  protected final String TEXT_30 = "); " + NL + "\tif(!file_";
  protected final String TEXT_31 = ".isAbsolute()) {" + NL + "\t\tfile_";
  protected final String TEXT_32 = " = file_";
  protected final String TEXT_33 = ".getCanonicalFile();" + NL + "\t}" + NL;
  protected final String TEXT_34 = NL + "\t//create directory only if not exists" + NL + "\t";
  protected final String TEXT_35 = NL + "\t\tlog.info(\"";
  protected final String TEXT_36 = " - Creating directory '\" + file_";
  protected final String TEXT_37 = ".getParentFile() + \"'.\");" + NL + "\t";
  protected final String TEXT_38 = NL + "\tfile_";
  protected final String TEXT_39 = ".getParentFile().mkdirs();" + NL + "\t";
  protected final String TEXT_40 = " - Directory '\" + file_";
  protected final String TEXT_41 = ".getParentFile() + \"' created successfully.\");" + NL + "\t";
  protected final String TEXT_42 = NL + "\tString[] headers_";
  protected final String TEXT_43 = " = new String[";
  protected final String TEXT_44 = "];" + NL + "\t\t" + NL + "\theaders_";
  protected final String TEXT_45 = "[0] = \"<?xml version=\\\"1.0\\\" encoding=\\\"\"+";
  protected final String TEXT_46 = "+\"\\\"?>\";  " + NL;
  protected final String TEXT_47 = NL + "\tString[] footers_";
  protected final String TEXT_48 = "];" + NL;
  protected final String TEXT_49 = NL + "\theaders_";
  protected final String TEXT_50 = "[";
  protected final String TEXT_51 = "] = \"<\"+";
  protected final String TEXT_52 = "+\">\";" + NL + "" + NL + "\tfooters_";
  protected final String TEXT_53 = "] = \"</\"+";
  protected final String TEXT_54 = "+\">\";" + NL;
  protected final String TEXT_55 = NL + "\tString[][] groupby_";
  protected final String TEXT_56 = "][2];" + NL + "" + NL + "\tint groupby_new_";
  protected final String TEXT_57 = " = 0;" + NL + "" + NL + "\tboolean start_";
  protected final String TEXT_58 = " = false;" + NL;
  protected final String TEXT_59 = NL + "\tgroupby_";
  protected final String TEXT_60 = "][0] = \"\";" + NL + "" + NL + "\tgroupby_";
  protected final String TEXT_61 = "][1] = \"</\"+";
  protected final String TEXT_62 = NL + NL + "\tint nb_line_";
  protected final String TEXT_63 = " = 0;" + NL;
  protected final String TEXT_64 = NL + "\tint currentRowCount_";
  protected final String TEXT_65 = " = 0;" + NL + "\tint currentFileCount_";
  protected final String TEXT_66 = " = 0;" + NL + "" + NL + "\tString canonicalPath_";
  protected final String TEXT_67 = " = originalFile_";
  protected final String TEXT_68 = ".getCanonicalPath();" + NL + "\tStringBuffer sb_";
  protected final String TEXT_69 = " = new StringBuffer(canonicalPath_";
  protected final String TEXT_70 = ");" + NL + "\tint lastIndexOf_";
  protected final String TEXT_71 = " = canonicalPath_";
  protected final String TEXT_72 = ".lastIndexOf('.');" + NL + "\tint position_";
  protected final String TEXT_73 = " = lastIndexOf_";
  protected final String TEXT_74 = " > -1 ? lastIndexOf_";
  protected final String TEXT_75 = " : canonicalPath_";
  protected final String TEXT_76 = ".length();" + NL + "\tsb_";
  protected final String TEXT_77 = ".insert(position_";
  protected final String TEXT_78 = ", currentFileCount_";
  protected final String TEXT_79 = ");" + NL + "" + NL + "\tfileName_";
  protected final String TEXT_80 = " = sb_";
  protected final String TEXT_81 = ".toString();" + NL + "\tfile_";
  protected final String TEXT_82 = NL + "\tjava.io.BufferedWriter out_";
  protected final String TEXT_83 = " = new java.io.BufferedWriter(new java.io.OutputStreamWriter(new java.io.FileOutputStream(file_";
  protected final String TEXT_84 = "), ";
  protected final String TEXT_85 = "));" + NL + "\t";
  protected final String TEXT_86 = NL + "\tresourceMap.put(\"nb_line_";
  protected final String TEXT_87 = "\", nb_line_";
  protected final String TEXT_88 = ");" + NL + "\tresourceMap.put(\"isFileGenerated_";
  protected final String TEXT_89 = "\", true);" + NL + "\tresourceMap.put(\"file_";
  protected final String TEXT_90 = "\", file_";
  protected final String TEXT_91 = ");" + NL + "\tresourceMap.put(\"stream_";
  protected final String TEXT_92 = "\", out_";
  protected final String TEXT_93 = ");" + NL + "\t";
  protected final String TEXT_94 = NL;
  protected final String TEXT_95 = NL + "\tout_";
  protected final String TEXT_96 = ".write(headers_";
  protected final String TEXT_97 = "]);" + NL + "\tout_";
  protected final String TEXT_98 = ".newLine();\t";
  protected final String TEXT_99 = NL + "\tint nb_line_";
  protected final String TEXT_100 = " = 0;" + NL + "\torg.dom4j.io.OutputFormat format_";
  protected final String TEXT_101 = " = org.dom4j.io.OutputFormat.createPrettyPrint();" + NL + "\tformat_";
  protected final String TEXT_102 = ".setEncoding(";
  protected final String TEXT_103 = ");" + NL + "\tformat_";
  protected final String TEXT_104 = ".setNewLineAfterDeclaration(false);" + NL + "\tformat_";
  protected final String TEXT_105 = ".setTrimText(";
  protected final String TEXT_106 = ");" + NL + "\t" + NL + "\torg.dom4j.io.XMLWriter writer_";
  protected final String TEXT_107 = " = new org.dom4j.io.XMLWriter(new java.io.OutputStreamWriter(new java.io.FileOutputStream(file_";
  protected final String TEXT_108 = "), format_";
  protected final String TEXT_109 = "\", writer_";
  protected final String TEXT_110 = ");" + NL + "\t" + NL + "\tboolean isEmpty_";
  protected final String TEXT_111 = " = true;" + NL + "\t";

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
	boolean isLog4jEnabled = ("true").equals(ElementParameterParser.getValue(node.getProcess(), "__LOG4J_ACTIVATE__"));
	boolean isDeleteEmptyFile = ("true").equals(ElementParameterParser.getValue(node, "__DELETE_EMPTYFILE__"));
	List<IMetadataTable> metadatas = node.getMetadataList();
	if ((metadatas!=null)&&(metadatas.size()>0)) {
		IMetadataTable metadata = metadatas.get(0);
		if (metadata!=null) {
			String encoding = ElementParameterParser.getValue(node, "__ENCODING__");
			List<Map<String, String>> rootTags = (List<Map<String,String>>)ElementParameterParser.getObjectValue(node, "__ROOT_TAGS__");
			if (rootTags.size()==0) {
				Map<String, String> defaultRootNode = new HashMap<String, String>();
				defaultRootNode.put("TAG","\"root\"");
				rootTags.add(defaultRootNode);
			}
			int headers = rootTags.size() + 1;
			boolean split = ("true").equals(ElementParameterParser.getValue(node, "__SPLIT__"));
			String fileName = ElementParameterParser.getValue(node, "__FILENAME__");
			boolean trim = "true".equals(ElementParameterParser.getValue(node, "__TRIM__"));
			
			//**
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
					}else{
						attribute[ia][1] = map.get("LABEL");
					}
					attribute[ia++][0] = col;
				}else{
					if(("true").equals(map.get("SCHEMA_COLUMN_NAME"))){
						tag[it][1] = col;
					}else{
						tag[it][1] = map.get("LABEL");
					}
					tag[it++][0] = col;
				}
			}
			//**

    stringBuffer.append(TEXT_22);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_23);
    stringBuffer.append(fileName );
    stringBuffer.append(TEXT_24);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_25);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_26);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_27);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_28);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_29);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_30);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_31);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_32);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_33);
    
			if(("true").equals(ElementParameterParser.getValue(node,"__CREATE__"))){

    stringBuffer.append(TEXT_34);
    if(isLog4jEnabled){
    stringBuffer.append(TEXT_35);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_36);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_37);
    }
    stringBuffer.append(TEXT_38);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_39);
    if(isLog4jEnabled){
    stringBuffer.append(TEXT_35);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_40);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_41);
    }
    
			}
			if(!inputIsDocument) {

    stringBuffer.append(TEXT_42);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_43);
    stringBuffer.append(headers );
    stringBuffer.append(TEXT_44);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_45);
    stringBuffer.append( encoding );
    stringBuffer.append(TEXT_46);
    
				if(rootTags.size() > 0){

    stringBuffer.append(TEXT_47);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_43);
    stringBuffer.append(rootTags.size());
    stringBuffer.append(TEXT_48);
    
					for (int i=0; i<rootTags.size(); i++){
						Map<String, String> rootTag = rootTags.get(i);

    stringBuffer.append(TEXT_49);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_50);
    stringBuffer.append(i+1 );
    stringBuffer.append(TEXT_51);
    stringBuffer.append(rootTag.get("TAG") );
    stringBuffer.append(TEXT_52);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_50);
    stringBuffer.append(i );
    stringBuffer.append(TEXT_53);
    stringBuffer.append(rootTag.get("TAG") );
    stringBuffer.append(TEXT_54);
    
					}
				}

				if(groupby.length>0){

    stringBuffer.append(TEXT_55);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_43);
    stringBuffer.append(groupby.length );
    stringBuffer.append(TEXT_56);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_57);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_58);
    
					for(int i = 0; i < groupby.length; i++){

    stringBuffer.append(TEXT_59);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_50);
    stringBuffer.append(i );
    stringBuffer.append(TEXT_60);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_50);
    stringBuffer.append(i );
    stringBuffer.append(TEXT_61);
    stringBuffer.append(groupby[i][2] );
    stringBuffer.append(TEXT_54);
    
					}
				}

    stringBuffer.append(TEXT_62);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_63);
    
				if(split) {

    stringBuffer.append(TEXT_64);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_65);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_66);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_67);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_68);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_69);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_70);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_71);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_72);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_73);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_74);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_75);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_76);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_77);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_78);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_79);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_80);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_81);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_29);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_19);
    
				}

    stringBuffer.append(TEXT_82);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_83);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_84);
    stringBuffer.append(encoding);
    stringBuffer.append(TEXT_85);
    if(isDeleteEmptyFile) {
    stringBuffer.append(TEXT_86);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_87);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_88);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_89);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_90);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_91);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_92);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_93);
    }
    stringBuffer.append(TEXT_94);
    	
				for(int i = 0; i < headers;i++){

    stringBuffer.append(TEXT_95);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_96);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_50);
    stringBuffer.append(i );
    stringBuffer.append(TEXT_97);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_98);
    
				}
			} else {

    stringBuffer.append(TEXT_99);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_100);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_101);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_102);
    stringBuffer.append(encoding);
    stringBuffer.append(TEXT_103);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_104);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_105);
    stringBuffer.append(trim);
    stringBuffer.append(TEXT_106);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_107);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_84);
    stringBuffer.append(encoding);
    stringBuffer.append(TEXT_108);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_93);
    if(isDeleteEmptyFile) {
    stringBuffer.append(TEXT_86);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_87);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_88);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_89);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_90);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_91);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_109);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_110);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_111);
    }
    
			}
		}
	}

    stringBuffer.append(TEXT_94);
    return stringBuffer.toString();
  }
}
