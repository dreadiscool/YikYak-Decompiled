package android.support.v7.widget;

import android.content.Context;
import android.content.res.Configuration;
import android.content.res.Resources;
import android.content.res.TypedArray;
import android.database.DataSetObserver;
import android.graphics.Rect;
import android.graphics.drawable.Drawable;
import android.os.Build.VERSION;
import android.os.Handler;
import android.support.v4.text.TextUtilsCompat;
import android.support.v4.widget.PopupWindowCompat;
import android.support.v7.appcompat.R.attr;
import android.support.v7.appcompat.R.styleable;
import android.support.v7.internal.widget.AppCompatPopupWindow;
import android.util.AttributeSet;
import android.util.DisplayMetrics;
import android.view.KeyEvent;
import android.view.KeyEvent.DispatcherState;
import android.view.View;
import android.view.View.MeasureSpec;
import android.view.View.OnTouchListener;
import android.view.ViewGroup;
import android.view.ViewParent;
import android.widget.AdapterView.OnItemClickListener;
import android.widget.AdapterView.OnItemSelectedListener;
import android.widget.LinearLayout;
import android.widget.LinearLayout.LayoutParams;
import android.widget.ListAdapter;
import android.widget.ListView;
import android.widget.PopupWindow;
import android.widget.PopupWindow.OnDismissListener;
import java.lang.reflect.Method;

public class ListPopupWindow
{
  private static final boolean DEBUG = false;
  private static final int EXPAND_LIST_TIMEOUT = 250;
  public static final int INPUT_METHOD_FROM_FOCUSABLE = 0;
  public static final int INPUT_METHOD_NEEDED = 1;
  public static final int INPUT_METHOD_NOT_NEEDED = 2;
  public static final int MATCH_PARENT = -1;
  public static final int POSITION_PROMPT_ABOVE = 0;
  public static final int POSITION_PROMPT_BELOW = 1;
  private static final String TAG = "ListPopupWindow";
  public static final int WRAP_CONTENT = -2;
  private static Method sClipToWindowEnabledMethod;
  private ListAdapter mAdapter;
  private Context mContext;
  private boolean mDropDownAlwaysVisible = false;
  private View mDropDownAnchorView;
  private int mDropDownGravity = 0;
  private int mDropDownHeight = -2;
  private int mDropDownHorizontalOffset;
  private ListPopupWindow.DropDownListView mDropDownList;
  private Drawable mDropDownListHighlight;
  private int mDropDownVerticalOffset;
  private boolean mDropDownVerticalOffsetSet;
  private int mDropDownWidth = -2;
  private boolean mForceIgnoreOutsideTouch = false;
  private Handler mHandler = new Handler();
  private final ListPopupWindow.ListSelectorHider mHideSelector = new ListPopupWindow.ListSelectorHider(this, null);
  private AdapterView.OnItemClickListener mItemClickListener;
  private AdapterView.OnItemSelectedListener mItemSelectedListener;
  private int mLayoutDirection;
  int mListItemExpandMaximum = 2147483647;
  private boolean mModal;
  private DataSetObserver mObserver;
  private PopupWindow mPopup;
  private int mPromptPosition = 0;
  private View mPromptView;
  private final ListPopupWindow.ResizePopupRunnable mResizePopupRunnable = new ListPopupWindow.ResizePopupRunnable(this, null);
  private final ListPopupWindow.PopupScrollListener mScrollListener = new ListPopupWindow.PopupScrollListener(this, null);
  private Runnable mShowDropDownRunnable;
  private Rect mTempRect = new Rect();
  private final ListPopupWindow.PopupTouchInterceptor mTouchInterceptor = new ListPopupWindow.PopupTouchInterceptor(this, null);
  
