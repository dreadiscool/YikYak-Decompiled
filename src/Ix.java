import android.app.Application;
import android.content.Context;
import android.os.Build.VERSION;

public class Ix
{
  private final Application a;
  private Iy b;
  
  public Ix(Context paramContext)
  {
    this.a = ((Application)paramContext.getApplicationContext());
    if (Build.VERSION.SDK_INT >= 14) {
      this.b = new Iy(this.a);
    }
  }
  
  public boolean a(IA paramIA)
  {
    if ((this.b != null) && (Iy.a(this.b, paramIA))) {}
    for (boolean bool = true;; bool = false) {
      return bool;
    }
  }
}


/* Location:           C:\Users\dreadiscool\Desktop\tools\classes-dex2jar.jar
 * Qualified Name:     Ix
 * JD-Core Version:    0.7.0.1
 */