package android.support.v4.view;

import android.graphics.Paint;
import android.graphics.drawable.Drawable;
import android.os.Bundle;
import android.support.v4.view.accessibility.AccessibilityNodeInfoCompat;
import android.support.v4.view.accessibility.AccessibilityNodeProviderCompat;
import android.view.View;
import android.view.ViewGroup;
import android.view.ViewParent;
import android.view.accessibility.AccessibilityEvent;
import java.lang.reflect.Method;
import java.util.WeakHashMap;

class ViewCompat$BaseViewCompatImpl
  implements ViewCompat.ViewCompatImpl
{
  private Method mDispatchFinishTemporaryDetach;
  private Method mDispatchStartTemporaryDetach;
  private boolean mTempDetachBound;
  WeakHashMap<View, ViewPropertyAnimatorCompat> mViewPropertyAnimatorCompatMap = null;
  
  private void bindTempDetach()
  {
    try
    {
      this.mDispatchStartTemporaryDetach = View.class.getDeclaredMethod("dispatchStartTemporaryDetach", new Class[0]);
      this.mDispatchFinishTemporaryDetach = View.class.getDeclaredMethod("dispatchFinishTemporaryDetach", new Class[0]);
      label30:
      this.mTempDetachBound = true;
      return;
    }
    catch (NoSuchMethodException localNoSuchMethodException)
    {
      break label30;
    }
  }
  
  public ViewPropertyAnimatorCompat animate(View paramView)
  {
    return new ViewPropertyAnimatorCompat(paramView);
  }
  
  public boolean canScrollHorizontally(View paramView, int paramInt)
  {
    return false;
  }
  
  public boolean canScrollVertically(View paramView, int paramInt)
  {
    return false;
  }
  
  public void dispatchFinishTemporaryDetach(View paramView)
  {
    if (!this.mTempDetachBound) {
      bindTempDetach();
    }
    if (this.mDispatchFinishTemporaryDetach != null) {}
    try
    {
      this.mDispatchFinishTemporaryDetach.invoke(paramView, new Object[0]);
      for (;;)
      {
        label31:
        return;
        paramView.onFinishTemporaryDetach();
      }
    }
    catch (Exception localException)
    {
      break label31;
    }
  }
  
  public void dispatchStartTemporaryDetach(View paramView)
  {
    if (!this.mTempDetachBound) {
      bindTempDetach();
    }
    if (this.mDispatchStartTemporaryDetach != null) {}
    try
    {
      this.mDispatchStartTemporaryDetach.invoke(paramView, new Object[0]);
      for (;;)
      {
        label31:
        return;
        paramView.onStartTemporaryDetach();
      }
    }
    catch (Exception localException)
    {
      break label31;
    }
  }
  
  public int getAccessibilityLiveRegion(View paramView)
  {
    return 0;
  }
  
  public AccessibilityNodeProviderCompat getAccessibilityNodeProvider(View paramView)
  {
    return null;
  }
  
  public float getAlpha(View paramView)
  {
    return 1.0F;
  }
  
  public float getElevation(View paramView)
  {
    return 0.0F;
  }
  
  public boolean getFitsSystemWindows(View paramView)
  {
    return false;
  }
  
  long getFrameTime()
  {
    return 10L;
  }
  
  public int getImportantForAccessibility(View paramView)
  {
    return 0;
  }
  
  public int getLabelFor(View paramView)
  {
    return 0;
  }
  
  public int getLayerType(View paramView)
  {
    return 0;
  }
  
  public int getLayoutDirection(View paramView)
  {
    return 0;
  }
  
  public int getMeasuredHeightAndState(View paramView)
  {
    return paramView.getMeasuredHeight();
  }
  
  public int getMeasuredState(View paramView)
  {
    return 0;
  }
  
  public int getMeasuredWidthAndState(View paramView)
  {
    return paramView.getMeasuredWidth();
  }
  
  public int getMinimumHeight(View paramView)
  {
    return 0;
  }
  
  public int getMinimumWidth(View paramView)
  {
    return 0;
  }
  
  public int getOverScrollMode(View paramView)
  {
    return 2;
  }
  
  public int getPaddingEnd(View paramView)
  {
    return paramView.getPaddingRight();
  }
  
  public int getPaddingStart(View paramView)
  {
    return paramView.getPaddingLeft();
  }
  
  public ViewParent getParentForAccessibility(View paramView)
  {
    return paramView.getParent();
  }
  
  public float getPivotX(View paramView)
  {
    return 0.0F;
  }
  
  public float getPivotY(View paramView)
  {
    return 0.0F;
  }
  
  public float getRotation(View paramView)
  {
    return 0.0F;
  }
  
  public float getRotationX(View paramView)
  {
    return 0.0F;
  }
  
  public float getRotationY(View paramView)
  {
    return 0.0F;
  }
  
  public float getScaleX(View paramView)
  {
    return 0.0F;
  }
  
  public float getScaleY(View paramView)
  {
    return 0.0F;
  }
  
  public String getTransitionName(View paramView)
  {
    return null;
  }
  
  public float getTranslationX(View paramView)
  {
    return 0.0F;
  }
  
  public float getTranslationY(View paramView)
  {
    return 0.0F;
  }
  
  public float getTranslationZ(View paramView)
  {
    return 0.0F;
  }
  
  public int getWindowSystemUiVisibility(View paramView)
  {
    return 0;
  }
  
  public float getX(View paramView)
  {
    return 0.0F;
  }
  
  public float getY(View paramView)
  {
    return 0.0F;
  }
  
  public boolean hasAccessibilityDelegate(View paramView)
  {
    return false;
  }
  
  public boolean hasTransientState(View paramView)
  {
    return false;
  }
  
  public boolean isOpaque(View paramView)
  {
    boolean bool = false;
    Drawable localDrawable = paramView.getBackground();
    if ((localDrawable != null) && (localDrawable.getOpacity() == -1)) {
      bool = true;
    }
    return bool;
  }
  
  public void jumpDrawablesToCurrentState(View paramView) {}
  
  public void onInitializeAccessibilityEvent(View paramView, AccessibilityEvent paramAccessibilityEvent) {}
  
  public void onInitializeAccessibilityNodeInfo(View paramView, AccessibilityNodeInfoCompat paramAccessibilityNodeInfoCompat) {}
  
  public void onPopulateAccessibilityEvent(View paramView, AccessibilityEvent paramAccessibilityEvent) {}
  
  public boolean performAccessibilityAction(View paramView, int paramInt, Bundle paramBundle)
  {
    return false;
  }
  
  public void postInvalidateOnAnimation(View paramView)
  {
    paramView.invalidate();
  }
  
  public void postInvalidateOnAnimation(View paramView, int paramInt1, int paramInt2, int paramInt3, int paramInt4)
  {
    paramView.invalidate(paramInt1, paramInt2, paramInt3, paramInt4);
  }
  
  public void postOnAnimation(View paramView, Runnable paramRunnable)
  {
    paramView.postDelayed(paramRunnable, getFrameTime());
  }
  
  public void postOnAnimationDelayed(View paramView, Runnable paramRunnable, long paramLong)
  {
    paramView.postDelayed(paramRunnable, paramLong + getFrameTime());
  }
  
  public void requestApplyInsets(View paramView) {}
  
  public int resolveSizeAndState(int paramInt1, int paramInt2, int paramInt3)
  {
    return View.resolveSize(paramInt1, paramInt2);
  }
  
  public void setAccessibilityDelegate(View paramView, AccessibilityDelegateCompat paramAccessibilityDelegateCompat) {}
  
  public void setAccessibilityLiveRegion(View paramView, int paramInt) {}
  
  public void setAlpha(View paramView, float paramFloat) {}
  
  public void setChildrenDrawingOrderEnabled(ViewGroup paramViewGroup, boolean paramBoolean) {}
  
  public void setElevation(View paramView, float paramFloat) {}
  
  public void setHasTransientState(View paramView, boolean paramBoolean) {}
  
  public void setImportantForAccessibility(View paramView, int paramInt) {}
  
  public void setLabelFor(View paramView, int paramInt) {}
  
  public void setLayerPaint(View paramView, Paint paramPaint) {}
  
  public void setLayerType(View paramView, int paramInt, Paint paramPaint) {}
  
  public void setLayoutDirection(View paramView, int paramInt) {}
  
  public void setOnApplyWindowInsetsListener(View paramView, OnApplyWindowInsetsListener paramOnApplyWindowInsetsListener) {}
  
  public void setOverScrollMode(View paramView, int paramInt) {}
  
  public void setPaddingRelative(View paramView, int paramInt1, int paramInt2, int paramInt3, int paramInt4)
  {
    paramView.setPadding(paramInt1, paramInt2, paramInt3, paramInt4);
  }
  
  public void setPivotX(View paramView, float paramFloat) {}
  
  public void setPivotY(View paramView, float paramFloat) {}
  
  public void setRotation(View paramView, float paramFloat) {}
  
  public void setRotationX(View paramView, float paramFloat) {}
  
  public void setRotationY(View paramView, float paramFloat) {}
  
  public void setScaleX(View paramView, float paramFloat) {}
  
  public void setScaleY(View paramView, float paramFloat) {}
  
  public void setTransitionName(View paramView, String paramString) {}
  
  public void setTranslationX(View paramView, float paramFloat) {}
  
  public void setTranslationY(View paramView, float paramFloat) {}
  
  public void setTranslationZ(View paramView, float paramFloat) {}
  
  public void setX(View paramView, float paramFloat) {}
  
  public void setY(View paramView, float paramFloat) {}
}


/* Location:           C:\Users\dreadiscool\Desktop\tools\classes-dex2jar.jar
 * Qualified Name:     android.support.v4.view.ViewCompat.BaseViewCompatImpl
 * JD-Core Version:    0.7.0.1
 */