import android.app.Activity;
import android.app.Application;
import android.content.Context;
import android.content.pm.ApplicationInfo;
import android.content.pm.PackageManager;
import android.content.pm.PackageManager.NameNotFoundException;
import android.os.Build.VERSION;
import android.os.Bundle;
import java.util.HashSet;
import java.util.Iterator;
import java.util.Set;

public class fl
  extends fu
{
  private static boolean a;
  private static fl l;
  private boolean b;
  private fU c;
  private fG d;
  private Context e;
  private volatile Boolean f = Boolean.valueOf(false);
  private fr g;
  private String h;
  private String i;
  private Set<fm> j;
  private boolean k = false;
  
  protected fl(Context paramContext)
  {
    this(paramContext, gC.a(paramContext), gr.c());
  }
  
  private fl(Context paramContext, fU paramfU, fG paramfG)
  {
    if (paramContext == null) {
      throw new IllegalArgumentException("context cannot be null");
    }
    this.e = paramContext.getApplicationContext();
    this.c = paramfU;
    this.d = paramfG;
    fV.a(this.e);
    fF.a(this.e);
    ge.a(this.e);
    this.g = new gl();
    this.j = new HashSet();
    g();
  }
  
  private int a(String paramString)
  {
    String str = paramString.toLowerCase();
    int m;
    if ("verbose".equals(str)) {
      m = 0;
    }
    for (;;)
    {
      return m;
      if ("info".equals(str)) {
        m = 1;
      } else if ("warning".equals(str)) {
        m = 2;
      } else if ("error".equals(str)) {
        m = 3;
      } else {
        m = -1;
      }
    }
  }
  
  static fl a()
  {
    try
    {
      fl localfl = l;
      return localfl;
    }
    finally
    {
      localObject = finally;
      throw localObject;
    }
  }
  
  public static fl a(Context paramContext)
  {
    try
    {
      if (l == null) {
        l = new fl(paramContext);
      }
      fl localfl = l;
      return localfl;
    }
    finally
    {
      localObject = finally;
      throw localObject;
    }
  }
  
  private void g()
  {
    if (a) {}
    for (;;)
    {
      return;
      try
      {
        ApplicationInfo localApplicationInfo2 = this.e.getPackageManager().getApplicationInfo(this.e.getPackageName(), 129);
        localApplicationInfo1 = localApplicationInfo2;
      }
      catch (PackageManager.NameNotFoundException localNameNotFoundException)
      {
        ApplicationInfo localApplicationInfo1;
        for (;;)
        {
          fA.c("PackageManager doesn't know about package: " + localNameNotFoundException);
          localApplicationInfo1 = null;
        }
        localBundle = localApplicationInfo1.metaData;
      }
      if (localApplicationInfo1 == null)
      {
        fA.d("Couldn't get ApplicationInfo to load gloabl config.");
      }
      else
      {
        Bundle localBundle;
        if (localBundle != null)
        {
          int m = localBundle.getInt("com.google.android.gms.analytics.globalConfigResource");
          if (m > 0)
          {
            fw localfw = (fw)new gJ(this.e).a(m);
            if (localfw != null) {
              a(localfw);
            }
          }
        }
      }
    }
  }
  
  void a(Activity paramActivity)
  {
    Iterator localIterator = this.j.iterator();
    while (localIterator.hasNext()) {
      ((fm)localIterator.next()).a(paramActivity);
    }
  }
  
  public void a(Application paramApplication)
  {
    if ((Build.VERSION.SDK_INT >= 14) && (!this.k))
    {
      paramApplication.registerActivityLifecycleCallbacks(new fn(this));
      this.k = true;
    }
  }
  
  void a(fm paramfm)
  {
    this.j.add(paramfm);
    if ((this.e instanceof Application)) {
      a((Application)this.e);
    }
  }
  
  void a(fw paramfw)
  {
    fA.c("Loading global config values.");
    if (paramfw.a())
    {
      this.i = paramfw.b();
      fA.c("app name loaded: " + this.i);
    }
    if (paramfw.c())
    {
      this.h = paramfw.d();
      fA.c("app version loaded: " + this.h);
    }
    if (paramfw.e())
    {
      int m = a(paramfw.f());
      if (m >= 0)
      {
        fA.c("log level loaded: " + m);
        d().a(m);
      }
    }
    if (paramfw.g()) {
      this.d.a(paramfw.h());
    }
    if (paramfw.i()) {
      a(paramfw.j());
    }
  }
  
  /* Error */
  void a(java.util.Map<String, String> paramMap)
  {
    // Byte code:
    //   0: aload_0
    //   1: monitorenter
    //   2: aload_1
    //   3: ifnonnull +21 -> 24
    //   6: new 56	java/lang/IllegalArgumentException
    //   9: dup
    //   10: ldc_w 284
    //   13: invokespecial 61	java/lang/IllegalArgumentException:<init>	(Ljava/lang/String;)V
    //   16: athrow
    //   17: astore 4
    //   19: aload_0
    //   20: monitorexit
    //   21: aload 4
    //   23: athrow
    //   24: aload_1
    //   25: ldc_w 286
    //   28: invokestatic 292	java/util/Locale:getDefault	()Ljava/util/Locale;
    //   31: invokestatic 297	fJ:a	(Ljava/util/Locale;)Ljava/lang/String;
    //   34: invokestatic 300	fJ:a	(Ljava/util/Map;Ljava/lang/String;Ljava/lang/String;)V
    //   37: aload_1
    //   38: ldc_w 302
    //   41: invokestatic 305	fF:a	()LfF;
    //   44: invokestatic 308	fJ:a	(Ljava/util/Map;Ljava/lang/String;Lgm;)V
    //   47: aload_1
    //   48: ldc_w 310
    //   51: invokestatic 315	gH:a	()LgH;
    //   54: invokevirtual 317	gH:c	()Ljava/lang/String;
    //   57: invokeinterface 323 3 0
    //   62: pop
    //   63: invokestatic 315	gH:a	()LgH;
    //   66: invokevirtual 324	gH:b	()Ljava/lang/String;
    //   69: pop
    //   70: aload_0
    //   71: getfield 71	fl:c	LfU;
    //   74: aload_1
    //   75: invokeinterface 328 2 0
    //   80: aload_0
    //   81: monitorexit
    //   82: return
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	83	0	this	fl
    //   0	83	1	paramMap	java.util.Map<String, String>
    //   17	5	4	localObject	Object
    // Exception table:
    //   from	to	target	type
    //   6	21	17	finally
    //   24	82	17	finally
  }
  
  public void a(boolean paramBoolean)
  {
    gH.a().a(gI.ac);
    this.b = paramBoolean;
  }
  
  void b(Activity paramActivity)
  {
    Iterator localIterator = this.j.iterator();
    while (localIterator.hasNext()) {
      ((fm)localIterator.next()).b(paramActivity);
    }
  }
  
  void b(fm paramfm)
  {
    this.j.remove(paramfm);
  }
  
  public boolean b()
  {
    gH.a().a(gI.ad);
    return this.b;
  }
  
  public boolean c()
  {
    gH.a().a(gI.R);
    return this.f.booleanValue();
  }
  
  public fr d()
  {
    return this.g;
  }
  
  @Deprecated
  public void e()
  {
    this.d.a();
  }
  
  void f()
  {
    this.c.e();
  }
}


/* Location:           C:\Users\dreadiscool\Desktop\tools\classes-dex2jar.jar
 * Qualified Name:     fl
 * JD-Core Version:    0.7.0.1
 */