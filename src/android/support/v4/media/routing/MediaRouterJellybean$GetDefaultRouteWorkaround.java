package android.support.v4.media.routing;

import android.media.MediaRouter;
import android.os.Build.VERSION;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;

public final class MediaRouterJellybean$GetDefaultRouteWorkaround
{
  private Method mGetSystemAudioRouteMethod;
  
  public MediaRouterJellybean$GetDefaultRouteWorkaround()
  {
    if ((Build.VERSION.SDK_INT < 16) || (Build.VERSION.SDK_INT > 17)) {
      throw new UnsupportedOperationException();
    }
    try
    {
      this.mGetSystemAudioRouteMethod = MediaRouter.class.getMethod("getSystemAudioRoute", new Class[0]);
      label43:
      return;
    }
    catch (NoSuchMethodException localNoSuchMethodException)
    {
      break label43;
    }
  }
  
  public Object getDefaultRoute(Object paramObject)
  {
    localMediaRouter = (MediaRouter)paramObject;
    if (this.mGetSystemAudioRouteMethod != null) {}
    try
    {
      Object localObject2 = this.mGetSystemAudioRouteMethod.invoke(localMediaRouter, new Object[0]);
      localObject1 = localObject2;
    }
    catch (InvocationTargetException localInvocationTargetException)
    {
      for (;;)
      {
        Object localObject1 = localMediaRouter.getRouteAt(0);
      }
    }
    catch (IllegalAccessException localIllegalAccessException)
    {
      break label33;
    }
    return localObject1;
  }
}


/* Location:           C:\Users\dreadiscool\Desktop\tools\classes-dex2jar.jar
 * Qualified Name:     android.support.v4.media.routing.MediaRouterJellybean.GetDefaultRouteWorkaround
 * JD-Core Version:    0.7.0.1
 */