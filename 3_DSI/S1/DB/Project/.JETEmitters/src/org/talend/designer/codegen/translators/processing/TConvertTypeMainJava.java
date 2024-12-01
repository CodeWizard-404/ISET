package org.talend.designer.codegen.translators.processing;

import java.util.List;
import java.util.Map;
import org.talend.core.model.metadata.IMetadataColumn;
import org.talend.core.model.metadata.IMetadataTable;
import org.talend.core.model.process.EConnectionType;
import org.talend.core.model.process.ElementParameterParser;
import org.talend.core.model.process.IConnection;
import org.talend.core.model.process.IConnectionCategory;
import org.talend.core.model.process.INode;
import org.talend.designer.codegen.config.CodeGeneratorArgument;
import org.talend.core.model.metadata.types.JavaTypesManager;

public class TConvertTypeMainJava
{
  protected static String nl;
  public static synchronized TConvertTypeMainJava create(String lineSeparator)
  {
    nl = lineSeparator;
    TConvertTypeMainJava result = new TConvertTypeMainJava();
    nl = null;
    return result;
  }

  public final String NL = nl == null ? (System.getProperties().getProperty("line.separator")) : nl;
  protected final String TEXT_1 = "    ";
  protected final String TEXT_2 = " = null;";
  protected final String TEXT_3 = NL + "    ";
  protected final String TEXT_4 = " = new ";
  protected final String TEXT_5 = "Struct();" + NL + "    String errorCode_";
  protected final String TEXT_6 = " = \"\";" + NL + "    String errorMessage_";
  protected final String TEXT_7 = " = \"\";";
  protected final String TEXT_8 = NL + "  ";
  protected final String TEXT_9 = "Struct();" + NL + "  boolean bHasError_";
  protected final String TEXT_10 = " = false;  ";
  protected final String TEXT_11 = "           " + NL + "          try {";
  protected final String TEXT_12 = NL + "              if (\"\".equals(";
  protected final String TEXT_13 = ".";
  protected final String TEXT_14 = ")){  ";
  protected final String TEXT_15 = NL + "                ";
  protected final String TEXT_16 = " = null;" + NL + "              }";
  protected final String TEXT_17 = NL + "              ";
  protected final String TEXT_18 = "=TypeConvert.";
  protected final String TEXT_19 = "2";
  protected final String TEXT_20 = "(";
  protected final String TEXT_21 = ", ";
  protected final String TEXT_22 = ");";
  protected final String TEXT_23 = ");" + NL + "        \t";
  protected final String TEXT_24 = "=ParserUtils.parseTo_Document(";
  protected final String TEXT_25 = "=";
  protected final String TEXT_26 = ".toString();";
  protected final String TEXT_27 = " = ";
  protected final String TEXT_28 = ";";
  protected final String TEXT_29 = "            " + NL + "          } catch(java.lang.Exception e){" + NL + "globalMap.put(\"";
  protected final String TEXT_30 = "_ERROR_MESSAGE\",e.getMessage());" + NL + "            bHasError_";
  protected final String TEXT_31 = " = true;            ";
  protected final String TEXT_32 = NL + "              if ((\"\").equals(errorMessage_";
  protected final String TEXT_33 = ")){" + NL + "                errorMessage_";
  protected final String TEXT_34 = " = \"";
  protected final String TEXT_35 = "\" + \":\" + e.getMessage();" + NL + "              } else{" + NL + "                errorMessage_";
  protected final String TEXT_36 = " = errorMessage_";
  protected final String TEXT_37 = " + \";\" + \"";
  protected final String TEXT_38 = "\" + \":\" + e.getMessage();" + NL + "              }";
  protected final String TEXT_39 = NL + "              System.err.println(e.getMessage());          ";
  protected final String TEXT_40 = NL + "              throw e;";
  protected final String TEXT_41 = NL + "          }";
  protected final String TEXT_42 = NL + "      if (bHasError_";
  protected final String TEXT_43 = ") {";
  protected final String TEXT_44 = " = null;}";
  protected final String TEXT_45 = NL + "      ";
  protected final String TEXT_46 = "     " + NL + "      try {";
  protected final String TEXT_47 = NL + "          if (\"\".equals(";
  protected final String TEXT_48 = NL + "            ";
  protected final String TEXT_49 = " = null;" + NL + "          }";
  protected final String TEXT_50 = NL + "          ";
  protected final String TEXT_51 = " = TypeConvert.";
  protected final String TEXT_52 = ");" + NL + "\t\t";
  protected final String TEXT_53 = NL + "      } catch (java.lang.Exception e){" + NL + "globalMap.put(\"";
  protected final String TEXT_54 = "_ERROR_MESSAGE\",e.getMessage());" + NL + "        bHasError_";
  protected final String TEXT_55 = " = true;        ";
  protected final String TEXT_56 = NL + "          if (\"\".equals(errorMessage_";
  protected final String TEXT_57 = ")){" + NL + "            errorMessage_";
  protected final String TEXT_58 = "\" + \":\" + e.getMessage();" + NL + "          } else{" + NL + "            errorMessage_";
  protected final String TEXT_59 = "=errorMessage_";
  protected final String TEXT_60 = "\" + \":\" + e.getMessage();" + NL + "          }";
  protected final String TEXT_61 = NL + "          System.err.println(e.getMessage());          ";
  protected final String TEXT_62 = NL + "          throw e;";
  protected final String TEXT_63 = NL + "      }";
  protected final String TEXT_64 = ") { ";
  protected final String TEXT_65 = NL + "    if (errorMessage_";
  protected final String TEXT_66 = ".length() > 0){" + NL + "      if (errorMessage_";
  protected final String TEXT_67 = ".contains(\"Can't support convert\")){" + NL + "        errorCode_";
  protected final String TEXT_68 = " = \"1\"; //ConvertTypeNotSupportException" + NL + "      }else{" + NL + "        errorCode_";
  protected final String TEXT_69 = " = \"2\"; //Other Java exception" + NL + "      }";
  protected final String TEXT_70 = ".errorCode = errorCode_";
  protected final String TEXT_71 = ".errorMessage = errorMessage_";
  protected final String TEXT_72 = " + \" - Line: \" + tos_count_";
  protected final String TEXT_73 = ";" + NL + "    } else{";
  protected final String TEXT_74 = " = null;" + NL + "    }" + NL + "    errorMessage_";
  protected final String TEXT_75 = NL + "  nb_line_";
  protected final String TEXT_76 = " ++ ;";
  protected final String TEXT_77 = NL;

