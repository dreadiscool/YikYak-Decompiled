package android.support.v4.media.session;

import android.os.Bundle;
import android.os.Handler;
import android.os.ResultReceiver;
import android.support.v4.media.MediaMetadataCompat;
import android.view.KeyEvent;

class MediaControllerCompat$MediaControllerImplBase
  implements MediaControllerCompat.MediaControllerImpl
{
  public boolean dispatchMediaButtonEvent(KeyEvent paramKeyEvent)
  {
    return false;
  }
  
  public Object getMediaController()
  {
    return null;
  }
  
  public MediaMetadataCompat getMetadata()
  {
    return null;
  }
  
  public MediaControllerCompat.PlaybackInfo getPlaybackInfo()
  {
    return null;
  }
  
  public PlaybackStateCompat getPlaybackState()
  {
    return null;
  }
  
  public int getRatingType()
  {
    return 0;
  }
  
  public MediaControllerCompat.TransportControls getTransportControls()
  {
    return null;
  }
  
  public void registerCallback(MediaControllerCompat.Callback paramCallback, Handler paramHandler) {}
  
  public void sendCommand(String paramString, Bundle paramBundle, ResultReceiver paramResultReceiver) {}
  
  public void unregisterCallback(MediaControllerCompat.Callback paramCallback) {}
}


/* Location:           C:\Users\dreadiscool\Desktop\tools\classes-dex2jar.jar
 * Qualified Name:     android.support.v4.media.session.MediaControllerCompat.MediaControllerImplBase
 * JD-Core Version:    0.7.0.1
 */