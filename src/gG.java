import android.text.TextUtils;
import java.util.HashMap;
import java.util.Map;

class gG
  implements Runnable
{
  private final Map<String, String> b;
  
  gG(Map<String, String> paramMap)
  {
    Map localMap;
    this.b = new HashMap(localMap);
    String str = (String)localMap.get("&ht");
    if (str != null) {}
    try
    {
      Long.valueOf(str);
      if (str == null)
      {
        long l = System.currentTimeMillis();
        this.b.put("&ht", Long.toString(l));
      }
      return;
    }
    catch (NumberFormatException localNumberFormatException)
    {
      for (;;)
      {
        str = null;
      }
    }
  }
  
  private String a(Map<String, String> paramMap)
  {
    String str;
    if (paramMap.containsKey("useSecure")) {
      if (fJ.a((String)paramMap.get("useSecure"), true)) {
        str = "https:";
      }
    }
    for (;;)
    {
      return str;
      str = "http:";
      continue;
      str = "https:";
    }
  }
  
  private void b(Map<String, String> paramMap)
  {
    gm localgm = fv.a(gC.a(this.a));
    fJ.a(paramMap, "&adid", localgm);
    fJ.a(paramMap, "&ate", localgm);
  }
  
  private void c(Map<String, String> paramMap)
  {
    fV localfV = fV.a();
    fJ.a(paramMap, "&an", localfV);
    fJ.a(paramMap, "&av", localfV);
    fJ.a(paramMap, "&aid", localfV);
    fJ.a(paramMap, "&aiid", localfV);
    paramMap.put("&v", "1");
  }
  
  private boolean d(Map<String, String> paramMap)
  {
    boolean bool;
    if (paramMap.get("&sf") == null) {
      bool = false;
    }
    for (;;)
    {
      return bool;
      double d = fJ.a((String)paramMap.get("&sf"), 100.0D);
      if (d >= 100.0D)
      {
        bool = false;
      }
      else
      {
        if (gC.a((String)paramMap.get("&cid")) % 10000 >= d * 100.0D)
        {
          if (paramMap.get("&t") == null) {}
          for (String str = "unknown";; str = (String)paramMap.get("&t"))
          {
            Object[] arrayOfObject = new Object[1];
            arrayOfObject[0] = str;
            fA.c(String.format("%s hit sampled out", arrayOfObject));
            bool = true;
            break;
          }
        }
        bool = false;
      }
    }
  }
  
  public void run()
  {
    b(this.b);
    if (TextUtils.isEmpty((CharSequence)this.b.get("&cid"))) {
      this.b.put("&cid", ge.a().a("&cid"));
    }
    if ((fl.a(gC.a(this.a)).c()) || (d(this.b))) {}
    for (;;)
    {
      return;
      if (!TextUtils.isEmpty(gC.b(this.a)))
      {
        gH.a().a(true);
        this.b.putAll(new fq().b(gC.b(this.a)).a());
        gH.a().a(false);
        gC.a(this.a, null);
      }
      c(this.b);
      Map localMap = fy.a(this.b);
      gC.d(this.a).a(localMap, Long.valueOf((String)this.b.get("&ht")).longValue(), a(this.b), gC.c(this.a));
    }
  }
}


/* Location:           C:\Users\dreadiscool\Desktop\tools\classes-dex2jar.jar
 * Qualified Name:     gG
 * JD-Core Version:    0.7.0.1
 */