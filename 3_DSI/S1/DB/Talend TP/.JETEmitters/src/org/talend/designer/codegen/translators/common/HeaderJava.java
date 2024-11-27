package org.talend.designer.codegen.translators.common;

import org.talend.core.model.process.IProcess;
import org.talend.core.model.process.INode;
import org.talend.core.model.process.IConnection;
import org.talend.core.model.process.EConnectionType;
import org.talend.core.model.process.ElementParameterParser;
import org.talend.designer.codegen.config.CodeGeneratorArgument;
import org.talend.designer.runprocess.CodeGeneratorRoutine;
import org.talend.designer.codegen.i18n.Messages;
import org.talend.core.ui.branding.IBrandingService;
import org.talend.core.ui.branding.AbstractBrandingService;
import org.talend.core.GlobalServiceRegister;
import org.talend.designer.codegen.ITalendSynchronizer;
import org.talend.designer.codegen.PigTemplate;
import java.util.List;
import java.util.ArrayList;
import java.util.Vector;
import org.talend.core.model.process.IContextParameter;
import org.talend.core.model.metadata.types.JavaTypesManager;
import org.talend.core.model.utils.NodeUtil;
import org.talend.core.model.utils.JavaResourcesHelper;
import org.talend.core.model.process.ProcessUtils;
import org.talend.designer.runprocess.ProcessorUtilities;

public class HeaderJava
{
  protected static String nl;
  public static synchronized HeaderJava create(String lineSeparator)
  {
    nl = lineSeparator;
    HeaderJava result = new HeaderJava();
    nl = null;
    return result;
  }

