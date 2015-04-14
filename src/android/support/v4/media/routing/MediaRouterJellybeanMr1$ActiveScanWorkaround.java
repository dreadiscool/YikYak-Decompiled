package android.support.v4.media.routing;

import android.content.Context;
import android.hardware.display.DisplayManager;
import android.os.Build.VERSION;
import android.os.Handler;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;

public final class MediaRouterJellybeanMr1$ActiveScanWorkaround
  implements Runnable
{
  private static final int WIFI_DISPLAY_SCAN_INTERVAL = 15000;
  private boolean mActivelyScanningWifiDisplays;
  private final DisplayManager mDisplayManager;
  private final Handler mHandler;
  private Method mScanWifiDisplaysMethod;
  
  public MediaRouterJellybeanMr1$ActiveScanWorkaround(Context paramContext, Handler paramHandler)
  {
    if (Build.VERSION.SDK_INT != 17) {
      throw new UnsupportedOperationException();
    }
    this.mDisplayManager = ((DisplayManager)paramContext.getSystemService("display"));
    this.mHandler = paramHandler;
    try
    {
      this.mScanWifiDisplaysMethod = DisplayManager.class.getMethod("scanWifiDisplays", new Class[0]);
      label53:
      return;
    }
    catch (NoSuchMethodException localNoSuchMethodException)
    {
      break label53;
    }
  }
  
  public void run()
  {
    if (this.mActivelyScanningWifiDisplays) {}
    try
    {
      this.mScanWifiDisplaysMethod.invoke(this.mDisplayManager, new Object[0]);
      label23:
      this.mHandler.postDelayed(this, 15000L);
      return;
    }
    catch (InvocationTargetException localInvocationTargetException)
    {
      break label23;
    }
    catch (IllegalAccessException localIllegalAccessException)
    {
      break label23;
    }
  }
  
  public void setActiveScanRouteTypes(int paramInt)
  {
    if ((paramInt & 0x2) != 0) {
      if ((!this.mActivelyScanningWifiDisplays) && (this.mScanWifiDisplaysMethod != null))
      {
        this.mActivelyScanningWifiDisplays = true;
        this.mHandler.post(this);
      }
    }
    for (;;)
    {
      return;
      if (this.mActivelyScanningWifiDisplays)
      {
        this.mActivelyScanningWifiDisplays = false;
        this.mHandler.removeCallbacks(this);
      }
    }
  }
}


/* Location:           C:\Users\dreadiscool\Desktop\tools\classes-dex2jar.jar
 * Qualified Name:     android.support.v4.media.routing.MediaRouterJellybeanMr1.ActiveScanWorkaround
 * JD-Core Version:    0.7.0.1
 */