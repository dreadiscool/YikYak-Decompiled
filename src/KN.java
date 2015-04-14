import java.security.KeyStoreException;
import java.security.NoSuchAlgorithmException;
import java.security.cert.CertificateException;
import java.security.cert.X509Certificate;
import java.util.Collections;
import java.util.HashSet;
import java.util.LinkedList;
import java.util.List;
import java.util.Set;
import javax.net.ssl.TrustManager;
import javax.net.ssl.TrustManagerFactory;
import javax.net.ssl.X509TrustManager;

class KN
  implements X509TrustManager
{
  private final TrustManager[] a = a(paramKO);
  private final KO b;
  private final long c;
  private final List<byte[]> d = new LinkedList();
  private final Set<X509Certificate> e = Collections.synchronizedSet(new HashSet());
  
  public KN(KO paramKO, KM paramKM)
  {
    this.b = paramKO;
    this.c = paramKM.d();
    for (String str : paramKM.c()) {
      this.d.add(a(str));
    }
  }
  
  private void a(X509Certificate[] paramArrayOfX509Certificate)
  {
    if ((this.c != -1L) && (System.currentTimeMillis() - this.c > 15552000000L))
    {
      IC.g();
      new StringBuilder().append("Certificate pins are stale, (").append(System.currentTimeMillis() - this.c).append(" millis vs ").append(15552000000L).append(" millis) ").append("falling back to system trust.").toString();
      return;
    }
    X509Certificate[] arrayOfX509Certificate = Ky.a(paramArrayOfX509Certificate, this.b);
    int i = arrayOfX509Certificate.length;
    for (int j = 0;; j++)
    {
      if (j >= i) {
        break label117;
      }
      if (a(arrayOfX509Certificate[j])) {
        break;
      }
    }
    label117:
    throw new CertificateException("No valid pins found in chain!");
  }
  
  private void a(X509Certificate[] paramArrayOfX509Certificate, String paramString)
  {
    TrustManager[] arrayOfTrustManager = this.a;
    int i = arrayOfTrustManager.length;
    for (int j = 0; j < i; j++) {
      ((X509TrustManager)arrayOfTrustManager[j]).checkServerTrusted(paramArrayOfX509Certificate, paramString);
    }
  }
  
  /* Error */
  private boolean a(X509Certificate paramX509Certificate)
  {
    // Byte code:
    //   0: ldc 126
    //   2: invokestatic 132	java/security/MessageDigest:getInstance	(Ljava/lang/String;)Ljava/security/MessageDigest;
    //   5: aload_1
    //   6: invokevirtual 138	java/security/cert/X509Certificate:getPublicKey	()Ljava/security/PublicKey;
    //   9: invokeinterface 144 1 0
    //   14: invokevirtual 148	java/security/MessageDigest:digest	([B)[B
    //   17: astore_3
    //   18: aload_0
    //   19: getfield 28	KN:d	Ljava/util/List;
    //   22: invokeinterface 152 1 0
    //   27: astore 4
    //   29: aload 4
    //   31: invokeinterface 158 1 0
    //   36: ifeq +30 -> 66
    //   39: aload 4
    //   41: invokeinterface 162 1 0
    //   46: checkcast 164	[B
    //   49: aload_3
    //   50: invokestatic 170	java/util/Arrays:equals	([B[B)Z
    //   53: istore 6
    //   55: iload 6
    //   57: ifeq -28 -> 29
    //   60: iconst_1
    //   61: istore 5
    //   63: iload 5
    //   65: ireturn
    //   66: iconst_0
    //   67: istore 5
    //   69: goto -6 -> 63
    //   72: astore_2
    //   73: new 113	java/security/cert/CertificateException
    //   76: dup
    //   77: aload_2
    //   78: invokespecial 173	java/security/cert/CertificateException:<init>	(Ljava/lang/Throwable;)V
    //   81: athrow
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	82	0	this	KN
    //   0	82	1	paramX509Certificate	X509Certificate
    //   72	6	2	localNoSuchAlgorithmException	NoSuchAlgorithmException
    //   17	33	3	arrayOfByte	byte[]
    //   27	13	4	localIterator	java.util.Iterator
    //   61	7	5	bool1	boolean
    //   53	3	6	bool2	boolean
    // Exception table:
    //   from	to	target	type
    //   0	55	72	java/security/NoSuchAlgorithmException
  }
  
  private byte[] a(String paramString)
  {
    int i = paramString.length();
    byte[] arrayOfByte = new byte[i / 2];
    for (int j = 0; j < i; j += 2) {
      arrayOfByte[(j / 2)] = ((byte)((Character.digit(paramString.charAt(j), 16) << 4) + Character.digit(paramString.charAt(j + 1), 16)));
    }
    return arrayOfByte;
  }
  
  private TrustManager[] a(KO paramKO)
  {
    try
    {
      TrustManagerFactory localTrustManagerFactory = TrustManagerFactory.getInstance("X509");
      localTrustManagerFactory.init(paramKO.a);
      TrustManager[] arrayOfTrustManager = localTrustManagerFactory.getTrustManagers();
      return arrayOfTrustManager;
    }
    catch (NoSuchAlgorithmException localNoSuchAlgorithmException)
    {
      throw new AssertionError(localNoSuchAlgorithmException);
    }
    catch (KeyStoreException localKeyStoreException)
    {
      throw new AssertionError(localKeyStoreException);
    }
  }
  
  public void checkClientTrusted(X509Certificate[] paramArrayOfX509Certificate, String paramString)
  {
    throw new CertificateException("Client certificates not supported!");
  }
  
  public void checkServerTrusted(X509Certificate[] paramArrayOfX509Certificate, String paramString)
  {
    if (this.e.contains(paramArrayOfX509Certificate[0])) {}
    for (;;)
    {
      return;
      a(paramArrayOfX509Certificate, paramString);
      a(paramArrayOfX509Certificate);
      this.e.add(paramArrayOfX509Certificate[0]);
    }
  }
  
  public X509Certificate[] getAcceptedIssuers()
  {
    return null;
  }
}


/* Location:           C:\Users\dreadiscool\Desktop\tools\classes-dex2jar.jar
 * Qualified Name:     KN
 * JD-Core Version:    0.7.0.1
 */