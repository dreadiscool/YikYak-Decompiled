import java.io.IOException;
import java.security.cert.Certificate;
import java.security.cert.CertificateEncodingException;
import java.util.List;

final class yR
{
  private final String a;
  private final zo b;
  private final String c;
  private final zy d;
  private final int e;
  private final String f;
  private final zo g;
  private final zn h;
  
  public yR(LV paramLV)
  {
    LD localLD;
    try
    {
      localLD = LK.a(paramLV);
      this.a = localLD.q();
      this.c = localLD.q();
      zq localzq1 = new zq();
      int j = yL.a(localLD);
      for (int k = 0; k < j; k++) {
        localzq1.a(localLD.q());
      }
      this.b = localzq1.a();
      AK localAK = AK.a(localLD.q());
      this.d = localAK.a;
      this.e = localAK.b;
      this.f = localAK.c;
      zq localzq2 = new zq();
      int m = yL.a(localLD);
      while (i < m)
      {
        localzq2.a(localLD.q());
        i++;
      }
      this.g = localzq2.a();
      if (a())
      {
        String str = localLD.q();
        if (str.length() > 0) {
          throw new IOException("expected \"\" but was \"" + str + "\"");
        }
      }
    }
    finally
    {
      paramLV.close();
    }
    for (this.h = zn.a(localLD.q(), a(localLD), a(localLD));; this.h = null)
    {
      paramLV.close();
      return;
    }
  }
  
  public yR(zF paramzF)
  {
    this.a = paramzF.a().c();
    this.b = AD.c(paramzF);
    this.c = paramzF.a().d();
    this.d = paramzF.b();
    this.e = paramzF.c();
    this.f = paramzF.e();
    this.g = paramzF.g();
    this.h = paramzF.f();
  }
  
  /* Error */
  private List<Certificate> a(LD paramLD)
  {
    // Byte code:
    //   0: aload_1
    //   1: invokestatic 45	yL:a	(LLD;)I
    //   4: istore_2
    //   5: iload_2
    //   6: bipush 255
    //   8: if_icmpne +11 -> 19
    //   11: invokestatic 151	java/util/Collections:emptyList	()Ljava/util/List;
    //   14: astore 5
    //   16: aload 5
    //   18: areturn
    //   19: ldc 153
    //   21: invokestatic 159	java/security/cert/CertificateFactory:getInstance	(Ljava/lang/String;)Ljava/security/cert/CertificateFactory;
    //   24: astore 4
    //   26: new 161	java/util/ArrayList
    //   29: dup
    //   30: iload_2
    //   31: invokespecial 164	java/util/ArrayList:<init>	(I)V
    //   34: astore 5
    //   36: iconst_0
    //   37: istore 6
    //   39: iload 6
    //   41: iload_2
    //   42: if_icmpge -26 -> 16
    //   45: aload 5
    //   47: aload 4
    //   49: new 166	java/io/ByteArrayInputStream
    //   52: dup
    //   53: aload_1
    //   54: invokeinterface 33 1 0
    //   59: invokestatic 171	LE:b	(Ljava/lang/String;)LLE;
    //   62: invokevirtual 174	LE:f	()[B
    //   65: invokespecial 177	java/io/ByteArrayInputStream:<init>	([B)V
    //   68: invokevirtual 181	java/security/cert/CertificateFactory:generateCertificate	(Ljava/io/InputStream;)Ljava/security/cert/Certificate;
    //   71: invokeinterface 187 2 0
    //   76: pop
    //   77: iinc 6 1
    //   80: goto -41 -> 39
    //   83: astore_3
    //   84: new 82	java/io/IOException
    //   87: dup
    //   88: aload_3
    //   89: invokevirtual 190	java/security/cert/CertificateException:getMessage	()Ljava/lang/String;
    //   92: invokespecial 99	java/io/IOException:<init>	(Ljava/lang/String;)V
    //   95: athrow
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	96	0	this	yR
    //   0	96	1	paramLD	LD
    //   4	39	2	i	int
    //   83	6	3	localCertificateException	java.security.cert.CertificateException
    //   24	24	4	localCertificateFactory	java.security.cert.CertificateFactory
    //   14	32	5	localObject	Object
    //   37	41	6	j	int
    // Exception table:
    //   from	to	target	type
    //   19	77	83	java/security/cert/CertificateException
  }
  
  private void a(LC paramLC, List<Certificate> paramList)
  {
    try
    {
      paramLC.b(Integer.toString(paramList.size()));
      paramLC.g(10);
      int i = paramList.size();
      for (int j = 0; j < i; j++)
      {
        paramLC.b(LE.a(((Certificate)paramList.get(j)).getEncoded()).b());
        paramLC.g(10);
      }
      return;
    }
    catch (CertificateEncodingException localCertificateEncodingException)
    {
      throw new IOException(localCertificateEncodingException.getMessage());
    }
  }
  
  private boolean a()
  {
    return this.a.startsWith("https://");
  }
  
  public zF a(zz paramzz, zR paramzR)
  {
    String str1 = this.g.a("Content-Type");
    String str2 = this.g.a("Content-Length");
    zz localzz = new zB().a(this.a).a(this.c, null).a(this.b).b();
    return new zH().a(localzz).a(this.d).a(this.e).a(this.f).a(this.g).a(new yP(paramzR, str1, str2)).a(this.h).a();
  }
  
  public void a(zO paramzO)
  {
    int i = 0;
    LC localLC = LK.a(paramzO.a(0));
    localLC.b(this.a);
    localLC.g(10);
    localLC.b(this.c);
    localLC.g(10);
    localLC.b(Integer.toString(this.b.a()));
    localLC.g(10);
    int j = this.b.a();
    for (int k = 0; k < j; k++)
    {
      localLC.b(this.b.a(k));
      localLC.b(": ");
      localLC.b(this.b.b(k));
      localLC.g(10);
    }
    localLC.b(new AK(this.d, this.e, this.f).toString());
    localLC.g(10);
    localLC.b(Integer.toString(this.g.a()));
    localLC.g(10);
    int m = this.g.a();
    while (i < m)
    {
      localLC.b(this.g.a(i));
      localLC.b(": ");
      localLC.b(this.g.b(i));
      localLC.g(10);
      i++;
    }
    if (a())
    {
      localLC.g(10);
      localLC.b(this.h.a());
      localLC.g(10);
      a(localLC, this.h.b());
      a(localLC, this.h.d());
    }
    localLC.close();
  }
  
  public boolean a(zz paramzz, zF paramzF)
  {
    if ((this.a.equals(paramzz.c())) && (this.c.equals(paramzz.d())) && (AD.a(paramzF, this.b, paramzz))) {}
    for (boolean bool = true;; bool = false) {
      return bool;
    }
  }
}


/* Location:           C:\Users\dreadiscool\Desktop\tools\classes-dex2jar.jar
 * Qualified Name:     yR
 * JD-Core Version:    0.7.0.1
 */