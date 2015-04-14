import android.annotation.TargetApi;
import android.app.Application;
import android.app.Application.ActivityLifecycleCallbacks;
import java.util.concurrent.ScheduledExecutorService;

@TargetApi(14)
class aT
  extends aZ
{
  private final Application c;
  private final Application.ActivityLifecycleCallbacks d = new aU(this);
  
  aT(bd parambd, bf parambf, Application paramApplication)
  {
    super(parambd, parambf);
    this.c = paramApplication;
    Jg.a(aR.b().C(), "Registering activity lifecycle callbacks for session analytics.");
    paramApplication.registerActivityLifecycleCallbacks(this.d);
  }
  
  public static aT a(Application paramApplication, bd parambd, aY paramaY, KK paramKK)
  {
    ScheduledExecutorService localScheduledExecutorService = Jo.b("Crashlytics Trace Manager");
    return new aT(parambd, new bf(paramApplication, new aX(paramApplication, localScheduledExecutorService, paramaY, paramKK), paramaY, localScheduledExecutorService), paramApplication);
  }
  
  public void a()
  {
    Jg.a(aR.b().C(), "Unregistering activity lifecycle callbacks for session analytics");
    this.c.unregisterActivityLifecycleCallbacks(this.d);
    super.a();
  }
}


/* Location:           C:\Users\dreadiscool\Desktop\tools\classes-dex2jar.jar
 * Qualified Name:     aT
 * JD-Core Version:    0.7.0.1
 */