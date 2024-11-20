package org.talend.designer.codegen.translators.misc;

import org.talend.core.model.process.INode;
import org.talend.core.model.process.ElementParameterParser;
import org.talend.designer.codegen.config.CodeGeneratorArgument;
import org.talend.core.model.utils.NodeUtil;

public class TMsgBoxMainJava
{
  protected static String nl;
  public static synchronized TMsgBoxMainJava create(String lineSeparator)
  {
    nl = lineSeparator;
    TMsgBoxMainJava result = new TMsgBoxMainJava();
    nl = null;
    return result;
  }

  public final String NL = nl == null ? (System.getProperties().getProperty("line.separator")) : nl;
  protected final String TEXT_1 = "";
  protected final String TEXT_2 = NL + "\tint messageIcon";
  protected final String TEXT_3 = " = javax.swing.JOptionPane.";
  protected final String TEXT_4 = ";" + NL + "\tString title";
  protected final String TEXT_5 = " = ";
  protected final String TEXT_6 = ";" + NL + "\tString message";
  protected final String TEXT_7 = ";   \t" + NL + "\tString result";
  protected final String TEXT_8 = " = null; " + NL + "\t";
  protected final String TEXT_9 = NL + "\t\tjavax.swing.JOptionPane.showMessageDialog(null, message";
  protected final String TEXT_10 = ", title";
  protected final String TEXT_11 = ", messageIcon";
  protected final String TEXT_12 = ");" + NL + "\t\tresult";
  protected final String TEXT_13 = " = String.valueOf(1);";
  protected final String TEXT_14 = NL + "\t\t//javax.swing.JOptionPane.showOptionDialog(null, message";
  protected final String TEXT_15 = ", javax.swing.JOptionPane.YES_NO_OPTION, messageIcon";
  protected final String TEXT_16 = ", null, new String[] { \"OK\", \"Cancel\" }, null);" + NL + "\t\t//result";
  protected final String TEXT_17 = " = 1;" + NL + "\t\t" + NL + "\t\tresult";
  protected final String TEXT_18 = " = String.valueOf(javax.swing.JOptionPane.showOptionDialog(null, message";
  protected final String TEXT_19 = ", javax.swing.JOptionPane.OK_CANCEL_OPTION, messageIcon";
  protected final String TEXT_20 = ", null, new String[] { \"OK\", \"Cancel\" }, null));";
  protected final String TEXT_21 = NL + "\t\tresult";
  protected final String TEXT_22 = ", javax.swing.JOptionPane.YES_NO_CANCEL_OPTION, messageIcon";
  protected final String TEXT_23 = ", null, new String[] { \"Abort\", \"Retry\", \"Ignore\" }, null));";
  protected final String TEXT_24 = ", null, new String[] { \"Yes\", \"No\", \"Cancel\" }, null));";
  protected final String TEXT_25 = ", null, new String[] { \"Yes\", \"No\" }, null));";
  protected final String TEXT_26 = ", null, new String[] { \"Retry\", \"Cancel\" }, null));";
  protected final String TEXT_27 = NL + "        //mask Answer by '*'" + NL + "\t\tjavax.swing.JPasswordField text_";
  protected final String TEXT_28 = " = new javax.swing.JPasswordField(20);" + NL + "\t\ttext_";
  protected final String TEXT_29 = ".setEchoChar('*');" + NL + "    \tObject[] message_";
  protected final String TEXT_30 = " = { ";
  protected final String TEXT_31 = ", new javax.swing.JScrollPane(text_";
  protected final String TEXT_32 = ")};" + NL + "    \tjavax.swing.JOptionPane pane_";
  protected final String TEXT_33 = " = new javax.swing.JOptionPane(message_";
  protected final String TEXT_34 = ",javax.swing.JOptionPane.OK_CANCEL_OPTION);" + NL + "    \tjavax.swing.JDialog dialog_";
  protected final String TEXT_35 = " = pane_";
  protected final String TEXT_36 = ".createDialog(null, title";
  protected final String TEXT_37 = ");" + NL + "    \tdialog_";
  protected final String TEXT_38 = ".show();" + NL + "    \tif((pane_";
  protected final String TEXT_39 = ".getValue()!=null)&&(pane_";
  protected final String TEXT_40 = ".getValue().equals(0))){" + NL + "\t\t\tresult";
  protected final String TEXT_41 = " = new String(text_";
  protected final String TEXT_42 = ".getPassword());" + NL + "\t\t}else{" + NL + "\t\t\tresult";
  protected final String TEXT_43 = "=null;" + NL + "\t\t}";
  protected final String TEXT_44 = " = javax.swing.JOptionPane.showInputDialog(null, ";
  protected final String TEXT_45 = " , title";
  protected final String TEXT_46 = ");";
  protected final String TEXT_47 = NL + NL + "globalMap.put(\"";
  protected final String TEXT_48 = "_RESULT\", result";
  protected final String TEXT_49 = NL;

