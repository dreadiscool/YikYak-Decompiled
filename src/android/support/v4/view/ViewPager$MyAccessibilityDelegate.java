package android.support.v4.view;

import android.os.Bundle;
import android.support.v4.view.accessibility.AccessibilityNodeInfoCompat;
import android.support.v4.view.accessibility.AccessibilityRecordCompat;
import android.view.View;
import android.view.accessibility.AccessibilityEvent;

class ViewPager$MyAccessibilityDelegate
  extends AccessibilityDelegateCompat
{
  ViewPager$MyAccessibilityDelegate(ViewPager paramViewPager) {}
  
  private boolean canScroll()
  {
    int i = 1;
    if ((ViewPager.access$200(this.this$0) != null) && (ViewPager.access$200(this.this$0).getCount() > i)) {}
    for (;;)
    {
      return i;
      int j = 0;
    }
  }
  
  public void onInitializeAccessibilityEvent(View paramView, AccessibilityEvent paramAccessibilityEvent)
  {
    super.onInitializeAccessibilityEvent(paramView, paramAccessibilityEvent);
    paramAccessibilityEvent.setClassName(ViewPager.class.getName());
    AccessibilityRecordCompat localAccessibilityRecordCompat = AccessibilityRecordCompat.obtain();
    localAccessibilityRecordCompat.setScrollable(canScroll());
    if ((paramAccessibilityEvent.getEventType() == 4096) && (ViewPager.access$200(this.this$0) != null))
    {
      localAccessibilityRecordCompat.setItemCount(ViewPager.access$200(this.this$0).getCount());
      localAccessibilityRecordCompat.setFromIndex(ViewPager.access$300(this.this$0));
      localAccessibilityRecordCompat.setToIndex(ViewPager.access$300(this.this$0));
    }
  }
  
  public void onInitializeAccessibilityNodeInfo(View paramView, AccessibilityNodeInfoCompat paramAccessibilityNodeInfoCompat)
  {
    super.onInitializeAccessibilityNodeInfo(paramView, paramAccessibilityNodeInfoCompat);
    paramAccessibilityNodeInfoCompat.setClassName(ViewPager.class.getName());
    paramAccessibilityNodeInfoCompat.setScrollable(canScroll());
    if (this.this$0.canScrollHorizontally(1)) {
      paramAccessibilityNodeInfoCompat.addAction(4096);
    }
    if (this.this$0.canScrollHorizontally(-1)) {
      paramAccessibilityNodeInfoCompat.addAction(8192);
    }
  }
  
  public boolean performAccessibilityAction(View paramView, int paramInt, Bundle paramBundle)
  {
    int i = 1;
    if (super.performAccessibilityAction(paramView, paramInt, paramBundle)) {}
    for (;;)
    {
      return i;
      int j;
      switch (paramInt)
      {
      default: 
        i = 0;
        break;
      case 4096: 
        if (this.this$0.canScrollHorizontally(i)) {
          this.this$0.setCurrentItem(1 + ViewPager.access$300(this.this$0));
        } else {
          j = 0;
        }
        break;
      case 8192: 
        if (this.this$0.canScrollHorizontally(-1)) {
          this.this$0.setCurrentItem(-1 + ViewPager.access$300(this.this$0));
        } else {
          j = 0;
        }
        break;
      }
    }
  }
}


/* Location:           C:\Users\dreadiscool\Desktop\tools\classes-dex2jar.jar
 * Qualified Name:     android.support.v4.view.ViewPager.MyAccessibilityDelegate
 * JD-Core Version:    0.7.0.1
 */