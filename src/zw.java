import java.net.HttpURLConnection;
import java.net.Proxy;
import java.net.URL;
import java.net.URLStreamHandler;
import java.net.URLStreamHandlerFactory;

public final class zw
  implements Cloneable, URLStreamHandlerFactory
{
  private final zu a;
  
  public zw(zu paramzu)
  {
    this.a = paramzu;
  }
  
  public HttpURLConnection a(URL paramURL)
  {
    return a(paramURL, this.a.d());
  }
  
  HttpURLConnection a(URL paramURL, Proxy paramProxy)
  {
    String str = paramURL.getProtocol();
    zu localzu = this.a.w();
    localzu.a(paramProxy);
    if (str.equals("http")) {}
    for (Object localObject = new AN(paramURL, localzu);; localObject = new AO(paramURL, localzu))
    {
      return localObject;
      if (!str.equals("https")) {
        break;
      }
    }
    throw new IllegalArgumentException("Unexpected protocol: " + str);
  }
  
  public zu a()
  {
    return this.a;
  }
  
  public zw b()
  {
    return new zw(this.a.x());
  }
  
  public URLStreamHandler createURLStreamHandler(String paramString)
  {
    if ((!paramString.equals("http")) && (!paramString.equals("https"))) {}
    for (Object localObject = null;; localObject = new zx(this, paramString)) {
      return localObject;
    }
  }
}


/* Location:           C:\Users\dreadiscool\Desktop\tools\classes-dex2jar.jar
 * Qualified Name:     zw
 * JD-Core Version:    0.7.0.1
 */