package android.support.v4.view;

import android.graphics.Paint;
import android.os.Build.VERSION;
import android.os.Bundle;
import android.support.v4.view.accessibility.AccessibilityNodeInfoCompat;
import android.support.v4.view.accessibility.AccessibilityNodeProviderCompat;
import android.view.View;
import android.view.ViewGroup;
import android.view.ViewParent;
import android.view.accessibility.AccessibilityEvent;

public class ViewCompat
{
  public static final int ACCESSIBILITY_LIVE_REGION_ASSERTIVE = 2;
  public static final int ACCESSIBILITY_LIVE_REGION_NONE = 0;
  public static final int ACCESSIBILITY_LIVE_REGION_POLITE = 1;
  private static final long FAKE_FRAME_TIME = 10L;
  static final ViewCompat.ViewCompatImpl IMPL;
  public static final int IMPORTANT_FOR_ACCESSIBILITY_AUTO = 0;
  public static final int IMPORTANT_FOR_ACCESSIBILITY_NO = 2;
  public static final int IMPORTANT_FOR_ACCESSIBILITY_NO_HIDE_DESCENDANTS = 4;
  public static final int IMPORTANT_FOR_ACCESSIBILITY_YES = 1;
  public static final int LAYER_TYPE_HARDWARE = 2;
  public static final int LAYER_TYPE_NONE = 0;
  public static final int LAYER_TYPE_SOFTWARE = 1;
  public static final int LAYOUT_DIRECTION_INHERIT = 2;
  public static final int LAYOUT_DIRECTION_LOCALE = 3;
  public static final int LAYOUT_DIRECTION_LTR = 0;
  public static final int LAYOUT_DIRECTION_RTL = 1;
  public static final int MEASURED_HEIGHT_STATE_SHIFT = 16;
  public static final int MEASURED_SIZE_MASK = 16777215;
  public static final int MEASURED_STATE_MASK = -16777216;
  public static final int MEASURED_STATE_TOO_SMALL = 16777216;
  public static final int OVER_SCROLL_ALWAYS = 0;
  public static final int OVER_SCROLL_IF_CONTENT_SCROLLS = 1;
  public static final int OVER_SCROLL_NEVER = 2;
  private static final String TAG = "ViewCompat";
  
  static
  {
    int i = Build.VERSION.SDK_INT;
    if (i >= 21) {
      IMPL = new ViewCompat.Api21ViewCompatImpl();
    }
    for (;;)
    {
      return;
      if (i >= 19) {
        IMPL = new ViewCompat.KitKatViewCompatImpl();
      } else if (i >= 17) {
        IMPL = new ViewCompat.JbMr1ViewCompatImpl();
      } else if (i >= 16) {
        IMPL = new ViewCompat.JBViewCompatImpl();
      } else if (i >= 14) {
        IMPL = new ViewCompat.ICSViewCompatImpl();
      } else if (i >= 11) {
        IMPL = new ViewCompat.HCViewCompatImpl();
      } else if (i >= 9) {
        IMPL = new ViewCompat.GBViewCompatImpl();
      } else if (i >= 7) {
        IMPL = new ViewCompat.EclairMr1ViewCompatImpl();
      } else {
        IMPL = new ViewCompat.BaseViewCompatImpl();
      }
    }
  }
  
  public static ViewPropertyAnimatorCompat animate(View paramView)
  {
    return IMPL.animate(paramView);
  }
  
  public static boolean canScrollHorizontally(View paramView, int paramInt)
  {
    return IMPL.canScrollHorizontally(paramView, paramInt);
  }
  
  public static boolean canScrollVertically(View paramView, int paramInt)
  {
    return IMPL.canScrollVertically(paramView, paramInt);
  }
  
  public static void dispatchFinishTemporaryDetach(View paramView)
  {
    IMPL.dispatchFinishTemporaryDetach(paramView);
  }
  
  public static void dispatchStartTemporaryDetach(View paramView)
  {
    IMPL.dispatchStartTemporaryDetach(paramView);
  }
  
  public static int getAccessibilityLiveRegion(View paramView)
  {
    return IMPL.getAccessibilityLiveRegion(paramView);
  }
  
  public static AccessibilityNodeProviderCompat getAccessibilityNodeProvider(View paramView)
  {
    return IMPL.getAccessibilityNodeProvider(paramView);
  }
  
  public static float getAlpha(View paramView)
  {
    return IMPL.getAlpha(paramView);
  }
  
  public static float getElevation(View paramView)
  {
    return IMPL.getElevation(paramView);
  }
  
  public static boolean getFitsSystemWindows(View paramView)
  {
    return IMPL.getFitsSystemWindows(paramView);
  }
  
  public static int getImportantForAccessibility(View paramView)
  {
    return IMPL.getImportantForAccessibility(paramView);
  }
  
  public static int getLabelFor(View paramView)
  {
    return IMPL.getLabelFor(paramView);
  }
  
