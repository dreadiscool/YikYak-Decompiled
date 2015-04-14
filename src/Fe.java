import android.view.View;
import android.view.View.OnClickListener;
import android.widget.ImageView;
import com.yik.yak.ui.adapter.YakRecyclerViewAdapter;
import com.yik.yak.ui.view.RefreshListView;

class Fe
  implements View.OnClickListener
{
  Fe(Fb paramFb) {}
  
  public void onClick(View paramView)
  {
    if (this.a.v != Fn.b)
    {
      If.a().j("Hot");
      this.a.v = Fn.b;
      this.a.c();
    }
    this.a.v = Fn.b;
    if (this.a.m == null) {
      this.a.a();
    }
    for (;;)
    {
      return;
      this.a.D.setAdapter(this.a.y);
      this.a.y.setData(this.a.m);
      this.a.y.notifyDataSetChanged();
      this.a.D.setRefreshing(false);
      this.a.z.setVisibility(8);
      this.a.A.setVisibility(0);
      this.a.f();
    }
  }
}


/* Location:           C:\Users\dreadiscool\Desktop\tools\classes-dex2jar.jar
 * Qualified Name:     Fe
 * JD-Core Version:    0.7.0.1
 */