  static
  {
    try
    {
      Class[] arrayOfClass = new Class[1];
      arrayOfClass[0] = Boolean.TYPE;
      sClipToWindowEnabledMethod = PopupWindow.class.getDeclaredMethod("setClipToScreenEnabled", arrayOfClass);
      label22:
      return;
    }
    catch (NoSuchMethodException localNoSuchMethodException)
    {
      break label22;
    }
  }
  
  public ListPopupWindow(Context paramContext)
  {
    this(paramContext, null, R.attr.listPopupWindowStyle);
  }
  
  public ListPopupWindow(Context paramContext, AttributeSet paramAttributeSet)
  {
    this(paramContext, paramAttributeSet, R.attr.listPopupWindowStyle);
  }
  
  public ListPopupWindow(Context paramContext, AttributeSet paramAttributeSet, int paramInt)
  {
    this(paramContext, paramAttributeSet, paramInt, 0);
  }
  
  public ListPopupWindow(Context paramContext, AttributeSet paramAttributeSet, int paramInt1, int paramInt2)
  {
    this.mContext = paramContext;
    TypedArray localTypedArray = paramContext.obtainStyledAttributes(paramAttributeSet, R.styleable.ListPopupWindow, paramInt1, paramInt2);
    this.mDropDownHorizontalOffset = localTypedArray.getDimensionPixelOffset(R.styleable.ListPopupWindow_android_dropDownHorizontalOffset, 0);
    this.mDropDownVerticalOffset = localTypedArray.getDimensionPixelOffset(R.styleable.ListPopupWindow_android_dropDownVerticalOffset, 0);
    if (this.mDropDownVerticalOffset != 0) {
      this.mDropDownVerticalOffsetSet = true;
    }
    localTypedArray.recycle();
    this.mPopup = new AppCompatPopupWindow(paramContext, paramAttributeSet, paramInt1);
    this.mPopup.setInputMethodMode(1);
    this.mLayoutDirection = TextUtilsCompat.getLayoutDirectionFromLocale(this.mContext.getResources().getConfiguration().locale);
  }
  
