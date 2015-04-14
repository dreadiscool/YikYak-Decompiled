import android.os.Handler;
import com.yik.yak.ui.adapter.viewholder.YakDetailViewHolder;

public class ET
  implements Runnable
{
  public ET(YakDetailViewHolder paramYakDetailViewHolder) {}
  
  public void run()
  {
    bx.a(bw.k).a(1000L).a(this.a.shareButton);
    new Handler().postDelayed(new EU(this), 500L);
  }
}


/* Location:           C:\Users\dreadiscool\Desktop\tools\classes-dex2jar.jar
 * Qualified Name:     ET
 * JD-Core Version:    0.7.0.1
 */