  public String generate(Object argument)
  {
    final StringBuffer stringBuffer = new StringBuffer();
    
  CodeGeneratorArgument codeGenArgument = (CodeGeneratorArgument) argument;
  INode node = (INode)codeGenArgument.getArgument();
  String cid = node.getUniqueName();
  boolean autoCast = ("true").equals(ElementParameterParser.getValue(node, "__AUTOCAST__"));
  List<Map<String, String>> manualtable = (List<Map<String,String>>)ElementParameterParser.getObjectValue(node, "__MANUALTABLE__");
  boolean bEmptyToNull = "true".equals(ElementParameterParser.getValue(node, "__EMPTYTONULL__"));
  boolean bDieOnError = "true".equals(ElementParameterParser.getValue(node, "__DIEONERROR__"));
  IConnection inMainCon = null;
  List<? extends IConnection> connsIn = node.getIncomingConnections(EConnectionType.FLOW_MAIN);
  
  if (connsIn == null || connsIn.size() == 0 ){
    return "";
  } else{
    inMainCon = connsIn.get(0);
  }   
  IConnection outConn = null;
  List< ? extends IConnection> outConns = node.getOutgoingSortedConnections();
  
  if (outConns == null || outConns.size() == 0 ){
    return "";
  } else{
  	for(int i=0; i<outConns.size(); i++){
  		IConnection connTemp = outConns.get(i);
	    if (connTemp.getLineStyle().hasConnectionCategory(IConnectionCategory.DATA)) {
	    	outConn = connTemp;
	    	break;
	    }
  	}
  } 
  
  String outconnName = outConn.getName();
  String preconnName = inMainCon.getName(); 
  String rejectConnName = null; 
  List<? extends IConnection> rejectConns = node.getOutgoingConnections("REJECT");
  
  if (rejectConns != null && rejectConns.size() > 0) {
    for (IConnection conn : rejectConns) {
      if (conn.isActivate()){
        rejectConnName = conn.getName();
      }
    }
  }
  // Output Reject flow
  boolean bOutputReject = (rejectConnName != null) && (!bDieOnError);

  //reset reject = null
  boolean bResetReject = (rejectConnName != null) && (bDieOnError);

  //reset the main = null, and also consider there only have one reject link  
  boolean bResetMain = (rejectConnName == null) || (rejectConnName != null && !rejectConnName.equals(outconnName));
  
  //reset reject = null, when die on error and there only have one reject link, so, always reset to reject = null
  boolean bResetalways = (bDieOnError && rejectConnName != null && rejectConnName.equals(outconnName));

  // will ignore error
  boolean bIgnoreError = (rejectConnName == null) && (!bDieOnError);
  IMetadataTable preMetadata = inMainCon.getMetadataTable(); 
  List<IMetadataColumn> preColumns = preMetadata.getListColumns();   
  List<IMetadataTable> metadatas = node.getMetadataList();
  IMetadataTable metadata = metadatas.get(0);
  List<IMetadataColumn> columns = metadata.getListColumns();
  
  if (bResetReject){
  
    stringBuffer.append(TEXT_1);
    stringBuffer.append(rejectConnName );
    stringBuffer.append(TEXT_2);
    
  }
  
  if (bOutputReject){
  
    stringBuffer.append(TEXT_3);
    stringBuffer.append(rejectConnName );
    stringBuffer.append(TEXT_4);
    stringBuffer.append(rejectConnName );
    stringBuffer.append(TEXT_5);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_6);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_7);
    
  }
  stringBuffer.append("\n");//control code format  
  
    stringBuffer.append(TEXT_8);
    stringBuffer.append(outconnName );
    stringBuffer.append(TEXT_4);
    stringBuffer.append(outconnName );
    stringBuffer.append(TEXT_9);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_10);
      
  if (autoCast){ //autoCast begin
  
    for (IMetadataColumn col : columns){//col:columns  
      String outLabel = col.getLabel();
      String outPattern = col.getPattern();
      String outTypeWhole = JavaTypesManager.getTypeToGenerate(col.getTalendType(), col.isNullable());
      String outType = outTypeWhole.contains(".") ? outTypeWhole.substring(outTypeWhole.lastIndexOf(".") + 1) : outTypeWhole;
      if (("byte[]").equals(outType)){
        outType = "byteArray";
      }
      
      for (IMetadataColumn preCol : preColumns){//3
        String preLabel = preCol.getLabel();

        if (preLabel.equals(outLabel)){
          String inTypeWhole = JavaTypesManager.getTypeToGenerate(preCol.getTalendType(), preCol.isNullable());
          String inType = inTypeWhole.contains(".") ? inTypeWhole.substring(inTypeWhole.lastIndexOf(".") + 1) : inTypeWhole;
          String inPattern = preCol.getPattern();
          
          if (("byte[]").equals(inType)){
            inType = "byteArray";
          }
          
    stringBuffer.append(TEXT_11);
    
            if (bEmptyToNull && ("String".equals(inType) || "Object".equals(inType))) {
            
    stringBuffer.append(TEXT_12);
    stringBuffer.append(preconnName );
    stringBuffer.append(TEXT_13);
    stringBuffer.append(preLabel);
    stringBuffer.append(TEXT_14);
    stringBuffer.append(TEXT_15);
    stringBuffer.append(preconnName );
    stringBuffer.append(TEXT_13);
    stringBuffer.append(preLabel );
    stringBuffer.append(TEXT_16);
    
            }
            
            if ("Date".equals(outType) && ("String".equals(inType)||"Object".equals(inType))) {
    stringBuffer.append(TEXT_17);
    stringBuffer.append(outconnName );
    stringBuffer.append(TEXT_13);
    stringBuffer.append(outLabel );
    stringBuffer.append(TEXT_18);
    stringBuffer.append(inType );
    stringBuffer.append(TEXT_19);
    stringBuffer.append(outType );
    stringBuffer.append(TEXT_20);
    stringBuffer.append(preconnName );
    stringBuffer.append(TEXT_13);
    stringBuffer.append(preLabel );
    stringBuffer.append(TEXT_21);
    stringBuffer.append(outPattern );
    stringBuffer.append(TEXT_22);
    } else if ("String".equals(outType) && "Date".equals(inType)) {
    stringBuffer.append(TEXT_17);
    stringBuffer.append(outconnName );
    stringBuffer.append(TEXT_13);
    stringBuffer.append(outLabel );
    stringBuffer.append(TEXT_18);
    stringBuffer.append(inType );
    stringBuffer.append(TEXT_19);
    stringBuffer.append(outType );
    stringBuffer.append(TEXT_20);
    stringBuffer.append(preconnName );
    stringBuffer.append(TEXT_13);
    stringBuffer.append(preLabel );
    stringBuffer.append(TEXT_21);
    stringBuffer.append(inPattern );
    stringBuffer.append(TEXT_23);
    } else if (("Document".equals(outType) && "String".equals(inType))){
    stringBuffer.append(TEXT_17);
    stringBuffer.append(outconnName );
    stringBuffer.append(TEXT_13);
    stringBuffer.append(outLabel );
    stringBuffer.append(TEXT_24);
    stringBuffer.append(preconnName );
    stringBuffer.append(TEXT_13);
    stringBuffer.append(preLabel );
    stringBuffer.append(TEXT_22);
    } else if (("String".equals(outType) && "Document".equals(inType))){
    stringBuffer.append(TEXT_17);
    stringBuffer.append(outconnName );
    stringBuffer.append(TEXT_13);
    stringBuffer.append(outLabel );
    stringBuffer.append(TEXT_25);
    stringBuffer.append(preconnName );
    stringBuffer.append(TEXT_13);
    stringBuffer.append(preLabel );
    stringBuffer.append(TEXT_26);
    } else{
    stringBuffer.append(TEXT_17);
    stringBuffer.append(outconnName );
    stringBuffer.append(TEXT_13);
    stringBuffer.append(outLabel );
    stringBuffer.append(TEXT_18);
    stringBuffer.append(inType );
    stringBuffer.append(TEXT_19);
    stringBuffer.append(outType );
    stringBuffer.append(TEXT_20);
    stringBuffer.append(preconnName );
    stringBuffer.append(TEXT_13);
    stringBuffer.append(preLabel );
    stringBuffer.append(TEXT_22);
    }
            
            if (bOutputReject){
    stringBuffer.append(TEXT_1);
    stringBuffer.append(TEXT_17);
    stringBuffer.append(rejectConnName );
    stringBuffer.append(TEXT_13);
    stringBuffer.append(outLabel );
    stringBuffer.append(TEXT_27);
    stringBuffer.append(outconnName );
    stringBuffer.append(TEXT_13);
    stringBuffer.append(outLabel );
    stringBuffer.append(TEXT_28);
    }
    stringBuffer.append(TEXT_29);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_30);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_31);
    if (bOutputReject){
    stringBuffer.append(TEXT_32);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_33);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_34);
    stringBuffer.append(outLabel );
    stringBuffer.append(TEXT_35);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_36);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_37);
    stringBuffer.append(outLabel );
    stringBuffer.append(TEXT_38);
    }else if (bIgnoreError){
    stringBuffer.append(TEXT_39);
    }else if (bDieOnError){
    stringBuffer.append(TEXT_40);
    }
    stringBuffer.append(TEXT_41);
          
        }
      }//3
    }//col:columns

    if (bResetMain){
    
    stringBuffer.append(TEXT_42);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_43);
    stringBuffer.append(outconnName );
    stringBuffer.append(TEXT_44);
    
    }
    
    if (bResetalways){
    
    stringBuffer.append(TEXT_45);
    stringBuffer.append(outconnName );
    stringBuffer.append(TEXT_2);
    
    }
  } else { // autoCast end,manual cast begin
  
    for (Map<String, String> manualColumn : manualtable){//111
      String input = manualColumn.get("INPUT_COLUMN");
      String output = manualColumn.get("OUTPUT_COLUMN");
      IMetadataColumn in = preMetadata.getColumn(input);
      IMetadataColumn out = metadata.getColumn(output);
      String inTypeWhole = JavaTypesManager.getTypeToGenerate(in.getTalendType(), in.isNullable());
      String inType = inTypeWhole.contains(".") ? inTypeWhole.substring(inTypeWhole.lastIndexOf(".") + 1) : inTypeWhole;
      String outTypeWhole = JavaTypesManager.getTypeToGenerate(out.getTalendType(), out.isNullable());
      String outType = outTypeWhole.contains(".") ? outTypeWhole.substring(outTypeWhole.lastIndexOf(".") + 1) : outTypeWhole;
      
      if (("byte[]").equals(outType)){
        outType = "byteArray";
      }
      
      if (("byte[]").equals(inType)){
        inType = "byteArray";
      }
      String outLabel = out.getLabel();
      String outPattern = out.getPattern();
      String preLabel = in.getLabel();
      String inPattern = in.getPattern();
      
    stringBuffer.append(TEXT_46);
    
        if (bEmptyToNull && ("String".equals(inType) || "Object".equals(inType))) {
        
    stringBuffer.append(TEXT_47);
    stringBuffer.append(preconnName );
    stringBuffer.append(TEXT_13);
    stringBuffer.append(preLabel);
    stringBuffer.append(TEXT_14);
    stringBuffer.append(TEXT_48);
    stringBuffer.append(preconnName );
    stringBuffer.append(TEXT_13);
    stringBuffer.append(preLabel );
    stringBuffer.append(TEXT_49);
    
        }
        
        if ("Date".equals(outType) && "String".equals(inType)) {
    stringBuffer.append(TEXT_50);
    stringBuffer.append(outconnName );
    stringBuffer.append(TEXT_13);
    stringBuffer.append(outLabel );
    stringBuffer.append(TEXT_51);
    stringBuffer.append(inType );
    stringBuffer.append(TEXT_19);
    stringBuffer.append(outType );
    stringBuffer.append(TEXT_20);
    stringBuffer.append(preconnName );
    stringBuffer.append(TEXT_13);
    stringBuffer.append(preLabel );
    stringBuffer.append(TEXT_21);
    stringBuffer.append(outPattern );
    stringBuffer.append(TEXT_22);
    } else if ("String".equals(outType) && "Date".equals(inType)) {
    stringBuffer.append(TEXT_50);
    stringBuffer.append(outconnName );
    stringBuffer.append(TEXT_13);
    stringBuffer.append(outLabel );
    stringBuffer.append(TEXT_51);
    stringBuffer.append(inType );
    stringBuffer.append(TEXT_19);
    stringBuffer.append(outType );
    stringBuffer.append(TEXT_20);
    stringBuffer.append(preconnName );
    stringBuffer.append(TEXT_13);
    stringBuffer.append(preLabel );
    stringBuffer.append(TEXT_21);
    stringBuffer.append(inPattern );
    stringBuffer.append(TEXT_22);
    } else if (("Document".equals(outType) && "String".equals(inType))){
    stringBuffer.append(TEXT_50);
    stringBuffer.append(outconnName );
    stringBuffer.append(TEXT_13);
    stringBuffer.append(outLabel );
    stringBuffer.append(TEXT_24);
    stringBuffer.append(preconnName );
    stringBuffer.append(TEXT_13);
    stringBuffer.append(preLabel );
    stringBuffer.append(TEXT_52);
    } else if (("String".equals(outType) && "Document".equals(inType))){
    stringBuffer.append(TEXT_50);
    stringBuffer.append(outconnName );
    stringBuffer.append(TEXT_13);
    stringBuffer.append(outLabel );
    stringBuffer.append(TEXT_25);
    stringBuffer.append(preconnName );
    stringBuffer.append(TEXT_13);
    stringBuffer.append(preLabel );
    stringBuffer.append(TEXT_26);
    } else {
    stringBuffer.append(TEXT_50);
    stringBuffer.append(outconnName );
    stringBuffer.append(TEXT_13);
    stringBuffer.append(outLabel );
    stringBuffer.append(TEXT_51);
    stringBuffer.append(inType );
    stringBuffer.append(TEXT_19);
    stringBuffer.append(outType );
    stringBuffer.append(TEXT_20);
    stringBuffer.append(preconnName );
    stringBuffer.append(TEXT_13);
    stringBuffer.append(preLabel );
    stringBuffer.append(TEXT_22);
    }
        
        if (bOutputReject){
        
    stringBuffer.append(TEXT_1);
    stringBuffer.append(TEXT_50);
    stringBuffer.append(rejectConnName );
    stringBuffer.append(TEXT_13);
    stringBuffer.append(outLabel );
    stringBuffer.append(TEXT_27);
    stringBuffer.append(outconnName );
    stringBuffer.append(TEXT_13);
    stringBuffer.append(outLabel );
    stringBuffer.append(TEXT_28);
    
        }
        
    stringBuffer.append(TEXT_53);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_54);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_55);
    if (bOutputReject){
    stringBuffer.append(TEXT_56);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_57);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_34);
    stringBuffer.append(outLabel );
    stringBuffer.append(TEXT_58);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_59);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_37);
    stringBuffer.append(outLabel );
    stringBuffer.append(TEXT_60);
    }else if (bIgnoreError){
    stringBuffer.append(TEXT_61);
    }else if (bDieOnError){
    stringBuffer.append(TEXT_62);
    }
    stringBuffer.append(TEXT_63);
    
    }//111
     
    if (bResetMain){
    
    stringBuffer.append(TEXT_42);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_64);
    stringBuffer.append(outconnName );
    stringBuffer.append(TEXT_44);
    
    }
     
    if (bResetalways){
    
    stringBuffer.append(TEXT_45);
    stringBuffer.append(outconnName );
    stringBuffer.append(TEXT_2);
    
    }
  }//manual end.

  stringBuffer.append("\n"); //control code format

  if (bOutputReject){//occure Reject
  
    stringBuffer.append(TEXT_65);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_66);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_67);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_68);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_69);
    stringBuffer.append(TEXT_45);
    stringBuffer.append(rejectConnName );
    stringBuffer.append(TEXT_70);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_28);
    stringBuffer.append(TEXT_45);
    stringBuffer.append(rejectConnName );
    stringBuffer.append(TEXT_71);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_72);
    stringBuffer.append(node.getUniqueName() );
    stringBuffer.append(TEXT_73);
    stringBuffer.append(TEXT_45);
    stringBuffer.append(rejectConnName );
    stringBuffer.append(TEXT_74);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_7);
    
  }//occure Reject end
  
    stringBuffer.append(TEXT_75);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_76);
    stringBuffer.append(TEXT_77);
    return stringBuffer.toString();
  }
}
