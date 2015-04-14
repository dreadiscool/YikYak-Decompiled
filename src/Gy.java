import com.yik.yak.ui.activity.MainActivity;
import com.yik.yak.ui.view.RefreshListView;
import java.util.ArrayList;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

class Gy
  implements Runnable
{
  Gy(Gx paramGx, JSONObject paramJSONObject) {}
  
  public void run()
  {
    for (;;)
    {
      int i;
      try
      {
        JSONArray localJSONArray = this.a.getJSONArray("messages");
        this.b.b = localJSONArray.length();
        i = 0;
        if (i < this.b.b)
        {
          localCK = new CK(localJSONArray.getJSONObject(i), this.b.e.c, this.b.e.d, this.b.e.e, this.b.c, this.b.b - i);
          if (!this.b.d.equals("")) {
            continue;
          }
          if (this.b.e.v == Fn.b) {
            this.b.e.m.add(localCK);
          } else {
            this.b.e.l.add(localCK);
          }
        }
      }
      catch (JSONException localJSONException)
      {
        try
        {
          CK localCK;
          if (this.b.d.equals(""))
          {
            this.b.e.a(this.b.e.p, this.b.e.p);
            ((MainActivity)this.b.e.getActivity()).c();
            this.b.e.D.setRefreshing(false);
            this.b.e.h();
            return;
            this.b.e.l.add(localCK);
            this.b.e.m.add(localCK);
          }
          else
          {
            this.b.e.a(this.b.e.p, this.b.e.q);
            continue;
          }
        }
        catch (Exception localException)
        {
          continue;
        }
      }
      i++;
    }
  }
}


/* Location:           C:\Users\dreadiscool\Desktop\tools\classes-dex2jar.jar
 * Qualified Name:     Gy
 * JD-Core Version:    0.7.0.1
 */