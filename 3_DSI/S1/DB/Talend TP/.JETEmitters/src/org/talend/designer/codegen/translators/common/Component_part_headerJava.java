package org.talend.designer.codegen.translators.common;

import org.talend.core.model.process.INode;
import org.talend.core.model.temp.ECodePart;
import org.talend.core.model.process.IConnection;
import org.talend.core.model.metadata.IMetadataTable;
import org.talend.core.model.metadata.IMetadataColumn;
import org.talend.core.model.process.EConnectionType;
import org.talend.core.model.process.ElementParameterParser;
import org.talend.core.model.process.EParameterFieldType;
import org.talend.designer.core.model.components.EParameterName;
import org.talend.designer.core.model.components.ElementParameter;
import org.talend.designer.codegen.config.CodeGeneratorArgument;
import org.talend.core.model.utils.NodeUtil;
import org.talend.core.model.process.IConnectionCategory;
import java.util.List;
import java.util.ArrayList;
import java.util.Set;
import java.util.HashSet;
import java.util.Iterator;

public class Component_part_headerJava
{
  protected static String nl;
  public static synchronized Component_part_headerJava create(String lineSeparator)
  {
    nl = lineSeparator;
    Component_part_headerJava result = new Component_part_headerJava();
    nl = null;
    return result;
  }

