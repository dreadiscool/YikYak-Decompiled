import android.view.ScaleGestureDetector;
import android.view.ScaleGestureDetector.OnScaleGestureListener;

class HK
  implements ScaleGestureDetector.OnScaleGestureListener
{
  HK(HJ paramHJ) {}
  
  public boolean onScale(ScaleGestureDetector paramScaleGestureDetector)
  {
    float f = paramScaleGestureDetector.getScaleFactor();
    if ((Float.isNaN(f)) || (Float.isInfinite(f))) {}
    for (boolean bool = false;; bool = true)
    {
      return bool;
      this.a.a.a(f, paramScaleGestureDetector.getFocusX(), paramScaleGestureDetector.getFocusY());
    }
  }
  
  public boolean onScaleBegin(ScaleGestureDetector paramScaleGestureDetector)
  {
    return true;
  }
  
  public void onScaleEnd(ScaleGestureDetector paramScaleGestureDetector) {}
}


/* Location:           C:\Users\dreadiscool\Desktop\tools\classes-dex2jar.jar
 * Qualified Name:     HK
 * JD-Core Version:    0.7.0.1
 */