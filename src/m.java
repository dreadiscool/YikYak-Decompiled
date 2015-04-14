import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;
import java.util.List;
import java.util.concurrent.Callable;
import java.util.concurrent.Executor;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.atomic.AtomicBoolean;
import java.util.concurrent.atomic.AtomicInteger;

public class m<TResult>
{
  public static final ExecutorService a = ;
  public static final Executor b = b.b();
  private static final Executor c = h.b();
  private final Object d = new Object();
  private boolean e;
  private boolean f;
  private TResult g;
  private Exception h;
  private List<l<TResult, Void>> i = new ArrayList();
  
  public static <TResult> m<TResult> a(Exception paramException)
  {
    y localy = a();
    localy.b(paramException);
    return localy.a();
  }
  
  public static <TResult> m<TResult> a(TResult paramTResult)
  {
    y localy = a();
    localy.b(paramTResult);
    return localy.a();
  }
  
  public static m<Void> a(Collection<? extends m<?>> paramCollection)
  {
    if (paramCollection.size() == 0) {}
    y localy;
    for (m localm = a(null);; localm = localy.a())
    {
      return localm;
      localy = a();
      ArrayList localArrayList = new ArrayList();
      Object localObject = new Object();
      AtomicInteger localAtomicInteger = new AtomicInteger(paramCollection.size());
      AtomicBoolean localAtomicBoolean = new AtomicBoolean(false);
      Iterator localIterator = paramCollection.iterator();
      while (localIterator.hasNext()) {
        ((m)localIterator.next()).a(new r(localObject, localArrayList, localAtomicBoolean, localAtomicInteger, localy));
      }
    }
  }
  
  public static <TResult> m<TResult> a(Callable<TResult> paramCallable)
  {
    return a(paramCallable, a);
  }
  
  public static <TResult> m<TResult> a(Callable<TResult> paramCallable, Executor paramExecutor)
  {
    y localy = a();
    paramExecutor.execute(new q(localy, paramCallable));
    return localy.a();
  }
  
  public static <TResult> m<TResult>.y a()
  {
    m localm = new m();
    localm.getClass();
    return new y(localm, null);
  }
  
  public static <TResult> m<TResult> b(Callable<TResult> paramCallable)
  {
    return a(paramCallable, c);
  }
  
  private static <TContinuationResult, TResult> void c(m<TContinuationResult>.y paramm, l<TResult, TContinuationResult> paraml, m<TResult> paramm1, Executor paramExecutor)
  {
    paramExecutor.execute(new x(paraml, paramm1, paramm));
  }
  
  private static <TContinuationResult, TResult> void d(m<TContinuationResult>.y paramm, l<TResult, m<TContinuationResult>> paraml, m<TResult> paramm1, Executor paramExecutor)
  {
    paramExecutor.execute(new o(paraml, paramm1, paramm));
  }
  
  public static <TResult> m<TResult> h()
  {
    y localy = a();
    localy.c();
    return localy.a();
  }
  
  private void k()
  {
    for (;;)
    {
      l locall;
      synchronized (this.d)
      {
        Iterator localIterator = this.i.iterator();
        if (!localIterator.hasNext()) {
          break;
        }
        locall = (l)localIterator.next();
      }
      try
      {
        locall.then(this);
      }
      catch (RuntimeException localRuntimeException)
      {
        throw localRuntimeException;
        localObject2 = finally;
        throw localObject2;
      }
      catch (Exception localException)
      {
        throw new RuntimeException(localException);
      }
    }
    this.i = null;
  }
  
  public m<Void> a(Callable<Boolean> paramCallable, l<Void, m<Void>> paraml)
  {
    return a(paramCallable, paraml, c);
  }
  
  public m<Void> a(Callable<Boolean> paramCallable, l<Void, m<Void>> paraml, Executor paramExecutor)
  {
    k localk = new k();
    localk.a(new s(this, paramCallable, paraml, paramExecutor, localk));
    return j().b((l)localk.a(), paramExecutor);
  }
  
  public <TContinuationResult> m<TContinuationResult> a(l<TResult, TContinuationResult> paraml)
  {
    return a(paraml, c);
  }
  
  public <TContinuationResult> m<TContinuationResult> a(l<TResult, TContinuationResult> paraml, Executor paramExecutor)
  {
    y localy = a();
    synchronized (this.d)
    {
      boolean bool = b();
      if (!bool) {
        this.i.add(new t(this, localy, paraml, paramExecutor));
      }
      if (bool) {
        c(localy, paraml, this, paramExecutor);
      }
      return localy.a();
    }
  }
  
  public <TContinuationResult> m<TContinuationResult> b(l<TResult, m<TContinuationResult>> paraml)
  {
    return b(paraml, c);
  }
  
  public <TContinuationResult> m<TContinuationResult> b(l<TResult, m<TContinuationResult>> paraml, Executor paramExecutor)
  {
    y localy = a();
    synchronized (this.d)
    {
      boolean bool = b();
      if (!bool) {
        this.i.add(new u(this, localy, paraml, paramExecutor));
      }
      if (bool) {
        d(localy, paraml, this, paramExecutor);
      }
      return localy.a();
    }
  }
  
  public boolean b()
  {
    synchronized (this.d)
    {
      boolean bool = this.e;
      return bool;
    }
  }
  
  public <TContinuationResult> m<TContinuationResult> c(l<TResult, TContinuationResult> paraml)
  {
    return c(paraml, c);
  }
  
  public <TContinuationResult> m<TContinuationResult> c(l<TResult, TContinuationResult> paraml, Executor paramExecutor)
  {
    return b(new v(this, paraml), paramExecutor);
  }
  
  public boolean c()
  {
    synchronized (this.d)
    {
      boolean bool = this.f;
      return bool;
    }
  }
  
  public <TContinuationResult> m<TContinuationResult> d(l<TResult, m<TContinuationResult>> paraml)
  {
    return d(paraml, c);
  }
  
  public <TContinuationResult> m<TContinuationResult> d(l<TResult, m<TContinuationResult>> paraml, Executor paramExecutor)
  {
    return b(new w(this, paraml), paramExecutor);
  }
  
  public boolean d()
  {
    for (;;)
    {
      synchronized (this.d)
      {
        if (this.h != null)
        {
          bool = true;
          return bool;
        }
      }
      boolean bool = false;
    }
  }
  
  public TResult e()
  {
    synchronized (this.d)
    {
      Object localObject3 = this.g;
      return localObject3;
    }
  }
  
  public Exception f()
  {
    synchronized (this.d)
    {
      Exception localException = this.h;
      return localException;
    }
  }
  
  public void g()
  {
    synchronized (this.d)
    {
      if (!b()) {
        this.d.wait();
      }
      return;
    }
  }
  
  public <TOut> m<TOut> i()
  {
    return this;
  }
  
  public m<Void> j()
  {
    return b(new n(this));
  }
}


/* Location:           C:\Users\dreadiscool\Desktop\tools\classes-dex2jar.jar
 * Qualified Name:     m
 * JD-Core Version:    0.7.0.1
 */