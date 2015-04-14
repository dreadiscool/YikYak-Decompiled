import java.util.ArrayList;
import java.util.HashMap;

class xl
  implements xh
{
  private xj b;
  
  xl(xj paramxj1, xj paramxj2)
  {
    this.b = paramxj2;
  }
  
  public void a(xg paramxg) {}
  
  public void b(xg paramxg)
  {
    paramxg.b(this);
    xj.a(this.a).remove(paramxg);
    ((xp)xj.b(this.b).get(paramxg)).f = true;
    int j;
    if (!this.a.b)
    {
      ArrayList localArrayList1 = xj.c(this.b);
      int i = localArrayList1.size();
      j = 0;
      if (j >= i) {
        break label175;
      }
      if (((xp)localArrayList1.get(j)).f) {}
    }
    label175:
    for (int k = 0;; k = 1)
    {
      if (k != 0)
      {
        if (this.a.a != null)
        {
          ArrayList localArrayList2 = (ArrayList)this.a.a.clone();
          int m = localArrayList2.size();
          int n = 0;
          for (;;)
          {
            if (n < m)
            {
              ((xh)localArrayList2.get(n)).b(this.b);
              n++;
              continue;
              j++;
              break;
            }
          }
        }
        xj.a(this.b, false);
      }
      return;
    }
  }
}


/* Location:           C:\Users\dreadiscool\Desktop\tools\classes-dex2jar.jar
 * Qualified Name:     xl
 * JD-Core Version:    0.7.0.1
 */