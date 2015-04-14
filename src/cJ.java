import android.view.View;
import android.view.ViewGroup;

public class cJ
  extends bv
{
  protected void a(View paramView)
  {
    ViewGroup localViewGroup = (ViewGroup)paramView.getParent();
    int i = localViewGroup.getWidth() - localViewGroup.getLeft();
    xj localxj = c();
    xg[] arrayOfxg = new xg[4];
    float[] arrayOfFloat1 = new float[3];
    arrayOfFloat1[0] = 1.0F;
    arrayOfFloat1[1] = 1.0F;
    arrayOfFloat1[2] = 0.0F;
    arrayOfxg[0] = xw.a(paramView, "alpha", arrayOfFloat1);
    float[] arrayOfFloat2 = new float[3];
    arrayOfFloat2[0] = 1.0F;
    arrayOfFloat2[1] = 0.475F;
    arrayOfFloat2[2] = 0.1F;
    arrayOfxg[1] = xw.a(paramView, "scaleX", arrayOfFloat2);
    float[] arrayOfFloat3 = new float[3];
    arrayOfFloat3[0] = 1.0F;
    arrayOfFloat3[1] = 0.475F;
    arrayOfFloat3[2] = 0.1F;
    arrayOfxg[2] = xw.a(paramView, "scaleY", arrayOfFloat3);
    float[] arrayOfFloat4 = new float[3];
    arrayOfFloat4[0] = 0.0F;
    arrayOfFloat4[1] = -42.0F;
    arrayOfFloat4[2] = i;
    arrayOfxg[3] = xw.a(paramView, "translationX", arrayOfFloat4);
    localxj.a(arrayOfxg);
  }
}


/* Location:           C:\Users\dreadiscool\Desktop\tools\classes-dex2jar.jar
 * Qualified Name:     cJ
 * JD-Core Version:    0.7.0.1
 */