  public final String NL = nl == null ? (System.getProperties().getProperty("line.separator")) : nl;
  protected final String TEXT_1 = "";
  protected final String TEXT_2 = NL + "package ";
  protected final String TEXT_3 = ";" + NL;
  protected final String TEXT_4 = NL + "import pigudf.";
  protected final String TEXT_5 = ";";
  protected final String TEXT_6 = NL + "import routines.";
  protected final String TEXT_7 = NL + "import ";
  protected final String TEXT_8 = NL + "import routines.system.*;" + NL + "import routines.system.api.*;" + NL + "import java.text.ParseException;" + NL + "import java.text.SimpleDateFormat;" + NL + "import java.util.Date;" + NL + "import java.util.List;" + NL + "import java.math.BigDecimal;" + NL + "import java.io.ByteArrayOutputStream;" + NL + "import java.io.ByteArrayInputStream;" + NL + "import java.io.DataInputStream;" + NL + "import java.io.DataOutputStream;" + NL + "import java.io.ObjectOutputStream;" + NL + "import java.io.ObjectInputStream;" + NL + "import java.io.IOException;" + NL + "import java.util.Comparator;";
  protected final String TEXT_9 = NL + "import org.junit.Test;" + NL + "import static org.junit.Assert.assertTrue;";
  protected final String TEXT_10 = NL + " ";
  protected final String TEXT_11 = NL;
  protected final String TEXT_12 = NL + NL;
  protected final String TEXT_13 = NL + "\t//the import part of ";
  protected final String TEXT_14 = NL + "\t";
  protected final String TEXT_15 = NL + NL + "@SuppressWarnings(\"unused\")" + NL + "" + NL + "/**" + NL + " * Job: ";
  protected final String TEXT_16 = " Purpose: ";
  protected final String TEXT_17 = "<br>" + NL + " * Description: ";
  protected final String TEXT_18 = " <br>" + NL + " * @author ";
  protected final String TEXT_19 = NL + " * @version ";
  protected final String TEXT_20 = NL + " * @status ";
  protected final String TEXT_21 = NL + " */";
  protected final String TEXT_22 = NL + "public class ";
  protected final String TEXT_23 = " implements ";
  protected final String TEXT_24 = " {";
  protected final String TEXT_25 = NL + "\tstatic {System.setProperty(\"TalendJob.log\", \"";
  protected final String TEXT_26 = ".log\");}" + NL + "" + NL + "\t";
  protected final String TEXT_27 = NL + "\tprivate static org.apache.log4j.Logger log = org.apache.log4j.Logger.getLogger(";
  protected final String TEXT_28 = ".class);" + NL + "\t";
  protected final String TEXT_29 = NL + NL + "\t";
  protected final String TEXT_30 = NL + "\tprivate static org.apache.logging.log4j.Logger log = org.apache.logging.log4j.LogManager.getLogger(";
  protected final String TEXT_31 = NL + NL + "protected static void logIgnoredError(String message, Throwable cause) {";
  protected final String TEXT_32 = NL + "       log.error(message, cause);";
  protected final String TEXT_33 = NL + "       System.err.println(message);" + NL + "       if (cause != null) {" + NL + "               cause.printStackTrace();" + NL + "       }";
  protected final String TEXT_34 = NL + NL + "}";
  protected final String TEXT_35 = NL + "\tprivate ESBEndpointRegistry registry = null;" + NL + "" + NL + "\tpublic void setEndpointRegistry(ESBEndpointRegistry registry) {" + NL + "\t\tthis.registry = registry;" + NL + "\t}" + NL + "" + NL + "\tprivate ESBProviderCallback callback = null;" + NL + "" + NL + "\tpublic void setProviderCallback(ESBProviderCallback callback) {" + NL + "\t\t";
  protected final String TEXT_36 = NL + "\t\t\tthis.callback = callback;" + NL + "\t\t";
  protected final String TEXT_37 = NL + "\t}" + NL + "" + NL + "\t";
  protected final String TEXT_38 = NL + "\t\tpublic ESBEndpointInfo getEndpoint() { return null; }" + NL + "\t";
  protected final String TEXT_39 = NL + "\tpublic TalendESBJob newTalendESBJob() {" + NL + "\t\t";
  protected final String TEXT_40 = " talendESBJob = new ";
  protected final String TEXT_41 = "();" + NL + "\t\tjava.util.Map<String, routines.system.TalendDataSource> talendDataSources =" + NL + "\t\t\t(java.util.Map<String, routines.system.TalendDataSource>) globalMap.get(KEY_DB_DATASOURCES);" + NL + "\t\tif (null != talendDataSources) {" + NL + "\t\t\tjava.util.Map<String, javax.sql.DataSource> dataSources = new java.util.HashMap<String, javax.sql.DataSource>();" + NL + "\t\t\tfor (java.util.Map.Entry<String, routines.system.TalendDataSource> talendDataSourceEntry : talendDataSources.entrySet()) {" + NL + "\t\t\t\tdataSources.put(talendDataSourceEntry.getKey(), talendDataSourceEntry.getValue().getRawDataSource());" + NL + "\t\t\t}" + NL + "\t\t\ttalendESBJob.setDataSources(dataSources);" + NL + "\t\t}" + NL + "\t\t// fix for TESB-7714" + NL + "\t\ttalendESBJob.setEndpointRegistry(registry);" + NL + "" + NL + "\t\treturn talendESBJob;" + NL + "\t}";
  protected final String TEXT_42 = NL + NL + "\tpublic final Object obj = new Object();" + NL + "" + NL + "\t// for transmiting parameters purpose" + NL + "\tprivate Object valueObject = null;" + NL + "" + NL + "\tpublic Object getValueObject() {" + NL + "\t\treturn this.valueObject;" + NL + "\t}" + NL + "" + NL + "\tpublic void setValueObject(Object valueObject) {" + NL + "\t\tthis.valueObject = valueObject;" + NL + "\t}";
  protected final String TEXT_43 = NL + "\tprivate Object[] multiThreadLockWrite = new Object[0];";
  protected final String TEXT_44 = NL + "\tprivate final static String defaultCharset = java.nio.charset.Charset.defaultCharset().name();" + NL + "" + NL + "\t";
  protected final String TEXT_45 = NL + "\tprivate final static String utf8Charset = \"UTF-8\";" + NL + "\t//contains type for every context property" + NL + "\tpublic class PropertiesWithType extends java.util.Properties {" + NL + "\t\tprivate static final long serialVersionUID = 1L;" + NL + "\t\tprivate java.util.Map<String,String> propertyTypes = new java.util.HashMap<>();" + NL + "\t\t" + NL + "\t\tpublic PropertiesWithType(java.util.Properties properties){" + NL + "\t\t\tsuper(properties);" + NL + "\t\t}" + NL + "\t\tpublic PropertiesWithType(){" + NL + "\t\t\tsuper();" + NL + "\t\t}" + NL + "\t\t" + NL + "\t\tpublic void setContextType(String key, String type) {" + NL + "\t\t\tpropertyTypes.put(key,type);" + NL + "\t\t}" + NL + "\t" + NL + "\t\tpublic String getContextType(String key) {" + NL + "\t\t\treturn propertyTypes.get(key);" + NL + "\t\t}" + NL + "\t}" + NL + "\t" + NL + "\t// create and load default properties" + NL + "\tprivate java.util.Properties defaultProps = new java.util.Properties();" + NL + "\t// create application properties with default" + NL + "\tpublic class ContextProperties extends PropertiesWithType {" + NL + "" + NL + "\t\tprivate static final long serialVersionUID = 1L;" + NL + "" + NL + "\t\tpublic ContextProperties(java.util.Properties properties){" + NL + "\t\t\tsuper(properties);" + NL + "\t\t}" + NL + "\t\tpublic ContextProperties(){" + NL + "\t\t\tsuper();" + NL + "\t\t}" + NL + "" + NL + "\t\tpublic void synchronizeContext(){" + NL + "\t\t\t";
  protected final String TEXT_46 = NL + "\t\t\tif(";
  protected final String TEXT_47 = " != null){" + NL + "\t\t\t\t";
  protected final String TEXT_48 = NL + "\t\t\t\t\tString pattern_";
  protected final String TEXT_49 = " = \"yyyy-MM-dd HH:mm:ss\";" + NL + "\t\t\t\t\tString value_";
  protected final String TEXT_50 = " = \"";
  protected final String TEXT_51 = "\";" + NL + "\t\t\t\t\tString[] parts_";
  protected final String TEXT_52 = " = value_";
  protected final String TEXT_53 = ".split(\";\");" + NL + "\t\t\t\t\tif(parts_";
  protected final String TEXT_54 = ".length > 1){" + NL + "\t\t\t\t\t\tpattern_";
  protected final String TEXT_55 = " = parts_";
  protected final String TEXT_56 = "[0];" + NL + "\t\t\t\t\t\tthis.setProperty(\"";
  protected final String TEXT_57 = "\", pattern_";
  protected final String TEXT_58 = " + \";\" + FormatterUtils.format_Date(";
  protected final String TEXT_59 = ", pattern_";
  protected final String TEXT_60 = "));" + NL + "\t\t\t\t\t}else{" + NL + "\t\t\t\t\t\tthis.setProperty(\"";
  protected final String TEXT_61 = "\", FormatterUtils.format_Date(";
  protected final String TEXT_62 = "));" + NL + "\t\t\t\t\t}" + NL + "\t\t\t\t";
  protected final String TEXT_63 = NL + "\t\t\t\t\tthis.setProperty(\"";
  protected final String TEXT_64 = "\", ";
  protected final String TEXT_65 = ".toString());" + NL + "\t\t\t\t";
  protected final String TEXT_66 = NL + "\t\t\t}" + NL + "\t\t\t";
  protected final String TEXT_67 = NL + "\t\t}" + NL + "\t\t" + NL + "\t\t//if the stored or passed value is \"<TALEND_NULL>\" string, it mean null" + NL + "\t\tpublic String getStringValue(String key) {" + NL + "\t\t\tString origin_value = this.getProperty(key);" + NL + "\t\t\tif(NULL_VALUE_EXPRESSION_IN_COMMAND_STRING_FOR_CHILD_JOB_ONLY.equals(origin_value)) {" + NL + "\t\t\t\treturn null;" + NL + "\t\t\t}" + NL + "\t\t\treturn origin_value;" + NL + "\t\t}" + NL;
  protected final String TEXT_68 = NL + "\t\tpublic String ";
  protected final String TEXT_69 = ";" + NL + "\t\tpublic String get";
  protected final String TEXT_70 = "(){" + NL + "\t\t\treturn this.";
  protected final String TEXT_71 = ";" + NL + "\t\t}" + NL + "\t\t";
  protected final String TEXT_72 = NL + "public ";
  protected final String TEXT_73 = " ";
  protected final String TEXT_74 = ";" + NL + "public ";
  protected final String TEXT_75 = " get";
  protected final String TEXT_76 = "(){" + NL + "\treturn this.";
  protected final String TEXT_77 = ";" + NL + "}";
  protected final String TEXT_78 = NL + "\t}" + NL + "\tprotected ContextProperties context = new ContextProperties(); // will be instanciated by MS." + NL + "\tpublic ContextProperties getContext() {" + NL + "\t\treturn this.context;" + NL + "\t}" + NL + "\tprivate final String jobVersion = \"";
  protected final String TEXT_79 = "\";" + NL + "\tprivate final String jobName = \"";
  protected final String TEXT_80 = "\";" + NL + "\tprivate final String projectName = \"";
  protected final String TEXT_81 = "\";" + NL + "\tpublic Integer errorCode = null;" + NL + "\tprivate String currentComponent = \"\";" + NL + "\t";
  protected final String TEXT_82 = NL + "\t\tprivate final java.util.Map<String, Object> globalMap = java.util.Collections.synchronizedMap(new java.util.HashMap<String, Object>());" + NL + "\t\t";
  protected final String TEXT_83 = NL + "\t\t\tprivate final static java.util.Map<String, Object> junitGlobalMap = java.util.Collections.synchronizedMap(new java.util.HashMap<String, Object>());" + NL + "\t\t";
  protected final String TEXT_84 = NL + "\t\tprivate final java.util.Map<String, Object> globalMap = new java.util.HashMap<String, Object>();" + NL + "        private final static java.util.Map<String, Object> junitGlobalMap = new java.util.HashMap<String, Object>();" + NL + "\t";
  protected final String TEXT_85 = NL + "\t\tprivate final java.util.Map<String, Long> start_Hash = new java.util.HashMap<String, Long>();" + NL + "\t\tprivate final java.util.Map<String, Long> end_Hash = new java.util.HashMap<String, Long>();" + NL + "\t\tprivate final java.util.Map<String, Boolean> ok_Hash = new java.util.HashMap<String, Boolean>();" + NL + "\t\tpublic  final java.util.List<String[]> globalBuffer = new java.util.ArrayList<String[]>();" + NL + "\t";
  protected final String TEXT_86 = NL + "\t\tprivate final java.util.Map<String, Long> start_Hash = java.util.Collections.synchronizedMap(new java.util.HashMap<String, Long>());" + NL + "\t\tprivate final java.util.Map<String, Long> end_Hash = java.util.Collections.synchronizedMap(new java.util.HashMap<String, Long>());" + NL + "\t\tprivate final java.util.Map<String, Boolean> ok_Hash = java.util.Collections.synchronizedMap(new java.util.HashMap<String, Boolean>());" + NL + "\t\tpublic  final java.util.List<String[]> globalBuffer = java.util.Collections.synchronizedList(new java.util.ArrayList<String[]>());" + NL + "\t";
  protected final String TEXT_87 = NL + "private final JobStructureCatcherUtils ";
  protected final String TEXT_88 = " = new JobStructureCatcherUtils(jobName, \"";
  protected final String TEXT_89 = "\", \"";
  protected final String TEXT_90 = "\");";
  protected final String TEXT_91 = NL + "private org.talend.job.audit.JobAuditLogger runtime_lineage_logger_";
  protected final String TEXT_92 = " = null;";
  protected final String TEXT_93 = NL + "private org.talend.job.audit.JobAuditLogger auditLogger_";
  protected final String TEXT_94 = " = null;" + NL + "" + NL + "private RunStat runStat = new RunStat(";
  protected final String TEXT_95 = ", System.getProperty(\"audit.interval\"));";
  protected final String TEXT_96 = NL + "private RunStat runStat = new RunStat();";
  protected final String TEXT_97 = NL + "private RunTrace runTrace = new RunTrace();";
  protected final String TEXT_98 = NL + NL + "\t// OSGi DataSource" + NL + "\tprivate final static String KEY_DB_DATASOURCES = \"KEY_DB_DATASOURCES\";" + NL + "\t" + NL + "\tprivate final static String KEY_DB_DATASOURCES_RAW = \"KEY_DB_DATASOURCES_RAW\";" + NL + "" + NL + "\tpublic void setDataSources(java.util.Map<String, javax.sql.DataSource> dataSources) {" + NL + "\t\tjava.util.Map<String, routines.system.TalendDataSource> talendDataSources = new java.util.HashMap<String, routines.system.TalendDataSource>();" + NL + "\t\tfor (java.util.Map.Entry<String, javax.sql.DataSource> dataSourceEntry : dataSources.entrySet()) {" + NL + "\t\t\ttalendDataSources.put(dataSourceEntry.getKey(), new routines.system.TalendDataSource(dataSourceEntry.getValue()));" + NL + "\t\t}" + NL + "\t\tglobalMap.put(KEY_DB_DATASOURCES, talendDataSources);" + NL + "\t\tglobalMap.put(KEY_DB_DATASOURCES_RAW, new java.util.HashMap<String, javax.sql.DataSource>(dataSources));" + NL + "\t}" + NL + "\t" + NL + "\tpublic void setDataSourceReferences(List serviceReferences) throws Exception{" + NL + "\t\t" + NL + "\t\tjava.util.Map<String, routines.system.TalendDataSource> talendDataSources = new java.util.HashMap<String, routines.system.TalendDataSource>();" + NL + "\t\tjava.util.Map<String, javax.sql.DataSource> dataSources = new java.util.HashMap<String, javax.sql.DataSource>();" + NL + "\t\t" + NL + "\t\tfor (java.util.Map.Entry<String, javax.sql.DataSource> entry : BundleUtils.getServices(serviceReferences,  javax.sql.DataSource.class).entrySet()) {" + NL + "                    dataSources.put(entry.getKey(), entry.getValue());" + NL + "                    talendDataSources.put(entry.getKey(), new routines.system.TalendDataSource(entry.getValue()));" + NL + "\t\t}" + NL + "" + NL + "\t\tglobalMap.put(KEY_DB_DATASOURCES, talendDataSources);" + NL + "\t\tglobalMap.put(KEY_DB_DATASOURCES_RAW, new java.util.HashMap<String, javax.sql.DataSource>(dataSources));" + NL + "\t}" + NL;
  protected final String TEXT_99 = NL + "\tLogCatcherUtils ";
  protected final String TEXT_100 = " = new LogCatcherUtils();";
  protected final String TEXT_101 = NL + "\tStatCatcherUtils ";
  protected final String TEXT_102 = " = new StatCatcherUtils(\"";
  protected final String TEXT_103 = NL + "\tMetterCatcherUtils ";
  protected final String TEXT_104 = " = new MetterCatcherUtils(\"";
  protected final String TEXT_105 = NL + "\tAssertCatcherUtils ";
  protected final String TEXT_106 = " = new AssertCatcherUtils();";
  protected final String TEXT_107 = NL + NL + "private final java.io.ByteArrayOutputStream baos = new java.io.ByteArrayOutputStream();" + NL + "private final java.io.PrintStream errorMessagePS = new java.io.PrintStream(new java.io.BufferedOutputStream(baos));" + NL + "" + NL + "public String getExceptionStackTrace() {" + NL + "\tif (\"failure\".equals(this.getStatus())) {" + NL + "\t\terrorMessagePS.flush();" + NL + "\t\treturn baos.toString();" + NL + "\t}" + NL + "\treturn null;" + NL + "}" + NL + "" + NL + "private Exception exception;" + NL + "" + NL + "public Exception getException() {" + NL + "\tif (\"failure\".equals(this.getStatus())) {" + NL + "\t\treturn this.exception;" + NL + "\t}" + NL + "\treturn null;" + NL + "}" + NL + "" + NL + "private class TalendException extends Exception {" + NL + "" + NL + "\tprivate static final long serialVersionUID = 1L;" + NL + "" + NL + "\tprivate java.util.Map<String, Object> globalMap = null;" + NL + "\tprivate Exception e = null;" + NL + "\tprivate String currentComponent = null;" + NL + "\tprivate String virtualComponentName = null;" + NL + "\t" + NL + "\tpublic void setVirtualComponentName (String virtualComponentName){" + NL + "\t\tthis.virtualComponentName = virtualComponentName;" + NL + "\t}" + NL + "" + NL + "\tprivate TalendException(Exception e, String errorComponent, final java.util.Map<String, Object> globalMap) {" + NL + "\t\tthis.currentComponent= errorComponent;" + NL + "\t\tthis.globalMap = globalMap;" + NL + "\t\tthis.e = e;" + NL + "\t}" + NL + "" + NL + "\tpublic Exception getException() {" + NL + "\t\treturn this.e;" + NL + "\t}" + NL + "" + NL + "\tpublic String getCurrentComponent() {" + NL + "\t\treturn this.currentComponent;" + NL + "\t}" + NL + "" + NL + "\t";
  protected final String TEXT_108 = NL + "    public String getExceptionCauseMessage(Exception e){" + NL + "        Throwable cause = e;" + NL + "        String message = null;" + NL + "        int i = 10;" + NL + "        while (null != cause && 0 < i--) {" + NL + "            message = cause.getMessage();" + NL + "            if (null == message) {" + NL + "                cause = cause.getCause();" + NL + "            } else {" + NL + "                break;          " + NL + "            }" + NL + "        }" + NL + "        if (null == message) {" + NL + "            message = e.getClass().getName();" + NL + "        }   " + NL + "        return message;" + NL + "    }" + NL + "" + NL + "\t@Override" + NL + "\tpublic void printStackTrace() {" + NL + "\t\tif (!(e instanceof TalendException || e instanceof TDieException)) {" + NL + "\t\t\tif(virtualComponentName!=null && currentComponent.indexOf(virtualComponentName+\"_\")==0){" + NL + "\t\t\t\tglobalMap.put(virtualComponentName+\"_ERROR_MESSAGE\",getExceptionCauseMessage(e));" + NL + "\t\t\t}" + NL + "\t\t\tglobalMap.put(currentComponent+\"_ERROR_MESSAGE\",getExceptionCauseMessage(e));" + NL + "\t\t\tSystem.err.println(\"Exception in component \" + currentComponent + \" (\" + jobName + \")\");" + NL + "\t\t}" + NL + "\t\tif (!(e instanceof TDieException)) {" + NL + "\t\t\tif(e instanceof TalendException){" + NL + "\t\t\t\te.printStackTrace();" + NL + "\t\t\t} else {" + NL + "\t\t\t\te.printStackTrace();" + NL + "\t\t\t\te.printStackTrace(errorMessagePS);" + NL + "\t\t\t\t";
  protected final String TEXT_109 = ".this.exception = e;" + NL + "\t\t\t}" + NL + "\t\t}" + NL + "\t\tif (!(e instanceof TalendException)) {" + NL + "\t\ttry {" + NL + "\t\t\tfor (java.lang.reflect.Method m : this.getClass().getEnclosingClass().getMethods()) {" + NL + "\t\t\t\tif (m.getName().compareTo(currentComponent + \"_error\") == 0) {" + NL + "\t\t\t\t\tm.invoke(";
  protected final String TEXT_110 = ".this, new Object[] { e , currentComponent, globalMap});" + NL + "\t\t\t\t\tbreak;" + NL + "\t\t\t\t}" + NL + "\t\t\t}" + NL + "" + NL + "\t\t\tif(!(e instanceof TDieException)){";
  protected final String TEXT_111 = NL + "\t\t\t\t";
  protected final String TEXT_112 = ".addMessage(\"Java Exception\", currentComponent, 6, e.getClass().getName() + \":\" + e.getMessage(), 1);";
  protected final String TEXT_113 = NL + "\t\t\ttry{";
  protected final String TEXT_114 = "Process(globalMap);";
  protected final String TEXT_115 = NL + "\t\t\t}finally{";
  protected final String TEXT_116 = NL + "\t\t\t}";
  protected final String TEXT_117 = NL + "\t\t\t} catch (TalendException e) {" + NL + "\t\t\t\t// do nothing" + NL + "\t\t\t";
  protected final String TEXT_118 = NL + "\t\t} catch (Exception e) {" + NL + "\t\t\tthis.e.printStackTrace();" + NL + "\t\t}" + NL + "\t\t}" + NL + "\t}" + NL + "}" + NL;
  protected final String TEXT_119 = NL + "\t\t\tpublic void ";
  protected final String TEXT_120 = "_error(Exception exception, String errorComponent, final java.util.Map<String, Object> globalMap) throws TalendException {" + NL + "\t\t\t\t";
  protected final String TEXT_121 = NL + "\t\t\t\t\t\t\t";
  protected final String TEXT_122 = "_error(exception, errorComponent, globalMap);" + NL + "\t\t\t\t\t\t";
  protected final String TEXT_123 = NL + "\t\t\t\t\t\t}" + NL + "\t\t\t\t\t";
  protected final String TEXT_124 = NL + "\t\t\t\t\t";
  protected final String TEXT_125 = "_error(exception, errorComponent, globalMap);" + NL + "\t\t\t\t\t}" + NL + "\t\t\t\t";
  protected final String TEXT_126 = NL + "\t\t\t\tend_Hash.put(errorComponent, System.currentTimeMillis());" + NL + "\t\t\t\t";
  protected final String TEXT_127 = NL + "\t\t\t\t\t\t\t\tif(!(exception instanceof TDieException)){" + NL + "\t\t\t\t\t\t\t\t\t";
  protected final String TEXT_128 = NL + "\t\t\t\t\t\t\t\t\t\t";
  protected final String TEXT_129 = ".addMessage(pid, projectName, jobName, \"java\", null, \"Failed\", \"Job execution error\", exception);" + NL + "\t\t\t\t\t\t\t\t\t";
  protected final String TEXT_130 = ".addMessage(pid, projectName, jobName, \"java\", null, \"Failed\", \"Job execution error\", exception.getMessage());" + NL + "\t\t\t\t\t\t\t\t\t";
  protected final String TEXT_131 = NL + "\t\t\t\t\t\t\t\t\t";
  protected final String TEXT_132 = "Process(globalMap);" + NL + "\t\t\t\t\t\t\t\t}" + NL + "\t\t\t\t\t\t\t\t";
  protected final String TEXT_133 = ".addMessage(\"failure\",errorComponent, end_Hash.get(errorComponent)-start_Hash.get(errorComponent));" + NL + "\t\t\t\t\t\t\t";
  protected final String TEXT_134 = "Process(globalMap);" + NL + "\t\t\t\t\t\t\t";
  protected final String TEXT_135 = NL + "\t\t\t\t\t\ttry {" + NL + "\t\t\t\t\t\t\t";
  protected final String TEXT_136 = NL + "\t\t\t\t\t\t\t\tif(this.execStat){" + NL + "\t\t\t\t\t\t\t\t\trunStat.updateStatOnConnection(\"";
  protected final String TEXT_137 = "\", 0, \"error\");" + NL + "\t\t\t\t\t\t\t\t}" + NL + "\t\t\t\t\t\t\t";
  protected final String TEXT_138 = NL + "\t\t\t\t\t\t\t\t((java.util.Map)threadLocal.get()).put(\"errorCode\", null);" + NL + "\t\t\t\t\t\t\t\t";
  protected final String TEXT_139 = "Process(globalMap);" + NL + "\t\t\t\t\t\t\t\tif ( !\"failure\".equals(((java.util.Map)threadLocal.get()).get(\"status\")) ) {" + NL + "\t\t\t\t\t\t\t\t\t((java.util.Map)threadLocal.get()).put(\"status\", \"end\");" + NL + "\t\t\t\t\t\t\t\t}" + NL + "\t\t\t\t\t\t\t\t";
  protected final String TEXT_140 = NL + "\t\t\t\t\t\t\t\terrorCode = null;" + NL + "\t\t\t\t\t\t\t\t";
  protected final String TEXT_141 = "Process(globalMap);" + NL + "\t\t\t\t\t\t\t\tif (!\"failure\".equals(status)) {" + NL + "\t\t\t\t\t\t\t\t\tstatus = \"end\";" + NL + "\t\t\t\t\t\t\t\t}" + NL + "\t\t\t\t\t\t\t\t";
  protected final String TEXT_142 = NL + NL + "\t\t\t\t\t\t} catch (Exception e) {" + NL + "\t\t\t\t\t\t\te.printStackTrace();" + NL + "\t\t\t\t\t\t}" + NL + "\t\t\t\t\t\t";
  protected final String TEXT_143 = NL + "\t\t\t\t((java.util.Map)threadLocal.get()).put(\"status\", \"failure\");" + NL + "\t\t\t\t";
  protected final String TEXT_144 = NL + "\t\t\t\tstatus = \"failure\";" + NL + "\t\t\t\t";
  protected final String TEXT_145 = "_onSubJobError(exception, errorComponent, globalMap);" + NL + "\t\t\t}" + NL + "\t\t\t";
  protected final String TEXT_146 = "_onSubJobError(Exception exception, String errorComponent, final java.util.Map<String, Object> globalMap) throws TalendException {";
  protected final String TEXT_147 = NL + NL + "resumeUtil.addLog(\"SYSTEM_LOG\", \"NODE:\"+ errorComponent, \"\", Thread.currentThread().getId()+ \"\", \"";
  protected final String TEXT_148 = "\", \"\", exception.getMessage(), ResumeUtil.getExceptionStackTrace(exception),\"\");" + NL;
  protected final String TEXT_149 = NL + "\t\t\t\ttry {" + NL + "\t\t\t\t\t";
  protected final String TEXT_150 = NL + "\t\t\t\t\t\tif(this.execStat){" + NL + "\t\t\t\t\t\t\trunStat.updateStatOnConnection(\"";
  protected final String TEXT_151 = "\", 0, \"error\");" + NL + "\t\t\t\t\t\t}" + NL + "\t\t\t\t\t";
  protected final String TEXT_152 = NL + "\t\t\t\t\t((java.util.Map)threadLocal.get()).put(\"errorCode\", null);" + NL + "\t\t\t\t\t";
  protected final String TEXT_153 = "Process(globalMap);" + NL + "\t\t\t\t\tif ( !\"failure\".equals(((java.util.Map)threadLocal.get()).get(\"status\")) ) {" + NL + "\t\t\t\t\t\t((java.util.Map)threadLocal.get()).put(\"status\", \"end\");" + NL + "\t\t\t\t\t}";
  protected final String TEXT_154 = NL + "\t\t\t\t\terrorCode = null;" + NL + "\t\t\t\t\t";
  protected final String TEXT_155 = "Process(globalMap);" + NL + "\t\t\t\t\tif (!\"failure\".equals(status)) {" + NL + "\t\t\t\t\t\tstatus = \"end\";" + NL + "\t\t\t\t\t}";
  protected final String TEXT_156 = NL + "\t\t\t\t} catch (Exception e) {" + NL + "\t\t\t\t\te.printStackTrace();" + NL + "\t\t\t\t}";

