package com.parse;

public abstract class SendCallback
  extends ParseCallback<Void>
{
  public abstract void done(ParseException paramParseException);
  
  final void internalDone(Void paramVoid, ParseException paramParseException)
  {
    done(paramParseException);
  }
}


/* Location:           C:\Users\dreadiscool\Desktop\tools\classes-dex2jar.jar
 * Qualified Name:     com.parse.SendCallback
 * JD-Core Version:    0.7.0.1
 */