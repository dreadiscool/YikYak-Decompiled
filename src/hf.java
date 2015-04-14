public final class hf
  extends jg<hf>
{
  private static volatile hf[] o;
  public int a;
  public String b;
  public hf[] c;
  public hf[] d;
  public hf[] e;
  public String f;
  public String g;
  public long h;
  public boolean i;
  public hf[] j;
  public int[] k;
  public boolean l;
  
  public hf()
  {
    b();
  }
  
  public static hf[] a()
  {
    if (o == null) {}
    synchronized (jk.a)
    {
      if (o == null) {
        o = new hf[0];
      }
      return o;
    }
  }
  
  public void a(je paramje)
  {
    int m = 0;
    paramje.a(1, this.a);
    if (!this.b.equals("")) {
      paramje.a(2, this.b);
    }
    if ((this.c != null) && (this.c.length > 0)) {
      for (int i3 = 0; i3 < this.c.length; i3++)
      {
        hf localhf4 = this.c[i3];
        if (localhf4 != null) {
          paramje.a(3, localhf4);
        }
      }
    }
    if ((this.d != null) && (this.d.length > 0)) {
      for (int i2 = 0; i2 < this.d.length; i2++)
      {
        hf localhf3 = this.d[i2];
        if (localhf3 != null) {
          paramje.a(4, localhf3);
        }
      }
    }
    if ((this.e != null) && (this.e.length > 0)) {
      for (int i1 = 0; i1 < this.e.length; i1++)
      {
        hf localhf2 = this.e[i1];
        if (localhf2 != null) {
          paramje.a(5, localhf2);
        }
      }
    }
    if (!this.f.equals("")) {
      paramje.a(6, this.f);
    }
    if (!this.g.equals("")) {
      paramje.a(7, this.g);
    }
    if (this.h != 0L) {
      paramje.a(8, this.h);
    }
    if (this.l) {
      paramje.a(9, this.l);
    }
    if ((this.k != null) && (this.k.length > 0)) {
      for (int n = 0; n < this.k.length; n++) {
        paramje.a(10, this.k[n]);
      }
    }
    if ((this.j != null) && (this.j.length > 0)) {
      while (m < this.j.length)
      {
        hf localhf1 = this.j[m];
        if (localhf1 != null) {
          paramje.a(11, localhf1);
        }
        m++;
      }
    }
    if (this.i) {
      paramje.a(12, this.i);
    }
    super.a(paramje);
  }
  
  public hf b()
  {
    this.a = 1;
    this.b = "";
    this.c = a();
    this.d = a();
    this.e = a();
    this.f = "";
    this.g = "";
    this.h = 0L;
    this.i = false;
    this.j = a();
    this.k = jo.a;
    this.l = false;
    this.m = null;
    this.n = -1;
    return this;
  }
  
  protected int c()
  {
    int m = 0;
    int n = super.c() + je.b(1, this.a);
    if (!this.b.equals("")) {
      n += je.b(2, this.b);
    }
    if ((this.c != null) && (this.c.length > 0))
    {
      int i7 = n;
      for (int i8 = 0; i8 < this.c.length; i8++)
      {
        hf localhf4 = this.c[i8];
        if (localhf4 != null) {
          i7 += je.c(3, localhf4);
        }
      }
      n = i7;
    }
    if ((this.d != null) && (this.d.length > 0))
    {
      int i5 = n;
      for (int i6 = 0; i6 < this.d.length; i6++)
      {
        hf localhf3 = this.d[i6];
        if (localhf3 != null) {
          i5 += je.c(4, localhf3);
        }
      }
      n = i5;
    }
    if ((this.e != null) && (this.e.length > 0))
    {
      int i3 = n;
      for (int i4 = 0; i4 < this.e.length; i4++)
      {
        hf localhf2 = this.e[i4];
        if (localhf2 != null) {
          i3 += je.c(5, localhf2);
        }
      }
      n = i3;
    }
    if (!this.f.equals("")) {
      n += je.b(6, this.f);
    }
    if (!this.g.equals("")) {
      n += je.b(7, this.g);
    }
    if (this.h != 0L) {
      n += je.b(8, this.h);
    }
    if (this.l) {
      n += je.b(9, this.l);
    }
    if ((this.k != null) && (this.k.length > 0))
    {
      int i1 = 0;
      int i2 = 0;
      while (i1 < this.k.length)
      {
        i2 += je.b(this.k[i1]);
        i1++;
      }
      n = n + i2 + 1 * this.k.length;
    }
    if ((this.j != null) && (this.j.length > 0)) {
      while (m < this.j.length)
      {
        hf localhf1 = this.j[m];
        if (localhf1 != null) {
          n += je.c(11, localhf1);
        }
        m++;
      }
    }
    if (this.i) {
      n += je.b(12, this.i);
    }
    return n;
  }
  
  public boolean equals(Object paramObject)
  {
    boolean bool = false;
    if (paramObject == this)
    {
      bool = true;
      break label118;
    }
    for (;;)
    {
      label9:
      return bool;
      if ((paramObject instanceof hf))
      {
        hf localhf = (hf)paramObject;
        if (this.a == localhf.a)
        {
          if (this.b == null)
          {
            if (localhf.b != null) {
              continue;
            }
            if ((!jk.a(this.c, localhf.c)) || (!jk.a(this.d, localhf.d)) || (!jk.a(this.e, localhf.e))) {
              continue;
            }
            if (this.f != null) {
              break label206;
            }
            if (localhf.f != null) {
              continue;
            }
          }
          for (;;)
          {
            if (this.g == null)
            {
              if (localhf.g != null) {
                break label9;
              }
              label118:
              if ((this.h != localhf.h) || (this.i != localhf.i) || (!jk.a(this.j, localhf.j)) || (!jk.a(this.k, localhf.k)) || (this.l != localhf.l)) {
                break label9;
              }
              bool = a(localhf);
              break label9;
              if (this.b.equals(localhf.b)) {
                break;
              }
              break label9;
              label206:
              if (!this.f.equals(localhf.f)) {
                break label9;
              }
            }
          }
          if (this.g.equals(localhf.g)) {
            break;
          }
        }
      }
    }
  }
  
  public int hashCode()
  {
    int m = 1231;
    int n = 0;
    int i1 = 31 * (527 + this.a);
    int i2;
    int i4;
    label80:
    label97:
    int i7;
    label133:
    int i8;
    if (this.b == null)
    {
      i2 = 0;
      int i3 = 31 * (31 * (31 * (31 * (i2 + i1) + jk.a(this.c)) + jk.a(this.d)) + jk.a(this.e));
      if (this.f != null) {
        break label197;
      }
      i4 = 0;
      int i5 = 31 * (i4 + i3);
      if (this.g != null) {
        break label209;
      }
      int i6 = 31 * (31 * (i5 + n) + (int)(this.h ^ this.h >>> 32));
      if (!this.i) {
        break label220;
      }
      i7 = m;
      i8 = 31 * (31 * (31 * (i7 + i6) + jk.a(this.j)) + jk.a(this.k));
      if (!this.l) {
        break label228;
      }
    }
    for (;;)
    {
      return 31 * (i8 + m) + d();
      i2 = this.b.hashCode();
      break;
      label197:
      i4 = this.f.hashCode();
      break label80;
      label209:
      n = this.g.hashCode();
      break label97;
      label220:
      i7 = 1237;
      break label133;
      label228:
      m = 1237;
    }
  }
}


/* Location:           C:\Users\dreadiscool\Desktop\tools\classes-dex2jar.jar
 * Qualified Name:     hf
 * JD-Core Version:    0.7.0.1
 */