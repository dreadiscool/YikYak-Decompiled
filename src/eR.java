import android.text.TextUtils;
import java.util.HashMap;
import java.util.Map;

public class eR
{
  private Map<String, String> a = new HashMap();
  
  public static eR a(String paramString, Boolean paramBoolean)
  {
    eJ.a().a(eK.H);
    eR localeR = new eR();
    localeR.a("&t", "exception");
    localeR.a("&exd", paramString);
    localeR.a("&exf", a(paramBoolean));
    return localeR;
  }
  
  public static eR a(String paramString1, String paramString2, String paramString3, Long paramLong)
  {
    eJ.a().a(eK.Y);
    eR localeR = new eR();
    localeR.a("&t", "event");
    localeR.a("&ec", paramString1);
    localeR.a("&ea", paramString2);
    localeR.a("&el", paramString3);
    if (paramLong == null) {}
    for (String str = null;; str = Long.toString(paramLong.longValue()))
    {
      localeR.a("&ev", str);
      return localeR;
    }
  }
  
  static String a(Boolean paramBoolean)
  {
    String str;
    if (paramBoolean == null) {
      str = null;
    }
    for (;;)
    {
      return str;
      if (paramBoolean.booleanValue()) {
        str = "1";
      } else {
        str = "0";
      }
    }
  }
  
  public static eR b()
  {
    eJ.a().a(eK.ak);
    eR localeR = new eR();
    localeR.a("&t", "appview");
    return localeR;
  }
  
  public eR a(String paramString)
  {
    eJ.a().a(eK.d);
    String str = fd.b(paramString);
    if (TextUtils.isEmpty(str)) {}
    for (;;)
    {
      return this;
      Map localMap = fd.a(str);
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
  
  public eR a(String paramString1, String paramString2)
  {
    eJ.a().a(eK.a);
    if (paramString1 != null) {
      this.a.put(paramString1, paramString2);
    }
    for (;;)
    {
      return this;
      eO.d(" MapBuilder.set() called with a null paramName.");
    }
  }
  
  public Map<String, String> a()
  {
    return new HashMap(this.a);
  }
}


/* Location:           C:\Users\dreadiscool\Desktop\tools\classes-dex2jar.jar
 * Qualified Name:     eR
 * JD-Core Version:    0.7.0.1
 */