package org.talend.designer.codegen.translators.file.output;

import org.talend.core.model.process.INode;
import org.talend.core.model.metadata.IMetadataTable;
import org.talend.designer.codegen.config.CodeGeneratorArgument;
import org.talend.core.model.process.ElementParameterParser;
import java.util.List;
import org.talend.core.model.process.IProcess;
import org.talend.core.model.utils.NodeUtil;
import org.talend.core.model.process.AbstractNode;

public class TFileOutputDelimitedFinallyJava
{
  protected static String nl;
  public static synchronized TFileOutputDelimitedFinallyJava create(String lineSeparator)
  {
    nl = lineSeparator;
    TFileOutputDelimitedFinallyJava result = new TFileOutputDelimitedFinallyJava();
    nl = null;
    return result;
  }

  public final String NL = nl == null ? (System.getProperties().getProperty("line.separator")) : nl;
  protected final String TEXT_1 = "";
  protected final String TEXT_2 = NL;
  protected final String TEXT_3 = NL + "\t\tif(resourceMap.get(\"finish_";
  protected final String TEXT_4 = "\") == null){ " + NL + "\t\t\t";
  protected final String TEXT_5 = NL + "\t\t   \t\tsynchronized (multiThreadLockWrite) {" + NL + "\t\t\t";
  protected final String TEXT_6 = NL + "\t\t\t\tsynchronized ((Object[])globalMap.get(\"lockWrite_";
  protected final String TEXT_7 = "\")) {" + NL + "\t\t\t";
  protected final String TEXT_8 = NL + "\t\t\t\tObject[] pLockWrite = (Object[])globalMap.get(\"PARALLEL_LOCK_WRITE\");" + NL + "\t\t\t\tsynchronized (pLockWrite) {" + NL + "\t\t\t";
  protected final String TEXT_9 = NL + "\t\t\t\t";
  protected final String TEXT_10 = NL + "\t\t\t\t\t\tjava.io.Writer out";
  protected final String TEXT_11 = " = (java.io.Writer)resourceMap.get(\"out_";
  protected final String TEXT_12 = "\");" + NL + "\t\t\t\t\t\tif(out";
  protected final String TEXT_13 = "!=null) {" + NL + "\t\t\t\t\t\t\tout";
  protected final String TEXT_14 = ".flush();" + NL + "\t\t\t\t\t\t\tout";
  protected final String TEXT_15 = ".close();" + NL + "\t\t\t\t\t\t}" + NL + "\t\t\t\t\t";
  protected final String TEXT_16 = "\");" + NL + "\t\t\t\t\t\tjava.io.OutputStreamWriter writer_";
  protected final String TEXT_17 = " = (java.io.OutputStreamWriter)resourceMap.get(\"writer_";
  protected final String TEXT_18 = ".flush();" + NL + "\t\t\t\t\t\t\twriter_";
  protected final String TEXT_19 = " = null;" + NL + "\t\t\t\t\t\t}" + NL + "\t\t\t\t\t";
  protected final String TEXT_20 = NL + "\t\t\t" + NL + "\t\t\t\t\tcom.talend.csv.CSVWriter CsvWriter";
  protected final String TEXT_21 = " = (com.talend.csv.CSVWriter)resourceMap.get(\"CsvWriter_";
  protected final String TEXT_22 = "\");" + NL + "\t\t\t\t\t";
  protected final String TEXT_23 = NL + "\t\t\t\t\t\tif(CsvWriter";
  protected final String TEXT_24 = "!=null) {" + NL + "\t\t\t\t\t    \tCsvWriter";
  protected final String TEXT_25 = ".close();" + NL + "\t\t\t\t\t    }" + NL + "\t\t\t\t\t\t";
  protected final String TEXT_26 = NL + "\t\t\t\t\t\t\tjava.io.Writer out";
  protected final String TEXT_27 = "\");" + NL + "\t\t\t\t\t\t\tif(out";
  protected final String TEXT_28 = "!=null) {" + NL + "\t\t\t\t\t\t\t\tout";
  protected final String TEXT_29 = ".flush();" + NL + "\t\t\t\t\t\t\t\tout";
  protected final String TEXT_30 = ".close();" + NL + "\t\t\t\t\t\t\t}" + NL + "\t\t\t\t\t\t";
  protected final String TEXT_31 = NL + "\t\t\t\t\t\t\tif(CsvWriter";
  protected final String TEXT_32 = "!=null) {" + NL + "\t\t\t\t\t\t\t\tCsvWriter";
  protected final String TEXT_33 = ".close();" + NL + "\t\t\t\t\t\t\t}" + NL + "\t\t\t\t\t\t\tjava.io.Writer out";
  protected final String TEXT_34 = ".flush();" + NL + "\t\t\t\t\t\t\t}" + NL + "\t\t\t\t\t\t\tjava.io.OutputStreamWriter outWriter_";
  protected final String TEXT_35 = " = (java.io.OutputStreamWriter)resourceMap.get(\"outWriter_";
  protected final String TEXT_36 = "\");" + NL + "\t\t\t\t\t\t\tif(outWriter_";
  protected final String TEXT_37 = "!=null) {" + NL + "\t\t\t\t\t\t\t\toutWriter_";
  protected final String TEXT_38 = ".flush();" + NL + "\t\t\t\t\t\t\t}" + NL + "\t\t\t\t\t\t";
  protected final String TEXT_39 = ".flush();" + NL + "\t\t\t\t\t\t\t}" + NL + "\t\t\t\t\t\t\tjava.io.BufferedWriter bufferWriter_";
  protected final String TEXT_40 = " = (java.io.BufferedWriter)resourceMap.get(\"bufferWriter_";
  protected final String TEXT_41 = "\");" + NL + "\t\t\t\t\t\t\tif(bufferWriter_";
  protected final String TEXT_42 = "!=null) {" + NL + "\t\t\t\t\t\t\t\tbufferWriter_";
  protected final String TEXT_43 = ".flush();" + NL + "\t\t\t\t\t\t\t}" + NL + "\t\t\t\t\t\t\tCsvWriter";
  protected final String TEXT_44 = " = null;" + NL + "\t\t\t\t\t\t";
  protected final String TEXT_45 = NL + "\t\t\t\t}" + NL + "\t\t\t";
  protected final String TEXT_46 = NL + "\t\t\t";
  protected final String TEXT_47 = NL + "\t\t\t\tif(Boolean.valueOf(String.valueOf(resourceMap.get(\"isFileGenerated_";
  protected final String TEXT_48 = "\"))) && Integer.valueOf(String.valueOf(resourceMap.get(\"nb_line_";
  protected final String TEXT_49 = "\"))) == 0){" + NL + "\t\t\t\t\t";
  protected final String TEXT_50 = NL + "\t\t\t\t\t\t((java.io.File)resourceMap.get(\"file_";
  protected final String TEXT_51 = "\")).delete();" + NL + "\t\t\t\t\t";
  protected final String TEXT_52 = NL + "\t\t\t\t\t\t((java.io.File)resourceMap.get(\"file";
  protected final String TEXT_53 = NL + "\t\t\t\t}\t\t" + NL + "\t\t\t";
  protected final String TEXT_54 = NL + "\t\t}" + NL + "\t";

