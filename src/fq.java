import android.text.TextUtils;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Set;

public class fq<T extends fq>
{
  fS a;
  Map<String, List<fR>> b = new HashMap();
  List<fT> c = new ArrayList();
  List<fR> d = new ArrayList();
  private Map<String, String> e = new HashMap();
  
  public final T a(String paramString1, String paramString2)
  {
    gH.a().a(gI.a);
    if (paramString1 != null) {
      this.e.put(paramString1, paramString2);
    }
    for (;;)
    {
      return this;
      fA.d(" HitBuilder.set() called with a null paramName.");
    }
  }
  
  public Map<String, String> a()
  {
    HashMap localHashMap = new HashMap(this.e);
    if (this.a != null) {
      localHashMap.putAll(this.a.a());
    }
    Iterator localIterator1 = this.c.iterator();
    for (int i = 1; localIterator1.hasNext(); i++) {
      localHashMap.putAll(((fT)localIterator1.next()).a(go.b(i)));
    }
    Iterator localIterator2 = this.d.iterator();
    for (int j = 1; localIterator2.hasNext(); j++) {
      localHashMap.putAll(((fR)localIterator2.next()).a(go.a(j)));
    }
    Iterator localIterator3 = this.b.entrySet().iterator();
    for (int k = 1; localIterator3.hasNext(); k++)
    {
      Map.Entry localEntry = (Map.Entry)localIterator3.next();
      List localList = (List)localEntry.getValue();
      String str = go.d(k);
      Iterator localIterator4 = localList.iterator();
      for (int m = 1; localIterator4.hasNext(); m++) {
        localHashMap.putAll(((fR)localIterator4.next()).a(str + go.c(m)));
      }
      if (!TextUtils.isEmpty((CharSequence)localEntry.getKey())) {
        localHashMap.put(str + "nm", localEntry.getKey());
      }
    }
    return localHashMap;
  }
  
  public T b(String paramString)
  {
    gH.a().a(gI.d);
    String str = fJ.b(paramString);
    if (TextUtils.isEmpty(str)) {}
    for (;;)
    {
      return this;
      Map localMap = fJ.a(str);
      a("&cc", (String)localMap.get("utm_content"));
      a("&cm", (String)localMap.get("utm_medium"));
      a("&cn", (String)localMap.get("utm_campaign"));
      a("&cs", (String)localMap.get("utm_source"));
      a("&ck", (String)localMap.get("utm_term"));
      a("&ci", (String)localMap.get("utm_id"));
      a("&gclid", (String)localMap.get("gclid"));
      a("&dclid", (String)localMap.get("dclid"));
      a("&gmob_t", (String)localMap.get("gmob_t"));
    }
  }
}


/* Location:           C:\Users\dreadiscool\Desktop\tools\classes-dex2jar.jar
 * Qualified Name:     fq
 * JD-Core Version:    0.7.0.1
 */