package com.facebook;

import android.content.Context;
import android.os.Bundle;
import com.facebook.internal.Logger;
import com.facebook.internal.Utility;
import java.io.Serializable;
import java.util.HashSet;
import java.util.Iterator;
import java.util.Set;
import org.json.JSONException;
import org.json.JSONObject;

class AppEventsLogger$AppEvent
  implements Serializable
{
  private static final long serialVersionUID = 1L;
  private static final HashSet<String> validatedIdentifiers = new HashSet();
  private boolean isImplicit;
  private JSONObject jsonObject;
  private String name;
  
  public AppEventsLogger$AppEvent(Context paramContext, String paramString, Double paramDouble, Bundle paramBundle, boolean paramBoolean)
  {
    try
    {
      validateIdentifier(paramString);
      this.name = paramString;
      this.isImplicit = paramBoolean;
      this.jsonObject = new JSONObject();
      this.jsonObject.put("_eventName", paramString);
      this.jsonObject.put("_logTime", System.currentTimeMillis() / 1000L);
      this.jsonObject.put("_ui", Utility.getActivityName(paramContext));
      if (paramDouble != null) {
        this.jsonObject.put("_valueToSum", paramDouble.doubleValue());
      }
      if (this.isImplicit) {
        this.jsonObject.put("_implicitlyLogged", "1");
      }
      String str1 = Settings.getAppVersion();
      if (str1 != null) {
        this.jsonObject.put("_appVersion", str1);
      }
      if (paramBundle != null)
      {
        Iterator localIterator = paramBundle.keySet().iterator();
        if (localIterator.hasNext())
        {
          str2 = (String)localIterator.next();
          validateIdentifier(str2);
          localObject = paramBundle.get(str2);
          if ((!(localObject instanceof String)) && (!(localObject instanceof Number)))
          {
            Object[] arrayOfObject4 = new Object[2];
            arrayOfObject4[0] = localObject;
            arrayOfObject4[1] = str2;
            throw new FacebookException(String.format("Parameter value '%s' for key '%s' should be a string or a numeric type.", arrayOfObject4));
          }
        }
      }
    }
    catch (JSONException localJSONException)
    {
      for (;;)
      {
        String str2;
        Object localObject;
        LoggingBehavior localLoggingBehavior2 = LoggingBehavior.APP_EVENTS;
        Object[] arrayOfObject2 = new Object[1];
        arrayOfObject2[0] = localJSONException.toString();
        Logger.log(localLoggingBehavior2, "AppEvents", "JSON encoding for app event failed: '%s'", arrayOfObject2);
        this.jsonObject = null;
        return;
        this.jsonObject.put(str2, localObject.toString());
      }
    }
    catch (FacebookException localFacebookException)
    {
      for (;;)
      {
        LoggingBehavior localLoggingBehavior1 = LoggingBehavior.APP_EVENTS;
        Object[] arrayOfObject1 = new Object[1];
        arrayOfObject1[0] = localFacebookException.toString();
        Logger.log(localLoggingBehavior1, "AppEvents", "Invalid app event name or parameter:", arrayOfObject1);
        this.jsonObject = null;
        continue;
        if (!this.isImplicit)
        {
          LoggingBehavior localLoggingBehavior3 = LoggingBehavior.APP_EVENTS;
          Object[] arrayOfObject3 = new Object[1];
          arrayOfObject3[0] = this.jsonObject.toString();
          Logger.log(localLoggingBehavior3, "AppEvents", "Created app event '%s'", arrayOfObject3);
        }
      }
    }
  }
  
  private AppEventsLogger$AppEvent(String paramString, boolean paramBoolean)
  {
    this.jsonObject = new JSONObject(paramString);
    this.isImplicit = paramBoolean;
  }
  
  private void validateIdentifier(String paramString)
  {
    if ((paramString == null) || (paramString.length() == 0) || (paramString.length() > 40))
    {
      if (paramString == null) {
        paramString = "<None Provided>";
      }
      Object[] arrayOfObject1 = new Object[2];
      arrayOfObject1[0] = paramString;
      arrayOfObject1[1] = Integer.valueOf(40);
      throw new FacebookException(String.format("Identifier '%s' must be less than %d characters", arrayOfObject1));
    }
    synchronized (validatedIdentifiers)
    {
      boolean bool = validatedIdentifiers.contains(paramString);
      if (!bool) {
        if (!paramString.matches("^[0-9a-zA-Z_]+[0-9a-zA-Z _-]*$")) {
          break label124;
        }
      }
    }
    synchronized (validatedIdentifiers)
    {
      validatedIdentifiers.add(paramString);
      return;
      localObject1 = finally;
      throw localObject1;
    }
    label124:
    Object[] arrayOfObject2 = new Object[1];
    arrayOfObject2[0] = paramString;
    throw new FacebookException(String.format("Skipping event named '%s' due to illegal name - must be under 40 chars and alphanumeric, _, - or space, and not start with a space or hyphen.", arrayOfObject2));
  }
  
  private Object writeReplace()
  {
    return new AppEventsLogger.AppEvent.SerializationProxyV1(this.jsonObject.toString(), this.isImplicit, null);
  }
  
  public boolean getIsImplicit()
  {
    return this.isImplicit;
  }
  
  public JSONObject getJSONObject()
  {
    return this.jsonObject;
  }
  
  public String getName()
  {
    return this.name;
  }
  
  public String toString()
  {
    Object[] arrayOfObject = new Object[3];
    arrayOfObject[0] = this.jsonObject.optString("_eventName");
    arrayOfObject[1] = Boolean.valueOf(this.isImplicit);
    arrayOfObject[2] = this.jsonObject.toString();
    return String.format("\"%s\", implicit: %b, json: %s", arrayOfObject);
  }
}


/* Location:           C:\Users\dreadiscool\Desktop\tools\classes-dex2jar.jar
 * Qualified Name:     com.facebook.AppEventsLogger.AppEvent
 * JD-Core Version:    0.7.0.1
 */