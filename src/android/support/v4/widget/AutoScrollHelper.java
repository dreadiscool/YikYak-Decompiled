package android.support.v4.widget;

import android.content.res.Resources;
import android.os.SystemClock;
import android.support.v4.view.MotionEventCompat;
import android.support.v4.view.ViewCompat;
import android.util.DisplayMetrics;
import android.view.MotionEvent;
import android.view.View;
import android.view.View.OnTouchListener;
import android.view.ViewConfiguration;
import android.view.animation.AccelerateInterpolator;
import android.view.animation.Interpolator;

public abstract class AutoScrollHelper
  implements View.OnTouchListener
{
  private static final int DEFAULT_ACTIVATION_DELAY = ;
  private static final int DEFAULT_EDGE_TYPE = 1;
  private static final float DEFAULT_MAXIMUM_EDGE = 3.4028235E+38F;
  private static final int DEFAULT_MAXIMUM_VELOCITY_DIPS = 1575;
  private static final int DEFAULT_MINIMUM_VELOCITY_DIPS = 315;
  private static final int DEFAULT_RAMP_DOWN_DURATION = 500;
  private static final int DEFAULT_RAMP_UP_DURATION = 500;
  private static final float DEFAULT_RELATIVE_EDGE = 0.2F;
  private static final float DEFAULT_RELATIVE_VELOCITY = 1.0F;
  public static final int EDGE_TYPE_INSIDE = 0;
  public static final int EDGE_TYPE_INSIDE_EXTEND = 1;
  public static final int EDGE_TYPE_OUTSIDE = 2;
  private static final int HORIZONTAL = 0;
  public static final float NO_MAX = 3.4028235E+38F;
  public static final float NO_MIN = 0.0F;
  public static final float RELATIVE_UNSPECIFIED = 0.0F;
  private static final int VERTICAL = 1;
  private int mActivationDelay;
  private boolean mAlreadyDelayed;
  private boolean mAnimating;
  private final Interpolator mEdgeInterpolator = new AccelerateInterpolator();
  private int mEdgeType;
  private boolean mEnabled;
  private boolean mExclusive;
  private float[] mMaximumEdges;
  private float[] mMaximumVelocity;
  private float[] mMinimumVelocity;
  private boolean mNeedsCancel;
  private boolean mNeedsReset;
  private float[] mRelativeEdges;
  private float[] mRelativeVelocity;
  private Runnable mRunnable;
  private final AutoScrollHelper.ClampedScroller mScroller = new AutoScrollHelper.ClampedScroller();
  private final View mTarget;
  
  public AutoScrollHelper(View paramView)
  {
    float[] arrayOfFloat1 = new float[2];
    arrayOfFloat1[0] = 0.0F;
    arrayOfFloat1[1] = 0.0F;
    this.mRelativeEdges = arrayOfFloat1;
    float[] arrayOfFloat2 = new float[2];
    arrayOfFloat2[0] = 3.4028235E+38F;
    arrayOfFloat2[1] = 3.4028235E+38F;
    this.mMaximumEdges = arrayOfFloat2;
    float[] arrayOfFloat3 = new float[2];
    arrayOfFloat3[0] = 0.0F;
    arrayOfFloat3[1] = 0.0F;
    this.mRelativeVelocity = arrayOfFloat3;
    float[] arrayOfFloat4 = new float[2];
    arrayOfFloat4[0] = 0.0F;
    arrayOfFloat4[1] = 0.0F;
    this.mMinimumVelocity = arrayOfFloat4;
    float[] arrayOfFloat5 = new float[2];
    arrayOfFloat5[0] = 3.4028235E+38F;
    arrayOfFloat5[1] = 3.4028235E+38F;
    this.mMaximumVelocity = arrayOfFloat5;
    this.mTarget = paramView;
    DisplayMetrics localDisplayMetrics = Resources.getSystem().getDisplayMetrics();
    int i = (int)(0.5F + 1575.0F * localDisplayMetrics.density);
    int j = (int)(0.5F + 315.0F * localDisplayMetrics.density);
    setMaximumVelocity(i, i);
    setMinimumVelocity(j, j);
    setEdgeType(1);
    setMaximumEdges(3.4028235E+38F, 3.4028235E+38F);
    setRelativeEdges(0.2F, 0.2F);
    setRelativeVelocity(1.0F, 1.0F);
    setActivationDelay(DEFAULT_ACTIVATION_DELAY);
    setRampUpDuration(500);
    setRampDownDuration(500);
  }
  
  private void cancelTargetTouch()
  {
    long l = SystemClock.uptimeMillis();
    MotionEvent localMotionEvent = MotionEvent.obtain(l, l, 3, 0.0F, 0.0F, 0);
    this.mTarget.onTouchEvent(localMotionEvent);
    localMotionEvent.recycle();
  }
  
  private float computeTargetVelocity(int paramInt, float paramFloat1, float paramFloat2, float paramFloat3)
  {
    float f1 = 0.0F;
    float f2 = getEdgeValue(this.mRelativeEdges[paramInt], paramFloat2, this.mMaximumEdges[paramInt], paramFloat1);
    if (f2 == 0.0F) {}
    for (;;)
    {
      return f1;
      float f3 = this.mRelativeVelocity[paramInt];
      float f4 = this.mMinimumVelocity[paramInt];
      float f5 = this.mMaximumVelocity[paramInt];
      float f6 = f3 * paramFloat3;
      if (f2 > 0.0F) {
        f1 = constrain(f2 * f6, f4, f5);
      } else {
        f1 = -constrain(f6 * -f2, f4, f5);
      }
    }
  }
  
  private static float constrain(float paramFloat1, float paramFloat2, float paramFloat3)
  {
    if (paramFloat1 > paramFloat3) {}
    for (;;)
    {
      return paramFloat3;
      if (paramFloat1 < paramFloat2) {
        paramFloat3 = paramFloat2;
      } else {
        paramFloat3 = paramFloat1;
      }
    }
  }
  
  private static int constrain(int paramInt1, int paramInt2, int paramInt3)
  {
    if (paramInt1 > paramInt3) {}
    for (;;)
    {
      return paramInt3;
      if (paramInt1 < paramInt2) {
        paramInt3 = paramInt2;
      } else {
        paramInt3 = paramInt1;
      }
    }
  }
  
  private float constrainEdgeValue(float paramFloat1, float paramFloat2)
  {
    float f = 0.0F;
    if (paramFloat2 == 0.0F) {}
    for (;;)
    {
      return f;
      switch (this.mEdgeType)
      {
      default: 
        break;
      case 0: 
      case 1: 
        if (paramFloat1 < paramFloat2) {
          if (paramFloat1 >= 0.0F) {
            f = 1.0F - paramFloat1 / paramFloat2;
          } else if ((this.mAnimating) && (this.mEdgeType == 1)) {
            f = 1.0F;
          }
        }
        break;
      case 2: 
        if (paramFloat1 < 0.0F) {
          f = paramFloat1 / -paramFloat2;
        }
        break;
      }
    }
  }
  
  private float getEdgeValue(float paramFloat1, float paramFloat2, float paramFloat3, float paramFloat4)
  {
    float f1 = 0.0F;
    float f2 = constrain(paramFloat1 * paramFloat2, 0.0F, paramFloat3);
    float f3 = constrainEdgeValue(paramFloat4, f2);
    float f4 = constrainEdgeValue(paramFloat2 - paramFloat4, f2) - f3;
    if (f4 < 0.0F) {}
    for (float f5 = -this.mEdgeInterpolator.getInterpolation(-f4);; f5 = this.mEdgeInterpolator.getInterpolation(f4))
    {
      f1 = constrain(f5, -1.0F, 1.0F);
      do
      {
        return f1;
      } while (f4 <= 0.0F);
    }
  }
  
  private void requestStop()
  {
    if (this.mNeedsReset) {
      this.mAnimating = false;
    }
    for (;;)
    {
      return;
      this.mScroller.requestStop();
    }
  }
  
  private boolean shouldAnimate()
  {
    AutoScrollHelper.ClampedScroller localClampedScroller = this.mScroller;
    int i = localClampedScroller.getVerticalDirection();
    int j = localClampedScroller.getHorizontalDirection();
    if (((i != 0) && (canTargetScrollVertically(i))) || ((j != 0) && (canTargetScrollHorizontally(j)))) {}
    for (boolean bool = true;; bool = false) {
      return bool;
    }
  }
  
  private void startAnimating()
  {
    if (this.mRunnable == null) {
      this.mRunnable = new AutoScrollHelper.ScrollAnimationRunnable(this, null);
    }
    this.mAnimating = true;
    this.mNeedsReset = true;
    if ((!this.mAlreadyDelayed) && (this.mActivationDelay > 0)) {
      ViewCompat.postOnAnimationDelayed(this.mTarget, this.mRunnable, this.mActivationDelay);
    }
    for (;;)
    {
      this.mAlreadyDelayed = true;
      return;
      this.mRunnable.run();
    }
  }
  
  public abstract boolean canTargetScrollHorizontally(int paramInt);
  
  public abstract boolean canTargetScrollVertically(int paramInt);
  
  public boolean isEnabled()
  {
    return this.mEnabled;
  }
  
  public boolean isExclusive()
  {
    return this.mExclusive;
  }
  
  public boolean onTouch(View paramView, MotionEvent paramMotionEvent)
  {
    int i = 1;
    boolean bool = false;
    if (!this.mEnabled) {
      return bool;
    }
    switch (MotionEventCompat.getActionMasked(paramMotionEvent))
    {
    default: 
      label48:
      if ((!this.mExclusive) || (!this.mAnimating)) {
        break;
      }
    }
    for (;;)
    {
      bool = i;
      break;
      this.mNeedsCancel = i;
      this.mAlreadyDelayed = false;
      float f1 = computeTargetVelocity(0, paramMotionEvent.getX(), paramView.getWidth(), this.mTarget.getWidth());
      float f2 = computeTargetVelocity(i, paramMotionEvent.getY(), paramView.getHeight(), this.mTarget.getHeight());
      this.mScroller.setTargetVelocity(f1, f2);
      if ((this.mAnimating) || (!shouldAnimate())) {
        break label48;
      }
      startAnimating();
      break label48;
      requestStop();
      break label48;
      i = 0;
    }
  }
  
  public abstract void scrollTargetBy(int paramInt1, int paramInt2);
  
  public AutoScrollHelper setActivationDelay(int paramInt)
  {
    this.mActivationDelay = paramInt;
    return this;
  }
  
  public AutoScrollHelper setEdgeType(int paramInt)
  {
    this.mEdgeType = paramInt;
    return this;
  }
  
  public AutoScrollHelper setEnabled(boolean paramBoolean)
  {
    if ((this.mEnabled) && (!paramBoolean)) {
      requestStop();
    }
    this.mEnabled = paramBoolean;
    return this;
  }
  
  public AutoScrollHelper setExclusive(boolean paramBoolean)
  {
    this.mExclusive = paramBoolean;
    return this;
  }
  
  public AutoScrollHelper setMaximumEdges(float paramFloat1, float paramFloat2)
  {
    this.mMaximumEdges[0] = paramFloat1;
    this.mMaximumEdges[1] = paramFloat2;
    return this;
  }
  
  public AutoScrollHelper setMaximumVelocity(float paramFloat1, float paramFloat2)
  {
    this.mMaximumVelocity[0] = (paramFloat1 / 1000.0F);
    this.mMaximumVelocity[1] = (paramFloat2 / 1000.0F);
    return this;
  }
  
  public AutoScrollHelper setMinimumVelocity(float paramFloat1, float paramFloat2)
  {
    this.mMinimumVelocity[0] = (paramFloat1 / 1000.0F);
    this.mMinimumVelocity[1] = (paramFloat2 / 1000.0F);
    return this;
  }
  
  public AutoScrollHelper setRampDownDuration(int paramInt)
  {
    this.mScroller.setRampDownDuration(paramInt);
    return this;
  }
  
  public AutoScrollHelper setRampUpDuration(int paramInt)
  {
    this.mScroller.setRampUpDuration(paramInt);
    return this;
  }
  
  public AutoScrollHelper setRelativeEdges(float paramFloat1, float paramFloat2)
  {
    this.mRelativeEdges[0] = paramFloat1;
    this.mRelativeEdges[1] = paramFloat2;
    return this;
  }
  
  public AutoScrollHelper setRelativeVelocity(float paramFloat1, float paramFloat2)
  {
    this.mRelativeVelocity[0] = (paramFloat1 / 1000.0F);
    this.mRelativeVelocity[1] = (paramFloat2 / 1000.0F);
    return this;
  }
}


/* Location:           C:\Users\dreadiscool\Desktop\tools\classes-dex2jar.jar
 * Qualified Name:     android.support.v4.widget.AutoScrollHelper
 * JD-Core Version:    0.7.0.1
 */