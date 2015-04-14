import javax.net.ssl.SSLContext;
import javax.net.ssl.SSLSocketFactory;
import javax.net.ssl.TrustManager;

public final class KL
{
  public static final SSLSocketFactory a(KM paramKM)
  {
    SSLContext localSSLContext = SSLContext.getInstance("TLS");
    KN localKN = new KN(new KO(paramKM.a(), paramKM.b()), paramKM);
    TrustManager[] arrayOfTrustManager = new TrustManager[1];
    arrayOfTrustManager[0] = localKN;
    localSSLContext.init(null, arrayOfTrustManager, null);
    return localSSLContext.getSocketFactory();
  }
}


/* Location:           C:\Users\dreadiscool\Desktop\tools\classes-dex2jar.jar
 * Qualified Name:     KL
 * JD-Core Version:    0.7.0.1
 */