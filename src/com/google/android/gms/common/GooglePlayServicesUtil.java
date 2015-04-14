package com.google.android.gms.common;

import android.app.Activity;
import android.app.AlertDialog;
import android.app.AlertDialog.Builder;
import android.app.Dialog;
import android.app.Notification;
import android.app.Notification.BigTextStyle;
import android.app.Notification.Builder;
import android.app.NotificationManager;
import android.app.PendingIntent;
import android.content.Context;
import android.content.DialogInterface.OnCancelListener;
import android.content.Intent;
import android.content.pm.ApplicationInfo;
import android.content.pm.PackageInfo;
import android.content.pm.PackageManager;
import android.content.pm.PackageManager.NameNotFoundException;
import android.content.pm.Signature;
import android.content.res.Configuration;
import android.content.res.Resources;
import android.content.res.Resources.Theme;
import android.os.Build;
import android.os.Bundle;
import android.os.Handler;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentActivity;
import android.text.TextUtils;
import android.util.Base64;
import android.util.Log;
import android.util.TypedValue;
import fg;
import fh;
import hK;
import hZ;
import hv;
import hw;
import is;
import iv;
import java.util.Arrays;
import java.util.Set;

public final class GooglePlayServicesUtil
{
  public static final String GMS_ERROR_DIALOG = "GooglePlayServicesErrorDialog";
  public static final String GOOGLE_PLAY_SERVICES_PACKAGE = "com.google.android.gms";
  public static final int GOOGLE_PLAY_SERVICES_VERSION_CODE = 6587000;
  public static final String GOOGLE_PLAY_STORE_PACKAGE = "com.android.vending";
  public static boolean Jg = false;
  public static boolean Jh = false;
  private static int Ji = -1;
  private static final Object Jj = new Object();
  
  public static void C(Context paramContext)
  {
    int i = isGooglePlayServicesAvailable(paramContext);
    if (i != 0)
    {
      Intent localIntent = aj(i);
      new StringBuilder().append("GooglePlayServices not available due to error ").append(i).toString();
      if (localIntent == null) {
        throw new GooglePlayServicesNotAvailableException(i);
      }
      throw new GooglePlayServicesRepairableException(i, "Google Play Services not available", localIntent);
    }
  }
  
  private static void D(Context paramContext)
  {
    Object localObject = null;
    try
    {
      ApplicationInfo localApplicationInfo = paramContext.getPackageManager().getApplicationInfo(paramContext.getPackageName(), 128);
      localObject = localApplicationInfo;
    }
    catch (PackageManager.NameNotFoundException localNameNotFoundException)
    {
      for (;;)
      {
        Bundle localBundle;
        Log.wtf("GooglePlayServicesUtil", "This should never happen.", localNameNotFoundException);
      }
    }
    localBundle = localObject.metaData;
    if (localBundle != null)
    {
      int i = localBundle.getInt("com.google.android.gms.version");
      if (i == 6587000) {
        return;
      }
      throw new IllegalStateException("The meta-data tag in your app's AndroidManifest.xml does not have the right value.  Expected 6587000 but found " + i + ".  You must have the" + " following declaration within the <application> element: " + "    <meta-data android:name=\"" + "com.google.android.gms.version" + "\" android:value=\"@integer/google_play_services_version\" />");
    }
    throw new IllegalStateException("A required meta-data tag in your app's AndroidManifest.xml does not exist.  You must have the following declaration within the <application> element:     <meta-data android:name=\"com.google.android.gms.version\" android:value=\"@integer/google_play_services_version\" />");
  }
  
  private static void E(Context paramContext)
  {
    GooglePlayServicesUtil.a locala = new GooglePlayServicesUtil.a(paramContext);
    locala.sendMessageDelayed(locala.obtainMessage(1), 120000L);
  }
  
  private static String F(Context paramContext)
  {
    String str = paramContext.getApplicationInfo().name;
    PackageManager localPackageManager;
    if (TextUtils.isEmpty(str))
    {
      str = paramContext.getPackageName();
      localPackageManager = paramContext.getApplicationContext().getPackageManager();
    }
    try
    {
      ApplicationInfo localApplicationInfo2 = localPackageManager.getApplicationInfo(paramContext.getPackageName(), 0);
      localApplicationInfo1 = localApplicationInfo2;
    }
    catch (PackageManager.NameNotFoundException localNameNotFoundException)
    {
      for (;;)
      {
        ApplicationInfo localApplicationInfo1 = null;
      }
    }
    if (localApplicationInfo1 != null) {
      str = localPackageManager.getApplicationLabel(localApplicationInfo1).toString();
    }
    return str;
  }
  
