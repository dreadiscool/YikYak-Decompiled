package android.support.v4.view;

import android.view.View;
import android.view.View.OnApplyWindowInsetsListener;
import android.view.WindowInsets;

final class ViewCompatApi21$1
  implements View.OnApplyWindowInsetsListener
{
  ViewCompatApi21$1(OnApplyWindowInsetsListener paramOnApplyWindowInsetsListener) {}
  
  public WindowInsets onApplyWindowInsets(View paramView, WindowInsets paramWindowInsets)
  {
    WindowInsetsCompatApi21 localWindowInsetsCompatApi21 = new WindowInsetsCompatApi21(paramWindowInsets);
    return ((WindowInsetsCompatApi21)this.val$listener.onApplyWindowInsets(paramView, localWindowInsetsCompatApi21)).unwrap();
  }
}


/* Location:           C:\Users\dreadiscool\Desktop\tools\classes-dex2jar.jar
 * Qualified Name:     android.support.v4.view.ViewCompatApi21.1
 * JD-Core Version:    0.7.0.1
 */