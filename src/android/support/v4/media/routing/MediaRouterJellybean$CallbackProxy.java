package android.support.v4.media.routing;

import android.media.MediaRouter;
import android.media.MediaRouter.Callback;
import android.media.MediaRouter.RouteGroup;
import android.media.MediaRouter.RouteInfo;

class MediaRouterJellybean$CallbackProxy<T extends MediaRouterJellybean.Callback>
  extends MediaRouter.Callback
{
  protected final T mCallback;
  
  public MediaRouterJellybean$CallbackProxy(T paramT)
  {
    this.mCallback = paramT;
  }
  
  public void onRouteAdded(MediaRouter paramMediaRouter, MediaRouter.RouteInfo paramRouteInfo)
  {
    this.mCallback.onRouteAdded(paramRouteInfo);
  }
  
  public void onRouteChanged(MediaRouter paramMediaRouter, MediaRouter.RouteInfo paramRouteInfo)
  {
    this.mCallback.onRouteChanged(paramRouteInfo);
  }
  
  public void onRouteGrouped(MediaRouter paramMediaRouter, MediaRouter.RouteInfo paramRouteInfo, MediaRouter.RouteGroup paramRouteGroup, int paramInt)
  {
    this.mCallback.onRouteGrouped(paramRouteInfo, paramRouteGroup, paramInt);
  }
  
  public void onRouteRemoved(MediaRouter paramMediaRouter, MediaRouter.RouteInfo paramRouteInfo)
  {
    this.mCallback.onRouteRemoved(paramRouteInfo);
  }
  
  public void onRouteSelected(MediaRouter paramMediaRouter, int paramInt, MediaRouter.RouteInfo paramRouteInfo)
  {
    this.mCallback.onRouteSelected(paramInt, paramRouteInfo);
  }
  
  public void onRouteUngrouped(MediaRouter paramMediaRouter, MediaRouter.RouteInfo paramRouteInfo, MediaRouter.RouteGroup paramRouteGroup)
  {
    this.mCallback.onRouteUngrouped(paramRouteInfo, paramRouteGroup);
  }
  
  public void onRouteUnselected(MediaRouter paramMediaRouter, int paramInt, MediaRouter.RouteInfo paramRouteInfo)
  {
    this.mCallback.onRouteUnselected(paramInt, paramRouteInfo);
  }
  
  public void onRouteVolumeChanged(MediaRouter paramMediaRouter, MediaRouter.RouteInfo paramRouteInfo)
  {
    this.mCallback.onRouteVolumeChanged(paramRouteInfo);
  }
}


/* Location:           C:\Users\dreadiscool\Desktop\tools\classes-dex2jar.jar
 * Qualified Name:     android.support.v4.media.routing.MediaRouterJellybean.CallbackProxy
 * JD-Core Version:    0.7.0.1
 */