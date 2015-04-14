import android.view.View;

public class cG
  extends bv
{
  protected void a(View paramView)
  {
    xj localxj = c();
    xg[] arrayOfxg = new xg[3];
    float[] arrayOfFloat1 = new float[3];
    arrayOfFloat1[0] = 1.0F;
    arrayOfFloat1[1] = 0.0F;
    arrayOfFloat1[2] = 0.0F;
    arrayOfxg[0] = xw.a(paramView, "alpha", arrayOfFloat1);
    float[] arrayOfFloat2 = new float[3];
    arrayOfFloat2[0] = 1.0F;
    arrayOfFloat2[1] = 0.3F;
    arrayOfFloat2[2] = 0.0F;
    arrayOfxg[1] = xw.a(paramView, "scaleX", arrayOfFloat2);
    float[] arrayOfFloat3 = new float[3];
    arrayOfFloat3[0] = 1.0F;
    arrayOfFloat3[1] = 0.3F;
    arrayOfFloat3[2] = 0.0F;
    arrayOfxg[2] = xw.a(paramView, "scaleY", arrayOfFloat3);
    localxj.a(arrayOfxg);
  }
}


/* Location:           C:\Users\dreadiscool\Desktop\tools\classes-dex2jar.jar
 * Qualified Name:     cG
 * JD-Core Version:    0.7.0.1
 */