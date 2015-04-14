import android.content.Context;
import android.location.Location;
import com.adjust.sdk.Adjust;
import com.amplitude.api.Amplitude;
import com.mixpanel.android.mpmetrics.MixpanelAPI;
import com.yik.yak.YikYak;
import com.yik.yak.data.models.YakkerLocation;
import java.util.Date;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import java.util.Set;
import java.util.TreeMap;
import org.json.JSONException;
import org.json.JSONObject;

public class If
{
  private static If a = new If(YikYak.getContext(), CR.d());
  private MixpanelAPI b;
  private boolean c = CR.a("mixPanel", "trackViaAdjust", true);
  private Context d;
  private long e;
  private boolean f = false;
  private boolean g = true;
  
  public If(Context paramContext, boolean paramBoolean)
  {
    this.d = paramContext;
    this.f = paramBoolean;
    r();
    s();
    b();
  }
  
  public static If a()
  {
    a.a(true);
    return a;
  }
  
  private Map<String, String> a(JSONObject paramJSONObject)
  {
    HashMap localHashMap = new HashMap();
    if (paramJSONObject != null)
    {
      new StringBuilder().append("properties.keys(): ").append(paramJSONObject.keys()).toString();
      Iterator localIterator = paramJSONObject.keys();
      while (localIterator.hasNext())
      {
        String str = (String)localIterator.next();
        try
        {
          localHashMap.put(str, String.valueOf(paramJSONObject.get(str)));
        }
        catch (JSONException localJSONException) {}
      }
    }
    return localHashMap;
  }
  
  private void a(String paramString1, String paramString2, String paramString3, Long paramLong)
  {
    a(paramString1, paramString2, paramString3, paramLong, null, CR.a("analytics", "googleEnabled", true), CR.a("analytics", "mixPanelEnabled", true), CR.a("analytics", "yikYakEnabled", false), CR.a("analytics", "amplitudeEnabled", true));
  }
  
  private void a(String paramString1, String paramString2, String paramString3, Long paramLong, JSONObject paramJSONObject)
  {
    a(paramString1, paramString2, paramString3, paramLong, paramJSONObject, CR.a("analytics", "googleEnabled", true), CR.a("analytics", "mixPanelEnabled", true), CR.a("analytics", "yikYakEnabled", false), CR.a("analytics", "amplitudeEnabled", true));
  }
  
  private void a(String paramString1, String paramString2, String paramString3, Long paramLong, JSONObject paramJSONObject, boolean paramBoolean1, boolean paramBoolean2, boolean paramBoolean3, boolean paramBoolean4)
  {
    String str = "Analytics: " + paramString2;
    JSONObject[] arrayOfJSONObject = new JSONObject[1];
    arrayOfJSONObject[0] = paramJSONObject;
    Iq.a(str, arrayOfJSONObject);
    if (paramBoolean3) {
      a(paramString2, a(paramJSONObject));
    }
    if (this.g)
    {
      if (paramBoolean1) {
        b(paramString1, paramString2, paramString3, paramLong);
      }
      if (paramBoolean2)
      {
        a(paramString2, paramJSONObject);
        if (this.c) {
          b(paramString2, paramJSONObject);
        }
      }
      if (paramBoolean4)
      {
        c(paramString2, paramJSONObject);
        if (this.c) {
          b(paramString2, paramJSONObject);
        }
      }
    }
  }
  
  private void a(String paramString, Map<String, String> paramMap)
  {
    new StringBuilder().append("logging ").append(paramString).append(" via YikYak with properties ").toString();
    TreeMap localTreeMap = new TreeMap();
    CM localCM = CM.a();
    if (paramMap == null) {}
    for (;;)
    {
      return;
      try
      {
        Iterator localIterator = paramMap.keySet().iterator();
        while (localIterator.hasNext())
        {
          String str2 = (String)localIterator.next();
          localTreeMap.put(str2, paramMap.get(str2));
        }
        if ((!localTreeMap.containsKey("userID")) || (!localTreeMap.containsKey("lat")) || (!localTreeMap.containsKey("long")))
        {
          if (!localTreeMap.containsKey("userID")) {
            localTreeMap.put("userID", ApplicationConfig.getYakkerID());
          }
          if (!localTreeMap.containsKey("lat")) {
            localTreeMap.put("lat", localCM.f().a());
          }
          if (!localTreeMap.containsKey("long")) {
            localTreeMap.put("long", localCM.f().b());
          }
        }
        String str1 = Im.b(CR.f(), "logEvent", localTreeMap, localCM.f());
        zC localzC = zC.a(zt.a("application/x-www-form-urlencoded"), (String)localTreeMap.get("RequestBody:body"));
        zz localzz = new zB().a(localzC).a(str1).b();
        Im.a(true).a(localzz).a(new Ig(this));
      }
      catch (Exception localException) {}
    }
  }
  
