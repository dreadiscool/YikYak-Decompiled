import android.view.View;

public class cf
  extends bv
{
  public void a(View paramView)
  {
    float f1 = paramView.getWidth() - paramView.getPaddingRight();
    float f2 = paramView.getHeight() - paramView.getPaddingBottom();
    xj localxj = c();
    xg[] arrayOfxg = new xg[4];
    float[] arrayOfFloat1 = new float[2];
    arrayOfFloat1[0] = 90.0F;
    arrayOfFloat1[1] = 0.0F;
    arrayOfxg[0] = xw.a(paramView, "rotation", arrayOfFloat1);
    float[] arrayOfFloat2 = new float[2];
    arrayOfFloat2[0] = 0.0F;
    arrayOfFloat2[1] = 1.0F;
    arrayOfxg[1] = xw.a(paramView, "alpha", arrayOfFloat2);
    float[] arrayOfFloat3 = new float[2];
    arrayOfFloat3[0] = f1;
    arrayOfFloat3[1] = f1;
    arrayOfxg[2] = xw.a(paramView, "pivotX", arrayOfFloat3);
    float[] arrayOfFloat4 = new float[2];
    arrayOfFloat4[0] = f2;
    arrayOfFloat4[1] = f2;
    arrayOfxg[3] = xw.a(paramView, "pivotY", arrayOfFloat4);
    localxj.a(arrayOfxg);
  }
}


/* Location:           C:\Users\dreadiscool\Desktop\tools\classes-dex2jar.jar
 * Qualified Name:     cf
 * JD-Core Version:    0.7.0.1
 */