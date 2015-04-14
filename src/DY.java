import android.content.Context;
import android.content.res.Resources;
import com.yik.yak.ui.activity.SendAYak;

class DY
  implements Runnable
{
  DY(DX paramDX) {}
  
  public void run()
  {
    SendAYak.a(this.a.b, SendAYak.d(this.a.b).getResources().getString(2131230986), SendAYak.d(this.a.b).getResources().getString(2131230983));
    If.a().a(CK.a(0), "FeaturedPeek");
    this.a.b.setResult(2001);
    this.a.b.finish();
  }
}


/* Location:           C:\Users\dreadiscool\Desktop\tools\classes-dex2jar.jar
 * Qualified Name:     DY
 * JD-Core Version:    0.7.0.1
 */