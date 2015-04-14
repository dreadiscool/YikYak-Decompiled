package com.facebook.internal;

import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.os.Handler;
import android.os.Looper;
import java.io.InputStream;
import java.net.URI;
import java.util.HashMap;
import java.util.Map;

public class ImageDownloader
{
  private static final int CACHE_READ_QUEUE_MAX_CONCURRENT = 2;
  private static final int DOWNLOAD_QUEUE_MAX_CONCURRENT = 8;
  private static WorkQueue cacheReadQueue = new WorkQueue(2);
  private static WorkQueue downloadQueue = new WorkQueue(8);
  private static Handler handler;
  private static final Map<ImageDownloader.RequestKey, ImageDownloader.DownloaderContext> pendingRequests = new HashMap();
  
  public static boolean cancelRequest(ImageRequest paramImageRequest)
  {
    ImageDownloader.RequestKey localRequestKey = new ImageDownloader.RequestKey(paramImageRequest.getImageUri(), paramImageRequest.getCallerTag());
    for (;;)
    {
      boolean bool;
      synchronized (pendingRequests)
      {
        ImageDownloader.DownloaderContext localDownloaderContext = (ImageDownloader.DownloaderContext)pendingRequests.get(localRequestKey);
        if (localDownloaderContext != null)
        {
          if (localDownloaderContext.workItem.cancel())
          {
            pendingRequests.remove(localRequestKey);
            bool = true;
            return bool;
          }
          localDownloaderContext.isCancelled = true;
          bool = true;
        }
      }
    }
  }
  
  public static void clearCache(Context paramContext)
  {
    ImageResponseCache.clearCache(paramContext);
    UrlRedirectCache.clearCache(paramContext);
  }
  