  private static Dialog a(int paramInt1, Activity paramActivity, Fragment paramFragment, int paramInt2, DialogInterface.OnCancelListener paramOnCancelListener)
  {
    if ((is.a(paramActivity)) && (paramInt1 == 2)) {
      paramInt1 = 42;
    }
    if (iv.c())
    {
      TypedValue localTypedValue = new TypedValue();
      paramActivity.getTheme().resolveAttribute(16843529, localTypedValue, true);
      if (!"Theme.Dialog.Alert".equals(paramActivity.getResources().getResourceEntryName(localTypedValue.resourceId))) {}
    }
    for (AlertDialog.Builder localBuilder = new AlertDialog.Builder(paramActivity, 5);; localBuilder = null)
    {
      if (localBuilder == null) {
        localBuilder = new AlertDialog.Builder(paramActivity);
      }
      localBuilder.setMessage(b(paramActivity, paramInt1));
      if (paramOnCancelListener != null) {
        localBuilder.setOnCancelListener(paramOnCancelListener);
      }
      Intent localIntent = aj(paramInt1);
      hw localhw;
      AlertDialog localAlertDialog;
      if (paramFragment == null)
      {
        localhw = new hw(paramActivity, localIntent, paramInt2);
        String str = c(paramActivity, paramInt1);
        if (str != null) {
          localBuilder.setPositiveButton(str, localhw);
        }
        switch (paramInt1)
        {
        default: 
          new StringBuilder().append("Unexpected error code ").append(paramInt1).toString();
          localAlertDialog = localBuilder.create();
        }
      }
      for (;;)
      {
        return localAlertDialog;
        localhw = new hw(paramFragment, localIntent, paramInt2);
        break;
        localAlertDialog = null;
        continue;
        localAlertDialog = localBuilder.create();
        continue;
        localAlertDialog = localBuilder.setTitle(fh.common_google_play_services_install_title).create();
        continue;
        localAlertDialog = localBuilder.setTitle(fh.common_google_play_services_enable_title).create();
        continue;
        localAlertDialog = localBuilder.setTitle(fh.common_google_play_services_update_title).create();
        continue;
        localAlertDialog = localBuilder.setTitle(fh.common_android_wear_update_title).create();
        continue;
        localAlertDialog = localBuilder.setTitle(fh.common_google_play_services_unsupported_title).create();
        continue;
        localAlertDialog = localBuilder.setTitle(fh.common_google_play_services_network_error_title).create();
        continue;
        localAlertDialog = localBuilder.create();
        continue;
        localAlertDialog = localBuilder.create();
        continue;
        localAlertDialog = localBuilder.setTitle(fh.common_google_play_services_invalid_account_title).create();
        continue;
        localAlertDialog = localBuilder.create();
      }
    }
  }
  
  private static void a(int paramInt, Context paramContext)
  {
    Resources localResources = paramContext.getResources();
    String str1 = d(paramContext, paramInt);
    int i = fh.common_google_play_services_error_notification_requested_by_msg;
    Object[] arrayOfObject = new Object[1];
    arrayOfObject[0] = F(paramContext);
    String str2 = localResources.getString(i, arrayOfObject);
    PendingIntent localPendingIntent = getErrorPendingIntent(paramInt, paramContext, 0);
    if (is.a(paramContext)) {
      hZ.a(iv.d());
    }
    Notification localNotification;
    for (Object localObject = new Notification.Builder(paramContext).setSmallIcon(fg.common_ic_googleplayservices).setPriority(2).setAutoCancel(true).setStyle(new Notification.BigTextStyle().bigText(str1 + " " + str2)).addAction(fg.common_full_open_on_phone, localResources.getString(fh.common_open_on_phone), localPendingIntent).build();; localObject = localNotification)
    {
      ((NotificationManager)paramContext.getSystemService("notification")).notify(ak(paramInt), (Notification)localObject);
      return;
      localNotification = new Notification(17301642, localResources.getString(fh.common_google_play_services_notification_ticker), System.currentTimeMillis());
      localNotification.flags = (0x10 | localNotification.flags);
      localNotification.setLatestEventInfo(paramContext, str1, str2, localPendingIntent);
    }
  }
  
