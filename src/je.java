import java.io.UnsupportedEncodingException;

public final class je
{
  private final byte[] a;
  private final int b;
  private int c;
  
  private je(byte[] paramArrayOfByte, int paramInt1, int paramInt2)
  {
    this.a = paramArrayOfByte;
    this.c = paramInt1;
    this.b = (paramInt1 + paramInt2);
  }
  
  public static je a(byte[] paramArrayOfByte)
  {
    return a(paramArrayOfByte, 0, paramArrayOfByte.length);
  }
  
  public static je a(byte[] paramArrayOfByte, int paramInt1, int paramInt2)
  {
    return new je(paramArrayOfByte, paramInt1, paramInt2);
  }
  
  public static int b(int paramInt)
  {
    if (paramInt >= 0) {}
    for (int i = f(paramInt);; i = 10) {
      return i;
    }
  }
  
  public static int b(int paramInt1, int paramInt2)
  {
    return d(paramInt1) + b(paramInt2);
  }
  
  public static int b(int paramInt, long paramLong)
  {
    return d(paramInt) + b(paramLong);
  }
  
  public static int b(int paramInt, String paramString)
  {
    return d(paramInt) + b(paramString);
  }
  
  public static int b(int paramInt, jl paramjl)
  {
    return 2 * d(paramInt) + c(paramjl);
  }
  
  public static int b(int paramInt, boolean paramBoolean)
  {
    return d(paramInt) + b(paramBoolean);
  }
  
  public static int b(long paramLong)
  {
    return d(paramLong);
  }
  
  public static int b(String paramString)
  {
    try
    {
      byte[] arrayOfByte = paramString.getBytes("UTF-8");
      int i = f(arrayOfByte.length);
      int j = arrayOfByte.length;
      return j + i;
    }
    catch (UnsupportedEncodingException localUnsupportedEncodingException)
    {
      throw new RuntimeException("UTF-8 not supported.");
    }
  }
  
  public static int b(boolean paramBoolean)
  {
    return 1;
  }
  
  public static int c(int paramInt, jl paramjl)
  {
    return d(paramInt) + d(paramjl);
  }
  
  public static int c(jl paramjl)
  {
    return paramjl.f();
  }
  
  public static int d(int paramInt)
  {
    return f(jo.a(paramInt, 0));
  }
  
  public static int d(long paramLong)
  {
    int i;
    if ((0xFFFFFF80 & paramLong) == 0L) {
      i = 1;
    }
    for (;;)
    {
      return i;
      if ((0xFFFFC000 & paramLong) == 0L) {
        i = 2;
      } else if ((0xFFE00000 & paramLong) == 0L) {
        i = 3;
      } else if ((0xF0000000 & paramLong) == 0L) {
        i = 4;
      } else if ((0x0 & paramLong) == 0L) {
        i = 5;
      } else if ((0x0 & paramLong) == 0L) {
        i = 6;
      } else if ((0x0 & paramLong) == 0L) {
        i = 7;
      } else if ((0x0 & paramLong) == 0L) {
        i = 8;
      } else if ((0x0 & paramLong) == 0L) {
        i = 9;
      } else {
        i = 10;
      }
    }
  }
  
  public static int d(jl paramjl)
  {
    int i = paramjl.f();
    return i + f(i);
  }
  
  public static int f(int paramInt)
  {
    int i;
    if ((paramInt & 0xFFFFFF80) == 0) {
      i = 1;
    }
    for (;;)
    {
      return i;
      if ((paramInt & 0xFFFFC000) == 0) {
        i = 2;
      } else if ((0xFFE00000 & paramInt) == 0) {
        i = 3;
      } else if ((0xF0000000 & paramInt) == 0) {
        i = 4;
      } else {
        i = 5;
      }
    }
  }
  
  public void a(byte paramByte)
  {
    if (this.c == this.b) {
      throw new jf(this.c, this.b);
    }
    byte[] arrayOfByte = this.a;
    int i = this.c;
    this.c = (i + 1);
    arrayOfByte[i] = paramByte;
  }
  
  public void a(int paramInt)
  {
    if (paramInt >= 0) {
      e(paramInt);
    }
    for (;;)
    {
      return;
      c(paramInt);
    }
  }
  
  public void a(int paramInt1, int paramInt2)
  {
    c(paramInt1, 0);
    a(paramInt2);
  }
  
  public void a(int paramInt, long paramLong)
  {
    c(paramInt, 0);
    a(paramLong);
  }
  
  public void a(int paramInt, String paramString)
  {
    c(paramInt, 2);
    a(paramString);
  }
  
  public void a(int paramInt, jl paramjl)
  {
    c(paramInt, 2);
    b(paramjl);
  }
  
  public void a(int paramInt, boolean paramBoolean)
  {
    c(paramInt, 0);
    a(paramBoolean);
  }
  
  public void a(long paramLong)
  {
    c(paramLong);
  }
  
  public void a(String paramString)
  {
    byte[] arrayOfByte = paramString.getBytes("UTF-8");
    e(arrayOfByte.length);
    b(arrayOfByte);
  }
  
  public void a(jl paramjl)
  {
    paramjl.a(this);
  }
  
  public void a(boolean paramBoolean)
  {
    if (paramBoolean) {}
    for (int i = 1;; i = 0)
    {
      c(i);
      return;
    }
  }
  
  public void b(jl paramjl)
  {
    e(paramjl.e());
    paramjl.a(this);
  }
  
  public void b(byte[] paramArrayOfByte)
  {
    b(paramArrayOfByte, 0, paramArrayOfByte.length);
  }
  
  public void b(byte[] paramArrayOfByte, int paramInt1, int paramInt2)
  {
    if (this.b - this.c >= paramInt2)
    {
      System.arraycopy(paramArrayOfByte, paramInt1, this.a, this.c, paramInt2);
      this.c = (paramInt2 + this.c);
      return;
    }
    throw new jf(this.c, this.b);
  }
  
  public void c(int paramInt)
  {
    a((byte)paramInt);
  }
  
  public void c(int paramInt1, int paramInt2)
  {
    e(jo.a(paramInt1, paramInt2));
  }
  
  public void c(long paramLong)
  {
    for (;;)
    {
      if ((0xFFFFFF80 & paramLong) == 0L)
      {
        c((int)paramLong);
        return;
      }
      c(0x80 | 0x7F & (int)paramLong);
      paramLong >>>= 7;
    }
  }
  
  public void e(int paramInt)
  {
    for (;;)
    {
      if ((paramInt & 0xFFFFFF80) == 0)
      {
        c(paramInt);
        return;
      }
      c(0x80 | paramInt & 0x7F);
      paramInt >>>= 7;
    }
  }
}


/* Location:           C:\Users\dreadiscool\Desktop\tools\classes-dex2jar.jar
 * Qualified Name:     je
 * JD-Core Version:    0.7.0.1
 */