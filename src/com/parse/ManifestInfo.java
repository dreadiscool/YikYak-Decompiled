package com.parse;

import android.app.Service;
import android.content.BroadcastReceiver;
import android.content.ComponentName;
import android.content.Context;
import android.content.Intent;
import android.content.pm.ActivityInfo;
import android.content.pm.ApplicationInfo;
import android.content.pm.PackageInfo;
import android.content.pm.PackageManager;
import android.content.pm.PackageManager.NameNotFoundException;
import android.content.pm.ResolveInfo;
import android.content.pm.ServiceInfo;
import android.os.Build.VERSION;
import android.os.Bundle;
import java.io.File;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

class ManifestInfo
{
  private static final Integer NUMBER_OF_PUSH_INTENTS = Integer.valueOf(3);
  private static final String TAG = "com.parse.ManifestInfo";
  private static String displayName = null;
  private static int iconId;
  private static long lastModified;
  private static Object lock = new Object();
  private static PushType pushType;
  private static Boolean pushUsesBroadcastReceivers = null;
  private static int versionCode;
  private static String versionName;
  
  static
  {
    lastModified = -1L;
    versionCode = -1;
    versionName = null;
    iconId = 0;
  }
  
  private static boolean checkReceiver(Class<? extends BroadcastReceiver> paramClass, String paramString, Intent[] paramArrayOfIntent)
  {
    boolean bool = false;
    ActivityInfo localActivityInfo = getReceiverInfo(paramClass);
    if (localActivityInfo == null) {}
    for (;;)
    {
      return bool;
      if ((paramString == null) || (paramString.equals(localActivityInfo.permission)))
      {
        int i = paramArrayOfIntent.length;
        for (int j = 0;; j++)
        {
          if (j >= i) {
            break label87;
          }
          Intent localIntent = paramArrayOfIntent[j];
          List localList = getPackageManager().queryBroadcastReceivers(localIntent, 0);
          if ((localList.isEmpty()) || (!checkResolveInfo(paramClass, localList))) {
            break;
          }
        }
        label87:
        bool = true;
      }
    }
  }
  
  private static boolean checkResolveInfo(Class<? extends BroadcastReceiver> paramClass, List<ResolveInfo> paramList)
  {
    Iterator localIterator = paramList.iterator();
    ResolveInfo localResolveInfo;
    do
    {
      if (!localIterator.hasNext()) {
        break;
      }
      localResolveInfo = (ResolveInfo)localIterator.next();
    } while ((localResolveInfo.activityInfo == null) || (!paramClass.getCanonicalName().equals(localResolveInfo.activityInfo.name)));
    for (boolean bool = true;; bool = false) {
      return bool;
    }
  }
  
  private static boolean deviceSupportsGcm()
  {
    if ((Build.VERSION.SDK_INT >= 8) && (getPackageInfo("com.google.android.gsf") != null)) {}
    for (boolean bool = true;; bool = false) {
      return bool;
    }
  }
  
  private static ManifestInfo.ManifestCheckResult gcmSupportLevel()
  {
    ManifestInfo.ManifestCheckResult localManifestCheckResult;
    if (getServiceInfo(PushService.class) == null) {
      localManifestCheckResult = ManifestInfo.ManifestCheckResult.MISSING_REQUIRED_DECLARATIONS;
    }
    for (;;)
    {
      return localManifestCheckResult;
      String[] arrayOfString1 = new String[6];
      arrayOfString1[0] = "android.permission.INTERNET";
      arrayOfString1[1] = "android.permission.ACCESS_NETWORK_STATE";
      arrayOfString1[2] = "android.permission.WAKE_LOCK";
      arrayOfString1[3] = "android.permission.GET_ACCOUNTS";
      arrayOfString1[4] = "com.google.android.c2dm.permission.RECEIVE";
      arrayOfString1[5] = (getPackageName() + ".permission.C2D_MESSAGE");
      if (!hasPermissions(arrayOfString1))
      {
        localManifestCheckResult = ManifestInfo.ManifestCheckResult.MISSING_REQUIRED_DECLARATIONS;
      }
      else
      {
        String str = getPackageName();
        Intent[] arrayOfIntent = new Intent[2];
        arrayOfIntent[0] = new Intent("com.google.android.c2dm.intent.RECEIVE").setPackage(str).addCategory(str);
        arrayOfIntent[1] = new Intent("com.google.android.c2dm.intent.REGISTRATION").setPackage(str).addCategory(str);
        if (!checkReceiver(GcmBroadcastReceiver.class, "com.google.android.c2dm.permission.SEND", arrayOfIntent))
        {
          localManifestCheckResult = ManifestInfo.ManifestCheckResult.MISSING_REQUIRED_DECLARATIONS;
        }
        else
        {
          String[] arrayOfString2 = new String[1];
          arrayOfString2[0] = "android.permission.VIBRATE";
          if (!hasPermissions(arrayOfString2)) {
            localManifestCheckResult = ManifestInfo.ManifestCheckResult.MISSING_OPTIONAL_DECLARATIONS;
          } else {
            localManifestCheckResult = ManifestInfo.ManifestCheckResult.HAS_ALL_DECLARATIONS;
          }
        }
      }
    }
  }
  
