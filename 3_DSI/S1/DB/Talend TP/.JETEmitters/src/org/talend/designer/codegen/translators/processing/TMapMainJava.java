package org.talend.designer.codegen.translators.processing;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;
import java.util.HashMap;
import java.util.Map;
import org.talend.designer.codegen.config.CodeGeneratorArgument;
import org.talend.commons.utils.generation.CodeGenerationUtils;
import org.talend.designer.mapper.MapperComponent;
import org.talend.designer.mapper.external.data.ExternalMapperData;
import org.talend.designer.mapper.external.data.ExternalMapperTable;
import org.talend.designer.mapper.external.data.ExternalMapperTableEntry;
import org.talend.designer.mapper.language.ILanguage;
import org.talend.designer.mapper.language.generation.JavaGenerationManager;
import org.talend.designer.mapper.language.generation.HashedMetadataTable;
import org.talend.designer.mapper.language.LanguageProvider;
import org.talend.designer.mapper.model.tableentry.TableEntryLocation;
import org.talend.designer.mapper.utils.DataMapExpressionParser;
import org.talend.core.model.process.IConnection;
import org.talend.core.model.process.EConnectionType;
import org.talend.core.model.metadata.IMetadataTable;
import org.talend.core.model.metadata.IMetadataColumn;
import org.talend.core.model.metadata.types.JavaTypesManager;
import org.talend.core.model.metadata.types.JavaType;
import org.talend.core.model.process.BlockCode;
import org.talend.core.model.process.INode;
import org.talend.core.model.process.ElementParameterParser;
import org.talend.core.GlobalServiceRegister;
import org.talend.core.model.metadata.IAutoConvertTypesService;
import org.talend.core.model.metadata.types.AutoConversionType;

public class TMapMainJava {


  protected static String nl;
  public static synchronized TMapMainJava create(String lineSeparator)
  {
    nl = lineSeparator;
    TMapMainJava result = new TMapMainJava();
    nl = null;
    return result;
  }

