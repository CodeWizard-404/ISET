package org.talend.designer.codegen.translators.processing;

import org.talend.core.model.process.ElementParameterParser;
import org.talend.core.model.metadata.IMetadataTable;
import org.talend.core.model.metadata.IMetadataColumn;
import org.talend.core.model.process.INode;
import org.talend.designer.codegen.config.CodeGeneratorArgument;
import org.talend.core.model.process.IConnectionCategory;
import org.talend.core.model.process.IConnection;
import java.util.List;
import java.util.Map;
import org.talend.core.model.metadata.types.JavaTypesManager;
import org.talend.core.model.metadata.types.JavaType;

public class TFilterRowMainJava
{
  protected static String nl;
  public static synchronized TFilterRowMainJava create(String lineSeparator)
  {
    nl = lineSeparator;
    TFilterRowMainJava result = new TFilterRowMainJava();
    nl = null;
    return result;
  }

  public final String NL = nl == null ? (System.getProperties().getProperty("line.separator")) : nl;
  protected final String TEXT_1 = "";
  protected final String TEXT_2 = NL + "          ";
  protected final String TEXT_3 = " = null;";
  protected final String TEXT_4 = NL + "    Operator_";
  protected final String TEXT_5 = " ope_";
  protected final String TEXT_6 = " = new Operator_";
  protected final String TEXT_7 = "(\"";
  protected final String TEXT_8 = "\");";
  protected final String TEXT_9 = "    " + NL + "        ope_";
  protected final String TEXT_10 = ".matches((";
  protected final String TEXT_11 = ")" + NL + "                       , \"";
  protected final String TEXT_12 = " failed\");";
  protected final String TEXT_13 = NL + "\t        ope_";
  protected final String TEXT_14 = ")" + NL + "\t                       , \"";
  protected final String TEXT_15 = NL + "            ope_";
  protected final String TEXT_16 = ")" + NL + "                           , \"";
  protected final String TEXT_17 = " failed\");" + NL + "\t\t \t";
  protected final String TEXT_18 = "  " + NL + "          ope_";
  protected final String TEXT_19 = ")" + NL + "                         , \"";
  protected final String TEXT_20 = NL + "      ope_";
  protected final String TEXT_21 = "), \"advanced condition failed\");";
  protected final String TEXT_22 = NL + "    " + NL + "    if (ope_";
  protected final String TEXT_23 = ".getMatchFlag()) {";
  protected final String TEXT_24 = NL + "              if(";
  protected final String TEXT_25 = " == null){ ";
  protected final String TEXT_26 = NL + "                ";
  protected final String TEXT_27 = " = new ";
  protected final String TEXT_28 = "Struct();" + NL + "              }";
  protected final String TEXT_29 = NL + "               ";
  protected final String TEXT_30 = ".";
  protected final String TEXT_31 = " = ";
  protected final String TEXT_32 = ";";
  protected final String TEXT_33 = NL + "\t\t\t\t\tlog.debug(\"";
  protected final String TEXT_34 = " - Process the record \" + (nb_line_";
  protected final String TEXT_35 = "+1) + \".\");" + NL + "\t\t\t\t\t";
  protected final String TEXT_36 = "    " + NL + "      nb_line_ok_";
  protected final String TEXT_37 = "++;" + NL + "    } else {";
  protected final String TEXT_38 = NL + "            if (";
  protected final String TEXT_39 = " == null){";
  protected final String TEXT_40 = NL + "              ";
  protected final String TEXT_41 = "Struct();" + NL + "            }";
  protected final String TEXT_42 = NL + "\t            ";
  protected final String TEXT_43 = ".errorMessage = ope_";
  protected final String TEXT_44 = ".getErrorMsg();";
  protected final String TEXT_45 = " - Reject the record \" + (nb_line_";
  protected final String TEXT_46 = "+1) + \". Caused by: \" + ";
  protected final String TEXT_47 = ".errorMessage+ \".\");" + NL + "\t\t\t\t\t";
  protected final String TEXT_48 = NL + "      nb_line_reject_";
  protected final String TEXT_49 = "++;" + NL + "    }";
  protected final String TEXT_50 = NL + NL + "nb_line_";
  protected final String TEXT_51 = "++;";
  protected final String TEXT_52 = NL;

