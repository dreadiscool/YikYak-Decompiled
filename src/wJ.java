import android.view.View;
import android.view.View.AccessibilityDelegate;

class wJ
  extends View.AccessibilityDelegate
{
  private View.AccessibilityDelegate b;
  
  public wJ(wI paramwI, View.AccessibilityDelegate paramAccessibilityDelegate)
  {
    this.b = paramAccessibilityDelegate;
  }
  
  public View.AccessibilityDelegate a()
  {
    return this.b;
  }
  
  public void a(wJ paramwJ)
  {
    if (this.b == paramwJ) {
      this.b = paramwJ.a();
    }
    for (;;)
    {
      return;
      if ((this.b instanceof wJ)) {
        ((wJ)this.b).a(paramwJ);
      }
    }
  }
  
  public boolean a(String paramString)
  {
    boolean bool;
    if (this.a.b() == paramString) {
      bool = true;
    }
    for (;;)
    {
      return bool;
      if ((this.b instanceof wJ)) {
        bool = ((wJ)this.b).a(paramString);
      } else {
        bool = false;
      }
    }
  }
  
  public void sendAccessibilityEvent(View paramView, int paramInt)
  {
    if (paramInt == wI.a(this.a)) {
      this.a.c(paramView);
    }
    if (this.b != null) {
      this.b.sendAccessibilityEvent(paramView, paramInt);
    }
  }
}


/* Location:           C:\Users\dreadiscool\Desktop\tools\classes-dex2jar.jar
 * Qualified Name:     wJ
 * JD-Core Version:    0.7.0.1
 */