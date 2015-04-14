package com.parse;

public abstract class CountCallback
  extends ParseCallback<Integer>
{
  public abstract void done(int paramInt, ParseException paramParseException);
  
  void internalDone(Integer paramInteger, ParseException paramParseException)
  {
    if (paramParseException == null) {
      done(paramInteger.intValue(), null);
    }
    for (;;)
    {
      return;
      done(-1, paramParseException);
    }
  }
}


/* Location:           C:\Users\dreadiscool\Desktop\tools\classes-dex2jar.jar
 * Qualified Name:     com.parse.CountCallback
 * JD-Core Version:    0.7.0.1
 */