  /* Error */
  private static void download(ImageDownloader.RequestKey paramRequestKey, Context paramContext)
  {
    // Byte code:
    //   0: aconst_null
    //   1: astore_2
    //   2: iconst_1
    //   3: istore_3
    //   4: new 103	java/net/URL
    //   7: dup
    //   8: aload_0
    //   9: getfield 107	com/facebook/internal/ImageDownloader$RequestKey:uri	Ljava/net/URI;
    //   12: invokevirtual 113	java/net/URI:toString	()Ljava/lang/String;
    //   15: invokespecial 116	java/net/URL:<init>	(Ljava/lang/String;)V
    //   18: invokevirtual 120	java/net/URL:openConnection	()Ljava/net/URLConnection;
    //   21: checkcast 122	java/net/HttpURLConnection
    //   24: astore 10
    //   26: aload 10
    //   28: iconst_0
    //   29: invokevirtual 126	java/net/HttpURLConnection:setInstanceFollowRedirects	(Z)V
    //   32: aload 10
    //   34: invokevirtual 130	java/net/HttpURLConnection:getResponseCode	()I
    //   37: lookupswitch	default:+35->72, 200:+247->284, 301:+143->180, 302:+143->180
    //   73: lconst_1
    //   74: invokevirtual 134	java/net/HttpURLConnection:getErrorStream	()Ljava/io/InputStream;
    //   77: astore 25
    //   79: aload 25
    //   81: astore 5
    //   83: new 136	java/lang/StringBuilder
    //   86: dup
    //   87: invokespecial 137	java/lang/StringBuilder:<init>	()V
    //   90: astore 26
    //   92: aload 5
    //   94: ifnull +263 -> 357
    //   97: new 139	java/io/InputStreamReader
    //   100: dup
    //   101: aload 5
    //   103: invokespecial 142	java/io/InputStreamReader:<init>	(Ljava/io/InputStream;)V
    //   106: astore 27
    //   108: sipush 128
    //   111: newarray char
    //   113: astore 28
    //   115: aload 27
    //   117: aload 28
    //   119: iconst_0
    //   120: aload 28
    //   122: arraylength
    //   123: invokevirtual 146	java/io/InputStreamReader:read	([CII)I
    //   126: istore 29
    //   128: iload 29
    //   130: ifle +182 -> 312
    //   133: aload 26
    //   135: aload 28
    //   137: iconst_0
    //   138: iload 29
    //   140: invokevirtual 150	java/lang/StringBuilder:append	([CII)Ljava/lang/StringBuilder;
    //   143: pop
    //   144: goto -29 -> 115
    //   147: astore 19
    //   149: aload 10
    //   151: astore 6
    //   153: aload 19
    //   155: astore 4
    //   157: aload 5
    //   159: invokestatic 156	com/facebook/internal/Utility:closeQuietly	(Ljava/io/Closeable;)V
    //   162: aload 6
    //   164: invokestatic 160	com/facebook/internal/Utility:disconnectQuietly	(Ljava/net/URLConnection;)V
    //   167: iload_3
    //   168: ifeq +11 -> 179
    //   171: aload_0
    //   172: aload 4
    //   174: aload_2
    //   175: iconst_0
    //   176: invokestatic 164	com/facebook/internal/ImageDownloader:issueResponse	(Lcom/facebook/internal/ImageDownloader$RequestKey;Ljava/lang/Exception;Landroid/graphics/Bitmap;Z)V
    //   179: return
    //   180: aload 10
    //   182: ldc 166
    //   184: invokevirtual 170	java/net/HttpURLConnection:getHeaderField	(Ljava/lang/String;)Ljava/lang/String;
    //   187: astore 22
    //   189: aload 22
    //   191: invokestatic 174	com/facebook/internal/Utility:isNullOrEmpty	(Ljava/lang/String;)Z
    //   194: ifne +315 -> 509
    //   197: new 109	java/net/URI
    //   200: dup
    //   201: aload 22
    //   203: invokespecial 175	java/net/URI:<init>	(Ljava/lang/String;)V
    //   206: astore 23
    //   208: aload_1
    //   209: aload_0
    //   210: getfield 107	com/facebook/internal/ImageDownloader$RequestKey:uri	Ljava/net/URI;
    //   213: aload 23
    //   215: invokestatic 179	com/facebook/internal/UrlRedirectCache:cacheUriRedirect	(Landroid/content/Context;Ljava/net/URI;Ljava/net/URI;)V
    //   218: aload_0
    //   219: invokestatic 183	com/facebook/internal/ImageDownloader:removePendingRequest	(Lcom/facebook/internal/ImageDownloader$RequestKey;)Lcom/facebook/internal/ImageDownloader$DownloaderContext;
    //   222: astore 24
    //   224: aload 24
    //   226: ifnull +33 -> 259
    //   229: aload 24
    //   231: getfield 88	com/facebook/internal/ImageDownloader$DownloaderContext:isCancelled	Z
    //   234: ifne +25 -> 259
    //   237: aload 24
    //   239: getfield 187	com/facebook/internal/ImageDownloader$DownloaderContext:request	Lcom/facebook/internal/ImageRequest;
    //   242: new 50	com/facebook/internal/ImageDownloader$RequestKey
    //   245: dup
    //   246: aload 23
    //   248: aload_0
    //   249: getfield 191	com/facebook/internal/ImageDownloader$RequestKey:tag	Ljava/lang/Object;
    //   252: invokespecial 63	com/facebook/internal/ImageDownloader$RequestKey:<init>	(Ljava/net/URI;Ljava/lang/Object;)V
    //   255: iconst_0
    //   256: invokestatic 195	com/facebook/internal/ImageDownloader:enqueueCacheRead	(Lcom/facebook/internal/ImageRequest;Lcom/facebook/internal/ImageDownloader$RequestKey;Z)V
    //   259: iconst_0
    //   260: istore_3
    //   261: aconst_null
    //   262: astore 18
    //   264: aconst_null
    //   265: astore 5
    //   267: aload 5
    //   269: invokestatic 156	com/facebook/internal/Utility:closeQuietly	(Ljava/io/Closeable;)V
    //   272: aload 10
    //   274: invokestatic 160	com/facebook/internal/Utility:disconnectQuietly	(Ljava/net/URLConnection;)V
    //   277: aload 18
    //   279: astore 4
    //   281: goto -114 -> 167
    //   284: aload_1
    //   285: aload 10
    //   287: invokestatic 199	com/facebook/internal/ImageResponseCache:interceptAndCacheImageStream	(Landroid/content/Context;Ljava/net/HttpURLConnection;)Ljava/io/InputStream;
    //   290: astore 14
    //   292: aload 14
    //   294: astore 5
    //   296: aload 5
    //   298: invokestatic 205	android/graphics/BitmapFactory:decodeStream	(Ljava/io/InputStream;)Landroid/graphics/Bitmap;
    //   301: astore 17
    //   303: aconst_null
    //   304: astore 18
    //   306: aload 17
    //   308: astore_2
    //   309: goto -42 -> 267
    //   312: aload 27
    //   314: invokestatic 156	com/facebook/internal/Utility:closeQuietly	(Ljava/io/Closeable;)V
    //   317: new 207	com/facebook/FacebookException
    //   320: dup
    //   321: aload 26
    //   323: invokevirtual 208	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   326: invokespecial 209	com/facebook/FacebookException:<init>	(Ljava/lang/String;)V
    //   329: astore 18
    //   331: goto -64 -> 267
    //   334: astore 16
    //   336: aload 10
    //   338: astore 7
    //   340: aload 16
    //   342: astore 4
    //   344: aload 5
    //   346: invokestatic 156	com/facebook/internal/Utility:closeQuietly	(Ljava/io/Closeable;)V
    //   349: aload 7
    //   351: invokestatic 160	com/facebook/internal/Utility:disconnectQuietly	(Ljava/net/URLConnection;)V
    //   354: goto -187 -> 167
    //   357: aload 26
    //   359: aload_1
    //   360: getstatic 214	com/facebook/android/R$string:com_facebook_image_download_unknown_error	I
    //   363: invokevirtual 220	android/content/Context:getString	(I)Ljava/lang/String;
    //   366: invokevirtual 223	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   369: pop
    //   370: goto -53 -> 317
    //   373: astore 15
    //   375: aload 5
    //   377: astore_2
    //   378: aload 10
    //   380: astore 9
    //   382: aload 15
    //   384: astore 8
    //   386: aload_2
    //   387: invokestatic 156	com/facebook/internal/Utility:closeQuietly	(Ljava/io/Closeable;)V
    //   390: aload 9
    //   392: invokestatic 160	com/facebook/internal/Utility:disconnectQuietly	(Ljava/net/URLConnection;)V
    //   395: aload 8
    //   397: athrow
    //   398: astore 8
    //   400: aconst_null
    //   401: astore 9
    //   403: goto -17 -> 386
    //   406: astore 13
    //   408: aload 10
    //   410: astore 9
    //   412: aload 13
    //   414: astore 8
    //   416: goto -30 -> 386
    //   419: astore 4
    //   421: aconst_null
    //   422: astore 5
    //   424: aconst_null
    //   425: astore 7
    //   427: goto -83 -> 344
    //   430: astore 12
    //   432: aconst_null
    //   433: astore 5
    //   435: aload 10
    //   437: astore 7
    //   439: aload 12
    //   441: astore 4
    //   443: goto -99 -> 344
    //   446: astore 21
    //   448: aconst_null
    //   449: astore 5
    //   451: aload 10
    //   453: astore 7
    //   455: aload 21
    //   457: astore 4
    //   459: iconst_0
    //   460: istore_3
    //   461: goto -117 -> 344
    //   464: astore 4
    //   466: aconst_null
    //   467: astore 5
    //   469: aconst_null
    //   470: astore 6
    //   472: goto -315 -> 157
    //   475: astore 11
    //   477: aconst_null
    //   478: astore 5
    //   480: aload 10
    //   482: astore 6
    //   484: aload 11
    //   486: astore 4
    //   488: goto -331 -> 157
    //   491: astore 20
    //   493: aconst_null
    //   494: astore 5
    //   496: aload 10
    //   498: astore 6
    //   500: aload 20
    //   502: astore 4
    //   504: iconst_0
    //   505: istore_3
    //   506: goto -349 -> 157
    //   509: iconst_0
    //   510: istore_3
    //   511: aconst_null
    //   512: astore 18
    //   514: aconst_null
    //   515: astore 5
    //   517: goto -250 -> 267
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	520	0	paramRequestKey	ImageDownloader.RequestKey
    //   0	520	1	paramContext	Context
    //   1	386	2	localObject1	Object
    //   3	508	3	i	int
    //   155	188	4	localObject2	Object
    //   419	1	4	localURISyntaxException1	java.net.URISyntaxException
    //   441	17	4	localObject3	Object
    //   464	1	4	localIOException1	java.io.IOException
    //   486	17	4	localObject4	Object
    //   81	435	5	localObject5	Object
    //   151	348	6	localHttpURLConnection1	java.net.HttpURLConnection
    //   338	116	7	localHttpURLConnection2	java.net.HttpURLConnection
    //   384	12	8	localObject6	Object
    //   398	1	8	localObject7	Object
    //   414	1	8	localObject8	Object
    //   380	31	9	localHttpURLConnection3	java.net.HttpURLConnection
    //   24	473	10	localHttpURLConnection4	java.net.HttpURLConnection
    //   475	10	11	localIOException2	java.io.IOException
    //   430	10	12	localURISyntaxException2	java.net.URISyntaxException
    //   406	7	13	localObject9	Object
    //   290	3	14	localInputStream1	InputStream
    //   373	10	15	localObject10	Object
    //   334	7	16	localURISyntaxException3	java.net.URISyntaxException
    //   301	6	17	localBitmap	Bitmap
    //   262	251	18	localFacebookException	com.facebook.FacebookException
    //   147	7	19	localIOException3	java.io.IOException
    //   491	10	20	localIOException4	java.io.IOException
    //   446	10	21	localURISyntaxException4	java.net.URISyntaxException
    //   187	15	22	str	java.lang.String
    //   206	41	23	localURI	URI
    //   222	16	24	localDownloaderContext	ImageDownloader.DownloaderContext
    //   77	3	25	localInputStream2	InputStream
    //   90	268	26	localStringBuilder	java.lang.StringBuilder
    //   106	207	27	localInputStreamReader	java.io.InputStreamReader
    //   113	23	28	arrayOfChar	char[]
    //   126	13	29	j	int
    // Exception table:
    //   from	to	target	type
    //   83	144	147	java/io/IOException
    //   296	331	147	java/io/IOException
    //   357	370	147	java/io/IOException
    //   83	144	334	java/net/URISyntaxException
    //   296	331	334	java/net/URISyntaxException
    //   357	370	334	java/net/URISyntaxException
    //   83	144	373	finally
    //   296	331	373	finally
    //   357	370	373	finally
    //   4	26	398	finally
    //   26	79	406	finally
    //   180	259	406	finally
    //   284	292	406	finally
    //   4	26	419	java/net/URISyntaxException
    //   26	79	430	java/net/URISyntaxException
    //   284	292	430	java/net/URISyntaxException
    //   180	259	446	java/net/URISyntaxException
    //   4	26	464	java/io/IOException
    //   26	79	475	java/io/IOException
    //   284	292	475	java/io/IOException
    //   180	259	491	java/io/IOException
  }
  
