package android.support.v4.media.session;

import android.media.MediaMetadata;
import android.media.session.MediaController.Callback;
import android.media.session.PlaybackState;
import android.os.Bundle;

class MediaControllerCompatApi21$CallbackProxy<T extends MediaControllerCompatApi21.Callback>
  extends MediaController.Callback
{
  protected final T mCallback;
  
  public MediaControllerCompatApi21$CallbackProxy(T paramT)
  {
    this.mCallback = paramT;
  }
  
  public void onMetadataChanged(MediaMetadata paramMediaMetadata)
  {
    this.mCallback.onMetadataChanged(paramMediaMetadata);
  }
  
  public void onPlaybackStateChanged(PlaybackState paramPlaybackState)
  {
    this.mCallback.onPlaybackStateChanged(paramPlaybackState);
  }
  
  public void onSessionDestroyed()
  {
    this.mCallback.onSessionDestroyed();
  }
  
  public void onSessionEvent(String paramString, Bundle paramBundle)
  {
    this.mCallback.onSessionEvent(paramString, paramBundle);
  }
}


/* Location:           C:\Users\dreadiscool\Desktop\tools\classes-dex2jar.jar
 * Qualified Name:     android.support.v4.media.session.MediaControllerCompatApi21.CallbackProxy
 * JD-Core Version:    0.7.0.1
 */