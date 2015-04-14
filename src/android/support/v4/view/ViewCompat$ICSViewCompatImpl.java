package android.support.v4.view;

import android.support.v4.view.accessibility.AccessibilityNodeInfoCompat;
import android.view.View;
import android.view.accessibility.AccessibilityEvent;
import java.lang.reflect.Field;
import java.util.WeakHashMap;

class ViewCompat$ICSViewCompatImpl
  extends ViewCompat.HCViewCompatImpl
{
  static boolean accessibilityDelegateCheckFailed = false;
  static Field mAccessibilityDelegateField;
  
  public ViewPropertyAnimatorCompat animate(View paramView)
  {
    if (this.mViewPropertyAnimatorCompatMap == null) {
      this.mViewPropertyAnimatorCompatMap = new WeakHashMap();
    }
    ViewPropertyAnimatorCompat localViewPropertyAnimatorCompat = (ViewPropertyAnimatorCompat)this.mViewPropertyAnimatorCompatMap.get(paramView);
    if (localViewPropertyAnimatorCompat == null)
    {
      localViewPropertyAnimatorCompat = new ViewPropertyAnimatorCompat(paramView);
      this.mViewPropertyAnimatorCompatMap.put(paramView, localViewPropertyAnimatorCompat);
    }
    return localViewPropertyAnimatorCompat;
  }
  
  public boolean canScrollHorizontally(View paramView, int paramInt)
  {
    return ViewCompatICS.canScrollHorizontally(paramView, paramInt);
  }
  
  public boolean canScrollVertically(View paramView, int paramInt)
  {
    return ViewCompatICS.canScrollVertically(paramView, paramInt);
  }
  
  /* Error */
  public boolean hasAccessibilityDelegate(View paramView)
  {
    // Byte code:
    //   0: iconst_1
    //   1: istore_2
    //   2: iconst_0
    //   3: istore_3
    //   4: getstatic 12	android/support/v4/view/ViewCompat$ICSViewCompatImpl:accessibilityDelegateCheckFailed	Z
    //   7: ifeq +5 -> 12
    //   10: iload_3
    //   11: ireturn
    //   12: getstatic 52	android/support/v4/view/ViewCompat$ICSViewCompatImpl:mAccessibilityDelegateField	Ljava/lang/reflect/Field;
    //   15: ifnonnull +20 -> 35
    //   18: ldc 54
    //   20: ldc 56
    //   22: invokevirtual 62	java/lang/Class:getDeclaredField	(Ljava/lang/String;)Ljava/lang/reflect/Field;
    //   25: putstatic 52	android/support/v4/view/ViewCompat$ICSViewCompatImpl:mAccessibilityDelegateField	Ljava/lang/reflect/Field;
    //   28: getstatic 52	android/support/v4/view/ViewCompat$ICSViewCompatImpl:mAccessibilityDelegateField	Ljava/lang/reflect/Field;
    //   31: iconst_1
    //   32: invokevirtual 68	java/lang/reflect/Field:setAccessible	(Z)V
    //   35: getstatic 52	android/support/v4/view/ViewCompat$ICSViewCompatImpl:mAccessibilityDelegateField	Ljava/lang/reflect/Field;
    //   38: aload_1
    //   39: invokevirtual 69	java/lang/reflect/Field:get	(Ljava/lang/Object;)Ljava/lang/Object;
    //   42: astore 5
    //   44: aload 5
    //   46: ifnull +17 -> 63
    //   49: iload_2
    //   50: istore_3
    //   51: goto -41 -> 10
    //   54: astore 6
    //   56: iload_2
    //   57: putstatic 12	android/support/v4/view/ViewCompat$ICSViewCompatImpl:accessibilityDelegateCheckFailed	Z
    //   60: goto -50 -> 10
    //   63: iconst_0
    //   64: istore_2
    //   65: goto -16 -> 49
    //   68: astore 4
    //   70: iload_2
    //   71: putstatic 12	android/support/v4/view/ViewCompat$ICSViewCompatImpl:accessibilityDelegateCheckFailed	Z
    //   74: goto -64 -> 10
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	77	0	this	ICSViewCompatImpl
    //   0	77	1	paramView	View
    //   1	70	2	bool1	boolean
    //   3	48	3	bool2	boolean
    //   68	1	4	localThrowable1	java.lang.Throwable
    //   42	3	5	localObject	java.lang.Object
    //   54	1	6	localThrowable2	java.lang.Throwable
    // Exception table:
    //   from	to	target	type
    //   18	35	54	java/lang/Throwable
    //   35	44	68	java/lang/Throwable
  }
  
  public void onInitializeAccessibilityEvent(View paramView, AccessibilityEvent paramAccessibilityEvent)
  {
    ViewCompatICS.onInitializeAccessibilityEvent(paramView, paramAccessibilityEvent);
  }
  
  public void onInitializeAccessibilityNodeInfo(View paramView, AccessibilityNodeInfoCompat paramAccessibilityNodeInfoCompat)
  {
    ViewCompatICS.onInitializeAccessibilityNodeInfo(paramView, paramAccessibilityNodeInfoCompat.getInfo());
  }
  
  public void onPopulateAccessibilityEvent(View paramView, AccessibilityEvent paramAccessibilityEvent)
  {
    ViewCompatICS.onPopulateAccessibilityEvent(paramView, paramAccessibilityEvent);
  }
  
  public void setAccessibilityDelegate(View paramView, AccessibilityDelegateCompat paramAccessibilityDelegateCompat)
  {
    ViewCompatICS.setAccessibilityDelegate(paramView, paramAccessibilityDelegateCompat.getBridge());
  }
}


/* Location:           C:\Users\dreadiscool\Desktop\tools\classes-dex2jar.jar
 * Qualified Name:     android.support.v4.view.ViewCompat.ICSViewCompatImpl
 * JD-Core Version:    0.7.0.1
 */