package com.yik.yak.ui.view;

import Ht;
import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.RecyclerView.LayoutManager;
import android.util.AttributeSet;
import android.view.MotionEvent;

public final class SnappyRecyclerView
  extends RecyclerView
{
  public SnappyRecyclerView(Context paramContext)
  {
    super(paramContext);
  }
  
  public SnappyRecyclerView(Context paramContext, AttributeSet paramAttributeSet)
  {
    super(paramContext, paramAttributeSet);
  }
  
  public SnappyRecyclerView(Context paramContext, AttributeSet paramAttributeSet, int paramInt)
  {
    super(paramContext, paramAttributeSet, paramInt);
  }
  
  public boolean fling(int paramInt1, int paramInt2)
  {
    if ((getLayoutManager() instanceof Ht)) {
      super.smoothScrollToPosition(((Ht)getLayoutManager()).a(paramInt1, paramInt2));
    }
    for (boolean bool = true;; bool = super.fling(paramInt1, paramInt2)) {
      return bool;
    }
  }
  
  public boolean onTouchEvent(MotionEvent paramMotionEvent)
  {
    boolean bool = super.onTouchEvent(paramMotionEvent);
    RecyclerView.LayoutManager localLayoutManager = getLayoutManager();
    if (((localLayoutManager instanceof Ht)) && ((paramMotionEvent.getAction() == 1) || (paramMotionEvent.getAction() == 3)) && (getScrollState() == 0)) {
      smoothScrollToPosition(((Ht)localLayoutManager).a());
    }
    return bool;
  }
}


/* Location:           C:\Users\dreadiscool\Desktop\tools\classes-dex2jar.jar
 * Qualified Name:     com.yik.yak.ui.view.SnappyRecyclerView
 * JD-Core Version:    0.7.0.1
 */