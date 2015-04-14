package com.squareup.picasso;

import java.io.BufferedInputStream;
import java.io.IOException;
import java.io.InputStream;

final class MarkableInputStream
  extends InputStream
{
  private static final int DEFAULT_BUFFER_SIZE = 4096;
  private long defaultMark = -1L;
  private final InputStream in;
  private long limit;
  private long offset;
  private long reset;
  
  public MarkableInputStream(InputStream paramInputStream)
  {
    this(paramInputStream, 4096);
  }
  
  public MarkableInputStream(InputStream paramInputStream, int paramInt)
  {
    if (!paramInputStream.markSupported()) {
      paramInputStream = new BufferedInputStream(paramInputStream, paramInt);
    }
    this.in = paramInputStream;
  }
  
  /* Error */
  private void setLimit(long paramLong)
  {
    // Byte code:
    //   0: aload_0
    //   1: getfield 41	com/squareup/picasso/MarkableInputStream:reset	J
    //   4: aload_0
    //   5: getfield 43	com/squareup/picasso/MarkableInputStream:offset	J
    //   8: lcmp
    //   9: ifge +54 -> 63
    //   12: aload_0
    //   13: getfield 43	com/squareup/picasso/MarkableInputStream:offset	J
    //   16: aload_0
    //   17: getfield 45	com/squareup/picasso/MarkableInputStream:limit	J
    //   20: lcmp
    //   21: ifgt +42 -> 63
    //   24: aload_0
    //   25: getfield 35	com/squareup/picasso/MarkableInputStream:in	Ljava/io/InputStream;
    //   28: invokevirtual 47	java/io/InputStream:reset	()V
    //   31: aload_0
    //   32: getfield 35	com/squareup/picasso/MarkableInputStream:in	Ljava/io/InputStream;
    //   35: lload_1
    //   36: aload_0
    //   37: getfield 41	com/squareup/picasso/MarkableInputStream:reset	J
    //   40: lsub
    //   41: l2i
    //   42: invokevirtual 51	java/io/InputStream:mark	(I)V
    //   45: aload_0
    //   46: aload_0
    //   47: getfield 41	com/squareup/picasso/MarkableInputStream:reset	J
    //   50: aload_0
    //   51: getfield 43	com/squareup/picasso/MarkableInputStream:offset	J
    //   54: invokespecial 55	com/squareup/picasso/MarkableInputStream:skip	(JJ)V
    //   57: aload_0
    //   58: lload_1
    //   59: putfield 45	com/squareup/picasso/MarkableInputStream:limit	J
    //   62: return
    //   63: aload_0
    //   64: aload_0
    //   65: getfield 43	com/squareup/picasso/MarkableInputStream:offset	J
    //   68: putfield 41	com/squareup/picasso/MarkableInputStream:reset	J
    //   71: aload_0
    //   72: getfield 35	com/squareup/picasso/MarkableInputStream:in	Ljava/io/InputStream;
    //   75: lload_1
    //   76: aload_0
    //   77: getfield 43	com/squareup/picasso/MarkableInputStream:offset	J
    //   80: lsub
    //   81: l2i
    //   82: invokevirtual 51	java/io/InputStream:mark	(I)V
    //   85: goto -28 -> 57
    //   88: astore_3
    //   89: new 57	java/lang/IllegalStateException
    //   92: dup
    //   93: new 59	java/lang/StringBuilder
    //   96: dup
    //   97: invokespecial 60	java/lang/StringBuilder:<init>	()V
    //   100: ldc 62
    //   102: invokevirtual 66	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   105: aload_3
    //   106: invokevirtual 69	java/lang/StringBuilder:append	(Ljava/lang/Object;)Ljava/lang/StringBuilder;
    //   109: invokevirtual 73	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   112: invokespecial 76	java/lang/IllegalStateException:<init>	(Ljava/lang/String;)V
    //   115: athrow
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	116	0	this	MarkableInputStream
    //   0	116	1	paramLong	long
    //   88	18	3	localIOException	IOException
    // Exception table:
    //   from	to	target	type
    //   0	85	88	java/io/IOException
  }
  
  private void skip(long paramLong1, long paramLong2)
  {
    for (;;)
    {
      if (paramLong1 < paramLong2)
      {
        l = this.in.skip(paramLong2 - paramLong1);
        if (l != 0L) {
          break label38;
        }
        if (read() != -1) {}
      }
      else
      {
        return;
      }
      long l = 1L;
      label38:
      paramLong1 += l;
    }
  }
  
  public int available()
  {
    return this.in.available();
  }
  
  public void close()
  {
    this.in.close();
  }
  
  public void mark(int paramInt)
  {
    this.defaultMark = savePosition(paramInt);
  }
  
  public boolean markSupported()
  {
    return this.in.markSupported();
  }
  
  public int read()
  {
    int i = this.in.read();
    if (i != -1) {
      this.offset = (1L + this.offset);
    }
    return i;
  }
  
  public int read(byte[] paramArrayOfByte)
  {
    int i = this.in.read(paramArrayOfByte);
    if (i != -1) {
      this.offset += i;
    }
    return i;
  }
  
  public int read(byte[] paramArrayOfByte, int paramInt1, int paramInt2)
  {
    int i = this.in.read(paramArrayOfByte, paramInt1, paramInt2);
    if (i != -1) {
      this.offset += i;
    }
    return i;
  }
  
  public void reset()
  {
    reset(this.defaultMark);
  }
  
  public void reset(long paramLong)
  {
    if ((this.offset > this.limit) || (paramLong < this.reset)) {
      throw new IOException("Cannot reset");
    }
    this.in.reset();
    skip(this.reset, paramLong);
    this.offset = paramLong;
  }
  
  public long savePosition(int paramInt)
  {
    long l = this.offset + paramInt;
    if (this.limit < l) {
      setLimit(l);
    }
    return this.offset;
  }
  
  public long skip(long paramLong)
  {
    long l = this.in.skip(paramLong);
    this.offset = (l + this.offset);
    return l;
  }
}


/* Location:           C:\Users\dreadiscool\Desktop\tools\classes-dex2jar.jar
 * Qualified Name:     com.squareup.picasso.MarkableInputStream
 * JD-Core Version:    0.7.0.1
 */