package android.support.v4.view.accessibility;

import android.os.Bundle;
import android.view.accessibility.AccessibilityNodeInfo;
import android.view.accessibility.AccessibilityNodeProvider;
import java.util.List;

final class AccessibilityNodeProviderCompatKitKat$1
  extends AccessibilityNodeProvider
{
  AccessibilityNodeProviderCompatKitKat$1(AccessibilityNodeProviderCompatKitKat.AccessibilityNodeInfoBridge paramAccessibilityNodeInfoBridge) {}
  
  public AccessibilityNodeInfo createAccessibilityNodeInfo(int paramInt)
  {
    return (AccessibilityNodeInfo)this.val$bridge.createAccessibilityNodeInfo(paramInt);
  }
  
  public List<AccessibilityNodeInfo> findAccessibilityNodeInfosByText(String paramString, int paramInt)
  {
    return this.val$bridge.findAccessibilityNodeInfosByText(paramString, paramInt);
  }
  
  public AccessibilityNodeInfo findFocus(int paramInt)
  {
    return (AccessibilityNodeInfo)this.val$bridge.findFocus(paramInt);
  }
  
  public boolean performAction(int paramInt1, int paramInt2, Bundle paramBundle)
  {
    return this.val$bridge.performAction(paramInt1, paramInt2, paramBundle);
  }
}


/* Location:           C:\Users\dreadiscool\Desktop\tools\classes-dex2jar.jar
 * Qualified Name:     android.support.v4.view.accessibility.AccessibilityNodeProviderCompatKitKat.1
 * JD-Core Version:    0.7.0.1
 */