  public final String NL = nl == null ? (System.getProperties().getProperty("line.separator")) : nl;
  protected final String TEXT_1 = "";
  protected final String TEXT_2 = NL + "                if(log.is";
  protected final String TEXT_3 = "Enabled())";
  protected final String TEXT_4 = NL + "            log.";
  protected final String TEXT_5 = "(\"";
  protected final String TEXT_6 = " - \" ";
  protected final String TEXT_7 = " + (";
  protected final String TEXT_8 = ") ";
  protected final String TEXT_9 = ");";
  protected final String TEXT_10 = NL + "            if (log.isDebugEnabled()) {" + NL + "                class BytesLimit65535_";
  protected final String TEXT_11 = "{" + NL + "                    public void limitLog4jByte() throws Exception{" + NL + "                    StringBuilder ";
  protected final String TEXT_12 = " = new StringBuilder();";
  protected final String TEXT_13 = NL + "                    ";
  protected final String TEXT_14 = ".append(\"Parameters:\");";
  protected final String TEXT_15 = NL + "                            ";
  protected final String TEXT_16 = ".append(\"";
  protected final String TEXT_17 = "\" + \" = \" + String.valueOf(";
  protected final String TEXT_18 = ").substring(0, 4) + \"...\");     ";
  protected final String TEXT_19 = "\" + \" = \" + ";
  protected final String TEXT_20 = NL + "                        ";
  protected final String TEXT_21 = ".append(\" | \");";
  protected final String TEXT_22 = NL + "                    } " + NL + "                } " + NL + "            new BytesLimit65535_";
  protected final String TEXT_23 = "().limitLog4jByte();" + NL + "            }";
  protected final String TEXT_24 = NL + "            StringBuilder ";
  protected final String TEXT_25 = " = new StringBuilder();    ";
  protected final String TEXT_26 = ".append(";
  protected final String TEXT_27 = ".";
  protected final String TEXT_28 = NL + "                    if(";
  protected final String TEXT_29 = " == null){";
  protected final String TEXT_30 = ".append(\"<null>\");" + NL + "                    }else{";
  protected final String TEXT_31 = ");" + NL + "                    }   ";
  protected final String TEXT_32 = NL + "                ";
  protected final String TEXT_33 = ".append(\"|\");";
  protected final String TEXT_34 = NL + "\t" + NL + "\t/**" + NL + "\t * [";
  protected final String TEXT_35 = " ";
  protected final String TEXT_36 = " ] start" + NL + "\t */" + NL + "" + NL + "\t";
  protected final String TEXT_37 = NL + "\t\t\t\tTalendThreadPool mtp_";
  protected final String TEXT_38 = " = new TalendThreadPool(";
  protected final String TEXT_39 = ");" + NL + "" + NL + "\t\t\t\tglobalMap.put(\"lockWrite_";
  protected final String TEXT_40 = "\", new Object[0]);" + NL + "\t\t\t\tint threadIdCounter_";
  protected final String TEXT_41 = " =0;" + NL + "\t\t\t";
  protected final String TEXT_42 = "\t\t\t" + NL + "\t\t\tint NB_ITERATE_";
  protected final String TEXT_43 = " = 0; //for statistics" + NL + "\t\t\t";
  protected final String TEXT_44 = NL + NL + "\t";
  protected final String TEXT_45 = NL + "\t\t";
  protected final String TEXT_46 = NL + "\t\t\tglobalMap.put(\"ENABLE_TRACES_CONNECTION_";
  protected final String TEXT_47 = "\",Boolean.FALSE);" + NL + "\t\t";
  protected final String TEXT_48 = NL + "\t\tok_Hash.put(\"";
  protected final String TEXT_49 = "\", false);" + NL + "\t\tstart_Hash.put(\"";
  protected final String TEXT_50 = "\", System.currentTimeMillis());" + NL + "\t\t";
  protected final String TEXT_51 = NL + "\t\t\t\t";
  protected final String TEXT_52 = ".addMessage(\"begin\",\"";
  protected final String TEXT_53 = "\");" + NL + "\t\t\t\t";
  protected final String TEXT_54 = "Process(globalMap);" + NL + "\t\t\t";
  protected final String TEXT_55 = NL + "    \t\t\t\t";
  protected final String TEXT_56 = NL + "    \t\t\t\t\t\t";
  protected final String TEXT_57 = ".addLineToRow(\"";
  protected final String TEXT_58 = "_count\");" + NL + "    \t\t\t\t\t";
  protected final String TEXT_59 = NL + "\t";
  protected final String TEXT_60 = NL + "\t\tcurrentVirtualComponent = \"";
  protected final String TEXT_61 = "\";" + NL + "\t";
  protected final String TEXT_62 = NL + "\tcurrentComponent=\"";
  protected final String TEXT_63 = "\";" + NL + "" + NL + "\t";
  protected final String TEXT_64 = NL + "\t\t\tif(";
  protected final String TEXT_65 = "execStat";
  protected final String TEXT_66 = " || ";
  protected final String TEXT_67 = "enableLogStash";
  protected final String TEXT_68 = ") {" + NL + "\t\t\t\trunStat.updateStatOnConnectionAndLog(resourceMap,globalMap,iterateLoop,iterateId,";
  protected final String TEXT_69 = "false";
  protected final String TEXT_70 = ",enableLogStash,0";
  protected final String TEXT_71 = ",\"";
  protected final String TEXT_72 = "\"";
  protected final String TEXT_73 = ");" + NL + "\t\t\t}" + NL + "\t\t\t";
  protected final String TEXT_74 = NL + "\t\t\trunStat.updateStatAndLog(execStat,enableLogStash,resourceMap,iterateId,0,0";
  protected final String TEXT_75 = ");" + NL + "\t\t\t";
  protected final String TEXT_76 = NL + "\t\t\t\t\tif(execStat) {" + NL + "\t\t\t\t\t\trunStat.updateStatOnConnection(resourceMap,iterateId,0,0";
  protected final String TEXT_77 = ");" + NL + "\t\t\t\t\t}" + NL + "\t\t\t\t";
  protected final String TEXT_78 = NL + "\t\t\t\t\tif(enableLogStash) {" + NL + "\t\t\t\t\t\trunStat.log(resourceMap,iterateId,0,0";
  protected final String TEXT_79 = NL + "\t\t\tif(runStat.update(execStat,enableLogStash,iterateId,1,1" + NL + "\t\t\t\t";
  protected final String TEXT_80 = NL + "\t\t\t\t\t,\"";
  protected final String TEXT_81 = "\",\"";
  protected final String TEXT_82 = "\"" + NL + "\t\t\t\t";
  protected final String TEXT_83 = NL + "\t\t\t)) {" + NL + "\t\t\t\t";
  protected final String TEXT_84 = "Process(globalMap);" + NL + "\t\t\t}" + NL + "\t\t\t";
  protected final String TEXT_85 = NL + "\t\t\t\t\tif(execStat){" + NL + "\t\t\t\t\t\trunStat.updateStatOnConnection(iterateId,1,1" + NL + "\t\t\t\t\t\t";
  protected final String TEXT_86 = NL + "\t\t\t\t\t\t\t,\"";
  protected final String TEXT_87 = "\"" + NL + "\t\t\t\t\t\t";
  protected final String TEXT_88 = NL + "\t\t\t\t\t\t);" + NL + "\t\t\t\t\t}" + NL + "\t\t\t\t\t";
  protected final String TEXT_89 = NL + "\t\t\t\t\tif(enableLogStash) {" + NL + "\t\t\t\t\t\tif(runStat.updateLog(iterateId,1,1" + NL + "\t\t\t\t\t\t";
  protected final String TEXT_90 = NL + "\t\t\t\t\t\t)) {" + NL + "\t\t\t\t\t\t\t";
  protected final String TEXT_91 = "Process(globalMap);" + NL + "\t\t\t\t\t\t}" + NL + "\t\t\t\t\t}" + NL + "\t\t\t\t\t";
  protected final String TEXT_92 = NL + "\t\t\t\t\tif(runStat.update(execStat,enableLogStash,iterateId,1,1" + NL + "\t\t\t\t\t\t";
  protected final String TEXT_93 = "\"" + NL + "\t\t\t\t\t\t\t";
  protected final String TEXT_94 = NL + "\t\t\t\t\t)) {" + NL + "\t\t\t\t\t\t";
  protected final String TEXT_95 = "Process(globalMap);" + NL + "\t\t\t\t\t}" + NL + "\t\t\t\t\t";
  protected final String TEXT_96 = NL + "\t\t\t\t\t\tif(execStat){" + NL + "\t\t\t\t\t\t\trunStat.updateStatOnConnection(iterateId,1,1" + NL + "\t\t\t\t\t\t\t\t";
  protected final String TEXT_97 = NL + "\t\t\t\t\t\t\t\t\t,\"";
  protected final String TEXT_98 = "\"" + NL + "\t\t\t\t\t\t\t\t\t";
  protected final String TEXT_99 = NL + "\t\t\t\t\t\t\t);" + NL + "\t\t\t\t\t\t}" + NL + "\t\t\t\t\t\t";
  protected final String TEXT_100 = NL + "\t\t\t\t\t\tif(enableLogStash) {" + NL + "\t\t\t\t\t\t\tif(runStat.updateLog(iterateId,1,1" + NL + "\t\t\t\t\t\t\t\t";
  protected final String TEXT_101 = NL + "\t\t\t\t\t\t\t)) {" + NL + "\t\t\t\t\t\t\t\t";
  protected final String TEXT_102 = "Process(globalMap);" + NL + "\t\t\t\t\t\t\t}" + NL + "\t\t\t\t\t\t}" + NL + "\t\t\t\t\t\t";
  protected final String TEXT_103 = NL + "    \t\t\tif(log.isTraceEnabled()){" + NL + "    \t\t\t\tlog.trace(\"";
  protected final String TEXT_104 = " - \" + (";
  protected final String TEXT_105 = "==null? \"\": ";
  protected final String TEXT_106 = ".toLogString()));" + NL + "    \t\t\t}" + NL + "    \t\t";
  protected final String TEXT_107 = NL + "\t\tint tos_count_";
  protected final String TEXT_108 = " = 0;" + NL + "\t\t";
  protected final String TEXT_109 = NL + "\t\tclass ParameterUtil_";
  protected final String TEXT_110 = "{" + NL + "\t\t" + NL + "            public java.util.Map<String, String> getParameter() throws Exception{" + NL + "                java.util.Map<String, String> component_parameters = new java.util.HashMap<>();";
  protected final String TEXT_111 = NL;
  protected final String TEXT_112 = NL + "                        component_parameters.put(\"";
  protected final String TEXT_113 = "\",String.valueOf(";
  protected final String TEXT_114 = "));";
  protected final String TEXT_115 = "[";
  protected final String TEXT_116 = "]\", \"";
  protected final String TEXT_117 = "\");";
  protected final String TEXT_118 = NL + "                  ";
  protected final String TEXT_119 = NL + "                    component_parameters.put(\"";
  protected final String TEXT_120 = "\", String.valueOf(";
  protected final String TEXT_121 = NL + "                return component_parameters;" + NL + "            }" + NL + "        }" + NL + "        ";
  protected final String TEXT_122 = NL + "        ";
  protected final String TEXT_123 = ".addComponentParameterMessage(\"";
  protected final String TEXT_124 = "\", \"";
  protected final String TEXT_125 = "\"," + NL + "          new ParameterUtil_";
  protected final String TEXT_126 = "().getParameter());";
  protected final String TEXT_127 = "Process(globalMap);" + NL + "\t\t";
  protected final String TEXT_128 = NL + "\t\t\tif(enableLogStash) {" + NL + "\t\t\t\t";
  protected final String TEXT_129 = ".addCM(\"";
  protected final String TEXT_130 = NL + "\t\t\t\tif(";
  protected final String TEXT_131 = "){" + NL + "\t\t\t\t\trunStat.updateStatOnConnectionAndLog(globalMap,iterateLoop,iterateId,";
  protected final String TEXT_132 = ");" + NL + "\t\t\t\t}" + NL + "\t\t\t\t";
  protected final String TEXT_133 = NL + "\t\t\t\t\trunStat.updateStatAndLog(execStat,enableLogStash,iterateId,0,0";
  protected final String TEXT_134 = ");" + NL + "\t\t\t\t\t";
  protected final String TEXT_135 = NL + "\t\t\t\t\t\tif(execStat){" + NL + "\t\t\t\t\t\t\trunStat.updateStatOnConnection(iterateId,0,0";
  protected final String TEXT_136 = ");" + NL + "\t\t\t\t\t\t}" + NL + "\t\t\t\t\t\t";
  protected final String TEXT_137 = NL + "\t\t\t\t\t\t" + NL + "\t\t\t\t\t\t";
  protected final String TEXT_138 = NL + "\t\t\t\t\t\tif(enableLogStash){" + NL + "\t\t\t\t\t\t\trunStat.log(iterateId,0,0";
  protected final String TEXT_139 = NL + "\t\t\t\tresourceMap.put(\"inIterateVComp\", true);" + NL + "\t\t\t";
  protected final String TEXT_140 = NL + "\t\t\t\tresourceMap.remove(\"inIterateVComp\");" + NL + "\t\t\t";
  protected final String TEXT_141 = NL + "\t\t\t\t\t\tresourceMap.remove(\"inIterateVComp\");" + NL + "\t\t\t\t\t";
  protected final String TEXT_142 = NL + "\t\t\t\t\t\tresourceMap.put(\"inIterateVComp\", true);" + NL + "\t\t\t\t\t";

