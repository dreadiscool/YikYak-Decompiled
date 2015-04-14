package android.support.v4.media.routing;

import android.media.MediaRouter;
import android.media.MediaRouter.RouteInfo;

class MediaRouterJellybeanMr1$CallbackProxy<T extends MediaRouterJellybeanMr1.Callback>
  extends MediaRouterJellybean.CallbackProxy<T>
{
  public MediaRouterJellybeanMr1$CallbackProxy(T paramT)
  {
    super(paramT);
  }
  
  public void onRoutePresentationDisplayChanged(MediaRouter paramMediaRouter, MediaRouter.RouteInfo paramRouteInfo)
  {
    ((MediaRouterJellybeanMr1.Callback)this.mCallback).onRoutePresentationDisplayChanged(paramRouteInfo);
  }
}


/* Location:           C:\Users\dreadiscool\Desktop\tools\classes-dex2jar.jar
 * Qualified Name:     android.support.v4.media.routing.MediaRouterJellybeanMr1.CallbackProxy
 * JD-Core Version:    0.7.0.1
 */