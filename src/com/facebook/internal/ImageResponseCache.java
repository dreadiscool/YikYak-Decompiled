package com.facebook.internal;

import android.content.Context;
import com.facebook.LoggingBehavior;
import java.io.IOException;
import java.io.InputStream;
import java.net.HttpURLConnection;
import java.net.URI;
import java.net.URISyntaxException;
import java.net.URL;

class ImageResponseCache
{
  static final String TAG = ImageResponseCache.class.getSimpleName();
  private static volatile FileLruCache imageCache;
  
  static void clearCache(Context paramContext)
  {
    try
    {
      getCache(paramContext).clearCache();
      return;
    }
    catch (IOException localIOException)
    {
      for (;;)
      {
        Logger.log(LoggingBehavior.CACHE, 5, TAG, "clearCache failed " + localIOException.getMessage());
      }
    }
  }
  
  static FileLruCache getCache(Context paramContext)
  {
    try
    {
      if (imageCache == null) {
        imageCache = new FileLruCache(paramContext.getApplicationContext(), TAG, new FileLruCache.Limits());
      }
      FileLruCache localFileLruCache = imageCache;
      return localFileLruCache;
    }
    finally
    {
      localObject = finally;
      throw localObject;
    }
  }
  
  static InputStream getCachedImageStream(URI paramURI, Context paramContext)
  {
    Object localObject = null;
    if ((paramURI != null) && (isCDNURL(paramURI))) {}
    try
    {
      InputStream localInputStream = getCache(paramContext).get(paramURI.toString());
      localObject = localInputStream;
    }
    catch (IOException localIOException)
    {
      for (;;)
      {
        Logger.log(LoggingBehavior.CACHE, 5, TAG, localIOException.toString());
      }
    }
    return localObject;
  }
  
  static InputStream interceptAndCacheImageStream(Context paramContext, HttpURLConnection paramHttpURLConnection)
  {
    Object localObject = null;
    URL localURL;
    if (paramHttpURLConnection.getResponseCode() == 200)
    {
      localURL = paramHttpURLConnection.getURL();
      localObject = paramHttpURLConnection.getInputStream();
    }
    try
    {
      if (isCDNURL(localURL.toURI()))
      {
        InputStream localInputStream = getCache(paramContext).interceptAndPut(localURL.toString(), new ImageResponseCache.BufferedHttpInputStream((InputStream)localObject, paramHttpURLConnection));
        localObject = localInputStream;
      }
    }
    catch (URISyntaxException localURISyntaxException)
    {
      break label57;
    }
    catch (IOException localIOException)
    {
      label57:
      break label57;
    }
    return localObject;
  }
  
  private static boolean isCDNURL(URI paramURI)
  {
    boolean bool = true;
    String str;
    if (paramURI != null)
    {
      str = paramURI.getHost();
      if (!str.endsWith("fbcdn.net")) {}
    }
    for (;;)
    {
      return bool;
      if ((!str.startsWith("fbcdn")) || (!str.endsWith("akamaihd.net"))) {
        bool = false;
      }
    }
  }
}


/* Location:           C:\Users\dreadiscool\Desktop\tools\classes-dex2jar.jar
 * Qualified Name:     com.facebook.internal.ImageResponseCache
 * JD-Core Version:    0.7.0.1
 */