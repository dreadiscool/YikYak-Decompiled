package android.support.v7.widget;

import java.util.ArrayList;

public abstract class RecyclerView$ItemAnimator
{
  private long mAddDuration = 120L;
  private long mChangeDuration = 250L;
  private ArrayList<RecyclerView.ItemAnimator.ItemAnimatorFinishedListener> mFinishedListeners = new ArrayList();
  private RecyclerView.ItemAnimator.ItemAnimatorListener mListener = null;
  private long mMoveDuration = 250L;
  private long mRemoveDuration = 120L;
  private boolean mSupportsChangeAnimations = false;
  
  public abstract boolean animateAdd(RecyclerView.ViewHolder paramViewHolder);
  
  public abstract boolean animateChange(RecyclerView.ViewHolder paramViewHolder1, RecyclerView.ViewHolder paramViewHolder2, int paramInt1, int paramInt2, int paramInt3, int paramInt4);
  
  public abstract boolean animateMove(RecyclerView.ViewHolder paramViewHolder, int paramInt1, int paramInt2, int paramInt3, int paramInt4);
  
  public abstract boolean animateRemove(RecyclerView.ViewHolder paramViewHolder);
  
  public final void dispatchAddFinished(RecyclerView.ViewHolder paramViewHolder)
  {
    onAddFinished(paramViewHolder);
    if (this.mListener != null) {
      this.mListener.onAddFinished(paramViewHolder);
    }
  }
  
  public final void dispatchAddStarting(RecyclerView.ViewHolder paramViewHolder)
  {
    onAddStarting(paramViewHolder);
  }
  
  public final void dispatchAnimationsFinished()
  {
    int i = this.mFinishedListeners.size();
    for (int j = 0; j < i; j++) {
      ((RecyclerView.ItemAnimator.ItemAnimatorFinishedListener)this.mFinishedListeners.get(j)).onAnimationsFinished();
    }
    this.mFinishedListeners.clear();
  }
  
  public final void dispatchChangeFinished(RecyclerView.ViewHolder paramViewHolder, boolean paramBoolean)
  {
    onChangeFinished(paramViewHolder, paramBoolean);
    if (this.mListener != null) {
      this.mListener.onChangeFinished(paramViewHolder);
    }
  }
  
  public final void dispatchChangeStarting(RecyclerView.ViewHolder paramViewHolder, boolean paramBoolean)
  {
    onChangeStarting(paramViewHolder, paramBoolean);
  }
  
  public final void dispatchMoveFinished(RecyclerView.ViewHolder paramViewHolder)
  {
    onMoveFinished(paramViewHolder);
    if (this.mListener != null) {
      this.mListener.onMoveFinished(paramViewHolder);
    }
  }
  
  public final void dispatchMoveStarting(RecyclerView.ViewHolder paramViewHolder)
  {
    onMoveStarting(paramViewHolder);
  }
  
  public final void dispatchRemoveFinished(RecyclerView.ViewHolder paramViewHolder)
  {
    onRemoveFinished(paramViewHolder);
    if (this.mListener != null) {
      this.mListener.onRemoveFinished(paramViewHolder);
    }
  }
  
  public final void dispatchRemoveStarting(RecyclerView.ViewHolder paramViewHolder)
  {
    onRemoveStarting(paramViewHolder);
  }
  
  public abstract void endAnimation(RecyclerView.ViewHolder paramViewHolder);
  
  public abstract void endAnimations();
  
  public long getAddDuration()
  {
    return this.mAddDuration;
  }
  
  public long getChangeDuration()
  {
    return this.mChangeDuration;
  }
  
  public long getMoveDuration()
  {
    return this.mMoveDuration;
  }
  
  public long getRemoveDuration()
  {
    return this.mRemoveDuration;
  }
  
  public boolean getSupportsChangeAnimations()
  {
    return this.mSupportsChangeAnimations;
  }
  
  public abstract boolean isRunning();
  
  public final boolean isRunning(RecyclerView.ItemAnimator.ItemAnimatorFinishedListener paramItemAnimatorFinishedListener)
  {
    boolean bool = isRunning();
    if (paramItemAnimatorFinishedListener != null)
    {
      if (bool) {
        break label21;
      }
      paramItemAnimatorFinishedListener.onAnimationsFinished();
    }
    for (;;)
    {
      return bool;
      label21:
      this.mFinishedListeners.add(paramItemAnimatorFinishedListener);
    }
  }
  
  public void onAddFinished(RecyclerView.ViewHolder paramViewHolder) {}
  
  public void onAddStarting(RecyclerView.ViewHolder paramViewHolder) {}
  
  public void onChangeFinished(RecyclerView.ViewHolder paramViewHolder, boolean paramBoolean) {}
  
  public void onChangeStarting(RecyclerView.ViewHolder paramViewHolder, boolean paramBoolean) {}
  
  public void onMoveFinished(RecyclerView.ViewHolder paramViewHolder) {}
  
  public void onMoveStarting(RecyclerView.ViewHolder paramViewHolder) {}
  
  public void onRemoveFinished(RecyclerView.ViewHolder paramViewHolder) {}
  
  public void onRemoveStarting(RecyclerView.ViewHolder paramViewHolder) {}
  
  public abstract void runPendingAnimations();
  
  public void setAddDuration(long paramLong)
  {
    this.mAddDuration = paramLong;
  }
  
  public void setChangeDuration(long paramLong)
  {
    this.mChangeDuration = paramLong;
  }
  
  void setListener(RecyclerView.ItemAnimator.ItemAnimatorListener paramItemAnimatorListener)
  {
    this.mListener = paramItemAnimatorListener;
  }
  
  public void setMoveDuration(long paramLong)
  {
    this.mMoveDuration = paramLong;
  }
  
  public void setRemoveDuration(long paramLong)
  {
    this.mRemoveDuration = paramLong;
  }
  
  public void setSupportsChangeAnimations(boolean paramBoolean)
  {
    this.mSupportsChangeAnimations = paramBoolean;
  }
}


/* Location:           C:\Users\dreadiscool\Desktop\tools\classes-dex2jar.jar
 * Qualified Name:     android.support.v7.widget.RecyclerView.ItemAnimator
 * JD-Core Version:    0.7.0.1
 */