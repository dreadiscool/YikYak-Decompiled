package com.adjust.sdk.plugin;

import android.content.Context;
import android.net.wifi.WifiInfo;
import android.net.wifi.WifiManager;
import android.text.TextUtils;
import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.Locale;

public class MacAddressUtil
{
  public static String getMacAddress(Context paramContext)
  {
    String str1 = getRawMacAddress(paramContext);
    if (str1 == null) {}
    for (String str2 = null;; str2 = removeSpaceString(str1.toUpperCase(Locale.US))) {
      return str2;
    }
  }
  
  private static String getRawMacAddress(Context paramContext)
  {
    Object localObject = loadAddress("wlan0");
    if (localObject != null) {}
    for (;;)
    {
      return localObject;
      localObject = loadAddress("eth0");
      if (localObject == null) {}
      try
      {
        String str = ((WifiManager)paramContext.getSystemService("wifi")).getConnectionInfo().getMacAddress();
        localObject = str;
        if (localObject != null) {
          continue;
        }
      }
      catch (Exception localException)
      {
        label44:
        break label44;
      }
      localObject = null;
    }
  }
  
  private static String loadAddress(String paramString)
  {
    String str1;
    try
    {
      String str2 = "/sys/class/net/" + paramString + "/address";
      StringBuilder localStringBuilder = new StringBuilder(1000);
      BufferedReader localBufferedReader = new BufferedReader(new FileReader(str2), 1024);
      char[] arrayOfChar = new char[1024];
      for (;;)
      {
        int i = localBufferedReader.read(arrayOfChar);
        if (i == -1) {
          break;
        }
        localStringBuilder.append(String.valueOf(arrayOfChar, 0, i));
      }
      localBufferedReader.close();
      String str3 = localStringBuilder.toString();
      str1 = str3;
    }
    catch (IOException localIOException)
    {
      str1 = null;
    }
    return str1;
  }
  
  private static String removeSpaceString(String paramString)
  {
    Object localObject = null;
    if (paramString == null) {}
    for (;;)
    {
      return localObject;
      String str = paramString.replaceAll("\\s", "");
      if (!TextUtils.isEmpty(str)) {
        localObject = str;
      }
    }
  }
}


/* Location:           C:\Users\dreadiscool\Desktop\tools\classes-dex2jar.jar
 * Qualified Name:     com.adjust.sdk.plugin.MacAddressUtil
 * JD-Core Version:    0.7.0.1
 */