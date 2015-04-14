import android.view.View;
import android.view.View.OnClickListener;
import android.widget.ImageView;
import com.yik.yak.ui.adapter.YakRecyclerViewAdapter;
import com.yik.yak.ui.view.RefreshListView;
import java.util.ArrayList;

class Fd
  implements View.OnClickListener
{
  Fd(Fb paramFb) {}
  
  public void onClick(View paramView)
  {
    if (this.a.v != Fn.a)
    {
      If.a().j("Hot");
      this.a.v = Fn.a;
      this.a.c();
    }
    this.a.v = Fn.a;
    if ((this.a.l == null) || (this.a.l.isEmpty())) {
      this.a.a();
    }
    for (;;)
    {
      return;
      this.a.D.setAdapter(this.a.x);
      this.a.x.setData(this.a.l);
      this.a.x.notifyDataSetChanged();
      this.a.D.setRefreshing(false);
      this.a.z.setVisibility(0);
      this.a.A.setVisibility(8);
      this.a.f();
    }
  }
}


/* Location:           C:\Users\dreadiscool\Desktop\tools\classes-dex2jar.jar
 * Qualified Name:     Fd
 * JD-Core Version:    0.7.0.1
 */