  private int buildDropDown()
  {
    boolean bool;
    ListPopupWindow.DropDownListView localDropDownListView;
    View localView2;
    LinearLayout localLinearLayout;
    LinearLayout.LayoutParams localLayoutParams2;
    label248:
    int i3;
    Object localObject;
    if (this.mDropDownList == null)
    {
      Context localContext = this.mContext;
      this.mShowDropDownRunnable = new ListPopupWindow.2(this);
      if (!this.mModal)
      {
        bool = true;
        this.mDropDownList = new ListPopupWindow.DropDownListView(localContext, bool);
        if (this.mDropDownListHighlight != null) {
          this.mDropDownList.setSelector(this.mDropDownListHighlight);
        }
        this.mDropDownList.setAdapter(this.mAdapter);
        this.mDropDownList.setOnItemClickListener(this.mItemClickListener);
        this.mDropDownList.setFocusable(true);
        this.mDropDownList.setFocusableInTouchMode(true);
        this.mDropDownList.setOnItemSelectedListener(new ListPopupWindow.3(this));
        this.mDropDownList.setOnScrollListener(this.mScrollListener);
        if (this.mItemSelectedListener != null) {
          this.mDropDownList.setOnItemSelectedListener(this.mItemSelectedListener);
        }
        localDropDownListView = this.mDropDownList;
        localView2 = this.mPromptView;
        if (localView2 == null) {
          break label695;
        }
        localLinearLayout = new LinearLayout(localContext);
        localLinearLayout.setOrientation(1);
        localLayoutParams2 = new LinearLayout.LayoutParams(-1, 0, 1.0F);
        switch (this.mPromptPosition)
        {
        default: 
          new StringBuilder().append("Invalid hint position ").append(this.mPromptPosition).toString();
          localView2.measure(View.MeasureSpec.makeMeasureSpec(this.mDropDownWidth, -2147483648), 0);
          LinearLayout.LayoutParams localLayoutParams3 = (LinearLayout.LayoutParams)localView2.getLayoutParams();
          i3 = localView2.getMeasuredHeight() + localLayoutParams3.topMargin + localLayoutParams3.bottomMargin;
          localObject = localLinearLayout;
        }
      }
    }
    for (;;)
    {
      this.mPopup.setContentView((View)localObject);
      int i = i3;
      for (;;)
      {
        label309:
        Drawable localDrawable = this.mPopup.getBackground();
        int i2;
        int j;
        if (localDrawable != null)
        {
          localDrawable.getPadding(this.mTempRect);
          i2 = this.mTempRect.top + this.mTempRect.bottom;
          if (this.mDropDownVerticalOffsetSet) {
            break label683;
          }
          this.mDropDownVerticalOffset = (-this.mTempRect.top);
          j = i2;
        }
        for (;;)
        {
          this.mPopup.getInputMethodMode();
          int k = this.mPopup.getMaxAvailableHeight(getAnchorView(), this.mDropDownVerticalOffset);
          int m;
          if ((this.mDropDownAlwaysVisible) || (this.mDropDownHeight == -1))
          {
            m = k + j;
            return m;
            bool = false;
            break;
            localLinearLayout.addView(localDropDownListView, localLayoutParams2);
            localLinearLayout.addView(localView2);
            break label248;
            localLinearLayout.addView(localView2);
            localLinearLayout.addView(localDropDownListView, localLayoutParams2);
            break label248;
            this.mPopup.getContentView();
            View localView1 = this.mPromptView;
            if (localView1 == null) {
              break label690;
            }
            LinearLayout.LayoutParams localLayoutParams1 = (LinearLayout.LayoutParams)localView1.getLayoutParams();
            i = localView1.getMeasuredHeight() + localLayoutParams1.topMargin + localLayoutParams1.bottomMargin;
            break label309;
            this.mTempRect.setEmpty();
            j = 0;
            continue;
          }
          int n;
          switch (this.mDropDownWidth)
          {
          default: 
            n = View.MeasureSpec.makeMeasureSpec(this.mDropDownWidth, 1073741824);
          }
          for (;;)
          {
            int i1 = this.mDropDownList.measureHeightOfChildrenCompat(n, 0, -1, k - i, -1);
            if (i1 > 0) {
              i += j;
            }
            m = i1 + i;
            break;
            n = View.MeasureSpec.makeMeasureSpec(this.mContext.getResources().getDisplayMetrics().widthPixels - (this.mTempRect.left + this.mTempRect.right), -2147483648);
            continue;
            n = View.MeasureSpec.makeMeasureSpec(this.mContext.getResources().getDisplayMetrics().widthPixels - (this.mTempRect.left + this.mTempRect.right), 1073741824);
          }
          label683:
          j = i2;
        }
        label690:
        i = 0;
      }
      label695:
      localObject = localDropDownListView;
      i3 = 0;
    }
  }
  
  private static boolean isConfirmKey(int paramInt)
  {
    if ((paramInt == 66) || (paramInt == 23)) {}
    for (boolean bool = true;; bool = false) {
      return bool;
    }
  }
  
  private void removePromptView()
  {
    if (this.mPromptView != null)
    {
      ViewParent localViewParent = this.mPromptView.getParent();
      if ((localViewParent instanceof ViewGroup)) {
        ((ViewGroup)localViewParent).removeView(this.mPromptView);
      }
    }
  }
  
  private void setPopupClipToScreenEnabled(boolean paramBoolean)
  {
    if (sClipToWindowEnabledMethod != null) {}
    try
    {
      Method localMethod = sClipToWindowEnabledMethod;
      PopupWindow localPopupWindow = this.mPopup;
      Object[] arrayOfObject = new Object[1];
      arrayOfObject[0] = Boolean.valueOf(paramBoolean);
      localMethod.invoke(localPopupWindow, arrayOfObject);
      label39:
      return;
    }
    catch (Exception localException)
    {
      break label39;
    }
  }
  
