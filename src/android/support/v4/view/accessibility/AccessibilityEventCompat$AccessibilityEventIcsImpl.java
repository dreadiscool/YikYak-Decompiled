package android.support.v4.view.accessibility;

import android.view.accessibility.AccessibilityEvent;

class AccessibilityEventCompat$AccessibilityEventIcsImpl
  extends AccessibilityEventCompat.AccessibilityEventStubImpl
{
  public void appendRecord(AccessibilityEvent paramAccessibilityEvent, Object paramObject)
  {
    AccessibilityEventCompatIcs.appendRecord(paramAccessibilityEvent, paramObject);
  }
  
  public Object getRecord(AccessibilityEvent paramAccessibilityEvent, int paramInt)
  {
    return AccessibilityEventCompatIcs.getRecord(paramAccessibilityEvent, paramInt);
  }
  
  public int getRecordCount(AccessibilityEvent paramAccessibilityEvent)
  {
    return AccessibilityEventCompatIcs.getRecordCount(paramAccessibilityEvent);
  }
}


/* Location:           C:\Users\dreadiscool\Desktop\tools\classes-dex2jar.jar
 * Qualified Name:     android.support.v4.view.accessibility.AccessibilityEventCompat.AccessibilityEventIcsImpl
 * JD-Core Version:    0.7.0.1
 */