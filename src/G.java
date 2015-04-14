import android.annotation.SuppressLint;
import android.app.Activity;
import android.content.Context;
import android.content.SharedPreferences;
import android.content.SharedPreferences.Editor;
import android.content.pm.PackageInfo;
import android.content.pm.PackageManager;
import java.io.File;
import java.util.Arrays;
import java.util.Collection;
import java.util.Collections;
import java.util.Iterator;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Future;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.TimeoutException;

@JR(a={bo.class})
public class G
  extends IM<Void>
  implements IN
{
  private final long a = System.currentTimeMillis();
  private final ConcurrentHashMap<String, String> g = new ConcurrentHashMap();
  private final Collection<IM<Boolean>> h;
  private File i;
  private V j;
  private Y k;
  private String l = null;
  private String m = null;
  private String n = null;
  private String o;
  private String p;
  private String q;
  private String r;
  private String s;
  private float t;
  private boolean u;
  private final aI v;
  private KK w;
  private S x;
  private bo y;
  
  public G()
  {
    this(1.0F, null, null, false);
  }
  
  G(float paramFloat, V paramV, aI paramaI, boolean paramBoolean)
  {
    this(paramFloat, paramV, paramaI, paramBoolean, Jo.a("Crashlytics Exception Handler"));
  }
  
  G(float paramFloat, V paramV, aI paramaI, boolean paramBoolean, ExecutorService paramExecutorService)
  {
    this.t = paramFloat;
    this.j = paramV;
    this.v = paramaI;
    this.u = paramBoolean;
    this.x = new S(paramExecutorService);
    IM[] arrayOfIM = new IM[2];
    arrayOfIM[0] = new aR();
    arrayOfIM[1] = new bh();
    this.h = Collections.unmodifiableCollection(Arrays.asList(arrayOfIM));
  }
  
  private void H()
  {
    H localH = new H(this);
    Iterator localIterator = G().iterator();
    while (localIterator.hasNext()) {
      localH.a((Kc)localIterator.next());
    }
    Future localFuture = D().e().submit(localH);
    IC.g();
    try
    {
      localFuture.get(4L, TimeUnit.SECONDS);
      return;
    }
    catch (InterruptedException localInterruptedException)
    {
      for (;;)
      {
        IC.g();
      }
    }
    catch (ExecutionException localExecutionException)
    {
      for (;;)
      {
        IC.g();
      }
    }
    catch (TimeoutException localTimeoutException)
    {
      for (;;)
      {
        IC.g();
      }
    }
  }
  
  private static boolean I()
  {
    G localG = f();
    if ((localG == null) || (localG.u)) {}
    for (boolean bool = true;; bool = false) {
      return bool;
    }
  }
  
  private int a(float paramFloat, int paramInt)
  {
    return (int)(paramFloat * paramInt);
  }
  
  public static void a(int paramInt, String paramString1, String paramString2)
  {
    b(paramInt, paramString1, paramString2);
    IC.g().a(paramInt, "" + paramString1, "" + paramString2, true);
  }
  
  private void a(Context paramContext, String paramString)
  {
    X localX;
    if (this.v != null) {
      localX = new X(this.v);
    }
    for (;;)
    {
      this.w = new Kz(IC.g());
      this.w.a(localX);
      try
      {
        this.p = paramContext.getPackageName();
        this.q = B().h();
        IC.g();
        new StringBuilder().append("Installer package name is: ").append(this.q).toString();
        PackageInfo localPackageInfo = paramContext.getPackageManager().getPackageInfo(this.p, 0);
        this.r = Integer.toString(localPackageInfo.versionCode);
        if (localPackageInfo.versionName == null) {}
        for (String str = "0.0";; str = localPackageInfo.versionName)
        {
          this.s = str;
          this.o = Jg.m(paramContext);
          B().m();
          a(this.o, b(paramContext)).a(paramString, this.p);
          return;
          localX = null;
          break;
        }
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
  
  static void a(String paramString)
  {
    aR localaR = (aR)IC.a(aR.class);
    if (localaR != null) {
      localaR.a(new Jk(paramString));
    }
  }
  
  private boolean a(Activity paramActivity, Lg paramLg)
  {
    as localas = new as(paramActivity, paramLg);
    R localR = new R(this, null);
    paramActivity.runOnUiThread(new N(this, paramActivity, localR, localas, paramLg));
    IC.g();
    localR.b();
    return localR.a();
  }
  
  private static boolean a(String paramString, G paramG)
  {
    if ((paramG == null) || (paramG.k == null))
    {
      IC.g();
      new StringBuilder().append("Crashlytics must be initialized by calling Fabric.with(Context) ").append(paramString).toString();
    }
    for (boolean bool = false;; bool = true) {
      return bool;
    }
  }
  
  private static void b(int paramInt, String paramString1, String paramString2)
  {
    if (I()) {}
    for (;;)
    {
      return;
      G localG = f();
      if (a("prior to logging messages.", localG))
      {
        long l1 = System.currentTimeMillis() - localG.a;
        localG.k.a(l1, c(paramInt, paramString1, paramString2));
      }
    }
  }
  
  private boolean b(Context paramContext)
  {
    return Jg.a(paramContext, "com.crashlytics.RequireBuildId", true);
  }
  
  private static String c(int paramInt, String paramString1, String paramString2)
  {
    return Jg.a(paramInt) + "/" + paramString1 + " " + paramString2;
  }
  
  public static G f()
  {
    try
    {
      G localG = (G)IC.a(G.class);
      return localG;
    }
    catch (IllegalStateException localIllegalStateException)
    {
      IC.g();
      throw localIllegalStateException;
    }
  }
  
  aq a(Lo paramLo)
  {
    if (paramLo != null) {}
    for (ar localar = new ar(this, l(), paramLo.a.d, this.w);; localar = null) {
      return localar;
    }
  }
  
  z a(String paramString, boolean paramBoolean)
  {
    return new z(paramString, paramBoolean);
  }
  
  @SuppressLint({"CommitPrefEdits"})
  void a(boolean paramBoolean)
  {
    KR localKR = new KR(this);
    localKR.a(localKR.b().putBoolean("always_send_reports_opt_in", paramBoolean));
  }
  
  protected boolean a()
  {
    return a(super.C());
  }
  
  /* Error */
  boolean a(Context paramContext)
  {
    // Byte code:
    //   0: aload_0
    //   1: getfield 87	G:u	Z
    //   4: ifeq +9 -> 13
    //   7: iconst_0
    //   8: istore 7
    //   10: iload 7
    //   12: ireturn
    //   13: new 435	Je
    //   16: dup
    //   17: invokespecial 436	Je:<init>	()V
    //   20: aload_1
    //   21: invokevirtual 438	Je:a	(Landroid/content/Context;)Ljava/lang/String;
    //   24: astore_2
    //   25: aload_2
    //   26: ifnonnull +9 -> 35
    //   29: iconst_0
    //   30: istore 7
    //   32: goto -22 -> 10
    //   35: invokestatic 170	IC:g	()LIO;
    //   38: pop
    //   39: new 202	java/lang/StringBuilder
    //   42: dup
    //   43: invokespecial 203	java/lang/StringBuilder:<init>	()V
    //   46: ldc_w 440
    //   49: invokevirtual 209	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   52: aload_0
    //   53: invokevirtual 442	G:d	()Ljava/lang/String;
    //   56: invokevirtual 209	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   59: invokevirtual 213	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   62: pop
    //   63: aload_0
    //   64: new 444	java/io/File
    //   67: dup
    //   68: aload_0
    //   69: invokevirtual 447	G:u	()Ljava/io/File;
    //   72: ldc_w 449
    //   75: invokespecial 452	java/io/File:<init>	(Ljava/io/File;Ljava/lang/String;)V
    //   78: putfield 196	G:i	Ljava/io/File;
    //   81: aload_0
    //   82: aload_1
    //   83: aload_2
    //   84: invokespecial 454	G:a	(Landroid/content/Context;Ljava/lang/String;)V
    //   87: new 456	aN
    //   90: dup
    //   91: aload_0
    //   92: invokevirtual 457	G:C	()Landroid/content/Context;
    //   95: aload_0
    //   96: getfield 293	G:o	Ljava/lang/String;
    //   99: aload_0
    //   100: invokevirtual 458	G:h	()Ljava/lang/String;
    //   103: invokespecial 461	aN:<init>	(Landroid/content/Context;Ljava/lang/String;Ljava/lang/String;)V
    //   106: astore 9
    //   108: invokestatic 170	IC:g	()LIO;
    //   111: pop
    //   112: aload_0
    //   113: new 363	Y
    //   116: dup
    //   117: invokestatic 467	java/lang/Thread:getDefaultUncaughtExceptionHandler	()Ljava/lang/Thread$UncaughtExceptionHandler;
    //   120: aload_0
    //   121: getfield 83	G:j	LV;
    //   124: aload_0
    //   125: getfield 94	G:x	LS;
    //   128: aload_0
    //   129: invokevirtual 249	G:B	()LJs;
    //   132: aload 9
    //   134: aload_0
    //   135: invokespecial 470	Y:<init>	(Ljava/lang/Thread$UncaughtExceptionHandler;LV;LS;LJs;LaN;LG;)V
    //   138: putfield 349	G:k	LY;
    //   141: aload_0
    //   142: invokevirtual 472	G:s	()Z
    //   145: istore 14
    //   147: iload 14
    //   149: istore 11
    //   151: aload_0
    //   152: getfield 349	G:k	LY;
    //   155: invokevirtual 473	Y:b	()V
    //   158: aload_0
    //   159: getfield 349	G:k	LY;
    //   162: invokestatic 477	java/lang/Thread:setDefaultUncaughtExceptionHandler	(Ljava/lang/Thread$UncaughtExceptionHandler;)V
    //   165: invokestatic 170	IC:g	()LIO;
    //   168: pop
    //   169: iload 11
    //   171: ifeq +39 -> 210
    //   174: aload_1
    //   175: invokestatic 479	Jg:n	(Landroid/content/Context;)Z
    //   178: ifeq +32 -> 210
    //   181: aload_0
    //   182: invokespecial 481	G:H	()V
    //   185: iconst_0
    //   186: istore 7
    //   188: goto -178 -> 10
    //   191: invokestatic 170	IC:g	()LIO;
    //   194: pop
    //   195: goto -26 -> 169
    //   198: astore 8
    //   200: new 483	Kd
    //   203: dup
    //   204: aload 8
    //   206: invokespecial 486	Kd:<init>	(Ljava/lang/Throwable;)V
    //   209: athrow
    //   210: iconst_1
    //   211: istore 7
    //   213: goto -203 -> 10
    //   216: astore 5
    //   218: invokestatic 170	IC:g	()LIO;
    //   221: pop
    //   222: iconst_0
    //   223: istore 7
    //   225: goto -215 -> 10
    //   228: astore 15
    //   230: goto -39 -> 191
    //   233: astore 10
    //   235: iconst_0
    //   236: istore 11
    //   238: goto -47 -> 191
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	241	0	this	G
    //   0	241	1	paramContext	Context
    //   24	60	2	str	String
    //   216	1	5	localException1	Exception
    //   8	216	7	bool1	boolean
    //   198	7	8	localW	W
    //   106	27	9	localaN	aN
    //   233	1	10	localException2	Exception
    //   149	88	11	bool2	boolean
    //   145	3	14	bool3	boolean
    //   228	1	15	localException3	Exception
    // Exception table:
    //   from	to	target	type
    //   81	87	198	W
    //   87	147	198	W
    //   151	169	198	W
    //   174	195	198	W
    //   81	87	216	java/lang/Exception
    //   174	195	216	java/lang/Exception
    //   151	169	228	java/lang/Exception
    //   87	147	233	java/lang/Exception
  }
  
  protected Void b()
  {
    q();
    this.k.g();
    int i1 = 1;
    try
    {
      localLo = Li.a().b();
      if (localLo != null) {
        break label36;
      }
      IC.g();
    }
    catch (Exception localException1)
    {
      for (;;)
      {
        Lo localLo;
        label36:
        aq localaq;
        label101:
        IC.g();
      }
    }
    finally
    {
      r();
    }
    return null;
    if (localLo.d.c)
    {
      i1 = 0;
      this.k.d();
      localaq = a(localLo);
      if (localaq == null) {
        break label101;
      }
      new aK(localaq).a(this.t);
    }
    for (;;)
    {
      for (;;)
      {
        if (i1 != 0) {}
        try
        {
          IC.g();
          r();
        }
        catch (Exception localException2)
        {
          IC.g();
          r();
        }
      }
      IC.g();
    }
  }
  
  public String c()
  {
    return "com.crashlytics.sdk.android:crashlytics";
  }
  
  public String d()
  {
    return "2.2.2.37";
  }
  
  public Collection<? extends IM> e()
  {
    return this.h;
  }
  
  Map<String, String> g()
  {
    return Collections.unmodifiableMap(this.g);
  }
  
  String h()
  {
    return this.p;
  }
  
  String i()
  {
    return this.q;
  }
  
  String j()
  {
    return this.s;
  }
  
  String k()
  {
    return this.r;
  }
  
  String l()
  {
    return Jg.b(f().C(), "com.crashlytics.ApiEndpoint");
  }
  
  Y m()
  {
    return this.k;
  }
  
  String n()
  {
    if (B().a()) {}
    for (String str = this.l;; str = null) {
      return str;
    }
  }
  
  String o()
  {
    if (B().a()) {}
    for (String str = this.m;; str = null) {
      return str;
    }
  }
  
  String p()
  {
    if (B().a()) {}
    for (String str = this.n;; str = null) {
      return str;
    }
  }
  
  void q()
  {
    this.x.a(new I(this));
  }
  
  void r()
  {
    this.x.b(new J(this));
  }
  
  boolean s()
  {
    return ((Boolean)this.x.a(new K(this))).booleanValue();
  }
  
  br t()
  {
    br localbr = null;
    if (this.y != null) {
      localbr = this.y.a();
    }
    return localbr;
  }
  
  File u()
  {
    return new KP(this).a();
  }
  
  boolean v()
  {
    return ((Boolean)Li.a().a(new L(this), Boolean.valueOf(false))).booleanValue();
  }
  
  boolean w()
  {
    return new KR(this).a().getBoolean("always_send_reports_opt_in", false);
  }
  
  boolean x()
  {
    return ((Boolean)Li.a().a(new M(this), Boolean.valueOf(true))).booleanValue();
  }
  
  Lh y()
  {
    Lo localLo = Li.a().b();
    if (localLo == null) {}
    for (Lh localLh = null;; localLh = localLo.b) {
      return localLh;
    }
  }
}


/* Location:           C:\Users\dreadiscool\Desktop\tools\classes-dex2jar.jar
 * Qualified Name:     G
 * JD-Core Version:    0.7.0.1
 */