  public void clearListSelection()
  {
    ListPopupWindow.DropDownListView localDropDownListView = this.mDropDownList;
    if (localDropDownListView != null)
    {
      ListPopupWindow.DropDownListView.access$502(localDropDownListView, true);
      localDropDownListView.requestLayout();
    }
  }
  
  public View.OnTouchListener createDragToOpenListener(View paramView)
  {
    return new ListPopupWindow.1(this, paramView);
  }
  
  public void dismiss()
  {
    this.mPopup.dismiss();
    removePromptView();
    this.mPopup.setContentView(null);
    this.mDropDownList = null;
    this.mHandler.removeCallbacks(this.mResizePopupRunnable);
  }
  
  public View getAnchorView()
  {
    return this.mDropDownAnchorView;
  }
  
  public int getAnimationStyle()
  {
    return this.mPopup.getAnimationStyle();
  }
  
  public Drawable getBackground()
  {
    return this.mPopup.getBackground();
  }
  
  public int getHeight()
  {
    return this.mDropDownHeight;
  }
  
  public int getHorizontalOffset()
  {
    return this.mDropDownHorizontalOffset;
  }
  
  public int getInputMethodMode()
  {
    return this.mPopup.getInputMethodMode();
  }
  
  public ListView getListView()
  {
    return this.mDropDownList;
  }
  
  public int getPromptPosition()
  {
    return this.mPromptPosition;
  }
  
  public Object getSelectedItem()
  {
    if (!isShowing()) {}
    for (Object localObject = null;; localObject = this.mDropDownList.getSelectedItem()) {
      return localObject;
    }
  }
  
  public long getSelectedItemId()
  {
    if (!isShowing()) {}
    for (long l = -9223372036854775808L;; l = this.mDropDownList.getSelectedItemId()) {
      return l;
    }
  }
  
  public int getSelectedItemPosition()
  {
    if (!isShowing()) {}
    for (int i = -1;; i = this.mDropDownList.getSelectedItemPosition()) {
      return i;
    }
  }
  
  public View getSelectedView()
  {
    if (!isShowing()) {}
    for (View localView = null;; localView = this.mDropDownList.getSelectedView()) {
      return localView;
    }
  }
  
  public int getSoftInputMode()
  {
    return this.mPopup.getSoftInputMode();
  }
  
  public int getVerticalOffset()
  {
    if (!this.mDropDownVerticalOffsetSet) {}
    for (int i = 0;; i = this.mDropDownVerticalOffset) {
      return i;
    }
  }
  
  public int getWidth()
  {
    return this.mDropDownWidth;
  }
  
  public boolean isDropDownAlwaysVisible()
  {
    return this.mDropDownAlwaysVisible;
  }
  
  public boolean isInputMethodNotNeeded()
  {
    if (this.mPopup.getInputMethodMode() == 2) {}
    for (boolean bool = true;; bool = false) {
      return bool;
    }
  }
  
  public boolean isModal()
  {
    return this.mModal;
  }
  
  public boolean isShowing()
  {
    return this.mPopup.isShowing();
  }
  
