package android.support.v4.app;

import android.view.View;
import android.view.Window;

class FragmentActivity$2
  implements FragmentContainer
{
  FragmentActivity$2(FragmentActivity paramFragmentActivity) {}
  
  public View findViewById(int paramInt)
  {
    return this.this$0.findViewById(paramInt);
  }
  
  public boolean hasView()
  {
    Window localWindow = this.this$0.getWindow();
    if ((localWindow != null) && (localWindow.peekDecorView() != null)) {}
    for (boolean bool = true;; bool = false) {
      return bool;
    }
  }
}


/* Location:           C:\Users\dreadiscool\Desktop\tools\classes-dex2jar.jar
 * Qualified Name:     android.support.v4.app.FragmentActivity.2
 * JD-Core Version:    0.7.0.1
 */