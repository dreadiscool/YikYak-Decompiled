package android.support.v7.internal.view.menu;

import android.content.Context;
import android.content.res.Configuration;
import android.content.res.Resources;
import android.content.res.TypedArray;
import android.graphics.Rect;
import android.graphics.drawable.Drawable;
import android.os.Build.VERSION;
import android.support.v4.view.ViewCompat;
import android.support.v7.appcompat.R.bool;
import android.support.v7.appcompat.R.styleable;
import android.support.v7.internal.text.AllCapsTransformationMethod;
import android.support.v7.internal.widget.CompatTextView;
import android.support.v7.widget.ActionMenuView.ActionMenuChildView;
import android.support.v7.widget.ListPopupWindow.ForwardingListener;
import android.text.TextUtils;
import android.util.AttributeSet;
import android.util.DisplayMetrics;
import android.view.MotionEvent;
import android.view.View;
import android.view.View.MeasureSpec;
import android.view.View.OnClickListener;
import android.view.View.OnLongClickListener;
import android.widget.Toast;

public class ActionMenuItemView
  extends CompatTextView
  implements MenuView.ItemView, ActionMenuView.ActionMenuChildView, View.OnClickListener, View.OnLongClickListener
{
  private static final int MAX_ICON_SIZE = 32;
  private static final String TAG = "ActionMenuItemView";
  private boolean mAllowTextWithIcon;
  private boolean mExpandedFormat;
  private ListPopupWindow.ForwardingListener mForwardingListener;
  private Drawable mIcon;
  private MenuItemImpl mItemData;
  private MenuBuilder.ItemInvoker mItemInvoker;
  private int mMaxIconSize;
  private int mMinWidth;
  private ActionMenuItemView.PopupCallback mPopupCallback;
  private int mSavedPaddingLeft;
  private CharSequence mTitle;
  
  public ActionMenuItemView(Context paramContext)
  {
    this(paramContext, null);
  }
  
  public ActionMenuItemView(Context paramContext, AttributeSet paramAttributeSet)
  {
    this(paramContext, paramAttributeSet, 0);
  }
  
  public ActionMenuItemView(Context paramContext, AttributeSet paramAttributeSet, int paramInt)
  {
    super(paramContext, paramAttributeSet, paramInt);
    Resources localResources = paramContext.getResources();
    this.mAllowTextWithIcon = localResources.getBoolean(R.bool.abc_config_allowActionMenuItemTextWithIcon);
    TypedArray localTypedArray = paramContext.obtainStyledAttributes(paramAttributeSet, R.styleable.ActionMenuItemView, paramInt, 0);
    this.mMinWidth = localTypedArray.getDimensionPixelSize(R.styleable.ActionMenuItemView_android_minWidth, 0);
    localTypedArray.recycle();
    this.mMaxIconSize = ((int)(0.5F + 32.0F * localResources.getDisplayMetrics().density));
    setOnClickListener(this);
    setOnLongClickListener(this);
    setTransformationMethod(new AllCapsTransformationMethod(paramContext));
    this.mSavedPaddingLeft = -1;
  }
  
  private void updateTextButtonVisibility()
  {
    int i = 0;
    int j;
    if (!TextUtils.isEmpty(this.mTitle))
    {
      j = 1;
      if ((this.mIcon == null) || ((this.mItemData.showsTextAsAction()) && ((this.mAllowTextWithIcon) || (this.mExpandedFormat)))) {
        i = 1;
      }
      if ((j & i) == 0) {
        break label69;
      }
    }
    label69:
    for (CharSequence localCharSequence = this.mTitle;; localCharSequence = null)
    {
      setText(localCharSequence);
      return;
      j = 0;
      break;
    }
  }
  
  public MenuItemImpl getItemData()
  {
    return this.mItemData;
  }
  
  public boolean hasText()
  {
    if (!TextUtils.isEmpty(getText())) {}
    for (boolean bool = true;; bool = false) {
      return bool;
    }
  }
  
  public void initialize(MenuItemImpl paramMenuItemImpl, int paramInt)
  {
    this.mItemData = paramMenuItemImpl;
    setIcon(paramMenuItemImpl.getIcon());
    setTitle(paramMenuItemImpl.getTitleForItemView(this));
    setId(paramMenuItemImpl.getItemId());
    if (paramMenuItemImpl.isVisible()) {}
    for (int i = 0;; i = 8)
    {
      setVisibility(i);
      setEnabled(paramMenuItemImpl.isEnabled());
      if ((paramMenuItemImpl.hasSubMenu()) && (this.mForwardingListener == null)) {
        this.mForwardingListener = new ActionMenuItemView.ActionMenuItemForwardingListener(this);
      }
      return;
    }
  }
  
  public boolean needsDividerAfter()
  {
    return hasText();
  }
  
  public boolean needsDividerBefore()
  {
    if ((hasText()) && (this.mItemData.getIcon() == null)) {}
    for (boolean bool = true;; bool = false) {
      return bool;
    }
  }
  
  public void onClick(View paramView)
  {
    if (this.mItemInvoker != null) {
      this.mItemInvoker.invokeItem(this.mItemData);
    }
  }
  
  public void onConfigurationChanged(Configuration paramConfiguration)
  {
    if (Build.VERSION.SDK_INT >= 8) {
      super.onConfigurationChanged(paramConfiguration);
    }
    this.mAllowTextWithIcon = getContext().getResources().getBoolean(R.bool.abc_config_allowActionMenuItemTextWithIcon);
    updateTextButtonVisibility();
  }
  
  public boolean onLongClick(View paramView)
  {
    boolean bool;
    if (hasText())
    {
      bool = false;
      return bool;
    }
    int[] arrayOfInt = new int[2];
    Rect localRect = new Rect();
    getLocationOnScreen(arrayOfInt);
    getWindowVisibleDisplayFrame(localRect);
    Context localContext = getContext();
    int i = getWidth();
    int j = getHeight();
    int k = arrayOfInt[1] + j / 2;
    int m = arrayOfInt[0] + i / 2;
    if (ViewCompat.getLayoutDirection(paramView) == 0) {
      m = localContext.getResources().getDisplayMetrics().widthPixels - m;
    }
    Toast localToast = Toast.makeText(localContext, this.mItemData.getTitle(), 0);
    if (k < localRect.height()) {
      localToast.setGravity(8388661, m, j);
    }
    for (;;)
    {
      localToast.show();
      bool = true;
      break;
      localToast.setGravity(81, 0, j);
    }
  }
  
  protected void onMeasure(int paramInt1, int paramInt2)
  {
    boolean bool = hasText();
    if ((bool) && (this.mSavedPaddingLeft >= 0)) {
      super.setPadding(this.mSavedPaddingLeft, getPaddingTop(), getPaddingRight(), getPaddingBottom());
    }
    super.onMeasure(paramInt1, paramInt2);
    int i = View.MeasureSpec.getMode(paramInt1);
    int j = View.MeasureSpec.getSize(paramInt1);
    int k = getMeasuredWidth();
    if (i == -2147483648) {}
    for (int m = Math.min(j, this.mMinWidth);; m = this.mMinWidth)
    {
      if ((i != 1073741824) && (this.mMinWidth > 0) && (k < m)) {
        super.onMeasure(View.MeasureSpec.makeMeasureSpec(m, 1073741824), paramInt2);
      }
      if ((!bool) && (this.mIcon != null)) {
        super.setPadding((getMeasuredWidth() - this.mIcon.getBounds().width()) / 2, getPaddingTop(), getPaddingRight(), getPaddingBottom());
      }
      return;
    }
  }
  
  public boolean onTouchEvent(MotionEvent paramMotionEvent)
  {
    if ((this.mItemData.hasSubMenu()) && (this.mForwardingListener != null) && (this.mForwardingListener.onTouch(this, paramMotionEvent))) {}
    for (boolean bool = true;; bool = super.onTouchEvent(paramMotionEvent)) {
      return bool;
    }
  }
  
  public boolean prefersCondensedTitle()
  {
    return true;
  }
  
  public void setCheckable(boolean paramBoolean) {}
  
  public void setChecked(boolean paramBoolean) {}
  
  public void setExpandedFormat(boolean paramBoolean)
  {
    if (this.mExpandedFormat != paramBoolean)
    {
      this.mExpandedFormat = paramBoolean;
      if (this.mItemData != null) {
        this.mItemData.actionFormatChanged();
      }
    }
  }
  
  public void setIcon(Drawable paramDrawable)
  {
    this.mIcon = paramDrawable;
    if (paramDrawable != null)
    {
      int i = paramDrawable.getIntrinsicWidth();
      int j = paramDrawable.getIntrinsicHeight();
      if (i > this.mMaxIconSize)
      {
        float f2 = this.mMaxIconSize / i;
        i = this.mMaxIconSize;
        j = (int)(f2 * j);
      }
      if (j > this.mMaxIconSize)
      {
        float f1 = this.mMaxIconSize / j;
        j = this.mMaxIconSize;
        i = (int)(f1 * i);
      }
      paramDrawable.setBounds(0, 0, i, j);
    }
    setCompoundDrawables(paramDrawable, null, null, null);
    updateTextButtonVisibility();
  }
  
  public void setItemInvoker(MenuBuilder.ItemInvoker paramItemInvoker)
  {
    this.mItemInvoker = paramItemInvoker;
  }
  
  public void setPadding(int paramInt1, int paramInt2, int paramInt3, int paramInt4)
  {
    this.mSavedPaddingLeft = paramInt1;
    super.setPadding(paramInt1, paramInt2, paramInt3, paramInt4);
  }
  
  public void setPopupCallback(ActionMenuItemView.PopupCallback paramPopupCallback)
  {
    this.mPopupCallback = paramPopupCallback;
  }
  
  public void setShortcut(boolean paramBoolean, char paramChar) {}
  
  public void setTitle(CharSequence paramCharSequence)
  {
    this.mTitle = paramCharSequence;
    setContentDescription(this.mTitle);
    updateTextButtonVisibility();
  }
  
  public boolean showsIcon()
  {
    return true;
  }
}


/* Location:           C:\Users\dreadiscool\Desktop\tools\classes-dex2jar.jar
 * Qualified Name:     android.support.v7.internal.view.menu.ActionMenuItemView
 * JD-Core Version:    0.7.0.1
 */