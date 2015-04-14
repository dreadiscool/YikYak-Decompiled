import android.content.Context;
import android.content.SharedPreferences;
import android.content.SharedPreferences.Editor;
import android.location.Location;

public class wW
{
  private static wW b = null;
  private String A = null;
  private String B = null;
  private String C = null;
  private String D = null;
  private String E = null;
  private String F = null;
  private String G = null;
  private String H = null;
  private String I = null;
  private String J = null;
  private String K = null;
  private String L = null;
  private String M = null;
  private String N = null;
  private String O = null;
  private String P = null;
  private String Q = null;
  private String R = null;
  private String S = null;
  private Location T = null;
  private String U = null;
  private String V = null;
  private String W = null;
  private String X = null;
  private String Y = null;
  private String Z = null;
  private Context a;
  private String aA = null;
  private String aB = null;
  private String aC = null;
  private String aD = null;
  private String aE = null;
  private String aF = null;
  private String aG = null;
  private String aH = null;
  private String aa = null;
  private String ab = null;
  private String ac = null;
  private String ad = null;
  private String ae = null;
  private String af = null;
  private String ag = null;
  private String ah = null;
  private String ai = null;
  private String aj = null;
  private String ak = null;
  private String al = null;
  private String am = null;
  private String an = null;
  private String ao = null;
  private String ap = null;
  private String aq = null;
  private String ar = null;
  private String as = null;
  private String at = null;
  private String au = null;
  private String av = null;
  private String aw = null;
  private String ax = null;
  private String ay = null;
  private String az = null;
  private String c = null;
  private String d = null;
  private String e = null;
  private String f = null;
  private String g = null;
  private String h = null;
  private String i = null;
  private String j = null;
  private String k = null;
  private String l = null;
  private String m = null;
  private String n = null;
  private String o = null;
  private String p = null;
  private String q = null;
  private String r = null;
  private String s = null;
  private String t = null;
  private String u = null;
  private String v = null;
  private String w = null;
  private String x = null;
  private String y = null;
  private String z = null;
  
  private String a(String paramString1, String paramString2)
  {
    try
    {
      String str = this.a.getSharedPreferences(paramString1, 0).getString(paramString2, "");
      return str;
    }
    finally
    {
      localObject = finally;
      throw localObject;
    }
  }
  
  public static wW a()
  {
    return b;
  }
  
  public static void a(Context paramContext, String paramString1, String paramString2)
  {
    if (b == null)
    {
      wW localwW = new wW();
      b = localwW;
      localwW.a = paramContext;
      b.a(paramContext, paramString1);
    }
  }
  
  private void a(String paramString1, String paramString2, String paramString3)
  {
    try
    {
      this.a.getSharedPreferences(paramString1, 0).edit().putString(paramString2, paramString3).commit();
      return;
    }
    finally
    {
      localObject = finally;
      throw localObject;
    }
  }
  
