package com.parse;

public abstract class GetCallback<T extends ParseObject>
  extends ParseCallback<T>
{
  public abstract void done(T paramT, ParseException paramParseException);
  
  final void internalDone(T paramT, ParseException paramParseException)
  {
    done(paramT, paramParseException);
  }
}


/* Location:           C:\Users\dreadiscool\Desktop\tools\classes-dex2jar.jar
 * Qualified Name:     com.parse.GetCallback
 * JD-Core Version:    0.7.0.1
 */