package android.support.v4.view.accessibility;

import java.util.List;

class AccessibilityNodeInfoCompat$AccessibilityNodeInfoApi21Impl
  extends AccessibilityNodeInfoCompat.AccessibilityNodeInfoKitKatImpl
{
  public void addAction(Object paramObject, int paramInt, CharSequence paramCharSequence)
  {
    AccessibilityNodeInfoCompatApi21.addAction(paramObject, paramInt, paramCharSequence);
  }
  
  public List<Object> getActionList(Object paramObject)
  {
    return AccessibilityNodeInfoCompatApi21.getActionList(paramObject);
  }
  
  public boolean isCollectionItemSelected(Object paramObject)
  {
    return AccessibilityNodeInfoCompatApi21.CollectionItemInfo.isSelected(paramObject);
  }
  
  public Object obtainCollectionInfo(int paramInt1, int paramInt2, boolean paramBoolean, int paramInt3)
  {
    return AccessibilityNodeInfoCompatApi21.obtainCollectionInfo(paramInt1, paramInt2, paramBoolean, paramInt3);
  }
  
  public Object obtainCollectionItemInfo(int paramInt1, int paramInt2, int paramInt3, int paramInt4, boolean paramBoolean1, boolean paramBoolean2)
  {
    return AccessibilityNodeInfoCompatApi21.obtainCollectionItemInfo(paramInt1, paramInt2, paramInt3, paramInt4, paramBoolean1, paramBoolean2);
  }
}


/* Location:           C:\Users\dreadiscool\Desktop\tools\classes-dex2jar.jar
 * Qualified Name:     android.support.v4.view.accessibility.AccessibilityNodeInfoCompat.AccessibilityNodeInfoApi21Impl
 * JD-Core Version:    0.7.0.1
 */