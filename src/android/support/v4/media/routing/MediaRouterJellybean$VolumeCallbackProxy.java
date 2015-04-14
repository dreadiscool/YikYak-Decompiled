package android.support.v4.media.routing;

import android.media.MediaRouter.RouteInfo;
import android.media.MediaRouter.VolumeCallback;

class MediaRouterJellybean$VolumeCallbackProxy<T extends MediaRouterJellybean.VolumeCallback>
  extends MediaRouter.VolumeCallback
{
  protected final T mCallback;
  
  public MediaRouterJellybean$VolumeCallbackProxy(T paramT)
  {
    this.mCallback = paramT;
  }
  
  public void onVolumeSetRequest(MediaRouter.RouteInfo paramRouteInfo, int paramInt)
  {
    this.mCallback.onVolumeSetRequest(paramRouteInfo, paramInt);
  }
  
  public void onVolumeUpdateRequest(MediaRouter.RouteInfo paramRouteInfo, int paramInt)
  {
    this.mCallback.onVolumeUpdateRequest(paramRouteInfo, paramInt);
  }
}


/* Location:           C:\Users\dreadiscool\Desktop\tools\classes-dex2jar.jar
 * Qualified Name:     android.support.v4.media.routing.MediaRouterJellybean.VolumeCallbackProxy
 * JD-Core Version:    0.7.0.1
 */