  public boolean onKeyDown(int paramInt, KeyEvent paramKeyEvent)
  {
    int i = 1;
    int k;
    ListAdapter localListAdapter;
    int i1;
    int i2;
    if ((isShowing()) && (paramInt != 62) && ((this.mDropDownList.getSelectedItemPosition() >= 0) || (!isConfirmKey(paramInt))))
    {
      k = this.mDropDownList.getSelectedItemPosition();
      if (!this.mPopup.isAboveAnchor())
      {
        int m = i;
        localListAdapter = this.mAdapter;
        i1 = 2147483647;
        i2 = -2147483648;
        if (localListAdapter != null)
        {
          boolean bool = localListAdapter.areAllItemsEnabled();
          if (!bool) {
            break label168;
          }
          i1 = 0;
          label91:
          if (!bool) {
            break label182;
          }
          i2 = -1 + localListAdapter.getCount();
        }
        label108:
        if (((m == 0) || (paramInt != 19) || (k > i1)) && ((m != 0) || (paramInt != 20) || (k < i2))) {
          break label205;
        }
        clearListSelection();
        this.mPopup.setInputMethodMode(i);
        show();
      }
    }
    for (;;)
    {
      return i;
      int n = 0;
      break;
      label168:
      i1 = this.mDropDownList.lookForSelectablePosition(0, i);
      break label91;
      label182:
      i2 = this.mDropDownList.lookForSelectablePosition(-1 + localListAdapter.getCount(), false);
      break label108;
      label205:
      ListPopupWindow.DropDownListView.access$502(this.mDropDownList, false);
      if (this.mDropDownList.onKeyDown(paramInt, paramKeyEvent))
      {
        this.mPopup.setInputMethodMode(2);
        this.mDropDownList.requestFocusFromTouch();
        show();
        switch (paramInt)
        {
        }
      }
      label314:
      do
      {
        do
        {
          int j = 0;
          break;
          if ((n == 0) || (paramInt != 20)) {
            break label314;
          }
        } while (k != i2);
        break;
      } while ((n != 0) || (paramInt != 19) || (k != i1));
    }
  }
  
  public boolean onKeyPreIme(int paramInt, KeyEvent paramKeyEvent)
  {
    int i = 1;
    View localView;
    if ((paramInt == 4) && (isShowing()))
    {
      localView = this.mDropDownAnchorView;
      if ((paramKeyEvent.getAction() == 0) && (paramKeyEvent.getRepeatCount() == 0))
      {
        KeyEvent.DispatcherState localDispatcherState2 = localView.getKeyDispatcherState();
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
        KeyEvent.DispatcherState localDispatcherState1 = localView.getKeyDispatcherState();
        if (localDispatcherState1 != null) {
          localDispatcherState1.handleUpEvent(paramKeyEvent);
        }
        if ((paramKeyEvent.isTracking()) && (!paramKeyEvent.isCanceled()))
        {
          dismiss();
          continue;
        }
      }
      int j = 0;
    }
  }
  
  public boolean onKeyUp(int paramInt, KeyEvent paramKeyEvent)
  {
    boolean bool;
    if ((isShowing()) && (this.mDropDownList.getSelectedItemPosition() >= 0))
    {
      bool = this.mDropDownList.onKeyUp(paramInt, paramKeyEvent);
      if ((bool) && (isConfirmKey(paramInt))) {
        dismiss();
      }
    }
    for (;;)
    {
      return bool;
      bool = false;
    }
  }
  
  public boolean performItemClick(int paramInt)
  {
    if (isShowing()) {
      if (this.mItemClickListener != null)
      {
        ListPopupWindow.DropDownListView localDropDownListView = this.mDropDownList;
        View localView = localDropDownListView.getChildAt(paramInt - localDropDownListView.getFirstVisiblePosition());
        ListAdapter localListAdapter = localDropDownListView.getAdapter();
        this.mItemClickListener.onItemClick(localDropDownListView, localView, paramInt, localListAdapter.getItemId(paramInt));
      }
    }
    for (boolean bool = true;; bool = false) {
      return bool;
    }
  }
  
  public void postShow()
  {
    this.mHandler.post(this.mShowDropDownRunnable);
  }
  
  public void setAdapter(ListAdapter paramListAdapter)
  {
    if (this.mObserver == null) {
      this.mObserver = new ListPopupWindow.PopupDataSetObserver(this, null);
    }
    for (;;)
    {
      this.mAdapter = paramListAdapter;
      if (this.mAdapter != null) {
        paramListAdapter.registerDataSetObserver(this.mObserver);
      }
      if (this.mDropDownList != null) {
        this.mDropDownList.setAdapter(this.mAdapter);
      }
      return;
      if (this.mAdapter != null) {
        this.mAdapter.unregisterDataSetObserver(this.mObserver);
      }
    }
  }
  
