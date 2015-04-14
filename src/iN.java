import android.location.Location;
import android.os.Handler;
import android.os.Looper;
import android.os.Message;

class iN
  extends jA
{
  private Handler a;
  
  iN(ju paramju, Looper paramLooper)
  {
    if (paramLooper == null) {}
    for (iM localiM = new iM(paramju);; localiM = new iM(paramju, paramLooper))
    {
      this.a = localiM;
      return;
    }
  }
  
  public void a(Location paramLocation)
  {
    if (this.a == null) {}
    for (;;)
    {
      return;
      Message localMessage = Message.obtain();
      localMessage.what = 1;
      localMessage.obj = paramLocation;
      this.a.sendMessage(localMessage);
    }
  }
}


/* Location:           C:\Users\dreadiscool\Desktop\tools\classes-dex2jar.jar
 * Qualified Name:     iN
 * JD-Core Version:    0.7.0.1
 */