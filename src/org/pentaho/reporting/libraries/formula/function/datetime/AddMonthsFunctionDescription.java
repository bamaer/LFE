package org.pentaho.reporting.libraries.formula.function.datetime;

import org.pentaho.reporting.libraries.formula.function.AbstractFunctionDescription;
import org.pentaho.reporting.libraries.formula.function.FunctionCategory;
import org.pentaho.reporting.libraries.formula.typing.Type;
import org.pentaho.reporting.libraries.formula.typing.coretypes.DateTimeType;
import org.pentaho.reporting.libraries.formula.typing.coretypes.NumberType;

public class AddMonthsFunctionDescription extends AbstractFunctionDescription{
	  private static final long serialVersionUID = 1152202788652836026L;

	  public AddMonthsFunctionDescription()
	  {
	    super("ADD_MONTHS", "org.pentaho.reporting.libraries.formula.function.datetime.AddMonthsFunction");
	  }

	  public Type getValueType()
	  {
	    return NumberType.GENERIC_NUMBER;
	  }

	  public int getParameterCount()
	  {
	    return 1;
	  }

	  public Type getParameterType(final int position)
	  {
	    return DateTimeType.DATE_TYPE;
	  }

	  public boolean isParameterMandatory(final int position)
	  {
	    return true;
	  }

	  public FunctionCategory getCategory()
	  {
	    return DateTimeFunctionCategory.CATEGORY;
	  }

}
