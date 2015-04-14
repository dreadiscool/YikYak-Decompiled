package android.support.v4.view.accessibility;

import android.os.Bundle;
import java.util.ArrayList;
import java.util.List;

class AccessibilityNodeProviderCompat$AccessibilityNodeProviderJellyBeanImpl$1
  implements AccessibilityNodeProviderCompatJellyBean.AccessibilityNodeInfoBridge
{
  AccessibilityNodeProviderCompat$AccessibilityNodeProviderJellyBeanImpl$1(AccessibilityNodeProviderCompat.AccessibilityNodeProviderJellyBeanImpl paramAccessibilityNodeProviderJellyBeanImpl, AccessibilityNodeProviderCompat paramAccessibilityNodeProviderCompat) {}
  
  public Object createAccessibilityNodeInfo(int paramInt)
  {
    AccessibilityNodeInfoCompat localAccessibilityNodeInfoCompat = this.val$compat.createAccessibilityNodeInfo(paramInt);
    if (localAccessibilityNodeInfoCompat == null) {}
    for (Object localObject = null;; localObject = localAccessibilityNodeInfoCompat.getInfo()) {
      return localObject;
    }
  }
  
  public List<Object> findAccessibilityNodeInfosByText(String paramString, int paramInt)
  {
    List localList = this.val$compat.findAccessibilityNodeInfosByText(paramString, paramInt);
    ArrayList localArrayList = new ArrayList();
    int i = localList.size();
    for (int j = 0; j < i; j++) {
      localArrayList.add(((AccessibilityNodeInfoCompat)localList.get(j)).getInfo());
    }
    return localArrayList;
  }
  
  public boolean performAction(int paramInt1, int paramInt2, Bundle paramBundle)
  {
    return this.val$compat.performAction(paramInt1, paramInt2, paramBundle);
  }
}


/* Location:           C:\Users\dreadiscool\Desktop\tools\classes-dex2jar.jar
 * Qualified Name:     android.support.v4.view.accessibility.AccessibilityNodeProviderCompat.AccessibilityNodeProviderJellyBeanImpl.1
 * JD-Core Version:    0.7.0.1
 */