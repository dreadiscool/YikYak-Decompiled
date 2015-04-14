import android.view.animation.Interpolator;
import java.util.ArrayList;

public abstract class xg
  implements Cloneable
{
  ArrayList<xh> a = null;
  
  public abstract xg a(long paramLong);
  
  public void a() {}
  
  public abstract void a(Interpolator paramInterpolator);
  
  public void a(xh paramxh)
  {
    if (this.a == null) {
      this.a = new ArrayList();
    }
    this.a.add(paramxh);
  }
  
  public ArrayList<xh> b()
  {
    return this.a;
  }
  
  public void b(xh paramxh)
  {
    if (this.a == null) {}
    for (;;)
    {
      return;
      this.a.remove(paramxh);
      if (this.a.size() == 0) {
        this.a = null;
      }
    }
  }
  
  public xg c()
  {
    try
    {
      xg localxg = (xg)super.clone();
      if (this.a != null)
      {
        ArrayList localArrayList = this.a;
        localxg.a = new ArrayList();
        int i = localArrayList.size();
        for (int j = 0; j < i; j++) {
          localxg.a.add(localArrayList.get(j));
        }
      }
      return localxg;
    }
    catch (CloneNotSupportedException localCloneNotSupportedException)
    {
      throw new AssertionError();
    }
  }
}


/* Location:           C:\Users\dreadiscool\Desktop\tools\classes-dex2jar.jar
 * Qualified Name:     xg
 * JD-Core Version:    0.7.0.1
 */