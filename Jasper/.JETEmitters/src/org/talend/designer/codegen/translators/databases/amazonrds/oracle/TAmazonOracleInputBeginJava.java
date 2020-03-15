package org.talend.designer.codegen.translators.databases.amazonrds.oracle;

import org.talend.core.model.process.INode;
import org.talend.core.model.process.ElementParameterParser;
import org.talend.core.model.metadata.IMetadataTable;
import org.talend.core.model.metadata.IMetadataColumn;
import org.talend.designer.codegen.config.CodeGeneratorArgument;
import org.talend.core.model.process.IConnection;
import org.talend.core.model.process.IConnectionCategory;
import org.talend.core.model.metadata.types.JavaTypesManager;
import java.util.Map;
import java.util.List;

public class TAmazonOracleInputBeginJava
{
  protected static String nl;
  public static synchronized TAmazonOracleInputBeginJava create(String lineSeparator)
  {
    nl = lineSeparator;
    TAmazonOracleInputBeginJava result = new TAmazonOracleInputBeginJava();
    nl = null;
    return result;
  }

  public final String NL = nl == null ? (System.getProperties().getProperty("line.separator")) : nl;
  protected final String TEXT_1 = "\t";
  protected final String TEXT_2 = NL + "\t\t\t\tlog.info(\"";
  protected final String TEXT_3 = " - Retrieving records from the datasource.\");" + NL + "\t\t\t";
  protected final String TEXT_4 = NL + "\t\t\t\tlog.info(\"";
  protected final String TEXT_5 = " - Retrieved records count: \"+ nb_line_";
  protected final String TEXT_6 = " + \" .\");" + NL + "\t\t\t";
  protected final String TEXT_7 = NL + "\t\t\t\tlog.info(\"";
  protected final String TEXT_8 = " - Retrieved records count: \"+ globalMap.get(\"";
  protected final String TEXT_9 = "_NB_LINE\") + \" .\");" + NL + "\t\t\t";
  protected final String TEXT_10 = NL + "\t\t\t\tlog.info(\"";
  protected final String TEXT_11 = " - Retrieved records count: \"+ nb_line_";
  protected final String TEXT_12 = " + \" .\");" + NL + "\t\t\t";
  protected final String TEXT_13 = NL + "\t\t\t\tlog.info(\"";
  protected final String TEXT_14 = " - Written records count: \" + nb_line_";
  protected final String TEXT_15 = " + \" .\");" + NL + "\t\t\t";
  protected final String TEXT_16 = NL + "\t\t\t\tfinal StringBuffer log4jSb_";
  protected final String TEXT_17 = " = new StringBuffer();" + NL + "\t\t\t";
  protected final String TEXT_18 = NL + "\t\t\t\tlog.debug(\"";
  protected final String TEXT_19 = " - Retrieving the record \" + (nb_line_";
  protected final String TEXT_20 = ") + \".\");" + NL + "\t\t\t";
  protected final String TEXT_21 = NL + "\t\t\t\tlog.debug(\"";
  protected final String TEXT_22 = " - Writing the record \" + nb_line_";
  protected final String TEXT_23 = " + \" to the file.\");" + NL + "\t\t\t";
  protected final String TEXT_24 = NL + "\t\t\t\tlog.debug(\"";
  protected final String TEXT_25 = " - Processing the record \" + nb_line_";
  protected final String TEXT_26 = " + \".\");" + NL + "\t\t\t";
  protected final String TEXT_27 = NL + "\t\t\t\tlog.info(\"";
  protected final String TEXT_28 = " - Processed records count: \" + nb_line_";
  protected final String TEXT_29 = " + \" .\");" + NL + "\t\t\t";
  protected final String TEXT_30 = NL + "\t\t\t\tif(conn_";
  protected final String TEXT_31 = " != null) {" + NL + "\t\t\t\t\tif(conn_";
  protected final String TEXT_32 = ".getMetaData() != null) {" + NL + "\t\t\t\t\t\t";
  protected final String TEXT_33 = NL + "\t\t\t\t\t\tlog.info(\"";
  protected final String TEXT_34 = " - Uses an existing connection ";
  protected final String TEXT_35 = ".\");" + NL + "\t\t\t\t\t\t";
  protected final String TEXT_36 = NL + "\t\t\t\t\t\tlog.info(\"";
  protected final String TEXT_37 = " - Uses an existing connection with username '\" + conn_";
  protected final String TEXT_38 = ".getMetaData().getUserName() + \"'. Connection URL: \" + conn_";
  protected final String TEXT_39 = ".getMetaData().getURL() + \".\");" + NL + "\t\t\t\t\t\t";
  protected final String TEXT_40 = NL + "\t\t\t\t\t}" + NL + "\t\t\t\t}" + NL + "\t\t\t";
  protected final String TEXT_41 = NL + "\t\t\tconn_";
  protected final String TEXT_42 = " = java.sql.DriverManager.getConnection(url_";
  protected final String TEXT_43 = ", dbUser_";
  protected final String TEXT_44 = ", dbPwd_";
  protected final String TEXT_45 = ");" + NL + "\t\t\t";
  protected final String TEXT_46 = NL + "\t\t\tconn_";
  protected final String TEXT_47 = ".rollback();" + NL + "\t\t\t";
  protected final String TEXT_48 = NL + "\t\t\tconn_";
  protected final String TEXT_49 = ".commit();" + NL + "\t\t\t";
  protected final String TEXT_50 = NL + "\t\t\tconn_";
  protected final String TEXT_51 = ".close();" + NL + "\t\t\t";
  protected final String TEXT_52 = NL + "\t\t\t\tconn_";
  protected final String TEXT_53 = ".setAutoCommit(";
  protected final String TEXT_54 = ");" + NL + "\t\t\t";
  protected final String TEXT_55 = NL + "\t\t\t\tlog.";
  protected final String TEXT_56 = "(\"";
  protected final String TEXT_57 = " - \" + ";
  protected final String TEXT_58 = ".getMessage());" + NL + "\t\t\t";
  protected final String TEXT_59 = NL + "\t    \t\tlog.";
  protected final String TEXT_60 = "(\"";
  protected final String TEXT_61 = "\");" + NL + "\t\t\t";
  protected final String TEXT_62 = NL + "\t\t\t\tpstmt_";
  protected final String TEXT_63 = ".executeBatch();" + NL + "\t\t\t";
  protected final String TEXT_64 = NL + "\t\t\t\tint countSum_";
  protected final String TEXT_65 = " = 0;" + NL + "\t\t\t\tfor(int countEach_";
  protected final String TEXT_66 = ": pstmt_";
  protected final String TEXT_67 = ".executeBatch()) {" + NL + "\t\t\t\t\tcountSum_";
  protected final String TEXT_68 = " += (countEach_";
  protected final String TEXT_69 = " < 0 ? 0 : ";
  protected final String TEXT_70 = ");" + NL + "\t\t\t\t}" + NL + "\t\t\t";
  protected final String TEXT_71 = NL + "            java.util.Map<String, routines.system.TalendDataSource> dataSources_";
  protected final String TEXT_72 = " = (java.util.Map<String, routines.system.TalendDataSource>) globalMap.get(KEY_DB_DATASOURCES);" + NL + "            if (null != dataSources_";
  protected final String TEXT_73 = ") {";
  protected final String TEXT_74 = NL + "                conn_";
  protected final String TEXT_75 = " = dataSources_";
  protected final String TEXT_76 = ".get(";
  protected final String TEXT_77 = ").getConnection();" + NL + "            } else {";
  protected final String TEXT_78 = NL + "\t\t\t\tString driverClass_";
  protected final String TEXT_79 = " = \"";
  protected final String TEXT_80 = "\";" + NL + "\t\t\t    java.lang.Class.forName(driverClass_";
  protected final String TEXT_81 = ");" + NL + "\t\t\t   \tString dbUser_";
  protected final String TEXT_82 = " = ";
  protected final String TEXT_83 = ";" + NL + "\t\t\t   \t" + NL + "        \t\t";
  protected final String TEXT_84 = NL + "        \t\t" + NL + "        \t\t";
  protected final String TEXT_85 = " " + NL + "\tfinal String decryptedPassword_";
  protected final String TEXT_86 = " = routines.system.PasswordEncryptUtil.decryptPassword(";
  protected final String TEXT_87 = ");";
  protected final String TEXT_88 = NL + "\tfinal String decryptedPassword_";
  protected final String TEXT_89 = " = ";
  protected final String TEXT_90 = "; ";
  protected final String TEXT_91 = NL + "\t\t\t   \t" + NL + "\t\t        String dbPwd_";
  protected final String TEXT_92 = " = decryptedPassword_";
  protected final String TEXT_93 = ";" + NL + "\t\t        " + NL + "\t\t\t\t";
  protected final String TEXT_94 = NL + "\t\t\t\t";
  protected final String TEXT_95 = NL + "\t\t\t\tconn_";
  protected final String TEXT_96 = " = java.sql.DriverManager.getConnection(url_";
  protected final String TEXT_97 = ",dbUser_";
  protected final String TEXT_98 = ",dbPwd_";
  protected final String TEXT_99 = ");";
  protected final String TEXT_100 = NL + "\t\t\t\tconn_";
  protected final String TEXT_101 = " = java.sql.DriverManager.getConnection(url_";
  protected final String TEXT_102 = ");";
  protected final String TEXT_103 = NL + "\t\t        ";
  protected final String TEXT_104 = NL + "\t\t    }";
  protected final String TEXT_105 = NL + "\t\t\tjava.sql.Statement stmt_";
  protected final String TEXT_106 = " = conn_";
  protected final String TEXT_107 = ".createStatement();";
  protected final String TEXT_108 = NL + "\t\t\tjava.sql.Statement stmt_";
  protected final String TEXT_109 = " = conn_";
  protected final String TEXT_110 = ".createStatement(java.sql.ResultSet.TYPE_FORWARD_ONLY," + NL + "\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\tjava.sql.ResultSet.CONCUR_READ_ONLY);" + NL + "\t\t\t";
  protected final String TEXT_111 = NL + "\t\t\t\t\ttmpContent_";
  protected final String TEXT_112 = " = rs_";
  protected final String TEXT_113 = ".getString(";
  protected final String TEXT_114 = "column_index_";
  protected final String TEXT_115 = ");";
  protected final String TEXT_116 = NL + "                        if(tmpContent_";
  protected final String TEXT_117 = " != null) {" + NL + "                            tmpContent_";
  protected final String TEXT_118 = " = tmpContent_";
  protected final String TEXT_119 = ";" + NL + "                        }";
  protected final String TEXT_120 = NL + "                    if(tmpContent_";
  protected final String TEXT_121 = " != null && tmpContent_";
  protected final String TEXT_122 = ".length() > 0) {\t\t\t  \t";
  protected final String TEXT_123 = NL + "                        ";
  protected final String TEXT_124 = ".";
  protected final String TEXT_125 = " = tmpContent_";
  protected final String TEXT_126 = ".charAt(0);\t\t\t  \t\t" + NL + "                    } else {\t\t\t  \t";
  protected final String TEXT_127 = "\t\t\t  \t    " + NL + "                            if(tmpContent_";
  protected final String TEXT_128 = " == null) {\t\t\t  \t   \t";
  protected final String TEXT_129 = NL + "                                ";
  protected final String TEXT_130 = ".";
  protected final String TEXT_131 = " = null;\t\t\t  \t\t\t" + NL + "                            } else {\t\t\t  \t\t";
  protected final String TEXT_132 = NL + "                                ";
  protected final String TEXT_133 = ".";
  protected final String TEXT_134 = " = '\\0';\t\t\t  \t\t\t" + NL + "                            }";
  protected final String TEXT_135 = "\t\t\t  \t\t" + NL + "                            if((\"\").equals(tmpContent_";
  protected final String TEXT_136 = ")) {\t\t\t  \t\t";
  protected final String TEXT_137 = NL + "                                ";
  protected final String TEXT_138 = ".";
  protected final String TEXT_139 = " = '\\0';\t\t\t  \t\t\t" + NL + "                            } else {" + NL + "        \t\t\t  \t\t\tthrow new RuntimeException(" + NL + "        \t\t\t\t\t\t\t\"Value is empty for column : '";
  protected final String TEXT_140 = "' in '";
  protected final String TEXT_141 = "' connection, value is invalid or this column should be nullable or have a default value.\");\t\t\t\t\t\t\t" + NL + "                            }\t\t\t  \t\t";
  protected final String TEXT_142 = NL + "                    }";
  protected final String TEXT_143 = NL + "\t\t\tif(rs_";
  protected final String TEXT_144 = ".getTimestamp(";
  protected final String TEXT_145 = "column_index_";
  protected final String TEXT_146 = ") != null) {" + NL + "\t\t\t    ";
  protected final String TEXT_147 = ".";
  protected final String TEXT_148 = " = new java.util.Date(rs_";
  protected final String TEXT_149 = ".getTimestamp(";
  protected final String TEXT_150 = "column_index_";
  protected final String TEXT_151 = ").getTime());" + NL + "\t\t\t} else {" + NL + "\t\t\t    ";
  protected final String TEXT_152 = ".";
  protected final String TEXT_153 = " =  null;" + NL + "\t\t\t}\t\t\t ";
  protected final String TEXT_154 = NL + "            tmpContent_";
  protected final String TEXT_155 = " = rs_";
  protected final String TEXT_156 = ".getString(";
  protected final String TEXT_157 = "column_index_";
  protected final String TEXT_158 = ");" + NL + "            if(tmpContent_";
  protected final String TEXT_159 = " != null) {";
  protected final String TEXT_160 = NL + "                ";
  protected final String TEXT_161 = ".";
  protected final String TEXT_162 = " = tmpContent_";
  protected final String TEXT_163 = ";" + NL + "            } else {";
  protected final String TEXT_164 = NL + "                ";
  protected final String TEXT_165 = ".";
  protected final String TEXT_166 = " = null;" + NL + "            }";
  protected final String TEXT_167 = NL + "            if(rs_";
  protected final String TEXT_168 = ".getObject(";
  protected final String TEXT_169 = "column_index_";
  protected final String TEXT_170 = ") != null) {";
  protected final String TEXT_171 = NL + "                ";
  protected final String TEXT_172 = ".";
  protected final String TEXT_173 = " = rs_";
  protected final String TEXT_174 = ".get";
  protected final String TEXT_175 = "(";
  protected final String TEXT_176 = "column_index_";
  protected final String TEXT_177 = ");" + NL + "            } else {";
  protected final String TEXT_178 = NL + "                    ";
  protected final String TEXT_179 = ".";
  protected final String TEXT_180 = " = null;";
  protected final String TEXT_181 = NL + "                    throw new RuntimeException(\"Null value in non-Nullable column\");";
  protected final String TEXT_182 = NL + "            }";
  protected final String TEXT_183 = NL + "            \tString url_";
  protected final String TEXT_184 = " = null;";
  protected final String TEXT_185 = NL + "            \t\turl_";
  protected final String TEXT_186 = " = \"jdbc:oracle:thin:@\" + ";
  protected final String TEXT_187 = " + \":\" + ";
  protected final String TEXT_188 = " + \":\" + ";
  protected final String TEXT_189 = ";";
  protected final String TEXT_190 = NL + "            \t\turl_";
  protected final String TEXT_191 = " = \"jdbc:oracle:thin:@(description=(address=(protocol=tcp)(host=\" + ";
  protected final String TEXT_192 = " + \")(port=\" + ";
  protected final String TEXT_193 = " + \"))(connect_data=(service_name=\" + ";
  protected final String TEXT_194 = " + \")))\";";
  protected final String TEXT_195 = NL + "            \t    url_";
  protected final String TEXT_196 = " = \"jdbc:oracle:oci8:@\" + ";
  protected final String TEXT_197 = ";";
  protected final String TEXT_198 = NL + "\t    \t\t\turl_";
  protected final String TEXT_199 = " = ";
  protected final String TEXT_200 = ";";
  protected final String TEXT_201 = NL;
  protected final String TEXT_202 = NL + "\t\t\tString driverClass_";
  protected final String TEXT_203 = " = \"";
  protected final String TEXT_204 = "\";" + NL + "\t\t\tjava.lang.Class.forName( driverClass_";
  protected final String TEXT_205 = ");" + NL + "\t\t\t";
  protected final String TEXT_206 = NL + "\t        String dbUser_";
  protected final String TEXT_207 = " = ";
  protected final String TEXT_208 = ";" + NL + "\t        " + NL + "    \t\t";
  protected final String TEXT_209 = NL + "    \t\t" + NL + "    \t\t";
  protected final String TEXT_210 = " " + NL + "\tfinal String decryptedPassword_";
  protected final String TEXT_211 = " = routines.system.PasswordEncryptUtil.decryptPassword(";
  protected final String TEXT_212 = ");";
  protected final String TEXT_213 = NL + "\tfinal String decryptedPassword_";
  protected final String TEXT_214 = " = ";
  protected final String TEXT_215 = "; ";
  protected final String TEXT_216 = NL + "\t\t   \t" + NL + "\t        String dbPwd_";
  protected final String TEXT_217 = " = decryptedPassword_";
  protected final String TEXT_218 = ";" + NL + "\t        ";
  protected final String TEXT_219 = NL + "\t\t\tconn_";
  protected final String TEXT_220 = " = java.sql.DriverManager.getConnection(url_";
  protected final String TEXT_221 = ");";
  protected final String TEXT_222 = NL + "\t\t\tconn_";
  protected final String TEXT_223 = " = java.sql.DriverManager.getConnection(url_";
  protected final String TEXT_224 = ",dbUser_";
  protected final String TEXT_225 = ",dbPwd_";
  protected final String TEXT_226 = ");";
  protected final String TEXT_227 = NL + "\t\t\tString atnParams_";
  protected final String TEXT_228 = " = ";
  protected final String TEXT_229 = ";" + NL + "\t\t\tatnParams_";
  protected final String TEXT_230 = " = atnParams_";
  protected final String TEXT_231 = ".replaceAll(\"&\", \"\\n\");" + NL + "\t\t\tjava.util.Properties atnParamsPrope_";
  protected final String TEXT_232 = " = new java.util.Properties();" + NL + "\t\t\tatnParamsPrope_";
  protected final String TEXT_233 = ".put(\"user\",dbUser_";
  protected final String TEXT_234 = ");" + NL + "\t\t\tatnParamsPrope_";
  protected final String TEXT_235 = ".put(\"password\",dbPwd_";
  protected final String TEXT_236 = ");" + NL + "\t\t\tatnParamsPrope_";
  protected final String TEXT_237 = ".load(new java.io.ByteArrayInputStream(atnParams_";
  protected final String TEXT_238 = ".getBytes()));" + NL + "\t\t\tconn_";
  protected final String TEXT_239 = " = java.sql.DriverManager.getConnection(url_";
  protected final String TEXT_240 = ", atnParamsPrope_";
  protected final String TEXT_241 = ");";
  protected final String TEXT_242 = NL + "                stmt_";
  protected final String TEXT_243 = ".setFetchSize(";
  protected final String TEXT_244 = ");" + NL + "\t\t\t\t";
  protected final String TEXT_245 = NL + "\t\t\t\tjava.io.Reader reader_";
  protected final String TEXT_246 = " = rs_";
  protected final String TEXT_247 = ".getCharacterStream(";
  protected final String TEXT_248 = "column_index_";
  protected final String TEXT_249 = ");" + NL + "\t\t\t\tjava.io.BufferedReader br_";
  protected final String TEXT_250 = " = null;" + NL + "\t\t\t\tif(reader_";
  protected final String TEXT_251 = " != null) {" + NL + "\t\t\t\t\tbr_";
  protected final String TEXT_252 = " = new java.io.BufferedReader(reader_";
  protected final String TEXT_253 = ");                 \t                        " + NL + " \t                StringBuffer content_";
  protected final String TEXT_254 = " = new StringBuffer();" + NL + " \t                int c_";
  protected final String TEXT_255 = " =0;" + NL + " \t                while( (c_";
  protected final String TEXT_256 = " = br_";
  protected final String TEXT_257 = ".read()) != -1) {" + NL + " \t                \tcontent_";
  protected final String TEXT_258 = ".append((char)c_";
  protected final String TEXT_259 = ");" + NL + "\t\t\t\t\t}" + NL + " \t                br_";
  protected final String TEXT_260 = ".close();" + NL + "\t\t\t\t\t";
  protected final String TEXT_261 = ".";
  protected final String TEXT_262 = " = content_";
  protected final String TEXT_263 = ".toString();" + NL + "\t\t\t\t} else {" + NL + "\t\t\t\t\t";
  protected final String TEXT_264 = ".";
  protected final String TEXT_265 = " = null;" + NL + "\t\t\t\t}                 \t                    ";
  protected final String TEXT_266 = NL + "\t\t\t \t    tmpContent_";
  protected final String TEXT_267 = " = rs_";
  protected final String TEXT_268 = ".getString(";
  protected final String TEXT_269 = "column_index_";
  protected final String TEXT_270 = ");" + NL + "\t\t\t        if(tmpContent_";
  protected final String TEXT_271 = " != null) {" + NL + "\t\t\t            ";
  protected final String TEXT_272 = ".";
  protected final String TEXT_273 = " = tmpContent_";
  protected final String TEXT_274 = ";" + NL + "\t\t\t        } else {" + NL + "\t\t\t            ";
  protected final String TEXT_275 = ".";
  protected final String TEXT_276 = " = null;" + NL + "\t\t\t        }                 \t                    ";
  protected final String TEXT_277 = NL + "\t\t\tbyte [] tmpBytes_";
  protected final String TEXT_278 = " = rs_";
  protected final String TEXT_279 = ".getBytes(";
  protected final String TEXT_280 = "column_index_";
  protected final String TEXT_281 = ");" + NL + "\t\t\tif(tmpBytes_";
  protected final String TEXT_282 = " != null) {" + NL + "\t\t\t\t";
  protected final String TEXT_283 = ".";
  protected final String TEXT_284 = " = tmpBytes_";
  protected final String TEXT_285 = ";" + NL + "\t\t\t} else {" + NL + "\t\t\t\t";
  protected final String TEXT_286 = ".";
  protected final String TEXT_287 = " = null;" + NL + "\t\t\t}\t\t";
  protected final String TEXT_288 = NL + "\t\t\t\tObject tmpObj_";
  protected final String TEXT_289 = "_";
  protected final String TEXT_290 = " = rs_";
  protected final String TEXT_291 = ".getObject(";
  protected final String TEXT_292 = "column_index_";
  protected final String TEXT_293 = ");" + NL + "\t\t\t\tif(tmpObj_";
  protected final String TEXT_294 = "_";
  protected final String TEXT_295 = " != null) {";
  protected final String TEXT_296 = NL + "\t\t\t\t\t";
  protected final String TEXT_297 = ".";
  protected final String TEXT_298 = " = oracle.xdb.XMLType.createXML((oracle.sql.OPAQUE) tmpObj_";
  protected final String TEXT_299 = "_";
  protected final String TEXT_300 = ").getStringVal();";
  protected final String TEXT_301 = NL + "\t\t\t\t\t";
  protected final String TEXT_302 = ".";
  protected final String TEXT_303 = " = tmpObj_";
  protected final String TEXT_304 = "_";
  protected final String TEXT_305 = ";";
  protected final String TEXT_306 = NL + "\t\t\t\t} else {";
  protected final String TEXT_307 = NL + "\t\t\t\t\t\t";
  protected final String TEXT_308 = ".";
  protected final String TEXT_309 = " = null;";
  protected final String TEXT_310 = "    " + NL + "\t\t\t\t\t\tthrow new RuntimeException(\"Null value in non-Nullable column\");";
  protected final String TEXT_311 = NL + "\t\t\t\t}";
  protected final String TEXT_312 = NL + "\t\t\t\tif(rs_";
  protected final String TEXT_313 = ".getObject(";
  protected final String TEXT_314 = "column_index_";
  protected final String TEXT_315 = ") != null) {" + NL + "\t\t\t\t\t";
  protected final String TEXT_316 = ".";
  protected final String TEXT_317 = " = rs_";
  protected final String TEXT_318 = ".get";
  protected final String TEXT_319 = "(";
  protected final String TEXT_320 = "column_index_";
  protected final String TEXT_321 = ");" + NL + "\t\t\t\t} else {";
  protected final String TEXT_322 = NL + "\t\t\t\t\t\t";
  protected final String TEXT_323 = ".";
  protected final String TEXT_324 = " = null;";
  protected final String TEXT_325 = "    " + NL + "\t\t\t\tthrow new RuntimeException(\"Null value in non-Nullable column\");";
  protected final String TEXT_326 = NL + "\t\t\t\t}";
  protected final String TEXT_327 = NL + NL + "    " + NL + "\t";
  protected final String TEXT_328 = NL + "\t\t    int nb_line_";
  protected final String TEXT_329 = " = 0;" + NL + "\t\t    java.sql.Connection conn_";
  protected final String TEXT_330 = " = null;";
  protected final String TEXT_331 = NL + "\t\t        conn_";
  protected final String TEXT_332 = " = (java.sql.Connection)globalMap.get(\"";
  protected final String TEXT_333 = "\");";
  protected final String TEXT_334 = NL + "\t\t        \tif (null == conn_";
  protected final String TEXT_335 = ") {" + NL + "\t\t\t\t\t\tjava.util.Map<String, routines.system.TalendDataSource> dataSources_";
  protected final String TEXT_336 = " = (java.util.Map<String, routines.system.TalendDataSource>) globalMap.get(KEY_DB_DATASOURCES);" + NL + "\t\t\t\t\t\tconn_";
  protected final String TEXT_337 = " = dataSources_";
  protected final String TEXT_338 = ".get(";
  protected final String TEXT_339 = ").getConnection();" + NL + "\t\t\t\t\t\t//globalMap.put(\"";
  protected final String TEXT_340 = "\", conn_";
  protected final String TEXT_341 = ");" + NL + "\t\t        \t}" + NL + "\t\t        ";
  protected final String TEXT_342 = NL + "\t\t\t\t";
  protected final String TEXT_343 = NL + "\t\t\t\t";
  protected final String TEXT_344 = NL + "             boolean currentAutoCommitMode";
  protected final String TEXT_345 = " =  conn_";
  protected final String TEXT_346 = ".getAutoCommit();" + NL + "             conn_";
  protected final String TEXT_347 = ".setAutoCommit(true);" + NL + "             try{";
  protected final String TEXT_348 = NL + "                           try{" + NL + "                               conn_";
  protected final String TEXT_349 = ".createStatement().execute(\"BEGIN QUERY LOGGING WITH SQL,OBJECTS ON \" + ";
  protected final String TEXT_350 = ");" + NL + "                           }catch(Exception e){" + NL + "                                 System.err.println(e.getMessage());" + NL + "                           }";
  protected final String TEXT_351 = NL + "                 conn_";
  protected final String TEXT_352 = ".createStatement().execute(" + NL + "              \"SET QUERY_BAND='\" +";
  protected final String TEXT_353 = NL + "               ";
  protected final String TEXT_354 = " + \"=\" + ";
  protected final String TEXT_355 = " + \";\" +";
  protected final String TEXT_356 = " \"' FOR SESSION\"" + NL + "           );" + NL + "              }catch(Exception e){" + NL + "               System.err.println(e.getMessage());" + NL + "      }" + NL + "      conn_";
  protected final String TEXT_357 = ".setAutoCommit(currentAutoCommitMode";
  protected final String TEXT_358 = ");";
  protected final String TEXT_359 = NL + "\t\t    ";
  protected final String TEXT_360 = NL + NL + "\t\t    String dbquery_";
  protected final String TEXT_361 = " = ";
  protected final String TEXT_362 = ";" + NL + "\t\t\t";
  protected final String TEXT_363 = NL + "                log.info(\"";
  protected final String TEXT_364 = " - Executing the query: '\"+dbquery_";
  protected final String TEXT_365 = "+\"'.\");" + NL + "\t\t\t";
  protected final String TEXT_366 = NL;
  protected final String TEXT_367 = NL + "                       globalMap.put(\"";
  protected final String TEXT_368 = "_QUERY\",dbquery_";
  protected final String TEXT_369 = ");";
  protected final String TEXT_370 = NL + "                       globalMap.put(\"";
  protected final String TEXT_371 = "_QUERY\",dbquery_";
  protected final String TEXT_372 = ");";
  protected final String TEXT_373 = NL + NL + "\t\t    java.sql.ResultSet rs_";
  protected final String TEXT_374 = " = null;" + NL + "\t\ttry{" + NL + "\t\t    rs_";
  protected final String TEXT_375 = " = stmt_";
  protected final String TEXT_376 = ".executeQuery(dbquery_";
  protected final String TEXT_377 = ");" + NL + "\t\t    java.sql.ResultSetMetaData rsmd_";
  protected final String TEXT_378 = " = rs_";
  protected final String TEXT_379 = ".getMetaData();" + NL + "\t\t    int colQtyInRs_";
  protected final String TEXT_380 = " = rsmd_";
  protected final String TEXT_381 = ".getColumnCount();" + NL;
  protected final String TEXT_382 = NL + "\t\t    routines.system.Dynamic dcg_";
  protected final String TEXT_383 = " =  new routines.system.Dynamic();" + NL + "\t\t    dcg_";
  protected final String TEXT_384 = ".setDbmsId(\"";
  protected final String TEXT_385 = "\");" + NL + "\t\t    List<String> listSchema_";
  protected final String TEXT_386 = "=new java.util.ArrayList<String>();" + NL + "\t\t    ";
  protected final String TEXT_387 = NL + "\t\t    \t    listSchema_";
  protected final String TEXT_388 = ".add(\"";
  protected final String TEXT_389 = "\");" + NL + "\t    \t    ";
  protected final String TEXT_390 = NL + NL + "\t\t\tint fixedColumnCount_";
  protected final String TEXT_391 = " = ";
  protected final String TEXT_392 = ";" + NL + "" + NL + "            for (int i = ";
  protected final String TEXT_393 = "; i <= rsmd_";
  protected final String TEXT_394 = ".getColumnCount()-";
  protected final String TEXT_395 = "; i++) {" + NL + "                if (!(listSchema_";
  protected final String TEXT_396 = ".contains(rsmd_";
  protected final String TEXT_397 = ".getColumnLabel(i).toUpperCase()) )) {" + NL + "                \troutines.system.DynamicMetadata dcm_";
  protected final String TEXT_398 = "=new routines.system.DynamicMetadata();" + NL + "                \tdcm_";
  protected final String TEXT_399 = ".setName(rsmd_";
  protected final String TEXT_400 = ".getColumnLabel(i));" + NL + "                \tdcm_";
  protected final String TEXT_401 = ".setDbName(rsmd_";
  protected final String TEXT_402 = ".getColumnName(i));" + NL + "                \tdcm_";
  protected final String TEXT_403 = ".setType(routines.system.Dynamic.getTalendTypeFromDBType(\"";
  protected final String TEXT_404 = "\", rsmd_";
  protected final String TEXT_405 = ".getColumnTypeName(i).toUpperCase(), rsmd_";
  protected final String TEXT_406 = ".getPrecision(i), rsmd_";
  protected final String TEXT_407 = ".getScale(i)));" + NL + "                \tdcm_";
  protected final String TEXT_408 = ".setDbType(rsmd_";
  protected final String TEXT_409 = ".getColumnTypeName(i));" + NL + "                \tdcm_";
  protected final String TEXT_410 = ".setDbTypeId(rsmd_";
  protected final String TEXT_411 = ".getColumnType(i));";
  protected final String TEXT_412 = NL + "                \tdcm_";
  protected final String TEXT_413 = ".setFormat(";
  protected final String TEXT_414 = ");";
  protected final String TEXT_415 = NL + "\t\t\tif(\"LONG\".equals(rsmd_";
  protected final String TEXT_416 = ".getColumnTypeName(i).toUpperCase())) {" + NL + "\t\t\t\tString length = MetadataTalendType.getDefaultDBTypes(\"oracle_id\", \"LONG\", MetadataTalendType.DEFAULT_LENGTH);" + NL + "\t\t\t\tif(length!=null && !(\"\".equals(length))) {" + NL + "\t\t\t\t\tdcm_";
  protected final String TEXT_417 = ".setLength(Integer.parseInt(length));" + NL + "\t\t\t\t} else {" + NL + "\t\t\t\t\tdcm_";
  protected final String TEXT_418 = ".setLength(rsmd_";
  protected final String TEXT_419 = ".getPrecision(i));" + NL + "\t\t\t\t}" + NL + "\t\t\t} else {" + NL + "\t\t\t\tdcm_";
  protected final String TEXT_420 = ".setLength(rsmd_";
  protected final String TEXT_421 = ".getPrecision(i));" + NL + "\t\t\t}";
  protected final String TEXT_422 = NL + "\t\t\tdcm_";
  protected final String TEXT_423 = ".setLength(rsmd_";
  protected final String TEXT_424 = ".getPrecision(i));";
  protected final String TEXT_425 = NL + "                \tdcm_";
  protected final String TEXT_426 = ".setPrecision(rsmd_";
  protected final String TEXT_427 = ".getScale(i));" + NL + "                \tdcm_";
  protected final String TEXT_428 = ".setNullable(rsmd_";
  protected final String TEXT_429 = ".isNullable(i) == 0 ? false : true);" + NL + "                \tdcm_";
  protected final String TEXT_430 = ".setKey(false);" + NL + "                \tdcm_";
  protected final String TEXT_431 = ".setSourceType(DynamicMetadata.sourceTypes.database);" + NL + "                \tdcm_";
  protected final String TEXT_432 = ".setColumnPosition(i);" + NL + "                \tdcg_";
  protected final String TEXT_433 = ".metadatas.add(dcm_";
  protected final String TEXT_434 = ");" + NL + "                }" + NL + "            }";
  protected final String TEXT_435 = NL + "\t\t    String tmpContent_";
  protected final String TEXT_436 = " = null;" + NL + "\t\t    ";
  protected final String TEXT_437 = NL + "\t\t    \tint column_index_";
  protected final String TEXT_438 = " =1;" + NL + "\t\t    ";
  protected final String TEXT_439 = NL + "\t\t    ";
  protected final String TEXT_440 = NL + "\t\t    \tlog.info(\"";
  protected final String TEXT_441 = " - Retrieving records from the database.\");" + NL + "\t\t    ";
  protected final String TEXT_442 = NL + "\t\t    while (rs_";
  protected final String TEXT_443 = ".next()) {" + NL + "\t\t        nb_line_";
  protected final String TEXT_444 = "++;" + NL + "\t\t        ";
  protected final String TEXT_445 = NL + "\t\t\t\t\t\t\t\t\tcolumn_index_";
  protected final String TEXT_446 = " = ";
  protected final String TEXT_447 = " + dcg_";
  protected final String TEXT_448 = ".getColumnCount();" + NL + "\t\t\t\t\t\t\t\t";
  protected final String TEXT_449 = NL + "\t\t\t\t\t\t\t\t\tcolumn_index_";
  protected final String TEXT_450 = " = ";
  protected final String TEXT_451 = ";" + NL + "\t\t\t\t\t\t\t\t";
  protected final String TEXT_452 = NL + "\t\t\t\t\t\t\t";
  protected final String TEXT_453 = NL + "\t\t\t\t\t\t\tif(colQtyInRs_";
  protected final String TEXT_454 = " < ";
  protected final String TEXT_455 = "column_index_";
  protected final String TEXT_456 = ") {" + NL + "\t\t\t\t\t\t\t\t";
  protected final String TEXT_457 = ".";
  protected final String TEXT_458 = " = ";
  protected final String TEXT_459 = ";" + NL + "\t\t\t\t\t\t\t} else {";
  protected final String TEXT_460 = NL + "\t\t\t\t\t\t\t\t\t";
  protected final String TEXT_461 = NL + "\t\t\t\t\t\t\t\t\t\t";
  protected final String TEXT_462 = NL + "\t\t\t\t\t\t\t\t\t\t";
  protected final String TEXT_463 = NL + "\t\t                            ";
  protected final String TEXT_464 = ".";
  protected final String TEXT_465 = " = (List)rs_";
  protected final String TEXT_466 = ".getObject(";
  protected final String TEXT_467 = "column_index_";
  protected final String TEXT_468 = ");";
  protected final String TEXT_469 = NL + "\t\t                         ";
  protected final String TEXT_470 = NL + "                                    oracle.sql.STRUCT jGeomStruct = (oracle.sql.STRUCT) rs_";
  protected final String TEXT_471 = ".getObject(";
  protected final String TEXT_472 = "column_index_";
  protected final String TEXT_473 = ");" + NL + "                                    if (jGeomStruct != null) {" + NL + "                                    oracle.spatial.geometry.JGeometry jGeom = oracle.spatial.geometry.JGeometry.load(jGeomStruct);" + NL + "                                    oracle.spatial.util.WKT wkt = new oracle.spatial.util.WKT();" + NL + "                                    String wktValue = new String(wkt.fromJGeometry(jGeom));" + NL;
  protected final String TEXT_474 = NL + "                                    ";
  protected final String TEXT_475 = ".";
  protected final String TEXT_476 = " = new Geometry(wktValue);" + NL + "                                    } else {";
  protected final String TEXT_477 = NL + "                                      ";
  protected final String TEXT_478 = ".";
  protected final String TEXT_479 = " = null;" + NL + "                                    }";
  protected final String TEXT_480 = NL + "                                        if (";
  protected final String TEXT_481 = ".";
  protected final String TEXT_482 = " != null) {";
  protected final String TEXT_483 = NL + "                                        ";
  protected final String TEXT_484 = ".";
  protected final String TEXT_485 = ".setEPSG(";
  protected final String TEXT_486 = ");" + NL + "                                        }";
  protected final String TEXT_487 = NL + "\t\t\t\t\t\t\t\t\t";
  protected final String TEXT_488 = NL + "                                  ";
  protected final String TEXT_489 = ".";
  protected final String TEXT_490 = "=dcg_";
  protected final String TEXT_491 = ";";
  protected final String TEXT_492 = NL + "\t\t\t\t\t\t\t\t\t\tList<String> list_";
  protected final String TEXT_493 = " = new java.util.ArrayList<String>();" + NL + "\t\t\t\t\t    \t\t\t\tfor(int i_";
  protected final String TEXT_494 = " = ";
  protected final String TEXT_495 = "; i_";
  protected final String TEXT_496 = "  <= rsmd_";
  protected final String TEXT_497 = ".getColumnCount(); i_";
  protected final String TEXT_498 = " ++){" + NL + "\t\t\t\t\t\t \t\t\t\t\tif (\"NTEXT\".equals(rsmd_";
  protected final String TEXT_499 = ".getColumnTypeName(i_";
  protected final String TEXT_500 = " ).toUpperCase())) {" + NL + "\t\t\t\t\t\t\t\t\t\t\t\tnet.sourceforge.jtds.jdbc.ClobImpl clob_";
  protected final String TEXT_501 = " = (net.sourceforge.jtds.jdbc.ClobImpl) rs_";
  protected final String TEXT_502 = ".getClob(i_";
  protected final String TEXT_503 = ");" + NL + "\t\t\t\t\t\t\t\t\t\t\t\tif(clob_";
  protected final String TEXT_504 = "!=null){" + NL + "\t\t\t\t\t\t\t\t\t\t\t\t\tnet.sourceforge.jtds.jdbc.TalendNTextImpl tNTextImpl_";
  protected final String TEXT_505 = " = new net.sourceforge.jtds.jdbc.TalendNTextImpl(clob_";
  protected final String TEXT_506 = ");" + NL + "\t\t\t\t\t\t\t  \t\t\t\t\t\tlist_";
  protected final String TEXT_507 = ".add(tNTextImpl_";
  protected final String TEXT_508 = ".getValue());" + NL + "\t\t\t\t\t\t\t\t\t\t\t\t}else{" + NL + "\t\t\t\t\t\t\t\t\t\t\t\t\tlist_";
  protected final String TEXT_509 = ".add(null);" + NL + "\t\t\t\t\t\t\t\t\t\t\t\t}" + NL + "\t\t\t\t\t\t   \t\t\t\t\t}" + NL + "   \t \t\t\t\t    \t\t\t\t}" + NL + "                                 \t\t routines.system.DynamicUtils.readColumnsFromDatabase_Mssql(";
  protected final String TEXT_510 = ".";
  protected final String TEXT_511 = ", rs_";
  protected final String TEXT_512 = ", fixedColumnCount_";
  protected final String TEXT_513 = ",list_";
  protected final String TEXT_514 = ",";
  protected final String TEXT_515 = ");";
  protected final String TEXT_516 = NL + "\t\t\t\t\t\t\t\t\t\troutines.system.DynamicUtils.readColumnsFromDatabase_Access(";
  protected final String TEXT_517 = ".";
  protected final String TEXT_518 = ", rs_";
  protected final String TEXT_519 = ", fixedColumnCount_";
  protected final String TEXT_520 = ",";
  protected final String TEXT_521 = ");";
  protected final String TEXT_522 = NL + "                                \t\t routines.system.DynamicUtils.readColumnsFromDatabase(";
  protected final String TEXT_523 = ".";
  protected final String TEXT_524 = ", rs_";
  protected final String TEXT_525 = ", fixedColumnCount_";
  protected final String TEXT_526 = ",";
  protected final String TEXT_527 = ");";
  protected final String TEXT_528 = NL + "                                  Object geom = rs_";
  protected final String TEXT_529 = ".getObject(";
  protected final String TEXT_530 = "column_index_";
  protected final String TEXT_531 = ");" + NL + "                                  if (geom != null) {" + NL + "                                  \torg.postgis.Geometry o =" + NL + "                                      org.postgis.PGgeometry.geomFromString(geom.toString());" + NL + "                                \tStringBuffer sb = new StringBuffer();" + NL + "                                \to.outerWKT(sb, false);" + NL + "                                \t";
  protected final String TEXT_532 = ".";
  protected final String TEXT_533 = " = new Geometry(sb.toString());" + NL + "                                  } else {" + NL + "                                  \t";
  protected final String TEXT_534 = ".";
  protected final String TEXT_535 = " = null;" + NL + "                                  }";
  protected final String TEXT_536 = NL + "\t\t                          ";
  protected final String TEXT_537 = NL + "\t\t                    }";
  protected final String TEXT_538 = NL + "\t\t\t\t\t";
  protected final String TEXT_539 = NL + "\t\t\t\t\t\tlog.debug(\"";
  protected final String TEXT_540 = " - Retrieving the record \" + nb_line_";
  protected final String TEXT_541 = " + \".\");" + NL + "\t\t\t\t\t";
  protected final String TEXT_542 = NL + "\t\t                            ";
  protected final String TEXT_543 = ".";
  protected final String TEXT_544 = " = ";
  protected final String TEXT_545 = ".";
  protected final String TEXT_546 = ";" + NL + "\t\t                            ";
  protected final String TEXT_547 = NL + "\t" + NL + "\t" + NL;
  protected final String TEXT_548 = NL;

