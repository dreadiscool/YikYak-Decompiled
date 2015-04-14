package android.support.v4.media.session;

import android.support.v4.media.RatingCompat;

class MediaControllerCompat$TransportControlsApi21
  extends MediaControllerCompat.TransportControls
{
  private final Object mControlsObj;
  
  public MediaControllerCompat$TransportControlsApi21(Object paramObject)
  {
    this.mControlsObj = paramObject;
  }
  
  public void fastForward()
  {
    MediaControllerCompatApi21.TransportControls.fastForward(this.mControlsObj);
  }
  
  public void pause()
  {
    MediaControllerCompatApi21.TransportControls.pause(this.mControlsObj);
  }
  
  public void play()
  {
    MediaControllerCompatApi21.TransportControls.play(this.mControlsObj);
  }
  
  public void rewind()
  {
    MediaControllerCompatApi21.TransportControls.rewind(this.mControlsObj);
  }
  
  public void seekTo(long paramLong)
  {
    MediaControllerCompatApi21.TransportControls.seekTo(this.mControlsObj, paramLong);
  }
  
  public void setRating(RatingCompat paramRatingCompat)
  {
    Object localObject1 = this.mControlsObj;
    if (paramRatingCompat != null) {}
    for (Object localObject2 = paramRatingCompat.getRating();; localObject2 = null)
    {
      MediaControllerCompatApi21.TransportControls.setRating(localObject1, localObject2);
      return;
    }
  }
  
  public void skipToNext()
  {
    MediaControllerCompatApi21.TransportControls.skipToNext(this.mControlsObj);
  }
  
  public void skipToPrevious()
  {
    MediaControllerCompatApi21.TransportControls.skipToPrevious(this.mControlsObj);
  }
  
  public void stop()
  {
    MediaControllerCompatApi21.TransportControls.stop(this.mControlsObj);
  }
}


/* Location:           C:\Users\dreadiscool\Desktop\tools\classes-dex2jar.jar
 * Qualified Name:     android.support.v4.media.session.MediaControllerCompat.TransportControlsApi21
 * JD-Core Version:    0.7.0.1
 */