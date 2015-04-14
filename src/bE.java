import android.view.View;

public class bE
  extends bv
{
  public void a(View paramView)
  {
    xj localxj = c();
    xg[] arrayOfxg = new xg[2];
    float[] arrayOfFloat1 = new float[5];
    arrayOfFloat1[0] = 1.0F;
    arrayOfFloat1[1] = 1.25F;
    arrayOfFloat1[2] = 0.75F;
    arrayOfFloat1[3] = 1.15F;
    arrayOfFloat1[4] = 1.0F;
    arrayOfxg[0] = xw.a(paramView, "scaleX", arrayOfFloat1);
    float[] arrayOfFloat2 = new float[5];
    arrayOfFloat2[0] = 1.0F;
    arrayOfFloat2[1] = 0.75F;
    arrayOfFloat2[2] = 1.25F;
    arrayOfFloat2[3] = 0.85F;
    arrayOfFloat2[4] = 1.0F;
    arrayOfxg[1] = xw.a(paramView, "scaleY", arrayOfFloat2);
    localxj.a(arrayOfxg);
  }
}


/* Location:           C:\Users\dreadiscool\Desktop\tools\classes-dex2jar.jar
 * Qualified Name:     bE
 * JD-Core Version:    0.7.0.1
 */