package com.parse;

import android.content.Context;
import android.content.pm.PackageInfo;
import android.content.pm.PackageManager;
import android.content.pm.PackageManager.NameNotFoundException;
import android.net.SSLCertificateSocketFactory;
import android.net.SSLSessionCache;
import android.net.http.AndroidHttpClient;
import android.os.Build.VERSION;
import java.util.concurrent.BlockingQueue;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.LinkedBlockingQueue;
import java.util.concurrent.ThreadFactory;
import java.util.concurrent.ThreadPoolExecutor;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.atomic.AtomicReference;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import m;
import org.apache.http.HttpEntity;
import org.apache.http.HttpHost;
import org.apache.http.HttpRequest;
import org.apache.http.HttpResponse;
import org.apache.http.client.HttpClient;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.client.methods.HttpPost;
import org.apache.http.client.methods.HttpUriRequest;
import org.apache.http.client.params.HttpClientParams;
import org.apache.http.conn.params.ConnManagerParams;
import org.apache.http.conn.params.ConnPerRouteBean;
import org.apache.http.conn.scheme.PlainSocketFactory;
import org.apache.http.conn.scheme.Scheme;
import org.apache.http.conn.scheme.SchemeRegistry;
import org.apache.http.impl.client.DefaultHttpClient;
import org.apache.http.impl.conn.tsccm.ThreadSafeClientConnManager;
import org.apache.http.params.BasicHttpParams;
import org.apache.http.params.HttpConnectionParams;
import org.apache.http.params.HttpParams;
import org.apache.http.params.HttpProtocolParams;
import y;

abstract class ParseRequest<Response, Result>
{
  private static final int CORE_POOL_SIZE = 1 + 2 * CPU_COUNT;
  private static final int CPU_COUNT = 0;
  protected static final int DEFAULT_MAX_RETRIES = 4;
  private static final long KEEP_ALIVE_TIME = 1L;
  private static final int MAX_POOL_SIZE = 1 + 2 * (2 * CPU_COUNT);
  private static final int MAX_QUEUE_SIZE = 128;
  static final ExecutorService NETWORK_EXECUTOR = newThreadPoolExecutor(CORE_POOL_SIZE, MAX_POOL_SIZE, 1L, TimeUnit.SECONDS, new LinkedBlockingQueue(128), sThreadFactory);
  private static final int SOCKET_OPERATION_TIMEOUT = 10000;
  private static volatile String UserAgent;
  private static HttpClient defaultClient = null;
  private static long defaultInitialRetryDelay = 1000L;
  private static final ThreadFactory sThreadFactory = new ParseRequest.1();
  private HttpClient client = defaultClient;
  private AtomicReference<m<Result>.y> currentTask = new AtomicReference();
  protected int maxRetries = 4;
  protected int method;
  private HttpUriRequest request;
  protected String url;
  
  static
  {
    CPU_COUNT = Runtime.getRuntime().availableProcessors();
  }
  
  public ParseRequest(int paramInt, String paramString)
  {
    this.method = paramInt;
    this.url = paramString;
  }
  
  public ParseRequest(String paramString)
  {
    this(0, paramString);
  }
  
  private m<Response> executeAsync(int paramInt, long paramLong, ProgressCallback paramProgressCallback)
  {
    return sendOneRequestAsync(paramProgressCallback).b(new ParseRequest.8(this, paramInt, paramLong, paramProgressCallback));
  }
  
  public static HttpClient getDefaultClient()
  {
    if (defaultClient == null) {
      throw new IllegalStateException("Can't send Parse HTTPS request before Parse.initialize()");
    }
    return defaultClient;
  }
  
  public static long getDefaultInitialRetryDelay()
  {
    return defaultInitialRetryDelay;
  }
  
  private static String getUserAgent(Context paramContext)
  {
    Object localObject;
    if (UserAgent == null) {
      localObject = "unknown";
    }
    try
    {
      String str1 = paramContext.getPackageName();
      int i = paramContext.getPackageManager().getPackageInfo(str1, 0).versionCode;
      String str2 = str1 + "/" + i;
      localObject = str2;
    }
    catch (PackageManager.NameNotFoundException localNameNotFoundException)
    {
      label57:
      break label57;
    }
    UserAgent = "Parse Android SDK 1.7.1 (" + (String)localObject + ") API Level " + Build.VERSION.SDK_INT;
    return UserAgent;
  }
  
  public static void initialize(Context paramContext)
  {
    if (defaultClient == null) {
      defaultClient = newHttpClient(paramContext);
    }
  }
  
