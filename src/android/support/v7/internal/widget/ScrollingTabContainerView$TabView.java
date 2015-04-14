package android.support.v7.internal.widget;

import android.content.Context;
import android.content.res.Resources;
import android.graphics.drawable.Drawable;
import android.os.Build.VERSION;
import android.support.v7.app.ActionBar.Tab;
import android.support.v7.appcompat.R.attr;
import android.support.v7.widget.LinearLayoutCompat;
import android.support.v7.widget.LinearLayoutCompat.LayoutParams;
import android.text.TextUtils;
import android.text.TextUtils.TruncateAt;
import android.util.DisplayMetrics;
import android.view.View;
import android.view.View.MeasureSpec;
import android.view.View.OnLongClickListener;
import android.view.ViewGroup;
import android.view.ViewParent;
import android.view.accessibility.AccessibilityEvent;
import android.view.accessibility.AccessibilityNodeInfo;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

class ScrollingTabContainerView$TabView
  extends LinearLayoutCompat
  implements View.OnLongClickListener
{
  private final int[] BG_ATTRS;
  private View mCustomView;
  private ImageView mIconView;
  private ActionBar.Tab mTab;
  private TextView mTextView;
  
  public ScrollingTabContainerView$TabView(ScrollingTabContainerView paramScrollingTabContainerView, Context paramContext, ActionBar.Tab paramTab, boolean paramBoolean)
  {
    super(paramContext, null, R.attr.actionBarTabStyle);
    int[] arrayOfInt = new int[1];
    arrayOfInt[0] = 16842964;
    this.BG_ATTRS = arrayOfInt;
    this.mTab = paramTab;
    TintTypedArray localTintTypedArray = TintTypedArray.obtainStyledAttributes(paramContext, null, this.BG_ATTRS, R.attr.actionBarTabStyle, 0);
    if (localTintTypedArray.hasValue(0)) {
      setBackgroundDrawable(localTintTypedArray.getDrawable(0));
    }
    localTintTypedArray.recycle();
    if (paramBoolean) {
      setGravity(8388627);
    }
    update();
  }
  
  public void bindTab(ActionBar.Tab paramTab)
  {
    this.mTab = paramTab;
    update();
  }
  
  public ActionBar.Tab getTab()
  {
    return this.mTab;
  }
  
  public void onInitializeAccessibilityEvent(AccessibilityEvent paramAccessibilityEvent)
  {
    super.onInitializeAccessibilityEvent(paramAccessibilityEvent);
    paramAccessibilityEvent.setClassName(ActionBar.Tab.class.getName());
  }
  
  public void onInitializeAccessibilityNodeInfo(AccessibilityNodeInfo paramAccessibilityNodeInfo)
  {
    super.onInitializeAccessibilityNodeInfo(paramAccessibilityNodeInfo);
    if (Build.VERSION.SDK_INT >= 14) {
      paramAccessibilityNodeInfo.setClassName(ActionBar.Tab.class.getName());
    }
  }
  
  public boolean onLongClick(View paramView)
  {
    int[] arrayOfInt = new int[2];
    getLocationOnScreen(arrayOfInt);
    Context localContext = getContext();
    int i = getWidth();
    int j = getHeight();
    int k = localContext.getResources().getDisplayMetrics().widthPixels;
    Toast localToast = Toast.makeText(localContext, this.mTab.getContentDescription(), 0);
    localToast.setGravity(49, arrayOfInt[0] + i / 2 - k / 2, j);
    localToast.show();
    return true;
  }
  
  public void onMeasure(int paramInt1, int paramInt2)
  {
    super.onMeasure(paramInt1, paramInt2);
    if ((this.this$0.mMaxTabWidth > 0) && (getMeasuredWidth() > this.this$0.mMaxTabWidth)) {
      super.onMeasure(View.MeasureSpec.makeMeasureSpec(this.this$0.mMaxTabWidth, 1073741824), paramInt2);
    }
  }
  
  public void setSelected(boolean paramBoolean)
  {
    if (isSelected() != paramBoolean) {}
    for (int i = 1;; i = 0)
    {
      super.setSelected(paramBoolean);
      if ((i != 0) && (paramBoolean)) {
        sendAccessibilityEvent(4);
      }
      return;
    }
  }
  
  public void update()
  {
    ActionBar.Tab localTab = this.mTab;
    View localView = localTab.getCustomView();
    if (localView != null)
    {
      ViewParent localViewParent = localView.getParent();
      if (localViewParent != this)
      {
        if (localViewParent != null) {
          ((ViewGroup)localViewParent).removeView(localView);
        }
        addView(localView);
      }
      this.mCustomView = localView;
      if (this.mTextView != null) {
        this.mTextView.setVisibility(8);
      }
      if (this.mIconView != null)
      {
        this.mIconView.setVisibility(8);
        this.mIconView.setImageDrawable(null);
      }
    }
    for (;;)
    {
      return;
      if (this.mCustomView != null)
      {
        removeView(this.mCustomView);
        this.mCustomView = null;
      }
      Drawable localDrawable = localTab.getIcon();
      CharSequence localCharSequence = localTab.getText();
      label202:
      int i;
      if (localDrawable != null)
      {
        if (this.mIconView == null)
        {
          ImageView localImageView = new ImageView(getContext());
          LinearLayoutCompat.LayoutParams localLayoutParams2 = new LinearLayoutCompat.LayoutParams(-2, -2);
          localLayoutParams2.gravity = 16;
          localImageView.setLayoutParams(localLayoutParams2);
          addView(localImageView, 0);
          this.mIconView = localImageView;
        }
        this.mIconView.setImageDrawable(localDrawable);
        this.mIconView.setVisibility(0);
        if (TextUtils.isEmpty(localCharSequence)) {
          break label374;
        }
        i = 1;
        label213:
        if (i == 0) {
          break label380;
        }
        if (this.mTextView == null)
        {
          CompatTextView localCompatTextView = new CompatTextView(getContext(), null, R.attr.actionBarTabTextStyle);
          localCompatTextView.setEllipsize(TextUtils.TruncateAt.END);
          LinearLayoutCompat.LayoutParams localLayoutParams1 = new LinearLayoutCompat.LayoutParams(-2, -2);
          localLayoutParams1.gravity = 16;
          localCompatTextView.setLayoutParams(localLayoutParams1);
          addView(localCompatTextView);
          this.mTextView = localCompatTextView;
        }
        this.mTextView.setText(localCharSequence);
        this.mTextView.setVisibility(0);
      }
      for (;;)
      {
        if (this.mIconView != null) {
          this.mIconView.setContentDescription(localTab.getContentDescription());
        }
        if ((i != 0) || (TextUtils.isEmpty(localTab.getContentDescription()))) {
          break label407;
        }
        setOnLongClickListener(this);
        break;
        if (this.mIconView == null) {
          break label202;
        }
        this.mIconView.setVisibility(8);
        this.mIconView.setImageDrawable(null);
        break label202;
        label374:
        i = 0;
        break label213;
        label380:
        if (this.mTextView != null)
        {
          this.mTextView.setVisibility(8);
          this.mTextView.setText(null);
        }
      }
      label407:
      setOnLongClickListener(null);
      setLongClickable(false);
    }
  }
}


/* Location:           C:\Users\dreadiscool\Desktop\tools\classes-dex2jar.jar
 * Qualified Name:     android.support.v7.internal.widget.ScrollingTabContainerView.TabView
 * JD-Core Version:    0.7.0.1
 */