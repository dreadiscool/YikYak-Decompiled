package com.parse.codec.binary;

import java.io.OutputStream;

public class Base32OutputStream
  extends BaseNCodecOutputStream
{
  public Base32OutputStream(OutputStream paramOutputStream)
  {
    this(paramOutputStream, true);
  }
  
  public Base32OutputStream(OutputStream paramOutputStream, boolean paramBoolean)
  {
    super(paramOutputStream, new Base32(false), paramBoolean);
  }
  
  public Base32OutputStream(OutputStream paramOutputStream, boolean paramBoolean, int paramInt, byte[] paramArrayOfByte)
  {
    super(paramOutputStream, new Base32(paramInt, paramArrayOfByte), paramBoolean);
  }
}


/* Location:           C:\Users\dreadiscool\Desktop\tools\classes-dex2jar.jar
 * Qualified Name:     com.parse.codec.binary.Base32OutputStream
 * JD-Core Version:    0.7.0.1
 */