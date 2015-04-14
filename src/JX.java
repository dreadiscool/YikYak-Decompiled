import java.util.Collection;
import java.util.concurrent.Callable;
import java.util.concurrent.FutureTask;

public class JX<V>
  extends FutureTask<V>
  implements JP<Kc>, JY, Kc
{
  final Object b = a(paramCallable);
  
  public JX(Runnable paramRunnable, V paramV)
  {
    super(paramRunnable, paramV);
  }
  
  public JX(Callable<V> paramCallable)
  {
    super(paramCallable);
  }
  
  public <T extends JP<Kc>,  extends JY,  extends Kc> T a()
  {
    return (JP)this.b;
  }
  
  protected <T extends JP<Kc>,  extends JY,  extends Kc> T a(Object paramObject)
  {
    if (JZ.a(paramObject)) {}
    for (Object localObject = (JP)paramObject;; localObject = new JZ()) {
      return localObject;
    }
  }
  
  public void a(Kc paramKc)
  {
    ((JP)a()).c(paramKc);
  }
  
  public void a(Throwable paramThrowable)
  {
    ((Kc)a()).a(paramThrowable);
  }
  
  public JS b()
  {
    return ((JY)a()).b();
  }
  
  public void b(boolean paramBoolean)
  {
    ((Kc)a()).b(paramBoolean);
  }
  
  public Collection<Kc> c()
  {
    return ((JP)a()).c();
  }
  
  public int compareTo(Object paramObject)
  {
    return ((JY)a()).compareTo(paramObject);
  }
  
  public boolean d()
  {
    return ((JP)a()).d();
  }
  
  public boolean e()
  {
    return ((Kc)a()).e();
  }
}


/* Location:           C:\Users\dreadiscool\Desktop\tools\classes-dex2jar.jar
 * Qualified Name:     JX
 * JD-Core Version:    0.7.0.1
 */