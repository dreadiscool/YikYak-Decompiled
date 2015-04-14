import com.adjust.sdk.OnFinishedListener;
import com.adjust.sdk.ResponseData;
import com.amplitude.api.Amplitude;
import com.mixpanel.android.mpmetrics.MixpanelAPI;
import com.yik.yak.ui.activity.MainActivity;
import org.json.JSONException;
import org.json.JSONObject;

public class Dn
  implements OnFinishedListener
{
  public Dn(MainActivity paramMainActivity) {}
  
  public void onFinishedTracking(ResponseData paramResponseData)
  {
    MixpanelAPI localMixpanelAPI = If.a().c();
    JSONObject localJSONObject = new JSONObject();
    if (paramResponseData.getNetwork() != null) {}
    try
    {
      localJSONObject.put("[Adjust]Network", paramResponseData.getNetwork());
      if (paramResponseData.getCampaign() != null) {
        localJSONObject.put("[Adjust]Campaign", paramResponseData.getCampaign());
      }
      if (paramResponseData.getAdgroup() != null) {
        localJSONObject.put("[Adjust]Adgroup", paramResponseData.getAdgroup());
      }
      if (paramResponseData.getCreative() != null) {
        localJSONObject.put("[Adjust]Creative", paramResponseData.getCreative());
      }
      if (localJSONObject.length() > 0)
      {
        localMixpanelAPI.registerSuperProperties(localJSONObject);
        Amplitude.setUserProperties(localJSONObject);
      }
      return;
    }
    catch (JSONException localJSONException)
    {
      for (;;)
      {
        localJSONException.printStackTrace();
      }
    }
  }
}


/* Location:           C:\Users\dreadiscool\Desktop\tools\classes-dex2jar.jar
 * Qualified Name:     Dn
 * JD-Core Version:    0.7.0.1
 */