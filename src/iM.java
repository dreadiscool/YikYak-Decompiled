import android.location.Location;
import android.os.Handler;
import android.os.Looper;
import android.os.Message;

class iM
  extends Handler
{
  private final ju a;
  
  public iM(ju paramju)
  {
    this.a = paramju;
  }
  
  public iM(ju paramju, Looper paramLooper)
  {
    super(paramLooper);
    this.a = paramju;
  }
  
  public void handleMessage(Message paramMessage)
  {
    switch (paramMessage.what)
    {
    }
    for (;;)
    {
      return;
      Location localLocation = new Location((Location)paramMessage.obj);
      this.a.onLocationChanged(localLocation);
    }
  }
}


/* Location:           C:\Users\dreadiscool\Desktop\tools\classes-dex2jar.jar
 * Qualified Name:     iM
 * JD-Core Version:    0.7.0.1
 */