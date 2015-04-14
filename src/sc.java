import java.io.InputStream;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public final class sc
{
  private final byte[] a;
  private final boolean b;
  private int c;
  private int d;
  private int e;
  private final InputStream f;
  private int g;
  private boolean h = false;
  private int i;
  private int j = 2147483647;
  private int k;
  private int l = 64;
  private int m = 67108864;
  private sd n = null;
  
  private sc(InputStream paramInputStream)
  {
    this.a = new byte[4096];
    this.c = 0;
    this.e = 0;
    this.i = 0;
    this.f = paramInputStream;
    this.b = false;
  }
  
  private sc(sB paramsB)
  {
    this.a = paramsB.c;
    this.e = paramsB.b();
    this.c = (paramsB.b() + paramsB.a());
    this.i = (-this.e);
    this.f = null;
    this.b = true;
  }
  
  public static long a(long paramLong)
  {
    return paramLong >>> 1 ^ -(1L & paramLong);
  }
  
  public static sc a(InputStream paramInputStream)
  {
    return new sc(paramInputStream);
  }
  
  static sc a(sB paramsB)
  {
    sc localsc = new sc(paramsB);
    try
    {
      localsc.c(paramsB.a());
      return localsc;
    }
    catch (sx localsx)
    {
      throw new IllegalArgumentException(localsx);
    }
  }
  
  private boolean a(boolean paramBoolean)
  {
    if (this.e < this.c) {
      throw new IllegalStateException("refillBuffer() called when buffer wasn't empty.");
    }
    boolean bool;
    if (this.i + this.c == this.j)
    {
      if (paramBoolean) {
        throw sx.b();
      }
      bool = false;
    }
    for (;;)
    {
      return bool;
      this.i += this.c;
      this.e = 0;
      if (this.f == null) {}
      for (int i1 = -1;; i1 = this.f.read(this.a))
      {
        this.c = i1;
        if ((this.c != 0) && (this.c >= -1)) {
          break;
        }
        throw new IllegalStateException("InputStream#read(byte[]) returned invalid result: " + this.c + "\nThe InputStream implementation is buggy.");
      }
      if (this.c == -1)
      {
        this.c = 0;
        if (paramBoolean) {
          throw sx.b();
        }
        bool = false;
      }
      else
      {
        z();
        int i2 = this.i + this.c + this.d;
        if ((i2 > this.m) || (i2 < 0)) {
          throw sx.i();
        }
        bool = true;
      }
    }
  }
  
  public static int b(int paramInt)
  {
    return paramInt >>> 1 ^ -(paramInt & 0x1);
  }
  
  private void z()
  {
    this.c += this.d;
    int i1 = this.i + this.c;
    if (i1 > this.j)
    {
      this.d = (i1 - this.j);
      this.c -= this.d;
    }
    for (;;)
    {
      return;
      this.d = 0;
    }
  }
  
  public int a()
  {
    int i1 = 0;
    if (x()) {
      this.g = 0;
    }
    for (;;)
    {
      return i1;
      this.g = s();
      if (tc.b(this.g) == 0) {
        throw sx.e();
      }
      i1 = this.g;
    }
  }
  
  public <T extends sE> T a(sI<T> paramsI, sg paramsg)
  {
    int i1 = s();
    if (this.k >= this.l) {
      throw sx.h();
    }
    int i2 = c(i1);
    this.k = (1 + this.k);
    sE localsE = (sE)paramsI.b(this, paramsg);
    a(0);
    this.k = (-1 + this.k);
    d(i2);
    return localsE;
  }
  
  public void a(int paramInt)
  {
    if (this.g != paramInt) {
      throw sx.f();
    }
  }
  
  public void a(int paramInt, sF paramsF, sg paramsg)
  {
    if (this.k >= this.l) {
      throw sx.h();
    }
    this.k = (1 + this.k);
    paramsF.c(this, paramsg);
    a(tc.a(paramInt, 4));
    this.k = (-1 + this.k);
  }
  
  public void a(sF paramsF, sg paramsg)
  {
    int i1 = s();
    if (this.k >= this.l) {
      throw sx.h();
    }
    int i2 = c(i1);
    this.k = (1 + this.k);
    paramsF.c(this, paramsg);
    a(0);
    this.k = (-1 + this.k);
    d(i2);
  }
  
  public void a(se paramse)
  {
    int i1;
    do
    {
      i1 = a();
    } while ((i1 != 0) && (a(i1, paramse)));
  }
  
  public boolean a(int paramInt, se paramse)
  {
    boolean bool = true;
    switch (tc.a(paramInt))
    {
    default: 
      throw sx.g();
    case 0: 
      long l2 = e();
      paramse.d(paramInt);
      paramse.a(l2);
    }
    for (;;)
    {
      return bool;
      long l1 = v();
      paramse.d(paramInt);
      paramse.b(l1);
      continue;
      rZ localrZ = l();
      paramse.d(paramInt);
      paramse.a(localrZ);
      continue;
      paramse.d(paramInt);
      a(paramse);
      int i2 = tc.a(tc.b(paramInt), 4);
      a(i2);
      paramse.d(i2);
      continue;
      bool = false;
      continue;
      int i1 = u();
      paramse.d(paramInt);
      paramse.a(i1);
    }
  }
  
  public double b()
  {
    return Double.longBitsToDouble(v());
  }
  
  public float c()
  {
    return Float.intBitsToFloat(u());
  }
  
  public int c(int paramInt)
  {
    if (paramInt < 0) {
      throw sx.c();
    }
    int i1 = paramInt + (this.i + this.e);
    int i2 = this.j;
    if (i1 > i2) {
      throw sx.b();
    }
    this.j = i1;
    z();
    return i2;
  }
  
  public long d()
  {
    return t();
  }
  
  public void d(int paramInt)
  {
    this.j = paramInt;
    z();
  }
  
  public long e()
  {
    return t();
  }
  
  public byte[] e(int paramInt)
  {
    if (paramInt < 0) {
      throw sx.c();
    }
    if (paramInt + (this.i + this.e) > this.j)
    {
      f(this.j - this.i - this.e);
      throw sx.b();
    }
    Object localObject;
    if (paramInt <= this.c - this.e)
    {
      localObject = new byte[paramInt];
      System.arraycopy(this.a, this.e, localObject, 0, paramInt);
      this.e = (paramInt + this.e);
    }
    for (;;)
    {
      return localObject;
      if (paramInt < 4096)
      {
        byte[] arrayOfByte4 = new byte[paramInt];
        int i10 = this.c - this.e;
        System.arraycopy(this.a, this.e, arrayOfByte4, 0, i10);
        this.e = this.c;
        a(true);
        while (paramInt - i10 > this.c)
        {
          System.arraycopy(this.a, 0, arrayOfByte4, i10, this.c);
          i10 += this.c;
          this.e = this.c;
          a(true);
        }
        System.arraycopy(this.a, 0, arrayOfByte4, i10, paramInt - i10);
        this.e = (paramInt - i10);
        localObject = arrayOfByte4;
      }
      else
      {
        int i1 = this.e;
        int i2 = this.c;
        this.i += this.c;
        this.e = 0;
        this.c = 0;
        int i3 = paramInt - (i2 - i1);
        ArrayList localArrayList = new ArrayList();
        int i8;
        for (int i4 = i3; i4 > 0; i4 = i8)
        {
          byte[] arrayOfByte3 = new byte[Math.min(i4, 4096)];
          int i7 = 0;
          while (i7 < arrayOfByte3.length)
          {
            if (this.f == null) {}
            for (int i9 = -1; i9 == -1; i9 = this.f.read(arrayOfByte3, i7, arrayOfByte3.length - i7)) {
              throw sx.b();
            }
            this.i = (i9 + this.i);
            i7 += i9;
          }
          i8 = i4 - arrayOfByte3.length;
          localArrayList.add(arrayOfByte3);
        }
        byte[] arrayOfByte1 = new byte[paramInt];
        int i5 = i2 - i1;
        System.arraycopy(this.a, i1, arrayOfByte1, 0, i5);
        Iterator localIterator = localArrayList.iterator();
        int i6 = i5;
        while (localIterator.hasNext())
        {
          byte[] arrayOfByte2 = (byte[])localIterator.next();
          System.arraycopy(arrayOfByte2, 0, arrayOfByte1, i6, arrayOfByte2.length);
          i6 += arrayOfByte2.length;
        }
        localObject = arrayOfByte1;
      }
    }
  }
  
  public int f()
  {
    return s();
  }
  
  public void f(int paramInt)
  {
    if (paramInt < 0) {
      throw sx.c();
    }
    if (paramInt + (this.i + this.e) > this.j)
    {
      f(this.j - this.i - this.e);
      throw sx.b();
    }
    if (paramInt <= this.c - this.e) {}
    int i1;
    for (this.e = (paramInt + this.e);; this.e = (paramInt - i1))
    {
      return;
      i1 = this.c - this.e;
      this.e = this.c;
      a(true);
      while (paramInt - i1 > this.c)
      {
        i1 += this.c;
        this.e = this.c;
        a(true);
      }
    }
  }
  
  public long g()
  {
    return v();
  }
  
  public int h()
  {
    return u();
  }
  
  public boolean i()
  {
    if (s() != 0) {}
    for (boolean bool = true;; bool = false) {
      return bool;
    }
  }
  
  public String j()
  {
    int i1 = s();
    String str;
    if ((i1 <= this.c - this.e) && (i1 > 0))
    {
      str = new String(this.a, this.e, i1, "UTF-8");
      this.e = (i1 + this.e);
    }
    for (;;)
    {
      return str;
      str = new String(e(i1), "UTF-8");
    }
  }
  
  public String k()
  {
    int i1 = s();
    Object localObject;
    if ((i1 <= this.c - this.e) && (i1 > 0))
    {
      localObject = rZ.a(this.a, this.e, i1);
      this.e = (i1 + this.e);
    }
    while (!((rZ)localObject).g())
    {
      throw sx.j();
      localObject = new sB(e(i1));
    }
    return ((rZ)localObject).f();
  }
  
  public rZ l()
  {
    int i1 = s();
    Object localObject;
    if (i1 == 0) {
      localObject = rZ.a;
    }
    for (;;)
    {
      return localObject;
      if ((i1 <= this.c - this.e) && (i1 > 0))
      {
        if ((this.b) && (this.h)) {}
        for (localObject = new rW(this.a, this.e, i1);; localObject = rZ.a(this.a, this.e, i1))
        {
          this.e = (i1 + this.e);
          break;
        }
      }
      localObject = new sB(e(i1));
    }
  }
  
  public int m()
  {
    return s();
  }
  
  public int n()
  {
    return s();
  }
  
  public int o()
  {
    return u();
  }
  
  public long p()
  {
    return v();
  }
  
  public int q()
  {
    return b(s());
  }
  
  public long r()
  {
    return a(t());
  }
  
  public int s()
  {
    int i1 = y();
    if (i1 >= 0) {}
    int i9;
    do
    {
      int i6;
      int i7;
      for (;;)
      {
        return i1;
        int i2 = i1 & 0x7F;
        int i3 = y();
        if (i3 >= 0)
        {
          i1 = i2 | i3 << 7;
        }
        else
        {
          int i4 = i2 | (i3 & 0x7F) << 7;
          int i5 = y();
          if (i5 >= 0)
          {
            i1 = i4 | i5 << 14;
          }
          else
          {
            i6 = i4 | (i5 & 0x7F) << 14;
            i7 = y();
            if (i7 < 0) {
              break;
            }
            i1 = i6 | i7 << 21;
          }
        }
      }
      int i8 = i6 | (i7 & 0x7F) << 21;
      i9 = y();
      i1 = i8 | i9 << 28;
    } while (i9 >= 0);
    for (int i10 = 0;; i10++)
    {
      if (i10 >= 5) {
        break label160;
      }
      if (y() >= 0) {
        break;
      }
    }
    label160:
    throw sx.d();
  }
  
  public long t()
  {
    int i1 = 0;
    long l1 = 0L;
    while (i1 < 64)
    {
      int i2 = y();
      l1 |= (i2 & 0x7F) << i1;
      if ((i2 & 0x80) == 0) {
        return l1;
      }
      i1 += 7;
    }
    throw sx.d();
  }
  
  public int u()
  {
    int i1 = y();
    int i2 = y();
    int i3 = y();
    int i4 = y();
    return i1 & 0xFF | (i2 & 0xFF) << 8 | (i3 & 0xFF) << 16 | (i4 & 0xFF) << 24;
  }
  
  public long v()
  {
    int i1 = y();
    int i2 = y();
    int i3 = y();
    int i4 = y();
    int i5 = y();
    int i6 = y();
    int i7 = y();
    int i8 = y();
    return 0xFF & i1 | (0xFF & i2) << 8 | (0xFF & i3) << 16 | (0xFF & i4) << 24 | (0xFF & i5) << 32 | (0xFF & i6) << 40 | (0xFF & i7) << 48 | (0xFF & i8) << 56;
  }
  
  public int w()
  {
    if (this.j == 2147483647) {}
    int i1;
    for (int i2 = -1;; i2 = this.j - i1)
    {
      return i2;
      i1 = this.i + this.e;
    }
  }
  
  public boolean x()
  {
    boolean bool = false;
    if ((this.e == this.c) && (!a(false))) {
      bool = true;
    }
    return bool;
  }
  
  public byte y()
  {
    if (this.e == this.c) {
      a(true);
    }
    byte[] arrayOfByte = this.a;
    int i1 = this.e;
    this.e = (i1 + 1);
    return arrayOfByte[i1];
  }
}


/* Location:           C:\Users\dreadiscool\Desktop\tools\classes-dex2jar.jar
 * Qualified Name:     sc
 * JD-Core Version:    0.7.0.1
 */