  public static boolean a(PackageManager paramPackageManager, PackageInfo paramPackageInfo)
  {
    boolean bool1 = true;
    boolean bool2 = false;
    if (paramPackageInfo == null) {}
    for (;;)
    {
      return bool2;
      if (c(paramPackageManager))
      {
        if (a(paramPackageInfo, bool1) != null) {}
        for (;;)
        {
          bool2 = bool1;
          break;
          bool1 = false;
        }
      }
      if (a(paramPackageInfo, false) != null) {
        bool2 = bool1;
      }
      if (!bool2) {
        a(paramPackageInfo, bool1);
      }
    }
  }
  
  public static boolean a(Resources paramResources)
  {
    boolean bool = false;
    if (paramResources == null) {}
    label49:
    for (;;)
    {
      return bool;
      if ((0xF & paramResources.getConfiguration().screenLayout) > 3) {}
      for (int i = 1;; i = 0)
      {
        if (((!iv.a()) || (i == 0)) && (!b(paramResources))) {
          break label49;
        }
        bool = true;
        break;
      }
    }
  }
  
  private static byte[] a(PackageInfo paramPackageInfo, boolean paramBoolean)
  {
    Object localObject;
    if (paramPackageInfo.signatures.length != 1) {
      localObject = null;
    }
    for (;;)
    {
      return localObject;
      byte[] arrayOfByte = paramPackageInfo.signatures[0].toByteArray();
      if (paramBoolean) {}
      for (Set localSet = b.gu();; localSet = b.gv())
      {
        if (!localSet.contains(arrayOfByte)) {
          break label56;
        }
        localObject = arrayOfByte;
        break;
      }
      label56:
      if (Log.isLoggable("GooglePlayServicesUtil", 2)) {
        new StringBuilder().append("Signature not valid.  Found: \n").append(Base64.encodeToString(arrayOfByte, 0)).toString();
      }
      localObject = null;
    }
  }
  
  private static byte[] a(PackageInfo paramPackageInfo, byte[]... paramVarArgs)
  {
    Object localObject;
    if (paramPackageInfo.signatures.length != 1) {
      localObject = null;
    }
    for (;;)
    {
      return localObject;
      byte[] arrayOfByte1 = paramPackageInfo.signatures[0].toByteArray();
      for (int i = 0;; i++)
      {
        if (i >= paramVarArgs.length) {
          break label60;
        }
        byte[] arrayOfByte2 = paramVarArgs[i];
        if (Arrays.equals(arrayOfByte2, arrayOfByte1))
        {
          localObject = arrayOfByte2;
          break;
        }
      }
      label60:
      if (Log.isLoggable("GooglePlayServicesUtil", 2)) {
        new StringBuilder().append("Signature not valid.  Found: \n").append(Base64.encodeToString(arrayOfByte1, 0)).toString();
      }
      localObject = null;
    }
  }
  
  public static Intent aj(int paramInt)
  {
    Intent localIntent;
    switch (paramInt)
    {
    default: 
      localIntent = null;
    }
    for (;;)
    {
      return localIntent;
      localIntent = hK.b("com.google.android.gms");
      continue;
      localIntent = hK.a();
      continue;
      localIntent = hK.a("com.google.android.gms");
    }
  }
  
  private static int ak(int paramInt)
  {
    switch (paramInt)
    {
    }
    for (int i = 39789;; i = 10436) {
      return i;
    }
  }
  
  public static String b(Context paramContext, int paramInt)
  {
    Resources localResources = paramContext.getResources();
    String str;
    switch (paramInt)
    {
    default: 
      str = localResources.getString(fh.common_google_play_services_unknown_issue);
    }
    for (;;)
    {
      return str;
      if (a(paramContext.getResources()))
      {
        str = localResources.getString(fh.common_google_play_services_install_text_tablet);
      }
      else
      {
        str = localResources.getString(fh.common_google_play_services_install_text_phone);
        continue;
        str = localResources.getString(fh.common_google_play_services_enable_text);
        continue;
        str = localResources.getString(fh.common_google_play_services_update_text);
        continue;
        str = localResources.getString(fh.common_android_wear_update_text);
        continue;
        str = localResources.getString(fh.common_google_play_services_unsupported_text);
        continue;
        str = localResources.getString(fh.common_google_play_services_network_error_text);
        continue;
        str = localResources.getString(fh.common_google_play_services_invalid_account_text);
      }
    }
  }
  
