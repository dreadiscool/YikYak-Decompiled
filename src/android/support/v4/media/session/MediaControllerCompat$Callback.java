package android.support.v4.media.session;

import android.os.Build.VERSION;
import android.os.Bundle;
import android.support.v4.media.MediaMetadataCompat;

public abstract class MediaControllerCompat$Callback
{
  final Object mCallbackObj;
  
  public MediaControllerCompat$Callback()
  {
    if (Build.VERSION.SDK_INT >= 21) {}
    for (this.mCallbackObj = MediaControllerCompatApi21.createCallback(new MediaControllerCompat.Callback.StubApi21(this, null));; this.mCallbackObj = null) {
      return;
    }
  }
  
  public void onMetadataChanged(MediaMetadataCompat paramMediaMetadataCompat) {}
  
  public void onPlaybackStateChanged(PlaybackStateCompat paramPlaybackStateCompat) {}
  
  public void onSessionDestroyed() {}
  
  public void onSessionEvent(String paramString, Bundle paramBundle) {}
}


/* Location:           C:\Users\dreadiscool\Desktop\tools\classes-dex2jar.jar
 * Qualified Name:     android.support.v4.media.session.MediaControllerCompat.Callback
 * JD-Core Version:    0.7.0.1
 */