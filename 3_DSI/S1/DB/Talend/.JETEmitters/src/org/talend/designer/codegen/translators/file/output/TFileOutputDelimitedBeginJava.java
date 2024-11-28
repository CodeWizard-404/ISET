package org.talend.designer.codegen.translators.file.output;

import org.talend.core.model.process.IConnection;
import org.talend.core.model.process.INode;
import org.talend.core.model.process.ElementParameterParser;
import org.talend.core.model.metadata.IMetadataTable;
import org.talend.core.model.metadata.IMetadataColumn;
import org.talend.designer.codegen.config.CodeGeneratorArgument;
import org.talend.core.model.process.IConnectionCategory;
import org.talend.core.model.metadata.types.JavaType;
import org.talend.core.model.metadata.types.JavaTypesManager;
import org.talend.core.model.utils.NodeUtil;
import java.util.List;
import org.talend.core.model.process.IProcess;
import org.talend.core.model.process.IElementParameter;
import org.talend.core.model.process.AbstractNode;

public class TFileOutputDelimitedBeginJava
{
  protected static String nl;
  public static synchronized TFileOutputDelimitedBeginJava create(String lineSeparator)
  {
    nl = lineSeparator;
    TFileOutputDelimitedBeginJava result = new TFileOutputDelimitedBeginJava();
    nl = null;
    return result;
  }

