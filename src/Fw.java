import android.content.res.Resources;
import android.support.v4.app.FragmentActivity;
import com.yik.yak.ui.adapter.YakDetailAdapter;
import com.yik.yak.ui.fragment.CommentFragment;
import com.yik.yak.ui.view.RefreshListView;
import java.util.ArrayList;

class Fw
  implements Runnable
{
  Fw(Ft paramFt) {}
  
  public void run()
  {
    this.a.c.b.clear();
    CK localCK = new CK();
    localCK.o = this.a.c.getActivity().getResources().getString(2131230946);
    localCK.x = true;
    this.a.c.b.add(localCK);
    this.a.c.o.setData(this.a.c.b);
    this.a.c.o.notifyDataSetChanged();
    this.a.c.p.setRefreshing(false);
  }
}


/* Location:           C:\Users\dreadiscool\Desktop\tools\classes-dex2jar.jar
 * Qualified Name:     Fw
 * JD-Core Version:    0.7.0.1
 */