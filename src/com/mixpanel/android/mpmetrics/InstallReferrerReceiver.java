package com.mixpanel.android.mpmetrics;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import java.io.UnsupportedEncodingException;
import java.net.URLDecoder;
import java.util.HashMap;
import java.util.Map;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import vb;

public class InstallReferrerReceiver
  extends BroadcastReceiver
{
  private final Pattern a = Pattern.compile("(^|&)utm_source=([^&#=]*)([#&]|$)");
  private final Pattern b = Pattern.compile("(^|&)utm_medium=([^&#=]*)([#&]|$)");
  private final Pattern c = Pattern.compile("(^|&)utm_campaign=([^&#=]*)([#&]|$)");
  private final Pattern d = Pattern.compile("(^|&)utm_content=([^&#=]*)([#&]|$)");
  private final Pattern e = Pattern.compile("(^|&)utm_term=([^&#=]*)([#&]|$)");
  
  private String a(Matcher paramMatcher)
  {
    String str2;
    if (paramMatcher.find())
    {
      str2 = paramMatcher.group(2);
      if (str2 == null) {}
    }
    for (;;)
    {
      try
      {
        String str3 = URLDecoder.decode(str2, "UTF-8");
        str1 = str3;
        return str1;
      }
      catch (UnsupportedEncodingException localUnsupportedEncodingException) {}
      String str1 = null;
    }
  }
  
  public void onReceive(Context paramContext, Intent paramIntent)
  {
    Bundle localBundle = paramIntent.getExtras();
    if (localBundle == null) {}
    for (;;)
    {
      return;
      String str1 = localBundle.getString("referrer");
      if (str1 != null)
      {
        HashMap localHashMap = new HashMap();
        localHashMap.put("referrer", str1);
        String str2 = a(this.a.matcher(str1));
        if (str2 != null) {
          localHashMap.put("utm_source", str2);
        }
        String str3 = a(this.b.matcher(str1));
        if (str3 != null) {
          localHashMap.put("utm_medium", str3);
        }
        String str4 = a(this.c.matcher(str1));
        if (str4 != null) {
          localHashMap.put("utm_campaign", str4);
        }
        String str5 = a(this.d.matcher(str1));
        if (str5 != null) {
          localHashMap.put("utm_content", str5);
        }
        String str6 = a(this.e.matcher(str1));
        if (str6 != null) {
          localHashMap.put("utm_term", str6);
        }
        vb.a(paramContext, "com.mixpanel.android.mpmetrics.ReferralInfo", localHashMap);
      }
    }
  }
}


/* Location:           C:\Users\dreadiscool\Desktop\tools\classes-dex2jar.jar
 * Qualified Name:     com.mixpanel.android.mpmetrics.InstallReferrerReceiver
 * JD-Core Version:    0.7.0.1
 */