  public final String NL = nl == null ? (System.getProperties().getProperty("line.separator")) : nl;
  protected final String TEXT_1 = "\t\t\t\tlog.debug(\"";
  protected final String TEXT_2 = " - Retrieving records from the datasource.\");" + NL + "\t\t\t";
  protected final String TEXT_3 = NL + "\t\t\t\tlog.debug(\"";
  protected final String TEXT_4 = " - Retrieved records count: \"+ nb_line_";
  protected final String TEXT_5 = " + \" .\");" + NL + "\t\t\t";
  protected final String TEXT_6 = " - Retrieved records count: \"+ globalMap.get(\"";
  protected final String TEXT_7 = "_NB_LINE\") + \" .\");" + NL + "\t\t\t";
  protected final String TEXT_8 = " - Written records count: \" + nb_line_";
  protected final String TEXT_9 = NL + "\t\t\t\tfinal StringBuffer log4jSb_";
  protected final String TEXT_10 = " = new StringBuffer();" + NL + "\t\t\t";
  protected final String TEXT_11 = " - Retrieving the record \" + (nb_line_";
  protected final String TEXT_12 = ") + \".\");" + NL + "\t\t\t";
  protected final String TEXT_13 = " - Writing the record \" + nb_line_";
  protected final String TEXT_14 = " + \" to the file.\");" + NL + "\t\t\t";
  protected final String TEXT_15 = " - Processing the record \" + nb_line_";
  protected final String TEXT_16 = " + \".\");" + NL + "\t\t\t";
  protected final String TEXT_17 = " - Processed records count: \" + nb_line_";
  protected final String TEXT_18 = NL + "                log.error(message_";
  protected final String TEXT_19 = ");";
  protected final String TEXT_20 = NL + "                System.err.println(message_";
  protected final String TEXT_21 = NL + "String fileName_";
  protected final String TEXT_22 = " = \"\";";
  protected final String TEXT_23 = NL + "        int dynamic_column_count_";
  protected final String TEXT_24 = " = 1;";
  protected final String TEXT_25 = NL + "                class FileOutputDelimitedUtil_";
  protected final String TEXT_26 = "{";
  protected final String TEXT_27 = NL + "                                    public void putHeaderValue_";
  protected final String TEXT_28 = "(java.io.Writer out";
  protected final String TEXT_29 = ",final String OUT_DELIM_";
  protected final String TEXT_30 = ",final ";
  protected final String TEXT_31 = "Struct ";
  protected final String TEXT_32 = ")throws java.lang.Exception{";
  protected final String TEXT_33 = NL + "                                    out";
  protected final String TEXT_34 = ".write(\"";
  protected final String TEXT_35 = "\");";
  protected final String TEXT_36 = NL + "                                    routines.system.DynamicUtils.writeHeaderToDelimitedFile(";
  protected final String TEXT_37 = ".";
  protected final String TEXT_38 = ", out";
  protected final String TEXT_39 = ", OUT_DELIM_";
  protected final String TEXT_40 = ".write(OUT_DELIM_";
  protected final String TEXT_41 = NL + "                                    }";
  protected final String TEXT_42 = NL + "                                }";
  protected final String TEXT_43 = NL + "                                public void putValue_";
  protected final String TEXT_44 = "(final ";
  protected final String TEXT_45 = ",StringBuilder sb_";
  protected final String TEXT_46 = ")throws java.lang.Exception {";
  protected final String TEXT_47 = NL + "                                if(";
  protected final String TEXT_48 = " != null) {";
  protected final String TEXT_49 = NL + "                                routines.system.DynamicUtils.writeValuesToStringBuilder(";
  protected final String TEXT_50 = ", sb_";
  protected final String TEXT_51 = ", ";
  protected final String TEXT_52 = ", java.nio.charset.Charset.forName(";
  protected final String TEXT_53 = "));";
  protected final String TEXT_54 = NL + "\t\t\t\t\t\t\t    routines.system.DynamicUtils.writeValuesToStringBuilder(";
  protected final String TEXT_55 = "));" + NL + "\t\t\t\t\t\t\t    ";
  protected final String TEXT_56 = NL + "                                sb_";
  protected final String TEXT_57 = ".append(";
  protected final String TEXT_58 = NL + "                                        FormatterUtils.format_Date(";
  protected final String TEXT_59 = ")";
  protected final String TEXT_60 = NL + "                                            FormatterUtils.format_Number(";
  protected final String TEXT_61 = ".toPlainString(), ";
  protected final String TEXT_62 = NL + "                                            FormatterUtils.format_Number(new java.math.BigDecimal(String.valueOf(";
  protected final String TEXT_63 = ")).toPlainString(), ";
  protected final String TEXT_64 = NL + "                                        ";
  protected final String TEXT_65 = ".toPlainString()";
  protected final String TEXT_66 = NL + "                                        java.nio.charset.Charset.forName(";
  protected final String TEXT_67 = ").decode(java.nio.ByteBuffer.wrap(";
  protected final String TEXT_68 = ")).toString()";
  protected final String TEXT_69 = NL + "                                );";
  protected final String TEXT_70 = ".append(OUT_DELIM_";
  protected final String TEXT_71 = NL + "                            }";
  protected final String TEXT_72 = "(String[] headColu";
  protected final String TEXT_73 = ",int dynamic_column_count_";
  protected final String TEXT_74 = " ";
  protected final String TEXT_75 = NL + "                                        headColu";
  protected final String TEXT_76 = "[";
  protected final String TEXT_77 = "+dynamic_column_count_";
  protected final String TEXT_78 = "]=\"";
  protected final String TEXT_79 = "\";";
  protected final String TEXT_80 = NL + "                                    dynamic_column_count_";
  protected final String TEXT_81 = " = ";
  protected final String TEXT_82 = ".getColumnCount();" + NL + "                                    for(int mi=0;mi<dynamic_column_count_";
  protected final String TEXT_83 = ";mi++){" + NL + "                                        headColu";
  protected final String TEXT_84 = "+mi]=";
  protected final String TEXT_85 = ".getColumnMetadata(mi).getName();" + NL + "                                    }";
  protected final String TEXT_86 = ",String[] row";
  protected final String TEXT_87 = "){";
  protected final String TEXT_88 = NL + "                                if (";
  protected final String TEXT_89 = " != null) {" + NL + "                                    dynamic_column_count_";
  protected final String TEXT_90 = ".getColumnCount();" + NL + "                                    routines.system.DynamicUtils.writeValuesToStringArrayEnhance(";
  protected final String TEXT_91 = ", row";
  protected final String TEXT_92 = ",";
  protected final String TEXT_93 = NL + "                                               \"";
  protected final String TEXT_94 = "\"";
  protected final String TEXT_95 = NL + "                                               null";
  protected final String TEXT_96 = "));" + NL + "                                }";
  protected final String TEXT_97 = NL + "                                    row";
  protected final String TEXT_98 = "]=";
  protected final String TEXT_99 = NL + "                                    ";
  protected final String TEXT_100 = ";";
  protected final String TEXT_101 = NL + "                                    FormatterUtils.format_Date(";
  protected final String TEXT_102 = NL + "                                    java.nio.charset.Charset.forName(";
  protected final String TEXT_103 = ")).toString();";
  protected final String TEXT_104 = NL + "                                        FormatterUtils.format_Number(";
  protected final String TEXT_105 = NL + "                                        FormatterUtils.format_Number(new java.math.BigDecimal(String.valueOf(";
  protected final String TEXT_106 = ".toPlainString();";
  protected final String TEXT_107 = NL + "                                    String.valueOf(";
  protected final String TEXT_108 = NL + "                }" + NL + "                FileOutputDelimitedUtil_";
  protected final String TEXT_109 = " fileOutputDelimitedUtil_";
  protected final String TEXT_110 = "=new FileOutputDelimitedUtil_";
  protected final String TEXT_111 = "();";
  protected final String TEXT_112 = NL + "    fileName_";
  protected final String TEXT_113 = " = (new java.io.File(";
  protected final String TEXT_114 = ")).getAbsolutePath().replace(\"\\\\\",\"/\");" + NL + "    String fullName_";
  protected final String TEXT_115 = " = null;" + NL + "    String extension_";
  protected final String TEXT_116 = " = null;" + NL + "    String directory_";
  protected final String TEXT_117 = " = null;" + NL + "    if((fileName_";
  protected final String TEXT_118 = ".indexOf(\"/\") != -1)) {" + NL + "        if(fileName_";
  protected final String TEXT_119 = ".lastIndexOf(\".\") < fileName_";
  protected final String TEXT_120 = ".lastIndexOf(\"/\")) {" + NL + "            fullName_";
  protected final String TEXT_121 = " = fileName_";
  protected final String TEXT_122 = ";" + NL + "            extension_";
  protected final String TEXT_123 = " = \"\";" + NL + "        } else {" + NL + "            fullName_";
  protected final String TEXT_124 = ".substring(0, fileName_";
  protected final String TEXT_125 = ".lastIndexOf(\".\"));" + NL + "            extension_";
  protected final String TEXT_126 = ".substring(fileName_";
  protected final String TEXT_127 = ".lastIndexOf(\".\"));" + NL + "        }" + NL + "        directory_";
  protected final String TEXT_128 = ".lastIndexOf(\"/\"));" + NL + "    } else {" + NL + "        if(fileName_";
  protected final String TEXT_129 = ".lastIndexOf(\".\") != -1) {" + NL + "            fullName_";
  protected final String TEXT_130 = ".lastIndexOf(\".\"));" + NL + "        } else {" + NL + "            fullName_";
  protected final String TEXT_131 = " = \"\";" + NL + "        }" + NL + "        directory_";
  protected final String TEXT_132 = " = \"\";" + NL + "    }" + NL + "    boolean isFileGenerated_";
  protected final String TEXT_133 = " = true;" + NL + "    java.io.File file";
  protected final String TEXT_134 = " = new java.io.File(fileName_";
  protected final String TEXT_135 = ");" + NL + "    globalMap.put(\"";
  protected final String TEXT_136 = "_FILE_NAME\",fileName_";
  protected final String TEXT_137 = NL + "    if(file";
  protected final String TEXT_138 = ".exists()){" + NL + "            throw new RuntimeException(\"The particular file \\\"\"+file";
  protected final String TEXT_139 = ".getAbsoluteFile() +" + NL + "            \"\\\" already exist. If you want to overwrite the file, please uncheck the\" + " + NL + "            \" \\\"Throw an error if the file already exist\\\" option in Advanced settings.\");" + NL + "        }";
  protected final String TEXT_140 = NL + "        if(file";
  protected final String TEXT_141 = ".exists()){" + NL + "            isFileGenerated_";
  protected final String TEXT_142 = " = false;" + NL + "        }";
  protected final String TEXT_143 = NL + "                boolean isFirstCheckDyn_";
  protected final String TEXT_144 = "= true;";
  protected final String TEXT_145 = NL + "            int nb_line_";
  protected final String TEXT_146 = " = 0;";
  protected final String TEXT_147 = NL + "            int splitEvery_";
  protected final String TEXT_148 = NL + "            int splitedFileNo_";
  protected final String TEXT_149 = " = 0;" + NL + "            int currentRow_";
  protected final String TEXT_150 = " = 0;" + NL + "" + NL + "            final String OUT_DELIM_";
  protected final String TEXT_151 = ";" + NL + "" + NL + "            final String OUT_DELIM_ROWSEP_";
  protected final String TEXT_152 = ";" + NL;
  protected final String TEXT_153 = NL + "                    //create directory only if not exists" + NL + "                    if(directory_";
  protected final String TEXT_154 = " != null && directory_";
  protected final String TEXT_155 = ".trim().length() != 0) {" + NL + "                        java.io.File dir_";
  protected final String TEXT_156 = " = new java.io.File(directory_";
  protected final String TEXT_157 = ");" + NL + "                        if(!dir_";
  protected final String TEXT_158 = ".exists()) {";
  protected final String TEXT_159 = NL + "                                log.info(\"";
  protected final String TEXT_160 = " - Creating directory '\" + dir_";
  protected final String TEXT_161 = ".getCanonicalPath() +\"'.\");";
  protected final String TEXT_162 = NL + "                            dir_";
  protected final String TEXT_163 = ".mkdirs();";
  protected final String TEXT_164 = " - The directory '\"+ dir_";
  protected final String TEXT_165 = ".getCanonicalPath() + \"' has been created successfully.\");";
  protected final String TEXT_166 = NL + "                        }" + NL + "                    }";
  protected final String TEXT_167 = NL;
  protected final String TEXT_168 = NL + "                        file";
  protected final String TEXT_169 = ");" + NL + "                        String zipName_";
  protected final String TEXT_170 = " = fullName_";
  protected final String TEXT_171 = " + \".zip\";" + NL + "                        java.io.File file_";
  protected final String TEXT_172 = " = new java.io.File(zipName_";
  protected final String TEXT_173 = ");" + NL + "                        //routines.system.Row" + NL + "                        java.util.zip.ZipOutputStream zipOut_";
  protected final String TEXT_174 = "= null;" + NL + "                        java.io.Writer out";
  protected final String TEXT_175 = " = null;" + NL + "" + NL + "                        if(file_";
  protected final String TEXT_176 = ".exists()) {" + NL + "                            file_";
  protected final String TEXT_177 = ".delete();" + NL + "                        }" + NL + "                        zipOut_";
  protected final String TEXT_178 = "= new java.util.zip.ZipOutputStream(" + NL + "                                new java.io.BufferedOutputStream(new java.io.FileOutputStream(zipName_";
  protected final String TEXT_179 = ")));" + NL + "                        zipOut_";
  protected final String TEXT_180 = ".putNextEntry(new java.util.zip.ZipEntry(file";
  protected final String TEXT_181 = ".getName()));" + NL + "                        out";
  protected final String TEXT_182 = " = new ";
  protected final String TEXT_183 = "(new java.io.OutputStreamWriter(zipOut_";
  protected final String TEXT_184 = NL + "                        //routines.system.Row" + NL + "                        java.io.Writer out";
  protected final String TEXT_185 = " = null;" + NL;
  protected final String TEXT_186 = NL + "                        java.io.File fileToDelete_";
  protected final String TEXT_187 = ");" + NL + "                        if(fileToDelete_";
  protected final String TEXT_188 = ".exists()) {" + NL + "                            fileToDelete_";
  protected final String TEXT_189 = ".delete();" + NL + "                        }";
  protected final String TEXT_190 = NL + "                        out";
  protected final String TEXT_191 = "(new java.io.OutputStreamWriter(" + NL + "                        new java.io.FileOutputStream(fileName_";
  protected final String TEXT_192 = "),";
  protected final String TEXT_193 = NL + "                    java.io.Writer out";
  protected final String TEXT_194 = " = null;" + NL + "                    file";
  protected final String TEXT_195 = " = new java.io.File(fullName_";
  protected final String TEXT_196 = " + splitedFileNo_";
  protected final String TEXT_197 = " + extension_";
  protected final String TEXT_198 = ");" + NL;
  protected final String TEXT_199 = NL + "                    if(file";
  protected final String TEXT_200 = ".exists()) {" + NL + "                        file";
  protected final String TEXT_201 = ".delete();" + NL + "                    }";
  protected final String TEXT_202 = NL + "                    out";
  protected final String TEXT_203 = "(new java.io.OutputStreamWriter(" + NL + "                        new java.io.FileOutputStream(fullName_";
  protected final String TEXT_204 = NL + "                        synchronized (multiThreadLockWrite) {";
  protected final String TEXT_205 = NL + "                            synchronized (fileName_";
  protected final String TEXT_206 = ".intern()) {";
  protected final String TEXT_207 = NL + "                                Object[] pLockWrite = (Object[])globalMap.get(\"PARALLEL_LOCK_WRITE\");" + NL + "                                synchronized (pLockWrite) {";
  protected final String TEXT_208 = NL + "                                    if(file_";
  protected final String TEXT_209 = ".length()==0){";
  protected final String TEXT_210 = NL + "                                    if(file";
  protected final String TEXT_211 = NL + "                                            fileOutputDelimitedUtil_";
  protected final String TEXT_212 = ".putHeaderValue_";
  protected final String TEXT_213 = "(out";
  protected final String TEXT_214 = ",OUT_DELIM_";
  protected final String TEXT_215 = NL + "                                        out";
  protected final String TEXT_216 = NL + "                                            out";
  protected final String TEXT_217 = ".write(OUT_DELIM_ROWSEP_";
  protected final String TEXT_218 = ");" + NL + "                                        out";
  protected final String TEXT_219 = ".flush();" + NL + "                                    }";
  protected final String TEXT_220 = NL + "                        }";
  protected final String TEXT_221 = NL + "                    //routines.system.Row" + NL + "                    java.util.zip.ZipOutputStream zipOut_";
  protected final String TEXT_222 = "= null;" + NL + "                    java.io.OutputStreamWriter writer_";
  protected final String TEXT_223 = " = null;" + NL + "                    java.io.Writer out";
  protected final String TEXT_224 = " = null;" + NL + "                    zipOut_";
  protected final String TEXT_225 = "=new java.util.zip.ZipOutputStream(new java.io.BufferedOutputStream(";
  protected final String TEXT_226 = "));" + NL + "                    zipOut_";
  protected final String TEXT_227 = ".putNextEntry(new java.util.zip.ZipEntry(\"TalendOutputDelimited\"));" + NL + "                    writer_";
  protected final String TEXT_228 = " = new java.io.OutputStreamWriter(zipOut_";
  protected final String TEXT_229 = ");" + NL + "                    out";
  protected final String TEXT_230 = "(writer_";
  protected final String TEXT_231 = NL + "                    //routines.system.Row" + NL + "                    java.io.OutputStreamWriter writer_";
  protected final String TEXT_232 = " = null;" + NL + "                    writer_";
  protected final String TEXT_233 = " = new java.io.OutputStreamWriter(";
  protected final String TEXT_234 = NL + "                                fileOutputDelimitedUtil_";
  protected final String TEXT_235 = NL + "                            out";
  protected final String TEXT_236 = NL + "                                out";
  protected final String TEXT_237 = "= true;" + NL + "                String[] headColu";
  protected final String TEXT_238 = " = null;";
  protected final String TEXT_239 = NL + "                String[] headColu";
  protected final String TEXT_240 = "=new String[";
  protected final String TEXT_241 = "];";
  protected final String TEXT_242 = NL + "            class CSVBasicSet_";
  protected final String TEXT_243 = "{" + NL + "                private char field_Delim;" + NL + "                private char row_Delim;" + NL + "                private char escape;" + NL + "                private char textEnclosure;" + NL + "                private boolean useCRLFRecordDelimiter;" + NL + "" + NL + "                public boolean isUseCRLFRecordDelimiter() {" + NL + "                    return useCRLFRecordDelimiter;" + NL + "                }" + NL + "" + NL + "                public void setFieldSeparator(String fieldSep) throws IllegalArgumentException{" + NL + "                    char field_Delim_";
  protected final String TEXT_244 = "[] = null;" + NL + "" + NL + "                    //support passing value (property: Field Separator) by 'context.fs' or 'globalMap.get(\"fs\")'." + NL + "                    if (fieldSep.length() > 0 ){" + NL + "                        field_Delim_";
  protected final String TEXT_245 = " = fieldSep.toCharArray();" + NL + "                    }else {" + NL + "                        throw new IllegalArgumentException(\"Field Separator must be assigned a char.\");" + NL + "                    }" + NL + "                    this.field_Delim = field_Delim_";
  protected final String TEXT_246 = "[0];" + NL + "                }" + NL + "" + NL + "                public char getFieldDelim(){" + NL + "                    if(this.field_Delim==0){" + NL + "                        setFieldSeparator(";
  protected final String TEXT_247 = ");" + NL + "                    }" + NL + "                    return this.field_Delim;" + NL + "                }" + NL + "" + NL + "                public void setRowSeparator(String rowSep){" + NL + "                    if(\"\\r\\n\".equals(rowSep)) {" + NL + "                        useCRLFRecordDelimiter = true;" + NL + "                        return;" + NL + "                    }" + NL + "                    char row_Delim";
  protected final String TEXT_248 = "[] = null;" + NL + "" + NL + "                    //support passing value (property: Row Separator) by 'context.rs' or 'globalMap.get(\"rs\")'." + NL + "                    if (rowSep.length() > 0 ){" + NL + "                        row_Delim";
  protected final String TEXT_249 = " = rowSep.toCharArray();" + NL + "                    }else {" + NL + "                        throw new IllegalArgumentException(\"Row Separator must be assigned a char.\");" + NL + "                    }" + NL + "                    this.row_Delim = row_Delim";
  protected final String TEXT_250 = "[0];" + NL + "                }" + NL + "" + NL + "                public char getRowDelim(){" + NL + "                    if(this.row_Delim==0){" + NL + "                        setRowSeparator(";
  protected final String TEXT_251 = ");" + NL + "                    }" + NL + "                    return this.row_Delim;" + NL + "                }" + NL + "" + NL + "                public void setEscapeAndTextEnclosure(String strEscape, String strTextEnclosure) throws IllegalArgumentException{" + NL + "                    if(strEscape.length() <= 0 ){" + NL + "                        throw new IllegalArgumentException(\"Escape Char must be assigned a char.\");" + NL + "                    }" + NL + "" + NL + "                    if (\"\".equals(strTextEnclosure)) strTextEnclosure = \"\\0\";" + NL + "                    char textEnclosure_";
  protected final String TEXT_252 = "[] = null;" + NL + "" + NL + "                    if(strTextEnclosure.length() > 0 ){" + NL + "                        textEnclosure_";
  protected final String TEXT_253 = " = strTextEnclosure.toCharArray();" + NL + "                    }else {" + NL + "                        throw new IllegalArgumentException(\"Text Enclosure must be assigned a char.\");" + NL + "                    }" + NL + "" + NL + "                    this.textEnclosure = textEnclosure_";
  protected final String TEXT_254 = "[0];" + NL + "" + NL + "                    if((\"\\\\\").equals(strEscape)){" + NL + "                        this.escape = '\\\\';" + NL + "                    }else if(strEscape.equals(strTextEnclosure)){" + NL + "                        this.escape = this.textEnclosure;" + NL + "                    } else {" + NL + "                        //the default escape mode is double escape" + NL + "                        this.escape = this.textEnclosure;" + NL + "                    }" + NL + "" + NL + "" + NL + "                }" + NL + "" + NL + "                public char getEscapeChar(){" + NL + "                    return (char)this.escape;" + NL + "                }" + NL + "" + NL + "                public char getTextEnclosure(){" + NL + "                    return this.textEnclosure;" + NL + "                }" + NL + "            }" + NL + "" + NL + "            int nb_line_";
  protected final String TEXT_255 = " =0;" + NL + "            int currentRow_";
  protected final String TEXT_256 = " = 0;" + NL + "" + NL + "" + NL + "            CSVBasicSet_";
  protected final String TEXT_257 = " csvSettings_";
  protected final String TEXT_258 = " = new CSVBasicSet_";
  protected final String TEXT_259 = "();" + NL + "            csvSettings_";
  protected final String TEXT_260 = ".setFieldSeparator(";
  protected final String TEXT_261 = ");" + NL + "            csvSettings_";
  protected final String TEXT_262 = ".setRowSeparator(";
  protected final String TEXT_263 = ".setEscapeAndTextEnclosure(";
  protected final String TEXT_264 = " - Creating directory '\" +dir_";
  protected final String TEXT_265 = " - The directory '\" + dir_";
  protected final String TEXT_266 = NL + "                            file";
  protected final String TEXT_267 = ");" + NL + "                            String zipName_";
  protected final String TEXT_268 = " + \".zip\";" + NL + "                            java.io.File file_";
  protected final String TEXT_269 = ");" + NL + "                            //routines.system.Row" + NL + "                            java.util.zip.ZipOutputStream zipOut_";
  protected final String TEXT_270 = " = null;" + NL + "                            java.io.Writer out";
  protected final String TEXT_271 = " = null;" + NL + "                            com.talend.csv.CSVWriter CsvWriter";
  protected final String TEXT_272 = " = null;" + NL + "" + NL + "                            if(file_";
  protected final String TEXT_273 = ".exists()) {" + NL + "                                file_";
  protected final String TEXT_274 = ".delete();" + NL + "                            }" + NL + "                            zipOut_";
  protected final String TEXT_275 = "=new java.util.zip.ZipOutputStream(" + NL + "                                    new java.io.BufferedOutputStream(new java.io.FileOutputStream(zipName_";
  protected final String TEXT_276 = ")));" + NL + "                            zipOut_";
  protected final String TEXT_277 = ".getName()));" + NL + "                            out";
  protected final String TEXT_278 = " = new routines.system.BufferedOutput(new java.io.OutputStreamWriter(zipOut_";
  protected final String TEXT_279 = "));" + NL + "                            java.io.StringWriter strWriter";
  protected final String TEXT_280 = " = new java.io.StringWriter();" + NL + "                            CsvWriter";
  protected final String TEXT_281 = " = new com.talend.csv.CSVWriter(strWriter";
  protected final String TEXT_282 = ");" + NL + "                            CsvWriter";
  protected final String TEXT_283 = ".setSeparator(csvSettings_";
  protected final String TEXT_284 = ".getFieldDelim());";
  protected final String TEXT_285 = NL + "                            java.io.Writer out";
  protected final String TEXT_286 = NL + "                            java.io.File fileToDelete_";
  protected final String TEXT_287 = ");" + NL + "                            if(fileToDelete_";
  protected final String TEXT_288 = ".exists()) {" + NL + "                                fileToDelete_";
  protected final String TEXT_289 = ".delete();" + NL + "                            }";
  protected final String TEXT_290 = NL + "                            if (resourceMap.get(\"outWriter_for_\" + ";
  protected final String TEXT_291 = ") == null) {" + NL + "                                out";
  protected final String TEXT_292 = " = new routines.system.BufferedOutput(new java.io.OutputStreamWriter(" + NL + "                                    new java.io.FileOutputStream(fileName_";
  protected final String TEXT_293 = "), ";
  protected final String TEXT_294 = "));" + NL + "                                resourceMap.put(\"outWriter_for_\" + ";
  protected final String TEXT_295 = ");" + NL + "                            } else {" + NL + "                                out";
  protected final String TEXT_296 = " = (java.io.Writer) resourceMap.get(\"outWriter_for_\" + ";
  protected final String TEXT_297 = ");" + NL + "                            }" + NL + "                            java.io.StringWriter strWriter";
  protected final String TEXT_298 = ".getName()));" + NL + "                            CsvWriter";
  protected final String TEXT_299 = " = new com.talend.csv.CSVWriter(new java.io.BufferedWriter(new java.io.OutputStreamWriter(" + NL + "                            zipOut_";
  protected final String TEXT_300 = ")));" + NL + "                            CsvWriter";
  protected final String TEXT_301 = NL + "                            com.talend.csv.CSVWriter CsvWriter";
  protected final String TEXT_302 = NL + "                            CsvWriter";
  protected final String TEXT_303 = " = new com.talend.csv.CSVWriter(new java.io.BufferedWriter(new java.io.OutputStreamWriter(" + NL + "                            new java.io.FileOutputStream(fileName_";
  protected final String TEXT_304 = ");" + NL + "                        java.io.Writer out";
  protected final String TEXT_305 = " = null;" + NL + "                        com.talend.csv.CSVWriter CsvWriter";
  protected final String TEXT_306 = NL + "                        if(file";
  protected final String TEXT_307 = ".exists()) {" + NL + "                            file";
  protected final String TEXT_308 = " = new routines.system.BufferedOutput(new java.io.OutputStreamWriter(" + NL + "                            new java.io.FileOutputStream(fullName_";
  protected final String TEXT_309 = "));" + NL + "                        java.io.StringWriter strWriter";
  protected final String TEXT_310 = " = new java.io.StringWriter();" + NL + "                        CsvWriter";
  protected final String TEXT_311 = ");" + NL + "                        CsvWriter";
  protected final String TEXT_312 = ".getFieldDelim());" + NL;
  protected final String TEXT_313 = ");" + NL + "                        com.talend.csv.CSVWriter CsvWriter";
  protected final String TEXT_314 = NL + "                        CsvWriter";
  protected final String TEXT_315 = " = new com.talend.csv.CSVWriter(new java.io.BufferedWriter(new java.io.OutputStreamWriter(" + NL + "                            new java.io.FileOutputStream(fullName_";
  protected final String TEXT_316 = ")));" + NL + "                        CsvWriter";
  protected final String TEXT_317 = NL + "                    if(csvSettings_";
  protected final String TEXT_318 = ".isUseCRLFRecordDelimiter()) {" + NL + "                        CsvWriter";
  protected final String TEXT_319 = ".setLineEnd(\"\\r\\n\");" + NL + "                    } else {" + NL + "                        CsvWriter";
  protected final String TEXT_320 = ".setLineEnd(\"\"+csvSettings_";
  protected final String TEXT_321 = ".getRowDelim());" + NL + "                    }";
  protected final String TEXT_322 = NL + "                    if(!csvSettings_";
  protected final String TEXT_323 = ".isUseCRLFRecordDelimiter() && csvSettings_";
  protected final String TEXT_324 = ".getRowDelim()!='\\r' && csvSettings_";
  protected final String TEXT_325 = ".getRowDelim()!='\\n') {" + NL + "                        CsvWriter";
  protected final String TEXT_326 = NL + "                        synchronized (fileName_";
  protected final String TEXT_327 = NL + "                        Object[] pLockWrite = (Object[])globalMap.get(\"PARALLEL_LOCK_WRITE\");" + NL + "                        synchronized (pLockWrite) {";
  protected final String TEXT_328 = NL + "                        if(file_";
  protected final String TEXT_329 = NL + "                                        fileOutputDelimitedUtil_";
  protected final String TEXT_330 = "(headColu";
  protected final String TEXT_331 = NL + "                                    headColu";
  protected final String TEXT_332 = ".writeNext(headColu";
  protected final String TEXT_333 = ".flush();";
  protected final String TEXT_334 = ".write(strWriter";
  protected final String TEXT_335 = ".getBuffer().toString());" + NL + "                                out";
  protected final String TEXT_336 = ".flush();" + NL + "                                strWriter";
  protected final String TEXT_337 = ".getBuffer().delete(0, strWriter";
  protected final String TEXT_338 = ".getBuffer().length());";
  protected final String TEXT_339 = NL + "                        java.util.zip.ZipOutputStream zipOut_";
  protected final String TEXT_340 = " = null;" + NL + "                        java.io.OutputStreamWriter outWriter_";
  protected final String TEXT_341 = " = null;" + NL + "                        java.io.Writer out";
  protected final String TEXT_342 = " = null;" + NL + "                        zipOut_";
  protected final String TEXT_343 = "=new java.util.zip.ZipOutputStream(" + NL + "                                new java.io.BufferedOutputStream(";
  protected final String TEXT_344 = "));" + NL + "                        zipOut_";
  protected final String TEXT_345 = ".putNextEntry(new java.util.zip.ZipEntry(\"TalendOutputDelimited\"));" + NL + "                        outWriter_";
  protected final String TEXT_346 = ");" + NL + "                        out";
  protected final String TEXT_347 = " = new routines.system.BufferedOutput(outWriter_";
  protected final String TEXT_348 = ");" + NL + "                        java.io.StringWriter strWriter";
  protected final String TEXT_349 = NL + "                        java.io.OutputStreamWriter outWriter_";
  protected final String TEXT_350 = " = null;" + NL + "                        outWriter_";
  protected final String TEXT_351 = " = null;" + NL + "                        java.io.BufferedWriter bufferWriter_";
  protected final String TEXT_352 = ");" + NL + "                        bufferWriter_";
  protected final String TEXT_353 = " = new java.io.BufferedWriter(outWriter_";
  protected final String TEXT_354 = " = new com.talend.csv.CSVWriter(bufferWriter_";
  protected final String TEXT_355 = NL + "                            headColu";
  protected final String TEXT_356 = NL + "                    CsvWriter";
  protected final String TEXT_357 = ".getBuffer().toString());" + NL + "                        strWriter";
  protected final String TEXT_358 = NL + "                CsvWriter";
  protected final String TEXT_359 = ".setEscapeChar(csvSettings_";
  protected final String TEXT_360 = ".getEscapeChar());" + NL + "                CsvWriter";
  protected final String TEXT_361 = ".setQuoteChar(csvSettings_";
  protected final String TEXT_362 = ".getTextEnclosure());" + NL + "                CsvWriter";
  protected final String TEXT_363 = ".setQuoteStatus(com.talend.csv.CSVWriter.QuoteStatus.FORCE);";
  protected final String TEXT_364 = NL + NL;
  protected final String TEXT_365 = NL + "        resourceMap.put(\"out_";
  protected final String TEXT_366 = "\", out";
  protected final String TEXT_367 = ");" + NL + "        resourceMap.put(\"writer_";
  protected final String TEXT_368 = "\", writer_";
  protected final String TEXT_369 = NL + "    resourceMap.put(\"CsvWriter_";
  protected final String TEXT_370 = "\", CsvWriter";
  protected final String TEXT_371 = NL + "            resourceMap.put(\"out_";
  protected final String TEXT_372 = ");" + NL + "            resourceMap.put(\"outWriter_";
  protected final String TEXT_373 = "\", outWriter_";
  protected final String TEXT_374 = NL + "            resourceMap.put(\"bufferWriter_";
  protected final String TEXT_375 = "\", bufferWriter_";
  protected final String TEXT_376 = NL + "resourceMap.put(\"nb_line_";
  protected final String TEXT_377 = "\", nb_line_";
  protected final String TEXT_378 = NL + "    resourceMap.put(\"isFileGenerated_";
  protected final String TEXT_379 = "\", isFileGenerated_";
  protected final String TEXT_380 = NL + "        resourceMap.put(\"file_";
  protected final String TEXT_381 = "\", file_";
  protected final String TEXT_382 = NL + "        resourceMap.put(\"file";
  protected final String TEXT_383 = "\", file";

