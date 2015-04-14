import android.content.Context;
import android.content.res.Resources;
import android.view.MotionEvent;
import android.view.VelocityTracker;
import android.view.View;
import android.view.View.OnTouchListener;
import android.view.ViewConfiguration;
import android.view.ViewParent;
import android.view.ViewPropertyAnimator;

public class yG
  implements View.OnTouchListener
{
  private int a;
  private int b;
  private int c;
  private long d;
  private View e;
  private yI f;
  private int g = 1;
  private float h;
  private float i;
  private boolean j;
  private int k;
  private Object l;
  private VelocityTracker m;
  private float n;
  
  public yG(View paramView, Object paramObject, yI paramyI)
  {
    ViewConfiguration localViewConfiguration = ViewConfiguration.get(paramView.getContext());
    this.a = localViewConfiguration.getScaledTouchSlop();
    this.b = (16 * localViewConfiguration.getScaledMinimumFlingVelocity());
    this.c = localViewConfiguration.getScaledMaximumFlingVelocity();
    this.d = paramView.getContext().getResources().getInteger(17694720);
    this.e = paramView;
    this.l = paramObject;
    this.f = paramyI;
  }
  
  private void a()
  {
    this.f.a(this.e, this.l);
  }
  
  public boolean onTouch(View paramView, MotionEvent paramMotionEvent)
  {
    boolean bool1 = true;
    boolean bool2 = false;
    paramMotionEvent.offsetLocation(this.n, 0.0F);
    if (this.g < 2) {
      this.g = this.e.getWidth();
    }
    float f3;
    float f4;
    float f5;
    float f6;
    boolean bool3;
    switch (paramMotionEvent.getActionMasked())
    {
    default: 
    case 0: 
    case 1: 
      do
      {
        for (;;)
        {
          return bool2;
          this.h = paramMotionEvent.getRawX();
          this.i = paramMotionEvent.getRawY();
          if (this.f.a(this.l))
          {
            this.f.a(bool1);
            this.m = VelocityTracker.obtain();
            this.m.addMovement(paramMotionEvent);
          }
        }
      } while (this.m == null);
      this.f.a(false);
      f3 = paramMotionEvent.getRawX() - this.h;
      this.m.addMovement(paramMotionEvent);
      this.m.computeCurrentVelocity(1000);
      f4 = this.m.getXVelocity();
      f5 = Math.abs(f4);
      f6 = Math.abs(this.m.getYVelocity());
      if ((Math.abs(f3) > this.g / 2) && (this.j)) {
        if (f3 > 0.0F) {
          bool3 = bool1;
        }
      }
      break;
    }
    for (;;)
    {
      label238:
      float f7;
      if (bool1)
      {
        ViewPropertyAnimator localViewPropertyAnimator = this.e.animate();
        if (bool3)
        {
          f7 = this.g;
          label263:
          localViewPropertyAnimator.translationX(f7).alpha(0.0F).setDuration(this.d).setListener(new yH(this));
        }
      }
      for (;;)
      {
        if (this.m != null)
        {
          this.m.recycle();
          this.m = null;
        }
        this.n = 0.0F;
        this.h = 0.0F;
        this.i = 0.0F;
        this.j = false;
        break;
        bool3 = false;
        break label238;
        if ((this.b > f5) || (f5 > this.c) || (f6 >= f5) || (f6 >= f5) || (!this.j)) {
          break label804;
        }
        boolean bool4;
        label396:
        boolean bool5;
        label406:
        boolean bool6;
        if (f4 < 0.0F)
        {
          bool4 = bool1;
          if (f3 >= 0.0F) {
            break label447;
          }
          bool5 = bool1;
          if (bool4 != bool5) {
            break label453;
          }
          bool6 = bool1;
          label416:
          if (this.m.getXVelocity() <= 0.0F) {
            break label459;
          }
        }
        for (;;)
        {
          boolean bool7 = bool1;
          bool1 = bool6;
          bool3 = bool7;
          break;
          bool4 = false;
          break label396;
          label447:
          bool5 = false;
          break label406;
          label453:
          bool6 = false;
          break label416;
          label459:
          bool1 = false;
        }
        f7 = -this.g;
        break label263;
        if (this.j) {
          this.e.animate().translationX(0.0F).alpha(1.0F).setDuration(this.d).setListener(null);
        }
      }
      if (this.m == null) {
        break;
      }
      this.e.animate().translationX(0.0F).alpha(1.0F).setDuration(this.d).setListener(null);
      this.m.recycle();
      this.m = null;
      this.n = 0.0F;
      this.h = 0.0F;
      this.i = 0.0F;
      this.j = false;
      break;
      if (this.m == null) {
        break;
      }
      this.m.addMovement(paramMotionEvent);
      float f1 = paramMotionEvent.getRawX() - this.h;
      float f2 = paramMotionEvent.getRawY() - this.i;
      if ((Math.abs(f1) > this.a) && (Math.abs(f2) < Math.abs(f1) / 2.0F))
      {
        this.j = bool1;
        if (f1 <= 0.0F) {
          break label794;
        }
      }
      label794:
      for (int i1 = this.a;; i1 = -this.a)
      {
        this.k = i1;
        if (this.e.getParent() != null) {
          this.e.getParent().requestDisallowInterceptTouchEvent(bool1);
        }
        MotionEvent localMotionEvent = MotionEvent.obtain(paramMotionEvent);
        localMotionEvent.setAction(0x3 | paramMotionEvent.getActionIndex() << 8);
        this.e.onTouchEvent(localMotionEvent);
        localMotionEvent.recycle();
        if (!this.j) {
          break;
        }
        this.n = f1;
        this.e.setTranslationX(f1 - this.k);
        this.e.setAlpha(Math.max(0.0F, Math.min(1.0F, 1.0F - 2.0F * Math.abs(f1) / this.g)));
        bool2 = bool1;
        break;
      }
      label804:
      bool3 = false;
      bool1 = false;
    }
  }
}


/* Location:           C:\Users\dreadiscool\Desktop\tools\classes-dex2jar.jar
 * Qualified Name:     yG
 * JD-Core Version:    0.7.0.1
 */