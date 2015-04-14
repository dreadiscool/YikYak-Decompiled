package android.support.v7.widget;

import android.view.animation.Interpolator;

public class RecyclerView$SmoothScroller$Action
{
  public static final int UNDEFINED_DURATION = -2147483648;
  private boolean changed = false;
  private int consecutiveUpdates = 0;
  private int mDuration;
  private int mDx;
  private int mDy;
  private Interpolator mInterpolator;
  
  public RecyclerView$SmoothScroller$Action(int paramInt1, int paramInt2)
  {
    this(paramInt1, paramInt2, -2147483648, null);
  }
  
  public RecyclerView$SmoothScroller$Action(int paramInt1, int paramInt2, int paramInt3)
  {
    this(paramInt1, paramInt2, paramInt3, null);
  }
  
  public RecyclerView$SmoothScroller$Action(int paramInt1, int paramInt2, int paramInt3, Interpolator paramInterpolator)
  {
    this.mDx = paramInt1;
    this.mDy = paramInt2;
    this.mDuration = paramInt3;
    this.mInterpolator = paramInterpolator;
  }
  
  private void runIfNecessary(RecyclerView paramRecyclerView)
  {
    if (this.changed)
    {
      validate();
      if (this.mInterpolator == null) {
        if (this.mDuration == -2147483648)
        {
          RecyclerView.access$4700(paramRecyclerView).smoothScrollBy(this.mDx, this.mDy);
          this.consecutiveUpdates = (1 + this.consecutiveUpdates);
          this.changed = false;
        }
      }
    }
    for (;;)
    {
      return;
      RecyclerView.access$4700(paramRecyclerView).smoothScrollBy(this.mDx, this.mDy, this.mDuration);
      break;
      RecyclerView.access$4700(paramRecyclerView).smoothScrollBy(this.mDx, this.mDy, this.mDuration, this.mInterpolator);
      break;
      this.consecutiveUpdates = 0;
    }
  }
  
  private void validate()
  {
    if ((this.mInterpolator != null) && (this.mDuration < 1)) {
      throw new IllegalStateException("If you provide an interpolator, you must set a positive duration");
    }
    if (this.mDuration < 1) {
      throw new IllegalStateException("Scroll duration must be a positive number");
    }
  }
  
  public int getDuration()
  {
    return this.mDuration;
  }
  
  public int getDx()
  {
    return this.mDx;
  }
  
  public int getDy()
  {
    return this.mDy;
  }
  
  public Interpolator getInterpolator()
  {
    return this.mInterpolator;
  }
  
  public void setDuration(int paramInt)
  {
    this.changed = true;
    this.mDuration = paramInt;
  }
  
  public void setDx(int paramInt)
  {
    this.changed = true;
    this.mDx = paramInt;
  }
  
  public void setDy(int paramInt)
  {
    this.changed = true;
    this.mDy = paramInt;
  }
  
  public void setInterpolator(Interpolator paramInterpolator)
  {
    this.changed = true;
    this.mInterpolator = paramInterpolator;
  }
  
  public void update(int paramInt1, int paramInt2, int paramInt3, Interpolator paramInterpolator)
  {
    this.mDx = paramInt1;
    this.mDy = paramInt2;
    this.mDuration = paramInt3;
    this.mInterpolator = paramInterpolator;
    this.changed = true;
  }
}


/* Location:           C:\Users\dreadiscool\Desktop\tools\classes-dex2jar.jar
 * Qualified Name:     android.support.v7.widget.RecyclerView.SmoothScroller.Action
 * JD-Core Version:    0.7.0.1
 */