  private void a(String paramString, JSONObject paramJSONObject)
  {
    new StringBuilder().append("logging ").append(paramString).append(" via Mixpanel with properties ").append(paramJSONObject).toString();
    if (paramString.equals(this.d.getString(2131230745))) {
      c().timeEvent(paramString);
    }
    for (;;)
    {
      return;
      if (paramString.equals(this.d.getString(2131230748))) {
        c().track(this.d.getString(2131230745), null);
      } else {
        c().track(paramString, paramJSONObject);
      }
    }
  }
  
  private void b(String paramString1, String paramString2, String paramString3, Long paramLong)
  {
    new StringBuilder().append("logging ").append(paramString2).append(" via Google").toString();
    if (CR.a("googleAnalytics", paramString2, false)) {
      en.a(this.d).send(eR.a(paramString1, paramString2, paramString3, paramLong).a());
    }
  }
  
  private void b(String paramString, JSONObject paramJSONObject)
  {
    HashMap localHashMap = new HashMap();
    localHashMap.put("ApplicationDidBecomeActive", "96cxsw");
    localHashMap.put("DidAttemptToRate", "z6ampr");
    localHashMap.put("SavePeekLocation", "5p4hhb");
    localHashMap.put("SendingYak", "hx6loo");
    localHashMap.put("ShareYak", "t92r4w");
    localHashMap.put("ViewPeekLocation", "4lq52y");
    localHashMap.put("Yak Upvote", "4dba81");
    String str = (String)localHashMap.get(paramString);
    if (!Ik.a(str))
    {
      new StringBuilder().append("logging ").append(paramString).append(" via Adjust with properties ").append(paramJSONObject).toString();
      Adjust.trackEvent(str, a(paramJSONObject));
    }
  }
  
  private void c(String paramString, JSONObject paramJSONObject)
  {
    if (!Ik.a(paramString))
    {
      new StringBuilder().append("logging ").append(paramString).append(" via Amplitude with properties ").append(paramJSONObject).toString();
      if ((paramJSONObject != null) && (paramJSONObject.names() != null)) {
        break label53;
      }
      Amplitude.logEvent(paramString);
    }
    for (;;)
    {
      return;
      label53:
      Amplitude.logEvent(paramString, paramJSONObject);
    }
  }
  
  private void q()
  {
    c().flush();
  }
  
  private void r()
  {
    try
    {
      a(MixpanelAPI.getInstance(this.d, "a61c8508f81a3770682472e2274b47f1"));
      return;
    }
    catch (Exception localException)
    {
      for (;;)
      {
        localException.toString();
      }
    }
  }
  
  private void s()
  {
    try
    {
      if (this.f) {
        Amplitude.initialize(this.d, this.d.getString(2131230743));
      } else {
        Amplitude.initialize(this.d, this.d.getString(2131230744));
      }
    }
    catch (Exception localException) {}
  }
  
  public void a(int paramInt)
  {
    JSONObject localJSONObject = new JSONObject();
    try
    {
      localJSONObject.put("Yakarma", paramInt);
      c().registerSuperProperties(localJSONObject);
      Amplitude.setUserProperties(localJSONObject);
      return;
    }
    catch (JSONException localJSONException)
    {
      for (;;)
      {
        localJSONException.printStackTrace();
      }
    }
  }
  
  public void a(CG paramCG)
  {
    String str1 = this.d.getString(2131230787);
    String str2 = this.d.getString(2131230777);
    String str3 = paramCG.b;
    JSONObject localJSONObject = new JSONObject();
    try
    {
      localJSONObject.put("PeekID", paramCG.i);
      localJSONObject.put("Name", paramCG.b);
      a(str1, str2, str3, null, localJSONObject);
      return;
    }
    catch (JSONException localJSONException)
    {
      for (;;)
      {
        localJSONException.printStackTrace();
      }
    }
  }
  
