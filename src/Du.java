import com.yik.yak.ui.activity.PeekSearchActivity;
import java.util.ArrayList;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

class Du
  implements Runnable
{
  Du(Dt paramDt, JSONObject paramJSONObject) {}
  
  public void run()
  {
    try
    {
      JSONArray localJSONArray = this.a.getJSONArray("messages");
      int i = localJSONArray.length();
      for (int j = 0; j < i; j++)
      {
        CK localCK = new CK(localJSONArray.getJSONObject(j), false, false, false, PeekSearchActivity.f(this.b.b), i - j);
        PeekSearchActivity.g(this.b.b).add(localCK);
      }
      try
      {
        PeekSearchActivity.h(this.b.b);
        this.b.b.b();
        return;
      }
      catch (Exception localException)
      {
        break label123;
      }
    }
    catch (JSONException localJSONException)
    {
      new StringBuilder().append("Failed:").append(localJSONException.getMessage()).append("").toString();
    }
  }
}


/* Location:           C:\Users\dreadiscool\Desktop\tools\classes-dex2jar.jar
 * Qualified Name:     Du
 * JD-Core Version:    0.7.0.1
 */