import android.view.ViewGroup;
import com.nispok.snackbar.Snackbar;

public class yC
{
  private static final String a = yC.class.getSimpleName();
  private static Snackbar b;
  
  public static void a()
  {
    if (b != null) {
      b.b();
    }
  }
  
  public static void a(Snackbar paramSnackbar, ViewGroup paramViewGroup)
  {
    a(paramSnackbar, paramViewGroup, Snackbar.b(paramSnackbar.getContext()));
  }
  
  public static void a(Snackbar paramSnackbar, ViewGroup paramViewGroup, boolean paramBoolean)
  {
    if (b != null) {
      if ((b.f()) && (!b.g()))
      {
        b.a();
        b = paramSnackbar;
        b.a(paramViewGroup, paramBoolean);
      }
    }
    for (;;)
    {
      return;
      b.b();
      b = paramSnackbar;
      b.b(paramViewGroup, paramBoolean);
    }
  }
  
  public static Snackbar b()
  {
    return b;
  }
}


/* Location:           C:\Users\dreadiscool\Desktop\tools\classes-dex2jar.jar
 * Qualified Name:     yC
 * JD-Core Version:    0.7.0.1
 */