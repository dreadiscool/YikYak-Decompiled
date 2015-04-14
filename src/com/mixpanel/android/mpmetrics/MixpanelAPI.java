package com.mixpanel.android.mpmetrics;

import android.annotation.TargetApi;
import android.app.Activity;
import android.app.Application;
import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;
import android.content.SharedPreferences;
import android.content.pm.PackageInfo;
import android.content.pm.PackageManager;
import android.content.pm.PackageManager.NameNotFoundException;
import android.os.Build;
import android.os.Build.VERSION;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.util.Collections;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Set;
import java.util.concurrent.Future;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;
import uJ;
import uN;
import uO;
import uR;
import uS;
import uW;
import uX;
import uY;
import uZ;
import uf;
import ug;
import up;
import ut;
import uu;
import va;
import vb;
import vi;
import wt;
import wv;
import ww;

public class MixpanelAPI
{
  private static final String APP_LINKS_LOGTAG = "MixpanelAPI - App Links (OPTIONAL)";
  private static final String ENGAGE_DATE_FORMAT_STRING = "yyyy-MM-dd'T'HH:mm:ss";
  private static final String LOGTAG = "MixpanelAPI.MixpanelAPI";
  public static final String VERSION = "4.5.3";
  private static final Map<String, Map<Context, MixpanelAPI>> sInstanceMap = new HashMap();
  private static final vi sPrefsLoader = new vi();
  private static Future<SharedPreferences> sReferrerPrefs;
  private final uJ mConfig;
  private final Context mContext;
  private final ut mDecideMessages;
  private final Map<String, String> mDeviceInfo;
  private final Map<String, Long> mEventTimings;
  private final uf mMessages;
  private final uS mPeople;
  private final vb mPersistentIdentity;
  private final String mToken;
  private final wt mTrackingDebug;
  private final wv mUpdatesFromMixpanel;
  private final uZ mUpdatesListener;
  
  MixpanelAPI(Context paramContext, Future<SharedPreferences> paramFuture, String paramString)
  {
    this.mContext = paramContext;
    this.mToken = paramString;
    this.mEventTimings = new HashMap();
    this.mPeople = new uS(this, null);
    this.mMessages = getAnalyticsMessages();
    this.mConfig = getConfig();
    HashMap localHashMap = new HashMap();
    localHashMap.put("$android_lib_version", "4.5.3");
    localHashMap.put("$android_os", "Android");
    String str1;
    if (Build.VERSION.RELEASE == null) {
      str1 = "UNKNOWN";
    }
    for (;;)
    {
      localHashMap.put("$android_os_version", str1);
      String str2;
      label119:
      String str3;
      label141:
      String str4;
      if (Build.MANUFACTURER == null)
      {
        str2 = "UNKNOWN";
        localHashMap.put("$android_manufacturer", str2);
        if (Build.BRAND != null) {
          break label355;
        }
        str3 = "UNKNOWN";
        localHashMap.put("$android_brand", str3);
        if (Build.MODEL != null) {
          break label363;
        }
        str4 = "UNKNOWN";
        localHashMap.put("$android_model", str4);
      }
      try
      {
        PackageInfo localPackageInfo = this.mContext.getPackageManager().getPackageInfo(this.mContext.getPackageName(), 0);
        localHashMap.put("$android_app_version", localPackageInfo.versionName);
        localHashMap.put("$android_app_version_code", Integer.toString(localPackageInfo.versionCode));
        label228:
        this.mDeviceInfo = Collections.unmodifiableMap(localHashMap);
        this.mUpdatesFromMixpanel = constructUpdatesFromMixpanel(paramContext, paramString);
        this.mTrackingDebug = constructTrackingDebug();
        this.mPersistentIdentity = getPersistentIdentity(paramContext, paramFuture, paramString);
        this.mUpdatesListener = constructUpdatesListener();
        this.mDecideMessages = constructDecideUpdates(paramString, this.mUpdatesListener, this.mUpdatesFromMixpanel);
        String str5 = this.mPersistentIdentity.d();
        this.mDecideMessages.a(str5);
        this.mMessages.a(this.mDecideMessages);
        registerMixpanelActivityLifecycleCallbacks();
        if (sendAppOpen()) {
          track("$app_open", null);
        }
        return;
        str1 = Build.VERSION.RELEASE;
        continue;
        str2 = Build.MANUFACTURER;
        break label119;
        label355:
        str3 = Build.BRAND;
        break label141;
        label363:
        str4 = Build.MODEL;
      }
      catch (PackageManager.NameNotFoundException localNameNotFoundException)
      {
        break label228;
      }
    }
  }
  
