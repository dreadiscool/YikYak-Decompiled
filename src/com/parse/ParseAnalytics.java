package com.parse;

import android.content.Intent;
import android.os.Bundle;
import java.util.Date;
import java.util.Map;
import m;
import org.json.JSONException;
import org.json.JSONObject;

public class ParseAnalytics
{
  private static final String APP_OPENED = "AppOpened";
  private static final String OP = "client_events";
  private static final String TAG = "com.parse.ParseAnalytics";
  static Map<String, Boolean> lruSeenPushes = new ParseAnalytics.1();
  
  private static ParseCommand createCommand(String paramString)
  {
    ParseCommand localParseCommand = new ParseCommand("client_events", ParseUser.getCurrentSessionToken());
    localParseCommand.put("at", Parse.encodeDate(new Date()));
    localParseCommand.put("name", paramString);
    return localParseCommand;
  }
  
  @Deprecated
  public static void trackAppOpened(Intent paramIntent)
  {
    trackAppOpenedInBackground(paramIntent);
  }
  
  public static m<Void> trackAppOpenedInBackground(Intent paramIntent)
  {
    if ((paramIntent != null) && (paramIntent.getExtras() != null)) {}
    m localm;
    for (String str1 = paramIntent.getExtras().getString("com.parse.Data");; str1 = null)
    {
      ParseCommand localParseCommand = createCommand("AppOpened");
      if (str1 != null) {}
      try
      {
        str2 = new JSONObject(str1).optString("push_hash");
        if (str2.length() <= 0) {}
      }
      catch (JSONException localJSONException)
      {
        for (;;)
        {
          String str2;
          Parse.logE("com.parse.ParseAnalytics", "Failed to parse push data: " + localJSONException.getMessage());
        }
      }
      synchronized (lruSeenPushes)
      {
        if (lruSeenPushes.containsKey(str2))
        {
          localm = m.a(null);
        }
        else
        {
          lruSeenPushes.put(str2, Boolean.valueOf(true));
          localParseCommand.put("push_hash", str2);
          localm = Parse.getEventuallyQueue().enqueueEventuallyAsync(localParseCommand, null).j();
        }
      }
    }
    return localm;
  }
  
  public static void trackAppOpenedInBackground(Intent paramIntent, SaveCallback paramSaveCallback)
  {
    Parse.callbackOnMainThreadAsync(trackAppOpenedInBackground(paramIntent), paramSaveCallback);
  }
  
  @Deprecated
  public static void trackEvent(String paramString)
  {
    trackEventInBackground(paramString);
  }
  
  @Deprecated
  public static void trackEvent(String paramString, Map<String, String> paramMap)
  {
    trackEventInBackground(paramString, paramMap);
  }
  
  public static m<Void> trackEventInBackground(String paramString)
  {
    return trackEventInBackground(paramString, (Map)null);
  }
  
  public static m<Void> trackEventInBackground(String paramString, Map<String, String> paramMap)
  {
    if ((paramString == null) || (paramString.trim().length() == 0)) {
      throw new RuntimeException("A name for the custom event must be provided.");
    }
    ParseCommand localParseCommand = createCommand(paramString);
    if (paramMap != null) {
      localParseCommand.put("dimensions", (JSONObject)Parse.encode(paramMap, NoObjectsEncodingStrategy.get()));
    }
    return Parse.getEventuallyQueue().enqueueEventuallyAsync(localParseCommand, null).j();
  }
  
  public static void trackEventInBackground(String paramString, SaveCallback paramSaveCallback)
  {
    Parse.callbackOnMainThreadAsync(trackEventInBackground(paramString), paramSaveCallback);
  }
  
  public static void trackEventInBackground(String paramString, Map<String, String> paramMap, SaveCallback paramSaveCallback)
  {
    Parse.callbackOnMainThreadAsync(trackEventInBackground(paramString, paramMap), paramSaveCallback);
  }
}


/* Location:           C:\Users\dreadiscool\Desktop\tools\classes-dex2jar.jar
 * Qualified Name:     com.parse.ParseAnalytics
 * JD-Core Version:    0.7.0.1
 */