  public String generate(Object argument)
  {
    final StringBuffer stringBuffer = new StringBuffer();
    
	//this util class use by set log4j debug paramters
	class DefaultLog4jFileUtil {
	
		INode node = null;
	    String cid = null;
 		boolean isLog4jEnabled = false;
 		String label = null;
 		
 		public DefaultLog4jFileUtil(){
 		}
 		public DefaultLog4jFileUtil(INode node) {
 			this.node = node;
 			this.cid = node.getUniqueName();
 			this.label = cid;
			this.isLog4jEnabled = ("true").equals(org.talend.core.model.process.ElementParameterParser.getValue(node.getProcess(), "__LOG4J_ACTIVATE__"));
 		}
 		
 		public void setCid(String cid) {
 			this.cid = cid;
 		}
 		
		//for all tFileinput* components 
		public void startRetriveDataInfo() {
			if (isLog4jEnabled) {
			
    stringBuffer.append(TEXT_1);
    stringBuffer.append(label);
    stringBuffer.append(TEXT_2);
    
			}
		}
		
		public void retrievedDataNumberInfo() {
			if (isLog4jEnabled) {
			
    stringBuffer.append(TEXT_3);
    stringBuffer.append(label);
    stringBuffer.append(TEXT_4);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_5);
    
			}
		}
		
		public void retrievedDataNumberInfoFromGlobalMap(INode node) {
			if (isLog4jEnabled) {
			
    stringBuffer.append(TEXT_3);
    stringBuffer.append(label);
    stringBuffer.append(TEXT_6);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_7);
    
			}
		}
		