  public void a(CK paramCK)
  {
    String str1 = paramCK.b;
    String str2 = this.d.getString(2131230796);
    String str3 = this.d.getString(2131230753);
    JSONObject localJSONObject = new JSONObject();
    try
    {
      localJSONObject.put("ContentID", str1);
      localJSONObject.put("YakType", CK.a(paramCK.h));
      a(str2, str3, str1, null, localJSONObject);
      return;
    }
    catch (JSONException localJSONException)
    {
      for (;;)
      {
        localJSONException.printStackTrace();
      }
    }
  }
  
  public void a(CK paramCK, String paramString)
  {
    String str1 = this.d.getString(2131230796);
    String str2 = this.d.getString(2131230779);
    String str3 = paramCK.b;
    JSONObject localJSONObject = new JSONObject();
    try
    {
      localJSONObject.put("YakType", CK.a(paramCK.h));
      localJSONObject.put("ContentID", paramCK.b);
      localJSONObject.put("NumberOfComments", paramCK.f);
      localJSONObject.put("Source", paramString);
      a(str1, str2, str3, null, localJSONObject);
      return;
    }
    catch (JSONException localJSONException)
    {
      for (;;)
      {
        localJSONException.printStackTrace();
      }
    }
  }
  
  public void a(Ih paramIh, CK paramCK, String paramString)
  {
    String str1;
    if (paramCK.v) {
      str1 = "Reply";
    }
    for (;;)
    {
      String str2;
      String str3;
      String str4;
      String str5;
      JSONObject localJSONObject;
      if (paramIh == Ih.a)
      {
        str2 = "Upvote";
        str3 = this.d.getString(2131230795);
        str4 = this.d.getString(2131230781);
        str5 = paramCK.b;
        localJSONObject = new JSONObject();
      }
      try
      {
        localJSONObject.put("ContentID", paramCK.b);
        localJSONObject.put("Direction", str2);
        localJSONObject.put("PostType", str1);
        localJSONObject.put("Source", paramString);
        localJSONObject.put("YakType", CK.a(paramCK.h));
        a(str3, str4, str5, null, localJSONObject, false, true, false, true);
        return;
        str1 = "Yak";
        continue;
        str2 = "Downvote";
      }
      catch (JSONException localJSONException)
      {
        for (;;)
        {
          localJSONException.printStackTrace();
        }
      }
    }
  }
  
  public void a(Location paramLocation)
  {
    JSONObject localJSONObject = new JSONObject();
    try
    {
      localJSONObject.put("Latitude", paramLocation.getLatitude());
      localJSONObject.put("Longitude", paramLocation.getLongitude());
      c().registerSuperProperties(localJSONObject);
      return;
    }
    catch (JSONException localJSONException)
    {
      for (;;)
      {
        localJSONException.printStackTrace();
      }
    }
  }
  
  public void a(MixpanelAPI paramMixpanelAPI)
  {
    this.b = paramMixpanelAPI;
  }
  
  public void a(String paramString)
  {
    if ((this.g) && (CR.a("googleAnalytics", paramString, false)))
    {
      en.a(this.d).set("&cd", paramString);
      en.a(this.d).send(eR.b().a());
    }
  }
  
  public void a(String paramString, Long paramLong, int paramInt)
  {
    String str1 = this.d.getString(2131230791);
    String str2 = this.d.getString(2131230768);
    JSONObject localJSONObject = new JSONObject();
    try
    {
      localJSONObject.put("YakType", CK.a(paramInt));
      localJSONObject.put("NumberOfVotes", paramLong);
      localJSONObject.put("Channel", paramString);
      localJSONObject.put("IsFamous", false);
      a(str1, str2, paramString, null, localJSONObject);
      return;
    }
    catch (JSONException localJSONException)
    {
      for (;;)
      {
        localJSONException.printStackTrace();
      }
    }
  }
  
