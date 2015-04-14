import android.app.ActivityManager.RunningAppProcessInfo;
import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.IntentFilter;
import android.content.res.Configuration;
import android.content.res.Resources;
import android.os.Environment;
import java.io.File;
import java.io.FilenameFilter;
import java.io.IOException;
import java.util.Arrays;
import java.util.Collections;
import java.util.Comparator;
import java.util.Date;
import java.util.HashSet;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;
import java.util.Locale;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Set;
import java.util.TreeMap;
import java.util.concurrent.atomic.AtomicBoolean;
import java.util.concurrent.atomic.AtomicInteger;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

class Y
  implements Thread.UncaughtExceptionHandler
{
  static final FilenameFilter a = new Z();
  static final Comparator<File> b = new af();
  static final Comparator<File> c = new ag();
  static final FilenameFilter d = new ah();
  private static final Pattern e = Pattern.compile("([\\d|A-Z|a-z]{12}\\-[\\d|A-Z|a-z]{4}\\-[\\d|A-Z|a-z]{4}\\-[\\d|A-Z|a-z]{12}).+");
  private static final Map<String, String> f = Collections.singletonMap("X-CRASHLYTICS-SEND-FLAGS", "1");
  private final AtomicInteger g = new AtomicInteger(0);
  private final AtomicBoolean h = new AtomicBoolean(false);
  private final Thread.UncaughtExceptionHandler i;
  private final File j;
  private final AtomicBoolean k;
  private final BroadcastReceiver l;
  private final BroadcastReceiver m;
  private final S n;
  private final Js o;
  private boolean p;
  private final G q;
  private final au r;
  private final aN s;
  
  Y(Thread.UncaughtExceptionHandler paramUncaughtExceptionHandler, V paramV, S paramS, Js paramJs, aN paramaN, G paramG)
  {
    this.i = paramUncaughtExceptionHandler;
    this.n = paramS;
    this.o = paramJs;
    this.q = paramG;
    this.s = paramaN;
    this.k = new AtomicBoolean(false);
    this.j = paramG.u();
    this.r = new au(paramG.C(), this.j);
    a(paramV);
    this.m = new ai(this);
    IntentFilter localIntentFilter1 = new IntentFilter("android.intent.action.ACTION_POWER_CONNECTED");
    this.l = new aj(this);
    IntentFilter localIntentFilter2 = new IntentFilter("android.intent.action.ACTION_POWER_DISCONNECTED");
    Context localContext = paramG.C();
    localContext.registerReceiver(this.m, localIntentFilter1);
    localContext.registerReceiver(this.l, localIntentFilter2);
    this.h.set(true);
  }
  
  private String a(File paramFile)
  {
    return paramFile.getName().substring(0, 35);
  }
  
  private void a(int paramInt)
  {
    int i1 = 0;
    HashSet localHashSet = new HashSet();
    File[] arrayOfFile1 = e();
    Arrays.sort(arrayOfFile1, b);
    int i2 = Math.min(paramInt, arrayOfFile1.length);
    for (int i3 = 0; i3 < i2; i3++) {
      localHashSet.add(a(arrayOfFile1[i3]));
    }
    File[] arrayOfFile2 = a(new am(null));
    int i4 = arrayOfFile2.length;
    while (i1 < i4)
    {
      File localFile = arrayOfFile2[i1];
      String str = localFile.getName();
      Matcher localMatcher = e.matcher(str);
      localMatcher.matches();
      if (!localHashSet.contains(localMatcher.group(1)))
      {
        IC.g();
        new StringBuilder().append("Trimming open session file: ").append(str).toString();
        localFile.delete();
      }
      i1++;
    }
  }
  
  private void a(C paramC)
  {
    if (paramC != null) {}
    try
    {
      paramC.a();
      return;
    }
    catch (IOException localIOException)
    {
      for (;;)
      {
        IC.g();
      }
    }
  }
  
  /* Error */
  private void a(E paramE, File paramFile)
  {
    // Byte code:
    //   0: aload_2
    //   1: invokevirtual 262	java/io/File:exists	()Z
    //   4: ifeq +96 -> 100
    //   7: aload_2
    //   8: invokevirtual 266	java/io/File:length	()J
    //   11: l2i
    //   12: newarray byte
    //   14: astore 5
    //   16: new 268	java/io/FileInputStream
    //   19: dup
    //   20: aload_2
    //   21: invokespecial 271	java/io/FileInputStream:<init>	(Ljava/io/File;)V
    //   24: astore 6
    //   26: iconst_0
    //   27: istore 7
    //   29: iload 7
    //   31: aload 5
    //   33: arraylength
    //   34: if_icmpge +35 -> 69
    //   37: aload 6
    //   39: aload 5
    //   41: iload 7
    //   43: aload 5
    //   45: arraylength
    //   46: iload 7
    //   48: isub
    //   49: invokevirtual 275	java/io/FileInputStream:read	([BII)I
    //   52: istore 9
    //   54: iload 9
    //   56: iflt +13 -> 69
    //   59: iload 7
    //   61: iload 9
    //   63: iadd
    //   64: istore 7
    //   66: goto -37 -> 29
    //   69: aload 6
    //   71: ldc_w 277
    //   74: invokestatic 282	Jg:a	(Ljava/io/Closeable;Ljava/lang/String;)V
    //   77: aload_1
    //   78: aload 5
    //   80: invokevirtual 287	E:a	([B)V
    //   83: return
    //   84: astore 8
    //   86: aconst_null
    //   87: astore 6
    //   89: aload 6
    //   91: ldc_w 277
    //   94: invokestatic 282	Jg:a	(Ljava/io/Closeable;Ljava/lang/String;)V
    //   97: aload 8
    //   99: athrow
    //   100: invokestatic 237	IC:g	()LIO;
    //   103: pop
    //   104: new 239	java/lang/StringBuilder
    //   107: dup
    //   108: invokespecial 240	java/lang/StringBuilder:<init>	()V
    //   111: ldc_w 289
    //   114: invokevirtual 246	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   117: aload_2
    //   118: invokevirtual 174	java/io/File:getName	()Ljava/lang/String;
    //   121: invokevirtual 246	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   124: invokevirtual 249	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   127: pop
    //   128: goto -45 -> 83
    //   131: astore 8
    //   133: goto -44 -> 89
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	136	0	this	Y
    //   0	136	1	paramE	E
    //   0	136	2	paramFile	File
    //   14	65	5	arrayOfByte	byte[]
    //   24	66	6	localFileInputStream	java.io.FileInputStream
    //   27	38	7	i1	int
    //   84	14	8	localObject1	Object
    //   131	1	8	localObject2	Object
    //   52	12	9	i2	int
    // Exception table:
    //   from	to	target	type
    //   16	26	84	finally
    //   29	54	131	finally
  }
  
  private void a(E paramE, String paramString)
  {
    String[] arrayOfString = new String[4];
    arrayOfString[0] = "SessionUser";
    arrayOfString[1] = "SessionApp";
    arrayOfString[2] = "SessionOS";
    arrayOfString[3] = "SessionDevice";
    int i1 = arrayOfString.length;
    int i2 = 0;
    if (i2 < i1)
    {
      String str = arrayOfString[i2];
      File[] arrayOfFile = a(new an(paramString + str));
      if (arrayOfFile.length == 0)
      {
        IC.g();
        new StringBuilder().append("Can't find ").append(str).append(" data for session ID ").append(paramString).toString();
      }
      for (;;)
      {
        i2++;
        break;
        IC.g();
        new StringBuilder().append("Collecting ").append(str).append(" data for session ID ").append(paramString).toString();
        a(paramE, arrayOfFile[0]);
      }
    }
  }
  
  private void a(E paramE, Date paramDate, Thread paramThread, Throwable paramThrowable, String paramString, boolean paramBoolean)
  {
    Context localContext = this.q.C();
    long l1 = paramDate.getTime() / 1000L;
    float f1 = Jg.c(localContext);
    int i1 = Jg.a(localContext, this.p);
    boolean bool = Jg.d(localContext);
    int i2 = localContext.getResources().getConfiguration().orientation;
    long l2 = Jg.b() - Jg.b(localContext);
    long l3 = Jg.b(Environment.getDataDirectory().getPath());
    ActivityManager.RunningAppProcessInfo localRunningAppProcessInfo = Jg.a(localContext.getPackageName(), localContext);
    LinkedList localLinkedList = new LinkedList();
    StackTraceElement[] arrayOfStackTraceElement = paramThrowable.getStackTrace();
    if (paramBoolean)
    {
      Map localMap2 = Thread.getAllStackTraces();
      arrayOfThread = new Thread[localMap2.size()];
      Iterator localIterator = localMap2.entrySet().iterator();
      for (int i3 = 0; localIterator.hasNext(); i3++)
      {
        Map.Entry localEntry = (Map.Entry)localIterator.next();
        arrayOfThread[i3] = ((Thread)localEntry.getKey());
        localLinkedList.add(localEntry.getValue());
      }
    }
    Thread[] arrayOfThread = new Thread[0];
    Object localObject;
    if (!Jg.a(localContext, "com.crashlytics.CollectCustomKeys", true)) {
      localObject = new TreeMap();
    }
    for (;;)
    {
      this.s.a(paramE, l1, paramThread, paramThrowable, paramString, arrayOfThread, f1, i1, bool, i2, l2, l3, localRunningAppProcessInfo, localLinkedList, arrayOfStackTraceElement, this.r.a(), (Map)localObject);
      return;
      Map localMap1 = this.q.g();
      if ((localMap1 != null) && (localMap1.size() > 1)) {
        localObject = new TreeMap(localMap1);
      } else {
        localObject = localMap1;
      }
    }
  }
  
  private void a(E paramE, File[] paramArrayOfFile, String paramString)
  {
    int i1 = 0;
    Arrays.sort(paramArrayOfFile, Jg.a);
    int i2 = paramArrayOfFile.length;
    for (;;)
    {
      if (i1 < i2)
      {
        File localFile = paramArrayOfFile[i1];
        try
        {
          IC.g();
          Locale localLocale = Locale.US;
          Object[] arrayOfObject = new Object[2];
          arrayOfObject[0] = paramString;
          arrayOfObject[1] = localFile.getName();
          String.format(localLocale, "Found Non Fatal for session ID %s in %s ", arrayOfObject);
          a(paramE, localFile);
          i1++;
        }
        catch (Exception localException)
        {
          for (;;)
          {
            IC.g();
          }
        }
      }
    }
  }
  
  private void a(V paramV)
  {
    IC.g();
    File localFile = new File(this.q.u(), "crash_marker");
    if (localFile.exists()) {
      localFile.delete();
    }
  }
  
  /* Error */
  private void a(br parambr)
  {
    // Byte code:
    //   0: aconst_null
    //   1: astore_2
    //   2: aload_0
    //   3: invokespecial 468	Y:j	()Ljava/lang/String;
    //   6: astore 10
    //   8: aload 10
    //   10: ifnull +68 -> 78
    //   13: new 256	C
    //   16: dup
    //   17: aload_0
    //   18: getfield 123	Y:j	Ljava/io/File;
    //   21: new 239	java/lang/StringBuilder
    //   24: dup
    //   25: invokespecial 240	java/lang/StringBuilder:<init>	()V
    //   28: aload 10
    //   30: invokevirtual 246	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   33: ldc_w 470
    //   36: invokevirtual 246	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   39: invokevirtual 249	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   42: invokespecial 471	C:<init>	(Ljava/io/File;Ljava/lang/String;)V
    //   45: astore 11
    //   47: aload 11
    //   49: invokestatic 474	E:a	(Ljava/io/OutputStream;)LE;
    //   52: astore 14
    //   54: aload 14
    //   56: astore_2
    //   57: aload_1
    //   58: aload_2
    //   59: invokestatic 479	aw:a	(Lbr;LE;)V
    //   62: aload_2
    //   63: ldc_w 481
    //   66: invokestatic 484	Jg:a	(Ljava/io/Flushable;Ljava/lang/String;)V
    //   69: aload 11
    //   71: ldc_w 486
    //   74: invokestatic 282	Jg:a	(Ljava/io/Closeable;Ljava/lang/String;)V
    //   77: return
    //   78: invokestatic 237	IC:g	()LIO;
    //   81: pop
    //   82: aconst_null
    //   83: astore 11
    //   85: goto -23 -> 62
    //   88: astore 7
    //   90: aconst_null
    //   91: astore 4
    //   93: aload 7
    //   95: astore 8
    //   97: aconst_null
    //   98: astore 6
    //   100: invokestatic 237	IC:g	()LIO;
    //   103: pop
    //   104: aload 8
    //   106: aload 4
    //   108: invokestatic 491	at:a	(Ljava/lang/Throwable;Ljava/io/OutputStream;)V
    //   111: aload 6
    //   113: ldc_w 481
    //   116: invokestatic 484	Jg:a	(Ljava/io/Flushable;Ljava/lang/String;)V
    //   119: aload 4
    //   121: ldc_w 486
    //   124: invokestatic 282	Jg:a	(Ljava/io/Closeable;Ljava/lang/String;)V
    //   127: goto -50 -> 77
    //   130: astore_3
    //   131: aconst_null
    //   132: astore 4
    //   134: aload_3
    //   135: astore 5
    //   137: aconst_null
    //   138: astore 6
    //   140: aload 6
    //   142: ldc_w 481
    //   145: invokestatic 484	Jg:a	(Ljava/io/Flushable;Ljava/lang/String;)V
    //   148: aload 4
    //   150: ldc_w 486
    //   153: invokestatic 282	Jg:a	(Ljava/io/Closeable;Ljava/lang/String;)V
    //   156: aload 5
    //   158: athrow
    //   159: astore 13
    //   161: aload 11
    //   163: astore 4
    //   165: aconst_null
    //   166: astore 6
    //   168: aload 13
    //   170: astore 5
    //   172: goto -32 -> 140
    //   175: astore 16
    //   177: aload 11
    //   179: astore 4
    //   181: aload_2
    //   182: astore 6
    //   184: aload 16
    //   186: astore 5
    //   188: goto -48 -> 140
    //   191: astore 5
    //   193: goto -53 -> 140
    //   196: astore 12
    //   198: aload 11
    //   200: astore 4
    //   202: aconst_null
    //   203: astore 6
    //   205: aload 12
    //   207: astore 8
    //   209: goto -109 -> 100
    //   212: astore 15
    //   214: aload 11
    //   216: astore 4
    //   218: aload_2
    //   219: astore 6
    //   221: aload 15
    //   223: astore 8
    //   225: goto -125 -> 100
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	228	0	this	Y
    //   0	228	1	parambr	br
    //   1	218	2	localObject1	Object
    //   130	5	3	localObject2	Object
    //   91	126	4	localObject3	Object
    //   135	52	5	localObject4	Object
    //   191	1	5	localObject5	Object
    //   98	122	6	localObject6	Object
    //   88	6	7	localException1	Exception
    //   95	129	8	localObject7	Object
    //   6	23	10	str	String
    //   45	170	11	localC	C
    //   196	10	12	localException2	Exception
    //   159	10	13	localObject8	Object
    //   52	3	14	localE	E
    //   212	10	15	localException3	Exception
    //   175	10	16	localObject9	Object
    // Exception table:
    //   from	to	target	type
    //   2	47	88	java/lang/Exception
    //   78	82	88	java/lang/Exception
    //   2	47	130	finally
    //   78	82	130	finally
    //   47	54	159	finally
    //   57	62	175	finally
    //   100	111	191	finally
    //   47	54	196	java/lang/Exception
    //   57	62	212	java/lang/Exception
  }
  
  /* Error */
  private void a(File paramFile, String paramString, int paramInt)
  {
    // Byte code:
    //   0: aconst_null
    //   1: astore 4
    //   3: invokestatic 237	IC:g	()LIO;
    //   6: pop
    //   7: new 239	java/lang/StringBuilder
    //   10: dup
    //   11: invokespecial 240	java/lang/StringBuilder:<init>	()V
    //   14: ldc_w 494
    //   17: invokevirtual 246	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   20: aload_2
    //   21: invokevirtual 246	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   24: invokevirtual 249	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   27: pop
    //   28: aload_0
    //   29: new 300	an
    //   32: dup
    //   33: new 239	java/lang/StringBuilder
    //   36: dup
    //   37: invokespecial 240	java/lang/StringBuilder:<init>	()V
    //   40: aload_2
    //   41: invokevirtual 246	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   44: ldc_w 470
    //   47: invokevirtual 246	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   50: invokevirtual 249	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   53: invokespecial 301	an:<init>	(Ljava/lang/String;)V
    //   56: invokespecial 215	Y:a	(Ljava/io/FilenameFilter;)[Ljava/io/File;
    //   59: astore 7
    //   61: aload 7
    //   63: ifnull +413 -> 476
    //   66: aload 7
    //   68: arraylength
    //   69: ifle +407 -> 476
    //   72: iconst_1
    //   73: istore 8
    //   75: invokestatic 237	IC:g	()LIO;
    //   78: pop
    //   79: getstatic 447	java/util/Locale:US	Ljava/util/Locale;
    //   82: astore 10
    //   84: iconst_2
    //   85: anewarray 4	java/lang/Object
    //   88: astore 11
    //   90: aload 11
    //   92: iconst_0
    //   93: aload_2
    //   94: aastore
    //   95: aload 11
    //   97: iconst_1
    //   98: iload 8
    //   100: invokestatic 500	java/lang/Boolean:valueOf	(Z)Ljava/lang/Boolean;
    //   103: aastore
    //   104: aload 10
    //   106: ldc_w 502
    //   109: aload 11
    //   111: invokestatic 453	java/lang/String:format	(Ljava/util/Locale;Ljava/lang/String;[Ljava/lang/Object;)Ljava/lang/String;
    //   114: pop
    //   115: aload_0
    //   116: new 300	an
    //   119: dup
    //   120: new 239	java/lang/StringBuilder
    //   123: dup
    //   124: invokespecial 240	java/lang/StringBuilder:<init>	()V
    //   127: aload_2
    //   128: invokevirtual 246	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   131: ldc_w 504
    //   134: invokevirtual 246	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   137: invokevirtual 249	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   140: invokespecial 301	an:<init>	(Ljava/lang/String;)V
    //   143: invokespecial 215	Y:a	(Ljava/io/FilenameFilter;)[Ljava/io/File;
    //   146: astore 13
    //   148: aload 13
    //   150: ifnull +332 -> 482
    //   153: aload 13
    //   155: arraylength
    //   156: ifle +326 -> 482
    //   159: iconst_1
    //   160: istore 14
    //   162: invokestatic 237	IC:g	()LIO;
    //   165: pop
    //   166: getstatic 447	java/util/Locale:US	Ljava/util/Locale;
    //   169: astore 16
    //   171: iconst_2
    //   172: anewarray 4	java/lang/Object
    //   175: astore 17
    //   177: aload 17
    //   179: iconst_0
    //   180: aload_2
    //   181: aastore
    //   182: aload 17
    //   184: iconst_1
    //   185: iload 14
    //   187: invokestatic 500	java/lang/Boolean:valueOf	(Z)Ljava/lang/Boolean;
    //   190: aastore
    //   191: aload 16
    //   193: ldc_w 506
    //   196: aload 17
    //   198: invokestatic 453	java/lang/String:format	(Ljava/util/Locale;Ljava/lang/String;[Ljava/lang/Object;)Ljava/lang/String;
    //   201: pop
    //   202: iload 8
    //   204: ifne +8 -> 212
    //   207: iload 14
    //   209: ifeq +360 -> 569
    //   212: new 256	C
    //   215: dup
    //   216: aload_0
    //   217: getfield 123	Y:j	Ljava/io/File;
    //   220: aload_2
    //   221: invokespecial 471	C:<init>	(Ljava/io/File;Ljava/lang/String;)V
    //   224: astore 19
    //   226: aload 19
    //   228: invokestatic 474	E:a	(Ljava/io/OutputStream;)LE;
    //   231: astore 27
    //   233: aload 27
    //   235: astore 21
    //   237: invokestatic 237	IC:g	()LIO;
    //   240: pop
    //   241: new 239	java/lang/StringBuilder
    //   244: dup
    //   245: invokespecial 240	java/lang/StringBuilder:<init>	()V
    //   248: ldc_w 508
    //   251: invokevirtual 246	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   254: aload_2
    //   255: invokevirtual 246	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   258: invokevirtual 249	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   261: pop
    //   262: aload_0
    //   263: aload 21
    //   265: aload_1
    //   266: invokespecial 309	Y:a	(LE;Ljava/io/File;)V
    //   269: aload 21
    //   271: iconst_4
    //   272: new 312	java/util/Date
    //   275: dup
    //   276: invokespecial 509	java/util/Date:<init>	()V
    //   279: invokevirtual 315	java/util/Date:getTime	()J
    //   282: ldc2_w 316
    //   285: ldiv
    //   286: invokevirtual 512	E:a	(IJ)V
    //   289: aload 21
    //   291: iconst_5
    //   292: iload 8
    //   294: invokevirtual 515	E:a	(IZ)V
    //   297: aload_0
    //   298: aload 21
    //   300: aload_2
    //   301: invokespecial 517	Y:a	(LE;Ljava/lang/String;)V
    //   304: iload 14
    //   306: ifeq +92 -> 398
    //   309: aload 13
    //   311: arraylength
    //   312: iload_3
    //   313: if_icmple +327 -> 640
    //   316: invokestatic 237	IC:g	()LIO;
    //   319: pop
    //   320: getstatic 447	java/util/Locale:US	Ljava/util/Locale;
    //   323: astore 32
    //   325: iconst_1
    //   326: anewarray 4	java/lang/Object
    //   329: astore 33
    //   331: aload 33
    //   333: iconst_0
    //   334: iload_3
    //   335: invokestatic 522	java/lang/Integer:valueOf	(I)Ljava/lang/Integer;
    //   338: aastore
    //   339: aload 32
    //   341: ldc_w 524
    //   344: aload 33
    //   346: invokestatic 453	java/lang/String:format	(Ljava/util/Locale;Ljava/lang/String;[Ljava/lang/Object;)Ljava/lang/String;
    //   349: pop
    //   350: aload_0
    //   351: aload_2
    //   352: iload_3
    //   353: invokespecial 527	Y:a	(Ljava/lang/String;I)V
    //   356: aload_0
    //   357: new 300	an
    //   360: dup
    //   361: new 239	java/lang/StringBuilder
    //   364: dup
    //   365: invokespecial 240	java/lang/StringBuilder:<init>	()V
    //   368: aload_2
    //   369: invokevirtual 246	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   372: ldc_w 504
    //   375: invokevirtual 246	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   378: invokevirtual 249	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   381: invokespecial 301	an:<init>	(Ljava/lang/String;)V
    //   384: invokespecial 215	Y:a	(Ljava/io/FilenameFilter;)[Ljava/io/File;
    //   387: astore 30
    //   389: aload_0
    //   390: aload 21
    //   392: aload 30
    //   394: aload_2
    //   395: invokespecial 529	Y:a	(LE;[Ljava/io/File;Ljava/lang/String;)V
    //   398: iload 8
    //   400: ifeq +13 -> 413
    //   403: aload_0
    //   404: aload 21
    //   406: aload 7
    //   408: iconst_0
    //   409: aaload
    //   410: invokespecial 309	Y:a	(LE;Ljava/io/File;)V
    //   413: aload 21
    //   415: bipush 11
    //   417: iconst_1
    //   418: invokevirtual 532	E:b	(II)V
    //   421: aload 21
    //   423: bipush 12
    //   425: iconst_3
    //   426: invokevirtual 534	E:c	(II)V
    //   429: aload 21
    //   431: ldc_w 536
    //   434: invokestatic 484	Jg:a	(Ljava/io/Flushable;Ljava/lang/String;)V
    //   437: aload 19
    //   439: ldc_w 538
    //   442: invokestatic 282	Jg:a	(Ljava/io/Closeable;Ljava/lang/String;)V
    //   445: invokestatic 237	IC:g	()LIO;
    //   448: pop
    //   449: new 239	java/lang/StringBuilder
    //   452: dup
    //   453: invokespecial 240	java/lang/StringBuilder:<init>	()V
    //   456: ldc_w 540
    //   459: invokevirtual 246	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   462: aload_2
    //   463: invokevirtual 246	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   466: invokevirtual 249	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   469: pop
    //   470: aload_0
    //   471: aload_2
    //   472: invokespecial 542	Y:a	(Ljava/lang/String;)V
    //   475: return
    //   476: iconst_0
    //   477: istore 8
    //   479: goto -404 -> 75
    //   482: iconst_0
    //   483: istore 14
    //   485: goto -323 -> 162
    //   488: astore 20
    //   490: aconst_null
    //   491: astore 21
    //   493: invokestatic 237	IC:g	()LIO;
    //   496: pop
    //   497: new 239	java/lang/StringBuilder
    //   500: dup
    //   501: invokespecial 240	java/lang/StringBuilder:<init>	()V
    //   504: ldc_w 544
    //   507: invokevirtual 246	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   510: aload_2
    //   511: invokevirtual 246	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   514: invokevirtual 249	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   517: pop
    //   518: aload 20
    //   520: aload 4
    //   522: invokestatic 491	at:a	(Ljava/lang/Throwable;Ljava/io/OutputStream;)V
    //   525: aload 21
    //   527: ldc_w 536
    //   530: invokestatic 484	Jg:a	(Ljava/io/Flushable;Ljava/lang/String;)V
    //   533: aload_0
    //   534: aload 4
    //   536: invokespecial 546	Y:a	(LC;)V
    //   539: goto -94 -> 445
    //   542: astore 22
    //   544: aconst_null
    //   545: astore 21
    //   547: aconst_null
    //   548: astore 19
    //   550: aload 21
    //   552: ldc_w 536
    //   555: invokestatic 484	Jg:a	(Ljava/io/Flushable;Ljava/lang/String;)V
    //   558: aload 19
    //   560: ldc_w 538
    //   563: invokestatic 282	Jg:a	(Ljava/io/Closeable;Ljava/lang/String;)V
    //   566: aload 22
    //   568: athrow
    //   569: invokestatic 237	IC:g	()LIO;
    //   572: pop
    //   573: new 239	java/lang/StringBuilder
    //   576: dup
    //   577: invokespecial 240	java/lang/StringBuilder:<init>	()V
    //   580: ldc_w 548
    //   583: invokevirtual 246	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   586: aload_2
    //   587: invokevirtual 246	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   590: invokevirtual 249	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   593: pop
    //   594: goto -149 -> 445
    //   597: astore 22
    //   599: aconst_null
    //   600: astore 21
    //   602: goto -52 -> 550
    //   605: astore 22
    //   607: goto -57 -> 550
    //   610: astore 22
    //   612: aload 4
    //   614: astore 19
    //   616: goto -66 -> 550
    //   619: astore 20
    //   621: aconst_null
    //   622: astore 21
    //   624: aload 19
    //   626: astore 4
    //   628: goto -135 -> 493
    //   631: astore 20
    //   633: aload 19
    //   635: astore 4
    //   637: goto -144 -> 493
    //   640: aload 13
    //   642: astore 30
    //   644: goto -255 -> 389
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	647	0	this	Y
    //   0	647	1	paramFile	File
    //   0	647	2	paramString	String
    //   0	647	3	paramInt	int
    //   1	635	4	localObject1	Object
    //   59	348	7	arrayOfFile1	File[]
    //   73	405	8	bool1	boolean
    //   82	23	10	localLocale1	Locale
    //   88	22	11	arrayOfObject1	Object[]
    //   146	495	13	arrayOfFile2	File[]
    //   160	324	14	bool2	boolean
    //   169	23	16	localLocale2	Locale
    //   175	22	17	arrayOfObject2	Object[]
    //   224	410	19	localObject2	Object
    //   488	31	20	localException1	Exception
    //   619	1	20	localException2	Exception
    //   631	1	20	localException3	Exception
    //   235	388	21	localE1	E
    //   542	25	22	localObject3	Object
    //   597	1	22	localObject4	Object
    //   605	1	22	localObject5	Object
    //   610	1	22	localObject6	Object
    //   231	3	27	localE2	E
    //   387	256	30	arrayOfFile3	File[]
    //   323	17	32	localLocale3	Locale
    //   329	16	33	arrayOfObject3	Object[]
    // Exception table:
    //   from	to	target	type
    //   212	226	488	java/lang/Exception
    //   212	226	542	finally
    //   226	233	597	finally
    //   237	429	605	finally
    //   493	525	610	finally
    //   226	233	619	java/lang/Exception
    //   237	429	631	java/lang/Exception
  }
  
  private void a(String paramString)
  {
    File[] arrayOfFile = b(paramString);
    int i1 = arrayOfFile.length;
    for (int i2 = 0; i2 < i1; i2++) {
      arrayOfFile[i2].delete();
    }
  }
  
  private void a(String paramString, int paramInt)
  {
    aP.a(this.j, new an(paramString + "SessionEvent"), paramInt, c);
  }
  
  /* Error */
  private void a(String paramString, Date paramDate)
  {
    // Byte code:
    //   0: aconst_null
    //   1: astore_3
    //   2: new 256	C
    //   5: dup
    //   6: aload_0
    //   7: getfield 123	Y:j	Ljava/io/File;
    //   10: new 239	java/lang/StringBuilder
    //   13: dup
    //   14: invokespecial 240	java/lang/StringBuilder:<init>	()V
    //   17: aload_1
    //   18: invokevirtual 246	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   21: ldc_w 559
    //   24: invokevirtual 246	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   27: invokevirtual 249	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   30: invokespecial 471	C:<init>	(Ljava/io/File;Ljava/lang/String;)V
    //   33: astore 4
    //   35: aload 4
    //   37: invokestatic 474	E:a	(Ljava/io/OutputStream;)LE;
    //   40: astore_3
    //   41: getstatic 447	java/util/Locale:US	Ljava/util/Locale;
    //   44: astore 8
    //   46: iconst_1
    //   47: anewarray 4	java/lang/Object
    //   50: astore 9
    //   52: aload 9
    //   54: iconst_0
    //   55: aload_0
    //   56: getfield 111	Y:q	LG;
    //   59: invokevirtual 561	G:d	()Ljava/lang/String;
    //   62: aastore
    //   63: aload 8
    //   65: ldc_w 563
    //   68: aload 9
    //   70: invokestatic 453	java/lang/String:format	(Ljava/util/Locale;Ljava/lang/String;[Ljava/lang/Object;)Ljava/lang/String;
    //   73: astore 10
    //   75: aload_2
    //   76: invokevirtual 315	java/util/Date:getTime	()J
    //   79: ldc2_w 316
    //   82: ldiv
    //   83: lstore 11
    //   85: aload_0
    //   86: getfield 113	Y:s	LaN;
    //   89: aload_3
    //   90: aload_1
    //   91: aload 10
    //   93: lload 11
    //   95: invokevirtual 566	aN:a	(LE;Ljava/lang/String;Ljava/lang/String;J)V
    //   98: aload_3
    //   99: ldc_w 481
    //   102: invokestatic 484	Jg:a	(Ljava/io/Flushable;Ljava/lang/String;)V
    //   105: aload 4
    //   107: ldc_w 568
    //   110: invokestatic 282	Jg:a	(Ljava/io/Closeable;Ljava/lang/String;)V
    //   113: return
    //   114: astore 5
    //   116: aconst_null
    //   117: astore 6
    //   119: aload 5
    //   121: aload 6
    //   123: invokestatic 491	at:a	(Ljava/lang/Throwable;Ljava/io/OutputStream;)V
    //   126: aload 5
    //   128: athrow
    //   129: astore 7
    //   131: aload 6
    //   133: astore 4
    //   135: aload_3
    //   136: ldc_w 481
    //   139: invokestatic 484	Jg:a	(Ljava/io/Flushable;Ljava/lang/String;)V
    //   142: aload 4
    //   144: ldc_w 568
    //   147: invokestatic 282	Jg:a	(Ljava/io/Closeable;Ljava/lang/String;)V
    //   150: aload 7
    //   152: athrow
    //   153: astore 7
    //   155: aconst_null
    //   156: astore 4
    //   158: goto -23 -> 135
    //   161: astore 7
    //   163: goto -28 -> 135
    //   166: astore 5
    //   168: aload 4
    //   170: astore 6
    //   172: goto -53 -> 119
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	175	0	this	Y
    //   0	175	1	paramString	String
    //   0	175	2	paramDate	Date
    //   1	135	3	localE	E
    //   33	136	4	localObject1	Object
    //   114	13	5	localException1	Exception
    //   166	1	5	localException2	Exception
    //   117	54	6	localObject2	Object
    //   129	22	7	localObject3	Object
    //   153	1	7	localObject4	Object
    //   161	1	7	localObject5	Object
    //   44	20	8	localLocale	Locale
    //   50	19	9	arrayOfObject	Object[]
    //   73	19	10	str	String
    //   83	11	11	l1	long
    // Exception table:
    //   from	to	target	type
    //   2	35	114	java/lang/Exception
    //   119	129	129	finally
    //   2	35	153	finally
    //   35	98	161	finally
    //   35	98	166	java/lang/Exception
  }
  
  private void a(Date paramDate, Thread paramThread, Throwable paramThrowable)
  {
    b(paramDate, paramThread, paramThrowable);
    l();
    k();
    f();
    if (!this.q.v()) {
      o();
    }
  }
  
  private File[] a(FilenameFilter paramFilenameFilter)
  {
    return b(this.j.listFiles(paramFilenameFilter));
  }
  
  /* Error */
  private void b(Date paramDate, Thread paramThread, Throwable paramThrowable)
  {
    // Byte code:
    //   0: aconst_null
    //   1: astore 4
    //   3: new 170	java/io/File
    //   6: dup
    //   7: aload_0
    //   8: getfield 123	Y:j	Ljava/io/File;
    //   11: ldc_w 455
    //   14: invokespecial 458	java/io/File:<init>	(Ljava/io/File;Ljava/lang/String;)V
    //   17: invokevirtual 593	java/io/File:createNewFile	()Z
    //   20: pop
    //   21: aload_0
    //   22: invokespecial 468	Y:j	()Ljava/lang/String;
    //   25: astore 10
    //   27: aload 10
    //   29: ifnull +83 -> 112
    //   32: aload 10
    //   34: invokestatic 594	G:a	(Ljava/lang/String;)V
    //   37: new 256	C
    //   40: dup
    //   41: aload_0
    //   42: getfield 123	Y:j	Ljava/io/File;
    //   45: new 239	java/lang/StringBuilder
    //   48: dup
    //   49: invokespecial 240	java/lang/StringBuilder:<init>	()V
    //   52: aload 10
    //   54: invokevirtual 246	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   57: ldc_w 470
    //   60: invokevirtual 246	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   63: invokevirtual 249	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   66: invokespecial 471	C:<init>	(Ljava/io/File;Ljava/lang/String;)V
    //   69: astore 6
    //   71: aload 6
    //   73: invokestatic 474	E:a	(Ljava/io/OutputStream;)LE;
    //   76: astore 4
    //   78: aload_0
    //   79: aload 4
    //   81: aload_1
    //   82: aload_2
    //   83: aload_3
    //   84: ldc_w 596
    //   87: iconst_1
    //   88: invokespecial 598	Y:a	(LE;Ljava/util/Date;Ljava/lang/Thread;Ljava/lang/Throwable;Ljava/lang/String;Z)V
    //   91: aload 6
    //   93: astore 12
    //   95: aload 4
    //   97: ldc_w 481
    //   100: invokestatic 484	Jg:a	(Ljava/io/Flushable;Ljava/lang/String;)V
    //   103: aload 12
    //   105: ldc_w 486
    //   108: invokestatic 282	Jg:a	(Ljava/io/Closeable;Ljava/lang/String;)V
    //   111: return
    //   112: invokestatic 237	IC:g	()LIO;
    //   115: pop
    //   116: aconst_null
    //   117: astore 12
    //   119: goto -24 -> 95
    //   122: astore 7
    //   124: aconst_null
    //   125: astore 6
    //   127: invokestatic 237	IC:g	()LIO;
    //   130: pop
    //   131: aload 7
    //   133: aload 6
    //   135: invokestatic 491	at:a	(Ljava/lang/Throwable;Ljava/io/OutputStream;)V
    //   138: aload 4
    //   140: ldc_w 481
    //   143: invokestatic 484	Jg:a	(Ljava/io/Flushable;Ljava/lang/String;)V
    //   146: aload 6
    //   148: ldc_w 486
    //   151: invokestatic 282	Jg:a	(Ljava/io/Closeable;Ljava/lang/String;)V
    //   154: goto -43 -> 111
    //   157: astore 5
    //   159: aconst_null
    //   160: astore 6
    //   162: aload 4
    //   164: ldc_w 481
    //   167: invokestatic 484	Jg:a	(Ljava/io/Flushable;Ljava/lang/String;)V
    //   170: aload 6
    //   172: ldc_w 486
    //   175: invokestatic 282	Jg:a	(Ljava/io/Closeable;Ljava/lang/String;)V
    //   178: aload 5
    //   180: athrow
    //   181: astore 5
    //   183: goto -21 -> 162
    //   186: astore 7
    //   188: goto -61 -> 127
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	191	0	this	Y
    //   0	191	1	paramDate	Date
    //   0	191	2	paramThread	Thread
    //   0	191	3	paramThrowable	Throwable
    //   1	162	4	localE	E
    //   157	22	5	localObject1	Object
    //   181	1	5	localObject2	Object
    //   69	102	6	localC1	C
    //   122	10	7	localException1	Exception
    //   186	1	7	localException2	Exception
    //   25	28	10	str	String
    //   93	25	12	localC2	C
    // Exception table:
    //   from	to	target	type
    //   3	71	122	java/lang/Exception
    //   112	116	122	java/lang/Exception
    //   3	71	157	finally
    //   112	116	157	finally
    //   71	91	181	finally
    //   127	138	181	finally
    //   71	91	186	java/lang/Exception
  }
  
  private File[] b(String paramString)
  {
    return a(new ao(paramString));
  }
  
  private File[] b(File[] paramArrayOfFile)
  {
    if (paramArrayOfFile == null) {
      paramArrayOfFile = new File[0];
    }
    return paramArrayOfFile;
  }
  
  /* Error */
  private void c(String paramString)
  {
    // Byte code:
    //   0: aconst_null
    //   1: astore_2
    //   2: new 256	C
    //   5: dup
    //   6: aload_0
    //   7: getfield 123	Y:j	Ljava/io/File;
    //   10: new 239	java/lang/StringBuilder
    //   13: dup
    //   14: invokespecial 240	java/lang/StringBuilder:<init>	()V
    //   17: aload_1
    //   18: invokevirtual 246	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   21: ldc_w 294
    //   24: invokevirtual 246	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   27: invokevirtual 249	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   30: invokespecial 471	C:<init>	(Ljava/io/File;Ljava/lang/String;)V
    //   33: astore_3
    //   34: aload_3
    //   35: invokestatic 474	E:a	(Ljava/io/OutputStream;)LE;
    //   38: astore_2
    //   39: aload_0
    //   40: getfield 111	Y:q	LG;
    //   43: invokevirtual 603	G:h	()Ljava/lang/String;
    //   46: astore 7
    //   48: aload_0
    //   49: getfield 111	Y:q	LG;
    //   52: invokevirtual 605	G:k	()Ljava/lang/String;
    //   55: astore 8
    //   57: aload_0
    //   58: getfield 111	Y:q	LG;
    //   61: invokevirtual 606	G:j	()Ljava/lang/String;
    //   64: astore 9
    //   66: aload_0
    //   67: getfield 109	Y:o	LJs;
    //   70: invokevirtual 610	Js:b	()Ljava/lang/String;
    //   73: astore 10
    //   75: aload_0
    //   76: getfield 111	Y:q	LG;
    //   79: invokevirtual 612	G:i	()Ljava/lang/String;
    //   82: invokestatic 617	Jm:a	(Ljava/lang/String;)LJm;
    //   85: invokevirtual 619	Jm:a	()I
    //   88: istore 11
    //   90: aload_0
    //   91: getfield 113	Y:s	LaN;
    //   94: aload_2
    //   95: aload 7
    //   97: aload 8
    //   99: aload 9
    //   101: aload 10
    //   103: iload 11
    //   105: invokevirtual 622	aN:a	(LE;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;I)V
    //   108: aload_2
    //   109: ldc_w 624
    //   112: invokestatic 484	Jg:a	(Ljava/io/Flushable;Ljava/lang/String;)V
    //   115: aload_3
    //   116: ldc_w 626
    //   119: invokestatic 282	Jg:a	(Ljava/io/Closeable;Ljava/lang/String;)V
    //   122: return
    //   123: astore 4
    //   125: aconst_null
    //   126: astore 5
    //   128: aload 4
    //   130: aload 5
    //   132: invokestatic 491	at:a	(Ljava/lang/Throwable;Ljava/io/OutputStream;)V
    //   135: aload 4
    //   137: athrow
    //   138: astore 6
    //   140: aload 5
    //   142: astore_3
    //   143: aload_2
    //   144: ldc_w 624
    //   147: invokestatic 484	Jg:a	(Ljava/io/Flushable;Ljava/lang/String;)V
    //   150: aload_3
    //   151: ldc_w 626
    //   154: invokestatic 282	Jg:a	(Ljava/io/Closeable;Ljava/lang/String;)V
    //   157: aload 6
    //   159: athrow
    //   160: astore 6
    //   162: aconst_null
    //   163: astore_3
    //   164: goto -21 -> 143
    //   167: astore 6
    //   169: goto -26 -> 143
    //   172: astore 4
    //   174: aload_3
    //   175: astore 5
    //   177: goto -49 -> 128
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	180	0	this	Y
    //   0	180	1	paramString	String
    //   1	143	2	localE	E
    //   33	142	3	localObject1	Object
    //   123	13	4	localException1	Exception
    //   172	1	4	localException2	Exception
    //   126	50	5	localObject2	Object
    //   138	20	6	localObject3	Object
    //   160	1	6	localObject4	Object
    //   167	1	6	localObject5	Object
    //   46	50	7	str1	String
    //   55	43	8	str2	String
    //   64	36	9	str3	String
    //   73	29	10	str4	String
    //   88	16	11	i1	int
    // Exception table:
    //   from	to	target	type
    //   2	34	123	java/lang/Exception
    //   128	138	138	finally
    //   2	34	160	finally
    //   34	108	167	finally
    //   34	108	172	java/lang/Exception
  }
  
  /* Error */
  private void d(String paramString)
  {
    // Byte code:
    //   0: aconst_null
    //   1: astore_2
    //   2: new 256	C
    //   5: dup
    //   6: aload_0
    //   7: getfield 123	Y:j	Ljava/io/File;
    //   10: new 239	java/lang/StringBuilder
    //   13: dup
    //   14: invokespecial 240	java/lang/StringBuilder:<init>	()V
    //   17: aload_1
    //   18: invokevirtual 246	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   21: ldc_w 296
    //   24: invokevirtual 246	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   27: invokevirtual 249	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   30: invokespecial 471	C:<init>	(Ljava/io/File;Ljava/lang/String;)V
    //   33: astore_3
    //   34: aload_3
    //   35: invokestatic 474	E:a	(Ljava/io/OutputStream;)LE;
    //   38: astore_2
    //   39: aload_0
    //   40: getfield 111	Y:q	LG;
    //   43: invokevirtual 129	G:C	()Landroid/content/Context;
    //   46: invokestatic 629	Jg:g	(Landroid/content/Context;)Z
    //   49: istore 6
    //   51: aload_0
    //   52: getfield 113	Y:s	LaN;
    //   55: aload_2
    //   56: iload 6
    //   58: invokevirtual 632	aN:a	(LE;Z)V
    //   61: aload_2
    //   62: ldc_w 634
    //   65: invokestatic 484	Jg:a	(Ljava/io/Flushable;Ljava/lang/String;)V
    //   68: aload_3
    //   69: ldc_w 636
    //   72: invokestatic 282	Jg:a	(Ljava/io/Closeable;Ljava/lang/String;)V
    //   75: return
    //   76: astore 4
    //   78: aconst_null
    //   79: astore_3
    //   80: aload 4
    //   82: aload_3
    //   83: invokestatic 491	at:a	(Ljava/lang/Throwable;Ljava/io/OutputStream;)V
    //   86: aload 4
    //   88: athrow
    //   89: astore 5
    //   91: aload_2
    //   92: ldc_w 634
    //   95: invokestatic 484	Jg:a	(Ljava/io/Flushable;Ljava/lang/String;)V
    //   98: aload_3
    //   99: ldc_w 636
    //   102: invokestatic 282	Jg:a	(Ljava/io/Closeable;Ljava/lang/String;)V
    //   105: aload 5
    //   107: athrow
    //   108: astore 5
    //   110: aconst_null
    //   111: astore_3
    //   112: goto -21 -> 91
    //   115: astore 4
    //   117: goto -37 -> 80
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	120	0	this	Y
    //   0	120	1	paramString	String
    //   1	91	2	localE	E
    //   33	79	3	localC	C
    //   76	11	4	localException1	Exception
    //   115	1	4	localException2	Exception
    //   89	17	5	localObject1	Object
    //   108	1	5	localObject2	Object
    //   49	8	6	bool	boolean
    // Exception table:
    //   from	to	target	type
    //   2	34	76	java/lang/Exception
    //   34	61	89	finally
    //   80	89	89	finally
    //   2	34	108	finally
    //   34	61	115	java/lang/Exception
  }
  
  /* Error */
  private void e(String paramString)
  {
    // Byte code:
    //   0: aconst_null
    //   1: astore_2
    //   2: aconst_null
    //   3: astore_3
    //   4: aload_0
    //   5: getfield 123	Y:j	Ljava/io/File;
    //   8: astore 7
    //   10: new 239	java/lang/StringBuilder
    //   13: dup
    //   14: invokespecial 240	java/lang/StringBuilder:<init>	()V
    //   17: aload_1
    //   18: invokevirtual 246	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   21: ldc_w 298
    //   24: invokevirtual 246	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   27: invokevirtual 249	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   30: astore 8
    //   32: new 256	C
    //   35: dup
    //   36: aload 7
    //   38: aload 8
    //   40: invokespecial 471	C:<init>	(Ljava/io/File;Ljava/lang/String;)V
    //   43: astore 5
    //   45: aload 5
    //   47: invokestatic 474	E:a	(Ljava/io/OutputStream;)LE;
    //   50: astore_3
    //   51: aload_0
    //   52: getfield 111	Y:q	LG;
    //   55: invokevirtual 129	G:C	()Landroid/content/Context;
    //   58: astore 9
    //   60: new 638	android/os/StatFs
    //   63: dup
    //   64: invokestatic 354	android/os/Environment:getDataDirectory	()Ljava/io/File;
    //   67: invokevirtual 357	java/io/File:getPath	()Ljava/lang/String;
    //   70: invokespecial 639	android/os/StatFs:<init>	(Ljava/lang/String;)V
    //   73: astore 10
    //   75: aload_0
    //   76: getfield 109	Y:o	LJs;
    //   79: invokevirtual 641	Js:f	()Ljava/lang/String;
    //   82: astore 11
    //   84: invokestatic 642	Jg:a	()I
    //   87: istore 12
    //   89: invokestatic 648	java/lang/Runtime:getRuntime	()Ljava/lang/Runtime;
    //   92: invokevirtual 651	java/lang/Runtime:availableProcessors	()I
    //   95: istore 13
    //   97: invokestatic 346	Jg:b	()J
    //   100: lstore 14
    //   102: aload 10
    //   104: invokevirtual 654	android/os/StatFs:getBlockCount	()I
    //   107: i2l
    //   108: aload 10
    //   110: invokevirtual 657	android/os/StatFs:getBlockSize	()I
    //   113: i2l
    //   114: lmul
    //   115: lstore 16
    //   117: aload 9
    //   119: invokestatic 659	Jg:f	(Landroid/content/Context;)Z
    //   122: istore 18
    //   124: aload_0
    //   125: getfield 109	Y:o	LJs;
    //   128: invokevirtual 660	Js:g	()Ljava/util/Map;
    //   131: astore 19
    //   133: aload 9
    //   135: invokestatic 663	Jg:h	(Landroid/content/Context;)I
    //   138: istore 20
    //   140: aload_0
    //   141: getfield 113	Y:s	LaN;
    //   144: aload_3
    //   145: aload 11
    //   147: iload 12
    //   149: getstatic 669	android/os/Build:MODEL	Ljava/lang/String;
    //   152: iload 13
    //   154: lload 14
    //   156: lload 16
    //   158: iload 18
    //   160: aload 19
    //   162: iload 20
    //   164: getstatic 672	android/os/Build:MANUFACTURER	Ljava/lang/String;
    //   167: getstatic 675	android/os/Build:PRODUCT	Ljava/lang/String;
    //   170: invokevirtual 678	aN:a	(LE;Ljava/lang/String;ILjava/lang/String;IJJZLjava/util/Map;ILjava/lang/String;Ljava/lang/String;)V
    //   173: aload_3
    //   174: ldc_w 680
    //   177: invokestatic 484	Jg:a	(Ljava/io/Flushable;Ljava/lang/String;)V
    //   180: aload 5
    //   182: ldc_w 682
    //   185: invokestatic 282	Jg:a	(Ljava/io/Closeable;Ljava/lang/String;)V
    //   188: return
    //   189: astore 6
    //   191: aload 6
    //   193: aload_2
    //   194: invokestatic 491	at:a	(Ljava/lang/Throwable;Ljava/io/OutputStream;)V
    //   197: aload 6
    //   199: athrow
    //   200: astore 4
    //   202: aload_2
    //   203: astore 5
    //   205: aload_3
    //   206: ldc_w 680
    //   209: invokestatic 484	Jg:a	(Ljava/io/Flushable;Ljava/lang/String;)V
    //   212: aload 5
    //   214: ldc_w 682
    //   217: invokestatic 282	Jg:a	(Ljava/io/Closeable;Ljava/lang/String;)V
    //   220: aload 4
    //   222: athrow
    //   223: astore 4
    //   225: aconst_null
    //   226: astore 5
    //   228: goto -23 -> 205
    //   231: astore 4
    //   233: goto -28 -> 205
    //   236: astore 6
    //   238: aload 5
    //   240: astore_2
    //   241: goto -50 -> 191
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	244	0	this	Y
    //   0	244	1	paramString	String
    //   1	240	2	localObject1	Object
    //   3	203	3	localE	E
    //   200	21	4	localObject2	Object
    //   223	1	4	localObject3	Object
    //   231	1	4	localObject4	Object
    //   43	196	5	localObject5	Object
    //   189	9	6	localException1	Exception
    //   236	1	6	localException2	Exception
    //   8	29	7	localFile	File
    //   30	9	8	str1	String
    //   58	76	9	localContext	Context
    //   73	36	10	localStatFs	android.os.StatFs
    //   82	64	11	str2	String
    //   87	61	12	i1	int
    //   95	58	13	i2	int
    //   100	55	14	l1	long
    //   115	42	16	l2	long
    //   122	37	18	bool	boolean
    //   131	30	19	localMap	Map
    //   138	25	20	i3	int
    // Exception table:
    //   from	to	target	type
    //   4	45	189	java/lang/Exception
    //   191	200	200	finally
    //   4	45	223	finally
    //   45	173	231	finally
    //   45	173	236	java/lang/Exception
  }
  
  /* Error */
  private void f(String paramString)
  {
    // Byte code:
    //   0: aconst_null
    //   1: astore_2
    //   2: new 256	C
    //   5: dup
    //   6: aload_0
    //   7: getfield 123	Y:j	Ljava/io/File;
    //   10: new 239	java/lang/StringBuilder
    //   13: dup
    //   14: invokespecial 240	java/lang/StringBuilder:<init>	()V
    //   17: aload_1
    //   18: invokevirtual 246	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   21: ldc_w 292
    //   24: invokevirtual 246	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   27: invokevirtual 249	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   30: invokespecial 471	C:<init>	(Ljava/io/File;Ljava/lang/String;)V
    //   33: astore_3
    //   34: aload_3
    //   35: invokestatic 474	E:a	(Ljava/io/OutputStream;)LE;
    //   38: astore_2
    //   39: aload_0
    //   40: getfield 111	Y:q	LG;
    //   43: invokevirtual 684	G:n	()Ljava/lang/String;
    //   46: astore 6
    //   48: aload_0
    //   49: getfield 111	Y:q	LG;
    //   52: invokevirtual 686	G:p	()Ljava/lang/String;
    //   55: astore 7
    //   57: aload_0
    //   58: getfield 111	Y:q	LG;
    //   61: invokevirtual 688	G:o	()Ljava/lang/String;
    //   64: astore 8
    //   66: aload 6
    //   68: ifnonnull +28 -> 96
    //   71: aload 7
    //   73: ifnonnull +23 -> 96
    //   76: aload 8
    //   78: ifnonnull +18 -> 96
    //   81: aload_2
    //   82: ldc_w 690
    //   85: invokestatic 484	Jg:a	(Ljava/io/Flushable;Ljava/lang/String;)V
    //   88: aload_3
    //   89: ldc_w 692
    //   92: invokestatic 282	Jg:a	(Ljava/io/Closeable;Ljava/lang/String;)V
    //   95: return
    //   96: aload_0
    //   97: getfield 113	Y:s	LaN;
    //   100: aload_2
    //   101: aload 6
    //   103: aload 7
    //   105: aload 8
    //   107: invokevirtual 695	aN:a	(LE;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;)V
    //   110: aload_2
    //   111: ldc_w 690
    //   114: invokestatic 484	Jg:a	(Ljava/io/Flushable;Ljava/lang/String;)V
    //   117: aload_3
    //   118: ldc_w 692
    //   121: invokestatic 282	Jg:a	(Ljava/io/Closeable;Ljava/lang/String;)V
    //   124: goto -29 -> 95
    //   127: astore 4
    //   129: aconst_null
    //   130: astore_3
    //   131: aload 4
    //   133: aload_3
    //   134: invokestatic 491	at:a	(Ljava/lang/Throwable;Ljava/io/OutputStream;)V
    //   137: aload 4
    //   139: athrow
    //   140: astore 5
    //   142: aload_2
    //   143: ldc_w 690
    //   146: invokestatic 484	Jg:a	(Ljava/io/Flushable;Ljava/lang/String;)V
    //   149: aload_3
    //   150: ldc_w 692
    //   153: invokestatic 282	Jg:a	(Ljava/io/Closeable;Ljava/lang/String;)V
    //   156: aload 5
    //   158: athrow
    //   159: astore 5
    //   161: aconst_null
    //   162: astore_3
    //   163: goto -21 -> 142
    //   166: astore 4
    //   168: goto -37 -> 131
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	171	0	this	Y
    //   0	171	1	paramString	String
    //   1	142	2	localE	E
    //   33	130	3	localC	C
    //   127	11	4	localException1	Exception
    //   166	1	4	localException2	Exception
    //   140	17	5	localObject1	Object
    //   159	1	5	localObject2	Object
    //   46	56	6	str1	String
    //   55	49	7	str2	String
    //   64	42	8	str3	String
    // Exception table:
    //   from	to	target	type
    //   2	34	127	java/lang/Exception
    //   34	66	140	finally
    //   96	110	140	finally
    //   131	140	140	finally
    //   2	34	159	finally
    //   34	66	166	java/lang/Exception
    //   96	110	166	java/lang/Exception
  }
  
  private String j()
  {
    File[] arrayOfFile = a(new an("BeginSession"));
    Arrays.sort(arrayOfFile, b);
    if (arrayOfFile.length > 0) {}
    for (String str = a(arrayOfFile[0]);; str = null) {
      return str;
    }
  }
  
  private void k()
  {
    Date localDate = new Date();
    String str = new B(this.o).toString();
    IC.g();
    new StringBuilder().append("Opening an new session with ID ").append(str).toString();
    a(str, localDate);
    c(str);
    d(str);
    e(str);
  }
  
  private void l()
  {
    a(8);
    String str1 = j();
    if (str1 != null)
    {
      f(str1);
      Lh localLh = this.q.y();
      if (localLh != null)
      {
        int i1 = localLh.c;
        IC.g();
        File[] arrayOfFile = e();
        if ((arrayOfFile != null) && (arrayOfFile.length > 0))
        {
          int i2 = arrayOfFile.length;
          for (int i3 = 0; i3 < i2; i3++)
          {
            File localFile = arrayOfFile[i3];
            String str2 = a(localFile);
            IC.g();
            new StringBuilder().append("Closing session: ").append(str2).toString();
            a(localFile, str2, i1);
          }
        }
      }
      else
      {
        IC.g();
      }
    }
    for (;;)
    {
      return;
      IC.g();
    }
  }
  
  private File[] m()
  {
    return a(a);
  }
  
  private void n()
  {
    File localFile = new File(this.q.u(), "invalidClsFiles");
    if (localFile.exists())
    {
      if (localFile.isDirectory())
      {
        File[] arrayOfFile = localFile.listFiles();
        int i1 = arrayOfFile.length;
        for (int i2 = 0; i2 < i1; i2++) {
          arrayOfFile[i2].delete();
        }
      }
      localFile.delete();
    }
  }
  
  private void o()
  {
    for (File localFile : m()) {
      this.n.a(new ae(this, localFile));
    }
  }
  
  void a(long paramLong, String paramString)
  {
    this.n.b(new al(this, paramLong, paramString));
  }
  
  void a(File[] paramArrayOfFile)
  {
    n();
    int i1 = paramArrayOfFile.length;
    for (int i2 = 0; i2 < i1; i2++)
    {
      File localFile1 = paramArrayOfFile[i2];
      IC.g();
      new StringBuilder().append("Found invalid session part file: ").append(localFile1).toString();
      String str = a(localFile1);
      ad localad = new ad(this, str);
      IC.g();
      new StringBuilder().append("Deleting all part files for invalid session: ").append(str).toString();
      for (File localFile2 : a(localad))
      {
        IC.g();
        new StringBuilder().append("Deleting session file: ").append(localFile2).toString();
        localFile2.delete();
      }
    }
  }
  
  boolean a()
  {
    return this.k.get();
  }
  
  void b()
  {
    this.n.b(new aa(this));
  }
  
  boolean c()
  {
    if (e().length > 0) {}
    for (boolean bool = true;; bool = false) {
      return bool;
    }
  }
  
  boolean d()
  {
    return ((Boolean)this.n.a(new ab(this))).booleanValue();
  }
  
  File[] e()
  {
    return a(new an("BeginSession"));
  }
  
  void f()
  {
    aP.a(this.j, a, 4, c);
  }
  
  void g()
  {
    this.n.a(new ac(this));
  }
  
  /* Error */
  public void uncaughtException(Thread paramThread, Throwable paramThrowable)
  {
    // Byte code:
    //   0: aload_0
    //   1: monitorenter
    //   2: aload_0
    //   3: getfield 115	Y:k	Ljava/util/concurrent/atomic/AtomicBoolean;
    //   6: iconst_1
    //   7: invokevirtual 167	java/util/concurrent/atomic/AtomicBoolean:set	(Z)V
    //   10: invokestatic 237	IC:g	()LIO;
    //   13: pop
    //   14: new 239	java/lang/StringBuilder
    //   17: dup
    //   18: invokespecial 240	java/lang/StringBuilder:<init>	()V
    //   21: ldc_w 795
    //   24: invokevirtual 246	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   27: aload_2
    //   28: invokevirtual 764	java/lang/StringBuilder:append	(Ljava/lang/Object;)Ljava/lang/StringBuilder;
    //   31: ldc_w 797
    //   34: invokevirtual 246	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   37: aload_1
    //   38: invokevirtual 798	java/lang/Thread:getName	()Ljava/lang/String;
    //   41: invokevirtual 246	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   44: invokevirtual 249	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   47: pop
    //   48: aload_0
    //   49: getfield 103	Y:h	Ljava/util/concurrent/atomic/AtomicBoolean;
    //   52: iconst_1
    //   53: invokevirtual 802	java/util/concurrent/atomic/AtomicBoolean:getAndSet	(Z)Z
    //   56: ifne +34 -> 90
    //   59: invokestatic 237	IC:g	()LIO;
    //   62: pop
    //   63: aload_0
    //   64: getfield 111	Y:q	LG;
    //   67: invokevirtual 129	G:C	()Landroid/content/Context;
    //   70: astore 15
    //   72: aload 15
    //   74: aload_0
    //   75: getfield 144	Y:m	Landroid/content/BroadcastReceiver;
    //   78: invokevirtual 806	android/content/Context:unregisterReceiver	(Landroid/content/BroadcastReceiver;)V
    //   81: aload 15
    //   83: aload_0
    //   84: getfield 156	Y:l	Landroid/content/BroadcastReceiver;
    //   87: invokevirtual 806	android/content/Context:unregisterReceiver	(Landroid/content/BroadcastReceiver;)V
    //   90: new 312	java/util/Date
    //   93: dup
    //   94: invokespecial 509	java/util/Date:<init>	()V
    //   97: astore 11
    //   99: aload_0
    //   100: getfield 107	Y:n	LS;
    //   103: new 808	ak
    //   106: dup
    //   107: aload_0
    //   108: aload 11
    //   110: aload_1
    //   111: aload_2
    //   112: invokespecial 810	ak:<init>	(LY;Ljava/util/Date;Ljava/lang/Thread;Ljava/lang/Throwable;)V
    //   115: invokevirtual 785	S:a	(Ljava/util/concurrent/Callable;)Ljava/lang/Object;
    //   118: pop
    //   119: invokestatic 237	IC:g	()LIO;
    //   122: pop
    //   123: aload_0
    //   124: getfield 105	Y:i	Ljava/lang/Thread$UncaughtExceptionHandler;
    //   127: aload_1
    //   128: aload_2
    //   129: invokeinterface 812 3 0
    //   134: aload_0
    //   135: getfield 115	Y:k	Ljava/util/concurrent/atomic/AtomicBoolean;
    //   138: iconst_0
    //   139: invokevirtual 167	java/util/concurrent/atomic/AtomicBoolean:set	(Z)V
    //   142: aload_0
    //   143: monitorexit
    //   144: return
    //   145: astore 6
    //   147: invokestatic 237	IC:g	()LIO;
    //   150: pop
    //   151: invokestatic 237	IC:g	()LIO;
    //   154: pop
    //   155: aload_0
    //   156: getfield 105	Y:i	Ljava/lang/Thread$UncaughtExceptionHandler;
    //   159: aload_1
    //   160: aload_2
    //   161: invokeinterface 812 3 0
    //   166: aload_0
    //   167: getfield 115	Y:k	Ljava/util/concurrent/atomic/AtomicBoolean;
    //   170: iconst_0
    //   171: invokevirtual 167	java/util/concurrent/atomic/AtomicBoolean:set	(Z)V
    //   174: goto -32 -> 142
    //   177: astore_3
    //   178: aload_0
    //   179: monitorexit
    //   180: aload_3
    //   181: athrow
    //   182: astore 4
    //   184: invokestatic 237	IC:g	()LIO;
    //   187: pop
    //   188: aload_0
    //   189: getfield 105	Y:i	Ljava/lang/Thread$UncaughtExceptionHandler;
    //   192: aload_1
    //   193: aload_2
    //   194: invokeinterface 812 3 0
    //   199: aload_0
    //   200: getfield 115	Y:k	Ljava/util/concurrent/atomic/AtomicBoolean;
    //   203: iconst_0
    //   204: invokevirtual 167	java/util/concurrent/atomic/AtomicBoolean:set	(Z)V
    //   207: aload 4
    //   209: athrow
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	210	0	this	Y
    //   0	210	1	paramThread	Thread
    //   0	210	2	paramThrowable	Throwable
    //   177	4	3	localObject1	Object
    //   182	26	4	localObject2	Object
    //   145	1	6	localException	Exception
    //   97	12	11	localDate	Date
    //   70	12	15	localContext	Context
    // Exception table:
    //   from	to	target	type
    //   10	119	145	java/lang/Exception
    //   2	10	177	finally
    //   119	142	177	finally
    //   151	174	177	finally
    //   184	210	177	finally
    //   10	119	182	finally
    //   147	151	182	finally
  }
}


/* Location:           C:\Users\dreadiscool\Desktop\tools\classes-dex2jar.jar
 * Qualified Name:     Y
 * JD-Core Version:    0.7.0.1
 */