package org.talend.designer.codegen.translators.technical;

import org.talend.core.model.process.INode;
import org.talend.core.model.process.ElementParameterParser;
import org.talend.designer.codegen.config.CodeGeneratorArgument;
import org.talend.core.model.metadata.IMetadataTable;
import org.talend.core.model.metadata.IMetadataColumn;
import org.talend.core.model.metadata.types.JavaType;
import org.talend.core.model.metadata.types.JavaTypesManager;
import java.util.List;
import java.util.Map;
import java.util.ArrayList;

public class TSortOutBeginJava
{
  protected static String nl;
  public static synchronized TSortOutBeginJava create(String lineSeparator)
  {
    nl = lineSeparator;
    TSortOutBeginJava result = new TSortOutBeginJava();
    nl = null;
    return result;
  }

  public final String NL = nl == null ? (System.getProperties().getProperty("line.separator")) : nl;
  protected final String TEXT_1 = "";
  protected final String TEXT_2 = NL + "if(true){" + NL + "\tthrow new java.lang.Exception(\"Bad sort criteria: couldn't sort column \\\"";
  protected final String TEXT_3 = "\\\" as num.\");" + NL + "}";
  protected final String TEXT_4 = "\\\" as date.\");" + NL + "}";
  protected final String TEXT_5 = NL;
  protected final String TEXT_6 = NL + "class Comparable";
  protected final String TEXT_7 = "Struct extends ";
  protected final String TEXT_8 = "Struct implements Comparable<Comparable";
  protected final String TEXT_9 = "Struct> {" + NL + "\t" + NL + "\tpublic int compareTo(Comparable";
  protected final String TEXT_10 = "Struct other) {" + NL;
  protected final String TEXT_11 = NL + "\t\tif(this.";
  protected final String TEXT_12 = " == null && other.";
  protected final String TEXT_13 = " != null){";
  protected final String TEXT_14 = NL + "\t\t\treturn -1;" + NL + "\t\t\t\t\t\t";
  protected final String TEXT_15 = NL + "\t\t\treturn 1;" + NL + "\t\t\t\t\t\t";
  protected final String TEXT_16 = NL + "\t\t}else if(this.";
  protected final String TEXT_17 = " != null && other.";
  protected final String TEXT_18 = " == null){";
  protected final String TEXT_19 = " != null){" + NL + "\t\t\tif(!this.";
  protected final String TEXT_20 = ".equals(other.";
  protected final String TEXT_21 = ")){";
  protected final String TEXT_22 = NL + "\t\t\t\treturn this.";
  protected final String TEXT_23 = ".compareTo(other.";
  protected final String TEXT_24 = ");";
  protected final String TEXT_25 = NL + "\t\t\t\treturn other.";
  protected final String TEXT_26 = ".compareTo(this.";
  protected final String TEXT_27 = NL + "\t\t\t}" + NL + "\t\t}";
  protected final String TEXT_28 = " != other.";
  protected final String TEXT_29 = "){";
  protected final String TEXT_30 = " ? 1 : -1;";
  protected final String TEXT_31 = " ? -1 : 1;";
  protected final String TEXT_32 = NL + "\t\t}";
  protected final String TEXT_33 = "){" + NL + "\t\t\t\t\t\t";
  protected final String TEXT_34 = " > other.";
  protected final String TEXT_35 = " ? 1 : -1;" + NL + "\t\t\t\t\t\t\t";
  protected final String TEXT_36 = " > this.";
  protected final String TEXT_37 = NL + "\t\tString thisS";
  protected final String TEXT_38 = " = this.";
  protected final String TEXT_39 = " == null ? \"null\" : new String(this.";
  protected final String TEXT_40 = ");" + NL + "\t\tString otherS";
  protected final String TEXT_41 = " = other.";
  protected final String TEXT_42 = " == null ? \"null\" : new String(other.";
  protected final String TEXT_43 = ");" + NL + "\t\tif(!thisS";
  protected final String TEXT_44 = ".equals(otherS";
  protected final String TEXT_45 = NL + "\t\t\treturn thisS";
  protected final String TEXT_46 = ".compareTo(otherS";
  protected final String TEXT_47 = ");" + NL + "\t\t\t\t\t\t\t";
  protected final String TEXT_48 = NL + "\t\t\treturn otherS";
  protected final String TEXT_49 = ".compareTo(thisS";
  protected final String TEXT_50 = NL + "\t\t\tString thisS";
  protected final String TEXT_51 = " == null ? \"null\" : FormatterUtils.format_Date(this.";
  protected final String TEXT_52 = ", ";
  protected final String TEXT_53 = ");" + NL + "\t\t\tString otherS";
  protected final String TEXT_54 = " == null ? \"null\" : FormatterUtils.format_Date(other.";
  protected final String TEXT_55 = ");" + NL + "\t\t\tif(!thisS";
  protected final String TEXT_56 = NL + "\t\t\t\treturn thisS";
  protected final String TEXT_57 = NL + "\t\t\t\treturn otherS";
  protected final String TEXT_58 = NL + "\t\t\t}";
  protected final String TEXT_59 = " == null ? \"null\" : String.valueOf(this.";
  protected final String TEXT_60 = " == null ? \"null\" : String.valueOf(other.";
  protected final String TEXT_61 = " = String.valueOf(this.";
  protected final String TEXT_62 = " = String.valueOf(other.";
  protected final String TEXT_63 = NL + "\t\treturn 0;" + NL + "\t}" + NL + "}" + NL + "" + NL + "java.util.List<Comparable";
  protected final String TEXT_64 = "Struct> list_";
  protected final String TEXT_65 = " = new java.util.ArrayList<Comparable";
  protected final String TEXT_66 = "Struct>();" + NL;
  protected final String TEXT_67 = NL + "////////////////////////////////////" + NL + "class ";
  protected final String TEXT_68 = "StructILightSerializable extends ";
  protected final String TEXT_69 = "Struct implements" + NL + "                        org.talend.designer.components.tsort.io.beans.ILightSerializable<";
  protected final String TEXT_70 = "StructILightSerializable> {" + NL + "" + NL + "\tpublic int compareTo(";
  protected final String TEXT_71 = "StructILightSerializable other) {" + NL;
  protected final String TEXT_72 = " ? -1 : -1;";
  protected final String TEXT_73 = NL + "\t\treturn 0;" + NL + "\t}" + NL + "" + NL + "\tpublic org.talend.designer.components.tsort.io.beans.ILightSerializable createInstance(byte[] byteArray) {" + NL + "\t\t";
  protected final String TEXT_74 = "StructILightSerializable result = new ";
  protected final String TEXT_75 = "StructILightSerializable();" + NL + "\t\tjava.io.ByteArrayInputStream bai = null;" + NL + "\t\tjava.io.DataInputStream dis = null;" + NL + "" + NL + "\t\ttry {" + NL + "\t\t\tbai = new java.io.ByteArrayInputStream(byteArray);" + NL + "\t\t\tdis = new java.io.DataInputStream(bai);" + NL + "\t\t\tint length = 0;";
  protected final String TEXT_76 = NL + "\t\t\t            result.";
  protected final String TEXT_77 = " = dis.read";
  protected final String TEXT_78 = "();" + NL + "\t\t\t\t\t";
  protected final String TEXT_79 = NL + "\t\t\t            length = dis.readInt();" + NL + "           \t\t\t\tif (length == -1) {" + NL + "           \t    \t\t\tresult.";
  protected final String TEXT_80 = " = null;" + NL + "           \t\t\t\t} else {" + NL + "               \t\t\t\tbyte[] bytes = new byte[length];" + NL + "               \t\t\t\tdis.read(bytes);" + NL + "               \t\t\t\tresult.";
  protected final String TEXT_81 = " = new String(bytes, utf8Charset);" + NL + "           \t\t\t\t}" + NL + "\t\t\t\t\t";
  protected final String TEXT_82 = " = bytes;" + NL + "           \t\t\t\t}" + NL + "\t\t\t\t\t";
  protected final String TEXT_83 = NL + "\t\t\t            length = dis.readByte();" + NL + "           \t\t\t\tif (length == -1) {" + NL + "           \t    \t\t\tresult.";
  protected final String TEXT_84 = " = null;" + NL + "           \t\t\t\t} else {" + NL + "           \t\t\t    \tresult.";
  protected final String TEXT_85 = " = new Date(dis.readLong());" + NL + "           \t\t\t\t}" + NL + "\t\t\t\t\t";
  protected final String TEXT_86 = " = null;" + NL + "           \t\t\t\t} else {" + NL + "               \t\t\t\tbyte[] bytes = new byte[length];" + NL + "               \t\t\t\tdis.read(bytes);" + NL + "               \t\t\t\tjava.io.ByteArrayInputStream bio_";
  protected final String TEXT_87 = "  = new java.io.ByteArrayInputStream(bytes);" + NL + "            \t\t\t\tjava.io.ObjectInputStream ois_";
  protected final String TEXT_88 = "  = new java.io.ObjectInputStream(bio_";
  protected final String TEXT_89 = " );" + NL + "               \t\t\t\tresult.";
  protected final String TEXT_90 = " = (";
  protected final String TEXT_91 = ") ois_";
  protected final String TEXT_92 = ".readObject();" + NL + "               \t\t\t\tois_";
  protected final String TEXT_93 = ".close();" + NL + "           \t\t\t\t}" + NL + "\t\t\t\t\t";
  protected final String TEXT_94 = "();" + NL + "           \t\t\t\t}" + NL + "\t\t\t\t\t";
  protected final String TEXT_95 = NL + NL + "\t\t} catch (java.lang.Exception e) {" + NL + "globalMap.put(\"";
  protected final String TEXT_96 = "_ERROR_MESSAGE\",e.getMessage());" + NL + "\t\t\te.printStackTrace();" + NL + "\t\t} finally {" + NL + "\t\t\tif (dis != null) {" + NL + "\t\t\t\ttry {" + NL + "\t\t\t\t\tdis.close();" + NL + "            } catch (java.io.IOException e) {" + NL + "            \te.printStackTrace();" + NL + "         \t}" + NL + "        \t}" + NL + "     \t}" + NL + "" + NL + "   \treturn result;" + NL + "   }" + NL + "" + NL + "\tpublic byte[] toByteArray() {" + NL + " \t\tjava.io.ByteArrayOutputStream bao = null;" + NL + "\t\tjava.io.DataOutputStream dos = null;" + NL + "\t\tbyte[] result = null;" + NL + "" + NL + " \t\ttry {" + NL + "\t\t\tbao = new java.io.ByteArrayOutputStream();" + NL + "\t\t\tdos = new java.io.DataOutputStream(bao);";
  protected final String TEXT_97 = NL + "\t\t\tdos.write";
  protected final String TEXT_98 = "(this.";
  protected final String TEXT_99 = ");" + NL + "\t\t\t\t\t";
  protected final String TEXT_100 = NL + "\t\t\tif(this.";
  protected final String TEXT_101 = " == null) {" + NL + "\t\t\t\tdos.writeInt(-1);" + NL + "\t\t\t} else {" + NL + "\t\t\t\tbyte[] byteArray = this.";
  protected final String TEXT_102 = ".getBytes(utf8Charset);" + NL + "\t\t\t\tdos.writeInt(byteArray.length);" + NL + "\t\t\t\tdos.write(byteArray);" + NL + "\t\t\t}" + NL + "\t\t\t\t\t";
  protected final String TEXT_103 = " == null) {" + NL + "\t\t\t\tdos.writeInt(-1);" + NL + "\t\t\t} else {" + NL + "\t\t\t\tdos.writeInt(this.";
  protected final String TEXT_104 = ".length);" + NL + "\t\t\t\tdos.write(this.";
  protected final String TEXT_105 = ");" + NL + "\t\t\t}" + NL + "\t\t\t\t\t";
  protected final String TEXT_106 = " == null) {" + NL + "\t\t\t\tdos.writeByte(-1);" + NL + "\t\t\t} else {" + NL + "\t\t\t\tdos.writeByte(0);" + NL + "\t\t\t\tdos.writeLong(this.";
  protected final String TEXT_107 = ".getTime());" + NL + "\t\t\t}" + NL + "\t\t\t\t\t";
  protected final String TEXT_108 = " == null) {" + NL + "\t\t\t\tdos.writeInt(-1);" + NL + "\t\t\t} else {" + NL + "\t\t\t\tjava.io.ByteArrayOutputStream bao_";
  protected final String TEXT_109 = " = new java.io.ByteArrayOutputStream();" + NL + "            \tjava.io.ObjectOutputStream oos_";
  protected final String TEXT_110 = " = new java.io.ObjectOutputStream(bao_";
  protected final String TEXT_111 = ");" + NL + "            \toos_";
  protected final String TEXT_112 = ".writeObject(this.";
  protected final String TEXT_113 = ".close();" + NL + "            \tbyte[] byteArray = bao_";
  protected final String TEXT_114 = ".toByteArray();" + NL + "\t\t\t\tdos.writeInt(byteArray.length);" + NL + "\t\t\t\tdos.write(byteArray);" + NL + "\t\t\t}" + NL + "\t\t\t\t";
  protected final String TEXT_115 = " == null) {" + NL + "\t\t\t\tdos.writeByte(-1);" + NL + "\t\t\t} else {" + NL + "\t\t\t\tdos.writeByte(0);" + NL + "\t\t\t\tdos.write";
  protected final String TEXT_116 = NL + "    \t} catch (java.lang.Exception e) {" + NL + "globalMap.put(\"";
  protected final String TEXT_117 = "_ERROR_MESSAGE\",e.getMessage());" + NL + "     \t\tthrow new RuntimeException(e);" + NL + "\t\t} finally {" + NL + "     \t\tif (dos != null) {" + NL + "         \t\ttry {" + NL + "            \t\tdos.close();" + NL + "           \t\t} catch (java.io.IOException e) {" + NL + "        \t\t\te.printStackTrace();" + NL + "          \t\t}" + NL + "        \t}" + NL + "     \t}" + NL + "     \tresult = bao.toByteArray();" + NL + "    \treturn result;" + NL + "  \t}" + NL + "" + NL + "" + NL + "}" + NL + "// /////////////////////////////////";
  protected final String TEXT_118 = NL + "  java.io.File dir_";
  protected final String TEXT_119 = " = new java.io.File(";
  protected final String TEXT_120 = ");" + NL + "  if (!dir_";
  protected final String TEXT_121 = ".exists()){" + NL + "    dir_";
  protected final String TEXT_122 = ".mkdirs();" + NL + "  }" + NL + "  dir_";
  protected final String TEXT_123 = " = null;";
  protected final String TEXT_124 = NL + NL + "org.talend.designer.components.tsort.io.sortimpl.FlowSorterIterator<";
  protected final String TEXT_125 = "StructILightSerializable> iterator_";
  protected final String TEXT_126 = " = new org.talend.designer.components.tsort.io.sortimpl.FlowSorterIterator<";
  protected final String TEXT_127 = "StructILightSerializable>();" + NL + "iterator_";
  protected final String TEXT_128 = ".setBufferSize(";
  protected final String TEXT_129 = ");" + NL + "iterator_";
  protected final String TEXT_130 = ".setILightSerializable(new ";
  protected final String TEXT_131 = "StructILightSerializable());" + NL + "iterator_";
  protected final String TEXT_132 = ".workDirectory = ";
  protected final String TEXT_133 = " + \"/\" + jobName + \"";
  protected final String TEXT_134 = " _\" + Thread.currentThread().getId() + \"_\" + pid;" + NL + "iterator_";
  protected final String TEXT_135 = ".initPut(\"\");" + NL;

