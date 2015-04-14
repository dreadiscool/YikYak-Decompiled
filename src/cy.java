import android.view.View;

public class cy
  extends bv
{
  protected void a(View paramView)
  {
    int i = paramView.getTop() + paramView.getHeight();
    xj localxj = c();
    xg[] arrayOfxg = new xg[2];
    float[] arrayOfFloat1 = new float[2];
    arrayOfFloat1[0] = 0.0F;
    arrayOfFloat1[1] = 1.0F;
    arrayOfxg[0] = xw.a(paramView, "alpha", arrayOfFloat1);
    cO localcO = cO.e;
    float f = (float)b();
    float[] arrayOfFloat2 = new float[2];
    arrayOfFloat2[0] = (-i);
    arrayOfFloat2[1] = 0.0F;
    arrayOfxg[1] = cN.a(localcO, f, xw.a(paramView, "translationY", arrayOfFloat2));
    localxj.a(arrayOfxg);
  }
}


/* Location:           C:\Users\dreadiscool\Desktop\tools\classes-dex2jar.jar
 * Qualified Name:     cy
 * JD-Core Version:    0.7.0.1
 */