  public String generate(Object argument)
  {
    final StringBuffer stringBuffer = new StringBuffer();
    
	CodeGeneratorArgument codeGenArgument = (CodeGeneratorArgument) argument;
	Vector v = (Vector) codeGenArgument.getArgument();
	IProcess process = (IProcess)v.get(0);
	String version = (String)v.get(1);

	List< ? extends INode> processNodes = (List< ? extends INode>)process.getGeneratingNodes();
	boolean stats = codeGenArgument.isStatistics();
	boolean trace = codeGenArgument.isTrace();
	boolean isRunInMultiThread = codeGenArgument.getIsRunInMultiThread();
	List<IContextParameter> params = new ArrayList<IContextParameter>();
	params=process.getContextManager().getDefaultContext().getContextParameterList();
	String className = process.getName();

    
IBrandingService service=(IBrandingService)GlobalServiceRegister.getDefault().getService(IBrandingService.class);
if(service instanceof AbstractBrandingService){

    stringBuffer.append(TEXT_1);
    stringBuffer.append(((AbstractBrandingService) service).getJobLicenseHeader(version));
    
}
    String jobFolderName = "";
    IProcess baseProcess = ProcessUtils.getTestContainerBaseProcess(process);
    if (baseProcess != null) {
        jobFolderName = JavaResourcesHelper.getJobFolderName(baseProcess.getName(), baseProcess.getVersion()) + ".";
    }
	jobFolderName = jobFolderName + JavaResourcesHelper.getJobFolderName(process.getName(), process.getVersion());
	String packageName = codeGenArgument.getCurrentProjectName().toLowerCase() + "." + jobFolderName;

    stringBuffer.append(TEXT_2);
    stringBuffer.append( packageName );
    stringBuffer.append(TEXT_3);
    for (String routine : CodeGeneratorRoutine.getRequiredPigudfName(process)) {
      boolean isTemplate =false;
       for(PigTemplate template:PigTemplate.values()){
            if(routine.equals(template.getFileName())){
                isTemplate = true;
            }
        }
    if(!isTemplate){
    stringBuffer.append(TEXT_4);
    stringBuffer.append(routine);
    stringBuffer.append(TEXT_5);
      }
}
    for (String routine : CodeGeneratorRoutine.getRequiredRoutineName(process)) {
    if(!routine.equals(ITalendSynchronizer.TEMPLATE)){
    stringBuffer.append(TEXT_6);
    stringBuffer.append(routine);
    stringBuffer.append(TEXT_5);
      }
}
    for (String codesJar : CodeGeneratorRoutine.getRequiredCodesJarName(process)) {
    stringBuffer.append(TEXT_7);
    stringBuffer.append(codesJar);
    stringBuffer.append(TEXT_5);
    }
    stringBuffer.append(TEXT_8);
    
if(ProcessUtils.isTestContainer(process)) {
    className = className + "Test";

    stringBuffer.append(TEXT_9);
    
}

    stringBuffer.append(TEXT_10);
    stringBuffer.append(TEXT_11);
    stringBuffer.append(ElementParameterParser.getValue(process, "__HEADER_IMPORT__") );
    stringBuffer.append(TEXT_11);
    stringBuffer.append(ElementParameterParser.getValue(process, "__FOOTER_IMPORT__") );
    stringBuffer.append(TEXT_12);
    
	List<INode> nodesWithImport = process.getNodesWithImport();
	if(nodesWithImport != null) {
		for(INode node:nodesWithImport){

    stringBuffer.append(TEXT_13);
    stringBuffer.append(node.getUniqueName() );
    stringBuffer.append(TEXT_14);
    stringBuffer.append(ElementParameterParser.getValue(node, "__IMPORT__") );
    stringBuffer.append(TEXT_11);
    		}
	}

    stringBuffer.append(TEXT_15);
    stringBuffer.append(className);
    stringBuffer.append(TEXT_16);
    stringBuffer.append(ElementParameterParser.getValue(process, "__PURPOSE__") );
    stringBuffer.append(TEXT_17);
    stringBuffer.append(ElementParameterParser.getValue(process, "__DESCRIPTION__") );
    stringBuffer.append(TEXT_18);
    stringBuffer.append(ElementParameterParser.getValue(process, "__AUTHOR__") );
    stringBuffer.append(TEXT_19);
    stringBuffer.append(version );
    stringBuffer.append(TEXT_20);
    stringBuffer.append(ElementParameterParser.getValue(process, "__STATUS__") );
    stringBuffer.append(TEXT_21);
    
String talendJobInterfaces = "TalendJob";

boolean talendMdmJob = !process.getNodesOfType("tMDMTriggerInput").isEmpty() || !process.getNodesOfType("tMDMTriggerOutput").isEmpty();

boolean actAsProvider = !process.getNodesOfType("tESBProviderRequest").isEmpty();
boolean actAsConsumer = !process.getNodesOfType("tESBConsumer").isEmpty();
boolean hasSAM4RS = false;
for (INode node : process.getNodesOfType("tRESTClient")) {
    if (Boolean.valueOf(ElementParameterParser.getValue(node, "__SERVICE_ACTIVITY_MONITOR__"))) {
        hasSAM4RS = true;
        break;
    }
}

boolean talendEsbJobFactory = actAsProvider || !process.getNodesOfType("tRouteInput").isEmpty();
boolean talendEsbJob = talendEsbJobFactory || actAsConsumer || ProcessorUtilities.isEsbJob(process);

boolean isLog4jEnabled = ("true").equals(ElementParameterParser.getValue(process, "__LOG4J_ACTIVATE__"));//log4j enable
boolean isLog4j2Enabled = ("true").equals(ElementParameterParser.getValue(process, "__LOG4J2_ACTIVATE__"));//log4j2 enable
boolean isLog4j1Enabled = !isLog4j2Enabled;//log4j1 enable

if (talendMdmJob) {
	talendJobInterfaces += ", TalendMDMJob"; // Talend MDM job
}
if (talendEsbJob) {
	talendJobInterfaces += ", TalendESBJob"; // Talend ESB job
}
if (talendEsbJobFactory) {
	talendJobInterfaces += ", TalendESBJobFactory"; // Talend ESB provider job
}

    stringBuffer.append(TEXT_22);
    stringBuffer.append(className);
    stringBuffer.append(TEXT_23);
    stringBuffer.append(talendJobInterfaces);
    stringBuffer.append(TEXT_24);
    if(isLog4jEnabled){
    stringBuffer.append(TEXT_25);
    stringBuffer.append(className);
    stringBuffer.append(TEXT_26);
    if(isLog4j1Enabled){
    stringBuffer.append(TEXT_27);
    stringBuffer.append(className);
    stringBuffer.append(TEXT_28);
    }
    stringBuffer.append(TEXT_29);
    if(isLog4j2Enabled){
    stringBuffer.append(TEXT_30);
    stringBuffer.append(className);
    stringBuffer.append(TEXT_28);
    }
    }
    stringBuffer.append(TEXT_31);
    if (isLog4jEnabled){
    stringBuffer.append(TEXT_32);
    } else {
    stringBuffer.append(TEXT_33);
    }
    stringBuffer.append(TEXT_34);
     if (talendEsbJob) { 
    stringBuffer.append(TEXT_35);
     if (actAsProvider) { 
    stringBuffer.append(TEXT_36);
     } 
    stringBuffer.append(TEXT_37);
     if (!actAsProvider) { 
    stringBuffer.append(TEXT_38);
     } 
     } 
    stringBuffer.append(TEXT_11);
     if (talendEsbJobFactory) { 
    stringBuffer.append(TEXT_39);
    stringBuffer.append(process.getName());
    stringBuffer.append(TEXT_40);
    stringBuffer.append(process.getName());
    stringBuffer.append(TEXT_41);
     } 
    stringBuffer.append(TEXT_42);
    
if(isRunInMultiThread){

    stringBuffer.append(TEXT_43);
    
}

    stringBuffer.append(TEXT_14);
    //it will be use in job setting.
    stringBuffer.append(TEXT_44);
    //uft-8 is for temp file, for example: tSortRow, tMap. Because they need keep reversibility.
    stringBuffer.append(TEXT_45);
     for (IContextParameter ctxParam :params){
				String cParaName = ctxParam.getName();
			
    stringBuffer.append(TEXT_46);
    stringBuffer.append(cParaName );
    stringBuffer.append(TEXT_47);
    if(ctxParam.getType().equals("id_Date")){
    stringBuffer.append(TEXT_48);
    stringBuffer.append(cParaName );
    stringBuffer.append(TEXT_49);
    stringBuffer.append(cParaName );
    stringBuffer.append(TEXT_50);
    stringBuffer.append(ctxParam.getValue() );
    stringBuffer.append(TEXT_51);
    stringBuffer.append(cParaName );
    stringBuffer.append(TEXT_52);
    stringBuffer.append(cParaName );
    stringBuffer.append(TEXT_53);
    stringBuffer.append(cParaName );
    stringBuffer.append(TEXT_54);
    stringBuffer.append(cParaName );
    stringBuffer.append(TEXT_55);
    stringBuffer.append(cParaName );
    stringBuffer.append(TEXT_56);
    stringBuffer.append(cParaName );
    stringBuffer.append(TEXT_57);
    stringBuffer.append(cParaName );
    stringBuffer.append(TEXT_58);
    stringBuffer.append(cParaName );
    stringBuffer.append(TEXT_59);
    stringBuffer.append(cParaName );
    stringBuffer.append(TEXT_60);
    stringBuffer.append(cParaName );
    stringBuffer.append(TEXT_61);
    stringBuffer.append(cParaName );
    stringBuffer.append(TEXT_59);
    stringBuffer.append(cParaName );
    stringBuffer.append(TEXT_62);
    }else{
    stringBuffer.append(TEXT_63);
    stringBuffer.append(cParaName );
    stringBuffer.append(TEXT_64);
    stringBuffer.append(cParaName );
    stringBuffer.append(TEXT_65);
    }
    stringBuffer.append(TEXT_66);
     } 
    stringBuffer.append(TEXT_67);
    
		for (IContextParameter ctxParam :params)
		{
				if(ctxParam.getType().equals("id_List Of Value") || ctxParam.getType().equals("id_File") || ctxParam.getType().equals("id_Directory"))
				{
		
    stringBuffer.append(TEXT_68);
    stringBuffer.append(ctxParam.getName());
    stringBuffer.append(TEXT_69);
    stringBuffer.append(Character.toUpperCase(ctxParam.getName().charAt(0)) + ctxParam.getName().substring(1));
    stringBuffer.append(TEXT_70);
    stringBuffer.append(ctxParam.getName());
    stringBuffer.append(TEXT_71);
    
				}else
				{

    stringBuffer.append(TEXT_72);
    stringBuffer.append(JavaTypesManager.getTypeToGenerate(ctxParam.getType(),true));
    stringBuffer.append(TEXT_73);
    stringBuffer.append(ctxParam.getName());
    stringBuffer.append(TEXT_74);
    stringBuffer.append(JavaTypesManager.getTypeToGenerate(ctxParam.getType(),true));
    stringBuffer.append(TEXT_75);
    stringBuffer.append(Character.toUpperCase(ctxParam.getName().charAt(0)) + ctxParam.getName().substring(1));
    stringBuffer.append(TEXT_76);
    stringBuffer.append(ctxParam.getName());
    stringBuffer.append(TEXT_77);
    				}
		}

    stringBuffer.append(TEXT_78);
    stringBuffer.append(process.getVersion() );
    stringBuffer.append(TEXT_79);
    stringBuffer.append(codeGenArgument.getJobName() );
    stringBuffer.append(TEXT_80);
    stringBuffer.append(codeGenArgument.getCurrentProjectName() );
    stringBuffer.append(TEXT_81);
    
	//tParallelize will wrap globalMap with synchronizedMap
	if(isRunInMultiThread || NodeUtil.containsMultiThreadComponent(process)){
	
    stringBuffer.append(TEXT_82);
    
		if(ProcessUtils.isTestContainer(process)) {
		
    stringBuffer.append(TEXT_83);
    
		}
		
    stringBuffer.append(TEXT_14);
    
	} else {
	
    stringBuffer.append(TEXT_84);
    
	}
	boolean exist_tParallelize = false;
    List<? extends INode> tParallelizeList = process.getNodesOfType("tParallelize");
    if(tParallelizeList != null && tParallelizeList.size() > 0){
        exist_tParallelize = true;
    }
	if(!isRunInMultiThread && !exist_tParallelize){
	
    stringBuffer.append(TEXT_85);
    
	}else{
	
    stringBuffer.append(TEXT_86);
    
	}
	
    stringBuffer.append(TEXT_11);
    
	INode jobCatcherNode = null;
	for (INode nodeInProcess : processNodes) {
		String componentName = nodeInProcess.getComponent().getName();
		if("tJobStructureCatcher".equals(componentName)) {
			jobCatcherNode = nodeInProcess;
			break;
		}
	}
	
	boolean enableLogStash = !Boolean.getBoolean("deactivate_extended_component_log") && (jobCatcherNode!=null);
	boolean enable_runtime_lineage_log = NodeUtil.isJobUsingRuntimeLineage(process) && (jobCatcherNode!=null);
	
	if(jobCatcherNode!=null) {

    stringBuffer.append(TEXT_87);
    stringBuffer.append(jobCatcherNode.getUniqueName() );
    stringBuffer.append(TEXT_88);
    stringBuffer.append(process.getId() );
    stringBuffer.append(TEXT_89);
    stringBuffer.append(process.getVersion() );
    stringBuffer.append(TEXT_90);
    
	}
	if(enable_runtime_lineage_log) {

    stringBuffer.append(TEXT_91);
    stringBuffer.append(jobCatcherNode.getUniqueName());
    stringBuffer.append(TEXT_92);
    
	}
	
	if (enableLogStash) {

    stringBuffer.append(TEXT_93);
    stringBuffer.append(jobCatcherNode.getUniqueName());
    stringBuffer.append(TEXT_94);
    stringBuffer.append(jobCatcherNode.getUniqueName() );
    stringBuffer.append(TEXT_95);
    
	} else if(stats) {

    stringBuffer.append(TEXT_96);
    
	}

    
	if (trace) {

    stringBuffer.append(TEXT_97);
    
	}

    stringBuffer.append(TEXT_98);
    
	for (INode logCatcher : process.getNodesOfType("tLogCatcher")) {

    stringBuffer.append(TEXT_99);
    stringBuffer.append(logCatcher.getUniqueName() );
    stringBuffer.append(TEXT_100);
    
	}

	for (INode statCatcher : process.getNodesOfType("tStatCatcher")) {

    stringBuffer.append(TEXT_101);
    stringBuffer.append(statCatcher.getUniqueName() );
    stringBuffer.append(TEXT_102);
    stringBuffer.append(process.getId() );
    stringBuffer.append(TEXT_89);
    stringBuffer.append(process.getVersion() );
    stringBuffer.append(TEXT_90);
    
	}
	
	for (INode metterCatcher : process.getNodesOfType("tFlowMeterCatcher")) {

    stringBuffer.append(TEXT_103);
    stringBuffer.append(metterCatcher.getUniqueName() );
    stringBuffer.append(TEXT_104);
    stringBuffer.append(process.getId() );
    stringBuffer.append(TEXT_89);
    stringBuffer.append(process.getVersion() );
    stringBuffer.append(TEXT_90);
    
	}

	for (INode assertCatcher : process.getNodesOfType("tAssertCatcher")) {

    stringBuffer.append(TEXT_105);
    stringBuffer.append(assertCatcher.getUniqueName() );
    stringBuffer.append(TEXT_106);
    
	}

    stringBuffer.append(TEXT_107);
    //For TDI-27789
    stringBuffer.append(TEXT_108);
    stringBuffer.append(className);
    stringBuffer.append(TEXT_109);
    stringBuffer.append(className);
    stringBuffer.append(TEXT_110);
    
		boolean needCatchTalendException = false;
		
		if (process.getNodesOfType("tLogCatcher").size() > 0) {
			List<INode> logCatchers = (List<INode>)process.getNodesOfType("tLogCatcher");
			for (INode logCatcher : logCatchers) {
				if (ElementParameterParser.getValue(logCatcher, "__CATCH_JAVA_EXCEPTION__").equals("true")) {
					// 1) add the message to the stack

    stringBuffer.append(TEXT_111);
    stringBuffer.append(logCatcher.getUniqueName() );
    stringBuffer.append(TEXT_112);
    
				}
			}

			INode virtualNCatchNode = null;
			boolean hasRealCatchNode = false;
			for (INode logCatcher : logCatchers) {
				if (ElementParameterParser.getValue(logCatcher, "__CATCH_JAVA_EXCEPTION__").equals("true")) {
					if(logCatcher.isVirtualGenerateNode()){
						virtualNCatchNode = logCatcher;
					}else{
						hasRealCatchNode = true;
					}
				}
			}
			if(hasRealCatchNode && virtualNCatchNode!=null){

    stringBuffer.append(TEXT_113);
    
			}
			for (INode logCatcher : logCatchers) {
				if (ElementParameterParser.getValue(logCatcher, "__CATCH_JAVA_EXCEPTION__").equals("true")) {
					if(logCatcher!=virtualNCatchNode){
					// 2) launch logCatcher subProcess
					needCatchTalendException =  true;

    stringBuffer.append(TEXT_111);
    stringBuffer.append(logCatcher.getDesignSubjobStartNode().getUniqueName() );
    stringBuffer.append(TEXT_114);
    
					}
				}
			}
			if(hasRealCatchNode && virtualNCatchNode!=null){

    stringBuffer.append(TEXT_115);
    
			}
			if(virtualNCatchNode!=null){
				needCatchTalendException =  true;

    stringBuffer.append(TEXT_111);
    stringBuffer.append(virtualNCatchNode.getDesignSubjobStartNode().getUniqueName() );
    stringBuffer.append(TEXT_114);
    
			}
			if(hasRealCatchNode && virtualNCatchNode!=null){

    stringBuffer.append(TEXT_116);
    
			}
		}

    stringBuffer.append(TEXT_116);
    
		if(needCatchTalendException) {
			//TODO should catch the TalendException in assertcatcher process? but before should not work too as use java reflect, this exception can't catch
			
    stringBuffer.append(TEXT_117);
    
		}

    stringBuffer.append(TEXT_118);
     // Methods for RUN IF Error links 
    
	for (INode node : processNodes) {
		if (node.isActivate()) {
			
    stringBuffer.append(TEXT_119);
    stringBuffer.append(node.getUniqueName() );
    stringBuffer.append(TEXT_120);
    
				//If node is virtual component input part,invoke virtual component output part when virtual link is ROWS_END,FLOW,COMPONENT_OK,ITERATE(virtual link could not be ON_SUBJOB_OK)
				if(node.isVirtualGenerateNode() && node.getVirtualLinkTo()!=null){
					List< ? extends IConnection> conns = node.getOutgoingConnections(node.getVirtualLinkTo());
					boolean invokeVirtualLinkError=false;
					//If virtual component virtual link is EConnectionType.ON_SUBJOB_OK,node.getOutgoingConnections().size() is 0
					for(IConnection conn:conns){
						INode virtualLinkNode = conn.getTarget();
						if(virtualLinkNode.isVirtualGenerateNode()){
						
    stringBuffer.append(TEXT_121);
    stringBuffer.append(virtualLinkNode.getUniqueName());
    stringBuffer.append(TEXT_122);
    
							invokeVirtualLinkError=true;
							break;
						}
					}
					if(invokeVirtualLinkError){
					
    stringBuffer.append(TEXT_123);
    
						continue;
					}
				}
				if(!node.isVirtualGenerateNode() && node.getUniqueName().startsWith("tAsyncIn_")){
				
    stringBuffer.append(TEXT_124);
    stringBuffer.append(node.getUniqueName().replace("tAsyncIn_","tAsyncOut_"));
    stringBuffer.append(TEXT_125);
    
					continue;
				}
				
    stringBuffer.append(TEXT_126);
    
				boolean ifBeforRunError = NodeUtil.checkComponentErrorConnectionAfterNode(node);
				if(!ifBeforRunError) {
					if (process.getNodesOfType("tAssertCatcher").size() > 0) {
						List<INode> assertCatchers = (List<INode>)process.getNodesOfType("tAssertCatcher");
						for (INode assertCatcher : assertCatchers) {
							if (ElementParameterParser.getValue(assertCatcher, "__CATCH_JAVA_EXCEPTION__").equals("true")) {
								// 1) add the message to the stack
								
    stringBuffer.append(TEXT_127);
    if("true".equals(ElementParameterParser.getValue(assertCatcher, "__GET_ORIGINAL_EXCEPTION__"))){
    stringBuffer.append(TEXT_128);
    stringBuffer.append(assertCatcher.getUniqueName());
    stringBuffer.append(TEXT_129);
    }else{
    stringBuffer.append(TEXT_128);
    stringBuffer.append(assertCatcher.getUniqueName());
    stringBuffer.append(TEXT_130);
    }
    stringBuffer.append(TEXT_131);
    stringBuffer.append(assertCatcher.getDesignSubjobStartNode().getUniqueName() );
    stringBuffer.append(TEXT_132);
    
							}
						}
					}
				}
				if (!node.getComponent().getName().equals("tDie")) {
					String statCatcher = ElementParameterParser.getValue(node,"__TSTATCATCHER_STATS__");
					if (statCatcher.compareTo("true")==0) {
						for (INode statCatcherNode : node.getProcess().getNodesOfType("tStatCatcher")) {
							
    stringBuffer.append(TEXT_121);
    stringBuffer.append(statCatcherNode.getUniqueName() );
    stringBuffer.append(TEXT_133);
    stringBuffer.append(statCatcherNode.getDesignSubjobStartNode().getUniqueName() );
    stringBuffer.append(TEXT_134);
    
						}
					}
				}
				boolean isExistOnCompErrorLink = false;
				List< ? extends IConnection> conns = NodeUtil.getVirtualNode(node).getOutgoingConnections();
				for (IConnection conn : conns) {
					if (conn.getLineStyle().equals(EConnectionType.ON_COMPONENT_ERROR)) {
						isExistOnCompErrorLink = true;
						
    stringBuffer.append(TEXT_135);
    if (stats) {
    stringBuffer.append(TEXT_136);
    stringBuffer.append(conn.getUniqueName() );
    stringBuffer.append(TEXT_137);
    }
    stringBuffer.append(TEXT_121);
    
							if (isRunInMultiThread ) {
								
    stringBuffer.append(TEXT_138);
    stringBuffer.append(conn.getTarget().getUniqueName() );
    stringBuffer.append(TEXT_139);
    
							} else {
								
    stringBuffer.append(TEXT_140);
    stringBuffer.append(conn.getTarget().getUniqueName() );
    stringBuffer.append(TEXT_141);
    
							}
							
    stringBuffer.append(TEXT_142);
    
					}
				}
				/*
				This part of code in order to call the correct onComponentError and onSubjobError for virtual component which EConnectionType is ROWS_END,FLOW,COMPONENT_OK,ITERATE.
				*/
				INode subjob_start_node = node;
				boolean hasBeenChanged = true;
				while(subjob_start_node.getDesignSubjobStartNode().isVirtualGenerateNode() && hasBeenChanged) {
					hasBeenChanged = false;
					if(subjob_start_node.getDesignSubjobStartNode().getVirtualLinkTo()==null){
						//if EConnectionType of virtual component(INPUT-->SUBJOB_OK-->OUTPUT) is SUBJOB_OK,the size of OUTPUT node IncomingConnections is zero.
						if(subjob_start_node.getDesignSubjobStartNode().getIncomingConnections().size()>0){
							subjob_start_node = subjob_start_node.getDesignSubjobStartNode().getIncomingConnections().get(0).getSource();
							hasBeenChanged = true;
						}
					}
				}
				// when use parallelize will add virtual components(tAsyncIn and tAsyncOut) but in graphical these is visable=false
				if ("true".equals(ElementParameterParser.getValue(node, "__PARALLELIZE__"))) {
					if(subjob_start_node.getDesignSubjobStartNode().getUniqueName().startsWith("tAsyncIn_")){
						subjob_start_node = NodeUtil.getNodeByUniqueName(subjob_start_node.getProcess(),subjob_start_node.getDesignSubjobStartNode().getUniqueName().replace("tAsyncIn_","tAsyncOut_"));
					}
				}
				//end
				boolean isSubjobHasOnSubJobError = false;
				if (!isExistOnCompErrorLink) {
					INode subJobStartNode =	subjob_start_node.getDesignSubjobStartNode();
					if (subJobStartNode != null) {
						List< ? extends IConnection> tempConns = subJobStartNode.getOutgoingConnections();
						for (IConnection conn : tempConns) {
							if (conn.getLineStyle().equals(EConnectionType.ON_SUBJOB_ERROR)) {
								isSubjobHasOnSubJobError = true;
								break;
							}
						}
					}
				}

				if (!isSubjobHasOnSubJobError && !isExistOnCompErrorLink) { // when there is no subjoberror and no onComponentError
					if (isRunInMultiThread ) {
				
    stringBuffer.append(TEXT_143);
    
					} else {
				
    stringBuffer.append(TEXT_144);
    
					}
				}

				
    stringBuffer.append(TEXT_124);
    stringBuffer.append(subjob_start_node.getDesignSubjobStartNode().getUniqueName() );
    stringBuffer.append(TEXT_145);
    
		}
	}
	for (INode node : processNodes) {
		if (node.isDesignSubjobStartNode()) {

    stringBuffer.append(TEXT_119);
    stringBuffer.append(node.getUniqueName() );
    stringBuffer.append(TEXT_146);
    
			List< ? extends IConnection> conns = node.getOutgoingConnections();
			int count = 0;
			for (IConnection conn : conns) {
				if (conn.getLineStyle().equals(EConnectionType.ON_SUBJOB_ERROR)) {
					count++;
				}
			}

			String label = "ERROR";

			if(count == 0){//FATAL
				label = "FATAL";
			}else{//ERROR------>RunSubJobError
				label = "ERROR";
			}

    stringBuffer.append(TEXT_147);
    stringBuffer.append(label );
    stringBuffer.append(TEXT_148);
    
			for (IConnection conn : conns) {
				if (conn.getLineStyle().equals(EConnectionType.ON_SUBJOB_ERROR)) {

    stringBuffer.append(TEXT_149);
    if (stats) {
    stringBuffer.append(TEXT_150);
    stringBuffer.append(conn.getUniqueName() );
    stringBuffer.append(TEXT_151);
    }
    
					if(isRunInMultiThread ){

    stringBuffer.append(TEXT_152);
    stringBuffer.append(conn.getTarget().getUniqueName() );
    stringBuffer.append(TEXT_153);
    
					} else {

    stringBuffer.append(TEXT_154);
    stringBuffer.append(conn.getTarget().getUniqueName() );
    stringBuffer.append(TEXT_155);
    
					}

    stringBuffer.append(TEXT_156);
    
				}
			}

    stringBuffer.append(TEXT_116);
    
		}
	}

    stringBuffer.append(TEXT_11);
    return stringBuffer.toString();
  }
}
