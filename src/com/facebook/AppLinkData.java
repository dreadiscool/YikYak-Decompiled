package com.facebook;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.text.TextUtils;
import com.facebook.internal.AttributionIdentifiers;
import com.facebook.internal.Utility;
import com.facebook.internal.Validate;
import com.facebook.model.GraphObject;
import com.facebook.model.GraphObject.Factory;
import java.util.Iterator;
import java.util.concurrent.Executor;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

public class AppLinkData
{
  private static final String APPLINK_BRIDGE_ARGS_KEY = "bridge_args";
  private static final String APPLINK_METHOD_ARGS_KEY = "method_args";
  private static final String APPLINK_VERSION_KEY = "version";
  public static final String ARGUMENTS_NATIVE_CLASS_KEY = "com.facebook.platform.APPLINK_NATIVE_CLASS";
  public static final String ARGUMENTS_NATIVE_URL = "com.facebook.platform.APPLINK_NATIVE_URL";
  public static final String ARGUMENTS_REFERER_DATA_KEY = "referer_data";
  public static final String ARGUMENTS_TAPTIME_KEY = "com.facebook.platform.APPLINK_TAP_TIME_UTC";
  private static final String BRIDGE_ARGS_METHOD_KEY = "method";
  private static final String BUNDLE_AL_APPLINK_DATA_KEY = "al_applink_data";
  static final String BUNDLE_APPLINK_ARGS_KEY = "com.facebook.platform.APPLINK_ARGS";
  private static final String DEFERRED_APP_LINK_ARGS_FIELD = "applink_args";
  private static final String DEFERRED_APP_LINK_CLASS_FIELD = "applink_class";
  private static final String DEFERRED_APP_LINK_CLICK_TIME_FIELD = "click_time";
  private static final String DEFERRED_APP_LINK_EVENT = "DEFERRED_APP_LINK";
  private static final String DEFERRED_APP_LINK_PATH = "%s/activities";
  private static final String DEFERRED_APP_LINK_URL_FIELD = "applink_url";
  private static final String METHOD_ARGS_REF_KEY = "ref";
  private static final String METHOD_ARGS_TARGET_URL_KEY = "target_url";
  private static final String REFERER_DATA_REF_KEY = "fb_ref";
  private static final String TAG = AppLinkData.class.getCanonicalName();
  private Bundle argumentBundle;
  private JSONObject arguments;
  private String ref;
  private Uri targetUri;
  
  public static AppLinkData createFromActivity(Activity paramActivity)
  {
    Validate.notNull(paramActivity, "activity");
    Intent localIntent = paramActivity.getIntent();
    AppLinkData localAppLinkData;
    if (localIntent == null) {
      localAppLinkData = null;
    }
    for (;;)
    {
      return localAppLinkData;
      localAppLinkData = createFromAlApplinkData(localIntent);
      if (localAppLinkData == null) {
        localAppLinkData = createFromJson(localIntent.getStringExtra("com.facebook.platform.APPLINK_ARGS"));
      }
      if (localAppLinkData == null) {
        localAppLinkData = createFromUri(localIntent.getData());
      }
    }
  }
  
  private static AppLinkData createFromAlApplinkData(Intent paramIntent)
  {
    Object localObject = null;
    Bundle localBundle1 = paramIntent.getBundleExtra("al_applink_data");
    if (localBundle1 == null) {}
    for (;;)
    {
      return localObject;
      AppLinkData localAppLinkData = new AppLinkData();
      localAppLinkData.targetUri = paramIntent.getData();
      if (localAppLinkData.targetUri == null)
      {
        String str = localBundle1.getString("target_url");
        if (str != null) {
          localAppLinkData.targetUri = Uri.parse(str);
        }
      }
      localAppLinkData.argumentBundle = localBundle1;
      localAppLinkData.arguments = null;
      Bundle localBundle2 = localBundle1.getBundle("referer_data");
      if (localBundle2 != null) {
        localAppLinkData.ref = localBundle2.getString("fb_ref");
      }
      localObject = localAppLinkData;
    }
  }
  