  public void setAnchorView(View paramView)
  {
    this.mDropDownAnchorView = paramView;
  }
  
  public void setAnimationStyle(int paramInt)
  {
    this.mPopup.setAnimationStyle(paramInt);
  }
  
  public void setBackgroundDrawable(Drawable paramDrawable)
  {
    this.mPopup.setBackgroundDrawable(paramDrawable);
  }
  
  public void setContentWidth(int paramInt)
  {
    Drawable localDrawable = this.mPopup.getBackground();
    if (localDrawable != null)
    {
      localDrawable.getPadding(this.mTempRect);
      this.mDropDownWidth = (paramInt + (this.mTempRect.left + this.mTempRect.right));
    }
    for (;;)
    {
      return;
      setWidth(paramInt);
    }
  }
  
  public void setDropDownAlwaysVisible(boolean paramBoolean)
  {
    this.mDropDownAlwaysVisible = paramBoolean;
  }
  
  public void setDropDownGravity(int paramInt)
  {
    this.mDropDownGravity = paramInt;
  }
  
  public void setForceIgnoreOutsideTouch(boolean paramBoolean)
  {
    this.mForceIgnoreOutsideTouch = paramBoolean;
  }
  
  public void setHeight(int paramInt)
  {
    this.mDropDownHeight = paramInt;
  }
  
  public void setHorizontalOffset(int paramInt)
  {
    this.mDropDownHorizontalOffset = paramInt;
  }
  
  public void setInputMethodMode(int paramInt)
  {
    this.mPopup.setInputMethodMode(paramInt);
  }
  
  void setListItemExpandMax(int paramInt)
  {
    this.mListItemExpandMaximum = paramInt;
  }
  
  public void setListSelector(Drawable paramDrawable)
  {
    this.mDropDownListHighlight = paramDrawable;
  }
  
  public void setModal(boolean paramBoolean)
  {
    this.mModal = paramBoolean;
    this.mPopup.setFocusable(paramBoolean);
  }
  
  public void setOnDismissListener(PopupWindow.OnDismissListener paramOnDismissListener)
  {
    this.mPopup.setOnDismissListener(paramOnDismissListener);
  }
  
  public void setOnItemClickListener(AdapterView.OnItemClickListener paramOnItemClickListener)
  {
    this.mItemClickListener = paramOnItemClickListener;
  }
  
  public void setOnItemSelectedListener(AdapterView.OnItemSelectedListener paramOnItemSelectedListener)
  {
    this.mItemSelectedListener = paramOnItemSelectedListener;
  }
  
  public void setPromptPosition(int paramInt)
  {
    this.mPromptPosition = paramInt;
  }
  
  public void setPromptView(View paramView)
  {
    boolean bool = isShowing();
    if (bool) {
      removePromptView();
    }
    this.mPromptView = paramView;
    if (bool) {
      show();
    }
  }
  
  public void setSelection(int paramInt)
  {
    ListPopupWindow.DropDownListView localDropDownListView = this.mDropDownList;
    if ((isShowing()) && (localDropDownListView != null))
    {
      ListPopupWindow.DropDownListView.access$502(localDropDownListView, false);
      localDropDownListView.setSelection(paramInt);
      if ((Build.VERSION.SDK_INT >= 11) && (localDropDownListView.getChoiceMode() != 0)) {
        localDropDownListView.setItemChecked(paramInt, true);
      }
    }
  }
  
  public void setSoftInputMode(int paramInt)
  {
    this.mPopup.setSoftInputMode(paramInt);
  }
  
  public void setVerticalOffset(int paramInt)
  {
    this.mDropDownVerticalOffset = paramInt;
    this.mDropDownVerticalOffsetSet = true;
  }
  
