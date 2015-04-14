package com.facebook.internal;

import android.content.ContentResolver;
import android.content.Context;
import android.content.Intent;
import android.content.pm.ActivityInfo;
import android.content.pm.PackageManager;
import android.content.pm.ResolveInfo;
import android.content.pm.ServiceInfo;
import android.database.Cursor;
import android.net.Uri;
import android.os.Bundle;
import android.text.TextUtils;
import com.facebook.FacebookException;
import com.facebook.FacebookOperationCanceledException;
import com.facebook.SessionDefaultAudience;
import com.facebook.Settings;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.TreeSet;
import java.util.UUID;

public final class NativeProtocol
{
  public static final String ACTION_FEED_DIALOG = "com.facebook.platform.action.request.FEED_DIALOG";
  public static final String ACTION_FEED_DIALOG_REPLY = "com.facebook.platform.action.reply.FEED_DIALOG";
  public static final String ACTION_LIKE_DIALOG = "com.facebook.platform.action.request.LIKE_DIALOG";
  public static final String ACTION_LIKE_DIALOG_REPLY = "com.facebook.platform.action.reply.LIKE_DIALOG";
  public static final String ACTION_MESSAGE_DIALOG = "com.facebook.platform.action.request.MESSAGE_DIALOG";
  public static final String ACTION_MESSAGE_DIALOG_REPLY = "com.facebook.platform.action.reply.MESSAGE_DIALOG";
  public static final String ACTION_OGACTIONPUBLISH_DIALOG = "com.facebook.platform.action.request.OGACTIONPUBLISH_DIALOG";
  public static final String ACTION_OGACTIONPUBLISH_DIALOG_REPLY = "com.facebook.platform.action.reply.OGACTIONPUBLISH_DIALOG";
  public static final String ACTION_OGMESSAGEPUBLISH_DIALOG = "com.facebook.platform.action.request.OGMESSAGEPUBLISH_DIALOG";
  public static final String ACTION_OGMESSAGEPUBLISH_DIALOG_REPLY = "com.facebook.platform.action.reply.OGMESSAGEPUBLISH_DIALOG";
  public static final String AUDIENCE_EVERYONE = "everyone";
  public static final String AUDIENCE_FRIENDS = "friends";
  public static final String AUDIENCE_ME = "only_me";
  public static final String BRIDGE_ARG_ACTION_ID_STRING = "action_id";
  public static final String BRIDGE_ARG_APP_NAME_STRING = "app_name";
  public static final String BRIDGE_ARG_ERROR_BUNDLE = "error";
  public static final String BRIDGE_ARG_ERROR_CODE = "error_code";
  public static final String BRIDGE_ARG_ERROR_DESCRIPTION = "error_description";
  public static final String BRIDGE_ARG_ERROR_JSON = "error_json";
  public static final String BRIDGE_ARG_ERROR_SUBCODE = "error_subcode";
  public static final String BRIDGE_ARG_ERROR_TYPE = "error_type";
  private static final String CONTENT_SCHEME = "content://";
  public static final int DIALOG_REQUEST_CODE = 64207;
  public static final String ERROR_APPLICATION_ERROR = "ApplicationError";
  public static final String ERROR_NETWORK_ERROR = "NetworkError";
  public static final String ERROR_PERMISSION_DENIED = "PermissionDenied";
  public static final String ERROR_PROTOCOL_ERROR = "ProtocolError";
  public static final String ERROR_SERVICE_DISABLED = "ServiceDisabled";
  public static final String ERROR_UNKNOWN_ERROR = "UnknownError";
  public static final String ERROR_USER_CANCELED = "UserCanceled";
  public static final String EXTRA_ACCESS_TOKEN = "com.facebook.platform.extra.ACCESS_TOKEN";
  public static final String EXTRA_ACTION = "com.facebook.platform.extra.ACTION";
  public static final String EXTRA_ACTION_TYPE = "com.facebook.platform.extra.ACTION_TYPE";
  public static final String EXTRA_APPLICATION_ID = "com.facebook.platform.extra.APPLICATION_ID";
  public static final String EXTRA_APPLICATION_NAME = "com.facebook.platform.extra.APPLICATION_NAME";
  public static final String EXTRA_DATA_FAILURES_FATAL = "com.facebook.platform.extra.DATA_FAILURES_FATAL";
  public static final String EXTRA_DESCRIPTION = "com.facebook.platform.extra.DESCRIPTION";
  public static final String EXTRA_EXPIRES_SECONDS_SINCE_EPOCH = "com.facebook.platform.extra.EXPIRES_SECONDS_SINCE_EPOCH";
  public static final String EXTRA_FRIEND_TAGS = "com.facebook.platform.extra.FRIENDS";
  public static final String EXTRA_GET_INSTALL_DATA_PACKAGE = "com.facebook.platform.extra.INSTALLDATA_PACKAGE";
  public static final String EXTRA_IMAGE = "com.facebook.platform.extra.IMAGE";
  public static final String EXTRA_LIKE_COUNT_STRING_WITHOUT_LIKE = "com.facebook.platform.extra.LIKE_COUNT_STRING_WITHOUT_LIKE";
  public static final String EXTRA_LIKE_COUNT_STRING_WITH_LIKE = "com.facebook.platform.extra.LIKE_COUNT_STRING_WITH_LIKE";
  public static final String EXTRA_LINK = "com.facebook.platform.extra.LINK";
  public static final String EXTRA_OBJECT_ID = "com.facebook.platform.extra.OBJECT_ID";
  public static final String EXTRA_OBJECT_IS_LIKED = "com.facebook.platform.extra.OBJECT_IS_LIKED";
  public static final String EXTRA_PERMISSIONS = "com.facebook.platform.extra.PERMISSIONS";
  public static final String EXTRA_PHOTOS = "com.facebook.platform.extra.PHOTOS";
  public static final String EXTRA_PLACE_TAG = "com.facebook.platform.extra.PLACE";
  public static final String EXTRA_PREVIEW_PROPERTY_NAME = "com.facebook.platform.extra.PREVIEW_PROPERTY_NAME";
  public static final String EXTRA_PROTOCOL_ACTION = "com.facebook.platform.protocol.PROTOCOL_ACTION";
  public static final String EXTRA_PROTOCOL_BRIDGE_ARGS = "com.facebook.platform.protocol.BRIDGE_ARGS";
  public static final String EXTRA_PROTOCOL_CALL_ID = "com.facebook.platform.protocol.CALL_ID";
  public static final String EXTRA_PROTOCOL_METHOD_ARGS = "com.facebook.platform.protocol.METHOD_ARGS";
  public static final String EXTRA_PROTOCOL_METHOD_RESULTS = "com.facebook.platform.protocol.RESULT_ARGS";
  public static final String EXTRA_PROTOCOL_VERSION = "com.facebook.platform.protocol.PROTOCOL_VERSION";
  static final String EXTRA_PROTOCOL_VERSIONS = "com.facebook.platform.extra.PROTOCOL_VERSIONS";
  public static final String EXTRA_REF = "com.facebook.platform.extra.REF";
  public static final String EXTRA_SOCIAL_SENTENCE_WITHOUT_LIKE = "com.facebook.platform.extra.SOCIAL_SENTENCE_WITHOUT_LIKE";
  public static final String EXTRA_SOCIAL_SENTENCE_WITH_LIKE = "com.facebook.platform.extra.SOCIAL_SENTENCE_WITH_LIKE";
  public static final String EXTRA_SUBTITLE = "com.facebook.platform.extra.SUBTITLE";
  public static final String EXTRA_TITLE = "com.facebook.platform.extra.TITLE";
  public static final String EXTRA_UNLIKE_TOKEN = "com.facebook.platform.extra.UNLIKE_TOKEN";
  private static final NativeProtocol.NativeAppInfo FACEBOOK_APP_INFO = new NativeProtocol.KatanaAppInfo(null);
  private static final String FACEBOOK_PROXY_AUTH_ACTIVITY = "com.facebook.katana.ProxyAuth";
  public static final String FACEBOOK_PROXY_AUTH_APP_ID_KEY = "client_id";
  public static final String FACEBOOK_PROXY_AUTH_E2E_KEY = "e2e";
  public static final String FACEBOOK_PROXY_AUTH_PERMISSIONS_KEY = "scope";
  private static final String FACEBOOK_TOKEN_REFRESH_ACTIVITY = "com.facebook.katana.platform.TokenRefreshService";
  public static final String IMAGE_URL_KEY = "url";
  public static final String IMAGE_USER_GENERATED_KEY = "user_generated";
  static final String INTENT_ACTION_PLATFORM_ACTIVITY = "com.facebook.platform.PLATFORM_ACTIVITY";
  static final String INTENT_ACTION_PLATFORM_SERVICE = "com.facebook.platform.PLATFORM_SERVICE";
  private static final List<Integer> KNOWN_PROTOCOL_VERSIONS;
  public static final int MESSAGE_GET_ACCESS_TOKEN_REPLY = 65537;
  public static final int MESSAGE_GET_ACCESS_TOKEN_REQUEST = 65536;
  public static final int MESSAGE_GET_INSTALL_DATA_REPLY = 65541;
  public static final int MESSAGE_GET_INSTALL_DATA_REQUEST = 65540;
  public static final int MESSAGE_GET_LIKE_STATUS_REPLY = 65543;
  public static final int MESSAGE_GET_LIKE_STATUS_REQUEST = 65542;
  static final int MESSAGE_GET_PROTOCOL_VERSIONS_REPLY = 65539;
  static final int MESSAGE_GET_PROTOCOL_VERSIONS_REQUEST = 65538;
  public static final String METHOD_ARGS_ACTION = "ACTION";
  public static final String METHOD_ARGS_ACTION_TYPE = "ACTION_TYPE";
  public static final String METHOD_ARGS_DATA_FAILURES_FATAL = "DATA_FAILURES_FATAL";
  public static final String METHOD_ARGS_DESCRIPTION = "DESCRIPTION";
  public static final String METHOD_ARGS_FRIEND_TAGS = "FRIENDS";
  public static final String METHOD_ARGS_IMAGE = "IMAGE";
  public static final String METHOD_ARGS_LINK = "LINK";
  public static final String METHOD_ARGS_OBJECT_ID = "object_id";
  public static final String METHOD_ARGS_PHOTOS = "PHOTOS";
  public static final String METHOD_ARGS_PLACE_TAG = "PLACE";
  public static final String METHOD_ARGS_PREVIEW_PROPERTY_NAME = "PREVIEW_PROPERTY_NAME";
  public static final String METHOD_ARGS_REF = "REF";
  public static final String METHOD_ARGS_SUBTITLE = "SUBTITLE";
  public static final String METHOD_ARGS_TITLE = "TITLE";
  public static final String METHOD_ARGS_VIDEO = "VIDEO";
  public static final int NO_PROTOCOL_AVAILABLE = -1;
  public static final String OPEN_GRAPH_CREATE_OBJECT_KEY = "fbsdk:create_object";
  private static final String PLATFORM_PROVIDER_VERSIONS = ".provider.PlatformProvider/versions";
  private static final String PLATFORM_PROVIDER_VERSION_COLUMN = "version";
  public static final int PROTOCOL_VERSION_20121101 = 20121101;
  public static final int PROTOCOL_VERSION_20130502 = 20130502;
  public static final int PROTOCOL_VERSION_20130618 = 20130618;
  public static final int PROTOCOL_VERSION_20131107 = 20131107;
  public static final int PROTOCOL_VERSION_20140204 = 20140204;
  public static final int PROTOCOL_VERSION_20140324 = 20140324;
  public static final int PROTOCOL_VERSION_20140701 = 20140701;
  public static final int PROTOCOL_VERSION_20141001 = 20141001;
  public static final int PROTOCOL_VERSION_20141028 = 20141028;
  public static final int PROTOCOL_VERSION_20141107 = 20141107;
  public static final int PROTOCOL_VERSION_20141218 = 20141218;
  public static final String RESULT_ARGS_ACCESS_TOKEN = "access_token";
  public static final String RESULT_ARGS_EXPIRES_SECONDS_SINCE_EPOCH = "expires_seconds_since_epoch";
  public static final String RESULT_ARGS_PERMISSIONS = "permissions";
  public static final String STATUS_ERROR_CODE = "com.facebook.platform.status.ERROR_CODE";
  public static final String STATUS_ERROR_DESCRIPTION = "com.facebook.platform.status.ERROR_DESCRIPTION";
  public static final String STATUS_ERROR_JSON = "com.facebook.platform.status.ERROR_JSON";
  public static final String STATUS_ERROR_SUBCODE = "com.facebook.platform.status.ERROR_SUBCODE";
  public static final String STATUS_ERROR_TYPE = "com.facebook.platform.status.ERROR_TYPE";
  private static Map<String, List<NativeProtocol.NativeAppInfo>> actionToAppInfoMap;
  private static List<NativeProtocol.NativeAppInfo> facebookAppInfoList = buildFacebookAppList();
  
