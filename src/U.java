import java.util.concurrent.Callable;

class U
  implements Callable<T>
{
  U(S paramS, Callable paramCallable) {}
  
  public T call()
  {
    try
    {
      Object localObject2 = this.a.call();
      localObject1 = localObject2;
    }
    catch (Exception localException)
    {
      for (;;)
      {
        IC.g();
        Object localObject1 = null;
      }
    }
    return localObject1;
  }
}


/* Location:           C:\Users\dreadiscool\Desktop\tools\classes-dex2jar.jar
 * Qualified Name:     U
 * JD-Core Version:    0.7.0.1
 */