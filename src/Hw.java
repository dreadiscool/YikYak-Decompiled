import android.graphics.drawable.AnimationDrawable;
import android.graphics.drawable.BitmapDrawable;

public class Hw
  extends Hx
{
  private AnimationDrawable m;
  private int n;
  
  public Hw(AnimationDrawable paramAnimationDrawable)
  {
    this.m = paramAnimationDrawable;
    this.k = ((BitmapDrawable)this.m.getFrame(0)).getBitmap();
    this.n = 0;
    for (int i = 0; i < this.m.getNumberOfFrames(); i++) {
      this.n += this.m.getDuration(i);
    }
  }
  
  public boolean a(long paramLong)
  {
    int i = 0;
    int k = super.a(paramLong);
    long l1;
    long l2;
    if (k != 0)
    {
      l1 = 0L;
      l2 = paramLong - this.l;
      if (l2 > this.n)
      {
        if (this.m.isOneShot()) {
          return i;
        }
        l2 %= this.n;
      }
    }
    for (;;)
    {
      if (i < this.m.getNumberOfFrames())
      {
        l1 += this.m.getDuration(i);
        if (l1 > l2) {
          this.k = ((BitmapDrawable)this.m.getFrame(i)).getBitmap();
        }
      }
      else
      {
        i = k;
        break;
      }
      int j;
      i += 1;
    }
  }
}


/* Location:           C:\Users\dreadiscool\Desktop\tools\classes-dex2jar.jar
 * Qualified Name:     Hw
 * JD-Core Version:    0.7.0.1
 */