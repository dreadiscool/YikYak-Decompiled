import android.view.View;

public class cx
  extends bv
{
  public void a(View paramView)
  {
    xj localxj = c();
    xg[] arrayOfxg = new xg[3];
    float[] arrayOfFloat1 = new float[2];
    arrayOfFloat1[0] = 1.0F;
    arrayOfFloat1[1] = 0.0F;
    arrayOfxg[0] = xw.a(paramView, "alpha", arrayOfFloat1);
    float[] arrayOfFloat2 = new float[2];
    arrayOfFloat2[0] = 0.0F;
    arrayOfFloat2[1] = paramView.getWidth();
    arrayOfxg[1] = xw.a(paramView, "translationX", arrayOfFloat2);
    float[] arrayOfFloat3 = new float[2];
    arrayOfFloat3[0] = 0.0F;
    arrayOfFloat3[1] = 120.0F;
    arrayOfxg[2] = xw.a(paramView, "rotation", arrayOfFloat3);
    localxj.a(arrayOfxg);
  }
}


/* Location:           C:\Users\dreadiscool\Desktop\tools\classes-dex2jar.jar
 * Qualified Name:     cx
 * JD-Core Version:    0.7.0.1
 */