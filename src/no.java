import java.util.ArrayList;
import java.util.Collection;
import java.util.HashMap;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Set;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.CountDownLatch;
import java.util.concurrent.locks.ReentrantLock;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class no
{
  public static final Object a = new Object();
  static final String[] b = "gtm.lifetime".toString().split("\\.");
  private static final Pattern c = Pattern.compile("(\\d+)\\s*([smhd]?)");
  private final ConcurrentHashMap<ns, Integer> d;
  private final Map<String, Object> e;
  private final ReentrantLock f;
  private final LinkedList<Map<String, Object>> g;
  private final nt h;
  private final CountDownLatch i;
  
  no()
  {
    this(new np());
  }
  
  no(nt paramnt)
  {
    this.h = paramnt;
    this.d = new ConcurrentHashMap();
    this.e = new HashMap();
    this.f = new ReentrantLock();
    this.g = new LinkedList();
    this.i = new CountDownLatch(1);
    a();
  }
  
  static Long a(String paramString)
  {
    Long localLong = null;
    Matcher localMatcher = c.matcher(paramString);
    if (!localMatcher.matches()) {
      nK.c("unknown _lifetime: " + paramString);
    }
    for (;;)
    {
      return localLong;
      long l1;
      try
      {
        long l2 = Long.parseLong(localMatcher.group(1));
        l1 = l2;
        if (l1 <= 0L) {
          nK.c("non-positive _lifetime: " + paramString);
        }
      }
      catch (NumberFormatException localNumberFormatException)
      {
        for (;;)
        {
          nK.b("illegal number in _lifetime value: " + paramString);
          l1 = 0L;
        }
        String str = localMatcher.group(2);
        if (str.length() == 0)
        {
          localLong = Long.valueOf(l1);
          continue;
        }
        switch (str.charAt(0))
        {
        default: 
          nK.b("unknown units in _lifetime: " + paramString);
        }
      }
      continue;
      localLong = Long.valueOf(l1 * 1000L);
      continue;
      localLong = Long.valueOf(60L * (l1 * 1000L));
      continue;
      localLong = Long.valueOf(60L * (60L * (l1 * 1000L)));
      continue;
      localLong = Long.valueOf(24L * (60L * (60L * (l1 * 1000L))));
    }
  }
  
  private void a()
  {
    this.h.a(new nq(this));
  }
  
  private void a(Map<String, Object> paramMap, String paramString, Collection<nr> paramCollection)
  {
    Iterator localIterator = paramMap.entrySet().iterator();
    while (localIterator.hasNext())
    {
      Map.Entry localEntry = (Map.Entry)localIterator.next();
      StringBuilder localStringBuilder = new StringBuilder().append(paramString);
      if (paramString.length() == 0) {}
      String str2;
      for (String str1 = "";; str1 = ".")
      {
        str2 = str1 + (String)localEntry.getKey();
        if (!(localEntry.getValue() instanceof Map)) {
          break label124;
        }
        a((Map)localEntry.getValue(), str2, paramCollection);
        break;
      }
      label124:
      if (!str2.equals("gtm.lifetime")) {
        paramCollection.add(new nr(str2, localEntry.getValue()));
      }
    }
  }
  
  private void b()
  {
    int k;
    for (int j = 0;; j = k)
    {
      Map localMap = (Map)this.g.poll();
      if (localMap != null)
      {
        g(localMap);
        k = j + 1;
        if (k > 500)
        {
          this.g.clear();
          throw new RuntimeException("Seems like an infinite loop of pushing to the data layer");
        }
      }
      else
      {
        return;
      }
    }
  }
  
  private void b(Map<String, Object> paramMap)
  {
    this.f.lock();
    try
    {
      this.g.offer(paramMap);
      if (this.f.getHoldCount() == 1) {
        b();
      }
      c(paramMap);
      return;
    }
    finally
    {
      this.f.unlock();
    }
  }
  
  private void c(Map<String, Object> paramMap)
  {
    Long localLong = d(paramMap);
    if (localLong == null) {}
    for (;;)
    {
      return;
      List localList = f(paramMap);
      localList.remove("gtm.lifetime");
      this.h.a(localList, localLong.longValue());
    }
  }
  
  private Long d(Map<String, Object> paramMap)
  {
    Object localObject = e(paramMap);
    if (localObject == null) {}
    for (Long localLong = null;; localLong = a(localObject.toString())) {
      return localLong;
    }
  }
  
  private Object e(Map<String, Object> paramMap)
  {
    String[] arrayOfString = b;
    int j = arrayOfString.length;
    int k = 0;
    Object localObject2;
    for (Object localObject1 = paramMap;; localObject1 = localObject2)
    {
      String str;
      if (k < j)
      {
        str = arrayOfString[k];
        if (!(localObject1 instanceof Map)) {
          localObject1 = null;
        }
      }
      else
      {
        return localObject1;
      }
      localObject2 = ((Map)localObject1).get(str);
      k++;
    }
  }
  
  private List<nr> f(Map<String, Object> paramMap)
  {
    ArrayList localArrayList = new ArrayList();
    a(paramMap, "", localArrayList);
    return localArrayList;
  }
  
  /* Error */
  private void g(Map<String, Object> paramMap)
  {
    // Byte code:
    //   0: aload_0
    //   1: getfield 76	no:e	Ljava/util/Map;
    //   4: astore_2
    //   5: aload_2
    //   6: monitorenter
    //   7: aload_1
    //   8: invokeinterface 288 1 0
    //   13: invokeinterface 183 1 0
    //   18: astore 4
    //   20: aload 4
    //   22: invokeinterface 188 1 0
    //   27: ifeq +45 -> 72
    //   30: aload 4
    //   32: invokeinterface 192 1 0
    //   37: checkcast 36	java/lang/String
    //   40: astore 5
    //   42: aload_0
    //   43: aload_0
    //   44: aload 5
    //   46: aload_1
    //   47: aload 5
    //   49: invokeinterface 282 2 0
    //   54: invokevirtual 291	no:a	(Ljava/lang/String;Ljava/lang/Object;)Ljava/util/Map;
    //   57: aload_0
    //   58: getfield 76	no:e	Ljava/util/Map;
    //   61: invokevirtual 294	no:a	(Ljava/util/Map;Ljava/util/Map;)V
    //   64: goto -44 -> 20
    //   67: astore_3
    //   68: aload_2
    //   69: monitorexit
    //   70: aload_3
    //   71: athrow
    //   72: aload_2
    //   73: monitorexit
    //   74: aload_0
    //   75: aload_1
    //   76: invokespecial 296	no:h	(Ljava/util/Map;)V
    //   79: return
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	80	0	this	no
    //   0	80	1	paramMap	Map<String, Object>
    //   4	69	2	localMap	Map
    //   67	4	3	localObject	Object
    //   18	13	4	localIterator	Iterator
    //   40	8	5	str	String
    // Exception table:
    //   from	to	target	type
    //   7	70	67	finally
    //   72	74	67	finally
  }
  
  private void h(Map<String, Object> paramMap)
  {
    Iterator localIterator = this.d.keySet().iterator();
    while (localIterator.hasNext()) {
      ((ns)localIterator.next()).a(paramMap);
    }
  }
  
  Map<String, Object> a(String paramString, Object paramObject)
  {
    HashMap localHashMap1 = new HashMap();
    String[] arrayOfString = paramString.toString().split("\\.");
    int j = 0;
    HashMap localHashMap2;
    for (Object localObject = localHashMap1; j < -1 + arrayOfString.length; localObject = localHashMap2)
    {
      localHashMap2 = new HashMap();
      ((Map)localObject).put(arrayOfString[j], localHashMap2);
      j++;
    }
    ((Map)localObject).put(arrayOfString[(-1 + arrayOfString.length)], paramObject);
    return localHashMap1;
  }
  
  void a(List<Object> paramList1, List<Object> paramList2)
  {
    while (paramList2.size() < paramList1.size()) {
      paramList2.add(null);
    }
    int j = 0;
    if (j < paramList1.size())
    {
      Object localObject = paramList1.get(j);
      if ((localObject instanceof List))
      {
        if (!(paramList2.get(j) instanceof List)) {
          paramList2.set(j, new ArrayList());
        }
        a((List)localObject, (List)paramList2.get(j));
      }
      for (;;)
      {
        j++;
        break;
        if ((localObject instanceof Map))
        {
          if (!(paramList2.get(j) instanceof Map)) {
            paramList2.set(j, new HashMap());
          }
          a((Map)localObject, (Map)paramList2.get(j));
        }
        else if (localObject != a)
        {
          paramList2.set(j, localObject);
        }
      }
    }
  }
  
  public void a(Map<String, Object> paramMap)
  {
    try
    {
      this.i.await();
      b(paramMap);
      return;
    }
    catch (InterruptedException localInterruptedException)
    {
      for (;;)
      {
        nK.b("DataLayer.push: unexpected InterruptedException");
      }
    }
  }
  
  void a(Map<String, Object> paramMap1, Map<String, Object> paramMap2)
  {
    Iterator localIterator = paramMap1.keySet().iterator();
    while (localIterator.hasNext())
    {
      String str = (String)localIterator.next();
      Object localObject = paramMap1.get(str);
      if ((localObject instanceof List))
      {
        if (!(paramMap2.get(str) instanceof List)) {
          paramMap2.put(str, new ArrayList());
        }
        a((List)localObject, (List)paramMap2.get(str));
      }
      else if ((localObject instanceof Map))
      {
        if (!(paramMap2.get(str) instanceof Map)) {
          paramMap2.put(str, new HashMap());
        }
        a((Map)localObject, (Map)paramMap2.get(str));
      }
      else
      {
        paramMap2.put(str, localObject);
      }
    }
  }
  
  void a(ns paramns)
  {
    this.d.put(paramns, Integer.valueOf(0));
  }
  
  /* Error */
  public String toString()
  {
    // Byte code:
    //   0: aload_0
    //   1: getfield 76	no:e	Ljava/util/Map;
    //   4: astore_1
    //   5: aload_1
    //   6: monitorenter
    //   7: new 110	java/lang/StringBuilder
    //   10: dup
    //   11: invokespecial 111	java/lang/StringBuilder:<init>	()V
    //   14: astore_2
    //   15: aload_0
    //   16: getfield 76	no:e	Ljava/util/Map;
    //   19: invokeinterface 177 1 0
    //   24: invokeinterface 183 1 0
    //   29: astore 4
    //   31: aload 4
    //   33: invokeinterface 188 1 0
    //   38: ifeq +64 -> 102
    //   41: aload 4
    //   43: invokeinterface 192 1 0
    //   48: checkcast 194	java/util/Map$Entry
    //   51: astore 6
    //   53: iconst_2
    //   54: anewarray 4	java/lang/Object
    //   57: astore 7
    //   59: aload 7
    //   61: iconst_0
    //   62: aload 6
    //   64: invokeinterface 199 1 0
    //   69: aastore
    //   70: aload 7
    //   72: iconst_1
    //   73: aload 6
    //   75: invokeinterface 202 1 0
    //   80: aastore
    //   81: aload_2
    //   82: ldc_w 335
    //   85: aload 7
    //   87: invokestatic 339	java/lang/String:format	(Ljava/lang/String;[Ljava/lang/Object;)Ljava/lang/String;
    //   90: invokevirtual 117	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   93: pop
    //   94: goto -63 -> 31
    //   97: astore_3
    //   98: aload_1
    //   99: monitorexit
    //   100: aload_3
    //   101: athrow
    //   102: aload_2
    //   103: invokevirtual 118	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   106: astore 5
    //   108: aload_1
    //   109: monitorexit
    //   110: aload 5
    //   112: areturn
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	113	0	this	no
    //   4	105	1	localMap	Map
    //   14	89	2	localStringBuilder	StringBuilder
    //   97	4	3	localObject	Object
    //   29	13	4	localIterator	Iterator
    //   106	5	5	str	String
    //   51	23	6	localEntry	Map.Entry
    //   57	29	7	arrayOfObject	Object[]
    // Exception table:
    //   from	to	target	type
    //   7	100	97	finally
    //   102	110	97	finally
  }
}


/* Location:           C:\Users\dreadiscool\Desktop\tools\classes-dex2jar.jar
 * Qualified Name:     no
 * JD-Core Version:    0.7.0.1
 */