import java.io.InputStream;
import java.io.OutputStream;
import java.net.HttpURLConnection;
import java.net.URL;
import java.security.Permission;
import java.security.Principal;
import java.security.cert.Certificate;
import java.util.List;
import java.util.Map;
import javax.net.ssl.HttpsURLConnection;

abstract class AM
  extends HttpsURLConnection
{
  private final HttpURLConnection a;
  
  public AM(HttpURLConnection paramHttpURLConnection)
  {
    super(paramHttpURLConnection.getURL());
    this.a = paramHttpURLConnection;
  }
  
  protected abstract zn a();
  
  public void addRequestProperty(String paramString1, String paramString2)
  {
    this.a.addRequestProperty(paramString1, paramString2);
  }
  
  public void connect()
  {
    this.connected = true;
    this.a.connect();
  }
  
  public void disconnect()
  {
    this.a.disconnect();
  }
  
  public boolean getAllowUserInteraction()
  {
    return this.a.getAllowUserInteraction();
  }
  
  public String getCipherSuite()
  {
    zn localzn = a();
    if (localzn != null) {}
    for (String str = localzn.a();; str = null) {
      return str;
    }
  }
  
  public int getConnectTimeout()
  {
    return this.a.getConnectTimeout();
  }
  
  public Object getContent()
  {
    return this.a.getContent();
  }
  
  public Object getContent(Class[] paramArrayOfClass)
  {
    return this.a.getContent(paramArrayOfClass);
  }
  
  public String getContentEncoding()
  {
    return this.a.getContentEncoding();
  }
  
  public int getContentLength()
  {
    return this.a.getContentLength();
  }
  
  public String getContentType()
  {
    return this.a.getContentType();
  }
  
  public long getDate()
  {
    return this.a.getDate();
  }
  
  public boolean getDefaultUseCaches()
  {
    return this.a.getDefaultUseCaches();
  }
  
  public boolean getDoInput()
  {
    return this.a.getDoInput();
  }
  
  public boolean getDoOutput()
  {
    return this.a.getDoOutput();
  }
  
  public InputStream getErrorStream()
  {
    return this.a.getErrorStream();
  }
  
  public long getExpiration()
  {
    return this.a.getExpiration();
  }
  
  public String getHeaderField(int paramInt)
  {
    return this.a.getHeaderField(paramInt);
  }
  
  public String getHeaderField(String paramString)
  {
    return this.a.getHeaderField(paramString);
  }
  
  public long getHeaderFieldDate(String paramString, long paramLong)
  {
    return this.a.getHeaderFieldDate(paramString, paramLong);
  }
  
  public int getHeaderFieldInt(String paramString, int paramInt)
  {
    return this.a.getHeaderFieldInt(paramString, paramInt);
  }
  
  public String getHeaderFieldKey(int paramInt)
  {
    return this.a.getHeaderFieldKey(paramInt);
  }
  
  public Map<String, List<String>> getHeaderFields()
  {
    return this.a.getHeaderFields();
  }
  
  public long getIfModifiedSince()
  {
    return this.a.getIfModifiedSince();
  }
  
  public InputStream getInputStream()
  {
    return this.a.getInputStream();
  }
  
  public boolean getInstanceFollowRedirects()
  {
    return this.a.getInstanceFollowRedirects();
  }
  
  public long getLastModified()
  {
    return this.a.getLastModified();
  }
  
  public Certificate[] getLocalCertificates()
  {
    Certificate[] arrayOfCertificate = null;
    zn localzn = a();
    if (localzn == null) {}
    for (;;)
    {
      return arrayOfCertificate;
      List localList = localzn.d();
      if (!localList.isEmpty()) {
        arrayOfCertificate = (Certificate[])localList.toArray(new Certificate[localList.size()]);
      }
    }
  }
  
  public Principal getLocalPrincipal()
  {
    zn localzn = a();
    if (localzn != null) {}
    for (Principal localPrincipal = localzn.e();; localPrincipal = null) {
      return localPrincipal;
    }
  }
  
  public OutputStream getOutputStream()
  {
    return this.a.getOutputStream();
  }
  
  public Principal getPeerPrincipal()
  {
    zn localzn = a();
    if (localzn != null) {}
    for (Principal localPrincipal = localzn.c();; localPrincipal = null) {
      return localPrincipal;
    }
  }
  
  public Permission getPermission()
  {
    return this.a.getPermission();
  }
  
  public int getReadTimeout()
  {
    return this.a.getReadTimeout();
  }
  
  public String getRequestMethod()
  {
    return this.a.getRequestMethod();
  }
  
  public Map<String, List<String>> getRequestProperties()
  {
    return this.a.getRequestProperties();
  }
  
  public String getRequestProperty(String paramString)
  {
    return this.a.getRequestProperty(paramString);
  }
  
  public int getResponseCode()
  {
    return this.a.getResponseCode();
  }
  
  public String getResponseMessage()
  {
    return this.a.getResponseMessage();
  }
  
  public Certificate[] getServerCertificates()
  {
    Certificate[] arrayOfCertificate = null;
    zn localzn = a();
    if (localzn == null) {}
    for (;;)
    {
      return arrayOfCertificate;
      List localList = localzn.b();
      if (!localList.isEmpty()) {
        arrayOfCertificate = (Certificate[])localList.toArray(new Certificate[localList.size()]);
      }
    }
  }
  
  public URL getURL()
  {
    return this.a.getURL();
  }
  
  public boolean getUseCaches()
  {
    return this.a.getUseCaches();
  }
  
  public void setAllowUserInteraction(boolean paramBoolean)
  {
    this.a.setAllowUserInteraction(paramBoolean);
  }
  
  public void setChunkedStreamingMode(int paramInt)
  {
    this.a.setChunkedStreamingMode(paramInt);
  }
  
  public void setConnectTimeout(int paramInt)
  {
    this.a.setConnectTimeout(paramInt);
  }
  
  public void setDefaultUseCaches(boolean paramBoolean)
  {
    this.a.setDefaultUseCaches(paramBoolean);
  }
  
  public void setDoInput(boolean paramBoolean)
  {
    this.a.setDoInput(paramBoolean);
  }
  
  public void setDoOutput(boolean paramBoolean)
  {
    this.a.setDoOutput(paramBoolean);
  }
  
  public void setFixedLengthStreamingMode(int paramInt)
  {
    this.a.setFixedLengthStreamingMode(paramInt);
  }
  
  public void setIfModifiedSince(long paramLong)
  {
    this.a.setIfModifiedSince(paramLong);
  }
  
  public void setInstanceFollowRedirects(boolean paramBoolean)
  {
    this.a.setInstanceFollowRedirects(paramBoolean);
  }
  
  public void setReadTimeout(int paramInt)
  {
    this.a.setReadTimeout(paramInt);
  }
  
  public void setRequestMethod(String paramString)
  {
    this.a.setRequestMethod(paramString);
  }
  
  public void setRequestProperty(String paramString1, String paramString2)
  {
    this.a.setRequestProperty(paramString1, paramString2);
  }
  
  public void setUseCaches(boolean paramBoolean)
  {
    this.a.setUseCaches(paramBoolean);
  }
  
  public String toString()
  {
    return this.a.toString();
  }
  
  public boolean usingProxy()
  {
    return this.a.usingProxy();
  }
}


/* Location:           C:\Users\dreadiscool\Desktop\tools\classes-dex2jar.jar
 * Qualified Name:     AM
 * JD-Core Version:    0.7.0.1
 */