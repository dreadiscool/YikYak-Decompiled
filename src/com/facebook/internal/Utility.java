package com.facebook.internal;

import android.content.Context;
import android.content.SharedPreferences;
import android.content.pm.PackageInfo;
import android.content.pm.PackageManager;
import android.content.pm.PackageManager.NameNotFoundException;
import android.net.Uri;
import android.net.Uri.Builder;
import android.os.AsyncTask;
import android.os.Bundle;
import android.os.Parcelable;
import android.text.TextUtils;
import android.webkit.CookieManager;
import android.webkit.CookieSyncManager;
import com.facebook.FacebookException;
import com.facebook.Request;
import com.facebook.Response;
import com.facebook.Settings;
import com.facebook.model.GraphObject;
import java.io.Closeable;
import java.io.File;
import java.io.IOException;
import java.io.UnsupportedEncodingException;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.net.HttpURLConnection;
import java.net.URLConnection;
import java.net.URLDecoder;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collection;
import java.util.Collections;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.concurrent.ConcurrentHashMap;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;
import org.json.JSONTokener;

public final class Utility
{
  private static final String APPLICATION_FIELDS = "fields";
  private static final String APP_SETTINGS_PREFS_KEY_FORMAT = "com.facebook.internal.APP_SETTINGS.%s";
  private static final String APP_SETTINGS_PREFS_STORE = "com.facebook.internal.preferences.APP_SETTINGS";
  private static final String APP_SETTING_DIALOG_CONFIGS = "android_dialog_configs";
  private static final String[] APP_SETTING_FIELDS;
  private static final String APP_SETTING_NUX_CONTENT = "gdpv4_nux_content";
  private static final String APP_SETTING_NUX_ENABLED = "gdpv4_nux_enabled";
  private static final String APP_SETTING_SUPPORTS_IMPLICIT_SDK_LOGGING = "supports_implicit_sdk_logging";
  public static final int DEFAULT_STREAM_BUFFER_SIZE = 8192;
  private static final String DIALOG_CONFIG_DIALOG_NAME_FEATURE_NAME_SEPARATOR = "\\|";
  private static final String DIALOG_CONFIG_NAME_KEY = "name";
  private static final String DIALOG_CONFIG_URL_KEY = "url";
  private static final String DIALOG_CONFIG_VERSIONS_KEY = "versions";
  private static final String EXTRA_APP_EVENTS_INFO_FORMAT_VERSION = "a1";
  private static final String HASH_ALGORITHM_MD5 = "MD5";
  private static final String HASH_ALGORITHM_SHA1 = "SHA-1";
  static final String LOG_TAG = "FacebookSDK";
  private static final String URL_SCHEME = "https";
  private static final String UTF8 = "UTF-8";
  private static Map<String, Utility.FetchedAppSettings> fetchedAppSettings = new ConcurrentHashMap();
  private static AsyncTask<Void, Void, GraphObject> initialAppSettingsLoadTask;
  
  static
  {
    String[] arrayOfString = new String[4];
    arrayOfString[0] = "supports_implicit_sdk_logging";
    arrayOfString[1] = "gdpv4_nux_content";
    arrayOfString[2] = "gdpv4_nux_enabled";
    arrayOfString[3] = "android_dialog_configs";
    APP_SETTING_FIELDS = arrayOfString;
  }
  
  public static <T> boolean areObjectsEqual(T paramT1, T paramT2)
  {
    boolean bool;
    if (paramT1 == null) {
      if (paramT2 == null) {
        bool = true;
      }
    }
    for (;;)
    {
      return bool;
      bool = false;
      continue;
      bool = paramT1.equals(paramT2);
    }
  }
  
  public static <T> ArrayList<T> arrayList(T... paramVarArgs)
  {
    ArrayList localArrayList = new ArrayList(paramVarArgs.length);
    int i = paramVarArgs.length;
    for (int j = 0; j < i; j++) {
      localArrayList.add(paramVarArgs[j]);
    }
    return localArrayList;
  }
  
