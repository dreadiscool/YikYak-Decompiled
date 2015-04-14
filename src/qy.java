import java.util.Collection;
import java.util.Iterator;
import java.util.Map;

public final class qy<T>
  extends pm<T>
{
  private final pW<T> a;
  private final Map<String, qz> b;
  
  private qy(pW<T> parampW, Map<String, qz> paramMap)
  {
    this.a = parampW;
    this.b = paramMap;
  }
  
  public void a(rr paramrr, T paramT)
  {
    if (paramT == null) {
      paramrr.f();
    }
    for (;;)
    {
      return;
      paramrr.d();
      try
      {
        Iterator localIterator = this.b.values().iterator();
        while (localIterator.hasNext())
        {
          qz localqz = (qz)localIterator.next();
          if (localqz.h)
          {
            paramrr.a(localqz.g);
            localqz.a(paramrr, paramT);
          }
        }
        paramrr.e();
      }
      catch (IllegalAccessException localIllegalAccessException)
      {
        throw new AssertionError();
      }
    }
  }
  
  public T b(ro paramro)
  {
    if (paramro.f() == rq.i) {
      paramro.j();
    }
    Object localObject1;
    for (Object localObject2 = null;; localObject2 = localObject1)
    {
      return localObject2;
      localObject1 = this.a.a();
      try
      {
        paramro.c();
        for (;;)
        {
          if (!paramro.e()) {
            break label115;
          }
          String str = paramro.g();
          localqz = (qz)this.b.get(str);
          if ((localqz != null) && (localqz.i)) {
            break;
          }
          paramro.n();
        }
      }
      catch (IllegalStateException localIllegalStateException)
      {
        for (;;)
        {
          qz localqz;
          throw new pi(localIllegalStateException);
          localqz.a(paramro, localObject1);
        }
      }
      catch (IllegalAccessException localIllegalAccessException)
      {
        throw new AssertionError(localIllegalAccessException);
      }
      label115:
      paramro.d();
    }
  }
}


/* Location:           C:\Users\dreadiscool\Desktop\tools\classes-dex2jar.jar
 * Qualified Name:     qy
 * JD-Core Version:    0.7.0.1
 */