  /* Error */
  private boolean a(Context paramContext, String paramString)
  {
    // Byte code:
    //   0: aload_0
    //   1: monitorenter
    //   2: aload_0
    //   3: aload_2
    //   4: invokevirtual 319	java/lang/String:trim	()Ljava/lang/String;
    //   7: invokevirtual 322	wW:b	(Ljava/lang/String;)V
    //   10: aload_0
    //   11: ldc_w 324
    //   14: invokevirtual 326	wW:h	(Ljava/lang/String;)V
    //   17: new 328	android/os/Handler
    //   20: dup
    //   21: invokestatic 334	android/os/Looper:getMainLooper	()Landroid/os/Looper;
    //   24: invokespecial 337	android/os/Handler:<init>	(Landroid/os/Looper;)V
    //   27: new 339	xa
    //   30: dup
    //   31: aload_0
    //   32: aload_0
    //   33: getfield 272	wW:a	Landroid/content/Context;
    //   36: invokespecial 342	xa:<init>	(LwW;Landroid/content/Context;)V
    //   39: invokevirtual 346	android/os/Handler:post	(Ljava/lang/Runnable;)Z
    //   42: pop
    //   43: aload_0
    //   44: getfield 272	wW:a	Landroid/content/Context;
    //   47: invokevirtual 349	android/content/Context:getPackageName	()Ljava/lang/String;
    //   50: astore 7
    //   52: aload_0
    //   53: aload 7
    //   55: invokevirtual 351	wW:N	(Ljava/lang/String;)V
    //   58: aload_0
    //   59: getfield 272	wW:a	Landroid/content/Context;
    //   62: invokevirtual 355	android/content/Context:getPackageManager	()Landroid/content/pm/PackageManager;
    //   65: astore 8
    //   67: aload_0
    //   68: aload 8
    //   70: aload 8
    //   72: aload 7
    //   74: iconst_0
    //   75: invokevirtual 361	android/content/pm/PackageManager:getApplicationInfo	(Ljava/lang/String;I)Landroid/content/pm/ApplicationInfo;
    //   78: invokevirtual 365	android/content/pm/PackageManager:getApplicationLabel	(Landroid/content/pm/ApplicationInfo;)Ljava/lang/CharSequence;
    //   81: invokeinterface 370 1 0
    //   86: invokevirtual 372	wW:d	(Ljava/lang/String;)V
    //   89: aload_0
    //   90: new 374	java/util/Date
    //   93: dup
    //   94: new 376	java/io/File
    //   97: dup
    //   98: aload 8
    //   100: aload 7
    //   102: iconst_0
    //   103: invokevirtual 361	android/content/pm/PackageManager:getApplicationInfo	(Ljava/lang/String;I)Landroid/content/pm/ApplicationInfo;
    //   106: getfield 381	android/content/pm/ApplicationInfo:sourceDir	Ljava/lang/String;
    //   109: invokespecial 383	java/io/File:<init>	(Ljava/lang/String;)V
    //   112: invokevirtual 387	java/io/File:lastModified	()J
    //   115: invokespecial 390	java/util/Date:<init>	(J)V
    //   118: invokevirtual 393	java/util/Date:getTime	()J
    //   121: ldc2_w 394
    //   124: ldiv
    //   125: invokestatic 400	java/lang/Long:toString	(J)Ljava/lang/String;
    //   128: invokevirtual 402	wW:D	(Ljava/lang/String;)V
    //   131: aload_0
    //   132: aload 8
    //   134: aload 7
    //   136: iconst_0
    //   137: invokevirtual 406	android/content/pm/PackageManager:getPackageInfo	(Ljava/lang/String;I)Landroid/content/pm/PackageInfo;
    //   140: getfield 411	android/content/pm/PackageInfo:versionCode	I
    //   143: invokestatic 416	java/lang/Integer:toString	(I)Ljava/lang/String;
    //   146: invokevirtual 418	wW:e	(Ljava/lang/String;)V
    //   149: aload_0
    //   150: aload 8
    //   152: aload 7
    //   154: invokevirtual 422	android/content/pm/PackageManager:getInstallerPackageName	(Ljava/lang/String;)Ljava/lang/String;
    //   157: invokevirtual 424	wW:E	(Ljava/lang/String;)V
    //   160: aload_0
    //   161: getstatic 429	android/os/Build:MODEL	Ljava/lang/String;
    //   164: invokevirtual 431	wW:l	(Ljava/lang/String;)V
    //   167: aload_0
    //   168: getstatic 434	android/os/Build:MANUFACTURER	Ljava/lang/String;
    //   171: invokevirtual 436	wW:i	(Ljava/lang/String;)V
    //   174: aload_0
    //   175: ldc_w 438
    //   178: invokestatic 443	java/lang/System:getProperty	(Ljava/lang/String;)Ljava/lang/String;
    //   181: invokevirtual 445	wW:k	(Ljava/lang/String;)V
    //   184: aload_0
    //   185: getstatic 450	android/os/Build$VERSION:RELEASE	Ljava/lang/String;
    //   188: invokevirtual 452	wW:M	(Ljava/lang/String;)V
    //   191: aload_0
    //   192: aload_1
    //   193: invokevirtual 456	android/content/Context:getResources	()Landroid/content/res/Resources;
    //   196: invokevirtual 462	android/content/res/Resources:getDisplayMetrics	()Landroid/util/DisplayMetrics;
    //   199: getfield 467	android/util/DisplayMetrics:density	F
    //   202: invokestatic 472	java/lang/Float:toString	(F)Ljava/lang/String;
    //   205: invokevirtual 474	wW:S	(Ljava/lang/String;)V
    //   208: aload_1
    //   209: ldc_w 476
    //   212: invokevirtual 480	android/content/Context:getSystemService	(Ljava/lang/String;)Ljava/lang/Object;
    //   215: checkcast 482	android/view/WindowManager
    //   218: astore 11
    //   220: getstatic 485	android/os/Build$VERSION:SDK_INT	I
    //   223: bipush 13
    //   225: if_icmplt +248 -> 473
    //   228: new 487	android/graphics/Point
    //   231: dup
    //   232: invokespecial 488	android/graphics/Point:<init>	()V
    //   235: astore 12
    //   237: aload 11
    //   239: invokeinterface 492 1 0
    //   244: aload 12
    //   246: invokevirtual 498	android/view/Display:getSize	(Landroid/graphics/Point;)V
    //   249: aload 12
    //   251: getfield 500	android/graphics/Point:x	I
    //   254: istore 13
    //   256: aload 12
    //   258: getfield 502	android/graphics/Point:y	I
    //   261: istore 14
    //   263: aload_0
    //   264: iload 13
    //   266: invokestatic 416	java/lang/Integer:toString	(I)Ljava/lang/String;
    //   269: invokevirtual 504	wW:U	(Ljava/lang/String;)V
    //   272: aload_0
    //   273: iload 14
    //   275: invokestatic 416	java/lang/Integer:toString	(I)Ljava/lang/String;
    //   278: invokevirtual 506	wW:T	(Ljava/lang/String;)V
    //   281: aload_0
    //   282: getfield 272	wW:a	Landroid/content/Context;
    //   285: ldc_w 508
    //   288: invokevirtual 480	android/content/Context:getSystemService	(Ljava/lang/String;)Ljava/lang/Object;
    //   291: checkcast 510	android/net/ConnectivityManager
    //   294: iconst_1
    //   295: invokevirtual 514	android/net/ConnectivityManager:getNetworkInfo	(I)Landroid/net/NetworkInfo;
    //   298: invokevirtual 519	android/net/NetworkInfo:isConnected	()Z
    //   301: ifeq +199 -> 500
    //   304: aload_0
    //   305: ldc_w 521
    //   308: invokevirtual 523	wW:f	(Ljava/lang/String;)V
    //   311: aload_0
    //   312: invokestatic 529	java/util/Locale:getDefault	()Ljava/util/Locale;
    //   315: getstatic 533	java/util/Locale:US	Ljava/util/Locale;
    //   318: invokevirtual 537	java/util/Locale:getDisplayLanguage	(Ljava/util/Locale;)Ljava/lang/String;
    //   321: invokevirtual 539	wW:G	(Ljava/lang/String;)V
    //   324: aload_0
    //   325: getfield 272	wW:a	Landroid/content/Context;
    //   328: ldc_w 541
    //   331: invokevirtual 480	android/content/Context:getSystemService	(Ljava/lang/String;)Ljava/lang/Object;
    //   334: checkcast 543	android/telephony/TelephonyManager
    //   337: astore 15
    //   339: aload 15
    //   341: ifnull +174 -> 515
    //   344: aload 15
    //   346: invokevirtual 546	android/telephony/TelephonyManager:getNetworkCountryIso	()Ljava/lang/String;
    //   349: ifnull +12 -> 361
    //   352: aload_0
    //   353: aload 15
    //   355: invokevirtual 546	android/telephony/TelephonyManager:getNetworkCountryIso	()Ljava/lang/String;
    //   358: invokevirtual 548	wW:g	(Ljava/lang/String;)V
    //   361: aload_0
    //   362: aload 15
    //   364: invokevirtual 551	android/telephony/TelephonyManager:getNetworkOperatorName	()Ljava/lang/String;
    //   367: invokevirtual 553	wW:j	(Ljava/lang/String;)V
    //   370: aload 15
    //   372: invokevirtual 556	android/telephony/TelephonyManager:getNetworkOperator	()Ljava/lang/String;
    //   375: astore 17
    //   377: aload 17
    //   379: ifnull +32 -> 411
    //   382: aload 17
    //   384: iconst_0
    //   385: iconst_3
    //   386: invokevirtual 560	java/lang/String:substring	(II)Ljava/lang/String;
    //   389: astore 19
    //   391: aload 17
    //   393: iconst_3
    //   394: invokevirtual 562	java/lang/String:substring	(I)Ljava/lang/String;
    //   397: astore 20
    //   399: aload_0
    //   400: aload 19
    //   402: invokevirtual 564	wW:J	(Ljava/lang/String;)V
    //   405: aload_0
    //   406: aload 20
    //   408: invokevirtual 566	wW:K	(Ljava/lang/String;)V
    //   411: aload_0
    //   412: invokevirtual 568	wW:Z	()Ljava/lang/String;
    //   415: astore 16
    //   417: aload 16
    //   419: ifnull +11 -> 430
    //   422: aload 16
    //   424: invokevirtual 572	java/lang/String:length	()I
    //   427: ifne +13 -> 440
    //   430: aload_0
    //   431: invokestatic 578	java/util/UUID:randomUUID	()Ljava/util/UUID;
    //   434: invokevirtual 579	java/util/UUID:toString	()Ljava/lang/String;
    //   437: invokevirtual 581	wW:I	(Ljava/lang/String;)V
    //   440: iconst_1
    //   441: istore 5
    //   443: aload_0
    //   444: monitorexit
    //   445: iload 5
    //   447: ireturn
    //   448: astore 10
    //   450: aload_0
    //   451: ldc_w 583
    //   454: invokevirtual 418	wW:e	(Ljava/lang/String;)V
    //   457: goto -308 -> 149
    //   460: astore 4
    //   462: aload 4
    //   464: invokevirtual 586	java/lang/Exception:printStackTrace	()V
    //   467: iconst_0
    //   468: istore 5
    //   470: goto -27 -> 443
    //   473: aload 11
    //   475: invokeinterface 492 1 0
    //   480: invokevirtual 589	android/view/Display:getWidth	()I
    //   483: istore 13
    //   485: aload 11
    //   487: invokeinterface 492 1 0
    //   492: invokevirtual 592	android/view/Display:getHeight	()I
    //   495: istore 14
    //   497: goto -234 -> 263
    //   500: aload_0
    //   501: ldc_w 594
    //   504: invokevirtual 523	wW:f	(Ljava/lang/String;)V
    //   507: goto -196 -> 311
    //   510: astore_3
    //   511: aload_0
    //   512: monitorexit
    //   513: aload_3
    //   514: athrow
    //   515: aload_0
    //   516: invokestatic 529	java/util/Locale:getDefault	()Ljava/util/Locale;
    //   519: invokevirtual 597	java/util/Locale:getCountry	()Ljava/lang/String;
    //   522: invokevirtual 548	wW:g	(Ljava/lang/String;)V
    //   525: goto -114 -> 411
    //   528: astore 18
    //   530: goto -119 -> 411
    //   533: astore 9
    //   535: goto -404 -> 131
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	538	0	this	wW
    //   0	538	1	paramContext	Context
    //   0	538	2	paramString	String
    //   510	4	3	localObject	Object
    //   460	3	4	localException	java.lang.Exception
    //   441	28	5	bool	boolean
    //   50	103	7	str1	String
    //   65	86	8	localPackageManager	android.content.pm.PackageManager
    //   533	1	9	localNameNotFoundException1	android.content.pm.PackageManager.NameNotFoundException
    //   448	1	10	localNameNotFoundException2	android.content.pm.PackageManager.NameNotFoundException
    //   218	268	11	localWindowManager	android.view.WindowManager
    //   235	22	12	localPoint	android.graphics.Point
    //   254	230	13	i1	int
    //   261	235	14	i2	int
    //   337	34	15	localTelephonyManager	android.telephony.TelephonyManager
    //   415	8	16	str2	String
    //   375	17	17	str3	String
    //   528	1	18	localIndexOutOfBoundsException	java.lang.IndexOutOfBoundsException
    //   389	12	19	str4	String
    //   397	10	20	str5	String
    // Exception table:
    //   from	to	target	type
    //   131	149	448	android/content/pm/PackageManager$NameNotFoundException
    //   2	67	460	java/lang/Exception
    //   67	131	460	java/lang/Exception
    //   131	149	460	java/lang/Exception
    //   149	377	460	java/lang/Exception
    //   382	411	460	java/lang/Exception
    //   411	440	460	java/lang/Exception
    //   450	457	460	java/lang/Exception
    //   473	507	460	java/lang/Exception
    //   515	525	460	java/lang/Exception
    //   2	67	510	finally
    //   67	131	510	finally
    //   131	149	510	finally
    //   149	377	510	finally
    //   382	411	510	finally
    //   411	440	510	finally
    //   450	457	510	finally
    //   462	467	510	finally
    //   473	507	510	finally
    //   515	525	510	finally
    //   382	411	528	java/lang/IndexOutOfBoundsException
    //   67	131	533	android/content/pm/PackageManager$NameNotFoundException
  }
  
