package android.support.v4.util;

public abstract interface Pools$Pool<T>
{
  public abstract T acquire();
  
  public abstract boolean release(T paramT);
}


/* Location:           C:\Users\dreadiscool\Desktop\tools\classes-dex2jar.jar
 * Qualified Name:     android.support.v4.util.Pools.Pool
 * JD-Core Version:    0.7.0.1
 */