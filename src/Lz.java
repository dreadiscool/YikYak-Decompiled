import java.io.EOFException;
import java.io.InputStream;
import java.io.OutputStream;
import java.nio.charset.Charset;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;

public final class Lz
  implements LC, LD, Cloneable
{
  LS a;
  long b;
  
  public int a(byte[] paramArrayOfByte, int paramInt1, int paramInt2)
  {
    LY.a(paramArrayOfByte.length, paramInt1, paramInt2);
    LS localLS = this.a;
    int i;
    if (localLS == null) {
      i = -1;
    }
    for (;;)
    {
      return i;
      i = Math.min(paramInt2, localLS.c - localLS.b);
      System.arraycopy(localLS.a, localLS.b, paramArrayOfByte, paramInt1, i);
      localLS.b = (i + localLS.b);
      this.b -= i;
      if (localLS.b == localLS.c)
      {
        this.a = localLS.a();
        LT.a.a(localLS);
      }
    }
  }
  
  public long a(byte paramByte)
  {
    return a(paramByte, 0L);
  }
  
  public long a(byte paramByte, long paramLong)
  {
    if (paramLong < 0L) {
      throw new IllegalArgumentException("fromIndex < 0");
    }
    LS localLS = this.a;
    long l4;
    if (localLS == null)
    {
      l4 = -1L;
      return l4;
    }
    long l1 = 0L;
    label38:
    int i = localLS.c - localLS.b;
    if (paramLong >= i) {}
    label166:
    for (paramLong -= i;; paramLong = 0L)
    {
      l1 += i;
      localLS = localLS.d;
      if (localLS != this.a) {
        break label38;
      }
      l4 = -1L;
      break;
      byte[] arrayOfByte = localLS.a;
      long l2 = paramLong + localLS.b;
      long l3 = localLS.c;
      for (;;)
      {
        if (l2 >= l3) {
          break label166;
        }
        if (arrayOfByte[((int)l2)] == paramByte)
        {
          l4 = l1 + l2 - localLS.b;
          break;
        }
        l2 += 1L;
      }
    }
  }
  
  public long a(LV paramLV)
  {
    if (paramLV == null) {
      throw new IllegalArgumentException("source == null");
    }
    long l2;
    for (long l1 = 0L;; l1 += l2)
    {
      l2 = paramLV.a(this, 2048L);
      if (l2 == -1L) {
        break;
      }
    }
    return l1;
  }
  
  public long a(Lz paramLz, long paramLong)
  {
    if (paramLz == null) {
      throw new IllegalArgumentException("sink == null");
    }
    if (paramLong < 0L) {
      throw new IllegalArgumentException("byteCount < 0: " + paramLong);
    }
    if (this.b == 0L) {
      paramLong = -1L;
    }
    for (;;)
    {
      return paramLong;
      if (paramLong > this.b) {
        paramLong = this.b;
      }
      paramLz.a_(this, paramLong);
    }
  }
  
  public Lz a(int paramInt)
  {
    LS localLS = d(1);
    byte[] arrayOfByte = localLS.a;
    int i = localLS.c;
    localLS.c = (i + 1);
    arrayOfByte[i] = ((byte)paramInt);
    this.b = (1L + this.b);
    return this;
  }
  
  public Lz a(LE paramLE)
  {
    if (paramLE == null) {
      throw new IllegalArgumentException("byteString == null");
    }
    return b(paramLE.b, 0, paramLE.b.length);
  }
  
  public Lz a(Lz paramLz, long paramLong1, long paramLong2)
  {
    if (paramLz == null) {
      throw new IllegalArgumentException("out == null");
    }
    LY.a(this.b, paramLong1, paramLong2);
    if (paramLong2 == 0L) {}
    for (;;)
    {
      return this;
      LS localLS1 = this.a;
      LS localLS2 = paramLz.d(1);
      paramLz.b = (paramLong2 + paramLz.b);
      long l = paramLong1;
      while (paramLong2 > 0L)
      {
        while (l >= localLS1.c - localLS1.b)
        {
          l -= localLS1.c - localLS1.b;
          localLS1 = localLS1.d;
        }
        if (localLS2.c == 2048) {
          localLS2 = localLS2.a(LT.a.a());
        }
        int i = (int)Math.min(Math.min(localLS1.c - (l + localLS1.b), paramLong2), 2048 - localLS2.c);
        System.arraycopy(localLS1.a, localLS1.b + (int)l, localLS2.a, localLS2.c, i);
        l += i;
        localLS2.c = (i + localLS2.c);
        paramLong2 -= i;
      }
    }
  }
  
  public Lz a(String paramString)
  {
    if (paramString == null) {
      throw new IllegalArgumentException("string == null");
    }
    int i = paramString.length();
    int j = 0;
    if (j < i)
    {
      int k = paramString.charAt(j);
      byte[] arrayOfByte;
      int i2;
      int m;
      label91:
      int i5;
      if (k < 128)
      {
        LS localLS = d(1);
        arrayOfByte = localLS.a;
        i2 = localLS.c - j;
        int i3 = Math.min(i, 2048 - i2);
        m = j + 1;
        arrayOfByte[(j + i2)] = ((byte)k);
        if (m < i3)
        {
          i5 = paramString.charAt(m);
          if (i5 < 128) {}
        }
        else
        {
          int i4 = m + i2 - localLS.c;
          localLS.c = (i4 + localLS.c);
          this.b += i4;
        }
      }
      for (;;)
      {
        j = m;
        break;
        int i6 = m + 1;
        arrayOfByte[(m + i2)] = ((byte)i5);
        m = i6;
        break label91;
        if (k < 2048)
        {
          a(0xC0 | k >> 6);
          a(0x80 | k & 0x3F);
          m = j + 1;
        }
        else if ((k < 55296) || (k > 57343))
        {
          a(0xE0 | k >> 12);
          a(0x80 | 0x3F & k >> 6);
          a(0x80 | k & 0x3F);
          m = j + 1;
        }
        else
        {
          if (j + 1 < i) {}
          for (int n = paramString.charAt(j + 1);; n = 0)
          {
            if ((k <= 56319) && (n >= 56320) && (n <= 57343)) {
              break label349;
            }
            a(63);
            j++;
            break;
          }
          label349:
          int i1 = 65536 + ((k & 0xFFFF27FF) << 10 | n & 0xFFFF23FF);
          a(0xF0 | i1 >> 18);
          a(0x80 | 0x3F & i1 >> 12);
          a(0x80 | 0x3F & i1 >> 6);
          a(0x80 | i1 & 0x3F);
          m = j + 2;
        }
      }
    }
    return this;
  }
  
  public String a(long paramLong, Charset paramCharset)
  {
    LY.a(this.b, 0L, paramLong);
    if (paramCharset == null) {
      throw new IllegalArgumentException("charset == null");
    }
    if (paramLong > 2147483647L) {
      throw new IllegalArgumentException("byteCount > Integer.MAX_VALUE: " + paramLong);
    }
    String str;
    if (paramLong == 0L) {
      str = "";
    }
    for (;;)
    {
      return str;
      LS localLS = this.a;
      if (paramLong + localLS.b > localLS.c)
      {
        str = new String(f(paramLong), paramCharset);
      }
      else
      {
        str = new String(localLS.a, localLS.b, (int)paramLong, paramCharset);
        localLS.b = ((int)(paramLong + localLS.b));
        this.b -= paramLong;
        if (localLS.b == localLS.c)
        {
          this.a = localLS.a();
          LT.a.a(localLS);
        }
      }
    }
  }
  
  public void a() {}
  
  public void a(long paramLong)
  {
    if (this.b < paramLong) {
      throw new EOFException();
    }
  }
  
  public void a(byte[] paramArrayOfByte)
  {
    int i = 0;
    while (i < paramArrayOfByte.length)
    {
      int j = a(paramArrayOfByte, i, paramArrayOfByte.length - i);
      if (j == -1) {
        throw new EOFException();
      }
      i += j;
    }
  }
  
  public void a_(Lz paramLz, long paramLong)
  {
    if (paramLz == null) {
      throw new IllegalArgumentException("source == null");
    }
    if (paramLz == this) {
      throw new IllegalArgumentException("source == this");
    }
    LY.a(paramLz.b, 0L, paramLong);
    LS localLS5;
    label81:
    LS localLS1;
    long l;
    if (paramLong > 0L) {
      if (paramLong < paramLz.a.c - paramLz.a.b)
      {
        if (this.a != null)
        {
          localLS5 = this.a.e;
          if ((localLS5 != null) && (paramLong + (localLS5.c - localLS5.b) <= 2048L)) {
            break label230;
          }
          paramLz.a = paramLz.a.a((int)paramLong);
        }
      }
      else
      {
        localLS1 = paramLz.a;
        l = localLS1.c - localLS1.b;
        paramLz.a = localLS1.a();
        if (this.a != null) {
          break label262;
        }
        this.a = localLS1;
        LS localLS2 = this.a;
        LS localLS3 = this.a;
        LS localLS4 = this.a;
        localLS3.e = localLS4;
        localLS2.d = localLS4;
      }
    }
    for (;;)
    {
      paramLz.b -= l;
      this.b = (l + this.b);
      paramLong -= l;
      break;
      localLS5 = null;
      break label81;
      label230:
      paramLz.a.a(localLS5, (int)paramLong);
      paramLz.b -= paramLong;
      this.b = (paramLong + this.b);
      return;
      label262:
      this.a.e.a(localLS1).b();
    }
  }
  
  public byte b(long paramLong)
  {
    LY.a(this.b, paramLong, 1L);
    for (LS localLS = this.a;; localLS = localLS.d)
    {
      int i = localLS.c - localLS.b;
      if (paramLong < i) {
        return localLS.a[(localLS.b + (int)paramLong)];
      }
      paramLong -= i;
    }
  }
  
  public LW b()
  {
    return LW.b;
  }
  
  public Lz b(int paramInt)
  {
    LS localLS = d(2);
    byte[] arrayOfByte = localLS.a;
    int i = localLS.c;
    int j = i + 1;
    arrayOfByte[i] = ((byte)(0xFF & paramInt >>> 8));
    int k = j + 1;
    arrayOfByte[j] = ((byte)(paramInt & 0xFF));
    localLS.c = k;
    this.b = (2L + this.b);
    return this;
  }
  
  public Lz b(byte[] paramArrayOfByte)
  {
    if (paramArrayOfByte == null) {
      throw new IllegalArgumentException("source == null");
    }
    return b(paramArrayOfByte, 0, paramArrayOfByte.length);
  }
  
  public Lz b(byte[] paramArrayOfByte, int paramInt1, int paramInt2)
  {
    if (paramArrayOfByte == null) {
      throw new IllegalArgumentException("source == null");
    }
    LY.a(paramArrayOfByte.length, paramInt1, paramInt2);
    int i = paramInt1 + paramInt2;
    while (paramInt1 < i)
    {
      LS localLS = d(1);
      int j = Math.min(i - paramInt1, 2048 - localLS.c);
      System.arraycopy(paramArrayOfByte, paramInt1, localLS.a, localLS.c, j);
      paramInt1 += j;
      localLS.c = (j + localLS.c);
    }
    this.b += paramInt2;
    return this;
  }
  
  public long c()
  {
    return this.b;
  }
  
  public LE c(long paramLong)
  {
    return new LE(f(paramLong));
  }
  
  public Lz c(int paramInt)
  {
    LS localLS = d(4);
    byte[] arrayOfByte = localLS.a;
    int i = localLS.c;
    int j = i + 1;
    arrayOfByte[i] = ((byte)(0xFF & paramInt >>> 24));
    int k = j + 1;
    arrayOfByte[j] = ((byte)(0xFF & paramInt >>> 16));
    int m = k + 1;
    arrayOfByte[k] = ((byte)(0xFF & paramInt >>> 8));
    int n = m + 1;
    arrayOfByte[m] = ((byte)(paramInt & 0xFF));
    localLS.c = n;
    this.b = (4L + this.b);
    return this;
  }
  
  public void close() {}
  
  LS d(int paramInt)
  {
    if ((paramInt < 1) || (paramInt > 2048)) {
      throw new IllegalArgumentException();
    }
    LS localLS1;
    if (this.a == null)
    {
      this.a = LT.a.a();
      LS localLS2 = this.a;
      LS localLS3 = this.a;
      localLS1 = this.a;
      localLS3.e = localLS1;
      localLS2.d = localLS1;
    }
    for (;;)
    {
      return localLS1;
      localLS1 = this.a.e;
      if (paramInt + localLS1.c > 2048) {
        localLS1 = localLS1.a(LT.a.a());
      }
    }
  }
  
  public Lz d()
  {
    return this;
  }
  
  public String d(long paramLong)
  {
    return a(paramLong, LY.a);
  }
  
  public OutputStream e()
  {
    return new LA(this);
  }
  
  String e(long paramLong)
  {
    String str;
    if ((paramLong > 0L) && (b(paramLong - 1L) == 13))
    {
      str = d(paramLong - 1L);
      g(2L);
    }
    for (;;)
    {
      return str;
      str = d(paramLong);
      g(1L);
    }
  }
  
  public boolean equals(Object paramObject)
  {
    long l1 = 0L;
    boolean bool;
    if (this == paramObject) {
      bool = true;
    }
    for (;;)
    {
      return bool;
      if (!(paramObject instanceof Lz))
      {
        bool = false;
      }
      else
      {
        Lz localLz = (Lz)paramObject;
        if (this.b != localLz.b)
        {
          bool = false;
        }
        else if (this.b == l1)
        {
          bool = true;
        }
        else
        {
          LS localLS1 = this.a;
          LS localLS2 = localLz.a;
          int i = localLS1.b;
          int j = localLS2.b;
          for (;;)
          {
            if (l1 >= this.b) {
              break label255;
            }
            long l2 = Math.min(localLS1.c - i, localLS2.c - j);
            int k = 0;
            for (;;)
            {
              if (k >= l2) {
                break label199;
              }
              byte[] arrayOfByte1 = localLS1.a;
              int m = i + 1;
              int n = arrayOfByte1[i];
              byte[] arrayOfByte2 = localLS2.a;
              int i1 = j + 1;
              if (n != arrayOfByte2[j])
              {
                bool = false;
                break;
              }
              k++;
              j = i1;
              i = m;
            }
            label199:
            if (i == localLS1.c)
            {
              localLS1 = localLS1.d;
              i = localLS1.b;
            }
            if (j == localLS2.c)
            {
              localLS2 = localLS2.d;
              j = localLS2.b;
            }
            l1 += l2;
          }
          label255:
          bool = true;
        }
      }
    }
  }
  
  public Lz f()
  {
    return this;
  }
  
  public byte[] f(long paramLong)
  {
    LY.a(this.b, 0L, paramLong);
    if (paramLong > 2147483647L) {
      throw new IllegalArgumentException("byteCount > Integer.MAX_VALUE: " + paramLong);
    }
    byte[] arrayOfByte = new byte[(int)paramLong];
    a(arrayOfByte);
    return arrayOfByte;
  }
  
  public LC g()
  {
    return this;
  }
  
  public void g(long paramLong)
  {
    while (paramLong > 0L)
    {
      if (this.a == null) {
        throw new EOFException();
      }
      int i = (int)Math.min(paramLong, this.a.c - this.a.b);
      this.b -= i;
      paramLong -= i;
      LS localLS1 = this.a;
      localLS1.b = (i + localLS1.b);
      if (this.a.b == this.a.c)
      {
        LS localLS2 = this.a;
        this.a = localLS2.a();
        LT.a.a(localLS2);
      }
    }
  }
  
  public boolean h()
  {
    if (this.b == 0L) {}
    for (boolean bool = true;; bool = false) {
      return bool;
    }
  }
  
  public int hashCode()
  {
    LS localLS = this.a;
    int i;
    if (localLS == null) {
      i = 0;
    }
    for (;;)
    {
      return i;
      i = 1;
      do
      {
        int j = localLS.b;
        int k = localLS.c;
        while (j < k)
        {
          int m = i * 31 + localLS.a[j];
          j++;
          i = m;
        }
        localLS = localLS.d;
      } while (localLS != this.a);
    }
  }
  
  public InputStream i()
  {
    return new LB(this);
  }
  
  public long j()
  {
    long l = this.b;
    if (l == 0L) {
      l = 0L;
    }
    for (;;)
    {
      return l;
      LS localLS = this.a.e;
      if (localLS.c < 2048) {
        l -= localLS.c - localLS.b;
      }
    }
  }
  
  public byte k()
  {
    if (this.b == 0L) {
      throw new IllegalStateException("size == 0");
    }
    LS localLS = this.a;
    int i = localLS.b;
    int j = localLS.c;
    byte[] arrayOfByte = localLS.a;
    int k = i + 1;
    byte b1 = arrayOfByte[i];
    this.b -= 1L;
    if (k == j)
    {
      this.a = localLS.a();
      LT.a.a(localLS);
    }
    for (;;)
    {
      return b1;
      localLS.b = k;
    }
  }
  
  public short l()
  {
    if (this.b < 2L) {
      throw new IllegalStateException("size < 2: " + this.b);
    }
    LS localLS = this.a;
    int i = localLS.b;
    int j = localLS.c;
    short s;
    if (j - i < 2)
    {
      s = (short)((0xFF & k()) << 8 | 0xFF & k());
      return s;
    }
    byte[] arrayOfByte = localLS.a;
    int k = i + 1;
    int m = (0xFF & arrayOfByte[i]) << 8;
    int n = k + 1;
    int i1 = m | 0xFF & arrayOfByte[k];
    this.b -= 2L;
    if (n == j)
    {
      this.a = localLS.a();
      LT.a.a(localLS);
    }
    for (;;)
    {
      s = (short)i1;
      break;
      localLS.b = n;
    }
  }
  
  public int m()
  {
    if (this.b < 4L) {
      throw new IllegalStateException("size < 4: " + this.b);
    }
    LS localLS = this.a;
    int i = localLS.b;
    int j = localLS.c;
    int i5;
    if (j - i < 4) {
      i5 = (0xFF & k()) << 24 | (0xFF & k()) << 16 | (0xFF & k()) << 8 | 0xFF & k();
    }
    for (;;)
    {
      return i5;
      byte[] arrayOfByte = localLS.a;
      int k = i + 1;
      int m = (0xFF & arrayOfByte[i]) << 24;
      int n = k + 1;
      int i1 = m | (0xFF & arrayOfByte[k]) << 16;
      int i2 = n + 1;
      int i3 = i1 | (0xFF & arrayOfByte[n]) << 8;
      int i4 = i2 + 1;
      i5 = i3 | 0xFF & arrayOfByte[i2];
      this.b -= 4L;
      if (i4 == j)
      {
        this.a = localLS.a();
        LT.a.a(localLS);
      }
      else
      {
        localLS.b = i4;
      }
    }
  }
  
  public short n()
  {
    return LY.a(l());
  }
  
  public int o()
  {
    return LY.a(m());
  }
  
  public LE p()
  {
    return new LE(r());
  }
  
  public String q()
  {
    long l = a((byte)10);
    if (l == -1L)
    {
      Lz localLz = new Lz();
      a(localLz, 0L, Math.min(32L, this.b));
      throw new EOFException("\\n not found: size=" + c() + " content=" + localLz.p().c() + "...");
    }
    return e(l);
  }
  
  public byte[] r()
  {
    try
    {
      byte[] arrayOfByte = f(this.b);
      return arrayOfByte;
    }
    catch (EOFException localEOFException)
    {
      throw new AssertionError(localEOFException);
    }
  }
  
  public void s()
  {
    try
    {
      g(this.b);
      return;
    }
    catch (EOFException localEOFException)
    {
      throw new AssertionError(localEOFException);
    }
  }
  
  public Lz t()
  {
    Lz localLz1 = new Lz();
    if (this.b == 0L) {}
    for (Lz localLz2 = localLz1;; localLz2 = localLz1)
    {
      return localLz2;
      localLz1.b(this.a.a, this.a.b, this.a.c - this.a.b);
      for (LS localLS = this.a.d; localLS != this.a; localLS = localLS.d) {
        localLz1.b(localLS.a, localLS.b, localLS.c - localLS.b);
      }
    }
  }
  
  public String toString()
  {
    Object localObject;
    if (this.b == 0L) {
      localObject = "Buffer[size=0]";
    }
    for (;;)
    {
      return localObject;
      if (this.b <= 16L)
      {
        LE localLE = t().p();
        Object[] arrayOfObject2 = new Object[2];
        arrayOfObject2[0] = Long.valueOf(this.b);
        arrayOfObject2[1] = localLE.c();
        localObject = String.format("Buffer[size=%s data=%s]", arrayOfObject2);
        continue;
      }
      try
      {
        MessageDigest localMessageDigest = MessageDigest.getInstance("MD5");
        localMessageDigest.update(this.a.a, this.a.b, this.a.c - this.a.b);
        for (LS localLS = this.a.d; localLS != this.a; localLS = localLS.d) {
          localMessageDigest.update(localLS.a, localLS.b, localLS.c - localLS.b);
        }
        Object[] arrayOfObject1 = new Object[2];
        arrayOfObject1[0] = Long.valueOf(this.b);
        arrayOfObject1[1] = LE.a(localMessageDigest.digest()).c();
        String str = String.format("Buffer[size=%s md5=%s]", arrayOfObject1);
        localObject = str;
      }
      catch (NoSuchAlgorithmException localNoSuchAlgorithmException)
      {
        throw new AssertionError();
      }
    }
  }
}


/* Location:           C:\Users\dreadiscool\Desktop\tools\classes-dex2jar.jar
 * Qualified Name:     Lz
 * JD-Core Version:    0.7.0.1
 */