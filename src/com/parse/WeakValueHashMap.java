package com.parse;

import java.lang.ref.WeakReference;
import java.util.HashMap;

class WeakValueHashMap<K, V>
{
  private HashMap<K, WeakReference<V>> map = new HashMap();
  
  public void clear()
  {
    this.map.clear();
  }
  
  public V get(K paramK)
  {
    WeakReference localWeakReference = (WeakReference)this.map.get(paramK);
    Object localObject;
    if (localWeakReference == null) {
      localObject = null;
    }
    for (;;)
    {
      return localObject;
      localObject = localWeakReference.get();
      if (localObject == null) {
        this.map.remove(paramK);
      }
    }
  }
  
  public void put(K paramK, V paramV)
  {
    this.map.put(paramK, new WeakReference(paramV));
  }
  
  public void remove(K paramK)
  {
    this.map.remove(paramK);
  }
}


/* Location:           C:\Users\dreadiscool\Desktop\tools\classes-dex2jar.jar
 * Qualified Name:     com.parse.WeakValueHashMap
 * JD-Core Version:    0.7.0.1
 */