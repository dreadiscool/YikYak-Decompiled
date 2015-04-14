package com.parse;

public class NotificationCompat$Builder$BigTextStyle
  extends NotificationCompat.Builder.Style
{
  CharSequence mBigText;
  
  public NotificationCompat$Builder$BigTextStyle() {}
  
  public NotificationCompat$Builder$BigTextStyle(NotificationCompat.Builder paramBuilder)
  {
    setBuilder(paramBuilder);
  }
  
  public BigTextStyle bigText(CharSequence paramCharSequence)
  {
    this.mBigText = paramCharSequence;
    return this;
  }
  
  public BigTextStyle setBigContentTitle(CharSequence paramCharSequence)
  {
    this.mBigContentTitle = paramCharSequence;
    return this;
  }
  
  public BigTextStyle setSummaryText(CharSequence paramCharSequence)
  {
    this.mSummaryText = paramCharSequence;
    this.mSummaryTextSet = true;
    return this;
  }
}


/* Location:           C:\Users\dreadiscool\Desktop\tools\classes-dex2jar.jar
 * Qualified Name:     com.parse.NotificationCompat.Builder.BigTextStyle
 * JD-Core Version:    0.7.0.1
 */