package android.support.v4.media.session;

import android.os.Bundle;
import android.support.v4.media.MediaMetadataCompat;

class MediaControllerCompat$Callback$StubApi21
  implements MediaControllerCompatApi21.Callback
{
  private MediaControllerCompat$Callback$StubApi21(MediaControllerCompat.Callback paramCallback) {}
  
  public void onMetadataChanged(Object paramObject)
  {
    this.this$0.onMetadataChanged(MediaMetadataCompat.fromMediaMetadata(paramObject));
  }
  
  public void onPlaybackStateChanged(Object paramObject)
  {
    this.this$0.onPlaybackStateChanged(PlaybackStateCompat.fromPlaybackState(paramObject));
  }
  
  public void onSessionDestroyed()
  {
    this.this$0.onSessionDestroyed();
  }
  
  public void onSessionEvent(String paramString, Bundle paramBundle)
  {
    this.this$0.onSessionEvent(paramString, paramBundle);
  }
}


/* Location:           C:\Users\dreadiscool\Desktop\tools\classes-dex2jar.jar
 * Qualified Name:     android.support.v4.media.session.MediaControllerCompat.Callback.StubApi21
 * JD-Core Version:    0.7.0.1
 */