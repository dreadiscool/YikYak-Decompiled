import java.util.Locale;
import java.util.Map;
import javax.net.ssl.HttpsURLConnection;
import javax.net.ssl.SSLSocketFactory;

public class Kz
  implements KK
{
  private final IO a;
  private KM b;
  private SSLSocketFactory c;
  private boolean d;
  
  public Kz()
  {
    this(new IB());
  }
  
  public Kz(IO paramIO)
  {
    this.a = paramIO;
  }
  
  private void a()
  {
    try
    {
      this.d = false;
      this.c = null;
      return;
    }
    finally
    {
      localObject = finally;
      throw localObject;
    }
  }
  
  private boolean a(String paramString)
  {
    if ((paramString != null) && (paramString.toLowerCase(Locale.US).startsWith("https"))) {}
    for (boolean bool = true;; bool = false) {
      return bool;
    }
  }
  
  private SSLSocketFactory b()
  {
    try
    {
      if ((this.c == null) && (!this.d)) {
        this.c = c();
      }
      SSLSocketFactory localSSLSocketFactory = this.c;
      return localSSLSocketFactory;
    }
    finally
    {
      localObject = finally;
      throw localObject;
    }
  }
  
  private SSLSocketFactory c()
  {
    try
    {
      this.d = true;
      try
      {
        SSLSocketFactory localSSLSocketFactory2 = KL.a(this.b);
        localSSLSocketFactory1 = localSSLSocketFactory2;
      }
      catch (Exception localException)
      {
        for (;;)
        {
          SSLSocketFactory localSSLSocketFactory1 = null;
        }
      }
      return localSSLSocketFactory1;
    }
    finally {}
  }
  
  public KC a(KB paramKB, String paramString, Map<String, String> paramMap)
  {
    KC localKC;
    switch (KA.a[paramKB.ordinal()])
    {
    default: 
      throw new IllegalArgumentException("Unsupported HTTP method!");
    case 1: 
      localKC = KC.a(paramString, paramMap, true);
    }
    for (;;)
    {
      if ((a(paramString)) && (this.b != null))
      {
        SSLSocketFactory localSSLSocketFactory = b();
        if (localSSLSocketFactory != null) {
          ((HttpsURLConnection)localKC.a()).setSSLSocketFactory(localSSLSocketFactory);
        }
      }
      return localKC;
      localKC = KC.b(paramString, paramMap, true);
      continue;
      localKC = KC.d(paramString);
      continue;
      localKC = KC.e(paramString);
    }
  }
  
  public void a(KM paramKM)
  {
    if (this.b != paramKM)
    {
      this.b = paramKM;
      a();
    }
  }
}


/* Location:           C:\Users\dreadiscool\Desktop\tools\classes-dex2jar.jar
 * Qualified Name:     Kz
 * JD-Core Version:    0.7.0.1
 */