  public final String NL = nl == null ? (System.getProperties().getProperty("line.separator")) : nl;
  protected final String TEXT_1 = "";
  protected final String TEXT_2 = NL + "\t\t\t";
  protected final String TEXT_3 = NL;
  protected final String TEXT_4 = NL + "\t\t" + NL + "\t\t" + NL + "\t\tboolean hasCasePrimitiveKeyWithNull_";
  protected final String TEXT_5 = " = false;" + NL + "\t\t";
  protected final String TEXT_6 = NL + "\t\t              " + NL + "\t\t\t\t   \t  \t\t  \tif(" + NL + " \t\t\t\t  \t\t  \t\t\t";
  protected final String TEXT_7 = NL + " \t\t\t\t  \t\t  \t\t\t(" + NL + " \t\t\t\t  \t\t  \t\t\t";
  protected final String TEXT_8 = NL + " \t\t\t\t  \t\t  \t\t\t";
  protected final String TEXT_9 = NL + " \t\t\t\t  \t\t  \t\t\t)" + NL + "  \t\t\t\t  \t\t  \t\t\t";
  protected final String TEXT_10 = NL + "\t  \t  \t\t  \t\t\t\t) { // G_TM_M_281" + NL + "" + NL + "\t\t\t\t\t\t\t";
  protected final String TEXT_11 = NL + "\t\t\t\t\thasCasePrimitiveKeyWithNull_";
  protected final String TEXT_12 = " = false;" + NL + "\t\t\t\t\t";
  protected final String TEXT_13 = NL + "\t \t           \t\t\t\t\t\t";
  protected final String TEXT_14 = NL + "    \t    \t    \t\t\t\t";
  protected final String TEXT_15 = NL + "                        \t\t    \t";
  protected final String TEXT_16 = " exprKey_";
  protected final String TEXT_17 = "__";
  protected final String TEXT_18 = " = ";
  protected final String TEXT_19 = "; " + NL + "                        \t\t    \tObject exprKeyValue_";
  protected final String TEXT_20 = ";" + NL + "                        \t\t    \tif(exprKeyValue_";
  protected final String TEXT_21 = " == null) {" + NL + "                        \t\t    \t\thasCasePrimitiveKeyWithNull_";
  protected final String TEXT_22 = " = true;" + NL + "                        \t\t    \t} else {" + NL + "\t\t\t\t\t\t\t            \texprKey_";
  protected final String TEXT_23 = " =  (";
  protected final String TEXT_24 = ")(";
  protected final String TEXT_25 = ") exprKeyValue_";
  protected final String TEXT_26 = ";" + NL + "                       \t\t    \t\t}" + NL + "                       \t\t    \t\t";
  protected final String TEXT_27 = NL + "\t\t\t\t\t\t            \t";
  protected final String TEXT_28 = ";" + NL + "            \t\t\t\t\t\t\t";
  protected final String TEXT_29 = NL + "\t                \t\t\t\t\t";
  protected final String TEXT_30 = NL + "            \t\t\t    \t\t";
  protected final String TEXT_31 = NL + NL + "                    SortableRow_";
  protected final String TEXT_32 = "_";
  protected final String TEXT_33 = " sortableRow_";
  protected final String TEXT_34 = " = fsi_";
  protected final String TEXT_35 = ".getNextFreeRow();" + NL + "" + NL + "                    sortableRow_";
  protected final String TEXT_36 = ".fillFrom(";
  protected final String TEXT_37 = ", exprKey_";
  protected final String TEXT_38 = ");" + NL + "" + NL + "                    fsi_";
  protected final String TEXT_39 = ".put(sortableRow_";
  protected final String TEXT_40 = ");" + NL + "" + NL + "\t\t\t\t";
  protected final String TEXT_41 = NL + "\t" + NL + "\t      fsi_";
  protected final String TEXT_42 = ".endPut();" + NL + "\t      " + NL + "\t\t";
  protected final String TEXT_43 = NL + "\t\t\tif(";
  protected final String TEXT_44 = " == null) {" + NL + "\t\t\t\t";
  protected final String TEXT_45 = " = new ";
  protected final String TEXT_46 = "Struct();" + NL + "\t\t\t}" + NL + "    \t    ";
  protected final String TEXT_47 = NL;
  protected final String TEXT_48 = NL + "        // ###############################" + NL + "        // # Input tables (lookups)";
  protected final String TEXT_49 = NL + "\t\t  boolean ";
  protected final String TEXT_50 = " = false;" + NL + "\t\t  boolean ";
  protected final String TEXT_51 = " = false;" + NL + "            \t\t\t\t    \t\t\t\t\t\t\t\t  " + NL + "\t\t";
  protected final String TEXT_52 = NL + "\t\t              " + NL + "\t\t\t   \t  \t\t  if(" + NL + " \t\t\t\t  \t\t  \t\t\t";
  protected final String TEXT_53 = NL + "\t  \t  \t\t  \t\t\t\t) { // G_TM_M_280" + NL + "" + NL + "\t\t\t\t\t\t\t // CALL close main tMap filter for table '";
  protected final String TEXT_54 = "'" + NL + "\t\t\t\t\t\t\t";
  protected final String TEXT_55 = NL + NL + "\t\t\t\t///////////////////////////////////////////////" + NL + "\t\t\t\t// Starting Lookup Table \"";
  protected final String TEXT_56 = "\" " + NL + "\t\t\t\t///////////////////////////////////////////////" + NL + "" + NL + "" + NL + "\t\t\t\t" + NL + "\t\t\t\t";
  protected final String TEXT_57 = "\t\t\t\t" + NL + "\t\t\t\tSortableRow_";
  protected final String TEXT_58 = " rsc_";
  protected final String TEXT_59 = ";" + NL + "\t\t\t" + NL + "\t\t\t\t";
  protected final String TEXT_60 = NL + "\t\t\t\t\ttHash_Lookup_";
  protected final String TEXT_61 = ".initGet();" + NL + "\t\t\t\t";
  protected final String TEXT_62 = NL + "\t\t\t\t" + NL + "" + NL + "\t\t\t\tfsi_";
  protected final String TEXT_63 = ".initGet();" + NL + "" + NL + "\t\t\t\t";
  protected final String TEXT_64 = NL + NL + "\t       \t\t\t//";
  protected final String TEXT_65 = "Struct();" + NL + "" + NL + "\t       \t\t\t ";
  protected final String TEXT_66 = "Struct ";
  protected final String TEXT_67 = "Struct();" + NL + "\t       \t\t\t" + NL + "\t\t\t\t\t";
  protected final String TEXT_68 = NL + NL + "\t\t\t\t//TEST firstLookupIsPersistentSorted=";
  protected final String TEXT_69 = " isFirstPersistentSortedTable=";
  protected final String TEXT_70 = NL + NL + "\t\t\t\t";
  protected final String TEXT_71 = " = false;" + NL + "\t\t\t" + NL + "\t           \twhile (fsi_";
  protected final String TEXT_72 = ".hasNext()) { // G_TM_M_250 loop \"";
  protected final String TEXT_73 = "\"" + NL + "\t\t\t\t" + NL + "" + NL + "\t\t\t\t\t\t\t\t";
  protected final String TEXT_74 = NL + "\t\t\t\t\t\t\t\t\t // CALL close loop of lookup '";
  protected final String TEXT_75 = "'" + NL + "\t\t\t\t\t\t\t\t\t";
  protected final String TEXT_76 = NL + NL + "\t\t\t\t\t" + NL + "\t\t\t\t" + NL + "\t\t\t\t" + NL + "\t\t\t\t\trsc_";
  protected final String TEXT_77 = " = (SortableRow_";
  protected final String TEXT_78 = ") fsi_";
  protected final String TEXT_79 = ".next();" + NL + "               \t\trsc_";
  protected final String TEXT_80 = ".copyDataTo(";
  protected final String TEXT_81 = " ";
  protected final String TEXT_82 = ");" + NL + "               \t\t" + NL + "               \t\t";
  protected final String TEXT_83 = " = rsc_";
  protected final String TEXT_84 = ".is__rejectedInnerJoin;" + NL + "               \t\t" + NL + "\t\t\t";
  protected final String TEXT_85 = NL + "\t\t\t\t";
  protected final String TEXT_86 = " = false;" + NL + "\t\t\t";
  protected final String TEXT_87 = NL + "                            " + NL + " \t\t\t\t\t    boolean forceLoop";
  protected final String TEXT_88 = " = false;" + NL + "       \t\t  \t    \t" + NL + "       \t\t  \t    \t";
  protected final String TEXT_89 = NL + " \t\t\t\t\t\t\t";
  protected final String TEXT_90 = "ObjectFromLookup = null;" + NL + "                          " + NL + "\t\t           \t\t  \tif(!";
  protected final String TEXT_91 = " && ";
  protected final String TEXT_92 = ") { // G_TM_M_020" + NL + "" + NL + "\t\t\t\t\t\t\t\t";
  protected final String TEXT_93 = NL + "\t\t\t\t\t\t\t\thasCasePrimitiveKeyWithNull_";
  protected final String TEXT_94 = " = false;" + NL + "\t\t\t\t\t\t\t\t";
  protected final String TEXT_95 = NL + " \t                        \t\t   ";
  protected final String TEXT_96 = NL + "                        \t\t\t    ";
  protected final String TEXT_97 = NL + "\t                        \t\t    \tObject exprKeyValue_";
  protected final String TEXT_98 = ";" + NL + "\t                        \t\t    \tif(exprKeyValue_";
  protected final String TEXT_99 = " == null) {" + NL + "\t                        \t\t    \t\thasCasePrimitiveKeyWithNull_";
  protected final String TEXT_100 = " = true;" + NL + "\t                        \t\t    \t} else {" + NL + "\t                        \t\t    \t\t";
  protected final String TEXT_101 = "HashKey.";
  protected final String TEXT_102 = " = (";
  protected final String TEXT_103 = ") rsc_";
  protected final String TEXT_104 = ".exprKey_";
  protected final String TEXT_105 = ";" + NL + "                        \t\t    \t\t}" + NL + "                        \t\t    \t\t";
  protected final String TEXT_106 = NL + "                    \t\t    \t\t        ";
  protected final String TEXT_107 = " == null ? null : new java.util.Date(rsc_";
  protected final String TEXT_108 = ".getTime());" + NL + "                    \t\t    \t\t    ";
  protected final String TEXT_109 = NL + "                        \t\t    \t\t    ";
  protected final String TEXT_110 = ";" + NL + "                        \t\t    \t\t";
  protected final String TEXT_111 = " = true;" + NL + "\t                        \t\t    \t} else {" + NL + "                        \t\t    \t\t\t";
  protected final String TEXT_112 = " == null ? null : new java.util.Date(";
  protected final String TEXT_113 = ".getTime());" + NL + "                        \t\t    \t\t";
  protected final String TEXT_114 = NL + "                        \t\t        ";
  protected final String TEXT_115 = NL + NL + "\t\t\t\t\t\t\t\t";
  protected final String TEXT_116 = NL + "\t\t                        \t";
  protected final String TEXT_117 = "HashKey.hashCodeDirty = true;" + NL + "                        \t\t";
  protected final String TEXT_118 = NL + "\t  \t\t\t\t\t" + NL + "\t  \t\t\t\t\t\t\t";
  protected final String TEXT_119 = NL + "\t" + NL + "\t\t  \t\t\t\t\t\t\tif(!hasCasePrimitiveKeyWithNull_";
  protected final String TEXT_120 = ") { // G_TM_M_091" + NL + "\t\t  \t\t\t\t\t\t\t" + NL + "\t\t\t  \t\t\t\t\t";
  protected final String TEXT_121 = NL + "\t\t\t  \t\t\t\t\t" + NL + "\t\t\t  \t\t\t\t\t";
  protected final String TEXT_122 = NL + NL + "\t\t\t  \t\t\t\t\t\t\ttHash_Lookup_Cache_";
  protected final String TEXT_123 = ".lookup( ";
  protected final String TEXT_124 = "HashKey );" + NL + "\t\t\t  \t\t\t\t\t\t\tif(tHash_Lookup_Cache_";
  protected final String TEXT_125 = ".hasNext()) { // G_TM_M_835" + NL + "\t\t\t  \t\t\t\t\t\t\t" + NL + "\t\t  \t\t\t\t\t\t\t\t\ttHash_Lookup_";
  protected final String TEXT_126 = " = tHash_Lookup_Cache_";
  protected final String TEXT_127 = ";" + NL + "\t\t\t  \t\t\t\t\t\t\t\t" + NL + "\t\t\t  \t\t\t\t\t\t\t} // G_TM_M_834" + NL + "\t\t\t\t\t\t\t\t\t\telse { // G_TM_M_835" + NL + "" + NL + "\t\t\t\t\t\t\t\t\t";
  protected final String TEXT_128 = NL + "\t\t\t\t\t\t\t\t\t\t\tglobalMap.put(";
  protected final String TEXT_129 = ", ";
  protected final String TEXT_130 = ");" + NL + "\t\t\t\t\t\t\t\t\t\t";
  protected final String TEXT_131 = NL + "\t\t\t\t\t\t\t\t" + NL + "\t\t\t\t\t\t\t\t\t";
  protected final String TEXT_132 = "Process(globalMap);" + NL + "\t\t\t\t\t\t\t\t\t" + NL + "\t\t\t\t\t\t\t\t\t";
  protected final String TEXT_133 = NL + "\t\t\t\t\t\t\t\t\t\ttHash_Lookup_";
  protected final String TEXT_134 = " = " + NL + "\t\t\t\t\t\t\t\t\t\t\t(org.talend.designer.components.lookup.persistent.Persistent";
  protected final String TEXT_135 = "LookupManager<";
  protected final String TEXT_136 = "Struct>) " + NL + "\t\t\t\t\t\t\t\t\t\t\t\t((org.talend.designer.components.lookup.persistent.Persistent";
  protected final String TEXT_137 = "Struct>) " + NL + "\t\t\t\t\t\t\t\t\t\t\t\t\t globalMap.get( \"tHash_Lookup_";
  protected final String TEXT_138 = "\" ));" + NL + "\t\t\t\t\t\t\t\t\t";
  protected final String TEXT_139 = " = " + NL + "\t\t\t\t\t\t\t\t\t\t(org.talend.designer.components.lookup.memory.AdvancedMemoryLookup<";
  protected final String TEXT_140 = "Struct>) " + NL + "\t\t\t\t\t\t\t\t\t\t((org.talend.designer.components.lookup.memory.AdvancedMemoryLookup<";
  protected final String TEXT_141 = "Struct>) " + NL + "\t\t\t\t\t\t\t\t\t\t\tglobalMap.get( \"tHash_Lookup_";
  protected final String TEXT_142 = NL + "\t\t\t\t\t\t\t\t" + NL + "\t\t\t\t\t\t\t\t\ttHash_Lookup_";
  protected final String TEXT_143 = ".initGet();" + NL + "\t\t\t\t\t\t\t\t" + NL + "\t\t\t\t\t\t\t\t\ttHash_Lookup_";
  protected final String TEXT_144 = "HashKey );" + NL + "\t\t\t\t\t\t\t\t\t\t" + NL + "\t\t\t\t\t\t\t\t\t";
  protected final String TEXT_145 = NL + NL + "\t\t\t\t\t\t\t\t\t\t} // G_TM_M_835" + NL + "\t\t\t\t\t\t\t\t\t\t" + NL + "\t\t\t\t\t\t\t\t\t";
  protected final String TEXT_146 = NL + "\t\t\t\t\t\t\t\t\t" + NL + "\t\t\t\t\t\t\t\t\t\t" + NL + "\t\t\t\t\t\t\t\t";
  protected final String TEXT_147 = NL + "\t  \t\t\t\t\t" + NL + "\t\t  \t\t\t\t\t\t\ttHash_Lookup_";
  protected final String TEXT_148 = "HashKey );" + NL + "" + NL + "\t  \t\t\t\t\t\t\t";
  protected final String TEXT_149 = NL + NL + "\t  \t\t\t\t\t\t\t";
  protected final String TEXT_150 = NL + NL + "\t\t\t  \t\t\t\t\t\t} // G_TM_M_091" + NL + "\t\t\t  \t\t\t\t\t\t" + NL + "\t\t\t  \t\t\t\t\t";
  protected final String TEXT_151 = NL + NL + " \t\t\t\t\t\t\t\t";
  protected final String TEXT_152 = NL + "\t\t\t\t\t\t\t\t  " + NL + "\t\t\t\t\t\t\t\t  if(";
  protected final String TEXT_153 = "!tHash_Lookup_";
  protected final String TEXT_154 = ".hasNext()) { // G_TM_M_090" + NL + "" + NL + "  \t\t\t\t\t\t\t\t";
  protected final String TEXT_155 = NL + "\t\t  \t\t\t\t" + NL + "\t  \t\t\t\t\t\t\t\t";
  protected final String TEXT_156 = NL + "\t\t\t  \t\t\t\t\t\t\t";
  protected final String TEXT_157 = " = true;" + NL + "\t  \t\t\t\t\t\t\t\t";
  protected final String TEXT_158 = NL + "\t\t\t\t\t\t" + NL + "\t\t\t\t\t\t\t\t\t";
  protected final String TEXT_159 = NL + "\t" + NL + "\t\t  \t\t\t\t\t\t\t\tforceLoop";
  protected final String TEXT_160 = " = true;" + NL + "\t  \t\t\t\t\t" + NL + "  \t\t\t\t\t\t\t\t\t";
  protected final String TEXT_161 = NL + "  \t\t\t\t\t\t\t\t\t  \t\t" + NL + " \t\t\t\t\t\t\t\t";
  protected final String TEXT_162 = NL + "\t\t\t\t\t\t\t\t  " + NL + "\t\t\t\t\t\t\t\t  } // G_TM_M_090" + NL + "" + NL + "  \t\t\t\t\t\t\t\t";
  protected final String TEXT_163 = NL + NL + NL + NL + "\t\t\t\t\t\t\t} // G_TM_M_020" + NL + "\t\t\t           \t\t  \t  " + NL + "\t\t\t\t\t\t\t";
  protected final String TEXT_164 = NL + "\t\t\t\t\t\t\t\t" + NL + "\t\t\t\t\t\t\t\telse { // G 20 - G 21" + NL + "   \t\t\t\t\t\t\t\t\tforceLoop";
  protected final String TEXT_165 = " = true;" + NL + "\t\t\t           \t\t  \t} // G 21" + NL + "                    \t\t  \t" + NL + "                    \t\t";
  protected final String TEXT_166 = NL + "\t\t\t\t           \t\tif(tHash_Lookup_";
  protected final String TEXT_167 = " != null && tHash_Lookup_";
  protected final String TEXT_168 = ".getCount(";
  protected final String TEXT_169 = "HashKey) > 1) { // G 071" + NL + "\t\t\t  \t\t\t\t\t\t\t" + NL + "\t\t\t  \t\t\t\t\t\t";
  protected final String TEXT_170 = NL + "\t\t\t\t\t\t\t\t\t \t\t" + NL + "\t\t\t\t\t\t\t\t\t//System.out.println(";
  protected final String TEXT_171 = ");" + NL + "\t\t\t\t\t\t\t\t} // G 071" + NL + "\t\t\t\t\t\t\t";
  protected final String TEXT_172 = NL + NL + "\t\t\t\t\t\t\t";
  protected final String TEXT_173 = " = null;" + NL + "                    \t\t  \t " + NL + "\t\t\t\t\t\t\t";
  protected final String TEXT_174 = NL + NL + "\t\t\t\t\t\t\t\twhile ((tHash_Lookup_";
  protected final String TEXT_175 = ".hasNext()) || forceLoop";
  protected final String TEXT_176 = ") { // G_TM_M_043" + NL + "" + NL + "\t\t\t\t\t\t\t\t";
  protected final String TEXT_177 = NL + "                    \t\t  \t " + NL + "\t\t\t\t\t\t\t";
  protected final String TEXT_178 = "   " + NL + "                    \t\t  \t " + NL + "\t       \t\t  \t    \t";
  protected final String TEXT_179 = "Struct fromLookup_";
  protected final String TEXT_180 = " = null;" + NL + "\t\t\t\t\t\t\t";
  protected final String TEXT_181 = "Default;" + NL + "\t\t\t\t\t\t\t\t\t\t " + NL + "\t\t\t\t\t\t\t";
  protected final String TEXT_182 = NL + "\t\t\t\t\t\t\t\t" + NL + "\t\t\t\t\t\t\t\tif(!forceLoop";
  protected final String TEXT_183 = ") { // G 46" + NL + "\t\t\t\t\t\t\t\t" + NL + "\t\t\t\t\t\t\t";
  protected final String TEXT_184 = NL + "\t\t\t\t\t\t\t\t " + NL + "\t\t\t\t\t\t\t";
  protected final String TEXT_185 = NL + "\t\t\t\t\t\t\t" + NL + "\t\t\t\t\t\t\t\tif (tHash_Lookup_";
  protected final String TEXT_186 = " !=null && tHash_Lookup_";
  protected final String TEXT_187 = ".hasNext()) { // G 099" + NL + "\t\t\t\t\t\t\t\t" + NL + "\t\t\t\t\t\t\t";
  protected final String TEXT_188 = NL + "\t\t\t\t\t\t\t\t" + NL + "\t\t\t\t\t\t\t\tfromLookup_";
  protected final String TEXT_189 = " = tHash_Lookup_";
  protected final String TEXT_190 = ".next();" + NL + "" + NL + "\t\t\t\t\t\t\t";
  protected final String TEXT_191 = NL + "\t\t\t\t\t\t\t" + NL + "\t\t\t\t\t\t\t\t} // G 099" + NL + "\t\t\t\t\t\t\t" + NL + "\t\t\t\t\t\t\t";
  protected final String TEXT_192 = NL + NL + "\t\t\t\t\t\t\tif(fromLookup_";
  protected final String TEXT_193 = " != null) {" + NL + "\t\t\t\t\t\t\t\t";
  protected final String TEXT_194 = " = fromLookup_";
  protected final String TEXT_195 = ";" + NL + "\t\t\t\t\t\t\t}" + NL + "\t\t\t\t\t\t\t" + NL + "\t\t\t\t\t\t\t";
  protected final String TEXT_196 = NL + NL + "\t\t\t\t\t\t\t\tif(tHash_Lookup_Cache_";
  protected final String TEXT_197 = " != tHash_Lookup_";
  protected final String TEXT_198 = ") {" + NL + "\t\t\t\t\t\t\t\t\ttHash_Lookup_Cache_";
  protected final String TEXT_199 = ".put(";
  protected final String TEXT_200 = ");" + NL + "\t\t\t\t\t\t\t\t}" + NL + "\t\t\t\t\t\t\t\t" + NL + "\t\t\t\t\t\t\t";
  protected final String TEXT_201 = NL + "\t\t\t\t\t\t\t" + NL + "\t\t\t  \t\t\t\t\t\t\t" + NL + "\t\t\t\t\t\t\t";
  protected final String TEXT_202 = NL + "                    \t\t  \t  \t\t" + NL + "\t\t\t\t\t\t\t\tif( !";
  protected final String TEXT_203 = " && " + NL + "\t\t\t\t\t\t\t\t\t";
  protected final String TEXT_204 = NL + "\t\t\t\t\t\t\t\t\t!(" + NL + "\t\t\t\t\t\t\t\t\t\t";
  protected final String TEXT_205 = NL + "\t\t\t\t\t\t\t\t\t\t";
  protected final String TEXT_206 = NL + "\t\t\t\t\t\t\t\t\t)" + NL + "\t\t\t\t\t\t\t\t\t";
  protected final String TEXT_207 = NL + "\t\t\t\t\t\t\t\t) { // G 016" + NL + "                    \t\t  \t  \t\t  " + NL + "\t\t\t\t\t\t\t\t\tfromLookup_";
  protected final String TEXT_208 = " = null;" + NL + "\t\t\t\t\t\t\t\t\t";
  protected final String TEXT_209 = "Default;" + NL + "                    \t\t  \t  \t\t  \t\t" + NL + "\t\t\t\t\t\t\t\t\t";
  protected final String TEXT_210 = NL + "\t\t\t\t\t\t\t\t\t" + NL + "\t\t\t\t\t\t\t\t\t\t";
  protected final String TEXT_211 = " = true;" + NL + "\t\t\t\t\t\t\t\t\t\t\t\t\t" + NL + "\t\t\t\t\t\t\t\t\t";
  protected final String TEXT_212 = NL + "\t\t\t\t\t\t\t\t} // G 016" + NL + "     \t               \t\t  \t" + NL + "\t\t\t\t\t\t\t\t";
  protected final String TEXT_213 = NL + "\t\t\t\t\t\t\t\t" + NL + "\t\t\t\t\t\t\t\t\tif(fromLookup_";
  protected final String TEXT_214 = " == null && !";
  protected final String TEXT_215 = ") { // G 017" + NL + "\t\t\t\t\t\t\t\t" + NL + "\t\t\t\t\t\t\t\t\t\tcontinue;" + NL + "\t\t\t\t\t\t\t\t\t" + NL + "\t\t\t\t\t\t\t\t\t} // G 017" + NL + "\t\t\t\t\t\t\t\t" + NL + "\t\t\t\t\t\t\t\t";
  protected final String TEXT_216 = NL + "     \t               \t\t  \t  \t  " + NL + "\t\t\t\t\t\t\t";
  protected final String TEXT_217 = "\t" + NL + "\t                    \t\t  \t" + NL + "\t\t                    ";
  protected final String TEXT_218 = NL + "\t                    \t" + NL + "\t                    \t\t} // G 46" + NL + "\t                    \t\t  \t" + NL + "\t\t\t\t\t\t\t\tforceLoop";
  protected final String TEXT_219 = " = false;" + NL + "\t\t\t\t\t\t\t\t\t \t" + NL + "\t\t\t\t\t\t\t";
  protected final String TEXT_220 = NL + "\t\t\t\t\t\t\t\t" + NL + "\t\t\t\t\t\t\t\t\t\t\t\t";
  protected final String TEXT_221 = ";" + NL + "\t\t\t\t\t\t\t\t" + NL + "\t\t\t\t\t\t\t\t\t\t\t";
  protected final String TEXT_222 = NL + "\t\t            \t\t\t\t\tif(!";
  protected final String TEXT_223 = ") { // G_TM_M_255" + NL + "\t\t            \t\t\t\t";
  protected final String TEXT_224 = NL + " \t           \t\t\t\t\t\t\t\t\t\t";
  protected final String TEXT_225 = NL + "        \t    \t\t\t\t\t\t\t\t";
  protected final String TEXT_226 = NL + "                        \t\t    \t\t\t\tObject exprKeyValue_";
  protected final String TEXT_227 = ";" + NL + "                        \t\t    \t\t\t\tif(exprKeyValue_";
  protected final String TEXT_228 = " == null) {" + NL + "            \t            \t\t    \t\t\t\thasCasePrimitiveKeyWithNull_";
  protected final String TEXT_229 = " = true;" + NL + "\t\t\t                        \t\t    \t} else {" + NL + "\t\t\t\t\t\t\t            \t\t\t\texprKey_";
  protected final String TEXT_230 = ";" + NL + "                       \t\t    \t\t\t\t\t}" + NL + "                       \t\t    \t\t\t\t\t";
  protected final String TEXT_231 = NL + "\t\t\t\t\t            \t\t\t\t\texprKey_";
  protected final String TEXT_232 = ";" + NL + "            \t\t\t\t\t\t\t\t\t\t";
  protected final String TEXT_233 = NL + "                \t\t\t\t\t\t\t\t\t";
  protected final String TEXT_234 = NL + "            \t\t\t\t    \t\t\t\t";
  protected final String TEXT_235 = NL + "                    \t\t\t\t\t} // G_TM_M_255" + NL + "                    \t\t\t\t";
  protected final String TEXT_236 = NL + NL + "\t\t\t\t\t\t\t\tSortableRow_";
  protected final String TEXT_237 = " = new SortableRow_";
  protected final String TEXT_238 = "();" + NL + "" + NL + "\t\t\t\t\t\t\t\trsc_";
  protected final String TEXT_239 = ");" + NL + "" + NL + "\t\t\t\t\t\t\t\trsc_";
  protected final String TEXT_240 = ".is__rejectedInnerJoin = ";
  protected final String TEXT_241 = ";" + NL + "\t\t\t\t\t\t" + NL + "\t\t\t\t\t\t\t\t";
  protected final String TEXT_242 = " = false;" + NL + "" + NL + "\t\t\t\t\t\t\t\t// Sort and store in KeyFile(s) and DataFile(s)" + NL + "\t\t\t\t\t\t\t\tfsi_";
  protected final String TEXT_243 = ".put(rsc_";
  protected final String TEXT_244 = ");" + NL + "\t\t\t\t\t" + NL + "\t\t\t\t\t\t\t\t";
  protected final String TEXT_245 = NL + "\t\t\t\t\t\t\t\tif(forceLoop";
  protected final String TEXT_246 = ") {" + NL + "\t\t\t\t\t\t\t\t\tbreak;" + NL + "\t\t\t\t\t\t\t\t}" + NL + "\t\t\t\t\t\t\t" + NL + "\t            \t\t\t}  // G_TM_M_043 loop (MultipleResult) ";
  protected final String TEXT_247 = NL + "\t\t\t\t\t";
  protected final String TEXT_248 = NL + "\t        \t    \t\t\t}  // G_TM_M_043 loop (closeAllRowsBlock) ";
  protected final String TEXT_249 = NL + "\t\t\t\t\t\t\t";
  protected final String TEXT_250 = NL + "\t    \t        \t} // G_TM_M_250 loop \"";
  protected final String TEXT_251 = "\"" + NL + "" + NL + "\t            \t\t";
  protected final String TEXT_252 = NL + "\t            \t" + NL + "\t           \t";
  protected final String TEXT_253 = NL + "\t            \t" + NL + "\t            \t" + NL + "\t            ";
  protected final String TEXT_254 = "\t\t\t\t" + NL + "\t\t\t\t\tfsi_";
  protected final String TEXT_255 = ".endGet();" + NL + "\t\t\t\t";
  protected final String TEXT_256 = " " + NL + "\t            \t" + NL + "\t            \tfsi_";
  protected final String TEXT_257 = ".endPut();" + NL + "\t            \t" + NL + "\t\t\t\t";
  protected final String TEXT_258 = NL + "                try {";
  protected final String TEXT_259 = "// ###############################";
  protected final String TEXT_260 = NL + "        { // start of Var scope" + NL + "        " + NL + "\t        // ###############################" + NL + "        \t// # Vars tables" + NL + "        ";
  protected final String TEXT_261 = NL + "        // ###############################" + NL + "        // # Output tables";
  protected final String TEXT_262 = NL + "\t\t} catch (java.lang.Exception e) {" + NL + "\t\t\t//if anohter java.lang.Exception when processing an java.lang.Exception" + NL + "    \t\t";
  protected final String TEXT_263 = NL + "    \t\t\tlog.error(\"";
  protected final String TEXT_264 = " - \" + e.getMessage());" + NL + "    \t\t";
  protected final String TEXT_265 = NL + "\t\t\ttry{//EE";
  protected final String TEXT_266 = "                " + NL + "                ";
  protected final String TEXT_267 = "            " + NL + "               ";
  protected final String TEXT_268 = NL + "                ";
  protected final String TEXT_269 = "_tmp;";
  protected final String TEXT_270 = ".errorMessage = e.getMessage();";
  protected final String TEXT_271 = ".errorStackTrace = ResumeUtil.getExceptionStackTrace(e);" + NL + "              " + NL + "                ";
  protected final String TEXT_272 = "\t\t\t" + NL + "\t\t\t" + NL + "    ";
  protected final String TEXT_273 = "\t" + NL + "                \t\t";
  protected final String TEXT_274 = "_List.clear();" + NL + "            \t";
  protected final String TEXT_275 = "\t\t\t\t\t" + NL + "                \t\t";
  protected final String TEXT_276 = " = null;";
  protected final String TEXT_277 = NL + "         } catch (java.lang.Exception ee) {//EE" + NL + "        \t\t";
  protected final String TEXT_278 = NL + "        \t\t\tlog.error(\"";
  protected final String TEXT_279 = " - \" + ee.getMessage());" + NL + "        \t\t";
  protected final String TEXT_280 = NL + "\t\t\t\tee.printStackTrace();";
  protected final String TEXT_281 = NL + "\t\t}//EE  \t\t\t" + NL + "\t}//end catch";
  protected final String TEXT_282 = NL + NL + NL + NL + NL + NL + NL;

	public boolean hasConcurrencyContext(List<IConnection> inputConnections, List<? extends INode> graphicalNodes) {

		for(IConnection connection : inputConnections) {
            EConnectionType connectionType = connection.getLineStyle();
            if (connectionType == EConnectionType.FLOW_MAIN) {
	            INode node = connection.getSource();
				return recursiveSearchIterateForConcurrency(node, graphicalNodes);
			}
		}
		return false;
	
	}

	public boolean hasIterateConnectionBefore(List<IConnection> inputConnections, List<? extends INode> graphicalNodes) {

		for(IConnection connection : inputConnections) {
            EConnectionType connectionType = connection.getLineStyle();
            if (connectionType == EConnectionType.FLOW_MAIN) {
	            INode node = connection.getSource();
				return recursiveSearchIterate(node, graphicalNodes);
			}
		}
		return false;
	
	}
	