		//for all tFileinput* components 
		public void retrievedDataNumberInfo(INode node) {
			if (isLog4jEnabled) {
			
    stringBuffer.append(TEXT_3);
    stringBuffer.append(label);
    stringBuffer.append(TEXT_4);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_5);
    
			}
		}
		
		public void writeDataFinishInfo(INode node) {
			if(isLog4jEnabled){
			
    stringBuffer.append(TEXT_3);
    stringBuffer.append(label);
    stringBuffer.append(TEXT_8);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_5);
    
			}
		}
		
 		//TODO delete it and remove all log4jSb parameter from components
		public void componentStartInfo(INode node) {
			if (isLog4jEnabled) {
			
    stringBuffer.append(TEXT_9);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_10);
    
			}
		}
		
		//TODO rename or delete it
		public void debugRetriveData(INode node,boolean hasIncreased) {
			if(isLog4jEnabled){
			
    stringBuffer.append(TEXT_3);
    stringBuffer.append(label);
    stringBuffer.append(TEXT_11);
    stringBuffer.append(cid);
    stringBuffer.append(hasIncreased?"":"+1");
    stringBuffer.append(TEXT_12);
    
			}
		}
		
		//TODO rename or delete it
		public void debugRetriveData(INode node) {
			debugRetriveData(node,true);
		}
		
		//TODO rename or delete it
		public void debugWriteData(INode node) {
			if(isLog4jEnabled){
			
    stringBuffer.append(TEXT_3);
    stringBuffer.append(label);
    stringBuffer.append(TEXT_13);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_14);
    
			}
		}
		
		public void logCurrentRowNumberInfo() {
			if(isLog4jEnabled){
			
    stringBuffer.append(TEXT_3);
    stringBuffer.append(label);
    stringBuffer.append(TEXT_15);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_16);
    
			}
		}
		
		public void logDataCountInfo() {
			if(isLog4jEnabled){
			
    stringBuffer.append(TEXT_3);
    stringBuffer.append(label);
    stringBuffer.append(TEXT_17);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_5);
    
			}
		}

        public void logErrorMessage() {
            if(isLog4jEnabled){
            
    stringBuffer.append(TEXT_18);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_19);
    
            } else {
            
    stringBuffer.append(TEXT_20);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_19);
    
            }
        }
	}
	
	final DefaultLog4jFileUtil log4jFileUtil = new DefaultLog4jFileUtil((INode)(((org.talend.designer.codegen.config.CodeGeneratorArgument)argument).getArgument()));
	
    
CodeGeneratorArgument codeGenArgument = (CodeGeneratorArgument) argument;
INode node = (INode)codeGenArgument.getArgument();
String cid = node.getUniqueName();

boolean isTSalesforceWaveOutputBulkExec = ((cid == null) ? false : (cid.startsWith("tSalesforceWaveOutputBulkExec")));
boolean useDoubleQuoteEnclosure = "true".equals(ElementParameterParser.getValue(node,"__CSV_OPTION__"))
                                  && ("\"\"\"").equals(ElementParameterParser.getValue(node, "__TEXT_ENCLOSURE__"));
boolean applyNA4Null = isTSalesforceWaveOutputBulkExec;
String str4Nil = "#N/A";

