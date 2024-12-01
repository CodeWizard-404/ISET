package org.talend.designer.codegen.translators.file.input;

import org.talend.core.model.process.INode;
import org.talend.core.model.metadata.IMetadataTable;
import org.talend.designer.codegen.config.CodeGeneratorArgument;
import org.talend.core.model.process.ElementParameterParser;
import java.util.List;
import org.talend.core.model.process.IProcess;

public class TFileInputDelimitedEndJava
{
  protected static String nl;
  public static synchronized TFileInputDelimitedEndJava create(String lineSeparator)
  {
    nl = lineSeparator;
    TFileInputDelimitedEndJava result = new TFileInputDelimitedEndJava();
    nl = null;
    return result;
  }

  public final String NL = nl == null ? (System.getProperties().getProperty("line.separator")) : nl;
  protected final String TEXT_1 = "";
  protected final String TEXT_2 = NL;
  protected final String TEXT_3 = NL + "\t\t\t\t" + NL + "            }" + NL + "            nb_line_";
  protected final String TEXT_4 = "+=fid_";
  protected final String TEXT_5 = ".getRowNumber();" + NL + "\t\t}" + NL + "\t\t}finally{" + NL + "            if(!((Object)(";
  protected final String TEXT_6 = ") instanceof java.io.InputStream)){" + NL + "            \tif(fid_";
  protected final String TEXT_7 = "!=null){" + NL + "            \t\tfid_";
  protected final String TEXT_8 = ".close();" + NL + "            \t}" + NL + "            }" + NL + "            if(fid_";
  protected final String TEXT_9 = "!=null){" + NL + "            \tglobalMap.put(\"";
  protected final String TEXT_10 = "_NB_LINE\", nb_line_";
  protected final String TEXT_11 = ");" + NL + "            }" + NL + "\t\t\t\t\t";
  protected final String TEXT_12 = NL + "\t\t\t\t\t\tlog.info(\"";
  protected final String TEXT_13 = "- Retrieved records count: \"+ nb_line_";
  protected final String TEXT_14 = " + \".\");" + NL + "\t\t\t\t\t";
  protected final String TEXT_15 = NL + "        }";
  protected final String TEXT_16 = NL + NL + "            }" + NL + "            }finally{" + NL + "                if(!((Object)(";
  protected final String TEXT_17 = ") instanceof java.io.InputStream)){" + NL + "                \tif(fid_";
  protected final String TEXT_18 = "!=null){" + NL + "                \t\tfid_";
  protected final String TEXT_19 = ".close();" + NL + "                \t}" + NL + "                }" + NL + "                if(fid_";
  protected final String TEXT_20 = "!=null){" + NL + "                \tglobalMap.put(\"";
  protected final String TEXT_21 = "_NB_LINE\", fid_";
  protected final String TEXT_22 = ".getRowNumber());" + NL + "\t\t\t\t\t";
  protected final String TEXT_23 = " - Retrieved records count: \"+ fid_";
  protected final String TEXT_24 = ".getRowNumber() + \".\");" + NL + "\t\t\t\t\t";
  protected final String TEXT_25 = NL + "                }" + NL + "\t\t\t}";
  protected final String TEXT_26 = NL + "\t\t\t\tnb_line_";
  protected final String TEXT_27 = "++;" + NL + "\t\t\t}" + NL + "\t\t\t";
  protected final String TEXT_28 = "}";
  protected final String TEXT_29 = NL + "\t\t\t}finally{" + NL + "    \t\t\tif(!(filename_";
  protected final String TEXT_30 = " instanceof java.io.InputStream)){" + NL + "    \t\t\t\tif(csvReader";
  protected final String TEXT_31 = "!=null){" + NL + "    \t\t\t\t\tcsvReader";
  protected final String TEXT_32 = ".close();" + NL + "    \t\t\t\t}" + NL + "    \t\t\t}" + NL + "    \t\t\tif(csvReader";
  protected final String TEXT_33 = "!=null){" + NL + "    \t\t\t\tglobalMap.put(\"";
  protected final String TEXT_34 = "_NB_LINE\",nb_line_";
  protected final String TEXT_35 = ");" + NL + "    \t\t\t}" + NL + "\t\t\t\t";
  protected final String TEXT_36 = NL + "\t\t\t\t\tlog.info(\"";
  protected final String TEXT_37 = " - Retrieved records count: \"+ nb_line_";
  protected final String TEXT_38 = " + \".\");" + NL + "\t\t\t\t";
  protected final String TEXT_39 = NL + "\t\t\t}";
  protected final String TEXT_40 = NL + "\t\t\t";
  protected final String TEXT_41 = "\t\t\t  ";

