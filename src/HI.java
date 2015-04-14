import android.annotation.TargetApi;
import android.content.Context;
import android.view.MotionEvent;

@TargetApi(5)
public class HI
  extends HG
{
  private int f = -1;
  private int g = 0;
  
  public HI(Context paramContext)
  {
    super(paramContext);
  }
  
  float a(MotionEvent paramMotionEvent)
  {
    try
    {
      float f2 = paramMotionEvent.getX(this.g);
      f1 = f2;
    }
    catch (Exception localException)
    {
      for (;;)
      {
        float f1 = paramMotionEvent.getX();
      }
    }
    return f1;
  }
  
  float b(MotionEvent paramMotionEvent)
  {
    try
    {
      float f2 = paramMotionEvent.getY(this.g);
      f1 = f2;
    }
    catch (Exception localException)
    {
      for (;;)
      {
        float f1 = paramMotionEvent.getY();
      }
    }
    return f1;
  }
  
  public boolean c(MotionEvent paramMotionEvent)
  {
    int i = 0;
    switch (0xFF & paramMotionEvent.getAction())
    {
    }
    int j;
    do
    {
      for (;;)
      {
        if (this.f != -1) {
          i = this.f;
        }
        this.g = paramMotionEvent.findPointerIndex(i);
        return super.c(paramMotionEvent);
        this.f = paramMotionEvent.getPointerId(0);
        continue;
        this.f = -1;
      }
      j = HF.a(paramMotionEvent.getAction());
    } while (paramMotionEvent.getPointerId(j) != this.f);
    if (j == 0) {}
    for (int k = 1;; k = 0)
    {
      this.f = paramMotionEvent.getPointerId(k);
      this.b = paramMotionEvent.getX(k);
      this.c = paramMotionEvent.getY(k);
      break;
    }
  }
}


/* Location:           C:\Users\dreadiscool\Desktop\tools\classes-dex2jar.jar
 * Qualified Name:     HI
 * JD-Core Version:    0.7.0.1
 */