  private static ApplicationInfo getApplicationInfo()
  {
    return getContext().getApplicationInfo();
  }
  
  private static ApplicationInfo getApplicationInfo(int paramInt)
  {
    try
    {
      ApplicationInfo localApplicationInfo2 = getPackageManager().getApplicationInfo(getPackageName(), paramInt);
      localApplicationInfo1 = localApplicationInfo2;
    }
    catch (PackageManager.NameNotFoundException localNameNotFoundException)
    {
      for (;;)
      {
        ApplicationInfo localApplicationInfo1 = null;
      }
    }
    return localApplicationInfo1;
  }
  
  public static Bundle getApplicationMetadata()
  {
    return getApplicationInfo(128).metaData;
  }
  
  private static Context getContext()
  {
    return Parse.getApplicationContext();
  }
  
  public static String getDisplayName()
  {
    synchronized (lock)
    {
      if (displayName == null) {
        displayName = getPackageManager().getApplicationLabel(getApplicationInfo()).toString();
      }
      return displayName;
    }
  }
  
  private static String getGcmManifestMessage()
  {
    String str = getPackageName() + ".permission.C2D_MESSAGE";
    return "make sure that these permissions are declared as children of the root <manifest> element:\n\n<uses-permission android:name=\"android.permission.INTERNET\" />\n<uses-permission android:name=\"android.permission.ACCESS_NETWORK_STATE\" />\n<uses-permission android:name=\"android.permission.VIBRATE\" />\n<uses-permission android:name=\"android.permission.WAKE_LOCK\" />\n<uses-permission android:name=\"android.permission.GET_ACCOUNTS\" />\n<uses-permission android:name=\"com.google.android.c2dm.permission.RECEIVE\" />\n<permission android:name=\"" + str + "\" " + "android:protectionLevel=\"signature\" />\n" + "<uses-permission android:name=\"" + str + "\" />\n" + "\n" + "Also, please make sure that these services and broadcast receivers are declared as " + "children of the <application> element:\n" + "\n" + "<service android:name=\"com.parse.PushService\" />\n" + "<receiver android:name=\"com.parse.GcmBroadcastReceiver\" " + "android:permission=\"com.google.android.c2dm.permission.SEND\">\n" + "  <intent-filter>\n" + "    <action android:name=\"com.google.android.c2dm.intent.RECEIVE\" />\n" + "    <action android:name=\"com.google.android.c2dm.intent.REGISTRATION\" />\n" + "    <category android:name=\"" + getPackageName() + "\" />\n" + "  </intent-filter>\n" + "</receiver>\n";
  }
  
  public static int getIconId()
  {
    synchronized (lock)
    {
      if (iconId == 0) {
        iconId = getApplicationInfo().icon;
      }
      return iconId;
    }
  }
  