boolean useStream = ("true").equals(ElementParameterParser.getValue(node,"__USESTREAM__"));
String outStream = ElementParameterParser.getValue(node,"__STREAMNAME__");
String fileName = ElementParameterParser.getValue(node,"__FILENAME__");

boolean isAppend = ("true").equals(ElementParameterParser.getValue(node,"__APPEND__"));
int schemaOptNum=100;
String schemaOptNumStr=ElementParameterParser.getValue(node, "__SCHEMA_OPT_NUM__");
if(schemaOptNumStr!=null && !"".equals(schemaOptNumStr) && !"\"\"".equals(schemaOptNumStr)){
    schemaOptNum  = Integer.parseInt(schemaOptNumStr);
}
boolean isIncludeHeader = ("true").equals(ElementParameterParser.getValue(node,"__INCLUDEHEADER__"));
String advancedSeparatorStr = ElementParameterParser.getValue(node, "__ADVANCED_SEPARATOR__");
boolean advancedSeparator = (advancedSeparatorStr!=null&&!("").equals(advancedSeparatorStr))?("true").equals(advancedSeparatorStr):false;
String thousandsSeparator = ElementParameterParser.getValueWithJavaType(node, "__THOUSANDS_SEPARATOR__", JavaTypesManager.CHARACTER);
String decimalSeparator = ElementParameterParser.getValueWithJavaType(node, "__DECIMAL_SEPARATOR__", JavaTypesManager.CHARACTER);
String encoding = ElementParameterParser.getValue(node,"__ENCODING__");
boolean split = ("true").equals(ElementParameterParser.getValue(node, "__SPLIT__"));
boolean isInRowMode = ("true").equals(ElementParameterParser.getValue(node,"__ROW_MODE__"));

boolean compress = ("true").equals(ElementParameterParser.getValue(node,"__COMPRESS__"));

String parallelize = ElementParameterParser.getValue(node,"__PARALLELIZE__");
boolean isParallelize = (parallelize!=null&&!("").equals(parallelize))?("true").equals(parallelize):false;
IProcess process = node.getProcess();
boolean isLog4jEnabled = ("true").equals(ElementParameterParser.getValue(process, "__LOG4J_ACTIVATE__"));
boolean exceptionOnFileExist = !useStream&&!isAppend&&(("true").equals(ElementParameterParser.getValue(node, "__FILE_EXIST_EXCEPTION__")));

    stringBuffer.append(TEXT_21);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_22);
    