  public String A()
  {
    try
    {
      String str = this.A;
      return str;
    }
    finally
    {
      localObject = finally;
      throw localObject;
    }
  }
  
  public void A(String paramString)
  {
    try
    {
      this.I = paramString;
      return;
    }
    finally
    {
      localObject = finally;
      throw localObject;
    }
  }
  
  public String B()
  {
    try
    {
      String str = this.B;
      return str;
    }
    finally
    {
      localObject = finally;
      throw localObject;
    }
  }
  
  public void B(String paramString)
  {
    try
    {
      this.M = paramString;
      return;
    }
    finally
    {
      localObject = finally;
      throw localObject;
    }
  }
  
  public String C()
  {
    try
    {
      String str = this.C;
      return str;
    }
    finally
    {
      localObject = finally;
      throw localObject;
    }
  }
  
  public void C(String paramString)
  {
    try
    {
      this.N = paramString;
      return;
    }
    finally
    {
      localObject = finally;
      throw localObject;
    }
  }
  
  public String D()
  {
    try
    {
      String str = this.D;
      return str;
    }
    finally
    {
      localObject = finally;
      throw localObject;
    }
  }
  
  public void D(String paramString)
  {
    try
    {
      this.P = paramString;
      return;
    }
    finally
    {
      localObject = finally;
      throw localObject;
    }
  }
  
