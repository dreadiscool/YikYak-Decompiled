import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.net.HttpRetryException;
import java.net.HttpURLConnection;
import java.net.InetSocketAddress;
import java.net.ProtocolException;
import java.net.Proxy;
import java.net.Proxy.Type;
import java.net.SocketPermission;
import java.net.URL;
import java.security.Permission;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.Date;
import java.util.LinkedHashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.concurrent.TimeUnit;

public class AN
  extends HttpURLConnection
{
  private static final Set<String> e;
  final zu a;
  protected IOException b;
  protected Ax c;
  zn d;
  private zq f = new zq();
  private long g = -1L;
  private int h;
  private zo i;
  private zJ j;
  
  static
  {
    String[] arrayOfString = new String[8];
    arrayOfString[0] = "OPTIONS";
    arrayOfString[1] = "GET";
    arrayOfString[2] = "HEAD";
    arrayOfString[3] = "POST";
    arrayOfString[4] = "PUT";
    arrayOfString[5] = "DELETE";
    arrayOfString[6] = "TRACE";
    arrayOfString[7] = "PATCH";
    e = new LinkedHashSet(Arrays.asList(arrayOfString));
  }
  
  public AN(URL paramURL, zu paramzu)
  {
    super(paramURL);
    this.a = paramzu;
  }
  
  private Ax a(String paramString, zf paramzf, AH paramAH, zF paramzF)
  {
    zB localzB = new zB().a(getURL()).a(paramString, null);
    zo localzo = this.f.a();
    int k = 0;
    int m = localzo.a();
    while (k < m)
    {
      localzB.b(localzo.a(k), localzo.b(k));
      k++;
    }
    boolean bool1 = false;
    if (AB.c(paramString))
    {
      if (this.g == -1L) {
        break label220;
      }
      localzB.a("Content-Length", Long.toString(this.g));
    }
    for (;;)
    {
      if (localzo.a("Content-Type") == null) {
        localzB.a("Content-Type", "application/x-www-form-urlencoded");
      }
      boolean bool2 = bool1;
      if (localzo.a("User-Agent") == null) {
        localzB.a("User-Agent", c());
      }
      zz localzz = localzB.b();
      zu localzu = this.a;
      if ((zS.b.a(localzu) != null) && (!getUseCaches())) {
        localzu = this.a.x().a(null);
      }
      return new Ax(localzu, localzz, bool2, true, false, paramzf, null, paramAH, paramzF);
      label220:
      if (this.chunkLength > 0) {
        localzB.a("Transfer-Encoding", "chunked");
      } else {
        bool1 = true;
      }
    }
  }
  
  private static String a(zF paramzF)
  {
    String str;
    if (paramzF.j() == null) {
      if (paramzF.k() == null) {
        str = "NONE";
      }
    }
    for (;;)
    {
      return str;
      str = "CACHE " + paramzF.c();
      continue;
      if (paramzF.k() == null) {
        str = "NETWORK " + paramzF.c();
      } else {
        str = "CONDITIONAL_CACHE " + paramzF.j().c();
      }
    }
  }
  
  private zo a()
  {
    if (this.i == null)
    {
      zF localzF = d().h();
      this.i = localzF.g().b().a(zY.a().b() + "-Response-Source", a(localzF)).a();
    }
    return this.i;
  }
  
  private void a(String paramString, boolean paramBoolean)
  {
    ArrayList localArrayList = new ArrayList();
    if (paramBoolean) {
      localArrayList.addAll(this.a.s());
    }
    String[] arrayOfString = paramString.split(",", -1);
    int k = arrayOfString.length;
    int m = 0;
    while (m < k)
    {
      String str = arrayOfString[m];
      try
      {
        localArrayList.add(zy.a(str));
        m++;
      }
      catch (IOException localIOException)
      {
        throw new IllegalStateException(localIOException);
      }
    }
    this.a.a(localArrayList);
  }
  
  private boolean a(boolean paramBoolean)
  {
    for (;;)
    {
      try
      {
        this.c.a();
        this.j = this.c.j();
        if (this.c.i() == null) {
          continue;
        }
        localzn = this.c.i().j();
        this.d = localzn;
        if (paramBoolean) {
          this.c.n();
        }
        bool = true;
      }
      catch (IOException localIOException)
      {
        zn localzn;
        Ax localAx = this.c.a(localIOException);
        if (localAx == null) {
          continue;
        }
        this.c = localAx;
        boolean bool = false;
        continue;
        this.b = localIOException;
        throw localIOException;
      }
      return bool;
      localzn = null;
    }
  }
  
  private void b()
  {
    if (this.b != null) {
      throw this.b;
    }
    if (this.c != null) {
      return;
    }
    this.connected = true;
    do
    {
      try
      {
        if (this.doOutput)
        {
          if (this.method.equals("GET")) {
            this.method = "POST";
          }
        }
        else {
          this.c = a(this.method, null, null, null);
        }
      }
      catch (IOException localIOException)
      {
        this.b = localIOException;
        throw localIOException;
      }
    } while (AB.c(this.method));
    throw new ProtocolException(this.method + " does not support writing");
  }
  
  private String c()
  {
    String str = System.getProperty("http.agent");
    if (str != null) {}
    for (;;)
    {
      return str;
      str = "Java" + System.getProperty("java.version");
    }
  }
  
  private Ax d()
  {
    b();
    Ax localAx;
    if (this.c.f())
    {
      localAx = this.c;
      return localAx;
    }
    for (;;)
    {
      if (a(true))
      {
        zF localzF = this.c.h();
        zz localzz = this.c.o();
        if (localzz == null)
        {
          this.c.k();
          localAx = this.c;
          break;
        }
        int k = 1 + this.h;
        this.h = k;
        if (k > 20) {
          throw new ProtocolException("Too many follow-up requests: " + this.h);
        }
        this.url = localzz.a();
        this.f = localzz.e().b();
        LU localLU = this.c.d();
        if (!localzz.d().equals(this.method)) {
          localLU = null;
        }
        if ((localLU != null) && (!(localLU instanceof AH))) {
          throw new HttpRetryException("Cannot retry streamed HTTP body", this.responseCode);
        }
        if (!this.c.b(localzz.a())) {
          this.c.k();
        }
        zf localzf = this.c.m();
        this.c = a(localzz.d(), localzf, (AH)localLU, localzF);
      }
    }
  }
  
  public final void addRequestProperty(String paramString1, String paramString2)
  {
    if (this.connected) {
      throw new IllegalStateException("Cannot add request property after connection is made");
    }
    if (paramString1 == null) {
      throw new NullPointerException("field == null");
    }
    if (paramString2 == null) {
      zY.a().a("Ignoring header " + paramString1 + " because its value was null.");
    }
    for (;;)
    {
      return;
      if (("X-Android-Transports".equals(paramString1)) || ("X-Android-Protocols".equals(paramString1))) {
        a(paramString2, true);
      } else {
        this.f.a(paramString1, paramString2);
      }
    }
  }
  
  public final void connect()
  {
    b();
    while (!a(false)) {}
  }
  
  public final void disconnect()
  {
    if (this.c == null) {}
    for (;;)
    {
      return;
      this.c.l();
    }
  }
  
  public int getConnectTimeout()
  {
    return this.a.a();
  }
  
  public final InputStream getErrorStream()
  {
    Object localObject = null;
    try
    {
      Ax localAx = d();
      if ((Ax.a(localAx.h())) && (localAx.h().c() >= 400))
      {
        InputStream localInputStream = localAx.h().h().d();
        localObject = localInputStream;
      }
    }
    catch (IOException localIOException)
    {
      label45:
      break label45;
    }
    return localObject;
  }
  
  public final String getHeaderField(int paramInt)
  {
    try
    {
      String str2 = a().b(paramInt);
      str1 = str2;
    }
    catch (IOException localIOException)
    {
      for (;;)
      {
        String str1 = null;
      }
    }
    return str1;
  }
  
  public final String getHeaderField(String paramString)
  {
    if (paramString == null) {}
    try
    {
      localObject = AK.a(d().h()).toString();
    }
    catch (IOException localIOException)
    {
      String str;
      localObject = null;
    }
    str = a().a(paramString);
    Object localObject = str;
    return localObject;
  }
  
  public final String getHeaderFieldKey(int paramInt)
  {
    try
    {
      String str2 = a().a(paramInt);
      str1 = str2;
    }
    catch (IOException localIOException)
    {
      for (;;)
      {
        String str1 = null;
      }
    }
    return str1;
  }
  
  public final Map<String, List<String>> getHeaderFields()
  {
    try
    {
      Map localMap2 = AD.a(a(), AK.a(d().h()).toString());
      localMap1 = localMap2;
    }
    catch (IOException localIOException)
    {
      for (;;)
      {
        Map localMap1 = Collections.emptyMap();
      }
    }
    return localMap1;
  }
  
  public final InputStream getInputStream()
  {
    if (!this.doInput) {
      throw new ProtocolException("This protocol does not support input");
    }
    Ax localAx = d();
    if (getResponseCode() >= 400) {
      throw new FileNotFoundException(this.url.toString());
    }
    return localAx.h().h().d();
  }
  
  public final OutputStream getOutputStream()
  {
    connect();
    LC localLC = this.c.e();
    if (localLC == null) {
      throw new ProtocolException("method does not support a request body: " + this.method);
    }
    if (this.c.f()) {
      throw new ProtocolException("cannot write request body after response has been read");
    }
    return localLC.e();
  }
  
  public final Permission getPermission()
  {
    String str = getURL().getHost();
    int k = Ae.a(getURL());
    if (usingProxy())
    {
      InetSocketAddress localInetSocketAddress = (InetSocketAddress)this.a.d().address();
      str = localInetSocketAddress.getHostName();
      k = localInetSocketAddress.getPort();
    }
    return new SocketPermission(str + ":" + k, "connect, resolve");
  }
  
  public int getReadTimeout()
  {
    return this.a.b();
  }
  
  public final Map<String, List<String>> getRequestProperties()
  {
    if (this.connected) {
      throw new IllegalStateException("Cannot access request header fields after connection is set");
    }
    return AD.a(this.f.a(), null);
  }
  
  public final String getRequestProperty(String paramString)
  {
    if (paramString == null) {}
    for (String str = null;; str = this.f.c(paramString)) {
      return str;
    }
  }
  
  public final int getResponseCode()
  {
    return d().h().c();
  }
  
  public String getResponseMessage()
  {
    return d().h().e();
  }
  
  public void setConnectTimeout(int paramInt)
  {
    this.a.a(paramInt, TimeUnit.MILLISECONDS);
  }
  
  public void setFixedLengthStreamingMode(int paramInt)
  {
    setFixedLengthStreamingMode(paramInt);
  }
  
  public void setFixedLengthStreamingMode(long paramLong)
  {
    if (this.connected) {
      throw new IllegalStateException("Already connected");
    }
    if (this.chunkLength > 0) {
      throw new IllegalStateException("Already in chunked mode");
    }
    if (paramLong < 0L) {
      throw new IllegalArgumentException("contentLength < 0");
    }
    this.g = paramLong;
    this.fixedContentLength = ((int)Math.min(paramLong, 2147483647L));
  }
  
  public void setIfModifiedSince(long paramLong)
  {
    super.setIfModifiedSince(paramLong);
    if (this.ifModifiedSince != 0L) {
      this.f.b("If-Modified-Since", Av.a(new Date(this.ifModifiedSince)));
    }
    for (;;)
    {
      return;
      this.f.b("If-Modified-Since");
    }
  }
  
  public void setInstanceFollowRedirects(boolean paramBoolean)
  {
    this.a.a(paramBoolean);
  }
  
  public void setReadTimeout(int paramInt)
  {
    this.a.b(paramInt, TimeUnit.MILLISECONDS);
  }
  
  public void setRequestMethod(String paramString)
  {
    if (!e.contains(paramString)) {
      throw new ProtocolException("Expected one of " + e + " but was " + paramString);
    }
    this.method = paramString;
  }
  
  public final void setRequestProperty(String paramString1, String paramString2)
  {
    if (this.connected) {
      throw new IllegalStateException("Cannot set request property after connection is made");
    }
    if (paramString1 == null) {
      throw new NullPointerException("field == null");
    }
    if (paramString2 == null) {
      zY.a().a("Ignoring header " + paramString1 + " because its value was null.");
    }
    for (;;)
    {
      return;
      if (("X-Android-Transports".equals(paramString1)) || ("X-Android-Protocols".equals(paramString1))) {
        a(paramString2, false);
      } else {
        this.f.b(paramString1, paramString2);
      }
    }
  }
  
  public final boolean usingProxy()
  {
    Proxy localProxy;
    if (this.j != null)
    {
      localProxy = this.j.b();
      if ((localProxy == null) || (localProxy.type() == Proxy.Type.DIRECT)) {
        break label44;
      }
    }
    label44:
    for (boolean bool = true;; bool = false)
    {
      return bool;
      localProxy = this.a.d();
      break;
    }
  }
}


/* Location:           C:\Users\dreadiscool\Desktop\tools\classes-dex2jar.jar
 * Qualified Name:     AN
 * JD-Core Version:    0.7.0.1
 */