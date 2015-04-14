package com.parse.codec.binary;

import java.io.InputStream;

public class Base32InputStream
  extends BaseNCodecInputStream
{
  public Base32InputStream(InputStream paramInputStream)
  {
    this(paramInputStream, false);
  }
  
  public Base32InputStream(InputStream paramInputStream, boolean paramBoolean)
  {
    super(paramInputStream, new Base32(false), paramBoolean);
  }
  
  public Base32InputStream(InputStream paramInputStream, boolean paramBoolean, int paramInt, byte[] paramArrayOfByte)
  {
    super(paramInputStream, new Base32(paramInt, paramArrayOfByte), paramBoolean);
  }
}


/* Location:           C:\Users\dreadiscool\Desktop\tools\classes-dex2jar.jar
 * Qualified Name:     com.parse.codec.binary.Base32InputStream
 * JD-Core Version:    0.7.0.1
 */