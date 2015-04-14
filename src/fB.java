import android.text.TextUtils;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import java.util.Set;

public class fB
{
  private final Map<String, Integer> a = new HashMap();
  private final Map<String, String> b = new HashMap();
  private final boolean c;
  private final String d;
  
  public fB(String paramString, boolean paramBoolean)
  {
    this.c = paramBoolean;
    this.d = paramString;
  }
  
  public String a()
  {
    if (!this.c) {}
    StringBuilder localStringBuilder;
    for (String str1 = "";; str1 = localStringBuilder.toString())
    {
      return str1;
      localStringBuilder = new StringBuilder();
      localStringBuilder.append(this.d);
      Iterator localIterator1 = this.a.keySet().iterator();
      while (localIterator1.hasNext())
      {
        String str3 = (String)localIterator1.next();
        localStringBuilder.append("&").append(str3).append("=").append(this.a.get(str3));
      }
      Iterator localIterator2 = this.b.keySet().iterator();
      while (localIterator2.hasNext())
      {
        String str2 = (String)localIterator2.next();
        localStringBuilder.append("&").append(str2).append("=").append((String)this.b.get(str2));
      }
    }
  }
  
  public void a(String paramString, int paramInt)
  {
    if (!this.c) {}
    for (;;)
    {
      return;
      Integer localInteger = (Integer)this.a.get(paramString);
      if (localInteger == null) {
        localInteger = Integer.valueOf(0);
      }
      this.a.put(paramString, Integer.valueOf(paramInt + localInteger.intValue()));
    }
  }
  
  public void a(String paramString1, String paramString2)
  {
    if ((!this.c) || (TextUtils.isEmpty(paramString1))) {}
    for (;;)
    {
      return;
      this.b.put(paramString1, paramString2);
    }
  }
}


/* Location:           C:\Users\dreadiscool\Desktop\tools\classes-dex2jar.jar
 * Qualified Name:     fB
 * JD-Core Version:    0.7.0.1
 */