  public String generate(Object argument)
  {
    final StringBuffer stringBuffer = new StringBuffer();
    stringBuffer.append(TEXT_1);
    
class BasicLogUtil{
    protected String cid  = "";
    protected org.talend.core.model.process.INode node = null;
    protected boolean log4jEnabled = false;
    private String logID = "";
    
    private BasicLogUtil(){}
    
    public BasicLogUtil(org.talend.core.model.process.INode node){
        this.node = node;
        String cidx = this.node.getUniqueName();
        if(cidx.matches("^.*?tAmazonAuroraOutput_\\d+_out$") || cidx.matches("^.*?tDBOutput_\\d+_out$")){
             cidx = cidx.substring(0,cidx.length()-4);// 4 ==> "_out".length();
        }
        this.cid = cidx;
        this.log4jEnabled = ("true").equals(org.talend.core.model.process.ElementParameterParser.getValue(this.node.getProcess(), "__LOG4J_ACTIVATE__"));
        this.log4jEnabled = this.log4jEnabled &&
                            this.node.getComponent().isLog4JEnabled() && !"JOBLET".equals(node.getComponent().getComponentType().toString());
        this.logID = this.cid;
    }
    
    public String var(String varName){
        return varName + "_" + this.cid;
    }
	
	public String varForTableName(String varName, String dbmsId) {
		if ("id_MSSQL".equals(dbmsId) || cid.startsWith("tMSSQL")) {
			return "\"[\" +" + var(varName) + " + \"]\"";
		} else if ("ibmdb2_id".equals(dbmsId) || "redshift_id".equals(dbmsId) || "postgres_id".equals(dbmsId) || cid.startsWith("tDB2") || 
			cid.startsWith("tRedshift") || cid.startsWith("tGreenplum")){
			return new StringBuilder().append("\"\\\"\" +").append(var(varName)).append("+ \"\\\"\"").toString();
		} else {
			return var(varName);
		}
	}
    public String str(String content){
        return "\"" + content + "\"";
    }
    
    public void info(String... message){
        log4j("info", message);
    }
    
    public void debug(String... message){
        log4j("debug", message);
    }
    
    public void warn(String... message){
        log4j("warn", message);
    }
    
    public void error(String... message){
        log4j("error", message);
    }
    
    public void fatal(String... message){
        log4j("fatal", message);
    }
    
    public void trace(String... message){
        log4j("trace", message);
    }
    java.util.List<String> checkableList = java.util.Arrays.asList(new String[]{"info", "debug", "trace"});     
    public void log4j(String level, String... messages){
        if(this.log4jEnabled){
            if(checkableList.contains(level)){
            
    stringBuffer.append(TEXT_2);
    stringBuffer.append(level.substring(0, 1).toUpperCase() + level.substring(1));
    stringBuffer.append(TEXT_3);
    
            }
            
    stringBuffer.append(TEXT_4);
    stringBuffer.append(level);
    stringBuffer.append(TEXT_5);
    stringBuffer.append(logID);
    stringBuffer.append(TEXT_6);
    for(String message : messages){
    stringBuffer.append(TEXT_7);
    stringBuffer.append(message);
    stringBuffer.append(TEXT_8);
    }
    stringBuffer.append(TEXT_9);
    
        }
    }
    
    public boolean isActive(){
        return this.log4jEnabled;
    }
}

class LogUtil extends BasicLogUtil{
    
    private LogUtil(){
    }
    
    public LogUtil(org.talend.core.model.process.INode node){
        super(node);
    }
    
    public void startWork(){
        debug(str("Start to work."));
    }
    
    public void endWork(){
        debug(str("Done."));
    }
    
    public void logIgnoredException(String exception){
        warn(exception);
    }
    
    public void logPrintedException(String exception){
        error(exception);
    }
    
    public void logException(String exception){
        fatal(exception);
    }
    
    public void logCompSetting(){
    
    
        if(log4jEnabled){
        
    stringBuffer.append(TEXT_10);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_11);
    stringBuffer.append(var("log4jParamters"));
    stringBuffer.append(TEXT_12);
    stringBuffer.append(TEXT_13);
    stringBuffer.append(var("log4jParamters"));
    stringBuffer.append(TEXT_14);
    
                    java.util.Set<org.talend.core.model.process.EParameterFieldType> ignoredParamsTypes = new java.util.HashSet<org.talend.core.model.process.EParameterFieldType>(); 
                    ignoredParamsTypes.addAll(
                        java.util.Arrays.asList(
                            org.talend.core.model.process.EParameterFieldType.SCHEMA_TYPE,
                            org.talend.core.model.process.EParameterFieldType.LABEL,
                            org.talend.core.model.process.EParameterFieldType.EXTERNAL,
                            org.talend.core.model.process.EParameterFieldType.MAPPING_TYPE,
                            org.talend.core.model.process.EParameterFieldType.IMAGE,
                            org.talend.core.model.process.EParameterFieldType.TNS_EDITOR,
                            org.talend.core.model.process.EParameterFieldType.WSDL2JAVA,
                            org.talend.core.model.process.EParameterFieldType.GENERATEGRAMMARCONTROLLER,
                            org.talend.core.model.process.EParameterFieldType.GENERATE_SURVIVORSHIP_RULES_CONTROLLER,
                            org.talend.core.model.process.EParameterFieldType.REFRESH_REPORTS,
                            org.talend.core.model.process.EParameterFieldType.BROWSE_REPORTS,
                            org.talend.core.model.process.EParameterFieldType.PALO_DIM_SELECTION,
                            org.talend.core.model.process.EParameterFieldType.GUESS_SCHEMA,
                            org.talend.core.model.process.EParameterFieldType.MATCH_RULE_IMEX_CONTROLLER,
                            org.talend.core.model.process.EParameterFieldType.MEMO_PERL,
                            org.talend.core.model.process.EParameterFieldType.DBTYPE_LIST,
                            org.talend.core.model.process.EParameterFieldType.VERSION,
                            org.talend.core.model.process.EParameterFieldType.TECHNICAL,
                            org.talend.core.model.process.EParameterFieldType.ICON_SELECTION,
                            org.talend.core.model.process.EParameterFieldType.JAVA_COMMAND,
                            org.talend.core.model.process.EParameterFieldType.TREE_TABLE,
                            org.talend.core.model.process.EParameterFieldType.VALIDATION_RULE_TYPE,
                            org.talend.core.model.process.EParameterFieldType.DCSCHEMA,
                            org.talend.core.model.process.EParameterFieldType.SURVIVOR_RELATION,
                            org.talend.core.model.process.EParameterFieldType.REST_RESPONSE_SCHEMA_TYPE
                            )
                    );
                    for(org.talend.core.model.process.IElementParameter ep : org.talend.core.model.utils.NodeUtil.getDisplayedParameters(node)){
                        if(!ep.isLog4JEnabled() || ignoredParamsTypes.contains(ep.getFieldType())){
                            continue;
                        }
                        String name = ep.getName();
                        if(org.talend.core.model.process.EParameterFieldType.PASSWORD.equals(ep.getFieldType())){
                            String epName = "__" + name + "__";
                            String password = "";
                            if(org.talend.core.model.process.ElementParameterParser.canEncrypt(node, epName)){
                                password = org.talend.core.model.process.ElementParameterParser.getEncryptedValue(node, epName);
                            }else{
                                String passwordValue = org.talend.core.model.process.ElementParameterParser.getValue(node, epName);
                                if (passwordValue == null || "".equals(passwordValue.trim())) {// for the value which empty
                                    passwordValue = "\"\"";
                                } 
                                password = "routines.system.PasswordEncryptUtil.encryptPassword(" + passwordValue + ")";
                            } 
                            
    stringBuffer.append(TEXT_15);
    stringBuffer.append(var("log4jParamters"));
    stringBuffer.append(TEXT_16);
    stringBuffer.append(name);
    stringBuffer.append(TEXT_17);
    stringBuffer.append(password);
    stringBuffer.append(TEXT_18);
    
                        }else{
                            String value = org.talend.core.model.utils.NodeUtil.getNormalizeParameterValue(node, ep);
                            if(value.length()>10000){
                            value = org.talend.core.model.utils.NodeUtil.replaceCRLFInMEMO_SQL(value);
                            }
                            
    stringBuffer.append(TEXT_15);
    stringBuffer.append(var("log4jParamters"));
    stringBuffer.append(TEXT_16);
    stringBuffer.append(name);
    stringBuffer.append(TEXT_19);
    stringBuffer.append(value);
    stringBuffer.append(TEXT_9);
    
                        }   
                        
    stringBuffer.append(TEXT_20);
    stringBuffer.append(var("log4jParamters"));
    stringBuffer.append(TEXT_21);
    
                    }
                    debug(var("log4jParamters")); 
                    
    stringBuffer.append(TEXT_22);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_23);
    
        } 
        
    
    } 
    
