package butterknife;

import butterknife.internal.ListenerMethod;

public enum OnTextChanged$Callback
{
  static
  {
    BEFORE_TEXT_CHANGED = new Callback("BEFORE_TEXT_CHANGED", 1);
    AFTER_TEXT_CHANGED = new Callback("AFTER_TEXT_CHANGED", 2);
    Callback[] arrayOfCallback = new Callback[3];
    arrayOfCallback[0] = TEXT_CHANGED;
    arrayOfCallback[1] = BEFORE_TEXT_CHANGED;
    arrayOfCallback[2] = AFTER_TEXT_CHANGED;
    $VALUES = arrayOfCallback;
  }
  
  private OnTextChanged$Callback() {}
}


/* Location:           C:\Users\dreadiscool\Desktop\tools\classes-dex2jar.jar
 * Qualified Name:     butterknife.OnTextChanged.Callback
 * JD-Core Version:    0.7.0.1
 */