import android.support.v7.widget.RecyclerView;
import com.yik.yak.ui.adapter.YakDetailAdapter;
import com.yik.yak.ui.fragment.CommentFragment;
import com.yik.yak.ui.view.RefreshListView;

class Fv
  implements Runnable
{
  Fv(Fu paramFu) {}
  
  public void run()
  {
    this.a.b.c.p.e().smoothScrollToPosition(-1 + this.a.b.c.o.getItemCount());
  }
}


/* Location:           C:\Users\dreadiscool\Desktop\tools\classes-dex2jar.jar
 * Qualified Name:     Fv
 * JD-Core Version:    0.7.0.1
 */