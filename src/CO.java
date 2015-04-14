import android.os.Bundle;
import android.os.Handler.Callback;
import android.os.Message;
import com.google.android.gms.common.api.GoogleApiClient.ConnectionCallbacks;

class CO
  implements GoogleApiClient.ConnectionCallbacks
{
  CO(CM paramCM) {}
  
  public void onConnected(Bundle paramBundle)
  {
    if (CM.a(this.a) != null)
    {
      Message localMessage = new Message();
      localMessage.arg1 = 1;
      CM.a(this.a).handleMessage(localMessage);
    }
    this.a.h();
  }
  
  public void onConnectionSuspended(int paramInt)
  {
    if (CM.a(this.a) != null)
    {
      Message localMessage = new Message();
      localMessage.arg1 = 0;
      CM.a(this.a).handleMessage(localMessage);
    }
    CM.a(this.a, null);
  }
}


/* Location:           C:\Users\dreadiscool\Desktop\tools\classes-dex2jar.jar
 * Qualified Name:     CO
 * JD-Core Version:    0.7.0.1
 */