  /* Error */
  public static void downloadAsync(ImageRequest paramImageRequest)
  {
    // Byte code:
    //   0: aload_0
    //   1: ifnonnull +4 -> 5
    //   4: return
    //   5: new 50	com/facebook/internal/ImageDownloader$RequestKey
    //   8: dup
    //   9: aload_0
    //   10: invokevirtual 56	com/facebook/internal/ImageRequest:getImageUri	()Ljava/net/URI;
    //   13: aload_0
    //   14: invokevirtual 60	com/facebook/internal/ImageRequest:getCallerTag	()Ljava/lang/Object;
    //   17: invokespecial 63	com/facebook/internal/ImageDownloader$RequestKey:<init>	(Ljava/net/URI;Ljava/lang/Object;)V
    //   20: astore_1
    //   21: getstatic 35	com/facebook/internal/ImageDownloader:pendingRequests	Ljava/util/Map;
    //   24: astore_2
    //   25: aload_2
    //   26: monitorenter
    //   27: getstatic 35	com/facebook/internal/ImageDownloader:pendingRequests	Ljava/util/Map;
    //   30: aload_1
    //   31: invokeinterface 69 2 0
    //   36: checkcast 71	com/facebook/internal/ImageDownloader$DownloaderContext
    //   39: astore 4
    //   41: aload 4
    //   43: ifnull +35 -> 78
    //   46: aload 4
    //   48: aload_0
    //   49: putfield 187	com/facebook/internal/ImageDownloader$DownloaderContext:request	Lcom/facebook/internal/ImageRequest;
    //   52: aload 4
    //   54: iconst_0
    //   55: putfield 88	com/facebook/internal/ImageDownloader$DownloaderContext:isCancelled	Z
    //   58: aload 4
    //   60: getfield 75	com/facebook/internal/ImageDownloader$DownloaderContext:workItem	Lcom/facebook/internal/WorkQueue$WorkItem;
    //   63: invokeinterface 228 1 0
    //   68: aload_2
    //   69: monitorexit
    //   70: goto -66 -> 4
    //   73: astore_3
    //   74: aload_2
    //   75: monitorexit
    //   76: aload_3
    //   77: athrow
    //   78: aload_0
    //   79: aload_1
    //   80: aload_0
    //   81: invokevirtual 231	com/facebook/internal/ImageRequest:isCachedRedirectAllowed	()Z
    //   84: invokestatic 195	com/facebook/internal/ImageDownloader:enqueueCacheRead	(Lcom/facebook/internal/ImageRequest;Lcom/facebook/internal/ImageDownloader$RequestKey;Z)V
    //   87: goto -19 -> 68
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	90	0	paramImageRequest	ImageRequest
    //   20	60	1	localRequestKey	ImageDownloader.RequestKey
    //   24	51	2	localMap	Map
    //   73	4	3	localObject	Object
    //   39	20	4	localDownloaderContext	ImageDownloader.DownloaderContext
    // Exception table:
    //   from	to	target	type
    //   27	76	73	finally
    //   78	87	73	finally
  }
  
