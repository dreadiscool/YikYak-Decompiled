import android.view.View;
import com.nispok.snackbar.Snackbar;

public class yt
  implements yI
{
  public yt(Snackbar paramSnackbar) {}
  
  public void a(View paramView, Object paramObject)
  {
    if (paramView != null) {
      Snackbar.b(this.a, false);
    }
  }
  
  public void a(boolean paramBoolean)
  {
    if (Snackbar.f(this.a)) {}
    for (;;)
    {
      return;
      if (paramBoolean)
      {
        this.a.removeCallbacks(Snackbar.g(this.a));
        Snackbar.a(this.a, System.currentTimeMillis());
      }
      else
      {
        Snackbar.b(this.a, Snackbar.h(this.a) - (Snackbar.i(this.a) - Snackbar.j(this.a)));
        Snackbar.c(this.a, Snackbar.h(this.a));
      }
    }
  }
  
  public boolean a(Object paramObject)
  {
    return true;
  }
}


/* Location:           C:\Users\dreadiscool\Desktop\tools\classes-dex2jar.jar
 * Qualified Name:     yt
 * JD-Core Version:    0.7.0.1
 */