import java.util.concurrent.Executor;

class JU<Result>
  implements Executor
{
  private final Executor a;
  private final JT b;
  
  public JU(Executor paramExecutor, JT paramJT)
  {
    this.a = paramExecutor;
    this.b = paramJT;
  }
  
  public void execute(Runnable paramRunnable)
  {
    this.a.execute(new JV(this, paramRunnable, null));
  }
}


/* Location:           C:\Users\dreadiscool\Desktop\tools\classes-dex2jar.jar
 * Qualified Name:     JU
 * JD-Core Version:    0.7.0.1
 */