package android.support.v7.internal.widget;

import android.content.Context;
import android.content.res.Resources;
import android.graphics.Rect;
import android.graphics.drawable.Drawable;
import android.support.v7.widget.ListPopupWindow;
import android.util.AttributeSet;
import android.util.DisplayMetrics;
import android.view.ViewTreeObserver;
import android.widget.ListAdapter;
import android.widget.ListView;
import android.widget.SpinnerAdapter;

class SpinnerCompat$DropdownPopup
  extends ListPopupWindow
  implements SpinnerCompat.SpinnerPopup
{
  private ListAdapter mAdapter;
  private CharSequence mHintText;
  
  public SpinnerCompat$DropdownPopup(SpinnerCompat paramSpinnerCompat, Context paramContext, AttributeSet paramAttributeSet, int paramInt)
  {
    super(paramContext, paramAttributeSet, paramInt);
    setAnchorView(paramSpinnerCompat);
    setModal(true);
    setPromptPosition(0);
    setOnItemClickListener(new SpinnerCompat.DropdownPopup.1(this, paramSpinnerCompat));
  }
  
  void computeContentWidth()
  {
    Drawable localDrawable = getBackground();
    int i3;
    int i;
    label46:
    int j;
    int k;
    int m;
    int i1;
    int i2;
    if (localDrawable != null)
    {
      localDrawable.getPadding(SpinnerCompat.access$400(this.this$0));
      if (ViewUtils.isLayoutRtl(this.this$0))
      {
        i3 = SpinnerCompat.access$400(this.this$0).right;
        i = i3;
        j = this.this$0.getPaddingLeft();
        k = this.this$0.getPaddingRight();
        m = this.this$0.getWidth();
        if (this.this$0.mDropDownWidth != -2) {
          break label245;
        }
        i1 = this.this$0.measureContentWidth((SpinnerAdapter)this.mAdapter, getBackground());
        i2 = this.this$0.getContext().getResources().getDisplayMetrics().widthPixels - SpinnerCompat.access$400(this.this$0).left - SpinnerCompat.access$400(this.this$0).right;
        if (i1 <= i2) {
          break label295;
        }
      }
    }
    for (;;)
    {
      setContentWidth(Math.max(i2, m - j - k));
      label169:
      if (ViewUtils.isLayoutRtl(this.this$0)) {}
      for (int n = i + (m - k - getWidth());; n = i + j)
      {
        setHorizontalOffset(n);
        return;
        i3 = -SpinnerCompat.access$400(this.this$0).left;
        break;
        Rect localRect = SpinnerCompat.access$400(this.this$0);
        SpinnerCompat.access$400(this.this$0).right = 0;
        localRect.left = 0;
        i = 0;
        break label46;
        label245:
        if (this.this$0.mDropDownWidth == -1)
        {
          setContentWidth(m - j - k);
          break label169;
        }
        setContentWidth(this.this$0.mDropDownWidth);
        break label169;
      }
      label295:
      i2 = i1;
    }
  }
  
  public CharSequence getHintText()
  {
    return this.mHintText;
  }
  
  public void setAdapter(ListAdapter paramListAdapter)
  {
    super.setAdapter(paramListAdapter);
    this.mAdapter = paramListAdapter;
  }
  
  public void setPromptText(CharSequence paramCharSequence)
  {
    this.mHintText = paramCharSequence;
  }
  
  public void show(int paramInt1, int paramInt2)
  {
    boolean bool = isShowing();
    computeContentWidth();
    setInputMethodMode(2);
    super.show();
    getListView().setChoiceMode(1);
    setSelection(this.this$0.getSelectedItemPosition());
    if (bool) {}
    for (;;)
    {
      return;
      ViewTreeObserver localViewTreeObserver = this.this$0.getViewTreeObserver();
      if (localViewTreeObserver != null)
      {
        SpinnerCompat.DropdownPopup.2 local2 = new SpinnerCompat.DropdownPopup.2(this);
        localViewTreeObserver.addOnGlobalLayoutListener(local2);
        setOnDismissListener(new SpinnerCompat.DropdownPopup.3(this, local2));
      }
    }
  }
}


/* Location:           C:\Users\dreadiscool\Desktop\tools\classes-dex2jar.jar
 * Qualified Name:     android.support.v7.internal.widget.SpinnerCompat.DropdownPopup
 * JD-Core Version:    0.7.0.1
 */