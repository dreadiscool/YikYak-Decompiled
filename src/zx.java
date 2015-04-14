import java.net.Proxy;
import java.net.URL;
import java.net.URLConnection;
import java.net.URLStreamHandler;

class zx
  extends URLStreamHandler
{
  zx(zw paramzw, String paramString) {}
  
  protected int getDefaultPort()
  {
    if (this.a.equals("http")) {}
    for (int i = 80;; i = 443)
    {
      return i;
      if (!this.a.equals("https")) {
        break;
      }
    }
    throw new AssertionError();
  }
  
  protected URLConnection openConnection(URL paramURL)
  {
    return this.b.a(paramURL);
  }
  
  protected URLConnection openConnection(URL paramURL, Proxy paramProxy)
  {
    return this.b.a(paramURL, paramProxy);
  }
}


/* Location:           C:\Users\dreadiscool\Desktop\tools\classes-dex2jar.jar
 * Qualified Name:     zx
 * JD-Core Version:    0.7.0.1
 */