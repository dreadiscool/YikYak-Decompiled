import android.annotation.SuppressLint;
import android.content.Context;
import android.content.SharedPreferences;
import android.content.SharedPreferences.Editor;
import android.text.TextUtils;

class IW
{
  private final Context a;
  private final KQ b;
  
  public IW(Context paramContext)
  {
    this.a = paramContext.getApplicationContext();
    this.b = new KR(paramContext, "TwitterAdvertisingInfoPreferences");
  }
  
  private void a(IV paramIV)
  {
    new Thread(new IX(this, paramIV)).start();
  }
  
  @SuppressLint({"CommitPrefEdits"})
  private void b(IV paramIV)
  {
    if (c(paramIV)) {
      this.b.a(this.b.b().putString("advertising_id", paramIV.a).putBoolean("limit_ad_tracking_enabled", paramIV.b));
    }
    for (;;)
    {
      return;
      this.b.a(this.b.b().remove("advertising_id").remove("limit_ad_tracking_enabled"));
    }
  }
  
  private boolean c(IV paramIV)
  {
    if ((paramIV != null) && (!TextUtils.isEmpty(paramIV.a))) {}
    for (boolean bool = true;; bool = false) {
      return bool;
    }
  }
  
  private IV e()
  {
    IV localIV = c().a();
    if (!c(localIV))
    {
      localIV = d().a();
      if (!c(localIV)) {
        IC.g();
      }
    }
    for (;;)
    {
      return localIV;
      IC.g();
      continue;
      IC.g();
    }
  }
  
  public IV a()
  {
    IV localIV = b();
    if (c(localIV))
    {
      IC.g();
      a(localIV);
    }
    for (;;)
    {
      return localIV;
      localIV = e();
      b(localIV);
    }
  }
  
  protected IV b()
  {
    return new IV(this.b.a().getString("advertising_id", ""), this.b.a().getBoolean("limit_ad_tracking_enabled", false));
  }
  
  public Jd c()
  {
    return new IY(this.a);
  }
  
  public Jd d()
  {
    return new IZ(this.a);
  }
}


/* Location:           C:\Users\dreadiscool\Desktop\tools\classes-dex2jar.jar
 * Qualified Name:     IW
 * JD-Core Version:    0.7.0.1
 */