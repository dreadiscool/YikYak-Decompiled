import android.content.res.Resources;
import android.view.View;
import com.yik.yak.ui.view.RefreshListView;
import java.io.IOException;
import java.util.ArrayList;
import javax.net.ssl.SSLPeerUnverifiedException;

class Fi
  implements Runnable
{
  Fi(Fb paramFb, Exception paramException) {}
  
  public void run()
  {
    if (((this.a instanceof IOException)) && (!(this.a instanceof SSLPeerUnverifiedException)))
    {
      this.b.l = new ArrayList();
      this.b.m = null;
      CK localCK2 = new CK();
      localCK2.k = this.b.getResources().getString(2131230945);
      localCK2.h = 1;
      localCK2.l = this.b.getResources().getString(2131230944);
      localCK2.f = 0;
      localCK2.g = 1;
      localCK2.d = 99999;
      localCK2.i = 999999999;
      this.b.v = Fn.a;
      this.b.l.add(localCK2);
      this.b.a(this.b.p, this.b.p);
    }
    if ((this.a instanceof SSLPeerUnverifiedException)) {
      if (CR.a("googleAnalytics", "PeekSaved", true))
      {
        UrlHelper.a(true).a(null);
        If.a().b(false);
        this.b.a();
      }
    }
    for (;;)
    {
      return;
      If.a().b(false);
      this.b.l = new ArrayList();
      this.b.m = null;
      CK localCK1 = new CK();
      localCK1.k = this.b.getResources().getString(2131230945);
      localCK1.h = 1;
      localCK1.l = this.b.getResources().getString(2131230963);
      localCK1.f = 0;
      localCK1.g = 1;
      localCK1.d = 99999;
      localCK1.i = 999999999;
      this.b.v = Fn.a;
      this.b.l.add(localCK1);
      this.b.a(this.b.p, this.b.p);
      try
      {
        if (this.b.D.d() != null) {
          this.b.D.setRefreshing(false);
        }
        if ((this.b.l == null) || (this.b.l.size() == 0)) {
          this.b.E.findViewById(2131558505).setVisibility(0);
        }
        label408:
        this.b.h();
      }
      catch (Exception localException)
      {
        break label408;
      }
    }
  }
}



/* Location:           C:\Users\dreadiscool\Desktop\tools\classes-dex2jar.jar

 * Qualified Name:     Fi

 * JD-Core Version:    0.7.0.1

 */