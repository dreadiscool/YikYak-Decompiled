import java.net.HttpURLConnection;
import java.net.Proxy;
import java.net.URL;

final class KG
  implements KF
{
  public HttpURLConnection a(URL paramURL)
  {
    return (HttpURLConnection)paramURL.openConnection();
  }
  
  public HttpURLConnection a(URL paramURL, Proxy paramProxy)
  {
    return (HttpURLConnection)paramURL.openConnection(paramProxy);
  }
}


/* Location:           C:\Users\dreadiscool\Desktop\tools\classes-dex2jar.jar
 * Qualified Name:     KG
 * JD-Core Version:    0.7.0.1
 */