  public String E()
  {
    try
    {
      String str = this.E;
      return str;
    }
    finally
    {
      localObject = finally;
      throw localObject;
    }
  }
  
  public void E(String paramString)
  {
    try
    {
      this.Q = paramString;
      return;
    }
    finally
    {
      localObject = finally;
      throw localObject;
    }
  }
  
  public String F()
  {
    try
    {
      String str = this.F;
      return str;
    }
    finally
    {
      localObject = finally;
      throw localObject;
    }
  }
  
  public void F(String paramString)
  {
    try
    {
      a("mat_is_paying_user", "mat_is_paying_user", paramString);
      return;
    }
    finally
    {
      localObject = finally;
      throw localObject;
    }
  }
  
  public String G()
  {
    try
    {
      String str = this.G;
      return str;
    }
    finally
    {
      localObject = finally;
      throw localObject;
    }
  }
  
  public void G(String paramString)
  {
    try
    {
      this.R = paramString;
      return;
    }
    finally
    {
      localObject = finally;
      throw localObject;
    }
  }
  
  public String H()
  {
    try
    {
      String str = this.H;
      return str;
    }
    finally
    {
      localObject = finally;
      throw localObject;
    }
  }
  
  public void H(String paramString)
  {
    try
    {
      a("mat_log_id_last_open", "logId", paramString);
      return;
    }
    finally
    {
      localObject = finally;
      throw localObject;
    }
  }
  
  public String I()
  {
    try
    {
      String str = this.I;
      return str;
    }
    finally
    {
      localObject = finally;
      throw localObject;
    }
  }
  
  public void I(String paramString)
  {
    try
    {
      a("mat_id", "mat_id", paramString);
      return;
    }
    finally
    {
      localObject = finally;
      throw localObject;
    }
  }
  
  public String J()
  {
    try
    {
      String str = this.J;
      return str;
    }
    finally
    {
      localObject = finally;
      throw localObject;
    }
  }
  
  public void J(String paramString)
  {
    try
    {
      this.W = paramString;
      return;
    }
    finally
    {
      localObject = finally;
      throw localObject;
    }
  }
  
  public String K()
  {
    try
    {
      String str = this.K;
      return str;
    }
    finally
    {
      localObject = finally;
      throw localObject;
    }
  }
  
  public void K(String paramString)
  {
    try
    {
      this.X = paramString;
      return;
    }
    finally
    {
      localObject = finally;
      throw localObject;
    }
  }
  
  public String L()
  {
    try
    {
      String str = this.L;
      return str;
    }
    finally
    {
      localObject = finally;
      throw localObject;
    }
  }
  
  public void L(String paramString)
  {
    try
    {
      a("mat_log_id_open", "logId", paramString);
      return;
    }
    finally
    {
      localObject = finally;
      throw localObject;
    }
  }
  
  public String M()
  {
    try
    {
      String str = this.M;
      return str;
    }
    finally
    {
      localObject = finally;
      throw localObject;
    }
  }
  
  public void M(String paramString)
  {
    try
    {
      this.Y = paramString;
      return;
    }
    finally
    {
      localObject = finally;
      throw localObject;
    }
  }
  
  public String N()
  {
    try
    {
      String str = this.N;
      return str;
    }
    finally
    {
      localObject = finally;
      throw localObject;
    }
  }
  
  public void N(String paramString)
  {
    try
    {
      this.Z = paramString;
      return;
    }
    finally
    {
      localObject = finally;
      throw localObject;
    }
  }
  
  public String O()
  {
    try
    {
      String str = this.O;
      return str;
    }
    finally
    {
      localObject = finally;
      throw localObject;
    }
  }
  
  public void O(String paramString)
  {
    try
    {
      this.ac = paramString;
      return;
    }
    finally
    {
      localObject = finally;
      throw localObject;
    }
  }
  
  public String P()
  {
    try
    {
      String str = this.P;
      return str;
    }
    finally
    {
      localObject = finally;
      throw localObject;
    }
  }
  
  public void P(String paramString)
  {
    try
    {
      this.ad = paramString;
      return;
    }
    finally
    {
      localObject = finally;
      throw localObject;
    }
  }
  
