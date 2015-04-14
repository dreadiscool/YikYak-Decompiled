package com.facebook.internal;

import android.os.Bundle;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Set;
import org.json.JSONArray;
import org.json.JSONObject;

public class BundleJSONConverter
{
  private static final Map<Class<?>, BundleJSONConverter.Setter> SETTERS = new HashMap();
  
  static
  {
    SETTERS.put(Boolean.class, new BundleJSONConverter.1());
    SETTERS.put(Integer.class, new BundleJSONConverter.2());
    SETTERS.put(Long.class, new BundleJSONConverter.3());
    SETTERS.put(Double.class, new BundleJSONConverter.4());
    SETTERS.put(String.class, new BundleJSONConverter.5());
    SETTERS.put([Ljava.lang.String.class, new BundleJSONConverter.6());
    SETTERS.put(JSONArray.class, new BundleJSONConverter.7());
  }
  
  public static Bundle convertToBundle(JSONObject paramJSONObject)
  {
    Bundle localBundle = new Bundle();
    Iterator localIterator = paramJSONObject.keys();
    while (localIterator.hasNext())
    {
      String str = (String)localIterator.next();
      Object localObject = paramJSONObject.get(str);
      if ((localObject != null) && (localObject != JSONObject.NULL)) {
        if ((localObject instanceof JSONObject))
        {
          localBundle.putBundle(str, convertToBundle((JSONObject)localObject));
        }
        else
        {
          BundleJSONConverter.Setter localSetter = (BundleJSONConverter.Setter)SETTERS.get(localObject.getClass());
          if (localSetter == null) {
            throw new IllegalArgumentException("Unsupported type: " + localObject.getClass());
          }
          localSetter.setOnBundle(localBundle, str, localObject);
        }
      }
    }
    return localBundle;
  }
  
  public static JSONObject convertToJSON(Bundle paramBundle)
  {
    JSONObject localJSONObject = new JSONObject();
    Iterator localIterator1 = paramBundle.keySet().iterator();
    while (localIterator1.hasNext())
    {
      String str = (String)localIterator1.next();
      Object localObject = paramBundle.get(str);
      if (localObject != null) {
        if ((localObject instanceof List))
        {
          JSONArray localJSONArray = new JSONArray();
          Iterator localIterator2 = ((List)localObject).iterator();
          while (localIterator2.hasNext()) {
            localJSONArray.put((String)localIterator2.next());
          }
          localJSONObject.put(str, localJSONArray);
        }
        else if ((localObject instanceof Bundle))
        {
          localJSONObject.put(str, convertToJSON((Bundle)localObject));
        }
        else
        {
          BundleJSONConverter.Setter localSetter = (BundleJSONConverter.Setter)SETTERS.get(localObject.getClass());
          if (localSetter == null) {
            throw new IllegalArgumentException("Unsupported type: " + localObject.getClass());
          }
          localSetter.setOnJSON(localJSONObject, str, localObject);
        }
      }
    }
    return localJSONObject;
  }
}


/* Location:           C:\Users\dreadiscool\Desktop\tools\classes-dex2jar.jar
 * Qualified Name:     com.facebook.internal.BundleJSONConverter
 * JD-Core Version:    0.7.0.1
 */