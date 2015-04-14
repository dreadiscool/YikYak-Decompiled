package com.parse;

import java.io.ByteArrayOutputStream;
import java.io.Closeable;
import java.io.EOFException;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;

class ParseIOUtils
{
  private static final int DEFAULT_BUFFER_SIZE = 4096;
  private static final int EOF = -1;
  private static final int SKIP_BUFFER_SIZE = 2048;
  private static byte[] SKIP_BYTE_BUFFER;
  
  public static void closeQuietly(Closeable paramCloseable)
  {
    if (paramCloseable != null) {}
    try
    {
      paramCloseable.close();
      label10:
      return;
    }
    catch (IOException localIOException)
    {
      break label10;
    }
  }
  
  public static void closeQuietly(InputStream paramInputStream)
  {
    if (paramInputStream != null) {}
    try
    {
      paramInputStream.close();
      label8:
      return;
    }
    catch (IOException localIOException)
    {
      break label8;
    }
  }
  
  public static void closeQuietly(OutputStream paramOutputStream)
  {
    if (paramOutputStream != null) {}
    try
    {
      paramOutputStream.close();
      label8:
      return;
    }
    catch (IOException localIOException)
    {
      break label8;
    }
  }
  
  public static int copy(InputStream paramInputStream, OutputStream paramOutputStream)
  {
    long l = copyLarge(paramInputStream, paramOutputStream);
    if (l > 2147483647L) {}
    for (int i = -1;; i = (int)l) {
      return i;
    }
  }
  
  public static long copyLarge(InputStream paramInputStream, OutputStream paramOutputStream)
  {
    return copyLarge(paramInputStream, paramOutputStream, new byte[4096]);
  }
  
  public static long copyLarge(InputStream paramInputStream, OutputStream paramOutputStream, long paramLong1, long paramLong2)
  {
    return copyLarge(paramInputStream, paramOutputStream, paramLong1, paramLong2, new byte[4096]);
  }
  
  public static long copyLarge(InputStream paramInputStream, OutputStream paramOutputStream, long paramLong1, long paramLong2, byte[] paramArrayOfByte)
  {
    if (paramLong1 > 0L) {
      skipFully(paramInputStream, paramLong1);
    }
    long l2;
    if (paramLong2 == 0L)
    {
      l2 = 0L;
      return l2;
    }
    int i = paramArrayOfByte.length;
    if ((paramLong2 > 0L) && (paramLong2 < i)) {}
    for (int j = (int)paramLong2;; j = i)
    {
      long l1 = 0L;
      while (j > 0)
      {
        int k = paramInputStream.read(paramArrayOfByte, 0, j);
        if (-1 == k) {
          break;
        }
        paramOutputStream.write(paramArrayOfByte, 0, k);
        l1 += k;
        if (paramLong2 > 0L) {
          j = (int)Math.min(paramLong2 - l1, i);
        }
      }
      l2 = l1;
      break;
    }
  }
  
  public static long copyLarge(InputStream paramInputStream, OutputStream paramOutputStream, byte[] paramArrayOfByte)
  {
    int i;
    for (long l = 0L;; l += i)
    {
      i = paramInputStream.read(paramArrayOfByte);
      if (-1 == i) {
        break;
      }
      paramOutputStream.write(paramArrayOfByte, 0, i);
    }
    return l;
  }
  
  public static long skip(InputStream paramInputStream, long paramLong)
  {
    if (paramLong < 0L) {
      throw new IllegalArgumentException("Skip count must be non-negative, actual: " + paramLong);
    }
    if (SKIP_BYTE_BUFFER == null) {
      SKIP_BYTE_BUFFER = new byte[2048];
    }
    long l2;
    for (long l1 = paramLong;; l1 -= l2) {
      if (l1 > 0L)
      {
        l2 = paramInputStream.read(SKIP_BYTE_BUFFER, 0, (int)Math.min(l1, 2048L));
        if (l2 >= 0L) {}
      }
      else
      {
        return paramLong - l1;
      }
    }
  }
  
  public static void skipFully(InputStream paramInputStream, long paramLong)
  {
    if (paramLong < 0L) {
      throw new IllegalArgumentException("Bytes to skip must not be negative: " + paramLong);
    }
    long l = skip(paramInputStream, paramLong);
    if (l != paramLong) {
      throw new EOFException("Bytes to skip: " + paramLong + " actual: " + l);
    }
  }
  
  public static byte[] toByteArray(InputStream paramInputStream)
  {
    ByteArrayOutputStream localByteArrayOutputStream = new ByteArrayOutputStream();
    copy(paramInputStream, localByteArrayOutputStream);
    return localByteArrayOutputStream.toByteArray();
  }
}


/* Location:           C:\Users\dreadiscool\Desktop\tools\classes-dex2jar.jar
 * Qualified Name:     com.parse.ParseIOUtils
 * JD-Core Version:    0.7.0.1
 */