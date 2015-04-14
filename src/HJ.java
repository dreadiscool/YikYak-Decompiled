import android.annotation.TargetApi;
import android.content.Context;
import android.view.MotionEvent;
import android.view.ScaleGestureDetector;

@TargetApi(8)
public class HJ
  extends HI
{
  protected final ScaleGestureDetector f = new ScaleGestureDetector(paramContext, new HK(this));
  
  public HJ(Context paramContext)
  {
    super(paramContext);
  }
  
  public boolean a()
  {
    return this.f.isInProgress();
  }
  
  public boolean c(MotionEvent paramMotionEvent)
  {
    this.f.onTouchEvent(paramMotionEvent);
    return super.c(paramMotionEvent);
  }
}


/* Location:           C:\Users\dreadiscool\Desktop\tools\classes-dex2jar.jar
 * Qualified Name:     HJ
 * JD-Core Version:    0.7.0.1
 */