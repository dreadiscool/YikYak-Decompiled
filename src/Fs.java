import com.yik.yak.ui.adapter.YakDetailAdapter;
import com.yik.yak.ui.fragment.CommentFragment;
import com.yik.yak.ui.view.RefreshListView;
import java.util.ArrayList;
import javax.net.ssl.SSLPeerUnverifiedException;

public class Fs
  implements Runnable
{
  public Fs(CommentFragment paramCommentFragment, Exception paramException) {}
  
  public void run()
  {
    this.b.b.clear();
    this.b.o.notifyDataSetChanged();
    this.b.p.setRefreshing(false);
    if ((this.a instanceof SSLPeerUnverifiedException))
    {
      If.a().b(false);
      if (CR.a("googleAnalytics", "PeekSaved", true))
      {
        UrlHelper.a(true).a(null);
        If.a().b(false);
        this.b.a();
      }
    }
  }
}



/* Location:           C:\Users\dreadiscool\Desktop\tools\classes-dex2jar.jar

 * Qualified Name:     Fs

 * JD-Core Version:    0.7.0.1

 */