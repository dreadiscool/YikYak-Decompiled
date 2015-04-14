package android.support.v4.app;

import java.util.ArrayList;

public class NotificationCompat$InboxStyle
  extends NotificationCompat.Style
{
  ArrayList<CharSequence> mTexts = new ArrayList();
  
  public NotificationCompat$InboxStyle() {}
  
  public NotificationCompat$InboxStyle(NotificationCompat.Builder paramBuilder)
  {
    setBuilder(paramBuilder);
  }
  
  public InboxStyle addLine(CharSequence paramCharSequence)
  {
    this.mTexts.add(NotificationCompat.Builder.limitCharSequenceLength(paramCharSequence));
    return this;
  }
  
  public InboxStyle setBigContentTitle(CharSequence paramCharSequence)
  {
    this.mBigContentTitle = NotificationCompat.Builder.limitCharSequenceLength(paramCharSequence);
    return this;
  }
  
  public InboxStyle setSummaryText(CharSequence paramCharSequence)
  {
    this.mSummaryText = NotificationCompat.Builder.limitCharSequenceLength(paramCharSequence);
    this.mSummaryTextSet = true;
    return this;
  }
}


/* Location:           C:\Users\dreadiscool\Desktop\tools\classes-dex2jar.jar
 * Qualified Name:     android.support.v4.app.NotificationCompat.InboxStyle
 * JD-Core Version:    0.7.0.1
 */