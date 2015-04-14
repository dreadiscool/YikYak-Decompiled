import android.view.View;
import android.view.View.OnClickListener;
import com.nispok.snackbar.Snackbar;

public class ys
  implements View.OnClickListener
{
  public ys(Snackbar paramSnackbar) {}
  
  public void onClick(View paramView)
  {
    if ((Snackbar.a(this.a) != null) && (!Snackbar.b(this.a)) && ((!Snackbar.c(this.a)) || (Snackbar.d(this.a))))
    {
      Snackbar.a(this.a).a(this.a);
      Snackbar.a(this.a, true);
    }
    if (Snackbar.e(this.a)) {
      this.a.b();
    }
  }
}


/* Location:           C:\Users\dreadiscool\Desktop\tools\classes-dex2jar.jar
 * Qualified Name:     ys
 * JD-Core Version:    0.7.0.1
 */