import android.view.View;

public class bJ
  extends bv
{
  public void a(View paramView)
  {
    float f1 = (paramView.getWidth() - paramView.getPaddingLeft() - paramView.getPaddingRight()) / 2 + paramView.getPaddingLeft();
    float f2 = paramView.getHeight() - paramView.getPaddingBottom();
    xj localxj = c();
    xg[] arrayOfxg = new xg[3];
    float[] arrayOfFloat1 = new float[5];
    arrayOfFloat1[0] = 12.0F;
    arrayOfFloat1[1] = -12.0F;
    arrayOfFloat1[2] = 3.0F;
    arrayOfFloat1[3] = -3.0F;
    arrayOfFloat1[4] = 0.0F;
    arrayOfxg[0] = xw.a(paramView, "rotation", arrayOfFloat1);
    float[] arrayOfFloat2 = new float[5];
    arrayOfFloat2[0] = f1;
    arrayOfFloat2[1] = f1;
    arrayOfFloat2[2] = f1;
    arrayOfFloat2[3] = f1;
    arrayOfFloat2[4] = f1;
    arrayOfxg[1] = xw.a(paramView, "pivotX", arrayOfFloat2);
    float[] arrayOfFloat3 = new float[5];
    arrayOfFloat3[0] = f2;
    arrayOfFloat3[1] = f2;
    arrayOfFloat3[2] = f2;
    arrayOfFloat3[3] = f2;
    arrayOfFloat3[4] = f2;
    arrayOfxg[2] = xw.a(paramView, "pivotY", arrayOfFloat3);
    localxj.a(arrayOfxg);
  }
}


/* Location:           C:\Users\dreadiscool\Desktop\tools\classes-dex2jar.jar
 * Qualified Name:     bJ
 * JD-Core Version:    0.7.0.1
 */