  public String generate(Object argument)
  {
    final StringBuffer stringBuffer = new StringBuffer();
    stringBuffer.append(TEXT_1);
     
    CodeGeneratorArgument codeGenArgument = (CodeGeneratorArgument) argument;
    INode node = (INode)codeGenArgument.getArgument();
    String cid = node.getUniqueName();
    boolean useStream = ("true").equals(ElementParameterParser.getValue(node,"__USESTREAM__"));
    boolean isInRowMode = ("true").equals(ElementParameterParser.getValue(node,"__ROW_MODE__"));
    
    String filename = ElementParameterParser.getValue(node,"__FILENAME__");
	boolean isDeleteEmptyFile = ("true").equals(ElementParameterParser.getValue(node, "__DELETE_EMPTYFILE__")); 
	boolean isAppend = ("true").equals(ElementParameterParser.getValue(node,"__APPEND__"));
	
	boolean compress = ("true").equals(ElementParameterParser.getValue(node,"__COMPRESS__"));
	
	String parallelize = ElementParameterParser.getValue(node,"__PARALLELIZE__");
	boolean isParallelize = (parallelize!=null&&!("").equals(parallelize))?("true").equals(parallelize):false;
	
	boolean split = ("true").equals(ElementParameterParser.getValue(node, "__SPLIT__"));
	IProcess process = node.getProcess();

    stringBuffer.append(TEXT_2);
    
List<IMetadataTable> metadatas = node.getMetadataList();
if ((metadatas!=null)&&(metadatas.size()>0)) {
	IMetadataTable metadata = metadatas.get(0);
	if (metadata!=null) {
	
    stringBuffer.append(TEXT_3);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_4);
     
		    if(codeGenArgument.getIsRunInMultiThread()){
			
    stringBuffer.append(TEXT_5);
    
			}
			if (((AbstractNode)node).getParallelIterator() != null) {
			
    stringBuffer.append(TEXT_6);
    stringBuffer.append(((AbstractNode)node).getParallelIterator());
    stringBuffer.append(TEXT_7);
     
			}
			if (isParallelize) {
			
    stringBuffer.append(TEXT_8);
     
			}
			
    stringBuffer.append(TEXT_9);
    
				//////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
				if(("false").equals(ElementParameterParser.getValue(node,"__CSV_OPTION__"))) {	
				//////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
					if(!useStream){
					
    stringBuffer.append(TEXT_10);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_11);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_12);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_13);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_14);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_15);
    
					}else{
					
    stringBuffer.append(TEXT_10);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_11);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_16);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_17);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_12);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_13);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_18);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_14);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_19);
    
					}
					
    stringBuffer.append(TEXT_9);
    
				//////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
				}else{//the following is the tFileOutputCSV component
				//////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
				
    stringBuffer.append(TEXT_20);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_21);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_22);
    
					if(!useStream){
					
    stringBuffer.append(TEXT_23);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_24);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_25);
    
						if(isInRowMode){
						
    stringBuffer.append(TEXT_26);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_11);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_27);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_28);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_29);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_30);
    
						}
					}else{
						if(isInRowMode){
						
    stringBuffer.append(TEXT_31);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_32);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_33);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_11);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_27);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_28);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_34);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_35);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_36);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_37);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_38);
    
						}else{
						
    stringBuffer.append(TEXT_31);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_32);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_39);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_40);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_41);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_42);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_34);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_35);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_36);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_37);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_43);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_44);
    
						}
					}
				}
			if (isParallelize) {
			
    stringBuffer.append(TEXT_45);
    
			}
			if (((AbstractNode)node).getParallelIterator() != null) {
			
    stringBuffer.append(TEXT_45);
     
			}
			if(codeGenArgument.getIsRunInMultiThread()){
			
    stringBuffer.append(TEXT_45);
    
			}
			
    stringBuffer.append(TEXT_46);
    if(!useStream && isDeleteEmptyFile){
    stringBuffer.append(TEXT_47);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_48);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_49);
    if(compress && !isAppend && !split){
    stringBuffer.append(TEXT_50);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_51);
    }else{
    stringBuffer.append(TEXT_52);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_51);
    }
    stringBuffer.append(TEXT_53);
    }
    stringBuffer.append(TEXT_54);
    
	}
}

    stringBuffer.append(TEXT_2);
    return stringBuffer.toString();
  }
}
