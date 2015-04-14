package android.support.v4.media.session;

import android.content.Intent;
import android.os.Bundle;
import android.os.ResultReceiver;

public abstract interface MediaSessionCompatApi21$Callback
{
  public abstract void onCommand(String paramString, Bundle paramBundle, ResultReceiver paramResultReceiver);
  
  public abstract void onFastForward();
  
  public abstract boolean onMediaButtonEvent(Intent paramIntent);
  
  public abstract void onPause();
  
  public abstract void onPlay();
  
  public abstract void onRewind();
  
  public abstract void onSeekTo(long paramLong);
  
  public abstract void onSetRating(Object paramObject);
  
  public abstract void onSkipToNext();
  
  public abstract void onSkipToPrevious();
  
  public abstract void onStop();
}


/* Location:           C:\Users\dreadiscool\Desktop\tools\classes-dex2jar.jar
 * Qualified Name:     android.support.v4.media.session.MediaSessionCompatApi21.Callback
 * JD-Core Version:    0.7.0.1
 */