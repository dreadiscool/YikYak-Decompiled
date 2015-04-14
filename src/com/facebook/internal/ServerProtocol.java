package com.facebook.internal;

import android.content.Context;
import android.os.Bundle;
import com.facebook.LoggingBehavior;
import com.facebook.Settings;
import java.util.Collection;
import org.json.JSONException;
import org.json.JSONObject;

public final class ServerProtocol
{
  private static final String DIALOG_AUTHORITY_FORMAT = "m.%s";
  public static final String DIALOG_PARAM_ACCESS_TOKEN = "access_token";
  public static final String DIALOG_PARAM_APP_ID = "app_id";
  public static final String DIALOG_PARAM_AUTH_TYPE = "auth_type";
  public static final String DIALOG_PARAM_CLIENT_ID = "client_id";
  public static final String DIALOG_PARAM_DEFAULT_AUDIENCE = "default_audience";
  public static final String DIALOG_PARAM_DISPLAY = "display";
  public static final String DIALOG_PARAM_E2E = "e2e";
  public static final String DIALOG_PARAM_LEGACY_OVERRIDE = "legacy_override";
  public static final String DIALOG_PARAM_REDIRECT_URI = "redirect_uri";
  public static final String DIALOG_PARAM_RESPONSE_TYPE = "response_type";
  public static final String DIALOG_PARAM_RETURN_SCOPES = "return_scopes";
  public static final String DIALOG_PARAM_SCOPE = "scope";
  public static final String DIALOG_PATH = "dialog/";
  public static final String DIALOG_REREQUEST_AUTH_TYPE = "rerequest";
  public static final String DIALOG_RESPONSE_TYPE_TOKEN = "token";
  public static final String DIALOG_RETURN_SCOPES_TRUE = "true";
  public static final String FALLBACK_DIALOG_DISPLAY_VALUE_TOUCH = "touch";
  public static final String FALLBACK_DIALOG_PARAM_APP_ID = "app_id";
  public static final String FALLBACK_DIALOG_PARAM_BRIDGE_ARGS = "bridge_args";
  public static final String FALLBACK_DIALOG_PARAM_KEY_HASH = "android_key_hash";
  public static final String FALLBACK_DIALOG_PARAM_METHOD_ARGS = "method_args";
  public static final String FALLBACK_DIALOG_PARAM_METHOD_RESULTS = "method_results";
  public static final String FALLBACK_DIALOG_PARAM_VERSION = "version";
  public static final String GRAPH_API_VERSION = "v2.2";
  private static final String GRAPH_URL_FORMAT = "https://graph.%s";
  private static final String GRAPH_VIDEO_URL_FORMAT = "https://graph-video.%s";
  private static final String LEGACY_API_VERSION = "v1.0";
  private static final String TAG = ServerProtocol.class.getName();
  public static final Collection<String> errorsProxyAuthDisabled;
  public static final Collection<String> errorsUserCanceled;
  
  static
  {
    String[] arrayOfString1 = new String[2];
    arrayOfString1[0] = "service_disabled";
    arrayOfString1[1] = "AndroidAuthKillSwitchException";
    errorsProxyAuthDisabled = Utility.unmodifiableCollection(arrayOfString1);
    String[] arrayOfString2 = new String[2];
    arrayOfString2[0] = "access_denied";
    arrayOfString2[1] = "OAuthAccessDeniedException";
    errorsUserCanceled = Utility.unmodifiableCollection(arrayOfString2);
  }
  
  public static final String getAPIVersion()
  {
    if (Settings.getPlatformCompatibilityEnabled()) {}
    for (String str = "v1.0";; str = "v2.2") {
      return str;
    }
  }
  
  public static final String getDialogAuthority()
  {
    Object[] arrayOfObject = new Object[1];
    arrayOfObject[0] = Settings.getFacebookDomain();
    return String.format("m.%s", arrayOfObject);
  }
  
  public static final String getGraphUrlBase()
  {
    Object[] arrayOfObject = new Object[1];
    arrayOfObject[0] = Settings.getFacebookDomain();
    return String.format("https://graph.%s", arrayOfObject);
  }
  
  public static final String getGraphVideoUrlBase()
  {
    Object[] arrayOfObject = new Object[1];
    arrayOfObject[0] = Settings.getFacebookDomain();
    return String.format("https://graph-video.%s", arrayOfObject);
  }
  
  public static Bundle getQueryParamsForPlatformActivityIntentWebFallback(Context paramContext, String paramString1, int paramInt, String paramString2, Bundle paramBundle)
  {
    Object localObject = null;
    String str = Settings.getApplicationSignature(paramContext);
    if (Utility.isNullOrEmpty(str)) {}
    for (;;)
    {
      return localObject;
      Bundle localBundle1 = new Bundle();
      localBundle1.putString("android_key_hash", str);
      localBundle1.putString("app_id", Settings.getApplicationId());
      localBundle1.putInt("version", paramInt);
      localBundle1.putString("display", "touch");
      Bundle localBundle2 = new Bundle();
      localBundle2.putString("action_id", paramString1);
      localBundle2.putString("app_name", paramString2);
      if (paramBundle == null) {
        paramBundle = new Bundle();
      }
      try
      {
        JSONObject localJSONObject1 = BundleJSONConverter.convertToJSON(localBundle2);
        JSONObject localJSONObject2 = BundleJSONConverter.convertToJSON(paramBundle);
        if ((localJSONObject1 == null) || (localJSONObject2 == null)) {
          continue;
        }
        localBundle1.putString("bridge_args", localJSONObject1.toString());
        localBundle1.putString("method_args", localJSONObject2.toString());
        localObject = localBundle1;
      }
      catch (JSONException localJSONException)
      {
        for (;;)
        {
          Logger.log(LoggingBehavior.DEVELOPER_ERRORS, 6, TAG, "Error creating Url -- " + localJSONException);
          localBundle1 = null;
        }
      }
    }
  }
}


/* Location:           C:\Users\dreadiscool\Desktop\tools\classes-dex2jar.jar
 * Qualified Name:     com.facebook.internal.ServerProtocol
 * JD-Core Version:    0.7.0.1
 */