import java.util.ArrayList;
import java.util.concurrent.atomic.AtomicBoolean;
import java.util.concurrent.atomic.AtomicInteger;

final class r
  implements l<Object, Void>
{
  r(Object paramObject, ArrayList paramArrayList, AtomicBoolean paramAtomicBoolean, AtomicInteger paramAtomicInteger, y paramy) {}
  
  public Void a(m<Object> paramm)
  {
    if (paramm.d()) {}
    for (;;)
    {
      synchronized (this.a)
      {
        this.b.add(paramm.f());
        if (paramm.c()) {
          this.c.set(true);
        }
        if (this.d.decrementAndGet() == 0)
        {
          if (this.b.size() == 0) {
            break label172;
          }
          if (this.b.size() == 1) {
            this.e.b((Exception)this.b.get(0));
          }
        }
        else
        {
          return null;
        }
      }
      Throwable[] arrayOfThrowable = (Throwable[])this.b.toArray(new Throwable[this.b.size()]);
      Object[] arrayOfObject = new Object[1];
      arrayOfObject[0] = Integer.valueOf(this.b.size());
      a locala = new a(String.format("There were %d exceptions.", arrayOfObject), arrayOfThrowable);
      this.e.b(locala);
      continue;
      label172:
      if (this.c.get()) {
        this.e.c();
      } else {
        this.e.b(null);
      }
    }
  }
}


/* Location:           C:\Users\dreadiscool\Desktop\tools\classes-dex2jar.jar
 * Qualified Name:     r
 * JD-Core Version:    0.7.0.1
 */