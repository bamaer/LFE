package org.pentaho.reporting.libraries.formula.function.datetime;

import java.math.BigDecimal;
import java.util.Calendar;
import java.util.Date;

import org.pentaho.reporting.libraries.formula.EvaluationException;
import org.pentaho.reporting.libraries.formula.FormulaContext;
import org.pentaho.reporting.libraries.formula.LibFormulaErrorValue;
import org.pentaho.reporting.libraries.formula.function.Function;
import org.pentaho.reporting.libraries.formula.function.ParameterCallback;
import org.pentaho.reporting.libraries.formula.lvalues.TypeValuePair;
import org.pentaho.reporting.libraries.formula.typing.TypeRegistry;
import org.pentaho.reporting.libraries.formula.typing.coretypes.NumberType;
import org.pentaho.reporting.libraries.formula.util.DateUtil;

public class QuarterFunction implements Function
{
  private static final long serialVersionUID = 2486417585939551783L;

  public QuarterFunction()
  {
  }

  public String getCanonicalName()
  {
    return "QUARTER";
  }

  public TypeValuePair evaluate(final FormulaContext context,
      final ParameterCallback parameters) throws EvaluationException
  {
    if (parameters.getParameterCount() != 1)
    {
      throw EvaluationException.getInstance(LibFormulaErrorValue.ERROR_ARGUMENTS_VALUE);
    }

    final TypeRegistry typeRegistry = context.getTypeRegistry();

    final Date d = typeRegistry.convertToDate(parameters.getType(0), parameters.getValue(0));

    if (d == null)
    {
      throw EvaluationException.getInstance(
          LibFormulaErrorValue.ERROR_INVALID_ARGUMENT_VALUE);
    }

    final Calendar gc = DateUtil.createCalendar(d, context.getLocalizationContext());
    final int tmpQ = gc.get(Calendar.MONTH);
    int quarter = -1;
    if(tmpQ >= 0 && tmpQ <= 2)
    	quarter = 1;
    else if (tmpQ >= 3 && tmpQ <= 5)
    	quarter = 2;
    else if (tmpQ >= 6 && tmpQ <= 8)
    	quarter = 3; 
    else if(tmpQ >= 9 && tmpQ <= 11)
    	quarter = 4;
    return new TypeValuePair(NumberType.GENERIC_NUMBER, new BigDecimal((double)quarter));
  }
}
