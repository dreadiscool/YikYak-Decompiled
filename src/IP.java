import android.content.Context;
import android.content.pm.ApplicationInfo;
import android.content.pm.PackageInfo;
import android.content.pm.PackageManager;
import android.content.pm.PackageManager.NameNotFoundException;
import java.util.Collection;

class IP
  extends IM<Boolean>
{
  private final Collection<IM> a;
  private final KK g;
  private PackageManager h;
  private String i;
  private PackageInfo j;
  private String k;
  private String l;
  private String m;
  private String n;
  private String o;
  
  public IP(Collection<IM> paramCollection)
  {
    this.a = paramCollection;
    this.g = new Kz();
  }
  
  private KV a(Lf paramLf, Collection<IM> paramCollection)
  {
    Context localContext = C();
    String str1 = new Je().a(localContext);
    String str2 = Jg.m(localContext);
    String[] arrayOfString = new String[1];
    arrayOfString[0] = str2;
    String str3 = Jg.a(arrayOfString);
    int i1 = Jm.a(this.m).a();
    return new KV(str1, B().c(), this.l, this.k, str3, this.n, i1, this.o, "0", paramLf, paramCollection);
  }
  
  private boolean a(KW paramKW, Lf paramLf, Collection<IM> paramCollection)
  {
    KV localKV = a(paramLf, paramCollection);
    return new Lt(this, e(), paramKW.c, this.g).a(localKV);
  }
  
  private boolean a(String paramString, KW paramKW, Collection<IM> paramCollection)
  {
    boolean bool = true;
    if ("new".equals(paramKW.b)) {
      if (b(paramString, paramKW, paramCollection)) {
        bool = Li.a().d();
      }
    }
    for (;;)
    {
      return bool;
      IC.g();
      bool = false;
      continue;
      if ("configured".equals(paramKW.b))
      {
        bool = Li.a().d();
      }
      else if (paramKW.e)
      {
        IC.g();
        c(paramString, paramKW, paramCollection);
      }
    }
  }
  
  private boolean b(String paramString, KW paramKW, Collection<IM> paramCollection)
  {
    KV localKV = a(Lf.a(C(), paramString), paramCollection);
    return new KZ(this, e(), paramKW.c, this.g).a(localKV);
  }
  
  private boolean c(String paramString, KW paramKW, Collection<IM> paramCollection)
  {
    return a(paramKW, Lf.a(C(), paramString), paramCollection);
  }
  
  protected boolean a()
  {
    bool = false;
    try
    {
      this.m = B().h();
      this.h = C().getPackageManager();
      this.i = C().getPackageName();
      this.j = this.h.getPackageInfo(this.i, 0);
      this.k = Integer.toString(this.j.versionCode);
      if (this.j.versionName == null) {}
      for (String str = "0.0";; str = this.j.versionName)
      {
        this.l = str;
        this.n = this.h.getApplicationLabel(C().getApplicationInfo()).toString();
        this.o = Integer.toString(C().getApplicationInfo().targetSdkVersion);
        bool = true;
        break;
      }
      return bool;
    }
    catch (PackageManager.NameNotFoundException localNameNotFoundException)
    {
      IC.g();
    }
  }
  
  protected Boolean b()
  {
    str = Jg.k(C());
    try
    {
      Li.a().a(this, this.f, this.g, this.k, this.l, e()).c();
      Lo localLo2 = Li.a().b();
      localLo1 = localLo2;
    }
    catch (Exception localException1)
    {
      for (;;)
      {
        try
        {
          boolean bool2 = a(str, localLo1.a, this.a);
          bool1 = bool2;
          return Boolean.valueOf(bool1);
        }
        catch (Exception localException2)
        {
          Lo localLo1;
          IC.g();
        }
        localException1 = localException1;
        IC.g();
        localLo1 = null;
        continue;
        boolean bool1 = false;
      }
    }
    if (localLo1 == null) {}
  }
  
  public String c()
  {
    return "io.fabric.sdk.android:fabric";
  }
  
  public String d()
  {
    return "1.2.0.37";
  }
  
  String e()
  {
    return Jg.b(C(), "com.crashlytics.ApiEndpoint");
  }
}


/* Location:           C:\Users\dreadiscool\Desktop\tools\classes-dex2jar.jar
 * Qualified Name:     IP
 * JD-Core Version:    0.7.0.1
 */