  public String Q()
  {
    try
    {
      String str = this.Q;
      return str;
    }
    finally
    {
      localObject = finally;
      throw localObject;
    }
  }
  
  public void Q(String paramString)
  {
    try
    {
      this.ae = paramString;
      return;
    }
    finally
    {
      localObject = finally;
      throw localObject;
    }
  }
  
  public String R()
  {
    try
    {
      String str = a("mat_log_id_install", "logId");
      return str;
    }
    finally
    {
      localObject = finally;
      throw localObject;
    }
  }
  
  public void R(String paramString)
  {
    try
    {
      this.af = paramString;
      return;
    }
    finally
    {
      localObject = finally;
      throw localObject;
    }
  }
  
  public String S()
  {
    try
    {
      String str = a("mat_referrer", "referrer");
      return str;
    }
    finally
    {
      localObject = finally;
      throw localObject;
    }
  }
  
  public void S(String paramString)
  {
    try
    {
      this.ag = paramString;
      return;
    }
    finally
    {
      localObject = finally;
      throw localObject;
    }
  }
  
  public String T()
  {
    try
    {
      String str = a("mat_is_paying_user", "mat_is_paying_user");
      return str;
    }
    finally
    {
      localObject = finally;
      throw localObject;
    }
  }
  
  public void T(String paramString)
  {
    try
    {
      this.ah = paramString;
      return;
    }
    finally
    {
      localObject = finally;
      throw localObject;
    }
  }
  
  public String U()
  {
    try
    {
      String str = this.R;
      return str;
    }
    finally
    {
      localObject = finally;
      throw localObject;
    }
  }
  
  public void U(String paramString)
  {
    try
    {
      this.ai = paramString;
      return;
    }
    finally
    {
      localObject = finally;
      throw localObject;
    }
  }
  
  public String V()
  {
    try
    {
      String str = a("mat_log_id_last_open", "logId");
      return str;
    }
    finally
    {
      localObject = finally;
      throw localObject;
    }
  }
  
  public void V(String paramString)
  {
    try
    {
      this.ao = paramString;
      return;
    }
    finally
    {
      localObject = finally;
      throw localObject;
    }
  }
  
  public String W()
  {
    try
    {
      String str = this.S;
      return str;
    }
    finally
    {
      localObject = finally;
      throw localObject;
    }
  }
  
  public void W(String paramString)
  {
    try
    {
      this.ap = paramString;
      return;
    }
    finally
    {
      localObject = finally;
      throw localObject;
    }
  }
  
  public String X()
  {
    try
    {
      String str = this.U;
      return str;
    }
    finally
    {
      localObject = finally;
      throw localObject;
    }
  }
  
  public void X(String paramString)
  {
    try
    {
      this.aq = paramString;
      return;
    }
    finally
    {
      localObject = finally;
      throw localObject;
    }
  }
  
  public String Y()
  {
    try
    {
      String str = this.V;
      return str;
    }
    finally
    {
      localObject = finally;
      throw localObject;
    }
  }
  
  public void Y(String paramString)
  {
    try
    {
      this.ar = paramString;
      return;
    }
    finally
    {
      localObject = finally;
      throw localObject;
    }
  }
  
  public String Z()
  {
    try
    {
      String str = a("mat_id", "mat_id");
      return str;
    }
    finally
    {
      localObject = finally;
      throw localObject;
    }
  }
  
  public void Z(String paramString)
  {
    try
    {
      this.as = paramString;
      return;
    }
    finally
    {
      localObject = finally;
      throw localObject;
    }
  }
  
  public void a(String paramString)
  {
    try
    {
      this.c = paramString;
      return;
    }
    finally
    {
      localObject = finally;
      throw localObject;
    }
  }
  
  public String aA()
  {
    try
    {
      String str = this.aq;
      return str;
    }
    finally
    {
      localObject = finally;
      throw localObject;
    }
  }
  
  public String aB()
  {
    try
    {
      String str = this.ar;
      return str;
    }
    finally
    {
      localObject = finally;
      throw localObject;
    }
  }
  
  public String aC()
  {
    try
    {
      String str = this.as;
      return str;
    }
    finally
    {
      localObject = finally;
      throw localObject;
    }
  }
  
  public String aD()
  {
    try
    {
      String str = this.at;
      return str;
    }
    finally
    {
      localObject = finally;
      throw localObject;
    }
  }
  
  public String aE()
  {
    try
    {
      String str = this.au;
      return str;
    }
    finally
    {
      localObject = finally;
      throw localObject;
    }
  }
  
  public String aF()
  {
    try
    {
      String str = this.av;
      return str;
    }
    finally
    {
      localObject = finally;
      throw localObject;
    }
  }
  
  public String aG()
  {
    try
    {
      String str = this.aw;
      return str;
    }
    finally
    {
      localObject = finally;
      throw localObject;
    }
  }
  
  public String aH()
  {
    try
    {
      String str = this.ax;
      return str;
    }
    finally
    {
      localObject = finally;
      throw localObject;
    }
  }
  
  public String aI()
  {
    try
    {
      String str = this.ay;
      return str;
    }
    finally
    {
      localObject = finally;
      throw localObject;
    }
  }
  
  public String aJ()
  {
    try
    {
      String str = this.az;
      return str;
    }
    finally
    {
      localObject = finally;
      throw localObject;
    }
  }
  
  public String aK()
  {
    try
    {
      String str = this.aA;
      return str;
    }
    finally
    {
      localObject = finally;
      throw localObject;
    }
  }
  
  public String aL()
  {
    try
    {
      String str = this.aB;
      return str;
    }
    finally
    {
      localObject = finally;
      throw localObject;
    }
  }
  
