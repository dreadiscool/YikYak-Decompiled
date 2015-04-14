package android.support.v4.media.session;

import android.content.Intent;
import android.os.Build.VERSION;
import android.os.Bundle;
import android.os.ResultReceiver;
import android.support.v4.media.RatingCompat;

public abstract class MediaSessionCompat$Callback
{
  final Object mCallbackObj;
  
  public MediaSessionCompat$Callback()
  {
    if (Build.VERSION.SDK_INT >= 21) {}
    for (this.mCallbackObj = MediaSessionCompatApi21.createCallback(new MediaSessionCompat.Callback.StubApi21(this, null));; this.mCallbackObj = null) {
      return;
    }
  }
  
  public void onCommand(String paramString, Bundle paramBundle, ResultReceiver paramResultReceiver) {}
  
  public void onFastForward() {}
  
  public boolean onMediaButtonEvent(Intent paramIntent)
  {
    return false;
  }
  
  public void onPause() {}
  
  public void onPlay() {}
  
  public void onRewind() {}
  
  public void onSeekTo(long paramLong) {}
  
  public void onSetRating(RatingCompat paramRatingCompat) {}
  
  public void onSkipToNext() {}
  
  public void onSkipToPrevious() {}
  
  public void onStop() {}
}


/* Location:           C:\Users\dreadiscool\Desktop\tools\classes-dex2jar.jar
 * Qualified Name:     android.support.v4.media.session.MediaSessionCompat.Callback
 * JD-Core Version:    0.7.0.1
 */