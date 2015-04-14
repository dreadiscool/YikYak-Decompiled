package android.support.v4.media.routing;

import android.media.MediaRouter;
import android.media.MediaRouter.Callback;

class MediaRouterJellybeanMr2
  extends MediaRouterJellybeanMr1
{
  public static void addCallback(Object paramObject1, int paramInt1, Object paramObject2, int paramInt2)
  {
    ((MediaRouter)paramObject1).addCallback(paramInt1, (MediaRouter.Callback)paramObject2, paramInt2);
  }
  
  public static Object getDefaultRoute(Object paramObject)
  {
    return ((MediaRouter)paramObject).getDefaultRoute();
  }
}


/* Location:           C:\Users\dreadiscool\Desktop\tools\classes-dex2jar.jar
 * Qualified Name:     android.support.v4.media.routing.MediaRouterJellybeanMr2
 * JD-Core Version:    0.7.0.1
 */