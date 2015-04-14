package android.support.v7.widget;

import android.support.v4.view.ViewCompat;
import android.support.v4.widget.ScrollerCompat;
import android.view.View;
import android.view.animation.Interpolator;
import java.util.ArrayList;

class RecyclerView$ViewFlinger
  implements Runnable
{
  private boolean mEatRunOnAnimationRequest = false;
  private Interpolator mInterpolator = RecyclerView.access$2000();
  private int mLastFlingX;
  private int mLastFlingY;
  private boolean mReSchedulePostAnimationCallback = false;
  private ScrollerCompat mScroller;
  
  public RecyclerView$ViewFlinger(RecyclerView paramRecyclerView)
  {
    this.mScroller = ScrollerCompat.create(paramRecyclerView.getContext(), RecyclerView.access$2000());
  }
  
  private int computeScrollDuration(int paramInt1, int paramInt2, int paramInt3, int paramInt4)
  {
    int i = Math.abs(paramInt1);
    int j = Math.abs(paramInt2);
    int k;
    int m;
    int n;
    if (i > j)
    {
      k = 1;
      m = (int)Math.sqrt(paramInt3 * paramInt3 + paramInt4 * paramInt4);
      n = (int)Math.sqrt(paramInt1 * paramInt1 + paramInt2 * paramInt2);
      if (k == 0) {
        break label142;
      }
    }
    int i4;
    label142:
    for (int i1 = this.this$0.getWidth();; i1 = this.this$0.getHeight())
    {
      int i2 = i1 / 2;
      float f1 = Math.min(1.0F, 1.0F * n / i1);
      float f2 = i2 + i2 * distanceInfluenceForSnapDuration(f1);
      if (m <= 0) {
        break label154;
      }
      i4 = 4 * Math.round(1000.0F * Math.abs(f2 / m));
      return Math.min(i4, 2000);
      k = 0;
      break;
    }
    label154:
    if (k != 0) {}
    for (int i3 = i;; i3 = j)
    {
      i4 = (int)(300.0F * (1.0F + i3 / i1));
      break;
    }
  }
  
  private void disableRunOnAnimationRequests()
  {
    this.mReSchedulePostAnimationCallback = false;
    this.mEatRunOnAnimationRequest = true;
  }
  
  private float distanceInfluenceForSnapDuration(float paramFloat)
  {
    return (float)Math.sin((float)(0.47123891676382D * (paramFloat - 0.5F)));
  }
  
  private void enableRunOnAnimationRequests()
  {
    this.mEatRunOnAnimationRequest = false;
    if (this.mReSchedulePostAnimationCallback) {
      postOnAnimation();
    }
  }
  
  public void fling(int paramInt1, int paramInt2)
  {
    RecyclerView.access$3100(this.this$0, 2);
    this.mLastFlingY = 0;
    this.mLastFlingX = 0;
    this.mScroller.fling(0, 0, paramInt1, paramInt2, -2147483648, 2147483647, -2147483648, 2147483647);
    postOnAnimation();
  }
  
  void postOnAnimation()
  {
    if (this.mEatRunOnAnimationRequest) {
      this.mReSchedulePostAnimationCallback = true;
    }
    for (;;)
    {
      return;
      ViewCompat.postOnAnimation(this.this$0, this);
    }
  }
  
  public void run()
  {
    disableRunOnAnimationRequests();
    RecyclerView.access$2100(this.this$0);
    ScrollerCompat localScrollerCompat = this.mScroller;
    RecyclerView.SmoothScroller localSmoothScroller = RecyclerView.access$1100(this.this$0).mSmoothScroller;
    int i;
    int j;
    int k;
    int m;
    int i2;
    int i3;
    label349:
    int i12;
    int i4;
    int i5;
    int i6;
    int i7;
    int i8;
    label444:
    int i9;
    int i11;
    if (localScrollerCompat.computeScrollOffset())
    {
      i = localScrollerCompat.getCurrX();
      j = localScrollerCompat.getCurrY();
      k = i - this.mLastFlingX;
      m = j - this.mLastFlingY;
      int n = 0;
      int i1 = 0;
      this.mLastFlingX = i;
      this.mLastFlingY = j;
      i2 = 0;
      i3 = 0;
      if (RecyclerView.access$2200(this.this$0) != null)
      {
        this.this$0.eatRequestLayout();
        RecyclerView.access$2302(this.this$0, true);
        if (k != 0)
        {
          n = RecyclerView.access$1100(this.this$0).scrollHorizontallyBy(k, this.this$0.mRecycler, this.this$0.mState);
          i2 = k - n;
        }
        if (m != 0)
        {
          i1 = RecyclerView.access$1100(this.this$0).scrollVerticallyBy(m, this.this$0.mRecycler, this.this$0.mState);
          i3 = m - i1;
        }
        if (RecyclerView.access$2400(this.this$0))
        {
          int i13 = this.this$0.mChildHelper.getChildCount();
          int i14 = 0;
          if (i14 < i13)
          {
            View localView1 = this.this$0.mChildHelper.getChildAt(i14);
            RecyclerView.ViewHolder localViewHolder = this.this$0.getChildViewHolder(localView1);
            if ((localViewHolder != null) && (localViewHolder.mShadowingHolder != null)) {
              if (localViewHolder.mShadowingHolder == null) {
                break label349;
              }
            }
            for (View localView2 = localViewHolder.mShadowingHolder.itemView;; localView2 = null)
            {
              if (localView2 != null)
              {
                int i15 = localView1.getLeft();
                int i16 = localView1.getTop();
                if ((i15 != localView2.getLeft()) || (i16 != localView2.getTop())) {
                  localView2.layout(i15, i16, i15 + localView2.getWidth(), i16 + localView2.getHeight());
                }
              }
              i14++;
              break;
            }
          }
        }
        if ((localSmoothScroller != null) && (!localSmoothScroller.isPendingInitialRun()) && (localSmoothScroller.isRunning()))
        {
          i12 = this.this$0.mState.getItemCount();
          if (i12 != 0) {
            break label711;
          }
          localSmoothScroller.stop();
        }
        RecyclerView.access$2302(this.this$0, false);
        this.this$0.resumeRequestLayout(false);
      }
      i4 = i3;
      i5 = i2;
      i6 = i1;
      i7 = n;
      if ((k != i7) || (m != i6)) {
        break label762;
      }
      i8 = 1;
      if (!RecyclerView.access$2600(this.this$0).isEmpty()) {
        this.this$0.invalidate();
      }
      if (ViewCompat.getOverScrollMode(this.this$0) != 2) {
        RecyclerView.access$2700(this.this$0, k, m);
      }
      if ((i5 != 0) || (i4 != 0))
      {
        i9 = (int)localScrollerCompat.getCurrVelocity();
        if (i5 == i) {
          break label810;
        }
        if (i5 >= 0) {
          break label768;
        }
        i11 = -i9;
      }
    }
    label519:
    label540:
    label810:
    for (int i10 = i11;; i10 = 0)
    {
      if (i4 != j) {
        if (i4 < 0) {
          i9 = -i9;
        }
      }
      for (;;)
      {
        if (ViewCompat.getOverScrollMode(this.this$0) != 2) {
          this.this$0.absorbGlows(i10, i9);
        }
        if (((i10 != 0) || (i5 == i) || (localScrollerCompat.getFinalX() == 0)) && ((i9 != 0) || (i4 == j) || (localScrollerCompat.getFinalY() == 0))) {
          localScrollerCompat.abortAnimation();
        }
        if ((i7 != 0) || (i6 != 0))
        {
          RecyclerView.access$2800(this.this$0, 0, 0, 0, 0);
          if (RecyclerView.access$2900(this.this$0) != null) {
            RecyclerView.access$2900(this.this$0).onScrolled(this.this$0, i7, i6);
          }
        }
        if (!RecyclerView.access$3000(this.this$0)) {
          this.this$0.invalidate();
        }
        if ((localScrollerCompat.isFinished()) || (i8 == 0)) {
          RecyclerView.access$3100(this.this$0, 0);
        }
        for (;;)
        {
          if ((localSmoothScroller != null) && (localSmoothScroller.isPendingInitialRun())) {
            RecyclerView.SmoothScroller.access$2500(localSmoothScroller, 0, 0);
          }
          enableRunOnAnimationRequests();
          return;
          label711:
          if (localSmoothScroller.getTargetPosition() >= i12)
          {
            localSmoothScroller.setTargetPosition(i12 - 1);
            RecyclerView.SmoothScroller.access$2500(localSmoothScroller, k - i2, m - i3);
            break;
          }
          RecyclerView.SmoothScroller.access$2500(localSmoothScroller, k - i2, m - i3);
          break;
          label762:
          i8 = 0;
          break label444;
          if (i5 > 0)
          {
            i11 = i9;
            break label519;
          }
          i11 = 0;
          break label519;
          if (i4 > 0) {
            break label540;
          }
          i9 = 0;
          break label540;
          postOnAnimation();
        }
        i9 = 0;
      }
    }
  }
  
  public void smoothScrollBy(int paramInt1, int paramInt2)
  {
    smoothScrollBy(paramInt1, paramInt2, 0, 0);
  }
  
  public void smoothScrollBy(int paramInt1, int paramInt2, int paramInt3)
  {
    smoothScrollBy(paramInt1, paramInt2, paramInt3, RecyclerView.access$2000());
  }
  
  public void smoothScrollBy(int paramInt1, int paramInt2, int paramInt3, int paramInt4)
  {
    smoothScrollBy(paramInt1, paramInt2, computeScrollDuration(paramInt1, paramInt2, paramInt3, paramInt4));
  }
  
  public void smoothScrollBy(int paramInt1, int paramInt2, int paramInt3, Interpolator paramInterpolator)
  {
    if (this.mInterpolator != paramInterpolator)
    {
      this.mInterpolator = paramInterpolator;
      this.mScroller = ScrollerCompat.create(this.this$0.getContext(), paramInterpolator);
    }
    RecyclerView.access$3100(this.this$0, 2);
    this.mLastFlingY = 0;
    this.mLastFlingX = 0;
    this.mScroller.startScroll(0, 0, paramInt1, paramInt2, paramInt3);
    postOnAnimation();
  }
  
  public void stop()
  {
    this.this$0.removeCallbacks(this);
    this.mScroller.abortAnimation();
  }
}


/* Location:           C:\Users\dreadiscool\Desktop\tools\classes-dex2jar.jar
 * Qualified Name:     android.support.v7.widget.RecyclerView.ViewFlinger
 * JD-Core Version:    0.7.0.1
 */