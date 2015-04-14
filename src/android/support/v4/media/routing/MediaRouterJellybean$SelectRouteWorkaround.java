package android.support.v4.media.routing;

import android.media.MediaRouter;
import android.media.MediaRouter.RouteInfo;
import android.os.Build.VERSION;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;

public final class MediaRouterJellybean$SelectRouteWorkaround
{
  private Method mSelectRouteIntMethod;
  
  public MediaRouterJellybean$SelectRouteWorkaround()
  {
    if ((Build.VERSION.SDK_INT < 16) || (Build.VERSION.SDK_INT > 17)) {
      throw new UnsupportedOperationException();
    }
    try
    {
      Class[] arrayOfClass = new Class[2];
      arrayOfClass[0] = Integer.TYPE;
      arrayOfClass[1] = MediaRouter.RouteInfo.class;
      this.mSelectRouteIntMethod = MediaRouter.class.getMethod("selectRouteInt", arrayOfClass);
      label56:
      return;
    }
    catch (NoSuchMethodException localNoSuchMethodException)
    {
      break label56;
    }
  }
  
  public void selectRoute(Object paramObject1, int paramInt, Object paramObject2)
  {
    MediaRouter localMediaRouter = (MediaRouter)paramObject1;
    MediaRouter.RouteInfo localRouteInfo = (MediaRouter.RouteInfo)paramObject2;
    if (((0x800000 & localRouteInfo.getSupportedTypes()) == 0) && (this.mSelectRouteIntMethod != null)) {}
    try
    {
      Method localMethod = this.mSelectRouteIntMethod;
      Object[] arrayOfObject = new Object[2];
      arrayOfObject[0] = Integer.valueOf(paramInt);
      arrayOfObject[1] = localRouteInfo;
      localMethod.invoke(localMediaRouter, arrayOfObject);
      return;
    }
    catch (InvocationTargetException localInvocationTargetException)
    {
      for (;;)
      {
        localMediaRouter.selectRoute(paramInt, localRouteInfo);
      }
    }
    catch (IllegalAccessException localIllegalAccessException)
    {
      label69:
      break label69;
    }
  }
}


/* Location:           C:\Users\dreadiscool\Desktop\tools\classes-dex2jar.jar
 * Qualified Name:     android.support.v4.media.routing.MediaRouterJellybean.SelectRouteWorkaround
 * JD-Core Version:    0.7.0.1
 */