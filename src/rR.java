import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Set;

class rR
{
  private static final Object a = null;
  private static Long b = new Long(0L);
  private static Double c = new Double(0.0D);
  private static rQ d = rQ.a(0L);
  private static String e = new String("");
  private static Boolean f = new Boolean(false);
  private static List<Object> g = new ArrayList(0);
  private static Map<Object, Object> h = new HashMap();
  private static dQ i = a(e);
  
  public static dQ a()
  {
    return i;
  }
  
  public static dQ a(Object paramObject)
  {
    int j = 0;
    dS localdS = dQ.F();
    dQ localdQ1;
    if ((paramObject instanceof dQ))
    {
      localdQ1 = (dQ)paramObject;
      return localdQ1;
    }
    if ((paramObject instanceof String)) {
      localdS.a(dV.a).a((String)paramObject);
    }
    for (;;)
    {
      if (j != 0) {
        localdS.b(true);
      }
      localdQ1 = localdS.c();
      break;
      if ((paramObject instanceof List))
      {
        localdS.a(dV.b);
        Iterator localIterator2 = ((List)paramObject).iterator();
        int n = 0;
        if (localIterator2.hasNext())
        {
          dQ localdQ4 = a(localIterator2.next());
          if (localdQ4 == i)
          {
            localdQ1 = i;
            break;
          }
          if ((n != 0) || (localdQ4.E())) {}
          for (n = 1;; n = 0)
          {
            localdS.b(localdQ4);
            break;
          }
        }
        j = n;
        continue;
      }
      if ((paramObject instanceof Map))
      {
        localdS.a(dV.c);
        Iterator localIterator1 = ((Map)paramObject).entrySet().iterator();
        int k = 0;
        if (localIterator1.hasNext())
        {
          Map.Entry localEntry = (Map.Entry)localIterator1.next();
          dQ localdQ2 = a(localEntry.getKey());
          dQ localdQ3 = a(localEntry.getValue());
          if ((localdQ2 == i) || (localdQ3 == i))
          {
            localdQ1 = i;
            break;
          }
          if ((k != 0) || (localdQ2.E()) || (localdQ3.E())) {}
          for (int m = 1;; m = 0)
          {
            localdS.c(localdQ2);
            localdS.d(localdQ3);
            k = m;
            break;
          }
        }
        j = k;
        continue;
      }
      if (b(paramObject))
      {
        localdS.a(dV.a).a(paramObject.toString());
      }
      else if (c(paramObject))
      {
        localdS.a(dV.f).a(d(paramObject));
      }
      else
      {
        if (!(paramObject instanceof Boolean)) {
          break label407;
        }
        localdS.a(dV.h).a(((Boolean)paramObject).booleanValue());
      }
    }
    label407:
    StringBuilder localStringBuilder = new StringBuilder().append("Converting to Value from unknown object type: ");
    if (paramObject == null) {}
    for (String str = "null";; str = paramObject.getClass().toString())
    {
      rB.a(str);
      localdQ1 = i;
      break;
    }
  }
  
  private static boolean b(Object paramObject)
  {
    if (((paramObject instanceof Double)) || ((paramObject instanceof Float)) || (((paramObject instanceof rQ)) && (((rQ)paramObject).a()))) {}
    for (boolean bool = true;; bool = false) {
      return bool;
    }
  }
  
  private static boolean c(Object paramObject)
  {
    if (((paramObject instanceof Byte)) || ((paramObject instanceof Short)) || ((paramObject instanceof Integer)) || ((paramObject instanceof Long)) || (((paramObject instanceof rQ)) && (((rQ)paramObject).b()))) {}
    for (boolean bool = true;; bool = false) {
      return bool;
    }
  }
  
  private static long d(Object paramObject)
  {
    if ((paramObject instanceof Number)) {}
    for (long l = ((Number)paramObject).longValue();; l = 0L)
    {
      return l;
      rB.a("getInt64 received non-Number");
    }
  }
}


/* Location:           C:\Users\dreadiscool\Desktop\tools\classes-dex2jar.jar
 * Qualified Name:     rR
 * JD-Core Version:    0.7.0.1
 */