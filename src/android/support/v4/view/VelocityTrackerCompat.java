package android.support.v4.view;

import android.os.Build.VERSION;
import android.view.VelocityTracker;

public class VelocityTrackerCompat
{
  static final VelocityTrackerCompat.VelocityTrackerVersionImpl IMPL;
  
  static
  {
    if (Build.VERSION.SDK_INT >= 11) {}
    for (IMPL = new VelocityTrackerCompat.HoneycombVelocityTrackerVersionImpl();; IMPL = new VelocityTrackerCompat.BaseVelocityTrackerVersionImpl()) {
      return;
    }
  }
  
  public static float getXVelocity(VelocityTracker paramVelocityTracker, int paramInt)
  {
    return IMPL.getXVelocity(paramVelocityTracker, paramInt);
  }
  
  public static float getYVelocity(VelocityTracker paramVelocityTracker, int paramInt)
  {
    return IMPL.getYVelocity(paramVelocityTracker, paramInt);
  }
}


/* Location:           C:\Users\dreadiscool\Desktop\tools\classes-dex2jar.jar
 * Qualified Name:     android.support.v4.view.VelocityTrackerCompat
 * JD-Core Version:    0.7.0.1
 */