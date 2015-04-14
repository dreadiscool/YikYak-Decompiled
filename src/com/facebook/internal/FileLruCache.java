package com.facebook.internal;

import android.content.Context;
import com.facebook.Settings;
import java.io.File;
import java.io.InputStream;
import java.io.OutputStream;
import java.util.concurrent.Executor;
import java.util.concurrent.atomic.AtomicLong;

public final class FileLruCache
{
  private static final String HEADER_CACHEKEY_KEY = "key";
  private static final String HEADER_CACHE_CONTENT_TAG_KEY = "tag";
  static final String TAG = FileLruCache.class.getSimpleName();
  private static final AtomicLong bufferIndex = new AtomicLong();
  private final File directory;
  private boolean isTrimInProgress;
  private boolean isTrimPending;
  private AtomicLong lastClearCacheTime = new AtomicLong(0L);
  private final FileLruCache.Limits limits;
  private final Object lock;
  private final String tag;
  
  public FileLruCache(Context paramContext, String paramString, FileLruCache.Limits paramLimits)
  {
    this.tag = paramString;
    this.limits = paramLimits;
    this.directory = new File(paramContext.getCacheDir(), paramString);
    this.lock = new Object();
    if ((this.directory.mkdirs()) || (this.directory.isDirectory())) {
      FileLruCache.BufferFile.deleteAll(this.directory);
    }
  }
  
  private void postTrim()
  {
    synchronized (this.lock)
    {
      if (!this.isTrimPending)
      {
        this.isTrimPending = true;
        Settings.getExecutor().execute(new FileLruCache.3(this));
      }
      return;
    }
  }
  
  private void renameToTargetAndTrim(String paramString, File paramFile)
  {
    if (!paramFile.renameTo(new File(this.directory, Utility.md5hash(paramString)))) {
      paramFile.delete();
    }
    postTrim();
  }
  
