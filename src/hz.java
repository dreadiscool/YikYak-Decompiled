import android.os.Handler;
import android.os.Looper;
import android.os.Message;
import android.util.Log;
import com.google.android.gms.common.ConnectionResult;

final class hz
  extends Handler
{
  public hz(hy paramhy, Looper paramLooper)
  {
    super(paramLooper);
  }
  
  public void handleMessage(Message paramMessage)
  {
    if ((paramMessage.what == 1) && (!this.a.c())) {
      ((hA)paramMessage.obj).b();
    }
    for (;;)
    {
      return;
      if (paramMessage.what == 3)
      {
        hy.a(this.a).a(new ConnectionResult(((Integer)paramMessage.obj).intValue(), null));
      }
      else if (paramMessage.what == 4)
      {
        hy.a(this.a, 4, null);
        hy.a(this.a).a(((Integer)paramMessage.obj).intValue());
        hy.a(this.a, 4, 1, null);
      }
      else if ((paramMessage.what == 2) && (!this.a.isConnected()))
      {
        ((hA)paramMessage.obj).b();
      }
      else if ((paramMessage.what == 2) || (paramMessage.what == 1))
      {
        ((hA)paramMessage.obj).a();
      }
      else
      {
        Log.wtf("GmsClient", "Don't know how to handle this message.");
      }
    }
  }
}


/* Location:           C:\Users\dreadiscool\Desktop\tools\classes-dex2jar.jar
 * Qualified Name:     hz
 * JD-Core Version:    0.7.0.1
 */