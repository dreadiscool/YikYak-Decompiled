import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import com.mixpanel.android.mpmetrics.MixpanelAPI;
import java.util.Iterator;
import java.util.Set;
import org.json.JSONException;
import org.json.JSONObject;

public final class uO
  extends BroadcastReceiver
{
  public uO(MixpanelAPI paramMixpanelAPI) {}
  
  public void onReceive(Context paramContext, Intent paramIntent)
  {
    JSONObject localJSONObject = new JSONObject();
    Bundle localBundle = paramIntent.getBundleExtra("event_args");
    if (localBundle != null)
    {
      Iterator localIterator = localBundle.keySet().iterator();
      while (localIterator.hasNext())
      {
        String str = (String)localIterator.next();
        try
        {
          localJSONObject.put(str, localBundle.get(str));
        }
        catch (JSONException localJSONException)
        {
          new StringBuilder().append("failed to add key \"").append(str).append("\" to properties for tracking bolts event").toString();
        }
      }
    }
    this.a.track("$" + paramIntent.getStringExtra("event_name"), localJSONObject);
  }
}


/* Location:           C:\Users\dreadiscool\Desktop\tools\classes-dex2jar.jar
 * Qualified Name:     uO
 * JD-Core Version:    0.7.0.1
 */