  public void setWidth(int paramInt)
  {
    this.mDropDownWidth = paramInt;
  }
  
  public void show()
  {
    boolean bool1 = true;
    boolean bool2 = false;
    int i = -1;
    int j = buildDropDown();
    boolean bool3 = isInputMethodNotNeeded();
    if (this.mPopup.isShowing())
    {
      int n;
      if (this.mDropDownWidth == i)
      {
        n = i;
        if (this.mDropDownHeight != i) {
          break label206;
        }
        if (!bool3) {
          break label161;
        }
        label53:
        if (!bool3) {
          break label172;
        }
        PopupWindow localPopupWindow4 = this.mPopup;
        if (this.mDropDownWidth != i) {
          break label167;
        }
        label72:
        localPopupWindow4.setWindowLayoutMode(i, 0);
      }
      for (;;)
      {
        PopupWindow localPopupWindow2 = this.mPopup;
        if ((!this.mForceIgnoreOutsideTouch) && (!this.mDropDownAlwaysVisible)) {
          bool2 = bool1;
        }
        localPopupWindow2.setOutsideTouchable(bool2);
        this.mPopup.update(getAnchorView(), this.mDropDownHorizontalOffset, this.mDropDownVerticalOffset, n, j);
        return;
        if (this.mDropDownWidth == -2)
        {
          n = getAnchorView().getWidth();
          break;
        }
        n = this.mDropDownWidth;
        break;
        label161:
        j = i;
        break label53;
        label167:
        i = 0;
        break label72;
        label172:
        PopupWindow localPopupWindow3 = this.mPopup;
        if (this.mDropDownWidth == i) {}
        for (int i1 = i;; i1 = 0)
        {
          localPopupWindow3.setWindowLayoutMode(i1, i);
          break;
        }
        label206:
        if (this.mDropDownHeight != -2) {
          j = this.mDropDownHeight;
        }
      }
    }
    int k;
    label235:
    int m;
    label246:
    PopupWindow localPopupWindow1;
    if (this.mDropDownWidth == i)
    {
      k = i;
      if (this.mDropDownHeight != i) {
        break label419;
      }
      m = i;
      this.mPopup.setWindowLayoutMode(k, m);
      setPopupClipToScreenEnabled(bool1);
      localPopupWindow1 = this.mPopup;
      if ((this.mForceIgnoreOutsideTouch) || (this.mDropDownAlwaysVisible)) {
        break label460;
      }
    }
    for (;;)
    {
      localPopupWindow1.setOutsideTouchable(bool1);
      this.mPopup.setTouchInterceptor(this.mTouchInterceptor);
      PopupWindowCompat.showAsDropDown(this.mPopup, getAnchorView(), this.mDropDownHorizontalOffset, this.mDropDownVerticalOffset, this.mDropDownGravity);
      this.mDropDownList.setSelection(i);
      if ((!this.mModal) || (this.mDropDownList.isInTouchMode())) {
        clearListSelection();
      }
      if (this.mModal) {
        break;
      }
      this.mHandler.post(this.mHideSelector);
      break;
      if (this.mDropDownWidth == -2)
      {
        this.mPopup.setWidth(getAnchorView().getWidth());
        k = 0;
        break label235;
      }
      this.mPopup.setWidth(this.mDropDownWidth);
      k = 0;
      break label235;
      label419:
      if (this.mDropDownHeight == -2)
      {
        this.mPopup.setHeight(j);
        m = 0;
        break label246;
      }
      this.mPopup.setHeight(this.mDropDownHeight);
      m = 0;
      break label246;
      label460:
      bool1 = false;
    }
  }
}


/* Location:           C:\Users\dreadiscool\Desktop\tools\classes-dex2jar.jar
 * Qualified Name:     android.support.v7.widget.ListPopupWindow
 * JD-Core Version:    0.7.0.1
 */