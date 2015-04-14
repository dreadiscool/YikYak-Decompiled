import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Set;

public class fT
{
  Map<String, String> a = new HashMap();
  
  public Map<String, String> a(String paramString)
  {
    HashMap localHashMap = new HashMap();
    Iterator localIterator = this.a.entrySet().iterator();
    while (localIterator.hasNext())
    {
      Map.Entry localEntry = (Map.Entry)localIterator.next();
      localHashMap.put(paramString + (String)localEntry.getKey(), localEntry.getValue());
    }
    return localHashMap;
  }
}


/* Location:           C:\Users\dreadiscool\Desktop\tools\classes-dex2jar.jar
 * Qualified Name:     fT
 * JD-Core Version:    0.7.0.1
 */