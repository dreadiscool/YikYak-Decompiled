import com.yik.yak.ui.activity.MainActivity;
import com.yik.yak.ui.view.RefreshListView;
import java.util.ArrayList;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

class Gv
  implements Runnable
{
  Gv(Gu paramGu, JSONObject paramJSONObject) {}
  
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
          CK localCK = new CK(localJSONArray.getJSONObject(i), this.b.d.c, this.b.d.d, this.b.d.e, this.b.c, this.b.b - i);
          if (this.b.d.v == Fn.b) {
            this.b.d.m.add(localCK);
          } else {
            this.b.d.l.add(localCK);
          }
        }
      }
      catch (JSONException localJSONException)
      {
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
          continue;
        }
      }
      i++;
    }
  }
}


/* Location:           C:\Users\dreadiscool\Desktop\tools\classes-dex2jar.jar
 * Qualified Name:     Gv
 * JD-Core Version:    0.7.0.1
 */