  /* Error */
  private void trim()
  {
    // Byte code:
    //   0: aload_0
    //   1: getfield 67	com/facebook/internal/FileLruCache:lock	Ljava/lang/Object;
    //   4: astore_1
    //   5: aload_1
    //   6: monitorenter
    //   7: aload_0
    //   8: iconst_0
    //   9: putfield 98	com/facebook/internal/FileLruCache:isTrimPending	Z
    //   12: aload_0
    //   13: iconst_1
    //   14: putfield 131	com/facebook/internal/FileLruCache:isTrimInProgress	Z
    //   17: aload_1
    //   18: monitorexit
    //   19: getstatic 137	com/facebook/LoggingBehavior:CACHE	Lcom/facebook/LoggingBehavior;
    //   22: getstatic 34	com/facebook/internal/FileLruCache:TAG	Ljava/lang/String;
    //   25: ldc 139
    //   27: invokestatic 145	com/facebook/internal/Logger:log	(Lcom/facebook/LoggingBehavior;Ljava/lang/String;Ljava/lang/String;)V
    //   30: new 147	java/util/PriorityQueue
    //   33: dup
    //   34: invokespecial 148	java/util/PriorityQueue:<init>	()V
    //   37: astore 6
    //   39: lconst_0
    //   40: lstore 7
    //   42: lconst_0
    //   43: lstore 9
    //   45: aload_0
    //   46: getfield 65	com/facebook/internal/FileLruCache:directory	Ljava/io/File;
    //   49: invokestatic 152	com/facebook/internal/FileLruCache$BufferFile:excludeBufferFiles	()Ljava/io/FilenameFilter;
    //   52: invokevirtual 156	java/io/File:listFiles	(Ljava/io/FilenameFilter;)[Ljava/io/File;
    //   55: astore 11
    //   57: aload 11
    //   59: ifnull +304 -> 363
    //   62: aload 11
    //   64: arraylength
    //   65: istore 22
    //   67: iconst_0
    //   68: istore 23
    //   70: iload 23
    //   72: iload 22
    //   74: if_icmpge +289 -> 363
    //   77: aload 11
    //   79: iload 23
    //   81: aaload
    //   82: astore 24
    //   84: new 158	com/facebook/internal/FileLruCache$ModifiedFile
    //   87: dup
    //   88: aload 24
    //   90: invokespecial 160	com/facebook/internal/FileLruCache$ModifiedFile:<init>	(Ljava/io/File;)V
    //   93: astore 25
    //   95: aload 6
    //   97: aload 25
    //   99: invokevirtual 164	java/util/PriorityQueue:add	(Ljava/lang/Object;)Z
    //   102: pop
    //   103: getstatic 137	com/facebook/LoggingBehavior:CACHE	Lcom/facebook/LoggingBehavior;
    //   106: getstatic 34	com/facebook/internal/FileLruCache:TAG	Ljava/lang/String;
    //   109: new 166	java/lang/StringBuilder
    //   112: dup
    //   113: invokespecial 167	java/lang/StringBuilder:<init>	()V
    //   116: ldc 169
    //   118: invokevirtual 173	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   121: aload 25
    //   123: invokevirtual 177	com/facebook/internal/FileLruCache$ModifiedFile:getModified	()J
    //   126: invokestatic 183	java/lang/Long:valueOf	(J)Ljava/lang/Long;
    //   129: invokevirtual 186	java/lang/StringBuilder:append	(Ljava/lang/Object;)Ljava/lang/StringBuilder;
    //   132: ldc 188
    //   134: invokevirtual 173	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   137: aload 25
    //   139: invokevirtual 191	com/facebook/internal/FileLruCache$ModifiedFile:getFile	()Ljava/io/File;
    //   142: invokevirtual 194	java/io/File:getName	()Ljava/lang/String;
    //   145: invokevirtual 173	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   148: invokevirtual 197	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   151: invokestatic 145	com/facebook/internal/Logger:log	(Lcom/facebook/LoggingBehavior;Ljava/lang/String;Ljava/lang/String;)V
    //   154: aload 24
    //   156: invokevirtual 200	java/io/File:length	()J
    //   159: lstore 27
    //   161: lload 27
    //   163: lload 7
    //   165: ladd
    //   166: lstore 29
    //   168: lconst_1
    //   169: lload 9
    //   171: ladd
    //   172: lstore 31
    //   174: iinc 23 1
    //   177: lload 31
    //   179: lstore 9
    //   181: lload 29
    //   183: lstore 7
    //   185: goto -115 -> 70
    //   188: astore_2
    //   189: aload_1
    //   190: monitorexit
    //   191: aload_2
    //   192: athrow
    //   193: lload 12
    //   195: aload_0
    //   196: getfield 52	com/facebook/internal/FileLruCache:limits	Lcom/facebook/internal/FileLruCache$Limits;
    //   199: invokevirtual 206	com/facebook/internal/FileLruCache$Limits:getByteCount	()I
    //   202: i2l
    //   203: lcmp
    //   204: ifgt +17 -> 221
    //   207: lload 14
    //   209: aload_0
    //   210: getfield 52	com/facebook/internal/FileLruCache:limits	Lcom/facebook/internal/FileLruCache$Limits;
    //   213: invokevirtual 209	com/facebook/internal/FileLruCache$Limits:getFileCount	()I
    //   216: i2l
    //   217: lcmp
    //   218: ifle +77 -> 295
    //   221: aload 6
    //   223: invokevirtual 213	java/util/PriorityQueue:remove	()Ljava/lang/Object;
    //   226: checkcast 158	com/facebook/internal/FileLruCache$ModifiedFile
    //   229: invokevirtual 191	com/facebook/internal/FileLruCache$ModifiedFile:getFile	()Ljava/io/File;
    //   232: astore 16
    //   234: getstatic 137	com/facebook/LoggingBehavior:CACHE	Lcom/facebook/LoggingBehavior;
    //   237: getstatic 34	com/facebook/internal/FileLruCache:TAG	Ljava/lang/String;
    //   240: new 166	java/lang/StringBuilder
    //   243: dup
    //   244: invokespecial 167	java/lang/StringBuilder:<init>	()V
    //   247: ldc 215
    //   249: invokevirtual 173	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   252: aload 16
    //   254: invokevirtual 194	java/io/File:getName	()Ljava/lang/String;
    //   257: invokevirtual 173	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   260: invokevirtual 197	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   263: invokestatic 145	com/facebook/internal/Logger:log	(Lcom/facebook/LoggingBehavior;Ljava/lang/String;Ljava/lang/String;)V
    //   266: lload 12
    //   268: aload 16
    //   270: invokevirtual 200	java/io/File:length	()J
    //   273: lsub
    //   274: lstore 12
    //   276: lload 14
    //   278: lconst_1
    //   279: lsub
    //   280: lstore 17
    //   282: aload 16
    //   284: invokevirtual 127	java/io/File:delete	()Z
    //   287: pop
    //   288: lload 17
    //   290: lstore 14
    //   292: goto -99 -> 193
    //   295: aload_0
    //   296: getfield 67	com/facebook/internal/FileLruCache:lock	Ljava/lang/Object;
    //   299: astore 20
    //   301: aload 20
    //   303: monitorenter
    //   304: aload_0
    //   305: iconst_0
    //   306: putfield 131	com/facebook/internal/FileLruCache:isTrimInProgress	Z
    //   309: aload_0
    //   310: getfield 67	com/facebook/internal/FileLruCache:lock	Ljava/lang/Object;
    //   313: invokevirtual 218	java/lang/Object:notifyAll	()V
    //   316: aload 20
    //   318: monitorexit
    //   319: return
    //   320: astore 21
    //   322: aload 20
    //   324: monitorexit
    //   325: aload 21
    //   327: athrow
    //   328: astore_3
    //   329: aload_0
    //   330: getfield 67	com/facebook/internal/FileLruCache:lock	Ljava/lang/Object;
    //   333: astore 4
    //   335: aload 4
    //   337: monitorenter
    //   338: aload_0
    //   339: iconst_0
    //   340: putfield 131	com/facebook/internal/FileLruCache:isTrimInProgress	Z
    //   343: aload_0
    //   344: getfield 67	com/facebook/internal/FileLruCache:lock	Ljava/lang/Object;
    //   347: invokevirtual 218	java/lang/Object:notifyAll	()V
    //   350: aload 4
    //   352: monitorexit
    //   353: aload_3
    //   354: athrow
    //   355: astore 5
    //   357: aload 4
    //   359: monitorexit
    //   360: aload 5
    //   362: athrow
    //   363: lload 7
    //   365: lstore 12
    //   367: lload 9
    //   369: lstore 14
    //   371: goto -178 -> 193
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	374	0	this	FileLruCache
    //   4	186	1	localObject1	Object
    //   188	4	2	localObject2	Object
    //   328	26	3	localObject3	Object
    //   333	25	4	localObject4	Object
    //   355	6	5	localObject5	Object
    //   37	185	6	localPriorityQueue	java.util.PriorityQueue
    //   40	324	7	l1	long
    //   43	325	9	l2	long
    //   55	23	11	arrayOfFile	File[]
    //   193	74	12	localObject6	Object
    //   274	92	12	l3	long
    //   207	70	14	localObject7	Object
    //   290	80	14	l4	long
    //   232	51	16	localFile1	File
    //   280	9	17	l5	long
    //   299	24	20	localObject8	Object
    //   320	6	21	localObject9	Object
    //   65	10	22	i	int
    //   68	107	23	j	int
    //   82	73	24	localFile2	File
    //   93	45	25	localModifiedFile	FileLruCache.ModifiedFile
    //   159	3	27	l6	long
    //   166	16	29	l7	long
    //   172	6	31	l8	long
    // Exception table:
    //   from	to	target	type
    //   7	19	188	finally
    //   189	191	188	finally
    //   304	325	320	finally
    //   19	161	328	finally
    //   193	288	328	finally
    //   338	353	355	finally
    //   357	360	355	finally
  }
  
