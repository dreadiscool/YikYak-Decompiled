package android.support.v4.accessibilityservice;

import android.accessibilityservice.AccessibilityServiceInfo;
import android.content.pm.ResolveInfo;

class AccessibilityServiceInfoCompat$AccessibilityServiceInfoIcsImpl
  extends AccessibilityServiceInfoCompat.AccessibilityServiceInfoStubImpl
{
  public boolean getCanRetrieveWindowContent(AccessibilityServiceInfo paramAccessibilityServiceInfo)
  {
    return AccessibilityServiceInfoCompatIcs.getCanRetrieveWindowContent(paramAccessibilityServiceInfo);
  }
  
  public int getCapabilities(AccessibilityServiceInfo paramAccessibilityServiceInfo)
  {
    if (getCanRetrieveWindowContent(paramAccessibilityServiceInfo)) {}
    for (int i = 1;; i = 0) {
      return i;
    }
  }
  
  public String getDescription(AccessibilityServiceInfo paramAccessibilityServiceInfo)
  {
    return AccessibilityServiceInfoCompatIcs.getDescription(paramAccessibilityServiceInfo);
  }
  
  public String getId(AccessibilityServiceInfo paramAccessibilityServiceInfo)
  {
    return AccessibilityServiceInfoCompatIcs.getId(paramAccessibilityServiceInfo);
  }
  
  public ResolveInfo getResolveInfo(AccessibilityServiceInfo paramAccessibilityServiceInfo)
  {
    return AccessibilityServiceInfoCompatIcs.getResolveInfo(paramAccessibilityServiceInfo);
  }
  
  public String getSettingsActivityName(AccessibilityServiceInfo paramAccessibilityServiceInfo)
  {
    return AccessibilityServiceInfoCompatIcs.getSettingsActivityName(paramAccessibilityServiceInfo);
  }
}


/* Location:           C:\Users\dreadiscool\Desktop\tools\classes-dex2jar.jar
 * Qualified Name:     android.support.v4.accessibilityservice.AccessibilityServiceInfoCompat.AccessibilityServiceInfoIcsImpl
 * JD-Core Version:    0.7.0.1
 */