  public static <T> List<T> asListNoNulls(T... paramVarArgs)
  {
    ArrayList localArrayList = new ArrayList();
    int i = paramVarArgs.length;
    for (int j = 0; j < i; j++)
    {
      T ? = paramVarArgs[j];
      if (? != null) {
        localArrayList.add(?);
      }
    }
    return localArrayList;
  }
  
  public static Uri buildUri(String paramString1, String paramString2, Bundle paramBundle)
  {
    Uri.Builder localBuilder = new Uri.Builder();
    localBuilder.scheme("https");
    localBuilder.authority(paramString1);
    localBuilder.path(paramString2);
    Iterator localIterator = paramBundle.keySet().iterator();
    while (localIterator.hasNext())
    {
      String str = (String)localIterator.next();
      Object localObject = paramBundle.get(str);
      if ((localObject instanceof String)) {
        localBuilder.appendQueryParameter(str, (String)localObject);
      }
    }
    return localBuilder.build();
  }
  
  public static void clearCaches(Context paramContext)
  {
    ImageDownloader.clearCache(paramContext);
  }
  
  private static void clearCookiesForDomain(Context paramContext, String paramString)
  {
    CookieSyncManager.createInstance(paramContext).sync();
    CookieManager localCookieManager = CookieManager.getInstance();
    String str = localCookieManager.getCookie(paramString);
    if (str == null) {}
    for (;;)
    {
      return;
      String[] arrayOfString1 = str.split(";");
      int i = arrayOfString1.length;
      for (int j = 0; j < i; j++)
      {
        String[] arrayOfString2 = arrayOfString1[j].split("=");
        if (arrayOfString2.length > 0) {
          localCookieManager.setCookie(paramString, arrayOfString2[0].trim() + "=;expires=Sat, 1 Jan 2000 00:00:01 UTC;");
        }
      }
      localCookieManager.removeExpiredCookie();
    }
  }
  
  public static void clearFacebookCookies(Context paramContext)
  {
    clearCookiesForDomain(paramContext, "facebook.com");
    clearCookiesForDomain(paramContext, ".facebook.com");
    clearCookiesForDomain(paramContext, "https://facebook.com");
    clearCookiesForDomain(paramContext, "https://.facebook.com");
  }
  
  public static void closeQuietly(Closeable paramCloseable)
  {
    if (paramCloseable != null) {}
    try
    {
      paramCloseable.close();
      label10:
      return;
    }
    catch (IOException localIOException)
    {
      break label10;
    }
  }
  
  public static String coerceValueIfNullOrEmpty(String paramString1, String paramString2)
  {
    if (isNullOrEmpty(paramString1)) {}
    for (;;)
    {
      return paramString2;
      paramString2 = paramString1;
    }
  }
  
  static Map<String, Object> convertJSONObjectToHashMap(JSONObject paramJSONObject)
  {
    HashMap localHashMap = new HashMap();
    JSONArray localJSONArray = paramJSONObject.names();
    int i = 0;
    for (;;)
    {
      if (i < localJSONArray.length()) {}
      try
      {
        String str = localJSONArray.getString(i);
        Object localObject = paramJSONObject.get(str);
        if ((localObject instanceof JSONObject)) {
          localObject = convertJSONObjectToHashMap((JSONObject)localObject);
        }
        localHashMap.put(str, localObject);
        label65:
        i++;
        continue;
        return localHashMap;
      }
      catch (JSONException localJSONException)
      {
        break label65;
      }
    }
  }
  
  public static void deleteDirectory(File paramFile)
  {
    if (!paramFile.exists()) {}
    for (;;)
    {
      return;
      if (paramFile.isDirectory())
      {
        File[] arrayOfFile = paramFile.listFiles();
        int i = arrayOfFile.length;
        for (int j = 0; j < i; j++) {
          deleteDirectory(arrayOfFile[j]);
        }
      }
      paramFile.delete();
    }
  }
  
