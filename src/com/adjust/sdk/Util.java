package com.adjust.sdk;

import android.content.ContentResolver;
import android.content.Context;
import android.content.pm.ApplicationInfo;
import android.content.pm.PackageInfo;
import android.content.pm.PackageManager;
import android.content.pm.PackageManager.NameNotFoundException;
import android.content.res.Configuration;
import android.content.res.Resources;
import android.database.Cursor;
import android.net.Uri;
import android.os.Build;
import android.os.Build.VERSION;
import android.os.Bundle;
import android.text.TextUtils;
import android.util.DisplayMetrics;
import com.adjust.sdk.plugin.Plugin;
import java.math.BigInteger;
import java.security.MessageDigest;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Locale;
import java.util.Map;
import java.util.Map.Entry;
import java.util.UUID;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import org.json.JSONException;
import org.json.JSONObject;

public class Util
{
  private static final String DATE_FORMAT = "yyyy-MM-dd'T'HH:mm:ss'Z'Z";
  private static SimpleDateFormat dateFormat;
  
  public static JSONObject buildJsonObject(String paramString)
  {
    try
    {
      localJSONObject = new JSONObject(paramString);
      return localJSONObject;
    }
    catch (JSONException localJSONException)
    {
      for (;;)
      {
        JSONObject localJSONObject = null;
      }
    }
  }
  
  private static String convertToHex(byte[] paramArrayOfByte)
  {
    BigInteger localBigInteger = new BigInteger(1, paramArrayOfByte);
    String str = "%0" + (paramArrayOfByte.length << 1) + "x";
    Object[] arrayOfObject = new Object[1];
    arrayOfObject[0] = localBigInteger;
    return String.format(str, arrayOfObject);
  }
  
  protected static String createUuid()
  {
    return UUID.randomUUID().toString();
  }
  
  public static String dateFormat(long paramLong)
  {
    if (dateFormat == null) {
      dateFormat = new SimpleDateFormat("yyyy-MM-dd'T'HH:mm:ss'Z'Z", Locale.US);
    }
    return dateFormat.format(Long.valueOf(paramLong));
  }
  
  public static String getAndroidId(Context paramContext)
  {
    return Reflection.getAndroidId(paramContext);
  }
  
  private static String getAppVersion(Context paramContext)
  {
    try
    {
      String str2 = sanitizeString(paramContext.getPackageManager().getPackageInfo(paramContext.getPackageName(), 0).versionName);
      str1 = str2;
    }
    catch (PackageManager.NameNotFoundException localNameNotFoundException)
    {
      for (;;)
      {
        String str1 = "unknown";
      }
    }
    return str1;
  }
  
  public static Bundle getApplicationBundle(Context paramContext, Logger paramLogger)
  {
    try
    {
      String str = paramContext.getPackageName();
      localBundle = paramContext.getPackageManager().getApplicationInfo(str, 128).metaData;
      return localBundle;
    }
    catch (PackageManager.NameNotFoundException localNameNotFoundException)
    {
      for (;;)
      {
        paramLogger.error("ApplicationInfo not found", new Object[0]);
        Bundle localBundle = null;
      }
    }
    catch (Exception localException)
    {
      for (;;)
      {
        Object[] arrayOfObject = new Object[1];
        arrayOfObject[0] = localException;
        paramLogger.error("Failed to get ApplicationBundle (%s)", arrayOfObject);
      }
    }
  }
  
  protected static String getAttributionId(Context paramContext)
  {
    String str;
    try
    {
      ContentResolver localContentResolver = paramContext.getContentResolver();
      Uri localUri = Uri.parse("content://com.facebook.katana.provider.AttributionIdProvider");
      String[] arrayOfString = new String[1];
      arrayOfString[0] = "aid";
      Cursor localCursor = localContentResolver.query(localUri, arrayOfString, null, null, null);
      if (localCursor == null)
      {
        str = null;
      }
      else if (!localCursor.moveToFirst())
      {
        localCursor.close();
        str = null;
      }
      else
      {
        str = localCursor.getString(localCursor.getColumnIndex("aid"));
        localCursor.close();
      }
    }
    catch (Exception localException)
    {
      str = null;
    }
    return str;
  }
  
  private static String getCountry(Locale paramLocale)
  {
    return sanitizeStringShort(paramLocale.getCountry());
  }
  
  private static String getDeviceName()
  {
    return sanitizeString(Build.MODEL);
  }
  
  private static String getDeviceType(int paramInt)
  {
    String str;
    switch (paramInt & 0xF)
    {
    default: 
      str = "unknown";
    }
    for (;;)
    {
      return str;
      str = "phone";
      continue;
      str = "tablet";
    }
  }
  
  private static String getDisplayHeight(DisplayMetrics paramDisplayMetrics)
  {
    return sanitizeString(String.valueOf(paramDisplayMetrics.heightPixels));
  }
  
  private static String getDisplayWidth(DisplayMetrics paramDisplayMetrics)
  {
    return sanitizeString(String.valueOf(paramDisplayMetrics.widthPixels));
  }
  
  private static String getLanguage(Locale paramLocale)
  {
    return sanitizeStringShort(paramLocale.getLanguage());
  }
  
  public static String getMacAddress(Context paramContext)
  {
    return Reflection.getMacAddress(paramContext);
  }
  
  public static String getMacSha1(String paramString)
  {
    if (paramString == null) {}
    for (String str = null;; str = sha1(paramString)) {
      return str;
    }
  }
  
  public static String getMacShortMd5(String paramString)
  {
    if (paramString == null) {}
    for (String str = null;; str = md5(paramString.replaceAll(":", ""))) {
      return str;
    }
  }
  
  private static String getOsName()
  {
    return "android";
  }
  
