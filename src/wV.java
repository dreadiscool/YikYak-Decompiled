import android.app.Activity;
import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.IntentFilter;
import android.net.ConnectivityManager;
import android.net.NetworkInfo;
import java.util.Date;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import org.json.JSONArray;
import org.json.JSONObject;

public class wV
{
  private static volatile wV s = null;
  protected wU a;
  protected boolean b;
  protected boolean c;
  public boolean d;
  public boolean e;
  protected boolean f;
  public boolean g;
  protected BroadcastReceiver h;
  protected wW i;
  protected Context j;
  public ExecutorService k;
  protected ExecutorService l;
  protected wR m;
  private final String n = "heF9BATUfWuISyO8";
  private xb o;
  private wQ p;
  private boolean q;
  private boolean r;
  
  public static wV a()
  {
    try
    {
      wV localwV = s;
      return localwV;
    }
    finally
    {
      localObject = finally;
      throw localObject;
    }
  }
  
  public static void a(Context paramContext, String paramString1, String paramString2)
  {
    wV localwV = new wV();
    s = localwV;
    localwV.j = paramContext.getApplicationContext();
    s.l = Executors.newSingleThreadExecutor();
    s.l.execute(new xc(paramString1, paramString2));
  }
  
  private void a(Object paramObject, JSONArray paramJSONArray, double paramDouble, String paramString1, String paramString2, String paramString3, String paramString4)
  {
    for (;;)
    {
      try
      {
        boolean bool = this.c;
        if (!bool) {
          return;
        }
        b();
        this.i.a("conversion");
        Date localDate = new Date();
        if (!(paramObject instanceof String)) {
          break label232;
        }
        if (paramObject.equals("close")) {
          continue;
        }
        if ((paramObject.equals("open")) || (paramObject.equals("install")) || (paramObject.equals("update")) || (paramObject.equals("session")))
        {
          this.i.a("session");
          new Date(60000L + localDate.getTime());
          this.i.R(Double.toString(paramDouble));
          if (paramDouble > 0.0D) {
            this.i.F(Integer.toString(1));
          }
          this.i.h(paramString1);
          this.i.Q(paramString2);
          a(wY.a(this.q, this.r), wY.a(), wY.a(paramJSONArray, paramString3, paramString4), this.f);
          this.f = false;
          b();
          this.i.b();
          continue;
        }
        this.i.x((String)paramObject);
      }
      finally {}
      continue;
      label232:
      if ((paramObject instanceof Integer)) {
        this.i.v(Integer.toString(((Integer)paramObject).intValue()));
      }
    }
  }
  
  public static boolean a(Context paramContext)
  {
    NetworkInfo localNetworkInfo = ((ConnectivityManager)paramContext.getSystemService("connectivity")).getActiveNetworkInfo();
    if ((localNetworkInfo != null) && (localNetworkInfo.isConnected())) {}
    for (boolean bool = true;; bool = false) {
      return bool;
    }
  }
  
  private void h()
  {
    Date localDate = null;
    for (;;)
    {
      if (this.i != null) {}
      do
      {
        return;
        if (localDate == null) {
          localDate = new Date(1000L + new Date().getTime());
        }
      } while (localDate.before(new Date()));
      try
      {
        Thread.sleep(50L);
      }
      catch (InterruptedException localInterruptedException) {}
    }
  }
  
  public void a(Activity paramActivity)
  {
    this.l.execute(new wZ(this, paramActivity));
  }
  
  public void a(String paramString)
  {
    this.l.execute(new xd(this, paramString));
  }
  
  protected void a(String paramString1, String paramString2)
  {
    wW.a(this.j, paramString1, paramString2);
    this.i = wW.a();
    this.k = Executors.newSingleThreadExecutor();
    this.o = new xb();
    this.p = new wQ(paramString2.trim(), "heF9BATUfWuISyO8");
    this.f = true;
    this.c = false;
    this.b = false;
    this.q = false;
    this.r = false;
    this.m = new wR(this.j, this);
    b();
    this.h = new xe(this);
    if (this.b) {}
    try
    {
      this.j.unregisterReceiver(this.h);
      label126:
      this.b = false;
      IntentFilter localIntentFilter = new IntentFilter("android.net.conn.CONNECTIVITY_CHANGE");
      this.j.registerReceiver(this.h, localIntentFilter);
      this.b = true;
      this.c = true;
      return;
    }
    catch (IllegalArgumentException localIllegalArgumentException)
    {
      break label126;
    }
  }
  
  protected void a(String paramString1, String paramString2, JSONObject paramJSONObject, boolean paramBoolean)
  {
    ExecutorService localExecutorService = this.k;
    wR localwR = this.m;
    localwR.getClass();
    localExecutorService.execute(new wS(localwR, paramString1, paramString2, paramJSONObject, paramBoolean));
  }
  
  public void a(String paramString, boolean paramBoolean)
  {
    if (paramBoolean) {}
    for (int i1 = 1;; i1 = 0)
    {
      this.l.execute(new wX(this, paramString, i1));
      return;
    }
  }
  