  public static void disconnectQuietly(URLConnection paramURLConnection)
  {
    if ((paramURLConnection instanceof HttpURLConnection)) {
      ((HttpURLConnection)paramURLConnection).disconnect();
    }
  }
  
  public static String getActivityName(Context paramContext)
  {
    String str;
    if (paramContext == null) {
      str = "null";
    }
    for (;;)
    {
      return str;
      if (paramContext == paramContext.getApplicationContext()) {
        str = "unknown";
      } else {
        str = paramContext.getClass().getSimpleName();
      }
    }
  }
  
  private static GraphObject getAppSettingsQueryResponse(String paramString)
  {
    Bundle localBundle = new Bundle();
    localBundle.putString("fields", TextUtils.join(",", APP_SETTING_FIELDS));
    Request localRequest = Request.newGraphPathRequest(null, paramString, null);
    localRequest.setSkipClientToken(true);
    localRequest.setParameters(localBundle);
    return localRequest.executeAndWait().getGraphObject();
  }
  
  public static Utility.DialogFeatureConfig getDialogFeatureConfig(String paramString1, String paramString2, String paramString3)
  {
    Utility.DialogFeatureConfig localDialogFeatureConfig;
    if ((isNullOrEmpty(paramString2)) || (isNullOrEmpty(paramString3))) {
      localDialogFeatureConfig = null;
    }
    for (;;)
    {
      return localDialogFeatureConfig;
      Utility.FetchedAppSettings localFetchedAppSettings = (Utility.FetchedAppSettings)fetchedAppSettings.get(paramString1);
      if (localFetchedAppSettings != null)
      {
        Map localMap = (Map)localFetchedAppSettings.getDialogConfigurations().get(paramString2);
        if (localMap != null)
        {
          localDialogFeatureConfig = (Utility.DialogFeatureConfig)localMap.get(paramString3);
          continue;
        }
      }
      localDialogFeatureConfig = null;
    }
  }
  
  public static String getMetadataApplicationId(Context paramContext)
  {
    Validate.notNull(paramContext, "context");
    Settings.loadDefaultsFromMetadata(paramContext);
    return Settings.getApplicationId();
  }
  
  public static Method getMethodQuietly(Class<?> paramClass, String paramString, Class<?>... paramVarArgs)
  {
    try
    {
      Method localMethod2 = paramClass.getMethod(paramString, paramVarArgs);
      localMethod1 = localMethod2;
    }
    catch (NoSuchMethodException localNoSuchMethodException)
    {
      for (;;)
      {
        Method localMethod1 = null;
      }
    }
    return localMethod1;
  }
  
  public static Method getMethodQuietly(String paramString1, String paramString2, Class<?>... paramVarArgs)
  {
    try
    {
      Method localMethod2 = getMethodQuietly(Class.forName(paramString1), paramString2, paramVarArgs);
      localMethod1 = localMethod2;
    }
    catch (ClassNotFoundException localClassNotFoundException)
    {
      for (;;)
      {
        Method localMethod1 = null;
      }
    }
    return localMethod1;
  }
  
  public static Object getStringPropertyAsJSON(JSONObject paramJSONObject, String paramString1, String paramString2)
  {
    Object localObject1 = paramJSONObject.opt(paramString1);
    if ((localObject1 != null) && ((localObject1 instanceof String))) {}
    for (Object localObject2 = new JSONTokener((String)localObject1).nextValue();; localObject2 = localObject1)
    {
      Object localObject3;
      if ((localObject2 != null) && (!(localObject2 instanceof JSONObject)) && (!(localObject2 instanceof JSONArray))) {
        if (paramString2 != null)
        {
          localObject3 = new JSONObject();
          ((JSONObject)localObject3).putOpt(paramString2, localObject2);
        }
      }
      for (;;)
      {
        return localObject3;
        throw new FacebookException("Got an unexpected non-JSON object.");
        localObject3 = localObject2;
      }
    }
  }
  
