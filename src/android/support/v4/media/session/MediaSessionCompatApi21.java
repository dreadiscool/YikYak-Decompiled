package android.support.v4.media.session;

import android.content.Context;
import android.media.AudioAttributes.Builder;
import android.media.MediaMetadata;
import android.media.VolumeProvider;
import android.media.session.MediaSession;
import android.media.session.MediaSession.Callback;
import android.media.session.PlaybackState;
import android.os.Bundle;
import android.os.Handler;
import android.os.Parcelable;

class MediaSessionCompatApi21
{
  public static Object createCallback(MediaSessionCompatApi21.Callback paramCallback)
  {
    return new MediaSessionCompatApi21.CallbackProxy(paramCallback);
  }
  
  public static Object createSession(Context paramContext, String paramString)
  {
    return new MediaSession(paramContext, paramString);
  }
  
  public static Parcelable getSessionToken(Object paramObject)
  {
    return ((MediaSession)paramObject).getSessionToken();
  }
  
  public static boolean isActive(Object paramObject)
  {
    return ((MediaSession)paramObject).isActive();
  }
  
  public static void release(Object paramObject)
  {
    ((MediaSession)paramObject).release();
  }
  
  public static void sendSessionEvent(Object paramObject, String paramString, Bundle paramBundle)
  {
    ((MediaSession)paramObject).sendSessionEvent(paramString, paramBundle);
  }
  
  public static void setActive(Object paramObject, boolean paramBoolean)
  {
    ((MediaSession)paramObject).setActive(paramBoolean);
  }
  
  public static void setCallback(Object paramObject1, Object paramObject2, Handler paramHandler)
  {
    ((MediaSession)paramObject1).setCallback((MediaSession.Callback)paramObject2, paramHandler);
  }
  
  public static void setFlags(Object paramObject, int paramInt)
  {
    ((MediaSession)paramObject).setFlags(paramInt);
  }
  
  public static void setMetadata(Object paramObject1, Object paramObject2)
  {
    ((MediaSession)paramObject1).setMetadata((MediaMetadata)paramObject2);
  }
  
  public static void setPlaybackState(Object paramObject1, Object paramObject2)
  {
    ((MediaSession)paramObject1).setPlaybackState((PlaybackState)paramObject2);
  }
  
  public static void setPlaybackToLocal(Object paramObject, int paramInt)
  {
    AudioAttributes.Builder localBuilder = new AudioAttributes.Builder();
    localBuilder.setLegacyStreamType(paramInt);
    ((MediaSession)paramObject).setPlaybackToLocal(localBuilder.build());
  }
  
  public static void setPlaybackToRemote(Object paramObject1, Object paramObject2)
  {
    ((MediaSession)paramObject1).setPlaybackToRemote((VolumeProvider)paramObject2);
  }
  
  public static Object verifySession(Object paramObject)
  {
    if ((paramObject instanceof MediaSession)) {
      return paramObject;
    }
    throw new IllegalArgumentException("mediaSession is not a valid MediaSession object");
  }
}


/* Location:           C:\Users\dreadiscool\Desktop\tools\classes-dex2jar.jar
 * Qualified Name:     android.support.v4.media.session.MediaSessionCompatApi21
 * JD-Core Version:    0.7.0.1
 */