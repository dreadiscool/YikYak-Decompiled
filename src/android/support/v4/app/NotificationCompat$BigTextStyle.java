package android.support.v4.app;

public class NotificationCompat$BigTextStyle
  extends NotificationCompat.Style
{
  CharSequence mBigText;
  
  public NotificationCompat$BigTextStyle() {}
  
  public NotificationCompat$BigTextStyle(NotificationCompat.Builder paramBuilder)
  {
    setBuilder(paramBuilder);
  }
  
  public BigTextStyle bigText(CharSequence paramCharSequence)
  {
    this.mBigText = NotificationCompat.Builder.limitCharSequenceLength(paramCharSequence);
    return this;
  }
  
  public BigTextStyle setBigContentTitle(CharSequence paramCharSequence)
  {
    this.mBigContentTitle = NotificationCompat.Builder.limitCharSequenceLength(paramCharSequence);
    return this;
  }
  
  public BigTextStyle setSummaryText(CharSequence paramCharSequence)
  {
    this.mSummaryText = NotificationCompat.Builder.limitCharSequenceLength(paramCharSequence);
    this.mSummaryTextSet = true;
    return this;
  }
}


/* Location:           C:\Users\dreadiscool\Desktop\tools\classes-dex2jar.jar
 * Qualified Name:     android.support.v4.app.NotificationCompat.BigTextStyle
 * JD-Core Version:    0.7.0.1
 */