  static
  {
    actionToAppInfoMap = buildActionToAppInfoMap();
    Integer[] arrayOfInteger = new Integer[11];
    arrayOfInteger[0] = Integer.valueOf(20141218);
    arrayOfInteger[1] = Integer.valueOf(20141107);
    arrayOfInteger[2] = Integer.valueOf(20141028);
    arrayOfInteger[3] = Integer.valueOf(20141001);
    arrayOfInteger[4] = Integer.valueOf(20140701);
    arrayOfInteger[5] = Integer.valueOf(20140324);
    arrayOfInteger[6] = Integer.valueOf(20140204);
    arrayOfInteger[7] = Integer.valueOf(20131107);
    arrayOfInteger[8] = Integer.valueOf(20130618);
    arrayOfInteger[9] = Integer.valueOf(20130502);
    arrayOfInteger[10] = Integer.valueOf(20121101);
    KNOWN_PROTOCOL_VERSIONS = Arrays.asList(arrayOfInteger);
  }
  
  private static Map<String, List<NativeProtocol.NativeAppInfo>> buildActionToAppInfoMap()
  {
    HashMap localHashMap = new HashMap();
    ArrayList localArrayList = new ArrayList();
    localArrayList.add(new NativeProtocol.MessengerAppInfo(null));
    localHashMap.put("com.facebook.platform.action.request.OGACTIONPUBLISH_DIALOG", facebookAppInfoList);
    localHashMap.put("com.facebook.platform.action.request.FEED_DIALOG", facebookAppInfoList);
    localHashMap.put("com.facebook.platform.action.request.LIKE_DIALOG", facebookAppInfoList);
    localHashMap.put("com.facebook.platform.action.request.MESSAGE_DIALOG", localArrayList);
    localHashMap.put("com.facebook.platform.action.request.OGMESSAGEPUBLISH_DIALOG", localArrayList);
    return localHashMap;
  }
  