  static List<ResolveInfo> getIntentReceivers(String... paramVarArgs)
  {
    String str1 = getPackageName();
    ArrayList localArrayList = new ArrayList();
    int i = paramVarArgs.length;
    for (int j = 0; j < i; j++)
    {
      String str2 = paramVarArgs[j];
      localArrayList.addAll(getPackageManager().queryBroadcastReceivers(new Intent(str2), 32));
    }
    for (int k = -1 + localArrayList.size(); k >= 0; k--) {
      if (!((ResolveInfo)localArrayList.get(k)).activityInfo.packageName.equals(str1)) {
        localArrayList.remove(k);
      }
    }
    return localArrayList;
  }
  
  public static long getLastModified()
  {
    synchronized (lock)
    {
      if (lastModified == -1L) {
        lastModified = new File(getApplicationInfo().sourceDir).lastModified();
      }
      return lastModified;
    }
  }
  
  public static String getNonePushTypeLogMessage()
  {
    String str;
    synchronized (lock)
    {
      if (pushType == PushType.NONE) {
        str = "Push is not configured for this app because the app manifest is missing required declarations. Please add the following declarations to your app manifest to support either GCM or PPNS for push (or both). To enable GCM support, please " + getGcmManifestMessage() + "To enable PPNS support, please " + getPpnsManifestMessage();
      } else {
        str = "";
      }
    }
    return str;
  }
  
  private static PackageInfo getPackageInfo(String paramString)
  {
    Object localObject = null;
    try
    {
      PackageInfo localPackageInfo = getPackageManager().getPackageInfo(paramString, 0);
      localObject = localPackageInfo;
    }
    catch (PackageManager.NameNotFoundException localNameNotFoundException)
    {
      label13:
      break label13;
    }
    return localObject;
  }
  
  private static PackageManager getPackageManager()
  {
    return getContext().getPackageManager();
  }
  
  private static String getPackageName()
  {
    return getContext().getPackageName();
  }
  
  private static String getPpnsManifestMessage()
  {
    return "make sure that these permissions are declared as children of the root <manifest> element:\n\n<uses-permission android:name=\"android.permission.INTERNET\" />\n<uses-permission android:name=\"android.permission.ACCESS_NETWORK_STATE\" />\n<uses-permission android:name=\"android.permission.RECEIVE_BOOT_COMPLETED\" />\n<uses-permission android:name=\"android.permission.VIBRATE\" />\n<uses-permission android:name=\"android.permission.WAKE_LOCK\" />\n\nAlso, please make sure that these services and broadcast receivers are declared as children of the <application> element:\n\n<service android:name=\"com.parse.PushService\" />\n<receiver android:name=\"com.parse.ParseBroadcastReceiver\">\n  <intent-filter>\n    <action android:name=\"android.intent.action.BOOT_COMPLETED\" />\n    <action android:name=\"android.intent.action.USER_PRESENT\" />\n  </intent-filter>\n</receiver>\n";
  }
  
  public static PushType getPushType()
  {
    for (;;)
    {
      ManifestInfo.ManifestCheckResult localManifestCheckResult2;
      synchronized (lock)
      {
        boolean bool1;
        boolean bool2;
        if (pushType == null)
        {
          bool1 = deviceSupportsGcm();
          bool2 = hasAnyGcmSpecificDeclaration();
          ManifestInfo.ManifestCheckResult localManifestCheckResult1 = gcmSupportLevel();
          localManifestCheckResult2 = ppnsSupportLevel();
          if ((!bool1) || (localManifestCheckResult1 == ManifestInfo.ManifestCheckResult.MISSING_REQUIRED_DECLARATIONS)) {
            continue;
          }
          pushType = PushType.GCM;
          if (Parse.getLogLevel() <= 5)
          {
            if ((pushType != PushType.GCM) || (localManifestCheckResult1 != ManifestInfo.ManifestCheckResult.MISSING_OPTIONAL_DECLARATIONS)) {
              break label271;
            }
            Parse.logW("com.parse.ManifestInfo", "Using GCM for push, but the app manifest is missing some optional declarations that should be added for maximum reliability. Please " + getGcmManifestMessage());
          }
          if ((Parse.getLogLevel() <= 6) && (pushType == PushType.NONE) && (bool2))
          {
            if (!bool1) {
              Parse.logE("com.parse.ManifestInfo", "Cannot use GCM for push on this device because Google Play Services is not installed. Install Google Play Service from the Play Store, or enable PPNS as a fallback push service. To enable PPNS as a fallback push service on devices without Google Play support, please " + getPpnsManifestMessage());
            }
            if (localManifestCheckResult1 != ManifestInfo.ManifestCheckResult.HAS_ALL_DECLARATIONS) {
              Parse.logE("com.parse.ManifestInfo", "Cannot use GCM for push because the app manifest is missing some required declarations. Please " + getGcmManifestMessage());
            }
          }
          if (Parse.getLogLevel() <= 2) {
            Parse.logV("com.parse.ManifestInfo", "Using " + pushType + " for push.");
          }
        }
        return pushType;
        if (((!bool2) || (!bool1)) && (localManifestCheckResult2 != ManifestInfo.ManifestCheckResult.MISSING_REQUIRED_DECLARATIONS)) {
          pushType = PushType.PPNS;
        }
      }
      pushType = PushType.NONE;
      continue;
      label271:
      if ((pushType == PushType.PPNS) && (localManifestCheckResult2 == ManifestInfo.ManifestCheckResult.MISSING_OPTIONAL_DECLARATIONS)) {
        Parse.logW("com.parse.ManifestInfo", "Using PPNS for push, but the app manifest is missing some optional declarations that should be added for maximum reliability. Please " + getPpnsManifestMessage());
      }
    }
  }
  
