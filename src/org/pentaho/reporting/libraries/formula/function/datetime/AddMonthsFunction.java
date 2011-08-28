package org.pentaho.reporting.libraries.formula.function.datetime;

import java.math.BigDecimal;
import java.util.Date;
import java.util.Calendar;

import org.pentaho.reporting.libraries.formula.EvaluationException;
import org.pentaho.reporting.libraries.formula.FormulaContext;
import org.pentaho.reporting.libraries.formula.LibFormulaErrorValue;
import org.pentaho.reporting.libraries.formula.function.Function;
import org.pentaho.reporting.libraries.formula.function.ParameterCallback;
import org.pentaho.reporting.libraries.formula.lvalues.TypeValuePair;
import org.pentaho.reporting.libraries.formula.typing.TypeRegistry;
import org.pentaho.reporting.libraries.formula.typing.coretypes.DateTimeType;
import org.pentaho.reporting.libraries.formula.typing.coretypes.NumberType;
import org.pentaho.reporting.libraries.formula.util.DateUtil;

public class AddMonthsFunction implements Function{

	  private static final long serialVersionUID = 2486417585939551783L;
	  
	  public AddMonthsFunction(){
		  
	  }
	  
	  public String getCanonicalName()
	  {
	    return "ADD_MONTHS";
	  }

	  public TypeValuePair evaluate(final FormulaContext context,
		      final ParameterCallback parameters) throws EvaluationException
		  {
		    if (parameters.getParameterCount() != 2)
		    {
		      throw EvaluationException.getInstance(LibFormulaErrorValue.ERROR_ARGUMENTS_VALUE);
		    }

		    final TypeRegistry typeRegistry = context.getTypeRegistry();

		    final Date d = typeRegistry.convertToDate(parameters.getType(0), parameters.getValue(0));
		    final Number nb_months = typeRegistry.convertToNumber(parameters.getType(1), parameters.getValue(1));

		    if (d == null  || nb_months == null)
		    {
		      throw EvaluationException.getInstance(
		          LibFormulaErrorValue.ERROR_INVALID_ARGUMENT_VALUE);
		    }
		    

		    final Calendar gc = DateUtil.createCalendar(d, context.getLocalizationContext());
		    
		    gc.add(gc.MONTH, nb_months.intValue());
		    
		    
		    
		    return new TypeValuePair(DateTimeType.DATE_TYPE, typeRegistry.convertToDate(DateTimeType.DATE_TYPE, gc.getTime()));
		  }

}