  private static void enqueueCacheRead(ImageRequest paramImageRequest, ImageDownloader.RequestKey paramRequestKey, boolean paramBoolean)
  {
    enqueueRequest(paramImageRequest, paramRequestKey, cacheReadQueue, new ImageDownloader.CacheReadWorkItem(paramImageRequest.getContext(), paramRequestKey, paramBoolean));
  }
  
  private static void enqueueDownload(ImageRequest paramImageRequest, ImageDownloader.RequestKey paramRequestKey)
  {
    enqueueRequest(paramImageRequest, paramRequestKey, downloadQueue, new ImageDownloader.DownloadImageWorkItem(paramImageRequest.getContext(), paramRequestKey));
  }
  
  private static void enqueueRequest(ImageRequest paramImageRequest, ImageDownloader.RequestKey paramRequestKey, WorkQueue paramWorkQueue, Runnable paramRunnable)
  {
    synchronized (pendingRequests)
    {
      ImageDownloader.DownloaderContext localDownloaderContext = new ImageDownloader.DownloaderContext(null);
      localDownloaderContext.request = paramImageRequest;
      pendingRequests.put(paramRequestKey, localDownloaderContext);
      localDownloaderContext.workItem = paramWorkQueue.addActiveWorkItem(paramRunnable);
      return;
    }
  }
  
