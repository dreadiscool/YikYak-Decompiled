import android.content.Intent;
import android.os.Handler;
import android.os.Looper;
import android.os.Message;
import java.util.concurrent.BlockingQueue;

class hc
  extends Handler
{
  hc(hb paramhb, Looper paramLooper)
  {
    super(paramLooper);
  }
  
  public void handleMessage(Message paramMessage)
  {
    Intent localIntent = (Intent)paramMessage.obj;
    this.a.b.add(localIntent);
  }
}


/* Location:           C:\Users\dreadiscool\Desktop\tools\classes-dex2jar.jar
 * Qualified Name:     hc
 * JD-Core Version:    0.7.0.1
 */