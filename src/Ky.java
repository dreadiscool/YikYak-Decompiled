import java.security.GeneralSecurityException;
import java.security.cert.CertificateException;
import java.security.cert.X509Certificate;
import java.util.LinkedList;
import javax.security.auth.x500.X500Principal;

final class Ky
{
  private static boolean a(X509Certificate paramX509Certificate1, X509Certificate paramX509Certificate2)
  {
    boolean bool = false;
    if (!paramX509Certificate1.getSubjectX500Principal().equals(paramX509Certificate2.getIssuerX500Principal())) {}
    for (;;)
    {
      return bool;
      try
      {
        paramX509Certificate2.verify(paramX509Certificate1.getPublicKey());
        bool = true;
      }
      catch (GeneralSecurityException localGeneralSecurityException) {}
    }
  }
  
  public static X509Certificate[] a(X509Certificate[] paramArrayOfX509Certificate, KO paramKO)
  {
    int i = 1;
    LinkedList localLinkedList = new LinkedList();
    if (paramKO.a(paramArrayOfX509Certificate[0])) {}
    for (int j = i;; j = 0)
    {
      localLinkedList.add(paramArrayOfX509Certificate[0]);
      int k = j;
      for (int m = i; m < paramArrayOfX509Certificate.length; m++)
      {
        if (paramKO.a(paramArrayOfX509Certificate[m])) {
          k = i;
        }
        if (!a(paramArrayOfX509Certificate[m], paramArrayOfX509Certificate[(m - 1)])) {
          break;
        }
        localLinkedList.add(paramArrayOfX509Certificate[m]);
      }
      X509Certificate localX509Certificate = paramKO.b(paramArrayOfX509Certificate[(m - 1)]);
      if (localX509Certificate != null) {
        localLinkedList.add(localX509Certificate);
      }
      for (;;)
      {
        if (i != 0) {
          return (X509Certificate[])localLinkedList.toArray(new X509Certificate[localLinkedList.size()]);
        }
        throw new CertificateException("Didn't find a trust anchor in chain cleanup!");
        i = k;
      }
    }
  }
}


/* Location:           C:\Users\dreadiscool\Desktop\tools\classes-dex2jar.jar
 * Qualified Name:     Ky
 * JD-Core Version:    0.7.0.1
 */