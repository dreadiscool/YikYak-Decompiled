package android.support.v4.media.routing;

import android.media.MediaRouter.RouteInfo;
import android.os.Build.VERSION;
import java.lang.reflect.Field;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;

public final class MediaRouterJellybeanMr1$IsConnectingWorkaround
{
  private Method mGetStatusCodeMethod;
  private int mStatusConnecting;
  
  public MediaRouterJellybeanMr1$IsConnectingWorkaround()
  {
    if (Build.VERSION.SDK_INT != 17) {
      throw new UnsupportedOperationException();
    }
    try
    {
      this.mStatusConnecting = MediaRouter.RouteInfo.class.getField("STATUS_CONNECTING").getInt(null);
      this.mGetStatusCodeMethod = MediaRouter.RouteInfo.class.getMethod("getStatusCode", new Class[0]);
      label50:
      return;
    }
    catch (IllegalAccessException localIllegalAccessException)
    {
      break label50;
    }
    catch (NoSuchMethodException localNoSuchMethodException)
    {
      break label50;
    }
    catch (NoSuchFieldException localNoSuchFieldException)
    {
      break label50;
    }
  }
  
  public boolean isConnecting(Object paramObject)
  {
    MediaRouter.RouteInfo localRouteInfo = (MediaRouter.RouteInfo)paramObject;
    if (this.mGetStatusCodeMethod != null) {
      for (;;)
      {
        try
        {
          int i = ((Integer)this.mGetStatusCodeMethod.invoke(localRouteInfo, new Object[0])).intValue();
          int j = this.mStatusConnecting;
          if (i != j) {
            continue;
          }
          bool = true;
        }
        catch (InvocationTargetException localInvocationTargetException)
        {
          boolean bool = false;
          continue;
        }
        catch (IllegalAccessException localIllegalAccessException)
        {
          continue;
        }
        return bool;
        bool = false;
      }
    }
  }
}


/* Location:           C:\Users\dreadiscool\Desktop\tools\classes-dex2jar.jar
 * Qualified Name:     android.support.v4.media.routing.MediaRouterJellybeanMr1.IsConnectingWorkaround
 * JD-Core Version:    0.7.0.1
 */