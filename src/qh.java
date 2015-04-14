import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.List;

public final class qh<E>
  extends pm<Object>
{
  public static final pn a = new qi();
  private final Class<E> b;
  private final pm<E> c;
  
  public qh(oR paramoR, pm<E> parampm, Class<E> paramClass)
  {
    this.c = new qE(paramoR, parampm, paramClass);
    this.b = paramClass;
  }
  
  public void a(rr paramrr, Object paramObject)
  {
    if (paramObject == null) {
      paramrr.f();
    }
    for (;;)
    {
      return;
      paramrr.b();
      int i = 0;
      int j = Array.getLength(paramObject);
      while (i < j)
      {
        Object localObject = Array.get(paramObject, i);
        this.c.a(paramrr, localObject);
        i++;
      }
      paramrr.c();
    }
  }
  
  public Object b(ro paramro)
  {
    if (paramro.f() == rq.i) {
      paramro.j();
    }
    Object localObject1;
    for (Object localObject2 = null;; localObject2 = localObject1)
    {
      return localObject2;
      ArrayList localArrayList = new ArrayList();
      paramro.a();
      while (paramro.e()) {
        localArrayList.add(this.c.b(paramro));
      }
      paramro.b();
      localObject1 = Array.newInstance(this.b, localArrayList.size());
      for (int i = 0; i < localArrayList.size(); i++) {
        Array.set(localObject1, i, localArrayList.get(i));
      }
    }
  }
}


/* Location:           C:\Users\dreadiscool\Desktop\tools\classes-dex2jar.jar
 * Qualified Name:     qh
 * JD-Core Version:    0.7.0.1
 */