	public boolean recursiveSearchIterate(INode node, List<? extends INode> graphicalNodes) {
	
		//System.out.println(node);
	
		List<IConnection> connections = (List<IConnection>) node.getIncomingConnections();

		for(IConnection connection : connections) {
            EConnectionType connectionType = connection.getLineStyle();
            if (connectionType == EConnectionType.FLOW_MAIN) {
	            node = connection.getSource();
				//System.out.println(connection.getName() + " connectionType=" + connectionType + " connection=" + String.valueOf(connection));
    	        return recursiveSearchIterate(node, graphicalNodes);
            } else if(connectionType == EConnectionType.ITERATE) {
				//System.out.println("ITERATE return true");
    	        return true;
            }else{
            	//for virtual component
            	boolean find = false;
				for(INode loopNode : graphicalNodes) {
					if(loopNode.getUniqueName().equals(node.getUniqueName())){
						find = true;
					}
				}
				if(!find){
					List<IConnection> vConnections = (List<IConnection>) node.getIncomingConnections();
					for(IConnection vConnection : vConnections) {
						node = vConnection.getSource();
						break;
					}
					return recursiveSearchIterate(node, graphicalNodes);
				}
            }
		}
		
		//System.out.println("return false");
		return false;
	
	}

	private boolean recursiveSearchIterateForConcurrency(INode node, List<? extends INode> graphicalNodes) {
		List<IConnection> connections = (List<IConnection>) node.getIncomingConnections();

		for(IConnection connection : connections) {
            EConnectionType connectionType = connection.getLineStyle();
            if (connectionType == EConnectionType.FLOW_MAIN) {
	            node = connection.getSource();
    	        return recursiveSearchIterateForConcurrency(node, graphicalNodes);
            } else if(connectionType == EConnectionType.ITERATE) {
				boolean parallelIterate = "true".equals(ElementParameterParser.getValue(connection, "__ENABLE_PARALLEL__"));
    	        if(parallelIterate) {
    	        	return true;
    	        } else {
    	        	node = connection.getSource();
        			return recursiveSearchIterateForConcurrency(node, graphicalNodes);
    	        }
            }else{
            	//for virtual component
            	boolean find = false;
				for(INode loopNode : graphicalNodes) {
					if(loopNode.getUniqueName().equals(node.getUniqueName())){
						find = true;
					}
				}
				if(!find){
					List<IConnection> vConnections = (List<IConnection>) node.getIncomingConnections();
					for(IConnection vConnection : vConnections) {
						node = vConnection.getSource();
						break;
					}
					return recursiveSearchIterateForConcurrency(node, graphicalNodes);
				}
            }
		}
		
		return false;
	
	}

	public INode searchSubProcessStartNode(IConnection connection) {
       	INode source = connection.getSource();
    	//System.out.println(" source=" +  source);
    	INode subprocessStartNode = null;
    	if(source != null) {
			String searchedComponentName = source.getUniqueName();
        	//System.out.println(" searchedComponentName=" +  searchedComponentName);
			List<? extends INode> generatedNodes = source.getProcess().getGeneratingNodes();
			for(INode loopNode : generatedNodes) {
				if(loopNode.getUniqueName().equals(searchedComponentName)) {
					subprocessStartNode = loopNode.getSubProcessStartNode(false);
		        	//System.out.println(" subprocessStartNode=" +  subprocessStartNode.getUniqueName());
				}
			}
		}
	
		return subprocessStartNode;
	}
    public boolean hasJoinedTable(String tableNameToTest, ExternalMapperData data) {
        for (ExternalMapperTable table : data.getOutputTables()) {
            if (table.getIsJoinTableOf() != null && table.getIsJoinTableOf().equals(tableNameToTest)) {
                return true;
            }
        }
        return false;
    }
    
    
  public boolean isErrorReject(ExternalMapperTable table){
        String errorMessage = null;
        String errorStackTrace = null; 
        if(table!=null&&table.getName()!=null&&table.getName().endsWith("ErrorReject")){
            for(ExternalMapperTableEntry entry:table.getMetadataTableEntries()){
                if("errorMessage".equals(entry.getName())){
                    errorMessage = entry.getName();
                }else if("errorStackTrace".equals(entry.getName())){
                    errorStackTrace = entry.getName();
                }
            }
            if(errorMessage!=null&&errorStackTrace!=null){
                return true;
            }
        }
        return false;
    }

	public String getExpressionWithAutoConvertFunction(
		String expression, 
		ExternalMapperTableEntry targetTableEntry, 
		IMetadataColumn targetColumn,
		DataMapExpressionParser expressionParser, 
		Map<TableEntryLocation, ExternalMapperTableEntry> locationMap4Entry,
		Map<TableEntryLocation, IMetadataColumn> locationMap4Column, 
		Map<String,String> autoConverterMap, 
		boolean enable_auto_convert_type) {
		
		if(!enable_auto_convert_type) {
			return expression;
		}
		
		if(expression == null || expression.isEmpty()) {
			return expression;
		}
	
		TableEntryLocation uniqueLocation = getUniqueEntryLocation(expression);
		
        if(uniqueLocation == null) {
        	return expression;
        }
        
    	ExternalMapperTableEntry uniqueSourceEntry = locationMap4Entry.get(uniqueLocation);
    	
    	if(uniqueSourceEntry == null) {
    		return expression;
    	}
    	
    	String source_talend_type = uniqueSourceEntry.getType();
        String target_talend_type = targetTableEntry.getType();
        
        String convertFunction = autoConverterMap.get(contact(source_talend_type, ":", target_talend_type));
        
        if(convertFunction!=null && !convertFunction.isEmpty()) {
        	StringBuilder strbuilder = new StringBuilder();
        	
	        if(uniqueSourceEntry.isNullable()) {
	      		strbuilder.append("(((").append(expression).append(") == null) ? null : (");
	        }
        
        	expression = convertFunction.replace("${0}", expression);
        	
        	String pattern = null;
        	if((JavaTypesManager.STRING.getId().equals(source_talend_type)||JavaTypesManager.OBJECT.getId().equals(source_talend_type)) && JavaTypesManager.DATE.getId().equals(target_talend_type)) {
        		if(targetColumn!=null) {
        			pattern = targetColumn.getPattern();
        		}
        		
        		if(pattern == null || pattern.isEmpty()) {
        			pattern = "\"dd-MM-yyyy\"";
        		}
        		
        	} else if(JavaTypesManager.DATE.getId().equals(source_talend_type) && JavaTypesManager.STRING.getId().equals(target_talend_type)) {
        		IMetadataColumn sourceColumn = locationMap4Column.get(uniqueLocation);
        		
        		if(sourceColumn!=null) {
        			pattern = sourceColumn.getPattern();
        		}
        		
        		if(pattern == null || pattern.isEmpty()) {
        			pattern = "\"dd-MM-yyyy\"";
        		}
        	}
        	
        	if(pattern != null) {
        		expression = expression.replace("${1}", pattern);
        	}
        	
        	strbuilder.append(expression);
        	
        	if(uniqueSourceEntry.isNullable()) {
      			strbuilder.append("))");
        	}
        	
        	return strbuilder.toString();
        }
        
        return expression;
	}
	
	java.util.regex.Pattern locationPattern = java.util.regex.Pattern.compile(LanguageProvider.getJavaLanguage().getLocationPattern());
	
	private TableEntryLocation getUniqueEntryLocation(String expression) {
		java.util.regex.Matcher matcher = locationPattern.matcher(expression);
		if(matcher.matches()) {
			return new TableEntryLocation(matcher.group(1), matcher.group(2));
		}
		return null;
	}
	
	StringBuilder strbuilder = new StringBuilder(20);
	
	private String contact(String... content) {
		strbuilder.setLength(0);
		for(String each : content) {
			strbuilder.append(each);
		}
		return strbuilder.toString();
	}

