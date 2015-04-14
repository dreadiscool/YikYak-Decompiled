import android.view.View;

public class bK
  extends bv
{
  public void a(View paramView)
  {
    float f = (float)(paramView.getWidth() / 100.0D);
    xj localxj = c();
    xg[] arrayOfxg = new xg[2];
    float[] arrayOfFloat1 = new float[8];
    arrayOfFloat1[0] = (0.0F * f);
    arrayOfFloat1[1] = (-25.0F * f);
    arrayOfFloat1[2] = (20.0F * f);
    arrayOfFloat1[3] = (-15.0F * f);
    arrayOfFloat1[4] = (10.0F * f);
    arrayOfFloat1[5] = (-5.0F * f);
    arrayOfFloat1[6] = (f * 0.0F);
    arrayOfFloat1[7] = 0.0F;
    arrayOfxg[0] = xw.a(paramView, "translationX", arrayOfFloat1);
    float[] arrayOfFloat2 = new float[7];
    arrayOfFloat2[0] = 0.0F;
    arrayOfFloat2[1] = -5.0F;
    arrayOfFloat2[2] = 3.0F;
    arrayOfFloat2[3] = -3.0F;
    arrayOfFloat2[4] = 2.0F;
    arrayOfFloat2[5] = -1.0F;
    arrayOfFloat2[6] = 0.0F;
    arrayOfxg[1] = xw.a(paramView, "rotation", arrayOfFloat2);
    localxj.a(arrayOfxg);
  }
}


/* Location:           C:\Users\dreadiscool\Desktop\tools\classes-dex2jar.jar
 * Qualified Name:     bK
 * JD-Core Version:    0.7.0.1
 */