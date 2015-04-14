import android.os.Handler.Callback;
import android.os.Message;
import com.google.android.gms.common.ConnectionResult;
import com.google.android.gms.common.api.GoogleApiClient.OnConnectionFailedListener;

class CN
  implements GoogleApiClient.OnConnectionFailedListener
{
  CN(CM paramCM) {}
  
  public void onConnectionFailed(ConnectionResult paramConnectionResult)
  {
    if (CM.a(this.a) != null)
    {
      Message localMessage = new Message();
      localMessage.arg1 = -1;
      CM.a(this.a).handleMessage(localMessage);
    }
  }
}


/* Location:           C:\Users\dreadiscool\Desktop\tools\classes-dex2jar.jar
 * Qualified Name:     CN
 * JD-Core Version:    0.7.0.1
 */