  private static String hashBytes(MessageDigest paramMessageDigest, byte[] paramArrayOfByte)
  {
    paramMessageDigest.update(paramArrayOfByte);
    byte[] arrayOfByte = paramMessageDigest.digest();
    StringBuilder localStringBuilder = new StringBuilder();
    int i = arrayOfByte.length;
    for (int j = 0; j < i; j++)
    {
      int k = arrayOfByte[j];
      localStringBuilder.append(Integer.toHexString(0xF & k >> 4));
      localStringBuilder.append(Integer.toHexString(0xF & k >> 0));
    }
    return localStringBuilder.toString();
  }
  
  private static String hashWithAlgorithm(String paramString1, String paramString2)
  {
    return hashWithAlgorithm(paramString1, paramString2.getBytes());
  }
  
  private static String hashWithAlgorithm(String paramString, byte[] paramArrayOfByte)
  {
    try
    {
      MessageDigest localMessageDigest = MessageDigest.getInstance(paramString);
      str = hashBytes(localMessageDigest, paramArrayOfByte);
    }
    catch (NoSuchAlgorithmException localNoSuchAlgorithmException)
    {
      for (;;)
      {
        String str = null;
      }
    }
    return str;
  }
  
  public static int[] intersectRanges(int[] paramArrayOfInt1, int[] paramArrayOfInt2)
  {
    int i = 0;
    if (paramArrayOfInt1 == null) {}
    for (;;)
    {
      return paramArrayOfInt2;
      if (paramArrayOfInt2 != null) {
        break;
      }
      paramArrayOfInt2 = paramArrayOfInt1;
    }
    int[] arrayOfInt = new int[paramArrayOfInt1.length + paramArrayOfInt2.length];
    int j = 0;
    int k = 0;
    label31:
    int m;
    int n;
    if ((j < paramArrayOfInt1.length) && (i < paramArrayOfInt2.length))
    {
      m = paramArrayOfInt1[j];
      n = paramArrayOfInt2[i];
      if (j >= -1 + paramArrayOfInt1.length) {
        break label258;
      }
    }
    label258:
    for (int i1 = paramArrayOfInt1[(j + 1)];; i1 = 2147483647)
    {
      if (i < -1 + paramArrayOfInt2.length) {}
      for (int i2 = paramArrayOfInt2[(i + 1)];; i2 = 2147483647)
      {
        if (m < n) {
          if (i1 > n) {
            if (i1 > i2) {
              i += 2;
            }
          }
        }
        int i3;
        for (;;)
        {
          if (n == -2147483648) {
            break label234;
          }
          i3 = k + 1;
          arrayOfInt[k] = n;
          if (i2 == 2147483647) {
            break label236;
          }
          k = i3 + 1;
          arrayOfInt[i3] = i2;
          break;
          j += 2;
          i2 = i1;
          continue;
          j += 2;
          i2 = 2147483647;
          n = -2147483648;
          continue;
          if (i2 > m)
          {
            if (i2 > i1)
            {
              j += 2;
              i2 = i1;
              n = m;
            }
            else
            {
              i += 2;
              n = m;
            }
          }
          else
          {
            i += 2;
            i2 = 2147483647;
            n = -2147483648;
          }
        }
        label234:
        break label31;
        label236:
        k = i3;
        paramArrayOfInt2 = Arrays.copyOf(arrayOfInt, k);
        break;
      }
    }
  }
  
  public static Object invokeMethodQuietly(Object paramObject, Method paramMethod, Object... paramVarArgs)
  {
    Object localObject1 = null;
    try
    {
      Object localObject2 = paramMethod.invoke(paramObject, paramVarArgs);
      localObject1 = localObject2;
    }
    catch (IllegalAccessException localIllegalAccessException)
    {
      break label13;
    }
    catch (InvocationTargetException localInvocationTargetException)
    {
      label13:
      break label13;
    }
    return localObject1;
  }
  
