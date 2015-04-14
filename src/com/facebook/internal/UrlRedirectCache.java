package com.facebook.internal;

import android.content.Context;
import com.facebook.LoggingBehavior;
import java.io.IOException;

class UrlRedirectCache
{
  private static final String REDIRECT_CONTENT_TAG = TAG + "_Redirect";
  static final String TAG = UrlRedirectCache.class.getSimpleName();
  private static volatile FileLruCache urlRedirectCache;
  
  /* Error */
  static void cacheUriRedirect(Context paramContext, java.net.URI paramURI1, java.net.URI paramURI2)
  {
    // Byte code:
    //   0: aload_1
    //   1: ifnull +7 -> 8
    //   4: aload_2
    //   5: ifnonnull +4 -> 9
    //   8: return
    //   9: aconst_null
    //   10: astore_3
    //   11: aload_0
    //   12: invokestatic 44	com/facebook/internal/UrlRedirectCache:getCache	(Landroid/content/Context;)Lcom/facebook/internal/FileLruCache;
    //   15: aload_1
    //   16: invokevirtual 47	java/net/URI:toString	()Ljava/lang/String;
    //   19: getstatic 35	com/facebook/internal/UrlRedirectCache:REDIRECT_CONTENT_TAG	Ljava/lang/String;
    //   22: invokevirtual 53	com/facebook/internal/FileLruCache:openPutStream	(Ljava/lang/String;Ljava/lang/String;)Ljava/io/OutputStream;
    //   25: astore 8
    //   27: aload 8
    //   29: astore_3
    //   30: aload_3
    //   31: aload_2
    //   32: invokevirtual 47	java/net/URI:toString	()Ljava/lang/String;
    //   35: invokevirtual 59	java/lang/String:getBytes	()[B
    //   38: invokevirtual 65	java/io/OutputStream:write	([B)V
    //   41: aload_3
    //   42: invokestatic 71	com/facebook/internal/Utility:closeQuietly	(Ljava/io/Closeable;)V
    //   45: goto -37 -> 8
    //   48: astore 7
    //   50: aload_3
    //   51: invokestatic 71	com/facebook/internal/Utility:closeQuietly	(Ljava/io/Closeable;)V
    //   54: goto -46 -> 8
    //   57: astore 4
    //   59: aconst_null
    //   60: astore 5
    //   62: aload 4
    //   64: astore 6
    //   66: aload 5
    //   68: invokestatic 71	com/facebook/internal/Utility:closeQuietly	(Ljava/io/Closeable;)V
    //   71: aload 6
    //   73: athrow
    //   74: astore 9
    //   76: aload_3
    //   77: astore 5
    //   79: aload 9
    //   81: astore 6
    //   83: goto -17 -> 66
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	86	0	paramContext	Context
    //   0	86	1	paramURI1	java.net.URI
    //   0	86	2	paramURI2	java.net.URI
    //   10	67	3	localObject1	Object
    //   57	6	4	localObject2	Object
    //   60	18	5	localObject3	Object
    //   64	18	6	localObject4	Object
    //   48	1	7	localIOException	IOException
    //   25	3	8	localOutputStream	java.io.OutputStream
    //   74	6	9	localObject5	Object
    // Exception table:
    //   from	to	target	type
    //   11	27	48	java/io/IOException
    //   30	41	48	java/io/IOException
    //   11	27	57	finally
    //   30	41	74	finally
  }
  
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
      if (urlRedirectCache == null) {
        urlRedirectCache = new FileLruCache(paramContext.getApplicationContext(), TAG, new FileLruCache.Limits());
      }
      FileLruCache localFileLruCache = urlRedirectCache;
      return localFileLruCache;
    }
    finally
    {
      localObject = finally;
      throw localObject;
    }
  }
  
  /* Error */
  static java.net.URI getRedirectedUri(Context paramContext, java.net.URI paramURI)
  {
    // Byte code:
    //   0: aconst_null
    //   1: astore_2
    //   2: iconst_0
    //   3: istore_3
    //   4: aload_1
    //   5: ifnonnull +5 -> 10
    //   8: aload_2
    //   9: areturn
    //   10: aload_1
    //   11: invokevirtual 47	java/net/URI:toString	()Ljava/lang/String;
    //   14: astore 4
    //   16: aload_0
    //   17: invokestatic 44	com/facebook/internal/UrlRedirectCache:getCache	(Landroid/content/Context;)Lcom/facebook/internal/FileLruCache;
    //   20: astore 10
    //   22: aload 4
    //   24: astore 11
    //   26: aconst_null
    //   27: astore 12
    //   29: aload 10
    //   31: aload 11
    //   33: getstatic 35	com/facebook/internal/UrlRedirectCache:REDIRECT_CONTENT_TAG	Ljava/lang/String;
    //   36: invokevirtual 114	com/facebook/internal/FileLruCache:get	(Ljava/lang/String;Ljava/lang/String;)Ljava/io/InputStream;
    //   39: astore 15
    //   41: aload 15
    //   43: ifnull +97 -> 140
    //   46: new 116	java/io/InputStreamReader
    //   49: dup
    //   50: aload 15
    //   52: invokespecial 119	java/io/InputStreamReader:<init>	(Ljava/io/InputStream;)V
    //   55: astore 6
    //   57: sipush 128
    //   60: newarray char
    //   62: astore 18
    //   64: new 21	java/lang/StringBuilder
    //   67: dup
    //   68: invokespecial 24	java/lang/StringBuilder:<init>	()V
    //   71: astore 19
    //   73: aload 6
    //   75: aload 18
    //   77: iconst_0
    //   78: aload 18
    //   80: arraylength
    //   81: invokevirtual 123	java/io/InputStreamReader:read	([CII)I
    //   84: istore 20
    //   86: iload 20
    //   88: ifle +27 -> 115
    //   91: aload 19
    //   93: aload 18
    //   95: iconst_0
    //   96: iload 20
    //   98: invokevirtual 126	java/lang/StringBuilder:append	([CII)Ljava/lang/StringBuilder;
    //   101: pop
    //   102: goto -29 -> 73
    //   105: astore 17
    //   107: aload 6
    //   109: invokestatic 71	com/facebook/internal/Utility:closeQuietly	(Ljava/io/Closeable;)V
    //   112: goto -104 -> 8
    //   115: aload 6
    //   117: invokestatic 71	com/facebook/internal/Utility:closeQuietly	(Ljava/io/Closeable;)V
    //   120: aload 19
    //   122: invokevirtual 33	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   125: astore 21
    //   127: aload 21
    //   129: astore 11
    //   131: aload 6
    //   133: astore 12
    //   135: iconst_1
    //   136: istore_3
    //   137: goto -108 -> 29
    //   140: iload_3
    //   141: ifeq +25 -> 166
    //   144: new 46	java/net/URI
    //   147: dup
    //   148: aload 11
    //   150: invokespecial 129	java/net/URI:<init>	(Ljava/lang/String;)V
    //   153: astore 23
    //   155: aload 12
    //   157: invokestatic 71	com/facebook/internal/Utility:closeQuietly	(Ljava/io/Closeable;)V
    //   160: aload 23
    //   162: astore_2
    //   163: goto -155 -> 8
    //   166: aload 12
    //   168: invokestatic 71	com/facebook/internal/Utility:closeQuietly	(Ljava/io/Closeable;)V
    //   171: goto -163 -> 8
    //   174: astore 9
    //   176: aconst_null
    //   177: astore 6
    //   179: aload 6
    //   181: invokestatic 71	com/facebook/internal/Utility:closeQuietly	(Ljava/io/Closeable;)V
    //   184: goto -176 -> 8
    //   187: astore 7
    //   189: aconst_null
    //   190: astore 6
    //   192: aload 7
    //   194: astore 8
    //   196: aload 6
    //   198: invokestatic 71	com/facebook/internal/Utility:closeQuietly	(Ljava/io/Closeable;)V
    //   201: aload 8
    //   203: athrow
    //   204: astore 8
    //   206: goto -10 -> 196
    //   209: astore 8
    //   211: aload 12
    //   213: astore 6
    //   215: goto -19 -> 196
    //   218: astore 16
    //   220: goto -41 -> 179
    //   223: astore 14
    //   225: aload 12
    //   227: astore 6
    //   229: goto -50 -> 179
    //   232: astore 5
    //   234: aconst_null
    //   235: astore 6
    //   237: goto -130 -> 107
    //   240: astore 13
    //   242: aload 12
    //   244: astore 6
    //   246: goto -139 -> 107
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	249	0	paramContext	Context
    //   0	249	1	paramURI	java.net.URI
    //   1	162	2	localObject1	Object
    //   3	138	3	i	int
    //   14	9	4	str1	String
    //   232	1	5	localURISyntaxException1	java.net.URISyntaxException
    //   55	190	6	localObject2	Object
    //   187	6	7	localObject3	Object
    //   194	8	8	localObject4	Object
    //   204	1	8	localObject5	Object
    //   209	1	8	localObject6	Object
    //   174	1	9	localIOException1	IOException
    //   20	10	10	localFileLruCache	FileLruCache
    //   24	125	11	localObject7	Object
    //   27	216	12	localObject8	Object
    //   240	1	13	localURISyntaxException2	java.net.URISyntaxException
    //   223	1	14	localIOException2	IOException
    //   39	12	15	localInputStream	java.io.InputStream
    //   218	1	16	localIOException3	IOException
    //   105	1	17	localURISyntaxException3	java.net.URISyntaxException
    //   62	32	18	arrayOfChar	char[]
    //   71	50	19	localStringBuilder	java.lang.StringBuilder
    //   84	13	20	j	int
    //   125	3	21	str2	String
    //   153	8	23	localURI	java.net.URI
    // Exception table:
    //   from	to	target	type
    //   57	102	105	java/net/URISyntaxException
    //   115	127	105	java/net/URISyntaxException
    //   16	22	174	java/io/IOException
    //   16	22	187	finally
    //   57	102	204	finally
    //   115	127	204	finally
    //   29	57	209	finally
    //   144	155	209	finally
    //   57	102	218	java/io/IOException
    //   115	127	218	java/io/IOException
    //   29	57	223	java/io/IOException
    //   144	155	223	java/io/IOException
    //   16	22	232	java/net/URISyntaxException
    //   29	57	240	java/net/URISyntaxException
    //   144	155	240	java/net/URISyntaxException
  }
}


/* Location:           C:\Users\dreadiscool\Desktop\tools\classes-dex2jar.jar
 * Qualified Name:     com.facebook.internal.UrlRedirectCache
 * JD-Core Version:    0.7.0.1
 */