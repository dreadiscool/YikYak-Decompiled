package com.squareup.picasso;

import android.content.Context;
import android.net.Uri;
import java.io.File;
import java.io.IOException;
import java.net.HttpURLConnection;
import java.net.URL;
import yL;
import zu;
import zw;

public class OkHttpDownloader
  implements Downloader
{
  static final String RESPONSE_SOURCE_ANDROID = "X-Android-Response-Source";
  static final String RESPONSE_SOURCE_OKHTTP = "OkHttp-Response-Source";
  private final zw urlFactory;
  
  public OkHttpDownloader(Context paramContext)
  {
    this(Utils.createDefaultCacheDir(paramContext));
  }
  
  public OkHttpDownloader(Context paramContext, long paramLong)
  {
    this(Utils.createDefaultCacheDir(paramContext), paramLong);
  }
  
  public OkHttpDownloader(File paramFile)
  {
    this(paramFile, Utils.calculateDiskCacheSize(paramFile));
  }
  
  public OkHttpDownloader(File paramFile, long paramLong)
  {
    this(new zu());
    try
    {
      this.urlFactory.a().a(new yL(paramFile, paramLong));
      label31:
      return;
    }
    catch (IOException localIOException)
    {
      break label31;
    }
  }
  
  public OkHttpDownloader(zu paramzu)
  {
    this.urlFactory = new zw(paramzu);
  }
  
  protected zu getClient()
  {
    return this.urlFactory.a();
  }
  
  public Downloader.Response load(Uri paramUri, boolean paramBoolean)
  {
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
    String str = localHttpURLConnection.getHeaderField("OkHttp-Response-Source");
    if (str == null) {
      str = localHttpURLConnection.getHeaderField("X-Android-Response-Source");
    }
    long l = localHttpURLConnection.getHeaderFieldInt("Content-Length", -1);
    boolean bool = Utils.parseResponseSourceHeader(str);
    return new Downloader.Response(localHttpURLConnection.getInputStream(), bool, l);
  }
  
  protected HttpURLConnection openConnection(Uri paramUri)
  {
    HttpURLConnection localHttpURLConnection = this.urlFactory.a(new URL(paramUri.toString()));
    localHttpURLConnection.setConnectTimeout(15000);
    localHttpURLConnection.setReadTimeout(20000);
    return localHttpURLConnection;
  }
}


/* Location:           C:\Users\dreadiscool\Desktop\tools\classes-dex2jar.jar
 * Qualified Name:     com.squareup.picasso.OkHttpDownloader
 * JD-Core Version:    0.7.0.1
 */