  private static AppLinkData createFromJson(String paramString)
  {
    Object localObject = null;
    if (paramString == null) {}
    for (;;)
    {
      return localObject;
      try
      {
        JSONObject localJSONObject1 = new JSONObject(paramString);
        String str = localJSONObject1.getString("version");
        if ((localJSONObject1.getJSONObject("bridge_args").getString("method").equals("applink")) && (str.equals("2")))
        {
          AppLinkData localAppLinkData = new AppLinkData();
          localAppLinkData.arguments = localJSONObject1.getJSONObject("method_args");
          if (localAppLinkData.arguments.has("ref")) {
            localAppLinkData.ref = localAppLinkData.arguments.getString("ref");
          }
          for (;;)
          {
            if (localAppLinkData.arguments.has("target_url")) {
              localAppLinkData.targetUri = Uri.parse(localAppLinkData.arguments.getString("target_url"));
            }
            localAppLinkData.argumentBundle = toBundle(localAppLinkData.arguments);
            localObject = localAppLinkData;
            break;
            if (localAppLinkData.arguments.has("referer_data"))
            {
              JSONObject localJSONObject2 = localAppLinkData.arguments.getJSONObject("referer_data");
              if (localJSONObject2.has("fb_ref")) {
                localAppLinkData.ref = localJSONObject2.getString("fb_ref");
              }
            }
          }
        }
      }
      catch (JSONException localJSONException) {}catch (FacebookException localFacebookException) {}
    }
  }
  
  private static AppLinkData createFromUri(Uri paramUri)
  {
    AppLinkData localAppLinkData;
    if (paramUri == null) {
      localAppLinkData = null;
    }
    for (;;)
    {
      return localAppLinkData;
      localAppLinkData = new AppLinkData();
      localAppLinkData.targetUri = paramUri;
    }
  }
  
  public static void fetchDeferredAppLinkData(Context paramContext, AppLinkData.CompletionHandler paramCompletionHandler)
  {
    fetchDeferredAppLinkData(paramContext, null, paramCompletionHandler);
  }
  
  public static void fetchDeferredAppLinkData(Context paramContext, String paramString, AppLinkData.CompletionHandler paramCompletionHandler)
  {
    Validate.notNull(paramContext, "context");
    Validate.notNull(paramCompletionHandler, "completionHandler");
    if (paramString == null) {
      paramString = Utility.getMetadataApplicationId(paramContext);
    }
    Validate.notNull(paramString, "applicationId");
    Context localContext = paramContext.getApplicationContext();
    Settings.getExecutor().execute(new AppLinkData.1(localContext, paramString, paramCompletionHandler));
  }
  