  public String aM()
  {
    try
    {
      String str = this.aC;
      return str;
    }
    finally
    {
      localObject = finally;
      throw localObject;
    }
  }
  
  public String aN()
  {
    try
    {
      String str = this.aD;
      return str;
    }
    finally
    {
      localObject = finally;
      throw localObject;
    }
  }
  
  public String aO()
  {
    try
    {
      String str = this.aE;
      return str;
    }
    finally
    {
      localObject = finally;
      throw localObject;
    }
  }
  
  public String aP()
  {
    try
    {
      String str = this.aF;
      return str;
    }
    finally
    {
      localObject = finally;
      throw localObject;
    }
  }
  
  public String aQ()
  {
    try
    {
      String str = this.aG;
      return str;
    }
    finally
    {
      localObject = finally;
      throw localObject;
    }
  }
  
  public String aR()
  {
    try
    {
      String str = this.aH;
      return str;
    }
    finally
    {
      localObject = finally;
      throw localObject;
    }
  }
  
  public String aa()
  {
    try
    {
      String str = this.W;
      return str;
    }
    finally
    {
      localObject = finally;
      throw localObject;
    }
  }
  
  public void aa(String paramString)
  {
    try
    {
      this.at = paramString;
      return;
    }
    finally
    {
      localObject = finally;
      throw localObject;
    }
  }
  
  public String ab()
  {
    try
    {
      String str = this.X;
      return str;
    }
    finally
    {
      localObject = finally;
      throw localObject;
    }
  }
  
  public void ab(String paramString)
  {
    try
    {
      this.au = paramString;
      return;
    }
    finally
    {
      localObject = finally;
      throw localObject;
    }
  }
  
  public String ac()
  {
    try
    {
      String str = a("mat_log_id_open", "logId");
      return str;
    }
    finally
    {
      localObject = finally;
      throw localObject;
    }
  }
  
  public void ac(String paramString)
  {
    try
    {
      this.av = paramString;
      return;
    }
    finally
    {
      localObject = finally;
      throw localObject;
    }
  }
  
  public String ad()
  {
    try
    {
      String str = this.Y;
      return str;
    }
    finally
    {
      localObject = finally;
      throw localObject;
    }
  }
  
  public void ad(String paramString)
  {
    try
    {
      this.aw = paramString;
      return;
    }
    finally
    {
      localObject = finally;
      throw localObject;
    }
  }
  
  public String ae()
  {
    try
    {
      String str = this.Z;
      return str;
    }
    finally
    {
      localObject = finally;
      throw localObject;
    }
  }
  
  public void ae(String paramString)
  {
    try
    {
      this.ax = paramString;
      return;
    }
    finally
    {
      localObject = finally;
      throw localObject;
    }
  }
  
  public String af()
  {
    try
    {
      String str = this.aa;
      return str;
    }
    finally
    {
      localObject = finally;
      throw localObject;
    }
  }
  
  public void af(String paramString)
  {
    try
    {
      this.ay = paramString;
      return;
    }
    finally
    {
      localObject = finally;
      throw localObject;
    }
  }
  
  public String ag()
  {
    try
    {
      String str = this.ab;
      return str;
    }
    finally
    {
      localObject = finally;
      throw localObject;
    }
  }
  
  public void ag(String paramString)
  {
    try
    {
      this.az = paramString;
      return;
    }
    finally
    {
      localObject = finally;
      throw localObject;
    }
  }
  
  public String ah()
  {
    try
    {
      String str = this.ac;
      return str;
    }
    finally
    {
      localObject = finally;
      throw localObject;
    }
  }
  
  public void ah(String paramString)
  {
    try
    {
      this.aA = paramString;
      return;
    }
    finally
    {
      localObject = finally;
      throw localObject;
    }
  }
  
  public String ai()
  {
    try
    {
      String str = this.ad;
      return str;
    }
    finally
    {
      localObject = finally;
      throw localObject;
    }
  }
  
  public void ai(String paramString)
  {
    try
    {
      this.aB = paramString;
      return;
    }
    finally
    {
      localObject = finally;
      throw localObject;
    }
  }
  
  public String aj()
  {
    try
    {
      String str = this.ae;
      return str;
    }
    finally
    {
      localObject = finally;
      throw localObject;
    }
  }
  
  public void aj(String paramString)
  {
    try
    {
      this.aC = paramString;
      return;
    }
    finally
    {
      localObject = finally;
      throw localObject;
    }
  }
  
  public String ak()
  {
    try
    {
      String str = this.af;
      return str;
    }
    finally
    {
      localObject = finally;
      throw localObject;
    }
  }
  
  public void ak(String paramString)
  {
    try
    {
      this.aD = paramString;
      return;
    }
    finally
    {
      localObject = finally;
      throw localObject;
    }
  }
  
  public String al()
  {
    try
    {
      String str = this.ag;
      return str;
    }
    finally
    {
      localObject = finally;
      throw localObject;
    }
  }
  
  public void al(String paramString)
  {
    try
    {
      this.aE = paramString;
      return;
    }
    finally
    {
      localObject = finally;
      throw localObject;
    }
  }
  
  public String am()
  {
    try
    {
      String str = this.ah;
      return str;
    }
    finally
    {
      localObject = finally;
      throw localObject;
    }
  }
  
  public void am(String paramString)
  {
    try
    {
      this.aF = paramString;
      return;
    }
    finally
    {
      localObject = finally;
      throw localObject;
    }
  }
  
  public String an()
  {
    try
    {
      String str = this.ai;
      return str;
    }
    finally
    {
      localObject = finally;
      throw localObject;
    }
  }
  
  public void an(String paramString)
  {
    try
    {
      this.aG = paramString;
      return;
    }
    finally
    {
      localObject = finally;
      throw localObject;
    }
  }
  
