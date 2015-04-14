import android.content.Context;
import android.content.res.Resources;
import android.util.DisplayMetrics;

public class fF
  implements gm
{
  private static fF a;
  private static Object b = new Object();
  private final Context c;
  
  protected fF(Context paramContext)
  {
    this.c = paramContext;
  }
  
  public static fF a()
  {
    synchronized (b)
    {
      fF localfF = a;
      return localfF;
    }
  }
  
  public static void a(Context paramContext)
  {
    synchronized (b)
    {
      if (a == null) {
        a = new fF(paramContext);
      }
      return;
    }
  }
  
  public String a(String paramString)
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
  
  protected String b()
  {
    DisplayMetrics localDisplayMetrics = this.c.getResources().getDisplayMetrics();
    return localDisplayMetrics.widthPixels + "x" + localDisplayMetrics.heightPixels;
  }
  
  public boolean b(String paramString)
  {
    return "&sr".equals(paramString);
  }
}


/* Location:           C:\Users\dreadiscool\Desktop\tools\classes-dex2jar.jar
 * Qualified Name:     fF
 * JD-Core Version:    0.7.0.1
 */