  private static void fetchDeferredAppLinkFromServer(Context paramContext, String paramString, AppLinkData.CompletionHandler paramCompletionHandler)
  {
    Object localObject = null;
    GraphObject localGraphObject1 = GraphObject.Factory.create();
    localGraphObject1.setProperty("event", "DEFERRED_APP_LINK");
    Utility.setAppEventAttributionParameters(localGraphObject1, AttributionIdentifiers.getAttributionIdentifiers(paramContext), AppEventsLogger.getAnonymousAppDeviceGUID(paramContext), Settings.getLimitEventAndDataUsage(paramContext));
    localGraphObject1.setProperty("application_package_name", paramContext.getPackageName());
    Object[] arrayOfObject = new Object[1];
    arrayOfObject[0] = paramString;
    String str1 = String.format("%s/activities", arrayOfObject);
    try
    {
      GraphObject localGraphObject2 = Request.newPostRequest(null, str1, localGraphObject1, null).executeAndWait().getGraphObject();
      if (localGraphObject2 != null)
      {
        localJSONObject = localGraphObject2.getInnerJSONObject();
        if (localJSONObject != null)
        {
          String str2 = localJSONObject.optString("applink_args");
          l = localJSONObject.optLong("click_time", -1L);
          str3 = localJSONObject.optString("applink_class");
          str4 = localJSONObject.optString("applink_url");
          if (!TextUtils.isEmpty(str2))
          {
            AppLinkData localAppLinkData = createFromJson(str2);
            localObject = localAppLinkData;
            if (l == -1L) {}
          }
        }
      }
    }
    catch (Exception localException)
    {
      try
      {
        for (;;)
        {
          JSONObject localJSONObject;
          long l;
          String str3;
          String str4;
          if (localObject.arguments != null) {
            localObject.arguments.put("com.facebook.platform.APPLINK_TAP_TIME_UTC", l);
          }
          if (localObject.argumentBundle != null) {
            localObject.argumentBundle.putString("com.facebook.platform.APPLINK_TAP_TIME_UTC", Long.toString(l));
          }
          label211:
          if (str3 != null) {}
          try
          {
            if (localObject.arguments != null) {
              localObject.arguments.put("com.facebook.platform.APPLINK_NATIVE_CLASS", str3);
            }
            if (localObject.argumentBundle != null) {
              localObject.argumentBundle.putString("com.facebook.platform.APPLINK_NATIVE_CLASS", str3);
            }
            label253:
            if (str4 != null) {}
            try
            {
              if (localObject.arguments != null) {
                localObject.arguments.put("com.facebook.platform.APPLINK_NATIVE_URL", str4);
              }
              if (localObject.argumentBundle != null) {
                localObject.argumentBundle.putString("com.facebook.platform.APPLINK_NATIVE_URL", str4);
              }
              for (;;)
              {
                label295:
                paramCompletionHandler.onDeferredAppLinkDataFetched(localObject);
                return;
                localJSONObject = null;
                break;
                localException = localException;
                Utility.logd(TAG, "Unable to fetch deferred applink from server");
              }
            }
            catch (JSONException localJSONException1)
            {
              break label295;
            }
          }
          catch (JSONException localJSONException2)
          {
            break label253;
          }
        }
      }
      catch (JSONException localJSONException3)
      {
        break label211;
      }
    }
  }
  
  private static Bundle toBundle(JSONObject paramJSONObject)
  {
    Bundle localBundle = new Bundle();
    Iterator localIterator = paramJSONObject.keys();
    while (localIterator.hasNext())
    {
      String str = (String)localIterator.next();
      Object localObject1 = paramJSONObject.get(str);
      if ((localObject1 instanceof JSONObject))
      {
        localBundle.putBundle(str, toBundle((JSONObject)localObject1));
      }
      else if ((localObject1 instanceof JSONArray))
      {
        JSONArray localJSONArray = (JSONArray)localObject1;
        if (localJSONArray.length() == 0)
        {
          localBundle.putStringArray(str, new String[0]);
        }
        else
        {
          Object localObject2 = localJSONArray.get(0);
          if ((localObject2 instanceof JSONObject))
          {
            Bundle[] arrayOfBundle = new Bundle[localJSONArray.length()];
            for (int j = 0; j < localJSONArray.length(); j++) {
              arrayOfBundle[j] = toBundle(localJSONArray.getJSONObject(j));
            }
            localBundle.putParcelableArray(str, arrayOfBundle);
          }
          else
          {
            if ((localObject2 instanceof JSONArray)) {
              throw new FacebookException("Nested arrays are not supported.");
            }
            String[] arrayOfString = new String[localJSONArray.length()];
            for (int i = 0; i < localJSONArray.length(); i++) {
              arrayOfString[i] = localJSONArray.get(i).toString();
            }
            localBundle.putStringArray(str, arrayOfString);
          }
        }
      }
      else
      {
        localBundle.putString(str, localObject1.toString());
      }
    }
    return localBundle;
  }
  
  public Bundle getArgumentBundle()
  {
    return this.argumentBundle;
  }
  
  @Deprecated
  public JSONObject getArguments()
  {
    return this.arguments;
  }
  
  public String getRef()
  {
    return this.ref;
  }
  
  public Bundle getRefererData()
  {
    if (this.argumentBundle != null) {}
    for (Bundle localBundle = this.argumentBundle.getBundle("referer_data");; localBundle = null) {
      return localBundle;
    }
  }
  
  public Uri getTargetUri()
  {
    return this.targetUri;
  }
}


/* Location:           C:\Users\dreadiscool\Desktop\tools\classes-dex2jar.jar
 * Qualified Name:     com.facebook.AppLinkData
 * JD-Core Version:    0.7.0.1
 */