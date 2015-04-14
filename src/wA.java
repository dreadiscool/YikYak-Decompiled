import android.app.Activity;
import android.app.Application.ActivityLifecycleCallbacks;
import android.hardware.Sensor;
import android.hardware.SensorManager;
import android.os.Build;
import android.os.Bundle;
import android.os.Message;

class wA
  implements Application.ActivityLifecycleCallbacks, wn
{
  private final wm b = new wm(this);
  private final wz c;
  
  public wA(ww paramww)
  {
    this.c = new wz(paramww);
  }
  
  private void a(Activity paramActivity)
  {
    if ((b()) && (!ww.c(this.a).f())) {
      this.c.a();
    }
    for (;;)
    {
      return;
      if (!ww.c(this.a).e())
      {
        SensorManager localSensorManager = (SensorManager)paramActivity.getSystemService("sensor");
        Sensor localSensor = localSensorManager.getDefaultSensor(1);
        localSensorManager.registerListener(this.b, localSensor, 3);
      }
    }
  }
  
  private void b(Activity paramActivity)
  {
    if ((b()) && (!ww.c(this.a).f())) {
      this.c.b();
    }
    for (;;)
    {
      return;
      if (!ww.c(this.a).e()) {
        ((SensorManager)paramActivity.getSystemService("sensor")).unregisterListener(this.b);
      }
    }
  }
  
  private boolean b()
  {
    boolean bool = false;
    if (!Build.HARDWARE.equals("goldfish")) {}
    for (;;)
    {
      return bool;
      if ((Build.BRAND.startsWith("generic")) && (Build.DEVICE.startsWith("generic")) && (Build.PRODUCT.contains("sdk")) && (Build.MODEL.toLowerCase().contains("sdk"))) {
        bool = true;
      }
    }
  }
  
  public void a()
  {
    Message localMessage = ww.a(this.a).obtainMessage(1);
    ww.a(this.a).sendMessage(localMessage);
  }
  
  public void onActivityCreated(Activity paramActivity, Bundle paramBundle) {}
  
  public void onActivityDestroyed(Activity paramActivity) {}
  
  public void onActivityPaused(Activity paramActivity)
  {
    ww.b(this.a).b(paramActivity);
    if (ww.b(this.a).b()) {
      b(paramActivity);
    }
  }
  
  public void onActivityResumed(Activity paramActivity)
  {
    a(paramActivity);
    ww.b(this.a).a(paramActivity);
  }
  
  public void onActivitySaveInstanceState(Activity paramActivity, Bundle paramBundle) {}
  
  public void onActivityStarted(Activity paramActivity) {}
  
  public void onActivityStopped(Activity paramActivity) {}
}


/* Location:           C:\Users\dreadiscool\Desktop\tools\classes-dex2jar.jar
 * Qualified Name:     wA
 * JD-Core Version:    0.7.0.1
 */