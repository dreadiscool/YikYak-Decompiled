import android.view.ViewTreeObserver;
import android.view.ViewTreeObserver.OnPreDrawListener;
import com.nispok.snackbar.Snackbar;

public class yu
  implements ViewTreeObserver.OnPreDrawListener
{
  public yu(Snackbar paramSnackbar) {}
  
  public boolean onPreDraw()
  {
    this.a.getViewTreeObserver().removeOnPreDrawListener(this);
    if ((Snackbar.k(this.a) != null) && (!Snackbar.l(this.a))) {
      Snackbar.c(this.a, false);
    }
    return true;
  }
}


/* Location:           C:\Users\dreadiscool\Desktop\tools\classes-dex2jar.jar
 * Qualified Name:     yu
 * JD-Core Version:    0.7.0.1
 */