  public static boolean b(PackageManager paramPackageManager)
  {
    for (boolean bool = true;; bool = false) {
      synchronized (Jj)
      {
        int i = Ji;
        if (i == -1) {}
        try
        {
          PackageInfo localPackageInfo = paramPackageManager.getPackageInfo("com.google.android.gms", 64);
          byte[][] arrayOfByte = new byte[1][];
          arrayOfByte[0] = b.Jc[1];
          if (a(localPackageInfo, arrayOfByte) != null) {}
          for (Ji = 1; Ji != 0; Ji = 0) {
            return bool;
          }
        }
        catch (PackageManager.NameNotFoundException localNameNotFoundException)
        {
          for (;;)
          {
            Ji = 0;
          }
        }
      }
    }
  }
  
  public static boolean b(PackageManager paramPackageManager, String paramString)
  {
    try
    {
      PackageInfo localPackageInfo = paramPackageManager.getPackageInfo(paramString, 64);
      bool = a(paramPackageManager, localPackageInfo);
    }
    catch (PackageManager.NameNotFoundException localNameNotFoundException)
    {
      for (;;)
      {
        if (Log.isLoggable("GooglePlayServicesUtil", 3)) {
          new StringBuilder().append("Package manager can't find package ").append(paramString).append(", defaulting to false").toString();
        }
        boolean bool = false;
      }
    }
    return bool;
  }
  
  private static boolean b(Resources paramResources)
  {
    boolean bool = false;
    Configuration localConfiguration = paramResources.getConfiguration();
    if ((iv.b()) && ((0xF & localConfiguration.screenLayout) <= 3) && (localConfiguration.smallestScreenWidthDp >= 600)) {
      bool = true;
    }
    return bool;
  }
  
  public static String c(Context paramContext, int paramInt)
  {
    Resources localResources = paramContext.getResources();
    String str;
    switch (paramInt)
    {
    default: 
      str = localResources.getString(17039370);
    }
    for (;;)
    {
      return str;
      str = localResources.getString(fh.common_google_play_services_install_button);
      continue;
      str = localResources.getString(fh.common_google_play_services_enable_button);
      continue;
      str = localResources.getString(fh.common_google_play_services_update_button);
    }
  }
  
  public static boolean c(PackageManager paramPackageManager)
  {
    if ((b(paramPackageManager)) || (!gw())) {}
    for (boolean bool = true;; bool = false) {
      return bool;
    }
  }
  
  public static String d(Context paramContext, int paramInt)
  {
    Resources localResources = paramContext.getResources();
    String str;
    switch (paramInt)
    {
    default: 
      str = localResources.getString(fh.common_google_play_services_unknown_issue);
    }
    for (;;)
    {
      return str;
      str = localResources.getString(fh.common_google_play_services_notification_needs_installation_title);
      continue;
      str = localResources.getString(fh.common_google_play_services_notification_needs_update_title);
      continue;
      str = localResources.getString(fh.common_android_wear_notification_needs_update_text);
      continue;
      str = localResources.getString(fh.common_google_play_services_needs_enabling_title);
      continue;
      str = localResources.getString(fh.common_google_play_services_unsupported_text);
      continue;
      str = localResources.getString(fh.common_google_play_services_network_error_text);
      continue;
      str = localResources.getString(fh.common_google_play_services_invalid_account_text);
    }
  }
  
  public static boolean e(Context paramContext, int paramInt)
  {
    int i = 1;
    PackageManager localPackageManager;
    if (paramInt == i) {
      localPackageManager = paramContext.getPackageManager();
    }
    for (;;)
    {
      try
      {
        boolean bool = localPackageManager.getApplicationInfo("com.google.android.gms", 8192).enabled;
        if (bool) {
          return i;
        }
      }
      catch (PackageManager.NameNotFoundException localNameNotFoundException) {}
      i = 0;
    }
  }
  
