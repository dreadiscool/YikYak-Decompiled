package android.support.v7.widget;

import android.graphics.PointF;
import android.view.View;

public abstract class RecyclerView$SmoothScroller
{
  private RecyclerView.LayoutManager mLayoutManager;
  private boolean mPendingInitialRun;
  private RecyclerView mRecyclerView;
  private final RecyclerView.SmoothScroller.Action mRecyclingAction = new RecyclerView.SmoothScroller.Action(0, 0);
  private boolean mRunning;
  private int mTargetPosition = -1;
  private View mTargetView;
  
  private void onAnimation(int paramInt1, int paramInt2)
  {
    if ((!this.mRunning) || (this.mTargetPosition == -1)) {
      stop();
    }
    this.mPendingInitialRun = false;
    if (this.mTargetView != null)
    {
      if (getChildPosition(this.mTargetView) != this.mTargetPosition) {
        break label117;
      }
      onTargetFound(this.mTargetView, this.mRecyclerView.mState, this.mRecyclingAction);
      RecyclerView.SmoothScroller.Action.access$4900(this.mRecyclingAction, this.mRecyclerView);
      stop();
    }
    for (;;)
    {
      if (this.mRunning)
      {
        onSeekTargetStep(paramInt1, paramInt2, this.mRecyclerView.mState, this.mRecyclingAction);
        RecyclerView.SmoothScroller.Action.access$4900(this.mRecyclingAction, this.mRecyclerView);
      }
      return;
      label117:
      this.mTargetView = null;
    }
  }
  
  public View findViewByPosition(int paramInt)
  {
    return RecyclerView.access$1100(this.mRecyclerView).findViewByPosition(paramInt);
  }
  
  public int getChildCount()
  {
    return RecyclerView.access$1100(this.mRecyclerView).getChildCount();
  }
  
  public int getChildPosition(View paramView)
  {
    return this.mRecyclerView.getChildPosition(paramView);
  }
  
  public RecyclerView.LayoutManager getLayoutManager()
  {
    return this.mLayoutManager;
  }
  
  public int getTargetPosition()
  {
    return this.mTargetPosition;
  }
  
  public void instantScrollToPosition(int paramInt)
  {
    this.mRecyclerView.scrollToPosition(paramInt);
  }
  
  public boolean isPendingInitialRun()
  {
    return this.mPendingInitialRun;
  }
  
  public boolean isRunning()
  {
    return this.mRunning;
  }
  
  protected void normalize(PointF paramPointF)
  {
    double d = Math.sqrt(paramPointF.x * paramPointF.x + paramPointF.y * paramPointF.y);
    paramPointF.x = ((float)(paramPointF.x / d));
    paramPointF.y = ((float)(paramPointF.y / d));
  }
  
  protected void onChildAttachedToWindow(View paramView)
  {
    if (getChildPosition(paramView) == getTargetPosition()) {
      this.mTargetView = paramView;
    }
  }
  
  protected abstract void onSeekTargetStep(int paramInt1, int paramInt2, RecyclerView.State paramState, RecyclerView.SmoothScroller.Action paramAction);
  
  protected abstract void onStart();
  
  protected abstract void onStop();
  
  protected abstract void onTargetFound(View paramView, RecyclerView.State paramState, RecyclerView.SmoothScroller.Action paramAction);
  
  public void setTargetPosition(int paramInt)
  {
    this.mTargetPosition = paramInt;
  }
  
  void start(RecyclerView paramRecyclerView, RecyclerView.LayoutManager paramLayoutManager)
  {
    this.mRecyclerView = paramRecyclerView;
    this.mLayoutManager = paramLayoutManager;
    if (this.mTargetPosition == -1) {
      throw new IllegalArgumentException("Invalid target position");
    }
    RecyclerView.State.access$4602(this.mRecyclerView.mState, this.mTargetPosition);
    this.mRunning = true;
    this.mPendingInitialRun = true;
    this.mTargetView = findViewByPosition(getTargetPosition());
    onStart();
    RecyclerView.access$4700(this.mRecyclerView).postOnAnimation();
  }
  
  protected final void stop()
  {
    if (!this.mRunning) {}
    for (;;)
    {
      return;
      onStop();
      RecyclerView.State.access$4602(this.mRecyclerView.mState, -1);
      this.mTargetView = null;
      this.mTargetPosition = -1;
      this.mPendingInitialRun = false;
      this.mRunning = false;
      RecyclerView.LayoutManager.access$4800(this.mLayoutManager, this);
      this.mLayoutManager = null;
      this.mRecyclerView = null;
    }
  }
}


/* Location:           C:\Users\dreadiscool\Desktop\tools\classes-dex2jar.jar
 * Qualified Name:     android.support.v7.widget.RecyclerView.SmoothScroller
 * JD-Core Version:    0.7.0.1
 */