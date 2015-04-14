import android.os.Build.VERSION;

public final class iv
{
  public static boolean a()
  {
    return a(11);
  }
  
  private static boolean a(int paramInt)
  {
    if (Build.VERSION.SDK_INT >= paramInt) {}
    for (boolean bool = true;; bool = false) {
      return bool;
    }
  }
  
  public static boolean b()
  {
    return a(13);
  }
  
  public static boolean c()
  {
    return a(14);
  }
  
  public static boolean d()
  {
    return a(16);
  }
}


/* Location:           C:\Users\dreadiscool\Desktop\tools\classes-dex2jar.jar
 * Qualified Name:     iv
 * JD-Core Version:    0.7.0.1
 */