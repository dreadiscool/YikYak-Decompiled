import java.net.URL;
import javax.net.ssl.HostnameVerifier;
import javax.net.ssl.SSLSocketFactory;

public final class AO
  extends AM
{
  private final AN a;
  
  public AO(AN paramAN)
  {
    super(paramAN);
    this.a = paramAN;
  }
  
  public AO(URL paramURL, zu paramzu)
  {
    this(new AN(paramURL, paramzu));
  }
  
  protected zn a()
  {
    if (this.a.c == null) {
      throw new IllegalStateException("Connection has not yet been established");
    }
    if (this.a.c.f()) {}
    for (zn localzn = this.a.c.h().f();; localzn = this.a.d) {
      return localzn;
    }
  }
  
  public HostnameVerifier getHostnameVerifier()
  {
    return this.a.a.j();
  }
  
  public SSLSocketFactory getSSLSocketFactory()
  {
    return this.a.a.i();
  }
  
  public void setFixedLengthStreamingMode(long paramLong)
  {
    this.a.setFixedLengthStreamingMode(paramLong);
  }
  
  public void setHostnameVerifier(HostnameVerifier paramHostnameVerifier)
  {
    this.a.a.a(paramHostnameVerifier);
  }
  
  public void setSSLSocketFactory(SSLSocketFactory paramSSLSocketFactory)
  {
    this.a.a.a(paramSSLSocketFactory);
  }
}


/* Location:           C:\Users\dreadiscool\Desktop\tools\classes-dex2jar.jar
 * Qualified Name:     AO
 * JD-Core Version:    0.7.0.1
 */