  public static int getLayerType(View paramView)
  {
    return IMPL.getLayerType(paramView);
  }
  
  public static int getLayoutDirection(View paramView)
  {
    return IMPL.getLayoutDirection(paramView);
  }
  
  public static int getMeasuredHeightAndState(View paramView)
  {
    return IMPL.getMeasuredHeightAndState(paramView);
  }
  
  public static int getMeasuredState(View paramView)
  {
    return IMPL.getMeasuredState(paramView);
  }
  
  public static int getMeasuredWidthAndState(View paramView)
  {
    return IMPL.getMeasuredWidthAndState(paramView);
  }
  
  public static int getMinimumHeight(View paramView)
  {
    return IMPL.getMinimumHeight(paramView);
  }
  
  public static int getMinimumWidth(View paramView)
  {
    return IMPL.getMinimumWidth(paramView);
  }
  
  public static int getOverScrollMode(View paramView)
  {
    return IMPL.getOverScrollMode(paramView);
  }
  
  public static int getPaddingEnd(View paramView)
  {
    return IMPL.getPaddingEnd(paramView);
  }
  
  public static int getPaddingStart(View paramView)
  {
    return IMPL.getPaddingStart(paramView);
  }
  
  public static ViewParent getParentForAccessibility(View paramView)
  {
    return IMPL.getParentForAccessibility(paramView);
  }
  
  public static float getPivotX(View paramView)
  {
    return IMPL.getPivotX(paramView);
  }
  
  public static float getPivotY(View paramView)
  {
    return IMPL.getPivotY(paramView);
  }
  
  public static float getRotation(View paramView)
  {
    return IMPL.getRotation(paramView);
  }
  
  public static float getRotationX(View paramView)
  {
    return IMPL.getRotationX(paramView);
  }
  
  public static float getRotationY(View paramView)
  {
    return IMPL.getRotationY(paramView);
  }
  
  public static float getScaleX(View paramView)
  {
    return IMPL.getScaleX(paramView);
  }
  
  public static float getScaleY(View paramView)
  {
    return IMPL.getScaleY(paramView);
  }
  
  public static String getTransitionName(View paramView)
  {
    return IMPL.getTransitionName(paramView);
  }
  
  public static float getTranslationX(View paramView)
  {
    return IMPL.getTranslationX(paramView);
  }
  
  public static float getTranslationY(View paramView)
  {
    return IMPL.getTranslationY(paramView);
  }
  
  public static float getTranslationZ(View paramView)
  {
    return IMPL.getTranslationZ(paramView);
  }
  
  public static int getWindowSystemUiVisibility(View paramView)
  {
    return IMPL.getWindowSystemUiVisibility(paramView);
  }
  
  public static float getX(View paramView)
  {
    return IMPL.getX(paramView);
  }
  
  public static float getY(View paramView)
  {
    return IMPL.getY(paramView);
  }
  
  public static boolean hasAccessibilityDelegate(View paramView)
  {
    return IMPL.hasAccessibilityDelegate(paramView);
  }
  
  public static boolean hasTransientState(View paramView)
  {
    return IMPL.hasTransientState(paramView);
  }
  
  public static boolean isOpaque(View paramView)
  {
    return IMPL.isOpaque(paramView);
  }
  
  public static void jumpDrawablesToCurrentState(View paramView)
  {
    IMPL.jumpDrawablesToCurrentState(paramView);
  }
  
  public static void onInitializeAccessibilityEvent(View paramView, AccessibilityEvent paramAccessibilityEvent)
  {
    IMPL.onInitializeAccessibilityEvent(paramView, paramAccessibilityEvent);
  }
  
  public static void onInitializeAccessibilityNodeInfo(View paramView, AccessibilityNodeInfoCompat paramAccessibilityNodeInfoCompat)
  {
    IMPL.onInitializeAccessibilityNodeInfo(paramView, paramAccessibilityNodeInfoCompat);
  }
  
  public static void onPopulateAccessibilityEvent(View paramView, AccessibilityEvent paramAccessibilityEvent)
  {
    IMPL.onPopulateAccessibilityEvent(paramView, paramAccessibilityEvent);
  }
  
  public static boolean performAccessibilityAction(View paramView, int paramInt, Bundle paramBundle)
  {
    return IMPL.performAccessibilityAction(paramView, paramInt, paramBundle);
  }
  
  public static void postInvalidateOnAnimation(View paramView)
  {
    IMPL.postInvalidateOnAnimation(paramView);
  }
  
  public static void postInvalidateOnAnimation(View paramView, int paramInt1, int paramInt2, int paramInt3, int paramInt4)
  {
    IMPL.postInvalidateOnAnimation(paramView, paramInt1, paramInt2, paramInt3, paramInt4);
  }
  
  public static void postOnAnimation(View paramView, Runnable paramRunnable)
  {
    IMPL.postOnAnimation(paramView, paramRunnable);
  }
  