  public static boolean isNullOrEmpty(String paramString)
  {
    if ((paramString == null) || (paramString.length() == 0)) {}
    for (boolean bool = true;; bool = false) {
      return bool;
    }
  }
  
  public static <T> boolean isNullOrEmpty(Collection<T> paramCollection)
  {
    if ((paramCollection == null) || (paramCollection.size() == 0)) {}
    for (boolean bool = true;; bool = false) {
      return bool;
    }
  }
  
  public static <T> boolean isSubset(Collection<T> paramCollection1, Collection<T> paramCollection2)
  {
    boolean bool = false;
    if ((paramCollection2 == null) || (paramCollection2.size() == 0)) {
      if ((paramCollection1 == null) || (paramCollection1.size() == 0)) {
        bool = true;
      }
    }
    for (;;)
    {
      return bool;
      HashSet localHashSet = new HashSet(paramCollection2);
      Iterator localIterator = paramCollection1.iterator();
      for (;;)
      {
        if (localIterator.hasNext()) {
          if (!localHashSet.contains(localIterator.next())) {
            break;
          }
        }
      }
      bool = true;
    }
  }
  
  public static void loadAppSettingsAsync(Context paramContext, String paramString)
  {
    Object localObject = null;
    if ((isNullOrEmpty(paramString)) || (fetchedAppSettings.containsKey(paramString)) || (initialAppSettingsLoadTask != null)) {}
    for (;;)
    {
      return;
      Object[] arrayOfObject = new Object[1];
      arrayOfObject[0] = paramString;
      String str1 = String.format("com.facebook.internal.APP_SETTINGS.%s", arrayOfObject);
      initialAppSettingsLoadTask = new Utility.1(paramString, paramContext, str1);
      initialAppSettingsLoadTask.execute((Void[])null);
      String str2 = paramContext.getSharedPreferences("com.facebook.internal.preferences.APP_SETTINGS", 0).getString(str1, null);
      if (!isNullOrEmpty(str2)) {}
      try
      {
        JSONObject localJSONObject = new JSONObject(str2);
        localObject = localJSONObject;
      }
      catch (JSONException localJSONException)
      {
        for (;;)
        {
          logd("FacebookSDK", localJSONException);
        }
      }
      if (localObject != null) {
        parseAppSettingsFromJSON(paramString, localObject);
      }
    }
  }
  
  public static void logd(String paramString, Exception paramException)
  {
    if ((Settings.isDebugEnabled()) && (paramString != null) && (paramException != null)) {
      new StringBuilder().append(paramException.getClass().getSimpleName()).append(": ").append(paramException.getMessage()).toString();
    }
  }
  
  public static void logd(String paramString1, String paramString2)
  {
    Settings.isDebugEnabled();
  }
  
  public static void logd(String paramString1, String paramString2, Throwable paramThrowable)
  {
    if (Settings.isDebugEnabled()) {
      isNullOrEmpty(paramString1);
    }
  }
  
  static String md5hash(String paramString)
  {
    return hashWithAlgorithm("MD5", paramString);
  }
  
  private static Utility.FetchedAppSettings parseAppSettingsFromJSON(String paramString, JSONObject paramJSONObject)
  {
    Utility.FetchedAppSettings localFetchedAppSettings = new Utility.FetchedAppSettings(paramJSONObject.optBoolean("supports_implicit_sdk_logging", false), paramJSONObject.optString("gdpv4_nux_content", ""), paramJSONObject.optBoolean("gdpv4_nux_enabled", false), parseDialogConfigurations(paramJSONObject.optJSONObject("android_dialog_configs")), null);
    fetchedAppSettings.put(paramString, localFetchedAppSettings);
    return localFetchedAppSettings;
  }
  