  private static HttpClient newHttpClient(Context paramContext)
  {
    if (paramContext == null) {
      throw new IllegalArgumentException("Context passed to newHttpClient should not be null.");
    }
    Context localContext = paramContext.getApplicationContext();
    BasicHttpParams localBasicHttpParams = new BasicHttpParams();
    HttpConnectionParams.setStaleCheckingEnabled(localBasicHttpParams, false);
    HttpConnectionParams.setConnectionTimeout(localBasicHttpParams, 10000);
    HttpConnectionParams.setSoTimeout(localBasicHttpParams, 10000);
    HttpConnectionParams.setSocketBufferSize(localBasicHttpParams, 8192);
    HttpClientParams.setRedirecting(localBasicHttpParams, false);
    SSLSessionCache localSSLSessionCache = new SSLSessionCache(localContext);
    HttpProtocolParams.setUserAgent(localBasicHttpParams, getUserAgent(localContext));
    SchemeRegistry localSchemeRegistry = new SchemeRegistry();
    localSchemeRegistry.register(new Scheme("http", PlainSocketFactory.getSocketFactory(), 80));
    localSchemeRegistry.register(new Scheme("https", SSLCertificateSocketFactory.getHttpSocketFactory(10000, localSSLSessionCache), 443));
    ConnManagerParams.setMaxConnectionsPerRoute(localBasicHttpParams, new ConnPerRouteBean(20));
    ConnManagerParams.setMaxTotalConnections(localBasicHttpParams, 20);
    String str1 = System.getProperty("http.proxyHost");
    String str2 = System.getProperty("http.proxyPort");
    if ((str1 != null) && (str1.length() != 0) && (str2 != null) && (str2.length() != 0)) {
      localBasicHttpParams.setParameter("http.route.default-proxy", new HttpHost(str1, Integer.parseInt(str2), "http"));
    }
    return new DefaultHttpClient(new ThreadSafeClientConnManager(localBasicHttpParams, localSchemeRegistry), localBasicHttpParams);
  }
  
  private static ThreadPoolExecutor newThreadPoolExecutor(int paramInt1, int paramInt2, long paramLong, TimeUnit paramTimeUnit, BlockingQueue<Runnable> paramBlockingQueue, ThreadFactory paramThreadFactory)
  {
    ThreadPoolExecutor localThreadPoolExecutor = new ThreadPoolExecutor(paramInt1, paramInt2, paramLong, paramTimeUnit, paramBlockingQueue, paramThreadFactory);
    if (Build.VERSION.SDK_INT >= 9) {
      localThreadPoolExecutor.allowCoreThreadTimeOut(true);
    }
    return localThreadPoolExecutor;
  }
  
  private m<Response> sendOneRequestAsync(ProgressCallback paramProgressCallback)
  {
    if (((y)this.currentTask.get()).a().c()) {}
    for (m localm = m.h();; localm = m.a(new ParseRequest.3(this, paramProgressCallback), NETWORK_EXECUTOR).b(new ParseRequest.2(this), m.a)) {
      return localm;
    }
  }
  
  public static void setDefaultClient(HttpClient paramHttpClient)
  {
    defaultClient = paramHttpClient;
  }
  
  public static void setDefaultInitialRetryDelay(long paramLong)
  {
    defaultInitialRetryDelay = paramLong;
  }
  
  public void cancel()
  {
    y localy = (y)this.currentTask.get();
    if (localy != null) {
      localy.b();
    }
    if (this.request != null) {
      this.request.abort();
    }
  }
  
  protected ParseException connectionFailed(String paramString, Exception paramException)
  {
    return new ParseException(100, paramString + ": " + paramException.getClass().getName() + ": " + paramException.getMessage());
  }
  
  public m<Result> executeAsync()
  {
    return executeAsync(null);
  }
  
  public m<Result> executeAsync(ProgressCallback paramProgressCallback)
  {
    y localy = m.a();
    this.currentTask.set(localy);
    m.a(null).b(new ParseRequest.7(this)).d(new ParseRequest.6(this, paramProgressCallback)).d(new ParseRequest.5(this)).b(new ParseRequest.4(this, localy));
    return localy.a();
  }
  
  protected HttpEntity newEntity()
  {
    return null;
  }
  
  protected HttpUriRequest newRequest()
  {
    if (this.method == 0) {}
    HttpPost localHttpPost;
    for (Object localObject = new HttpGet(this.url);; localObject = localHttpPost)
    {
      AndroidHttpClient.modifyRequestToAcceptGzipResponse((HttpRequest)localObject);
      return localObject;
      if (this.method != 1) {
        break;
      }
      String str = null;
      if (this.url.contains(".s3.amazonaws.com"))
      {
        Matcher localMatcher = Pattern.compile("^https://([a-zA-Z0-9.]*\\.s3\\.amazonaws\\.com)/?.*").matcher(this.url);
        if (localMatcher.matches())
        {
          str = localMatcher.group(1);
          this.url = this.url.replace(str, "s3.amazonaws.com");
        }
      }
      localHttpPost = new HttpPost(this.url);
      localHttpPost.setEntity(newEntity());
      if (str != null) {
        localHttpPost.addHeader("Host", str);
      }
    }
    throw new IllegalStateException("Invalid method " + this.method);
  }
  
  protected m<Result> onPostExecute(m<Response> paramm)
  {
    return paramm.i();
  }
  
  protected m<Void> onPreExecute(m<Void> paramm)
  {
    return null;
  }
  
  protected abstract Response onResponse(HttpResponse paramHttpResponse, ProgressCallback paramProgressCallback);
  
  public void setClient(HttpClient paramHttpClient)
  {
    this.client = paramHttpClient;
  }
  
  public void setMaxRetries(int paramInt)
  {
    this.maxRetries = paramInt;
  }
  
  public void setMethod(int paramInt)
  {
    this.method = paramInt;
  }
  
  public void setUrl(String paramString)
  {
    this.url = paramString;
  }
}


/* Location:           C:\Users\dreadiscool\Desktop\tools\classes-dex2jar.jar
 * Qualified Name:     com.parse.ParseRequest
 * JD-Core Version:    0.7.0.1
 */