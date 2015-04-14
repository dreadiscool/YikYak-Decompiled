import android.view.GestureDetector.SimpleOnGestureListener;
import android.view.MotionEvent;
import android.view.View.OnLongClickListener;

class HU
  extends GestureDetector.SimpleOnGestureListener
{
  HU(HT paramHT) {}
  
  public void onLongPress(MotionEvent paramMotionEvent)
  {
    if (HT.a(this.a) != null) {
      HT.a(this.a).onLongClick(this.a.c());
    }
  }
}


/* Location:           C:\Users\dreadiscool\Desktop\tools\classes-dex2jar.jar
 * Qualified Name:     HU
 * JD-Core Version:    0.7.0.1
 */