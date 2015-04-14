import android.os.Bundle;
import android.os.Handler;
import android.os.Looper;
import android.os.Message;
import android.util.Log;
import com.google.android.gms.common.api.GoogleApiClient.ConnectionCallbacks;
import java.util.ArrayList;

final class hF
  extends Handler
{
  public hF(hE paramhE, Looper paramLooper)
  {
    super(paramLooper);
  }
  
  public void handleMessage(Message paramMessage)
  {
    if (paramMessage.what == 1) {
      synchronized (hE.a(this.a))
      {
        if ((hE.b(this.a).gN()) && (hE.b(this.a).isConnected()) && (hE.a(this.a).contains(paramMessage.obj)))
        {
          Bundle localBundle = hE.b(this.a).fX();
          ((GoogleApiClient.ConnectionCallbacks)paramMessage.obj).onConnected(localBundle);
        }
      }
    }
    Log.wtf("GmsClientEvents", "Don't know how to handle this message.");
  }
}


/* Location:           C:\Users\dreadiscool\Desktop\tools\classes-dex2jar.jar
 * Qualified Name:     hF
 * JD-Core Version:    0.7.0.1
 */