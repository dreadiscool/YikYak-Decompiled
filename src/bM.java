import android.view.View;

public class bM
  extends bv
{
  public void a(View paramView)
  {
    xj localxj = c();
    xg[] arrayOfxg = new xg[2];
    float[] arrayOfFloat1 = new float[4];
    arrayOfFloat1[0] = 0.0F;
    arrayOfFloat1[1] = 1.0F;
    arrayOfFloat1[2] = 1.0F;
    arrayOfFloat1[3] = 1.0F;
    arrayOfxg[0] = xw.a(paramView, "alpha", arrayOfFloat1);
    float[] arrayOfFloat2 = new float[4];
    arrayOfFloat2[0] = (-paramView.getHeight());
    arrayOfFloat2[1] = 30.0F;
    arrayOfFloat2[2] = -10.0F;
    arrayOfFloat2[3] = 0.0F;
    arrayOfxg[1] = xw.a(paramView, "translationY", arrayOfFloat2);
    localxj.a(arrayOfxg);
  }
}


/* Location:           C:\Users\dreadiscool\Desktop\tools\classes-dex2jar.jar
 * Qualified Name:     bM
 * JD-Core Version:    0.7.0.1
 */