  /* Error */
  public String ao()
  {
    // Byte code:
    //   0: aload_0
    //   1: monitorenter
    //   2: aload_0
    //   3: monitorexit
    //   4: ldc_w 629
    //   7: areturn
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	8	0	this	wW
    // Exception table:
    //   from	to	target	type
    //   2	2	8	finally
  }
  
  public void ao(String paramString)
  {
    try
    {
      this.aH = paramString;
      return;
    }
    finally
    {
      localObject = finally;
      throw localObject;
    }
  }
  
  public String ap()
  {
    try
    {
      String str = this.aj;
      return str;
    }
    finally
    {
      localObject = finally;
      throw localObject;
    }
  }
  
  public String aq()
  {
    try
    {
      String str = this.ak;
      return str;
    }
    finally
    {
      localObject = finally;
      throw localObject;
    }
  }
  
  public String ar()
  {
    try
    {
      String str = this.al;
      return str;
    }
    finally
    {
      localObject = finally;
      throw localObject;
    }
  }
  
  public String as()
  {
    try
    {
      String str = this.am;
      return str;
    }
    finally
    {
      localObject = finally;
      throw localObject;
    }
  }
  
  public String at()
  {
    try
    {
      String str = a("mat_log_id_update", "logId");
      return str;
    }
    finally
    {
      localObject = finally;
      throw localObject;
    }
  }
  
  public String au()
  {
    try
    {
      String str = this.an;
      return str;
    }
    finally
    {
      localObject = finally;
      throw localObject;
    }
  }
  
  public String av()
  {
    try
    {
      String str = a("mat_user_ids", "user_email");
      return str;
    }
    finally
    {
      localObject = finally;
      throw localObject;
    }
  }
  
  public String aw()
  {
    try
    {
      String str = a("mat_user_ids", "user_id");
      return str;
    }
    finally
    {
      localObject = finally;
      throw localObject;
    }
  }
  
  public String ax()
  {
    try
    {
      String str = a("mat_user_ids", "user_name");
      return str;
    }
    finally
    {
      localObject = finally;
      throw localObject;
    }
  }
  
  public String ay()
  {
    try
    {
      String str = this.ao;
      return str;
    }
    finally
    {
      localObject = finally;
      throw localObject;
    }
  }
  
  public String az()
  {
    try
    {
      String str = this.ap;
      return str;
    }
    finally
    {
      localObject = finally;
      throw localObject;
    }
  }
  
  public void b()
  {
    try
    {
      v(null);
      x(null);
      R(null);
      h("USD");
      Q(null);
      s(null);
      r(null);
      w(null);
      y(null);
      A(null);
      z(null);
      t(null);
      u(null);
      m(null);
      n(null);
      o(null);
      p(null);
      q(null);
      W(null);
      V(null);
      X(null);
      ak(null);
      al(null);
      am(null);
      an(null);
      ao(null);
      ai(null);
      ah(null);
      ag(null);
      aj(null);
      ae(null);
      af(null);
      ac(null);
      ab(null);
      aa(null);
      ad(null);
      Y(null);
      Z(null);
      return;
    }
    finally
    {
      localObject = finally;
      throw localObject;
    }
  }
  
  public void b(String paramString)
  {
    try
    {
      this.d = paramString;
      return;
    }
    finally
    {
      localObject = finally;
      throw localObject;
    }
  }
  
  public String c()
  {
    try
    {
      String str = this.c;
      return str;
    }
    finally
    {
      localObject = finally;
      throw localObject;
    }
  }
  
  public void c(String paramString)
  {
    try
    {
      this.h = paramString;
      return;
    }
    finally
    {
      localObject = finally;
      throw localObject;
    }
  }
  
  public String d()
  {
    try
    {
      String str = this.d;
      return str;
    }
    finally
    {
      localObject = finally;
      throw localObject;
    }
  }
  
  public void d(String paramString)
  {
    try
    {
      this.j = paramString;
      return;
    }
    finally
    {
      localObject = finally;
      throw localObject;
    }
  }
  
  public String e()
  {
    try
    {
      String str = this.e;
      return str;
    }
    finally
    {
      localObject = finally;
      throw localObject;
    }
  }
  
  public void e(String paramString)
  {
    try
    {
      this.k = paramString;
      return;
    }
    finally
    {
      localObject = finally;
      throw localObject;
    }
  }
  
  public String f()
  {
    try
    {
      String str = this.f;
      return str;
    }
    finally
    {
      localObject = finally;
      throw localObject;
    }
  }
  
  public void f(String paramString)
  {
    try
    {
      this.l = paramString;
      return;
    }
    finally
    {
      localObject = finally;
      throw localObject;
    }
  }
  
  public String g()
  {
    try
    {
      String str = this.g;
      return str;
    }
    finally
    {
      localObject = finally;
      throw localObject;
    }
  }
  
  public void g(String paramString)
  {
    try
    {
      this.m = paramString;
      return;
    }
    finally
    {
      localObject = finally;
      throw localObject;
    }
  }
  
  public String h()
  {
    try
    {
      String str = this.h;
      return str;
    }
    finally
    {
      localObject = finally;
      throw localObject;
    }
  }
  
  public void h(String paramString)
  {
    try
    {
      this.n = paramString;
      return;
    }
    finally
    {
      localObject = finally;
      throw localObject;
    }
  }
  
  public String i()
  {
    try
    {
      String str = this.i;
      return str;
    }
    finally
    {
      localObject = finally;
      throw localObject;
    }
  }
  
  public void i(String paramString)
  {
    try
    {
      this.o = paramString;
      return;
    }
    finally
    {
      localObject = finally;
      throw localObject;
    }
  }
  
  public String j()
  {
    try
    {
      String str = this.j;
      return str;
    }
    finally
    {
      localObject = finally;
      throw localObject;
    }
  }
  
