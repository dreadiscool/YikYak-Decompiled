import android.os.Message;
import java.util.concurrent.BlockingQueue;
import java.util.concurrent.Executor;
import java.util.concurrent.FutureTask;
import java.util.concurrent.LinkedBlockingQueue;
import java.util.concurrent.ThreadFactory;
import java.util.concurrent.ThreadPoolExecutor;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.atomic.AtomicBoolean;

public abstract class JE<Params, Progress, Result>
{
  private static final int a = Runtime.getRuntime().availableProcessors();
  public static final Executor b = new ThreadPoolExecutor(d, e, 1L, TimeUnit.SECONDS, g, f);
  public static final Executor c = new JL(null);
  private static final int d = 1 + a;
  private static final int e = 1 + 2 * a;
  private static final ThreadFactory f = new JF();
  private static final BlockingQueue<Runnable> g = new LinkedBlockingQueue(128);
  private static final JK h = new JK();
  private static volatile Executor i = c;
  private final JO<Params, Result> j = new JG(this);
  private final FutureTask<Result> k = new JH(this, this.j);
  private volatile JN l = JN.a;
  private final AtomicBoolean m = new AtomicBoolean();
  private final AtomicBoolean n = new AtomicBoolean();
  
  private void d(Result paramResult)
  {
    if (!this.n.get()) {
      e(paramResult);
    }
  }
  
  private Result e(Result paramResult)
  {
    JK localJK = h;
    Object[] arrayOfObject = new Object[1];
    arrayOfObject[0] = paramResult;
    localJK.obtainMessage(1, new JJ(this, arrayOfObject)).sendToTarget();
    return paramResult;
  }
  
  private void f(Result paramResult)
  {
    if (b_()) {
      b(paramResult);
    }
    for (;;)
    {
      this.l = JN.c;
      return;
      a(paramResult);
    }
  }
  
  public final JE<Params, Progress, Result> a(Executor paramExecutor, Params... paramVarArgs)
  {
    if (this.l != JN.a) {}
    switch (JI.a[this.l.ordinal()])
    {
    default: 
      this.l = JN.b;
      a();
      this.j.b = paramVarArgs;
      paramExecutor.execute(this.k);
      return this;
    case 1: 
      throw new IllegalStateException("Cannot execute task: the task is already running.");
    }
    throw new IllegalStateException("Cannot execute task: the task has already been executed (a task can be executed only once)");
  }
  
  protected abstract Result a(Params... paramVarArgs);
  
  protected void a() {}
  
  protected void a(Result paramResult) {}
  
  public final boolean a(boolean paramBoolean)
  {
    this.m.set(true);
    return this.k.cancel(paramBoolean);
  }
  
  public final JN a_()
  {
    return this.l;
  }
  
  protected void b(Result paramResult) {}
  
  protected void b(Progress... paramVarArgs) {}
  
  public final boolean b_()
  {
    return this.m.get();
  }
}


/* Location:           C:\Users\dreadiscool\Desktop\tools\classes-dex2jar.jar
 * Qualified Name:     JE
 * JD-Core Version:    0.7.0.1
 */