  private static Map<String, Map<String, Utility.DialogFeatureConfig>> parseDialogConfigurations(JSONObject paramJSONObject)
  {
    HashMap localHashMap = new HashMap();
    if (paramJSONObject != null)
    {
      JSONArray localJSONArray = paramJSONObject.optJSONArray("data");
      if (localJSONArray != null)
      {
        int i = 0;
        if (i < localJSONArray.length())
        {
          Utility.DialogFeatureConfig localDialogFeatureConfig = Utility.DialogFeatureConfig.access$400(localJSONArray.optJSONObject(i));
          if (localDialogFeatureConfig == null) {}
          for (;;)
          {
            i++;
            break;
            String str = localDialogFeatureConfig.getDialogName();
            Object localObject = (Map)localHashMap.get(str);
            if (localObject == null)
            {
              localObject = new HashMap();
              localHashMap.put(str, localObject);
            }
            ((Map)localObject).put(localDialogFeatureConfig.getFeatureName(), localDialogFeatureConfig);
          }
        }
      }
    }
    return localHashMap;
  }
  
  public static Bundle parseUrlQueryString(String paramString)
  {
    Bundle localBundle = new Bundle();
    String[] arrayOfString1;
    int i;
    if (!isNullOrEmpty(paramString))
    {
      arrayOfString1 = paramString.split("&");
      i = arrayOfString1.length;
    }
    for (int j = 0;; j++) {
      if (j < i)
      {
        String[] arrayOfString2 = arrayOfString1[j].split("=");
        try
        {
          if (arrayOfString2.length == 2) {
            localBundle.putString(URLDecoder.decode(arrayOfString2[0], "UTF-8"), URLDecoder.decode(arrayOfString2[1], "UTF-8"));
          } else if (arrayOfString2.length == 1) {
            localBundle.putString(URLDecoder.decode(arrayOfString2[0], "UTF-8"), "");
          }
        }
        catch (UnsupportedEncodingException localUnsupportedEncodingException)
        {
          logd("FacebookSDK", localUnsupportedEncodingException);
        }
      }
      else
      {
        return localBundle;
      }
    }
  }
  
  public static void putObjectInBundle(Bundle paramBundle, String paramString, Object paramObject)
  {
    if ((paramObject instanceof String)) {
      paramBundle.putString(paramString, (String)paramObject);
    }
    for (;;)
    {
      return;
      if ((paramObject instanceof Parcelable))
      {
        paramBundle.putParcelable(paramString, (Parcelable)paramObject);
      }
      else
      {
        if (!(paramObject instanceof byte[])) {
          break;
        }
        paramBundle.putByteArray(paramString, (byte[])paramObject);
      }
    }
    throw new FacebookException("attempted to add unsupported type to Bundle");
  }
  
  public static Utility.FetchedAppSettings queryAppSettings(String paramString, boolean paramBoolean)
  {
    Utility.FetchedAppSettings localFetchedAppSettings;
    if ((!paramBoolean) && (fetchedAppSettings.containsKey(paramString))) {
      localFetchedAppSettings = (Utility.FetchedAppSettings)fetchedAppSettings.get(paramString);
    }
    for (;;)
    {
      return localFetchedAppSettings;
      GraphObject localGraphObject = getAppSettingsQueryResponse(paramString);
      if (localGraphObject == null) {
        localFetchedAppSettings = null;
      } else {
        localFetchedAppSettings = parseAppSettingsFromJSON(paramString, localGraphObject.getInnerJSONObject());
      }
    }
  }
  
