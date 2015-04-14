import java.io.Flushable;
import java.io.InputStream;
import java.io.OutputStream;

final class E
  implements Flushable
{
  private final byte[] a;
  private final int b;
  private int c;
  private final OutputStream d;
  
  private E(OutputStream paramOutputStream, byte[] paramArrayOfByte)
  {
    this.d = paramOutputStream;
    this.a = paramArrayOfByte;
    this.c = 0;
    this.b = paramArrayOfByte.length;
  }
  
  public static E a(OutputStream paramOutputStream)
  {
    return a(paramOutputStream, 4096);
  }
  
  public static E a(OutputStream paramOutputStream, int paramInt)
  {
    return new E(paramOutputStream, new byte[paramInt]);
  }
  
  private void a()
  {
    if (this.d == null) {
      throw new F();
    }
    this.d.write(this.a, 0, this.c);
    this.c = 0;
  }
  
  public static int b(float paramFloat)
  {
    return 4;
  }
  
  public static int b(int paramInt, float paramFloat)
  {
    return j(paramInt) + b(paramFloat);
  }
  
  public static int b(int paramInt, long paramLong)
  {
    return j(paramInt) + b(paramLong);
  }
  
  public static int b(int paramInt, A paramA)
  {
    return j(paramInt) + b(paramA);
  }
  
  public static int b(int paramInt, boolean paramBoolean)
  {
    return j(paramInt) + b(paramBoolean);
  }
  
  public static int b(long paramLong)
  {
    return d(paramLong);
  }
  
  public static int b(A paramA)
  {
    return l(paramA.a()) + paramA.a();
  }
  
  public static int b(boolean paramBoolean)
  {
    return 1;
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
  
  public static int e(int paramInt)
  {
    if (paramInt >= 0) {}
    for (int i = l(paramInt);; i = 10) {
      return i;
    }
  }
  
  public static int e(int paramInt1, int paramInt2)
  {
    return j(paramInt1) + e(paramInt2);
  }
  
  public static int f(int paramInt)
  {
    return l(paramInt);
  }
  
  public static int f(int paramInt1, int paramInt2)
  {
    return j(paramInt1) + f(paramInt2);
  }
  
  public static int g(int paramInt)
  {
    return e(paramInt);
  }
  
  public static int g(int paramInt1, int paramInt2)
  {
    return j(paramInt1) + g(paramInt2);
  }
  
  public static int h(int paramInt)
  {
    return l(n(paramInt));
  }
  
  public static int h(int paramInt1, int paramInt2)
  {
    return j(paramInt1) + h(paramInt2);
  }
  
  public static int j(int paramInt)
  {
    return l(aQ.a(paramInt, 0));
  }
  
  public static int l(int paramInt)
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
  
  public static int n(int paramInt)
  {
    return paramInt << 1 ^ paramInt >> 31;
  }
  
  public void a(byte paramByte)
  {
    if (this.c == this.b) {
      a();
    }
    byte[] arrayOfByte = this.a;
    int i = this.c;
    this.c = (i + 1);
    arrayOfByte[i] = paramByte;
  }
  
  public void a(float paramFloat)
  {
    m(Float.floatToRawIntBits(paramFloat));
  }
  
  public void a(int paramInt)
  {
    if (paramInt >= 0) {
      k(paramInt);
    }
    for (;;)
    {
      return;
      c(paramInt);
    }
  }
  
  public void a(int paramInt, float paramFloat)
  {
    i(paramInt, 5);
    a(paramFloat);
  }
  
  public void a(int paramInt1, int paramInt2)
  {
    i(paramInt1, 0);
    a(paramInt2);
  }
  
  public void a(int paramInt, long paramLong)
  {
    i(paramInt, 0);
    a(paramLong);
  }
  
  public void a(int paramInt, A paramA)
  {
    i(paramInt, 2);
    a(paramA);
  }
  
  public void a(int paramInt, String paramString)
  {
    i(paramInt, 2);
    a(paramString);
  }
  
  public void a(int paramInt, boolean paramBoolean)
  {
    i(paramInt, 0);
    a(paramBoolean);
  }
  
  public void a(long paramLong)
  {
    c(paramLong);
  }
  
  public void a(A paramA)
  {
    k(paramA.a());
    c(paramA);
  }
  
  public void a(A paramA, int paramInt1, int paramInt2)
  {
    if (this.b - this.c >= paramInt2) {
      paramA.a(this.a, paramInt1, this.c, paramInt2);
    }
    int j;
    int k;
    for (this.c = (paramInt2 + this.c);; this.c = k)
    {
      return;
      int i = this.b - this.c;
      paramA.a(this.a, paramInt1, this.c, i);
      j = paramInt1 + i;
      k = paramInt2 - i;
      this.c = this.b;
      a();
      if (k > this.b) {
        break;
      }
      paramA.a(this.a, j, 0, k);
    }
    InputStream localInputStream = paramA.b();
    if (j != localInputStream.skip(j)) {
      throw new IllegalStateException("Skip failed.");
    }
    int n;
    int m;
    do
    {
      this.d.write(this.a, 0, n);
      k -= n;
      if (k <= 0) {
        break;
      }
      m = Math.min(k, this.b);
      n = localInputStream.read(this.a, 0, m);
    } while (n == m);
    throw new IllegalStateException("Read failed.");
  }
  
  public void a(String paramString)
  {
    byte[] arrayOfByte = paramString.getBytes("UTF-8");
    k(arrayOfByte.length);
    a(arrayOfByte);
  }
  
  public void a(boolean paramBoolean)
  {
    if (paramBoolean) {}
    for (int i = 1;; i = 0)
    {
      i(i);
      return;
    }
  }
  
  public void a(byte[] paramArrayOfByte)
  {
    a(paramArrayOfByte, 0, paramArrayOfByte.length);
  }
  
  public void a(byte[] paramArrayOfByte, int paramInt1, int paramInt2)
  {
    if (this.b - this.c >= paramInt2)
    {
      System.arraycopy(paramArrayOfByte, paramInt1, this.a, this.c, paramInt2);
      this.c = (paramInt2 + this.c);
    }
    for (;;)
    {
      return;
      int i = this.b - this.c;
      System.arraycopy(paramArrayOfByte, paramInt1, this.a, this.c, i);
      int j = paramInt1 + i;
      int k = paramInt2 - i;
      this.c = this.b;
      a();
      if (k <= this.b)
      {
        System.arraycopy(paramArrayOfByte, j, this.a, 0, k);
        this.c = k;
      }
      else
      {
        this.d.write(paramArrayOfByte, j, k);
      }
    }
  }
  
  public void b(int paramInt)
  {
    k(paramInt);
  }
  
  public void b(int paramInt1, int paramInt2)
  {
    i(paramInt1, 0);
    b(paramInt2);
  }
  
  public void c(int paramInt)
  {
    a(paramInt);
  }
  
  public void c(int paramInt1, int paramInt2)
  {
    i(paramInt1, 0);
    c(paramInt2);
  }
  
  public void c(long paramLong)
  {
    for (;;)
    {
      if ((0xFFFFFF80 & paramLong) == 0L)
      {
        i((int)paramLong);
        return;
      }
      i(0x80 | 0x7F & (int)paramLong);
      paramLong >>>= 7;
    }
  }
  
  public void c(A paramA)
  {
    a(paramA, 0, paramA.a());
  }
  
  public void d(int paramInt)
  {
    k(n(paramInt));
  }
  
  public void d(int paramInt1, int paramInt2)
  {
    i(paramInt1, 0);
    d(paramInt2);
  }
  
  public void flush()
  {
    if (this.d != null) {
      a();
    }
  }
  
  public void i(int paramInt)
  {
    a((byte)paramInt);
  }
  
  public void i(int paramInt1, int paramInt2)
  {
    k(aQ.a(paramInt1, paramInt2));
  }
  
  public void k(int paramInt)
  {
    for (;;)
    {
      if ((paramInt & 0xFFFFFF80) == 0)
      {
        i(paramInt);
        return;
      }
      i(0x80 | paramInt & 0x7F);
      paramInt >>>= 7;
    }
  }
  
  public void m(int paramInt)
  {
    i(paramInt & 0xFF);
    i(0xFF & paramInt >> 8);
    i(0xFF & paramInt >> 16);
    i(0xFF & paramInt >> 24);
  }
}


/* Location:           C:\Users\dreadiscool\Desktop\tools\classes-dex2jar.jar
 * Qualified Name:     E
 * JD-Core Version:    0.7.0.1
 */