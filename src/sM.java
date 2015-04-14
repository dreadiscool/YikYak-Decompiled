import java.util.ArrayDeque;
import java.util.Deque;
import java.util.Iterator;
import java.util.NoSuchElementException;

class sM
  implements Iterator<sB>
{
  private final Deque<sJ> a = new ArrayDeque(sJ.b().length);
  private sB b = a(paramrZ);
  
  private sM(rZ paramrZ) {}
  
  private sB a(rZ paramrZ)
  {
    sJ localsJ;
    for (rZ localrZ = paramrZ; (localrZ instanceof sJ); localrZ = sJ.a(localsJ))
    {
      localsJ = (sJ)localrZ;
      this.a.push(localsJ);
    }
    return (sB)localrZ;
  }
  
  private sB b()
  {
    sB localsB;
    if (this.a.isEmpty()) {
      localsB = null;
    }
    for (;;)
    {
      return localsB;
      localsB = a(sJ.b((sJ)this.a.pop()));
      if (localsB.d()) {
        break;
      }
    }
  }
  
  public sB a()
  {
    if (this.b == null) {
      throw new NoSuchElementException();
    }
    sB localsB = this.b;
    this.b = b();
    return localsB;
  }
  
  public boolean hasNext()
  {
    if (this.b != null) {}
    for (boolean bool = true;; bool = false) {
      return bool;
    }
  }
  
  public void remove()
  {
    throw new UnsupportedOperationException();
  }
}


/* Location:           C:\Users\dreadiscool\Desktop\tools\classes-dex2jar.jar
 * Qualified Name:     sM
 * JD-Core Version:    0.7.0.1
 */