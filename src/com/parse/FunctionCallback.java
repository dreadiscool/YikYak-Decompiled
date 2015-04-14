package com.parse;

public abstract class FunctionCallback<T>
  extends ParseCallback<T>
{
  public abstract void done(T paramT, ParseException paramParseException);
  
  final void internalDone(T paramT, ParseException paramParseException)
  {
    done(paramT, paramParseException);
  }
}


/* Location:           C:\Users\dreadiscool\Desktop\tools\classes-dex2jar.jar
 * Qualified Name:     com.parse.FunctionCallback
 * JD-Core Version:    0.7.0.1
 */