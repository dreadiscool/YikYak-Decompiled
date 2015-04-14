package com.parse;

import android.app.Activity;
import android.content.Context;
import org.json.JSONObject;

public final class PushRoutes$Route
{
  private final String activityClassName;
  private final int iconId;
  
  public PushRoutes$Route(String paramString, int paramInt)
  {
    if (paramString == null) {
      throw new IllegalArgumentException("activityClassName can't be null");
    }
    if (paramInt == 0) {
      throw new IllegalArgumentException("iconId can't be 0");
    }
    this.activityClassName = paramString;
    this.iconId = paramInt;
  }
  
  public static Route newFromJSON(JSONObject paramJSONObject)
  {
    int i = 0;
    Route localRoute = null;
    String str;
    if (paramJSONObject != null)
    {
      JSONObject localJSONObject = paramJSONObject.optJSONObject("data");
      if (localJSONObject != null)
      {
        str = localJSONObject.optString("activityClass", null);
        i = localJSONObject.optInt("icon", 0);
      }
    }
    for (;;)
    {
      if ((str != null) && (i != 0)) {
        localRoute = new Route(str, i);
      }
      return localRoute;
      str = null;
    }
  }
  
  public boolean equals(Object paramObject)
  {
    boolean bool = false;
    if ((paramObject != null) && ((paramObject instanceof Route)))
    {
      Route localRoute = (Route)paramObject;
      if ((this.activityClassName.equals(localRoute.activityClassName)) && (this.iconId == localRoute.iconId)) {
        bool = true;
      }
    }
    return bool;
  }
  
  public Class<? extends Activity> getActivityClass()
  {
    localObject = null;
    try
    {
      Class localClass2 = Class.forName(this.activityClassName);
      localClass1 = localClass2;
    }
    catch (ClassNotFoundException localClassNotFoundException)
    {
      for (;;)
      {
        Class localClass1 = null;
        continue;
        localObject = localClass1;
      }
    }
    if ((localClass1 != null) && (!Activity.class.isAssignableFrom(localClass1)))
    {
      if (localObject == null) {
        Parse.logE("com.parse.PushRoutes", "Activity class " + this.activityClassName + " registered to handle push no " + "longer exists. Call PushService.subscribe with an activity class that does exist.");
      }
      return localObject;
    }
  }
  
  public int getIconId()
  {
    return this.iconId;
  }
  
  public int hashCode()
  {
    return 31 * (31 + this.activityClassName.hashCode()) + this.iconId;
  }
  
  public JSONObject toJSON()
  {
    JSONObject localJSONObject1 = new JSONObject();
    JSONObject localJSONObject2 = new JSONObject();
    localJSONObject2.put("appName", ManifestInfo.getDisplayName());
    localJSONObject2.put("activityPackage", Parse.applicationContext.getPackageName());
    localJSONObject2.put("activityClass", this.activityClassName);
    localJSONObject2.put("icon", this.iconId);
    localJSONObject1.put("data", localJSONObject2);
    localJSONObject1.put("name", "com.parse.StandardPushCallback");
    return localJSONObject1;
  }
  
  public String toString()
  {
    return super.toString() + " (activityClassName: " + this.activityClassName + " iconId: " + this.iconId + ")";
  }
}


/* Location:           C:\Users\dreadiscool\Desktop\tools\classes-dex2jar.jar
 * Qualified Name:     com.parse.PushRoutes.Route
 * JD-Core Version:    0.7.0.1
 */