  private static String getOsVersion()
  {
    return sanitizeString("" + Build.VERSION.SDK_INT);
  }
  
  private static String getPackageName(Context paramContext)
  {
    return sanitizeString(paramContext.getPackageName());
  }
  
  public static String getPlayAdId(Context paramContext)
  {
    return Reflection.getPlayAdId(paramContext);
  }
  
  public static Map<String, String> getPluginKeys(Context paramContext)
  {
    HashMap localHashMap = new HashMap();
    Iterator localIterator = getPlugins().iterator();
    while (localIterator.hasNext())
    {
      Map.Entry localEntry = ((Plugin)localIterator.next()).getParameter(paramContext);
      if (localEntry != null) {
        localHashMap.put(localEntry.getKey(), localEntry.getValue());
      }
    }
    if (localHashMap.size() == 0) {}
    for (Object localObject = null;; localObject = localHashMap) {
      return localObject;
    }
  }
  
  private static List<Plugin> getPlugins()
  {
    ArrayList localArrayList = new ArrayList(Constants.PLUGINS.size());
    Iterator localIterator = Constants.PLUGINS.iterator();
    while (localIterator.hasNext())
    {
      Object localObject = Reflection.createDefaultInstance((String)localIterator.next());
      if ((localObject != null) && ((localObject instanceof Plugin))) {
        localArrayList.add((Plugin)localObject);
      }
    }
    return localArrayList;
  }
  
  private static String getScreenDensity(DisplayMetrics paramDisplayMetrics)
  {
    int i = paramDisplayMetrics.densityDpi;
    String str;
    if (i == 0) {
      str = "unknown";
    }
    for (;;)
    {
      return str;
      if (i < 140) {
        str = "low";
      } else if (i > 200) {
        str = "high";
      } else {
        str = "medium";
      }
    }
  }
  
  private static String getScreenFormat(int paramInt)
  {
    String str;
    switch (paramInt & 0x30)
    {
    default: 
      str = "unknown";
    }
    for (;;)
    {
      return str;
      str = "long";
      continue;
      str = "normal";
    }
  }
  
  private static String getScreenSize(int paramInt)
  {
    String str;
    switch (paramInt & 0xF)
    {
    default: 
      str = "unknown";
    }
    for (;;)
    {
      return str;
      str = "small";
      continue;
      str = "normal";
      continue;
      str = "large";
      continue;
      str = "xlarge";
    }
  }
  
  protected static String getUserAgent(Context paramContext)
  {
    Resources localResources = paramContext.getResources();
    DisplayMetrics localDisplayMetrics = localResources.getDisplayMetrics();
    Configuration localConfiguration = localResources.getConfiguration();
    Locale localLocale = localConfiguration.locale;
    int i = localConfiguration.screenLayout;
    String[] arrayOfString = new String[13];
    arrayOfString[0] = getPackageName(paramContext);
    arrayOfString[1] = getAppVersion(paramContext);
    arrayOfString[2] = getDeviceType(i);
    arrayOfString[3] = getDeviceName();
    arrayOfString[4] = getOsName();
    arrayOfString[5] = getOsVersion();
    arrayOfString[6] = getLanguage(localLocale);
    arrayOfString[7] = getCountry(localLocale);
    arrayOfString[8] = getScreenSize(i);
    arrayOfString[9] = getScreenFormat(i);
    arrayOfString[10] = getScreenDensity(localDisplayMetrics);
    arrayOfString[11] = getDisplayWidth(localDisplayMetrics);
    arrayOfString[12] = getDisplayHeight(localDisplayMetrics);
    return TextUtils.join(" ", arrayOfString);
  }
  
  private static String hash(String paramString1, String paramString2)
  {
    Object localObject = null;
    try
    {
      byte[] arrayOfByte = paramString1.getBytes("UTF-8");
      MessageDigest localMessageDigest = MessageDigest.getInstance(paramString2);
      localMessageDigest.update(arrayOfByte, 0, arrayOfByte.length);
      String str = convertToHex(localMessageDigest.digest());
      localObject = str;
    }
    catch (Exception localException)
    {
      label41:
      break label41;
    }
    return localObject;
  }
  
  public static boolean isGooglePlayServicesAvailable(Context paramContext)
  {
    return Reflection.isGooglePlayServicesAvailable(paramContext);
  }
  
  public static Boolean isPlayTrackingEnabled(Context paramContext)
  {
    return Reflection.isPlayTrackingEnabled(paramContext);
  }
  
  private static String md5(String paramString)
  {
    return hash(paramString, "MD5");
  }
  
  public static String quote(String paramString)
  {
    if (paramString == null) {
      paramString = null;
    }
    for (;;)
    {
      return paramString;
      if (Pattern.compile("\\s").matcher(paramString).find())
      {
        Object[] arrayOfObject = new Object[1];
        arrayOfObject[0] = paramString;
        paramString = String.format("'%s'", arrayOfObject);
      }
    }
  }
  
  private static String sanitizeString(String paramString)
  {
    return sanitizeString(paramString, "unknown");
  }
  
  private static String sanitizeString(String paramString1, String paramString2)
  {
    if (TextUtils.isEmpty(paramString1)) {
      paramString1 = paramString2;
    }
    String str = paramString1.replaceAll("\\s", "");
    if (TextUtils.isEmpty(str)) {}
    for (;;)
    {
      return paramString2;
      paramString2 = str;
    }
  }
  
  private static String sanitizeStringShort(String paramString)
  {
    return sanitizeString(paramString, "zz");
  }
  
  public static String sha1(String paramString)
  {
    return hash(paramString, "SHA-1");
  }
}


/* Location:           C:\Users\dreadiscool\Desktop\tools\classes-dex2jar.jar
 * Qualified Name:     com.adjust.sdk.Util
 * JD-Core Version:    0.7.0.1
 */