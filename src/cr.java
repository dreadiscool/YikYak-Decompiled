import android.view.View;
import android.view.ViewGroup;

public class cr
  extends bv
{
  public void a(View paramView)
  {
    int i = ((ViewGroup)paramView.getParent()).getHeight() - paramView.getTop();
    xj localxj = c();
    xg[] arrayOfxg = new xg[2];
    float[] arrayOfFloat1 = new float[2];
    arrayOfFloat1[0] = 1.0F;
    arrayOfFloat1[1] = 0.0F;
    arrayOfxg[0] = xw.a(paramView, "alpha", arrayOfFloat1);
    float[] arrayOfFloat2 = new float[2];
    arrayOfFloat2[0] = 0.0F;
    arrayOfFloat2[1] = i;
    arrayOfxg[1] = xw.a(paramView, "translationY", arrayOfFloat2);
    localxj.a(arrayOfxg);
  }
}


/* Location:           C:\Users\dreadiscool\Desktop\tools\classes-dex2jar.jar
 * Qualified Name:     cr
 * JD-Core Version:    0.7.0.1
 */