  static boolean getPushUsesBroadcastReceivers()
  {
    boolean bool2;
    if (pushUsesBroadcastReceivers != null)
    {
      bool2 = pushUsesBroadcastReceivers.booleanValue();
      return bool2;
    }
    Integer localInteger = Integer.valueOf(0);
    if (hasIntentReceiver("com.parse.push.intent.RECEIVE")) {
      localInteger = Integer.valueOf(1 + localInteger.intValue());
    }
    if (hasIntentReceiver("com.parse.push.intent.OPEN")) {
      localInteger = Integer.valueOf(1 + localInteger.intValue());
    }
    if (hasIntentReceiver("com.parse.push.intent.DELETE")) {
      localInteger = Integer.valueOf(1 + localInteger.intValue());
    }
    if ((localInteger.intValue() != 0) && (localInteger != NUMBER_OF_PUSH_INTENTS)) {
      throw new SecurityException("The Parse Push BroadcastReceiver must implement a filter for all of com.parse.push.intent.RECEIVE, com.parse.push.intent.OPEN, and com.parse.push.intent.DELETE");
    }
    if (localInteger == NUMBER_OF_PUSH_INTENTS) {}
    for (boolean bool1 = true;; bool1 = false)
    {
      pushUsesBroadcastReceivers = Boolean.valueOf(bool1);
      bool2 = pushUsesBroadcastReceivers.booleanValue();
      break;
    }
  }
  
  private static ActivityInfo getReceiverInfo(Class<? extends BroadcastReceiver> paramClass)
  {
    Object localObject = null;
    try
    {
      ActivityInfo localActivityInfo = getPackageManager().getReceiverInfo(new ComponentName(getContext(), paramClass), 0);
      localObject = localActivityInfo;
    }
    catch (PackageManager.NameNotFoundException localNameNotFoundException)
    {
      label23:
      break label23;
    }
    return localObject;
  }
  
  private static ServiceInfo getServiceInfo(Class<? extends Service> paramClass)
  {
    Object localObject = null;
    try
    {
      ServiceInfo localServiceInfo = getPackageManager().getServiceInfo(new ComponentName(getContext(), paramClass), 0);
      localObject = localServiceInfo;
    }
    catch (PackageManager.NameNotFoundException localNameNotFoundException)
    {
      label23:
      break label23;
    }
    return localObject;
  }
  
  public static int getVersionCode()
  {
    synchronized (lock)
    {
      int i = versionCode;
      if (i == -1) {}
      try
      {
        versionCode = getPackageManager().getPackageInfo(getPackageName(), 0).versionCode;
        return versionCode;
      }
      catch (PackageManager.NameNotFoundException localNameNotFoundException)
      {
        for (;;)
        {
          Parse.logE("com.parse.ManifestInfo", "Couldn't find info about own package", localNameNotFoundException);
        }
      }
    }
  }
  
