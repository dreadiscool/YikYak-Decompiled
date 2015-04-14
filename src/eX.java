import android.content.Context;
import android.content.res.Resources;
import android.util.DisplayMetrics;
import com.google.android.gms.common.util.VisibleForTesting;

public class eX
  implements el
{
  private static eX a;
  private static Object b = new Object();
  private final Context c;
  
  @VisibleForTesting
  protected eX(Context paramContext)
  {
    this.c = paramContext;
  }
  
  public static eX a()
  {
    synchronized (b)
    {
      eX localeX = a;
      return localeX;
    }
  }
  
  public static void a(Context paramContext)
  {
    synchronized (b)
    {
      if (a == null) {
        a = new eX(paramContext);
      }
      return;
    }
  }
  
  public boolean a(String paramString)
  {
    return "&sr".equals(paramString);
  }
  
  protected String b()
  {
    DisplayMetrics localDisplayMetrics = this.c.getResources().getDisplayMetrics();
    return localDisplayMetrics.widthPixels + "x" + localDisplayMetrics.heightPixels;
  }
  
  public String b(String paramString)
  {
    String str = null;
    if (paramString == null) {}
    for (;;)
    {
      return str;
      if (paramString.equals("&sr")) {
        str = b();
      }
    }
  }
}


/* Location:           C:\Users\dreadiscool\Desktop\tools\classes-dex2jar.jar
 * Qualified Name:     eX
 * JD-Core Version:    0.7.0.1
 */