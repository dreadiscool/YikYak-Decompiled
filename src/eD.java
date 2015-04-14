import com.google.android.gms.analytics.internal.Command;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Set;

class eD
{
  private final Map<String, String> a;
  private final long b;
  private final String c;
  private final List<Command> d;
  
  public eD(Map<String, String> paramMap, long paramLong, String paramString, List<Command> paramList)
  {
    this.a = paramMap;
    this.b = paramLong;
    this.c = paramString;
    this.d = paramList;
  }
  
  public Map<String, String> a()
  {
    return this.a;
  }
  
  public long b()
  {
    return this.b;
  }
  
  public String c()
  {
    return this.c;
  }
  
  public List<Command> d()
  {
    return this.d;
  }
  
  public String toString()
  {
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("PATH: ");
    localStringBuilder.append(this.c);
    if (this.a != null)
    {
      localStringBuilder.append("  PARAMS: ");
      Iterator localIterator = this.a.entrySet().iterator();
      while (localIterator.hasNext())
      {
        Map.Entry localEntry = (Map.Entry)localIterator.next();
        localStringBuilder.append((String)localEntry.getKey());
        localStringBuilder.append("=");
        localStringBuilder.append((String)localEntry.getValue());
        localStringBuilder.append(",  ");
      }
    }
    return localStringBuilder.toString();
  }
}


/* Location:           C:\Users\dreadiscool\Desktop\tools\classes-dex2jar.jar
 * Qualified Name:     eD
 * JD-Core Version:    0.7.0.1
 */