  public void clearCache()
  {
    File[] arrayOfFile = this.directory.listFiles(FileLruCache.BufferFile.excludeBufferFiles());
    this.lastClearCacheTime.set(System.currentTimeMillis());
    if (arrayOfFile != null) {
      Settings.getExecutor().execute(new FileLruCache.2(this, arrayOfFile));
    }
  }
  
  public InputStream get(String paramString)
  {
    return get(paramString, null);
  }
  
  /* Error */
  public InputStream get(String paramString1, String paramString2)
  {
    // Byte code:
    //   0: aconst_null
    //   1: astore_3
    //   2: new 54	java/io/File
    //   5: dup
    //   6: aload_0
    //   7: getfield 65	com/facebook/internal/FileLruCache:directory	Ljava/io/File;
    //   10: aload_1
    //   11: invokestatic 120	com/facebook/internal/Utility:md5hash	(Ljava/lang/String;)Ljava/lang/String;
    //   14: invokespecial 63	java/io/File:<init>	(Ljava/io/File;Ljava/lang/String;)V
    //   17: astore 4
    //   19: new 241	java/io/FileInputStream
    //   22: dup
    //   23: aload 4
    //   25: invokespecial 242	java/io/FileInputStream:<init>	(Ljava/io/File;)V
    //   28: astore 5
    //   30: new 244	java/io/BufferedInputStream
    //   33: dup
    //   34: aload 5
    //   36: sipush 8192
    //   39: invokespecial 247	java/io/BufferedInputStream:<init>	(Ljava/io/InputStream;I)V
    //   42: astore 6
    //   44: aload 6
    //   46: invokestatic 253	com/facebook/internal/FileLruCache$StreamHeader:readHeader	(Ljava/io/InputStream;)Lorg/json/JSONObject;
    //   49: astore 8
    //   51: aload 8
    //   53: ifnonnull +10 -> 63
    //   56: aload 6
    //   58: invokevirtual 256	java/io/BufferedInputStream:close	()V
    //   61: aload_3
    //   62: areturn
    //   63: aload 8
    //   65: ldc 8
    //   67: invokevirtual 261	org/json/JSONObject:optString	(Ljava/lang/String;)Ljava/lang/String;
    //   70: astore 9
    //   72: aload 9
    //   74: ifnull +16 -> 90
    //   77: aload 9
    //   79: aload_1
    //   80: invokevirtual 266	java/lang/String:equals	(Ljava/lang/Object;)Z
    //   83: istore 10
    //   85: iload 10
    //   87: ifne +11 -> 98
    //   90: aload 6
    //   92: invokevirtual 256	java/io/BufferedInputStream:close	()V
    //   95: goto -34 -> 61
    //   98: aload 8
    //   100: ldc 11
    //   102: aconst_null
    //   103: invokevirtual 269	org/json/JSONObject:optString	(Ljava/lang/String;Ljava/lang/String;)Ljava/lang/String;
    //   106: astore 11
    //   108: aload_2
    //   109: ifnonnull +8 -> 117
    //   112: aload 11
    //   114: ifnonnull +20 -> 134
    //   117: aload_2
    //   118: ifnull +24 -> 142
    //   121: aload_2
    //   122: aload 11
    //   124: invokevirtual 266	java/lang/String:equals	(Ljava/lang/Object;)Z
    //   127: istore 15
    //   129: iload 15
    //   131: ifne +11 -> 142
    //   134: aload 6
    //   136: invokevirtual 256	java/io/BufferedInputStream:close	()V
    //   139: goto -78 -> 61
    //   142: new 271	java/util/Date
    //   145: dup
    //   146: invokespecial 272	java/util/Date:<init>	()V
    //   149: invokevirtual 275	java/util/Date:getTime	()J
    //   152: lstore 12
    //   154: getstatic 137	com/facebook/LoggingBehavior:CACHE	Lcom/facebook/LoggingBehavior;
    //   157: getstatic 34	com/facebook/internal/FileLruCache:TAG	Ljava/lang/String;
    //   160: new 166	java/lang/StringBuilder
    //   163: dup
    //   164: invokespecial 167	java/lang/StringBuilder:<init>	()V
    //   167: ldc_w 277
    //   170: invokevirtual 173	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   173: lload 12
    //   175: invokestatic 183	java/lang/Long:valueOf	(J)Ljava/lang/Long;
    //   178: invokevirtual 186	java/lang/StringBuilder:append	(Ljava/lang/Object;)Ljava/lang/StringBuilder;
    //   181: ldc_w 279
    //   184: invokevirtual 173	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   187: aload 4
    //   189: invokevirtual 194	java/io/File:getName	()Ljava/lang/String;
    //   192: invokevirtual 173	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   195: invokevirtual 197	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   198: invokestatic 145	com/facebook/internal/Logger:log	(Lcom/facebook/LoggingBehavior;Ljava/lang/String;Ljava/lang/String;)V
    //   201: aload 4
    //   203: lload 12
    //   205: invokevirtual 283	java/io/File:setLastModified	(J)Z
    //   208: pop
    //   209: aload 6
    //   211: astore_3
    //   212: goto -151 -> 61
    //   215: astore 7
    //   217: aload 6
    //   219: invokevirtual 256	java/io/BufferedInputStream:close	()V
    //   222: aload 7
    //   224: athrow
    //   225: astore 16
    //   227: goto -166 -> 61
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	230	0	this	FileLruCache
    //   0	230	1	paramString1	String
    //   0	230	2	paramString2	String
    //   1	211	3	localObject1	Object
    //   17	185	4	localFile	File
    //   28	7	5	localFileInputStream	java.io.FileInputStream
    //   42	176	6	localBufferedInputStream	java.io.BufferedInputStream
    //   215	8	7	localObject2	Object
    //   49	50	8	localJSONObject	org.json.JSONObject
    //   70	8	9	str1	String
    //   83	3	10	bool1	boolean
    //   106	17	11	str2	String
    //   152	52	12	l	long
    //   127	3	15	bool2	boolean
    //   225	1	16	localIOException	java.io.IOException
    // Exception table:
    //   from	to	target	type
    //   44	51	215	finally
    //   63	85	215	finally
    //   98	129	215	finally
    //   142	209	215	finally
    //   19	30	225	java/io/IOException
  }
  
