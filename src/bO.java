import android.view.View;

public class bO
  extends bv
{
  public void a(View paramView)
  {
    xj localxj = c();
    xg[] arrayOfxg = new xg[2];
    float[] arrayOfFloat1 = new float[4];
    arrayOfFloat1[0] = (paramView.getMeasuredWidth() + paramView.getWidth());
    arrayOfFloat1[1] = -30.0F;
    arrayOfFloat1[2] = 10.0F;
    arrayOfFloat1[3] = 0.0F;
    arrayOfxg[0] = xw.a(paramView, "translationX", arrayOfFloat1);
    float[] arrayOfFloat2 = new float[4];
    arrayOfFloat2[0] = 0.0F;
    arrayOfFloat2[1] = 1.0F;
    arrayOfFloat2[2] = 1.0F;
    arrayOfFloat2[3] = 1.0F;
    arrayOfxg[1] = xw.a(paramView, "alpha", arrayOfFloat2);
    localxj.a(arrayOfxg);
  }
}


/* Location:           C:\Users\dreadiscool\Desktop\tools\classes-dex2jar.jar
 * Qualified Name:     bO
 * JD-Core Version:    0.7.0.1
 */