  /* Error */
  public static String readStreamToString(java.io.InputStream paramInputStream)
  {
    // Byte code:
    //   0: aconst_null
    //   1: astore_1
    //   2: new 631	java/io/BufferedInputStream
    //   5: dup
    //   6: aload_0
    //   7: invokespecial 634	java/io/BufferedInputStream:<init>	(Ljava/io/InputStream;)V
    //   10: astore_2
    //   11: new 636	java/io/InputStreamReader
    //   14: dup
    //   15: aload_2
    //   16: invokespecial 637	java/io/InputStreamReader:<init>	(Ljava/io/InputStream;)V
    //   19: astore_3
    //   20: new 201	java/lang/StringBuilder
    //   23: dup
    //   24: invokespecial 202	java/lang/StringBuilder:<init>	()V
    //   27: astore 4
    //   29: sipush 2048
    //   32: newarray char
    //   34: astore 6
    //   36: aload_3
    //   37: aload 6
    //   39: invokevirtual 641	java/io/InputStreamReader:read	([C)I
    //   42: istore 7
    //   44: iload 7
    //   46: bipush 255
    //   48: if_icmpeq +32 -> 80
    //   51: aload 4
    //   53: aload 6
    //   55: iconst_0
    //   56: iload 7
    //   58: invokevirtual 644	java/lang/StringBuilder:append	([CII)Ljava/lang/StringBuilder;
    //   61: pop
    //   62: goto -26 -> 36
    //   65: astore 5
    //   67: aload_2
    //   68: astore_1
    //   69: aload_1
    //   70: invokestatic 646	com/facebook/internal/Utility:closeQuietly	(Ljava/io/Closeable;)V
    //   73: aload_3
    //   74: invokestatic 646	com/facebook/internal/Utility:closeQuietly	(Ljava/io/Closeable;)V
    //   77: aload 5
    //   79: athrow
    //   80: aload 4
    //   82: invokevirtual 215	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   85: astore 8
    //   87: aload_2
    //   88: invokestatic 646	com/facebook/internal/Utility:closeQuietly	(Ljava/io/Closeable;)V
    //   91: aload_3
    //   92: invokestatic 646	com/facebook/internal/Utility:closeQuietly	(Ljava/io/Closeable;)V
    //   95: aload 8
    //   97: areturn
    //   98: astore 5
    //   100: aconst_null
    //   101: astore_3
    //   102: goto -33 -> 69
    //   105: astore 5
    //   107: aconst_null
    //   108: astore_3
    //   109: aload_2
    //   110: astore_1
    //   111: goto -42 -> 69
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	114	0	paramInputStream	java.io.InputStream
    //   1	110	1	localObject1	Object
    //   10	100	2	localBufferedInputStream	java.io.BufferedInputStream
    //   19	90	3	localInputStreamReader	java.io.InputStreamReader
    //   27	54	4	localStringBuilder	StringBuilder
    //   65	13	5	localObject2	Object
    //   98	1	5	localObject3	Object
    //   105	1	5	localObject4	Object
    //   34	20	6	arrayOfChar	char[]
    //   42	15	7	i	int
    //   85	11	8	str	String
    // Exception table:
    //   from	to	target	type
    //   20	62	65	finally
    //   80	87	65	finally
    //   2	11	98	finally
    //   11	20	105	finally
  }
  
  public static boolean safeGetBooleanFromResponse(GraphObject paramGraphObject, String paramString)
  {
    Object localObject = Boolean.valueOf(false);
    if (paramGraphObject != null) {
      localObject = paramGraphObject.getProperty(paramString);
    }
    if (!(localObject instanceof Boolean)) {
      localObject = Boolean.valueOf(false);
    }
    return ((Boolean)localObject).booleanValue();
  }
  
  public static String safeGetStringFromResponse(GraphObject paramGraphObject, String paramString)
  {
    Object localObject = "";
    if (paramGraphObject != null) {
      localObject = paramGraphObject.getProperty(paramString);
    }
    if (!(localObject instanceof String)) {
      localObject = "";
    }
    return (String)localObject;
  }
  