  public void a(String paramString1, Long paramLong, String paramString2, String paramString3)
  {
    String str1 = this.d.getString(2131230791);
    String str2 = this.d.getString(2131230768);
    JSONObject localJSONObject = new JSONObject();
    try
    {
      localJSONObject.put("YakType", paramString2);
      localJSONObject.put("NumberOfVotes", paramLong);
      localJSONObject.put("Channel", paramString1);
      localJSONObject.put("FamousAvatar", paramString3);
      localJSONObject.put("IsFamous", true);
      a(str1, str2, paramString1, null, localJSONObject);
      return;
    }
    catch (JSONException localJSONException)
    {
      for (;;)
      {
        localJSONException.printStackTrace();
      }
    }
  }
  
  public void a(String paramString1, String paramString2)
  {
    String str1 = this.d.getString(2131230796);
    String str2 = this.d.getString(2131230767);
    JSONObject localJSONObject = new JSONObject();
    try
    {
      localJSONObject.put("YakType", paramString1);
      localJSONObject.put("Source", paramString2);
      a(str1, str2, null, null, localJSONObject);
      return;
    }
    catch (JSONException localJSONException)
    {
      for (;;)
      {
        localJSONException.printStackTrace();
      }
    }
  }
  
  public void a(boolean paramBoolean)
  {
    this.g = paramBoolean;
  }
  
  public en b()
  {
    return en.a(this.d);
  }
  
  public void b(CG paramCG)
  {
    String str1 = this.d.getString(2131230787);
    String str2 = this.d.getString(2131230761);
    String str3 = paramCG.b;
    JSONObject localJSONObject = new JSONObject();
    try
    {
      localJSONObject.put("PeekID", paramCG.i);
      localJSONObject.put("Name", paramCG.b);
      a(str1, str2, str3, null, localJSONObject);
      return;
    }
    catch (JSONException localJSONException)
    {
      for (;;)
      {
        localJSONException.printStackTrace();
      }
    }
  }
  
  public void b(CK paramCK)
  {
    String str1 = paramCK.b;
    String str2 = this.d.getString(2131230796);
    String str3 = this.d.getString(2131230760);
    JSONObject localJSONObject = new JSONObject();
    try
    {
      localJSONObject.put("YakType", CK.a(paramCK.h));
      localJSONObject.put("ContentID", str1);
      a(str2, str3, str1, null, localJSONObject);
      return;
    }
    catch (JSONException localJSONException)
    {
      for (;;)
      {
        localJSONException.printStackTrace();
      }
    }
  }
  
  public void b(String paramString)
  {
    this.e = new Date().getTime();
    String str1 = this.d.getString(2131230783);
    String str2 = this.d.getString(2131230745);
    JSONObject localJSONObject = new JSONObject();
    try
    {
      localJSONObject.put("Source", paramString);
      a(str1, str2, null, null, localJSONObject, false, true, true, true);
      return;
    }
    catch (JSONException localJSONException)
    {
      for (;;)
      {
        localJSONException.printStackTrace();
      }
    }
  }
  
  public void b(boolean paramBoolean)
  {
    String str1 = this.d.getString(2131230783);
    String str2;
    if (paramBoolean) {
      str2 = this.d.getString(2131230751);
    }
    for (;;)
    {
      JSONObject localJSONObject = new JSONObject();
      try
      {
        localJSONObject.put("eventType", str2);
        a(str1, str2, null, null, localJSONObject, false, false, true, false);
        return;
        str2 = this.d.getString(2131230750);
      }
      catch (JSONException localJSONException)
      {
        for (;;)
        {
          localJSONException.printStackTrace();
        }
      }
    }
  }
  
  public MixpanelAPI c()
  {
    if (this.b == null) {
      r();
    }
    return this.b;
  }
  
  public void c(String paramString)
  {
    String str1 = this.d.getString(2131230784);
    String str2 = this.d.getString(2131230752);
    JSONObject localJSONObject = new JSONObject();
    try
    {
      localJSONObject.put("Category", paramString);
      a(str1, str2, paramString, null, localJSONObject);
      return;
    }
    catch (JSONException localJSONException)
    {
      for (;;)
      {
        localJSONException.printStackTrace();
      }
    }
  }
  
  public void d()
  {
    q();
  }
  
  public void d(String paramString)
  {
    String str1 = this.d.getString(2131230791);
    String str2 = this.d.getString(2131230769);
    JSONObject localJSONObject = new JSONObject();
    try
    {
      localJSONObject.put("Provider", paramString);
      a(str1, str2, null, null, localJSONObject);
      return;
    }
    catch (JSONException localJSONException)
    {
      for (;;)
      {
        localJSONException.printStackTrace();
      }
    }
  }
  
