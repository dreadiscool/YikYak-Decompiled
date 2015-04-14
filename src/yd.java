import android.app.Activity;
import android.graphics.Point;
import android.os.Build.VERSION;
import android.view.Display;
import android.view.WindowManager;

public class yd
{
  private static final ye a;
  
  static
  {
    if (Build.VERSION.SDK_INT >= 17) {
      a = new yg();
    }
    for (;;)
    {
      return;
      if (Build.VERSION.SDK_INT >= 13) {
        a = new yf();
      } else {
        a = new yh();
      }
    }
  }
  
  public static int a(Activity paramActivity, Float paramFloat)
  {
    Display localDisplay = paramActivity.getWindowManager().getDefaultDisplay();
    Point localPoint = new Point();
    b(localDisplay, localPoint);
    return (int)(localPoint.x * paramFloat.floatValue());
  }
  
  public static void a(Display paramDisplay, Point paramPoint)
  {
    a.a(paramDisplay, paramPoint);
  }
  
  public static void b(Display paramDisplay, Point paramPoint)
  {
    a.b(paramDisplay, paramPoint);
  }
}


/* Location:           C:\Users\dreadiscool\Desktop\tools\classes-dex2jar.jar
 * Qualified Name:     yd
 * JD-Core Version:    0.7.0.1
 */