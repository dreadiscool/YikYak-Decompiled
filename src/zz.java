import java.io.IOException;
import java.net.MalformedURLException;
import java.net.URI;
import java.net.URISyntaxException;
import java.net.URL;
import java.util.List;

public final class zz
{
  private final String a;
  private final String b;
  private final zo c;
  private final zC d;
  private final Object e;
  private volatile URL f;
  private volatile URI g;
  private volatile yS h;
  
  private zz(zB paramzB)
  {
    this.a = zB.a(paramzB);
    this.b = zB.b(paramzB);
    this.c = zB.c(paramzB).a();
    this.d = zB.d(paramzB);
    if (zB.e(paramzB) != null) {}
    for (Object localObject = zB.e(paramzB);; localObject = this)
    {
      this.e = localObject;
      this.f = zB.f(paramzB);
      return;
    }
  }
  
  public String a(String paramString)
  {
    return this.c.a(paramString);
  }
  
  public URL a()
  {
    URL localURL;
    try
    {
      localURL = this.f;
      if (localURL == null)
      {
        localURL = new URL(this.a);
        this.f = localURL;
      }
    }
    catch (MalformedURLException localMalformedURLException)
    {
      throw new RuntimeException("Malformed URL: " + this.a, localMalformedURLException);
    }
    return localURL;
  }
  
  public URI b()
  {
    URI localURI;
    try
    {
      localURI = this.g;
      if (localURI == null)
      {
        localURI = zY.a().a(a());
        this.g = localURI;
      }
    }
    catch (URISyntaxException localURISyntaxException)
    {
      throw new IOException(localURISyntaxException.getMessage());
    }
    return localURI;
  }
  
  public List<String> b(String paramString)
  {
    return this.c.c(paramString);
  }
  
  public String c()
  {
    return this.a;
  }
  
  public String d()
  {
    return this.b;
  }
  
  public zo e()
  {
    return this.c;
  }
  
  public zC f()
  {
    return this.d;
  }
  
  public zB g()
  {
    return new zB(this, null);
  }
  
  public yS h()
  {
    yS localyS = this.h;
    if (localyS != null) {}
    for (;;)
    {
      return localyS;
      localyS = yS.a(this.c);
      this.h = localyS;
    }
  }
  
  public boolean i()
  {
    return a().getProtocol().equals("https");
  }
  
  public String toString()
  {
    StringBuilder localStringBuilder = new StringBuilder().append("Request{method=").append(this.b).append(", url=").append(this.a).append(", tag=");
    if (this.e != this) {}
    for (Object localObject = this.e;; localObject = null) {
      return localObject + '}';
    }
  }
}


/* Location:           C:\Users\dreadiscool\Desktop\tools\classes-dex2jar.jar
 * Qualified Name:     zz
 * JD-Core Version:    0.7.0.1
 */