  public void e() {}
  
  public void e(String paramString)
  {
    a(this.d.getString(2131230788), paramString, null, null);
  }
  
  public void f() {}
  
  public void f(String paramString)
  {
    String str1 = this.d.getString(2131230793);
    String str2 = this.d.getString(2131230771);
    JSONObject localJSONObject = new JSONObject();
    try
    {
      localJSONObject.put("Tab", paramString);
      a(str1, str2, paramString, null, localJSONObject);
      return;
    }
    catch (JSONException localJSONException)
    {
      for (;;)
      {
        localJSONException.printStackTrace();
      }
    }
  }
  
  public void g()
  {
    long l = (new Date().getTime() - this.e) / 1000L;
    String str1 = this.d.getString(2131230783);
    String str2 = this.d.getString(2131230748);
    JSONObject localJSONObject = new JSONObject();
    try
    {
      localJSONObject.put("eventType", str2);
      localJSONObject.put("Duration", l);
      a(str1, str2, null, null, localJSONObject, false, true, true, false);
      return;
    }
    catch (JSONException localJSONException)
    {
      for (;;)
      {
        localJSONException.printStackTrace();
      }
    }
  }
  
  public void g(String paramString)
  {
    String str1 = this.d.getString(2131230794);
    String str2 = this.d.getString(2131230778);
    JSONObject localJSONObject = new JSONObject();
    try
    {
      localJSONObject.put("Source", paramString);
      a(str1, str2, null, null, localJSONObject);
      return;
    }
    catch (JSONException localJSONException)
    {
      for (;;)
      {
        localJSONException.printStackTrace();
      }
    }
  }
  
  public void h()
  {
    a(this.d.getString(2131230796), this.d.getString(2131230756), null, null, null);
  }
  
  public void h(String paramString)
  {
    String str1 = this.d.getString(2131230787);
    String str2 = this.d.getString(2131230765);
    JSONObject localJSONObject = new JSONObject();
    try
    {
      localJSONObject.put("Query", paramString);
      a(str1, str2, paramString, null, localJSONObject);
      return;
    }
    catch (JSONException localJSONException)
    {
      for (;;)
      {
        localJSONException.printStackTrace();
      }
    }
  }
  
  public void i()
  {
    a(this.d.getString(2131230796), this.d.getString(2131230755), null, null, null);
  }
  
  public void i(String paramString)
  {
    String str1 = this.d.getString(2131230786);
    String str2 = this.d.getString(2131230772);
    JSONObject localJSONObject = new JSONObject();
    try
    {
      localJSONObject.put("URL", paramString);
      a(str1, str2, null, null, localJSONObject);
      return;
    }
    catch (JSONException localJSONException)
    {
      for (;;)
      {
        localJSONException.printStackTrace();
      }
    }
  }
  
  public void j()
  {
    a(this.d.getString(2131230796), this.d.getString(2131230757), null, null, null);
  }
  
  public void j(String paramString)
  {
    String str1 = this.d.getString(2131230797);
    String str2 = this.d.getString(2131230782);
    JSONObject localJSONObject = new JSONObject();
    try
    {
      localJSONObject.put("Segment", paramString);
      a(str1, str2, null, null, localJSONObject);
      return;
    }
    catch (JSONException localJSONException)
    {
      for (;;)
      {
        localJSONException.printStackTrace();
      }
    }
  }
  
  public void k()
  {
    a(this.d.getString(2131230794), this.d.getString(2131230780), null, null, new JSONObject());
  }
  
  public void l()
  {
    a(this.d.getString(2131230785), this.d.getString(2131230759), null, null);
  }
  
  public void m()
  {
    a(this.d.getString(2131230789), this.d.getString(2131230754), null, null);
  }
  
  public void n()
  {
    a(this.d.getString(2131230794), this.d.getString(2131230776), null, null);
  }
  
  public void o()
  {
    a(this.d.getString(2131230794), this.d.getString(2131230774), null, null);
  }
  
  public void p()
  {
    a(this.d.getString(2131230794), this.d.getString(2131230775), null, null);
  }
}



/* Location:           C:\Users\dreadiscool\Desktop\tools\classes-dex2jar.jar

 * Qualified Name:     If

 * JD-Core Version:    0.7.0.1

 */