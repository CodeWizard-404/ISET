package org.talend.designer.codegen.translators.processing;

import org.talend.core.model.process.INode;
import org.talend.core.model.metadata.IMetadataTable;
import org.talend.designer.codegen.config.CodeGeneratorArgument;
import java.util.List;
import org.talend.core.model.process.ElementParameterParser;

public class TFilterRowEndJava
{
  protected static String nl;
  public static synchronized TFilterRowEndJava create(String lineSeparator)
  {
    nl = lineSeparator;
    TFilterRowEndJava result = new TFilterRowEndJava();
    nl = null;
    return result;
  }

  public final String NL = nl == null ? (System.getProperties().getProperty("line.separator")) : nl;
  protected final String TEXT_1 = "    globalMap.put(\"";
  protected final String TEXT_2 = "_NB_LINE\", nb_line_";
  protected final String TEXT_3 = ");" + NL + "    globalMap.put(\"";
  protected final String TEXT_4 = "_NB_LINE_OK\", nb_line_ok_";
  protected final String TEXT_5 = "_NB_LINE_REJECT\", nb_line_reject_";
  protected final String TEXT_6 = ");" + NL + "    ";
  protected final String TEXT_7 = NL + "    \tlog.info(\"";
  protected final String TEXT_8 = " - Processed records count:\" + nb_line_";
  protected final String TEXT_9 = " + \". Matched records count:\" + nb_line_ok_";
  protected final String TEXT_10 = " + \". Rejected records count:\" + nb_line_reject_";
  protected final String TEXT_11 = " + \".\");";
  protected final String TEXT_12 = NL;

  public String generate(Object argument)
  {
    final StringBuffer stringBuffer = new StringBuffer();
    
CodeGeneratorArgument codeGenArgument = (CodeGeneratorArgument) argument;
INode node = (INode)codeGenArgument.getArgument();
String cid = node.getUniqueName();
List<IMetadataTable> metadatas = node.getMetadataList();

if (metadatas != null && metadatas.size() > 0) {
  IMetadataTable metadata = metadatas.get(0);
  
  if (metadata != null) {
		boolean isLog4jEnabled = ("true").equals(ElementParameterParser.getValue(node.getProcess(), "__LOG4J_ACTIVATE__"));
  
    stringBuffer.append(TEXT_1);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_2);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_3);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_4);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_3);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_5);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_6);
    if(isLog4jEnabled){
    stringBuffer.append(TEXT_7);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_8);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_9);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_10);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_11);
    }
    
  }
}

    stringBuffer.append(TEXT_12);
    return stringBuffer.toString();
  }
}