  public String generate(Object argument)
  {
    final StringBuffer stringBuffer = new StringBuffer();
    stringBuffer.append(TEXT_1);
    
CodeGeneratorArgument codeGenArgument = (CodeGeneratorArgument) argument;
INode node = (INode)codeGenArgument.getArgument();
String cid = node.getUniqueName();
String destination = ElementParameterParser.getValue(node, "__DESTINATION__");
String rowName= "";
if ((node.getIncomingConnections()!=null)&&(node.getIncomingConnections().size()>0)) {
	rowName = node.getIncomingConnections().get(0).getName();
} else {
	rowName="defaultRow";
}

List<Map<String, String>> criterias = (List<Map<String,String>>)ElementParameterParser.getObjectValue(node, "__CRITERIA__");

String isExternalSort = ElementParameterParser.getValue(node, "__EXTERNAL__");

final Integer SORT_NUM = 0;
final Integer SORT_ALPHA = 1;
final Integer SORT_DATE = 2;
final Integer SORT_ASC = Integer.MAX_VALUE;
final Integer SORT_DESC = Integer.MIN_VALUE;
List<String> listCols = new ArrayList<String>();
List<Integer> listCriterias = new ArrayList<Integer>();
List<Integer> listCriteriaTypes = new ArrayList<Integer>();
List<Boolean> listNullables = new ArrayList<Boolean>();
List<String> listPatterns = new ArrayList<String>();
List<JavaType> listColumnTypes = new ArrayList<JavaType>();
List<IMetadataTable> metadatas = node.getMetadataList();
if ((metadatas!=null)&&(metadatas.size()>0)) {
	IMetadataTable metadata = metadatas.get(0);
	if (metadata!=null) {
        for (int i = 0 ; i < criterias.size() ; i++) {
        	Map<String, String> line = criterias.get(i);
        	String colname = line.get("COLNAME");
        	if(listCols.contains(colname)){
        		continue;//skip dipulicate
        	}
        	listCols.add(colname);
        	if(("asc").equals(line.get("ORDER"))){
        		listCriterias.add(SORT_ASC);
        	}else{
        		listCriterias.add(SORT_DESC);
        	}
        	if(("num").equals(line.get("SORT"))){
        		listCriteriaTypes.add(SORT_NUM);
        	}else if(("alpha").equals(line.get("SORT"))){
        		listCriteriaTypes.add(SORT_ALPHA);
        	}else{
        		listCriteriaTypes.add(SORT_DATE);
        	}
    
        	for (IMetadataColumn column : metadata.getListColumns()) {
        		if (column.getLabel().compareTo(colname)==0) {
        			listColumnTypes.add(JavaTypesManager.getJavaTypeFromId(column.getTalendType()));
        			if(JavaTypesManager.isJavaPrimitiveType(column.getTalendType(), false)){
	        			listNullables.add(column.isNullable());
        			}else{
        				listNullables.add(true);
        			}
        			listPatterns.add(column.getPattern() == null || column.getPattern().trim().length() == 0 ? null : column.getPattern());
        			
        		}
        	}
    	}

    
    	for (int i = 0 ; i < listCols.size() ; i++) {
    		Integer criteriaType = listCriteriaTypes.get(i);
    		JavaType columnType = listColumnTypes.get(i);
    		if(criteriaType == SORT_NUM){
    			if(!columnType.isPrimitive()){
    				if("id_Dynamic".equals(columnType.getId()) || columnType == JavaTypesManager.LIST || columnType == JavaTypesManager.BYTE_ARRAY || columnType == JavaTypesManager.OBJECT || columnType == JavaTypesManager.STRING){

    stringBuffer.append(TEXT_2);
    stringBuffer.append(listCols.get(i) );
    stringBuffer.append(TEXT_3);
    
					}
				}
			}else if(criteriaType == SORT_DATE){
				if(columnType != JavaTypesManager.DATE){

    stringBuffer.append(TEXT_2);
    stringBuffer.append(listCols.get(i) );
    stringBuffer.append(TEXT_4);
    
				}
			}
		}

    stringBuffer.append(TEXT_5);
    
		if(("false").equals(isExternalSort)){
		//sort in memory begin

    stringBuffer.append(TEXT_6);
    stringBuffer.append(rowName );
    stringBuffer.append(TEXT_7);
    stringBuffer.append(rowName );
    stringBuffer.append(TEXT_8);
    stringBuffer.append(rowName );
    stringBuffer.append(TEXT_9);
    stringBuffer.append(rowName );
    stringBuffer.append(TEXT_10);
    
			for (int i = 0 ; i < listCols.size() ; i++) {
				String colname = listCols.get(i);	
				JavaType columnType = listColumnTypes.get(i);
				Integer criteriaType = listCriteriaTypes.get(i);
				Integer criteria = listCriterias.get(i);
				if(criteriaType == SORT_NUM){
					if("id_Dynamic".equals(columnType.getId())){
					} else if(listNullables.get(i)){//

    stringBuffer.append(TEXT_11);
    stringBuffer.append(colname );
    stringBuffer.append(TEXT_12);
    stringBuffer.append(colname );
    stringBuffer.append(TEXT_13);
    
						if(criteria == SORT_ASC){
						
    stringBuffer.append(TEXT_14);
    
						}else{
						
    stringBuffer.append(TEXT_15);
    
						}

    stringBuffer.append(TEXT_16);
    stringBuffer.append(colname );
    stringBuffer.append(TEXT_17);
    stringBuffer.append(colname );
    stringBuffer.append(TEXT_18);
    
						if(criteria == SORT_ASC){
						
    stringBuffer.append(TEXT_15);
    
						}else{
						
    stringBuffer.append(TEXT_14);
    
						}

    stringBuffer.append(TEXT_16);
    stringBuffer.append(colname );
    stringBuffer.append(TEXT_17);
    stringBuffer.append(colname );
    stringBuffer.append(TEXT_19);
    stringBuffer.append(colname );
    stringBuffer.append(TEXT_20);
    stringBuffer.append(colname );
    stringBuffer.append(TEXT_21);
    
						if(criteria == SORT_ASC){

    stringBuffer.append(TEXT_22);
    stringBuffer.append(colname );
    stringBuffer.append(TEXT_23);
    stringBuffer.append(colname );
    stringBuffer.append(TEXT_24);
    
						}else{

    stringBuffer.append(TEXT_25);
    stringBuffer.append(colname );
    stringBuffer.append(TEXT_26);
    stringBuffer.append(colname );
    stringBuffer.append(TEXT_24);
    
						}

    stringBuffer.append(TEXT_27);
    
					}else{//end tag for if(listNullables.get(i))
						if(columnType == JavaTypesManager.BOOLEAN){

    stringBuffer.append(TEXT_11);
    stringBuffer.append(colname );
    stringBuffer.append(TEXT_28);
    stringBuffer.append(colname );
    stringBuffer.append(TEXT_29);
    
							if(criteria == SORT_ASC){

    stringBuffer.append(TEXT_22);
    stringBuffer.append(colname );
    stringBuffer.append(TEXT_30);
    
							}else{

    stringBuffer.append(TEXT_22);
    stringBuffer.append(colname );
    stringBuffer.append(TEXT_31);
    
							}

    stringBuffer.append(TEXT_32);
    
						}else {

    stringBuffer.append(TEXT_11);
    stringBuffer.append(colname );
    stringBuffer.append(TEXT_28);
    stringBuffer.append(colname );
    stringBuffer.append(TEXT_33);
    
							if(criteria == SORT_ASC){
							
    stringBuffer.append(TEXT_22);
    stringBuffer.append(colname );
    stringBuffer.append(TEXT_34);
    stringBuffer.append(colname );
    stringBuffer.append(TEXT_35);
    
							}else{
							
    stringBuffer.append(TEXT_25);
    stringBuffer.append(colname );
    stringBuffer.append(TEXT_36);
    stringBuffer.append(colname );
    stringBuffer.append(TEXT_35);
    
							}
						
    stringBuffer.append(TEXT_32);
    
						}
					}//end of if(listNullables.get(i))
				}else if(criteriaType == SORT_ALPHA){//end tag for if(criteriaType == SORT_NUM)
					if(columnType == JavaTypesManager.BYTE_ARRAY){

    stringBuffer.append(TEXT_37);
    stringBuffer.append(colname );
    stringBuffer.append(TEXT_38);
    stringBuffer.append(colname );
    stringBuffer.append(TEXT_39);
    stringBuffer.append(colname );
    stringBuffer.append(TEXT_40);
    stringBuffer.append(colname );
    stringBuffer.append(TEXT_41);
    stringBuffer.append(colname );
    stringBuffer.append(TEXT_42);
    stringBuffer.append(colname );
    stringBuffer.append(TEXT_43);
    stringBuffer.append(colname );
    stringBuffer.append(TEXT_44);
    stringBuffer.append(colname );
    stringBuffer.append(TEXT_21);
    
							if(criteria == SORT_ASC){
							
    stringBuffer.append(TEXT_45);
    stringBuffer.append(colname );
    stringBuffer.append(TEXT_46);
    stringBuffer.append(colname );
    stringBuffer.append(TEXT_47);
    
							}else{
							
    stringBuffer.append(TEXT_48);
    stringBuffer.append(colname );
    stringBuffer.append(TEXT_49);
    stringBuffer.append(colname );
    stringBuffer.append(TEXT_47);
    
							}

    stringBuffer.append(TEXT_32);
    
					}else if(columnType == JavaTypesManager.DATE){

    stringBuffer.append(TEXT_50);
    stringBuffer.append(colname );
    stringBuffer.append(TEXT_38);
    stringBuffer.append(colname );
    stringBuffer.append(TEXT_51);
    stringBuffer.append(colname );
    stringBuffer.append(TEXT_52);
    stringBuffer.append(listPatterns.get(i) );
    stringBuffer.append(TEXT_53);
    stringBuffer.append(colname );
    stringBuffer.append(TEXT_41);
    stringBuffer.append(colname );
    stringBuffer.append(TEXT_54);
    stringBuffer.append(colname );
    stringBuffer.append(TEXT_52);
    stringBuffer.append(listPatterns.get(i) );
    stringBuffer.append(TEXT_55);
    stringBuffer.append(colname );
    stringBuffer.append(TEXT_44);
    stringBuffer.append(colname );
    stringBuffer.append(TEXT_21);
    
							if(criteria == SORT_ASC){
							
    stringBuffer.append(TEXT_56);
    stringBuffer.append(colname );
    stringBuffer.append(TEXT_46);
    stringBuffer.append(colname );
    stringBuffer.append(TEXT_47);
    
							}else{
							
    stringBuffer.append(TEXT_57);
    stringBuffer.append(colname );
    stringBuffer.append(TEXT_49);
    stringBuffer.append(colname );
    stringBuffer.append(TEXT_47);
    
							}

    stringBuffer.append(TEXT_58);
    
					}else if(columnType == JavaTypesManager.STRING){

    stringBuffer.append(TEXT_11);
    stringBuffer.append(colname );
    stringBuffer.append(TEXT_12);
    stringBuffer.append(colname );
    stringBuffer.append(TEXT_13);
    
							if(criteria == SORT_ASC){
						
    stringBuffer.append(TEXT_14);
    
							}else{
						
    stringBuffer.append(TEXT_15);
    
							}

    stringBuffer.append(TEXT_16);
    stringBuffer.append(colname );
    stringBuffer.append(TEXT_17);
    stringBuffer.append(colname );
    stringBuffer.append(TEXT_18);
    
							if(criteria == SORT_ASC){
						
    stringBuffer.append(TEXT_15);
    
							}else{
						
    stringBuffer.append(TEXT_14);
    
							}

    stringBuffer.append(TEXT_16);
    stringBuffer.append(colname );
    stringBuffer.append(TEXT_17);
    stringBuffer.append(colname );
    stringBuffer.append(TEXT_19);
    stringBuffer.append(colname );
    stringBuffer.append(TEXT_20);
    stringBuffer.append(colname );
    stringBuffer.append(TEXT_21);
    
							if(criteria == SORT_ASC){

    stringBuffer.append(TEXT_22);
    stringBuffer.append(colname );
    stringBuffer.append(TEXT_23);
    stringBuffer.append(colname );
    stringBuffer.append(TEXT_24);
    
							}else{

    stringBuffer.append(TEXT_25);
    stringBuffer.append(colname );
    stringBuffer.append(TEXT_26);
    stringBuffer.append(colname );
    stringBuffer.append(TEXT_24);
    
							}

    stringBuffer.append(TEXT_27);
    
					}else{
						if(listNullables.get(i)){

    stringBuffer.append(TEXT_37);
    stringBuffer.append(colname );
    stringBuffer.append(TEXT_38);
    stringBuffer.append(colname );
    stringBuffer.append(TEXT_59);
    stringBuffer.append(colname );
    stringBuffer.append(TEXT_40);
    stringBuffer.append(colname );
    stringBuffer.append(TEXT_41);
    stringBuffer.append(colname );
    stringBuffer.append(TEXT_60);
    stringBuffer.append(colname );
    stringBuffer.append(TEXT_43);
    stringBuffer.append(colname );
    stringBuffer.append(TEXT_44);
    stringBuffer.append(colname );
    stringBuffer.append(TEXT_21);
    
							if(criteria == SORT_ASC){
							
    stringBuffer.append(TEXT_45);
    stringBuffer.append(colname );
    stringBuffer.append(TEXT_46);
    stringBuffer.append(colname );
    stringBuffer.append(TEXT_47);
    
							}else{
							
    stringBuffer.append(TEXT_48);
    stringBuffer.append(colname );
    stringBuffer.append(TEXT_49);
    stringBuffer.append(colname );
    stringBuffer.append(TEXT_47);
    
							}

    stringBuffer.append(TEXT_32);
    
						}else{

    stringBuffer.append(TEXT_37);
    stringBuffer.append(colname );
    stringBuffer.append(TEXT_61);
    stringBuffer.append(colname );
    stringBuffer.append(TEXT_40);
    stringBuffer.append(colname );
    stringBuffer.append(TEXT_62);
    stringBuffer.append(colname );
    stringBuffer.append(TEXT_43);
    stringBuffer.append(colname );
    stringBuffer.append(TEXT_44);
    stringBuffer.append(colname );
    stringBuffer.append(TEXT_21);
    
							if(criteria == SORT_ASC){
							
    stringBuffer.append(TEXT_45);
    stringBuffer.append(colname );
    stringBuffer.append(TEXT_46);
    stringBuffer.append(colname );
    stringBuffer.append(TEXT_47);
    
							}else{
							
    stringBuffer.append(TEXT_48);
    stringBuffer.append(colname );
    stringBuffer.append(TEXT_49);
    stringBuffer.append(colname );
    stringBuffer.append(TEXT_47);
    
							}

    stringBuffer.append(TEXT_32);
    
						}
					}
				}else if(!"id_Dynamic".equals(columnType.getId())){//end tag for if(criteriaType == SORT_ALPHA) for SORT_DATE

    stringBuffer.append(TEXT_11);
    stringBuffer.append(colname );
    stringBuffer.append(TEXT_12);
    stringBuffer.append(colname );
    stringBuffer.append(TEXT_13);
    
							if(criteria == SORT_ASC){
						
    stringBuffer.append(TEXT_14);
    
							}else{
						
    stringBuffer.append(TEXT_15);
    
							}

    stringBuffer.append(TEXT_16);
    stringBuffer.append(colname );
    stringBuffer.append(TEXT_17);
    stringBuffer.append(colname );
    stringBuffer.append(TEXT_18);
    
							if(criteria == SORT_ASC){
						
    stringBuffer.append(TEXT_15);
    
							}else{
						
    stringBuffer.append(TEXT_14);
    
							}

    stringBuffer.append(TEXT_16);
    stringBuffer.append(colname );
    stringBuffer.append(TEXT_17);
    stringBuffer.append(colname );
    stringBuffer.append(TEXT_19);
    stringBuffer.append(colname );
    stringBuffer.append(TEXT_20);
    stringBuffer.append(colname );
    stringBuffer.append(TEXT_21);
    
							if(criteria == SORT_ASC){

    stringBuffer.append(TEXT_22);
    stringBuffer.append(colname );
    stringBuffer.append(TEXT_23);
    stringBuffer.append(colname );
    stringBuffer.append(TEXT_24);
    
							}else{

    stringBuffer.append(TEXT_25);
    stringBuffer.append(colname );
    stringBuffer.append(TEXT_26);
    stringBuffer.append(colname );
    stringBuffer.append(TEXT_24);
    
							}

    stringBuffer.append(TEXT_27);
    
				}//end of if(criteriaType == SORT_NUM)
			}

    stringBuffer.append(TEXT_63);
    stringBuffer.append(rowName );
    stringBuffer.append(TEXT_64);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_65);
    stringBuffer.append(rowName );
    stringBuffer.append(TEXT_66);
    
		//sort in memory end
		}else{
		//sort out of memory begin
			String tempDirectory = ElementParameterParser.getValue(node, "__TEMPFILE__");
			String bufferSize = ElementParameterParser.getValue(node, "__EXTERNAL_SORT_BUFFERSIZE__");
			boolean bCreateDir = "true".equals(ElementParameterParser.getValue(node, "__CREATEDIR__"));

    stringBuffer.append(TEXT_67);
    stringBuffer.append(rowName );
    stringBuffer.append(TEXT_68);
    stringBuffer.append(rowName );
    stringBuffer.append(TEXT_69);
    stringBuffer.append(rowName );
    stringBuffer.append(TEXT_70);
    stringBuffer.append(rowName );
    stringBuffer.append(TEXT_71);
    
			for (int i = 0 ; i < listCols.size() ; i++) {
				String colname = listCols.get(i);	
				JavaType columnType = listColumnTypes.get(i);
				Integer criteriaType = listCriteriaTypes.get(i);
				Integer criteria = listCriterias.get(i);
				if(criteriaType == SORT_NUM){
					if("id_Dynamic".equals(columnType.getId())){
					} else if(listNullables.get(i)){//

    stringBuffer.append(TEXT_11);
    stringBuffer.append(colname );
    stringBuffer.append(TEXT_12);
    stringBuffer.append(colname );
    stringBuffer.append(TEXT_13);
    
						if(criteria == SORT_ASC){
						
    stringBuffer.append(TEXT_14);
    
						}else{
						
    stringBuffer.append(TEXT_15);
    
						}

    stringBuffer.append(TEXT_16);
    stringBuffer.append(colname );
    stringBuffer.append(TEXT_17);
    stringBuffer.append(colname );
    stringBuffer.append(TEXT_18);
    
						if(criteria == SORT_ASC){
						
    stringBuffer.append(TEXT_15);
    
						}else{
						
    stringBuffer.append(TEXT_14);
    
						}

    stringBuffer.append(TEXT_16);
    stringBuffer.append(colname );
    stringBuffer.append(TEXT_17);
    stringBuffer.append(colname );
    stringBuffer.append(TEXT_19);
    stringBuffer.append(colname );
    stringBuffer.append(TEXT_20);
    stringBuffer.append(colname );
    stringBuffer.append(TEXT_21);
    
						if(criteria == SORT_ASC){

    stringBuffer.append(TEXT_22);
    stringBuffer.append(colname );
    stringBuffer.append(TEXT_23);
    stringBuffer.append(colname );
    stringBuffer.append(TEXT_24);
    
						}else{

    stringBuffer.append(TEXT_25);
    stringBuffer.append(colname );
    stringBuffer.append(TEXT_26);
    stringBuffer.append(colname );
    stringBuffer.append(TEXT_24);
    
						}

    stringBuffer.append(TEXT_27);
    
					}else{//end tag for if(listNullables.get(i))
						if(columnType == JavaTypesManager.BOOLEAN){

    stringBuffer.append(TEXT_11);
    stringBuffer.append(colname );
    stringBuffer.append(TEXT_28);
    stringBuffer.append(colname );
    stringBuffer.append(TEXT_29);
    
							if(criteria == SORT_ASC){

    stringBuffer.append(TEXT_22);
    stringBuffer.append(colname );
    stringBuffer.append(TEXT_30);
    
							}else{

    stringBuffer.append(TEXT_22);
    stringBuffer.append(colname );
    stringBuffer.append(TEXT_72);
    
							}

    stringBuffer.append(TEXT_32);
    
						}else {

    stringBuffer.append(TEXT_11);
    stringBuffer.append(colname );
    stringBuffer.append(TEXT_28);
    stringBuffer.append(colname );
    stringBuffer.append(TEXT_33);
    
							if(criteria == SORT_ASC){
							
    stringBuffer.append(TEXT_22);
    stringBuffer.append(colname );
    stringBuffer.append(TEXT_34);
    stringBuffer.append(colname );
    stringBuffer.append(TEXT_35);
    
							}else{
							
    stringBuffer.append(TEXT_25);
    stringBuffer.append(colname );
    stringBuffer.append(TEXT_36);
    stringBuffer.append(colname );
    stringBuffer.append(TEXT_35);
    
							}
						
    stringBuffer.append(TEXT_32);
    
						}
					}//end of if(listNullables.get(i))
				}else if(criteriaType == SORT_ALPHA){//end tag for if(criteriaType == SORT_NUM)
					if(columnType == JavaTypesManager.BYTE_ARRAY){

    stringBuffer.append(TEXT_37);
    stringBuffer.append(colname );
    stringBuffer.append(TEXT_38);
    stringBuffer.append(colname );
    stringBuffer.append(TEXT_39);
    stringBuffer.append(colname );
    stringBuffer.append(TEXT_40);
    stringBuffer.append(colname );
    stringBuffer.append(TEXT_41);
    stringBuffer.append(colname );
    stringBuffer.append(TEXT_42);
    stringBuffer.append(colname );
    stringBuffer.append(TEXT_43);
    stringBuffer.append(colname );
    stringBuffer.append(TEXT_44);
    stringBuffer.append(colname );
    stringBuffer.append(TEXT_21);
    
							if(criteria == SORT_ASC){
							
    stringBuffer.append(TEXT_45);
    stringBuffer.append(colname );
    stringBuffer.append(TEXT_46);
    stringBuffer.append(colname );
    stringBuffer.append(TEXT_47);
    
							}else{
							
    stringBuffer.append(TEXT_48);
    stringBuffer.append(colname );
    stringBuffer.append(TEXT_49);
    stringBuffer.append(colname );
    stringBuffer.append(TEXT_47);
    
							}

    stringBuffer.append(TEXT_32);
    
					}else if(columnType == JavaTypesManager.DATE){

    stringBuffer.append(TEXT_50);
    stringBuffer.append(colname );
    stringBuffer.append(TEXT_38);
    stringBuffer.append(colname );
    stringBuffer.append(TEXT_51);
    stringBuffer.append(colname );
    stringBuffer.append(TEXT_52);
    stringBuffer.append(listPatterns.get(i) );
    stringBuffer.append(TEXT_53);
    stringBuffer.append(colname );
    stringBuffer.append(TEXT_41);
    stringBuffer.append(colname );
    stringBuffer.append(TEXT_54);
    stringBuffer.append(colname );
    stringBuffer.append(TEXT_52);
    stringBuffer.append(listPatterns.get(i) );
    stringBuffer.append(TEXT_55);
    stringBuffer.append(colname );
    stringBuffer.append(TEXT_44);
    stringBuffer.append(colname );
    stringBuffer.append(TEXT_21);
    
							if(criteria == SORT_ASC){
							
    stringBuffer.append(TEXT_56);
    stringBuffer.append(colname );
    stringBuffer.append(TEXT_46);
    stringBuffer.append(colname );
    stringBuffer.append(TEXT_47);
    
							}else{
							
    stringBuffer.append(TEXT_57);
    stringBuffer.append(colname );
    stringBuffer.append(TEXT_49);
    stringBuffer.append(colname );
    stringBuffer.append(TEXT_47);
    
							}

    stringBuffer.append(TEXT_58);
    
					}else if(columnType == JavaTypesManager.STRING){

    stringBuffer.append(TEXT_11);
    stringBuffer.append(colname );
    stringBuffer.append(TEXT_12);
    stringBuffer.append(colname );
    stringBuffer.append(TEXT_13);
    
							if(criteria == SORT_ASC){
						
    stringBuffer.append(TEXT_14);
    
							}else{
						
    stringBuffer.append(TEXT_15);
    
							}

    stringBuffer.append(TEXT_16);
    stringBuffer.append(colname );
    stringBuffer.append(TEXT_17);
    stringBuffer.append(colname );
    stringBuffer.append(TEXT_18);
    
							if(criteria == SORT_ASC){
						
    stringBuffer.append(TEXT_15);
    
							}else{
						
    stringBuffer.append(TEXT_14);
    
							}

    stringBuffer.append(TEXT_16);
    stringBuffer.append(colname );
    stringBuffer.append(TEXT_17);
    stringBuffer.append(colname );
    stringBuffer.append(TEXT_19);
    stringBuffer.append(colname );
    stringBuffer.append(TEXT_20);
    stringBuffer.append(colname );
    stringBuffer.append(TEXT_21);
    
							if(criteria == SORT_ASC){

    stringBuffer.append(TEXT_22);
    stringBuffer.append(colname );
    stringBuffer.append(TEXT_23);
    stringBuffer.append(colname );
    stringBuffer.append(TEXT_24);
    
							}else{

    stringBuffer.append(TEXT_25);
    stringBuffer.append(colname );
    stringBuffer.append(TEXT_26);
    stringBuffer.append(colname );
    stringBuffer.append(TEXT_24);
    
							}

    stringBuffer.append(TEXT_27);
    
					}else{
						if(listNullables.get(i)){

    stringBuffer.append(TEXT_37);
    stringBuffer.append(colname );
    stringBuffer.append(TEXT_38);
    stringBuffer.append(colname );
    stringBuffer.append(TEXT_59);
    stringBuffer.append(colname );
    stringBuffer.append(TEXT_40);
    stringBuffer.append(colname );
    stringBuffer.append(TEXT_41);
    stringBuffer.append(colname );
    stringBuffer.append(TEXT_60);
    stringBuffer.append(colname );
    stringBuffer.append(TEXT_43);
    stringBuffer.append(colname );
    stringBuffer.append(TEXT_44);
    stringBuffer.append(colname );
    stringBuffer.append(TEXT_21);
    
							if(criteria == SORT_ASC){
							
    stringBuffer.append(TEXT_45);
    stringBuffer.append(colname );
    stringBuffer.append(TEXT_46);
    stringBuffer.append(colname );
    stringBuffer.append(TEXT_47);
    
							}else{
							
    stringBuffer.append(TEXT_48);
    stringBuffer.append(colname );
    stringBuffer.append(TEXT_49);
    stringBuffer.append(colname );
    stringBuffer.append(TEXT_47);
    
							}

    stringBuffer.append(TEXT_32);
    
						}else{

    stringBuffer.append(TEXT_37);
    stringBuffer.append(colname );
    stringBuffer.append(TEXT_61);
    stringBuffer.append(colname );
    stringBuffer.append(TEXT_40);
    stringBuffer.append(colname );
    stringBuffer.append(TEXT_62);
    stringBuffer.append(colname );
    stringBuffer.append(TEXT_43);
    stringBuffer.append(colname );
    stringBuffer.append(TEXT_44);
    stringBuffer.append(colname );
    stringBuffer.append(TEXT_21);
    
							if(criteria == SORT_ASC){
							
    stringBuffer.append(TEXT_45);
    stringBuffer.append(colname );
    stringBuffer.append(TEXT_46);
    stringBuffer.append(colname );
    stringBuffer.append(TEXT_47);
    
							}else{
							
    stringBuffer.append(TEXT_48);
    stringBuffer.append(colname );
    stringBuffer.append(TEXT_49);
    stringBuffer.append(colname );
    stringBuffer.append(TEXT_47);
    
							}

    stringBuffer.append(TEXT_32);
    
						}
					}
				}else if(!"id_Dynamic".equals(columnType.getId())){//end tag for if(criteriaType == SORT_ALPHA) for SORT_DATE

    stringBuffer.append(TEXT_11);
    stringBuffer.append(colname );
    stringBuffer.append(TEXT_12);
    stringBuffer.append(colname );
    stringBuffer.append(TEXT_13);
    
							if(criteria == SORT_ASC){
						
    stringBuffer.append(TEXT_14);
    
							}else{
						
    stringBuffer.append(TEXT_15);
    
							}

    stringBuffer.append(TEXT_16);
    stringBuffer.append(colname );
    stringBuffer.append(TEXT_17);
    stringBuffer.append(colname );
    stringBuffer.append(TEXT_18);
    
							if(criteria == SORT_ASC){
						
    stringBuffer.append(TEXT_15);
    
							}else{
						
    stringBuffer.append(TEXT_14);
    
							}

    stringBuffer.append(TEXT_16);
    stringBuffer.append(colname );
    stringBuffer.append(TEXT_17);
    stringBuffer.append(colname );
    stringBuffer.append(TEXT_19);
    stringBuffer.append(colname );
    stringBuffer.append(TEXT_20);
    stringBuffer.append(colname );
    stringBuffer.append(TEXT_21);
    
							if(criteria == SORT_ASC){

    stringBuffer.append(TEXT_22);
    stringBuffer.append(colname );
    stringBuffer.append(TEXT_23);
    stringBuffer.append(colname );
    stringBuffer.append(TEXT_24);
    
							}else{

    stringBuffer.append(TEXT_25);
    stringBuffer.append(colname );
    stringBuffer.append(TEXT_26);
    stringBuffer.append(colname );
    stringBuffer.append(TEXT_24);
    
							}

    stringBuffer.append(TEXT_27);
    
				}//end of if(criteriaType == SORT_NUM)
			}

    stringBuffer.append(TEXT_73);
    stringBuffer.append(rowName );
    stringBuffer.append(TEXT_74);
    stringBuffer.append(rowName );
    stringBuffer.append(TEXT_75);
    
		if (metadata !=null) {
			for (IMetadataColumn column: metadata.getListColumns()) {
				JavaType javaType = JavaTypesManager.getJavaTypeFromId(column.getTalendType());
			 	String typeToGenerate = JavaTypesManager.getTypeToGenerate(column.getTalendType(), column.isNullable());
				if (JavaTypesManager.isJavaPrimitiveType(column.getTalendType(), column.isNullable())) {
					typeToGenerate=typeToGenerate.substring(0,1).toUpperCase()+typeToGenerate.substring(1);
					
    stringBuffer.append(TEXT_76);
    stringBuffer.append(column.getLabel() );
    stringBuffer.append(TEXT_77);
    stringBuffer.append( typeToGenerate );
    stringBuffer.append(TEXT_78);
    
				} else if(("String").equals(typeToGenerate)) {
					
    stringBuffer.append(TEXT_79);
    stringBuffer.append(column.getLabel() );
    stringBuffer.append(TEXT_80);
    stringBuffer.append(column.getLabel() );
    stringBuffer.append(TEXT_81);
    
				} else if(("byte[]").equals(typeToGenerate)) {
					
    stringBuffer.append(TEXT_79);
    stringBuffer.append(column.getLabel() );
    stringBuffer.append(TEXT_80);
    stringBuffer.append(column.getLabel() );
    stringBuffer.append(TEXT_82);
    
				} else if(("java.util.Date").equals(typeToGenerate)) {
					
    stringBuffer.append(TEXT_83);
    stringBuffer.append(column.getLabel() );
    stringBuffer.append(TEXT_84);
    stringBuffer.append(column.getLabel() );
    stringBuffer.append(TEXT_85);
    
				} else if(("id_Dynamic").equals(column.getTalendType()) || ("Object").equals(typeToGenerate) || ("BigDecimal").equals(typeToGenerate) || ("List").equals(typeToGenerate)) {
					
    stringBuffer.append(TEXT_79);
    stringBuffer.append(column.getLabel() );
    stringBuffer.append(TEXT_86);
    stringBuffer.append(column.getLabel() );
    stringBuffer.append(TEXT_87);
    stringBuffer.append(column.getLabel() );
    stringBuffer.append(TEXT_88);
    stringBuffer.append(column.getLabel() );
    stringBuffer.append(TEXT_89);
    stringBuffer.append(column.getLabel() );
    stringBuffer.append(TEXT_90);
    stringBuffer.append( typeToGenerate );
    stringBuffer.append(TEXT_91);
    stringBuffer.append(column.getLabel() );
    stringBuffer.append(TEXT_92);
    stringBuffer.append(column.getLabel() );
    stringBuffer.append(TEXT_93);
    
				} else {
					typeToGenerate =JavaTypesManager.getTypeToGenerate(column.getTalendType(), false);
					typeToGenerate=typeToGenerate.substring(0,1).toUpperCase()+typeToGenerate.substring(1);
					
    stringBuffer.append(TEXT_83);
    stringBuffer.append(column.getLabel() );
    stringBuffer.append(TEXT_84);
    stringBuffer.append(column.getLabel() );
    stringBuffer.append(TEXT_77);
    stringBuffer.append( typeToGenerate );
    stringBuffer.append(TEXT_94);
    
				}
			}
    	}

    stringBuffer.append(TEXT_95);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_96);
    	
		if (metadata !=null) {
			for (IMetadataColumn column: metadata.getListColumns()) {
				JavaType javaType = JavaTypesManager.getJavaTypeFromId(column.getTalendType());
			 	String typeToGenerate = JavaTypesManager.getTypeToGenerate(column.getTalendType(), column.isNullable());
				if (JavaTypesManager.isJavaPrimitiveType(column.getTalendType(), column.isNullable())) {
					typeToGenerate=typeToGenerate.substring(0,1).toUpperCase()+typeToGenerate.substring(1);
					
    stringBuffer.append(TEXT_97);
    stringBuffer.append( typeToGenerate );
    stringBuffer.append(TEXT_98);
    stringBuffer.append(column.getLabel() );
    stringBuffer.append(TEXT_99);
    
				} else if(("String").equals(typeToGenerate)) {
					
    stringBuffer.append(TEXT_100);
    stringBuffer.append(column.getLabel() );
    stringBuffer.append(TEXT_101);
    stringBuffer.append(column.getLabel() );
    stringBuffer.append(TEXT_102);
    
				} else if(("byte[]").equals(typeToGenerate)) {
					
    stringBuffer.append(TEXT_100);
    stringBuffer.append(column.getLabel() );
    stringBuffer.append(TEXT_103);
    stringBuffer.append(column.getLabel() );
    stringBuffer.append(TEXT_104);
    stringBuffer.append(column.getLabel() );
    stringBuffer.append(TEXT_105);
    
				} else if(("java.util.Date").equals(typeToGenerate)) {
					
    stringBuffer.append(TEXT_100);
    stringBuffer.append(column.getLabel() );
    stringBuffer.append(TEXT_106);
    stringBuffer.append(column.getLabel() );
    stringBuffer.append(TEXT_107);
    
				} else if(("id_Dynamic").equals(column.getTalendType()) || ("Object").equals(typeToGenerate) || ("BigDecimal").equals(typeToGenerate) || ("List").equals(typeToGenerate)) {
					
    stringBuffer.append(TEXT_100);
    stringBuffer.append(column.getLabel() );
    stringBuffer.append(TEXT_108);
    stringBuffer.append(column.getLabel() );
    stringBuffer.append(TEXT_109);
    stringBuffer.append(column.getLabel() );
    stringBuffer.append(TEXT_110);
    stringBuffer.append(column.getLabel() );
    stringBuffer.append(TEXT_111);
    stringBuffer.append(column.getLabel() );
    stringBuffer.append(TEXT_112);
    stringBuffer.append(column.getLabel() );
    stringBuffer.append(TEXT_111);
    stringBuffer.append(column.getLabel() );
    stringBuffer.append(TEXT_113);
    stringBuffer.append(column.getLabel() );
    stringBuffer.append(TEXT_114);
    
				} else {
					typeToGenerate =JavaTypesManager.getTypeToGenerate(column.getTalendType(), false);
					typeToGenerate = typeToGenerate.substring(0,1).toUpperCase()+typeToGenerate.substring(1);
					
    stringBuffer.append(TEXT_100);
    stringBuffer.append(column.getLabel() );
    stringBuffer.append(TEXT_115);
    stringBuffer.append(typeToGenerate );
    stringBuffer.append(TEXT_98);
    stringBuffer.append(column.getLabel() );
    stringBuffer.append(TEXT_105);
    
				
				}
			}
    	}
    	
    stringBuffer.append(TEXT_116);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_117);
    
//create directory if doesn't exist
if (bCreateDir){

    stringBuffer.append(TEXT_118);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_119);
    stringBuffer.append(tempDirectory );
    stringBuffer.append(TEXT_120);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_121);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_122);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_123);
    
}

    stringBuffer.append(TEXT_124);
    stringBuffer.append(rowName );
    stringBuffer.append(TEXT_125);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_126);
    stringBuffer.append(rowName );
    stringBuffer.append(TEXT_127);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_128);
    stringBuffer.append(bufferSize );
    stringBuffer.append(TEXT_129);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_130);
    stringBuffer.append(rowName );
    stringBuffer.append(TEXT_131);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_132);
    stringBuffer.append(tempDirectory );
    stringBuffer.append(TEXT_133);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_134);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_135);
    
		//sort out of memory end
		}
	}
}

    stringBuffer.append(TEXT_5);
    return stringBuffer.toString();
  }
}
