package com.parse;

import java.util.Collections;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map.Entry;
import java.util.Set;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import org.json.JSONObject;

class PushRoutes
{
  private static final Pattern CHANNEL_PATTERN = Pattern.compile("^$|^[a-zA-Z][A-Za-z0-9_-]*$");
  private static final String TAG = "com.parse.PushRoutes";
  private final HashMap<String, PushRoutes.Route> channels = new HashMap();
  
  public PushRoutes(JSONObject paramJSONObject)
  {
    if (paramJSONObject != null)
    {
      JSONObject localJSONObject1 = paramJSONObject.optJSONObject("routes");
      if (localJSONObject1 != null)
      {
        Iterator localIterator = localJSONObject1.keys();
        while (localIterator.hasNext())
        {
          String str = (String)localIterator.next();
          PushRoutes.Route localRoute2 = PushRoutes.Route.newFromJSON(localJSONObject1.optJSONObject(str));
          if ((str != null) && (localRoute2 != null)) {
            put(str, localRoute2);
          }
        }
      }
      JSONObject localJSONObject2 = paramJSONObject.optJSONObject("defaultRoute");
      if (localJSONObject2 != null)
      {
        PushRoutes.Route localRoute1 = PushRoutes.Route.newFromJSON(localJSONObject2);
        if (localRoute1 != null) {
          put(null, localRoute1);
        }
      }
    }
  }
  
  public static boolean isValidChannelName(String paramString)
  {
    try
    {
      boolean bool = CHANNEL_PATTERN.matcher(paramString).matches();
      return bool;
    }
    finally
    {
      localObject = finally;
      throw localObject;
    }
  }
  
  public PushRoutes.Route get(String paramString)
  {
    return (PushRoutes.Route)this.channels.get(paramString);
  }
  
  public Set<String> getChannels()
  {
    return Collections.unmodifiableSet(this.channels.keySet());
  }
  
  public PushRoutes.Route put(String paramString, PushRoutes.Route paramRoute)
  {
    if (paramRoute == null) {
      throw new IllegalArgumentException("Can't insert null route");
    }
    if ((paramString != null) && (!isValidChannelName(paramString))) {
      throw new IllegalArgumentException("invalid channel name: " + paramString);
    }
    return (PushRoutes.Route)this.channels.put(paramString, paramRoute);
  }
  
  public PushRoutes.Route remove(String paramString)
  {
    return (PushRoutes.Route)this.channels.remove(paramString);
  }
  
  public JSONObject toJSON()
  {
    JSONObject localJSONObject1 = new JSONObject();
    JSONObject localJSONObject2 = new JSONObject();
    Iterator localIterator = this.channels.entrySet().iterator();
    while (localIterator.hasNext())
    {
      Map.Entry localEntry = (Map.Entry)localIterator.next();
      String str = (String)localEntry.getKey();
      PushRoutes.Route localRoute = (PushRoutes.Route)localEntry.getValue();
      if (str == null) {
        localJSONObject1.put("defaultRoute", localRoute.toJSON());
      } else {
        localJSONObject2.put(str, localRoute.toJSON());
      }
    }
    localJSONObject1.put("routes", localJSONObject2);
    return localJSONObject1;
  }
}


/* Location:           C:\Users\dreadiscool\Desktop\tools\classes-dex2jar.jar
 * Qualified Name:     com.parse.PushRoutes
 * JD-Core Version:    0.7.0.1
 */