import android.text.TextUtils;
import java.io.UnsupportedEncodingException;
import java.net.URLEncoder;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Set;

class eN
{
  static String a(eM parameM, long paramLong)
  {
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append(parameM.a());
    if (parameM.c() > 0L)
    {
      long l = paramLong - parameM.c();
      if (l >= 0L) {
        localStringBuilder.append("&qt").append("=").append(l);
      }
    }
    localStringBuilder.append("&z").append("=").append(parameM.b());
    return localStringBuilder.toString();
  }
  
  static String a(String paramString)
  {
    try
    {
      String str = URLEncoder.encode(paramString, "UTF-8");
      return str;
    }
    catch (UnsupportedEncodingException localUnsupportedEncodingException)
    {
      throw new AssertionError("URL encoding failed for: " + paramString);
    }
  }
  
  static Map<String, String> a(Map<String, String> paramMap)
  {
    HashMap localHashMap = new HashMap();
    Iterator localIterator = paramMap.entrySet().iterator();
    while (localIterator.hasNext())
    {
      Map.Entry localEntry = (Map.Entry)localIterator.next();
      if ((((String)localEntry.getKey()).startsWith("&")) && (localEntry.getValue() != null))
      {
        String str = ((String)localEntry.getKey()).substring(1);
        if (!TextUtils.isEmpty(str)) {
          localHashMap.put(str, localEntry.getValue());
        }
      }
    }
    return localHashMap;
  }
}


/* Location:           C:\Users\dreadiscool\Desktop\tools\classes-dex2jar.jar
 * Qualified Name:     eN
 * JD-Core Version:    0.7.0.1
 */