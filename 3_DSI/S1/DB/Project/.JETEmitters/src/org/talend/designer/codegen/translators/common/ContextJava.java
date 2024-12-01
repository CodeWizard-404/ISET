package org.talend.designer.codegen.translators.common;

import org.talend.core.model.process.IContextParameter;
import org.talend.designer.codegen.config.CodeGeneratorArgument;
import java.util.List;
import java.util.Properties;
import java.io.ByteArrayOutputStream;
import org.talend.core.model.utils.TalendTextUtils;
import org.talend.core.model.utils.ContextOrderProperties;

public class ContextJava
{
  protected static String nl;
  public static synchronized ContextJava create(String lineSeparator)
  {
    nl = lineSeparator;
    ContextJava result = new ContextJava();
    nl = null;
    return result;
  }

  public final String NL = nl == null ? (System.getProperties().getProperty("line.separator")) : nl;
  protected final String TEXT_1 = "";

  public String generate(Object argument)
  {
    final StringBuffer stringBuffer = new StringBuffer();
    
	CodeGeneratorArgument codeGenArgument = (CodeGeneratorArgument) argument;
	List<IContextParameter> parameterList = (List<IContextParameter>) codeGenArgument.getArgument();
	ContextOrderProperties contextProperty = new ContextOrderProperties(parameterList);

    ByteArrayOutputStream baos = new ByteArrayOutputStream();
    try {
        contextProperty.store(baos, "this is context properties");
    } catch (java.lang.Exception e) {
        e.printStackTrace();
    }

    stringBuffer.append(TEXT_1);
    stringBuffer.append(baos );
    return stringBuffer.toString();
  }
}