  public String generate(Object argument)
  {
    final StringBuffer stringBuffer = new StringBuffer();
    stringBuffer.append(TEXT_1);
    
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
			
    stringBuffer.append(TEXT_2);
    stringBuffer.append(label);
    stringBuffer.append(TEXT_3);
    
			}
		}
		
		public void retrievedDataNumberInfo() {
			if (isLog4jEnabled) {
			
    stringBuffer.append(TEXT_4);
    stringBuffer.append(label);
    stringBuffer.append(TEXT_5);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_6);
    
			}
		}
		
		public void retrievedDataNumberInfoFromGlobalMap(INode node) {
			if (isLog4jEnabled) {
			
    stringBuffer.append(TEXT_7);
    stringBuffer.append(label);
    stringBuffer.append(TEXT_8);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_9);
    
			}
		}
		
		//for all tFileinput* components 
		public void retrievedDataNumberInfo(INode node) {
			if (isLog4jEnabled) {
			
    stringBuffer.append(TEXT_10);
    stringBuffer.append(label);
    stringBuffer.append(TEXT_11);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_12);
    
			}
		}
		
		public void writeDataFinishInfo(INode node) {
			if(isLog4jEnabled){
			
    stringBuffer.append(TEXT_13);
    stringBuffer.append(label);
    stringBuffer.append(TEXT_14);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_15);
    
			}
		}
		
 		//TODO delete it and remove all log4jSb parameter from components
		public void componentStartInfo(INode node) {
			if (isLog4jEnabled) {
			
    stringBuffer.append(TEXT_16);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_17);
    
			}
		}
		
		//TODO rename or delete it
		public void debugRetriveData(INode node,boolean hasIncreased) {
			if(isLog4jEnabled){
			
    stringBuffer.append(TEXT_18);
    stringBuffer.append(label);
    stringBuffer.append(TEXT_19);
    stringBuffer.append(cid);
    stringBuffer.append(hasIncreased?"":"+1");
    stringBuffer.append(TEXT_20);
    
			}
		}
		
		//TODO rename or delete it
		public void debugRetriveData(INode node) {
			debugRetriveData(node,true);
		}
		
		//TODO rename or delete it
		public void debugWriteData(INode node) {
			if(isLog4jEnabled){
			
    stringBuffer.append(TEXT_21);
    stringBuffer.append(label);
    stringBuffer.append(TEXT_22);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_23);
    
			}
		}
		
		public void logCurrentRowNumberInfo() {
			if(isLog4jEnabled){
			
    stringBuffer.append(TEXT_24);
    stringBuffer.append(label);
    stringBuffer.append(TEXT_25);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_26);
    
			}
		}
		
		public void logDataCountInfo() {
			if(isLog4jEnabled){
			
    stringBuffer.append(TEXT_27);
    stringBuffer.append(label);
    stringBuffer.append(TEXT_28);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_29);
    
			}
		}
	}
	
	final DefaultLog4jFileUtil log4jFileUtil = new DefaultLog4jFileUtil((INode)(((org.talend.designer.codegen.config.CodeGeneratorArgument)argument).getArgument()));
	
    
	class DefaultLog4jCodeGenerateUtil extends DefaultLog4jFileUtil{

 		String connection = "";
 		boolean hasInit = false;
 		String dataAction ;
 		String dataOperationPrefix;
		String useBatchSize;
		String batchSize;
		String dbSchema;
 		boolean logCommitCounter = false;

		public DefaultLog4jCodeGenerateUtil(){
		}

		public DefaultLog4jCodeGenerateUtil(INode node) {
			super(node);
	    	init();
		}

	    public void beforeComponentProcess(INode node){
	    	this.node = node;
	    	init();
	    }

		private void init() {
			if(hasInit){
				return;
			}
 			this.cid = node.getUniqueName();
			this.isLog4jEnabled = ("true").equals(ElementParameterParser.getValue(node.getProcess(), "__LOG4J_ACTIVATE__"));
			String useConn = ElementParameterParser.getValue(node,"__USE_EXISTING_CONNECTION__");
			if(useConn == null || "".equals(useConn) || "true".equals(useConn)){
				connection = ElementParameterParser.getValue(node,"__CONNECTION__");
				if(!"".equals(connection)){
					connection = "'" + connection+"' ";
				}
			}
			//for output
			dataAction = ElementParameterParser.getValue(node,"__DATA_ACTION__");
			if(dataAction != null && !("").equals(dataAction)){
				logCommitCounter=true;
			}
			useBatchSize = ElementParameterParser.getValue(node, "__USE_BATCH_SIZE__");
			batchSize =ElementParameterParser.getValue(node, "__BATCH_SIZE__");
			hasInit = true;
		}

		public void debugDriverClassName() {
			logInfo(node,"debug",cid+" - Driver ClassName: \"+driverClass_"+cid+"+\".");
		}

		public void debugConnectionParams(INode node) {
			beforeComponentProcess(node);
			debugDriverClassName();
		}

		public void useExistConnection(INode node){
			beforeComponentProcess(node);
			if(isLog4jEnabled) {
			
    stringBuffer.append(TEXT_30);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_31);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_32);
    if (cid.startsWith("tImpala") || cid.startsWith("tHive")) {
    stringBuffer.append(TEXT_33);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_34);
    stringBuffer.append(connection );
    stringBuffer.append(TEXT_35);
    } else {
    stringBuffer.append(TEXT_36);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_37);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_38);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_39);
    }
    stringBuffer.append(TEXT_40);
    
			}
		}

		public void connect(INode node){
			beforeComponentProcess(node);
			connect();
		}

		public void connect(){
			connect_begin();
			
    stringBuffer.append(TEXT_41);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_42);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_43);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_44);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_45);
    
			connect_end();
		}

		public void connect_begin(){
			logInfo(node,"info",cid+" - Connection attempt to '\" + url_"+cid+" + \"' with the username '\" + dbUser_"+cid+" + \"'.");
		}

		public void connect_begin_noUser(){
			logInfo(node,"info",cid+" - Connection attempt to '\" + url_"+cid+" + \"'.");
		}

		public void connect_end(){
			logInfo(node,"info",cid+" - Connection to '\" + url_"+cid+" + \"' has succeeded.");
		}

		public void rollback(INode node){
			beforeComponentProcess(node);
			logInfo(node,"debug",cid+" - Connection "+connection+"starting to rollback.");
			
    stringBuffer.append(TEXT_46);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_47);
    
			logInfo(node,"debug",cid+" - Connection "+connection+"rollback has succeeded.");
		}

		public void commit(INode node){
			beforeComponentProcess(node);
			commit();
		}

		private void commit(){
			commit_begin();
			
    stringBuffer.append(TEXT_48);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_49);
    
			commit_end();
		}

		private void commit_begin(){
			if(logCommitCounter){
				logInfo(node,"debug",cid+" - Connection "+connection+"starting to commit \" + commitCounter_"+cid+"+ \" records.");
			}else{
				logInfo(node,"debug",cid+" - Connection "+connection+"starting to commit.");
			}
		}
		private void commit_end(){
			logInfo(node,"debug",cid+" - Connection "+connection+"commit has succeeded.");
		}

		public void close(INode node){
			beforeComponentProcess(node);
			close();
		}

		private void close(){
			close_begin();
			
    stringBuffer.append(TEXT_50);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_51);
    
			close_end();
		}

		public void close_begin(){
			logInfo(node,"info",cid+" - Closing the connection "+connection+"to the database.");
		}
		public void close_end(){
			logInfo(node,"info",cid+" - Connection "+connection+"to the database closed.");
		}

		public void autoCommit(INode node,boolean autoCommit){
			beforeComponentProcess(node);
			logInfo(node,"debug",cid+" - Connection is set auto commit to '"+autoCommit+"'.");
			
    stringBuffer.append(TEXT_52);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_53);
    stringBuffer.append(autoCommit);
    stringBuffer.append(TEXT_54);
    
		}

		public void query(INode node){
			beforeComponentProcess(node);
			//for input
	 		String dbquery= ElementParameterParser.getValue(node, "__QUERY__");
			dbquery = dbquery.replaceAll("\n"," ");
			dbquery = dbquery.replaceAll("\r"," ");
			logInfo(node,"info",cid+" - Executing the query: '\" + "+dbquery +" + \"'.");
		}

		public void retrieveRecordsCount(INode node){
			beforeComponentProcess(node);
			logInfo(node,"info",cid+" - Retrieved records count: \"+nb_line_"+cid+" + \" .");
		}

		public void logError(INode node,String logLevel,String exception){
	    	beforeComponentProcess(node);
	    	if(isLog4jEnabled){
	    	
    stringBuffer.append(TEXT_55);
    stringBuffer.append(logLevel);
    stringBuffer.append(TEXT_56);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_57);
    stringBuffer.append(exception);
    stringBuffer.append(TEXT_58);
    
			}
	    }

	    public void logError(INode node,String logLevel){
	    	logError(node,logLevel,"e");
	    }
	    
	    public void logInfo(INode node,String logLevel,String message){
	    	beforeComponentProcess(node);
	    	if(isLog4jEnabled){
	    	
    stringBuffer.append(TEXT_59);
    stringBuffer.append(logLevel);
    stringBuffer.append(TEXT_60);
    stringBuffer.append(message);
    stringBuffer.append(TEXT_61);
    
			}
	    }
		/**
		*batchType :
		*			1: do not get return value of executeBatch();
		*			2: get return value of executeBatch();
		*
		*/
		public void executeBatch(INode node,int batchType){
			beforeComponentProcess(node);
			boolean logBatch = ("true").equals(useBatchSize) && !("").equals(batchSize) && !("0").equals(batchSize);
			if(logBatch){
				logInfo(node,"debug",cid+" - Executing the "+dataAction+" batch.");
			}
			if(batchType==1){
			
    stringBuffer.append(TEXT_62);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_63);
    
			}else if(batchType==2){
				boolean isMysqlBatchInsert = false;
				if ((node.getUniqueName().contains("tMysqlOutput")||node.getUniqueName().contains("tAmazonMysqlOutput")) && ("INSERT").equals(dataAction)) {
					isMysqlBatchInsert = true;
				}
			
    stringBuffer.append(TEXT_64);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_65);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_66);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_67);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_68);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_69);
    stringBuffer.append(isMysqlBatchInsert? "1" : "countEach_"+cid );
    stringBuffer.append(TEXT_70);
    
			}
			if(logBatch){
				logInfo(node,"debug",cid+" - The "+dataAction+" batch execution has succeeded.");
			}
		}
	}

	DefaultLog4jCodeGenerateUtil log4jCodeGenerateUtil = new DefaultLog4jCodeGenerateUtil();

    
	//this util class use by connection component
	class DefaultDBInputUtil {
	
		protected String cid ;
		protected String dbproperties ;
		protected String dbhost;
		protected String dbport;
		protected String dbname;
		protected String dbuser;
		protected String dbpwd ;
		protected boolean isLog4jEnabled;
		protected boolean isDynamic;
		protected DefaultLog4jCodeGenerateUtil log4jCodeGenerateUtil;

		public void beforeComponentProcess(INode node){
			cid = node.getUniqueName();
			List<IMetadataTable> metadatas = node.getMetadataList();
			if ((metadatas != null) && (metadatas.size()>0)) {
				IMetadataTable metadata = metadatas.get(0);
				if (metadata != null) {
					isDynamic = metadata.isDynamicSchema();
				}
			}
			log4jCodeGenerateUtil = new DefaultLog4jCodeGenerateUtil();
		}

		public void afterUseExistConnection(INode node) {
		}
		
		public String getDirverClassName(INode node){
			return "";
		}
	    
	    public void afterUseNewConnection(INode node) {
	    }
	    
	    public void setURL(INode node) {
	    }
	    
		public void createConnection(INode node) {
			this.createConnection(node, true);
		}

		public void createConnection(INode node, boolean needUserAndPassword) {
			cid = node.getUniqueName();
			dbproperties = ElementParameterParser.getValue(node, "__PROPERTIES__");
			dbhost = ElementParameterParser.getValue(node, "__HOST__");
	    	dbport = ElementParameterParser.getValue(node, "__PORT__");
	    	dbname = ElementParameterParser.getValue(node, "__DBNAME__");
	    	dbuser = ElementParameterParser.getValue(node, "__USER__");

	 		boolean specify_alias = "true".equals(ElementParameterParser.getValue(node, "__SPECIFY_DATASOURCE_ALIAS__"));
 		if(specify_alias){

    stringBuffer.append(TEXT_71);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_72);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_73);
    
                String alias = ElementParameterParser.getValue(node, "__DATASOURCE_ALIAS__");

    stringBuffer.append(TEXT_74);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_75);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_76);
    stringBuffer.append((null != alias && !("".equals(alias)))?alias:"\"\"");
    stringBuffer.append(TEXT_77);
    
		}

    stringBuffer.append(TEXT_78);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_79);
    stringBuffer.append(this.getDirverClassName(node) );
    stringBuffer.append(TEXT_80);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_81);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_82);
    stringBuffer.append(dbuser);
    stringBuffer.append(TEXT_83);
    
        		String passwordFieldName = "__PASS__";
        		
    stringBuffer.append(TEXT_84);
    if (ElementParameterParser.canEncrypt(node, passwordFieldName)) {
    stringBuffer.append(TEXT_85);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_86);
    stringBuffer.append(ElementParameterParser.getEncryptedValue(node, passwordFieldName));
    stringBuffer.append(TEXT_87);
    } else {
    stringBuffer.append(TEXT_88);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_89);
    stringBuffer.append( ElementParameterParser.getValue(node, passwordFieldName));
    stringBuffer.append(TEXT_90);
    }
    stringBuffer.append(TEXT_91);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_92);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_93);
    this.setURL(node);
    stringBuffer.append(TEXT_94);
    
				log4jCodeGenerateUtil.debugConnectionParams(node);
				log4jCodeGenerateUtil.connect_begin();
				
    
			if(needUserAndPassword) {

    stringBuffer.append(TEXT_95);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_96);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_97);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_98);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_99);
    
			} else {

    stringBuffer.append(TEXT_100);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_101);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_102);
    
			}
			log4jCodeGenerateUtil.connect_end();

    stringBuffer.append(TEXT_103);
    this.afterUseNewConnection(node);
    
			if(specify_alias){

    stringBuffer.append(TEXT_104);
    
			}
		}
		
		public String getQueryString(INode node) {
			String dbquery= ElementParameterParser.getValue(node, "__QUERY__");
			dbquery = org.talend.core.model.utils.NodeUtil.replaceCRLFInMEMO_SQL(dbquery);
			
			return dbquery;
		}
		
		public void createStatement(INode node) {

    stringBuffer.append(TEXT_105);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_106);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_107);
    
		}
		public void createMinValueStatement(INode node){

    stringBuffer.append(TEXT_108);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_109);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_110);
    }
		public String mappingType(String typeToGenerate) {
		
            if(("byte[]").equals(typeToGenerate)) {
                return "Bytes";
            } else if(("java.util.Date").equals(typeToGenerate)) {
                return "Timestamp";
            } else if(("Integer").equals(typeToGenerate)) {
               return "Int";
            } else {
                return typeToGenerate.substring(0,1).toUpperCase()+typeToGenerate.substring(1);
            }
		}
		//-----------according schema type to generate ResultSet
		public void generateStringCharAndCharacterSet(String firstConnName, IMetadataColumn column, int currentColNo,
					String trimMethod, String typeToGenerate, boolean whetherTrimAllCol, boolean whetherTrimCol) {

    stringBuffer.append(TEXT_111);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_112);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_113);
    if(isDynamic){
    stringBuffer.append(TEXT_114);
    stringBuffer.append(cid);
    }else{
    stringBuffer.append(currentColNo);
    }
    stringBuffer.append(TEXT_115);
    
                    if(whetherTrimAllCol || whetherTrimCol) {

    stringBuffer.append(TEXT_116);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_117);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_118);
    stringBuffer.append(cid);
    stringBuffer.append(trimMethod);
    stringBuffer.append(TEXT_119);
    
                    }

    stringBuffer.append(TEXT_120);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_121);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_122);
    stringBuffer.append(TEXT_123);
    stringBuffer.append(firstConnName);
    stringBuffer.append(TEXT_124);
    stringBuffer.append(column.getLabel());
    stringBuffer.append(TEXT_125);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_126);
    
                        if(("Character").equals(typeToGenerate)) {

    stringBuffer.append(TEXT_127);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_128);
    stringBuffer.append(TEXT_129);
    stringBuffer.append(firstConnName);
    stringBuffer.append(TEXT_130);
    stringBuffer.append(column.getLabel());
    stringBuffer.append(TEXT_131);
    stringBuffer.append(TEXT_132);
    stringBuffer.append(firstConnName);
    stringBuffer.append(TEXT_133);
    stringBuffer.append(column.getLabel());
    stringBuffer.append(TEXT_134);
    
                        } else {

    stringBuffer.append(TEXT_135);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_136);
    stringBuffer.append(TEXT_137);
    stringBuffer.append(firstConnName);
    stringBuffer.append(TEXT_138);
    stringBuffer.append(column.getLabel());
    stringBuffer.append(TEXT_139);
    stringBuffer.append(column.getLabel());
    stringBuffer.append(TEXT_140);
    stringBuffer.append(firstConnName);
    stringBuffer.append(TEXT_141);
    
                        }

    stringBuffer.append(TEXT_142);
    
		}
		
	    public void generateTimestampResultSet(String firstConnName, IMetadataColumn column, int currentColNo) {

    stringBuffer.append(TEXT_143);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_144);
    if(isDynamic){
    stringBuffer.append(TEXT_145);
    stringBuffer.append(cid);
    }else{
    stringBuffer.append(currentColNo);
    }
    stringBuffer.append(TEXT_146);
    stringBuffer.append(firstConnName);
    stringBuffer.append(TEXT_147);
    stringBuffer.append(column.getLabel());
    stringBuffer.append(TEXT_148);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_149);
    if(isDynamic){
    stringBuffer.append(TEXT_150);
    stringBuffer.append(cid);
    }else{
    stringBuffer.append(currentColNo);
    }
    stringBuffer.append(TEXT_151);
    stringBuffer.append(firstConnName);
    stringBuffer.append(TEXT_152);
    stringBuffer.append(column.getLabel());
    stringBuffer.append(TEXT_153);
    
	    }
	    
	    public void generateStringResultSet(String firstConnName, IMetadataColumn column, int currentColNo, String trimMethod) {

    stringBuffer.append(TEXT_154);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_155);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_156);
    if(isDynamic){
    stringBuffer.append(TEXT_157);
    stringBuffer.append(cid);
    }else{
    stringBuffer.append(currentColNo);
    }
    stringBuffer.append(TEXT_158);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_159);
    stringBuffer.append(TEXT_160);
    stringBuffer.append(firstConnName);
    stringBuffer.append(TEXT_161);
    stringBuffer.append(column.getLabel());
    stringBuffer.append(TEXT_162);
    stringBuffer.append(cid);
    stringBuffer.append(trimMethod);
    stringBuffer.append(TEXT_163);
    stringBuffer.append(TEXT_164);
    stringBuffer.append(firstConnName);
    stringBuffer.append(TEXT_165);
    stringBuffer.append(column.getLabel());
    stringBuffer.append(TEXT_166);
    
	    }
	    
	    public void generateBytesResultSet(String firstConnName, IMetadataColumn column, int currentColNo) {
	    }
	    
	    public void generateOthersResultSet(String firstConnName, IMetadataColumn column, int currentColNo, String typeToGenerate) {

    stringBuffer.append(TEXT_167);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_168);
    if(isDynamic){
    stringBuffer.append(TEXT_169);
    stringBuffer.append(cid);
    }else{
    stringBuffer.append(currentColNo);
    }
    stringBuffer.append(TEXT_170);
    stringBuffer.append(TEXT_171);
    stringBuffer.append(firstConnName);
    stringBuffer.append(TEXT_172);
    stringBuffer.append(column.getLabel());
    stringBuffer.append(TEXT_173);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_174);
    stringBuffer.append(typeToGenerate);
    stringBuffer.append(TEXT_175);
    if(isDynamic){
    stringBuffer.append(TEXT_176);
    stringBuffer.append(cid);
    }else{
    stringBuffer.append(currentColNo);
    }
    stringBuffer.append(TEXT_177);
    
                if(column.isNullable()) {
                    
    stringBuffer.append(TEXT_178);
    stringBuffer.append(firstConnName);
    stringBuffer.append(TEXT_179);
    stringBuffer.append(column.getLabel());
    stringBuffer.append(TEXT_180);
    
                } else {
                    
    stringBuffer.append(TEXT_181);
        
                }
                
    stringBuffer.append(TEXT_182);
    
	    }
	    //---------end according schema type to generate ResultSet
	    
		public void afterComponentProcess(INode node){
	    }
	}//end DefaultDBInputUtil class
	
	DefaultDBInputUtil dbInputBeginUtil = new DefaultDBInputUtil();
	
	

    

	class DBInputBeginUtil extends DefaultDBInputUtil{
	
		private INode node = null;
		
		public void beforeComponentProcess(INode node){
	    	super.beforeComponentProcess(node);
	    	this.node = node;
	    }
	
		public void setURL(INode node) {
			
			String localServiceName = ElementParameterParser.getValue(node, "__LOCAL_SERVICE_NAME__");
			String connectionType = ElementParameterParser.getValue(node, "__CONNECTION_TYPE__");
			String jdbcURL = ElementParameterParser.getValue(node, "__JDBC_URL__");

    stringBuffer.append(TEXT_183);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_184);
    
            	if(("ORACLE_SID").equals(connectionType)) {

    stringBuffer.append(TEXT_185);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_186);
    stringBuffer.append(dbhost);
    stringBuffer.append(TEXT_187);
    stringBuffer.append(dbport);
    stringBuffer.append(TEXT_188);
    stringBuffer.append(dbname);
    stringBuffer.append(TEXT_189);
    
            	} else if(("ORACLE_SERVICE_NAME").equals(connectionType)) {

    stringBuffer.append(TEXT_190);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_191);
    stringBuffer.append(dbhost);
    stringBuffer.append(TEXT_192);
    stringBuffer.append(dbport);
    stringBuffer.append(TEXT_193);
    stringBuffer.append(dbname);
    stringBuffer.append(TEXT_194);
    
            	} else if(("ORACLE_OCI").equals(connectionType)) {
            	    
    stringBuffer.append(TEXT_195);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_196);
    stringBuffer.append(localServiceName);
    stringBuffer.append(TEXT_197);
    
            	}else if(("ORACLE_WALLET").equals(connectionType)) {

    stringBuffer.append(TEXT_198);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_199);
    stringBuffer.append(jdbcURL);
    stringBuffer.append(TEXT_200);
    
				}

    stringBuffer.append(TEXT_201);
    
		}
		
		public String getDirverClassName(INode node){
			String dbVersion =  ElementParameterParser.getValue(node, "__DB_VERSION__"); 
			if("ORACLE_11".equals(dbVersion) || "ORACLE_11-6".equals(dbVersion) || "ORACLE_12".equals(dbVersion) ){
			    return "oracle.jdbc.OracleDriver";	
			}else {
				return "oracle.jdbc.driver.OracleDriver";	
			}
		}
		
		public void createConnection(INode node) {
			cid = node.getUniqueName();
			dbproperties = ElementParameterParser.getValue(node, "__PROPERTIES__");
			dbhost = ElementParameterParser.getValue(node, "__HOST__");
	    	dbport = ElementParameterParser.getValue(node, "__PORT__");
	    	dbname = ElementParameterParser.getValue(node, "__DBNAME__");
	    	dbuser = ElementParameterParser.getValue(node, "__USER__");

	 		String connectionType = ElementParameterParser.getValue(node, "__CONNECTION_TYPE__");

    stringBuffer.append(TEXT_202);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_203);
    stringBuffer.append(this.getDirverClassName(node) );
    stringBuffer.append(TEXT_204);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_205);
    this.setURL(node);
    stringBuffer.append(TEXT_206);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_207);
    stringBuffer.append(dbuser);
    stringBuffer.append(TEXT_208);
    
    		String passwordFieldName = "__PASS__";
    		
    stringBuffer.append(TEXT_209);
    if (ElementParameterParser.canEncrypt(node, passwordFieldName)) {
    stringBuffer.append(TEXT_210);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_211);
    stringBuffer.append(ElementParameterParser.getEncryptedValue(node, passwordFieldName));
    stringBuffer.append(TEXT_212);
    } else {
    stringBuffer.append(TEXT_213);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_214);
    stringBuffer.append( ElementParameterParser.getValue(node, passwordFieldName));
    stringBuffer.append(TEXT_215);
    }
    stringBuffer.append(TEXT_216);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_217);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_218);
    
			log4jCodeGenerateUtil.debugConnectionParams(node);
			log4jCodeGenerateUtil.connect_begin();
			if(("ORACLE_WALLET").equals(connectionType)) {

    stringBuffer.append(TEXT_219);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_220);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_221);
    
			}else if (dbproperties == null || ("\"\"").equals(dbproperties) || ("").equals(dbproperties)) {

    stringBuffer.append(TEXT_222);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_223);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_224);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_225);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_226);
    
			} else {

    stringBuffer.append(TEXT_227);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_228);
    stringBuffer.append(dbproperties);
    stringBuffer.append(TEXT_229);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_230);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_231);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_232);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_233);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_234);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_235);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_236);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_237);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_238);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_239);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_240);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_241);
    
			}
			log4jCodeGenerateUtil.connect_end();
		}
		
		public void createStatement(INode node) {
			
			String useCursor= ElementParameterParser.getValue(node, "__USE_CURSOR__");
			String cursorSize= ElementParameterParser.getValue(node, "__CURSOR_SIZE__");
			if(!("true").equals(useCursor)) {
				 super.createStatement(node);
			}else {
            	super.createMinValueStatement(node);

    stringBuffer.append(TEXT_242);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_243);
    stringBuffer.append(cursorSize );
    stringBuffer.append(TEXT_244);
    
            }
		}
		//-----------according schema type to generate ResultSet
		public void generateStringResultSet(String firstConnName, IMetadataColumn column, int currentColNo, String trimMethod) {
			String columnType = column.getType();
			if(columnType != null && ("CLOB").equals(columnType)) {

    stringBuffer.append(TEXT_245);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_246);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_247);
    if(isDynamic){
    stringBuffer.append(TEXT_248);
    stringBuffer.append(cid);
    }else{
    stringBuffer.append(currentColNo);
    }
    stringBuffer.append(TEXT_249);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_250);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_251);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_252);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_253);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_254);
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
    stringBuffer.append(firstConnName);
    stringBuffer.append(TEXT_261);
    stringBuffer.append(column.getLabel());
    stringBuffer.append(TEXT_262);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_263);
    stringBuffer.append(firstConnName);
    stringBuffer.append(TEXT_264);
    stringBuffer.append(column.getLabel());
    stringBuffer.append(TEXT_265);
    
			} else {

    stringBuffer.append(TEXT_266);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_267);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_268);
    if(isDynamic){
    stringBuffer.append(TEXT_269);
    stringBuffer.append(cid);
    }else{
    stringBuffer.append(currentColNo);
    }
    stringBuffer.append(TEXT_270);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_271);
    stringBuffer.append(firstConnName);
    stringBuffer.append(TEXT_272);
    stringBuffer.append(column.getLabel());
    stringBuffer.append(TEXT_273);
    stringBuffer.append(cid);
    stringBuffer.append(trimMethod);
    stringBuffer.append(TEXT_274);
    stringBuffer.append(firstConnName);
    stringBuffer.append(TEXT_275);
    stringBuffer.append(column.getLabel());
    stringBuffer.append(TEXT_276);
    
			}
	    }
	    
	   	public void generateBytesResultSet(String firstConnName, IMetadataColumn column, int currentColNo) {

    stringBuffer.append(TEXT_277);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_278);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_279);
    if(isDynamic){
    stringBuffer.append(TEXT_280);
    stringBuffer.append(cid);
    }else{
    stringBuffer.append(currentColNo);
    }
    stringBuffer.append(TEXT_281);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_282);
    stringBuffer.append(firstConnName);
    stringBuffer.append(TEXT_283);
    stringBuffer.append(column.getLabel());
    stringBuffer.append(TEXT_284);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_285);
    stringBuffer.append(firstConnName);
    stringBuffer.append(TEXT_286);
    stringBuffer.append(column.getLabel());
    stringBuffer.append(TEXT_287);
    
	    }

	   	public void generateOthersResultSet(String firstConnName, IMetadataColumn column, int currentColNo, String typeToGenerate) {
	   		boolean isConvert = ("true").equals(ElementParameterParser.getValue(node, "__IS_CONVERT_XMLTYPE__"));    
			List<Map<String, String>> convertColumns = (List<Map<String,String>>)ElementParameterParser.getObjectValue(node, "__CONVERT_XMLTYPE__");  
	   		
			if(("Object").equals(typeToGenerate)){
			
				boolean needConvert = false;
	   			String convertToJavaType = "";
				if (isConvert && convertColumns.size() > 0) {
					for(java.util.Map<String, String> convertcolumn : convertColumns) {
						if (convertcolumn.get("REFCOL").equals(column.getLabel()) ) {
							needConvert = true;
							convertToJavaType = convertcolumn.get("CONVETTYPE");
						}
					}
				} 
				

    stringBuffer.append(TEXT_288);
    stringBuffer.append(currentColNo);
    stringBuffer.append(TEXT_289);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_290);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_291);
    if(isDynamic){
    stringBuffer.append(TEXT_292);
    stringBuffer.append(cid);
    }else{
    stringBuffer.append(currentColNo);
    }
    stringBuffer.append(TEXT_293);
    stringBuffer.append(currentColNo);
    stringBuffer.append(TEXT_294);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_295);
    
				if (needConvert && "String".equals(convertToJavaType)) {

    stringBuffer.append(TEXT_296);
    stringBuffer.append(firstConnName);
    stringBuffer.append(TEXT_297);
    stringBuffer.append(column.getLabel());
    stringBuffer.append(TEXT_298);
    stringBuffer.append(currentColNo);
    stringBuffer.append(TEXT_299);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_300);
    
				} else {

    stringBuffer.append(TEXT_301);
    stringBuffer.append(firstConnName);
    stringBuffer.append(TEXT_302);
    stringBuffer.append(column.getLabel());
    stringBuffer.append(TEXT_303);
    stringBuffer.append(currentColNo);
    stringBuffer.append(TEXT_304);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_305);
    
				}

    stringBuffer.append(TEXT_306);
    
					if(column.isNullable()) {

    stringBuffer.append(TEXT_307);
    stringBuffer.append(firstConnName);
    stringBuffer.append(TEXT_308);
    stringBuffer.append(column.getLabel());
    stringBuffer.append(TEXT_309);
    
					} else {

    stringBuffer.append(TEXT_310);
        
					}

    stringBuffer.append(TEXT_311);
    
			} else {

    stringBuffer.append(TEXT_312);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_313);
    if(isDynamic){
    stringBuffer.append(TEXT_314);
    stringBuffer.append(cid);
    }else{
    stringBuffer.append(currentColNo);
    }
    stringBuffer.append(TEXT_315);
    stringBuffer.append(firstConnName);
    stringBuffer.append(TEXT_316);
    stringBuffer.append(column.getLabel());
    stringBuffer.append(TEXT_317);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_318);
    stringBuffer.append(typeToGenerate);
    stringBuffer.append(TEXT_319);
    if(isDynamic){
    stringBuffer.append(TEXT_320);
    stringBuffer.append(cid);
    }else{
    stringBuffer.append(currentColNo);
    }
    stringBuffer.append(TEXT_321);
    
					if(column.isNullable()) {

    stringBuffer.append(TEXT_322);
    stringBuffer.append(firstConnName);
    stringBuffer.append(TEXT_323);
    stringBuffer.append(column.getLabel());
    stringBuffer.append(TEXT_324);
    
					} else {

    stringBuffer.append(TEXT_325);
        
					}

    stringBuffer.append(TEXT_326);
    
			}
	    }	    
	    //---------end according schema type to generate ResultSet
	}//end class
	
	dbInputBeginUtil = new DBInputBeginUtil();

    stringBuffer.append(TEXT_327);
    
	CodeGeneratorArgument codeGenArgument = (CodeGeneratorArgument) argument;
	INode node = (INode)codeGenArgument.getArgument();
	String cid = node.getUniqueName();
	String type = ElementParameterParser.getValue(node, "__TYPE__");
	String dbhost = ElementParameterParser.getValue(node, "__HOST__");
	String dbport = ElementParameterParser.getValue(node, "__PORT__");
	String dbname = ElementParameterParser.getValue(node, "__DBNAME__");
	String dbproperties = ElementParameterParser.getValue(node, "__PROPERTIES__");
	String dbuser = ElementParameterParser.getValue(node, "__USER__");

	String dbencoding = ElementParameterParser.getValue(node, "__ENCODING__");
	String enableStream = ElementParameterParser.getValue(node, "__ENABLE_STREAM__");
	String dbms=ElementParameterParser.getValue(node, "__MAPPING__");
	if("tJDBCInput".equals(node.getComponent().getName())) {
		boolean isEnableMapping = ("true").equals(ElementParameterParser.getValue(node, "__ENABLE_MAPPING__"));
		if (!isEnableMapping) {
			dbms = "";
		}
	}
	boolean isLog4jEnabled = ("true").equals(ElementParameterParser.getValue(node.getProcess(), "__LOG4J_ACTIVATE__"));

    boolean whetherTrimAllCol = ("true").equals(ElementParameterParser.getValue(node, "__TRIM_ALL_COLUMN__"));
    List<Map<String, String>> trimColumnList = (List<Map<String,String>>)ElementParameterParser.getObjectValue(node, "__TRIM_COLUMN__");

    dbInputBeginUtil.beforeComponentProcess(node);
    int dynamic_index=-1;
	List<IMetadataTable> metadatas = node.getMetadataList();
	if ((metadatas != null) && (metadatas.size()>0)) {
		IMetadataTable metadata = metadatas.get(0);
		if (metadata != null) {

    stringBuffer.append(TEXT_328);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_329);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_330);
    
		    String useExistingConn = ElementParameterParser.getValue(node,"__USE_EXISTING_CONNECTION__");
		    if(("true").equals(useExistingConn)) {
		        String connection = ElementParameterParser.getValue(node,"__CONNECTION__");
		        String conn = "conn_" + connection;
                if(connection.matches("^.*?tAmazonAuroraConnection_\\d+$")){
                      conn += "_in";
                }

    stringBuffer.append(TEXT_331);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_332);
    stringBuffer.append(conn);
    stringBuffer.append(TEXT_333);
    
                INode connectionNode = null;
                for (INode processNode : node.getProcess().getGeneratingNodes()) {
                	String nodeUniqueName = processNode.getUniqueName();
                	if(connection.equals(nodeUniqueName) || (connection+"_in").equals(nodeUniqueName)) {
                		connectionNode = processNode;
                		break;
                	}
                }
		        boolean specify_alias = "true".equals(ElementParameterParser.getValue(connectionNode, "__SPECIFY_DATASOURCE_ALIAS__"));
		        if(specify_alias){
	                String alias = ElementParameterParser.getValue(connectionNode, "__DATASOURCE_ALIAS__");

    stringBuffer.append(TEXT_334);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_335);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_336);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_337);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_338);
    stringBuffer.append((null != alias && !("".equals(alias)))?alias:"\"\"");
    stringBuffer.append(TEXT_339);
    stringBuffer.append(conn);
    stringBuffer.append(TEXT_340);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_341);
    
		        }
		        
    stringBuffer.append(TEXT_342);
    log4jCodeGenerateUtil.useExistConnection(node);
    
				dbInputBeginUtil.afterUseExistConnection(node);

		    } else {
				dbInputBeginUtil.createConnection(node);
				if ("teradata_id".equalsIgnoreCase(dbms)) {

    stringBuffer.append(TEXT_343);
    
      boolean queryBand = "true".equals(ElementParameterParser.getValue(node, "__QUERY_BAND__"));
      boolean activateQueryLogging = "true".equals(ElementParameterParser.getValue(node, "__ACTIVATE_QUERY_LOGGING__"));
      String usrName = ElementParameterParser.getValue(node, "__USER__");
      List<Map<String, String>> queryBandList = (List<Map<String,String>>)ElementParameterParser.getObjectValue(node, "__QUERY_BAND_PARAMETERS__");
      if(queryBand){
    stringBuffer.append(TEXT_344);
    stringBuffer.append( cid );
    stringBuffer.append(TEXT_345);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_346);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_347);
    
                    if(activateQueryLogging){
                        
    stringBuffer.append(TEXT_348);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_349);
    stringBuffer.append( usrName );
    stringBuffer.append(TEXT_350);
    
                    }
                  
    stringBuffer.append(TEXT_351);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_352);
    
            for(Map<String, String> map : queryBandList) {

    stringBuffer.append(TEXT_353);
    stringBuffer.append( map.get("KEY") );
    stringBuffer.append(TEXT_354);
    stringBuffer.append( map.get("VALUE") );
    stringBuffer.append(TEXT_355);
    
            }

    stringBuffer.append(TEXT_356);
    stringBuffer.append( cid );
    stringBuffer.append(TEXT_357);
    stringBuffer.append( cid );
    stringBuffer.append(TEXT_358);
    }
    
				}
		    }

    stringBuffer.append(TEXT_359);
    dbInputBeginUtil.createStatement(node);
    stringBuffer.append(TEXT_360);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_361);
    stringBuffer.append(dbInputBeginUtil.getQueryString(node));
    stringBuffer.append(TEXT_362);
    if(isLog4jEnabled){
    stringBuffer.append(TEXT_363);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_364);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_365);
    }
    stringBuffer.append(TEXT_366);
     
                if(cid.matches("^.*?tAmazonAuroraInput_\\d+_in$")){
                    // why 3: ==> "_in".length()
                    
    stringBuffer.append(TEXT_367);
    stringBuffer.append( cid.substring(0,cid.length() - 3) );
    stringBuffer.append(TEXT_368);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_369);
    
                }else{
                    
    stringBuffer.append(TEXT_370);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_371);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_372);
    
            }
             
    stringBuffer.append(TEXT_373);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_374);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_375);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_376);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_377);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_378);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_379);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_380);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_381);
    
		    List< ? extends IConnection> conns = node.getOutgoingSortedConnections();
		    List<IMetadataColumn> columnList = metadata.getListColumns();
		    boolean isDynamic = metadata.isDynamicSchema();
		    if(isDynamic){
		    	String DynamicDatePattern = "\"dd-MM-yyyy\"";
		    	for(IMetadataColumn column : columnList) {
		    		if("id_Dynamic".equals(column.getTalendType())) {
		    			DynamicDatePattern = column.getPattern();
		    			break;
		    		}
		    	}
		    
    stringBuffer.append(TEXT_382);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_383);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_384);
    stringBuffer.append(dbms );
    stringBuffer.append(TEXT_385);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_386);
    

		    for(int i=0; i< columnList.size(); i++) {
		        if(columnList.get(i).getTalendType().equals("id_Dynamic")){
		            dynamic_index = i+1;
		        }else{
		            IMetadataColumn column = columnList.get(i);
		            String columName = column.getOriginalDbColumnName();
		            if(columName==null || "".equals(columName)){
		                columName = column.getLabel();
		            }
	            
    stringBuffer.append(TEXT_387);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_388);
    stringBuffer.append(columName.toUpperCase());
    stringBuffer.append(TEXT_389);
    
		    	}
			}
		    
    stringBuffer.append(TEXT_390);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_391);
    stringBuffer.append(dynamic_index-1);
    stringBuffer.append(TEXT_392);
    stringBuffer.append(dynamic_index);
    stringBuffer.append(TEXT_393);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_394);
    stringBuffer.append(columnList.size()-dynamic_index);
    stringBuffer.append(TEXT_395);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_396);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_397);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_398);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_399);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_400);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_401);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_402);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_403);
    stringBuffer.append(dbms );
    stringBuffer.append(TEXT_404);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_405);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_406);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_407);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_408);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_409);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_410);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_411);
     if((DynamicDatePattern!=null) && (!"".equals(DynamicDatePattern)) && (!"\"\"".equals(DynamicDatePattern))) {
    stringBuffer.append(TEXT_412);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_413);
    stringBuffer.append(DynamicDatePattern);
    stringBuffer.append(TEXT_414);
     } 
    
		if (("oracle_id".equalsIgnoreCase(dbms))) {

    stringBuffer.append(TEXT_415);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_416);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_417);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_418);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_419);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_420);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_421);
    
		} else {

    stringBuffer.append(TEXT_422);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_423);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_424);
    
		}

    stringBuffer.append(TEXT_425);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_426);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_427);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_428);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_429);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_430);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_431);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_432);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_433);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_434);
    
		    }
		    
    stringBuffer.append(TEXT_435);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_436);
    if(isDynamic){
    stringBuffer.append(TEXT_437);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_438);
    }
    stringBuffer.append(TEXT_439);
    if(isLog4jEnabled){
    stringBuffer.append(TEXT_440);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_441);
    }
    stringBuffer.append(TEXT_442);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_443);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_444);
    
		        if(conns != null && conns.size() > 0) {
		            IConnection conn = conns.get(0);
		            String firstConnName = conn.getName();
		            int currentColNo = 1;
		            for(IMetadataColumn column : columnList) {
		                boolean whetherTrimCol = false;
		                if((trimColumnList != null && trimColumnList.size() > 0) && !whetherTrimAllCol) {
		                    for(Map<String, String> trimColumn : trimColumnList) {
		                        if(column.getLabel().equals(trimColumn.get("SCHEMA_COLUMN"))) {
		                            if(("true").equals(trimColumn.get("TRIM"))) {
		                                whetherTrimCol = true;
		                                break;
		                            }
		                        }
		                    }
		                }
		                String trimMethod = "";
		                if(whetherTrimAllCol || whetherTrimCol) {
		                    trimMethod = ".trim()";
		                }
		                String columnType = column.getType();

		                String typeToGenerate = JavaTypesManager.getTypeToGenerate(column.getTalendType(), column.isNullable());
		                String defVal = JavaTypesManager.getDefaultValueFromJavaType(typeToGenerate);
		                if(conn.getLineStyle().hasConnectionCategory(IConnectionCategory.DATA)) {
							if(isDynamic){
								if(!("Dynamic").equals(typeToGenerate) && dynamic_index < currentColNo) {
								
    stringBuffer.append(TEXT_445);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_446);
    stringBuffer.append(currentColNo-1);
    stringBuffer.append(TEXT_447);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_448);
    }else{
    stringBuffer.append(TEXT_449);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_450);
    stringBuffer.append(currentColNo);
    stringBuffer.append(TEXT_451);
    }
    stringBuffer.append(TEXT_452);
    
							}
							
    stringBuffer.append(TEXT_453);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_454);
    if(isDynamic){
    stringBuffer.append(TEXT_455);
    stringBuffer.append(cid);
    }else{
    stringBuffer.append(currentColNo);
    }
    stringBuffer.append(TEXT_456);
    stringBuffer.append(firstConnName);
    stringBuffer.append(TEXT_457);
    stringBuffer.append(column.getLabel());
    stringBuffer.append(TEXT_458);
    stringBuffer.append(defVal);
    stringBuffer.append(TEXT_459);
    
								typeToGenerate = dbInputBeginUtil.mappingType(typeToGenerate);

								if(("Char").equals(typeToGenerate) || ("Character").equals(typeToGenerate)) {

    stringBuffer.append(TEXT_460);
    dbInputBeginUtil.generateStringCharAndCharacterSet(firstConnName, column,currentColNo, trimMethod, typeToGenerate, whetherTrimAllCol, whetherTrimCol);
    
								} else if(("Timestamp").equals(typeToGenerate)) {
									if("vertica_id".equalsIgnoreCase(dbms) && "DATE".equalsIgnoreCase(column.getType())){

    stringBuffer.append(TEXT_461);
    dbInputBeginUtil.generateOthersResultSet(firstConnName, column,  currentColNo,  "Date");
    
									}else{

    stringBuffer.append(TEXT_462);
    dbInputBeginUtil.generateTimestampResultSet(firstConnName, column, currentColNo);
    
									}
		                         } else if (("List").equals(typeToGenerate)) {

    stringBuffer.append(TEXT_463);
    stringBuffer.append(firstConnName);
    stringBuffer.append(TEXT_464);
    stringBuffer.append(column.getLabel());
    stringBuffer.append(TEXT_465);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_466);
    if(isDynamic){
    stringBuffer.append(TEXT_467);
    stringBuffer.append(cid);
    }else{
    stringBuffer.append(currentColNo);
    }
    stringBuffer.append(TEXT_468);
    
		                        } else if(("String").equals(typeToGenerate)) {

    stringBuffer.append(TEXT_469);
    dbInputBeginUtil.generateStringResultSet(firstConnName, column, currentColNo,trimMethod);
    
								} else if("Geometry".equals(typeToGenerate) && type.indexOf("ORACLE") >= 0) {

    stringBuffer.append(TEXT_470);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_471);
    if(isDynamic){
    stringBuffer.append(TEXT_472);
    stringBuffer.append(cid);
    }else{
    stringBuffer.append(currentColNo);
    }
    stringBuffer.append(TEXT_473);
    stringBuffer.append(TEXT_474);
    stringBuffer.append(firstConnName);
    stringBuffer.append(TEXT_475);
    stringBuffer.append(column.getLabel());
    stringBuffer.append(TEXT_476);
    stringBuffer.append(TEXT_477);
    stringBuffer.append(firstConnName);
    stringBuffer.append(TEXT_478);
    stringBuffer.append(column.getLabel());
    stringBuffer.append(TEXT_479);
    
                                    String sourceCRS = ElementParameterParser.getValue(node,"__CRS__");
                                    String forceCRS = ElementParameterParser.getValue(node,"__FORCE_CRS__");
                                    if (forceCRS.equals("true")) {

    stringBuffer.append(TEXT_480);
    stringBuffer.append(firstConnName);
    stringBuffer.append(TEXT_481);
    stringBuffer.append(column.getLabel());
    stringBuffer.append(TEXT_482);
    stringBuffer.append(TEXT_483);
    stringBuffer.append(firstConnName);
    stringBuffer.append(TEXT_484);
    stringBuffer.append(column.getLabel());
    stringBuffer.append(TEXT_485);
    stringBuffer.append(sourceCRS);
    stringBuffer.append(TEXT_486);
    
                                    }
								} else if(("Bytes").equals(typeToGenerate) && (columnType != null && (("LONG RAW").equals(columnType) || ("RAW").equals(columnType)))) {//oracle

    stringBuffer.append(TEXT_487);
    dbInputBeginUtil.generateBytesResultSet(firstConnName, column, currentColNo);
    
								} else if(("Dynamic").equals(typeToGenerate)) {

    stringBuffer.append(TEXT_488);
    stringBuffer.append(firstConnName);
    stringBuffer.append(TEXT_489);
    stringBuffer.append(column.getLabel());
    stringBuffer.append(TEXT_490);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_491);
     //for bug TDI-20886
									boolean trim = whetherTrimAllCol || whetherTrimCol;
									if ("id_MSSQL".equalsIgnoreCase(dbms)) {

    stringBuffer.append(TEXT_492);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_493);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_494);
    stringBuffer.append(metadata.getListColumns().size());
    stringBuffer.append(TEXT_495);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_496);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_497);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_498);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_499);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_500);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_501);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_502);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_503);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_504);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_505);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_506);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_507);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_508);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_509);
    stringBuffer.append(firstConnName);
    stringBuffer.append(TEXT_510);
    stringBuffer.append(column.getLabel());
    stringBuffer.append(TEXT_511);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_512);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_513);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_514);
    stringBuffer.append(trim);
    stringBuffer.append(TEXT_515);
    
									}else if("access_id".equalsIgnoreCase(dbms)){

    stringBuffer.append(TEXT_516);
    stringBuffer.append(firstConnName);
    stringBuffer.append(TEXT_517);
    stringBuffer.append(column.getLabel());
    stringBuffer.append(TEXT_518);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_519);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_520);
    stringBuffer.append(trim);
    stringBuffer.append(TEXT_521);
    
									}else{

    stringBuffer.append(TEXT_522);
    stringBuffer.append(firstConnName);
    stringBuffer.append(TEXT_523);
    stringBuffer.append(column.getLabel());
    stringBuffer.append(TEXT_524);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_525);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_526);
    stringBuffer.append(trim);
    stringBuffer.append(TEXT_527);
    
									}
								} else if(typeToGenerate.equals("Geometry")) {

    stringBuffer.append(TEXT_528);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_529);
    if(isDynamic){
    stringBuffer.append(TEXT_530);
    stringBuffer.append(cid);
    }else{
    stringBuffer.append(currentColNo);
    }
    stringBuffer.append(TEXT_531);
    stringBuffer.append(firstConnName);
    stringBuffer.append(TEXT_532);
    stringBuffer.append(column.getLabel());
    stringBuffer.append(TEXT_533);
    stringBuffer.append(firstConnName);
    stringBuffer.append(TEXT_534);
    stringBuffer.append(column.getLabel());
    stringBuffer.append(TEXT_535);
    
                 	            } else {

    stringBuffer.append(TEXT_536);
    dbInputBeginUtil.generateOthersResultSet( firstConnName, column,  currentColNo,  typeToGenerate);
    
		                        }

    stringBuffer.append(TEXT_537);
    
		                    currentColNo++;
		                }
		            }

    stringBuffer.append(TEXT_538);
    if(isLog4jEnabled){
    stringBuffer.append(TEXT_539);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_540);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_541);
    }
    
		            if(conns.size() > 1) {
		                for(int connNO = 1 ; connNO < conns.size() ; connNO++) {
		                    IConnection conn2 = conns.get(connNO);
		                    if((conn2.getName().compareTo(firstConnName) != 0) && (conn2.getLineStyle().hasConnectionCategory(IConnectionCategory.DATA))) {
		                        for(IMetadataColumn column:columnList){
		                            
    stringBuffer.append(TEXT_542);
    stringBuffer.append(conn2.getName());
    stringBuffer.append(TEXT_543);
    stringBuffer.append(column.getLabel());
    stringBuffer.append(TEXT_544);
    stringBuffer.append(firstConnName);
    stringBuffer.append(TEXT_545);
    stringBuffer.append(column.getLabel());
    stringBuffer.append(TEXT_546);
    
		                        }
		                    }
		                }
		            }
		        }
		}
	}

    stringBuffer.append(TEXT_547);
    stringBuffer.append(TEXT_548);
    return stringBuffer.toString();
  }
}
