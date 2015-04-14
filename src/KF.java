import java.net.HttpURLConnection;
import java.net.Proxy;
import java.net.URL;

public abstract interface KF
{
  public static final KF a = new KG();
  
  public abstract HttpURLConnection a(URL paramURL);
  
  public abstract HttpURLConnection a(URL paramURL, Proxy paramProxy);
}


/* Location:           C:\Users\dreadiscool\Desktop\tools\classes-dex2jar.jar
 * Qualified Name:     KF
 * JD-Core Version:    0.7.0.1
 */