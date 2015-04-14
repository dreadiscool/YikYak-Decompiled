package com.parse;

public abstract class GetDataCallback
  extends ParseCallback<byte[]>
{
  public abstract void done(byte[] paramArrayOfByte, ParseException paramParseException);
  
  final void internalDone(byte[] paramArrayOfByte, ParseException paramParseException)
  {
    done(paramArrayOfByte, paramParseException);
  }
}


/* Location:           C:\Users\dreadiscool\Desktop\tools\classes-dex2jar.jar
 * Qualified Name:     com.parse.GetDataCallback
 * JD-Core Version:    0.7.0.1
 */