package com.google.android.gms.analytics;

import android.content.Context;
import android.net.Uri;
import android.text.TextUtils;
import fA;
import fE;
import fF;
import fI;
import fJ;
import fV;
import fk;
import ft;
import fu;
import fz;
import gH;
import gI;
import ge;
import hZ;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Locale;
import java.util.Map;
import java.util.Random;
import java.util.Set;

public class Tracker
{
  private final fu Ce;
  private final Map<String, String> Cf = new HashMap();
  private fE Cg;
  private final ge Ch;
  private final fF Ci;
  private final fV Cj;
  private boolean Ck;
  private ft Cl;
  private fI Cm;
  private fk Cn;
  private Context mContext;
  private final Map<String, String> rd = new HashMap();
  
  Tracker(String paramString, fu paramfu, Context paramContext)
  {
    this(paramString, paramfu, ge.a(), fF.a(), fV.a(), new fz("tracking"), paramContext);
  }
  
  Tracker(String paramString, fu paramfu, ge paramge, fF paramfF, fV paramfV, fE paramfE, Context paramContext)
  {
    this.Ce = paramfu;
    if (paramContext != null) {
      this.mContext = paramContext.getApplicationContext();
    }
    if (paramString != null) {
      this.rd.put("&tid", paramString);
    }
    this.rd.put("useSecure", "1");
    this.Ch = paramge;
    this.Ci = paramfF;
    this.Cj = paramfV;
    this.rd.put("&a", Integer.toString(1 + new Random().nextInt(2147483647)));
    this.Cg = paramfE;
    this.Cl = new ft(this);
    enableAdvertisingIdCollection(false);
  }
  
  void a(fI paramfI)
  {
    fA.c("Loading Tracker config values.");
    this.Cm = paramfI;
    if (this.Cm.a())
    {
      String str2 = this.Cm.b();
      set("&tid", str2);
      fA.c("[Tracker] trackingId loaded: " + str2);
    }
    if (this.Cm.c())
    {
      String str1 = Double.toString(this.Cm.d());
      set("&sf", str1);
      fA.c("[Tracker] sample frequency loaded: " + str1);
    }
    if (this.Cm.e())
    {
      setSessionTimeout(this.Cm.f());
      fA.c("[Tracker] session timeout loaded: " + fn());
    }
    if (this.Cm.g())
    {
      enableAutoActivityTracking(this.Cm.h());
      fA.c("[Tracker] auto activity tracking loaded: " + fo());
    }
    if (this.Cm.i())
    {
      if (this.Cm.j())
      {
        set("&aip", "1");
        fA.c("[Tracker] anonymize ip loaded: true");
      }
      fA.c("[Tracker] anonymize ip loaded: false");
    }
    enableExceptionReporting(this.Cm.k());
  }
  
  public void enableAdvertisingIdCollection(boolean paramBoolean)
  {
    if (!paramBoolean)
    {
      this.rd.put("&ate", null);
      this.rd.put("&adid", null);
    }
    for (;;)
    {
      return;
      if (this.rd.containsKey("&ate")) {
        this.rd.remove("&ate");
      }
      if (this.rd.containsKey("&adid")) {
        this.rd.remove("&adid");
      }
    }
  }
  
  public void enableAutoActivityTracking(boolean paramBoolean)
  {
    this.Cl.a(paramBoolean);
  }
  
  public void enableExceptionReporting(boolean paramBoolean)
  {
    if (this.Ck == paramBoolean) {}
    for (;;)
    {
      return;
      this.Ck = paramBoolean;
      if (!paramBoolean) {
        break;
      }
      this.Cn = new fk(this, Thread.getDefaultUncaughtExceptionHandler(), this.mContext);
      Thread.setDefaultUncaughtExceptionHandler(this.Cn);
      fA.c("Uncaught exceptions will be reported to Google Analytics.");
    }
    if (this.Cn != null) {
      Thread.setDefaultUncaughtExceptionHandler(this.Cn.b());
    }
    for (;;)
    {
      fA.c("Uncaught exceptions will not be reported to Google Analytics.");
      break;
      Thread.setDefaultUncaughtExceptionHandler(null);
    }
  }
  
  long fn()
  {
    return this.Cl.a();
  }
  
  boolean fo()
  {
    return this.Cl.b();
  }
  
  public String get(String paramString)
  {
    String str = null;
    gH.a().a(gI.j);
    if (TextUtils.isEmpty(paramString)) {}
    for (;;)
    {
      return str;
      if (this.rd.containsKey(paramString)) {
        str = (String)this.rd.get(paramString);
      } else if (paramString.equals("&ul")) {
        str = fJ.a(Locale.getDefault());
      } else if ((this.Ch != null) && (this.Ch.b(paramString))) {
        str = this.Ch.a(paramString);
      } else if ((this.Ci != null) && (this.Ci.b(paramString))) {
        str = this.Ci.a(paramString);
      } else if ((this.Cj != null) && (this.Cj.b(paramString))) {
        str = this.Cj.a(paramString);
      }
    }
  }
  