  private static List<NativeProtocol.NativeAppInfo> buildFacebookAppList()
  {
    ArrayList localArrayList = new ArrayList();
    localArrayList.add(FACEBOOK_APP_INFO);
    localArrayList.add(new NativeProtocol.WakizashiAppInfo(null));
    return localArrayList;
  }
  
  private static Uri buildPlatformProviderVersionURI(NativeProtocol.NativeAppInfo paramNativeAppInfo)
  {
    return Uri.parse("content://" + paramNativeAppInfo.getPackage() + ".provider.PlatformProvider/versions");
  }
  
  public static int computeLatestAvailableVersionFromVersionSpec(TreeSet<Integer> paramTreeSet, int paramInt, int[] paramArrayOfInt)
  {
    int i = -1;
    int j = -1 + paramArrayOfInt.length;
    Iterator localIterator = paramTreeSet.descendingIterator();
    int k = i;
    int m = j;
    for (;;)
    {
      int n;
      int i1;
      int i2;
      if (localIterator.hasNext())
      {
        n = ((Integer)localIterator.next()).intValue();
        i1 = Math.max(k, n);
        for (i2 = m; (i2 >= 0) && (paramArrayOfInt[i2] > n); i2--) {}
        if (i2 >= 0) {
          break label88;
        }
      }
      for (;;)
      {
        return i;
        label88:
        if (paramArrayOfInt[i2] != n) {
          break;
        }
        if (i2 % 2 == 0) {
          i = Math.min(i1, paramInt);
        }
      }
      m = i2;
      k = i1;
    }
  }
  
