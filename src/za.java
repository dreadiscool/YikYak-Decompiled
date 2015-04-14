import java.security.Principal;
import java.security.PublicKey;
import java.security.cert.Certificate;
import java.security.cert.X509Certificate;
import java.util.List;
import java.util.Map;
import javax.net.ssl.SSLPeerUnverifiedException;

public final class za
{
  public static final za a = new zc().a();
  private final Map<String, List<LE>> b;
  
  private za(zc paramzc)
  {
    this.b = Ae.a(zc.a(paramzc));
  }
  
  private static LE a(X509Certificate paramX509Certificate)
  {
    return Ae.a(LE.a(paramX509Certificate.getPublicKey().getEncoded()));
  }
  
  public static String a(Certificate paramCertificate)
  {
    if (!(paramCertificate instanceof X509Certificate)) {
      throw new IllegalArgumentException("Certificate pinning requires X509 certificates");
    }
    return "sha1/" + a((X509Certificate)paramCertificate).b();
  }
  
  public void a(String paramString, List<Certificate> paramList)
  {
    int i = 0;
    List localList = (List)this.b.get(paramString);
    if (localList == null) {
      return;
    }
    int j = paramList.size();
    for (int k = 0;; k++)
    {
      if (k >= j) {
        break label71;
      }
      if (localList.contains(a((X509Certificate)paramList.get(k)))) {
        break;
      }
    }
    label71:
    StringBuilder localStringBuilder = new StringBuilder().append("Certificate pinning failure!").append("\n  Peer certificate chain:");
    int m = paramList.size();
    for (int n = 0; n < m; n++)
    {
      X509Certificate localX509Certificate = (X509Certificate)paramList.get(n);
      localStringBuilder.append("\n    ").append(a(localX509Certificate)).append(": ").append(localX509Certificate.getSubjectDN().getName());
    }
    localStringBuilder.append("\n  Pinned certificates for ").append(paramString).append(":");
    int i1 = localList.size();
    while (i < i1)
    {
      LE localLE = (LE)localList.get(i);
      localStringBuilder.append("\n    sha1/").append(localLE.b());
      i++;
    }
    throw new SSLPeerUnverifiedException(localStringBuilder.toString());
  }
}


/* Location:           C:\Users\dreadiscool\Desktop\tools\classes-dex2jar.jar
 * Qualified Name:     za
 * JD-Core Version:    0.7.0.1
 */