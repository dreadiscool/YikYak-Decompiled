import java.net.Proxy;

public final class AC
  implements AL
{
  private final Ax a;
  private final An b;
  
  public AC(Ax paramAx, An paramAn)
  {
    this.a = paramAx;
    this.b = paramAn;
  }
  
  private LV b(zF paramzF)
  {
    LV localLV;
    if (!Ax.a(paramzF)) {
      localLV = this.b.b(0L);
    }
    for (;;)
    {
      return localLV;
      if ("chunked".equalsIgnoreCase(paramzF.a("Transfer-Encoding")))
      {
        localLV = this.b.a(this.a);
      }
      else
      {
        long l = AD.a(paramzF);
        if (l != -1L) {
          localLV = this.b.b(l);
        } else {
          localLV = this.b.i();
        }
      }
    }
  }
  
  public LU a(zz paramzz, long paramLong)
  {
    if ("chunked".equalsIgnoreCase(paramzz.a("Transfer-Encoding"))) {}
    for (LU localLU = this.b.h();; localLU = this.b.a(paramLong))
    {
      return localLU;
      if (paramLong == -1L) {
        break;
      }
    }
    throw new IllegalStateException("Cannot stream a request body without chunked encoding or a known content length!");
  }
  
  public zI a(zF paramzF)
  {
    LV localLV = b(paramzF);
    return new AF(paramzF.g(), LK.a(localLV));
  }
  
  public void a()
  {
    this.b.d();
  }
  
  public void a(AH paramAH)
  {
    this.b.a(paramAH);
  }
  
  public void a(Ax paramAx)
  {
    this.b.a(paramAx);
  }
  
  public void a(zz paramzz)
  {
    this.a.b();
    String str = AG.a(paramzz, this.a.i().c().b().type(), this.a.i().l());
    this.b.a(paramzz.e(), str);
  }
  
  public zH b()
  {
    return this.b.g();
  }
  
  public void c()
  {
    if (d()) {
      this.b.a();
    }
    for (;;)
    {
      return;
      this.b.b();
    }
  }
  
  public boolean d()
  {
    boolean bool = false;
    if ("close".equalsIgnoreCase(this.a.g().a("Connection"))) {}
    for (;;)
    {
      return bool;
      if ((!"close".equalsIgnoreCase(this.a.h().a("Connection"))) && (!this.b.c())) {
        bool = true;
      }
    }
  }
}


/* Location:           C:\Users\dreadiscool\Desktop\tools\classes-dex2jar.jar
 * Qualified Name:     AC
 * JD-Core Version:    0.7.0.1
 */