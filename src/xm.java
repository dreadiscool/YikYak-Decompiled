import java.util.ArrayList;
import java.util.HashMap;

public class xm
{
  private xp b;
  
  xm(xj paramxj, xg paramxg)
  {
    this.b = ((xp)xj.b(paramxj).get(paramxg));
    if (this.b == null)
    {
      this.b = new xp(paramxg);
      xj.b(paramxj).put(paramxg, this.b);
      xj.d(paramxj).add(this.b);
    }
  }
  
  public xm a(xg paramxg)
  {
    xp localxp = (xp)xj.b(this.a).get(paramxg);
    if (localxp == null)
    {
      localxp = new xp(paramxg);
      xj.b(this.a).put(paramxg, localxp);
      xj.d(this.a).add(localxp);
    }
    localxp.a(new xn(this.b, 0));
    return this;
  }
}


/* Location:           C:\Users\dreadiscool\Desktop\tools\classes-dex2jar.jar
 * Qualified Name:     xm
 * JD-Core Version:    0.7.0.1
 */