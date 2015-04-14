import android.annotation.TargetApi;
import android.content.Context;
import android.os.Build.VERSION;
import android.text.TextUtils;
import java.util.HashMap;
import java.util.Map;

public class bh
  extends IM<Boolean>
  implements Jn
{
  private final IR<String> a = new IR();
  private final bn g = new bn();
  
  /* Error */
  private bi a(Context paramContext)
  {
    // Byte code:
    //   0: aconst_null
    //   1: astore_2
    //   2: aload_1
    //   3: invokevirtual 37	android/content/Context:getAssets	()Landroid/content/res/AssetManager;
    //   6: ldc 39
    //   8: invokevirtual 45	android/content/res/AssetManager:open	(Ljava/lang/String;)Ljava/io/InputStream;
    //   11: astore 12
    //   13: aload 12
    //   15: astore 4
    //   17: aload 4
    //   19: ifnull +72 -> 91
    //   22: aload 4
    //   24: invokestatic 50	bi:a	(Ljava/io/InputStream;)Lbi;
    //   27: astore_2
    //   28: invokestatic 55	IC:g	()LIO;
    //   31: pop
    //   32: new 57	java/lang/StringBuilder
    //   35: dup
    //   36: invokespecial 58	java/lang/StringBuilder:<init>	()V
    //   39: aload_2
    //   40: getfield 62	bi:d	Ljava/lang/String;
    //   43: invokevirtual 66	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   46: ldc 68
    //   48: invokevirtual 66	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   51: aload_2
    //   52: getfield 71	bi:b	Ljava/lang/String;
    //   55: invokevirtual 66	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   58: ldc 73
    //   60: invokevirtual 66	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   63: aload_2
    //   64: getfield 75	bi:a	Ljava/lang/String;
    //   67: invokevirtual 66	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   70: ldc 77
    //   72: invokevirtual 66	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   75: ldc 79
    //   77: invokevirtual 66	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   80: aload_2
    //   81: getfield 82	bi:c	Ljava/lang/String;
    //   84: invokevirtual 66	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   87: invokevirtual 86	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   90: pop
    //   91: aload 4
    //   93: ifnull +8 -> 101
    //   96: aload 4
    //   98: invokevirtual 91	java/io/InputStream:close	()V
    //   101: aload_2
    //   102: areturn
    //   103: astore 13
    //   105: invokestatic 55	IC:g	()LIO;
    //   108: pop
    //   109: goto -8 -> 101
    //   112: astore 8
    //   114: aconst_null
    //   115: astore 4
    //   117: invokestatic 55	IC:g	()LIO;
    //   120: pop
    //   121: aload 4
    //   123: ifnull -22 -> 101
    //   126: aload 4
    //   128: invokevirtual 91	java/io/InputStream:close	()V
    //   131: goto -30 -> 101
    //   134: astore 10
    //   136: invokestatic 55	IC:g	()LIO;
    //   139: pop
    //   140: goto -39 -> 101
    //   143: astore_3
    //   144: aconst_null
    //   145: astore 4
    //   147: aload_3
    //   148: astore 5
    //   150: aload 4
    //   152: ifnull +8 -> 160
    //   155: aload 4
    //   157: invokevirtual 91	java/io/InputStream:close	()V
    //   160: aload 5
    //   162: athrow
    //   163: astore 6
    //   165: invokestatic 55	IC:g	()LIO;
    //   168: pop
    //   169: goto -9 -> 160
    //   172: astore 5
    //   174: goto -24 -> 150
    //   177: astore 15
    //   179: goto -62 -> 117
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	182	0	this	bh
    //   0	182	1	paramContext	Context
    //   1	101	2	localbi	bi
    //   143	5	3	localObject1	Object
    //   15	141	4	localInputStream1	java.io.InputStream
    //   148	13	5	localObject2	Object
    //   172	1	5	localObject3	Object
    //   163	1	6	localIOException1	java.io.IOException
    //   112	1	8	localException1	Exception
    //   134	1	10	localIOException2	java.io.IOException
    //   11	3	12	localInputStream2	java.io.InputStream
    //   103	1	13	localIOException3	java.io.IOException
    //   177	1	15	localException2	Exception
    // Exception table:
    //   from	to	target	type
    //   96	101	103	java/io/IOException
    //   2	13	112	java/lang/Exception
    //   126	131	134	java/io/IOException
    //   2	13	143	finally
    //   155	160	163	java/io/IOException
    //   22	91	172	finally
    //   117	121	172	finally
    //   22	91	177	java/lang/Exception
  }
  
  private String a(Context paramContext, String paramString)
  {
    Object localObject = null;
    if (a(paramString, Build.VERSION.SDK_INT)) {
      IC.g();
    }
    for (;;)
    {
      try
      {
        String str = (String)this.a.a(paramContext, this.g);
        boolean bool = "".equals(str);
        if (bool) {
          str = null;
        }
        localObject = str;
      }
      catch (Exception localException)
      {
        IC.g();
        continue;
      }
      return localObject;
      IC.g();
    }
  }
  
  private void a(Context paramContext, Js paramJs, KX paramKX, bi parambi)
  {
    new bj(paramContext, this, paramJs, paramKX, parambi, new KR(IC.a(bh.class)), new JC(), new Kz(IC.g())).a();
  }
  
  private KX g()
  {
    Lo localLo = Li.a().b();
    if (localLo != null) {}
    for (KX localKX = localLo.f;; localKX = null) {
      return localKX;
    }
  }
  
  boolean a(KX paramKX, bi parambi)
  {
    if ((paramKX != null) && (!TextUtils.isEmpty(paramKX.a)) && (parambi != null)) {}
    for (boolean bool = true;; bool = false) {
      return bool;
    }
  }
  
  @TargetApi(11)
  boolean a(String paramString, int paramInt)
  {
    boolean bool;
    if (paramInt < 11) {
      if (paramString == null) {
        bool = true;
      }
    }
    for (;;)
    {
      return bool;
      bool = false;
      continue;
      bool = "io.crash.air".equals(paramString);
    }
  }
  
  protected Boolean b()
  {
    IC.g();
    Context localContext = C();
    Js localJs = B();
    if (TextUtils.isEmpty(a(localContext, localJs.h()))) {
      IC.g();
    }
    for (Boolean localBoolean = Boolean.valueOf(false);; localBoolean = Boolean.valueOf(true))
    {
      return localBoolean;
      IC.g();
      KX localKX = g();
      bi localbi = a(localContext);
      if (a(localKX, localbi)) {
        a(localContext, localJs, localKX, localbi);
      }
    }
  }
  
  public String c()
  {
    return "com.crashlytics.sdk.android:beta";
  }
  
  public String d()
  {
    return "1.1.2.37";
  }
  
  public Map<Jt, String> e()
  {
    String str1 = B().h();
    String str2 = a(C(), str1);
    HashMap localHashMap = new HashMap();
    if (!TextUtils.isEmpty(str2)) {
      localHashMap.put(Jt.c, str2);
    }
    return localHashMap;
  }
  
  String f()
  {
    return Jg.b(C(), "com.crashlytics.ApiEndpoint");
  }
}


/* Location:           C:\Users\dreadiscool\Desktop\tools\classes-dex2jar.jar
 * Qualified Name:     bh
 * JD-Core Version:    0.7.0.1
 */