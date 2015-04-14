import android.content.Context;
import android.content.res.Resources;
import com.yik.yak.ui.activity.SendAYak;

class Eb
  implements Runnable
{
  Eb(Ea paramEa) {}
  
  public void run()
  {
    if (!Ik.a(SendAYak.b(this.a.c))) {
      SendAYak.a(this.a.c, SendAYak.d(this.a.c).getResources().getString(2131230987), SendAYak.d(this.a.c).getResources().getString(2131230984));
    }
    If.a().a(this.a.b, "MainFeed");
    this.a.c.setResult(2001);
    SendAYak.e(this.a.c);
    this.a.c.finish();
  }
}


/* Location:           C:\Users\dreadiscool\Desktop\tools\classes-dex2jar.jar
 * Qualified Name:     Eb
 * JD-Core Version:    0.7.0.1
 */