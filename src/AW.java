import java.io.IOException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

final class AW
{
  AT[] a = new AT[8];
  int b = -1 + this.a.length;
  int c = 0;
  int d = 0;
  private final List<AT> e = new ArrayList();
  private final LD f;
  private int g;
  private int h;
  
  AW(int paramInt, LV paramLV)
  {
    this.g = paramInt;
    this.h = paramInt;
    this.f = LK.a(paramLV);
  }
  
  private void a(int paramInt, AT paramAT)
  {
    this.e.add(paramAT);
    int i = paramAT.j;
    if (paramInt != -1) {
      i -= this.a[d(paramInt)].j;
    }
    if (i > this.h)
    {
      e();
      return;
    }
    int j = b(i + this.d - this.h);
    if (paramInt == -1)
    {
      if (1 + this.c > this.a.length)
      {
        AT[] arrayOfAT = new AT[2 * this.a.length];
        System.arraycopy(this.a, 0, arrayOfAT, this.a.length, this.a.length);
        this.b = (-1 + this.a.length);
        this.a = arrayOfAT;
      }
      int m = this.b;
      this.b = (m - 1);
      this.a[m] = paramAT;
      this.c = (1 + this.c);
    }
    for (;;)
    {
      this.d = (i + this.d);
      break;
      int k = paramInt + (j + d(paramInt));
      this.a[k] = paramAT;
    }
  }
  
  private int b(int paramInt)
  {
    int i = 0;
    if (paramInt > 0)
    {
      for (int j = -1 + this.a.length; (j >= this.b) && (paramInt > 0); j--)
      {
        paramInt -= this.a[j].j;
        this.d -= this.a[j].j;
        this.c = (-1 + this.c);
        i++;
      }
      System.arraycopy(this.a, 1 + this.b, this.a, i + (1 + this.b), this.c);
      this.b = (i + this.b);
    }
    return i;
  }
  
  private void c(int paramInt)
  {
    if (h(paramInt))
    {
      AT localAT = AV.a()[paramInt];
      this.e.add(localAT);
    }
    for (;;)
    {
      return;
      int i = d(paramInt - AV.a().length);
      if ((i < 0) || (i > -1 + this.a.length)) {
        throw new IOException("Header index too large " + (paramInt + 1));
      }
      this.e.add(this.a[i]);
    }
  }
  
  private int d(int paramInt)
  {
    return paramInt + (1 + this.b);
  }
  
  private void d()
  {
    if (this.h < this.d)
    {
      if (this.h != 0) {
        break label23;
      }
      e();
    }
    for (;;)
    {
      return;
      label23:
      b(this.d - this.h);
    }
  }
  
  private void e()
  {
    this.e.clear();
    Arrays.fill(this.a, null);
    this.b = (-1 + this.a.length);
    this.c = 0;
    this.d = 0;
  }
  
  private void e(int paramInt)
  {
    LE localLE1 = g(paramInt);
    LE localLE2 = c();
    this.e.add(new AT(localLE1, localLE2));
  }
  
  private void f()
  {
    LE localLE1 = AV.a(c());
    LE localLE2 = c();
    this.e.add(new AT(localLE1, localLE2));
  }
  
  private void f(int paramInt)
  {
    a(-1, new AT(g(paramInt), c()));
  }
  
  private LE g(int paramInt)
  {
    if (h(paramInt)) {}
    for (LE localLE = AV.a()[paramInt].h;; localLE = this.a[d(paramInt - AV.a().length)].h) {
      return localLE;
    }
  }
  
  private void g()
  {
    a(-1, new AT(AV.a(c()), c()));
  }
  
  private int h()
  {
    return 0xFF & this.f.k();
  }
  
  private boolean h(int paramInt)
  {
    if ((paramInt >= 0) && (paramInt <= -1 + AV.a().length)) {}
    for (boolean bool = true;; bool = false) {
      return bool;
    }
  }
  
  int a(int paramInt1, int paramInt2)
  {
    int i = paramInt1 & paramInt2;
    if (i < paramInt2) {}
    for (;;)
    {
      return i;
      int k;
      for (int j = 0;; j += 7)
      {
        k = h();
        if ((k & 0x80) == 0) {
          break;
        }
        paramInt2 += ((k & 0x7F) << j);
      }
      i = paramInt2 + (k << j);
    }
  }
  
  void a()
  {
    while (!this.f.h())
    {
      int i = 0xFF & this.f.k();
      if (i == 128) {
        throw new IOException("index == 0");
      }
      if ((i & 0x80) == 128)
      {
        c(-1 + a(i, 127));
      }
      else if (i == 64)
      {
        g();
      }
      else if ((i & 0x40) == 64)
      {
        f(-1 + a(i, 63));
      }
      else if ((i & 0x20) == 32)
      {
        this.h = a(i, 31);
        if ((this.h < 0) || (this.h > this.g)) {
          throw new IOException("Invalid dynamic table size update " + this.h);
        }
        d();
      }
      else if ((i == 16) || (i == 0))
      {
        f();
      }
      else
      {
        e(-1 + a(i, 15));
      }
    }
  }
  
  void a(int paramInt)
  {
    this.g = paramInt;
    this.h = paramInt;
    d();
  }
  
  public List<AT> b()
  {
    ArrayList localArrayList = new ArrayList(this.e);
    this.e.clear();
    return localArrayList;
  }
  
  LE c()
  {
    int i = h();
    int j;
    int k;
    if ((i & 0x80) == 128)
    {
      j = 1;
      k = a(i, 127);
      if (j == 0) {
        break label60;
      }
    }
    label60:
    for (LE localLE = LE.a(Bd.a().a(this.f.f(k)));; localLE = this.f.c(k))
    {
      return localLE;
      j = 0;
      break;
    }
  }
}


/* Location:           C:\Users\dreadiscool\Desktop\tools\classes-dex2jar.jar
 * Qualified Name:     AW
 * JD-Core Version:    0.7.0.1
 */