  public String generate(Object argument)
  {
    final StringBuffer stringBuffer = new StringBuffer();
    stringBuffer.append(TEXT_1);
    
	CodeGeneratorArgument codeGenArgument = (CodeGeneratorArgument) argument;
	INode node = (INode)codeGenArgument.getArgument();
	String cid = node.getUniqueName();
	
	int button = Integer.parseInt(ElementParameterParser.getValue(node, "__BUTTONS__"));
	boolean maskAnswer="true".equals(ElementParameterParser.getValue(node, "__ANSWER_MASK__"));
	String msg = ElementParameterParser.getValue(node, "__MESSAGE__");
	

    stringBuffer.append(TEXT_2);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_3);
    stringBuffer.append(ElementParameterParser.getValue(node, "__ICON__") );
    stringBuffer.append(TEXT_4);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_5);
    stringBuffer.append(ElementParameterParser.getValue(node, "__TITLE__") );
    stringBuffer.append(TEXT_6);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_5);
    stringBuffer.append(NodeUtil.replaceCRLFInMEMO_SQL(msg) );
    stringBuffer.append(TEXT_7);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_8);
    
	switch(button) {
		case 0:
		// 0) OK

    stringBuffer.append(TEXT_9);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_10);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_11);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_12);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_13);
    
			break;
		case 1:
		// 1) OK and Cancel

    stringBuffer.append(TEXT_14);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_10);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_15);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_16);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_17);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_18);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_10);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_19);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_20);
    
			break;
		case 2:
		// 2) Abort Retry Ignore

    stringBuffer.append(TEXT_21);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_18);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_10);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_22);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_23);
    
			break;
		case 3:
		// 3) Yes No and Cancel

    stringBuffer.append(TEXT_21);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_18);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_10);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_22);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_24);
    
			break;
		case 4:
		// 4) Yes and No

    stringBuffer.append(TEXT_21);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_18);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_10);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_15);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_25);
    
			break;
		case 5:
		// 5) Retry and Cancel

    stringBuffer.append(TEXT_21);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_18);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_10);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_15);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_26);
    
			break;
		case 6:
		// 6) Question
		if(maskAnswer){

    stringBuffer.append(TEXT_27);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_28);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_29);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_30);
    stringBuffer.append(ElementParameterParser.getValue(node, "__QUESTION_LABEL__") );
    stringBuffer.append(TEXT_31);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_32);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_33);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_11);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_34);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_35);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_36);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_37);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_38);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_39);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_40);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_41);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_42);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_43);
          }else{
    stringBuffer.append(TEXT_21);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_44);
    stringBuffer.append(ElementParameterParser.getValue(node, "__QUESTION_LABEL__") );
    stringBuffer.append(TEXT_45);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_11);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_46);
    
		}
			break;
		default:
			//do nothing
			break;
	}

    stringBuffer.append(TEXT_47);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_48);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_46);
    stringBuffer.append(TEXT_49);
    return stringBuffer.toString();
  }
}
