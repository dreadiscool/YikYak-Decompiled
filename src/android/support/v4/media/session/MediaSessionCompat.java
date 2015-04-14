package android.support.v4.media.session;

import android.content.Context;
import android.os.Build.VERSION;
import android.os.Bundle;
import android.os.Handler;
import android.support.v4.media.MediaMetadataCompat;
import android.support.v4.media.VolumeProviderCompat;
import android.text.TextUtils;

public class MediaSessionCompat
{
  public static final int FLAG_HANDLES_MEDIA_BUTTONS = 1;
  public static final int FLAG_HANDLES_TRANSPORT_CONTROLS = 2;
  private final MediaSessionCompat.MediaSessionImpl mImpl;
  
  public MediaSessionCompat(Context paramContext, String paramString)
  {
    if (paramContext == null) {
      throw new IllegalArgumentException("context must not be null");
    }
    if (TextUtils.isEmpty(paramString)) {
      throw new IllegalArgumentException("tag must not be null or empty");
    }
    if (Build.VERSION.SDK_INT >= 21) {}
    for (this.mImpl = new MediaSessionCompat.MediaSessionImplApi21(paramContext, paramString);; this.mImpl = new MediaSessionCompat.MediaSessionImplBase()) {
      return;
    }
  }
  
  private MediaSessionCompat(MediaSessionCompat.MediaSessionImpl paramMediaSessionImpl)
  {
    this.mImpl = paramMediaSessionImpl;
  }
  
  public static MediaSessionCompat obtain(Object paramObject)
  {
    return new MediaSessionCompat(new MediaSessionCompat.MediaSessionImplApi21(paramObject));
  }
  
  public Object getMediaSession()
  {
    return this.mImpl.getMediaSession();
  }
  
  public MediaSessionCompat.Token getSessionToken()
  {
    return this.mImpl.getSessionToken();
  }
  
  public boolean isActive()
  {
    return this.mImpl.isActive();
  }
  
  public void release()
  {
    this.mImpl.release();
  }
  
  public void sendSessionEvent(String paramString, Bundle paramBundle)
  {
    if (TextUtils.isEmpty(paramString)) {
      throw new IllegalArgumentException("event cannot be null or empty");
    }
    this.mImpl.sendSessionEvent(paramString, paramBundle);
  }
  
  public void setActive(boolean paramBoolean)
  {
    this.mImpl.setActive(paramBoolean);
  }
  
  public void setCallback(MediaSessionCompat.Callback paramCallback)
  {
    setCallback(paramCallback, null);
  }
  
  public void setCallback(MediaSessionCompat.Callback paramCallback, Handler paramHandler)
  {
    MediaSessionCompat.MediaSessionImpl localMediaSessionImpl = this.mImpl;
    if (paramHandler != null) {}
    for (;;)
    {
      localMediaSessionImpl.setCallback(paramCallback, paramHandler);
      return;
      paramHandler = new Handler();
    }
  }
  
  public void setFlags(int paramInt)
  {
    this.mImpl.setFlags(paramInt);
  }
  
  public void setMetadata(MediaMetadataCompat paramMediaMetadataCompat)
  {
    this.mImpl.setMetadata(paramMediaMetadataCompat);
  }
  
  public void setPlaybackState(PlaybackStateCompat paramPlaybackStateCompat)
  {
    this.mImpl.setPlaybackState(paramPlaybackStateCompat);
  }
  
  public void setPlaybackToLocal(int paramInt)
  {
    this.mImpl.setPlaybackToLocal(paramInt);
  }
  
  public void setPlaybackToRemote(VolumeProviderCompat paramVolumeProviderCompat)
  {
    if (paramVolumeProviderCompat == null) {
      throw new IllegalArgumentException("volumeProvider may not be null!");
    }
    this.mImpl.setPlaybackToRemote(paramVolumeProviderCompat);
  }
}


/* Location:           C:\Users\dreadiscool\Desktop\tools\classes-dex2jar.jar
 * Qualified Name:     android.support.v4.media.session.MediaSessionCompat
 * JD-Core Version:    0.7.0.1
 */