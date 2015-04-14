import android.view.animation.Interpolator;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;

public final class xj
  extends xg
{
  boolean b = false;
  private ArrayList<xg> c = new ArrayList();
  private HashMap<xg, xp> d = new HashMap();
  private ArrayList<xp> e = new ArrayList();
  private ArrayList<xp> f = new ArrayList();
  private boolean g = true;
  private xl h = null;
  private boolean i = false;
  private long j = 0L;
  private xQ k = null;
  private long l = -1L;
  
  private void e()
  {
    if (this.g)
    {
      this.f.clear();
      ArrayList localArrayList1 = new ArrayList();
      int i3 = this.e.size();
      for (int i4 = 0; i4 < i3; i4++)
      {
        xp localxp4 = (xp)this.e.get(i4);
        if ((localxp4.b == null) || (localxp4.b.size() == 0)) {
          localArrayList1.add(localxp4);
        }
      }
      ArrayList localArrayList2 = new ArrayList();
      while (localArrayList1.size() > 0)
      {
        int i5 = localArrayList1.size();
        for (int i6 = 0; i6 < i5; i6++)
        {
          xp localxp2 = (xp)localArrayList1.get(i6);
          this.f.add(localxp2);
          if (localxp2.e != null)
          {
            int i7 = localxp2.e.size();
            for (int i8 = 0; i8 < i7; i8++)
            {
              xp localxp3 = (xp)localxp2.e.get(i8);
              localxp3.d.remove(localxp2);
              if (localxp3.d.size() == 0) {
                localArrayList2.add(localxp3);
              }
            }
          }
        }
        localArrayList1.clear();
        localArrayList1.addAll(localArrayList2);
        localArrayList2.clear();
      }
      this.g = false;
      if (this.f.size() != this.e.size()) {
        throw new IllegalStateException("Circular dependencies cannot exist in AnimatorSet");
      }
    }
    else
    {
      int m = this.e.size();
      for (int n = 0; n < m; n++)
      {
        xp localxp1 = (xp)this.e.get(n);
        if ((localxp1.b != null) && (localxp1.b.size() > 0))
        {
          int i1 = localxp1.b.size();
          for (int i2 = 0; i2 < i1; i2++)
          {
            xn localxn = (xn)localxp1.b.get(i2);
            if (localxp1.d == null) {
              localxp1.d = new ArrayList();
            }
            if (!localxp1.d.contains(localxn.a)) {
              localxp1.d.add(localxn.a);
            }
          }
        }
        localxp1.f = false;
      }
    }
  }
  
  public xm a(xg paramxg)
  {
    if (paramxg != null) {
      this.g = true;
    }
    for (xm localxm = new xm(this, paramxg);; localxm = null) {
      return localxm;
    }
  }
  
  public void a()
  {
    int m = 0;
    this.b = false;
    this.i = true;
    e();
    int n = this.f.size();
    for (int i1 = 0; i1 < n; i1++)
    {
      xp localxp3 = (xp)this.f.get(i1);
      ArrayList localArrayList4 = localxp3.a.b();
      if ((localArrayList4 != null) && (localArrayList4.size() > 0))
      {
        Iterator localIterator2 = new ArrayList(localArrayList4).iterator();
        while (localIterator2.hasNext())
        {
          xh localxh = (xh)localIterator2.next();
          if (((localxh instanceof xo)) || ((localxh instanceof xl))) {
            localxp3.a.b(localxh);
          }
        }
      }
    }
    ArrayList localArrayList1 = new ArrayList();
    int i2 = 0;
    if (i2 < n)
    {
      xp localxp2 = (xp)this.f.get(i2);
      if (this.h == null) {
        this.h = new xl(this, this);
      }
      if ((localxp2.b == null) || (localxp2.b.size() == 0)) {
        localArrayList1.add(localxp2);
      }
      for (;;)
      {
        localxp2.a.a(this.h);
        i2++;
        break;
        int i6 = localxp2.b.size();
        for (int i7 = 0; i7 < i6; i7++)
        {
          xn localxn = (xn)localxp2.b.get(i7);
          localxn.a.a.a(new xo(this, localxp2, localxn.b));
        }
        localxp2.c = ((ArrayList)localxp2.b.clone());
      }
    }
    if (this.j <= 0L)
    {
      Iterator localIterator1 = localArrayList1.iterator();
      while (localIterator1.hasNext())
      {
        xp localxp1 = (xp)localIterator1.next();
        localxp1.a.a();
        this.c.add(localxp1.a);
      }
    }
    float[] arrayOfFloat = new float[2];
    arrayOfFloat[0] = 0.0F;
    arrayOfFloat[1] = 1.0F;
    this.k = xQ.b(arrayOfFloat);
    this.k.c(this.j);
    this.k.a(new xk(this, localArrayList1));
    this.k.a();
    if (this.a != null)
    {
      ArrayList localArrayList3 = (ArrayList)this.a.clone();
      int i4 = localArrayList3.size();
      for (int i5 = 0; i5 < i4; i5++) {
        ((xh)localArrayList3.get(i5)).a(this);
      }
    }
    if ((this.e.size() == 0) && (this.j == 0L))
    {
      this.i = false;
      if (this.a != null)
      {
        ArrayList localArrayList2 = (ArrayList)this.a.clone();
        int i3 = localArrayList2.size();
        while (m < i3)
        {
          ((xh)localArrayList2.get(m)).b(this);
          m++;
        }
      }
    }
  }
  
  public void a(Interpolator paramInterpolator)
  {
    Iterator localIterator = this.e.iterator();
    while (localIterator.hasNext()) {
      ((xp)localIterator.next()).a.a(paramInterpolator);
    }
  }
  
  public void a(xg... paramVarArgs)
  {
    int m = 1;
    if (paramVarArgs != null)
    {
      this.g = m;
      xm localxm = a(paramVarArgs[0]);
      while (m < paramVarArgs.length)
      {
        localxm.a(paramVarArgs[m]);
        m += 1;
      }
    }
  }
  
  public void b(long paramLong)
  {
    this.j = paramLong;
  }
  
  public xj c(long paramLong)
  {
    if (paramLong < 0L) {
      throw new IllegalArgumentException("duration must be a value of zero or greater");
    }
    Iterator localIterator = this.e.iterator();
    while (localIterator.hasNext()) {
      ((xp)localIterator.next()).a.a(paramLong);
    }
    this.l = paramLong;
    return this;
  }
  
  public xj d()
  {
    xj localxj = (xj)super.c();
    localxj.g = true;
    localxj.b = false;
    localxj.i = false;
    localxj.c = new ArrayList();
    localxj.d = new HashMap();
    localxj.e = new ArrayList();
    localxj.f = new ArrayList();
    HashMap localHashMap = new HashMap();
    Iterator localIterator1 = this.e.iterator();
    while (localIterator1.hasNext())
    {
      xp localxp3 = (xp)localIterator1.next();
      xp localxp4 = localxp3.a();
      localHashMap.put(localxp3, localxp4);
      localxj.e.add(localxp4);
      localxj.d.put(localxp4.a, localxp4);
      localxp4.b = null;
      localxp4.c = null;
      localxp4.e = null;
      localxp4.d = null;
      ArrayList localArrayList1 = localxp4.a.b();
      if (localArrayList1 != null)
      {
        Iterator localIterator4 = localArrayList1.iterator();
        ArrayList localArrayList2 = null;
        while (localIterator4.hasNext())
        {
          xh localxh = (xh)localIterator4.next();
          if ((localxh instanceof xl))
          {
            if (localArrayList2 == null) {
              localArrayList2 = new ArrayList();
            }
            localArrayList2.add(localxh);
          }
        }
        if (localArrayList2 != null)
        {
          Iterator localIterator5 = localArrayList2.iterator();
          while (localIterator5.hasNext()) {
            localArrayList1.remove((xh)localIterator5.next());
          }
        }
      }
    }
    Iterator localIterator2 = this.e.iterator();
    while (localIterator2.hasNext())
    {
      xp localxp1 = (xp)localIterator2.next();
      xp localxp2 = (xp)localHashMap.get(localxp1);
      if (localxp1.b != null)
      {
        Iterator localIterator3 = localxp1.b.iterator();
        while (localIterator3.hasNext())
        {
          xn localxn = (xn)localIterator3.next();
          localxp2.a(new xn((xp)localHashMap.get(localxn.a), localxn.b));
        }
      }
    }
    return localxj;
  }
}


/* Location:           C:\Users\dreadiscool\Desktop\tools\classes-dex2jar.jar
 * Qualified Name:     xj
 * JD-Core Version:    0.7.0.1
 */