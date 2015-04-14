import java.io.IOException;
import java.util.List;
import java.util.zip.Deflater;

final class Bq
  implements AS
{
  private final LC a;
  private final Lz b;
  private final LC c;
  private final boolean d;
  private boolean e;
  
  Bq(LC paramLC, boolean paramBoolean)
  {
    this.a = paramLC;
    this.d = paramBoolean;
    Deflater localDeflater = new Deflater();
    localDeflater.setDictionary(Bo.a);
    this.b = new Lz();
    this.c = LK.a(new LF(this.b, localDeflater));
  }
  
  private void a(List<AT> paramList)
  {
    if (this.b.c() != 0L) {
      throw new IllegalStateException();
    }
    this.c.e(paramList.size());
    int i = paramList.size();
    for (int j = 0; j < i; j++)
    {
      LE localLE1 = ((AT)paramList.get(j)).h;
      this.c.e(localLE1.e());
      this.c.b(localLE1);
      LE localLE2 = ((AT)paramList.get(j)).i;
      this.c.e(localLE2.e());
      this.c.b(localLE2);
    }
    this.c.a();
  }
  
  public void a() {}
  
  void a(int paramInt1, int paramInt2, Lz paramLz, int paramInt3)
  {
    if (this.e) {
      throw new IOException("closed");
    }
    if (paramInt3 > 16777215L) {
      throw new IllegalArgumentException("FRAME_TOO_LARGE max size is 16Mib: " + paramInt3);
    }
    this.a.e(0x7FFFFFFF & paramInt1);
    this.a.e((paramInt2 & 0xFF) << 24 | 0xFFFFFF & paramInt3);
    if (paramInt3 > 0) {
      this.a.a_(paramLz, paramInt3);
    }
  }
  
  public void a(int paramInt1, int paramInt2, List<AT> paramList) {}
  
  public void a(int paramInt, long paramLong)
  {
    try
    {
      if (this.e) {
        throw new IOException("closed");
      }
    }
    finally {}
    if ((paramLong == 0L) || (paramLong > 2147483647L)) {
      throw new IllegalArgumentException("windowSizeIncrement must be between 1 and 0x7fffffff: " + paramLong);
    }
    this.a.e(-2147287031);
    this.a.e(8);
    this.a.e(paramInt);
    this.a.e((int)paramLong);
    this.a.a();
  }
  
  public void a(int paramInt, AP paramAP)
  {
    try
    {
      if (this.e) {
        throw new IOException("closed");
      }
    }
    finally {}
    if (paramAP.t == -1) {
      throw new IllegalArgumentException();
    }
    this.a.e(-2147287037);
    this.a.e(8);
    this.a.e(0x7FFFFFFF & paramInt);
    this.a.e(paramAP.t);
    this.a.a();
  }
  
  public void a(int paramInt, AP paramAP, byte[] paramArrayOfByte)
  {
    try
    {
      if (this.e) {
        throw new IOException("closed");
      }
    }
    finally {}
    if (paramAP.u == -1) {
      throw new IllegalArgumentException("errorCode.spdyGoAwayCode == -1");
    }
    this.a.e(-2147287033);
    this.a.e(8);
    this.a.e(paramInt);
    this.a.e(paramAP.u);
    this.a.a();
  }
  
  public void a(Bn paramBn) {}
  
  public void a(boolean paramBoolean, int paramInt1, int paramInt2)
  {
    boolean bool1 = true;
    try
    {
      if (this.e) {
        throw new IOException("closed");
      }
    }
    finally {}
    boolean bool2 = this.d;
    boolean bool3;
    if ((paramInt1 & 0x1) == bool1) {
      bool3 = bool1;
    }
    for (;;)
    {
      if (paramBoolean != bool1) {
        throw new IllegalArgumentException("payload != reply");
      }
      this.a.e(-2147287034);
      this.a.e(4);
      this.a.e(paramInt1);
      this.a.a();
      return;
      for (;;)
      {
        if (bool2 == bool3) {
          break label128;
        }
        break;
        bool3 = false;
      }
      label128:
      bool1 = false;
    }
  }
  
  public void a(boolean paramBoolean, int paramInt1, Lz paramLz, int paramInt2)
  {
    if (paramBoolean) {}
    for (int i = 1;; i = 0) {
      try
      {
        a(paramInt1, i, paramLz, paramInt2);
        return;
      }
      finally {}
    }
  }
  
  public void a(boolean paramBoolean1, boolean paramBoolean2, int paramInt1, int paramInt2, List<AT> paramList)
  {
    int i = 0;
    try
    {
      if (this.e) {
        throw new IOException("closed");
      }
    }
    finally {}
    a(paramList);
    int j = (int)(10L + this.b.c());
    int k;
    if (paramBoolean1) {
      k = 1;
    }
    for (;;)
    {
      int m = i | k;
      this.a.e(-2147287039);
      this.a.e((m & 0xFF) << 24 | j & 0xFFFFFF);
      this.a.e(paramInt1 & 0x7FFFFFFF);
      this.a.e(paramInt2 & 0x7FFFFFFF);
      this.a.f(0);
      this.a.a(this.b);
      this.a.a();
      return;
      k = 0;
      if (paramBoolean2) {
        i = 2;
      }
    }
  }
  
  public void b()
  {
    try
    {
      if (this.e) {
        throw new IOException("closed");
      }
    }
    finally {}
    this.a.a();
  }
  
  public void b(Bn paramBn)
  {
    try
    {
      if (this.e) {
        throw new IOException("closed");
      }
    }
    finally {}
    int i = paramBn.b();
    int j = 4 + i * 8;
    this.a.e(-2147287036);
    this.a.e(0x0 | j & 0xFFFFFF);
    this.a.e(i);
    for (int k = 0;; k++) {
      if (k <= 10)
      {
        if (paramBn.a(k))
        {
          int m = paramBn.c(k);
          this.a.e((m & 0xFF) << 24 | k & 0xFFFFFF);
          this.a.e(paramBn.b(k));
        }
      }
      else
      {
        this.a.a();
        return;
      }
    }
  }
  
  public int c()
  {
    return 16383;
  }
  
  public void close()
  {
    try
    {
      this.e = true;
      Ae.a(this.a, this.c);
      return;
    }
    finally
    {
      localObject = finally;
      throw localObject;
    }
  }
}


/* Location:           C:\Users\dreadiscool\Desktop\tools\classes-dex2jar.jar
 * Qualified Name:     Bq
 * JD-Core Version:    0.7.0.1
 */