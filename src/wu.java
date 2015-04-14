import android.os.Looper;
import java.util.Collections;
import java.util.HashSet;
import java.util.Set;

class wu<T>
{
  private Set<T> a = new HashSet();
  
  public Set<T> a()
  {
    if (Thread.currentThread() != Looper.getMainLooper().getThread()) {
      throw new RuntimeException("Can't remove an activity when not on the UI thread");
    }
    return Collections.unmodifiableSet(this.a);
  }
  
  public void a(T paramT)
  {
    if (Thread.currentThread() != Looper.getMainLooper().getThread()) {
      throw new RuntimeException("Can't remove an activity when not on the UI thread");
    }
    this.a.remove(paramT);
  }
  
  public void b(T paramT)
  {
    if (Thread.currentThread() != Looper.getMainLooper().getThread()) {
      throw new RuntimeException("Can't add an activity when not on the UI thread");
    }
    this.a.add(paramT);
  }
  
  public boolean b()
  {
    if (Thread.currentThread() != Looper.getMainLooper().getThread()) {
      throw new RuntimeException("Can't check isEmpty() when not on the UI thread");
    }
    return this.a.isEmpty();
  }
}


/* Location:           C:\Users\dreadiscool\Desktop\tools\classes-dex2jar.jar
 * Qualified Name:     wu
 * JD-Core Version:    0.7.0.1
 */