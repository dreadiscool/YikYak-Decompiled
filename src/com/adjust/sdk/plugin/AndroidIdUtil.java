package com.adjust.sdk.plugin;

import android.content.Context;
import android.provider.Settings.Secure;

public class AndroidIdUtil
{
  public static String getAndroidId(Context paramContext)
  {
    return Settings.Secure.getString(paramContext.getContentResolver(), "android_id");
  }
}


/* Location:           C:\Users\dreadiscool\Desktop\tools\classes-dex2jar.jar
 * Qualified Name:     com.adjust.sdk.plugin.AndroidIdUtil
 * JD-Core Version:    0.7.0.1
 */