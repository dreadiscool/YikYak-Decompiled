package android.support.v4.view.accessibility;

public class AccessibilityNodeInfoCompat$AccessibilityActionCompat
{
  private final Object mAction;
  
  private AccessibilityNodeInfoCompat$AccessibilityActionCompat(Object paramObject)
  {
    this.mAction = paramObject;
  }
  
  public int getId()
  {
    return AccessibilityNodeInfoCompatApi21.AccessibilityAction.getId(this.mAction);
  }
  
  public CharSequence getLabel()
  {
    return AccessibilityNodeInfoCompatApi21.AccessibilityAction.getLabel(this.mAction);
  }
}


/* Location:           C:\Users\dreadiscool\Desktop\tools\classes-dex2jar.jar
 * Qualified Name:     android.support.v4.view.accessibility.AccessibilityNodeInfoCompat.AccessibilityActionCompat
 * JD-Core Version:    0.7.0.1
 */