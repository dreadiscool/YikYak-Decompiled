import java.util.Map.Entry;

class sU
  implements Comparable<sP<K, V>.sU>, Map.Entry<K, V>
{
  private final K b;
  private V c;
  
  sU(K paramK, V paramV)
  {
    this.b = paramV;
    Object localObject;
    this.c = localObject;
  }
  
  sU(Map.Entry<K, V> paramEntry)
  {
    this(paramEntry, (Comparable)localObject.getKey(), localObject.getValue());
  }
  
  private boolean a(Object paramObject1, Object paramObject2)
  {
    boolean bool;
    if (paramObject1 == null) {
      if (paramObject2 == null) {
        bool = true;
      }
    }
    for (;;)
    {
      return bool;
      bool = false;
      continue;
      bool = paramObject1.equals(paramObject2);
    }
  }
  
  public int a(sP<K, V>.sU paramsP)
  {
    return a().compareTo(paramsP.a());
  }
  
  public K a()
  {
    return this.b;
  }
  
  public boolean equals(Object paramObject)
  {
    boolean bool = true;
    if (paramObject == this) {}
    for (;;)
    {
      return bool;
      if (!(paramObject instanceof Map.Entry))
      {
        bool = false;
      }
      else
      {
        Map.Entry localEntry = (Map.Entry)paramObject;
        if ((!a(this.b, localEntry.getKey())) || (!a(this.c, localEntry.getValue()))) {
          bool = false;
        }
      }
    }
  }
  
  public V getValue()
  {
    return this.c;
  }
  
  public int hashCode()
  {
    int i = 0;
    int j;
    if (this.b == null)
    {
      j = 0;
      if (this.c != null) {
        break label33;
      }
    }
    for (;;)
    {
      return j ^ i;
      j = this.b.hashCode();
      break;
      label33:
      i = this.c.hashCode();
    }
  }
  
  public V setValue(V paramV)
  {
    sP.a(this.a);
    Object localObject = this.c;
    this.c = paramV;
    return localObject;
  }
  
  public String toString()
  {
    return this.b + "=" + this.c;
  }
}


/* Location:           C:\Users\dreadiscool\Desktop\tools\classes-dex2jar.jar
 * Qualified Name:     sU
 * JD-Core Version:    0.7.0.1
 */