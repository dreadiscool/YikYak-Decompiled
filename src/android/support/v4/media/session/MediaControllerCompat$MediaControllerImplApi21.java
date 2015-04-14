package android.support.v4.media.session;

import android.content.Context;
import android.os.Bundle;
import android.os.Handler;
import android.os.RemoteException;
import android.os.ResultReceiver;
import android.support.v4.media.MediaMetadataCompat;
import android.view.KeyEvent;

class MediaControllerCompat$MediaControllerImplApi21
  implements MediaControllerCompat.MediaControllerImpl
{
  private final Object mControllerObj;
  
  public MediaControllerCompat$MediaControllerImplApi21(Context paramContext, MediaSessionCompat.Token paramToken)
  {
    this.mControllerObj = MediaControllerCompatApi21.fromToken(paramContext, paramToken.getToken());
    if (this.mControllerObj == null) {
      throw new RemoteException();
    }
  }
  
  public MediaControllerCompat$MediaControllerImplApi21(Context paramContext, MediaSessionCompat paramMediaSessionCompat)
  {
    this.mControllerObj = MediaControllerCompatApi21.fromToken(paramContext, paramMediaSessionCompat.getSessionToken().getToken());
  }
  
  public boolean dispatchMediaButtonEvent(KeyEvent paramKeyEvent)
  {
    return MediaControllerCompatApi21.dispatchMediaButtonEvent(this.mControllerObj, paramKeyEvent);
  }
  
  public Object getMediaController()
  {
    return this.mControllerObj;
  }
  
  public MediaMetadataCompat getMetadata()
  {
    Object localObject = MediaControllerCompatApi21.getMetadata(this.mControllerObj);
    if (localObject != null) {}
    for (MediaMetadataCompat localMediaMetadataCompat = MediaMetadataCompat.fromMediaMetadata(localObject);; localMediaMetadataCompat = null) {
      return localMediaMetadataCompat;
    }
  }
  
  public MediaControllerCompat.PlaybackInfo getPlaybackInfo()
  {
    Object localObject = MediaControllerCompatApi21.getPlaybackInfo(this.mControllerObj);
    if (localObject != null) {}
    for (MediaControllerCompat.PlaybackInfo localPlaybackInfo = new MediaControllerCompat.PlaybackInfo(MediaControllerCompatApi21.PlaybackInfo.getPlaybackType(localObject), MediaControllerCompatApi21.PlaybackInfo.getLegacyAudioStream(localObject), MediaControllerCompatApi21.PlaybackInfo.getVolumeControl(localObject), MediaControllerCompatApi21.PlaybackInfo.getMaxVolume(localObject), MediaControllerCompatApi21.PlaybackInfo.getCurrentVolume(localObject));; localPlaybackInfo = null) {
      return localPlaybackInfo;
    }
  }
  
  public PlaybackStateCompat getPlaybackState()
  {
    Object localObject = MediaControllerCompatApi21.getPlaybackState(this.mControllerObj);
    if (localObject != null) {}
    for (PlaybackStateCompat localPlaybackStateCompat = PlaybackStateCompat.fromPlaybackState(localObject);; localPlaybackStateCompat = null) {
      return localPlaybackStateCompat;
    }
  }
  
  public int getRatingType()
  {
    return MediaControllerCompatApi21.getRatingType(this.mControllerObj);
  }
  
  public MediaControllerCompat.TransportControls getTransportControls()
  {
    Object localObject = MediaControllerCompatApi21.getTransportControls(this.mControllerObj);
    if (localObject != null) {}
    for (MediaControllerCompat.TransportControlsApi21 localTransportControlsApi21 = new MediaControllerCompat.TransportControlsApi21(localObject);; localTransportControlsApi21 = null) {
      return localTransportControlsApi21;
    }
  }
  
  public void registerCallback(MediaControllerCompat.Callback paramCallback, Handler paramHandler)
  {
    MediaControllerCompatApi21.registerCallback(this.mControllerObj, paramCallback.mCallbackObj, paramHandler);
  }
  
  public void sendCommand(String paramString, Bundle paramBundle, ResultReceiver paramResultReceiver)
  {
    MediaControllerCompatApi21.sendCommand(this.mControllerObj, paramString, paramBundle, paramResultReceiver);
  }
  
  public void unregisterCallback(MediaControllerCompat.Callback paramCallback)
  {
    MediaControllerCompatApi21.unregisterCallback(this.mControllerObj, paramCallback.mCallbackObj);
  }
}


/* Location:           C:\Users\dreadiscool\Desktop\tools\classes-dex2jar.jar
 * Qualified Name:     android.support.v4.media.session.MediaControllerCompat.MediaControllerImplApi21
 * JD-Core Version:    0.7.0.1
 */