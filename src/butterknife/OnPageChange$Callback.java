package butterknife;

import butterknife.internal.ListenerMethod;

public enum OnPageChange$Callback
{
  static
  {
    PAGE_SCROLLED = new Callback("PAGE_SCROLLED", 1);
    PAGE_SCROLL_STATE_CHANGED = new Callback("PAGE_SCROLL_STATE_CHANGED", 2);
    Callback[] arrayOfCallback = new Callback[3];
    arrayOfCallback[0] = PAGE_SELECTED;
    arrayOfCallback[1] = PAGE_SCROLLED;
    arrayOfCallback[2] = PAGE_SCROLL_STATE_CHANGED;
    $VALUES = arrayOfCallback;
  }
  
  private OnPageChange$Callback() {}
}


/* Location:           C:\Users\dreadiscool\Desktop\tools\classes-dex2jar.jar
 * Qualified Name:     butterknife.OnPageChange.Callback
 * JD-Core Version:    0.7.0.1
 */