  /* Error */
  public static void allInstances(uQ paramuQ)
  {
    // Byte code:
    //   0: getstatic 57	com/mixpanel/android/mpmetrics/MixpanelAPI:sInstanceMap	Ljava/util/Map;
    //   3: astore_1
    //   4: aload_1
    //   5: monitorenter
    //   6: getstatic 57	com/mixpanel/android/mpmetrics/MixpanelAPI:sInstanceMap	Ljava/util/Map;
    //   9: invokeinterface 270 1 0
    //   14: invokeinterface 276 1 0
    //   19: astore_3
    //   20: aload_3
    //   21: invokeinterface 281 1 0
    //   26: ifeq +58 -> 84
    //   29: aload_3
    //   30: invokeinterface 285 1 0
    //   35: checkcast 95	java/util/Map
    //   38: invokeinterface 270 1 0
    //   43: invokeinterface 276 1 0
    //   48: astore 4
    //   50: aload 4
    //   52: invokeinterface 281 1 0
    //   57: ifeq -37 -> 20
    //   60: aload_0
    //   61: aload 4
    //   63: invokeinterface 285 1 0
    //   68: checkcast 2	com/mixpanel/android/mpmetrics/MixpanelAPI
    //   71: invokeinterface 289 2 0
    //   76: goto -26 -> 50
    //   79: astore_2
    //   80: aload_1
    //   81: monitorexit
    //   82: aload_2
    //   83: athrow
    //   84: aload_1
    //   85: monitorexit
    //   86: return
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	87	0	paramuQ	uQ
    //   3	82	1	localMap	Map
    //   79	4	2	localObject	Object
    //   19	11	3	localIterator1	Iterator
    //   48	14	4	localIterator2	Iterator
    // Exception table:
    //   from	to	target	type
    //   6	82	79	finally
    //   84	86	79	finally
  }
  
  private static void checkIntentForInboundAppLink(Context paramContext)
  {
    if ((paramContext instanceof Activity)) {}
    try
    {
      Class localClass = Class.forName("g");
      Intent localIntent = ((Activity)paramContext).getIntent();
      Class[] arrayOfClass = new Class[2];
      arrayOfClass[0] = Context.class;
      arrayOfClass[1] = Intent.class;
      Method localMethod = localClass.getMethod("getTargetUrlFromInboundIntent", arrayOfClass);
      Object[] arrayOfObject = new Object[2];
      arrayOfObject[0] = paramContext;
      arrayOfObject[1] = localIntent;
      localMethod.invoke(null, arrayOfObject);
      label81:
      return;
    }
    catch (ClassNotFoundException localClassNotFoundException)
    {
      for (;;)
      {
        new StringBuilder().append("Please install the Bolts library >= 1.1.2 to track App Links: ").append(localClassNotFoundException.getMessage()).toString();
      }
    }
    catch (NoSuchMethodException localNoSuchMethodException)
    {
      for (;;)
      {
        new StringBuilder().append("Please install the Bolts library >= 1.1.2 to track App Links: ").append(localNoSuchMethodException.getMessage()).toString();
      }
    }
    catch (IllegalAccessException localIllegalAccessException)
    {
      for (;;)
      {
        new StringBuilder().append("Unable to detect inbound App Links: ").append(localIllegalAccessException.getMessage()).toString();
      }
    }
    catch (InvocationTargetException localInvocationTargetException)
    {
      break label81;
    }
  }
  
  @Deprecated
  public static void enableFallbackServer(Context paramContext, boolean paramBoolean) {}
  
  public static MixpanelAPI getInstance(Context paramContext, String paramString)
  {
    MixpanelAPI localMixpanelAPI = null;
    if ((paramString == null) || (paramContext == null)) {
      return localMixpanelAPI;
    }
    for (;;)
    {
      Map localMap2;
      synchronized (sInstanceMap)
      {
        Context localContext = paramContext.getApplicationContext();
        if (sReferrerPrefs == null) {
          sReferrerPrefs = sPrefsLoader.a(paramContext, "com.mixpanel.android.mpmetrics.ReferralInfo", null);
        }
        localMap2 = (Map)sInstanceMap.get(paramString);
        if (localMap2 == null)
        {
          HashMap localHashMap = new HashMap();
          sInstanceMap.put(paramString, localHashMap);
          localObject2 = localHashMap;
          localMixpanelAPI = (MixpanelAPI)((Map)localObject2).get(localContext);
          if ((localMixpanelAPI == null) && (up.a(localContext)))
          {
            localMixpanelAPI = new MixpanelAPI(localContext, sReferrerPrefs, paramString);
            registerAppLinksListeners(paramContext, localMixpanelAPI);
            ((Map)localObject2).put(localContext, localMixpanelAPI);
          }
          checkIntentForInboundAppLink(paramContext);
        }
      }
      Object localObject2 = localMap2;
    }
  }
  
