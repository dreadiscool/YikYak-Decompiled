package com.parse;

public abstract class RefreshCallback
  extends ParseCallback<ParseObject>
{
  public abstract void done(ParseObject paramParseObject, ParseException paramParseException);
  
  final void internalDone(ParseObject paramParseObject, ParseException paramParseException)
  {
    done(paramParseObject, paramParseException);
  }
}


/* Location:           C:\Users\dreadiscool\Desktop\tools\classes-dex2jar.jar
 * Qualified Name:     com.parse.RefreshCallback
 * JD-Core Version:    0.7.0.1
 */