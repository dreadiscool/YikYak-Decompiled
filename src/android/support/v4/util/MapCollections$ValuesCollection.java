package android.support.v4.util;

import java.util.Collection;
import java.util.Iterator;

final class MapCollections$ValuesCollection
  implements Collection<V>
{
  MapCollections$ValuesCollection(MapCollections paramMapCollections) {}
  
  public boolean add(V paramV)
  {
    throw new UnsupportedOperationException();
  }
  
  public boolean addAll(Collection<? extends V> paramCollection)
  {
    throw new UnsupportedOperationException();
  }
  
  public void clear()
  {
    this.this$0.colClear();
  }
  
  public boolean contains(Object paramObject)
  {
    if (this.this$0.colIndexOfValue(paramObject) >= 0) {}
    for (boolean bool = true;; bool = false) {
      return bool;
    }
  }
  
  public boolean containsAll(Collection<?> paramCollection)
  {
    Iterator localIterator = paramCollection.iterator();
    do
    {
      if (!localIterator.hasNext()) {
        break;
      }
    } while (contains(localIterator.next()));
    for (boolean bool = false;; bool = true) {
      return bool;
    }
  }
  
  public boolean isEmpty()
  {
    if (this.this$0.colGetSize() == 0) {}
    for (boolean bool = true;; bool = false) {
      return bool;
    }
  }
  
  public Iterator<V> iterator()
  {
    return new MapCollections.ArrayIterator(this.this$0, 1);
  }
  
  public boolean remove(Object paramObject)
  {
    int i = this.this$0.colIndexOfValue(paramObject);
    if (i >= 0) {
      this.this$0.colRemoveAt(i);
    }
    for (boolean bool = true;; bool = false) {
      return bool;
    }
  }
  
  public boolean removeAll(Collection<?> paramCollection)
  {
    int i = 0;
    int j = this.this$0.colGetSize();
    boolean bool = false;
    while (i < j)
    {
      if (paramCollection.contains(this.this$0.colGetEntry(i, 1)))
      {
        this.this$0.colRemoveAt(i);
        i--;
        j--;
        bool = true;
      }
      i++;
    }
    return bool;
  }
  
  public boolean retainAll(Collection<?> paramCollection)
  {
    int i = 0;
    int j = this.this$0.colGetSize();
    boolean bool = false;
    while (i < j)
    {
      if (!paramCollection.contains(this.this$0.colGetEntry(i, 1)))
      {
        this.this$0.colRemoveAt(i);
        i--;
        j--;
        bool = true;
      }
      i++;
    }
    return bool;
  }
  
  public int size()
  {
    return this.this$0.colGetSize();
  }
  
  public Object[] toArray()
  {
    return this.this$0.toArrayHelper(1);
  }
  
  public <T> T[] toArray(T[] paramArrayOfT)
  {
    return this.this$0.toArrayHelper(paramArrayOfT, 1);
  }
}


/* Location:           C:\Users\dreadiscool\Desktop\tools\classes-dex2jar.jar
 * Qualified Name:     android.support.v4.util.MapCollections.ValuesCollection
 * JD-Core Version:    0.7.0.1
 */