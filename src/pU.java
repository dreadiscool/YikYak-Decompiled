import java.util.ConcurrentModificationException;
import java.util.Iterator;
import java.util.NoSuchElementException;

abstract class pU<T>
  implements Iterator<T>
{
  pV<K, V> b = this.e.e.d;
  pV<K, V> c = null;
  int d = this.e.d;
  
  private pU(pO parampO) {}
  
  final pV<K, V> b()
  {
    pV localpV = this.b;
    if (localpV == this.e.e) {
      throw new NoSuchElementException();
    }
    if (this.e.d != this.d) {
      throw new ConcurrentModificationException();
    }
    this.b = localpV.d;
    this.c = localpV;
    return localpV;
  }
  
  public final boolean hasNext()
  {
    if (this.b != this.e.e) {}
    for (boolean bool = true;; bool = false) {
      return bool;
    }
  }
  
  public final void remove()
  {
    if (this.c == null) {
      throw new IllegalStateException();
    }
    this.e.a(this.c, true);
    this.c = null;
    this.d = this.e.d;
  }
}


/* Location:           C:\Users\dreadiscool\Desktop\tools\classes-dex2jar.jar
 * Qualified Name:     pU
 * JD-Core Version:    0.7.0.1
 */