  public static Intent createPlatformActivityIntent(Context paramContext, String paramString1, String paramString2, int paramInt, String paramString3, Bundle paramBundle)
  {
    Intent localIntent = findActivityIntent(paramContext, "com.facebook.platform.PLATFORM_ACTIVITY", paramString2);
    if (localIntent == null) {
      localIntent = null;
    }
    for (;;)
    {
      return localIntent;
      String str = Utility.getMetadataApplicationId(paramContext);
      localIntent.putExtra("com.facebook.platform.protocol.PROTOCOL_VERSION", paramInt).putExtra("com.facebook.platform.protocol.PROTOCOL_ACTION", paramString2).putExtra("com.facebook.platform.extra.APPLICATION_ID", str);
      if (isVersionCompatibleWithBucketedIntent(paramInt))
      {
        Bundle localBundle = new Bundle();
        localBundle.putString("action_id", paramString1);
        localBundle.putString("app_name", paramString3);
        localIntent.putExtra("com.facebook.platform.protocol.BRIDGE_ARGS", localBundle);
        if (paramBundle == null) {
          paramBundle = new Bundle();
        }
        localIntent.putExtra("com.facebook.platform.protocol.METHOD_ARGS", paramBundle);
      }
      else
      {
        localIntent.putExtra("com.facebook.platform.protocol.CALL_ID", paramString1);
        localIntent.putExtra("com.facebook.platform.extra.APPLICATION_NAME", paramString3);
        localIntent.putExtras(paramBundle);
      }
    }
  }
  
