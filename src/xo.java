import java.util.ArrayList;

class xo
  implements xh
{
  private xj a;
  private xp b;
  private int c;
  
  public xo(xj paramxj, xp paramxp, int paramInt)
  {
    this.a = paramxj;
    this.b = paramxp;
    this.c = paramInt;
  }
  
  private void c(xg paramxg)
  {
    if (this.a.b) {
      return;
    }
    int i = this.b.c.size();
    int j = 0;
    label24:
    xn localxn;
    if (j < i)
    {
      localxn = (xn)this.b.c.get(j);
      if ((localxn.b == this.c) && (localxn.a.a == paramxg)) {
        paramxg.b(this);
      }
    }
    for (;;)
    {
      this.b.c.remove(localxn);
      if (this.b.c.size() != 0) {
        break;
      }
      this.b.a.a();
      xj.a(this.a).add(this.b.a);
      break;
      j++;
      break label24;
      localxn = null;
    }
  }
  
  public void a(xg paramxg)
  {
    if (this.c == 0) {
      c(paramxg);
    }
  }
  
  public void b(xg paramxg)
  {
    if (this.c == 1) {
      c(paramxg);
    }
  }
}


/* Location:           C:\Users\dreadiscool\Desktop\tools\classes-dex2jar.jar
 * Qualified Name:     xo
 * JD-Core Version:    0.7.0.1
 */