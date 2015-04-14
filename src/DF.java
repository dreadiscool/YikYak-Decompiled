import android.view.View;
import butterknife.internal.DebouncingOnClickListener;
import com.yik.yak.ui.activity.ReportDialog;
import com.yik.yak.ui.activity.ReportDialog..ViewInjector;

public class DF
  extends DebouncingOnClickListener
{
  public DF(ReportDialog..ViewInjector paramViewInjector, ReportDialog paramReportDialog) {}
  
  public void doClick(View paramView)
  {
    this.a.onReportClick(paramView);
  }
}


/* Location:           C:\Users\dreadiscool\Desktop\tools\classes-dex2jar.jar
 * Qualified Name:     DF
 * JD-Core Version:    0.7.0.1
 */