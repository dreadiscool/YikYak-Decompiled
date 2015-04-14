import java.net.InetSocketAddress;
import java.net.Proxy;
import java.net.Proxy.Type;

public final class zJ
{
  final yJ a;
  final Proxy b;
  final InetSocketAddress c;
  final zi d;
  final boolean e;
  
  public zJ(yJ paramyJ, Proxy paramProxy, InetSocketAddress paramInetSocketAddress, zi paramzi, boolean paramBoolean)
  {
    if (paramyJ == null) {
      throw new NullPointerException("address == null");
    }
    if (paramProxy == null) {
      throw new NullPointerException("proxy == null");
    }
    if (paramInetSocketAddress == null) {
      throw new NullPointerException("inetSocketAddress == null");
    }
    if (paramzi == null) {
      throw new NullPointerException("connectionConfiguration == null");
    }
    this.a = paramyJ;
    this.b = paramProxy;
    this.c = paramInetSocketAddress;
    this.d = paramzi;
    this.e = paramBoolean;
  }
  
  public yJ a()
  {
    return this.a;
  }
  
  public Proxy b()
  {
    return this.b;
  }
  
  public boolean c()
  {
    if ((this.a.e != null) && (this.b.type() == Proxy.Type.HTTP)) {}
    for (boolean bool = true;; bool = false) {
      return bool;
    }
  }
  
  public boolean equals(Object paramObject)
  {
    boolean bool = false;
    if ((paramObject instanceof zJ))
    {
      zJ localzJ = (zJ)paramObject;
      if ((this.a.equals(localzJ.a)) && (this.b.equals(localzJ.b)) && (this.c.equals(localzJ.c)) && (this.d.equals(localzJ.d)) && (this.e == localzJ.e)) {
        bool = true;
      }
    }
    return bool;
  }
  
  public int hashCode()
  {
    int i = 31 * (31 * (31 * (31 * (527 + this.a.hashCode()) + this.b.hashCode()) + this.c.hashCode()) + this.d.hashCode());
    if (this.e) {}
    for (int j = 1;; j = 0) {
      return j + i;
    }
  }
}


/* Location:           C:\Users\dreadiscool\Desktop\tools\classes-dex2jar.jar
 * Qualified Name:     zJ
 * JD-Core Version:    0.7.0.1
 */