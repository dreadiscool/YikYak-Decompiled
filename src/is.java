import android.content.Context;
import android.content.pm.PackageManager;
import java.util.regex.Pattern;

public final class is
{
  private static Pattern a = null;
  
  public static int a(int paramInt)
  {
    return paramInt / 1000;
  }
  
  public static boolean a(Context paramContext)
  {
    return paramContext.getPackageManager().hasSystemFeature("android.hardware.type.watch");
  }
  
  public static int b(int paramInt)
  {
    return paramInt % 1000 / 100;
  }
  
  public static boolean c(int paramInt)
  {
    if (b(paramInt) == 3) {}
    for (boolean bool = true;; bool = false) {
      return bool;
    }
  }
}


/* Location:           C:\Users\dreadiscool\Desktop\tools\classes-dex2jar.jar
 * Qualified Name:     is
 * JD-Core Version:    0.7.0.1
 */