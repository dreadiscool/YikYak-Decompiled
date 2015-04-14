import java.util.AbstractSet;
import java.util.Iterator;

class pS
  extends AbstractSet<K>
{
  pS(pO parampO) {}
  
  public void clear()
  {
    this.a.clear();
  }
  
  public boolean contains(Object paramObject)
  {
    return this.a.containsKey(paramObject);
  }
  
  public Iterator<K> iterator()
  {
    return new pT(this);
  }
  
  public boolean remove(Object paramObject)
  {
    if (this.a.b(paramObject) != null) {}
    for (boolean bool = true;; bool = false) {
      return bool;
    }
  }
  
  public int size()
  {
    return this.a.c;
  }
}


/* Location:           C:\Users\dreadiscool\Desktop\tools\classes-dex2jar.jar
 * Qualified Name:     pS
 * JD-Core Version:    0.7.0.1
 */