  private void pushWaitingPeopleRecord()
  {
    JSONArray localJSONArray = this.mPersistentIdentity.e();
    if (localJSONArray != null) {
      sendAllPeopleRecords(localJSONArray);
    }
  }
  
  private void recordPeopleMessage(JSONObject paramJSONObject)
  {
    if (paramJSONObject.has("$distinct_id")) {
      this.mMessages.a(paramJSONObject);
    }
    for (;;)
    {
      return;
      this.mPersistentIdentity.a(paramJSONObject);
    }
  }
  
  private static void registerAppLinksListeners(Context paramContext, MixpanelAPI paramMixpanelAPI)
  {
    try
    {
      Class localClass = Class.forName("android.support.v4.content.LocalBroadcastManager");
      Class[] arrayOfClass1 = new Class[1];
      arrayOfClass1[0] = Context.class;
      Method localMethod1 = localClass.getMethod("getInstance", arrayOfClass1);
      Class[] arrayOfClass2 = new Class[2];
      arrayOfClass2[0] = BroadcastReceiver.class;
      arrayOfClass2[1] = IntentFilter.class;
      Method localMethod2 = localClass.getMethod("registerReceiver", arrayOfClass2);
      Object[] arrayOfObject1 = new Object[1];
      arrayOfObject1[0] = paramContext;
      Object localObject = localMethod1.invoke(null, arrayOfObject1);
      Object[] arrayOfObject2 = new Object[2];
      arrayOfObject2[0] = new uO(paramMixpanelAPI);
      arrayOfObject2[1] = new IntentFilter("com.parse.bolts.measurement_event");
      localMethod2.invoke(localObject, arrayOfObject2);
      label127:
      return;
    }
    catch (ClassNotFoundException localClassNotFoundException)
    {
      for (;;)
      {
        new StringBuilder().append("To enable App Links tracking android.support.v4 must be installed: ").append(localClassNotFoundException.getMessage()).toString();
      }
    }
    catch (NoSuchMethodException localNoSuchMethodException)
    {
      for (;;)
      {
        new StringBuilder().append("To enable App Links tracking android.support.v4 must be installed: ").append(localNoSuchMethodException.getMessage()).toString();
      }
    }
    catch (IllegalAccessException localIllegalAccessException)
    {
      for (;;)
      {
        new StringBuilder().append("App Links tracking will not be enabled due to this exception: ").append(localIllegalAccessException.getMessage()).toString();
      }
    }
    catch (InvocationTargetException localInvocationTargetException)
    {
      break label127;
    }
  }
  
  private void sendAllPeopleRecords(JSONArray paramJSONArray)
  {
    int i = 0;
    for (;;)
    {
      if (i < paramJSONArray.length()) {}
      try
      {
        JSONObject localJSONObject = paramJSONArray.getJSONObject(i);
        this.mMessages.a(localJSONObject);
        label26:
        i++;
        continue;
        return;
      }
      catch (JSONException localJSONException)
      {
        break label26;
      }
    }
  }
  
  @Deprecated
  public static void setFlushInterval(Context paramContext, long paramLong) {}
  
  public void alias(String paramString1, String paramString2)
  {
    if (paramString2 == null) {
      paramString2 = getDistinctId();
    }
    if (paramString1.equals(paramString2)) {
      new StringBuilder().append("Attempted to alias identical distinct_ids ").append(paramString1).append(". Alias message will not be sent.").toString();
    }
    for (;;)
    {
      return;
      try
      {
        JSONObject localJSONObject = new JSONObject();
        localJSONObject.put("alias", paramString1);
        localJSONObject.put("original", paramString2);
        track("$create_alias", localJSONObject);
        label79:
        flush();
      }
      catch (JSONException localJSONException)
      {
        break label79;
      }
    }
  }
  
  public void clearSuperProperties()
  {
    this.mPersistentIdentity.h();
  }
  
  ut constructDecideUpdates(String paramString, uu paramuu, wv paramwv)
  {
    return new ut(paramString, paramuu, paramwv);
  }
  
  wt constructTrackingDebug()
  {
    if ((this.mUpdatesFromMixpanel instanceof ww)) {}
    for (wt localwt = (wt)this.mUpdatesFromMixpanel;; localwt = null) {
      return localwt;
    }
  }
  
  wv constructUpdatesFromMixpanel(Context paramContext, String paramString)
  {
    if (Build.VERSION.SDK_INT < 16) {}
    for (Object localObject = new uX(this);; localObject = new ww(this.mContext, this.mToken, this)) {
      return localObject;
    }
  }
  