  public void j(String paramString)
  {
    try
    {
      this.p = paramString;
      return;
    }
    finally
    {
      localObject = finally;
      throw localObject;
    }
  }
  
  public String k()
  {
    try
    {
      String str = this.k;
      return str;
    }
    finally
    {
      localObject = finally;
      throw localObject;
    }
  }
  
  public void k(String paramString)
  {
    try
    {
      this.q = paramString;
      return;
    }
    finally
    {
      localObject = finally;
      throw localObject;
    }
  }
  
  public String l()
  {
    try
    {
      String str = this.l;
      return str;
    }
    finally
    {
      localObject = finally;
      throw localObject;
    }
  }
  
  public void l(String paramString)
  {
    try
    {
      this.t = paramString;
      return;
    }
    finally
    {
      localObject = finally;
      throw localObject;
    }
  }
  
  public String m()
  {
    try
    {
      String str = this.m;
      return str;
    }
    finally
    {
      localObject = finally;
      throw localObject;
    }
  }
  
  public void m(String paramString)
  {
    try
    {
      this.u = paramString;
      return;
    }
    finally
    {
      localObject = finally;
      throw localObject;
    }
  }
  
  public String n()
  {
    try
    {
      String str = this.n;
      return str;
    }
    finally
    {
      localObject = finally;
      throw localObject;
    }
  }
  
  public void n(String paramString)
  {
    try
    {
      this.v = paramString;
      return;
    }
    finally
    {
      localObject = finally;
      throw localObject;
    }
  }
  
  public String o()
  {
    try
    {
      String str = this.o;
      return str;
    }
    finally
    {
      localObject = finally;
      throw localObject;
    }
  }
  
  public void o(String paramString)
  {
    try
    {
      this.w = paramString;
      return;
    }
    finally
    {
      localObject = finally;
      throw localObject;
    }
  }
  
  public String p()
  {
    try
    {
      String str = this.p;
      return str;
    }
    finally
    {
      localObject = finally;
      throw localObject;
    }
  }
  
  public void p(String paramString)
  {
    try
    {
      this.x = paramString;
      return;
    }
    finally
    {
      localObject = finally;
      throw localObject;
    }
  }
  
  public String q()
  {
    try
    {
      String str = this.q;
      return str;
    }
    finally
    {
      localObject = finally;
      throw localObject;
    }
  }
  
  public void q(String paramString)
  {
    try
    {
      this.y = paramString;
      return;
    }
    finally
    {
      localObject = finally;
      throw localObject;
    }
  }
  
  public String r()
  {
    try
    {
      String str = this.r;
      return str;
    }
    finally
    {
      localObject = finally;
      throw localObject;
    }
  }
  
  public void r(String paramString)
  {
    try
    {
      this.z = paramString;
      return;
    }
    finally
    {
      localObject = finally;
      throw localObject;
    }
  }
  
  public String s()
  {
    try
    {
      String str = this.s;
      return str;
    }
    finally
    {
      localObject = finally;
      throw localObject;
    }
  }
  
  public void s(String paramString)
  {
    try
    {
      this.A = paramString;
      return;
    }
    finally
    {
      localObject = finally;
      throw localObject;
    }
  }
  
  public String t()
  {
    try
    {
      String str = this.t;
      return str;
    }
    finally
    {
      localObject = finally;
      throw localObject;
    }
  }
  
  public void t(String paramString)
  {
    try
    {
      this.B = paramString;
      return;
    }
    finally
    {
      localObject = finally;
      throw localObject;
    }
  }
  
  public String u()
  {
    try
    {
      String str = this.u;
      return str;
    }
    finally
    {
      localObject = finally;
      throw localObject;
    }
  }
  
  public void u(String paramString)
  {
    try
    {
      this.C = paramString;
      return;
    }
    finally
    {
      localObject = finally;
      throw localObject;
    }
  }
  
  public String v()
  {
    try
    {
      String str = this.v;
      return str;
    }
    finally
    {
      localObject = finally;
      throw localObject;
    }
  }
  
  public void v(String paramString)
  {
    try
    {
      this.D = paramString;
      return;
    }
    finally
    {
      localObject = finally;
      throw localObject;
    }
  }
  
  public String w()
  {
    try
    {
      String str = this.w;
      return str;
    }
    finally
    {
      localObject = finally;
      throw localObject;
    }
  }
  
  public void w(String paramString)
  {
    try
    {
      this.E = paramString;
      return;
    }
    finally
    {
      localObject = finally;
      throw localObject;
    }
  }
  
  public String x()
  {
    try
    {
      String str = this.x;
      return str;
    }
    finally
    {
      localObject = finally;
      throw localObject;
    }
  }
  
  public void x(String paramString)
  {
    try
    {
      this.F = paramString;
      return;
    }
    finally
    {
      localObject = finally;
      throw localObject;
    }
  }
  
  public String y()
  {
    try
    {
      String str = this.y;
      return str;
    }
    finally
    {
      localObject = finally;
      throw localObject;
    }
  }
  
  public void y(String paramString)
  {
    try
    {
      this.G = paramString;
      return;
    }
    finally
    {
      localObject = finally;
      throw localObject;
    }
  }
  
  public String z()
  {
    try
    {
      String str = this.z;
      return str;
    }
    finally
    {
      localObject = finally;
      throw localObject;
    }
  }
  
  public void z(String paramString)
  {
    try
    {
      this.H = paramString;
      return;
    }
    finally
    {
      localObject = finally;
      throw localObject;
    }
  }
}


/* Location:           C:\Users\dreadiscool\Desktop\tools\classes-dex2jar.jar
 * Qualified Name:     wW
 * JD-Core Version:    0.7.0.1
 */