  public static Intent createPlatformServiceIntent(Context paramContext)
  {
    Iterator localIterator = facebookAppInfoList.iterator();
    Intent localIntent;
    do
    {
      if (!localIterator.hasNext()) {
        break;
      }
      NativeProtocol.NativeAppInfo localNativeAppInfo = (NativeProtocol.NativeAppInfo)localIterator.next();
      localIntent = validateServiceIntent(paramContext, new Intent("com.facebook.platform.PLATFORM_SERVICE").setPackage(localNativeAppInfo.getPackage()).addCategory("android.intent.category.DEFAULT"), localNativeAppInfo);
    } while (localIntent == null);
    for (;;)
    {
      return localIntent;
      localIntent = null;
    }
  }
  
  public static Intent createProxyAuthIntent(Context paramContext, String paramString1, List<String> paramList, String paramString2, boolean paramBoolean, SessionDefaultAudience paramSessionDefaultAudience)
  {
    Iterator localIterator = facebookAppInfoList.iterator();
    Intent localIntent1;
    do
    {
      if (!localIterator.hasNext()) {
        break;
      }
      NativeProtocol.NativeAppInfo localNativeAppInfo = (NativeProtocol.NativeAppInfo)localIterator.next();
      Intent localIntent2 = new Intent().setClassName(localNativeAppInfo.getPackage(), "com.facebook.katana.ProxyAuth").putExtra("client_id", paramString1);
      if (!Utility.isNullOrEmpty(paramList)) {
        localIntent2.putExtra("scope", TextUtils.join(",", paramList));
      }
      if (!Utility.isNullOrEmpty(paramString2)) {
        localIntent2.putExtra("e2e", paramString2);
      }
      localIntent2.putExtra("response_type", "token");
      localIntent2.putExtra("return_scopes", "true");
      localIntent2.putExtra("default_audience", paramSessionDefaultAudience.getNativeProtocolAudience());
      if (!Settings.getPlatformCompatibilityEnabled())
      {
        localIntent2.putExtra("legacy_override", "v2.2");
        if (paramBoolean) {
          localIntent2.putExtra("auth_type", "rerequest");
        }
      }
      localIntent1 = validateActivityIntent(paramContext, localIntent2, localNativeAppInfo);
    } while (localIntent1 == null);
    for (;;)
    {
      return localIntent1;
      localIntent1 = null;
    }
  }
  
  public static Intent createTokenRefreshIntent(Context paramContext)
  {
    Iterator localIterator = facebookAppInfoList.iterator();
    Intent localIntent;
    do
    {
      if (!localIterator.hasNext()) {
        break;
      }
      NativeProtocol.NativeAppInfo localNativeAppInfo = (NativeProtocol.NativeAppInfo)localIterator.next();
      localIntent = validateServiceIntent(paramContext, new Intent().setClassName(localNativeAppInfo.getPackage(), "com.facebook.katana.platform.TokenRefreshService"), localNativeAppInfo);
    } while (localIntent == null);
    for (;;)
    {
      return localIntent;
      localIntent = null;
    }
  }
  
  private static Intent findActivityIntent(Context paramContext, String paramString1, String paramString2)
  {
    List localList = (List)actionToAppInfoMap.get(paramString2);
    Intent localIntent;
    if (localList == null) {
      localIntent = null;
    }
    for (;;)
    {
      return localIntent;
      Iterator localIterator = localList.iterator();
      localIntent = null;
      if (localIterator.hasNext())
      {
        NativeProtocol.NativeAppInfo localNativeAppInfo = (NativeProtocol.NativeAppInfo)localIterator.next();
        localIntent = validateActivityIntent(paramContext, new Intent().setAction(paramString1).setPackage(localNativeAppInfo.getPackage()).addCategory("android.intent.category.DEFAULT"), localNativeAppInfo);
        if (localIntent == null) {
          break;
        }
      }
    }
  }
  
