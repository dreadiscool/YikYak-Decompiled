import android.content.res.Resources;
import android.os.Handler;
import android.support.v4.app.FragmentActivity;
import com.yik.yak.ui.adapter.YakDetailAdapter;
import com.yik.yak.ui.fragment.CommentFragment;
import com.yik.yak.ui.view.RefreshListView;
import java.util.ArrayList;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

class Fu
  implements Runnable
{
  Fu(Ft paramFt, JSONObject paramJSONObject) {}
  
  public void run()
  {
    try
    {
      this.b.c.b.clear();
      JSONArray localJSONArray = this.a.getJSONArray("comments");
      int i = localJSONArray.length();
      for (int j = 0; j < i; j++)
      {
        Object[] arrayOfObject = new Object[1];
        arrayOfObject[0] = localJSONArray.getJSONObject(j);
        Iq.a(this, arrayOfObject);
        this.b.c.b.add(new CK(localJSONArray.getJSONObject(j), this.b.c.d, this.b.c.e, this.b.c.f, this.b.c.getActivity(), i - j));
      }
      this.b.c.k.f = this.b.c.b.size();
      this.b.c.o.setHeaderData(this.b.c.k);
      if (this.b.c.b.isEmpty())
      {
        CK localCK = new CK();
        localCK.o = this.b.c.getActivity().getResources().getString(2131230946);
        localCK.x = true;
        this.b.c.b.add(localCK);
      }
      this.b.c.o.setData(this.b.c.b);
      this.b.c.o.notifyDataSetChanged();
      this.b.c.p.setRefreshing(false);
      if (this.b.b) {
        this.b.a.postDelayed(new Fv(this), 500L);
      }
      return;
    }
    catch (JSONException localJSONException)
    {
      for (;;)
      {
        new StringBuilder().append("JSON Failed:").append(this.a).toString();
      }
    }
  }
}


/* Location:           C:\Users\dreadiscool\Desktop\tools\classes-dex2jar.jar
 * Qualified Name:     Fu
 * JD-Core Version:    0.7.0.1
 */