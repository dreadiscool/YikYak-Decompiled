import android.view.View;
import android.view.animation.Interpolator;
import java.util.Iterator;
import java.util.List;

public class bx
{
  private bv a;
  private long b;
  private long c;
  private Interpolator d;
  private List<xh> e;
  private View f;
  
  private bx(bz parambz)
  {
    this.a = bz.a(parambz);
    this.b = bz.b(parambz);
    this.c = bz.c(parambz);
    this.d = bz.d(parambz);
    this.e = bz.e(parambz);
    this.f = bz.f(parambz);
  }
  
  private bv a()
  {
    this.a.a(this.b).a(this.d).b(this.c);
    if (this.e.size() > 0)
    {
      Iterator localIterator = this.e.iterator();
      while (localIterator.hasNext())
      {
        xh localxh = (xh)localIterator.next();
        this.a.a(localxh);
      }
    }
    this.a.b(this.f);
    return this.a;
  }
  
  public static bz a(bw parambw)
  {
    return new bz(parambw, null);
  }
}


/* Location:           C:\Users\dreadiscool\Desktop\tools\classes-dex2jar.jar
 * Qualified Name:     bx
 * JD-Core Version:    0.7.0.1
 */