    //no use for now, because we log the data by rowStruct
    public void traceData(String rowStruct, java.util.List<org.talend.core.model.metadata.IMetadataColumn> columnList, String nbline){
        if(log4jEnabled){
        
    stringBuffer.append(TEXT_24);
    stringBuffer.append(var("log4jSb"));
    stringBuffer.append(TEXT_25);
    
            for(org.talend.core.model.metadata.IMetadataColumn column : columnList){
                org.talend.core.model.metadata.types.JavaType javaType = org.talend.core.model.metadata.types.JavaTypesManager.getJavaTypeFromId(column.getTalendType());
                String columnName = column.getLabel();
                boolean isPrimit = org.talend.core.model.metadata.types.JavaTypesManager.isJavaPrimitiveType(column.getTalendType(), column.isNullable());
                if(isPrimit){
                
    stringBuffer.append(TEXT_13);
    stringBuffer.append(var("log4jSb"));
    stringBuffer.append(TEXT_26);
    stringBuffer.append(rowStruct);
    stringBuffer.append(TEXT_27);
    stringBuffer.append(columnName);
    stringBuffer.append(TEXT_9);
    
                }else{
                
    stringBuffer.append(TEXT_28);
    stringBuffer.append(rowStruct);
    stringBuffer.append(TEXT_27);
    stringBuffer.append(columnName);
    stringBuffer.append(TEXT_29);
    stringBuffer.append(TEXT_20);
    stringBuffer.append(var("log4jSb"));
    stringBuffer.append(TEXT_30);
    stringBuffer.append(TEXT_20);
    stringBuffer.append(var("log4jSb"));
    stringBuffer.append(TEXT_26);
    stringBuffer.append(rowStruct);
    stringBuffer.append(TEXT_27);
    stringBuffer.append(columnName);
    stringBuffer.append(TEXT_31);
    
                }
                
    stringBuffer.append(TEXT_32);
    stringBuffer.append(var("log4jSb"));
    stringBuffer.append(TEXT_33);
    
            }
        }
        trace(str("Content of the record "), nbline, str(": "), var("log4jSb"));
        
    
    }
}

class LogHelper{
    
    java.util.Map<String, String> pastDict = null;
    
    public LogHelper(){
        pastDict = new java.util.HashMap<String, String>();
        pastDict.put("insert", "inserted");
        pastDict.put("update", "updated");
        pastDict.put("delete", "deleted");
        pastDict.put("upsert", "upserted");
    }   
    
    public String upperFirstChar(String data){ 
        return data.substring(0, 1).toUpperCase() + data.substring(1);
    }
    
    public String toPastTense(String data){
        return pastDict.get(data);
    }
}
LogHelper logHelper = new LogHelper();