  public InputStream interceptAndPut(String paramString, InputStream paramInputStream)
  {
    return new FileLruCache.CopyingInputStream(paramInputStream, openPutStream(paramString));
  }
  
  OutputStream openPutStream(String paramString)
  {
    return openPutStream(paramString, null);
  }
  
  /* Error */
  public OutputStream openPutStream(String paramString1, String paramString2)
  {
    // Byte code:
    //   0: aload_0
    //   1: getfield 65	com/facebook/internal/FileLruCache:directory	Ljava/io/File;
    //   4: invokestatic 305	com/facebook/internal/FileLruCache$BufferFile:newFile	(Ljava/io/File;)Ljava/io/File;
    //   7: astore_3
    //   8: aload_3
    //   9: invokevirtual 127	java/io/File:delete	()Z
    //   12: pop
    //   13: aload_3
    //   14: invokevirtual 308	java/io/File:createNewFile	()Z
    //   17: ifne +34 -> 51
    //   20: new 239	java/io/IOException
    //   23: dup
    //   24: new 166	java/lang/StringBuilder
    //   27: dup
    //   28: invokespecial 167	java/lang/StringBuilder:<init>	()V
    //   31: ldc_w 310
    //   34: invokevirtual 173	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   37: aload_3
    //   38: invokevirtual 313	java/io/File:getAbsolutePath	()Ljava/lang/String;
    //   41: invokevirtual 173	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   44: invokevirtual 197	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   47: invokespecial 316	java/io/IOException:<init>	(Ljava/lang/String;)V
    //   50: athrow
    //   51: new 318	java/io/FileOutputStream
    //   54: dup
    //   55: aload_3
    //   56: invokespecial 319	java/io/FileOutputStream:<init>	(Ljava/io/File;)V
    //   59: astore 5
    //   61: new 321	java/io/BufferedOutputStream
    //   64: dup
    //   65: new 323	com/facebook/internal/FileLruCache$CloseCallbackOutputStream
    //   68: dup
    //   69: aload 5
    //   71: new 325	com/facebook/internal/FileLruCache$1
    //   74: dup
    //   75: aload_0
    //   76: invokestatic 224	java/lang/System:currentTimeMillis	()J
    //   79: aload_3
    //   80: aload_1
    //   81: invokespecial 328	com/facebook/internal/FileLruCache$1:<init>	(Lcom/facebook/internal/FileLruCache;JLjava/io/File;Ljava/lang/String;)V
    //   84: invokespecial 331	com/facebook/internal/FileLruCache$CloseCallbackOutputStream:<init>	(Ljava/io/OutputStream;Lcom/facebook/internal/FileLruCache$StreamCloseCallback;)V
    //   87: sipush 8192
    //   90: invokespecial 334	java/io/BufferedOutputStream:<init>	(Ljava/io/OutputStream;I)V
    //   93: astore 6
    //   95: new 258	org/json/JSONObject
    //   98: dup
    //   99: invokespecial 335	org/json/JSONObject:<init>	()V
    //   102: astore 7
    //   104: aload 7
    //   106: ldc 8
    //   108: aload_1
    //   109: invokevirtual 339	org/json/JSONObject:put	(Ljava/lang/String;Ljava/lang/Object;)Lorg/json/JSONObject;
    //   112: pop
    //   113: aload_2
    //   114: invokestatic 343	com/facebook/internal/Utility:isNullOrEmpty	(Ljava/lang/String;)Z
    //   117: ifne +12 -> 129
    //   120: aload 7
    //   122: ldc 11
    //   124: aload_2
    //   125: invokevirtual 339	org/json/JSONObject:put	(Ljava/lang/String;Ljava/lang/Object;)Lorg/json/JSONObject;
    //   128: pop
    //   129: aload 6
    //   131: aload 7
    //   133: invokestatic 347	com/facebook/internal/FileLruCache$StreamHeader:writeHeader	(Ljava/io/OutputStream;Lorg/json/JSONObject;)V
    //   136: aload 6
    //   138: areturn
    //   139: astore 12
    //   141: getstatic 137	com/facebook/LoggingBehavior:CACHE	Lcom/facebook/LoggingBehavior;
    //   144: iconst_5
    //   145: getstatic 34	com/facebook/internal/FileLruCache:TAG	Ljava/lang/String;
    //   148: new 166	java/lang/StringBuilder
    //   151: dup
    //   152: invokespecial 167	java/lang/StringBuilder:<init>	()V
    //   155: ldc_w 349
    //   158: invokevirtual 173	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   161: aload 12
    //   163: invokevirtual 186	java/lang/StringBuilder:append	(Ljava/lang/Object;)Ljava/lang/StringBuilder;
    //   166: invokevirtual 197	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   169: invokestatic 352	com/facebook/internal/Logger:log	(Lcom/facebook/LoggingBehavior;ILjava/lang/String;Ljava/lang/String;)V
    //   172: new 239	java/io/IOException
    //   175: dup
    //   176: aload 12
    //   178: invokevirtual 355	java/io/FileNotFoundException:getMessage	()Ljava/lang/String;
    //   181: invokespecial 316	java/io/IOException:<init>	(Ljava/lang/String;)V
    //   184: athrow
    //   185: astore 9
    //   187: getstatic 137	com/facebook/LoggingBehavior:CACHE	Lcom/facebook/LoggingBehavior;
    //   190: iconst_5
    //   191: getstatic 34	com/facebook/internal/FileLruCache:TAG	Ljava/lang/String;
    //   194: new 166	java/lang/StringBuilder
    //   197: dup
    //   198: invokespecial 167	java/lang/StringBuilder:<init>	()V
    //   201: ldc_w 357
    //   204: invokevirtual 173	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   207: aload 9
    //   209: invokevirtual 186	java/lang/StringBuilder:append	(Ljava/lang/Object;)Ljava/lang/StringBuilder;
    //   212: invokevirtual 197	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   215: invokestatic 352	com/facebook/internal/Logger:log	(Lcom/facebook/LoggingBehavior;ILjava/lang/String;Ljava/lang/String;)V
    //   218: new 239	java/io/IOException
    //   221: dup
    //   222: aload 9
    //   224: invokevirtual 358	org/json/JSONException:getMessage	()Ljava/lang/String;
    //   227: invokespecial 316	java/io/IOException:<init>	(Ljava/lang/String;)V
    //   230: athrow
    //   231: astore 8
    //   233: aload 6
    //   235: invokevirtual 359	java/io/BufferedOutputStream:close	()V
    //   238: aload 8
    //   240: athrow
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	241	0	this	FileLruCache
    //   0	241	1	paramString1	String
    //   0	241	2	paramString2	String
    //   7	73	3	localFile	File
    //   59	11	5	localFileOutputStream	java.io.FileOutputStream
    //   93	141	6	localBufferedOutputStream	java.io.BufferedOutputStream
    //   102	30	7	localJSONObject	org.json.JSONObject
    //   231	8	8	localObject	Object
    //   185	38	9	localJSONException	org.json.JSONException
    //   139	38	12	localFileNotFoundException	java.io.FileNotFoundException
    // Exception table:
    //   from	to	target	type
    //   51	61	139	java/io/FileNotFoundException
    //   95	136	185	org/json/JSONException
    //   95	136	231	finally
    //   187	231	231	finally
  }
  
  long sizeInBytesForTest()
  {
    long l1;
    synchronized (this.lock)
    {
      for (;;)
      {
        if (!this.isTrimPending)
        {
          boolean bool = this.isTrimInProgress;
          if (!bool) {
            break;
          }
        }
        try
        {
          this.lock.wait();
        }
        catch (InterruptedException localInterruptedException) {}
      }
      File[] arrayOfFile = this.directory.listFiles();
      l1 = 0L;
      if (arrayOfFile != null)
      {
        int i = arrayOfFile.length;
        int j = 0;
        if (j < i)
        {
          long l2 = l1 + arrayOfFile[j].length();
          j++;
          l1 = l2;
        }
      }
    }
    return l1;
  }
  
  public String toString()
  {
    return "{FileLruCache: tag:" + this.tag + " file:" + this.directory.getName() + "}";
  }
}


/* Location:           C:\Users\dreadiscool\Desktop\tools\classes-dex2jar.jar
 * Qualified Name:     com.facebook.internal.FileLruCache
 * JD-Core Version:    0.7.0.1
 */