  public String generate(Object argument)
  {
    final StringBuffer stringBuffer = new StringBuffer();
    stringBuffer.append(TEXT_1);
     
    CodeGeneratorArgument codeGenArgument = (CodeGeneratorArgument) argument;
    INode node = (INode)codeGenArgument.getArgument();
    String cid = node.getUniqueName();
	
	String vcid = "";
	
	String projectName = codeGenArgument.getCurrentProjectName();
	String jobName = codeGenArgument.getJobName();
	String jobVersion = codeGenArgument.getJobVersion();
	
	String tempDir = ElementParameterParser.getValue(node, "__TEMP_DIR__");

	String destination = ElementParameterParser.getValue(node, "__DESTINATION__");
	if(destination!=null && !"".equals(destination)){
		vcid = destination;
	}
	IProcess process = node.getProcess();
	boolean isLog4jEnabled = ("true").equals(ElementParameterParser.getValue(process, "__LOG4J_ACTIVATE__"));
	if(("false").equals(ElementParameterParser.getValue(node,"__CSV_OPTION__"))) {	
//////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////

    stringBuffer.append(TEXT_2);
    
	List<IMetadataTable> metadatas = node.getMetadataList();
	if ((metadatas!=null)&&(metadatas.size()>0)) {
		IMetadataTable metadata = metadatas.get(0);
		if (metadata!=null) {
			String filename = ElementParameterParser.getValue(node,"__FILENAME__");
			if(!("".equals(vcid))) {
				filename = "\"/"+filename.substring(1, filename.length()-1)+vcid+"_"+projectName+"_"+jobName+"_"+jobVersion+"\"";
				filename = tempDir+"+"+filename;
			}
			
    		boolean uncompress = ("true").equals(ElementParameterParser.getValue(node,"__UNCOMPRESS__"));

			if(uncompress){

    stringBuffer.append(TEXT_3);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_4);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_5);
    stringBuffer.append(filename );
    stringBuffer.append(TEXT_6);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_7);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_8);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_9);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_10);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_11);
    if(isLog4jEnabled){
    stringBuffer.append(TEXT_12);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_13);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_14);
    }
    stringBuffer.append(TEXT_15);
    
			}else{

    stringBuffer.append(TEXT_16);
    stringBuffer.append(filename );
    stringBuffer.append(TEXT_17);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_18);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_19);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_20);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_21);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_22);
    if(isLog4jEnabled){
    stringBuffer.append(TEXT_12);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_23);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_24);
    }
    stringBuffer.append(TEXT_25);
    
			}
		}
	}

    stringBuffer.append(TEXT_2);
    
//////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
}else{//the following is the tFileInputCSV component
//////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////

    stringBuffer.append(TEXT_2);
    
	List<IMetadataTable> metadatas = node.getMetadataList();
	if ((metadatas!=null)&&(metadatas.size()>0)) {
		IMetadataTable metadata = metadatas.get(0);
		if (metadata!=null) {
    		boolean uncompress = ("true").equals(ElementParameterParser.getValue(node,"__UNCOMPRESS__"));


    stringBuffer.append(TEXT_26);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_27);
    if(uncompress){//compress
    stringBuffer.append(TEXT_28);
    }
    stringBuffer.append(TEXT_29);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_30);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_31);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_32);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_33);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_34);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_35);
    if(isLog4jEnabled){
    stringBuffer.append(TEXT_36);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_37);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_38);
    }
    stringBuffer.append(TEXT_39);
    
		}
	}

    stringBuffer.append(TEXT_40);
    
//////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
  }

    stringBuffer.append(TEXT_41);
    stringBuffer.append(TEXT_2);
    return stringBuffer.toString();
  }
}
