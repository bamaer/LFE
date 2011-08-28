package org.pentaho.reporting.libraries.formula.function.logical;

import java.math.BigDecimal;
import java.util.Calendar;
import java.util.Date;

import org.pentaho.reporting.libraries.formula.EvaluationException;
import org.pentaho.reporting.libraries.formula.FormulaContext;
import org.pentaho.reporting.libraries.formula.LibFormulaErrorValue;
import org.pentaho.reporting.libraries.formula.function.Function;
import org.pentaho.reporting.libraries.formula.function.ParameterCallback;
import org.pentaho.reporting.libraries.formula.lvalues.TypeValuePair;
import org.pentaho.reporting.libraries.formula.typing.Type;
import org.pentaho.reporting.libraries.formula.typing.TypeConversionException;
import org.pentaho.reporting.libraries.formula.typing.TypeRegistry;
import org.pentaho.reporting.libraries.formula.typing.coretypes.LogicalType;

public class InFunction implements Function
{
	
	private static final TypeValuePair RETURN_FALSE = new TypeValuePair(LogicalType.TYPE, Boolean.FALSE);
	private static final TypeValuePair RETURN_TRUE = new TypeValuePair(LogicalType.TYPE, Boolean.TRUE);
	private boolean tmpTrueFalse = false; 
    private static final long serialVersionUID = 2486417585939551783L;

  public InFunction(){
  }

  public String getCanonicalName(){
    return "IN";
  }

  public TypeValuePair evaluate(FormulaContext context,  ParameterCallback parameters) throws EvaluationException
  {
	  tmpTrueFalse = false; 
	    final int parameterCount = parameters.getParameterCount();
	    if (parameterCount < 2)
	    {
	      throw EvaluationException.getInstance(LibFormulaErrorValue.ERROR_ARGUMENTS_VALUE);
	    }
	    
	    final TypeRegistry typeRegistry = context.getTypeRegistry();
	    	    	
	    final Type t = parameters.getType(0);
	    final Object o = parameters.getValue(0);
	    final String refStr = typeRegistry.convertToText(t, o);
	    	
	    for (int i=1; i < parameters.getParameterCount() ; i++){
	    	final Type tc = parameters.getType(i);
	    	final Object oc = parameters.getValue(i);
		    final String compareStr = typeRegistry.convertToText(tc,oc);
		    if(refStr.equals(compareStr)){
		    	tmpTrueFalse = true; 
		    }
	    }
	    if(tmpTrueFalse) 
		   	return RETURN_TRUE;
	    else 
	    	return RETURN_FALSE;
	    
  }
}