List<IMetadataTable> metadatas = node.getMetadataList();
List< ? extends IConnection> conns = node.getIncomingConnections();
if ((metadatas!=null)&&(metadatas.size()>0)) {//A1
    IMetadataTable metadata = metadatas.get(0);
    boolean hasDynamic = metadata.isDynamicSchema();
    if(hasDynamic && ("true").equals(ElementParameterParser.getValue(node,"__CSV_OPTION__"))){
    
    stringBuffer.append(TEXT_23);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_24);
    
    }
    IMetadataColumn dynamicCol = metadata.getDynamicColumn();
    for (IConnection conn : conns) {//B1
        if (conn.getLineStyle().hasConnectionCategory(IConnectionCategory.DATA)) {//C1
            List<IMetadataColumn> columns = metadata.getListColumns();
            int sizeColumns = columns.size();
            if(sizeColumns> schemaOptNum){//D1
            
    stringBuffer.append(TEXT_25);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_26);
    
                    if(("false").equals(ElementParameterParser.getValue(node,"__CSV_OPTION__"))) {//E1 not use CSV Option
                        if(isIncludeHeader){//F1
                            for (int i = 0; i < sizeColumns; i++) {//H1
                                IMetadataColumn column = columns.get(i);
                                if(i%schemaOptNum==0){
                                
    stringBuffer.append(TEXT_27);
    stringBuffer.append(i/schemaOptNum);
    stringBuffer.append(TEXT_28);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_29);
    stringBuffer.append(cid);
    if(hasDynamic){
    stringBuffer.append(TEXT_30);
    stringBuffer.append(NodeUtil.getPrivateConnClassName(conn) );
    stringBuffer.append(TEXT_31);
    stringBuffer.append(conn.getName() );
    }
    stringBuffer.append(TEXT_32);
    
                                }
                                if(!("id_Dynamic".equals(column.getTalendType()))) {
                                
    stringBuffer.append(TEXT_33);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_34);
    stringBuffer.append(column.getLabel() );
    stringBuffer.append(TEXT_35);
    
                                }else{
                                
    stringBuffer.append(TEXT_36);
    stringBuffer.append(conn.getName() );
    stringBuffer.append(TEXT_37);
    stringBuffer.append(column.getLabel() );
    stringBuffer.append(TEXT_38);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_39);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_19);
    
                                }
                                if(i != sizeColumns - 1) {
                                
    stringBuffer.append(TEXT_33);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_40);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_19);
    
                                }
                                if((i+1)%schemaOptNum==0){
                                
    stringBuffer.append(TEXT_41);
    
                                }
                            }//H1
                            if(sizeColumns>0&&(sizeColumns%schemaOptNum)>0){
                            
    stringBuffer.append(TEXT_42);
    
                            }
                        }//F1
                        for (int i = 0; i < sizeColumns; i++) {//F2
                            IMetadataColumn column = columns.get(i);
                            JavaType javaType = JavaTypesManager.getJavaTypeFromId(column.getTalendType());
                            boolean isPrimitive = JavaTypesManager.isJavaPrimitiveType( javaType, column.isNullable());
                            if(i%schemaOptNum==0){
                            
    stringBuffer.append(TEXT_43);
    stringBuffer.append(i/schemaOptNum);
    stringBuffer.append(TEXT_44);
    stringBuffer.append(NodeUtil.getPrivateConnClassName(conn) );
    stringBuffer.append(TEXT_31);
    stringBuffer.append(conn.getName() );
    stringBuffer.append(TEXT_45);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_29);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_46);
    
                            }
                            if(!isPrimitive) {
                            
    stringBuffer.append(TEXT_47);
    stringBuffer.append(conn.getName() );
    stringBuffer.append(TEXT_37);
    stringBuffer.append(column.getLabel() );
    stringBuffer.append(TEXT_48);
    
                            }
                            if(column.getTalendType().equals("id_Dynamic")){
                                if(advancedSeparator){

    stringBuffer.append(TEXT_49);
    stringBuffer.append(conn.getName() );
    stringBuffer.append(TEXT_37);
    stringBuffer.append(column.getLabel() );
    stringBuffer.append(TEXT_50);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_39);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_51);
    stringBuffer.append( thousandsSeparator );
    stringBuffer.append(TEXT_51);
    stringBuffer.append( decimalSeparator );
    stringBuffer.append(TEXT_52);
    stringBuffer.append(encoding );
    stringBuffer.append(TEXT_53);
    
							    }else{
    stringBuffer.append(TEXT_54);
    stringBuffer.append(conn.getName() );
    stringBuffer.append(TEXT_37);
    stringBuffer.append(column.getLabel() );
    stringBuffer.append(TEXT_50);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_39);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_52);
    stringBuffer.append(encoding );
    stringBuffer.append(TEXT_55);
    }
                            }else{
                            
    stringBuffer.append(TEXT_56);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_57);
    
                                    String pattern = column.getPattern() == null || column.getPattern().trim().length() == 0 ? null : column.getPattern();
                                    if (javaType == JavaTypesManager.DATE && pattern != null && pattern.trim().length() != 0) {
                                    
    stringBuffer.append(TEXT_58);
    stringBuffer.append(conn.getName() );
    stringBuffer.append(TEXT_37);
    stringBuffer.append(column.getLabel() );
    stringBuffer.append(TEXT_51);
    stringBuffer.append( pattern );
    stringBuffer.append(TEXT_59);
    
                                    } else if(advancedSeparator && JavaTypesManager.isNumberType(javaType, column.isNullable())) {
                                        if(javaType == JavaTypesManager.BIGDECIMAL) {
                                        
    stringBuffer.append(TEXT_60);
    stringBuffer.append(column.getPrecision() == null? conn.getName() + "." + column.getLabel() : conn.getName() + "." + column.getLabel() + ".setScale(" + column.getPrecision() + ", java.math.RoundingMode.HALF_UP)" );
    stringBuffer.append(TEXT_61);
    stringBuffer.append( thousandsSeparator );
    stringBuffer.append(TEXT_51);
    stringBuffer.append( decimalSeparator );
    stringBuffer.append(TEXT_59);
    
                                        } else {
                                        
    stringBuffer.append(TEXT_62);
    stringBuffer.append(conn.getName() );
    stringBuffer.append(TEXT_37);
    stringBuffer.append(column.getLabel() );
    stringBuffer.append(TEXT_63);
    stringBuffer.append( thousandsSeparator );
    stringBuffer.append(TEXT_51);
    stringBuffer.append( decimalSeparator );
    stringBuffer.append(TEXT_59);
    
                                        }
                                    } else if(javaType == JavaTypesManager.BIGDECIMAL){
                                    
    stringBuffer.append(TEXT_64);
    stringBuffer.append(column.getPrecision() == null? conn.getName() + "." + column.getLabel() : conn.getName() + "." + column.getLabel() + ".setScale(" + column.getPrecision() + ", java.math.RoundingMode.HALF_UP)" );
    stringBuffer.append(TEXT_65);
    
                                    } else if(javaType == JavaTypesManager.BYTE_ARRAY){
                                    
    stringBuffer.append(TEXT_66);
    stringBuffer.append(encoding );
    stringBuffer.append(TEXT_67);
    stringBuffer.append(conn.getName() );
    stringBuffer.append(TEXT_37);
    stringBuffer.append(column.getLabel() );
    stringBuffer.append(TEXT_68);
    
                                    } else {
                                    
    stringBuffer.append(TEXT_64);
    stringBuffer.append(conn.getName() );
    stringBuffer.append(TEXT_37);
    stringBuffer.append(column.getLabel() );
    
                                    }
                                    
    stringBuffer.append(TEXT_69);
    
                            }
                            if(!isPrimitive) {
                            
    stringBuffer.append(TEXT_42);
    
                            }
                            if(i != sizeColumns - 1) {
                            
    stringBuffer.append(TEXT_56);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_70);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_19);
    
                            }
                            if((i+1)%schemaOptNum==0){
                            
    stringBuffer.append(TEXT_42);
    
                            }
                        }//F2
                        if(sizeColumns>0&&(sizeColumns%schemaOptNum)>0){
                        
    stringBuffer.append(TEXT_71);
    
                        }
                    }else{
                        //E2 use CSV Option
                        if(isIncludeHeader){//F3
                            for (int i = 0; i < sizeColumns; i++) {//H3
                                IMetadataColumn column = columns.get(i);
                                if(i%schemaOptNum==0){
                                
    stringBuffer.append(TEXT_27);
    stringBuffer.append(i/schemaOptNum);
    stringBuffer.append(TEXT_72);
    stringBuffer.append(cid);
    if(hasDynamic){
    stringBuffer.append(TEXT_30);
    stringBuffer.append(NodeUtil.getPrivateConnClassName(conn) );
    stringBuffer.append(TEXT_31);
    stringBuffer.append(conn.getName() );
    stringBuffer.append(TEXT_73);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_74);
    }
    stringBuffer.append(TEXT_32);
    
                                }
                                if(!("id_Dynamic".equals(column.getTalendType()))) {
                                    if(hasDynamic){
                                    
    stringBuffer.append(TEXT_75);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_76);
    stringBuffer.append(i-1);
    stringBuffer.append(TEXT_77);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_78);
    stringBuffer.append(column.getLabel() );
    stringBuffer.append(TEXT_79);
    
                                    }else{
                                    
    stringBuffer.append(TEXT_75);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_76);
    stringBuffer.append(i);
    stringBuffer.append(TEXT_78);
    stringBuffer.append(column.getLabel() );
    stringBuffer.append(TEXT_79);
    
                                    }
                                }else{
                                
    stringBuffer.append(TEXT_80);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_81);
    stringBuffer.append(conn.getName());
    stringBuffer.append(TEXT_37);
    stringBuffer.append(column.getLabel());
    stringBuffer.append(TEXT_82);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_83);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_76);
    stringBuffer.append(i);
    stringBuffer.append(TEXT_84);
    stringBuffer.append(conn.getName());
    stringBuffer.append(TEXT_37);
    stringBuffer.append(column.getLabel());
    stringBuffer.append(TEXT_85);
    
                                }
                                if((i+1)%schemaOptNum==0){
                                
    stringBuffer.append(TEXT_41);
    
                                }
                            }//H3
                            if(sizeColumns>0&&(sizeColumns%schemaOptNum)>0){
                            
    stringBuffer.append(TEXT_42);
    
                            }
                        }//F3
                        for (int i = 0; i < sizeColumns; i++) {//F4
                            IMetadataColumn column = columns.get(i);
                            JavaType javaType = JavaTypesManager.getJavaTypeFromId(column.getTalendType());
                            String pattern = column.getPattern() == null || column.getPattern().trim().length() == 0 ? null : column.getPattern();
                            boolean isPrimitive = JavaTypesManager.isJavaPrimitiveType( javaType, column.isNullable());
                            if(i%schemaOptNum==0){
                            
    stringBuffer.append(TEXT_43);
    stringBuffer.append(i/schemaOptNum);
    stringBuffer.append(TEXT_44);
    stringBuffer.append(NodeUtil.getPrivateConnClassName(conn) );
    stringBuffer.append(TEXT_31);
    stringBuffer.append(conn.getName() );
    stringBuffer.append(TEXT_86);
    stringBuffer.append(cid);
    if(hasDynamic){
    stringBuffer.append(TEXT_73);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_74);
    }
    stringBuffer.append(TEXT_87);
    
                            }
                            if(("id_Dynamic").equals(column.getTalendType())) {
                            
    stringBuffer.append(TEXT_88);
    stringBuffer.append(conn.getName());
    stringBuffer.append(TEXT_37);
    stringBuffer.append(column.getLabel());
    stringBuffer.append(TEXT_89);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_81);
    stringBuffer.append(conn.getName());
    stringBuffer.append(TEXT_37);
    stringBuffer.append(column.getLabel());
    stringBuffer.append(TEXT_90);
    stringBuffer.append(conn.getName());
    stringBuffer.append(TEXT_37);
    stringBuffer.append(column.getLabel());
    stringBuffer.append(TEXT_91);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_51);
    stringBuffer.append( i );
    stringBuffer.append(TEXT_92);
    
                                       if(applyNA4Null){
                                            
    stringBuffer.append(TEXT_93);
    stringBuffer.append( str4Nil );
    stringBuffer.append(TEXT_94);
    
                                       }else{
                                            
    stringBuffer.append(TEXT_95);
    
                                       }
                                     
    stringBuffer.append(TEXT_52);
    stringBuffer.append(encoding );
    stringBuffer.append(TEXT_96);
    
                            }else{
                                if(hasDynamic){
                                
    stringBuffer.append(TEXT_97);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_76);
    stringBuffer.append(i-1);
    stringBuffer.append(TEXT_77);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_98);
    stringBuffer.append(isPrimitive? "":conn.getName()+"."+column.getLabel()+ " == null ? null : ");
    
                                }else{
                                
    stringBuffer.append(TEXT_97);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_76);
    stringBuffer.append(i);
    stringBuffer.append(TEXT_98);
    stringBuffer.append(isPrimitive? "":conn.getName()+"."+column.getLabel()+ " == null ? null : ");
    
                                }
                                if(javaType == JavaTypesManager.STRING ){
                                
    stringBuffer.append(TEXT_99);
    stringBuffer.append(conn.getName() );
    stringBuffer.append(TEXT_37);
    stringBuffer.append(column.getLabel() );
    stringBuffer.append(TEXT_100);
    
                                }else if(javaType == JavaTypesManager.DATE && pattern != null){
                                
    stringBuffer.append(TEXT_101);
    stringBuffer.append(conn.getName() );
    stringBuffer.append(TEXT_37);
    stringBuffer.append(column.getLabel() );
    stringBuffer.append(TEXT_51);
    stringBuffer.append( pattern );
    stringBuffer.append(TEXT_19);
    
                                }else if(javaType == JavaTypesManager.BYTE_ARRAY){
                                
    stringBuffer.append(TEXT_102);
    stringBuffer.append(encoding );
    stringBuffer.append(TEXT_67);
    stringBuffer.append(conn.getName() );
    stringBuffer.append(TEXT_37);
    stringBuffer.append(column.getLabel() );
    stringBuffer.append(TEXT_103);
    
                                }else if(advancedSeparator && JavaTypesManager.isNumberType(javaType, column.isNullable())) {
                                    if(javaType == JavaTypesManager.BIGDECIMAL) {
    stringBuffer.append(TEXT_104);
    stringBuffer.append(column.getPrecision() == null? conn.getName() + "." + column.getLabel() : conn.getName() + "." + column.getLabel() + ".setScale(" + column.getPrecision() + ", java.math.RoundingMode.HALF_UP)" );
    stringBuffer.append(TEXT_61);
    stringBuffer.append( thousandsSeparator );
    stringBuffer.append(TEXT_51);
    stringBuffer.append( decimalSeparator );
    stringBuffer.append(TEXT_19);
    
                                    } else { 
    stringBuffer.append(TEXT_105);
    stringBuffer.append(conn.getName() );
    stringBuffer.append(TEXT_37);
    stringBuffer.append(column.getLabel() );
    stringBuffer.append(TEXT_63);
    stringBuffer.append( thousandsSeparator );
    stringBuffer.append(TEXT_51);
    stringBuffer.append( decimalSeparator );
    stringBuffer.append(TEXT_19);
    
                                    }
                                } else if (javaType == JavaTypesManager.BIGDECIMAL) {
                                
    stringBuffer.append(TEXT_99);
    stringBuffer.append(column.getPrecision() == null? conn.getName() + "." + column.getLabel() : conn.getName() + "." + column.getLabel() + ".setScale(" + column.getPrecision() + ", java.math.RoundingMode.HALF_UP)" );
    stringBuffer.append(TEXT_106);
    
                                } else{
                                
    stringBuffer.append(TEXT_107);
    stringBuffer.append(conn.getName() );
    stringBuffer.append(TEXT_37);
    stringBuffer.append(column.getLabel() );
    stringBuffer.append(TEXT_19);
    
                                }
                            }
                            if((i+1)%schemaOptNum==0){
                            
    stringBuffer.append(TEXT_42);
    
                            }
                        }//F4
                        if(sizeColumns>0&&(sizeColumns%schemaOptNum)>0){
                        
    stringBuffer.append(TEXT_71);
    
                        }
                    }
                    
    stringBuffer.append(TEXT_108);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_109);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_110);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_111);
    
            }//D1
        }//C1
    }//B1
}//A1

