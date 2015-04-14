package com.parse;

public abstract class ConfigCallback
  extends ParseCallback<ParseConfig>
{
  public abstract void done(ParseConfig paramParseConfig, ParseException paramParseException);
  
  final void internalDone(ParseConfig paramParseConfig, ParseException paramParseException)
  {
    done(paramParseConfig, paramParseException);
  }
}


/* Location:           C:\Users\dreadiscool\Desktop\tools\classes-dex2jar.jar
 * Qualified Name:     com.parse.ConfigCallback
 * JD-Core Version:    0.7.0.1
 */