public abstract class zU
  implements Runnable
{
  protected final String b;
  
  public zU(String paramString, Object... paramVarArgs)
  {
    this.b = String.format(paramString, paramVarArgs);
  }
  
  protected abstract void b();
  
  public final void run()
  {
    String str = Thread.currentThread().getName();
    Thread.currentThread().setName(this.b);
    try
    {
      b();
      return;
    }
    finally
    {
      Thread.currentThread().setName(str);
    }
  }
}


/* Location:           C:\Users\dreadiscool\Desktop\tools\classes-dex2jar.jar
 * Qualified Name:     zU
 * JD-Core Version:    0.7.0.1
 */