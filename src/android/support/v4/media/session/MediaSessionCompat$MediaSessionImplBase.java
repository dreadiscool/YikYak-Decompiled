package android.support.v4.media.session;

import android.os.Bundle;
import android.os.Handler;
import android.support.v4.media.MediaMetadataCompat;
import android.support.v4.media.VolumeProviderCompat;

class MediaSessionCompat$MediaSessionImplBase
  implements MediaSessionCompat.MediaSessionImpl
{
  public Object getMediaSession()
  {
    return null;
  }
  
  public MediaSessionCompat.Token getSessionToken()
  {
    return null;
  }
  
  public boolean isActive()
  {
    return false;
  }
  
  public void release() {}
  
  public void sendSessionEvent(String paramString, Bundle paramBundle) {}
  
  public void setActive(boolean paramBoolean) {}
  
  public void setCallback(MediaSessionCompat.Callback paramCallback, Handler paramHandler) {}
  
  public void setFlags(int paramInt) {}
  
  public void setMetadata(MediaMetadataCompat paramMediaMetadataCompat) {}
  
  public void setPlaybackState(PlaybackStateCompat paramPlaybackStateCompat) {}
  
  public void setPlaybackToLocal(int paramInt) {}
  
  public void setPlaybackToRemote(VolumeProviderCompat paramVolumeProviderCompat) {}
}


/* Location:           C:\Users\dreadiscool\Desktop\tools\classes-dex2jar.jar
 * Qualified Name:     android.support.v4.media.session.MediaSessionCompat.MediaSessionImplBase
 * JD-Core Version:    0.7.0.1
 */