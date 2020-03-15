package org.talend.designer.codegen.translators.talendmdm;

import org.talend.core.model.process.INode;
import org.talend.core.model.process.ElementParameterParser;
import org.talend.designer.codegen.config.CodeGeneratorArgument;

public class TMDMDeleteBeginJava
{
  protected static String nl;
  public static synchronized TMDMDeleteBeginJava create(String lineSeparator)
  {
    nl = lineSeparator;
    TMDMDeleteBeginJava result = new TMDMDeleteBeginJava();
    nl = null;
    return result;
  }

  public final String NL = nl == null ? (System.getProperties().getProperty("line.separator")) : nl;
  protected final String TEXT_1 = "       " + NL;
  protected final String TEXT_2 = NL + "int nb_line_";
  protected final String TEXT_3 = " = 0;";
  protected final String TEXT_4 = NL + "\torg.talend.mdm.webservice.TMDMService_ServiceLocator tmdmService_";
  protected final String TEXT_5 = " = new org.talend.mdm.webservice.TMDMService_ServiceLocator();" + NL + "\ttmdmService_";
  protected final String TEXT_6 = ".setTMDMPortEndpointAddress(";
  protected final String TEXT_7 = ");" + NL + "\torg.talend.mdm.webservice.TMDMService_PortType tmdmWS_";
  protected final String TEXT_8 = " = tmdmService_";
  protected final String TEXT_9 = ".getTMDMPort();    " + NL + "\torg.talend.mdm.webservice.TMDMServiceSoapBindingStub stub_";
  protected final String TEXT_10 = " = (org.talend.mdm.webservice.TMDMServiceSoapBindingStub)tmdmWS_";
  protected final String TEXT_11 = ";" + NL + "\t" + NL + "\t// Authentification" + NL + "\tstub_";
  protected final String TEXT_12 = ".setUsername(";
  protected final String TEXT_13 = ");" + NL + "\t";
  protected final String TEXT_14 = NL + "    ";
  protected final String TEXT_15 = " " + NL + "\tfinal String decryptedPassword_";
  protected final String TEXT_16 = " = routines.system.PasswordEncryptUtil.decryptPassword(";
  protected final String TEXT_17 = ");";
  protected final String TEXT_18 = NL + "\tfinal String decryptedPassword_";
  protected final String TEXT_19 = " = ";
  protected final String TEXT_20 = "; ";
  protected final String TEXT_21 = NL + "    " + NL + "\tstub_";
  protected final String TEXT_22 = ".setPassword(decryptedPassword_";
  protected final String TEXT_23 = ");";
  protected final String TEXT_24 = NL + "\torg.talend.mdm.webservice.TMDMService_PortType tmdmWS_";
  protected final String TEXT_25 = " = (org.talend.mdm.webservice.TMDMService_PortType)globalMap.get(\"";
  protected final String TEXT_26 = "\");";
  protected final String TEXT_27 = NL + "org.talend.mdm.webservice.WSDataClusterPK dataCluster_";
  protected final String TEXT_28 = " = new org.talend.mdm.webservice.WSDataClusterPK(";
  protected final String TEXT_29 = " + \"";
  protected final String TEXT_30 = "\");";

  public String generate(Object argument)
  {
    final StringBuffer stringBuffer = new StringBuffer();
    
	CodeGeneratorArgument codeGenArgument = (CodeGeneratorArgument) argument;
	INode node = (INode)codeGenArgument.getArgument();
	String cid = node.getUniqueName();
	
	boolean useExistingConn = ("true").equals(ElementParameterParser.getValue(node,"__USE_EXISTING_CONNECTION__"));
	String connection = ElementParameterParser.getValue(node,"__CONNECTION__");
	String mdmUrl = ElementParameterParser.getValue(node, "__MDMURL__");
	String username = ElementParameterParser.getValue(node, "__USERNAME__");

	String universe = ElementParameterParser.getValue(node, "__UNIVERSE__");
	String dataModule = ElementParameterParser.getValue(node, "__CONCEPT__");
	String dataCluster = ElementParameterParser.getValue(node, "__DATACLUSTER__");
	boolean isStaging = "STAGING".equalsIgnoreCase(ElementParameterParser.getValue(node, "__CONTAINER_TYPE__"));

    stringBuffer.append(TEXT_1);
    String conn = "TMDMService_" + connection;
    stringBuffer.append(TEXT_2);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_3);
    if(!useExistingConn){
    stringBuffer.append(TEXT_4);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_5);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_6);
    stringBuffer.append(mdmUrl );
    stringBuffer.append(TEXT_7);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_8);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_9);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_10);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_11);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_12);
    stringBuffer.append(username );
    stringBuffer.append(TEXT_13);
    
    String passwordFieldName = "__PASSWORD__";
    
    stringBuffer.append(TEXT_14);
    if (ElementParameterParser.canEncrypt(node, passwordFieldName)) {
    stringBuffer.append(TEXT_15);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_16);
    stringBuffer.append(ElementParameterParser.getEncryptedValue(node, passwordFieldName));
    stringBuffer.append(TEXT_17);
    } else {
    stringBuffer.append(TEXT_18);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_19);
    stringBuffer.append( ElementParameterParser.getValue(node, passwordFieldName));
    stringBuffer.append(TEXT_20);
    }
    stringBuffer.append(TEXT_21);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_22);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_23);
    }else{
    stringBuffer.append(TEXT_24);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_25);
    stringBuffer.append(conn);
    stringBuffer.append(TEXT_26);
    }
    stringBuffer.append(TEXT_27);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_28);
    stringBuffer.append(dataCluster );
    stringBuffer.append(TEXT_29);
    stringBuffer.append(isStaging?"#STAGING":"");
    stringBuffer.append(TEXT_30);
    return stringBuffer.toString();
  }
}
