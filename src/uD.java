import android.view.animation.Interpolator;

class uD
  implements Interpolator
{
  public uD(uy paramuy) {}
  
  public float getInterpolation(float paramFloat)
  {
    return 1.0F + (float)-(Math.pow(2.718281828459045D, -8.0F * paramFloat) * Math.cos(12.0F * paramFloat));
  }
}


/* Location:           C:\Users\dreadiscool\Desktop\tools\classes-dex2jar.jar
 * Qualified Name:     uD
 * JD-Core Version:    0.7.0.1
 */