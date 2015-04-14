package android.support.v7.widget;

import android.content.Context;
import android.graphics.Rect;
import android.support.v7.internal.widget.TintManager;
import android.support.v7.internal.widget.TintTypedArray;
import android.text.TextUtils;
import android.util.AttributeSet;
import android.view.KeyEvent;
import android.view.KeyEvent.DispatcherState;
import android.view.inputmethod.InputMethodManager;
import android.widget.AutoCompleteTextView;

public class SearchView$SearchAutoComplete
  extends AutoCompleteTextView
{
  private final int[] POPUP_WINDOW_ATTRS;
  private SearchView mSearchView;
  private int mThreshold;
  private final TintManager mTintManager;
  
  public SearchView$SearchAutoComplete(Context paramContext)
  {
    this(paramContext, null);
  }
  
  public SearchView$SearchAutoComplete(Context paramContext, AttributeSet paramAttributeSet)
  {
    this(paramContext, paramAttributeSet, 16842859);
  }
  
  public SearchView$SearchAutoComplete(Context paramContext, AttributeSet paramAttributeSet, int paramInt)
  {
    super(paramContext, paramAttributeSet, paramInt);
    int[] arrayOfInt = new int[1];
    arrayOfInt[0] = 16843126;
    this.POPUP_WINDOW_ATTRS = arrayOfInt;
    this.mThreshold = getThreshold();
    TintTypedArray localTintTypedArray = TintTypedArray.obtainStyledAttributes(paramContext, paramAttributeSet, this.POPUP_WINDOW_ATTRS, paramInt, 0);
    if (localTintTypedArray.hasValue(0)) {
      setDropDownBackgroundDrawable(localTintTypedArray.getDrawable(0));
    }
    localTintTypedArray.recycle();
    this.mTintManager = localTintTypedArray.getTintManager();
  }
  
  private boolean isEmpty()
  {
    if (TextUtils.getTrimmedLength(getText()) == 0) {}
    for (boolean bool = true;; bool = false) {
      return bool;
    }
  }
  
  public boolean enoughToFilter()
  {
    if ((this.mThreshold <= 0) || (super.enoughToFilter())) {}
    for (boolean bool = true;; bool = false) {
      return bool;
    }
  }
  
  protected void onFocusChanged(boolean paramBoolean, int paramInt, Rect paramRect)
  {
    super.onFocusChanged(paramBoolean, paramInt, paramRect);
    this.mSearchView.onTextFocusChanged();
  }
  
  public boolean onKeyPreIme(int paramInt, KeyEvent paramKeyEvent)
  {
    int i = 1;
    if (paramInt == 4) {
      if ((paramKeyEvent.getAction() == 0) && (paramKeyEvent.getRepeatCount() == 0))
      {
        KeyEvent.DispatcherState localDispatcherState2 = getKeyDispatcherState();
        if (localDispatcherState2 != null) {
          localDispatcherState2.startTracking(paramKeyEvent, this);
        }
      }
    }
    for (;;)
    {
      return i;
      if (paramKeyEvent.getAction() == i)
      {
        KeyEvent.DispatcherState localDispatcherState1 = getKeyDispatcherState();
        if (localDispatcherState1 != null) {
          localDispatcherState1.handleUpEvent(paramKeyEvent);
        }
        if ((paramKeyEvent.isTracking()) && (!paramKeyEvent.isCanceled()))
        {
          this.mSearchView.clearFocus();
          SearchView.access$2200(this.mSearchView, false);
          continue;
        }
      }
      boolean bool = super.onKeyPreIme(paramInt, paramKeyEvent);
    }
  }
  
  public void onWindowFocusChanged(boolean paramBoolean)
  {
    super.onWindowFocusChanged(paramBoolean);
    if ((paramBoolean) && (this.mSearchView.hasFocus()) && (getVisibility() == 0))
    {
      ((InputMethodManager)getContext().getSystemService("input_method")).showSoftInput(this, 0);
      if (SearchView.isLandscapeMode(getContext())) {
        SearchView.HIDDEN_METHOD_INVOKER.ensureImeVisible(this, true);
      }
    }
  }
  
  public void performCompletion() {}
  
  protected void replaceText(CharSequence paramCharSequence) {}
  
  public void setDropDownBackgroundResource(int paramInt)
  {
    setDropDownBackgroundDrawable(this.mTintManager.getDrawable(paramInt));
  }
  
  void setSearchView(SearchView paramSearchView)
  {
    this.mSearchView = paramSearchView;
  }
  
  public void setThreshold(int paramInt)
  {
    super.setThreshold(paramInt);
    this.mThreshold = paramInt;
  }
}


/* Location:           C:\Users\dreadiscool\Desktop\tools\classes-dex2jar.jar
 * Qualified Name:     android.support.v7.widget.SearchView.SearchAutoComplete
 * JD-Core Version:    0.7.0.1
 */