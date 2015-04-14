import java.security.Principal;
import java.security.cert.Certificate;
import java.security.cert.X509Certificate;
import java.util.Collections;
import java.util.List;
import javax.net.ssl.SSLPeerUnverifiedException;
import javax.net.ssl.SSLSession;
import javax.security.auth.x500.X500Principal;

public final class zn
{
  private final String a;
  private final List<Certificate> b;
  private final List<Certificate> c;
  
  private zn(String paramString, List<Certificate> paramList1, List<Certificate> paramList2)
  {
    this.a = paramString;
    this.b = paramList1;
    this.c = paramList2;
  }
  
  public static zn a(String paramString, List<Certificate> paramList1, List<Certificate> paramList2)
  {
    if (paramString == null) {
      throw new IllegalArgumentException("cipherSuite == null");
    }
    return new zn(paramString, Ae.a(paramList1), Ae.a(paramList2));
  }
  
  public static zn a(SSLSession paramSSLSession)
  {
    String str = paramSSLSession.getCipherSuite();
    if (str == null) {
      throw new IllegalStateException("cipherSuite == null");
    }
    try
    {
      Certificate[] arrayOfCertificate3 = paramSSLSession.getPeerCertificates();
      arrayOfCertificate1 = arrayOfCertificate3;
    }
    catch (SSLPeerUnverifiedException localSSLPeerUnverifiedException)
    {
      for (;;)
      {
        Certificate[] arrayOfCertificate2;
        Certificate[] arrayOfCertificate1 = null;
        continue;
        List localList1 = Collections.emptyList();
        continue;
        List localList2 = Collections.emptyList();
      }
    }
    if (arrayOfCertificate1 != null)
    {
      localList1 = Ae.a(arrayOfCertificate1);
      arrayOfCertificate2 = paramSSLSession.getLocalCertificates();
      if (arrayOfCertificate2 == null) {
        break label89;
      }
      localList2 = Ae.a(arrayOfCertificate2);
      return new zn(str, localList1, localList2);
    }
  }
  
  public String a()
  {
    return this.a;
  }
  
  public List<Certificate> b()
  {
    return this.b;
  }
  
  public Principal c()
  {
    if (!this.b.isEmpty()) {}
    for (X500Principal localX500Principal = ((X509Certificate)this.b.get(0)).getSubjectX500Principal();; localX500Principal = null) {
      return localX500Principal;
    }
  }
  
  public List<Certificate> d()
  {
    return this.c;
  }
  
  public Principal e()
  {
    if (!this.c.isEmpty()) {}
    for (X500Principal localX500Principal = ((X509Certificate)this.c.get(0)).getSubjectX500Principal();; localX500Principal = null) {
      return localX500Principal;
    }
  }
  
  public boolean equals(Object paramObject)
  {
    boolean bool = false;
    if (!(paramObject instanceof zn)) {}
    for (;;)
    {
      return bool;
      zn localzn = (zn)paramObject;
      if ((this.a.equals(localzn.a)) && (this.b.equals(localzn.b)) && (this.c.equals(localzn.c))) {
        bool = true;
      }
    }
  }
  
  public int hashCode()
  {
    return 31 * (31 * (527 + this.a.hashCode()) + this.b.hashCode()) + this.c.hashCode();
  }
}


/* Location:           C:\Users\dreadiscool\Desktop\tools\classes-dex2jar.jar
 * Qualified Name:     zn
 * JD-Core Version:    0.7.0.1
 */