  private static Handler getHandler()
  {
    try
    {
      if (handler == null) {
        handler = new Handler(Looper.getMainLooper());
      }
      Handler localHandler = handler;
      return localHandler;
    }
    finally
    {
      localObject = finally;
      throw localObject;
    }
  }
  
  private static void issueResponse(ImageDownloader.RequestKey paramRequestKey, Exception paramException, Bitmap paramBitmap, boolean paramBoolean)
  {
    ImageDownloader.DownloaderContext localDownloaderContext = removePendingRequest(paramRequestKey);
    if ((localDownloaderContext != null) && (!localDownloaderContext.isCancelled))
    {
      ImageRequest localImageRequest = localDownloaderContext.request;
      ImageRequest.Callback localCallback = localImageRequest.getCallback();
      if (localCallback != null) {
        getHandler().post(new ImageDownloader.1(localImageRequest, paramException, paramBoolean, paramBitmap, localCallback));
      }
    }
  }
  
  public static void prioritizeRequest(ImageRequest paramImageRequest)
  {
    ImageDownloader.RequestKey localRequestKey = new ImageDownloader.RequestKey(paramImageRequest.getImageUri(), paramImageRequest.getCallerTag());
    synchronized (pendingRequests)
    {
      ImageDownloader.DownloaderContext localDownloaderContext = (ImageDownloader.DownloaderContext)pendingRequests.get(localRequestKey);
      if (localDownloaderContext != null) {
        localDownloaderContext.workItem.moveToFront();
      }
      return;
    }
  }
  
