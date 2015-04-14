import java.util.Arrays;
import java.util.List;
import javax.net.ssl.SSLSocket;

public final class zi
{
  public static final zi a;
  public static final zi b;
  public static final zi c = new zk(false, null).a();
  final boolean d;
  final boolean e;
  private final String[] f;
  private final String[] g;
  private zi h;
  
  static
  {
    zk localzk1 = new zk(true, null);
    ze[] arrayOfze = new ze[18];
    arrayOfze[0] = ze.aK;
    arrayOfze[1] = ze.aO;
    arrayOfze[2] = ze.W;
    arrayOfze[3] = ze.am;
    arrayOfze[4] = ze.al;
    arrayOfze[5] = ze.av;
    arrayOfze[6] = ze.aw;
    arrayOfze[7] = ze.aj;
    arrayOfze[8] = ze.at;
    arrayOfze[9] = ze.F;
    arrayOfze[10] = ze.E;
    arrayOfze[11] = ze.J;
    arrayOfze[12] = ze.U;
    arrayOfze[13] = ze.D;
    arrayOfze[14] = ze.H;
    arrayOfze[15] = ze.h;
    arrayOfze[16] = ze.e;
    arrayOfze[17] = ze.d;
    zk localzk2 = localzk1.a(arrayOfze);
    zK[] arrayOfzK1 = new zK[3];
    arrayOfzK1[0] = zK.a;
    arrayOfzK1[1] = zK.b;
    arrayOfzK1[2] = zK.c;
    a = localzk2.a(arrayOfzK1).a(true).a();
    zk localzk3 = new zk(a);
    zK[] arrayOfzK2 = new zK[1];
    arrayOfzK2[0] = zK.c;
    b = localzk3.a(arrayOfzK2).a();
  }
  
  private zi(zk paramzk)
  {
    this.d = zk.a(paramzk);
    this.f = zk.b(paramzk);
    this.g = zk.c(paramzk);
    this.e = zk.d(paramzk);
  }
  
  private zi a(SSLSocket paramSSLSocket)
  {
    List localList1 = Ae.a(this.f, paramSSLSocket.getSupportedCipherSuites());
    List localList2 = Ae.a(this.g, paramSSLSocket.getSupportedProtocols());
    return new zk(this).a((String[])localList1.toArray(new String[localList1.size()])).b((String[])localList2.toArray(new String[localList2.size()])).a();
  }
  
  void a(SSLSocket paramSSLSocket, zJ paramzJ)
  {
    zi localzi = this.h;
    if (localzi == null)
    {
      localzi = a(paramSSLSocket);
      this.h = localzi;
    }
    paramSSLSocket.setEnabledProtocols(localzi.g);
    String[] arrayOfString1 = localzi.f;
    String[] arrayOfString2;
    if ((paramzJ.e) && (Arrays.asList(paramSSLSocket.getSupportedCipherSuites()).contains("TLS_FALLBACK_SCSV")))
    {
      arrayOfString2 = new String[1 + arrayOfString1.length];
      System.arraycopy(arrayOfString1, 0, arrayOfString2, 0, arrayOfString1.length);
      arrayOfString2[(-1 + arrayOfString2.length)] = "TLS_FALLBACK_SCSV";
    }
    for (;;)
    {
      paramSSLSocket.setEnabledCipherSuites(arrayOfString2);
      zY localzY = zY.a();
      if (localzi.e) {
        localzY.a(paramSSLSocket, paramzJ.a.b, paramzJ.a.i);
      }
      return;
      arrayOfString2 = arrayOfString1;
    }
  }
  
  public boolean a()
  {
    return this.d;
  }
  
  public List<ze> b()
  {
    ze[] arrayOfze = new ze[this.f.length];
    for (int i = 0; i < this.f.length; i++) {
      arrayOfze[i] = ze.b(this.f[i]);
    }
    return Ae.a(arrayOfze);
  }
  
  public List<zK> c()
  {
    zK[] arrayOfzK = new zK[this.g.length];
    for (int i = 0; i < this.g.length; i++) {
      arrayOfzK[i] = zK.a(this.g[i]);
    }
    return Ae.a(arrayOfzK);
  }
  
  public boolean d()
  {
    return this.e;
  }
  
  public boolean equals(Object paramObject)
  {
    boolean bool = false;
    if (!(paramObject instanceof zi)) {}
    for (;;)
    {
      return bool;
      zi localzi = (zi)paramObject;
      if ((this.d == localzi.d) && ((!this.d) || ((Arrays.equals(this.f, localzi.f)) && (Arrays.equals(this.g, localzi.g)) && (this.e == localzi.e)))) {
        bool = true;
      }
    }
  }
  
  public int hashCode()
  {
    int i = 17;
    int j;
    if (this.d)
    {
      j = 31 * (31 * (527 + Arrays.hashCode(this.f)) + Arrays.hashCode(this.g));
      if (!this.e) {
        break label51;
      }
    }
    label51:
    for (int k = 0;; k = 1)
    {
      i = k + j;
      return i;
    }
  }
  
  public String toString()
  {
    if (this.d) {}
    for (String str = "ConnectionSpec(cipherSuites=" + b() + ", tlsVersions=" + c() + ", supportsTlsExtensions=" + this.e + ")";; str = "ConnectionSpec()") {
      return str;
    }
  }
}


/* Location:           C:\Users\dreadiscool\Desktop\tools\classes-dex2jar.jar
 * Qualified Name:     zi
 * JD-Core Version:    0.7.0.1
 */