import java.net.Proxy;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Set;
import java.util.TreeMap;
import java.util.TreeSet;

public final class AD
{
  static final String a = zY.a().b();
  public static final String b = a + "-Sent-Millis";
  public static final String c = a + "-Received-Millis";
  public static final String d = a + "-Selected-Protocol";
  private static final Comparator<String> e = new AE();
  
  public static long a(zF paramzF)
  {
    return a(paramzF.g());
  }
  
  public static long a(zo paramzo)
  {
    return b(paramzo.a("Content-Length"));
  }
  
  public static long a(zz paramzz)
  {
    return a(paramzz.e());
  }
  
  private static String a(List<String> paramList)
  {
    if (paramList.size() == 1) {}
    StringBuilder localStringBuilder;
    for (String str = (String)paramList.get(0);; str = localStringBuilder.toString())
    {
      return str;
      localStringBuilder = new StringBuilder();
      int i = paramList.size();
      for (int j = 0; j < i; j++)
      {
        if (j > 0) {
          localStringBuilder.append("; ");
        }
        localStringBuilder.append((String)paramList.get(j));
      }
    }
  }
  
  public static Map<String, List<String>> a(zo paramzo, String paramString)
  {
    TreeMap localTreeMap = new TreeMap(e);
    int i = paramzo.a();
    for (int j = 0; j < i; j++)
    {
      String str1 = paramzo.a(j);
      String str2 = paramzo.b(j);
      ArrayList localArrayList = new ArrayList();
      List localList = (List)localTreeMap.get(str1);
      if (localList != null) {
        localArrayList.addAll(localList);
      }
      localArrayList.add(str2);
      localTreeMap.put(str1, Collections.unmodifiableList(localArrayList));
    }
    if (paramString != null) {
      localTreeMap.put(null, Collections.unmodifiableList(Collections.singletonList(paramString)));
    }
    return Collections.unmodifiableMap(localTreeMap);
  }
  
  public static zz a(yK paramyK, zF paramzF, Proxy paramProxy)
  {
    if (paramzF.c() == 407) {}
    for (zz localzz = paramyK.b(paramProxy, paramzF);; localzz = paramyK.a(paramProxy, paramzF)) {
      return localzz;
    }
  }
  
  public static void a(zB paramzB, Map<String, List<String>> paramMap)
  {
    Iterator localIterator = paramMap.entrySet().iterator();
    while (localIterator.hasNext())
    {
      Map.Entry localEntry = (Map.Entry)localIterator.next();
      String str = (String)localEntry.getKey();
      if ((("Cookie".equalsIgnoreCase(str)) || ("Cookie2".equalsIgnoreCase(str))) && (!((List)localEntry.getValue()).isEmpty())) {
        paramzB.b(str, a((List)localEntry.getValue()));
      }
    }
  }
  
  static boolean a(String paramString)
  {
    if ((!"Connection".equalsIgnoreCase(paramString)) && (!"Keep-Alive".equalsIgnoreCase(paramString)) && (!"Proxy-Authenticate".equalsIgnoreCase(paramString)) && (!"Proxy-Authorization".equalsIgnoreCase(paramString)) && (!"TE".equalsIgnoreCase(paramString)) && (!"Trailers".equalsIgnoreCase(paramString)) && (!"Transfer-Encoding".equalsIgnoreCase(paramString)) && (!"Upgrade".equalsIgnoreCase(paramString))) {}
    for (boolean bool = true;; bool = false) {
      return bool;
    }
  }
  
  public static boolean a(zF paramzF, zo paramzo, zz paramzz)
  {
    Iterator localIterator = d(paramzF).iterator();
    String str;
    do
    {
      if (!localIterator.hasNext()) {
        break;
      }
      str = (String)localIterator.next();
    } while (Ae.a(paramzo.c(str), paramzz.b(str)));
    for (boolean bool = false;; bool = true) {
      return bool;
    }
  }
  
  private static long b(String paramString)
  {
    long l1 = -1L;
    if (paramString == null) {}
    for (;;)
    {
      return l1;
      try
      {
        long l2 = Long.parseLong(paramString);
        l1 = l2;
      }
      catch (NumberFormatException localNumberFormatException) {}
    }
  }
  
  public static List<zd> b(zo paramzo, String paramString)
  {
    ArrayList localArrayList = new ArrayList();
    int i = paramzo.a();
    int j = 0;
    if (j < i)
    {
      if (!paramString.equalsIgnoreCase(paramzo.a(j))) {}
      label191:
      for (;;)
      {
        j++;
        break;
        String str1 = paramzo.b(j);
        int k = 0;
        for (;;)
        {
          if (k >= str1.length()) {
            break label191;
          }
          int m = Am.a(str1, k, " ");
          String str2 = str1.substring(k, m).trim();
          int n = Am.a(str1, m);
          if (!str1.regionMatches(true, n, "realm=\"", 0, "realm=\"".length())) {
            break;
          }
          int i1 = n + "realm=\"".length();
          int i2 = Am.a(str1, i1, "\"");
          String str3 = str1.substring(i1, i2);
          k = Am.a(str1, 1 + Am.a(str1, i2 + 1, ","));
          localArrayList.add(new zd(str2, str3));
        }
      }
    }
    return localArrayList;
  }
  
  public static boolean b(zF paramzF)
  {
    return d(paramzF).contains("*");
  }
  
  public static zo c(zF paramzF)
  {
    Set localSet = d(paramzF);
    if (localSet.isEmpty()) {}
    zq localzq;
    for (zo localzo2 = new zq().a();; localzo2 = localzq.a())
    {
      return localzo2;
      zo localzo1 = paramzF.j().a().e();
      localzq = new zq();
      int i = 0;
      int j = localzo1.a();
      while (i < j)
      {
        String str = localzo1.a(i);
        if (localSet.contains(str)) {
          localzq.a(str, localzo1.b(i));
        }
        i++;
      }
    }
  }
  
  private static Set<String> d(zF paramzF)
  {
    Object localObject = Collections.emptySet();
    zo localzo = paramzF.g();
    int i = localzo.a();
    int j = 0;
    if (j < i)
    {
      if (!"Vary".equalsIgnoreCase(localzo.a(j))) {}
      for (;;)
      {
        j++;
        break;
        String str = localzo.b(j);
        if (((Set)localObject).isEmpty()) {
          localObject = new TreeSet(String.CASE_INSENSITIVE_ORDER);
        }
        String[] arrayOfString = str.split(",");
        int k = arrayOfString.length;
        for (int m = 0; m < k; m++) {
          ((Set)localObject).add(arrayOfString[m].trim());
        }
      }
    }
    return localObject;
  }
}


/* Location:           C:\Users\dreadiscool\Desktop\tools\classes-dex2jar.jar
 * Qualified Name:     AD
 * JD-Core Version:    0.7.0.1
 */