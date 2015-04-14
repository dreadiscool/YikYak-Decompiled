import android.graphics.Matrix;
import android.view.animation.Interpolator;
import android.widget.ImageView;

class HW
  implements Runnable
{
  private final float b;
  private final float c;
  private final long d;
  private final float e;
  private final float f;
  
  public HW(HT paramHT, float paramFloat1, float paramFloat2, float paramFloat3, float paramFloat4)
  {
    this.b = paramFloat3;
    this.c = paramFloat4;
    this.d = System.currentTimeMillis();
    this.e = paramFloat1;
    this.f = paramFloat2;
  }
  
  private float a()
  {
    float f1 = Math.min(1.0F, 1.0F * (float)(System.currentTimeMillis() - this.d) / this.a.b);
    return HT.a.getInterpolation(f1);
  }
  
  public void run()
  {
    ImageView localImageView = this.a.c();
    if (localImageView == null) {}
    for (;;)
    {
      return;
      float f1 = a();
      float f2 = (this.e + f1 * (this.f - this.e)) / this.a.g();
      HT.b(this.a).postScale(f2, f2, this.b, this.c);
      HT.c(this.a);
      if (f1 < 1.0F) {
        HF.a(localImageView, this);
      }
    }
  }
}


/* Location:           C:\Users\dreadiscool\Desktop\tools\classes-dex2jar.jar
 * Qualified Name:     HW
 * JD-Core Version:    0.7.0.1
 */