  public static String getVersionName()
  {
    synchronized (lock)
    {
      String str = versionName;
      if (str == null) {}
      try
      {
        versionName = getPackageManager().getPackageInfo(getPackageName(), 0).versionName;
        return versionName;
      }
      catch (PackageManager.NameNotFoundException localNameNotFoundException)
      {
        for (;;)
        {
          Parse.logE("com.parse.ManifestInfo", "Couldn't find info about own package", localNameNotFoundException);
        }
      }
    }
  }
  
  private static boolean hasAnyGcmSpecificDeclaration()
  {
    boolean bool = false;
    String[] arrayOfString1 = new String[1];
    arrayOfString1[bool] = "com.google.android.c2dm.permission.RECEIVE";
    if (!hasPermissions(arrayOfString1))
    {
      String[] arrayOfString2 = new String[1];
      arrayOfString2[bool] = (getPackageName() + ".permission.C2D_MESSAGE");
      if ((!hasPermissions(arrayOfString2)) && (getReceiverInfo(GcmBroadcastReceiver.class) == null)) {}
    }
    else
    {
      bool = true;
    }
    return bool;
  }
  
  static boolean hasIntentReceiver(String paramString)
  {
    boolean bool = true;
    String[] arrayOfString = new String[bool];
    arrayOfString[0] = paramString;
    if (!getIntentReceivers(arrayOfString).isEmpty()) {}
    for (;;)
    {
      return bool;
      bool = false;
    }
  }
  
  private static boolean hasPermissions(String... paramVarArgs)
  {
    boolean bool = false;
    int i = paramVarArgs.length;
    int j = 0;
    if (j < i)
    {
      String str = paramVarArgs[j];
      if (getPackageManager().checkPermission(str, getPackageName()) == 0) {}
    }
    for (;;)
    {
      return bool;
      j++;
      break;
      bool = true;
    }
  }
  
  private static ManifestInfo.ManifestCheckResult ppnsSupportLevel()
  {
    ManifestInfo.ManifestCheckResult localManifestCheckResult;
    if (getServiceInfo(PushService.class) == null) {
      localManifestCheckResult = ManifestInfo.ManifestCheckResult.MISSING_REQUIRED_DECLARATIONS;
    }
    for (;;)
    {
      return localManifestCheckResult;
      String[] arrayOfString = new String[5];
      arrayOfString[0] = "android.permission.INTERNET";
      arrayOfString[1] = "android.permission.ACCESS_NETWORK_STATE";
      arrayOfString[2] = "android.permission.VIBRATE";
      arrayOfString[3] = "android.permission.WAKE_LOCK";
      arrayOfString[4] = "android.permission.RECEIVE_BOOT_COMPLETED";
      if (!hasPermissions(arrayOfString))
      {
        localManifestCheckResult = ManifestInfo.ManifestCheckResult.MISSING_OPTIONAL_DECLARATIONS;
      }
      else
      {
        Intent[] arrayOfIntent = new Intent[2];
        arrayOfIntent[0] = new Intent("android.intent.action.BOOT_COMPLETED").setPackage(getPackageName());
        arrayOfIntent[1] = new Intent("android.intent.action.USER_PRESENT").setPackage(getPackageName());
        if (!checkReceiver(ParseBroadcastReceiver.class, null, arrayOfIntent)) {
          localManifestCheckResult = ManifestInfo.ManifestCheckResult.MISSING_OPTIONAL_DECLARATIONS;
        } else {
          localManifestCheckResult = ManifestInfo.ManifestCheckResult.HAS_ALL_DECLARATIONS;
        }
      }
    }
  }
  
  static void setPushType(PushType paramPushType)
  {
    synchronized (lock)
    {
      pushType = paramPushType;
      return;
    }
  }
  
  public static void setPushUsesBroadcastReceivers(boolean paramBoolean)
  {
    pushUsesBroadcastReceivers = Boolean.valueOf(paramBoolean);
  }
}


/* Location:           C:\Users\dreadiscool\Desktop\tools\classes-dex2jar.jar
 * Qualified Name:     com.parse.ManifestInfo
 * JD-Core Version:    0.7.0.1
 */