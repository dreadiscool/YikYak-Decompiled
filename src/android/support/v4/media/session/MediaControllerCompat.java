package android.support.v4.media.session;

import android.content.Context;
import android.os.Build.VERSION;
import android.os.Bundle;
import android.os.Handler;
import android.os.ResultReceiver;
import android.support.v4.media.MediaMetadataCompat;
import android.text.TextUtils;
import android.view.KeyEvent;

public final class MediaControllerCompat
{
  private final MediaControllerCompat.MediaControllerImpl mImpl;
  
  public MediaControllerCompat(Context paramContext, MediaSessionCompat.Token paramToken)
  {
    if (paramToken == null) {
      throw new IllegalArgumentException("sessionToken must not be null");
    }
    if (Build.VERSION.SDK_INT >= 21) {}
    for (this.mImpl = new MediaControllerCompat.MediaControllerImplApi21(paramContext, paramToken);; this.mImpl = new MediaControllerCompat.MediaControllerImplBase()) {
      return;
    }
  }
  
  public MediaControllerCompat(Context paramContext, MediaSessionCompat paramMediaSessionCompat)
  {
    if (paramMediaSessionCompat == null) {
      throw new IllegalArgumentException("session must not be null");
    }
    if (Build.VERSION.SDK_INT >= 21) {}
    for (this.mImpl = new MediaControllerCompat.MediaControllerImplApi21(paramContext, paramMediaSessionCompat);; this.mImpl = new MediaControllerCompat.MediaControllerImplBase()) {
      return;
    }
  }
  
  public boolean dispatchMediaButtonEvent(KeyEvent paramKeyEvent)
  {
    if (paramKeyEvent == null) {
      throw new IllegalArgumentException("KeyEvent may not be null");
    }
    return this.mImpl.dispatchMediaButtonEvent(paramKeyEvent);
  }
  
  public Object getMediaController()
  {
    return this.mImpl.getMediaController();
  }
  
  public MediaMetadataCompat getMetadata()
  {
    return this.mImpl.getMetadata();
  }
  
  public MediaControllerCompat.PlaybackInfo getPlaybackInfo()
  {
    return this.mImpl.getPlaybackInfo();
  }
  
  public PlaybackStateCompat getPlaybackState()
  {
    return this.mImpl.getPlaybackState();
  }
  
  public int getRatingType()
  {
    return this.mImpl.getRatingType();
  }
  
  public MediaControllerCompat.TransportControls getTransportControls()
  {
    return this.mImpl.getTransportControls();
  }
  
  public void registerCallback(MediaControllerCompat.Callback paramCallback)
  {
    registerCallback(paramCallback, null);
  }
  
  public void registerCallback(MediaControllerCompat.Callback paramCallback, Handler paramHandler)
  {
    if (paramCallback == null) {
      throw new IllegalArgumentException("callback cannot be null");
    }
    if (paramHandler == null) {
      paramHandler = new Handler();
    }
    this.mImpl.registerCallback(paramCallback, paramHandler);
  }
  
  public void sendCommand(String paramString, Bundle paramBundle, ResultReceiver paramResultReceiver)
  {
    if (TextUtils.isEmpty(paramString)) {
      throw new IllegalArgumentException("command cannot be null or empty");
    }
    this.mImpl.sendCommand(paramString, paramBundle, paramResultReceiver);
  }
  
  public void unregisterCallback(MediaControllerCompat.Callback paramCallback)
  {
    if (paramCallback == null) {
      throw new IllegalArgumentException("callback cannot be null");
    }
    this.mImpl.unregisterCallback(paramCallback);
  }
}


/* Location:           C:\Users\dreadiscool\Desktop\tools\classes-dex2jar.jar
 * Qualified Name:     android.support.v4.media.session.MediaControllerCompat
 * JD-Core Version:    0.7.0.1
 */