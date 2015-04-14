import java.io.Serializable;
import java.util.AbstractMap;
import java.util.Comparator;
import java.util.Map.Entry;
import java.util.Set;

public final class pO<K, V>
  extends AbstractMap<K, V>
  implements Serializable
{
  private static final Comparator<Comparable> g;
  Comparator<? super K> a;
  pV<K, V> b;
  int c = 0;
  int d = 0;
  final pV<K, V> e = new pV();
  private pO<K, V>.pQ h;
  private pO<K, V>.pS i;
  
  static
  {
    if (!pO.class.desiredAssertionStatus()) {}
    for (boolean bool = true;; bool = false)
    {
      f = bool;
      g = new pP();
      return;
    }
  }
  
  public pO()
  {
    this(g);
  }
  
  public pO(Comparator<? super K> paramComparator)
  {
    if (paramComparator != null) {}
    for (;;)
    {
      this.a = paramComparator;
      return;
      paramComparator = g;
    }
  }
  
  private void a(pV<K, V> parampV)
  {
    int j = 0;
    pV localpV1 = parampV.b;
    pV localpV2 = parampV.c;
    pV localpV3 = localpV2.b;
    pV localpV4 = localpV2.c;
    parampV.c = localpV3;
    if (localpV3 != null) {
      localpV3.a = parampV;
    }
    a(parampV, localpV2);
    localpV2.b = parampV;
    parampV.a = localpV2;
    int k;
    if (localpV1 != null)
    {
      k = localpV1.h;
      if (localpV3 == null) {
        break label135;
      }
    }
    label135:
    for (int m = localpV3.h;; m = 0)
    {
      parampV.h = (1 + Math.max(k, m));
      int n = parampV.h;
      if (localpV4 != null) {
        j = localpV4.h;
      }
      localpV2.h = (1 + Math.max(n, j));
      return;
      k = 0;
      break;
    }
  }
  
  private void a(pV<K, V> parampV1, pV<K, V> parampV2)
  {
    pV localpV = parampV1.a;
    parampV1.a = null;
    if (parampV2 != null) {
      parampV2.a = localpV;
    }
    if (localpV != null) {
      if (localpV.b == parampV1) {
        localpV.b = parampV2;
      }
    }
    for (;;)
    {
      return;
      if ((!f) && (localpV.c != parampV1)) {
        throw new AssertionError();
      }
      localpV.c = parampV2;
      continue;
      this.b = parampV2;
    }
  }
  
  private boolean a(Object paramObject1, Object paramObject2)
  {
    if ((paramObject1 == paramObject2) || ((paramObject1 != null) && (paramObject1.equals(paramObject2)))) {}
    for (boolean bool = true;; bool = false) {
      return bool;
    }
  }
  
  private void b(pV<K, V> parampV)
  {
    int j = 0;
    pV localpV1 = parampV.b;
    pV localpV2 = parampV.c;
    pV localpV3 = localpV1.b;
    pV localpV4 = localpV1.c;
    parampV.b = localpV4;
    if (localpV4 != null) {
      localpV4.a = parampV;
    }
    a(parampV, localpV1);
    localpV1.c = parampV;
    parampV.a = localpV1;
    int k;
    if (localpV2 != null)
    {
      k = localpV2.h;
      if (localpV4 == null) {
        break label131;
      }
    }
    label131:
    for (int m = localpV4.h;; m = 0)
    {
      parampV.h = (1 + Math.max(k, m));
      int n = parampV.h;
      if (localpV3 != null) {
        j = localpV3.h;
      }
      localpV1.h = (1 + Math.max(n, j));
      return;
      k = 0;
      break;
    }
  }
  
  private void b(pV<K, V> parampV, boolean paramBoolean)
  {
    pV localpV1;
    pV localpV2;
    int j;
    label25:
    int k;
    label37:
    int m;
    int i3;
    label77:
    int i4;
    label89:
    int i5;
    if (parampV != null)
    {
      localpV1 = parampV.b;
      localpV2 = parampV.c;
      if (localpV1 == null) {
        break label122;
      }
      j = localpV1.h;
      if (localpV2 == null) {
        break label128;
      }
      k = localpV2.h;
      m = j - k;
      if (m != -2) {
        break label180;
      }
      pV localpV5 = localpV2.b;
      pV localpV6 = localpV2.c;
      if (localpV6 == null) {
        break label134;
      }
      i3 = localpV6.h;
      if (localpV5 == null) {
        break label140;
      }
      i4 = localpV5.h;
      i5 = i4 - i3;
      if ((i5 != -1) && ((i5 != 0) || (paramBoolean))) {
        break label146;
      }
      a(parampV);
      label117:
      if (!paramBoolean) {
        break label253;
      }
    }
    label128:
    label134:
    label140:
    label146:
    label180:
    label327:
    for (;;)
    {
      label121:
      return;
      label122:
      j = 0;
      break label25;
      k = 0;
      break label37;
      i3 = 0;
      break label77;
      i4 = 0;
      break label89;
      if ((!f) && (i5 != 1)) {
        throw new AssertionError();
      }
      b(localpV2);
      a(parampV);
      break label117;
      int n;
      label210:
      int i1;
      label222:
      int i2;
      if (m == 2)
      {
        pV localpV3 = localpV1.b;
        pV localpV4 = localpV1.c;
        if (localpV4 != null)
        {
          n = localpV4.h;
          if (localpV3 == null) {
            break label267;
          }
          i1 = localpV3.h;
          i2 = i1 - n;
          if ((i2 != 1) && ((i2 != 0) || (paramBoolean))) {
            break label273;
          }
          b(parampV);
          label249:
          if (paramBoolean) {
            break label305;
          }
        }
      }
      label253:
      do
      {
        do
        {
          parampV = parampV.a;
          break;
          n = 0;
          break label210;
          i1 = 0;
          break label222;
          if ((!f) && (i2 != -1)) {
            throw new AssertionError();
          }
          a(localpV1);
          b(parampV);
          break label249;
          break label121;
          if (m != 0) {
            break label327;
          }
          parampV.h = (j + 1);
        } while (!paramBoolean);
        break label121;
        if ((!f) && (m != -1) && (m != 1)) {
          throw new AssertionError();
        }
        parampV.h = (1 + Math.max(j, k));
      } while (paramBoolean);
    }
  }
  
  pV<K, V> a(Object paramObject)
  {
    Object localObject = null;
    if (paramObject != null) {}
    try
    {
      pV localpV = a(paramObject, false);
      localObject = localpV;
    }
    catch (ClassCastException localClassCastException)
    {
      label17:
      break label17;
    }
    return localObject;
  }
  
  pV<K, V> a(K paramK, boolean paramBoolean)
  {
    Object localObject1 = null;
    Comparator localComparator = this.a;
    Object localObject2 = this.b;
    Comparable localComparable;
    int k;
    if (localObject2 != null) {
      if (localComparator == g)
      {
        localComparable = (Comparable)paramK;
        if (localComparable == null) {
          break label68;
        }
        k = localComparable.compareTo(((pV)localObject2).f);
        label52:
        if (k != 0) {
          break label86;
        }
        localObject1 = localObject2;
      }
    }
    label305:
    for (;;)
    {
      label60:
      return localObject1;
      localComparable = null;
      break;
      label68:
      k = localComparator.compare(paramK, ((pV)localObject2).f);
      break label52;
      label86:
      pV localpV3;
      label98:
      int m;
      Object localObject3;
      if (k < 0)
      {
        localpV3 = ((pV)localObject2).b;
        if (localpV3 != null) {
          break label188;
        }
        m = k;
        localObject3 = localObject2;
      }
      for (int j = m;; j = 0)
      {
        if (!paramBoolean) {
          break label305;
        }
        pV localpV1 = this.e;
        if (localObject3 == null)
        {
          if ((localComparator == g) && (!(paramK instanceof Comparable)))
          {
            throw new ClassCastException(paramK.getClass().getName() + " is not Comparable");
            localpV3 = ((pV)localObject2).c;
            break label98;
            label188:
            localObject2 = localpV3;
            break;
          }
          localpV2 = new pV(localObject3, paramK, localpV1, localpV1.e);
          this.b = localpV2;
          this.c = (1 + this.c);
          this.d = (1 + this.d);
          localObject1 = localpV2;
          break label60;
        }
        pV localpV2 = new pV(localObject3, paramK, localpV1, localpV1.e);
        if (j < 0) {
          localObject3.b = localpV2;
        }
        for (;;)
        {
          b(localObject3, true);
          break;
          localObject3.c = localpV2;
        }
        localObject3 = localObject2;
      }
    }
  }
  
  pV<K, V> a(Map.Entry<?, ?> paramEntry)
  {
    pV localpV = a(paramEntry.getKey());
    int j;
    if ((localpV != null) && (a(localpV.g, paramEntry.getValue())))
    {
      j = 1;
      if (j == 0) {
        break label45;
      }
    }
    for (;;)
    {
      return localpV;
      j = 0;
      break;
      label45:
      localpV = null;
    }
  }
  
  void a(pV<K, V> parampV, boolean paramBoolean)
  {
    int j = 0;
    if (paramBoolean)
    {
      parampV.e.d = parampV.d;
      parampV.d.e = parampV.e;
    }
    pV localpV1 = parampV.b;
    pV localpV2 = parampV.c;
    pV localpV3 = parampV.a;
    pV localpV4;
    int k;
    if ((localpV1 != null) && (localpV2 != null)) {
      if (localpV1.h > localpV2.h)
      {
        localpV4 = localpV1.b();
        a(localpV4, false);
        pV localpV5 = parampV.b;
        if (localpV5 == null) {
          break label264;
        }
        k = localpV5.h;
        localpV4.b = localpV5;
        localpV5.a = localpV4;
        parampV.b = null;
      }
    }
    for (;;)
    {
      pV localpV6 = parampV.c;
      if (localpV6 != null)
      {
        j = localpV6.h;
        localpV4.c = localpV6;
        localpV6.a = localpV4;
        parampV.c = null;
      }
      localpV4.h = (1 + Math.max(k, j));
      a(parampV, localpV4);
      return;
      localpV4 = localpV2.a();
      break;
      if (localpV1 != null)
      {
        a(parampV, localpV1);
        parampV.b = null;
      }
      for (;;)
      {
        b(localpV3, false);
        this.c = (-1 + this.c);
        this.d = (1 + this.d);
        break;
        if (localpV2 != null)
        {
          a(parampV, localpV2);
          parampV.c = null;
        }
        else
        {
          a(parampV, null);
        }
      }
      label264:
      k = 0;
    }
  }
  
  pV<K, V> b(Object paramObject)
  {
    pV localpV = a(paramObject);
    if (localpV != null) {
      a(localpV, true);
    }
    return localpV;
  }
  
  public void clear()
  {
    this.b = null;
    this.c = 0;
    this.d = (1 + this.d);
    pV localpV = this.e;
    localpV.e = localpV;
    localpV.d = localpV;
  }
  
  public boolean containsKey(Object paramObject)
  {
    if (a(paramObject) != null) {}
    for (boolean bool = true;; bool = false) {
      return bool;
    }
  }
  
  public Set<Map.Entry<K, V>> entrySet()
  {
    pQ localpQ = this.h;
    if (localpQ != null) {}
    for (;;)
    {
      return localpQ;
      localpQ = new pQ(this);
      this.h = localpQ;
    }
  }
  
  public V get(Object paramObject)
  {
    pV localpV = a(paramObject);
    if (localpV != null) {}
    for (Object localObject = localpV.g;; localObject = null) {
      return localObject;
    }
  }
  
  public Set<K> keySet()
  {
    pS localpS = this.i;
    if (localpS != null) {}
    for (;;)
    {
      return localpS;
      localpS = new pS(this);
      this.i = localpS;
    }
  }
  
  public V put(K paramK, V paramV)
  {
    if (paramK == null) {
      throw new NullPointerException("key == null");
    }
    pV localpV = a(paramK, true);
    Object localObject = localpV.g;
    localpV.g = paramV;
    return localObject;
  }
  
  public V remove(Object paramObject)
  {
    pV localpV = b(paramObject);
    if (localpV != null) {}
    for (Object localObject = localpV.g;; localObject = null) {
      return localObject;
    }
  }
  
  public int size()
  {
    return this.c;
  }
}


/* Location:           C:\Users\dreadiscool\Desktop\tools\classes-dex2jar.jar
 * Qualified Name:     pO
 * JD-Core Version:    0.7.0.1
 */