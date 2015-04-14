package android.support.v4.util;

public class Pools$SimplePool<T>
  implements Pools.Pool<T>
{
  private final Object[] mPool;
  private int mPoolSize;
  
  public Pools$SimplePool(int paramInt)
  {
    if (paramInt <= 0) {
      throw new IllegalArgumentException("The max pool size must be > 0");
    }
    this.mPool = new Object[paramInt];
  }
  
  private boolean isInPool(T paramT)
  {
    boolean bool = false;
    for (int i = 0;; i++) {
      if (i < this.mPoolSize)
      {
        if (this.mPool[i] == paramT) {
          bool = true;
        }
      }
      else {
        return bool;
      }
    }
  }
  
  public T acquire()
  {
    Object localObject;
    if (this.mPoolSize > 0)
    {
      int i = -1 + this.mPoolSize;
      localObject = this.mPool[i];
      this.mPool[i] = null;
      this.mPoolSize = (-1 + this.mPoolSize);
    }
    for (;;)
    {
      return localObject;
      localObject = null;
    }
  }
  
  public boolean release(T paramT)
  {
    if (isInPool(paramT)) {
      throw new IllegalStateException("Already in the pool!");
    }
    if (this.mPoolSize < this.mPool.length)
    {
      this.mPool[this.mPoolSize] = paramT;
      this.mPoolSize = (1 + this.mPoolSize);
    }
    for (boolean bool = true;; bool = false) {
      return bool;
    }
  }
}


/* Location:           C:\Users\dreadiscool\Desktop\tools\classes-dex2jar.jar
 * Qualified Name:     android.support.v4.util.Pools.SimplePool
 * JD-Core Version:    0.7.0.1
 */