  public static Dialog getErrorDialog(int paramInt1, Activity paramActivity, int paramInt2)
  {
    return getErrorDialog(paramInt1, paramActivity, paramInt2, null);
  }
  
  public static Dialog getErrorDialog(int paramInt1, Activity paramActivity, int paramInt2, DialogInterface.OnCancelListener paramOnCancelListener)
  {
    return a(paramInt1, paramActivity, null, paramInt2, paramOnCancelListener);
  }
  
  public static PendingIntent getErrorPendingIntent(int paramInt1, Context paramContext, int paramInt2)
  {
    Intent localIntent = aj(paramInt1);
    if (localIntent == null) {}
    for (PendingIntent localPendingIntent = null;; localPendingIntent = PendingIntent.getActivity(paramContext, paramInt2, localIntent, 268435456)) {
      return localPendingIntent;
    }
  }
  
  public static String getErrorString(int paramInt)
  {
    String str;
    switch (paramInt)
    {
    default: 
      str = "UNKNOWN_ERROR_CODE";
    }
    for (;;)
    {
      return str;
      str = "SUCCESS";
      continue;
      str = "SERVICE_MISSING";
      continue;
      str = "SERVICE_VERSION_UPDATE_REQUIRED";
      continue;
      str = "SERVICE_DISABLED";
      continue;
      str = "SIGN_IN_REQUIRED";
      continue;
      str = "INVALID_ACCOUNT";
      continue;
      str = "RESOLUTION_REQUIRED";
      continue;
      str = "NETWORK_ERROR";
      continue;
      str = "INTERNAL_ERROR";
      continue;
      str = "SERVICE_INVALID";
      continue;
      str = "DEVELOPER_ERROR";
      continue;
      str = "LICENSE_CHECK_FAILED";
    }
  }
  
  /* Error */
  public static String getOpenSourceSoftwareLicenseInfo(Context paramContext)
  {
    // Byte code:
    //   0: new 612	android/net/Uri$Builder
    //   3: dup
    //   4: invokespecial 613	android/net/Uri$Builder:<init>	()V
    //   7: ldc_w 615
    //   10: invokevirtual 619	android/net/Uri$Builder:scheme	(Ljava/lang/String;)Landroid/net/Uri$Builder;
    //   13: ldc 11
    //   15: invokevirtual 622	android/net/Uri$Builder:authority	(Ljava/lang/String;)Landroid/net/Uri$Builder;
    //   18: ldc_w 624
    //   21: invokevirtual 627	android/net/Uri$Builder:appendPath	(Ljava/lang/String;)Landroid/net/Uri$Builder;
    //   24: ldc_w 629
    //   27: invokevirtual 627	android/net/Uri$Builder:appendPath	(Ljava/lang/String;)Landroid/net/Uri$Builder;
    //   30: invokevirtual 632	android/net/Uri$Builder:build	()Landroid/net/Uri;
    //   33: astore_1
    //   34: aload_0
    //   35: invokevirtual 636	android/content/Context:getContentResolver	()Landroid/content/ContentResolver;
    //   38: aload_1
    //   39: invokevirtual 642	android/content/ContentResolver:openInputStream	(Landroid/net/Uri;)Ljava/io/InputStream;
    //   42: astore 4
    //   44: new 644	java/util/Scanner
    //   47: dup
    //   48: aload 4
    //   50: invokespecial 647	java/util/Scanner:<init>	(Ljava/io/InputStream;)V
    //   53: ldc_w 649
    //   56: invokevirtual 653	java/util/Scanner:useDelimiter	(Ljava/lang/String;)Ljava/util/Scanner;
    //   59: invokevirtual 656	java/util/Scanner:next	()Ljava/lang/String;
    //   62: astore 7
    //   64: aload 7
    //   66: astore_3
    //   67: aload 4
    //   69: ifnull +44 -> 113
    //   72: aload 4
    //   74: invokevirtual 661	java/io/InputStream:close	()V
    //   77: goto +36 -> 113
    //   80: astore 6
    //   82: aload 4
    //   84: ifnull +31 -> 115
    //   87: aload 4
    //   89: invokevirtual 661	java/io/InputStream:close	()V
    //   92: goto +23 -> 115
    //   95: astore 5
    //   97: aload 4
    //   99: ifnull +8 -> 107
    //   102: aload 4
    //   104: invokevirtual 661	java/io/InputStream:close	()V
    //   107: aload 5
    //   109: athrow
    //   110: astore_2
    //   111: aconst_null
    //   112: astore_3
    //   113: aload_3
    //   114: areturn
    //   115: aconst_null
    //   116: astore_3
    //   117: goto -4 -> 113
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	120	0	paramContext	Context
    //   33	6	1	localUri	android.net.Uri
    //   110	1	2	localException	java.lang.Exception
    //   66	51	3	str1	String
    //   42	61	4	localInputStream	java.io.InputStream
    //   95	13	5	localObject	Object
    //   80	1	6	localNoSuchElementException	java.util.NoSuchElementException
    //   62	3	7	str2	String
    // Exception table:
    //   from	to	target	type
    //   44	64	80	java/util/NoSuchElementException
    //   44	64	95	finally
    //   34	44	110	java/lang/Exception
    //   72	110	110	java/lang/Exception
  }
  
