import java.util.AbstractSet;
import java.util.Iterator;
import java.util.Map.Entry;

class sW
  extends AbstractSet<Map.Entry<K, V>>
{
  private sW(sP paramsP) {}
  
  public boolean a(Map.Entry<K, V> paramEntry)
  {
    if (!contains(paramEntry)) {
      this.a.a((Comparable)paramEntry.getKey(), paramEntry.getValue());
    }
    for (boolean bool = true;; bool = false) {
      return bool;
    }
  }
  
  public void clear()
  {
    this.a.clear();
  }
  
  public boolean contains(Object paramObject)
  {
    Map.Entry localEntry = (Map.Entry)paramObject;
    Object localObject1 = this.a.get(localEntry.getKey());
    Object localObject2 = localEntry.getValue();
    if ((localObject1 == localObject2) || ((localObject1 != null) && (localObject1.equals(localObject2)))) {}
    for (boolean bool = true;; bool = false) {
      return bool;
    }
  }
  
  public Iterator<Map.Entry<K, V>> iterator()
  {
    return new sV(this.a, null);
  }
  
  public boolean remove(Object paramObject)
  {
    Map.Entry localEntry = (Map.Entry)paramObject;
    if (contains(localEntry)) {
      this.a.remove(localEntry.getKey());
    }
    for (boolean bool = true;; bool = false) {
      return bool;
    }
  }
  
  public int size()
  {
    return this.a.size();
  }
}


/* Location:           C:\Users\dreadiscool\Desktop\tools\classes-dex2jar.jar
 * Qualified Name:     sW
 * JD-Core Version:    0.7.0.1
 */