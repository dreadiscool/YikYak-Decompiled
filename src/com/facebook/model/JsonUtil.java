package com.facebook.model;

import java.util.ArrayList;
import java.util.Collection;
import java.util.HashSet;
import java.util.Iterator;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Set;
import org.json.JSONException;
import org.json.JSONObject;

class JsonUtil
{
  static void jsonObjectClear(JSONObject paramJSONObject)
  {
    Iterator localIterator = paramJSONObject.keys();
    while (localIterator.hasNext())
    {
      localIterator.next();
      localIterator.remove();
    }
  }
  
  static boolean jsonObjectContainsValue(JSONObject paramJSONObject, Object paramObject)
  {
    Iterator localIterator = paramJSONObject.keys();
    Object localObject;
    do
    {
      if (!localIterator.hasNext()) {
        break;
      }
      localObject = paramJSONObject.opt((String)localIterator.next());
    } while ((localObject == null) || (!localObject.equals(paramObject)));
    for (boolean bool = true;; bool = false) {
      return bool;
    }
  }
  
  static Set<Map.Entry<String, Object>> jsonObjectEntrySet(JSONObject paramJSONObject)
  {
    HashSet localHashSet = new HashSet();
    Iterator localIterator = paramJSONObject.keys();
    while (localIterator.hasNext())
    {
      String str = (String)localIterator.next();
      localHashSet.add(new JsonUtil.JSONObjectEntry(str, paramJSONObject.opt(str)));
    }
    return localHashSet;
  }
  
  static Set<String> jsonObjectKeySet(JSONObject paramJSONObject)
  {
    HashSet localHashSet = new HashSet();
    Iterator localIterator = paramJSONObject.keys();
    while (localIterator.hasNext()) {
      localHashSet.add(localIterator.next());
    }
    return localHashSet;
  }
  
  static void jsonObjectPutAll(JSONObject paramJSONObject, Map<String, Object> paramMap)
  {
    Iterator localIterator = paramMap.entrySet().iterator();
    while (localIterator.hasNext())
    {
      Map.Entry localEntry = (Map.Entry)localIterator.next();
      try
      {
        paramJSONObject.putOpt((String)localEntry.getKey(), localEntry.getValue());
      }
      catch (JSONException localJSONException)
      {
        throw new IllegalArgumentException(localJSONException);
      }
    }
  }
  
  static Collection<Object> jsonObjectValues(JSONObject paramJSONObject)
  {
    ArrayList localArrayList = new ArrayList();
    Iterator localIterator = paramJSONObject.keys();
    while (localIterator.hasNext()) {
      localArrayList.add(paramJSONObject.opt((String)localIterator.next()));
    }
    return localArrayList;
  }
}


/* Location:           C:\Users\dreadiscool\Desktop\tools\classes-dex2jar.jar
 * Qualified Name:     com.facebook.model.JsonUtil
 * JD-Core Version:    0.7.0.1
 */