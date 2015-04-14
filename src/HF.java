import android.annotation.TargetApi;
import android.os.Build.VERSION;
import android.view.View;

public class HF
{
  public static int a(int paramInt)
  {
    if (Build.VERSION.SDK_INT >= 11) {}
    for (int i = c(paramInt);; i = b(paramInt)) {
      return i;
    }
  }
  
  public static void a(View paramView, Runnable paramRunnable)
  {
    if (Build.VERSION.SDK_INT >= 16) {
      b(paramView, paramRunnable);
    }
    for (;;)
    {
      return;
      paramView.postDelayed(paramRunnable, 16L);
    }
  }
  
  @TargetApi(5)
  private static int b(int paramInt)
  {
    return (0xFF00 & paramInt) >> 8;
  }
  
  @TargetApi(16)
  private static void b(View paramView, Runnable paramRunnable)
  {
    paramView.postOnAnimation(paramRunnable);
  }
  
  @TargetApi(11)
  private static int c(int paramInt)
  {
    return (0xFF00 & paramInt) >> 8;
  }
}


/* Location:           C:\Users\dreadiscool\Desktop\tools\classes-dex2jar.jar
 * Qualified Name:     HF
 * JD-Core Version:    0.7.0.1
 */