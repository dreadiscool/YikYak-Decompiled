package android.support.v7.widget;

import android.view.View;

final class OrientationHelper$2
  extends OrientationHelper
{
  OrientationHelper$2(RecyclerView.LayoutManager paramLayoutManager)
  {
    super(paramLayoutManager, null);
  }
  
  public int getDecoratedEnd(View paramView)
  {
    RecyclerView.LayoutParams localLayoutParams = (RecyclerView.LayoutParams)paramView.getLayoutParams();
    return this.mLayoutManager.getDecoratedBottom(paramView) + localLayoutParams.bottomMargin;
  }
  
  public int getDecoratedMeasurement(View paramView)
  {
    RecyclerView.LayoutParams localLayoutParams = (RecyclerView.LayoutParams)paramView.getLayoutParams();
    return this.mLayoutManager.getDecoratedMeasuredHeight(paramView) + localLayoutParams.topMargin + localLayoutParams.bottomMargin;
  }
  
  public int getDecoratedMeasurementInOther(View paramView)
  {
    RecyclerView.LayoutParams localLayoutParams = (RecyclerView.LayoutParams)paramView.getLayoutParams();
    return this.mLayoutManager.getDecoratedMeasuredWidth(paramView) + localLayoutParams.leftMargin + localLayoutParams.rightMargin;
  }
  
  public int getDecoratedStart(View paramView)
  {
    RecyclerView.LayoutParams localLayoutParams = (RecyclerView.LayoutParams)paramView.getLayoutParams();
    return this.mLayoutManager.getDecoratedTop(paramView) - localLayoutParams.topMargin;
  }
  
  public int getEnd()
  {
    return this.mLayoutManager.getHeight();
  }
  
  public int getEndAfterPadding()
  {
    return this.mLayoutManager.getHeight() - this.mLayoutManager.getPaddingBottom();
  }
  
  public int getEndPadding()
  {
    return this.mLayoutManager.getPaddingBottom();
  }
  
  public int getStartAfterPadding()
  {
    return this.mLayoutManager.getPaddingTop();
  }
  
  public int getTotalSpace()
  {
    return this.mLayoutManager.getHeight() - this.mLayoutManager.getPaddingTop() - this.mLayoutManager.getPaddingBottom();
  }
  
  public void offsetChild(View paramView, int paramInt)
  {
    paramView.offsetTopAndBottom(paramInt);
  }
  
  public void offsetChildren(int paramInt)
  {
    this.mLayoutManager.offsetChildrenVertical(paramInt);
  }
}


/* Location:           C:\Users\dreadiscool\Desktop\tools\classes-dex2jar.jar
 * Qualified Name:     android.support.v7.widget.OrientationHelper.2
 * JD-Core Version:    0.7.0.1
 */