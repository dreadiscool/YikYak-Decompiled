package android.support.v4.util;

import java.util.Iterator;
import java.util.Map.Entry;

final class MapCollections$MapIterator
  implements Iterator<Map.Entry<K, V>>, Map.Entry<K, V>
{
  int mEnd;
  boolean mEntryValid = false;
  int mIndex;
  
  MapCollections$MapIterator(MapCollections paramMapCollections)
  {
    this.mEnd = (-1 + paramMapCollections.colGetSize());
    this.mIndex = -1;
  }
  
  public final boolean equals(Object paramObject)
  {
    int i = 1;
    boolean bool = false;
    if (!this.mEntryValid) {
      throw new IllegalStateException("This container does not support retaining Map.Entry objects");
    }
    if (!(paramObject instanceof Map.Entry)) {
      return bool;
    }
    Map.Entry localEntry = (Map.Entry)paramObject;
    if ((ContainerHelpers.equal(localEntry.getKey(), this.this$0.colGetEntry(this.mIndex, 0))) && (ContainerHelpers.equal(localEntry.getValue(), this.this$0.colGetEntry(this.mIndex, i)))) {}
    for (;;)
    {
      bool = i;
      break;
      i = 0;
    }
  }
  
  public K getKey()
  {
    if (!this.mEntryValid) {
      throw new IllegalStateException("This container does not support retaining Map.Entry objects");
    }
    return this.this$0.colGetEntry(this.mIndex, 0);
  }
  
  public V getValue()
  {
    if (!this.mEntryValid) {
      throw new IllegalStateException("This container does not support retaining Map.Entry objects");
    }
    return this.this$0.colGetEntry(this.mIndex, 1);
  }
  
  public boolean hasNext()
  {
    if (this.mIndex < this.mEnd) {}
    for (boolean bool = true;; bool = false) {
      return bool;
    }
  }
  
  public final int hashCode()
  {
    int i = 0;
    if (!this.mEntryValid) {
      throw new IllegalStateException("This container does not support retaining Map.Entry objects");
    }
    Object localObject1 = this.this$0.colGetEntry(this.mIndex, 0);
    Object localObject2 = this.this$0.colGetEntry(this.mIndex, 1);
    int j;
    if (localObject1 == null)
    {
      j = 0;
      if (localObject2 != null) {
        break label70;
      }
    }
    for (;;)
    {
      return i ^ j;
      j = localObject1.hashCode();
      break;
      label70:
      i = localObject2.hashCode();
    }
  }
  
  public Map.Entry<K, V> next()
  {
    this.mIndex = (1 + this.mIndex);
    this.mEntryValid = true;
    return this;
  }
  
  public void remove()
  {
    if (!this.mEntryValid) {
      throw new IllegalStateException();
    }
    this.this$0.colRemoveAt(this.mIndex);
    this.mIndex = (-1 + this.mIndex);
    this.mEnd = (-1 + this.mEnd);
    this.mEntryValid = false;
  }
  
  public V setValue(V paramV)
  {
    if (!this.mEntryValid) {
      throw new IllegalStateException("This container does not support retaining Map.Entry objects");
    }
    return this.this$0.colSetValue(this.mIndex, paramV);
  }
  
  public final String toString()
  {
    return getKey() + "=" + getValue();
  }
}


/* Location:           C:\Users\dreadiscool\Desktop\tools\classes-dex2jar.jar
 * Qualified Name:     android.support.v4.util.MapCollections.MapIterator
 * JD-Core Version:    0.7.0.1
 */