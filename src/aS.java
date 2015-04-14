import android.annotation.SuppressLint;
import android.annotation.TargetApi;
import android.app.Application;
import android.content.Context;
import android.content.SharedPreferences;
import android.content.SharedPreferences.Editor;
import android.content.pm.ApplicationInfo;
import android.content.pm.PackageInfo;
import android.content.pm.PackageManager;
import android.os.Build.VERSION;
import java.io.File;
import java.util.Map;
import java.util.UUID;

abstract class aS
  extends IM<Boolean>
{
  aZ a;
  private String g;
  private String h;
  private KQ i;
  private long j;
  
  @SuppressLint({"CommitPrefEdits"})
  @TargetApi(14)
  private void a(Context paramContext)
  {
    try
    {
      aY localaY = new aY(paramContext, new be(), new JC(), new Kv(C(), h(), "session_analytics.tap", "session_analytics_to_send"));
      Js localJs = B();
      Map localMap = localJs.g();
      String str1 = paramContext.getPackageName();
      String str2 = localJs.b();
      String str3 = (String)localMap.get(Jt.d);
      String str4 = (String)localMap.get(Jt.g);
      String str5 = (String)localMap.get(Jt.c);
      String str6 = Jg.m(paramContext);
      String str7 = localJs.d();
      String str8 = localJs.e();
      bd localbd = new bd(str1, UUID.randomUUID().toString(), str2, str3, str4, str5, str6, str7, str8, this.g, this.h);
      Application localApplication = (Application)C().getApplicationContext();
      if ((localApplication != null) && (Build.VERSION.SDK_INT >= 14)) {}
      for (this.a = aT.a(localApplication, localbd, localaY, new Kz(IC.g())); a(this.j); this.a = aZ.a(paramContext, localbd, localaY, new Kz(IC.g())))
      {
        IC.g();
        this.a.b();
        this.i.a(this.i.b().putBoolean("analytics_launched", true));
        break;
      }
      return;
    }
    catch (Exception localException)
    {
      Jg.a(paramContext, "Crashlytics failed to initialize session analytics.", localException);
    }
  }
  
  public void a(Jk paramJk)
  {
    if (this.a != null) {
      this.a.a(paramJk.a());
    }
  }
  
  @SuppressLint({"NewApi"})
  protected boolean a()
  {
    boolean bool = false;
    try
    {
      this.i = new KR(this);
      Context localContext = C();
      PackageInfo localPackageInfo = localContext.getPackageManager().getPackageInfo(localContext.getPackageName(), 0);
      this.g = Integer.toString(localPackageInfo.versionCode);
      if (localPackageInfo.versionName == null) {}
      for (String str = "0.0";; str = localPackageInfo.versionName)
      {
        this.h = str;
        if (Build.VERSION.SDK_INT < 9) {
          break;
        }
        this.j = localPackageInfo.firstInstallTime;
        break label138;
      }
      this.j = new File(localContext.getPackageManager().getApplicationInfo(localContext.getPackageName(), 0).sourceDir).lastModified();
    }
    catch (Exception localException)
    {
      IC.g();
      return bool;
    }
    label138:
    bool = true;
    return bool;
  }
  
  boolean a(long paramLong)
  {
    if ((!g()) && (b(paramLong))) {}
    for (boolean bool = true;; bool = false) {
      return bool;
    }
  }
  
  boolean b(long paramLong)
  {
    if (System.currentTimeMillis() - paramLong < 3600000L) {}
    for (boolean bool = true;; bool = false) {
      return bool;
    }
  }
  
  public String c()
  {
    return "com.crashlytics.sdk.android:answers";
  }
  
  public String d()
  {
    return "1.1.2.37";
  }
  
  protected Boolean e()
  {
    Context localContext = C();
    a(localContext);
    Object localObject;
    try
    {
      Lo localLo = Li.a().b();
      if (localLo == null)
      {
        localObject = Boolean.valueOf(false);
      }
      else if (localLo.d.d)
      {
        this.a.a(localLo.e, f());
        localObject = Boolean.valueOf(true);
      }
      else
      {
        Jg.a(localContext, "Disabling analytics collection based on settings flag value.");
        this.a.a();
        Boolean localBoolean = Boolean.valueOf(false);
        localObject = localBoolean;
      }
    }
    catch (Exception localException)
    {
      IC.g();
      localObject = Boolean.valueOf(false);
    }
    return localObject;
  }
  
  String f()
  {
    return Jg.b(C(), "com.crashlytics.ApiEndpoint");
  }
  
  boolean g()
  {
    return this.i.a().getBoolean("analytics_launched", false);
  }
  
  File h()
  {
    return new KP(this).a();
  }
}


/* Location:           C:\Users\dreadiscool\Desktop\tools\classes-dex2jar.jar
 * Qualified Name:     aS
 * JD-Core Version:    0.7.0.1
 */