  public static void postOnAnimationDelayed(View paramView, Runnable paramRunnable, long paramLong)
  {
    IMPL.postOnAnimationDelayed(paramView, paramRunnable, paramLong);
  }
  
  public static void requestApplyInsets(View paramView)
  {
    IMPL.requestApplyInsets(paramView);
  }
  
  public static int resolveSizeAndState(int paramInt1, int paramInt2, int paramInt3)
  {
    return IMPL.resolveSizeAndState(paramInt1, paramInt2, paramInt3);
  }
  
  public static void setAccessibilityDelegate(View paramView, AccessibilityDelegateCompat paramAccessibilityDelegateCompat)
  {
    IMPL.setAccessibilityDelegate(paramView, paramAccessibilityDelegateCompat);
  }
  
  public static void setAccessibilityLiveRegion(View paramView, int paramInt)
  {
    IMPL.setAccessibilityLiveRegion(paramView, paramInt);
  }
  
  public static void setAlpha(View paramView, float paramFloat)
  {
    IMPL.setAlpha(paramView, paramFloat);
  }
  
  public static void setChildrenDrawingOrderEnabled(ViewGroup paramViewGroup, boolean paramBoolean)
  {
    IMPL.setChildrenDrawingOrderEnabled(paramViewGroup, paramBoolean);
  }
  
  public static void setElevation(View paramView, float paramFloat)
  {
    IMPL.setElevation(paramView, paramFloat);
  }
  
  public static void setHasTransientState(View paramView, boolean paramBoolean)
  {
    IMPL.setHasTransientState(paramView, paramBoolean);
  }
  
  public static void setImportantForAccessibility(View paramView, int paramInt)
  {
    IMPL.setImportantForAccessibility(paramView, paramInt);
  }
  
  public static void setLabelFor(View paramView, int paramInt)
  {
    IMPL.setLabelFor(paramView, paramInt);
  }
  
  public static void setLayerPaint(View paramView, Paint paramPaint)
  {
    IMPL.setLayerPaint(paramView, paramPaint);
  }
  
  public static void setLayerType(View paramView, int paramInt, Paint paramPaint)
  {
    IMPL.setLayerType(paramView, paramInt, paramPaint);
  }
  
  public static void setLayoutDirection(View paramView, int paramInt)
  {
    IMPL.setLayoutDirection(paramView, paramInt);
  }
  
  public static void setOnApplyWindowInsetsListener(View paramView, OnApplyWindowInsetsListener paramOnApplyWindowInsetsListener)
  {
    IMPL.setOnApplyWindowInsetsListener(paramView, paramOnApplyWindowInsetsListener);
  }
  
  public static void setOverScrollMode(View paramView, int paramInt)
  {
    IMPL.setOverScrollMode(paramView, paramInt);
  }
  
  public static void setPaddingRelative(View paramView, int paramInt1, int paramInt2, int paramInt3, int paramInt4)
  {
    IMPL.setPaddingRelative(paramView, paramInt1, paramInt2, paramInt3, paramInt4);
  }
  
  public static void setPivotX(View paramView, float paramFloat)
  {
    IMPL.setPivotX(paramView, paramFloat);
  }
  
  public static void setPivotY(View paramView, float paramFloat)
  {
    IMPL.setPivotX(paramView, paramFloat);
  }
  
  public static void setRotation(View paramView, float paramFloat)
  {
    IMPL.setRotation(paramView, paramFloat);
  }
  
  public static void setRotationX(View paramView, float paramFloat)
  {
    IMPL.setRotationX(paramView, paramFloat);
  }
  
  public static void setRotationY(View paramView, float paramFloat)
  {
    IMPL.setRotationY(paramView, paramFloat);
  }
  
  public static void setScaleX(View paramView, float paramFloat)
  {
    IMPL.setScaleX(paramView, paramFloat);
  }
  
  public static void setScaleY(View paramView, float paramFloat)
  {
    IMPL.setScaleY(paramView, paramFloat);
  }
  
  public static void setTransitionName(View paramView, String paramString)
  {
    IMPL.setTransitionName(paramView, paramString);
  }
  
  public static void setTranslationX(View paramView, float paramFloat)
  {
    IMPL.setTranslationX(paramView, paramFloat);
  }
  
  public static void setTranslationY(View paramView, float paramFloat)
  {
    IMPL.setTranslationY(paramView, paramFloat);
  }
  
  public static void setTranslationZ(View paramView, float paramFloat)
  {
    IMPL.setTranslationZ(paramView, paramFloat);
  }
  
  public static void setX(View paramView, float paramFloat)
  {
    IMPL.setX(paramView, paramFloat);
  }
  
  public static void setY(View paramView, float paramFloat)
  {
    IMPL.setY(paramView, paramFloat);
  }
}


/* Location:           C:\Users\dreadiscool\Desktop\tools\classes-dex2jar.jar
 * Qualified Name:     android.support.v4.view.ViewCompat
 * JD-Core Version:    0.7.0.1
 */