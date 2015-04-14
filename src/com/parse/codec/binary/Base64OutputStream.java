package com.parse.codec.binary;

import java.io.OutputStream;

public class Base64OutputStream
  extends BaseNCodecOutputStream
{
  public Base64OutputStream(OutputStream paramOutputStream)
  {
    this(paramOutputStream, true);
  }
  
  public Base64OutputStream(OutputStream paramOutputStream, boolean paramBoolean)
  {
    super(paramOutputStream, new Base64(false), paramBoolean);
  }
  
  public Base64OutputStream(OutputStream paramOutputStream, boolean paramBoolean, int paramInt, byte[] paramArrayOfByte)
  {
    super(paramOutputStream, new Base64(paramInt, paramArrayOfByte), paramBoolean);
  }
}


/* Location:           C:\Users\dreadiscool\Desktop\tools\classes-dex2jar.jar
 * Qualified Name:     com.parse.codec.binary.Base64OutputStream
 * JD-Core Version:    0.7.0.1
 */