  /* Error */
  protected boolean a(String paramString1, String paramString2, JSONObject paramJSONObject)
  {
    // Byte code:
    //   0: iconst_1
    //   1: istore 4
    //   3: aload_2
    //   4: aload_0
    //   5: getfield 240	wV:p	LwQ;
    //   8: invokestatic 291	wY:a	(Ljava/lang/String;LwQ;)Ljava/lang/String;
    //   11: astore 5
    //   13: new 293	java/lang/StringBuilder
    //   16: dup
    //   17: aload_1
    //   18: invokestatic 297	java/lang/String:valueOf	(Ljava/lang/Object;)Ljava/lang/String;
    //   21: invokespecial 298	java/lang/StringBuilder:<init>	(Ljava/lang/String;)V
    //   24: ldc_w 300
    //   27: invokevirtual 304	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   30: aload 5
    //   32: invokevirtual 304	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   35: invokevirtual 306	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   38: astore 6
    //   40: aload_0
    //   41: getfield 232	wV:o	Lxb;
    //   44: aload 6
    //   46: aload_3
    //   47: aload_0
    //   48: getfield 141	wV:q	Z
    //   51: invokevirtual 309	xb:a	(Ljava/lang/String;Lorg/json/JSONObject;Z)Lorg/json/JSONObject;
    //   54: astore 7
    //   56: aload 7
    //   58: ifnonnull +6 -> 64
    //   61: iload 4
    //   63: ireturn
    //   64: aload 7
    //   66: ldc_w 311
    //   69: invokevirtual 317	org/json/JSONObject:has	(Ljava/lang/String;)Z
    //   72: ifne +9 -> 81
    //   75: iconst_0
    //   76: istore 4
    //   78: goto -17 -> 61
    //   81: aload_0
    //   82: getfield 319	wV:a	LwU;
    //   85: ifnull +24 -> 109
    //   88: aload 7
    //   90: ldc_w 311
    //   93: invokevirtual 323	org/json/JSONObject:getString	(Ljava/lang/String;)Ljava/lang/String;
    //   96: ldc_w 325
    //   99: invokevirtual 326	java/lang/String:equals	(Ljava/lang/Object;)Z
    //   102: istore 20
    //   104: iload 20
    //   106: ifeq +3 -> 109
    //   109: aload 7
    //   111: ldc_w 328
    //   114: invokevirtual 323	org/json/JSONObject:getString	(Ljava/lang/String;)Ljava/lang/String;
    //   117: ldc 102
    //   119: invokevirtual 326	java/lang/String:equals	(Ljava/lang/Object;)Z
    //   122: ifeq +44 -> 166
    //   125: aload 7
    //   127: ldc_w 330
    //   130: invokevirtual 323	org/json/JSONObject:getString	(Ljava/lang/String;)Ljava/lang/String;
    //   133: astore 18
    //   135: aload_0
    //   136: invokevirtual 332	wV:e	()Ljava/lang/String;
    //   139: ldc_w 334
    //   142: invokevirtual 326	java/lang/String:equals	(Ljava/lang/Object;)Z
    //   145: ifeq +12 -> 157
    //   148: aload_0
    //   149: getfield 82	wV:i	LwW;
    //   152: aload 18
    //   154: invokevirtual 337	wW:L	(Ljava/lang/String;)V
    //   157: aload_0
    //   158: getfield 82	wV:i	LwW;
    //   161: aload 18
    //   163: invokevirtual 340	wW:H	(Ljava/lang/String;)V
    //   166: aload_0
    //   167: getfield 141	wV:q	Z
    //   170: ifeq -109 -> 61
    //   173: new 293	java/lang/StringBuilder
    //   176: dup
    //   177: ldc_w 342
    //   180: invokespecial 298	java/lang/StringBuilder:<init>	(Ljava/lang/String;)V
    //   183: aload 7
    //   185: invokevirtual 343	org/json/JSONObject:toString	()Ljava/lang/String;
    //   188: invokevirtual 304	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   191: invokevirtual 306	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   194: pop
    //   195: aload 7
    //   197: invokevirtual 346	org/json/JSONObject:length	()I
    //   200: ifle -139 -> 61
    //   203: aload 7
    //   205: ldc_w 348
    //   208: invokevirtual 317	org/json/JSONObject:has	(Ljava/lang/String;)Z
    //   211: ifeq +132 -> 343
    //   214: aload 7
    //   216: ldc_w 348
    //   219: invokevirtual 323	org/json/JSONObject:getString	(Ljava/lang/String;)Ljava/lang/String;
    //   222: ldc_w 350
    //   225: invokevirtual 326	java/lang/String:equals	(Ljava/lang/Object;)Z
    //   228: ifne +115 -> 343
    //   231: aload 7
    //   233: ldc_w 348
    //   236: invokevirtual 354	org/json/JSONObject:getJSONObject	(Ljava/lang/String;)Lorg/json/JSONObject;
    //   239: astore 14
    //   241: aload 14
    //   243: ldc 84
    //   245: invokevirtual 317	org/json/JSONObject:has	(Ljava/lang/String;)Z
    //   248: ifeq -187 -> 61
    //   251: aload 14
    //   253: ldc 84
    //   255: invokevirtual 354	org/json/JSONObject:getJSONObject	(Ljava/lang/String;)Lorg/json/JSONObject;
    //   258: astore 15
    //   260: aload 15
    //   262: ldc_w 356
    //   265: invokevirtual 317	org/json/JSONObject:has	(Ljava/lang/String;)Z
    //   268: ifeq -207 -> 61
    //   271: aload 15
    //   273: ldc_w 356
    //   276: invokevirtual 323	org/json/JSONObject:getString	(Ljava/lang/String;)Ljava/lang/String;
    //   279: ldc_w 358
    //   282: invokevirtual 326	java/lang/String:equals	(Ljava/lang/Object;)Z
    //   285: ifeq -224 -> 61
    //   288: aload 15
    //   290: ldc_w 360
    //   293: invokevirtual 323	org/json/JSONObject:getString	(Ljava/lang/String;)Ljava/lang/String;
    //   296: astore 16
    //   298: new 293	java/lang/StringBuilder
    //   301: dup
    //   302: ldc_w 362
    //   305: invokespecial 298	java/lang/StringBuilder:<init>	(Ljava/lang/String;)V
    //   308: aload 16
    //   310: invokevirtual 304	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   313: invokevirtual 306	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   316: pop
    //   317: goto -256 -> 61
    //   320: astore 10
    //   322: aload 10
    //   324: invokevirtual 365	org/json/JSONException:printStackTrace	()V
    //   327: goto -266 -> 61
    //   330: astore 19
    //   332: aload 19
    //   334: invokevirtual 365	org/json/JSONException:printStackTrace	()V
    //   337: iconst_0
    //   338: istore 4
    //   340: goto -279 -> 61
    //   343: aload 7
    //   345: ldc_w 367
    //   348: invokevirtual 317	org/json/JSONObject:has	(Ljava/lang/String;)Z
    //   351: ifeq -290 -> 61
    //   354: aload 7
    //   356: ldc_w 367
    //   359: invokevirtual 354	org/json/JSONObject:getJSONObject	(Ljava/lang/String;)Lorg/json/JSONObject;
    //   362: astore 11
    //   364: aload 11
    //   366: ldc_w 369
    //   369: invokevirtual 317	org/json/JSONObject:has	(Ljava/lang/String;)Z
    //   372: ifeq -311 -> 61
    //   375: aload 11
    //   377: ldc_w 369
    //   380: invokevirtual 323	org/json/JSONObject:getString	(Ljava/lang/String;)Ljava/lang/String;
    //   383: astore 12
    //   385: new 293	java/lang/StringBuilder
    //   388: dup
    //   389: ldc_w 371
    //   392: invokespecial 298	java/lang/StringBuilder:<init>	(Ljava/lang/String;)V
    //   395: aload 12
    //   397: invokevirtual 304	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   400: ldc_w 373
    //   403: invokevirtual 304	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   406: invokevirtual 306	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   409: pop
    //   410: goto -349 -> 61
    //   413: astore 8
    //   415: goto -249 -> 166
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	418	0	this	wV
    //   0	418	1	paramString1	String
    //   0	418	2	paramString2	String
    //   0	418	3	paramJSONObject	JSONObject
    //   1	338	4	bool1	boolean
    //   11	20	5	str1	String
    //   38	7	6	str2	String
    //   54	301	7	localJSONObject1	JSONObject
    //   413	1	8	localJSONException1	org.json.JSONException
    //   320	3	10	localJSONException2	org.json.JSONException
    //   362	14	11	localJSONObject2	JSONObject
    //   383	13	12	str3	String
    //   239	13	14	localJSONObject3	JSONObject
    //   258	31	15	localJSONObject4	JSONObject
    //   296	13	16	str4	String
    //   133	29	18	str5	String
    //   330	3	19	localJSONException3	org.json.JSONException
    //   102	3	20	bool2	boolean
    // Exception table:
    //   from	to	target	type
    //   203	317	320	org/json/JSONException
    //   343	410	320	org/json/JSONException
    //   88	104	330	org/json/JSONException
    //   109	166	413	org/json/JSONException
  }
  
  protected void b()
  {
    if (!a(this.j)) {}
    for (;;)
    {
      return;
      ExecutorService localExecutorService = this.k;
      wR localwR = this.m;
      localwR.getClass();
      localExecutorService.execute(new wT(localwR));
    }
  }
  
  public void c()
  {
    this.l.execute(new xf(this));
  }
  
  public String d()
  {
    h();
    return this.i.n();
  }
  
  public String e()
  {
    h();
    return this.i.ac();
  }
  
  public String f()
  {
    h();
    return this.i.aj();
  }
}


/* Location:           C:\Users\dreadiscool\Desktop\tools\classes-dex2jar.jar
 * Qualified Name:     wV
 * JD-Core Version:    0.7.0.1
 */