  private static TreeSet<Integer> getAllAvailableProtocolVersionsForAppInfo(Context paramContext, NativeProtocol.NativeAppInfo paramNativeAppInfo)
  {
    localTreeSet = new TreeSet();
    ContentResolver localContentResolver = paramContext.getContentResolver();
    String[] arrayOfString = new String[1];
    arrayOfString[0] = "version";
    Uri localUri = buildPlatformProviderVersionURI(paramNativeAppInfo);
    for (;;)
    {
      try
      {
        Cursor localCursor2 = localContentResolver.query(localUri, arrayOfString, null, null, null);
        localCursor1 = localCursor2;
        if (localCursor1 == null) {}
      }
      finally
      {
        Cursor localCursor1 = null;
        continue;
      }
      try
      {
        if (localCursor1.moveToNext()) {}
        return localTreeSet;
      }
      finally
      {
        if (localCursor1 != null) {
          localCursor1.close();
        }
      }
    }
  }
  
  public static Bundle getBridgeArgumentsFromIntent(Intent paramIntent)
  {
    if (!isVersionCompatibleWithBucketedIntent(getProtocolVersionFromIntent(paramIntent))) {}
    for (Bundle localBundle = null;; localBundle = paramIntent.getBundleExtra("com.facebook.platform.protocol.BRIDGE_ARGS")) {
      return localBundle;
    }
  }
  
  public static UUID getCallIdFromIntent(Intent paramIntent)
  {
    Object localObject = null;
    if (paramIntent == null) {}
    label69:
    label72:
    for (;;)
    {
      return localObject;
      String str;
      if (isVersionCompatibleWithBucketedIntent(getProtocolVersionFromIntent(paramIntent)))
      {
        Bundle localBundle = paramIntent.getBundleExtra("com.facebook.platform.protocol.BRIDGE_ARGS");
        if (localBundle == null) {
          break label69;
        }
        str = localBundle.getString("action_id");
      }
      for (;;)
      {
        for (;;)
        {
          if (str == null) {
            break label72;
          }
          try
          {
            UUID localUUID = UUID.fromString(str);
            localObject = localUUID;
          }
          catch (IllegalArgumentException localIllegalArgumentException) {}
        }
        str = paramIntent.getStringExtra("com.facebook.platform.protocol.CALL_ID");
        continue;
        break;
        str = null;
      }
    }
  }
  
  public static Bundle getErrorDataFromResultIntent(Intent paramIntent)
  {
    Bundle localBundle2;
    if (!isErrorResult(paramIntent)) {
      localBundle2 = null;
    }
    for (;;)
    {
      return localBundle2;
      Bundle localBundle1 = getBridgeArgumentsFromIntent(paramIntent);
      if (localBundle1 != null) {
        localBundle2 = localBundle1.getBundle("error");
      } else {
        localBundle2 = paramIntent.getExtras();
      }
    }
  }
  
  public static Exception getExceptionFromErrorData(Bundle paramBundle)
  {
    Object localObject;
    if (paramBundle == null) {
      localObject = null;
    }
    for (;;)
    {
      return localObject;
      String str1 = paramBundle.getString("error_type");
      if (str1 == null) {
        str1 = paramBundle.getString("com.facebook.platform.status.ERROR_TYPE");
      }
      String str2 = paramBundle.getString("error_description");
      if (str2 == null) {
        str2 = paramBundle.getString("com.facebook.platform.status.ERROR_DESCRIPTION");
      }
      if ((str1 != null) && (str1.equalsIgnoreCase("UserCanceled"))) {
        localObject = new FacebookOperationCanceledException(str2);
      } else {
        localObject = new FacebookException(str2);
      }
    }
  }
  
  public static int getLatestAvailableProtocolVersionForAction(Context paramContext, String paramString, int[] paramArrayOfInt)
  {
    return getLatestAvailableProtocolVersionForAppInfoList(paramContext, (List)actionToAppInfoMap.get(paramString), paramArrayOfInt);
  }
  