if(!useStream){

    stringBuffer.append(TEXT_112);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_113);
    stringBuffer.append(fileName);
    stringBuffer.append(TEXT_114);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_115);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_116);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_117);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_118);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_119);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_120);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_121);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_122);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_123);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_121);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_124);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_125);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_121);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_126);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_127);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_121);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_124);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_128);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_129);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_121);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_124);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_125);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_121);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_126);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_130);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_121);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_122);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_131);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_132);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_133);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_134);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_135);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_136);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_19);
    
    if(exceptionOnFileExist){
    
    stringBuffer.append(TEXT_137);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_138);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_139);
    
    }
    
    
    if(isAppend){
    
    stringBuffer.append(TEXT_140);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_141);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_142);
    
    }
}
if(("false").equals(ElementParameterParser.getValue(node,"__CSV_OPTION__"))) {
// ////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
    if ((metadatas!=null)&&(metadatas.size()>0)) {
        IMetadataTable metadata = metadatas.get(0);
        if (metadata!=null) {

            String fieldSeparator = ElementParameterParser.getValueWithUIFieldKey(
                node,
                "__FIELDSEPARATOR__",
                "FIELDSEPARATOR"
            );

            String rowSeparator = ElementParameterParser.getValueWithUIFieldKey(
                node,
                "__ROWSEPARATOR__",
                "ROWSEPARATOR"
            );


            String splitEvery = ElementParameterParser.getValue(node, "__SPLIT_EVERY__");

            boolean hasDynamic = metadata.isDynamicSchema();
            if(hasDynamic){
            
    stringBuffer.append(TEXT_143);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_144);
    
            }
            
    stringBuffer.append(TEXT_145);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_146);
    
            if(split){
            
    stringBuffer.append(TEXT_147);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_81);
    stringBuffer.append(splitEvery );
    stringBuffer.append(TEXT_100);
    
            }
            
    stringBuffer.append(TEXT_148);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_149);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_150);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_81);
    stringBuffer.append(fieldSeparator );
    stringBuffer.append(TEXT_151);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_81);
    stringBuffer.append(rowSeparator );
    stringBuffer.append(TEXT_152);
    
            if(!useStream){
            //**************************** the following is the part of file Path***************************************

                if(("true").equals(ElementParameterParser.getValue(node,"__CREATE__"))){
                
    stringBuffer.append(TEXT_153);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_154);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_155);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_156);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_157);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_158);
    if(isLog4jEnabled){
    stringBuffer.append(TEXT_159);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_160);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_161);
    }
    stringBuffer.append(TEXT_162);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_163);
    if(isLog4jEnabled){
    stringBuffer.append(TEXT_159);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_164);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_165);
    }
    stringBuffer.append(TEXT_166);
    
                }
                
    stringBuffer.append(TEXT_167);
    
                String writerClass = null;
                if(isInRowMode){
                    writerClass = "routines.system.BufferedOutput";
                }else{
                    writerClass = "java.io.BufferedWriter";
                }
                if(!split){
                    if(compress && !isAppend){// compress the dest file
                    
    stringBuffer.append(TEXT_168);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_134);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_169);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_170);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_171);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_172);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_173);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_174);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_175);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_176);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_177);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_178);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_179);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_180);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_181);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_182);
    stringBuffer.append(writerClass);
    stringBuffer.append(TEXT_183);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_92);
    stringBuffer.append(encoding);
    stringBuffer.append(TEXT_53);
    
                    }else{
                    
    stringBuffer.append(TEXT_184);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_185);
    if(!isAppend) {
    stringBuffer.append(TEXT_186);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_134);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_187);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_188);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_189);
    }
    stringBuffer.append(TEXT_190);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_182);
    stringBuffer.append(writerClass);
    stringBuffer.append(TEXT_191);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_51);
    stringBuffer.append(isAppend);
    stringBuffer.append(TEXT_192);
    stringBuffer.append(encoding);
    stringBuffer.append(TEXT_53);
    
                    }
                } else {
                
    stringBuffer.append(TEXT_193);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_194);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_195);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_196);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_197);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_198);
    if(!isAppend) {
    stringBuffer.append(TEXT_199);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_200);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_201);
    }
    stringBuffer.append(TEXT_202);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_182);
    stringBuffer.append(writerClass);
    stringBuffer.append(TEXT_203);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_196);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_197);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_51);
    stringBuffer.append(isAppend);
    stringBuffer.append(TEXT_192);
    stringBuffer.append(encoding);
    stringBuffer.append(TEXT_53);
    
                }

                if(isIncludeHeader && !hasDynamic){
                
    
                    if(codeGenArgument.getIsRunInMultiThread()){
                    
    stringBuffer.append(TEXT_204);
    
                    }
                        if (((AbstractNode)node).getParallelIterator() != null) {
                        
    stringBuffer.append(TEXT_205);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_206);
    
                        }
                            if (isParallelize) {
                            
    stringBuffer.append(TEXT_207);
    
                            }
                                if(!split && compress && !isAppend){
                                
    stringBuffer.append(TEXT_208);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_209);
    
                                }else{
                                
    stringBuffer.append(TEXT_210);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_209);
    
                                }
                                List<IMetadataColumn> columns = metadata.getListColumns();
                                int sizeColumns = columns.size();
                                for (int i = 0; i < sizeColumns; i++) {
                                    IMetadataColumn column = columns.get(i);
                                    if(sizeColumns > schemaOptNum){
                                        if(i%schemaOptNum==0){
                                        
    stringBuffer.append(TEXT_211);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_212);
    stringBuffer.append(i/schemaOptNum);
    stringBuffer.append(TEXT_213);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_214);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_19);
    
                                        }
                                    }else{//AA
                                    
    stringBuffer.append(TEXT_215);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_34);
    stringBuffer.append(column.getLabel() );
    stringBuffer.append(TEXT_35);
    
                                        if(i != sizeColumns - 1) {
                                            
    stringBuffer.append(TEXT_216);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_40);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_19);
    
                                        }
                                    }//AA
                                }
                                
    stringBuffer.append(TEXT_215);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_217);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_218);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_219);
    
                            if (isParallelize) {
                            
    stringBuffer.append(TEXT_42);
    
                            }
                        if (((AbstractNode)node).getParallelIterator() != null) {
                        
    stringBuffer.append(TEXT_71);
    
                        }
                    if(codeGenArgument.getIsRunInMultiThread()){
                    
    stringBuffer.append(TEXT_220);
    
                    }
                }

            }else{
            //***********************the following is the part of output Stream**************************************

                String writerClass = null;
                if(isInRowMode){
                    writerClass = "routines.system.BufferedOutput";
                }else{
                    writerClass = "java.io.BufferedWriter";
                }
                if(compress){// compress the dest output stream
                
    stringBuffer.append(TEXT_221);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_222);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_223);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_224);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_225);
    stringBuffer.append(outStream );
    stringBuffer.append(TEXT_226);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_227);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_228);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_92);
    stringBuffer.append(encoding);
    stringBuffer.append(TEXT_229);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_182);
    stringBuffer.append(writerClass);
    stringBuffer.append(TEXT_230);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_19);
    
                }else{
                
    stringBuffer.append(TEXT_231);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_223);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_232);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_233);
    stringBuffer.append(outStream );
    stringBuffer.append(TEXT_92);
    stringBuffer.append(encoding);
    stringBuffer.append(TEXT_229);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_182);
    stringBuffer.append(writerClass);
    stringBuffer.append(TEXT_230);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_19);
    
                }

                if(isIncludeHeader && !hasDynamic){
                    List<IMetadataColumn> columns = metadata.getListColumns();
                    int sizeColumns = columns.size();
                    for (int i = 0; i < sizeColumns; i++) {
                        IMetadataColumn column = columns.get(i);
                        if(sizeColumns > schemaOptNum){
                            if(i%schemaOptNum==0){
                            
    stringBuffer.append(TEXT_234);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_212);
    stringBuffer.append(i/schemaOptNum);
    stringBuffer.append(TEXT_213);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_214);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_19);
    
                            }
                        }else{//BB
                        
    stringBuffer.append(TEXT_235);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_34);
    stringBuffer.append(column.getLabel() );
    stringBuffer.append(TEXT_35);
    
                            if(i != sizeColumns - 1) {
                            
    stringBuffer.append(TEXT_236);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_40);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_19);
    
                            }
                        }//BB
                    }
                    
    stringBuffer.append(TEXT_202);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_217);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_19);
    
                }
            }// ****************************output Stream end*************************************
        }
    }
    
    stringBuffer.append(TEXT_167);
    
