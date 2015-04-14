package android.support.v7.widget;

import android.content.Context;
import android.support.v4.view.MotionEventCompat;
import android.support.v4.view.ViewPropertyAnimatorCompat;
import android.support.v4.widget.ListViewAutoScrollHelper;
import android.support.v7.appcompat.R.attr;
import android.support.v7.internal.widget.ListViewCompat;
import android.view.MotionEvent;
import android.view.View;

class ListPopupWindow$DropDownListView
  extends ListViewCompat
{
  private ViewPropertyAnimatorCompat mClickAnimation;
  private boolean mDrawsInPressedState;
  private boolean mHijackFocus;
  private boolean mListSelectionHidden;
  private ListViewAutoScrollHelper mScrollHelper;
  
  public ListPopupWindow$DropDownListView(Context paramContext, boolean paramBoolean)
  {
    super(paramContext, null, R.attr.dropDownListViewStyle);
    this.mHijackFocus = paramBoolean;
    setCacheColorHint(0);
  }
  
  private void clearPressedItem()
  {
    this.mDrawsInPressedState = false;
    setPressed(false);
    drawableStateChanged();
    if (this.mClickAnimation != null)
    {
      this.mClickAnimation.cancel();
      this.mClickAnimation = null;
    }
  }
  
  private void clickPressedItem(View paramView, int paramInt)
  {
    performItemClick(paramView, paramInt, getItemIdAtPosition(paramInt));
  }
  
  private void setPressedItem(View paramView, int paramInt, float paramFloat1, float paramFloat2)
  {
    this.mDrawsInPressedState = true;
    setPressed(true);
    layoutChildren();
    setSelection(paramInt);
    positionSelectorLikeTouchCompat(paramInt, paramView, paramFloat1, paramFloat2);
    setSelectorEnabled(false);
    refreshDrawableState();
  }
  
  public boolean hasFocus()
  {
    if ((this.mHijackFocus) || (super.hasFocus())) {}
    for (boolean bool = true;; bool = false) {
      return bool;
    }
  }
  
  public boolean hasWindowFocus()
  {
    if ((this.mHijackFocus) || (super.hasWindowFocus())) {}
    for (boolean bool = true;; bool = false) {
      return bool;
    }
  }
  
  public boolean isFocused()
  {
    if ((this.mHijackFocus) || (super.isFocused())) {}
    for (boolean bool = true;; bool = false) {
      return bool;
    }
  }
  
  public boolean isInTouchMode()
  {
    if (((this.mHijackFocus) && (this.mListSelectionHidden)) || (super.isInTouchMode())) {}
    for (boolean bool = true;; bool = false) {
      return bool;
    }
  }
  
  public boolean onForwardedEvent(MotionEvent paramMotionEvent, int paramInt)
  {
    int i = MotionEventCompat.getActionMasked(paramMotionEvent);
    int i1;
    boolean bool2;
    switch (i)
    {
    default: 
      i1 = 0;
    case 3: 
      for (bool2 = true;; bool2 = false)
      {
        label38:
        if ((!bool2) || (i1 != 0)) {
          clearPressedItem();
        }
        if (!bool2) {
          break;
        }
        if (this.mScrollHelper == null) {
          this.mScrollHelper = new ListViewAutoScrollHelper(this);
        }
        this.mScrollHelper.setEnabled(true);
        this.mScrollHelper.onTouch(this, paramMotionEvent);
        label95:
        return bool2;
        i1 = 0;
      }
    }
    for (boolean bool1 = false;; bool1 = true)
    {
      int j = paramMotionEvent.findPointerIndex(paramInt);
      if (j < 0)
      {
        i1 = 0;
        bool2 = false;
        break label38;
      }
      int k = (int)paramMotionEvent.getX(j);
      int m = (int)paramMotionEvent.getY(j);
      int n = pointToPosition(k, m);
      if (n == -1)
      {
        bool2 = bool1;
        i1 = 1;
        break label38;
      }
      View localView = getChildAt(n - getFirstVisiblePosition());
      setPressedItem(localView, n, k, m);
      if (i != 1) {
        break;
      }
      clickPressedItem(localView, n);
      break;
      if (this.mScrollHelper == null) {
        break label95;
      }
      this.mScrollHelper.setEnabled(false);
      break label95;
    }
  }
  
  protected boolean touchModeDrawsInPressedStateCompat()
  {
    if ((this.mDrawsInPressedState) || (super.touchModeDrawsInPressedStateCompat())) {}
    for (boolean bool = true;; bool = false) {
      return bool;
    }
  }
}


/* Location:           C:\Users\dreadiscool\Desktop\tools\classes-dex2jar.jar
 * Qualified Name:     android.support.v7.widget.ListPopupWindow.DropDownListView
 * JD-Core Version:    0.7.0.1
 */