  private static int getLatestAvailableProtocolVersionForAppInfo(Context paramContext, NativeProtocol.NativeAppInfo paramNativeAppInfo, int[] paramArrayOfInt)
  {
    return computeLatestAvailableVersionFromVersionSpec(getAllAvailableProtocolVersionsForAppInfo(paramContext, paramNativeAppInfo), getLatestKnownVersion(), paramArrayOfInt);
  }
  
  private static int getLatestAvailableProtocolVersionForAppInfoList(Context paramContext, List<NativeProtocol.NativeAppInfo> paramList, int[] paramArrayOfInt)
  {
    int i;
    if (paramList == null) {
      i = -1;
    }
    for (;;)
    {
      return i;
      Iterator localIterator = paramList.iterator();
      for (;;)
      {
        if (localIterator.hasNext())
        {
          i = getLatestAvailableProtocolVersionForAppInfo(paramContext, (NativeProtocol.NativeAppInfo)localIterator.next(), paramArrayOfInt);
          if (i != -1) {
            break;
          }
        }
      }
      i = -1;
    }
  }
  
  public static int getLatestAvailableProtocolVersionForService(Context paramContext, int paramInt)
  {
    List localList = facebookAppInfoList;
    int[] arrayOfInt = new int[1];
    arrayOfInt[0] = paramInt;
    return getLatestAvailableProtocolVersionForAppInfoList(paramContext, localList, arrayOfInt);
  }
  
  public static final int getLatestKnownVersion()
  {
    return ((Integer)KNOWN_PROTOCOL_VERSIONS.get(0)).intValue();
  }
  
  public static int getProtocolVersionFromIntent(Intent paramIntent)
  {
    return paramIntent.getIntExtra("com.facebook.platform.protocol.PROTOCOL_VERSION", 0);
  }
  
  public static Bundle getSuccessResultsFromIntent(Intent paramIntent)
  {
    int i = getProtocolVersionFromIntent(paramIntent);
    Bundle localBundle = paramIntent.getExtras();
    if ((!isVersionCompatibleWithBucketedIntent(i)) || (localBundle == null)) {}
    for (;;)
    {
      return localBundle;
      localBundle = localBundle.getBundle("com.facebook.platform.protocol.RESULT_ARGS");
    }
  }
  
  public static boolean isErrorResult(Intent paramIntent)
  {
    Bundle localBundle = getBridgeArgumentsFromIntent(paramIntent);
    if (localBundle != null) {}
    for (boolean bool = localBundle.containsKey("error");; bool = paramIntent.hasExtra("com.facebook.platform.status.ERROR_TYPE")) {
      return bool;
    }
  }
  
  public static boolean isVersionCompatibleWithBucketedIntent(int paramInt)
  {
    if ((KNOWN_PROTOCOL_VERSIONS.contains(Integer.valueOf(paramInt))) && (paramInt >= 20140701)) {}
    for (boolean bool = true;; bool = false) {
      return bool;
    }
  }
  
  static Intent validateActivityIntent(Context paramContext, Intent paramIntent, NativeProtocol.NativeAppInfo paramNativeAppInfo)
  {
    if (paramIntent == null) {
      paramIntent = null;
    }
    for (;;)
    {
      return paramIntent;
      ResolveInfo localResolveInfo = paramContext.getPackageManager().resolveActivity(paramIntent, 0);
      if (localResolveInfo == null) {
        paramIntent = null;
      } else if (!paramNativeAppInfo.validateSignature(paramContext, localResolveInfo.activityInfo.packageName)) {
        paramIntent = null;
      }
    }
  }
  
  static Intent validateServiceIntent(Context paramContext, Intent paramIntent, NativeProtocol.NativeAppInfo paramNativeAppInfo)
  {
    if (paramIntent == null) {
      paramIntent = null;
    }
    for (;;)
    {
      return paramIntent;
      ResolveInfo localResolveInfo = paramContext.getPackageManager().resolveService(paramIntent, 0);
      if (localResolveInfo == null) {
        paramIntent = null;
      } else if (!paramNativeAppInfo.validateSignature(paramContext, localResolveInfo.serviceInfo.packageName)) {
        paramIntent = null;
      }
    }
  }
}



/* Location:           C:\Users\dreadiscool\Desktop\tools\classes-dex2jar.jar

 * Qualified Name:     com.facebook.internal.NativeProtocol

 * JD-Core Version:    0.7.0.1

 */