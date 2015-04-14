import java.io.Reader;
import java.util.Iterator;
import java.util.List;
import java.util.Map.Entry;
import java.util.Set;

public final class qn
  extends ro
{
  private static final Reader a = new qo();
  private static final Object b = new Object();
  private final List<Object> c;
  
  private void a(rq paramrq)
  {
    if (f() != paramrq) {
      throw new IllegalStateException("Expected " + paramrq + " but was " + f());
    }
  }
  
  private Object q()
  {
    return this.c.get(-1 + this.c.size());
  }
  
  private Object r()
  {
    return this.c.remove(-1 + this.c.size());
  }
  
  public void a()
  {
    a(rq.a);
    oZ localoZ = (oZ)q();
    this.c.add(localoZ.iterator());
  }
  
  public void b()
  {
    a(rq.b);
    r();
    r();
  }
  
  public void c()
  {
    a(rq.c);
    pe localpe = (pe)q();
    this.c.add(localpe.o().iterator());
  }
  
  public void close()
  {
    this.c.clear();
    this.c.add(b);
  }
  
  public void d()
  {
    a(rq.d);
    r();
    r();
  }
  
  public boolean e()
  {
    rq localrq = f();
    if ((localrq != rq.d) && (localrq != rq.b)) {}
    for (boolean bool = true;; bool = false) {
      return bool;
    }
  }
  
  public rq f()
  {
    rq localrq;
    if (this.c.isEmpty()) {
      localrq = rq.j;
    }
    Object localObject;
    for (;;)
    {
      return localrq;
      localObject = q();
      if ((localObject instanceof Iterator))
      {
        boolean bool = this.c.get(-2 + this.c.size()) instanceof pe;
        Iterator localIterator = (Iterator)localObject;
        if (localIterator.hasNext())
        {
          if (bool)
          {
            localrq = rq.e;
          }
          else
          {
            this.c.add(localIterator.next());
            localrq = f();
          }
        }
        else if (bool) {
          localrq = rq.d;
        } else {
          localrq = rq.b;
        }
      }
      else if ((localObject instanceof pe))
      {
        localrq = rq.c;
      }
      else if ((localObject instanceof oZ))
      {
        localrq = rq.a;
      }
      else if ((localObject instanceof pg))
      {
        pg localpg = (pg)localObject;
        if (localpg.q()) {
          localrq = rq.f;
        } else if (localpg.o()) {
          localrq = rq.h;
        } else if (localpg.p()) {
          localrq = rq.g;
        } else {
          throw new AssertionError();
        }
      }
      else
      {
        if (!(localObject instanceof pd)) {
          break;
        }
        localrq = rq.i;
      }
    }
    if (localObject == b) {
      throw new IllegalStateException("JsonReader is closed");
    }
    throw new AssertionError();
  }
  
  public String g()
  {
    a(rq.e);
    Map.Entry localEntry = (Map.Entry)((Iterator)q()).next();
    this.c.add(localEntry.getValue());
    return (String)localEntry.getKey();
  }
  
  public String h()
  {
    rq localrq = f();
    if ((localrq != rq.f) && (localrq != rq.g)) {
      throw new IllegalStateException("Expected " + rq.f + " but was " + localrq);
    }
    return ((pg)r()).b();
  }
  
  public boolean i()
  {
    a(rq.h);
    return ((pg)r()).f();
  }
  
  public void j()
  {
    a(rq.i);
    r();
  }
  
  public double k()
  {
    rq localrq = f();
    if ((localrq != rq.g) && (localrq != rq.f)) {
      throw new IllegalStateException("Expected " + rq.g + " but was " + localrq);
    }
    double d = ((pg)q()).c();
    if ((!p()) && ((Double.isNaN(d)) || (Double.isInfinite(d)))) {
      throw new NumberFormatException("JSON forbids NaN and infinities: " + d);
    }
    r();
    return d;
  }
  
  public long l()
  {
    rq localrq = f();
    if ((localrq != rq.g) && (localrq != rq.f)) {
      throw new IllegalStateException("Expected " + rq.g + " but was " + localrq);
    }
    long l = ((pg)q()).d();
    r();
    return l;
  }
  
  public int m()
  {
    rq localrq = f();
    if ((localrq != rq.g) && (localrq != rq.f)) {
      throw new IllegalStateException("Expected " + rq.g + " but was " + localrq);
    }
    int i = ((pg)q()).e();
    r();
    return i;
  }
  
  public void n()
  {
    if (f() == rq.e) {
      g();
    }
    for (;;)
    {
      return;
      r();
    }
  }
  
  public void o()
  {
    a(rq.e);
    Map.Entry localEntry = (Map.Entry)((Iterator)q()).next();
    this.c.add(localEntry.getValue());
    this.c.add(new pg((String)localEntry.getKey()));
  }
  
  public String toString()
  {
    return getClass().getSimpleName();
  }
}


/* Location:           C:\Users\dreadiscool\Desktop\tools\classes-dex2jar.jar
 * Qualified Name:     qn
 * JD-Core Version:    0.7.0.1
 */