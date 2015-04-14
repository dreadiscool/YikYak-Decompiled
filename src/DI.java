import android.os.Handler;
import android.view.View;
import android.view.View.OnClickListener;
import com.yik.yak.ui.activity.ReportDialog;

public class DI
  implements View.OnClickListener
{
  public DI(ReportDialog paramReportDialog) {}
  
  public void onClick(View paramView)
  {
    this.a.setResult(0);
    DJ localDJ = new DJ(this);
    new Handler().postDelayed(localDJ, 250L);
  }
}


/* Location:           C:\Users\dreadiscool\Desktop\tools\classes-dex2jar.jar
 * Qualified Name:     DI
 * JD-Core Version:    0.7.0.1
 */