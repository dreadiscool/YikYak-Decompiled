package android.support.v4.media.routing;

class MediaRouterJellybeanMr1
  extends MediaRouterJellybean
{
  private static final String TAG = "MediaRouterJellybeanMr1";
  
  public static Object createCallback(MediaRouterJellybeanMr1.Callback paramCallback)
  {
    return new MediaRouterJellybeanMr1.CallbackProxy(paramCallback);
  }
}


/* Location:           C:\Users\dreadiscool\Desktop\tools\classes-dex2jar.jar
 * Qualified Name:     android.support.v4.media.routing.MediaRouterJellybeanMr1
 * JD-Core Version:    0.7.0.1
 */