import android.view.View;

public class ca
  extends bv
{
  public void a(View paramView)
  {
    xj localxj = c();
    xg[] arrayOfxg = new xg[2];
    float[] arrayOfFloat1 = new float[4];
    arrayOfFloat1[0] = 90.0F;
    arrayOfFloat1[1] = -15.0F;
    arrayOfFloat1[2] = 15.0F;
    arrayOfFloat1[3] = 0.0F;
    arrayOfxg[0] = xw.a(paramView, "rotationX", arrayOfFloat1);
    float[] arrayOfFloat2 = new float[4];
    arrayOfFloat2[0] = 0.25F;
    arrayOfFloat2[1] = 0.5F;
    arrayOfFloat2[2] = 0.75F;
    arrayOfFloat2[3] = 1.0F;
    arrayOfxg[1] = xw.a(paramView, "alpha", arrayOfFloat2);
    localxj.a(arrayOfxg);
  }
}


/* Location:           C:\Users\dreadiscool\Desktop\tools\classes-dex2jar.jar
 * Qualified Name:     ca
 * JD-Core Version:    0.7.0.1
 */