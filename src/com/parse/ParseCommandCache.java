package com.parse;

import android.content.Context;
import java.io.File;
import java.util.HashMap;
import java.util.logging.Logger;
import k;
import m;
import org.json.JSONObject;

class ParseCommandCache
  extends ParseEventuallyQueue
{
  private static final String TAG = "com.parse.ParseCommandCache";
  private static int filenameCounter = 0;
  private static final Object lock = new Object();
  private File cachePath;
  private Logger log;
  private int maxCacheSizeBytes = 10485760;
  private HashMap<File, m<Object>.y> pendingTasks = new HashMap();
  private boolean running;
  private final Object runningLock;
  private boolean shouldStop;
  private int timeoutMaxRetries = 5;
  private double timeoutRetryWaitSeconds = 600.0D;
  private boolean unprocessedCommandsExist;
  
  public ParseCommandCache(Context paramContext)
  {
    setConnected(false);
    this.shouldStop = false;
    this.running = false;
    this.runningLock = new Object();
    this.log = Logger.getLogger("com.parse.ParseCommandCache");
    this.cachePath = getCacheDir();
    if (!Parse.hasPermission("android.permission.ACCESS_NETWORK_STATE")) {}
    for (;;)
    {
      return;
      setConnected(ConnectivityNotifier.getNotifier().isConnected());
      ConnectivityNotifier.getNotifier().addListener(new ParseCommandCache.1(this), paramContext);
      resume();
    }
  }
  
  /* Error */
  private m<Object> enqueueEventuallyAsync(ParseCommand paramParseCommand, boolean paramBoolean, ParseObject paramParseObject)
  {
    // Byte code:
    //   0: iconst_0
    //   1: istore 4
    //   3: ldc 81
    //   5: invokestatic 125	com/parse/Parse:requirePermission	(Ljava/lang/String;)V
    //   8: invokestatic 131	m:a	()Ly;
    //   11: astore 5
    //   13: aload_3
    //   14: ifnull +18 -> 32
    //   17: aload_3
    //   18: invokevirtual 137	com/parse/ParseObject:getObjectId	()Ljava/lang/String;
    //   21: ifnonnull +11 -> 32
    //   24: aload_1
    //   25: aload_3
    //   26: invokevirtual 140	com/parse/ParseObject:getOrCreateLocalId	()Ljava/lang/String;
    //   29: invokevirtual 145	com/parse/ParseCommand:setLocalId	(Ljava/lang/String;)V
    //   32: aload_1
    //   33: invokevirtual 149	com/parse/ParseCommand:toJSONObject	()Lorg/json/JSONObject;
    //   36: invokevirtual 154	org/json/JSONObject:toString	()Ljava/lang/String;
    //   39: ldc 156
    //   41: invokevirtual 162	java/lang/String:getBytes	(Ljava/lang/String;)[B
    //   44: astore 8
    //   46: aload 8
    //   48: arraylength
    //   49: aload_0
    //   50: getfield 50	com/parse/ParseCommandCache:maxCacheSizeBytes	I
    //   53: if_icmple +70 -> 123
    //   56: iconst_5
    //   57: invokestatic 166	com/parse/Parse:getLogLevel	()I
    //   60: if_icmplt +12 -> 72
    //   63: aload_0
    //   64: getfield 73	com/parse/ParseCommandCache:log	Ljava/util/logging/Logger;
    //   67: ldc 168
    //   69: invokevirtual 171	java/util/logging/Logger:warning	(Ljava/lang/String;)V
    //   72: aload_0
    //   73: iconst_4
    //   74: invokevirtual 175	com/parse/ParseCommandCache:notifyTestHelper	(I)V
    //   77: aconst_null
    //   78: invokestatic 178	m:a	(Ljava/lang/Object;)Lm;
    //   81: astore 7
    //   83: aload 7
    //   85: areturn
    //   86: astore 6
    //   88: iconst_5
    //   89: invokestatic 166	com/parse/Parse:getLogLevel	()I
    //   92: if_icmplt +17 -> 109
    //   95: aload_0
    //   96: getfield 73	com/parse/ParseCommandCache:log	Ljava/util/logging/Logger;
    //   99: getstatic 184	java/util/logging/Level:WARNING	Ljava/util/logging/Level;
    //   102: ldc 186
    //   104: aload 6
    //   106: invokevirtual 189	java/util/logging/Logger:log	(Ljava/util/logging/Level;Ljava/lang/String;Ljava/lang/Throwable;)V
    //   109: aload_0
    //   110: iconst_4
    //   111: invokevirtual 175	com/parse/ParseCommandCache:notifyTestHelper	(I)V
    //   114: aconst_null
    //   115: invokestatic 178	m:a	(Ljava/lang/Object;)Lm;
    //   118: astore 7
    //   120: goto -37 -> 83
    //   123: getstatic 39	com/parse/ParseCommandCache:lock	Ljava/lang/Object;
    //   126: astore 9
    //   128: aload 9
    //   130: monitorenter
    //   131: aload_0
    //   132: getfield 79	com/parse/ParseCommandCache:cachePath	Ljava/io/File;
    //   135: invokevirtual 195	java/io/File:list	()[Ljava/lang/String;
    //   138: astore 13
    //   140: aload 13
    //   142: ifnull +220 -> 362
    //   145: aload 13
    //   147: invokestatic 201	java/util/Arrays:sort	([Ljava/lang/Object;)V
    //   150: aload 13
    //   152: arraylength
    //   153: istore 22
    //   155: iconst_0
    //   156: istore 23
    //   158: iconst_0
    //   159: istore 24
    //   161: iload 23
    //   163: iload 22
    //   165: if_icmpge +38 -> 203
    //   168: aload 13
    //   170: iload 23
    //   172: aaload
    //   173: astore 32
    //   175: iload 24
    //   177: new 191	java/io/File
    //   180: dup
    //   181: aload_0
    //   182: getfield 79	com/parse/ParseCommandCache:cachePath	Ljava/io/File;
    //   185: aload 32
    //   187: invokespecial 204	java/io/File:<init>	(Ljava/io/File;Ljava/lang/String;)V
    //   190: invokevirtual 208	java/io/File:length	()J
    //   193: l2i
    //   194: iadd
    //   195: istore 24
    //   197: iinc 23 1
    //   200: goto -39 -> 161
    //   203: iload 24
    //   205: aload 8
    //   207: arraylength
    //   208: iadd
    //   209: istore 25
    //   211: iload 25
    //   213: aload_0
    //   214: getfield 50	com/parse/ParseCommandCache:maxCacheSizeBytes	I
    //   217: if_icmple +145 -> 362
    //   220: iload_2
    //   221: ifeq +49 -> 270
    //   224: iconst_5
    //   225: invokestatic 166	com/parse/Parse:getLogLevel	()I
    //   228: if_icmplt +12 -> 240
    //   231: aload_0
    //   232: getfield 73	com/parse/ParseCommandCache:log	Ljava/util/logging/Logger;
    //   235: ldc 210
    //   237: invokevirtual 171	java/util/logging/Logger:warning	(Ljava/lang/String;)V
    //   240: aconst_null
    //   241: invokestatic 178	m:a	(Ljava/lang/Object;)Lm;
    //   244: astore 31
    //   246: aload 31
    //   248: astore 7
    //   250: getstatic 39	com/parse/ParseCommandCache:lock	Ljava/lang/Object;
    //   253: invokevirtual 213	java/lang/Object:notifyAll	()V
    //   256: aload 9
    //   258: monitorexit
    //   259: goto -176 -> 83
    //   262: astore 11
    //   264: aload 9
    //   266: monitorexit
    //   267: aload 11
    //   269: athrow
    //   270: iconst_5
    //   271: invokestatic 166	com/parse/Parse:getLogLevel	()I
    //   274: if_icmplt +383 -> 657
    //   277: aload_0
    //   278: getfield 73	com/parse/ParseCommandCache:log	Ljava/util/logging/Logger;
    //   281: ldc 215
    //   283: invokevirtual 171	java/util/logging/Logger:warning	(Ljava/lang/String;)V
    //   286: goto +371 -> 657
    //   289: iload 26
    //   291: aload_0
    //   292: getfield 50	com/parse/ParseCommandCache:maxCacheSizeBytes	I
    //   295: if_icmple +67 -> 362
    //   298: iload 4
    //   300: aload 13
    //   302: arraylength
    //   303: if_icmpge +59 -> 362
    //   306: aload_0
    //   307: getfield 79	com/parse/ParseCommandCache:cachePath	Ljava/io/File;
    //   310: astore 27
    //   312: iload 4
    //   314: iconst_1
    //   315: iadd
    //   316: istore 28
    //   318: new 191	java/io/File
    //   321: dup
    //   322: aload 27
    //   324: aload 13
    //   326: iload 4
    //   328: aaload
    //   329: invokespecial 204	java/io/File:<init>	(Ljava/io/File;Ljava/lang/String;)V
    //   332: astore 29
    //   334: iload 26
    //   336: aload 29
    //   338: invokevirtual 208	java/io/File:length	()J
    //   341: l2i
    //   342: isub
    //   343: istore 30
    //   345: aload_0
    //   346: aload 29
    //   348: invokespecial 219	com/parse/ParseCommandCache:removeFile	(Ljava/io/File;)V
    //   351: iload 30
    //   353: istore 26
    //   355: iload 28
    //   357: istore 4
    //   359: goto -70 -> 289
    //   362: invokestatic 224	java/lang/System:currentTimeMillis	()J
    //   365: invokestatic 230	java/lang/Long:toHexString	(J)Ljava/lang/String;
    //   368: astore 14
    //   370: aload 14
    //   372: invokevirtual 232	java/lang/String:length	()I
    //   375: bipush 16
    //   377: if_icmpge +273 -> 650
    //   380: bipush 16
    //   382: aload 14
    //   384: invokevirtual 232	java/lang/String:length	()I
    //   387: isub
    //   388: newarray char
    //   390: astore 21
    //   392: aload 21
    //   394: bipush 48
    //   396: invokestatic 236	java/util/Arrays:fill	([CC)V
    //   399: new 238	java/lang/StringBuilder
    //   402: dup
    //   403: invokespecial 239	java/lang/StringBuilder:<init>	()V
    //   406: new 158	java/lang/String
    //   409: dup
    //   410: aload 21
    //   412: invokespecial 242	java/lang/String:<init>	([C)V
    //   415: invokevirtual 246	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   418: aload 14
    //   420: invokevirtual 246	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   423: invokevirtual 247	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   426: astore 15
    //   428: getstatic 32	com/parse/ParseCommandCache:filenameCounter	I
    //   431: istore 16
    //   433: iload 16
    //   435: iconst_1
    //   436: iadd
    //   437: putstatic 32	com/parse/ParseCommandCache:filenameCounter	I
    //   440: iload 16
    //   442: invokestatic 252	java/lang/Integer:toHexString	(I)Ljava/lang/String;
    //   445: astore 17
    //   447: aload 17
    //   449: invokevirtual 232	java/lang/String:length	()I
    //   452: bipush 8
    //   454: if_icmpge +51 -> 505
    //   457: bipush 8
    //   459: aload 17
    //   461: invokevirtual 232	java/lang/String:length	()I
    //   464: isub
    //   465: newarray char
    //   467: astore 20
    //   469: aload 20
    //   471: bipush 48
    //   473: invokestatic 236	java/util/Arrays:fill	([CC)V
    //   476: new 238	java/lang/StringBuilder
    //   479: dup
    //   480: invokespecial 239	java/lang/StringBuilder:<init>	()V
    //   483: new 158	java/lang/String
    //   486: dup
    //   487: aload 20
    //   489: invokespecial 242	java/lang/String:<init>	([C)V
    //   492: invokevirtual 246	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   495: aload 17
    //   497: invokevirtual 246	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   500: invokevirtual 247	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   503: astore 17
    //   505: new 238	java/lang/StringBuilder
    //   508: dup
    //   509: invokespecial 239	java/lang/StringBuilder:<init>	()V
    //   512: ldc 254
    //   514: invokevirtual 246	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   517: aload 15
    //   519: invokevirtual 246	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   522: ldc_w 256
    //   525: invokevirtual 246	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   528: aload 17
    //   530: invokevirtual 246	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   533: ldc_w 256
    //   536: invokevirtual 246	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   539: invokevirtual 247	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   542: ldc_w 258
    //   545: aload_0
    //   546: getfield 79	com/parse/ParseCommandCache:cachePath	Ljava/io/File;
    //   549: invokestatic 262	java/io/File:createTempFile	(Ljava/lang/String;Ljava/lang/String;Ljava/io/File;)Ljava/io/File;
    //   552: astore 18
    //   554: aload_0
    //   555: getfield 55	com/parse/ParseCommandCache:pendingTasks	Ljava/util/HashMap;
    //   558: aload 18
    //   560: aload 5
    //   562: invokevirtual 266	java/util/HashMap:put	(Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;
    //   565: pop
    //   566: aload_1
    //   567: invokevirtual 269	com/parse/ParseCommand:retainLocalIds	()V
    //   570: aload 18
    //   572: aload 8
    //   574: invokestatic 275	com/parse/ParseFileUtils:writeByteArrayToFile	(Ljava/io/File;[B)V
    //   577: aload_0
    //   578: iconst_3
    //   579: invokevirtual 175	com/parse/ParseCommandCache:notifyTestHelper	(I)V
    //   582: aload_0
    //   583: iconst_1
    //   584: putfield 277	com/parse/ParseCommandCache:unprocessedCommandsExist	Z
    //   587: getstatic 39	com/parse/ParseCommandCache:lock	Ljava/lang/Object;
    //   590: invokevirtual 213	java/lang/Object:notifyAll	()V
    //   593: aload 9
    //   595: monitorexit
    //   596: aload 5
    //   598: invokevirtual 282	y:a	()Lm;
    //   601: astore 7
    //   603: goto -520 -> 83
    //   606: astore 12
    //   608: iconst_5
    //   609: invokestatic 166	com/parse/Parse:getLogLevel	()I
    //   612: if_icmplt +18 -> 630
    //   615: aload_0
    //   616: getfield 73	com/parse/ParseCommandCache:log	Ljava/util/logging/Logger;
    //   619: getstatic 184	java/util/logging/Level:WARNING	Ljava/util/logging/Level;
    //   622: ldc_w 284
    //   625: aload 12
    //   627: invokevirtual 189	java/util/logging/Logger:log	(Ljava/util/logging/Level;Ljava/lang/String;Ljava/lang/Throwable;)V
    //   630: getstatic 39	com/parse/ParseCommandCache:lock	Ljava/lang/Object;
    //   633: invokevirtual 213	java/lang/Object:notifyAll	()V
    //   636: goto -43 -> 593
    //   639: astore 10
    //   641: getstatic 39	com/parse/ParseCommandCache:lock	Ljava/lang/Object;
    //   644: invokevirtual 213	java/lang/Object:notifyAll	()V
    //   647: aload 10
    //   649: athrow
    //   650: aload 14
    //   652: astore 15
    //   654: goto -226 -> 428
    //   657: iload 25
    //   659: istore 26
    //   661: goto -372 -> 289
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	664	0	this	ParseCommandCache
    //   0	664	1	paramParseCommand	ParseCommand
    //   0	664	2	paramBoolean	boolean
    //   0	664	3	paramParseObject	ParseObject
    //   1	357	4	i	int
    //   11	586	5	localy	y
    //   86	19	6	localUnsupportedEncodingException	java.io.UnsupportedEncodingException
    //   81	521	7	localObject1	Object
    //   44	529	8	arrayOfByte	byte[]
    //   126	468	9	localObject2	Object
    //   639	9	10	localObject3	Object
    //   262	6	11	localObject4	Object
    //   606	20	12	localIOException	java.io.IOException
    //   138	187	13	arrayOfString	String[]
    //   368	283	14	str1	String
    //   426	227	15	str2	String
    //   431	10	16	j	int
    //   445	84	17	str3	String
    //   552	19	18	localFile1	File
    //   467	21	20	arrayOfChar1	char[]
    //   390	21	21	arrayOfChar2	char[]
    //   153	13	22	k	int
    //   156	42	23	m	int
    //   159	50	24	n	int
    //   209	449	25	i1	int
    //   289	371	26	i2	int
    //   310	13	27	localFile2	File
    //   316	40	28	i3	int
    //   332	15	29	localFile3	File
    //   343	9	30	i4	int
    //   244	3	31	localm	m
    //   173	13	32	str4	String
    // Exception table:
    //   from	to	target	type
    //   17	46	86	java/io/UnsupportedEncodingException
    //   250	267	262	finally
    //   587	596	262	finally
    //   630	650	262	finally
    //   131	246	606	java/io/IOException
    //   270	587	606	java/io/IOException
    //   131	246	639	finally
    //   270	587	639	finally
    //   608	630	639	finally
  }
  
  private static File getCacheDir()
  {
    File localFile = new File(Parse.getParseDir(), "CommandCache");
    localFile.mkdirs();
    return localFile;
  }
  
  public static int getPendingCount()
  {
    synchronized (lock)
    {
      String[] arrayOfString = getCacheDir().list();
      if (arrayOfString == null)
      {
        i = 0;
        return i;
      }
      int i = arrayOfString.length;
    }
  }
  
  /* Error */
  private void maybeRunAllCommandsNow(int paramInt)
  {
    // Byte code:
    //   0: getstatic 39	com/parse/ParseCommandCache:lock	Ljava/lang/Object;
    //   3: astore_2
    //   4: aload_2
    //   5: monitorenter
    //   6: aload_0
    //   7: iconst_0
    //   8: putfield 277	com/parse/ParseCommandCache:unprocessedCommandsExist	Z
    //   11: aload_0
    //   12: invokevirtual 303	com/parse/ParseCommandCache:isConnected	()Z
    //   15: ifne +8 -> 23
    //   18: aload_2
    //   19: monitorexit
    //   20: goto +585 -> 605
    //   23: aload_0
    //   24: getfield 79	com/parse/ParseCommandCache:cachePath	Ljava/io/File;
    //   27: invokevirtual 195	java/io/File:list	()[Ljava/lang/String;
    //   30: astore 4
    //   32: aload 4
    //   34: ifnull +9 -> 43
    //   37: aload 4
    //   39: arraylength
    //   40: ifne +13 -> 53
    //   43: aload_2
    //   44: monitorexit
    //   45: goto +560 -> 605
    //   48: astore_3
    //   49: aload_2
    //   50: monitorexit
    //   51: aload_3
    //   52: athrow
    //   53: aload 4
    //   55: invokestatic 201	java/util/Arrays:sort	([Ljava/lang/Object;)V
    //   58: aload 4
    //   60: arraylength
    //   61: istore 5
    //   63: iconst_0
    //   64: istore 6
    //   66: iload 6
    //   68: iload 5
    //   70: if_icmpge +533 -> 603
    //   73: aload 4
    //   75: iload 6
    //   77: aaload
    //   78: astore 7
    //   80: new 191	java/io/File
    //   83: dup
    //   84: aload_0
    //   85: getfield 79	com/parse/ParseCommandCache:cachePath	Ljava/io/File;
    //   88: aload 7
    //   90: invokespecial 204	java/io/File:<init>	(Ljava/io/File;Ljava/lang/String;)V
    //   93: astore 8
    //   95: new 151	org/json/JSONObject
    //   98: dup
    //   99: new 158	java/lang/String
    //   102: dup
    //   103: aload 8
    //   105: invokestatic 307	com/parse/ParseFileUtils:readFileToByteArray	(Ljava/io/File;)[B
    //   108: ldc 156
    //   110: invokespecial 310	java/lang/String:<init>	([BLjava/lang/String;)V
    //   113: invokespecial 312	org/json/JSONObject:<init>	(Ljava/lang/String;)V
    //   116: astore 9
    //   118: aload_0
    //   119: getfield 55	com/parse/ParseCommandCache:pendingTasks	Ljava/util/HashMap;
    //   122: aload 8
    //   124: invokevirtual 316	java/util/HashMap:containsKey	(Ljava/lang/Object;)Z
    //   127: ifeq +479 -> 606
    //   130: aload_0
    //   131: getfield 55	com/parse/ParseCommandCache:pendingTasks	Ljava/util/HashMap;
    //   134: aload 8
    //   136: invokevirtual 320	java/util/HashMap:get	(Ljava/lang/Object;)Ljava/lang/Object;
    //   139: checkcast 279	y
    //   142: astore 10
    //   144: new 142	com/parse/ParseCommand
    //   147: dup
    //   148: aload 9
    //   150: invokespecial 323	com/parse/ParseCommand:<init>	(Lorg/json/JSONObject;)V
    //   153: astore 11
    //   155: aload 11
    //   157: invokevirtual 326	com/parse/ParseCommand:getLocalId	()Ljava/lang/String;
    //   160: astore 18
    //   162: aload_0
    //   163: aload 11
    //   165: invokevirtual 329	com/parse/ParseCommand:executeAsync	()Lm;
    //   168: new 331	com/parse/ParseCommandCache$4
    //   171: dup
    //   172: aload_0
    //   173: aload 10
    //   175: aload 18
    //   177: invokespecial 334	com/parse/ParseCommandCache$4:<init>	(Lcom/parse/ParseCommandCache;Ly;Ljava/lang/String;)V
    //   180: invokevirtual 338	m:b	(Ll;)Lm;
    //   183: invokespecial 342	com/parse/ParseCommandCache:waitForTaskWithoutLock	(Lm;)Ljava/lang/Object;
    //   186: pop
    //   187: aload 10
    //   189: ifnull +13 -> 202
    //   192: aload_0
    //   193: aload 10
    //   195: invokevirtual 282	y:a	()Lm;
    //   198: invokespecial 342	com/parse/ParseCommandCache:waitForTaskWithoutLock	(Lm;)Ljava/lang/Object;
    //   201: pop
    //   202: aload_0
    //   203: aload 8
    //   205: invokespecial 219	com/parse/ParseCommandCache:removeFile	(Ljava/io/File;)V
    //   208: aload_0
    //   209: iconst_1
    //   210: invokevirtual 175	com/parse/ParseCommandCache:notifyTestHelper	(I)V
    //   213: iinc 6 1
    //   216: goto -150 -> 66
    //   219: astore 24
    //   221: bipush 6
    //   223: invokestatic 166	com/parse/Parse:getLogLevel	()I
    //   226: if_icmplt -13 -> 213
    //   229: aload_0
    //   230: getfield 73	com/parse/ParseCommandCache:log	Ljava/util/logging/Logger;
    //   233: getstatic 345	java/util/logging/Level:SEVERE	Ljava/util/logging/Level;
    //   236: ldc_w 347
    //   239: aload 24
    //   241: invokevirtual 189	java/util/logging/Logger:log	(Ljava/util/logging/Level;Ljava/lang/String;Ljava/lang/Throwable;)V
    //   244: goto -31 -> 213
    //   247: astore 23
    //   249: bipush 6
    //   251: invokestatic 166	com/parse/Parse:getLogLevel	()I
    //   254: if_icmplt +18 -> 272
    //   257: aload_0
    //   258: getfield 73	com/parse/ParseCommandCache:log	Ljava/util/logging/Logger;
    //   261: getstatic 345	java/util/logging/Level:SEVERE	Ljava/util/logging/Level;
    //   264: ldc_w 349
    //   267: aload 23
    //   269: invokevirtual 189	java/util/logging/Logger:log	(Ljava/util/logging/Level;Ljava/lang/String;Ljava/lang/Throwable;)V
    //   272: aload_0
    //   273: aload 8
    //   275: invokespecial 219	com/parse/ParseCommandCache:removeFile	(Ljava/io/File;)V
    //   278: goto -65 -> 213
    //   281: astore 22
    //   283: bipush 6
    //   285: invokestatic 166	com/parse/Parse:getLogLevel	()I
    //   288: if_icmplt +18 -> 306
    //   291: aload_0
    //   292: getfield 73	com/parse/ParseCommandCache:log	Ljava/util/logging/Logger;
    //   295: getstatic 345	java/util/logging/Level:SEVERE	Ljava/util/logging/Level;
    //   298: ldc_w 351
    //   301: aload 22
    //   303: invokevirtual 189	java/util/logging/Logger:log	(Ljava/util/logging/Level;Ljava/lang/String;Ljava/lang/Throwable;)V
    //   306: aload_0
    //   307: aload 8
    //   309: invokespecial 219	com/parse/ParseCommandCache:removeFile	(Ljava/io/File;)V
    //   312: goto -99 -> 213
    //   315: astore 21
    //   317: bipush 6
    //   319: invokestatic 166	com/parse/Parse:getLogLevel	()I
    //   322: if_icmplt +18 -> 340
    //   325: aload_0
    //   326: getfield 73	com/parse/ParseCommandCache:log	Ljava/util/logging/Logger;
    //   329: getstatic 345	java/util/logging/Level:SEVERE	Ljava/util/logging/Level;
    //   332: ldc_w 353
    //   335: aload 21
    //   337: invokevirtual 189	java/util/logging/Logger:log	(Ljava/util/logging/Level;Ljava/lang/String;Ljava/lang/Throwable;)V
    //   340: aload_0
    //   341: aload 8
    //   343: invokespecial 219	com/parse/ParseCommandCache:removeFile	(Ljava/io/File;)V
    //   346: goto -133 -> 213
    //   349: astore 12
    //   351: aload 12
    //   353: invokevirtual 356	com/parse/ParseException:getCode	()I
    //   356: bipush 100
    //   358: if_icmpne +208 -> 566
    //   361: iload_1
    //   362: ifle +190 -> 552
    //   365: iconst_4
    //   366: invokestatic 166	com/parse/Parse:getLogLevel	()I
    //   369: if_icmplt +49 -> 418
    //   372: aload_0
    //   373: getfield 73	com/parse/ParseCommandCache:log	Ljava/util/logging/Logger;
    //   376: new 238	java/lang/StringBuilder
    //   379: dup
    //   380: invokespecial 239	java/lang/StringBuilder:<init>	()V
    //   383: ldc_w 358
    //   386: invokevirtual 246	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   389: aload_0
    //   390: getfield 47	com/parse/ParseCommandCache:timeoutRetryWaitSeconds	D
    //   393: invokevirtual 361	java/lang/StringBuilder:append	(D)Ljava/lang/StringBuilder;
    //   396: ldc_w 363
    //   399: invokevirtual 246	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   402: iload_1
    //   403: invokevirtual 366	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   406: ldc_w 368
    //   409: invokevirtual 246	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   412: invokevirtual 247	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   415: invokevirtual 371	java/util/logging/Logger:info	(Ljava/lang/String;)V
    //   418: invokestatic 224	java/lang/System:currentTimeMillis	()J
    //   421: lstore 13
    //   423: lload 13
    //   425: ldc2_w 372
    //   428: aload_0
    //   429: getfield 47	com/parse/ParseCommandCache:timeoutRetryWaitSeconds	D
    //   432: dmul
    //   433: d2l
    //   434: ladd
    //   435: lstore 15
    //   437: lload 13
    //   439: lload 15
    //   441: lcmp
    //   442: ifge +100 -> 542
    //   445: aload_0
    //   446: invokevirtual 303	com/parse/ParseCommandCache:isConnected	()Z
    //   449: ifeq +10 -> 459
    //   452: aload_0
    //   453: getfield 61	com/parse/ParseCommandCache:shouldStop	Z
    //   456: ifeq +25 -> 481
    //   459: iconst_4
    //   460: invokestatic 166	com/parse/Parse:getLogLevel	()I
    //   463: if_icmplt +13 -> 476
    //   466: aload_0
    //   467: getfield 73	com/parse/ParseCommandCache:log	Ljava/util/logging/Logger;
    //   470: ldc_w 375
    //   473: invokevirtual 371	java/util/logging/Logger:info	(Ljava/lang/String;)V
    //   476: aload_2
    //   477: monitorexit
    //   478: goto +127 -> 605
    //   481: getstatic 39	com/parse/ParseCommandCache:lock	Ljava/lang/Object;
    //   484: lload 15
    //   486: lload 13
    //   488: lsub
    //   489: invokevirtual 379	java/lang/Object:wait	(J)V
    //   492: invokestatic 224	java/lang/System:currentTimeMillis	()J
    //   495: lstore 13
    //   497: lload 13
    //   499: lload 15
    //   501: ldc2_w 372
    //   504: aload_0
    //   505: getfield 47	com/parse/ParseCommandCache:timeoutRetryWaitSeconds	D
    //   508: dmul
    //   509: d2l
    //   510: lsub
    //   511: lcmp
    //   512: ifge -75 -> 437
    //   515: lload 15
    //   517: ldc2_w 372
    //   520: aload_0
    //   521: getfield 47	com/parse/ParseCommandCache:timeoutRetryWaitSeconds	D
    //   524: dmul
    //   525: d2l
    //   526: lsub
    //   527: lstore 13
    //   529: goto -92 -> 437
    //   532: astore 17
    //   534: aload_0
    //   535: iconst_1
    //   536: putfield 61	com/parse/ParseCommandCache:shouldStop	Z
    //   539: goto -47 -> 492
    //   542: aload_0
    //   543: iload_1
    //   544: iconst_1
    //   545: isub
    //   546: invokespecial 381	com/parse/ParseCommandCache:maybeRunAllCommandsNow	(I)V
    //   549: goto -336 -> 213
    //   552: aload_0
    //   553: iconst_0
    //   554: invokevirtual 59	com/parse/ParseCommandCache:setConnected	(Z)V
    //   557: aload_0
    //   558: bipush 7
    //   560: invokevirtual 175	com/parse/ParseCommandCache:notifyTestHelper	(I)V
    //   563: goto -350 -> 213
    //   566: bipush 6
    //   568: invokestatic 166	com/parse/Parse:getLogLevel	()I
    //   571: if_icmplt +18 -> 589
    //   574: aload_0
    //   575: getfield 73	com/parse/ParseCommandCache:log	Ljava/util/logging/Logger;
    //   578: getstatic 345	java/util/logging/Level:SEVERE	Ljava/util/logging/Level;
    //   581: ldc_w 383
    //   584: aload 12
    //   586: invokevirtual 189	java/util/logging/Logger:log	(Ljava/util/logging/Level;Ljava/lang/String;Ljava/lang/Throwable;)V
    //   589: aload_0
    //   590: aload 8
    //   592: invokespecial 219	com/parse/ParseCommandCache:removeFile	(Ljava/io/File;)V
    //   595: aload_0
    //   596: iconst_2
    //   597: invokevirtual 175	com/parse/ParseCommandCache:notifyTestHelper	(I)V
    //   600: goto -387 -> 213
    //   603: aload_2
    //   604: monitorexit
    //   605: return
    //   606: aconst_null
    //   607: astore 10
    //   609: goto -465 -> 144
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	612	0	this	ParseCommandCache
    //   0	612	1	paramInt	int
    //   3	601	2	localObject1	Object
    //   48	4	3	localObject2	Object
    //   30	44	4	arrayOfString	String[]
    //   61	10	5	i	int
    //   64	150	6	j	int
    //   78	11	7	str1	String
    //   93	498	8	localFile	File
    //   116	33	9	localJSONObject	JSONObject
    //   142	466	10	localy	y
    //   153	11	11	localParseCommand	ParseCommand
    //   349	236	12	localParseException	ParseException
    //   421	107	13	l1	long
    //   435	81	15	l2	long
    //   532	1	17	localInterruptedException	InterruptedException
    //   160	16	18	str2	String
    //   315	21	21	localJSONException1	org.json.JSONException
    //   281	21	22	localJSONException2	org.json.JSONException
    //   247	21	23	localIOException	java.io.IOException
    //   219	21	24	localFileNotFoundException	java.io.FileNotFoundException
    // Exception table:
    //   from	to	target	type
    //   6	51	48	finally
    //   53	95	48	finally
    //   95	118	48	finally
    //   118	144	48	finally
    //   144	155	48	finally
    //   155	213	48	finally
    //   221	478	48	finally
    //   481	492	48	finally
    //   492	605	48	finally
    //   95	118	219	java/io/FileNotFoundException
    //   95	118	247	java/io/IOException
    //   95	118	281	org/json/JSONException
    //   144	155	315	org/json/JSONException
    //   155	213	349	com/parse/ParseException
    //   481	492	532	java/lang/InterruptedException
  }
  
  private void removeFile(File paramFile)
  {
    synchronized (lock)
    {
      this.pendingTasks.remove(paramFile);
    }
    try
    {
      new ParseCommand(new JSONObject(new String(ParseFileUtils.readFileToByteArray(paramFile), "UTF-8"))).releaseLocalIds();
      label45:
      ParseFileUtils.deleteQuietly(paramFile);
      return;
      localObject2 = finally;
      throw localObject2;
    }
    catch (Exception localException)
    {
      break label45;
    }
  }
  
  /* Error */
  private void runLoop()
  {
    // Byte code:
    //   0: iconst_4
    //   1: invokestatic 166	com/parse/Parse:getLogLevel	()I
    //   4: if_icmplt +13 -> 17
    //   7: aload_0
    //   8: getfield 73	com/parse/ParseCommandCache:log	Ljava/util/logging/Logger;
    //   11: ldc_w 397
    //   14: invokevirtual 371	java/util/logging/Logger:info	(Ljava/lang/String;)V
    //   17: aload_0
    //   18: getfield 65	com/parse/ParseCommandCache:runningLock	Ljava/lang/Object;
    //   21: astore_1
    //   22: aload_1
    //   23: monitorenter
    //   24: aload_0
    //   25: getfield 63	com/parse/ParseCommandCache:running	Z
    //   28: ifeq +8 -> 36
    //   31: aload_1
    //   32: monitorexit
    //   33: goto +233 -> 266
    //   36: aload_0
    //   37: iconst_1
    //   38: putfield 63	com/parse/ParseCommandCache:running	Z
    //   41: aload_0
    //   42: getfield 65	com/parse/ParseCommandCache:runningLock	Ljava/lang/Object;
    //   45: invokevirtual 213	java/lang/Object:notifyAll	()V
    //   48: aload_1
    //   49: monitorexit
    //   50: getstatic 39	com/parse/ParseCommandCache:lock	Ljava/lang/Object;
    //   53: astore_3
    //   54: aload_3
    //   55: monitorenter
    //   56: aload_0
    //   57: getfield 61	com/parse/ParseCommandCache:shouldStop	Z
    //   60: ifne +88 -> 148
    //   63: invokestatic 402	java/lang/Thread:interrupted	()Z
    //   66: ifne +82 -> 148
    //   69: iconst_1
    //   70: istore 5
    //   72: aload_3
    //   73: monitorexit
    //   74: iload 5
    //   76: ifeq +138 -> 214
    //   79: getstatic 39	com/parse/ParseCommandCache:lock	Ljava/lang/Object;
    //   82: astore 8
    //   84: aload 8
    //   86: monitorenter
    //   87: aload_0
    //   88: aload_0
    //   89: getfield 43	com/parse/ParseCommandCache:timeoutMaxRetries	I
    //   92: invokespecial 381	com/parse/ParseCommandCache:maybeRunAllCommandsNow	(I)V
    //   95: aload_0
    //   96: getfield 61	com/parse/ParseCommandCache:shouldStop	Z
    //   99: istore 12
    //   101: iload 12
    //   103: ifne +16 -> 119
    //   106: aload_0
    //   107: getfield 277	com/parse/ParseCommandCache:unprocessedCommandsExist	Z
    //   110: ifne +9 -> 119
    //   113: getstatic 39	com/parse/ParseCommandCache:lock	Ljava/lang/Object;
    //   116: invokevirtual 404	java/lang/Object:wait	()V
    //   119: aload_0
    //   120: getfield 61	com/parse/ParseCommandCache:shouldStop	Z
    //   123: ifne +144 -> 267
    //   126: iconst_1
    //   127: istore 5
    //   129: aload 8
    //   131: monitorexit
    //   132: goto -58 -> 74
    //   135: astore 10
    //   137: aload 8
    //   139: monitorexit
    //   140: aload 10
    //   142: athrow
    //   143: astore_2
    //   144: aload_1
    //   145: monitorexit
    //   146: aload_2
    //   147: athrow
    //   148: iconst_0
    //   149: istore 5
    //   151: goto -79 -> 72
    //   154: astore 4
    //   156: aload_3
    //   157: monitorexit
    //   158: aload 4
    //   160: athrow
    //   161: astore 13
    //   163: aload_0
    //   164: iconst_1
    //   165: putfield 61	com/parse/ParseCommandCache:shouldStop	Z
    //   168: goto -49 -> 119
    //   171: astore 11
    //   173: bipush 6
    //   175: invokestatic 166	com/parse/Parse:getLogLevel	()I
    //   178: if_icmplt +18 -> 196
    //   181: aload_0
    //   182: getfield 73	com/parse/ParseCommandCache:log	Ljava/util/logging/Logger;
    //   185: getstatic 345	java/util/logging/Level:SEVERE	Ljava/util/logging/Level;
    //   188: ldc_w 406
    //   191: aload 11
    //   193: invokevirtual 189	java/util/logging/Logger:log	(Ljava/util/logging/Level;Ljava/lang/String;Ljava/lang/Throwable;)V
    //   196: aload_0
    //   197: getfield 61	com/parse/ParseCommandCache:shouldStop	Z
    //   200: ifne +73 -> 273
    //   203: iconst_1
    //   204: istore 5
    //   206: goto -77 -> 129
    //   209: astore 9
    //   211: aload 9
    //   213: athrow
    //   214: aload_0
    //   215: getfield 65	com/parse/ParseCommandCache:runningLock	Ljava/lang/Object;
    //   218: astore 6
    //   220: aload 6
    //   222: monitorenter
    //   223: aload_0
    //   224: iconst_0
    //   225: putfield 63	com/parse/ParseCommandCache:running	Z
    //   228: aload_0
    //   229: getfield 65	com/parse/ParseCommandCache:runningLock	Ljava/lang/Object;
    //   232: invokevirtual 213	java/lang/Object:notifyAll	()V
    //   235: aload 6
    //   237: monitorexit
    //   238: iconst_4
    //   239: invokestatic 166	com/parse/Parse:getLogLevel	()I
    //   242: if_icmplt +24 -> 266
    //   245: aload_0
    //   246: getfield 73	com/parse/ParseCommandCache:log	Ljava/util/logging/Logger;
    //   249: ldc_w 408
    //   252: invokevirtual 371	java/util/logging/Logger:info	(Ljava/lang/String;)V
    //   255: goto +11 -> 266
    //   258: astore 7
    //   260: aload 6
    //   262: monitorexit
    //   263: aload 7
    //   265: athrow
    //   266: return
    //   267: iconst_0
    //   268: istore 5
    //   270: goto -141 -> 129
    //   273: iconst_0
    //   274: istore 5
    //   276: goto -147 -> 129
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	279	0	this	ParseCommandCache
    //   21	124	1	localObject1	Object
    //   143	4	2	localObject2	Object
    //   53	104	3	localObject3	Object
    //   154	5	4	localObject4	Object
    //   70	205	5	i	int
    //   258	6	7	localObject6	Object
    //   82	56	8	localObject7	Object
    //   209	3	9	localObject8	Object
    //   135	6	10	localObject9	Object
    //   171	21	11	localException	Exception
    //   99	3	12	bool	boolean
    //   161	1	13	localInterruptedException	InterruptedException
    // Exception table:
    //   from	to	target	type
    //   119	140	135	finally
    //   196	214	135	finally
    //   24	50	143	finally
    //   144	146	143	finally
    //   56	74	154	finally
    //   156	158	154	finally
    //   106	119	161	java/lang/InterruptedException
    //   87	101	171	java/lang/Exception
    //   106	119	171	java/lang/Exception
    //   163	168	171	java/lang/Exception
    //   87	101	209	finally
    //   106	119	209	finally
    //   163	168	209	finally
    //   173	196	209	finally
    //   223	238	258	finally
    //   260	263	258	finally
  }
  
  private <T> T waitForTaskWithoutLock(m<T> paramm)
  {
    synchronized (lock)
    {
      k localk = new k(Boolean.valueOf(false));
      paramm.a(new ParseCommandCache.3(this, localk), m.a);
      for (;;)
      {
        boolean bool = ((Boolean)localk.a()).booleanValue();
        if (!bool) {
          try
          {
            lock.wait();
          }
          catch (InterruptedException localInterruptedException)
          {
            this.shouldStop = true;
          }
        }
      }
    }
    Object localObject3 = Parse.waitForTask(paramm);
    return localObject3;
  }
  
  public void clear()
  {
    synchronized (lock)
    {
      File[] arrayOfFile = this.cachePath.listFiles();
      if (arrayOfFile != null)
      {
        int i = arrayOfFile.length;
        for (int j = 0; j < i; j++) {
          removeFile(arrayOfFile[j]);
        }
        this.pendingTasks.clear();
      }
    }
  }
  
  public m<Object> enqueueEventuallyAsync(ParseCommand paramParseCommand, ParseObject paramParseObject)
  {
    return enqueueEventuallyAsync(paramParseCommand, false, paramParseObject);
  }
  
  void fakeObjectUpdate()
  {
    notifyTestHelper(3);
    notifyTestHelper(1);
    notifyTestHelper(5);
  }
  
  public void pause()
  {
    synchronized (this.runningLock)
    {
      if (this.running) {}
      synchronized (lock)
      {
        this.shouldStop = true;
        lock.notifyAll();
        for (;;)
        {
          boolean bool = this.running;
          if (bool) {
            try
            {
              this.runningLock.wait();
            }
            catch (InterruptedException localInterruptedException) {}
          }
        }
      }
    }
  }
  
  public int pendingCount()
  {
    return getPendingCount();
  }
  
  public void resume()
  {
    synchronized (this.runningLock)
    {
      if (!this.running) {
        new ParseCommandCache.2(this, "ParseCommandCache.runLoop()").start();
      }
      try
      {
        this.runningLock.wait();
        return;
      }
      catch (InterruptedException localInterruptedException)
      {
        synchronized (lock)
        {
          this.shouldStop = true;
          lock.notifyAll();
        }
      }
    }
  }
  
  public void setConnected(boolean paramBoolean)
  {
    synchronized (lock)
    {
      if ((isConnected() != paramBoolean) && (paramBoolean)) {
        lock.notifyAll();
      }
      super.setConnected(paramBoolean);
      return;
    }
  }
  
  public void setMaxCacheSizeBytes(int paramInt)
  {
    synchronized (lock)
    {
      this.maxCacheSizeBytes = paramInt;
      return;
    }
  }
  
  public void setTimeoutMaxRetries(int paramInt)
  {
    synchronized (lock)
    {
      this.timeoutMaxRetries = paramInt;
      return;
    }
  }
  
  public void setTimeoutRetryWaitSeconds(double paramDouble)
  {
    synchronized (lock)
    {
      this.timeoutRetryWaitSeconds = paramDouble;
      return;
    }
  }
  
  void simulateReboot()
  {
    synchronized (lock)
    {
      this.pendingTasks.clear();
      return;
    }
  }
}


/* Location:           C:\Users\dreadiscool\Desktop\tools\classes-dex2jar.jar
 * Qualified Name:     com.parse.ParseCommandCache
 * JD-Core Version:    0.7.0.1
 */