package android.support.v4.content;

import android.database.ContentObserver;
import android.os.Handler;

public final class Loader$ForceLoadContentObserver
  extends ContentObserver
{
  public Loader$ForceLoadContentObserver(Loader paramLoader)
  {
    super(new Handler());
  }
  
  public boolean deliverSelfNotifications()
  {
    return true;
  }
  
  public void onChange(boolean paramBoolean)
  {
    this.this$0.onContentChanged();
  }
}


/* Location:           C:\Users\dreadiscool\Desktop\tools\classes-dex2jar.jar
 * Qualified Name:     android.support.v4.content.Loader.ForceLoadContentObserver
 * JD-Core Version:    0.7.0.1
 */