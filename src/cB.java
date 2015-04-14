import android.view.View;

public class cB
  extends bv
{
  public void a(View paramView)
  {
    xj localxj = c();
    xg[] arrayOfxg = new xg[3];
    float[] arrayOfFloat1 = new float[2];
    arrayOfFloat1[0] = 0.45F;
    arrayOfFloat1[1] = 1.0F;
    arrayOfxg[0] = xw.a(paramView, "scaleX", arrayOfFloat1);
    float[] arrayOfFloat2 = new float[2];
    arrayOfFloat2[0] = 0.45F;
    arrayOfFloat2[1] = 1.0F;
    arrayOfxg[1] = xw.a(paramView, "scaleY", arrayOfFloat2);
    float[] arrayOfFloat3 = new float[2];
    arrayOfFloat3[0] = 0.0F;
    arrayOfFloat3[1] = 1.0F;
    arrayOfxg[2] = xw.a(paramView, "alpha", arrayOfFloat3);
    localxj.a(arrayOfxg);
  }
}


/* Location:           C:\Users\dreadiscool\Desktop\tools\classes-dex2jar.jar
 * Qualified Name:     cB
 * JD-Core Version:    0.7.0.1
 */