  public static Context getRemoteContext(Context paramContext)
  {
    try
    {
      Context localContext2 = paramContext.createPackageContext("com.google.android.gms", 3);
      localContext1 = localContext2;
    }
    catch (PackageManager.NameNotFoundException localNameNotFoundException)
    {
      for (;;)
      {
        Context localContext1 = null;
      }
    }
    return localContext1;
  }
  
  public static Resources getRemoteResource(Context paramContext)
  {
    try
    {
      Resources localResources2 = paramContext.getPackageManager().getResourcesForApplication("com.google.android.gms");
      localResources1 = localResources2;
    }
    catch (PackageManager.NameNotFoundException localNameNotFoundException)
    {
      for (;;)
      {
        Resources localResources1 = null;
      }
    }
    return localResources1;
  }
  
  public static boolean gw()
  {
    if (Jg) {}
    for (boolean bool = Jh;; bool = "user".equals(Build.TYPE)) {
      return bool;
    }
  }
  
  public static int isGooglePlayServicesAvailable(Context paramContext)
  {
    int i = 1;
    PackageManager localPackageManager = paramContext.getPackageManager();
    if (!hv.a) {}
    try
    {
      paramContext.getResources().getString(fh.common_google_play_services_unknown_issue);
      label24:
      if (!hv.a) {
        D(paramContext);
      }
      for (;;)
      {
        try
        {
          localPackageInfo1 = localPackageManager.getPackageInfo("com.google.android.gms", 64);
          if (!is.c(localPackageInfo1.versionCode)) {
            continue;
          }
          if (!gw()) {
            continue;
          }
          k = 0;
          byte[][] arrayOfByte2 = new byte[3][];
          arrayOfByte2[0] = b.Ix[k];
          arrayOfByte2[i] = b.IE[k];
          arrayOfByte2[2] = b.IC[k];
          if (a(localPackageInfo1, arrayOfByte2) != null) {
            continue;
          }
          i = 9;
        }
        catch (PackageManager.NameNotFoundException localNameNotFoundException1)
        {
          PackageInfo localPackageInfo1;
          int k;
          String str;
          byte[] arrayOfByte;
          byte[][] arrayOfByte1;
          int j;
          continue;
        }
        return i;
        k = i;
        continue;
        str = paramContext.getPackageName();
        try
        {
          PackageInfo localPackageInfo3 = localPackageManager.getPackageInfo(str, 64);
          if (a(localPackageManager, localPackageInfo3)) {
            continue;
          }
          new StringBuilder().append("Calling package ").append(localPackageInfo3.packageName).append(" signature invalid on Glass.").toString();
          i = 9;
        }
        catch (PackageManager.NameNotFoundException localNameNotFoundException4)
        {
          new StringBuilder().append("Could not get info for calling package: ").append(str).toString();
          i = 9;
        }
        continue;
        if (is.a(paramContext))
        {
          if (a(localPackageInfo1, b.Ix) == null) {
            i = 9;
          }
        }
        else
        {
          try
          {
            PackageInfo localPackageInfo2 = localPackageManager.getPackageInfo("com.android.vending", 64);
            arrayOfByte = a(localPackageInfo2, b.Ix);
            if (arrayOfByte != null) {
              continue;
            }
            i = 9;
          }
          catch (PackageManager.NameNotFoundException localNameNotFoundException2)
          {
            i = 9;
          }
          continue;
          arrayOfByte1 = new byte[i][];
          arrayOfByte1[0] = arrayOfByte;
          if (a(localPackageInfo1, arrayOfByte1) == null)
          {
            i = 9;
            continue;
          }
        }
        j = is.a(6587000);
        if (is.a(localPackageInfo1.versionCode) < j)
        {
          new StringBuilder().append("Google Play services out of date.  Requires 6587000 but found ").append(localPackageInfo1.versionCode).toString();
          i = 2;
        }
        else
        {
          try
          {
            ApplicationInfo localApplicationInfo = localPackageManager.getApplicationInfo("com.google.android.gms", 0);
            if (localApplicationInfo.enabled) {
              continue;
            }
            i = 3;
          }
          catch (PackageManager.NameNotFoundException localNameNotFoundException3)
          {
            Log.wtf("GooglePlayServicesUtil", "Google Play services missing when getting application info.");
            localNameNotFoundException3.printStackTrace();
          }
          continue;
          i = 0;
        }
      }
    }
    catch (Throwable localThrowable)
    {
      break label24;
    }
  }
  
