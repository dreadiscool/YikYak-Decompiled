package com.facebook.internal;

import java.io.InputStream;
import java.io.OutputStream;

final class FileLruCache$CopyingInputStream
  extends InputStream
{
  final InputStream input;
  final OutputStream output;
  
  FileLruCache$CopyingInputStream(InputStream paramInputStream, OutputStream paramOutputStream)
  {
    this.input = paramInputStream;
    this.output = paramOutputStream;
  }
  
  public int available()
  {
    return this.input.available();
  }
  
  public void close()
  {
    try
    {
      this.input.close();
      return;
    }
    finally
    {
      this.output.close();
    }
  }
  
  public void mark(int paramInt)
  {
    throw new UnsupportedOperationException();
  }
  
  public boolean markSupported()
  {
    return false;
  }
  
  public int read()
  {
    int i = this.input.read();
    if (i >= 0) {
      this.output.write(i);
    }
    return i;
  }
  
  public int read(byte[] paramArrayOfByte)
  {
    int i = this.input.read(paramArrayOfByte);
    if (i > 0) {
      this.output.write(paramArrayOfByte, 0, i);
    }
    return i;
  }
  
  public int read(byte[] paramArrayOfByte, int paramInt1, int paramInt2)
  {
    int i = this.input.read(paramArrayOfByte, paramInt1, paramInt2);
    if (i > 0) {
      this.output.write(paramArrayOfByte, paramInt1, i);
    }
    return i;
  }
  
  public void reset()
  {
    try
    {
      throw new UnsupportedOperationException();
    }
    finally {}
  }
  
  public long skip(long paramLong)
  {
    byte[] arrayOfByte = new byte[1024];
    int i;
    for (long l = 0L;; l += i) {
      if (l < paramLong)
      {
        i = read(arrayOfByte, 0, (int)Math.min(paramLong - l, arrayOfByte.length));
        if (i >= 0) {}
      }
      else
      {
        return l;
      }
    }
  }
}


/* Location:           C:\Users\dreadiscool\Desktop\tools\classes-dex2jar.jar
 * Qualified Name:     com.facebook.internal.FileLruCache.CopyingInputStream
 * JD-Core Version:    0.7.0.1
 */