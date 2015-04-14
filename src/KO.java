import java.io.InputStream;
import java.security.GeneralSecurityException;
import java.security.KeyStore;
import java.security.KeyStoreException;
import java.security.Principal;
import java.security.cert.X509Certificate;
import java.util.Enumeration;
import java.util.HashMap;
import javax.security.auth.x500.X500Principal;

class KO
{
  final KeyStore a;
  private final HashMap<Principal, X509Certificate> b;
  
  public KO(InputStream paramInputStream, String paramString)
  {
    KeyStore localKeyStore = a(paramInputStream, paramString);
    this.b = a(localKeyStore);
    this.a = localKeyStore;
  }
  
  /* Error */
  private KeyStore a(InputStream paramInputStream, String paramString)
  {
    // Byte code:
    //   0: ldc 34
    //   2: invokestatic 40	java/security/KeyStore:getInstance	(Ljava/lang/String;)Ljava/security/KeyStore;
    //   5: astore 7
    //   7: new 42	java/io/BufferedInputStream
    //   10: dup
    //   11: aload_1
    //   12: invokespecial 45	java/io/BufferedInputStream:<init>	(Ljava/io/InputStream;)V
    //   15: astore 8
    //   17: aload 7
    //   19: aload 8
    //   21: aload_2
    //   22: invokevirtual 51	java/lang/String:toCharArray	()[C
    //   25: invokevirtual 55	java/security/KeyStore:load	(Ljava/io/InputStream;[C)V
    //   28: aload 8
    //   30: invokevirtual 58	java/io/BufferedInputStream:close	()V
    //   33: aload 7
    //   35: areturn
    //   36: astore 9
    //   38: aload 8
    //   40: invokevirtual 58	java/io/BufferedInputStream:close	()V
    //   43: aload 9
    //   45: athrow
    //   46: astore 6
    //   48: new 60	java/lang/AssertionError
    //   51: dup
    //   52: aload 6
    //   54: invokespecial 63	java/lang/AssertionError:<init>	(Ljava/lang/Object;)V
    //   57: athrow
    //   58: astore 5
    //   60: new 60	java/lang/AssertionError
    //   63: dup
    //   64: aload 5
    //   66: invokespecial 63	java/lang/AssertionError:<init>	(Ljava/lang/Object;)V
    //   69: athrow
    //   70: astore 4
    //   72: new 60	java/lang/AssertionError
    //   75: dup
    //   76: aload 4
    //   78: invokespecial 63	java/lang/AssertionError:<init>	(Ljava/lang/Object;)V
    //   81: athrow
    //   82: astore_3
    //   83: new 60	java/lang/AssertionError
    //   86: dup
    //   87: aload_3
    //   88: invokespecial 63	java/lang/AssertionError:<init>	(Ljava/lang/Object;)V
    //   91: athrow
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	92	0	this	KO
    //   0	92	1	paramInputStream	InputStream
    //   0	92	2	paramString	String
    //   82	6	3	localIOException	java.io.IOException
    //   70	7	4	localCertificateException	java.security.cert.CertificateException
    //   58	7	5	localNoSuchAlgorithmException	java.security.NoSuchAlgorithmException
    //   46	7	6	localKeyStoreException	KeyStoreException
    //   5	29	7	localKeyStore	KeyStore
    //   15	24	8	localBufferedInputStream	java.io.BufferedInputStream
    //   36	8	9	localObject	Object
    // Exception table:
    //   from	to	target	type
    //   17	28	36	finally
    //   0	17	46	java/security/KeyStoreException
    //   28	46	46	java/security/KeyStoreException
    //   0	17	58	java/security/NoSuchAlgorithmException
    //   28	46	58	java/security/NoSuchAlgorithmException
    //   0	17	70	java/security/cert/CertificateException
    //   28	46	70	java/security/cert/CertificateException
    //   0	17	82	java/io/IOException
    //   28	46	82	java/io/IOException
  }
  
  private HashMap<Principal, X509Certificate> a(KeyStore paramKeyStore)
  {
    try
    {
      HashMap localHashMap = new HashMap();
      Enumeration localEnumeration = paramKeyStore.aliases();
      while (localEnumeration.hasMoreElements())
      {
        X509Certificate localX509Certificate = (X509Certificate)paramKeyStore.getCertificate((String)localEnumeration.nextElement());
        if (localX509Certificate != null) {
          localHashMap.put(localX509Certificate.getSubjectX500Principal(), localX509Certificate);
        }
      }
      return localHashMap;
    }
    catch (KeyStoreException localKeyStoreException)
    {
      throw new AssertionError(localKeyStoreException);
    }
  }
  
  public boolean a(X509Certificate paramX509Certificate)
  {
    X509Certificate localX509Certificate = (X509Certificate)this.b.get(paramX509Certificate.getSubjectX500Principal());
    if ((localX509Certificate != null) && (localX509Certificate.getPublicKey().equals(paramX509Certificate.getPublicKey()))) {}
    for (boolean bool = true;; bool = false) {
      return bool;
    }
  }
  
  public X509Certificate b(X509Certificate paramX509Certificate)
  {
    X509Certificate localX509Certificate = (X509Certificate)this.b.get(paramX509Certificate.getIssuerX500Principal());
    if (localX509Certificate == null) {
      localX509Certificate = null;
    }
    for (;;)
    {
      return localX509Certificate;
      if (localX509Certificate.getSubjectX500Principal().equals(paramX509Certificate.getSubjectX500Principal())) {
        localX509Certificate = null;
      } else {
        try
        {
          paramX509Certificate.verify(localX509Certificate.getPublicKey());
        }
        catch (GeneralSecurityException localGeneralSecurityException)
        {
          localX509Certificate = null;
        }
      }
    }
  }
}


/* Location:           C:\Users\dreadiscool\Desktop\tools\classes-dex2jar.jar
 * Qualified Name:     KO
 * JD-Core Version:    0.7.0.1
 */