package com.parse;

import android.content.Context;
import android.content.pm.PackageInfo;
import android.content.pm.PackageManager;
import android.content.pm.PackageManager.NameNotFoundException;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Arrays;
import java.util.List;
import java.util.TimeZone;
import java.util.UUID;
import m;
import org.json.JSONObject;

@ParseClassName("_Installation")
public class ParseInstallation
  extends ParseObject
{
  private static final String APP_IDENTIFIER = "appIdentifier";
  private static final String APP_NAME = "appName";
  static final String APP_VERSION = "appVersion";
  private static final String DEVICE_TOKEN = "deviceToken";
  private static final String DEVICE_TOKEN_LAST_MODIFIED = "deviceTokenLastModified";
  private static final String DEVICE_TYPE = "deviceType";
  private static final String INSTALLATION_ID = "installationId";
  static final String INSTALLATION_ID_LOCATION = "installationId";
  static final String OS_VERSION = "osVersion";
  private static final String PARSE_VERSION = "parseVersion";
  private static final String PIN_CURRENT_INSTALLATION = "_currentInstallation";
  private static final String PUSH_TYPE = "pushType";
  private static final String STORAGE_LOCATION = "currentInstallation";
  private static final String TAG = "com.parse.ParseInstallation";
  private static final String TIMEZONE = "timeZone";
  static ParseInstallation currentInstallation;
  static String installationId;
  private static final Object installationLock = new Object();
  private static final List<String> readonlyFields;
  
  static
  {
    currentInstallation = null;
    installationId = null;
    String[] arrayOfString = new String[10];
    arrayOfString[0] = "deviceType";
    arrayOfString[1] = "installationId";
    arrayOfString[2] = "deviceToken";
    arrayOfString[3] = "pushType";
    arrayOfString[4] = "timeZone";
    arrayOfString[5] = "appVersion";
    arrayOfString[6] = "appName";
    arrayOfString[7] = "parseVersion";
    arrayOfString[8] = "deviceTokenLastModified";
    arrayOfString[9] = "appIdentifier";
    readonlyFields = Arrays.asList(arrayOfString);
  }
  
  static void clearCurrentInstallationFromDisk(Context paramContext)
  {
    synchronized (installationLock)
    {
      currentInstallation = null;
      installationId = null;
      if (OfflineStore.isEnabled()) {
        ParseObject.unpinAllInBackground("_currentInstallation");
      }
      Parse.deleteDiskObject(paramContext, "currentInstallation");
      Parse.deleteDiskObject(paramContext, "installationId");
      return;
    }
  }
  
  static void clearCurrentInstallationFromMemory()
  {
    synchronized (installationLock)
    {
      currentInstallation = null;
      return;
    }
  }
  
  public static ParseInstallation getCurrentInstallation()
  {
    int i = 0;
    for (;;)
    {
      synchronized (installationLock)
      {
        if (currentInstallation == null)
        {
          boolean bool = OfflineStore.isEnabled();
          ParseObject localParseObject;
          if (bool)
          {
            try
            {
              localParseObject = (ParseObject)Parse.waitForTask(ParseQuery.getQuery(ParseInstallation.class).fromPin("_currentInstallation").findInBackground((ParseUser)null).d(new ParseInstallation.1()));
              if (localParseObject != null) {
                continue;
              }
              currentInstallation = (ParseInstallation)ParseObject.create(ParseInstallation.class);
              currentInstallation.updateDeviceInfo();
              j = 0;
              if (j != 0) {
                currentInstallation.maybeUpdateInstallationIdOnDisk();
              }
              return currentInstallation;
            }
            catch (ParseException localParseException)
            {
              localParseObject = null;
              continue;
            }
          }
          else
          {
            localParseObject = getFromDisk(Parse.applicationContext, "currentInstallation");
            continue;
          }
          i = 1;
          currentInstallation = (ParseInstallation)localParseObject;
          Parse.logV("com.parse.ParseInstallation", "Successfully deserialized Installation object");
        }
      }
      int j = i;
    }
  }
  
  static String getOrCreateCurrentInstallationId()
  {
    synchronized (installationLock)
    {
      String str = installationId;
      if (str != null) {}
    }
    try
    {
      installationId = new String(ParseFileUtils.readFileToByteArray(new File(Parse.getParseDir(), "installationId")));
      if (installationId == null)
      {
        installationId = UUID.randomUUID().toString();
        setCurrentInstallationId(installationId);
      }
      return installationId;
    }
    catch (FileNotFoundException localFileNotFoundException)
    {
      for (;;)
      {
        Parse.logI("com.parse.ParseInstallation", "Couldn't find existing installationId file. Creating one instead.");
      }
      localObject2 = finally;
      throw localObject2;
    }
    catch (IOException localIOException)
    {
      for (;;)
      {
        Parse.logE("com.parse.ParseInstallation", "Unexpected exception reading installation id from disk", localIOException);
      }
    }
  }
  
  public static ParseQuery<ParseInstallation> getQuery()
  {
    return ParseQuery.getQuery(ParseInstallation.class);
  }
  
  static boolean hasCurrentInstallation()
  {
    for (;;)
    {
      synchronized (installationLock)
      {
        if (currentInstallation == null)
        {
          if (!new File(Parse.getParseDir(), "currentInstallation").exists()) {
            break label47;
          }
          break label42;
          return bool;
        }
      }
      label42:
      boolean bool = true;
      continue;
      label47:
      bool = false;
    }
  }
  
  private static m<Void> maybeFlushToDiskAsync(ParseInstallation paramParseInstallation)
  {
    m localm2;
    synchronized (installationLock)
    {
      int i;
      if (paramParseInstallation == currentInstallation)
      {
        i = 1;
        if (i == 0)
        {
          localm2 = m.a(null);
          return localm2;
        }
      }
      else
      {
        i = 0;
      }
    }
    if (OfflineStore.isEnabled()) {}
    for (m localm1 = ParseObject.unpinAllInBackground("_currentInstallation").b(new ParseInstallation.7(paramParseInstallation));; localm1 = m.a(null).b(new ParseInstallation.8(paramParseInstallation)))
    {
      localm2 = localm1.b(new ParseInstallation.9(paramParseInstallation));
      break;
    }
  }
  
  private void maybeUpdateInstallationIdOnDisk()
  {
    String str1 = getInstallationId();
    String str2 = getOrCreateCurrentInstallationId();
    if ((str1 == null) || (str1.length() == 0)) {}
    for (int i = 1;; i = 0)
    {
      if ((i == 0) && (!str1.equals(str2)))
      {
        Parse.logW("com.parse.ParseInstallation", "Will update installation id on disk: " + str2 + " because it does not match installation id in ParseInstallation: " + str1);
        setCurrentInstallationId(str1);
      }
      return;
    }
  }
  
  static void setCurrentInstallationId(String paramString)
  {
    synchronized (installationLock)
    {
      File localFile = new File(Parse.getParseDir(), "installationId");
      try
      {
        ParseFileUtils.writeByteArrayToFile(localFile, paramString.getBytes());
        installationId = paramString;
        return;
      }
      catch (IOException localIOException)
      {
        for (;;)
        {
          Parse.logE("com.parse.ParseInstallation", "Unexpected exception writing installation id to disk", localIOException);
        }
      }
    }
  }
  
  private void updateDeviceInfo()
  {
    if (!has("installationId")) {
      super.put("installationId", getOrCreateCurrentInstallationId());
    }
    if (!"android".equals(get("deviceType"))) {
      super.put("deviceType", "android");
    }
  }
  
  private void updateTimezone()
  {
    String str = TimeZone.getDefault().getID();
    if (((str.indexOf('/') > 0) || (str.equals("GMT"))) && (!str.equals(get("timeZone")))) {
      super.put("timeZone", str);
    }
  }
  
  private void updateVersionInfo()
  {
    synchronized (this.mutex)
    {
      try
      {
        String str1 = Parse.applicationContext.getPackageName();
        PackageManager localPackageManager = Parse.applicationContext.getPackageManager();
        String str2 = localPackageManager.getPackageInfo(str1, 0).versionName;
        String str3 = localPackageManager.getApplicationLabel(localPackageManager.getApplicationInfo(str1, 0)).toString();
        if ((str1 != null) && (!str1.equals(get("appIdentifier")))) {
          super.put("appIdentifier", str1);
        }
        if ((str3 != null) && (!str3.equals(get("appName")))) {
          super.put("appName", str3);
        }
        if ((str2 != null) && (!str2.equals(get("appVersion")))) {
          super.put("appVersion", str2);
        }
        if (!"1.7.1".equals(get("parseVersion"))) {
          super.put("parseVersion", "1.7.1");
        }
        return;
      }
      catch (PackageManager.NameNotFoundException localNameNotFoundException)
      {
        for (;;)
        {
          Parse.logW("com.parse.ParseInstallation", "Cannot load package info; will not be saved to installation");
        }
      }
    }
  }
  
  /* Error */
  void checkKeyIsMutable(String paramString)
  {
    // Byte code:
    //   0: aload_0
    //   1: getfield 314	com/parse/ParseInstallation:mutex	Ljava/lang/Object;
    //   4: astore_2
    //   5: aload_2
    //   6: monitorenter
    //   7: getstatic 80	com/parse/ParseInstallation:readonlyFields	Ljava/util/List;
    //   10: aload_1
    //   11: invokeinterface 355 2 0
    //   16: ifeq +42 -> 58
    //   19: new 357	java/lang/IllegalArgumentException
    //   22: dup
    //   23: new 255	java/lang/StringBuilder
    //   26: dup
    //   27: invokespecial 256	java/lang/StringBuilder:<init>	()V
    //   30: ldc_w 359
    //   33: invokevirtual 262	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   36: aload_1
    //   37: invokevirtual 262	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   40: ldc_w 361
    //   43: invokevirtual 262	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   46: invokevirtual 265	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   49: invokespecial 363	java/lang/IllegalArgumentException:<init>	(Ljava/lang/String;)V
    //   52: athrow
    //   53: astore_3
    //   54: aload_2
    //   55: monitorexit
    //   56: aload_3
    //   57: athrow
    //   58: aload_2
    //   59: monitorexit
    //   60: return
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	61	0	this	ParseInstallation
    //   0	61	1	paramString	String
    //   4	55	2	localObject1	Object
    //   53	4	3	localObject2	Object
    // Exception table:
    //   from	to	target	type
    //   7	56	53	finally
    //   58	60	53	finally
  }
  
  <T extends ParseObject> m<T> fetchAsync(m<Void> paramm)
  {
    synchronized (this.mutex)
    {
      if (getObjectId() == null)
      {
        localm1 = saveAsync(paramm);
        m localm2 = localm1.d(new ParseInstallation.2(this, paramm));
        return localm2;
      }
      m localm1 = m.a(null);
    }
  }
  
  String getDeviceToken()
  {
    return super.getString("deviceToken");
  }
  
  public String getInstallationId()
  {
    return getString("installationId");
  }
  
  PushType getPushType()
  {
    return PushType.fromString(super.getString("pushType"));
  }
  
  m<Void> handleFetchResultAsync(JSONObject paramJSONObject)
  {
    return super.handleFetchResultAsync(paramJSONObject).d(new ParseInstallation.6(this));
  }
  
  m<Void> handleSaveResultAsync(JSONObject paramJSONObject, ParseOperationSet paramParseOperationSet)
  {
    m localm = super.handleSaveResultAsync(paramJSONObject, paramParseOperationSet);
    if (ManifestInfo.getPushUsesBroadcastReceivers()) {
      localm = localm.d(new ParseInstallation.4(this)).c(new ParseInstallation.3(this));
    }
    return localm.d(new ParseInstallation.5(this));
  }
  
  boolean isDeviceTokenStale()
  {
    if (super.getLong("deviceTokenLastModified") != ManifestInfo.getLastModified()) {}
    for (boolean bool = true;; bool = false) {
      return bool;
    }
  }
  
  boolean needsDefaultACL()
  {
    return false;
  }
  
  public void put(String paramString, Object paramObject)
  {
    synchronized (this.mutex)
    {
      checkKeyIsMutable(paramString);
      super.put(paramString, paramObject);
      return;
    }
  }
  
  public void remove(String paramString)
  {
    synchronized (this.mutex)
    {
      checkKeyIsMutable(paramString);
      super.remove(paramString);
      return;
    }
  }
  
  void removeDeviceToken()
  {
    super.remove("deviceToken");
    super.remove("deviceTokenLastModified");
  }
  
  void removePushType()
  {
    super.remove("pushType");
  }
  
  void setDefaultValues()
  {
    super.setDefaultValues();
    super.put("deviceType", "android");
    super.put("installationId", getOrCreateCurrentInstallationId());
  }
  
  void setDeviceToken(String paramString)
  {
    if ((paramString != null) && (paramString.length() > 0))
    {
      super.put("deviceToken", paramString);
      super.put("deviceTokenLastModified", Long.valueOf(ManifestInfo.getLastModified()));
    }
  }
  
  void setDeviceTokenLastModified(long paramLong)
  {
    super.put("deviceTokenLastModified", Long.valueOf(paramLong));
  }
  
  void setPushType(PushType paramPushType)
  {
    if (paramPushType != null) {
      super.put("pushType", paramPushType.toString());
    }
  }
  
  void updateBeforeSave()
  {
    super.updateBeforeSave();
    updateTimezone();
    updateVersionInfo();
    updateDeviceInfo();
  }
}


/* Location:           C:\Users\dreadiscool\Desktop\tools\classes-dex2jar.jar
 * Qualified Name:     com.parse.ParseInstallation
 * JD-Core Version:    0.7.0.1
 */