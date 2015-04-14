import java.net.URL;
import java.util.List;

class AA
  implements zs
{
  private final int b;
  private final zz c;
  private int d;
  
  AA(Ax paramAx, int paramInt, zz paramzz)
  {
    this.b = paramInt;
    this.c = paramzz;
  }
  
  public zF a(zz paramzz)
  {
    this.d = (1 + this.d);
    if (this.b > 0)
    {
      zr localzr2 = (zr)this.a.a.v().get(-1 + this.b);
      yJ localyJ = b().c().a();
      if ((!paramzz.a().getHost().equals(localyJ.a())) || (Ae.a(paramzz.a()) != localyJ.b())) {
        throw new IllegalStateException("network interceptor " + localzr2 + " must retain the same host and port");
      }
      if (this.d > 1) {
        throw new IllegalStateException("network interceptor " + localzr2 + " must call proceed() exactly once");
      }
    }
    zF localzF1;
    if (this.b < this.a.a.v().size())
    {
      AA localAA = new AA(this.a, 1 + this.b, paramzz);
      zr localzr1 = (zr)this.a.a.v().get(this.b);
      localzF1 = localzr1.a(localAA);
      if (localAA.d != 1) {
        throw new IllegalStateException("network interceptor " + localzr1 + " must call proceed() exactly once");
      }
    }
    for (zF localzF2 = localzF1;; localzF2 = Ax.c(this.a))
    {
      return localzF2;
      Ax.b(this.a).a(paramzz);
      if ((this.a.c()) && (paramzz.f() != null))
      {
        LC localLC = LK.a(Ax.b(this.a).a(paramzz, paramzz.f().b()));
        paramzz.f().a(localLC);
        localLC.close();
      }
    }
  }
  
  public zz a()
  {
    return this.c;
  }
  
  public zf b()
  {
    return Ax.a(this.a);
  }
}


/* Location:           C:\Users\dreadiscool\Desktop\tools\classes-dex2jar.jar
 * Qualified Name:     AA
 * JD-Core Version:    0.7.0.1
 */