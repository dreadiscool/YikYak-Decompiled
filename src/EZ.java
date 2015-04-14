import com.yik.yak.ui.activity.MainActivity;
import com.yik.yak.ui.view.RefreshListView;
import java.util.ArrayList;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

class EZ
  implements Runnable
{
  EZ(EY paramEY, JSONObject paramJSONObject) {}
  
  public void run()
  {
    try
    {
      JSONArray localJSONArray = this.a.getJSONArray("messages");
      this.b.b = localJSONArray.length();
      for (int i = 0; i < this.b.b; i++)
      {
        CK localCK = new CK(localJSONArray.getJSONObject(i), this.b.d.c, this.b.d.d, this.b.d.e, this.b.c, this.b.b - i);
        this.b.d.l.add(localCK);
        this.b.d.m.add(localCK);
      }
      try
      {
        this.b.d.a(this.b.d.p, this.b.d.q);
        ((MainActivity)this.b.d.getActivity()).c();
        this.b.d.D.setRefreshing(false);
        this.b.d.h();
        return;
      }
      catch (Exception localException)
      {
        break label183;
      }
    }
    catch (JSONException localJSONException) {}
  }
}


/* Location:           C:\Users\dreadiscool\Desktop\tools\classes-dex2jar.jar
 * Qualified Name:     EZ
 * JD-Core Version:    0.7.0.1
 */