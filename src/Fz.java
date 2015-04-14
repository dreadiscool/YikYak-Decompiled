import android.graphics.Rect;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.view.ViewTreeObserver.OnGlobalLayoutListener;
import com.yik.yak.ui.adapter.YakDetailAdapter;
import com.yik.yak.ui.fragment.CommentFragment;
import com.yik.yak.ui.view.RefreshListView;

public class Fz
  implements ViewTreeObserver.OnGlobalLayoutListener
{
  public Fz(CommentFragment paramCommentFragment) {}
  
  public void onGlobalLayout()
  {
    Rect localRect = new Rect();
    CommentFragment.b(this.a).getWindowVisibleDisplayFrame(localRect);
    if (CommentFragment.b(this.a).getRootView().getHeight() - (localRect.bottom - localRect.top) > 100) {
      if (!this.a.h)
      {
        this.a.h = true;
        this.a.p.e().smoothScrollToPosition(-1 + this.a.o.getItemCount());
      }
    }
    for (;;)
    {
      return;
      if (this.a.h) {
        this.a.h = false;
      }
    }
  }
}


/* Location:           C:\Users\dreadiscool\Desktop\tools\classes-dex2jar.jar
 * Qualified Name:     Fz
 * JD-Core Version:    0.7.0.1
 */