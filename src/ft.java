import android.app.Activity;
import android.content.Intent;
import com.google.android.gms.analytics.Tracker;
import java.util.HashMap;
import java.util.Map;

public class ft
  implements fm
{
  private boolean b = false;
  private int c = 0;
  private long d = -1L;
  private boolean e = false;
  private long f;
  private it g = iu.c();
  
  public ft(Tracker paramTracker) {}
  
  private void e()
  {
    fl localfl = fl.a();
    if (localfl == null) {
      fA.a("GoogleAnalytics isn't initialized for the Tracker!");
    }
    for (;;)
    {
      return;
      if ((this.d >= 0L) || (this.b)) {
        localfl.a(Tracker.b(this.a));
      } else {
        localfl.b(Tracker.b(this.a));
      }
    }
  }
  
  public long a()
  {
    return this.d;
  }
  
  public void a(long paramLong)
  {
    this.d = paramLong;
    e();
  }
  
  public void a(Activity paramActivity)
  {
    gH.a().a(gI.ai);
    if ((this.c == 0) && (d())) {
      this.e = true;
    }
    this.c = (1 + this.c);
    HashMap localHashMap;
    Tracker localTracker;
    if (this.b)
    {
      Intent localIntent = paramActivity.getIntent();
      if (localIntent != null) {
        this.a.setCampaignParamsOnNextHit(localIntent.getData());
      }
      localHashMap = new HashMap();
      localHashMap.put("&t", "screenview");
      gH.a().a(true);
      localTracker = this.a;
      if (Tracker.c(this.a) == null) {
        break label145;
      }
    }
    label145:
    for (String str = Tracker.c(this.a).a(paramActivity);; str = paramActivity.getClass().getCanonicalName())
    {
      localTracker.set("&cd", str);
      this.a.send(localHashMap);
      gH.a().a(false);
      return;
    }
  }
  
  public void a(boolean paramBoolean)
  {
    this.b = paramBoolean;
    e();
  }
  
  public void b(Activity paramActivity)
  {
    gH.a().a(gI.aj);
    this.c = (-1 + this.c);
    this.c = Math.max(0, this.c);
    if (this.c == 0) {
      this.f = this.g.b();
    }
  }
  
  public boolean b()
  {
    return this.b;
  }
  
  public boolean c()
  {
    boolean bool = this.e;
    this.e = false;
    return bool;
  }
  
  boolean d()
  {
    if (this.g.b() >= this.f + Math.max(1000L, this.d)) {}
    for (boolean bool = true;; bool = false) {
      return bool;
    }
  }
}


/* Location:           C:\Users\dreadiscool\Desktop\tools\classes-dex2jar.jar
 * Qualified Name:     ft
 * JD-Core Version:    0.7.0.1
 */