LogUtil log = null;

    
	CodeGeneratorArgument codeGenArgument = (CodeGeneratorArgument) argument;
	INode node = (INode)codeGenArgument.getArgument();
	log = new LogUtil(node);
	boolean isLog4jEnabled = ("true").equals(ElementParameterParser.getValue(node.getProcess(), "__LOG4J_ACTIVATE__"));
	boolean containsTPartitioner = node.getProcess().getNodesOfType("tPartitioner").size() > 0 ? true : false;
	String startNodeCid=node.getDesignSubjobStartNode().getUniqueName();
	ECodePart codePart = codeGenArgument.getCodePart();
	boolean trace = codeGenArgument.isTrace();
	boolean stat = codeGenArgument.isStatistics();
	Set<IConnection> connSet =  new HashSet<IConnection>();
	connSet.addAll(node.getOutgoingConnections(EConnectionType.FLOW_MAIN));
	connSet.addAll(node.getOutgoingConnections(EConnectionType.FLOW_MERGE));
	String incomingName = codeGenArgument.getIncomingName();
	
	Set<IConnection> iterateConnSet =  new HashSet<IConnection>();
	iterateConnSet.addAll(node.getOutgoingConnections(EConnectionType.ITERATE));
	
	List<IConnection> allSubProcessConnection = codeGenArgument.getAllMainSubTreeConnections();

    stringBuffer.append(TEXT_34);
    stringBuffer.append(node.getUniqueName() );
    stringBuffer.append(TEXT_35);
    stringBuffer.append(codePart );
    stringBuffer.append(TEXT_36);
    
    //This part in order to feedback with the iterate_subprocess_header.javajet and iterate_subprocess_footer.javajet
    
	if (codePart.equals(ECodePart.BEGIN)) {
		boolean parallelIterate = false;
		boolean hasParallelIterate = false;
		for (IConnection iterateConn : iterateConnSet) { 
			parallelIterate = "true".equals(ElementParameterParser.getValue(iterateConn, "__ENABLE_PARALLEL__"));
			String iterateNodeName = iterateConn.getTarget().getUniqueName();
	        if (parallelIterate) {
			
    stringBuffer.append(TEXT_37);
    stringBuffer.append(iterateConn.getTarget().getUniqueName() );
    stringBuffer.append(TEXT_38);
    stringBuffer.append(ElementParameterParser.getValue(iterateConn,"__NUMBER_PARALLEL__") );
    stringBuffer.append(TEXT_39);
    stringBuffer.append(iterateNodeName);
    stringBuffer.append(TEXT_40);
    stringBuffer.append(iterateNodeName);
    stringBuffer.append(TEXT_41);
    
			}
			
    stringBuffer.append(TEXT_42);
    stringBuffer.append(iterateNodeName );
    stringBuffer.append(TEXT_43);
    			
			continue;
		}
	}	
	
    stringBuffer.append(TEXT_44);
    
	if (codePart.equals(ECodePart.BEGIN)) {
	
    stringBuffer.append(TEXT_45);
    
		if(trace){ 
		
    stringBuffer.append(TEXT_46);
    stringBuffer.append(startNodeCid);
    stringBuffer.append(TEXT_47);
    
		}
		
    stringBuffer.append(TEXT_48);
    stringBuffer.append(node.getUniqueName() );
    stringBuffer.append(TEXT_49);
    stringBuffer.append(node.getUniqueName() );
    stringBuffer.append(TEXT_50);
    
		String statCatcher = ElementParameterParser.getValue(node,"__TSTATCATCHER_STATS__");
		if ((node.getProcess().getNodesOfType("tStatCatcher").size() > 0) && (statCatcher.equals("true"))) {
			for (INode statCatcherNode : node.getProcess().getNodesOfType("tStatCatcher")) {
			
    stringBuffer.append(TEXT_51);
    stringBuffer.append(statCatcherNode.getUniqueName() );
    stringBuffer.append(TEXT_52);
    stringBuffer.append(node.getUniqueName() );
    stringBuffer.append(TEXT_53);
    stringBuffer.append(statCatcherNode.getDesignSubjobStartNode().getUniqueName() );
    stringBuffer.append(TEXT_54);
    
			}
		}
	}
	if(codePart.equals(ECodePart.MAIN)) {
		List<INode> meterCatchers = (List<INode>)node.getProcess().getNodesOfType("tFlowMeterCatcher");	
	    if ((node.getProcess().getNodesOfType("tFlowMeter").size() > 0)){
        	for(IConnection temp_conn : node.getIncomingConnections(EConnectionType.FLOW_MAIN)){
        	    String name_conn = temp_conn.getUniqueName();
        	    if(temp_conn.isUseByMetter()){ 	    	
				
    stringBuffer.append(TEXT_55);
    
		            if (meterCatchers != null) {
		        		for (INode meterCatcher : meterCatchers) {
    					
    stringBuffer.append(TEXT_56);
    stringBuffer.append(meterCatcher.getUniqueName() );
    stringBuffer.append(TEXT_57);
    stringBuffer.append(name_conn);
    stringBuffer.append(TEXT_58);
    
		        		}
		        	}
				}
			}
			
			for(IConnection temp_conn : node.getIncomingConnections(EConnectionType.FLOW_MERGE)){
        	    String name_conn = temp_conn.getUniqueName();
        	    if(name_conn == incomingName && temp_conn.isUseByMetter()){ 	    	
            		if (meterCatchers != null) {
		        		for (INode meterCatcher : meterCatchers) {
    					
    stringBuffer.append(TEXT_56);
    stringBuffer.append(meterCatcher.getUniqueName() );
    stringBuffer.append(TEXT_57);
    stringBuffer.append(name_conn);
    stringBuffer.append(TEXT_58);
    
		        		}
		        	}
				}
			}			
	    }
	}
	
    stringBuffer.append(TEXT_59);
    
	if(node.isVirtualGenerateNode()){
	
    stringBuffer.append(TEXT_60);
    stringBuffer.append(NodeUtil.getVirtualUniqueName(node));
    stringBuffer.append(TEXT_61);
    
	}
	
    stringBuffer.append(TEXT_62);
    stringBuffer.append(node.getUniqueName() );
    stringBuffer.append(TEXT_63);
    
	connSet =  new HashSet<IConnection>();
	connSet.addAll(node.getIncomingConnections(EConnectionType.FLOW_MAIN));
	connSet.addAll(node.getIncomingConnections(EConnectionType.FLOW_MERGE));
	
	String cid = node.getUniqueName();
	
	List<? extends INode> jobCatcherNodes = node.getProcess().getNodesOfType("tJobStructureCatcher");
	boolean jobCatcherExists = jobCatcherNodes != null && !jobCatcherNodes.isEmpty();
	INode jobCatcherNode = jobCatcherExists ? jobCatcherNodes.get(0) : null;
	
	boolean enableLogStash = !Boolean.getBoolean("deactivate_extended_component_log") && jobCatcherExists;
	boolean logstashCurrent = enableLogStash && !cid.startsWith("tJobStructureCatcher") && !cid.startsWith("talend");
	
	//about performance monitor, no way to support more than one job catcher component, also that is not necessary
	final String subprocessName4Catcher = logstashCurrent ? jobCatcherNodes.get(0).getDesignSubjobStartNode().getUniqueName() : null;
	
	if ((codePart.equals(ECodePart.BEGIN))&&(stat || logstashCurrent)&&connSet.size()>0) {
		if(containsTPartitioner) {
			
    stringBuffer.append(TEXT_64);
    if(stat){
    stringBuffer.append(TEXT_65);
    }
    if(stat && logstashCurrent){
    stringBuffer.append(TEXT_66);
    }
    if(logstashCurrent){
    stringBuffer.append(TEXT_67);
    }
    stringBuffer.append(TEXT_68);
    if(stat){
    stringBuffer.append(TEXT_65);
    } else {
    stringBuffer.append(TEXT_69);
    }
    stringBuffer.append(TEXT_70);
    for(IConnection con : connSet){
    stringBuffer.append(TEXT_71);
    stringBuffer.append(con.getUniqueName());
    stringBuffer.append(TEXT_72);
    }
    stringBuffer.append(TEXT_73);
    
		} else {
			if(stat && logstashCurrent) {
			
    stringBuffer.append(TEXT_74);
    for(IConnection con : connSet){
    stringBuffer.append(TEXT_71);
    stringBuffer.append(con.getUniqueName());
    stringBuffer.append(TEXT_72);
    }
    stringBuffer.append(TEXT_75);
    
			} else {
				if(stat) {
				
    stringBuffer.append(TEXT_76);
    for(IConnection con : connSet){
    stringBuffer.append(TEXT_71);
    stringBuffer.append(con.getUniqueName());
    stringBuffer.append(TEXT_72);
    }
    stringBuffer.append(TEXT_77);
    
				}
				
				if(logstashCurrent) {
				
    stringBuffer.append(TEXT_78);
    for(IConnection con : connSet){
    stringBuffer.append(TEXT_71);
    stringBuffer.append(con.getUniqueName());
    stringBuffer.append(TEXT_72);
    }
    stringBuffer.append(TEXT_77);
    
				}
			}
		}
	}
	
	if((codePart.equals(ECodePart.MAIN))&&(stat || logstashCurrent)&&connSet.size()>0){
		if(!node.getComponent().useMerge()) {
			if(stat && logstashCurrent) {
			
    stringBuffer.append(TEXT_79);
    for(IConnection con : connSet){
					INode source = con.getSource();
					String sourceNodeId = source.getUniqueName();
					
					String sourceLabel = ElementParameterParser.getValue(source, "__LABEL__");
					String sourceNodeLabel = ((sourceLabel==null || "__UNIQUE_NAME__".equals(sourceLabel) || sourceLabel.contains("\"")) ? sourceNodeId : sourceLabel.trim());
					
					String targetLabel = ElementParameterParser.getValue(node, "__LABEL__");
					String targetNodeLabel = ((targetLabel==null || "__UNIQUE_NAME__".equals(targetLabel) || targetLabel.contains("\"")) ? node.getUniqueName() : targetLabel.trim());
					
					String sourceNodeComponent = source.getComponent().getName();
				
    stringBuffer.append(TEXT_80);
    stringBuffer.append(con.getUniqueName());
    stringBuffer.append(TEXT_81);
    stringBuffer.append(sourceNodeId);
    stringBuffer.append(TEXT_81);
    stringBuffer.append(sourceNodeLabel);
    stringBuffer.append(TEXT_81);
    stringBuffer.append(sourceNodeComponent);
    stringBuffer.append(TEXT_81);
    stringBuffer.append(node.getUniqueName());
    stringBuffer.append(TEXT_81);
    stringBuffer.append(targetNodeLabel);
    stringBuffer.append(TEXT_81);
    stringBuffer.append(node.getComponent().getName());
    stringBuffer.append(TEXT_82);
    }
    stringBuffer.append(TEXT_83);
    stringBuffer.append(subprocessName4Catcher );
    stringBuffer.append(TEXT_84);
    
			} else {
				if(stat) {
					
    stringBuffer.append(TEXT_85);
    for(IConnection con : connSet){
						
    stringBuffer.append(TEXT_86);
    stringBuffer.append(con.getUniqueName());
    stringBuffer.append(TEXT_87);
    }
    stringBuffer.append(TEXT_88);
    
				}
				
				if(logstashCurrent) {
					
    stringBuffer.append(TEXT_89);
    for(IConnection con : connSet){
							INode source = con.getSource();
							String sourceNodeId = source.getUniqueName();
							
							String sourceLabel = ElementParameterParser.getValue(source, "__LABEL__");
							String sourceNodeLabel = ((sourceLabel==null || "__UNIQUE_NAME__".equals(sourceLabel) || sourceLabel.contains("\"")) ? sourceNodeId : sourceLabel.trim());
							
							String targetLabel = ElementParameterParser.getValue(node, "__LABEL__");
							String targetNodeLabel = ((targetLabel==null || "__UNIQUE_NAME__".equals(targetLabel) || targetLabel.contains("\"")) ? node.getUniqueName() : targetLabel.trim());
							
							String sourceNodeComponent = source.getComponent().getName();
						
    stringBuffer.append(TEXT_86);
    stringBuffer.append(con.getUniqueName());
    stringBuffer.append(TEXT_81);
    stringBuffer.append(sourceNodeId);
    stringBuffer.append(TEXT_81);
    stringBuffer.append(sourceNodeLabel);
    stringBuffer.append(TEXT_81);
    stringBuffer.append(sourceNodeComponent);
    stringBuffer.append(TEXT_81);
    stringBuffer.append(node.getUniqueName());
    stringBuffer.append(TEXT_81);
    stringBuffer.append(targetNodeLabel);
    stringBuffer.append(TEXT_81);
    stringBuffer.append(node.getComponent().getName());
    stringBuffer.append(TEXT_87);
    }
    stringBuffer.append(TEXT_90);
    stringBuffer.append(subprocessName4Catcher );
    stringBuffer.append(TEXT_91);
    
				}
			}
		} else {
			for(IConnection connection:connSet){
				if(connection.getUniqueName().equals((String)codeGenArgument.getIncomingName())){
					if(stat && logstashCurrent) {
					
    stringBuffer.append(TEXT_92);
    for(IConnection con : connSet){
							INode source = con.getSource();
							String sourceNodeId = source.getUniqueName();
							
							String sourceLabel = ElementParameterParser.getValue(source, "__LABEL__");
							String sourceNodeLabel = ((sourceLabel==null || "__UNIQUE_NAME__".equals(sourceLabel) || sourceLabel.contains("\"")) ? sourceNodeId : sourceLabel.trim());
							
							String targetLabel = ElementParameterParser.getValue(node, "__LABEL__");
							String targetNodeLabel = ((targetLabel==null || "__UNIQUE_NAME__".equals(targetLabel) || targetLabel.contains("\"")) ? node.getUniqueName() : targetLabel.trim());
							
							String sourceNodeComponent = source.getComponent().getName();
							
							if(con.getUniqueName().equals((String)codeGenArgument.getIncomingName())){
    stringBuffer.append(TEXT_86);
    stringBuffer.append(con.getUniqueName());
    stringBuffer.append(TEXT_81);
    stringBuffer.append(sourceNodeId);
    stringBuffer.append(TEXT_81);
    stringBuffer.append(sourceNodeLabel);
    stringBuffer.append(TEXT_81);
    stringBuffer.append(sourceNodeComponent);
    stringBuffer.append(TEXT_81);
    stringBuffer.append(node.getUniqueName());
    stringBuffer.append(TEXT_81);
    stringBuffer.append(targetNodeLabel);
    stringBuffer.append(TEXT_81);
    stringBuffer.append(node.getComponent().getName());
    stringBuffer.append(TEXT_93);
    }
						}
    stringBuffer.append(TEXT_94);
    stringBuffer.append(subprocessName4Catcher );
    stringBuffer.append(TEXT_95);
    
					} else {
						if(stat) {
    stringBuffer.append(TEXT_96);
    for(IConnection con : connSet){
									if(con.getUniqueName().equals((String)codeGenArgument.getIncomingName())){
    stringBuffer.append(TEXT_97);
    stringBuffer.append(con.getUniqueName());
    stringBuffer.append(TEXT_98);
    }
								}
    stringBuffer.append(TEXT_99);
    }
						
						if(logstashCurrent) {
    stringBuffer.append(TEXT_100);
    for(IConnection con : connSet){
									INode source = con.getSource();
									String sourceNodeId = source.getUniqueName();
									
									String sourceLabel = ElementParameterParser.getValue(source, "__LABEL__");
									String sourceNodeLabel = ((sourceLabel==null || "__UNIQUE_NAME__".equals(sourceLabel) || sourceLabel.contains("\"")) ? sourceNodeId : sourceLabel.trim());
									
									String targetLabel = ElementParameterParser.getValue(node, "__LABEL__");
									String targetNodeLabel = ((targetLabel==null || "__UNIQUE_NAME__".equals(targetLabel) || targetLabel.contains("\"")) ? node.getUniqueName() : targetLabel.trim());
							
									String sourceNodeComponent = source.getComponent().getName();
							
									if(con.getUniqueName().equals((String)codeGenArgument.getIncomingName())){
    stringBuffer.append(TEXT_97);
    stringBuffer.append(con.getUniqueName());
    stringBuffer.append(TEXT_81);
    stringBuffer.append(sourceNodeId);
    stringBuffer.append(TEXT_81);
    stringBuffer.append(sourceNodeLabel);
    stringBuffer.append(TEXT_81);
    stringBuffer.append(sourceNodeComponent);
    stringBuffer.append(TEXT_81);
    stringBuffer.append(node.getUniqueName());
    stringBuffer.append(TEXT_81);
    stringBuffer.append(targetNodeLabel);
    stringBuffer.append(TEXT_81);
    stringBuffer.append(node.getComponent().getName());
    stringBuffer.append(TEXT_98);
    }
								}
    stringBuffer.append(TEXT_101);
    stringBuffer.append(subprocessName4Catcher );
    stringBuffer.append(TEXT_102);
    }
					}
				}
			}
		}
	}
	
	Set<IConnection> connSetForLog =  new HashSet<IConnection>();
	connSetForLog.addAll(node.getIncomingConnections(EConnectionType.FLOW_MAIN));
	connSetForLog.addAll(node.getIncomingConnections(EConnectionType.FLOW_MERGE));
	if((codePart.equals(ECodePart.MAIN)) && isLog4jEnabled && connSetForLog.size()>0){
		if(!(node.isVirtualGenerateNode() && node.getVirtualLinkTo()==null)){//ignore the connector in virtual component
    		for(IConnection con:connSetForLog){
    		
    stringBuffer.append(TEXT_103);
    stringBuffer.append(con.getUniqueName());
    stringBuffer.append(TEXT_104);
    stringBuffer.append(con.getName());
    stringBuffer.append(TEXT_105);
    stringBuffer.append(con.getName());
    stringBuffer.append(TEXT_106);
    
    		}
    	}
	}
	if(codePart.equals(ECodePart.BEGIN)){
	
    stringBuffer.append(TEXT_107);
    stringBuffer.append(node.getUniqueName() );
    stringBuffer.append(TEXT_108);
    
		log.startWork();
		log.logCompSetting();
		boolean enable_runtime_lineage_log = NodeUtil.isJobUsingRuntimeLineage(node.getProcess()) && jobCatcherExists && !cid.startsWith("tJobStructureCatcher") && !cid.startsWith("talend");
		if(enable_runtime_lineage_log) {
		
    stringBuffer.append(TEXT_109);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_110);
    
                java.util.Set<org.talend.core.model.process.EParameterFieldType> ignoredParamsTypes = new java.util.HashSet<org.talend.core.model.process.EParameterFieldType>(); 
                ignoredParamsTypes.addAll(
                    java.util.Arrays.asList(
                        org.talend.core.model.process.EParameterFieldType.SCHEMA_TYPE,
                        org.talend.core.model.process.EParameterFieldType.SCHEMA_REFERENCE,
                        org.talend.core.model.process.EParameterFieldType.LABEL,
                        org.talend.core.model.process.EParameterFieldType.EXTERNAL,
                        org.talend.core.model.process.EParameterFieldType.MAPPING_TYPE,
                        org.talend.core.model.process.EParameterFieldType.IMAGE,
                        org.talend.core.model.process.EParameterFieldType.TNS_EDITOR,
                        org.talend.core.model.process.EParameterFieldType.WSDL2JAVA,
                        org.talend.core.model.process.EParameterFieldType.GENERATEGRAMMARCONTROLLER,
                        org.talend.core.model.process.EParameterFieldType.GENERATE_SURVIVORSHIP_RULES_CONTROLLER,
                        org.talend.core.model.process.EParameterFieldType.REFRESH_REPORTS,
                        org.talend.core.model.process.EParameterFieldType.BROWSE_REPORTS,
                        org.talend.core.model.process.EParameterFieldType.PALO_DIM_SELECTION,
                        org.talend.core.model.process.EParameterFieldType.GUESS_SCHEMA,
                        org.talend.core.model.process.EParameterFieldType.MATCH_RULE_IMEX_CONTROLLER,
                        org.talend.core.model.process.EParameterFieldType.MEMO_PERL,
                        org.talend.core.model.process.EParameterFieldType.DBTYPE_LIST,
                        org.talend.core.model.process.EParameterFieldType.VERSION,
                        org.talend.core.model.process.EParameterFieldType.TECHNICAL,
                        org.talend.core.model.process.EParameterFieldType.ICON_SELECTION,
                        org.talend.core.model.process.EParameterFieldType.JAVA_COMMAND,
                        org.talend.core.model.process.EParameterFieldType.TREE_TABLE,
                        org.talend.core.model.process.EParameterFieldType.VALIDATION_RULE_TYPE,
                        org.talend.core.model.process.EParameterFieldType.DCSCHEMA,
                        org.talend.core.model.process.EParameterFieldType.SURVIVOR_RELATION,
                        org.talend.core.model.process.EParameterFieldType.REST_RESPONSE_SCHEMA_TYPE,
                        org.talend.core.model.process.EParameterFieldType.BUTTON
                        )
                );
                for(org.talend.core.model.process.IElementParameter ep : org.talend.core.model.utils.NodeUtil.getDisplayedParameters(node)){
                    if(!ep.isLog4JEnabled() || ignoredParamsTypes.contains(ep.getFieldType())){
                        continue;
                    }
                    
                    ElementParameter p = (ElementParameter)ep;
                    Object pluginValue = p.getTaggedValue("org.talend.sdk.component.source");
                    if(pluginValue != null && String.class.cast(pluginValue).equalsIgnoreCase("tacokit")) {
                        try {
                            if (!(Boolean) org.talend.core.runtime.IAdditionalInfo.class.cast(p).func("isPersisted")) {
                                continue;
                            }
                        } catch (Exception ex) {
                            //do nothing
                        }
                        
                        
    
//copy from configuration.javajet for tacokit

    stringBuffer.append(TEXT_111);
    
            //TODO: modify this part for Maps and nested lists.
            if (p.getFieldType() == EParameterFieldType.TABLE || p.getFieldType() == EParameterFieldType.TACOKIT_SUGGESTABLE_TABLE) {
                java.util.List<java.util.Map<String, String>> tableValues = ElementParameterParser.createTableValues((java.util.List<java.util.Map<String, Object>>) p.getValue(), p);
                String[] items = p.getListItemsDisplayCodeName();
                String tableName = p.getName().replace('$', '.');
                boolean primitiveTable = items.length == 1 && items[0].equals(tableName + "[]");
                String tableNamePrefix = tableName + "[]";
                for (int i = 0; i < tableValues.size(); i++) {
                    java.util.Map<String, String> lineValues = tableValues.get(i);
                    for (int j = 0; j < items.length; j++) {
                        String key = tableName + "[" + i + "]";
                        if (!primitiveTable) {
                            final String columnName = items[j].substring(tableNamePrefix.length(), items[j].length());
                            key = key + columnName;
                        }
                        String value = lineValues.get(items[j]);
                        if (!org.talend.core.model.utils.ContextParameterUtils.isDynamic(value)) {
                            value = org.talend.core.model.utils.TalendTextUtils.removeQuotes(value);
                            value = org.talend.core.model.utils.TalendTextUtils.addQuotes(value);
                        }
                        
                        if(value==null || "null".equals(value.trim())) {
                            value = "(Object)null";
                        }

    stringBuffer.append(TEXT_112);
    stringBuffer.append(key);
    stringBuffer.append(TEXT_113);
    stringBuffer.append(value);
    stringBuffer.append(TEXT_114);
    
                    }
                }
            } else if(p.getFieldType() == EParameterFieldType.SCHEMA_TYPE) {
                final String parameterName = p.getName();
                IConnection connection = null;
                final List<? extends IConnection> connections = NodeUtil.getOutgoingConnections(node, p.getContext());
                if(connections != null && !connections.isEmpty()) {
                    connection = connections.get(0);
                }
                if(connection != null) {
                    IMetadataTable metaTable = connection.getMetadataTable();
                    List<IMetadataColumn> columns = metaTable.getListColumns();
                    for(int i = 0; i < columns.size(); i++) {
                        IMetadataColumn column = columns.get(i);
                    
    stringBuffer.append(TEXT_112);
    stringBuffer.append(parameterName);
    stringBuffer.append(TEXT_115);
    stringBuffer.append(i);
    stringBuffer.append(TEXT_116);
    stringBuffer.append(column.getLabel());
    stringBuffer.append(TEXT_117);
    
                    }
                }
            } else if (p.getFieldType() == EParameterFieldType.TACOKIT_INPUT_SCHEMA) {
                final String parameterName = p.getName();
                IConnection connection = null;
                final List<? extends IConnection> connections = NodeUtil.getIncomingConnections(node, p.getContext());
                if(connections != null && !connections.isEmpty()) {
                    connection = connections.get(0);
                }
                if(connection != null) {
                    IMetadataTable metaTable = connection.getMetadataTable();
                    List<IMetadataColumn> columns = metaTable.getListColumns();
                    for(int i = 0; i < columns.size(); i++) {
                        IMetadataColumn column = columns.get(i);
                    
    stringBuffer.append(TEXT_112);
    stringBuffer.append(parameterName);
    stringBuffer.append(TEXT_115);
    stringBuffer.append(i);
    stringBuffer.append(TEXT_116);
    stringBuffer.append(column.getLabel());
    stringBuffer.append(TEXT_117);
    
                    }
                }
            } else {
                final String key;
                if(!p.getName().contains("$")){
                    key = p.getName();
                }else{
                    final StringBuilder keyBuilder = new StringBuilder();
                    for (String part : p.getName().split("\\.")) {
                        if (keyBuilder.length() != 0) {
                            keyBuilder.append(".");
                        }
                        if (part.contains("$") && !part.startsWith("$")) {
                            keyBuilder.append(part.replace("$", "."));
                        } else {
                            keyBuilder.append(part);
                        }
                    }
                    key = keyBuilder.toString();
                }
                String value = null;
                if(p.getFieldType() == EParameterFieldType.PASSWORD) {
                    continue;
                } else {
                    value = ElementParameterParser.getStringElementParameterValue(p);
                    if (!org.talend.core.model.utils.ContextParameterUtils.isDynamic(value)) {
                        value = org.talend.core.model.utils.TalendTextUtils.removeQuotes(value);
                        value = org.talend.core.model.utils.TalendTextUtils.addQuotes(value);
                    }
                }
                if (value != null) {
                 if(key.endsWith("$maxBatchSize")){
                  
    stringBuffer.append(TEXT_118);
    
                 } else if(p.getFieldType() == EParameterFieldType.CLOSED_LIST) {
                   String valueTemp = org.talend.core.model.utils.TalendTextUtils.removeQuotes(value);
                    if ("".equals(valueTemp)) {
                       String[] listItemsDisplayCodeValue = p.getListItemsDisplayCodeName();
                       if(listItemsDisplayCodeValue != null && listItemsDisplayCodeValue.length > 0){
                          valueTemp = listItemsDisplayCodeValue[0];
                          value = org.talend.core.model.utils.TalendTextUtils.addQuotes(valueTemp);
                       }
                    }
                }
                
                if(value==null || "null".equals(value.trim())) {
                    value = "(Object)null";
                }

    stringBuffer.append(TEXT_119);
    stringBuffer.append(key);
    stringBuffer.append(TEXT_120);
    stringBuffer.append(value);
    stringBuffer.append(TEXT_114);
    
                } // else do not put value in configuration
            }

    
                        
                        continue;
                    }
                    
                    String name = ep.getName();
                    java.util.Set<String> ignoredParamsNames = new java.util.HashSet<String>();
                    ignoredParamsNames.add("SQLPATTERN_VALUE");
                    ignoredParamsNames.add("ADDITIONAL_INSERT_COLUMNS");
                    ignoredParamsNames.add("ADDITIONAL_UPDATE_COLUMNS");
                    ignoredParamsNames.add("SELECTION_TABLE");
                    ignoredParamsNames.add("DIFFER_MESSAGE");
                    ignoredParamsNames.add("NO_DIFFER_MESSAGE");
                    
                    if(ignoredParamsNames.contains(name)) {
                        //do nothing
                    } else if(org.talend.core.model.process.EParameterFieldType.PASSWORD.equals(ep.getFieldType()) || org.talend.core.model.process.EParameterFieldType.HIDDEN_TEXT.equals(ep.getFieldType())){
                        //not log password
                    }else{
                        String value = org.talend.core.model.utils.NodeUtil.getRuntimeParameterValue(node, ep);
                        
    stringBuffer.append(TEXT_112);
    stringBuffer.append(name);
    stringBuffer.append(TEXT_120);
    stringBuffer.append(value);
    stringBuffer.append(TEXT_114);
    
                    }
                }
                
    stringBuffer.append(TEXT_121);
    stringBuffer.append(TEXT_122);
    stringBuffer.append(jobCatcherNode.getUniqueName());
    stringBuffer.append(TEXT_123);
    stringBuffer.append(node.getUniqueName());
    stringBuffer.append(TEXT_124);
    stringBuffer.append(node.getComponent().getName());
    stringBuffer.append(TEXT_125);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_126);
    stringBuffer.append(TEXT_122);
    stringBuffer.append(jobCatcherNode.getDesignSubjobStartNode().getUniqueName() );
    stringBuffer.append(TEXT_127);
    
		}
		
		if(logstashCurrent) {
			for (INode jobStructureCatcher : jobCatcherNodes) {
				String label = ElementParameterParser.getValue(node, "__LABEL__");
				String nodeLabel = ((label==null || "__UNIQUE_NAME__".equals(label) || label.contains("\"")) ? node.getUniqueName() : label.trim());
			
    stringBuffer.append(TEXT_128);
    stringBuffer.append(jobStructureCatcher.getUniqueName() );
    stringBuffer.append(TEXT_129);
    stringBuffer.append(node.getUniqueName());
    stringBuffer.append(TEXT_124);
    stringBuffer.append(nodeLabel);
    stringBuffer.append(TEXT_124);
    stringBuffer.append(node.getComponent().getName());
    stringBuffer.append(TEXT_53);
    stringBuffer.append(jobStructureCatcher.getDesignSubjobStartNode().getUniqueName() );
    stringBuffer.append(TEXT_84);
    
				break;
			}
		}
	}
	if(stat || logstashCurrent){
		boolean iterateInVFComp = (node.getVirtualLinkTo() != null && node.getVirtualLinkTo() == EConnectionType.ITERATE);
		if(iterateInVFComp){
			if(codePart.equals(ECodePart.BEGIN)){
				List<String> needToStartConnNames = new ArrayList<String>();
				INode nextNode = node.getOutgoingConnections(EConnectionType.ITERATE).get(0).getTarget();
				NodeUtil.fillConnectionsForStat(needToStartConnNames, nextNode);
				if(needToStartConnNames.isEmpty()) {
					//do nothing
				} else if(containsTPartitioner){
				
    stringBuffer.append(TEXT_130);
    if(stat){
    stringBuffer.append(TEXT_65);
    }
    if(stat && logstashCurrent){
    stringBuffer.append(TEXT_66);
    }
    if(logstashCurrent){
    stringBuffer.append(TEXT_67);
    }
    stringBuffer.append(TEXT_131);
    if(stat){
    stringBuffer.append(TEXT_65);
    } else {
    stringBuffer.append(TEXT_69);
    }
    stringBuffer.append(TEXT_70);
    for(String connName : needToStartConnNames){
    stringBuffer.append(TEXT_71);
    stringBuffer.append(connName);
    stringBuffer.append(TEXT_72);
    }
    stringBuffer.append(TEXT_132);
    
				} else {
					if(stat && logstashCurrent) {
					
    stringBuffer.append(TEXT_133);
    for(String connName : needToStartConnNames){
    stringBuffer.append(TEXT_71);
    stringBuffer.append(connName);
    stringBuffer.append(TEXT_72);
    }
    stringBuffer.append(TEXT_134);
    
					} else {
						if(stat){
						
    stringBuffer.append(TEXT_135);
    for(String connName : needToStartConnNames){
    stringBuffer.append(TEXT_71);
    stringBuffer.append(connName);
    stringBuffer.append(TEXT_72);
    }
    stringBuffer.append(TEXT_136);
    
						}
						
    stringBuffer.append(TEXT_137);
    if(logstashCurrent) {
    stringBuffer.append(TEXT_138);
    for(String connName : needToStartConnNames){
    stringBuffer.append(TEXT_71);
    stringBuffer.append(connName);
    stringBuffer.append(TEXT_72);
    }
    stringBuffer.append(TEXT_136);
    
						}
					}
				}
			}else if(codePart.equals(ECodePart.MAIN)){ 
			
    stringBuffer.append(TEXT_139);
    
			}else if(codePart.equals(ECodePart.END)){
			
    stringBuffer.append(TEXT_140);
    
			} 
		}else{
			IConnection preIterate = (node.getIncomingConnections(EConnectionType.ITERATE) != null && node.getIncomingConnections(EConnectionType.ITERATE).size() == 1) ? node.getIncomingConnections(EConnectionType.ITERATE).get(0) : null;
			if(preIterate != null){
				boolean iterateInVSComp = (preIterate.getSource().getVirtualLinkTo() != null && preIterate.getSource().getVirtualLinkTo() == EConnectionType.ITERATE);
				if(iterateInVSComp){
					if(codePart.equals(ECodePart.BEGIN)){ 
					
    stringBuffer.append(TEXT_141);
    
					}else if(codePart.equals(ECodePart.END)){
					
    stringBuffer.append(TEXT_142);
    
					}
				}
			}	
		}
	}
	
    stringBuffer.append(TEXT_111);
    return stringBuffer.toString();
  }
}
