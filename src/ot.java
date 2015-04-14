import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Set;

class ot
{
  private static final Object a = null;
  private static Long b = new Long(0L);
  private static Double c = new Double(0.0D);
  private static os d = os.a(0L);
  private static String e = new String("");
  private static Boolean f = new Boolean(false);
  private static List<Object> g = new ArrayList(0);
  private static Map<Object, Object> h = new HashMap();
  private static hf i = c(e);
  
  public static hf a()
  {
    return i;
  }
  
  private static Boolean a(String paramString)
  {
    Boolean localBoolean;
    if ("true".equalsIgnoreCase(paramString)) {
      localBoolean = Boolean.TRUE;
    }
    for (;;)
    {
      return localBoolean;
      if ("false".equalsIgnoreCase(paramString)) {
        localBoolean = Boolean.FALSE;
      } else {
        localBoolean = f;
      }
    }
  }
  
  public static String a(hf paramhf)
  {
    return a(c(paramhf));
  }
  
  public static String a(Object paramObject)
  {
    if (paramObject == null) {}
    for (String str = e;; str = paramObject.toString()) {
      return str;
    }
  }
  
  public static Boolean b(hf paramhf)
  {
    return b(c(paramhf));
  }
  
  public static Boolean b(Object paramObject)
  {
    if ((paramObject instanceof Boolean)) {}
    for (Boolean localBoolean = (Boolean)paramObject;; localBoolean = a(a(paramObject))) {
      return localBoolean;
    }
  }
  
  public static hf c(Object paramObject)
  {
    boolean bool1 = false;
    hf localhf1 = new hf();
    hf localhf2;
    if ((paramObject instanceof hf))
    {
      localhf2 = (hf)paramObject;
      return localhf2;
    }
    if ((paramObject instanceof String))
    {
      localhf1.a = 1;
      localhf1.b = ((String)paramObject);
    }
    for (;;)
    {
      localhf1.l = bool1;
      localhf2 = localhf1;
      break;
      if ((paramObject instanceof List))
      {
        localhf1.a = 2;
        List localList = (List)paramObject;
        ArrayList localArrayList3 = new ArrayList(localList.size());
        Iterator localIterator2 = localList.iterator();
        boolean bool4 = false;
        if (localIterator2.hasNext())
        {
          hf localhf5 = c(localIterator2.next());
          if (localhf5 == i)
          {
            localhf2 = i;
            break;
          }
          if ((bool4) || (localhf5.l)) {}
          for (boolean bool5 = true;; bool5 = false)
          {
            localArrayList3.add(localhf5);
            bool4 = bool5;
            break;
          }
        }
        localhf1.c = ((hf[])localArrayList3.toArray(new hf[0]));
        bool1 = bool4;
        continue;
      }
      if ((paramObject instanceof Map))
      {
        localhf1.a = 3;
        Set localSet = ((Map)paramObject).entrySet();
        ArrayList localArrayList1 = new ArrayList(localSet.size());
        ArrayList localArrayList2 = new ArrayList(localSet.size());
        Iterator localIterator1 = localSet.iterator();
        boolean bool2 = false;
        if (localIterator1.hasNext())
        {
          Map.Entry localEntry = (Map.Entry)localIterator1.next();
          hf localhf3 = c(localEntry.getKey());
          hf localhf4 = c(localEntry.getValue());
          if ((localhf3 == i) || (localhf4 == i))
          {
            localhf2 = i;
            break;
          }
          if ((bool2) || (localhf3.l) || (localhf4.l)) {}
          for (boolean bool3 = true;; bool3 = false)
          {
            localArrayList1.add(localhf3);
            localArrayList2.add(localhf4);
            bool2 = bool3;
            break;
          }
        }
        localhf1.d = ((hf[])localArrayList1.toArray(new hf[0]));
        localhf1.e = ((hf[])localArrayList2.toArray(new hf[0]));
        bool1 = bool2;
        continue;
      }
      if (d(paramObject))
      {
        localhf1.a = 1;
        localhf1.b = paramObject.toString();
      }
      else if (e(paramObject))
      {
        localhf1.a = 6;
        localhf1.h = f(paramObject);
      }
      else
      {
        if (!(paramObject instanceof Boolean)) {
          break label514;
        }
        localhf1.a = 8;
        localhf1.i = ((Boolean)paramObject).booleanValue();
      }
    }
    label514:
    StringBuilder localStringBuilder = new StringBuilder().append("Converting to Value from unknown object type: ");
    if (paramObject == null) {}
    for (String str = "null";; str = paramObject.getClass().toString())
    {
      nK.a(str);
      localhf2 = i;
      break;
    }
  }
  
