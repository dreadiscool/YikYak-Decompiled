import android.view.View;

public class cC
  extends bv
{
  public void a(View paramView)
  {
    xj localxj = c();
    xg[] arrayOfxg = new xg[4];
    float[] arrayOfFloat1 = new float[3];
    arrayOfFloat1[0] = 0.1F;
    arrayOfFloat1[1] = 0.475F;
    arrayOfFloat1[2] = 1.0F;
    arrayOfxg[0] = xw.a(paramView, "scaleX", arrayOfFloat1);
    float[] arrayOfFloat2 = new float[3];
    arrayOfFloat2[0] = 0.1F;
    arrayOfFloat2[1] = 0.475F;
    arrayOfFloat2[2] = 1.0F;
    arrayOfxg[1] = xw.a(paramView, "scaleY", arrayOfFloat2);
    float[] arrayOfFloat3 = new float[3];
    arrayOfFloat3[0] = (-paramView.getBottom());
    arrayOfFloat3[1] = 60.0F;
    arrayOfFloat3[2] = 0.0F;
    arrayOfxg[2] = xw.a(paramView, "translationY", arrayOfFloat3);
    float[] arrayOfFloat4 = new float[3];
    arrayOfFloat4[0] = 0.0F;
    arrayOfFloat4[1] = 1.0F;
    arrayOfFloat4[2] = 1.0F;
    arrayOfxg[3] = xw.a(paramView, "alpha", arrayOfFloat4);
    localxj.a(arrayOfxg);
  }
}


/* Location:           C:\Users\dreadiscool\Desktop\tools\classes-dex2jar.jar
 * Qualified Name:     cC
 * JD-Core Version:    0.7.0.1
 */