  public static void setAppEventAttributionParameters(GraphObject paramGraphObject, AttributionIdentifiers paramAttributionIdentifiers, String paramString, boolean paramBoolean)
  {
    boolean bool1 = true;
    if ((paramAttributionIdentifiers != null) && (paramAttributionIdentifiers.getAttributionId() != null)) {
      paramGraphObject.setProperty("attribution", paramAttributionIdentifiers.getAttributionId());
    }
    boolean bool2;
    if ((paramAttributionIdentifiers != null) && (paramAttributionIdentifiers.getAndroidAdvertiserId() != null))
    {
      paramGraphObject.setProperty("advertiser_id", paramAttributionIdentifiers.getAndroidAdvertiserId());
      if (!paramAttributionIdentifiers.isTrackingLimited())
      {
        bool2 = bool1;
        paramGraphObject.setProperty("advertiser_tracking_enabled", Boolean.valueOf(bool2));
      }
    }
    else
    {
      paramGraphObject.setProperty("anon_id", paramString);
      if (paramBoolean) {
        break label111;
      }
    }
    for (;;)
    {
      paramGraphObject.setProperty("application_tracking_enabled", Boolean.valueOf(bool1));
      return;
      bool2 = false;
      break;
      label111:
      bool1 = false;
    }
  }
  
  public static void setAppEventExtendedDeviceInfoParameters(GraphObject paramGraphObject, Context paramContext)
  {
    JSONArray localJSONArray = new JSONArray();
    localJSONArray.put("a1");
    String str1 = paramContext.getPackageName();
    int i = -1;
    String str2 = "";
    try
    {
      PackageInfo localPackageInfo = paramContext.getPackageManager().getPackageInfo(str1, 0);
      i = localPackageInfo.versionCode;
      str2 = localPackageInfo.versionName;
      label56:
      localJSONArray.put(str1);
      localJSONArray.put(i);
      localJSONArray.put(str2);
      paramGraphObject.setProperty("extinfo", localJSONArray.toString());
      return;
    }
    catch (PackageManager.NameNotFoundException localNameNotFoundException)
    {
      break label56;
    }
  }
  
  static String sha1hash(String paramString)
  {
    return hashWithAlgorithm("SHA-1", paramString);
  }
  
  static String sha1hash(byte[] paramArrayOfByte)
  {
    return hashWithAlgorithm("SHA-1", paramArrayOfByte);
  }
  
  public static boolean stringsEqualOrEmpty(String paramString1, String paramString2)
  {
    boolean bool1 = TextUtils.isEmpty(paramString1);
    boolean bool2 = TextUtils.isEmpty(paramString2);
    boolean bool3;
    if ((bool1) && (bool2)) {
      bool3 = true;
    }
    for (;;)
    {
      return bool3;
      if ((!bool1) && (!bool2)) {
        bool3 = paramString1.equals(paramString2);
      } else {
        bool3 = false;
      }
    }
  }
  
  public static JSONArray tryGetJSONArrayFromResponse(GraphObject paramGraphObject, String paramString)
  {
    JSONArray localJSONArray;
    if (paramGraphObject == null) {
      localJSONArray = null;
    }
    for (;;)
    {
      return localJSONArray;
      Object localObject = paramGraphObject.getProperty(paramString);
      if (!(localObject instanceof JSONArray)) {
        localJSONArray = null;
      } else {
        localJSONArray = (JSONArray)localObject;
      }
    }
  }
  
  public static JSONObject tryGetJSONObjectFromResponse(GraphObject paramGraphObject, String paramString)
  {
    JSONObject localJSONObject;
    if (paramGraphObject == null) {
      localJSONObject = null;
    }
    for (;;)
    {
      return localJSONObject;
      Object localObject = paramGraphObject.getProperty(paramString);
      if (!(localObject instanceof JSONObject)) {
        localJSONObject = null;
      } else {
        localJSONObject = (JSONObject)localObject;
      }
    }
  }
  
  public static <T> Collection<T> unmodifiableCollection(T... paramVarArgs)
  {
    return Collections.unmodifiableCollection(Arrays.asList(paramVarArgs));
  }
}


/* Location:           C:\Users\dreadiscool\Desktop\tools\classes-dex2jar.jar
 * Qualified Name:     com.facebook.internal.Utility
 * JD-Core Version:    0.7.0.1
 */