  public static Object c(hf paramhf)
  {
    int j = 0;
    Object localObject1;
    if (paramhf == null) {
      localObject1 = a;
    }
    for (;;)
    {
      return localObject1;
      switch (paramhf.a)
      {
      default: 
        nK.a("Failed to convert a value of type: " + paramhf.a);
        localObject1 = a;
        break;
      case 1: 
        localObject1 = paramhf.b;
        break;
      case 2: 
        ArrayList localArrayList = new ArrayList(paramhf.c.length);
        hf[] arrayOfhf2 = paramhf.c;
        int m = arrayOfhf2.length;
        for (;;)
        {
          if (j >= m) {
            break label173;
          }
          Object localObject4 = c(arrayOfhf2[j]);
          if (localObject4 == a)
          {
            localObject1 = a;
            break;
          }
          localArrayList.add(localObject4);
          j++;
        }
        localObject1 = localArrayList;
        break;
      case 3: 
        if (paramhf.d.length != paramhf.e.length)
        {
          nK.a("Converting an invalid value to object: " + paramhf.toString());
          localObject1 = a;
        }
        else
        {
          HashMap localHashMap = new HashMap(paramhf.e.length);
          for (;;)
          {
            if (j >= paramhf.d.length) {
              break label310;
            }
            Object localObject2 = c(paramhf.d[j]);
            Object localObject3 = c(paramhf.e[j]);
            if ((localObject2 == a) || (localObject3 == a))
            {
              localObject1 = a;
              break;
            }
            localHashMap.put(localObject2, localObject3);
            j++;
          }
          localObject1 = localHashMap;
        }
        break;
      case 4: 
        nK.a("Trying to convert a macro reference to object");
        localObject1 = a;
        break;
      case 5: 
        nK.a("Trying to convert a function id to object");
        localObject1 = a;
        break;
      case 6: 
        localObject1 = Long.valueOf(paramhf.h);
        break;
      case 7: 
        StringBuffer localStringBuffer = new StringBuffer();
        hf[] arrayOfhf1 = paramhf.j;
        int k = arrayOfhf1.length;
        for (;;)
        {
          if (j >= k) {
            break label413;
          }
          String str = a(arrayOfhf1[j]);
          if (str == e)
          {
            localObject1 = a;
            break;
          }
          localStringBuffer.append(str);
          j++;
        }
        label413:
        localObject1 = localStringBuffer.toString();
        break;
      case 8: 
        label173:
        label310:
        localObject1 = Boolean.valueOf(paramhf.i);
      }
    }
  }
  
  private static boolean d(Object paramObject)
  {
    if (((paramObject instanceof Double)) || ((paramObject instanceof Float)) || (((paramObject instanceof os)) && (((os)paramObject).a()))) {}
    for (boolean bool = true;; bool = false) {
      return bool;
    }
  }
  
  private static boolean e(Object paramObject)
  {
    if (((paramObject instanceof Byte)) || ((paramObject instanceof Short)) || ((paramObject instanceof Integer)) || ((paramObject instanceof Long)) || (((paramObject instanceof os)) && (((os)paramObject).b()))) {}
    for (boolean bool = true;; bool = false) {
      return bool;
    }
  }
  
  private static long f(Object paramObject)
  {
    if ((paramObject instanceof Number)) {}
    for (long l = ((Number)paramObject).longValue();; l = 0L)
    {
      return l;
      nK.a("getInt64 received non-Number");
    }
  }
}


/* Location:           C:\Users\dreadiscool\Desktop\tools\classes-dex2jar.jar
 * Qualified Name:     ot
 * JD-Core Version:    0.7.0.1
 */