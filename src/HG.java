import android.content.Context;
import android.util.FloatMath;
import android.view.MotionEvent;
import android.view.VelocityTracker;
import android.view.ViewConfiguration;

public class HG
  implements HL
{
  protected HS a;
  float b;
  float c;
  final float d;
  final float e;
  private VelocityTracker f;
  private boolean g;
  
  public HG(Context paramContext)
  {
    ViewConfiguration localViewConfiguration = ViewConfiguration.get(paramContext);
    this.e = localViewConfiguration.getScaledMinimumFlingVelocity();
    this.d = localViewConfiguration.getScaledTouchSlop();
  }
  
  float a(MotionEvent paramMotionEvent)
  {
    return paramMotionEvent.getX();
  }
  
  public void a(HS paramHS)
  {
    this.a = paramHS;
  }
  
  public boolean a()
  {
    return false;
  }
  
  float b(MotionEvent paramMotionEvent)
  {
    return paramMotionEvent.getY();
  }
  
  public boolean c(MotionEvent paramMotionEvent)
  {
    boolean bool = false;
    switch (paramMotionEvent.getAction())
    {
    }
    for (;;)
    {
      return true;
      this.f = VelocityTracker.obtain();
      if (this.f != null) {
        this.f.addMovement(paramMotionEvent);
      }
      this.b = a(paramMotionEvent);
      this.c = b(paramMotionEvent);
      this.g = false;
      continue;
      float f3 = a(paramMotionEvent);
      float f4 = b(paramMotionEvent);
      float f5 = f3 - this.b;
      float f6 = f4 - this.c;
      if (!this.g)
      {
        if (FloatMath.sqrt(f5 * f5 + f6 * f6) >= this.d) {
          bool = true;
        }
        this.g = bool;
      }
      if (this.g)
      {
        this.a.a(f5, f6);
        this.b = f3;
        this.c = f4;
        if (this.f != null)
        {
          this.f.addMovement(paramMotionEvent);
          continue;
          if (this.f != null)
          {
            this.f.recycle();
            this.f = null;
            continue;
            if ((this.g) && (this.f != null))
            {
              this.b = a(paramMotionEvent);
              this.c = b(paramMotionEvent);
              this.f.addMovement(paramMotionEvent);
              this.f.computeCurrentVelocity(1000);
              float f1 = this.f.getXVelocity();
              float f2 = this.f.getYVelocity();
              if (Math.max(Math.abs(f1), Math.abs(f2)) >= this.e) {
                this.a.a(this.b, this.c, -f1, -f2);
              }
            }
            if (this.f != null)
            {
              this.f.recycle();
              this.f = null;
            }
          }
        }
      }
    }
  }
}


/* Location:           C:\Users\dreadiscool\Desktop\tools\classes-dex2jar.jar
 * Qualified Name:     HG
 * JD-Core Version:    0.7.0.1
 */