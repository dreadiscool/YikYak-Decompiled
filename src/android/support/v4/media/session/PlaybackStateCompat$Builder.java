package android.support.v4.media.session;

import android.os.SystemClock;

public final class PlaybackStateCompat$Builder
{
  private long mActions;
  private long mBufferedPosition;
  private CharSequence mErrorMessage;
  private long mPosition;
  private float mRate;
  private int mState;
  private long mUpdateTime;
  
  public PlaybackStateCompat$Builder() {}
  
  public PlaybackStateCompat$Builder(PlaybackStateCompat paramPlaybackStateCompat)
  {
    this.mState = PlaybackStateCompat.access$100(paramPlaybackStateCompat);
    this.mPosition = PlaybackStateCompat.access$200(paramPlaybackStateCompat);
    this.mRate = PlaybackStateCompat.access$300(paramPlaybackStateCompat);
    this.mUpdateTime = PlaybackStateCompat.access$400(paramPlaybackStateCompat);
    this.mBufferedPosition = PlaybackStateCompat.access$500(paramPlaybackStateCompat);
    this.mActions = PlaybackStateCompat.access$600(paramPlaybackStateCompat);
    this.mErrorMessage = PlaybackStateCompat.access$700(paramPlaybackStateCompat);
  }
  
  public PlaybackStateCompat build()
  {
    return new PlaybackStateCompat(this.mState, this.mPosition, this.mBufferedPosition, this.mRate, this.mActions, this.mErrorMessage, this.mUpdateTime, null);
  }
  
  public void setActions(long paramLong)
  {
    this.mActions = paramLong;
  }
  
  public void setBufferedPosition(long paramLong)
  {
    this.mBufferedPosition = paramLong;
  }
  
  public void setErrorMessage(CharSequence paramCharSequence)
  {
    this.mErrorMessage = paramCharSequence;
  }
  
  public void setState(int paramInt, long paramLong, float paramFloat)
  {
    this.mState = paramInt;
    this.mPosition = paramLong;
    this.mRate = paramFloat;
    this.mUpdateTime = SystemClock.elapsedRealtime();
  }
}


/* Location:           C:\Users\dreadiscool\Desktop\tools\classes-dex2jar.jar
 * Qualified Name:     android.support.v4.media.session.PlaybackStateCompat.Builder
 * JD-Core Version:    0.7.0.1
 */