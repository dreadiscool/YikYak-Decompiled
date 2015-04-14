import android.view.View;
import android.view.animation.Interpolator;
import java.util.ArrayList;
import java.util.List;

public final class bz
{
  private List<xh> a = new ArrayList();
  private bv b;
  private long c = 1000L;
  private long d = 0L;
  private Interpolator e;
  private View f;
  
  private bz(bw parambw)
  {
    this.b = parambw.a();
  }
  
  public bA a(View paramView)
  {
    this.f = paramView;
    return new bA(bx.a(new bx(this, null)), this.f, null);
  }
  
  public bz a(long paramLong)
  {
    this.c = paramLong;
    return this;
  }
}


/* Location:           C:\Users\dreadiscool\Desktop\tools\classes-dex2jar.jar
 * Qualified Name:     bz
 * JD-Core Version:    0.7.0.1
 */