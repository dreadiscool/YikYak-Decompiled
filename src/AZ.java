import java.util.logging.Level;
import java.util.logging.Logger;

final class AZ
  implements LV
{
  int a;
  byte b;
  int c;
  int d;
  short e;
  private final LD f;
  
  public AZ(LD paramLD)
  {
    this.f = paramLD;
  }
  
  private void a()
  {
    int i = this.c;
    int j = AY.a(this.f);
    this.d = j;
    this.a = j;
    byte b1 = 0xFF & this.f.k();
    this.b = (0xFF & this.f.k());
    if (AY.b().isLoggable(Level.FINE)) {
      AY.b().fine(Ba.a(true, this.c, this.a, b1, this.b));
    }
    this.c = (0x7FFFFFFF & this.f.m());
    if (b1 != 9)
    {
      Object[] arrayOfObject = new Object[1];
      arrayOfObject[0] = Byte.valueOf(b1);
      throw AY.a("%s != TYPE_CONTINUATION", arrayOfObject);
    }
    if (this.c != i) {
      throw AY.a("TYPE_CONTINUATION streamId changed", new Object[0]);
    }
  }
  
  public long a(Lz paramLz, long paramLong)
  {
    long l1 = -1L;
    if (this.d == 0)
    {
      this.f.g(this.e);
      this.e = 0;
      if ((0x4 & this.b) == 0) {}
    }
    for (;;)
    {
      return l1;
      a();
      break;
      long l2 = this.f.a(paramLz, Math.min(paramLong, this.d));
      if (l2 != l1)
      {
        this.d = ((int)(this.d - l2));
        l1 = l2;
      }
    }
  }
  
  public LW b()
  {
    return this.f.b();
  }
  
  public void close() {}
}


/* Location:           C:\Users\dreadiscool\Desktop\tools\classes-dex2jar.jar
 * Qualified Name:     AZ
 * JD-Core Version:    0.7.0.1
 */