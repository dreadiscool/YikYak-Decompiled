import java.util.Map.Entry;

final class pV<K, V>
  implements Map.Entry<K, V>
{
  pV<K, V> a;
  pV<K, V> b;
  pV<K, V> c;
  pV<K, V> d;
  pV<K, V> e;
  final K f;
  V g;
  int h;
  
  pV()
  {
    this.f = null;
    this.e = this;
    this.d = this;
  }
  
  pV(pV<K, V> parampV1, K paramK, pV<K, V> parampV2, pV<K, V> parampV3)
  {
    this.a = parampV1;
    this.f = paramK;
    this.h = 1;
    this.d = parampV2;
    this.e = parampV3;
    parampV3.d = this;
    parampV2.e = this;
  }
  
  public pV<K, V> a()
  {
    pV localpV;
    for (Object localObject = this.b; localObject != null; localObject = localpV)
    {
      localpV = ((pV)localObject).b;
      this = (pV)localObject;
    }
    return this;
  }
  
  public pV<K, V> b()
  {
    pV localpV;
    for (Object localObject = this.c; localObject != null; localObject = localpV)
    {
      localpV = ((pV)localObject).c;
      this = (pV)localObject;
    }
    return this;
  }
  
  public boolean equals(Object paramObject)
  {
    boolean bool = false;
    Map.Entry localEntry;
    if ((paramObject instanceof Map.Entry))
    {
      localEntry = (Map.Entry)paramObject;
      if (this.f != null) {
        break label50;
      }
      if (localEntry.getKey() == null)
      {
        if (this.g != null) {
          break label69;
        }
        if (localEntry.getValue() != null) {}
      }
    }
    for (;;)
    {
      bool = true;
      label50:
      label69:
      do
      {
        do
        {
          return bool;
        } while (!this.f.equals(localEntry.getKey()));
        break;
      } while (!this.g.equals(localEntry.getValue()));
    }
  }
  
  public K getKey()
  {
    return this.f;
  }
  
  public V getValue()
  {
    return this.g;
  }
  
  public int hashCode()
  {
    int i = 0;
    int j;
    if (this.f == null)
    {
      j = 0;
      if (this.g != null) {
        break label33;
      }
    }
    for (;;)
    {
      return j ^ i;
      j = this.f.hashCode();
      break;
      label33:
      i = this.g.hashCode();
    }
  }
  
  public V setValue(V paramV)
  {
    Object localObject = this.g;
    this.g = paramV;
    return localObject;
  }
  
  public String toString()
  {
    return this.f + "=" + this.g;
  }
}


/* Location:           C:\Users\dreadiscool\Desktop\tools\classes-dex2jar.jar
 * Qualified Name:     pV
 * JD-Core Version:    0.7.0.1
 */