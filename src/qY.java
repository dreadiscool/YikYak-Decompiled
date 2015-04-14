import java.util.Iterator;
import java.util.Map.Entry;
import java.util.Set;

final class qY
  extends pm<pb>
{
  public pb a(ro paramro)
  {
    Object localObject;
    switch (rf.a[paramro.f().ordinal()])
    {
    default: 
      throw new IllegalArgumentException();
    case 3: 
      localObject = new pg(paramro.h());
    }
    for (;;)
    {
      return localObject;
      localObject = new pg(new pN(paramro.h()));
      continue;
      localObject = new pg(Boolean.valueOf(paramro.i()));
      continue;
      paramro.j();
      localObject = pd.a;
      continue;
      localObject = new oZ();
      paramro.a();
      while (paramro.e()) {
        ((oZ)localObject).a(a(paramro));
      }
      paramro.b();
      continue;
      localObject = new pe();
      paramro.c();
      while (paramro.e()) {
        ((pe)localObject).a(paramro.g(), a(paramro));
      }
      paramro.d();
    }
  }
  
  public void a(rr paramrr, pb parampb)
  {
    if ((parampb == null) || (parampb.j())) {
      paramrr.f();
    }
    for (;;)
    {
      return;
      if (parampb.i())
      {
        pg localpg = parampb.m();
        if (localpg.p()) {
          paramrr.a(localpg.a());
        } else if (localpg.o()) {
          paramrr.a(localpg.f());
        } else {
          paramrr.b(localpg.b());
        }
      }
      else if (parampb.g())
      {
        paramrr.b();
        Iterator localIterator2 = parampb.l().iterator();
        while (localIterator2.hasNext()) {
          a(paramrr, (pb)localIterator2.next());
        }
        paramrr.c();
      }
      else
      {
        if (!parampb.h()) {
          break;
        }
        paramrr.d();
        Iterator localIterator1 = parampb.k().o().iterator();
        while (localIterator1.hasNext())
        {
          Map.Entry localEntry = (Map.Entry)localIterator1.next();
          paramrr.a((String)localEntry.getKey());
          a(paramrr, (pb)localEntry.getValue());
        }
        paramrr.e();
      }
    }
    throw new IllegalArgumentException("Couldn't write " + parampb.getClass());
  }
}


/* Location:           C:\Users\dreadiscool\Desktop\tools\classes-dex2jar.jar
 * Qualified Name:     qY
 * JD-Core Version:    0.7.0.1
 */