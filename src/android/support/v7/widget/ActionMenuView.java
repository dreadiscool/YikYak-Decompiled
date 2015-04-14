package android.support.v7.widget;

import android.content.Context;
import android.content.res.Configuration;
import android.content.res.Resources;
import android.os.Build.VERSION;
import android.support.v7.internal.view.menu.ActionMenuItemView;
import android.support.v7.internal.view.menu.MenuBuilder;
import android.support.v7.internal.view.menu.MenuBuilder.Callback;
import android.support.v7.internal.view.menu.MenuBuilder.ItemInvoker;
import android.support.v7.internal.view.menu.MenuItemImpl;
import android.support.v7.internal.view.menu.MenuPresenter.Callback;
import android.support.v7.internal.view.menu.MenuView;
import android.support.v7.internal.widget.ViewUtils;
import android.util.AttributeSet;
import android.util.DisplayMetrics;
import android.view.ContextThemeWrapper;
import android.view.Menu;
import android.view.View;
import android.view.View.MeasureSpec;
import android.view.ViewGroup.LayoutParams;
import android.view.accessibility.AccessibilityEvent;

public class ActionMenuView
  extends LinearLayoutCompat
  implements MenuBuilder.ItemInvoker, MenuView
{
  static final int GENERATED_ITEM_PADDING = 4;
  static final int MIN_CELL_SIZE = 56;
  private static final String TAG = "ActionMenuView";
  private MenuPresenter.Callback mActionMenuPresenterCallback;
  private Context mContext;
  private boolean mFormatItems;
  private int mFormatItemsWidth;
  private int mGeneratedItemPadding;
  private MenuBuilder mMenu;
  private MenuBuilder.Callback mMenuBuilderCallback;
  private int mMinCellSize;
  private ActionMenuView.OnMenuItemClickListener mOnMenuItemClickListener;
  private Context mPopupContext;
  private int mPopupTheme;
  private ActionMenuPresenter mPresenter;
  private boolean mReserveOverflow;
  
  public ActionMenuView(Context paramContext)
  {
    this(paramContext, null);
  }
  
  public ActionMenuView(Context paramContext, AttributeSet paramAttributeSet)
  {
    super(paramContext, paramAttributeSet);
    this.mContext = paramContext;
    setBaselineAligned(false);
    float f = paramContext.getResources().getDisplayMetrics().density;
    this.mMinCellSize = ((int)(56.0F * f));
    this.mGeneratedItemPadding = ((int)(f * 4.0F));
    this.mPopupContext = paramContext;
    this.mPopupTheme = 0;
  }
  
  static int measureChildForCells(View paramView, int paramInt1, int paramInt2, int paramInt3, int paramInt4)
  {
    boolean bool = false;
    ActionMenuView.LayoutParams localLayoutParams = (ActionMenuView.LayoutParams)paramView.getLayoutParams();
    int i = View.MeasureSpec.makeMeasureSpec(View.MeasureSpec.getSize(paramInt3) - paramInt4, View.MeasureSpec.getMode(paramInt3));
    ActionMenuItemView localActionMenuItemView;
    int j;
    if ((paramView instanceof ActionMenuItemView))
    {
      localActionMenuItemView = (ActionMenuItemView)paramView;
      if ((localActionMenuItemView == null) || (!localActionMenuItemView.hasText())) {
        break label175;
      }
      j = 1;
      label57:
      if ((paramInt2 <= 0) || ((j != 0) && (paramInt2 < 2))) {
        break label181;
      }
      paramView.measure(View.MeasureSpec.makeMeasureSpec(paramInt1 * paramInt2, -2147483648), i);
      int m = paramView.getMeasuredWidth();
      k = m / paramInt1;
      if (m % paramInt1 != 0) {
        k++;
      }
      if ((j == 0) || (k >= 2)) {}
    }
    label175:
    label181:
    for (int k = 2;; k = 0)
    {
      if ((!localLayoutParams.isOverflowButton) && (j != 0)) {
        bool = true;
      }
      localLayoutParams.expandable = bool;
      localLayoutParams.cellsUsed = k;
      paramView.measure(View.MeasureSpec.makeMeasureSpec(k * paramInt1, 1073741824), i);
      return k;
      localActionMenuItemView = null;
      break;
      j = 0;
      break label57;
    }
  }
  
  private void onMeasureExactFormat(int paramInt1, int paramInt2)
  {
    int i = View.MeasureSpec.getMode(paramInt2);
    int j = View.MeasureSpec.getSize(paramInt1);
    int k = View.MeasureSpec.getSize(paramInt2);
    int m = getPaddingLeft() + getPaddingRight();
    int n = getPaddingTop() + getPaddingBottom();
    int i1 = getChildMeasureSpec(paramInt2, n, -2);
    int i2 = j - m;
    int i3 = i2 / this.mMinCellSize;
    int i4 = i2 % this.mMinCellSize;
    if (i3 == 0)
    {
      setMeasuredDimension(i2, 0);
      return;
    }
    int i5 = this.mMinCellSize + i4 / i3;
    int i6 = 0;
    int i7 = 0;
    int i8 = 0;
    int i9 = 0;
    int i10 = 0;
    long l1 = 0L;
    int i11 = getChildCount();
    int i12 = 0;
    View localView4;
    int i41;
    long l8;
    int i43;
    int i44;
    int i42;
    label171:
    int i32;
    ActionMenuView.LayoutParams localLayoutParams5;
    boolean bool2;
    label295:
    int i33;
    label313:
    int i34;
    int i35;
    for (;;)
    {
      if (i12 < i11)
      {
        localView4 = getChildAt(i12);
        if (localView4.getVisibility() == 8)
        {
          i41 = i9;
          l8 = l1;
          i43 = i6;
          i44 = i3;
          i42 = i7;
          i12++;
          i7 = i42;
          i6 = i43;
          i3 = i44;
          l1 = l8;
          i9 = i41;
        }
        else
        {
          boolean bool1 = localView4 instanceof ActionMenuItemView;
          i32 = i9 + 1;
          if (bool1) {
            localView4.setPadding(this.mGeneratedItemPadding, 0, this.mGeneratedItemPadding, 0);
          }
          localLayoutParams5 = (ActionMenuView.LayoutParams)localView4.getLayoutParams();
          localLayoutParams5.expanded = false;
          localLayoutParams5.extraPixels = 0;
          localLayoutParams5.cellsUsed = 0;
          localLayoutParams5.expandable = false;
          localLayoutParams5.leftMargin = 0;
          localLayoutParams5.rightMargin = 0;
          if ((bool1) && (((ActionMenuItemView)localView4).hasText()))
          {
            bool2 = true;
            localLayoutParams5.preventEdgeOffset = bool2;
            if (!localLayoutParams5.isOverflowButton) {
              break label438;
            }
            i33 = 1;
            i34 = measureChildForCells(localView4, i5, i33, i1, n);
            i35 = Math.max(i7, i34);
            if (!localLayoutParams5.expandable) {
              break label1330;
            }
          }
        }
      }
    }
    label530:
    label550:
    label1330:
    for (int i36 = i8 + 1;; i36 = i8)
    {
      if (localLayoutParams5.isOverflowButton) {}
      for (int i37 = 1;; i37 = i10)
      {
        int i38 = i3 - i34;
        int i39 = localView4.getMeasuredHeight();
        int i40 = Math.max(i6, i39);
        if (i34 == 1)
        {
          long l9 = l1 | 1 << i12;
          i43 = i40;
          i44 = i38;
          i8 = i36;
          i10 = i37;
          l8 = l9;
          i42 = i35;
          i41 = i32;
          break label171;
          bool2 = false;
          break label295;
          label438:
          i33 = i3;
          break label313;
          int i13;
          int i14;
          long l2;
          int i15;
          label470:
          int i23;
          long l4;
          int i24;
          int i25;
          label493:
          ActionMenuView.LayoutParams localLayoutParams4;
          int i30;
          int i31;
          if ((i10 != 0) && (i9 == 2))
          {
            i13 = 1;
            i14 = 0;
            l2 = l1;
            i15 = i3;
            if ((i8 <= 0) || (i15 <= 0)) {
              break label1281;
            }
            i23 = 2147483647;
            l4 = 0L;
            i24 = 0;
            i25 = 0;
            if (i25 >= i11) {
              break label613;
            }
            localLayoutParams4 = (ActionMenuView.LayoutParams)getChildAt(i25).getLayoutParams();
            if (localLayoutParams4.expandable) {
              break label550;
            }
            i30 = i24;
            i31 = i23;
          }
          for (;;)
          {
            i25++;
            i23 = i31;
            i24 = i30;
            break label493;
            i13 = 0;
            break;
            if (localLayoutParams4.cellsUsed < i23)
            {
              i31 = localLayoutParams4.cellsUsed;
              l4 = 1 << i25;
              i30 = 1;
            }
            else
            {
              if (localLayoutParams4.cellsUsed != i23) {
                break label1270;
              }
              l4 |= 1 << i25;
              i30 = i24 + 1;
              i31 = i23;
            }
          }
          label613:
          long l5 = l2 | l4;
          if (i24 > i15) {}
          for (long l3 = l5;; l3 = l2)
          {
            int i16;
            float f1;
            float f2;
            int i20;
            int i21;
            int i17;
            int i22;
            label819:
            int i27;
            int i28;
            long l6;
            label846:
            View localView3;
            ActionMenuView.LayoutParams localLayoutParams3;
            int i29;
            if ((i10 == 0) && (i9 == 1))
            {
              i16 = 1;
              if ((i15 <= 0) || (l3 == 0L)) {
                break label1152;
              }
              int i19 = i9 - 1;
              if ((i15 >= i19) && (i16 == 0) && (i7 <= 1)) {
                break label1152;
              }
              f1 = Long.bitCount(l3);
              if (i16 != 0) {
                break label1256;
              }
              if (((1L & l3) != 0L) && (!((ActionMenuView.LayoutParams)getChildAt(0).getLayoutParams()).preventEdgeOffset)) {
                f1 -= 0.5F;
              }
              if (((l3 & 1 << i11 - 1) == 0L) || (((ActionMenuView.LayoutParams)getChildAt(i11 - 1).getLayoutParams()).preventEdgeOffset)) {
                break label1256;
              }
              f2 = f1 - 0.5F;
              if (f2 <= 0.0F) {
                break label1002;
              }
              i20 = (int)(i15 * i5 / f2);
              i21 = 0;
              i17 = i14;
              for (;;)
              {
                if (i21 < i11) {
                  if ((l3 & 1 << i21) == 0L)
                  {
                    i22 = i17;
                    i21++;
                    i17 = i22;
                    continue;
                    int i26 = i23 + 1;
                    i27 = 0;
                    i28 = i15;
                    l6 = l5;
                    if (i27 < i11)
                    {
                      localView3 = getChildAt(i27);
                      localLayoutParams3 = (ActionMenuView.LayoutParams)localView3.getLayoutParams();
                      if ((l4 & 1 << i27) == 0L)
                      {
                        if (localLayoutParams3.cellsUsed != i26) {
                          break label1263;
                        }
                        l6 |= 1 << i27;
                        i29 = i28;
                      }
                    }
                  }
                }
              }
            }
            for (;;)
            {
              i27++;
              i28 = i29;
              break label846;
              if ((i13 != 0) && (localLayoutParams3.preventEdgeOffset) && (i28 == 1)) {
                localView3.setPadding(i5 + this.mGeneratedItemPadding, 0, this.mGeneratedItemPadding, 0);
              }
              localLayoutParams3.cellsUsed = (1 + localLayoutParams3.cellsUsed);
              localLayoutParams3.expanded = true;
              i29 = i28 - 1;
              continue;
              l2 = l6;
              i14 = 1;
              i15 = i28;
              break label470;
              i16 = 0;
              break label645;
              label1002:
              i20 = 0;
              break label788;
              View localView2 = getChildAt(i21);
              ActionMenuView.LayoutParams localLayoutParams2 = (ActionMenuView.LayoutParams)localView2.getLayoutParams();
              if ((localView2 instanceof ActionMenuItemView))
              {
                localLayoutParams2.extraPixels = i20;
                localLayoutParams2.expanded = true;
                if ((i21 == 0) && (!localLayoutParams2.preventEdgeOffset)) {
                  localLayoutParams2.leftMargin = (-i20 / 2);
                }
                i22 = 1;
                break label819;
              }
              if (localLayoutParams2.isOverflowButton)
              {
                localLayoutParams2.extraPixels = i20;
                localLayoutParams2.expanded = true;
                localLayoutParams2.rightMargin = (-i20 / 2);
                i22 = 1;
                break label819;
              }
              if (i21 != 0) {
                localLayoutParams2.leftMargin = (i20 / 2);
              }
              if (i21 != i11 - 1) {
                localLayoutParams2.rightMargin = (i20 / 2);
              }
              i22 = i17;
              break label819;
              i17 = i14;
              if (i17 != 0)
              {
                int i18 = 0;
                if (i18 < i11)
                {
                  View localView1 = getChildAt(i18);
                  ActionMenuView.LayoutParams localLayoutParams1 = (ActionMenuView.LayoutParams)localView1.getLayoutParams();
                  if (!localLayoutParams1.expanded) {}
                  for (;;)
                  {
                    i18++;
                    break;
                    localView1.measure(View.MeasureSpec.makeMeasureSpec(i5 * localLayoutParams1.cellsUsed + localLayoutParams1.extraPixels, 1073741824), i1);
                  }
                }
              }
              if (i != 1073741824) {}
              for (;;)
              {
                setMeasuredDimension(i2, i6);
                break;
                i6 = k;
              }
              label1256:
              f2 = f1;
              break label769;
              label1263:
              i29 = i28;
            }
            label1270:
            i30 = i24;
            i31 = i23;
            break label530;
          }
        }
        i41 = i32;
        i42 = i35;
        long l7 = l1;
        i43 = i40;
        i44 = i38;
        i10 = i37;
        i8 = i36;
        l8 = l7;
        break label171;
      }
    }
  }
  
  protected boolean checkLayoutParams(ViewGroup.LayoutParams paramLayoutParams)
  {
    if ((paramLayoutParams != null) && ((paramLayoutParams instanceof ActionMenuView.LayoutParams))) {}
    for (boolean bool = true;; bool = false) {
      return bool;
    }
  }
  
  public void dismissPopupMenus()
  {
    if (this.mPresenter != null) {
      this.mPresenter.dismissPopupMenus();
    }
  }
  
  public boolean dispatchPopulateAccessibilityEvent(AccessibilityEvent paramAccessibilityEvent)
  {
    return false;
  }
  
  protected ActionMenuView.LayoutParams generateDefaultLayoutParams()
  {
    ActionMenuView.LayoutParams localLayoutParams = new ActionMenuView.LayoutParams(-2, -2);
    localLayoutParams.gravity = 16;
    return localLayoutParams;
  }
  
  public ActionMenuView.LayoutParams generateLayoutParams(AttributeSet paramAttributeSet)
  {
    return new ActionMenuView.LayoutParams(getContext(), paramAttributeSet);
  }
  
  protected ActionMenuView.LayoutParams generateLayoutParams(ViewGroup.LayoutParams paramLayoutParams)
  {
    ActionMenuView.LayoutParams localLayoutParams;
    if (paramLayoutParams != null) {
      if ((paramLayoutParams instanceof ActionMenuView.LayoutParams))
      {
        localLayoutParams = new ActionMenuView.LayoutParams((ActionMenuView.LayoutParams)paramLayoutParams);
        if (localLayoutParams.gravity <= 0) {
          localLayoutParams.gravity = 16;
        }
      }
    }
    for (;;)
    {
      return localLayoutParams;
      localLayoutParams = new ActionMenuView.LayoutParams(paramLayoutParams);
      break;
      localLayoutParams = generateDefaultLayoutParams();
    }
  }
  
  public ActionMenuView.LayoutParams generateOverflowButtonLayoutParams()
  {
    ActionMenuView.LayoutParams localLayoutParams = generateDefaultLayoutParams();
    localLayoutParams.isOverflowButton = true;
    return localLayoutParams;
  }
  
  public Menu getMenu()
  {
    ActionMenuPresenter localActionMenuPresenter;
    if (this.mMenu == null)
    {
      Context localContext = getContext();
      this.mMenu = new MenuBuilder(localContext);
      this.mMenu.setCallback(new ActionMenuView.MenuBuilderCallback(this, null));
      this.mPresenter = new ActionMenuPresenter(localContext);
      this.mPresenter.setReserveOverflow(true);
      localActionMenuPresenter = this.mPresenter;
      if (this.mActionMenuPresenterCallback == null) {
        break label110;
      }
    }
    label110:
    for (Object localObject = this.mActionMenuPresenterCallback;; localObject = new ActionMenuView.ActionMenuPresenterCallback(this, null))
    {
      localActionMenuPresenter.setCallback((MenuPresenter.Callback)localObject);
      this.mMenu.addMenuPresenter(this.mPresenter, this.mPopupContext);
      this.mPresenter.setMenuView(this);
      return this.mMenu;
    }
  }
  
  public int getPopupTheme()
  {
    return this.mPopupTheme;
  }
  
  public int getWindowAnimations()
  {
    return 0;
  }
  
  protected boolean hasSupportDividerBeforeChildAt(int paramInt)
  {
    boolean bool1 = false;
    boolean bool2;
    if (paramInt == 0) {
      bool2 = false;
    }
    for (;;)
    {
      return bool2;
      View localView1 = getChildAt(paramInt - 1);
      View localView2 = getChildAt(paramInt);
      if ((paramInt < getChildCount()) && ((localView1 instanceof ActionMenuView.ActionMenuChildView))) {
        bool1 = false | ((ActionMenuView.ActionMenuChildView)localView1).needsDividerAfter();
      }
      if ((paramInt > 0) && ((localView2 instanceof ActionMenuView.ActionMenuChildView))) {
        bool2 = bool1 | ((ActionMenuView.ActionMenuChildView)localView2).needsDividerBefore();
      } else {
        bool2 = bool1;
      }
    }
  }
  
  public boolean hideOverflowMenu()
  {
    if ((this.mPresenter != null) && (this.mPresenter.hideOverflowMenu())) {}
    for (boolean bool = true;; bool = false) {
      return bool;
    }
  }
  
  public void initialize(MenuBuilder paramMenuBuilder)
  {
    this.mMenu = paramMenuBuilder;
  }
  
  public boolean invokeItem(MenuItemImpl paramMenuItemImpl)
  {
    return this.mMenu.performItemAction(paramMenuItemImpl, 0);
  }
  
  public boolean isOverflowMenuShowPending()
  {
    if ((this.mPresenter != null) && (this.mPresenter.isOverflowMenuShowPending())) {}
    for (boolean bool = true;; bool = false) {
      return bool;
    }
  }
  
  public boolean isOverflowMenuShowing()
  {
    if ((this.mPresenter != null) && (this.mPresenter.isOverflowMenuShowing())) {}
    for (boolean bool = true;; bool = false) {
      return bool;
    }
  }
  
  public boolean isOverflowReserved()
  {
    return this.mReserveOverflow;
  }
  
  public void onConfigurationChanged(Configuration paramConfiguration)
  {
    if (Build.VERSION.SDK_INT >= 8) {
      super.onConfigurationChanged(paramConfiguration);
    }
    this.mPresenter.updateMenuView(false);
    if ((this.mPresenter != null) && (this.mPresenter.isOverflowMenuShowing()))
    {
      this.mPresenter.hideOverflowMenu();
      this.mPresenter.showOverflowMenu();
    }
  }
  
  public void onDetachedFromWindow()
  {
    super.onDetachedFromWindow();
    dismissPopupMenus();
  }
  
  protected void onLayout(boolean paramBoolean, int paramInt1, int paramInt2, int paramInt3, int paramInt4)
  {
    if (!this.mFormatItems) {
      super.onLayout(paramBoolean, paramInt1, paramInt2, paramInt3, paramInt4);
    }
    int i;
    int j;
    int m;
    int n;
    int i1;
    boolean bool;
    for (;;)
    {
      return;
      i = getChildCount();
      j = (paramInt4 - paramInt2) / 2;
      int k = getDividerWidth();
      m = 0;
      n = paramInt3 - paramInt1 - getPaddingRight() - getPaddingLeft();
      i1 = 0;
      bool = ViewUtils.isLayoutRtl(this);
      int i2 = 0;
      if (i2 < i)
      {
        View localView4 = getChildAt(i2);
        int i29;
        int i26;
        int i28;
        if (localView4.getVisibility() == 8)
        {
          i29 = i1;
          i26 = m;
          i28 = n;
        }
        for (;;)
        {
          i2++;
          m = i26;
          n = i28;
          i1 = i29;
          break;
          ActionMenuView.LayoutParams localLayoutParams3 = (ActionMenuView.LayoutParams)localView4.getLayoutParams();
          if (localLayoutParams3.isOverflowButton)
          {
            int i30 = localView4.getMeasuredWidth();
            if (hasSupportDividerBeforeChildAt(i2)) {
              i30 += k;
            }
            int i31 = localView4.getMeasuredHeight();
            int i33;
            int i32;
            if (bool)
            {
              i33 = getPaddingLeft() + localLayoutParams3.leftMargin;
              i32 = i33 + i30;
            }
            for (;;)
            {
              int i34 = j - i31 / 2;
              localView4.layout(i33, i34, i32, i31 + i34);
              i28 = n - i30;
              i29 = 1;
              i26 = m;
              break;
              i32 = getWidth() - getPaddingRight() - localLayoutParams3.rightMargin;
              i33 = i32 - i30;
            }
          }
          int i25 = n - (localView4.getMeasuredWidth() + localLayoutParams3.leftMargin + localLayoutParams3.rightMargin);
          hasSupportDividerBeforeChildAt(i2);
          i26 = m + 1;
          int i27 = i1;
          i28 = i25;
          i29 = i27;
        }
      }
      if ((i != 1) || (i1 != 0)) {
        break;
      }
      View localView3 = getChildAt(0);
      int i21 = localView3.getMeasuredWidth();
      int i22 = localView3.getMeasuredHeight();
      int i23 = (paramInt3 - paramInt1) / 2 - i21 / 2;
      int i24 = j - i22 / 2;
      localView3.layout(i23, i24, i21 + i23, i22 + i24);
    }
    int i3;
    label400:
    int i5;
    label419:
    int i6;
    int i14;
    int i15;
    label446:
    View localView2;
    ActionMenuView.LayoutParams localLayoutParams2;
    int i16;
    if (i1 != 0)
    {
      i3 = 0;
      int i4 = m - i3;
      if (i4 <= 0) {
        break label509;
      }
      i5 = n / i4;
      i6 = Math.max(0, i5);
      if (!bool) {
        break label586;
      }
      i14 = getWidth() - getPaddingRight();
      i15 = 0;
      if (i15 < i)
      {
        localView2 = getChildAt(i15);
        localLayoutParams2 = (ActionMenuView.LayoutParams)localView2.getLayoutParams();
        if (localView2.getVisibility() == 8) {
          break label730;
        }
        if (!localLayoutParams2.isOverflowButton) {
          break label515;
        }
        i16 = i14;
      }
    }
    for (;;)
    {
      i15++;
      i14 = i16;
      break label446;
      break;
      i3 = 1;
      break label400;
      label509:
      i5 = 0;
      break label419;
      label515:
      int i17 = i14 - localLayoutParams2.rightMargin;
      int i18 = localView2.getMeasuredWidth();
      int i19 = localView2.getMeasuredHeight();
      int i20 = j - i19 / 2;
      localView2.layout(i17 - i18, i20, i17, i19 + i20);
      i16 = i17 - (i6 + (i18 + localLayoutParams2.leftMargin));
      continue;
      label586:
      int i7 = getPaddingLeft();
      int i8 = 0;
      label595:
      View localView1;
      ActionMenuView.LayoutParams localLayoutParams1;
      int i9;
      if (i8 < i)
      {
        localView1 = getChildAt(i8);
        localLayoutParams1 = (ActionMenuView.LayoutParams)localView1.getLayoutParams();
        if (localView1.getVisibility() == 8) {
          break label723;
        }
        if (!localLayoutParams1.isOverflowButton) {
          break label652;
        }
        i9 = i7;
      }
      for (;;)
      {
        i8++;
        i7 = i9;
        break label595;
        break;
        label652:
        int i10 = i7 + localLayoutParams1.leftMargin;
        int i11 = localView1.getMeasuredWidth();
        int i12 = localView1.getMeasuredHeight();
        int i13 = j - i12 / 2;
        localView1.layout(i10, i13, i10 + i11, i12 + i13);
        i9 = i10 + (i6 + (i11 + localLayoutParams1.rightMargin));
        continue;
        label723:
        i9 = i7;
      }
      label730:
      i16 = i14;
    }
  }
  
  protected void onMeasure(int paramInt1, int paramInt2)
  {
    boolean bool1 = this.mFormatItems;
    boolean bool2;
    int j;
    if (View.MeasureSpec.getMode(paramInt1) == 1073741824)
    {
      bool2 = true;
      this.mFormatItems = bool2;
      if (bool1 != this.mFormatItems) {
        this.mFormatItemsWidth = 0;
      }
      int i = View.MeasureSpec.getSize(paramInt1);
      if ((this.mFormatItems) && (this.mMenu != null) && (i != this.mFormatItemsWidth))
      {
        this.mFormatItemsWidth = i;
        this.mMenu.onItemsChanged(true);
      }
      j = getChildCount();
      if ((!this.mFormatItems) || (j <= 0)) {
        break label110;
      }
      onMeasureExactFormat(paramInt1, paramInt2);
    }
    for (;;)
    {
      return;
      bool2 = false;
      break;
      label110:
      for (int k = 0; k < j; k++)
      {
        ActionMenuView.LayoutParams localLayoutParams = (ActionMenuView.LayoutParams)getChildAt(k).getLayoutParams();
        localLayoutParams.rightMargin = 0;
        localLayoutParams.leftMargin = 0;
      }
      super.onMeasure(paramInt1, paramInt2);
    }
  }
  
  public MenuBuilder peekMenu()
  {
    return this.mMenu;
  }
  
  public void setExpandedActionViewsExclusive(boolean paramBoolean)
  {
    this.mPresenter.setExpandedActionViewsExclusive(paramBoolean);
  }
  
  public void setMenuCallbacks(MenuPresenter.Callback paramCallback, MenuBuilder.Callback paramCallback1)
  {
    this.mActionMenuPresenterCallback = paramCallback;
    this.mMenuBuilderCallback = paramCallback1;
  }
  
  public void setOnMenuItemClickListener(ActionMenuView.OnMenuItemClickListener paramOnMenuItemClickListener)
  {
    this.mOnMenuItemClickListener = paramOnMenuItemClickListener;
  }
  
  public void setOverflowReserved(boolean paramBoolean)
  {
    this.mReserveOverflow = paramBoolean;
  }
  
  public void setPopupTheme(int paramInt)
  {
    if (this.mPopupTheme != paramInt)
    {
      this.mPopupTheme = paramInt;
      if (paramInt != 0) {
        break label26;
      }
    }
    label26:
    for (this.mPopupContext = this.mContext;; this.mPopupContext = new ContextThemeWrapper(this.mContext, paramInt)) {
      return;
    }
  }
  
  public void setPresenter(ActionMenuPresenter paramActionMenuPresenter)
  {
    this.mPresenter = paramActionMenuPresenter;
    this.mPresenter.setMenuView(this);
  }
  
  public boolean showOverflowMenu()
  {
    if ((this.mPresenter != null) && (this.mPresenter.showOverflowMenu())) {}
    for (boolean bool = true;; bool = false) {
      return bool;
    }
  }
}


/* Location:           C:\Users\dreadiscool\Desktop\tools\classes-dex2jar.jar
 * Qualified Name:     android.support.v7.widget.ActionMenuView
 * JD-Core Version:    0.7.0.1
 */