    public String generate(Object argument)
  {
    final StringBuffer stringBuffer = new StringBuffer();
    stringBuffer.append(TEXT_1);
    
	CodeGeneratorArgument codeGenArgument = (CodeGeneratorArgument) argument;
	MapperComponent node = (MapperComponent) codeGenArgument.getArgument();
	
	boolean stats = codeGenArgument.isStatistics(); 

	String tMapInName = "TMAP_IN";
	String tMapOutName = "TMAP_OUT";

	String componentName = node.getUniqueName();
	boolean isVirtualIn = componentName.endsWith(tMapInName);
	boolean isVirtualOut = componentName.endsWith(tMapOutName);
	
	boolean trace = codeGenArgument.isTrace();
	int tryOffset = 0;
	
	String componentNameForKeyProblem = componentName.replaceAll("_" + tMapOutName, "").replaceAll("_" + tMapInName, "");
	
    List<IConnection> inputConnections = (List<IConnection>) node.getIncomingConnections();

	if(isVirtualIn) {
		String searchedComponentName = componentName.replaceAll(tMapInName, tMapOutName);
		List<? extends INode> generatedNodes = node.getProcess().getGeneratingNodes();
		for(INode loopNode : generatedNodes) {
			if(loopNode.getUniqueName().equals(searchedComponentName)) {
				inputConnections = (List<IConnection>) loopNode.getIncomingConnections();
				break;
			}
		}
	}
	boolean isLog4jEnabled = ("true").equals(ElementParameterParser.getValue(node.getProcess(), "__LOG4J_ACTIVATE__"));
	boolean dieonerror = ("true").equals(ElementParameterParser.getValue(node, "__DIE_ON_ERROR__"));

/////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
	
        ILanguage currentLanguage = LanguageProvider.getJavaLanguage();
        
        List<IConnection> outputConnections = (List<IConnection>) node.getOutgoingConnections();
        ExternalMapperData data = (ExternalMapperData) node.getExternalData();
        String uniqueNameComponent = node.getUniqueName();
        boolean checkingSyntax = codeGenArgument.isCheckingSyntax();
        //boolean checkingSyntax = true;

		//System.out.println("checkingSyntax=" + checkingSyntax + ", componentNameForKeyProblem=" + componentNameForKeyProblem);

        String cr = "\n";
        String rejected = "rejected_" + uniqueNameComponent;
        String rejectedInnerJoin = "rejectedInnerJoin_" + uniqueNameComponent;
        String mainRowRejected = "mainRowRejected_" + uniqueNameComponent;

        List<ExternalMapperTable> inputTablesWithInvalid = data.getInputTables();
        List<ExternalMapperTable> varsTables = data.getVarsTables();
        List<ExternalMapperTable> outputTables = data.getOutputTables();

		boolean isPersistent = true;
		boolean previousMainNodeIsVirtual = false;
		boolean isFirstPersistentSortedTable = false;
		boolean previousStateIsFirstPersistentSortedTable = false;
		boolean isPersistentSortedTable = false;
		boolean hasMainFilter = false;
		boolean mainFilterAlreadyDone = false;

        DataMapExpressionParser expressionParser = new DataMapExpressionParser(currentLanguage);

        JavaGenerationManager gm = (JavaGenerationManager) node.initGenerationManager();

        // /////////////////////////////////////////////////////////////////////////////////////////////////////
        // /////////////////////////////////////////////////////////////////////////////////////////////////////
        // INPUTS : initialization of input arrays from expressions keys and hashes
        // 
        
        HashMap<String, IConnection> hNameToConnection = new HashMap<String, IConnection>();
        for (IConnection connection : inputConnections) {
            hNameToConnection.put(connection.getName(), connection);
        }

		// filter input tables to get only valid tables
		boolean findNext = false;
		
		List<ExternalMapperTable> inputTables = new ArrayList<ExternalMapperTable>();
		for(int i=0; i < inputTablesWithInvalid.size(); i++) {
			ExternalMapperTable currentLoopTable = inputTablesWithInvalid.get(i);
			if(hNameToConnection.get(currentLoopTable.getName()) != null) {
				inputTables.add(currentLoopTable);
			}
		}

        gm.setInputTables(inputTables);
        gm.setVarsTables(varsTables);
        
     	HashMap<String, ExternalMapperTableEntry> hExternalInputTableEntries = new HashMap<String, ExternalMapperTableEntry>();
        
        //get the auto convert parameters from the global project setting
        Map<String,String> autoConverterMap = new HashMap<String,String>();
        
        //store all the input entries to map for looking up for auto data convert
    	Map<TableEntryLocation, ExternalMapperTableEntry> locationMap4Entry = new HashMap<TableEntryLocation, ExternalMapperTableEntry>();
    	
    	//store all the input columns to map for looking up for auto data convert
    	Map<TableEntryLocation, IMetadataColumn> locationMap4Column = new HashMap<TableEntryLocation, IMetadataColumn>();
    	
    	boolean enable_auto_convert_type = "true".equals(ElementParameterParser.getValue(node, "__ENABLE_AUTO_CONVERT_TYPE__"));
    	
    	if(enable_auto_convert_type) {

    stringBuffer.append(TEXT_2);
    stringBuffer.append(TEXT_3);
    
JavaType[] commonTypes = {
	JavaTypesManager.STRING,
    JavaTypesManager.INTEGER,
    JavaTypesManager.LONG,
    JavaTypesManager.SHORT,
    JavaTypesManager.BOOLEAN,
    JavaTypesManager.CHARACTER,
    JavaTypesManager.BYTE,
    JavaTypesManager.BYTE_ARRAY,
    JavaTypesManager.DATE,
    JavaTypesManager.DOUBLE,
    JavaTypesManager.FLOAT,
    JavaTypesManager.OBJECT,
    JavaTypesManager.LIST,
    JavaTypesManager.BIGDECIMAL
};

for(JavaType sourceType : commonTypes) {
	for(JavaType targetType : commonTypes) {
		if(sourceType == targetType) {
			continue;
		}
		
		String sourceTypeToGenerate = JavaTypesManager.getTypeToGenerate(sourceType.getId(), true);
        sourceTypeToGenerate = sourceTypeToGenerate.contains(".") ? sourceTypeToGenerate.substring(sourceTypeToGenerate.lastIndexOf(".") + 1) : sourceTypeToGenerate;
        if (("byte[]").equals(sourceTypeToGenerate)){
    		sourceTypeToGenerate = "byteArray";
        }
		
		String targetTypeToGenerate = JavaTypesManager.getTypeToGenerate(targetType.getId(), true);
        targetTypeToGenerate = targetTypeToGenerate.contains(".") ? targetTypeToGenerate.substring(targetTypeToGenerate.lastIndexOf(".") + 1) : targetTypeToGenerate;
        if (("byte[]").equals(targetTypeToGenerate)){
    		targetTypeToGenerate = "byteArray";
        }
        
        String function = null;
        if("Date".equals(targetTypeToGenerate) && ("String".equals(sourceTypeToGenerate)||"Object".equals(sourceTypeToGenerate))) {
        	function = contact("routines.system.TypeConvert.", sourceTypeToGenerate, "2", targetTypeToGenerate, "(${0}, ${1})");
        } else if("String".equals(targetTypeToGenerate) && "Date".equals(sourceTypeToGenerate)) {
        	function = contact("routines.system.TypeConvert.", sourceTypeToGenerate, "2", targetTypeToGenerate, "(${0}, ${1})");
        } else {
        	function = contact("routines.system.TypeConvert.", sourceTypeToGenerate, "2", targetTypeToGenerate, "(${0})");
        }
        
        autoConverterMap.put(contact(sourceType.getId(), ":", targetType.getId()), function);
	}
}

autoConverterMap.put(contact("id_Dynamic", ":", JavaTypesManager.STRING.getId()), "String.valueOf(${0})");
autoConverterMap.put(contact("id_Document", ":", JavaTypesManager.STRING.getId()), "String.valueOf(${0})");
autoConverterMap.put(contact(JavaTypesManager.STRING.getId(), ":", "id_Document"), "routines.system.ParserUtils.parseTo_Document(${0})");

    stringBuffer.append(TEXT_3);
    
            if(GlobalServiceRegister.getDefault().isServiceRegistered(IAutoConvertTypesService.class)) {
                IAutoConvertTypesService autoConvertTypesService = (IAutoConvertTypesService)GlobalServiceRegister.getDefault().getService(IAutoConvertTypesService.class);
            	List<AutoConversionType> autoConversionTypes = autoConvertTypesService.getAllAutoConversionTypes();
            	if(autoConversionTypes!=null) {
                	for(AutoConversionType autoConversionType : autoConversionTypes) {
                		autoConverterMap.put(contact(autoConversionType.getSourceDataType(), ":", autoConversionType.getTargetDataType()), autoConversionType.getConversionFunction());
                	}
            	}
        	}
        	
        	for(ExternalMapperTable inputTable : inputTables) {
        		IConnection connection = hNameToConnection.get(inputTable.getName());
        		
        		if(connection == null) {
        			continue;
        		}
        		
        		IMetadataTable metadata = connection.getMetadataTable();
        		
        		if(metadata == null) {
        			continue;
        		}
        		
        		List<IMetadataColumn> columns = metadata.getListColumns();
        		
        		if(columns == null || columns.isEmpty()) {
        			continue;
        		}
        		
        		List<ExternalMapperTableEntry> metadataTableEntries = inputTable.getMetadataTableEntries();
        		
        		if(metadataTableEntries == null || metadataTableEntries.isEmpty()) {
        			continue;
        		}
        		
        		for (ExternalMapperTableEntry externalTableEntry : metadataTableEntries) {
                	hExternalInputTableEntries.put(externalTableEntry.getName(), externalTableEntry);
        		}
        		
        		for(IMetadataColumn column : columns) {
        			ExternalMapperTableEntry entry = hExternalInputTableEntries.get(column.getLabel());
        			
        			if(entry == null) {
        				continue;
        			}
        			
        			TableEntryLocation location = new TableEntryLocation(inputTable.getName(), column.getLabel());
        			
        			locationMap4Entry.put(location, entry);
        			locationMap4Column.put(location, column);
        		}
        	}
        	
        	for(ExternalMapperTable varsTable : varsTables) {
        		List<ExternalMapperTableEntry> varsTableEntries = varsTable.getMetadataTableEntries();
                if (varsTableEntries == null || varsTableEntries.isEmpty()) {
                    continue;
                }
                
                for (ExternalMapperTableEntry varsTableEntry : varsTableEntries) {
                	TableEntryLocation location = new TableEntryLocation(varsTable.getName(), varsTableEntry.getName());
                	locationMap4Entry.put(location, varsTableEntry);
        		}
        	}
    	}
        
		int sizeInputTables = inputTables.size();

		ExternalMapperTable mainInputTable = null;
		String mainInputTableName = null;
		IConnection realMainConnection = null;
		
		if(sizeInputTables > 0) { // T_TM_M_199

			ExternalMapperTable externalTable = inputTables.get(0);
            String tableName = externalTable.getName();
            IConnection connection = hNameToConnection.get(tableName);
            EConnectionType connectionType = connection.getLineStyle();
            if (connectionType == EConnectionType.FLOW_MAIN) {
            	mainInputTable = externalTable;
            	mainInputTableName = mainInputTable.getName();
	            previousMainNodeIsVirtual = connection.getSource() != null ? connection.getSource().isVirtualGenerateNode() : false;
	            realMainConnection = org.talend.core.model.utils.NodeUtil.getRealConnectionTypeBased(connection);
            }

		} // T_TM_M_199

		String nextLookupName = null;
		List<IMetadataColumn> nextLookupColumnsKeys = new ArrayList<IMetadataColumn>();

		boolean hasPersistentLookup = false;
		int indexLastPersistentSortedTable = -1;		

		for (int iInputTable = 1; iInputTable < sizeInputTables; iInputTable++) { // T_TM_M_241
			ExternalMapperTable inputTable = inputTables.get(iInputTable);
            String tableName = inputTable.getName();
            IConnection connection = hNameToConnection.get(tableName);
            if (connection == null) {
	        	continue;
            }

            if (inputTable != null) { // T_TM_M_245
	        	hExternalInputTableEntries.clear();
            	List<ExternalMapperTableEntry> metadataTableEntries = inputTable.getMetadataTableEntries();
                if (metadataTableEntries == null) {
	            	continue;
                }
                	
                if(inputTable.isPersistent() && !"ALL_ROWS".equals(inputTable.getMatchingMode())) {
                	hasPersistentLookup = true;
					indexLastPersistentSortedTable = iInputTable;
                }
                	
			} // T_TM_M_245
		} // T_TM_M_241

		boolean firstLookupIsPersistentSorted = false;
		
    stringBuffer.append(TEXT_4);
    stringBuffer.append( uniqueNameComponent);
    stringBuffer.append(TEXT_5);
    


			  	   if(mainInputTable != null
			  	   	 && mainInputTable.isActivateExpressionFilter()
			  	   	 && mainInputTable.getExpressionFilter() != null 
			  	   	 && !("").equals(mainInputTable.getExpressionFilter().trim())) { // T_TM_M_300 

						if(isVirtualOut) { // T_TM_M_301

							mainFilterAlreadyDone = true;
	
		                	String key = CodeGenerationUtils.buildProblemKey(componentNameForKeyProblem,
   	                     	JavaGenerationManager.PROBLEM_KEY_FIELD.FILTER.toString(), mainInputTableName);
					  	  	 
    stringBuffer.append(TEXT_6);
    stringBuffer.append( checkingSyntax ? CodeGenerationUtils.buildJavaStartFieldKey(key) : "" );
    stringBuffer.append(TEXT_7);
    // keep this line to allow comments in filter 
    stringBuffer.append(TEXT_8);
    stringBuffer.append( mainInputTable.getExpressionFilter());
    stringBuffer.append(TEXT_8);
    // keep this line to allow comments in filter 
    stringBuffer.append(TEXT_9);
    stringBuffer.append( checkingSyntax ? CodeGenerationUtils.buildJavaEndFieldKey(key) : "" );
    stringBuffer.append(TEXT_10);
    
							if(isVirtualOut) {
					
								gm.addBlocksCodeToClose(new BlockCode("G_TM_M_281 close main tMap filter for table '" + mainInputTableName +"'"));
					
							}
								
						} // T_TM_M_301
				 	} // T_TM_M_300
			

		int currentJoinedTableIndex = 1;
		// exprKey(s) initialization(s) for Main flow
		// ---------------------------------------------
		boolean isFirstTableIsLookupPersistent = sizeInputTables > 1 && inputTables.get(1).isPersistent() && !"ALL_ROWS".equals(inputTables.get(1).getMatchingMode());
		if (isFirstTableIsLookupPersistent) { // T_TM_M_201
			ExternalMapperTable inputTable = inputTables.get(1);
            String tableName = inputTable.getName();
            nextLookupName = inputTable.getName();
            firstLookupIsPersistentSorted = true;
            
            IConnection connection = hNameToConnection.get(tableName);
            if (!isVirtualIn && connection != null) { // T_TM_M_206
            	//EConnectionType connectionType = connection.getLineStyle();
	
            	IMetadataTable metadataTable = connection.getMetadataTable();
            	if (inputTable != null) { // T_TM_M_205
		        	hExternalInputTableEntries.clear();
		        	
		        	
    stringBuffer.append(TEXT_11);
    stringBuffer.append( uniqueNameComponent);
    stringBuffer.append(TEXT_12);
    
		        	
            		List<ExternalMapperTableEntry> metadataTableEntries = inputTable.getMetadataTableEntries();
                	if (metadataTableEntries != null) { // T_TM_M_207
                	
                		for (ExternalMapperTableEntry externalTableEntry : metadataTableEntries) {
			            	hExternalInputTableEntries.put(externalTableEntry.getName(), externalTableEntry);
                		}
                		List<IMetadataColumn> listColumns = metadataTable.getListColumns();
                		for (IMetadataColumn column : listColumns) { // T_TM_M_204
			            	String columnName = column.getLabel();
                			ExternalMapperTableEntry externalInputTableEntry = hExternalInputTableEntries.get(columnName);
                    		if (externalInputTableEntry != null) { // T_TM_M_203
			                	String expressionKey = externalInputTableEntry.getExpression();
                        		if (expressionKey != null && !"".equals(expressionKey.trim())) { // T_TM_M_202
		                        	nextLookupColumnsKeys.add(column);
	                                String typeToGenerate = JavaTypesManager.getTypeToGenerate(column.getTalendType(), column.isNullable());
                                	boolean javaPrimitiveKeyColumn = JavaTypesManager.isJavaPrimitiveType(typeToGenerate);
				            		String key = CodeGenerationUtils.buildProblemKey(componentNameForKeyProblem,
			                		JavaGenerationManager.PROBLEM_KEY_FIELD.METADATA_COLUMN.toString(), tableName, columnName);
            						if (checkingSyntax) {
	    	        				
    stringBuffer.append(TEXT_13);
    stringBuffer.append( CodeGenerationUtils.buildJavaStartFieldKey(key) );
    stringBuffer.append(TEXT_14);
    
            						}
            						
            						expressionKey = getExpressionWithAutoConvertFunction(expressionKey, externalInputTableEntry, column, expressionParser, locationMap4Entry, locationMap4Column, autoConverterMap, enable_auto_convert_type);
        	                        
                       		    	if(javaPrimitiveKeyColumn) {
                        		    	
                       		    		JavaType javaType = JavaTypesManager.getJavaTypeFromName(typeToGenerate);
                       		    		String nullableType = JavaTypesManager.getTypeToGenerate(javaType.getId(), true);
                       		    		String defaultValue = JavaTypesManager.getDefaultValueFromJavaIdType(javaType.getId(), false);
                        		    	
    stringBuffer.append(TEXT_15);
    stringBuffer.append( JavaTypesManager.getTypeToGenerate(column.getTalendType(), column.isNullable()) );
    stringBuffer.append(TEXT_16);
    stringBuffer.append( tableName );
    stringBuffer.append(TEXT_17);
    stringBuffer.append( column.getLabel() );
    stringBuffer.append(TEXT_18);
    stringBuffer.append( defaultValue );
    stringBuffer.append(TEXT_19);
    stringBuffer.append( tableName );
    stringBuffer.append(TEXT_17);
    stringBuffer.append( columnName );
    stringBuffer.append(TEXT_18);
    stringBuffer.append( expressionKey );
    stringBuffer.append(TEXT_20);
    stringBuffer.append( tableName );
    stringBuffer.append(TEXT_17);
    stringBuffer.append( columnName );
    stringBuffer.append(TEXT_21);
    stringBuffer.append( uniqueNameComponent);
    stringBuffer.append(TEXT_22);
    stringBuffer.append( tableName );
    stringBuffer.append(TEXT_17);
    stringBuffer.append( column.getLabel() );
    stringBuffer.append(TEXT_23);
    stringBuffer.append( typeToGenerate );
    stringBuffer.append(TEXT_24);
    stringBuffer.append( nullableType );
    stringBuffer.append(TEXT_25);
    stringBuffer.append( tableName );
    stringBuffer.append(TEXT_17);
    stringBuffer.append( columnName );
    stringBuffer.append(TEXT_26);
    
                       		    	} else {
					            		
    stringBuffer.append(TEXT_27);
    stringBuffer.append( JavaTypesManager.getTypeToGenerate(column.getTalendType(), column.isNullable()) );
    stringBuffer.append(TEXT_16);
    stringBuffer.append( tableName );
    stringBuffer.append(TEXT_17);
    stringBuffer.append( column.getLabel() );
    stringBuffer.append(TEXT_18);
    stringBuffer.append( expressionKey );
    stringBuffer.append(TEXT_28);
    
                       		    	}


            						if (checkingSyntax) {
                					
    stringBuffer.append(TEXT_29);
    stringBuffer.append( CodeGenerationUtils.buildJavaEndFieldKey(key) );
    stringBuffer.append(TEXT_30);
    
            						}
								} // T_TM_M_202
							} // T_TM_M_203
						} // T_TM_M_204
					} // T_TM_M_207
				} // T_TM_M_205
			} // T_TM_M_206
		
			if(!isVirtualIn) { // T_TM_M_211
			
			
		        
    stringBuffer.append(TEXT_31);
    stringBuffer.append(componentNameForKeyProblem);
    stringBuffer.append(TEXT_32);
    stringBuffer.append(currentJoinedTableIndex);
    stringBuffer.append(TEXT_33);
    stringBuffer.append(componentNameForKeyProblem);
    stringBuffer.append(TEXT_32);
    stringBuffer.append(currentJoinedTableIndex);
    stringBuffer.append(TEXT_34);
    stringBuffer.append(componentNameForKeyProblem);
    stringBuffer.append(TEXT_32);
    stringBuffer.append(currentJoinedTableIndex);
    stringBuffer.append(TEXT_35);
    stringBuffer.append(componentNameForKeyProblem);
    stringBuffer.append(TEXT_32);
    stringBuffer.append(currentJoinedTableIndex);
    stringBuffer.append(TEXT_36);
    stringBuffer.append( mainInputTableName );
    
                    
                    for (IMetadataColumn column : nextLookupColumnsKeys) {
                    	String columnName = column.getLabel();
                    	
    stringBuffer.append(TEXT_37);
    stringBuffer.append( nextLookupName );
    stringBuffer.append(TEXT_17);
    stringBuffer.append(column.getLabel() );
    
                    }
                    
    stringBuffer.append(TEXT_38);
    stringBuffer.append(componentNameForKeyProblem);
    stringBuffer.append(TEXT_32);
    stringBuffer.append(currentJoinedTableIndex);
    stringBuffer.append(TEXT_39);
    stringBuffer.append(componentNameForKeyProblem);
    stringBuffer.append(TEXT_32);
    stringBuffer.append(currentJoinedTableIndex);
    stringBuffer.append(TEXT_40);
    

			} // T_TM_M_211



		} // T_TM_M_201
	
	
		if(isFirstTableIsLookupPersistent && !isVirtualOut) { // T_TM_M_212
	    
    stringBuffer.append(TEXT_41);
    stringBuffer.append(componentNameForKeyProblem);
    stringBuffer.append(TEXT_32);
    stringBuffer.append(currentJoinedTableIndex);
    stringBuffer.append(TEXT_42);
    
		} // T_TM_M_212
	
	
		if(isVirtualIn) { // T_TM_M_291
			
			
    stringBuffer.append(TEXT_43);
    stringBuffer.append( mainInputTableName );
    stringBuffer.append(TEXT_44);
    stringBuffer.append( mainInputTableName );
    stringBuffer.append(TEXT_45);
    stringBuffer.append( realMainConnection.getName() );
    stringBuffer.append(TEXT_46);
    
		} // T_TM_M_291
		
		
		
    stringBuffer.append(TEXT_47);
    
            if (!dieonerror) {
			    tryOffset = stringBuffer.length();

            } // close dieonerror if check
		
    stringBuffer.append(TEXT_48);
    

        ArrayList<ExternalMapperTable> inputTablesWithInnerJoin = new ArrayList<ExternalMapperTable>();
        boolean hasValidLookupTables = false;

		  int closeBracketCounter = 0;
		
    stringBuffer.append(TEXT_49);
    stringBuffer.append( rejectedInnerJoin );
    stringBuffer.append(TEXT_50);
    stringBuffer.append( mainRowRejected );
    stringBuffer.append(TEXT_51);
    

		String previousLookupName = null;
		String previousTableName = mainInputTableName;

		
		int previousJoinedTablesPersistentSortedDelimited = 0;
		int nextJoinedTableIndex = currentJoinedTableIndex;

		List<IConnection> cumulatedInputConnections = new ArrayList<IConnection>();

		sizeInputTables = inputTables.size();

		boolean lastPersistentSortedTableIsAlreadyProcessed = false;
		boolean previousTableIsPersistentSorted = false;
		boolean previousTableIsMultipleResultMode = false;
		List<String> declarationsStructForNextSortedWhile = new ArrayList<String>();
		List<String> closeAllRowsBlockCount = new ArrayList<String>();

        for (int iInputTable = 0; iInputTable < sizeInputTables; iInputTable++) { // T_TM_M_261
			ExternalMapperTable externalTable = inputTables.get(iInputTable);
			
			boolean isMultipleResultMode = false;
			
			ExternalMapperTable nextInputTable = (iInputTable + 1 < sizeInputTables) ? inputTables.get(iInputTable + 1) : null;
			
			//System.out.println("### " + externalTable.getName() + " ->  " + (nextInputTable != null ? nextInputTable.getName() : null));
			
			boolean hasNextValidTable = (nextInputTable != null);
			
			boolean isLastTable = !hasNextValidTable;
			boolean isLastPersistentSortedTable = (indexLastPersistentSortedTable == iInputTable);
			
			boolean nextTableIsPersistentSorted = 
				!isLastTable 
				&& inputTables.get(iInputTable + 1).isPersistent() 
				&& !"ALL_ROWS".equals(inputTables.get(iInputTable + 1).getMatchingMode());

			boolean nextTableIsFirstPersistentSorted = nextTableIsPersistentSorted && !previousStateIsFirstPersistentSortedTable;
			
			boolean isLastTableForTMAP_OUT = isVirtualOut && nextTableIsFirstPersistentSorted;
			boolean isLastPersistentSortedTableForTMAP_OUT = false;


            String tableName = externalTable.getName();
            
            //System.out.println("tableName=" + tableName);
            
            IConnection connection = hNameToConnection.get(tableName);
            if (connection == null) {
                continue;
            }
            
            
            EConnectionType connectionType = connection.getLineStyle();
            
            if (connectionType == EConnectionType.FLOW_MAIN) {
            
            		cumulatedInputConnections.add(connection);
            
			  	  	   if(!mainFilterAlreadyDone 
			  	  	    && !hasPersistentLookup
			  	  	   	&& externalTable.isActivateExpressionFilter() 
			  	  	   	&& externalTable.getExpressionFilter() != null 
			  	  	   	&& !("").equals(externalTable.getExpressionFilter().trim())
			  	  	   ) { 

						hasMainFilter = true;

		                String key = CodeGenerationUtils.buildProblemKey(componentNameForKeyProblem,
   	                     JavaGenerationManager.PROBLEM_KEY_FIELD.FILTER.toString(), tableName);
					  	  	 
    stringBuffer.append(TEXT_52);
    stringBuffer.append( checkingSyntax ? CodeGenerationUtils.buildJavaStartFieldKey(key) : "" );
    stringBuffer.append(TEXT_7);
    // keep this line to allow comments in filter 
    stringBuffer.append(TEXT_8);
    stringBuffer.append( externalTable.getExpressionFilter());
    stringBuffer.append(TEXT_8);
    // keep this line to allow comments in filter 
    stringBuffer.append(TEXT_9);
    stringBuffer.append( checkingSyntax ? CodeGenerationUtils.buildJavaEndFieldKey(key) : "" );
    stringBuffer.append(TEXT_53);
    stringBuffer.append(tableName );
    stringBuffer.append(TEXT_54);
    
							gm.addBlocksCodeToClose(new BlockCode("G_TM_M_280 close main tMap filter for table '" + tableName +"'"));

			 	  	   }
                  continue;
                  
            } else if (connectionType == EConnectionType.FLOW_REF) { // T_TM_M_249

				String lookupMode = externalTable.getLookupMode();
				boolean isCacheOrReloadLookupMode = org.talend.designer.mapper.model.table.LOOKUP_MODE.CACHE_OR_RELOAD.name().equals(lookupMode);
				boolean isOneOfReloadLookupMode = 
					   isCacheOrReloadLookupMode ||
					   org.talend.designer.mapper.model.table.LOOKUP_MODE.RELOAD.name().equals(lookupMode) 
					;

                IMetadataTable metadataTable = connection.getMetadataTable();
                if (externalTable != null) { // T_TM_M_250
                    if (externalTable.isInnerJoin()) {
                        inputTablesWithInnerJoin.add(externalTable);
                    }
                    hExternalInputTableEntries.clear();
                    List<ExternalMapperTableEntry> metadataTableEntries = externalTable.getMetadataTableEntries();
                    if (metadataTableEntries == null) {
                        continue;
                    }

					isPersistentSortedTable = externalTable.isPersistent() && !"ALL_ROWS".equals(externalTable.getMatchingMode());

					if(previousStateIsFirstPersistentSortedTable == false && isPersistentSortedTable) {
						isFirstPersistentSortedTable = true;
					}
					
					isLastPersistentSortedTableForTMAP_OUT = isVirtualOut && isFirstPersistentSortedTable;

					nextJoinedTableIndex++;

					if(isFirstPersistentSortedTable && isVirtualOut) {
						break;
					} 
					
				
    stringBuffer.append(TEXT_55);
    stringBuffer.append( tableName );
    stringBuffer.append(TEXT_56);
    
				//System.out.println("previousStateIsFirstPersistentSortedTable=" + previousStateIsFirstPersistentSortedTable + ", isFirstPersistentSortedTable=" + isFirstPersistentSortedTable + ", nextTableIsPersistentSorted=" + nextTableIsPersistentSorted); 

            if(isPersistentSortedTable) { // T_TM_M_294

				previousJoinedTablesPersistentSortedDelimited = currentJoinedTableIndex;

				
    stringBuffer.append(TEXT_57);
    stringBuffer.append(componentNameForKeyProblem);
    stringBuffer.append(TEXT_32);
    stringBuffer.append(currentJoinedTableIndex);
    stringBuffer.append(TEXT_58);
    stringBuffer.append(componentNameForKeyProblem);
    stringBuffer.append(TEXT_32);
    stringBuffer.append(currentJoinedTableIndex);
    stringBuffer.append(TEXT_59);
    
				if(!isOneOfReloadLookupMode) {
				
    stringBuffer.append(TEXT_60);
    stringBuffer.append( tableName );
    stringBuffer.append(TEXT_61);
    
				}
				
    stringBuffer.append(TEXT_62);
    stringBuffer.append(componentNameForKeyProblem);
    stringBuffer.append(TEXT_32);
    stringBuffer.append(currentJoinedTableIndex);
    stringBuffer.append(TEXT_63);
    
				if(true || previousTableName != null && !previousTableName.equals(mainInputTableName)) {
	         		for(String structName : declarationsStructForNextSortedWhile) {
				
    stringBuffer.append(TEXT_64);
    stringBuffer.append( previousTableIsMultipleResultMode ? "" : previousTableName + "Struct " );
    stringBuffer.append( previousTableName );
    stringBuffer.append(TEXT_45);
    stringBuffer.append( previousTableName );
    stringBuffer.append(TEXT_65);
    stringBuffer.append( structName );
    stringBuffer.append(TEXT_66);
    stringBuffer.append( structName );
    stringBuffer.append(TEXT_45);
    stringBuffer.append( structName );
    stringBuffer.append(TEXT_67);
    
					}
					declarationsStructForNextSortedWhile.clear();
				}
				
    stringBuffer.append(TEXT_68);
    stringBuffer.append( firstLookupIsPersistentSorted );
    stringBuffer.append(TEXT_69);
    stringBuffer.append( isFirstPersistentSortedTable );
    stringBuffer.append(TEXT_70);
    stringBuffer.append( isFirstPersistentSortedTable && !firstLookupIsPersistentSorted && !isVirtualIn ? "boolean " : "" );
    stringBuffer.append( rejectedInnerJoin );
    stringBuffer.append(TEXT_71);
    stringBuffer.append(componentNameForKeyProblem);
    stringBuffer.append(TEXT_32);
    stringBuffer.append(currentJoinedTableIndex);
    stringBuffer.append(TEXT_72);
    stringBuffer.append( currentJoinedTableIndex );
    stringBuffer.append(TEXT_73);
    
								if(isLastPersistentSortedTable) {
									
    stringBuffer.append(TEXT_74);
    stringBuffer.append(currentJoinedTableIndex );
    stringBuffer.append(TEXT_75);
    
									gm.addBlocksCodeToClose(new BlockCode("G_TM_M_250 close loop read file data '" + currentJoinedTableIndex +"'"));
								}
								
    stringBuffer.append(TEXT_76);
    stringBuffer.append(componentNameForKeyProblem);
    stringBuffer.append(TEXT_32);
    stringBuffer.append(currentJoinedTableIndex);
    stringBuffer.append(TEXT_77);
    stringBuffer.append(componentNameForKeyProblem);
    stringBuffer.append(TEXT_32);
    stringBuffer.append(currentJoinedTableIndex);
    stringBuffer.append(TEXT_78);
    stringBuffer.append(componentNameForKeyProblem);
    stringBuffer.append(TEXT_32);
    stringBuffer.append(currentJoinedTableIndex);
    stringBuffer.append(TEXT_79);
    stringBuffer.append(componentNameForKeyProblem);
    stringBuffer.append(TEXT_32);
    stringBuffer.append(currentJoinedTableIndex);
    stringBuffer.append(TEXT_80);
    
               		
               			String comma = "";
		         		for(IConnection aConnection : cumulatedInputConnections) {
		         		
			         		
    stringBuffer.append(comma);
    stringBuffer.append(TEXT_81);
    stringBuffer.append( aConnection.getName() );
    
		         			comma = ", ";
		         		}
               		
               		
    stringBuffer.append(TEXT_82);
    stringBuffer.append( rejectedInnerJoin );
    stringBuffer.append(TEXT_83);
    stringBuffer.append(componentNameForKeyProblem);
    stringBuffer.append(TEXT_32);
    stringBuffer.append(currentJoinedTableIndex);
    stringBuffer.append(TEXT_84);
    
			}  // T_TM_M_294 
			else if(isFirstPersistentSortedTable) { // T_TM_M_295
			
    stringBuffer.append(TEXT_85);
    stringBuffer.append( rejectedInnerJoin );
    stringBuffer.append(TEXT_86);
    
			} // T_TM_M_295

                    for (ExternalMapperTableEntry externalTableEntry : metadataTableEntries) {
                        hExternalInputTableEntries.put(externalTableEntry.getName(), externalTableEntry);
                    }
                    List<IMetadataColumn> listColumns = metadataTable.getListColumns();
                    ArrayList<String> keysNames = new ArrayList<String>();
                    ArrayList<String> keysValues = new ArrayList<String>();
                    ArrayList<String> keysTypes = new ArrayList<String>();
                    ArrayList<ExternalMapperTableEntry> keysEntries = new ArrayList<ExternalMapperTableEntry>();
                    ArrayList<IMetadataColumn> keysColumns = new ArrayList<IMetadataColumn>();
                    
                    boolean hasPrimitiveKey = false;
                    
                    for (IMetadataColumn column : listColumns) {
                        String columnName = column.getLabel();
                        ExternalMapperTableEntry externalInputTableEntry = hExternalInputTableEntries.get(columnName);
                        if (externalInputTableEntry != null) {
                            String expressionKey = externalInputTableEntry.getExpression();
                            if (expressionKey != null && !"".equals(expressionKey.trim())) {
                                keysNames.add(columnName);
                                keysValues.add(expressionKey);
                                String typeToGenerate = JavaTypesManager.getTypeToGenerate(column.getTalendType(), column.isNullable());
                                keysTypes.add(typeToGenerate);
                                boolean javaPrimitiveKeyColumn = JavaTypesManager.isJavaPrimitiveType(typeToGenerate);
                                if(javaPrimitiveKeyColumn) {
                                	hasPrimitiveKey = true;
                                }
                                
                                keysEntries.add(externalInputTableEntry);
                                keysColumns.add(column);
                            }
                        }
                    }
                    String[] aKeysNames = keysNames.toArray(new String[0]);
                    String[] aKeysValues = keysValues.toArray(new String[0]);
    		           
    		        String className = tableName + "Struct";

                    hasValidLookupTables = true;
                    
                     String matchingMode = externalTable.getMatchingMode();
					if(matchingMode == null) {
						if(aKeysValues.length > 0) {
							matchingMode = "UNIQUE_MATCH";
						} else {
							matchingMode = "ALL_ROWS";
						}
					}
                    isMultipleResultMode = ("ALL_ROWS").equals(matchingMode) || ("ALL_MATCHES").equals(matchingMode);

			//System.out.println("tableName=" +  tableName + " => isMultipleResultMode=" + isMultipleResultMode);

			declarationsStructForNextSortedWhile.add(tableName);

 			if (
 					!isVirtualIn 
	 				|| 
 					(
	 					isVirtualIn 
 						&& (isFirstPersistentSortedTable || previousStateIsFirstPersistentSortedTable) 
 					)
 				) { // T_TM_M_296

                     
    stringBuffer.append(TEXT_87);
    stringBuffer.append( tableName );
    stringBuffer.append(TEXT_88);
    
       		  	    	
       		  	    	
       		  	    	String beforeMatchFilter = null;
       		  	    	
                        
    stringBuffer.append(TEXT_89);
    stringBuffer.append( className );
    stringBuffer.append(TEXT_81);
    stringBuffer.append( tableName );
    stringBuffer.append(TEXT_90);
    stringBuffer.append( rejectedInnerJoin );
    
		           		  		
		           		  		if (beforeMatchFilter != null) { // T 101
   	                    				
    stringBuffer.append(TEXT_91);
    stringBuffer.append( beforeMatchFilter );
    
           		  	    			} // T 101
		           		  	    
		           		  	 
    stringBuffer.append(TEXT_92);
     
                        		if(aKeysValues.length > 0 || checkingSyntax) { // T 001

								
    stringBuffer.append(TEXT_93);
    stringBuffer.append( uniqueNameComponent);
    stringBuffer.append(TEXT_94);
    

                        		for (int iKeyName = 0; iKeyName < aKeysNames.length; iKeyName++) {

                        		    String key = CodeGenerationUtils.buildProblemKey(componentNameForKeyProblem,
                        		    JavaGenerationManager.PROBLEM_KEY_FIELD.METADATA_COLUMN.toString(), tableName, aKeysNames[iKeyName]);
                        		    if (checkingSyntax) {
    	                        		
    stringBuffer.append(TEXT_95);
    stringBuffer.append( CodeGenerationUtils.buildJavaStartFieldKey(key) );
    stringBuffer.append(TEXT_96);
    
                        		    }

                       		    	String typeToGenerate = keysTypes.get(iKeyName);
                       		        boolean javaPrimitiveKeyColumn = JavaTypesManager.isJavaPrimitiveType(typeToGenerate);
                       		        
                       		        aKeysValues[iKeyName] = getExpressionWithAutoConvertFunction(aKeysValues[iKeyName], keysEntries.get(iKeyName), keysColumns.get(iKeyName), expressionParser, locationMap4Entry, locationMap4Column, autoConverterMap, enable_auto_convert_type);
                       		    	
									if(isPersistentSortedTable) {


                        		    	if(javaPrimitiveKeyColumn) {
                        		    	
                        		    		JavaType javaType = JavaTypesManager.getJavaTypeFromName(typeToGenerate);
                        		    		String nullableType = JavaTypesManager.getTypeToGenerate(javaType.getId(), true);
	                        		    	
    stringBuffer.append(TEXT_97);
    stringBuffer.append( tableName );
    stringBuffer.append(TEXT_17);
    stringBuffer.append( aKeysNames[iKeyName] );
    stringBuffer.append(TEXT_18);
    stringBuffer.append( aKeysValues[iKeyName] );
    stringBuffer.append(TEXT_98);
    stringBuffer.append( tableName );
    stringBuffer.append(TEXT_17);
    stringBuffer.append( aKeysNames[iKeyName] );
    stringBuffer.append(TEXT_99);
    stringBuffer.append( uniqueNameComponent);
    stringBuffer.append(TEXT_100);
    stringBuffer.append( tableName );
    stringBuffer.append(TEXT_101);
    stringBuffer.append( aKeysNames[iKeyName] );
    stringBuffer.append(TEXT_102);
    stringBuffer.append( typeToGenerate );
    stringBuffer.append(TEXT_24);
    stringBuffer.append( nullableType );
    stringBuffer.append(TEXT_103);
    stringBuffer.append(componentNameForKeyProblem);
    stringBuffer.append(TEXT_32);
    stringBuffer.append(currentJoinedTableIndex);
    stringBuffer.append(TEXT_104);
    stringBuffer.append( tableName );
    stringBuffer.append(TEXT_17);
    stringBuffer.append( aKeysNames[iKeyName] );
    stringBuffer.append(TEXT_105);
    
                        		    	} else {
                        		    		if("java.util.Date".equals(typeToGenerate)) {
    stringBuffer.append(TEXT_106);
    stringBuffer.append( tableName );
    stringBuffer.append(TEXT_101);
    stringBuffer.append( aKeysNames[iKeyName] );
    stringBuffer.append(TEXT_83);
    stringBuffer.append(componentNameForKeyProblem);
    stringBuffer.append(TEXT_32);
    stringBuffer.append(currentJoinedTableIndex);
    stringBuffer.append(TEXT_104);
    stringBuffer.append( tableName );
    stringBuffer.append(TEXT_17);
    stringBuffer.append( aKeysNames[iKeyName] );
    stringBuffer.append(TEXT_107);
    stringBuffer.append(componentNameForKeyProblem);
    stringBuffer.append(TEXT_32);
    stringBuffer.append(currentJoinedTableIndex);
    stringBuffer.append(TEXT_104);
    stringBuffer.append( tableName );
    stringBuffer.append(TEXT_17);
    stringBuffer.append( aKeysNames[iKeyName] );
    stringBuffer.append(TEXT_108);
    
                    		    		    }else {
	                        		    	
    stringBuffer.append(TEXT_109);
    stringBuffer.append( tableName );
    stringBuffer.append(TEXT_101);
    stringBuffer.append( aKeysNames[iKeyName] );
    stringBuffer.append(TEXT_83);
    stringBuffer.append(componentNameForKeyProblem);
    stringBuffer.append(TEXT_32);
    stringBuffer.append(currentJoinedTableIndex);
    stringBuffer.append(TEXT_104);
    stringBuffer.append( tableName );
    stringBuffer.append(TEXT_17);
    stringBuffer.append( aKeysNames[iKeyName] );
    stringBuffer.append(TEXT_110);
    
                        		    	    }
                        		    	}

                        		    } else {
                        		    
                        		    	if(javaPrimitiveKeyColumn) {
                        		    	
                        		    		JavaType javaType = JavaTypesManager.getJavaTypeFromName(typeToGenerate);
                        		    		String nullableType = JavaTypesManager.getTypeToGenerate(javaType.getId(), true);
	                        		    	
    stringBuffer.append(TEXT_97);
    stringBuffer.append( tableName );
    stringBuffer.append(TEXT_17);
    stringBuffer.append( aKeysNames[iKeyName] );
    stringBuffer.append(TEXT_18);
    stringBuffer.append( aKeysValues[iKeyName] );
    stringBuffer.append(TEXT_98);
    stringBuffer.append( tableName );
    stringBuffer.append(TEXT_17);
    stringBuffer.append( aKeysNames[iKeyName] );
    stringBuffer.append(TEXT_99);
    stringBuffer.append( uniqueNameComponent);
    stringBuffer.append(TEXT_111);
    stringBuffer.append( tableName );
    stringBuffer.append(TEXT_101);
    stringBuffer.append( aKeysNames[iKeyName] );
    stringBuffer.append(TEXT_102);
    stringBuffer.append( typeToGenerate );
    stringBuffer.append(TEXT_24);
    stringBuffer.append( nullableType );
    stringBuffer.append(TEXT_25);
    stringBuffer.append( tableName );
    stringBuffer.append(TEXT_17);
    stringBuffer.append( aKeysNames[iKeyName] );
    stringBuffer.append(TEXT_105);
    
                        		    	} else {
                        		    		if("java.util.Date".equals(typeToGenerate)) {
    stringBuffer.append(TEXT_109);
    stringBuffer.append( tableName );
    stringBuffer.append(TEXT_101);
    stringBuffer.append( aKeysNames[iKeyName] );
    stringBuffer.append(TEXT_18);
    stringBuffer.append( aKeysValues[iKeyName] );
    stringBuffer.append(TEXT_112);
    stringBuffer.append( aKeysValues[iKeyName] );
    stringBuffer.append(TEXT_113);
    
                        		    		}else {
	                        		    	
    stringBuffer.append(TEXT_109);
    stringBuffer.append( tableName );
    stringBuffer.append(TEXT_101);
    stringBuffer.append( aKeysNames[iKeyName] );
    stringBuffer.append(TEXT_18);
    stringBuffer.append( aKeysValues[iKeyName] );
    stringBuffer.append(TEXT_110);
    
                        		    		}
                        		    	}
                        		    }
                        		    if (checkingSyntax) {
                        		    	
    stringBuffer.append(TEXT_114);
    stringBuffer.append( CodeGenerationUtils.buildJavaEndFieldKey(key) );
    stringBuffer.append(TEXT_114);
    
                        		    }
                        		}


                        		} // T 001
                        		
    stringBuffer.append(TEXT_115);
     
                        		if(!isPersistentSortedTable && aKeysValues.length > 0) { // T 002
                        		
    stringBuffer.append(TEXT_116);
    stringBuffer.append(tableName);
    stringBuffer.append(TEXT_117);
    
                        		} // T 002
                        		
    stringBuffer.append(TEXT_118);
    
	  							if(hasPrimitiveKey) { // T_TM_M_171
	  							
    stringBuffer.append(TEXT_119);
    stringBuffer.append( uniqueNameComponent);
    stringBuffer.append(TEXT_120);
    
			  					} // T_TM_M_171
			  					
    stringBuffer.append(TEXT_121);
    
			  					INode lookupSubProcessStartNode = searchSubProcessStartNode(connection);
			  					String lookupSubProcessStartNodeName = lookupSubProcessStartNode.getUniqueName();
								
								if(isOneOfReloadLookupMode) { // T_TM_M_354
									if(isCacheOrReloadLookupMode) { // T_TM_M_355
									
    stringBuffer.append(TEXT_122);
    stringBuffer.append( tableName );
    stringBuffer.append(TEXT_123);
    stringBuffer.append( tableName );
    stringBuffer.append(TEXT_124);
    stringBuffer.append( tableName );
    stringBuffer.append(TEXT_125);
    stringBuffer.append( tableName );
    stringBuffer.append(TEXT_126);
    stringBuffer.append( tableName );
    stringBuffer.append(TEXT_127);
    
									}
									
									List<ExternalMapperTableEntry> globalMapEntries = externalTable.getGlobalMapKeysValues();
									if(globalMapEntries != null) {
										for(ExternalMapperTableEntry entry : globalMapEntries) {
										
    stringBuffer.append(TEXT_128);
    stringBuffer.append( entry.getName());
    stringBuffer.append(TEXT_129);
    stringBuffer.append( entry.getExpression() );
    stringBuffer.append(TEXT_130);
    
										}
									}
									
    stringBuffer.append(TEXT_131);
    stringBuffer.append( lookupSubProcessStartNodeName );
    stringBuffer.append(TEXT_132);
    
								    
								    boolean isAllRows = "ALL_ROWS".equals(externalTable.getMatchingMode());
								    
								    if(externalTable.isPersistent()) {
								    
    stringBuffer.append(TEXT_133);
    stringBuffer.append(tableName);
    stringBuffer.append(TEXT_134);
    stringBuffer.append( isAllRows ? "" : "Sorted" );
    stringBuffer.append(TEXT_135);
    stringBuffer.append(tableName);
    stringBuffer.append(TEXT_136);
    stringBuffer.append( isAllRows ? "" : "Sorted" );
    stringBuffer.append(TEXT_135);
    stringBuffer.append(tableName);
    stringBuffer.append(TEXT_137);
    stringBuffer.append(tableName);
    stringBuffer.append(TEXT_138);
    
								    } else {
								    
    stringBuffer.append(TEXT_133);
    stringBuffer.append(tableName);
    stringBuffer.append(TEXT_139);
    stringBuffer.append(tableName);
    stringBuffer.append(TEXT_140);
    stringBuffer.append(tableName);
    stringBuffer.append(TEXT_141);
    stringBuffer.append(tableName);
    stringBuffer.append(TEXT_138);
    
								    }
								    
    stringBuffer.append(TEXT_142);
    stringBuffer.append( tableName );
    stringBuffer.append(TEXT_143);
    stringBuffer.append( tableName );
    stringBuffer.append(TEXT_123);
    stringBuffer.append( tableName );
    stringBuffer.append(TEXT_144);
    	
									if(isCacheOrReloadLookupMode) { // T_TM_M_359
									
    stringBuffer.append(TEXT_145);
    	
									} // T_TM_M_359
									
    stringBuffer.append(TEXT_146);
    
								} // T_TM_M_354
								else { // T_TM_M_357
								
    stringBuffer.append(TEXT_147);
    stringBuffer.append( tableName );
    stringBuffer.append(TEXT_123);
    stringBuffer.append( tableName );
    stringBuffer.append(TEXT_148);
    
	  							}
	  							
    stringBuffer.append(TEXT_149);
    
	  							if(hasPrimitiveKey) { // T_TM_M_172
	  							
    stringBuffer.append(TEXT_150);
    
			  					} // T_TM_M_171
			  					
    stringBuffer.append(TEXT_151);
    
  								if(externalTable.isInnerJoin() || isMultipleResultMode) {
  								
    stringBuffer.append(TEXT_152);
    stringBuffer.append( hasPrimitiveKey ? "hasCasePrimitiveKeyWithNull_" + uniqueNameComponent + " || " : "" );
    stringBuffer.append(TEXT_153);
    stringBuffer.append( tableName );
    stringBuffer.append(TEXT_154);
    
								}
								
    stringBuffer.append(TEXT_155);
    
	  								if(externalTable.isInnerJoin()) {
	  								
    stringBuffer.append(TEXT_156);
    stringBuffer.append( rejectedInnerJoin );
    stringBuffer.append(TEXT_157);
    
  									}
  									
    stringBuffer.append(TEXT_158);
    if(isMultipleResultMode) { // T 56 
    stringBuffer.append(TEXT_159);
    stringBuffer.append( tableName );
    stringBuffer.append(TEXT_160);
     } // T 56 
    stringBuffer.append(TEXT_161);
    
  								if(externalTable.isInnerJoin() || isMultipleResultMode) {
  								
    stringBuffer.append(TEXT_162);
    
								}
								
    stringBuffer.append(TEXT_163);
    
							if(isMultipleResultMode) { // T 57 
							
    stringBuffer.append(TEXT_164);
    stringBuffer.append( tableName );
    stringBuffer.append(TEXT_165);
    
							} // T 57

							if(!isPersistentSortedTable && ("UNIQUE_MATCH").equals(matchingMode)) { // T 52 
							
    stringBuffer.append(TEXT_166);
    stringBuffer.append( tableName );
    stringBuffer.append(TEXT_167);
    stringBuffer.append( tableName );
    stringBuffer.append(TEXT_168);
    stringBuffer.append( tableName );
    stringBuffer.append(TEXT_169);
    
			  						StringBuilder sbMoreOneResult = new StringBuilder("\"WARNING: UNIQUE MATCH is configured for the lookup '"+ tableName +"' and it contains more one result from keys : ");
			  						for(int iKeys = 0; iKeys < aKeysNames.length; iKeys++) {
			  							if(iKeys > 0) {
					  						sbMoreOneResult.append(",");
			  						 	}
				  						sbMoreOneResult.append( " " + tableName + "."+ aKeysNames[iKeys] + " = '\" + " + tableName + "HashKey."+ aKeysNames[iKeys] + " + \"'");
									}
			  						sbMoreOneResult.append( "\"");
									
    stringBuffer.append(TEXT_170);
    stringBuffer.append( sbMoreOneResult.toString());
    stringBuffer.append(TEXT_171);
     
							} // T 52 
							
    stringBuffer.append(TEXT_172);
    stringBuffer.append( tableName );
    stringBuffer.append(TEXT_66);
    stringBuffer.append( tableName );
    stringBuffer.append(TEXT_173);
    
							if(isMultipleResultMode) { // T 60
							// the condition "tHash_Lookup_tableName != null" is for "reload at each row" mode, in this mode tHash_Lookup_tableName can't be initialized
							
    stringBuffer.append(TEXT_174);
    stringBuffer.append( tableName );
    stringBuffer.append(TEXT_167);
    stringBuffer.append( tableName );
    stringBuffer.append(TEXT_175);
    stringBuffer.append( tableName );
    stringBuffer.append(TEXT_176);
    
								if(!hasPersistentLookup || isLastPersistentSortedTable || lastPersistentSortedTableIsAlreadyProcessed || (isVirtualOut && hasPersistentLookup && !isPersistentSortedTable)) {
									
    stringBuffer.append(TEXT_74);
    stringBuffer.append(tableName );
    stringBuffer.append(TEXT_75);
    
									gm.addBlocksCodeToClose(new BlockCode("close loop of lookup '" + tableName +"' // G_TM_M_043"));
								}
								
    stringBuffer.append(TEXT_177);
     } // T 60 
    stringBuffer.append(TEXT_178);
    stringBuffer.append( tableName );
    stringBuffer.append(TEXT_179);
    stringBuffer.append( tableName );
    stringBuffer.append(TEXT_180);
    stringBuffer.append( tableName );
    stringBuffer.append(TEXT_18);
    stringBuffer.append( tableName );
    stringBuffer.append(TEXT_181);
     
							if (isMultipleResultMode) { // T 69 
							
    stringBuffer.append(TEXT_182);
    stringBuffer.append( tableName );
    stringBuffer.append(TEXT_183);
    
							} // T 69
		                    
    stringBuffer.append(TEXT_184);
    
							if (!isMultipleResultMode) { // T 600
                    		
    stringBuffer.append(TEXT_185);
    stringBuffer.append( tableName );
    stringBuffer.append(TEXT_186);
    stringBuffer.append( tableName );
    stringBuffer.append(TEXT_187);
    
							} // T 600
                    		
    stringBuffer.append(TEXT_188);
    stringBuffer.append( tableName );
    stringBuffer.append(TEXT_189);
    stringBuffer.append( tableName );
    stringBuffer.append(TEXT_190);
    
							if (!isMultipleResultMode) { // T 601
							
    stringBuffer.append(TEXT_191);
    
							} // T 601
							
    stringBuffer.append(TEXT_192);
    stringBuffer.append( tableName );
    stringBuffer.append(TEXT_193);
    stringBuffer.append( tableName );
    stringBuffer.append(TEXT_194);
    stringBuffer.append( tableName );
    stringBuffer.append(TEXT_195);
    	
							if(isCacheOrReloadLookupMode) { // T_TM_M_360
							
    stringBuffer.append(TEXT_196);
    stringBuffer.append(tableName);
    stringBuffer.append(TEXT_197);
    stringBuffer.append( tableName );
    stringBuffer.append(TEXT_198);
    stringBuffer.append(tableName);
    stringBuffer.append(TEXT_199);
    stringBuffer.append( tableName );
    stringBuffer.append(TEXT_200);
    	
							} // T_TM_M_360
							
    stringBuffer.append(TEXT_201);
    
							if(
								externalTable.isActivateExpressionFilter() 
								&& externalTable.getExpressionFilter() != null 
								&& !("").equals(externalTable.getExpressionFilter().trim())
							) { // T 012 
                    		  	  	   		
								String key = CodeGenerationUtils.buildProblemKey(componentNameForKeyProblem,
								JavaGenerationManager.PROBLEM_KEY_FIELD.FILTER.toString(), tableName);
								
    stringBuffer.append(TEXT_202);
    stringBuffer.append( rejectedInnerJoin );
    stringBuffer.append(TEXT_203);
    stringBuffer.append( checkingSyntax ? CodeGenerationUtils.buildJavaStartFieldKey(key) : "" );
    stringBuffer.append(TEXT_204);
    // keep this line to allow comments in filter 
    stringBuffer.append(TEXT_205);
    stringBuffer.append( externalTable.getExpressionFilter());
    stringBuffer.append(TEXT_205);
    // keep this line to allow comments in filter 
    stringBuffer.append(TEXT_206);
    stringBuffer.append( checkingSyntax ? CodeGenerationUtils.buildJavaEndFieldKey(key) : "" );
    stringBuffer.append(TEXT_207);
    stringBuffer.append( tableName );
    stringBuffer.append(TEXT_208);
    stringBuffer.append( tableName );
    stringBuffer.append(TEXT_18);
    stringBuffer.append( tableName );
    stringBuffer.append(TEXT_209);
    
									if(externalTable.isInnerJoin()) { // G 058
									
    stringBuffer.append(TEXT_210);
    stringBuffer.append( rejectedInnerJoin );
    stringBuffer.append(TEXT_211);
    
									} // G 058
									
    stringBuffer.append(TEXT_212);
    
								if(aKeysValues.length == 0){ // T 081
								
    stringBuffer.append(TEXT_213);
    stringBuffer.append( tableName );
    stringBuffer.append(TEXT_214);
    stringBuffer.append( rejectedInnerJoin );
    stringBuffer.append(TEXT_215);
    
								} // T 081
								
    stringBuffer.append(TEXT_216);
    
							} // T 012
							
    stringBuffer.append(TEXT_217);
    
		                    if(isMultipleResultMode) { // T 70 
		                    
    stringBuffer.append(TEXT_218);
    stringBuffer.append( tableName );
    stringBuffer.append(TEXT_219);
    
							} // T 70


              				if(!isLastTable) { // T_TM_M_218 

								if(!isLastTable && nextInputTable != null && nextInputTable.isPersistent() && !"ALL_ROWS".equals(nextInputTable.getMatchingMode())) { // T_TM_M_216
									nextLookupColumnsKeys.clear();
            						String nextTableName = nextInputTable.getName();

            						IConnection nextConnection = hNameToConnection.get(nextTableName);
	            
            						IMetadataTable nextMetadataTable = nextConnection.getMetadataTable();
            						if (nextInputTable != null) { // T_TM_M_215
	                				hExternalInputTableEntries.clear();
                					List<ExternalMapperTableEntry> nextMetadataTableEntries = nextInputTable.getMetadataTableEntries();
                					if (nextMetadataTableEntries == null) {
	                    				continue;
                					}
                					nextLookupName = nextInputTable.getName();
                					for (ExternalMapperTableEntry externalTableEntry : nextMetadataTableEntries) {
	                    				hExternalInputTableEntries.put(externalTableEntry.getName(), externalTableEntry);
                					}
	                	
    				            	List<IMetadataColumn> nextListColumns = nextMetadataTable.getListColumns();
				                	for (IMetadataColumn column : nextListColumns) { // T_TM_M_214
	                    				String columnName = column.getLabel();
                    					ExternalMapperTableEntry externalInputTableEntry = hExternalInputTableEntries.get(columnName);
				                    	if (externalInputTableEntry != null) { // T_TM_M_213
	                        				String expressionKey = externalInputTableEntry.getExpression();
                        					if (expressionKey != null && !"".equals(expressionKey.trim())) { // T_TM_M_212
											
    stringBuffer.append(TEXT_220);
    stringBuffer.append( JavaTypesManager.getTypeToGenerate(column.getTalendType(), column.isNullable()) );
    stringBuffer.append(TEXT_16);
    stringBuffer.append( nextTableName );
    stringBuffer.append(TEXT_17);
    stringBuffer.append( column.getLabel() );
    stringBuffer.append(TEXT_18);
    stringBuffer.append( JavaTypesManager.getDefaultValueFromJavaIdType(externalInputTableEntry.getType(), externalInputTableEntry.isNullable()) );
    stringBuffer.append(TEXT_221);
    
											} // T_TM_M_212
                        				} // T_TM_M_213
                    				} // T_TM_M_214

                					
    stringBuffer.append(TEXT_222);
    stringBuffer.append( rejectedInnerJoin );
    stringBuffer.append(TEXT_223);
    

                					for (IMetadataColumn column : nextListColumns) { // T_TM_M_214
	                    				String columnName = column.getLabel();
                    					ExternalMapperTableEntry externalInputTableEntry = hExternalInputTableEntries.get(columnName);
                    					if (externalInputTableEntry != null) { // T_TM_M_213
	                        				String expressionKey = externalInputTableEntry.getExpression();
                        					if (expressionKey != null && !"".equals(expressionKey.trim())) { // T_TM_M_212
				                                String typeToGenerate = JavaTypesManager.getTypeToGenerate(column.getTalendType(), column.isNullable());
                                				boolean javaPrimitiveKeyColumn = JavaTypesManager.isJavaPrimitiveType(typeToGenerate);
                        						nextLookupColumnsKeys.add(column);
					            				String key = CodeGenerationUtils.buildProblemKey(componentNameForKeyProblem,
				                				JavaGenerationManager.PROBLEM_KEY_FIELD.METADATA_COLUMN.toString(), nextTableName, columnName);
            									if (checkingSyntax) {
    	        								
    stringBuffer.append(TEXT_224);
    stringBuffer.append( CodeGenerationUtils.buildJavaStartFieldKey(key) );
    stringBuffer.append(TEXT_225);
    
            									}
            									
            									expressionKey = getExpressionWithAutoConvertFunction(expressionKey, externalInputTableEntry, column, expressionParser, locationMap4Entry, locationMap4Column, autoConverterMap, enable_auto_convert_type);
                    	                        
				                       	    	if(javaPrimitiveKeyColumn) {
                       		    					JavaType javaType = JavaTypesManager.getJavaTypeFromName(typeToGenerate);
                       		    					String nullableType = JavaTypesManager.getTypeToGenerate(javaType.getId(), true);
                       		    					String defaultValue = JavaTypesManager.getDefaultValueFromJavaIdType(javaType.getId(), false);
                        		    				
    stringBuffer.append(TEXT_226);
    stringBuffer.append( nextTableName );
    stringBuffer.append(TEXT_17);
    stringBuffer.append( columnName );
    stringBuffer.append(TEXT_18);
    stringBuffer.append( expressionKey );
    stringBuffer.append(TEXT_227);
    stringBuffer.append( nextTableName );
    stringBuffer.append(TEXT_17);
    stringBuffer.append( columnName );
    stringBuffer.append(TEXT_228);
    stringBuffer.append( uniqueNameComponent);
    stringBuffer.append(TEXT_229);
    stringBuffer.append( nextTableName );
    stringBuffer.append(TEXT_17);
    stringBuffer.append( column.getLabel() );
    stringBuffer.append(TEXT_23);
    stringBuffer.append( typeToGenerate );
    stringBuffer.append(TEXT_24);
    stringBuffer.append( nullableType );
    stringBuffer.append(TEXT_25);
    stringBuffer.append( nextTableName );
    stringBuffer.append(TEXT_17);
    stringBuffer.append( columnName );
    stringBuffer.append(TEXT_230);
    
                       		    				} else {
						            				
    stringBuffer.append(TEXT_231);
    stringBuffer.append( nextTableName );
    stringBuffer.append(TEXT_17);
    stringBuffer.append( column.getLabel() );
    stringBuffer.append(TEXT_18);
    stringBuffer.append( expressionKey );
    stringBuffer.append(TEXT_232);
    
                       		    				}

            									if (checkingSyntax) {
                								
    stringBuffer.append(TEXT_233);
    stringBuffer.append( CodeGenerationUtils.buildJavaEndFieldKey(key) );
    stringBuffer.append(TEXT_234);
    
            									}
											} // T_TM_M_212
				                        } // T_TM_M_213
                    				} // T_TM_M_214
                    
			                    	
    stringBuffer.append(TEXT_235);
    
                    
								} // T_TM_M_215

				           		cumulatedInputConnections.add(connection);

								
    stringBuffer.append(TEXT_236);
    stringBuffer.append(componentNameForKeyProblem);
    stringBuffer.append(TEXT_32);
    stringBuffer.append(nextJoinedTableIndex);
    stringBuffer.append(TEXT_58);
    stringBuffer.append(componentNameForKeyProblem);
    stringBuffer.append(TEXT_32);
    stringBuffer.append(nextJoinedTableIndex);
    stringBuffer.append(TEXT_237);
    stringBuffer.append(componentNameForKeyProblem);
    stringBuffer.append(TEXT_32);
    stringBuffer.append(nextJoinedTableIndex);
    stringBuffer.append(TEXT_238);
    stringBuffer.append(componentNameForKeyProblem);
    stringBuffer.append(TEXT_32);
    stringBuffer.append(nextJoinedTableIndex);
    stringBuffer.append(TEXT_36);
    

						    	    String comma = "";
			         				for(IConnection aConnection : cumulatedInputConnections) {
						        		
    stringBuffer.append(comma);
    stringBuffer.append(TEXT_81);
    stringBuffer.append( aConnection.getName() );
    
			         					comma = ", ";
		         					}
                    				int sizeNextColumns = nextLookupColumnsKeys.size();
                    				for (int iColumn = 0; iColumn < sizeNextColumns; iColumn++) { // T_TM_M_105
	                    				IMetadataColumn column = nextLookupColumnsKeys.get(iColumn);
	
					         			
    stringBuffer.append(comma);
    stringBuffer.append(TEXT_16);
    stringBuffer.append( nextInputTable.getName() );
    stringBuffer.append(TEXT_17);
    stringBuffer.append(column.getLabel() );
    
	                    
            			        	} // T_TM_M_105
					
								
    stringBuffer.append(TEXT_239);
    stringBuffer.append(componentNameForKeyProblem);
    stringBuffer.append(TEXT_32);
    stringBuffer.append(nextJoinedTableIndex);
    stringBuffer.append(TEXT_240);
    stringBuffer.append( rejectedInnerJoin );
    stringBuffer.append(TEXT_241);
    stringBuffer.append( rejectedInnerJoin );
    stringBuffer.append(TEXT_242);
    stringBuffer.append(componentNameForKeyProblem);
    stringBuffer.append(TEXT_32);
    stringBuffer.append(nextJoinedTableIndex);
    stringBuffer.append(TEXT_243);
    stringBuffer.append(componentNameForKeyProblem);
    stringBuffer.append(TEXT_32);
    stringBuffer.append(nextJoinedTableIndex);
    stringBuffer.append(TEXT_244);
    


					} // T_TM_M_216
					else { // T_TM_M_217  
			
						cumulatedInputConnections.add(connection);
			
					} // T_TM_M_217
			
                	if(hasPersistentLookup && !isLastPersistentSortedTable && isMultipleResultMode 
                		&& !(isVirtualOut && hasPersistentLookup && !isPersistentSortedTable)
                		&& !(isVirtualIn && hasPersistentLookup && !isPersistentSortedTable)
                		) { // T_TM_M_247
					
    stringBuffer.append(TEXT_245);
    stringBuffer.append( tableName );
    stringBuffer.append(TEXT_246);
    stringBuffer.append( tableName );
    stringBuffer.append(TEXT_247);
    
					} // T_TM_M_247
					else if(isVirtualIn && !isPersistentSortedTable && externalTable.isPersistent()) { // T_TM_M_259
					
						closeAllRowsBlockCount.add(tableName);
					
					} // T_TM_M_259
	    		
                	if(!isLastTableForTMAP_OUT && !isLastTable && nextTableIsPersistentSorted) { // T_TM_M_248
                	
                		if(isVirtualIn && nextTableIsPersistentSorted) {
							int sizeCloseAllRowsBlocks = closeAllRowsBlockCount.size();
                			for(int iCloseBlockAllRows = 0; iCloseBlockAllRows < sizeCloseAllRowsBlocks; iCloseBlockAllRows++) {
                				String lookupName = closeAllRowsBlockCount.get(iCloseBlockAllRows);
							
    stringBuffer.append(TEXT_248);
    stringBuffer.append( lookupName );
    stringBuffer.append(TEXT_249);
    
                				
                			}
                			closeAllRowsBlockCount.clear();
                		}
                	
					
    stringBuffer.append(TEXT_250);
    stringBuffer.append( previousJoinedTablesPersistentSortedDelimited );
    stringBuffer.append(TEXT_251);
    
	            	
	            	} // T_TM_M_248
	            	
    stringBuffer.append(TEXT_252);
    
	            } // T_TM_M_218
	            
    stringBuffer.append(TEXT_253);
    
				} // T_TM_M_296
				 else { // T_TM_M_297  
				
					cumulatedInputConnections.add(connection);
				
				} // T_TM_M_297

				
       		    if(!isVirtualOut 
       		    	&& !isLastTable 
       		    	&& nextTableIsPersistentSorted 
       		    	&& (isFirstPersistentSortedTable || previousStateIsFirstPersistentSortedTable == true)
       		    ) { // T_TM_M_299
				
    stringBuffer.append(TEXT_254);
    stringBuffer.append(componentNameForKeyProblem);
    stringBuffer.append(TEXT_32);
    stringBuffer.append(previousJoinedTablesPersistentSortedDelimited);
    stringBuffer.append(TEXT_255);
    
				} // T_TM_M_299
	    	        	
				
				
                if(!isVirtualOut && !isLastTable && nextInputTable != null && nextInputTable.isPersistent()) { // T_TM_M_238
                
    stringBuffer.append(TEXT_256);
    stringBuffer.append(componentNameForKeyProblem);
    stringBuffer.append(TEXT_32);
    stringBuffer.append(nextJoinedTableIndex);
    stringBuffer.append(TEXT_257);
    
				} // T_TM_M_238


				if(isFirstPersistentSortedTable == true && previousStateIsFirstPersistentSortedTable == false) { // T_TM_M_219
					previousStateIsFirstPersistentSortedTable = true;
					isFirstPersistentSortedTable = false;
				} // T_TM_M_219

				if(isLastPersistentSortedTable) {
					lastPersistentSortedTableIsAlreadyProcessed = true;
				}

				currentJoinedTableIndex = nextJoinedTableIndex;
				
				//System.out.println("currentJoinedTableIndex=" + currentJoinedTableIndex);

            	previousTableName = tableName;

                } // T_TM_M_250

            } // T_TM_M_249
            
            previousTableIsMultipleResultMode = isMultipleResultMode; 
            previousTableIsPersistentSorted = isPersistentSortedTable;
            
        } // for (ExternalMapperTable externalTable : inputTables) {  // T_TM_M_261
        boolean atLeastOneInputTableWithInnerJoin = !inputTablesWithInnerJoin.isEmpty();

            if (!dieonerror) {
			    if(gm.getBlocksCodeToClose()!=null && gm.getBlocksCodeToClose().size()>0){
            
    stringBuffer.append(TEXT_258);
    
			    }else{
				    stringBuffer.insert(tryOffset,"try {");
				}
            } // close dieonerror if check


        
    stringBuffer.append(TEXT_259);
    

        // /////////////////////////////////////////////////////////////////////////////////////////////////////
        // /////////////////////////////////////////////////////////////////////////////////////////////////////

if(!isVirtualOut) { // T_TM_M_320
	
        // /////////////////////////////////////////////////////////////////////////////////////////////////////
        // /////////////////////////////////////////////////////////////////////////////////////////////////////
        // VARIABLES
        // 
        
        
    stringBuffer.append(TEXT_260);
    
        
        for (ExternalMapperTable varsTable : varsTables) {
            List<ExternalMapperTableEntry> varsTableEntries = varsTable.getMetadataTableEntries();
            if (varsTableEntries == null) {
                continue;
            }
            String varsTableName = varsTable.getName();
            String instanceVarName = varsTableName + "__" + uniqueNameComponent;
            String className = instanceVarName + "__Struct";

            
    stringBuffer.append( cr + className + " " + varsTableName + " = " + instanceVarName + ";" );
    
            
            for (ExternalMapperTableEntry varsTableEntry : varsTableEntries) {
                String varsColumnName = varsTableEntry.getName();
                String varExpression = varsTableEntry.getExpression();
                if (varExpression == null || varExpression.trim().length() == 0) {
                    varExpression = JavaTypesManager.getDefaultValueFromJavaIdType(varsTableEntry.getType(),
                            varsTableEntry.isNullable());
                } else {
                	varExpression = getExpressionWithAutoConvertFunction(varExpression, varsTableEntry, null, expressionParser, locationMap4Entry, locationMap4Column, autoConverterMap, enable_auto_convert_type);
                }
                
                //TODO : remove the code below as it's never be used.
                TableEntryLocation[] entryLocations = expressionParser.parseTableEntryLocations(varExpression);
                ArrayList<TableEntryLocation> listCoupleForAddTablePrefix = new ArrayList<TableEntryLocation>();
                for (TableEntryLocation location : entryLocations) {
                    if (gm.isInputTable(varExpression)) {
                        listCoupleForAddTablePrefix.add(location);
                    }
                }

                String key = CodeGenerationUtils.buildProblemKey(componentNameForKeyProblem,
                        JavaGenerationManager.PROBLEM_KEY_FIELD.METADATA_COLUMN.toString(), varsTableName,
                        varsColumnName);

                if (checkingSyntax) {
                    
    stringBuffer.append( cr  + CodeGenerationUtils.buildJavaStartFieldKey(key) );
    
                }
                
                
    stringBuffer.append( cr + gm.getGeneratedCodeTableColumnVariable(uniqueNameComponent, varsTableName, varsColumnName, false) + " = " + varExpression
                        + ";" );
    

                if (checkingSyntax) {
                    
    stringBuffer.append( cr + CodeGenerationUtils.buildJavaEndFieldKey(key));
    
                }

            }
        }
        
        
    stringBuffer.append(TEXT_259);
    
        
        // /////////////////////////////////////////////////////////////////////////////////////////////////////
        // /////////////////////////////////////////////////////////////////////////////////////////////////////

        // /////////////////////////////////////////////////////////////////////////////////////////////////////
        // /////////////////////////////////////////////////////////////////////////////////////////////////////
        // OUTPUTS
        // 
        
        
    stringBuffer.append(TEXT_261);
    

		StringBuilder sb = new StringBuilder();

        ArrayList<ExternalMapperTable> outputTablesSortedByReject = new ArrayList<ExternalMapperTable>(outputTables);
        // sorting outputs : rejects tables after not rejects table
        Collections.sort(outputTablesSortedByReject, new Comparator<ExternalMapperTable>() {

            public int compare(ExternalMapperTable o1, ExternalMapperTable o2) {
                if (o1.isReject() != o2.isReject()) {
                    if (o1.isReject()) {
                        return 1;
                    } else {
                        return -1;
                    }
                }
                if (o1.isRejectInnerJoin() != o2.isRejectInnerJoin()) {
                    if (o1.isRejectInnerJoin()) {
                        return 1;
                    } else {
                        return -1;
                    }
                }
                return 0;
            }

        });

        boolean lastValueReject = false;
        boolean oneFilterForNotRejectTable = false;
        boolean allNotRejectTablesHaveFilter = true;
        boolean atLeastOneReject = false;
        boolean atLeastOneRejectInnerJoin = false;
        boolean closeTestInnerJoinConditionsBracket = false;

        Map<String, IConnection> nameToOutputConnection = new HashMap<String, IConnection>();
        for (IConnection outputConnection : outputConnections) {
            nameToOutputConnection.put(outputConnection.getName(), outputConnection);
        }

        int lstSizeOutputs = outputTablesSortedByReject.size();
        // ///////////////////////////////////////////////////////////////////
        // init of allNotRejectTablesHaveFilter and atLeastOneReject
        String lastValidOutputTableName = null;
        for (int i = 0; i < lstSizeOutputs; i++) {
            ExternalMapperTable outputTable = (ExternalMapperTable) outputTablesSortedByReject.get(i);

            String outputTableName = outputTable.getName();

            if (outputTable.isRejectInnerJoin()) {
                atLeastOneRejectInnerJoin = true;
            }
            List<ExternalMapperTableEntry> columnsEntries = outputTable.getMetadataTableEntries();
            List<ExternalMapperTableEntry> filters = outputTable.getConstraintTableEntries();
            boolean hasFilter = filters != null && filters.size() > 0 && !gm.checkFiltersAreEmpty(outputTable) 
            	|| outputTable.isActivateExpressionFilter() && outputTable.getExpressionFilter() != null && !("").equals(outputTable.getExpressionFilter().trim());
            if (columnsEntries != null && columnsEntries.size() > 0) {
                if (!hasFilter && !(outputTable.isReject() || outputTable.isRejectInnerJoin())) {
                    if(!outputTable.isErrorRejectTable()){
                    	allNotRejectTablesHaveFilter = false;
                    }
                }
                if (outputTable.isReject()) {
                    atLeastOneReject = true;
                }
            }
				IConnection outputConnection = nameToOutputConnection.get(outputTableName);
            if (outputTable.getIsJoinTableOf() == null /* == main table */ && !hasJoinedTable(outputTableName,data) /* if main table has no joined table linked */ ) {
            	if (outputConnection != null) {
                	sb.append(cr + outputTableName + " = null;");
            	}
                if(checkingSyntax 
                || !checkingSyntax && outputConnection != null) {
	            	lastValidOutputTableName = outputTableName;
	            }
			} else if(outputTable.getIsJoinTableOf() == null && hasJoinedTable(outputTableName,data) && outputConnection != null){
			
			    if (outputConnection != null) {
                	sb.append(cr + outputTableName + " = null;");
            	}
            	
				sb.append(cr + outputTableName + "_List.clear();");
			}else if(outputTable.getIsJoinTableOf() != null){
	            lastValidOutputTableName = outputTableName;
			}

        }
        // ///////////////////////////////////////////////////////////////////

		// System.out.println(uniqueNameComponent + " lastValidOutputTableName="+lastValidOutputTableName);

        sb.append(cr);

        if (allNotRejectTablesHaveFilter && atLeastOneReject) {
            // write rejected = false;
            sb.append(cr + "boolean " + rejected + " = true;");
        }

        // write conditions for inner join reject
        if (lastValidOutputTableName != null && hasValidLookupTables && lstSizeOutputs > 0 && atLeastOneInputTableWithInnerJoin) {
            sb.append(cr + "if(");
            sb.append("!" + rejectedInnerJoin);
            sb.append(" ) {");
            closeTestInnerJoinConditionsBracket = true;
        }

        // ///////////////////////////////////////////////////////////////////
        // run through output tables list for generating intilization of outputs arrays
        int dummyVarCounter = 0;
        int curCount = 0;
        for (int indexCurrentTable = 0; indexCurrentTable < lstSizeOutputs; indexCurrentTable++) {
            ExternalMapperTable outputTable = (ExternalMapperTable) outputTablesSortedByReject.get(indexCurrentTable);
            String joinedTableName = outputTable.getIsJoinTableOf();
            List<ExternalMapperTableEntry> outputTableEntries = outputTable.getMetadataTableEntries();
            String outputTableName = outputTable.getName();
            
            //add for feature:2445
            if (!dieonerror){
                if(outputTable.isErrorRejectTable()){
                	continue;
                }
            }
            
            boolean connectionExists = true;
            IConnection outputConnection =null;
            if(outputTable.getIsJoinTableOf()==null){
            	outputConnection = nameToOutputConnection.get(outputTableName);
            }else{
            	outputConnection = nameToOutputConnection.get(outputTable.getIsJoinTableOf());
            }
            HashedMetadataTable hashedMetadataTable = null;
            if (outputTableEntries == null || outputConnection == null) {
                connectionExists = false;
            } else {
            	hashedMetadataTable = new HashedMetadataTable(outputConnection.getMetadataTable());
            }

			// System.out.println("Output table: (1)" + outputTableName);

            List<ExternalMapperTableEntry> filters = outputTable.getConstraintTableEntries();

            boolean currentIsReject = outputTable.isReject();
            boolean currentIsRejectInnerJoin = outputTable.isRejectInnerJoin();

            boolean hasFilters = filters != null && filters.size() > 0 && !gm.checkFiltersAreEmpty(outputTable);
            boolean hasExpressionFilter = outputTable.isActivateExpressionFilter() && outputTable.getExpressionFilter() != null && !("").equals(outputTable.getExpressionFilter().trim());

            boolean rejectValueHasJustChanged = lastValueReject != (currentIsReject || currentIsRejectInnerJoin);

            oneFilterForNotRejectTable = !(currentIsReject || currentIsRejectInnerJoin) && (hasFilters || hasExpressionFilter);

            if (rejectValueHasJustChanged) {

                if (closeTestInnerJoinConditionsBracket) {
                    sb.append(cr + "} // closing inner join bracket (1)");
                    if (atLeastOneReject && allNotRejectTablesHaveFilter) {
                        sb.append(cr + " else {");
                        sb.append(cr + rejected + " = false;");
                        sb.append(cr + "} // closing else inner join bracket (1)");
                    }
                    closeTestInnerJoinConditionsBracket = false;
                }
            }

            // No connection matching and no checking errors
            if (connectionExists || checkingSyntax) {
	            if (rejectValueHasJustChanged) {
	                sb.append(cr + "// ###### START REJECTS ##### ");
	            }

	            // write filters conditions and code to execute
	            if (!currentIsReject && !currentIsRejectInnerJoin || rejectValueHasJustChanged
	                    && oneFilterForNotRejectTable || currentIsReject && allNotRejectTablesHaveFilter
	                    || currentIsRejectInnerJoin && atLeastOneInputTableWithInnerJoin || checkingSyntax) {

	                boolean closeFilterOrRejectBracket = false;
	                if (currentIsReject || currentIsRejectInnerJoin) {
	                    sb.append(cr + cr + "// # Output reject table : '" + outputTableName + "'");
	                } else {
	                    sb.append(cr + cr + "// # Output table : '" + outputTableName + "'");
	                }
	                if (hasFilters || hasExpressionFilter || currentIsReject || currentIsRejectInnerJoin && atLeastOneInputTableWithInnerJoin) {
	                    sb.append(cr + "// # Filter conditions ");
	
	                    String key = CodeGenerationUtils.buildProblemKey(componentNameForKeyProblem,
	                            JavaGenerationManager.PROBLEM_KEY_FIELD.FILTER.toString(), outputTableName, null);
	                    if (checkingSyntax) {
	                        sb.append("\n").append(CodeGenerationUtils.buildJavaStartFieldKey(key));
	                    }
	
	                    String ifConditions = "if( ";
	
	                    String rejectedTests = null;
	                    if (allNotRejectTablesHaveFilter && atLeastOneReject && currentIsReject && currentIsRejectInnerJoin
	                            && atLeastOneInputTableWithInnerJoin) {
	                        rejectedTests = rejected + " || " + rejectedInnerJoin;
	                        if (hasFilters || hasExpressionFilter) {
	                            rejectedTests = "(" + rejectedTests + ")";
	                        }
	                    } else if (allNotRejectTablesHaveFilter && atLeastOneReject && currentIsReject) {
	                        rejectedTests = rejected;
	                    } else if (currentIsRejectInnerJoin && atLeastOneInputTableWithInnerJoin) {
	                        rejectedTests = rejectedInnerJoin;
	                    }
	                    if (hasFilters && !hasExpressionFilter || hasExpressionFilter) {
	                        String filtersConditions = null;
	                        if(hasExpressionFilter) {
		                     	filtersConditions = outputTable.getExpressionFilter();
		                     } else {
		                        filtersConditions = gm.buildConditions(filters, expressionParser);
		                     }
	                        if (rejectedTests == null) {
	                            ifConditions += cr + cr + filtersConditions  + cr + cr;
	                        } else {
	                            ifConditions += rejectedTests + " && (" + cr + cr + filtersConditions + cr + cr +")";
	                        }
	                    } else {
	                        ifConditions += rejectedTests;
	                    }
	                    ifConditions += " ) {";
	
	                    sb.append(cr).append(ifConditions);
	
	                    if (checkingSyntax) {
	                        sb.append("\n").append(CodeGenerationUtils.buildJavaEndFieldKey(key));
	                    }
	
	                    closeFilterOrRejectBracket = true;
	                    if (allNotRejectTablesHaveFilter && !(currentIsReject || currentIsRejectInnerJoin)
	                            && atLeastOneReject) {
	                        sb.append(cr + rejected + " = false;");
	                    }
	                }

					if(outputTable.getIsJoinTableOf()!=null){
						sb.append(cr).append(outputTable.getIsJoinTableOf() + "_tmp= new "+outputTable.getIsJoinTableOf() +"Struct();");
						sb.append(cr);
					}
											
	                if (outputTableEntries != null && (!currentIsReject && !currentIsRejectInnerJoin || currentIsReject || currentIsRejectInnerJoin
	                        && atLeastOneInputTableWithInnerJoin || checkingSyntax)) {
						if(joinedTableName==null && isLog4jEnabled){
							sb.append(cr + "count_" + outputTableName + "_" + componentNameForKeyProblem + "++;" + cr);
						}
						boolean needAppendColumnLog = true;
	                    for (ExternalMapperTableEntry outputTableEntry : outputTableEntries) {
	                        String outputColumnName = outputTableEntry.getName();
	                        IMetadataColumn metadataColumnFromConn = null;
	                        if(connectionExists) {
		                        metadataColumnFromConn = hashedMetadataTable.getColumn(outputColumnName);
		                    }
	                        String outputExpression = outputTableEntry.getExpression();
	                        if (outputExpression == null || outputExpression.trim().length() == 0) {
	                        	needAppendColumnLog = false;
	                        	if(metadataColumnFromConn == null) {
		                            outputExpression = JavaTypesManager.getDefaultValueFromJavaIdType(outputTableEntry
	    	                                .getType(), outputTableEntry.isNullable());
	    	                    } else {
		                            outputExpression = JavaTypesManager.getDefaultValueFromJavaIdType(metadataColumnFromConn
	    	                                .getTalendType(), metadataColumnFromConn.isNullable());
	    	                    }
	                        } else {
	                        	outputExpression = getExpressionWithAutoConvertFunction(outputExpression, outputTableEntry, metadataColumnFromConn, expressionParser, locationMap4Entry, locationMap4Column, autoConverterMap, enable_auto_convert_type);
	                        	
	                        	if(metadataColumnFromConn == null) {
									continue;
								}
	                        }
	
	                        String key = CodeGenerationUtils.buildProblemKey(componentNameForKeyProblem,
	                                JavaGenerationManager.PROBLEM_KEY_FIELD.METADATA_COLUMN.toString(), outputTableName,
	                                outputColumnName);
	                        if (checkingSyntax) {
	                            sb.append("\n").append(CodeGenerationUtils.buildJavaStartFieldKey(key));
	                        }
	
	                        String assignationVar = null;
	                        if (connectionExists) {                       
	                        	if(outputTable.getIsJoinTableOf()==null){
	                        		assignationVar = gm.getGeneratedCodeTableColumnVariable(uniqueNameComponent, outputTableName + "_tmp",outputColumnName, false);
	                        	}else {
	                            	assignationVar =gm.getGeneratedCodeTableColumnVariable(uniqueNameComponent, outputTable.getIsJoinTableOf() + "_tmp",outputColumnName, false);
	                            }     
	                        } else {
	                        	if(metadataColumnFromConn == null) {
		                            assignationVar = JavaTypesManager.getTypeToGenerate(outputTableEntry.getType(),
	                                    outputTableEntry.isNullable())
	                                    + " dummyVar" + (dummyVarCounter++);
	                            } else {
		                            assignationVar = JavaTypesManager.getTypeToGenerate(metadataColumnFromConn
	    	                                .getTalendType(), metadataColumnFromConn.isNullable())
	                                    + " dummyVar" + (dummyVarCounter++);
	                            }
	                        }
	                        
    	                    String expression = assignationVar + " = " + outputExpression + ";";
	                        sb.append(cr).append(expression);
	                        
	                        if (checkingSyntax) {
	                            sb.append("\n").append(CodeGenerationUtils.buildJavaEndFieldKey(key));
	                        }
	                        needAppendColumnLog = true;
	                    } // for entries
						
	                    if (connectionExists) {
	                    	if(hasJoinedTable(outputTableName, data)){
	                    		sb.append(cr + outputTableName + "_List.add(" + outputTableName + "_tmp);");
	                       		sb.append(cr + outputTableName + " = " + outputTableName + "_tmp;");
	                    	} else if (outputTable.getIsJoinTableOf()!=null) {
	                    		sb.append(cr + outputTable.getIsJoinTableOf() + "_List.add(" + outputTable.getIsJoinTableOf() + "_tmp);");
	                    		sb.append(cr + outputTable.getIsJoinTableOf() + " = " + outputTable.getIsJoinTableOf() + "_tmp;");
	                    	} else {
	                        	sb.append(cr + outputTableName + " = " + outputTableName + "_tmp;");
	                        }
							
							if(isLog4jEnabled){
									sb.append(cr + "log.debug(\"" + componentNameForKeyProblem + " - Outputting the record \" + count_" + (joinedTableName!=null?joinedTableName:outputTableName) + "_" + componentNameForKeyProblem + " + \" of the output table '" + outputTableName + "'.\");" + cr);
							}
	                        
	                        if (trace) { // only for traces to be able to use preview mode in tMap.
       	                    	if(hasJoinedTable(outputTableName, data)){ 
      	                    		sb.append("\n").append("java.util.LinkedHashMap<String,String> runTraceData" + indexCurrentTable +"=new java.util.LinkedHashMap<String,String>();");
									sb.append("\n");    
	   	                    		for (ExternalMapperTableEntry outputTableEntry : outputTable.getMetadataTableEntries()) { 
  	                                	sb.append("runTraceData" + indexCurrentTable + ".put(\"" + outputTableEntry.getName() + "\", String.valueOf("+outputTableName + "_tmp." + outputTableEntry.getName() +"));");
  	                                	sb.append("\n");
       	                    		}

       	                         	sb.append(
       	                              	"runTrace.sendTrace(\""+ outputTableName + "[MAIN]" +"\",\""+ node.getUniqueName() + "\"," +
       	                              	"runTraceData" + indexCurrentTable + ");"
       	                          	);
		                    	}else if(outputTable.getIsJoinTableOf()!=null){
       	                    		sb.append("\n").append("java.util.LinkedHashMap<String,String> runTraceData" + indexCurrentTable +"=new java.util.LinkedHashMap<String,String>();");
									sb.append("\n");         	                              
      	                    		for(ExternalMapperTableEntry outputTableEntry : outputTable.getMetadataTableEntries()){ 
      	                    			sb.append("runTraceData" + indexCurrentTable + ".put(\"" + outputTableEntry.getName() + "\", String.valueOf("+ outputTable.getIsJoinTableOf() + "_tmp." + outputTableEntry.getName() +"));");
  	                                	sb.append("\n");
      	                    		}
        							sb.append(
             	                        "runTrace.sendTrace(\"" + outputTable.getIsJoinTableOf() + ":" + outputTableName + "\",\"" + node.getUniqueName() + "\"," +
                    					"runTraceData" + indexCurrentTable + ");"
						            );
	                    		}
	                        }
	                        
	                    }
	                    
	                    
	                    

	                }
	                if (closeFilterOrRejectBracket) {
	                    sb.append(cr + "} // closing filter/reject");
	                }
	
	            }
	            lastValueReject = currentIsReject || currentIsRejectInnerJoin;
	
	         }

			// System.out.println("Output table: (2)" + outputTableName);

            boolean isLastTable = indexCurrentTable == lstSizeOutputs - 1;
            if (closeTestInnerJoinConditionsBracket 
            	&& (isLastTable || !checkingSyntax && (outputTableName.equals(lastValidOutputTableName) || lastValidOutputTableName == null))) {
                sb.append(cr + "}  // closing inner join bracket (2)");
                closeTestInnerJoinConditionsBracket = false;
            }

        } // for output tables

        sb.append(cr + "// ###############################");

        
        sb.append(cr);
        sb.append(cr + "} // end of Var scope");



        sb.append(cr + cr + rejectedInnerJoin + " = false;");
        
        sb.append(cr);

/////////////////////////////////////////////////////////////////////////////////////////////////////////////////////



    stringBuffer.append(TEXT_47);
    stringBuffer.append( sb.toString());
    stringBuffer.append(TEXT_47);
    
} // T_TM_M_320
	if (!dieonerror) {

    stringBuffer.append(TEXT_262);
    if(isLog4jEnabled){
    stringBuffer.append(TEXT_263);
    stringBuffer.append(componentNameForKeyProblem);
    stringBuffer.append(TEXT_264);
    }
    stringBuffer.append(TEXT_265);
    
        
        for (ExternalMapperTable varsTable : varsTables) {
            List<ExternalMapperTableEntry> varsTableEntries = varsTable.getMetadataTableEntries();
            if (varsTableEntries == null) {
                continue;
            }
            String varsTableName = varsTable.getName();
            String instanceVarName = varsTableName + "__" + uniqueNameComponent;
            String className = instanceVarName + "__Struct";

            
    stringBuffer.append( cr + className + " " + varsTableName + " = " + instanceVarName + ";" );
    

        }
        
        
    stringBuffer.append(TEXT_47);
    
		    Map<String, IConnection> nameToOutputConnection = new HashMap<String, IConnection>();
		    for (IConnection outputConnection : outputConnections) {
		        nameToOutputConnection.put(outputConnection.getName(), outputConnection);
		    }
		                
            int dummyVarCounter = 0;
            for(ExternalMapperTable outputTable : outputTables){
            	
            	String outputTableName = outputTable.getName(); 
                
                //add for feature:2445
                if (!dieonerror){
                    if(!outputTable.isErrorRejectTable()){
                    	continue;
                    }
                }
                
                List<ExternalMapperTableEntry> outputTableEntries = outputTable.getMetadataTableEntries();
                
                boolean connectionExists = true;
                IConnection outputConnection =null;
                if(outputTable.getIsJoinTableOf()==null){
                	outputConnection = nameToOutputConnection.get(outputTableName);
                }else{
                	outputConnection = nameToOutputConnection.get(outputTable.getIsJoinTableOf());
                }
                HashedMetadataTable hashedMetadataTable = null;
                if (outputTableEntries == null || outputConnection == null) {
                    connectionExists = false;
                } else {
                	hashedMetadataTable = new HashedMetadataTable(outputConnection.getMetadataTable());
                }
                
                //exist the ErrorReject schema, but there doesn't exist the Reject output link
                if(!connectionExists){
                	continue;
                }
             
    stringBuffer.append(TEXT_266);
       

                StringBuilder sb = new StringBuilder();
                for (ExternalMapperTableEntry outputTableEntry : outputTableEntries) {
                    String outputColumnName = outputTableEntry.getName();
                    //System.out.println(outputColumnName);
                    if(outputColumnName.equals("errorMessage") || outputColumnName.equals("errorStackTrace")){
                    	continue;
                    }  
                    
                    IMetadataColumn metadataColumnFromConn = null;
                    if(connectionExists) {
                        metadataColumnFromConn = hashedMetadataTable.getColumn(outputColumnName);
                    }
                    
                    String outputExpression = outputTableEntry.getExpression();
                    if (outputExpression == null || outputExpression.trim().length() == 0) {
                    	if(metadataColumnFromConn == null) {
                            outputExpression = JavaTypesManager.getDefaultValueFromJavaIdType(outputTableEntry
                                    .getType(), outputTableEntry.isNullable());
                        } else {
                            outputExpression = JavaTypesManager.getDefaultValueFromJavaIdType(metadataColumnFromConn
                                    .getTalendType(), metadataColumnFromConn.isNullable());
                        }
                    } else {
                    	outputExpression = getExpressionWithAutoConvertFunction(outputExpression, outputTableEntry, metadataColumnFromConn, expressionParser, locationMap4Entry, locationMap4Column, autoConverterMap, enable_auto_convert_type);
                    	
                    	if(metadataColumnFromConn == null) {
            				continue;
            			}
                    }
					
                    String key = CodeGenerationUtils.buildProblemKey(componentNameForKeyProblem,
                            JavaGenerationManager.PROBLEM_KEY_FIELD.METADATA_COLUMN.toString(), outputTableName,
                            outputColumnName);
                    if (checkingSyntax) {
                        sb.append("\n").append(CodeGenerationUtils.buildJavaStartFieldKey(key));
                    }

                    String assignationVar = null;
                    if (connectionExists) {
                    	if(outputTable.getIsJoinTableOf()==null){
                    		assignationVar = gm.getGeneratedCodeTableColumnVariable(uniqueNameComponent, outputTableName + "_tmp",outputColumnName, false);
                    	}else {
                        	assignationVar =gm.getGeneratedCodeTableColumnVariable(uniqueNameComponent, outputTable.getIsJoinTableOf() + "_tmp",outputColumnName, false);
                        }     
                    } else {
                    	if(metadataColumnFromConn == null) {
                            assignationVar = JavaTypesManager.getTypeToGenerate(outputTableEntry.getType(),
                                outputTableEntry.isNullable())
                                + " dummyVar" + (dummyVarCounter++);
                        } else {
                            assignationVar = JavaTypesManager.getTypeToGenerate(metadataColumnFromConn
                                    .getTalendType(), metadataColumnFromConn.isNullable())
                                + " dummyVar" + (dummyVarCounter++);
                        }
                    }
                    
                    String expression = assignationVar + " = " + outputExpression + ";";
                    sb.append(cr).append(expression);
                    
                    if (checkingSyntax) {
                        sb.append("\n").append(CodeGenerationUtils.buildJavaEndFieldKey(key));
                    }
                } // for entries  

    stringBuffer.append(TEXT_267);
     stringBuffer.append(sb.toString()); 
    stringBuffer.append(TEXT_268);
    stringBuffer.append(outputTableName );
    stringBuffer.append(TEXT_18);
    stringBuffer.append(outputTableName );
    stringBuffer.append(TEXT_269);
    stringBuffer.append(TEXT_268);
    stringBuffer.append(outputTableName );
    stringBuffer.append(TEXT_270);
    stringBuffer.append(TEXT_268);
    stringBuffer.append(outputTableName );
    stringBuffer.append(TEXT_271);
        
            }
            
    stringBuffer.append(TEXT_272);
    
            //clear others branches.
            for(ExternalMapperTable outputTable : outputTables){//111
            	
            	String outputTableName = outputTable.getName(); 
                
                //add for feature:2445
                if (!dieonerror){
                    if(outputTable.isErrorRejectTable()){
                    	continue;
                    }
                }
                
                
                //only process the table with output link
                if (nameToOutputConnection.get(outputTableName)!=null) {//222
                	if(hasJoinedTable(outputTableName,data)){
                	
                	//feature:11884, in merge case, the mergedTable/mergingTable both clear.
				
    stringBuffer.append(TEXT_273);
    stringBuffer.append(outputTableName );
    stringBuffer.append(TEXT_274);
        
                	}else{
				
    stringBuffer.append(TEXT_275);
    stringBuffer.append(outputTableName );
    stringBuffer.append(TEXT_276);
    		
                	}
                }//222
				
        
            }//111
            
    stringBuffer.append(TEXT_277);
    if(isLog4jEnabled){
    stringBuffer.append(TEXT_278);
    stringBuffer.append(componentNameForKeyProblem);
    stringBuffer.append(TEXT_279);
    }
    stringBuffer.append(TEXT_280);
    
            //clear others branches.
            for(ExternalMapperTable outputTable : outputTables){//111
            	
            	String outputTableName = outputTable.getName(); 
                
                //add for feature:2445
                if (!dieonerror){
                    if(outputTable.isErrorRejectTable()){
                    	continue;
                    }
                }
                
                
                //only process the table with output link
                if (nameToOutputConnection.get(outputTableName)!=null) {//222
                	if(hasJoinedTable(outputTableName,data)){
                	
                	//feature:11884, in merge case, the mergedTable/mergingTable both clear.
				
    stringBuffer.append(TEXT_273);
    stringBuffer.append(outputTableName );
    stringBuffer.append(TEXT_274);
        
                	}else{
				
    stringBuffer.append(TEXT_275);
    stringBuffer.append(outputTableName );
    stringBuffer.append(TEXT_276);
    		
                	}
                }//222
				
        
            }//111
            
    stringBuffer.append(TEXT_281);
    
	}

    stringBuffer.append(TEXT_282);
    stringBuffer.append(TEXT_47);
    return stringBuffer.toString();
  }
}