import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.RecyclerView.OnScrollListener;
import android.view.View;
import android.widget.LinearLayout;
import com.yik.yak.ui.view.RefreshListView;

class Fk
  extends RecyclerView.OnScrollListener
{
  int a;
  
  Fk(Fb paramFb) {}
  
  public void onScrollStateChanged(RecyclerView paramRecyclerView, int paramInt)
  {
    super.onScrollStateChanged(paramRecyclerView, paramInt);
  }
  
  public void onScrolled(RecyclerView paramRecyclerView, int paramInt1, int paramInt2)
  {
    super.onScrolled(paramRecyclerView, paramInt1, paramInt2);
    int i;
    if (!this.b.i)
    {
      i = this.b.D.c().findFirstVisibleItemPosition();
      if (i <= this.a) {
        break label91;
      }
      if (!this.b.f)
      {
        this.b.g = false;
        this.b.f = true;
        this.b.C.startAnimation(this.b.u);
      }
    }
    for (;;)
    {
      this.a = i;
      return;
      label91:
      if ((i < this.a) && (!this.b.g))
      {
        this.b.g = true;
        this.b.f = false;
        this.b.E.findViewById(2131558746).setVisibility(0);
        this.b.E.findViewById(2131558743).setVisibility(0);
        this.b.C.setVisibility(0);
        this.b.C.startAnimation(this.b.t);
      }
    }
  }
}


/* Location:           C:\Users\dreadiscool\Desktop\tools\classes-dex2jar.jar
 * Qualified Name:     Fk
 * JD-Core Version:    0.7.0.1
 */