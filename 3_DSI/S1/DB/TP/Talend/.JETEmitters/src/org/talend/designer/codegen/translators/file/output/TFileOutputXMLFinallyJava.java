package org.talend.designer.codegen.translators.file.output;

import org.talend.core.model.process.INode;
import org.talend.designer.codegen.config.CodeGeneratorArgument;
import org.talend.core.model.process.ElementParameterParser;

public class TFileOutputXMLFinallyJava
{
  protected static String nl;
  public static synchronized TFileOutputXMLFinallyJava create(String lineSeparator)
  {
    nl = lineSeparator;
    TFileOutputXMLFinallyJava result = new TFileOutputXMLFinallyJava();
    nl = null;
    return result;
  }

  public final String NL = nl == null ? (System.getProperties().getProperty("line.separator")) : nl;
  protected final String TEXT_1 = "";
  protected final String TEXT_2 = NL + "\tif(Boolean.valueOf(String.valueOf(resourceMap.remove(\"isFileGenerated_";
  protected final String TEXT_3 = "\"))) && Integer.valueOf(String.valueOf(resourceMap.remove(\"nb_line_";
  protected final String TEXT_4 = "\"))) == 0){" + NL + "\t\t";
  protected final String TEXT_5 = NL + "\t\t((java.io.BufferedWriter)resourceMap.remove(\"stream_";
  protected final String TEXT_6 = "\")).close();" + NL + "\t\t";
  protected final String TEXT_7 = NL + "\t\t((org.dom4j.io.XMLWriter)resourceMap.remove(\"stream_";
  protected final String TEXT_8 = NL + "\t\t((java.io.File)resourceMap.remove(\"file_";
  protected final String TEXT_9 = "\")).delete();" + NL + "\t}\t\t";
  protected final String TEXT_10 = "\t";
  protected final String TEXT_11 = NL;

  public String generate(Object argument)
  {
    final StringBuffer stringBuffer = new StringBuffer();
    stringBuffer.append(TEXT_1);
    
CodeGeneratorArgument codeGenArgument = (CodeGeneratorArgument) argument;
INode node = (INode)codeGenArgument.getArgument();
String cid = node.getUniqueName();

boolean isDeleteEmptyFile = ("true").equals(ElementParameterParser.getValue(node, "__DELETE_EMPTYFILE__"));
boolean inputIsDocument = "true".equals(ElementParameterParser.getValue(node, "__INPUT_IS_DOCUMENT__"));

if(isDeleteEmptyFile){
    stringBuffer.append(TEXT_2);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_3);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_4);
    if(!inputIsDocument) {
    stringBuffer.append(TEXT_5);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_6);
    } else {
    stringBuffer.append(TEXT_7);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_6);
    }
    stringBuffer.append(TEXT_8);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_9);
    }
    stringBuffer.append(TEXT_10);
    stringBuffer.append(TEXT_11);
    return stringBuffer.toString();
  }
}
