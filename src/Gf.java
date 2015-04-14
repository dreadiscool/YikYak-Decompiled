import android.content.Intent;
import android.view.View;
import android.widget.AdapterView;
import android.widget.AdapterView.OnItemClickListener;
import android.widget.Toast;
import com.yik.yak.ui.activity.YakDetailActivity;
import java.util.ArrayList;
import java.util.List;
import org.json.JSONObject;

class Gf
  implements AdapterView.OnItemClickListener
{
  Gf(Gd paramGd) {}
  
  public void onItemClick(AdapterView<?> paramAdapterView, View paramView, int paramInt, long paramLong)
  {
    Gd.a(this.a, (Cu)Gd.a(this.a).get(paramInt));
    if ((Gd.b(this.a).i().equals("new")) || (Gd.b(this.a).i().equals("unread")))
    {
      ArrayList localArrayList = new ArrayList();
      localArrayList.add(Gd.b(this.a));
      this.a.a(Cw.i, localArrayList, "read");
    }
    if (!Gd.b(this.a).i().equals("system"))
    {
      CK localCK = new CK(Gd.b(this.a).b(), Gd.c(this.a), 1);
      if (localCK.E) {
        break label246;
      }
      Intent localIntent = new Intent(this.a.getActivity(), YakDetailActivity.class);
      localIntent.putExtra("canVote", localCK.G);
      localIntent.putExtra("canReply", localCK.F);
      localIntent.putExtra("canReport", localCK.H);
      localIntent.putExtra("caller", "NotificationCenter");
      localIntent.putExtra("yak", localCK.d().toString());
      this.a.startActivityForResult(localIntent, 123);
    }
    for (;;)
    {
      return;
      label246:
      Toast.makeText(Gd.c(this.a), "The yak is no longer available.", 0).show();
    }
  }
}


/* Location:           C:\Users\dreadiscool\Desktop\tools\classes-dex2jar.jar
 * Qualified Name:     Gf
 * JD-Core Version:    0.7.0.1
 */