  private static void readFromCache(ImageDownloader.RequestKey paramRequestKey, Context paramContext, boolean paramBoolean)
  {
    boolean bool1 = false;
    InputStream localInputStream1;
    boolean bool2;
    if (paramBoolean)
    {
      URI localURI = UrlRedirectCache.getRedirectedUri(paramContext, paramRequestKey.uri);
      if (localURI != null)
      {
        InputStream localInputStream2 = ImageResponseCache.getCachedImageStream(localURI, paramContext);
        if (localInputStream2 != null) {
          bool1 = true;
        }
        boolean bool3 = bool1;
        localInputStream1 = localInputStream2;
        bool2 = bool3;
      }
    }
    for (;;)
    {
      if (!bool2) {
        localInputStream1 = ImageResponseCache.getCachedImageStream(paramRequestKey.uri, paramContext);
      }
      if (localInputStream1 != null)
      {
        Bitmap localBitmap = BitmapFactory.decodeStream(localInputStream1);
        Utility.closeQuietly(localInputStream1);
        issueResponse(paramRequestKey, null, localBitmap, bool2);
      }
      for (;;)
      {
        return;
        ImageDownloader.DownloaderContext localDownloaderContext = removePendingRequest(paramRequestKey);
        if ((localDownloaderContext != null) && (!localDownloaderContext.isCancelled)) {
          enqueueDownload(localDownloaderContext.request, paramRequestKey);
        }
      }
      bool2 = false;
      localInputStream1 = null;
    }
  }
  
  private static ImageDownloader.DownloaderContext removePendingRequest(ImageDownloader.RequestKey paramRequestKey)
  {
    synchronized (pendingRequests)
    {
      ImageDownloader.DownloaderContext localDownloaderContext = (ImageDownloader.DownloaderContext)pendingRequests.remove(paramRequestKey);
      return localDownloaderContext;
    }
  }
}


/* Location:           C:\Users\dreadiscool\Desktop\tools\classes-dex2jar.jar
 * Qualified Name:     com.facebook.internal.ImageDownloader
 * JD-Core Version:    0.7.0.1
 */