  uZ constructUpdatesListener()
  {
    if (Build.VERSION.SDK_INT < 16) {}
    for (Object localObject = new uY(this, null);; localObject = new uW(this, null)) {
      return localObject;
    }
  }
  
  public void flush()
  {
    this.mMessages.a();
  }
  
  uf getAnalyticsMessages()
  {
    return uf.a(this.mContext);
  }
  
  uJ getConfig()
  {
    return uJ.a(this.mContext);
  }
  
  public Map<String, String> getDeviceInfo()
  {
    return this.mDeviceInfo;
  }
  
  public String getDistinctId()
  {
    return this.mPersistentIdentity.c();
  }
  
  public uR getPeople()
  {
    return this.mPeople;
  }
  
  vb getPersistentIdentity(Context paramContext, Future<SharedPreferences> paramFuture, String paramString)
  {
    uN localuN = new uN(this);
    String str = "com.mixpanel.android.mpmetrics.MixpanelAPI_" + paramString;
    return new vb(paramFuture, sPrefsLoader.a(paramContext, str, localuN));
  }
  
  public JSONObject getSuperProperties()
  {
    return this.mPersistentIdentity.a();
  }
  
  public void identify(String paramString)
  {
    this.mPersistentIdentity.a(paramString);
  }
  
  @Deprecated
  public void logPosts() {}
  
  @TargetApi(16)
  void registerMixpanelActivityLifecycleCallbacks()
  {
    if ((Build.VERSION.SDK_INT >= 16) && (this.mConfig.o()) && ((this.mContext.getApplicationContext() instanceof Application))) {
      ((Application)this.mContext.getApplicationContext()).registerActivityLifecycleCallbacks(new va(this));
    }
  }
  
  public void registerSuperProperties(JSONObject paramJSONObject)
  {
    this.mPersistentIdentity.b(paramJSONObject);
  }
  
  public void registerSuperPropertiesOnce(JSONObject paramJSONObject)
  {
    this.mPersistentIdentity.c(paramJSONObject);
  }
  
  public void reset()
  {
    this.mPersistentIdentity.f();
  }
  
  boolean sendAppOpen()
  {
    if (!this.mConfig.g()) {}
    for (boolean bool = true;; bool = false) {
      return bool;
    }
  }
  
  public void timeEvent(String paramString)
  {
    long l = System.currentTimeMillis();
    synchronized (this.mEventTimings)
    {
      this.mEventTimings.put(paramString, Long.valueOf(l));
      return;
    }
  }
  
  public void track(String paramString, JSONObject paramJSONObject)
  {
    for (;;)
    {
      Long localLong;
      JSONObject localJSONObject1;
      synchronized (this.mEventTimings)
      {
        localLong = (Long)this.mEventTimings.get(paramString);
        this.mEventTimings.remove(paramString);
        try
        {
          localJSONObject1 = new JSONObject();
          Iterator localIterator1 = this.mPersistentIdentity.b().entrySet().iterator();
          if (localIterator1.hasNext())
          {
            Map.Entry localEntry = (Map.Entry)localIterator1.next();
            localJSONObject1.put((String)localEntry.getKey(), (String)localEntry.getValue());
            continue;
            return;
          }
        }
        catch (JSONException localJSONException)
        {
          new StringBuilder().append("Exception tracking event ").append(paramString).toString();
        }
      }
      JSONObject localJSONObject2 = this.mPersistentIdentity.a();
      Iterator localIterator2 = localJSONObject2.keys();
      while (localIterator2.hasNext())
      {
        String str2 = (String)localIterator2.next();
        localJSONObject1.put(str2, localJSONObject2.get(str2));
      }
      double d = System.currentTimeMillis() / 1000.0D;
      localJSONObject1.put("time", d);
      localJSONObject1.put("distinct_id", getDistinctId());
      if (localLong != null) {
        localJSONObject1.put("$duration", d - localLong.longValue() / 1000.0D);
      }
      if (paramJSONObject != null)
      {
        Iterator localIterator3 = paramJSONObject.keys();
        while (localIterator3.hasNext())
        {
          String str1 = (String)localIterator3.next();
          localJSONObject1.put(str1, paramJSONObject.get(str1));
        }
      }
      ug localug = new ug(paramString, localJSONObject1, this.mToken);
      this.mMessages.a(localug);
      if (this.mTrackingDebug != null) {
        this.mTrackingDebug.a(paramString);
      }
    }
  }
  
  public void unregisterSuperProperty(String paramString)
  {
    this.mPersistentIdentity.c(paramString);
  }
}


/* Location:           C:\Users\dreadiscool\Desktop\tools\classes-dex2jar.jar
 * Qualified Name:     com.mixpanel.android.mpmetrics.MixpanelAPI
 * JD-Core Version:    0.7.0.1
 */