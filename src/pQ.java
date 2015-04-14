import java.util.AbstractSet;
import java.util.Iterator;
import java.util.Map.Entry;

class pQ
  extends AbstractSet<Map.Entry<K, V>>
{
  pQ(pO parampO) {}
  
  public void clear()
  {
    this.a.clear();
  }
  
  public boolean contains(Object paramObject)
  {
    if (((paramObject instanceof Map.Entry)) && (this.a.a((Map.Entry)paramObject) != null)) {}
    for (boolean bool = true;; bool = false) {
      return bool;
    }
  }
  
  public Iterator<Map.Entry<K, V>> iterator()
  {
    return new pR(this);
  }
  
  public boolean remove(Object paramObject)
  {
    boolean bool = false;
    if (!(paramObject instanceof Map.Entry)) {}
    for (;;)
    {
      return bool;
      pV localpV = this.a.a((Map.Entry)paramObject);
      if (localpV != null)
      {
        this.a.a(localpV, true);
        bool = true;
      }
    }
  }
  
  public int size()
  {
    return this.a.c;
  }
}


/* Location:           C:\Users\dreadiscool\Desktop\tools\classes-dex2jar.jar
 * Qualified Name:     pQ
 * JD-Core Version:    0.7.0.1
 */