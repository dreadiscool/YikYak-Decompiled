import java.util.AbstractMap;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Set;
import java.util.SortedMap;
import java.util.TreeMap;

class sP<K extends Comparable<K>, V>
  extends AbstractMap<K, V>
{
  private final int a;
  private List<sP<K, V>.sU> b;
  private Map<K, V> c;
  private boolean d;
  private volatile sP<K, V>.sW e;
  
  private sP(int paramInt)
  {
    this.a = paramInt;
    this.b = Collections.emptyList();
    this.c = Collections.emptyMap();
  }
  
  private int a(K paramK)
  {
    int i = 0;
    int j = -1 + this.b.size();
    int i5;
    int k;
    if (j >= 0)
    {
      i5 = paramK.compareTo(((sU)this.b.get(j)).a());
      if (i5 > 0) {
        k = -(j + 2);
      }
    }
    for (;;)
    {
      return k;
      if (i5 == 0)
      {
        k = j;
      }
      else if (i <= j)
      {
        int m = (i + j) / 2;
        int n = paramK.compareTo(((sU)this.b.get(m)).a());
        int i4;
        int i3;
        if (n < 0)
        {
          i4 = m - 1;
          i3 = i;
        }
        for (;;)
        {
          i = i3;
          j = i4;
          break;
          if (n <= 0) {
            break label153;
          }
          int i1 = m + 1;
          int i2 = j;
          i3 = i1;
          i4 = i2;
        }
        label153:
        k = m;
      }
      else
      {
        k = -(i + 1);
      }
    }
  }
  
  static <FieldDescriptorType extends sk<FieldDescriptorType>> sP<FieldDescriptorType, Object> a(int paramInt)
  {
    return new sQ(paramInt);
  }
  
  private V c(int paramInt)
  {
    e();
    Object localObject = ((sU)this.b.remove(paramInt)).getValue();
    if (!this.c.isEmpty())
    {
      Iterator localIterator = f().entrySet().iterator();
      this.b.add(new sU(this, (Map.Entry)localIterator.next()));
      localIterator.remove();
    }
    return localObject;
  }
  
  private void e()
  {
    if (this.d) {
      throw new UnsupportedOperationException();
    }
  }
  
  private SortedMap<K, V> f()
  {
    e();
    if ((this.c.isEmpty()) && (!(this.c instanceof TreeMap))) {
      this.c = new TreeMap();
    }
    return (SortedMap)this.c;
  }
  
  private void g()
  {
    e();
    if ((this.b.isEmpty()) && (!(this.b instanceof ArrayList))) {
      this.b = new ArrayList(this.a);
    }
  }
  
  public V a(K paramK, V paramV)
  {
    e();
    int i = a(paramK);
    Object localObject;
    if (i >= 0) {
      localObject = ((sU)this.b.get(i)).setValue(paramV);
    }
    for (;;)
    {
      return localObject;
      g();
      int j = -(i + 1);
      if (j >= this.a)
      {
        localObject = f().put(paramK, paramV);
      }
      else
      {
        if (this.b.size() == this.a)
        {
          sU localsU = (sU)this.b.remove(-1 + this.a);
          f().put(localsU.a(), localsU.getValue());
        }
        this.b.add(j, new sU(this, paramK, paramV));
        localObject = null;
      }
    }
  }
  
  public void a()
  {
    if (!this.d) {
      if (!this.c.isEmpty()) {
        break label34;
      }
    }
    label34:
    for (Map localMap = Collections.emptyMap();; localMap = Collections.unmodifiableMap(this.c))
    {
      this.c = localMap;
      this.d = true;
      return;
    }
  }
  
  public Map.Entry<K, V> b(int paramInt)
  {
    return (Map.Entry)this.b.get(paramInt);
  }
  
  public boolean b()
  {
    return this.d;
  }
  
  public int c()
  {
    return this.b.size();
  }
  
  public void clear()
  {
    e();
    if (!this.b.isEmpty()) {
      this.b.clear();
    }
    if (!this.c.isEmpty()) {
      this.c.clear();
    }
  }
  
  public boolean containsKey(Object paramObject)
  {
    Comparable localComparable = (Comparable)paramObject;
    if ((a(localComparable) >= 0) || (this.c.containsKey(localComparable))) {}
    for (boolean bool = true;; bool = false) {
      return bool;
    }
  }
  
  public Iterable<Map.Entry<K, V>> d()
  {
    if (this.c.isEmpty()) {}
    for (Object localObject = sR.a();; localObject = this.c.entrySet()) {
      return localObject;
    }
  }
  
  public Set<Map.Entry<K, V>> entrySet()
  {
    if (this.e == null) {
      this.e = new sW(this, null);
    }
    return this.e;
  }
  
  public V get(Object paramObject)
  {
    Comparable localComparable = (Comparable)paramObject;
    int i = a(localComparable);
    if (i >= 0) {}
    for (Object localObject = ((sU)this.b.get(i)).getValue();; localObject = this.c.get(localComparable)) {
      return localObject;
    }
  }
  
  public V remove(Object paramObject)
  {
    e();
    Comparable localComparable = (Comparable)paramObject;
    int i = a(localComparable);
    Object localObject;
    if (i >= 0) {
      localObject = c(i);
    }
    for (;;)
    {
      return localObject;
      if (this.c.isEmpty()) {
        localObject = null;
      } else {
        localObject = this.c.remove(localComparable);
      }
    }
  }
  
  public int size()
  {
    return this.b.size() + this.c.size();
  }
}


/* Location:           C:\Users\dreadiscool\Desktop\tools\classes-dex2jar.jar
 * Qualified Name:     sP
 * JD-Core Version:    0.7.0.1
 */