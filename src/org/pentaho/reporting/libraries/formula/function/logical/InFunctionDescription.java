package org.pentaho.reporting.libraries.formula.function.logical;

import org.pentaho.reporting.libraries.formula.function.AbstractFunctionDescription;
import org.pentaho.reporting.libraries.formula.function.FunctionCategory;
import org.pentaho.reporting.libraries.formula.typing.Type;
import org.pentaho.reporting.libraries.formula.typing.coretypes.AnyType;
import org.pentaho.reporting.libraries.formula.typing.coretypes.DateTimeType;
import org.pentaho.reporting.libraries.formula.typing.coretypes.LogicalType;
import org.pentaho.reporting.libraries.formula.typing.coretypes.NumberType;
import org.pentaho.reporting.libraries.formula.typing.coretypes.TextType;

/**
 * Describes InFunction function.
 * 
 * @see InFunction
 * 
 * @author Bart Maertens
 */
public class InFunctionDescription extends AbstractFunctionDescription
{
  private static final long serialVersionUID = 1152202788652836026L;

  public InFunctionDescription()
  {
    super("IN", "org.pentaho.reporting.libraries.formula.function.logical.InFunction");
  }

  public Type getValueType()
  {
    return AnyType.TYPE;
  }

  public int getParameterCount()
  {
    return 10;
  }

  public Type getParameterType(final int position)
  {
    return AnyType.TYPE;
  }

  public boolean isParameterMandatory(final int position)
  {
    return true;
  }

  public FunctionCategory getCategory()
  {
    return LogicalFunctionCategory.CATEGORY;
  }
}