// ////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
}else{// the following is the tFileOutputCSV component
// ////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////

    if ((metadatas!=null)&&(metadatas.size()>0)) {
        IMetadataTable metadata = metadatas.get(0);
        if (metadata!=null) {
            List<IMetadataColumn> columns = metadata.getListColumns();
            int sizeColumns = columns.size();
            String delim = ElementParameterParser.getValue(node, "__FIELDSEPARATOR__");
            String rowSeparator = ElementParameterParser.getValue(node, "__CSVROWSEPARATOR__");
            boolean useOSLineSeparator = ("true").equals(ElementParameterParser.getValue(node,"__OS_LINE_SEPARATOR_AS_ROW_SEPARATOR__"));

            String escapeChar1 = ElementParameterParser.getValue(node, "__ESCAPE_CHAR__");

            if(escapeChar1.equals("\"\"\"")){
                escapeChar1 = "\"\\\"\"";
            }

            String textEnclosure1 = ElementParameterParser.getValue(node, "__TEXT_ENCLOSURE__");
            if(textEnclosure1.equals("\"\"\"")){
                textEnclosure1 = "\"\\\"\"";
            }

            String splitEvery = ElementParameterParser.getValue(node, "__SPLIT_EVERY__");

            boolean hasDynamic = metadata.isDynamicSchema();
            if(hasDynamic){
            
    stringBuffer.append(TEXT_143);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_237);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_238);
    
            }else{
            
    stringBuffer.append(TEXT_239);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_240);
    stringBuffer.append(sizeColumns);
    stringBuffer.append(TEXT_241);
    
            }
            
    stringBuffer.append(TEXT_242);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_243);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_244);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_245);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_246);
    stringBuffer.append(delim );
    stringBuffer.append(TEXT_247);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_248);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_249);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_250);
    stringBuffer.append(rowSeparator);
    stringBuffer.append(TEXT_251);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_252);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_253);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_254);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_146);
    
            if(split){
            
    stringBuffer.append(TEXT_147);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_81);
    stringBuffer.append(splitEvery );
    stringBuffer.append(TEXT_100);
    
            }
            
    stringBuffer.append(TEXT_148);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_255);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_256);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_257);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_258);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_259);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_260);
    stringBuffer.append(delim);
    stringBuffer.append(TEXT_261);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_262);
    stringBuffer.append(rowSeparator);
    stringBuffer.append(TEXT_261);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_263);
    stringBuffer.append(escapeChar1 );
    stringBuffer.append(TEXT_92);
    stringBuffer.append(textEnclosure1 );
    stringBuffer.append(TEXT_19);
    
            if(!useStream){
            //**************************** the following is the part of file Path***************************************
                if(("true").equals(ElementParameterParser.getValue(node,"__CREATE__"))){
                
    stringBuffer.append(TEXT_153);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_154);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_155);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_156);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_157);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_158);
    if(isLog4jEnabled){
    stringBuffer.append(TEXT_159);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_264);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_161);
    }
    stringBuffer.append(TEXT_162);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_163);
    if(isLog4jEnabled){
    stringBuffer.append(TEXT_159);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_265);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_165);
    }
    stringBuffer.append(TEXT_166);
    
                }

                if(!split){
                    if(isInRowMode){
                        if(compress && !isAppend){// compress the dest file
                        
    stringBuffer.append(TEXT_266);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_134);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_267);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_170);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_268);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_172);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_269);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_270);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_271);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_272);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_273);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_274);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_275);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_276);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_180);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_277);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_278);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_51);
    stringBuffer.append(encoding);
    stringBuffer.append(TEXT_279);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_280);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_281);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_282);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_283);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_284);
    
                        }else{
                        
    stringBuffer.append(TEXT_285);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_271);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_185);
    if(!isAppend) {
    stringBuffer.append(TEXT_286);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_134);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_287);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_288);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_289);
    }
    stringBuffer.append(TEXT_290);
    stringBuffer.append(fileName );
    stringBuffer.append(TEXT_291);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_292);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_51);
    stringBuffer.append(isAppend);
    stringBuffer.append(TEXT_293);
    stringBuffer.append(encoding);
    stringBuffer.append(TEXT_294);
    stringBuffer.append(fileName );
    stringBuffer.append(TEXT_38);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_295);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_296);
    stringBuffer.append(fileName );
    stringBuffer.append(TEXT_297);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_280);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_281);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_282);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_283);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_284);
    
                        }

                    }else{
                        if(compress && !isAppend){// compress the dest file
                        
    stringBuffer.append(TEXT_266);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_134);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_267);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_170);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_268);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_172);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_269);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_271);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_272);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_273);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_274);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_275);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_276);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_180);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_298);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_299);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_51);
    stringBuffer.append(encoding);
    stringBuffer.append(TEXT_300);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_283);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_284);
    
                        }else{
                        
    stringBuffer.append(TEXT_301);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_185);
    if(!isAppend) {
    stringBuffer.append(TEXT_286);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_134);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_287);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_288);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_289);
    }
    stringBuffer.append(TEXT_302);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_303);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_51);
    stringBuffer.append(isAppend);
    stringBuffer.append(TEXT_293);
    stringBuffer.append(encoding);
    stringBuffer.append(TEXT_300);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_283);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_284);
    
                        }
                    }
                }else{
                    if(isInRowMode){
                    
    stringBuffer.append(TEXT_168);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_195);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_196);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_197);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_304);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_305);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_185);
    if(!isAppend) {
    stringBuffer.append(TEXT_306);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_307);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_189);
    }
    stringBuffer.append(TEXT_190);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_308);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_196);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_197);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_51);
    stringBuffer.append(isAppend);
    stringBuffer.append(TEXT_192);
    stringBuffer.append(encoding);
    stringBuffer.append(TEXT_309);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_310);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_281);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_311);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_283);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_312);
    
                    }else{
                    
    stringBuffer.append(TEXT_168);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_195);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_196);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_197);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_313);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_185);
    if(!isAppend) {
    stringBuffer.append(TEXT_306);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_307);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_189);
    }
    stringBuffer.append(TEXT_314);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_315);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_196);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_197);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_51);
    stringBuffer.append(isAppend);
    stringBuffer.append(TEXT_192);
    stringBuffer.append(encoding);
    stringBuffer.append(TEXT_316);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_283);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_284);
    
                    }
                }

                if(!useOSLineSeparator) {
                
    stringBuffer.append(TEXT_317);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_318);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_319);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_320);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_321);
    
                } else {
                
    stringBuffer.append(TEXT_322);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_323);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_324);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_325);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_320);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_321);
    
                }

                if(isIncludeHeader && !hasDynamic)
                {
                
    
                    if(codeGenArgument.getIsRunInMultiThread()){
                    
    stringBuffer.append(TEXT_204);
    
                    }
                    if (((AbstractNode)node).getParallelIterator() != null) {
                    
    stringBuffer.append(TEXT_326);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_206);
    
                    }
                    if (isParallelize) {
                    
    stringBuffer.append(TEXT_327);
    
                    }
                    if(!split && compress && !isAppend){
                    
    stringBuffer.append(TEXT_328);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_209);
    
                    }else{
                    
    stringBuffer.append(TEXT_306);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_209);
    
                    }
                    
    
                            for(int i = 0 ; i < sizeColumns ; i++){
                                IMetadataColumn column = columns.get(i);
                                if(sizeColumns> schemaOptNum){
                                    if(i%schemaOptNum==0){
                                    
    stringBuffer.append(TEXT_329);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_212);
    stringBuffer.append(i/schemaOptNum);
    stringBuffer.append(TEXT_330);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_19);
    
                                    }
                                }else{//CC
                                
    stringBuffer.append(TEXT_331);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_76);
    stringBuffer.append(i);
    stringBuffer.append(TEXT_78);
    stringBuffer.append(column.getLabel() );
    stringBuffer.append(TEXT_79);
    
                                }//CC
                            }
                            
    stringBuffer.append(TEXT_302);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_332);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_282);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_333);
    if(isInRowMode){
    stringBuffer.append(TEXT_236);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_334);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_335);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_336);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_337);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_338);
    }
    stringBuffer.append(TEXT_220);
    
                    if (isParallelize) {
                    
    stringBuffer.append(TEXT_220);
    
                    }
                    if (((AbstractNode)node).getParallelIterator() != null) {
                    
    stringBuffer.append(TEXT_220);
    
                    }
                    if(codeGenArgument.getIsRunInMultiThread()){
                    
    stringBuffer.append(TEXT_220);
    
                    }
                    
    
                }
            }else{
            //***********************the following is the part of output Stream**************************************
                if(isInRowMode){
                    if(compress){// compress the dest output stream
                    
    stringBuffer.append(TEXT_339);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_340);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_341);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_305);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_342);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_343);
    stringBuffer.append(outStream );
    stringBuffer.append(TEXT_344);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_345);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_228);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_51);
    stringBuffer.append(encoding);
    stringBuffer.append(TEXT_346);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_347);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_348);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_310);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_281);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_311);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_283);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_284);
    
                    }else{
                    
    stringBuffer.append(TEXT_349);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_341);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_305);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_350);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_233);
    stringBuffer.append(outStream );
    stringBuffer.append(TEXT_51);
    stringBuffer.append(encoding);
    stringBuffer.append(TEXT_346);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_347);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_348);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_310);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_281);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_311);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_283);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_284);
    
                    }

                }else{
                    if(compress){// compress the dest output stream
                    
    stringBuffer.append(TEXT_339);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_340);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_351);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_305);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_342);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_343);
    stringBuffer.append(outStream );
    stringBuffer.append(TEXT_344);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_345);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_228);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_51);
    stringBuffer.append(encoding);
    stringBuffer.append(TEXT_352);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_353);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_311);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_354);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_311);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_283);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_284);
    
                    }else{
                    
    stringBuffer.append(TEXT_349);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_351);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_305);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_350);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_233);
    stringBuffer.append(outStream );
    stringBuffer.append(TEXT_51);
    stringBuffer.append(encoding);
    stringBuffer.append(TEXT_352);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_353);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_311);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_354);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_311);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_283);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_284);
    
                    }
                }

                if(!useOSLineSeparator) {
                
    stringBuffer.append(TEXT_317);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_318);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_319);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_320);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_321);
    
                } else {
                
    stringBuffer.append(TEXT_322);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_323);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_324);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_325);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_320);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_321);
    
                }

                if(isIncludeHeader && !hasDynamic)
                {
                    for(int i = 0; i < sizeColumns; i++)
                    {
                        IMetadataColumn column = columns.get(i);
                        if(sizeColumns> schemaOptNum){
                            if(i%schemaOptNum==0){
                            
    stringBuffer.append(TEXT_234);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_212);
    stringBuffer.append(i/schemaOptNum);
    stringBuffer.append(TEXT_330);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_19);
    
                            }
                        }else{//DD
                        
    stringBuffer.append(TEXT_355);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_76);
    stringBuffer.append(i);
    stringBuffer.append(TEXT_78);
    stringBuffer.append(column.getLabel() );
    stringBuffer.append(TEXT_79);
    
                        }//DD
                    }
                    
    stringBuffer.append(TEXT_356);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_332);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_19);
    if(isInRowMode){
    stringBuffer.append(TEXT_190);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_334);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_357);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_337);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_338);
    }
                }
            }//*****************************csv mode under output stream end********************************************************

            if(!(isIncludeHeader && hasDynamic)){//when there is dynamic schema, it won't be enclosed with "\""
            
    stringBuffer.append(TEXT_358);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_359);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_360);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_361);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_362);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_363);
    
            }
        }
    }
    
    stringBuffer.append(TEXT_364);
    
// ////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
}

    stringBuffer.append(TEXT_167);
    
if(("false").equals(ElementParameterParser.getValue(node,"__CSV_OPTION__"))) {
    if(!useStream){
    
    stringBuffer.append(TEXT_365);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_366);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_19);
    
    }else{
    
    stringBuffer.append(TEXT_365);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_366);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_367);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_368);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_19);
    
    }
}else{//the following is the tFileOutputCSV component

    stringBuffer.append(TEXT_369);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_370);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_19);
    
    if(!useStream){
        if(isInRowMode){
        
    stringBuffer.append(TEXT_371);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_366);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_19);
    
        }
    }else{
        if(isInRowMode){
        
    stringBuffer.append(TEXT_371);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_366);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_372);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_373);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_19);
    
        }else{
        
    stringBuffer.append(TEXT_374);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_375);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_372);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_373);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_19);
    
        }
    }
}

    stringBuffer.append(TEXT_376);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_377);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_19);
    if(!useStream && ("true").equals(ElementParameterParser.getValue(node, "__DELETE_EMPTYFILE__"))){
    stringBuffer.append(TEXT_378);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_379);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_19);
    if(compress && !isAppend && !split){
    stringBuffer.append(TEXT_380);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_381);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_19);
    }else{
    stringBuffer.append(TEXT_382);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_383);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_19);
    }
    }
    stringBuffer.append(TEXT_167);
    return stringBuffer.toString();
  }
}