  public String generate(Object argument)
  {
    final StringBuffer stringBuffer = new StringBuffer();
    stringBuffer.append(TEXT_1);
    
CodeGeneratorArgument codeGenArgument = (CodeGeneratorArgument) argument;
INode node = (INode)codeGenArgument.getArgument();
String cid = node.getUniqueName();
String connName = null;

if (node.getIncomingConnections().size() == 1) {
  IConnection conn = node.getIncomingConnections().get(0);
  connName = conn.getName();
}
List<IMetadataTable> metadatas = node.getMetadataList();

if ((metadatas != null) && (metadatas.size() > 0)) {
  IMetadataTable metadata = metadatas.get(0);

  if (metadata!=null && connName != null) {
    String logical = ElementParameterParser.getValue(node,"__LOGICAL_OP__");    
    List<? extends IConnection> conns = node.getOutgoingSortedConnections();
    List<? extends IConnection> connsFilter = node.getOutgoingConnections("FILTER");
    List<? extends IConnection> connsReject = node.getOutgoingConnections("REJECT");
    boolean use_advanced = ("true").equals(ElementParameterParser.getValue(node, "__USE_ADVANCED__"));
    String advancedCondition = ElementParameterParser.getValue(node, "__ADVANCED_COND__");    
    List<Map<String, String>> keyColumns = (List<Map<String,String>>)ElementParameterParser.getObjectValue(node,  "__CONDITIONS__");
    boolean isLog4jEnabled = ("true").equals(ElementParameterParser.getValue(node.getProcess(), "__LOG4J_ACTIVATE__"));
    
    if (conns != null && conns.size() > 0) {
       
      for (int i = 0; i < conns.size(); i++) {
        IConnection conn = conns.get(i);
        if (conn.getLineStyle().hasConnectionCategory(IConnectionCategory.DATA)) {
        
    stringBuffer.append(TEXT_2);
    stringBuffer.append(conn.getName());
    stringBuffer.append(TEXT_3);
    
        }
      }
    }
    
    stringBuffer.append(TEXT_4);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_5);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_6);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_7);
    stringBuffer.append(logical);
    stringBuffer.append(TEXT_8);
    
