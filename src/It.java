import android.app.Activity;
import android.app.AlertDialog.Builder;
import android.app.Dialog;
import android.content.Context;

public class It
{
  public static Dialog a(Context paramContext, int paramInt1, int paramInt2, Runnable paramRunnable1, Runnable paramRunnable2)
  {
    return a(paramContext, paramContext.getString(paramInt1), paramContext.getString(paramInt2), paramRunnable1, paramRunnable2);
  }
  
  public static Dialog a(Context paramContext, String paramString1, String paramString2, Runnable paramRunnable1, Runnable paramRunnable2)
  {
    Object localObject;
    if (((paramContext instanceof Activity)) && (((Activity)paramContext).isFinishing())) {
      localObject = null;
    }
    for (;;)
    {
      return localObject;
      localObject = new AlertDialog.Builder(paramContext).setTitle(paramString1).setMessage(paramString2).setCancelable(false).setPositiveButton(2131231036, new Iv(paramRunnable1)).setNegativeButton(2131230941, new Iu(paramRunnable2)).create();
      ((Dialog)localObject).show();
    }
  }
}


/* Location:           C:\Users\dreadiscool\Desktop\tools\classes-dex2jar.jar
 * Qualified Name:     It
 * JD-Core Version:    0.7.0.1
 */