import java.util.Collection;
import java.util.concurrent.ExecutorService;

public abstract class JT<Params, Progress, Result>
  extends JE<Params, Progress, Result>
  implements JP<Kc>, JY, Kc
{
  private final JZ a = new JZ();
  
  public void a(Kc paramKc)
  {
    if (a_() != JN.a) {
      throw new IllegalStateException("Must not add Dependency after task is running");
    }
    ((JP)f()).c(paramKc);
  }
  
  public void a(Throwable paramThrowable)
  {
    ((Kc)f()).a(paramThrowable);
  }
  
  public final void a(ExecutorService paramExecutorService, Params... paramVarArgs)
  {
    super.a(new JU(paramExecutorService, this), paramVarArgs);
  }
  
  public JS b()
  {
    return ((JY)f()).b();
  }
  
  public void b(boolean paramBoolean)
  {
    ((Kc)f()).b(paramBoolean);
  }
  
  public Collection<Kc> c()
  {
    return ((JP)f()).c();
  }
  
  public int compareTo(Object paramObject)
  {
    return JS.a(this, paramObject);
  }
  
  public boolean d()
  {
    return ((JP)f()).d();
  }
  
  public boolean e()
  {
    return ((Kc)f()).e();
  }
  
  public <T extends JP<Kc>,  extends JY,  extends Kc> T f()
  {
    return this.a;
  }
}


/* Location:           C:\Users\dreadiscool\Desktop\tools\classes-dex2jar.jar
 * Qualified Name:     JT
 * JD-Core Version:    0.7.0.1
 */