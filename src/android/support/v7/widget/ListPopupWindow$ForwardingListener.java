package android.support.v7.widget;

import android.os.SystemClock;
import android.support.v4.view.MotionEventCompat;
import android.view.MotionEvent;
import android.view.View;
import android.view.View.OnTouchListener;
import android.view.ViewConfiguration;
import android.view.ViewParent;

public abstract class ListPopupWindow$ForwardingListener
  implements View.OnTouchListener
{
  private int mActivePointerId;
  private Runnable mDisallowIntercept;
  private boolean mForwarding;
  private final int mLongPressTimeout;
  private final float mScaledTouchSlop;
  private final View mSrc;
  private final int mTapTimeout;
  private final int[] mTmpLocation = new int[2];
  private Runnable mTriggerLongPress;
  private boolean mWasLongPress;
  
  public ListPopupWindow$ForwardingListener(View paramView)
  {
    this.mSrc = paramView;
    this.mScaledTouchSlop = ViewConfiguration.get(paramView.getContext()).getScaledTouchSlop();
    this.mTapTimeout = ViewConfiguration.getTapTimeout();
    this.mLongPressTimeout = ((this.mTapTimeout + ViewConfiguration.getLongPressTimeout()) / 2);
  }
  
  private void clearCallbacks()
  {
    if (this.mTriggerLongPress != null) {
      this.mSrc.removeCallbacks(this.mTriggerLongPress);
    }
    if (this.mDisallowIntercept != null) {
      this.mSrc.removeCallbacks(this.mDisallowIntercept);
    }
  }
  
  private void onLongPress()
  {
    clearCallbacks();
    if (!this.mSrc.isEnabled()) {}
    for (;;)
    {
      return;
      if (onForwardingStarted())
      {
        this.mSrc.getParent().requestDisallowInterceptTouchEvent(true);
        long l = SystemClock.uptimeMillis();
        MotionEvent localMotionEvent = MotionEvent.obtain(l, l, 3, 0.0F, 0.0F, 0);
        this.mSrc.onTouchEvent(localMotionEvent);
        localMotionEvent.recycle();
        this.mForwarding = true;
        this.mWasLongPress = true;
      }
    }
  }
  
  private boolean onTouchForwarded(MotionEvent paramMotionEvent)
  {
    int i = 1;
    boolean bool1 = false;
    View localView = this.mSrc;
    ListPopupWindow localListPopupWindow = getPopup();
    if ((localListPopupWindow == null) || (!localListPopupWindow.isShowing())) {}
    ListPopupWindow.DropDownListView localDropDownListView;
    do
    {
      return bool1;
      localDropDownListView = ListPopupWindow.access$600(localListPopupWindow);
    } while ((localDropDownListView == null) || (!localDropDownListView.isShown()));
    MotionEvent localMotionEvent = MotionEvent.obtainNoHistory(paramMotionEvent);
    toGlobalMotionEvent(localView, localMotionEvent);
    toLocalMotionEvent(localDropDownListView, localMotionEvent);
    boolean bool2 = localDropDownListView.onForwardedEvent(localMotionEvent, this.mActivePointerId);
    localMotionEvent.recycle();
    int j = MotionEventCompat.getActionMasked(paramMotionEvent);
    int k;
    if ((j != i) && (j != 3))
    {
      k = i;
      label114:
      if ((!bool2) || (k == 0)) {
        break label135;
      }
    }
    for (;;)
    {
      bool1 = i;
      break;
      k = 0;
      break label114;
      label135:
      i = 0;
    }
  }
  
  private boolean onTouchObserved(MotionEvent paramMotionEvent)
  {
    boolean bool = false;
    View localView = this.mSrc;
    if (!localView.isEnabled()) {}
    for (;;)
    {
      return bool;
      switch (MotionEventCompat.getActionMasked(paramMotionEvent))
      {
      default: 
        break;
      case 0: 
        this.mActivePointerId = paramMotionEvent.getPointerId(0);
        this.mWasLongPress = false;
        if (this.mDisallowIntercept == null) {
          this.mDisallowIntercept = new ListPopupWindow.ForwardingListener.DisallowIntercept(this, null);
        }
        localView.postDelayed(this.mDisallowIntercept, this.mTapTimeout);
        if (this.mTriggerLongPress == null) {
          this.mTriggerLongPress = new ListPopupWindow.ForwardingListener.TriggerLongPress(this, null);
        }
        localView.postDelayed(this.mTriggerLongPress, this.mLongPressTimeout);
        break;
      case 2: 
        int i = paramMotionEvent.findPointerIndex(this.mActivePointerId);
        if ((i >= 0) && (!pointInView(localView, paramMotionEvent.getX(i), paramMotionEvent.getY(i), this.mScaledTouchSlop)))
        {
          clearCallbacks();
          localView.getParent().requestDisallowInterceptTouchEvent(true);
          bool = true;
        }
        break;
      case 1: 
      case 3: 
        clearCallbacks();
      }
    }
  }
  
  private static boolean pointInView(View paramView, float paramFloat1, float paramFloat2, float paramFloat3)
  {
    if ((paramFloat1 >= -paramFloat3) && (paramFloat2 >= -paramFloat3) && (paramFloat1 < paramFloat3 + (paramView.getRight() - paramView.getLeft())) && (paramFloat2 < paramFloat3 + (paramView.getBottom() - paramView.getTop()))) {}
    for (boolean bool = true;; bool = false) {
      return bool;
    }
  }
  
  private boolean toGlobalMotionEvent(View paramView, MotionEvent paramMotionEvent)
  {
    int[] arrayOfInt = this.mTmpLocation;
    paramView.getLocationOnScreen(arrayOfInt);
    paramMotionEvent.offsetLocation(arrayOfInt[0], arrayOfInt[1]);
    return true;
  }
  
  private boolean toLocalMotionEvent(View paramView, MotionEvent paramMotionEvent)
  {
    int[] arrayOfInt = this.mTmpLocation;
    paramView.getLocationOnScreen(arrayOfInt);
    paramMotionEvent.offsetLocation(-arrayOfInt[0], -arrayOfInt[1]);
    return true;
  }
  
  public abstract ListPopupWindow getPopup();
  
  public boolean onForwardingStarted()
  {
    ListPopupWindow localListPopupWindow = getPopup();
    if ((localListPopupWindow != null) && (!localListPopupWindow.isShowing())) {
      localListPopupWindow.show();
    }
    return true;
  }
  
  public boolean onForwardingStopped()
  {
    ListPopupWindow localListPopupWindow = getPopup();
    if ((localListPopupWindow != null) && (localListPopupWindow.isShowing())) {
      localListPopupWindow.dismiss();
    }
    return true;
  }
  
  public boolean onTouch(View paramView, MotionEvent paramMotionEvent)
  {
    boolean bool1 = false;
    boolean bool2 = this.mForwarding;
    boolean bool4;
    if (bool2)
    {
      if (this.mWasLongPress) {
        bool4 = onTouchForwarded(paramMotionEvent);
      }
      for (;;)
      {
        this.mForwarding = bool4;
        if ((bool4) || (bool2)) {
          bool1 = true;
        }
        return bool1;
        if ((onTouchForwarded(paramMotionEvent)) || (!onForwardingStopped())) {
          bool4 = true;
        } else {
          bool4 = false;
        }
      }
    }
    if ((onTouchObserved(paramMotionEvent)) && (onForwardingStarted())) {}
    for (boolean bool3 = true;; bool3 = false)
    {
      if (bool3)
      {
        long l = SystemClock.uptimeMillis();
        MotionEvent localMotionEvent = MotionEvent.obtain(l, l, 3, 0.0F, 0.0F, 0);
        this.mSrc.onTouchEvent(localMotionEvent);
        localMotionEvent.recycle();
      }
      bool4 = bool3;
      break;
    }
  }
}


/* Location:           C:\Users\dreadiscool\Desktop\tools\classes-dex2jar.jar
 * Qualified Name:     android.support.v7.widget.ListPopupWindow.ForwardingListener
 * JD-Core Version:    0.7.0.1
 */