import java.io.IOException;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;

final class Bc
  implements AS
{
  private final LC a;
  private final boolean b;
  private final Lz c;
  private final AX d;
  private int e;
  private boolean f;
  
  Bc(LC paramLC, boolean paramBoolean)
  {
    this.a = paramLC;
    this.b = paramBoolean;
    this.c = new Lz();
    this.d = new AX(this.c);
    this.e = 16384;
  }
  
  private void b(int paramInt, long paramLong)
  {
    if (paramLong > 0L)
    {
      int i = (int)Math.min(this.e, paramLong);
      paramLong -= i;
      if (paramLong == 0L) {}
      for (byte b1 = 4;; b1 = 0)
      {
        a(paramInt, i, (byte)9, b1);
        this.a.a_(this.c, i);
        break;
      }
    }
  }
  
  public void a()
  {
    try
    {
      if (this.f) {
        throw new IOException("closed");
      }
    }
    finally {}
    boolean bool = this.b;
    if (!bool) {}
    for (;;)
    {
      return;
      if (AY.b().isLoggable(Level.FINE))
      {
        Logger localLogger = AY.b();
        Object[] arrayOfObject = new Object[1];
        arrayOfObject[0] = AY.a().c();
        localLogger.fine(String.format(">> CONNECTION %s", arrayOfObject));
      }
      this.a.c(AY.a().f());
      this.a.a();
    }
  }
  
  void a(int paramInt1, byte paramByte, Lz paramLz, int paramInt2)
  {
    a(paramInt1, paramInt2, (byte)0, paramByte);
    if (paramInt2 > 0) {
      this.a.a_(paramLz, paramInt2);
    }
  }
  
  void a(int paramInt1, int paramInt2, byte paramByte1, byte paramByte2)
  {
    if (AY.b().isLoggable(Level.FINE)) {
      AY.b().fine(Ba.a(false, paramInt1, paramInt2, paramByte1, paramByte2));
    }
    if (paramInt2 > this.e)
    {
      Object[] arrayOfObject2 = new Object[2];
      arrayOfObject2[0] = Integer.valueOf(this.e);
      arrayOfObject2[1] = Integer.valueOf(paramInt2);
      throw AY.b("FRAME_SIZE_ERROR length > %d: %d", arrayOfObject2);
    }
    if ((0x80000000 & paramInt1) != 0)
    {
      Object[] arrayOfObject1 = new Object[1];
      arrayOfObject1[0] = Integer.valueOf(paramInt1);
      throw AY.b("reserved bit set: %s", arrayOfObject1);
    }
    AY.a(this.a, paramInt2);
    this.a.g(paramByte1 & 0xFF);
    this.a.g(paramByte2 & 0xFF);
    this.a.e(0x7FFFFFFF & paramInt1);
  }
  
  public void a(int paramInt1, int paramInt2, List<AT> paramList)
  {
    try
    {
      if (this.f) {
        throw new IOException("closed");
      }
    }
    finally {}
    if (this.c.c() != 0L) {
      throw new IllegalStateException();
    }
    this.d.a(paramList);
    long l = this.c.c();
    int i = (int)Math.min(-4 + this.e, l);
    if (l == i) {}
    for (byte b1 = 4;; b1 = 0)
    {
      a(paramInt1, i + 4, (byte)5, b1);
      this.a.e(0x7FFFFFFF & paramInt2);
      this.a.a_(this.c, i);
      if (l > i) {
        b(paramInt1, l - i);
      }
      return;
    }
  }
  
  public void a(int paramInt, long paramLong)
  {
    try
    {
      if (this.f) {
        throw new IOException("closed");
      }
    }
    finally {}
    if ((paramLong == 0L) || (paramLong > 2147483647L))
    {
      Object[] arrayOfObject = new Object[1];
      arrayOfObject[0] = Long.valueOf(paramLong);
      throw AY.b("windowSizeIncrement == 0 || windowSizeIncrement > 0x7fffffffL: %s", arrayOfObject);
    }
    a(paramInt, 4, (byte)8, (byte)0);
    this.a.e((int)paramLong);
    this.a.a();
  }
  
  public void a(int paramInt, AP paramAP)
  {
    try
    {
      if (this.f) {
        throw new IOException("closed");
      }
    }
    finally {}
    if (paramAP.t == -1) {
      throw new IllegalArgumentException();
    }
    a(paramInt, 4, (byte)3, (byte)0);
    this.a.e(paramAP.s);
    this.a.a();
  }
  
  public void a(int paramInt, AP paramAP, byte[] paramArrayOfByte)
  {
    try
    {
      if (this.f) {
        throw new IOException("closed");
      }
    }
    finally {}
    if (paramAP.s == -1) {
      throw AY.b("errorCode.httpCode == -1", new Object[0]);
    }
    a(0, 8 + paramArrayOfByte.length, (byte)7, (byte)0);
    this.a.e(paramInt);
    this.a.e(paramAP.s);
    if (paramArrayOfByte.length > 0) {
      this.a.c(paramArrayOfByte);
    }
    this.a.a();
  }
  
  public void a(Bn paramBn)
  {
    try
    {
      if (this.f) {
        throw new IOException("closed");
      }
    }
    finally {}
    this.e = paramBn.d(this.e);
    a(0, 0, (byte)4, (byte)1);
    this.a.a();
  }
  
  public void a(boolean paramBoolean, int paramInt1, int paramInt2)
  {
    byte b1 = 0;
    try
    {
      if (this.f) {
        throw new IOException("closed");
      }
    }
    finally {}
    if (paramBoolean) {
      b1 = 1;
    }
    a(0, 8, (byte)6, b1);
    this.a.e(paramInt1);
    this.a.e(paramInt2);
    this.a.a();
  }
  
  public void a(boolean paramBoolean, int paramInt1, Lz paramLz, int paramInt2)
  {
    try
    {
      if (this.f) {
        throw new IOException("closed");
      }
    }
    finally {}
    byte b1 = 0;
    if (paramBoolean) {
      b1 = (byte)1;
    }
    a(paramInt1, b1, paramLz, paramInt2);
  }
  
  void a(boolean paramBoolean, int paramInt, List<AT> paramList)
  {
    if (this.f) {
      throw new IOException("closed");
    }
    if (this.c.c() != 0L) {
      throw new IllegalStateException();
    }
    this.d.a(paramList);
    long l = this.c.c();
    int i = (int)Math.min(this.e, l);
    if (l == i) {}
    for (byte b1 = 4;; b1 = 0)
    {
      if (paramBoolean) {
        b1 = (byte)(b1 | 0x1);
      }
      a(paramInt, i, (byte)1, b1);
      this.a.a_(this.c, i);
      if (l > i) {
        b(paramInt, l - i);
      }
      return;
    }
  }
  
  public void a(boolean paramBoolean1, boolean paramBoolean2, int paramInt1, int paramInt2, List<AT> paramList)
  {
    if (paramBoolean2) {
      try
      {
        throw new UnsupportedOperationException();
      }
      finally {}
    }
    if (this.f) {
      throw new IOException("closed");
    }
    a(paramBoolean1, paramInt1, paramList);
  }
  
  public void b()
  {
    try
    {
      if (this.f) {
        throw new IOException("closed");
      }
    }
    finally {}
    this.a.a();
  }
  
  public void b(Bn paramBn)
  {
    int i = 0;
    try
    {
      if (this.f) {
        throw new IOException("closed");
      }
    }
    finally {}
    a(0, 6 * paramBn.b(), (byte)4, (byte)0);
    if (i < 10) {
      if (paramBn.a(i)) {
        break label111;
      }
    }
    for (;;)
    {
      label57:
      this.a.f(j);
      this.a.e(paramBn.b(i));
      break label105;
      this.a.a();
      return;
      label105:
      label111:
      do
      {
        j = i;
        break label57;
        i++;
        break;
        if (i == 4)
        {
          j = 3;
          break label57;
        }
      } while (i != 7);
      int j = 4;
    }
  }
  
  public int c()
  {
    return this.e;
  }
  
  public void close()
  {
    try
    {
      this.f = true;
      this.a.close();
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
 * Qualified Name:     Bc
 * JD-Core Version:    0.7.0.1
 */