    for (Map<String, String> keyColumn : keyColumns) {
      String sFunction = keyColumn.get("FUNCTION");
      
      if (!"".equals(keyColumn.get("FUNCTION"))) {
        String sPartFunction = sFunction.substring(sFunction.indexOf(":") < 0 ? 0 : sFunction.indexOf(":") + 1); 
        
    stringBuffer.append(TEXT_9);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_10);
    stringBuffer.append(keyColumn.get("FUNCTION").replace("$source", connName + "." + keyColumn.get("INPUT_COLUMN")).replace("$target", keyColumn.get("RVALUE")).replace("$operator", keyColumn.get("OPERATOR")));
    stringBuffer.append(TEXT_11);
    stringBuffer.append(sPartFunction.replace("$source", keyColumn.get("INPUT_COLUMN")).replace("$target", keyColumn.get("RVALUE").replace("\\", "\\\\").replace("\"", "\\\"")).replace("$operator", keyColumn.get("OPERATOR")));
    stringBuffer.append(TEXT_12);
    
      } else {
        IMetadataColumn rightColumn = metadata.getColumn(keyColumn.get("INPUT_COLUMN"));
        JavaType javaType = JavaTypesManager.getJavaTypeFromId(rightColumn.getTalendType());

        if (!JavaTypesManager.isJavaPrimitiveType(javaType, rightColumn.isNullable())) {
          //this is only for bug:8133, when "Oject" type, and "Empty" function, and compare with "null"
          
          if (keyColumn.get("RVALUE") != null && keyColumn.get("RVALUE").equals("null")){
	      
    stringBuffer.append(TEXT_13);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_10);
    stringBuffer.append("$source $operator $target".replace("$source", connName + "." + keyColumn.get("INPUT_COLUMN")).replace("$target", keyColumn.get("RVALUE")).replace("$operator", keyColumn.get("OPERATOR")));
    stringBuffer.append(TEXT_14);
    stringBuffer.append(keyColumn.get("INPUT_COLUMN"));
    stringBuffer.append(keyColumn.get("OPERATOR"));
    stringBuffer.append(keyColumn.get("RVALUE").replace("\\", "\\\\").replace("\"", "\\\""));
    stringBuffer.append(TEXT_12);
    } else {
			if( JavaTypesManager.isNumberType(javaType, rightColumn.isNullable())) {
				String typeToGenerate = JavaTypesManager.getTypeToGenerate(rightColumn.getTalendType(), rightColumn.isNullable());
          
    stringBuffer.append(TEXT_15);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_10);
    stringBuffer.append("$source == null? false : $source.compareTo($target) $operator 0".replace("$source", connName + "." + keyColumn.get("INPUT_COLUMN")).replace("$target", "ParserUtils.parseTo_"+typeToGenerate+"(String.valueOf("+keyColumn.get("RVALUE")+"))").replace("$operator", keyColumn.get("OPERATOR")));
    stringBuffer.append(TEXT_16);
    stringBuffer.append("$source.compareTo($target) $operator 0".replace("$source", keyColumn.get("INPUT_COLUMN")).replace("$target", keyColumn.get("RVALUE").replace("\\", "\\\\").replace("\"", "\\\"")).replace("$operator", keyColumn.get("OPERATOR")));
    stringBuffer.append(TEXT_17);
    
			}else{
         	
    stringBuffer.append(TEXT_15);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_10);
    stringBuffer.append("$source == null? false : $source.compareTo($target) $operator 0".replace("$source", connName + "." + keyColumn.get("INPUT_COLUMN")).replace("$target", keyColumn.get("RVALUE")).replace("$operator", keyColumn.get("OPERATOR")));
    stringBuffer.append(TEXT_16);
    stringBuffer.append("$source.compareTo($target) $operator 0".replace("$source", keyColumn.get("INPUT_COLUMN")).replace("$target", keyColumn.get("RVALUE").replace("\\", "\\\\").replace("\"", "\\\"")).replace("$operator", keyColumn.get("OPERATOR")));
    stringBuffer.append(TEXT_12);
    
         	}
	      }
        } else {
        
    stringBuffer.append(TEXT_18);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_10);
    stringBuffer.append("$source $operator $target".replace("$source", connName + "." + keyColumn.get("INPUT_COLUMN")).replace("$target", keyColumn.get("RVALUE")).replace("$operator", keyColumn.get("OPERATOR")) );
    stringBuffer.append(TEXT_19);
    stringBuffer.append(keyColumn.get("INPUT_COLUMN"));
    stringBuffer.append(keyColumn.get("OPERATOR"));
    stringBuffer.append(keyColumn.get("RVALUE").replace("\\", "\\\\").replace("\"", "\\\""));
    stringBuffer.append(TEXT_12);
    
	    }
      }
    }
    
    if (use_advanced) {
    
    stringBuffer.append(TEXT_20);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_10);
    stringBuffer.append(advancedCondition.replace("input_row", connName));
    stringBuffer.append(TEXT_21);
    
    }
    
    stringBuffer.append(TEXT_22);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_23);
    
      if (connsFilter != null) {

        if (connsFilter.size() > 0) {

          for (int i = 0; i < connsFilter.size(); i++) {
            IConnection conn = connsFilter.get(i);

            if (conn.getLineStyle().hasConnectionCategory(IConnectionCategory.DATA)) {
            
    stringBuffer.append(TEXT_24);
    stringBuffer.append(conn.getName() );
    stringBuffer.append(TEXT_25);
    stringBuffer.append(TEXT_26);
    stringBuffer.append(conn.getName() );
    stringBuffer.append(TEXT_27);
    stringBuffer.append(conn.getName() );
    stringBuffer.append(TEXT_28);
    
              for (IMetadataColumn column: metadata.getListColumns()) {
              
    stringBuffer.append(TEXT_29);
    stringBuffer.append(conn.getName() );
    stringBuffer.append(TEXT_30);
    stringBuffer.append(column.getLabel() );
    stringBuffer.append(TEXT_31);
    stringBuffer.append(connName );
    stringBuffer.append(TEXT_30);
    stringBuffer.append(column.getLabel() );
    stringBuffer.append(TEXT_32);
    
	          }
				if(isLog4jEnabled){
				
    stringBuffer.append(TEXT_33);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_34);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_35);
    
				}
            }
          }
        }
      }
      
    stringBuffer.append(TEXT_36);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_37);
    
      if (connsReject != null && connsReject.size() > 0) {
       
        for (int i = 0; i < connsReject.size(); i++) {
          IConnection conn = connsReject.get(i);
          String sRejectConnName = conn.getName();

          if (conn.getLineStyle().hasConnectionCategory(IConnectionCategory.DATA)) {
          
    stringBuffer.append(TEXT_38);
    stringBuffer.append(sRejectConnName);
    stringBuffer.append(TEXT_39);
    stringBuffer.append(TEXT_40);
    stringBuffer.append(sRejectConnName);
    stringBuffer.append(TEXT_27);
    stringBuffer.append(sRejectConnName);
    stringBuffer.append(TEXT_41);
    
            boolean hasErrorMsg = false;
            for (IMetadataColumn column: conn.getMetadataTable().getListColumns()) {
              String columnName = column.getLabel();
              
              if ("errorMessage".equals(columnName)) {
              	hasErrorMsg = true;
              
    stringBuffer.append(TEXT_42);
    stringBuffer.append(sRejectConnName);
    stringBuffer.append(TEXT_43);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_44);
    
              } else {
              
    stringBuffer.append(TEXT_26);
    stringBuffer.append(sRejectConnName);
    stringBuffer.append(TEXT_30);
    stringBuffer.append(column.getLabel() );
    stringBuffer.append(TEXT_31);
    stringBuffer.append(connName);
    stringBuffer.append(TEXT_30);
    stringBuffer.append(column.getLabel() );
    stringBuffer.append(TEXT_32);
    
              }
	        }
				if(isLog4jEnabled){
				
    stringBuffer.append(TEXT_33);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_34);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_35);
    if (hasErrorMsg) {
    stringBuffer.append(TEXT_33);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_45);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_46);
    stringBuffer.append(sRejectConnName);
    stringBuffer.append(TEXT_47);
    }
				}
          }
        }
      }
      
    stringBuffer.append(TEXT_48);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_49);
    
  }
}

    stringBuffer.append(TEXT_50);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_51);
    stringBuffer.append(TEXT_52);
    return stringBuffer.toString();
  }
}
