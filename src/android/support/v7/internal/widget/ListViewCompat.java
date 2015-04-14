package android.support.v7.internal.widget;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Rect;
import android.graphics.drawable.Drawable;
import android.support.v4.graphics.drawable.DrawableCompat;
import android.util.AttributeSet;
import android.view.View;
import android.view.View.MeasureSpec;
import android.view.ViewGroup.LayoutParams;
import android.widget.AbsListView;
import android.widget.ListAdapter;
import android.widget.ListView;
import java.lang.reflect.Field;

public class ListViewCompat
  extends ListView
{
  public static final int INVALID_POSITION = -1;
  public static final int NO_POSITION = -1;
  private static final int[] STATE_SET_NOTHING;
  private Field mIsChildViewEnabled;
  int mSelectionBottomPadding = 0;
  int mSelectionLeftPadding = 0;
  int mSelectionRightPadding = 0;
  int mSelectionTopPadding = 0;
  private ListViewCompat.GateKeeperDrawable mSelector;
  final Rect mSelectorRect = new Rect();
  
  static
  {
    int[] arrayOfInt = new int[1];
    arrayOfInt[0] = 0;
    STATE_SET_NOTHING = arrayOfInt;
  }
  
  public ListViewCompat(Context paramContext)
  {
    this(paramContext, null);
  }
  
  public ListViewCompat(Context paramContext, AttributeSet paramAttributeSet)
  {
    this(paramContext, paramAttributeSet, 0);
  }
  
  public ListViewCompat(Context paramContext, AttributeSet paramAttributeSet, int paramInt)
  {
    super(paramContext, paramAttributeSet, paramInt);
    try
    {
      this.mIsChildViewEnabled = AbsListView.class.getDeclaredField("mIsChildViewEnabled");
      this.mIsChildViewEnabled.setAccessible(true);
      return;
    }
    catch (NoSuchFieldException localNoSuchFieldException)
    {
      for (;;)
      {
        localNoSuchFieldException.printStackTrace();
      }
    }
  }
  
  protected void dispatchDraw(Canvas paramCanvas)
  {
    drawSelectorCompat(paramCanvas);
    super.dispatchDraw(paramCanvas);
  }
  
  protected void drawSelectorCompat(Canvas paramCanvas)
  {
    if (!this.mSelectorRect.isEmpty())
    {
      Drawable localDrawable = getSelector();
      localDrawable.setBounds(this.mSelectorRect);
      localDrawable.draw(paramCanvas);
    }
  }
  
  public void drawableStateChanged()
  {
    super.drawableStateChanged();
    this.mSelector.setEnabled(true);
    updateSelectorStateCompat();
  }
  
  public int lookForSelectablePosition(int paramInt, boolean paramBoolean)
  {
    ListAdapter localListAdapter = getAdapter();
    if ((localListAdapter == null) || (isInTouchMode())) {
      paramInt = -1;
    }
    for (;;)
    {
      return paramInt;
      int i = localListAdapter.getCount();
      if (!getAdapter().areAllItemsEnabled())
      {
        if (paramBoolean) {
          for (paramInt = Math.max(0, paramInt); (paramInt < i) && (!localListAdapter.isEnabled(paramInt)); paramInt++) {}
        }
        for (paramInt = Math.min(paramInt, i - 1); (paramInt >= 0) && (!localListAdapter.isEnabled(paramInt)); paramInt--) {}
        if ((paramInt < 0) || (paramInt >= i)) {
          paramInt = -1;
        }
      }
      else if ((paramInt < 0) || (paramInt >= i))
      {
        paramInt = -1;
      }
    }
  }
  
  public int measureHeightOfChildrenCompat(int paramInt1, int paramInt2, int paramInt3, int paramInt4, int paramInt5)
  {
    int i = getListPaddingTop();
    int j = getListPaddingBottom();
    getListPaddingLeft();
    getListPaddingRight();
    int k = getDividerHeight();
    Drawable localDrawable = getDivider();
    ListAdapter localListAdapter = getAdapter();
    if (localListAdapter == null)
    {
      paramInt4 = i + j;
      return paramInt4;
    }
    int m = j + i;
    label72:
    int n;
    View localView1;
    int i3;
    label93:
    View localView2;
    label125:
    int i5;
    if ((k > 0) && (localDrawable != null))
    {
      n = 0;
      localView1 = null;
      int i1 = 0;
      int i2 = localListAdapter.getCount();
      i3 = 0;
      if (i3 >= i2) {
        break label281;
      }
      int i4 = localListAdapter.getItemViewType(i3);
      if (i4 == i1) {
        break label288;
      }
      localView2 = null;
      i1 = i4;
      localView1 = localListAdapter.getView(i3, localView2, this);
      ViewGroup.LayoutParams localLayoutParams = localView1.getLayoutParams();
      if ((localLayoutParams == null) || (localLayoutParams.height <= 0)) {
        break label245;
      }
      i5 = View.MeasureSpec.makeMeasureSpec(localLayoutParams.height, 1073741824);
      label171:
      localView1.measure(paramInt1, i5);
      if (i3 <= 0) {
        break label295;
      }
    }
    label281:
    label288:
    label295:
    for (int i6 = m + k;; i6 = m)
    {
      int i7 = i6 + localView1.getMeasuredHeight();
      if (i7 >= paramInt4)
      {
        if ((paramInt5 < 0) || (i3 <= paramInt5) || (n <= 0) || (i7 == paramInt4)) {
          break;
        }
        paramInt4 = n;
        break;
        k = 0;
        break label72;
        label245:
        i5 = View.MeasureSpec.makeMeasureSpec(0, 0);
        break label171;
      }
      if ((paramInt5 >= 0) && (i3 >= paramInt5)) {
        n = i7;
      }
      i3++;
      m = i7;
      break label93;
      paramInt4 = m;
      break;
      localView2 = localView1;
      break label125;
    }
  }
  
  protected void positionSelectorCompat(int paramInt, View paramView)
  {
    Rect localRect = this.mSelectorRect;
    localRect.set(paramView.getLeft(), paramView.getTop(), paramView.getRight(), paramView.getBottom());
    localRect.left -= this.mSelectionLeftPadding;
    localRect.top -= this.mSelectionTopPadding;
    localRect.right += this.mSelectionRightPadding;
    localRect.bottom += this.mSelectionBottomPadding;
    try
    {
      boolean bool1 = this.mIsChildViewEnabled.getBoolean(this);
      Field localField;
      if (paramView.isEnabled() != bool1)
      {
        localField = this.mIsChildViewEnabled;
        if (bool1) {
          break label132;
        }
      }
      label132:
      for (boolean bool2 = true;; bool2 = false)
      {
        localField.set(this, Boolean.valueOf(bool2));
        if (paramInt != -1) {
          refreshDrawableState();
        }
        return;
      }
    }
    catch (IllegalAccessException localIllegalAccessException)
    {
      for (;;)
      {
        localIllegalAccessException.printStackTrace();
      }
    }
  }
  
  protected void positionSelectorLikeFocusCompat(int paramInt, View paramView)
  {
    boolean bool1 = true;
    Drawable localDrawable = getSelector();
    boolean bool2;
    float f1;
    float f2;
    if ((localDrawable != null) && (paramInt != -1))
    {
      bool2 = bool1;
      if (bool2) {
        localDrawable.setVisible(false, false);
      }
      positionSelectorCompat(paramInt, paramView);
      if (bool2)
      {
        Rect localRect = this.mSelectorRect;
        f1 = localRect.exactCenterX();
        f2 = localRect.exactCenterY();
        if (getVisibility() != 0) {
          break label97;
        }
      }
    }
    for (;;)
    {
      localDrawable.setVisible(bool1, false);
      DrawableCompat.setHotspot(localDrawable, f1, f2);
      return;
      bool2 = false;
      break;
      label97:
      bool1 = false;
    }
  }
  
  public void positionSelectorLikeTouchCompat(int paramInt, View paramView, float paramFloat1, float paramFloat2)
  {
    positionSelectorLikeFocusCompat(paramInt, paramView);
    Drawable localDrawable = getSelector();
    if ((localDrawable != null) && (paramInt != -1)) {
      DrawableCompat.setHotspot(localDrawable, paramFloat1, paramFloat2);
    }
  }
  
  public void setSelector(Drawable paramDrawable)
  {
    this.mSelector = new ListViewCompat.GateKeeperDrawable(paramDrawable);
    super.setSelector(this.mSelector);
    Rect localRect = new Rect();
    paramDrawable.getPadding(localRect);
    this.mSelectionLeftPadding = localRect.left;
    this.mSelectionTopPadding = localRect.top;
    this.mSelectionRightPadding = localRect.right;
    this.mSelectionBottomPadding = localRect.bottom;
  }
  
  public void setSelectorEnabled(boolean paramBoolean)
  {
    this.mSelector.setEnabled(paramBoolean);
  }
  
  protected boolean shouldShowSelectorCompat()
  {
    if ((touchModeDrawsInPressedStateCompat()) && (isPressed())) {}
    for (boolean bool = true;; bool = false) {
      return bool;
    }
  }
  
  public boolean touchModeDrawsInPressedStateCompat()
  {
    return false;
  }
  
  protected void updateSelectorStateCompat()
  {
    Drawable localDrawable = getSelector();
    if ((localDrawable != null) && (shouldShowSelectorCompat())) {
      localDrawable.setState(getDrawableState());
    }
  }
}


/* Location:           C:\Users\dreadiscool\Desktop\tools\classes-dex2jar.jar
 * Qualified Name:     android.support.v7.internal.widget.ListViewCompat
 * JD-Core Version:    0.7.0.1
 */