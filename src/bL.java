import android.view.View;

public class bL
  extends bv
{
  public void a(View paramView)
  {
    xj localxj = c();
    xg[] arrayOfxg = new xg[3];
    float[] arrayOfFloat1 = new float[4];
    arrayOfFloat1[0] = 0.0F;
    arrayOfFloat1[1] = 1.0F;
    arrayOfFloat1[2] = 1.0F;
    arrayOfFloat1[3] = 1.0F;
    arrayOfxg[0] = xw.a(paramView, "alpha", arrayOfFloat1);
    float[] arrayOfFloat2 = new float[4];
    arrayOfFloat2[0] = 0.3F;
    arrayOfFloat2[1] = 1.05F;
    arrayOfFloat2[2] = 0.9F;
    arrayOfFloat2[3] = 1.0F;
    arrayOfxg[1] = xw.a(paramView, "scaleX", arrayOfFloat2);
    float[] arrayOfFloat3 = new float[4];
    arrayOfFloat3[0] = 0.3F;
    arrayOfFloat3[1] = 1.05F;
    arrayOfFloat3[2] = 0.9F;
    arrayOfFloat3[3] = 1.0F;
    arrayOfxg[2] = xw.a(paramView, "scaleY", arrayOfFloat3);
    localxj.a(arrayOfxg);
  }
}


/* Location:           C:\Users\dreadiscool\Desktop\tools\classes-dex2jar.jar
 * Qualified Name:     bL
 * JD-Core Version:    0.7.0.1
 */