package com.squareup.picasso;

import android.content.Context;
import android.net.Uri;
import android.os.Build.VERSION;
import java.io.IOException;
import java.net.HttpURLConnection;
import java.net.URL;

public class UrlConnectionDownloader
  implements Downloader
{
  static final String RESPONSE_SOURCE = "X-Android-Response-Source";
  static volatile Object cache;
  private static final Object lock = new Object();
  private final Context context;
  
  public UrlConnectionDownloader(Context paramContext)
  {
    this.context = paramContext.getApplicationContext();
  }
  
  private static void installCacheIfNeeded(Context paramContext)
  {
    if (cache == null) {
      try
      {
        synchronized (lock)
        {
          if (cache == null) {
            cache = UrlConnectionDownloader.ResponseCacheIcs.install(paramContext);
          }
        }
        return;
      }
      catch (IOException localIOException) {}
    }
  }
  
  public Downloader.Response load(Uri paramUri, boolean paramBoolean)
  {
    if (Build.VERSION.SDK_INT >= 14) {
      installCacheIfNeeded(this.context);
    }
    HttpURLConnection localHttpURLConnection = openConnection(paramUri);
    localHttpURLConnection.setUseCaches(true);
    if (paramBoolean) {
      localHttpURLConnection.setRequestProperty("Cache-Control", "only-if-cached,max-age=2147483647");
    }
    int i = localHttpURLConnection.getResponseCode();
    if (i >= 300)
    {
      localHttpURLConnection.disconnect();
      throw new Downloader.ResponseException(i + " " + localHttpURLConnection.getResponseMessage());
    }
    long l = localHttpURLConnection.getHeaderFieldInt("Content-Length", -1);
    boolean bool = Utils.parseResponseSourceHeader(localHttpURLConnection.getHeaderField("X-Android-Response-Source"));
    return new Downloader.Response(localHttpURLConnection.getInputStream(), bool, l);
  }
  
  protected HttpURLConnection openConnection(Uri paramUri)
  {
    HttpURLConnection localHttpURLConnection = (HttpURLConnection)new URL(paramUri.toString()).openConnection();
    localHttpURLConnection.setConnectTimeout(15000);
    localHttpURLConnection.setReadTimeout(20000);
    return localHttpURLConnection;
  }
}


/* Location:           C:\Users\dreadiscool\Desktop\tools\classes-dex2jar.jar
 * Qualified Name:     com.squareup.picasso.UrlConnectionDownloader
 * JD-Core Version:    0.7.0.1
 */