import android.view.View;

public class cv
  extends bv
{
  public void a(View paramView)
  {
    float f1 = paramView.getPaddingLeft();
    float f2 = paramView.getPaddingTop();
    xj localxj = c();
    xg[] arrayOfxg = new xg[5];
    cO localcO = cO.z;
    float[] arrayOfFloat1 = new float[6];
    arrayOfFloat1[0] = 0.0F;
    arrayOfFloat1[1] = 80.0F;
    arrayOfFloat1[2] = 60.0F;
    arrayOfFloat1[3] = 80.0F;
    arrayOfFloat1[4] = 60.0F;
    arrayOfFloat1[5] = 60.0F;
    arrayOfxg[0] = cN.a(localcO, 1300.0F, xw.a(paramView, "rotation", arrayOfFloat1));
    float[] arrayOfFloat2 = new float[6];
    arrayOfFloat2[0] = 0.0F;
    arrayOfFloat2[1] = 0.0F;
    arrayOfFloat2[2] = 0.0F;
    arrayOfFloat2[3] = 0.0F;
    arrayOfFloat2[4] = 0.0F;
    arrayOfFloat2[5] = 700.0F;
    arrayOfxg[1] = xw.a(paramView, "translationY", arrayOfFloat2);
    float[] arrayOfFloat3 = new float[6];
    arrayOfFloat3[0] = 1.0F;
    arrayOfFloat3[1] = 1.0F;
    arrayOfFloat3[2] = 1.0F;
    arrayOfFloat3[3] = 1.0F;
    arrayOfFloat3[4] = 1.0F;
    arrayOfFloat3[5] = 0.0F;
    arrayOfxg[2] = xw.a(paramView, "alpha", arrayOfFloat3);
    float[] arrayOfFloat4 = new float[6];
    arrayOfFloat4[0] = f1;
    arrayOfFloat4[1] = f1;
    arrayOfFloat4[2] = f1;
    arrayOfFloat4[3] = f1;
    arrayOfFloat4[4] = f1;
    arrayOfFloat4[5] = f1;
    arrayOfxg[3] = xw.a(paramView, "pivotX", arrayOfFloat4);
    float[] arrayOfFloat5 = new float[6];
    arrayOfFloat5[0] = f2;
    arrayOfFloat5[1] = f2;
    arrayOfFloat5[2] = f2;
    arrayOfFloat5[3] = f2;
    arrayOfFloat5[4] = f2;
    arrayOfFloat5[5] = f2;
    arrayOfxg[4] = xw.a(paramView, "pivotY", arrayOfFloat5);
    localxj.a(arrayOfxg);
    a(1300L);
  }
}


/* Location:           C:\Users\dreadiscool\Desktop\tools\classes-dex2jar.jar
 * Qualified Name:     cv
 * JD-Core Version:    0.7.0.1
 */