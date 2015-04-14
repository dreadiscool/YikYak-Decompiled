import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.Iterator;
import java.util.List;
import java.util.concurrent.atomic.AtomicBoolean;
import java.util.concurrent.atomic.AtomicReference;

public class JZ
  implements JP<Kc>, JY, Kc
{
  private final List<Kc> a = new ArrayList();
  private final AtomicBoolean b = new AtomicBoolean(false);
  private final AtomicReference<Throwable> c = new AtomicReference(null);
  
  public static boolean a(Object paramObject)
  {
    for (;;)
    {
      try
      {
        JP localJP = (JP)paramObject;
        Kc localKc = (Kc)paramObject;
        JY localJY = (JY)paramObject;
        if ((localJP == null) || (localKc == null) || (localJY == null)) {
          continue;
        }
        bool = true;
      }
      catch (ClassCastException localClassCastException)
      {
        boolean bool = false;
        continue;
      }
      return bool;
      bool = false;
    }
  }
  
  public void a(Kc paramKc)
  {
    try
    {
      this.a.add(paramKc);
      return;
    }
    finally
    {
      localObject = finally;
      throw localObject;
    }
  }
  
  public void a(Throwable paramThrowable)
  {
    this.c.set(paramThrowable);
  }
  
  public JS b()
  {
    return JS.b;
  }
  
  public void b(boolean paramBoolean)
  {
    try
    {
      this.b.set(paramBoolean);
      return;
    }
    finally
    {
      localObject = finally;
      throw localObject;
    }
  }
  
  public Collection<Kc> c()
  {
    try
    {
      Collection localCollection = Collections.unmodifiableCollection(this.a);
      return localCollection;
    }
    finally
    {
      localObject = finally;
      throw localObject;
    }
  }
  
  public int compareTo(Object paramObject)
  {
    return JS.a(this, paramObject);
  }
  
  public boolean d()
  {
    Iterator localIterator = c().iterator();
    do
    {
      if (!localIterator.hasNext()) {
        break;
      }
    } while (((Kc)localIterator.next()).e());
    for (boolean bool = false;; bool = true) {
      return bool;
    }
  }
  
  public boolean e()
  {
    return this.b.get();
  }
}


/* Location:           C:\Users\dreadiscool\Desktop\tools\classes-dex2jar.jar
 * Qualified Name:     JZ
 * JD-Core Version:    0.7.0.1
 */