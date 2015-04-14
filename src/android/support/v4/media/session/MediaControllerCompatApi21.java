package android.support.v4.media.session;

import android.content.Context;
import android.media.session.MediaController;
import android.media.session.MediaController.Callback;
import android.media.session.MediaSession.Token;
import android.os.Bundle;
import android.os.Handler;
import android.os.ResultReceiver;
import android.view.KeyEvent;

class MediaControllerCompatApi21
{
  public static Object createCallback(MediaControllerCompatApi21.Callback paramCallback)
  {
    return new MediaControllerCompatApi21.CallbackProxy(paramCallback);
  }
  
  public static boolean dispatchMediaButtonEvent(Object paramObject, KeyEvent paramKeyEvent)
  {
    return ((MediaController)paramObject).dispatchMediaButtonEvent(paramKeyEvent);
  }
  
  public static Object fromToken(Context paramContext, Object paramObject)
  {
    return new MediaController(paramContext, (MediaSession.Token)paramObject);
  }
  
  public static Object getMetadata(Object paramObject)
  {
    return ((MediaController)paramObject).getMetadata();
  }
  
  public static Object getPlaybackInfo(Object paramObject)
  {
    return ((MediaController)paramObject).getPlaybackInfo();
  }
  
  public static Object getPlaybackState(Object paramObject)
  {
    return ((MediaController)paramObject).getPlaybackState();
  }
  
  public static int getRatingType(Object paramObject)
  {
    return ((MediaController)paramObject).getRatingType();
  }
  
  public static Object getTransportControls(Object paramObject)
  {
    return ((MediaController)paramObject).getTransportControls();
  }
  
  public static void registerCallback(Object paramObject1, Object paramObject2, Handler paramHandler)
  {
    ((MediaController)paramObject1).registerCallback((MediaController.Callback)paramObject2, paramHandler);
  }
  
  public static void sendCommand(Object paramObject, String paramString, Bundle paramBundle, ResultReceiver paramResultReceiver)
  {
    ((MediaController)paramObject).sendCommand(paramString, paramBundle, paramResultReceiver);
  }
  
  public static void unregisterCallback(Object paramObject1, Object paramObject2)
  {
    ((MediaController)paramObject1).unregisterCallback((MediaController.Callback)paramObject2);
  }
}


/* Location:           C:\Users\dreadiscool\Desktop\tools\classes-dex2jar.jar
 * Qualified Name:     android.support.v4.media.session.MediaControllerCompatApi21
 * JD-Core Version:    0.7.0.1
 */