  public void send(Map<String, String> paramMap)
  {
    gH.a().a(gI.l);
    HashMap localHashMap = new HashMap();
    localHashMap.putAll(this.rd);
    if (paramMap != null) {
      localHashMap.putAll(paramMap);
    }
    Iterator localIterator = this.Cf.keySet().iterator();
    while (localIterator.hasNext())
    {
      String str3 = (String)localIterator.next();
      if (!localHashMap.containsKey(str3)) {
        localHashMap.put(str3, this.Cf.get(str3));
      }
    }
    this.Cf.clear();
    if (TextUtils.isEmpty((CharSequence)localHashMap.get("&tid")))
    {
      Object[] arrayOfObject2 = new Object[1];
      arrayOfObject2[0] = "&tid";
      fA.d(String.format("Missing tracking id (%s) parameter.", arrayOfObject2));
    }
    String str1 = (String)localHashMap.get("&t");
    if (TextUtils.isEmpty(str1))
    {
      Object[] arrayOfObject1 = new Object[1];
      arrayOfObject1[0] = "&t";
      fA.d(String.format("Missing hit type (%s) parameter.", arrayOfObject1));
      str1 = "";
    }
    if (this.Cl.c()) {
      localHashMap.put("&sc", "start");
    }
    String str2 = str1.toLowerCase();
    if (("screenview".equals(str2)) || ("pageview".equals(str2)) || ("appview".equals(str2)) || (TextUtils.isEmpty(str2)))
    {
      int i = 1 + Integer.parseInt((String)this.rd.get("&a"));
      if (i >= 2147483647) {
        i = 1;
      }
      this.rd.put("&a", Integer.toString(i));
    }
    if ((!str2.equals("transaction")) && (!str2.equals("item")) && (!this.Cg.a())) {
      fA.d("Too many hits sent too quickly, rate limiting invoked.");
    }
    for (;;)
    {
      return;
      this.Ce.a(localHashMap);
    }
  }
  
  public void set(String paramString1, String paramString2)
  {
    hZ.a(paramString1, "Key should be non-null");
    gH.a().a(gI.k);
    this.rd.put(paramString1, paramString2);
  }
  
  public void setAnonymizeIp(boolean paramBoolean)
  {
    set("&aip", fJ.a(paramBoolean));
  }
  
  public void setAppId(String paramString)
  {
    set("&aid", paramString);
  }
  
  public void setAppInstallerId(String paramString)
  {
    set("&aiid", paramString);
  }
  
  public void setAppName(String paramString)
  {
    set("&an", paramString);
  }
  
  public void setAppVersion(String paramString)
  {
    set("&av", paramString);
  }
  
  public void setCampaignParamsOnNextHit(Uri paramUri)
  {
    if (paramUri == null) {}
    for (;;)
    {
      return;
      String str1 = paramUri.getQueryParameter("referrer");
      if (!TextUtils.isEmpty(str1))
      {
        Uri localUri = Uri.parse("http://hostname/?" + str1);
        String str2 = localUri.getQueryParameter("utm_id");
        if (str2 != null) {
          this.Cf.put("&ci", str2);
        }
        String str3 = localUri.getQueryParameter("utm_campaign");
        if (str3 != null) {
          this.Cf.put("&cn", str3);
        }
        String str4 = localUri.getQueryParameter("utm_content");
        if (str4 != null) {
          this.Cf.put("&cc", str4);
        }
        String str5 = localUri.getQueryParameter("utm_medium");
        if (str5 != null) {
          this.Cf.put("&cm", str5);
        }
        String str6 = localUri.getQueryParameter("utm_source");
        if (str6 != null) {
          this.Cf.put("&cs", str6);
        }
        String str7 = localUri.getQueryParameter("utm_term");
        if (str7 != null) {
          this.Cf.put("&ck", str7);
        }
        String str8 = localUri.getQueryParameter("dclid");
        if (str8 != null) {
          this.Cf.put("&dclid", str8);
        }
        String str9 = localUri.getQueryParameter("gclid");
        if (str9 != null) {
          this.Cf.put("&gclid", str9);
        }
      }
    }
  }
  
  public void setClientId(String paramString)
  {
    set("&cid", paramString);
  }
  
  public void setEncoding(String paramString)
  {
    set("&de", paramString);
  }
  
  public void setHostname(String paramString)
  {
    set("&dh", paramString);
  }
  
  public void setLanguage(String paramString)
  {
    set("&ul", paramString);
  }
  
  public void setLocation(String paramString)
  {
    set("&dl", paramString);
  }
  
  public void setPage(String paramString)
  {
    set("&dp", paramString);
  }
  
  public void setReferrer(String paramString)
  {
    set("&dr", paramString);
  }
  
  public void setSampleRate(double paramDouble)
  {
    set("&sf", Double.toHexString(paramDouble));
  }
  
  public void setScreenColors(String paramString)
  {
    set("&sd", paramString);
  }
  
  public void setScreenName(String paramString)
  {
    set("&cd", paramString);
  }
  
  public void setScreenResolution(int paramInt1, int paramInt2)
  {
    if ((paramInt1 < 0) && (paramInt2 < 0)) {
      fA.d("Invalid width or height. The values should be non-negative.");
    }
    for (;;)
    {
      return;
      set("&sr", paramInt1 + "x" + paramInt2);
    }
  }
  
  public void setSessionTimeout(long paramLong)
  {
    this.Cl.a(1000L * paramLong);
  }
  
  public void setTitle(String paramString)
  {
    set("&dt", paramString);
  }
  
  public void setUseSecure(boolean paramBoolean)
  {
    set("useSecure", fJ.a(paramBoolean));
  }
  
  public void setViewportSize(String paramString)
  {
    set("&vp", paramString);
  }
}


/* Location:           C:\Users\dreadiscool\Desktop\tools\classes-dex2jar.jar
 * Qualified Name:     com.google.android.gms.analytics.Tracker
 * JD-Core Version:    0.7.0.1
 */