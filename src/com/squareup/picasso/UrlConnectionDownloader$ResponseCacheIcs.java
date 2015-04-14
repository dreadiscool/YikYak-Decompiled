package com.squareup.picasso;

import android.content.Context;
import android.net.http.HttpResponseCache;
import java.io.File;

class UrlConnectionDownloader$ResponseCacheIcs
{
  static Object install(Context paramContext)
  {
    File localFile = Utils.createDefaultCacheDir(paramContext);
    HttpResponseCache localHttpResponseCache = HttpResponseCache.getInstalled();
    if (localHttpResponseCache == null) {
      localHttpResponseCache = HttpResponseCache.install(localFile, Utils.calculateDiskCacheSize(localFile));
    }
    return localHttpResponseCache;
  }
}


/* Location:           C:\Users\dreadiscool\Desktop\tools\classes-dex2jar.jar
 * Qualified Name:     com.squareup.picasso.UrlConnectionDownloader.ResponseCacheIcs
 * JD-Core Version:    0.7.0.1
 */