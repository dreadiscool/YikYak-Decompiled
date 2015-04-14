import java.lang.reflect.Type;
import java.util.Collection;
import java.util.Iterator;

final class qk<E>
  extends pm<Collection<E>>
{
  private final pm<E> a;
  private final pW<? extends Collection<E>> b;
  
  public qk(oR paramoR, Type paramType, pm<E> parampm, pW<? extends Collection<E>> parampW)
  {
    this.a = new qE(paramoR, parampm, paramType);
    this.b = parampW;
  }
  
  public Collection<E> a(ro paramro)
  {
    Object localObject;
    if (paramro.f() == rq.i)
    {
      paramro.j();
      localObject = null;
    }
    for (;;)
    {
      return localObject;
      localObject = (Collection)this.b.a();
      paramro.a();
      while (paramro.e()) {
        ((Collection)localObject).add(this.a.b(paramro));
      }
      paramro.b();
    }
  }
  
  public void a(rr paramrr, Collection<E> paramCollection)
  {
    if (paramCollection == null) {
      paramrr.f();
    }
    for (;;)
    {
      return;
      paramrr.b();
      Iterator localIterator = paramCollection.iterator();
      while (localIterator.hasNext())
      {
        Object localObject = localIterator.next();
        this.a.a(paramrr, localObject);
      }
      paramrr.c();
    }
  }
}


/* Location:           C:\Users\dreadiscool\Desktop\tools\classes-dex2jar.jar
 * Qualified Name:     qk
 * JD-Core Version:    0.7.0.1
 */