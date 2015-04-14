import java.util.ArrayList;
import java.util.List;
import java.util.Map;

public final class qt
  extends pm<Object>
{
  public static final pn a = new qu();
  private final oR b;
  
  private qt(oR paramoR)
  {
    this.b = paramoR;
  }
  
  public void a(rr paramrr, Object paramObject)
  {
    if (paramObject == null) {
      paramrr.f();
    }
    for (;;)
    {
      return;
      pm localpm = this.b.a(paramObject.getClass());
      if ((localpm instanceof qt))
      {
        paramrr.d();
        paramrr.e();
      }
      else
      {
        localpm.a(paramrr, paramObject);
      }
    }
  }
  
  public Object b(ro paramro)
  {
    rq localrq = paramro.f();
    Object localObject;
    switch (qv.a[localrq.ordinal()])
    {
    default: 
      throw new IllegalStateException();
    case 1: 
      localObject = new ArrayList();
      paramro.a();
      while (paramro.e()) {
        ((List)localObject).add(b(paramro));
      }
      paramro.b();
    }
    for (;;)
    {
      return localObject;
      localObject = new pO();
      paramro.c();
      while (paramro.e()) {
        ((Map)localObject).put(paramro.g(), b(paramro));
      }
      paramro.d();
      continue;
      localObject = paramro.h();
      continue;
      localObject = Double.valueOf(paramro.k());
      continue;
      localObject = Boolean.valueOf(paramro.i());
      continue;
      paramro.j();
      localObject = null;
    }
  }
}


/* Location:           C:\Users\dreadiscool\Desktop\tools\classes-dex2jar.jar
 * Qualified Name:     qt
 * JD-Core Version:    0.7.0.1
 */