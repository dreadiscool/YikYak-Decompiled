import android.graphics.RectF;
import android.view.GestureDetector.OnDoubleTapListener;
import android.view.MotionEvent;

public class HH
  implements GestureDetector.OnDoubleTapListener
{
  private HT a;
  
  public HH(HT paramHT)
  {
    a(paramHT);
  }
  
  public void a(HT paramHT)
  {
    this.a = paramHT;
  }
  
  public boolean onDoubleTap(MotionEvent paramMotionEvent)
  {
    boolean bool = true;
    if (this.a == null) {
      bool = false;
    }
    for (;;)
    {
      return bool;
      try
      {
        float f1 = this.a.g();
        float f2 = paramMotionEvent.getX();
        float f3 = paramMotionEvent.getY();
        if (f1 < this.a.e()) {
          this.a.a(this.a.f(), f2, f3, true);
        } else if ((f1 >= this.a.e()) && (f1 < this.a.f())) {
          this.a.a(this.a.f(), f2, f3, true);
        } else {
          this.a.a(this.a.d(), f2, f3, true);
        }
      }
      catch (ArrayIndexOutOfBoundsException localArrayIndexOutOfBoundsException) {}
    }
  }
  
  public boolean onDoubleTapEvent(MotionEvent paramMotionEvent)
  {
    return false;
  }
  
  public boolean onSingleTapConfirmed(MotionEvent paramMotionEvent)
  {
    boolean bool = false;
    if (this.a == null) {}
    for (;;)
    {
      return bool;
      this.a.c();
      if (this.a.i() != null)
      {
        RectF localRectF = this.a.b();
        if ((localRectF != null) && (localRectF.contains(paramMotionEvent.getX(), paramMotionEvent.getY())))
        {
          localRectF.width();
          localRectF.height();
          this.a.i();
          bool = true;
          continue;
        }
      }
      if (this.a.j() != null)
      {
        this.a.j();
        paramMotionEvent.getX();
        paramMotionEvent.getY();
      }
    }
  }
}


/* Location:           C:\Users\dreadiscool\Desktop\tools\classes-dex2jar.jar
 * Qualified Name:     HH
 * JD-Core Version:    0.7.0.1
 */