package com.adjust.sdk.plugin;

import java.util.Map.Entry;

public class MapEntry<K, V>
  implements Map.Entry<K, V>
{
  private K key;
  private V value;
  
  public MapEntry(K paramK, V paramV)
  {
    this.key = paramK;
    this.value = paramV;
  }
  
  public K getKey()
  {
    return this.key;
  }
  
  public V getValue()
  {
    return this.value;
  }
  
  public V setValue(V paramV)
  {
    this.value = paramV;
    return this.value;
  }
}


/* Location:           C:\Users\dreadiscool\Desktop\tools\classes-dex2jar.jar
 * Qualified Name:     com.adjust.sdk.plugin.MapEntry
 * JD-Core Version:    0.7.0.1
 */