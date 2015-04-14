import android.os.Handler;
import com.yik.yak.ui.activity.SendAYak;
import com.yik.yak.ui.view.LinkDetectingEditText;
import com.yik.yak.ui.view.LinkIconView;

public class DR
  implements Hk
{
  public DR(SendAYak paramSendAYak) {}
  
  public void a()
  {
    SendAYak.r(this.a).removeCallbacks(SendAYak.q(this.a));
    SendAYak.s(this.a);
    SendAYak.t(this.a).setIconState(Hm.c);
  }
  
  public void b()
  {
    SendAYak.r(this.a).removeCallbacks(SendAYak.q(this.a));
    SendAYak.r(this.a).postDelayed(SendAYak.q(this.a), 500L);
  }
  
  public void c()
  {
    SendAYak.r(this.a).removeCallbacks(SendAYak.q(this.a));
    SendAYak.t(this.a).setIconState(Hm.a);
    SendAYak.i(this.a).setLinkTextColor(-65536);
    SendAYak.a(this.a, "You can't put more than a single link!", yz.c);
  }
}


/* Location:           C:\Users\dreadiscool\Desktop\tools\classes-dex2jar.jar
 * Qualified Name:     DR
 * JD-Core Version:    0.7.0.1
 */