  public static boolean isGoogleSignedUid(PackageManager paramPackageManager, int paramInt)
  {
    if (paramPackageManager == null) {
      throw new SecurityException("Unknown error: invalid Package Manager");
    }
    String[] arrayOfString = paramPackageManager.getPackagesForUid(paramInt);
    if ((arrayOfString.length == 0) || (!b(paramPackageManager, arrayOfString[0]))) {
      throw new SecurityException("Uid is not Google Signed");
    }
    return true;
  }
  
  public static boolean isUserRecoverableError(int paramInt)
  {
    switch (paramInt)
    {
    }
    for (boolean bool = false;; bool = true) {
      return bool;
    }
  }
  
  public static boolean showErrorDialogFragment(int paramInt1, Activity paramActivity, int paramInt2)
  {
    return showErrorDialogFragment(paramInt1, paramActivity, paramInt2, null);
  }
  
  public static boolean showErrorDialogFragment(int paramInt1, Activity paramActivity, int paramInt2, DialogInterface.OnCancelListener paramOnCancelListener)
  {
    return showErrorDialogFragment(paramInt1, paramActivity, null, paramInt2, paramOnCancelListener);
  }
  
  public static boolean showErrorDialogFragment(int paramInt1, Activity paramActivity, Fragment paramFragment, int paramInt2, DialogInterface.OnCancelListener paramOnCancelListener)
  {
    Dialog localDialog = a(paramInt1, paramActivity, paramFragment, paramInt2, paramOnCancelListener);
    boolean bool;
    if (localDialog == null)
    {
      bool = false;
      return bool;
    }
    if ((paramActivity instanceof FragmentActivity))
    {
      android.support.v4.app.FragmentManager localFragmentManager1 = ((FragmentActivity)paramActivity).getSupportFragmentManager();
      SupportErrorDialogFragment.newInstance(localDialog, paramOnCancelListener).show(localFragmentManager1, "GooglePlayServicesErrorDialog");
    }
    for (;;)
    {
      bool = true;
      break;
      if (!iv.a()) {
        break label87;
      }
      android.app.FragmentManager localFragmentManager = paramActivity.getFragmentManager();
      ErrorDialogFragment.newInstance(localDialog, paramOnCancelListener).show(localFragmentManager, "GooglePlayServicesErrorDialog");
    }
    label87:
    throw new RuntimeException("This Activity does not support Fragments.");
  }
  
  public static void showErrorNotification(int paramInt, Context paramContext)
  {
    if ((is.a(paramContext)) && (paramInt == 2)) {
      paramInt = 42;
    }
    if (e(paramContext, paramInt)) {
      E(paramContext);
    }
    for (;;)
    {
      return;
      a(paramInt, paramContext);
    }
  }
}


/* Location:           C:\Users\dreadiscool\Desktop\tools\classes-dex2jar.jar
 * Qualified Name:     com.google.android.gms.common.GooglePlayServicesUtil
 * JD-Core Version:    0.7.0.1
 */