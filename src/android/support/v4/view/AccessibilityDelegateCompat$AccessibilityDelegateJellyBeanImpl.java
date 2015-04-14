package android.support.v4.view;

import android.os.Bundle;
import android.support.v4.view.accessibility.AccessibilityNodeProviderCompat;
import android.view.View;

class AccessibilityDelegateCompat$AccessibilityDelegateJellyBeanImpl
  extends AccessibilityDelegateCompat.AccessibilityDelegateIcsImpl
{
  public AccessibilityNodeProviderCompat getAccessibilityNodeProvider(Object paramObject, View paramView)
  {
    Object localObject = AccessibilityDelegateCompatJellyBean.getAccessibilityNodeProvider(paramObject, paramView);
    if (localObject != null) {}
    for (AccessibilityNodeProviderCompat localAccessibilityNodeProviderCompat = new AccessibilityNodeProviderCompat(localObject);; localAccessibilityNodeProviderCompat = null) {
      return localAccessibilityNodeProviderCompat;
    }
  }
  
  public Object newAccessiblityDelegateBridge(AccessibilityDelegateCompat paramAccessibilityDelegateCompat)
  {
    return AccessibilityDelegateCompatJellyBean.newAccessibilityDelegateBridge(new AccessibilityDelegateCompat.AccessibilityDelegateJellyBeanImpl.1(this, paramAccessibilityDelegateCompat));
  }
  
  public boolean performAccessibilityAction(Object paramObject, View paramView, int paramInt, Bundle paramBundle)
  {
    return AccessibilityDelegateCompatJellyBean.performAccessibilityAction(paramObject, paramView, paramInt, paramBundle);
  }
}


/* Location:           C:\Users\dreadiscool\Desktop\tools\classes-dex2jar.jar
 * Qualified Name:     android.support.v4.view.AccessibilityDelegateCompat.AccessibilityDelegateJellyBeanImpl
 * JD-Core Version:    0.7.0.1
 */