package butterknife.internal;

import android.view.View;
import android.view.View.OnClickListener;

public abstract class DebouncingOnClickListener
  implements View.OnClickListener
{
  private static final Runnable ENABLE_AGAIN = new DebouncingOnClickListener.1();
  private static boolean enabled = true;
  
  public abstract void doClick(View paramView);
  
  public final void onClick(View paramView)
  {
    if (enabled)
    {
      enabled = false;
      paramView.post(ENABLE_AGAIN);
      doClick(paramView);
    }
  }
}


/* Location:           C:\Users\dreadiscool\Desktop\tools\classes-dex2jar.jar
 * Qualified Name:     butterknife.internal.DebouncingOnClickListener
 * JD-Core Version:    0.7.0.1
 */