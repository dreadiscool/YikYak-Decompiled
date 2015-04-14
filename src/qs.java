import java.lang.reflect.Type;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Set;

final class qs<K, V>
  extends pm<Map<K, V>>
{
  private final pm<K> b;
  private final pm<V> c;
  private final pW<? extends Map<K, V>> d;
  
  public qs(oR paramoR, Type paramType1, pm<K> parampm, Type paramType2, pm<V> parampm1, pW<? extends Map<K, V>> parampW)
  {
    this.b = new qE(paramType1, paramType2, parampm);
    this.c = new qE(paramType1, parampW, parampm1);
    Object localObject;
    this.d = localObject;
  }
  
  private String a(pb parampb)
  {
    pg localpg;
    String str;
    if (parampb.i())
    {
      localpg = parampb.m();
      if (localpg.p()) {
        str = String.valueOf(localpg.a());
      }
    }
    for (;;)
    {
      return str;
      if (localpg.o())
      {
        str = Boolean.toString(localpg.f());
      }
      else if (localpg.q())
      {
        str = localpg.b();
      }
      else
      {
        throw new AssertionError();
        if (!parampb.j()) {
          break;
        }
        str = "null";
      }
    }
    throw new AssertionError();
  }
  
  public Map<K, V> a(ro paramro)
  {
    rq localrq = paramro.f();
    Object localObject1;
    if (localrq == rq.i)
    {
      paramro.j();
      localObject1 = null;
    }
    for (;;)
    {
      return localObject1;
      localObject1 = (Map)this.d.a();
      if (localrq == rq.a)
      {
        paramro.a();
        while (paramro.e())
        {
          paramro.a();
          Object localObject3 = this.b.b(paramro);
          if (((Map)localObject1).put(localObject3, this.c.b(paramro)) != null) {
            throw new pi("duplicate key: " + localObject3);
          }
          paramro.b();
        }
        paramro.b();
      }
      else
      {
        paramro.c();
        while (paramro.e())
        {
          pM.a.a(paramro);
          Object localObject2 = this.b.b(paramro);
          if (((Map)localObject1).put(localObject2, this.c.b(paramro)) != null) {
            throw new pi("duplicate key: " + localObject2);
          }
        }
        paramro.d();
      }
    }
  }
  
  public void a(rr paramrr, Map<K, V> paramMap)
  {
    int i = 0;
    if (paramMap == null) {
      paramrr.f();
    }
    for (;;)
    {
      return;
      if (!qr.a(this.a))
      {
        paramrr.d();
        Iterator localIterator2 = paramMap.entrySet().iterator();
        while (localIterator2.hasNext())
        {
          Map.Entry localEntry2 = (Map.Entry)localIterator2.next();
          paramrr.a(String.valueOf(localEntry2.getKey()));
          this.c.a(paramrr, localEntry2.getValue());
        }
        paramrr.e();
      }
      else
      {
        ArrayList localArrayList1 = new ArrayList(paramMap.size());
        ArrayList localArrayList2 = new ArrayList(paramMap.size());
        Iterator localIterator1 = paramMap.entrySet().iterator();
        int j = 0;
        if (localIterator1.hasNext())
        {
          Map.Entry localEntry1 = (Map.Entry)localIterator1.next();
          pb localpb = this.b.a(localEntry1.getKey());
          localArrayList1.add(localpb);
          localArrayList2.add(localEntry1.getValue());
          if ((localpb.g()) || (localpb.h())) {}
          for (int k = 1;; k = 0)
          {
            j = k | j;
            break;
          }
        }
        if (j != 0)
        {
          paramrr.b();
          while (i < localArrayList1.size())
          {
            paramrr.b();
            pY.a((pb)localArrayList1.get(i), paramrr);
            this.c.a(paramrr, localArrayList2.get(i));
            paramrr.c();
            i++;
          }
          paramrr.c();
        }
        else
        {
          paramrr.d();
          while (i < localArrayList1.size())
          {
            paramrr.a(a((pb)localArrayList1.get(i)));
            this.c.a(paramrr, localArrayList2.get(i));
            i++;
          }
          paramrr.e();
        }
      }
    }
  }
}


/* Location:           C:\Users\dreadiscool\Desktop\tools\classes-dex2jar.jar
 * Qualified Name:     qs
 * JD-Core Version:    0.7.0.1
 */