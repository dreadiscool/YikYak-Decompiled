package com.parse;

import android.content.Context;
import java.util.Collections;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.List<TT;>;
import java.util.Map;
import java.util.Map<Ljava.lang.String;TV;>;
import m;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

public class ParseConfig
{
  static final String CURRENT_CONFIG_FILENAME = "currentConfig";
  private static ParseConfig currentConfig;
  private static final Object currentConfigMutex = new Object();
  private static final TaskQueue taskQueue = new TaskQueue();
  private final Map<String, Object> params;
  
  ParseConfig()
  {
    this.params = Collections.unmodifiableMap(new HashMap());
  }
  
  ParseConfig(JSONObject paramJSONObject, ParseDecoder paramParseDecoder)
  {
    Map localMap = (Map)((Map)paramParseDecoder.decode(paramJSONObject)).get("params");
    if (localMap == null) {
      throw new RuntimeException("Object did not contain the 'params' key.");
    }
    this.params = Collections.unmodifiableMap(localMap);
  }
  
  static void clearCurrentConfigForTesting()
  {
    synchronized (currentConfigMutex)
    {
      currentConfig = null;
      return;
    }
  }
  
  public static ParseConfig get()
  {
    return (ParseConfig)Parse.waitForTask(getInBackground());
  }
  
  private static m<ParseConfig> getAsync(m<Void> paramm)
  {
    ParseCommand localParseCommand = new ParseCommand("client_config", ParseUser.getCurrentSessionToken());
    localParseCommand.enableRetrying();
    return paramm.b(new ParseConfig.3(localParseCommand)).c(new ParseConfig.2(), m.a);
  }
  
  public static ParseConfig getCurrentConfig()
  {
    if (currentConfig == null) {}
    synchronized (currentConfigMutex)
    {
      ParseConfig localParseConfig = getFromDisk(Parse.applicationContext, "currentConfig");
      if (localParseConfig != null)
      {
        currentConfig = localParseConfig;
        return currentConfig;
      }
      localParseConfig = new ParseConfig();
    }
  }
  
  private static ParseConfig getFromDisk(Context paramContext, String paramString)
  {
    Object localObject = null;
    JSONObject localJSONObject = Parse.getDiskObject(paramContext, paramString);
    if (localJSONObject == null) {}
    for (;;)
    {
      return localObject;
      try
      {
        ParseConfig localParseConfig = new ParseConfig(localJSONObject, new ParseDecoder());
        localObject = localParseConfig;
      }
      catch (JSONException localJSONException) {}
    }
  }
  
  public static m<ParseConfig> getInBackground()
  {
    return taskQueue.enqueue(new ParseConfig.1());
  }
  
  public static void getInBackground(ConfigCallback paramConfigCallback)
  {
    Parse.callbackOnMainThreadAsync(getInBackground(), paramConfigCallback);
  }
  
  private void saveToDisk(Context paramContext, String paramString)
  {
    JSONObject localJSONObject = new JSONObject();
    try
    {
      localJSONObject.put("params", (JSONObject)Parse.encode(this.params, PointerEncodingStrategy.get()));
      Parse.saveDiskObject(paramContext, paramString, localJSONObject);
      return;
    }
    catch (JSONException localJSONException)
    {
      throw new RuntimeException("could not serialize config to JSON");
    }
  }
  
  public Object get(String paramString)
  {
    return get(paramString, null);
  }
  
  public Object get(String paramString, Object paramObject)
  {
    if (!this.params.containsKey(paramString)) {}
    for (;;)
    {
      return paramObject;
      if (this.params.get(paramString) == JSONObject.NULL) {
        paramObject = null;
      } else {
        paramObject = this.params.get(paramString);
      }
    }
  }
  
  public boolean getBoolean(String paramString)
  {
    return getBoolean(paramString, false);
  }
  
  public boolean getBoolean(String paramString, boolean paramBoolean)
  {
    if (!this.params.containsKey(paramString)) {}
    for (;;)
    {
      return paramBoolean;
      Object localObject = this.params.get(paramString);
      if ((localObject instanceof Boolean)) {
        paramBoolean = ((Boolean)localObject).booleanValue();
      }
    }
  }
  
  public Date getDate(String paramString)
  {
    return getDate(paramString, null);
  }
  
  public Date getDate(String paramString, Date paramDate)
  {
    if (!this.params.containsKey(paramString)) {}
    Object localObject;
    for (;;)
    {
      return paramDate;
      localObject = this.params.get(paramString);
      if ((localObject != null) && (localObject != JSONObject.NULL)) {
        break;
      }
      paramDate = null;
    }
    if ((localObject instanceof Date)) {}
    for (Date localDate = (Date)localObject;; localDate = paramDate)
    {
      paramDate = localDate;
      break;
    }
  }
  
  public double getDouble(String paramString)
  {
    return getDouble(paramString, 0.0D);
  }
  
  public double getDouble(String paramString, double paramDouble)
  {
    Number localNumber = getNumber(paramString);
    if (localNumber != null) {
      paramDouble = localNumber.doubleValue();
    }
    return paramDouble;
  }
  
  public int getInt(String paramString)
  {
    return getInt(paramString, 0);
  }
  
  public int getInt(String paramString, int paramInt)
  {
    Number localNumber = getNumber(paramString);
    if (localNumber != null) {
      paramInt = localNumber.intValue();
    }
    return paramInt;
  }
  
  public JSONArray getJSONArray(String paramString)
  {
    return getJSONArray(paramString, null);
  }
  
  public JSONArray getJSONArray(String paramString, JSONArray paramJSONArray)
  {
    List localList = getList(paramString);
    if (localList != null) {}
    for (Object localObject = Parse.encode(localList, PointerEncodingStrategy.get());; localObject = null)
    {
      if ((localObject == null) || ((localObject instanceof JSONArray))) {
        paramJSONArray = (JSONArray)localObject;
      }
      return paramJSONArray;
    }
  }
  
  public JSONObject getJSONObject(String paramString)
  {
    return getJSONObject(paramString, null);
  }
  
  public JSONObject getJSONObject(String paramString, JSONObject paramJSONObject)
  {
    Map localMap = getMap(paramString);
    if (localMap != null) {}
    for (Object localObject = Parse.encode(localMap, PointerEncodingStrategy.get());; localObject = null)
    {
      if ((localObject == null) || ((localObject instanceof JSONObject))) {
        paramJSONObject = (JSONObject)localObject;
      }
      return paramJSONObject;
    }
  }
  
  public <T> List<T> getList(String paramString)
  {
    return getList(paramString, null);
  }
  
  public <T> List<T> getList(String paramString, List<T> paramList)
  {
    if (!this.params.containsKey(paramString)) {}
    Object localObject1;
    for (;;)
    {
      return paramList;
      localObject1 = this.params.get(paramString);
      if ((localObject1 != null) && (localObject1 != JSONObject.NULL)) {
        break;
      }
      paramList = null;
    }
    if ((localObject1 instanceof List)) {}
    for (Object localObject2 = (List)localObject1;; localObject2 = paramList)
    {
      paramList = (List<T>)localObject2;
      break;
    }
  }
  
  public long getLong(String paramString)
  {
    return getLong(paramString, 0L);
  }
  
  public long getLong(String paramString, long paramLong)
  {
    Number localNumber = getNumber(paramString);
    if (localNumber != null) {
      paramLong = localNumber.longValue();
    }
    return paramLong;
  }
  
  public <V> Map<String, V> getMap(String paramString)
  {
    return getMap(paramString, null);
  }
  
  public <V> Map<String, V> getMap(String paramString, Map<String, V> paramMap)
  {
    if (!this.params.containsKey(paramString)) {}
    Object localObject1;
    for (;;)
    {
      return paramMap;
      localObject1 = this.params.get(paramString);
      if ((localObject1 != null) && (localObject1 != JSONObject.NULL)) {
        break;
      }
      paramMap = null;
    }
    if ((localObject1 instanceof Map)) {}
    for (Object localObject2 = (Map)localObject1;; localObject2 = paramMap)
    {
      paramMap = (Map<String, V>)localObject2;
      break;
    }
  }
  
  public Number getNumber(String paramString)
  {
    return getNumber(paramString, null);
  }
  
  public Number getNumber(String paramString, Number paramNumber)
  {
    if (!this.params.containsKey(paramString)) {}
    Object localObject;
    for (;;)
    {
      return paramNumber;
      localObject = this.params.get(paramString);
      if ((localObject != null) && (localObject != JSONObject.NULL)) {
        break;
      }
      paramNumber = null;
    }
    if ((localObject instanceof Number)) {}
    for (Number localNumber = (Number)localObject;; localNumber = paramNumber)
    {
      paramNumber = localNumber;
      break;
    }
  }
  
  public ParseFile getParseFile(String paramString)
  {
    return getParseFile(paramString, null);
  }
  
  public ParseFile getParseFile(String paramString, ParseFile paramParseFile)
  {
    if (!this.params.containsKey(paramString)) {}
    Object localObject;
    for (;;)
    {
      return paramParseFile;
      localObject = this.params.get(paramString);
      if ((localObject != null) && (localObject != JSONObject.NULL)) {
        break;
      }
      paramParseFile = null;
    }
    if ((localObject instanceof ParseFile)) {}
    for (ParseFile localParseFile = (ParseFile)localObject;; localParseFile = paramParseFile)
    {
      paramParseFile = localParseFile;
      break;
    }
  }
  
  public ParseGeoPoint getParseGeoPoint(String paramString)
  {
    return getParseGeoPoint(paramString, null);
  }
  
  public ParseGeoPoint getParseGeoPoint(String paramString, ParseGeoPoint paramParseGeoPoint)
  {
    if (!this.params.containsKey(paramString)) {}
    Object localObject;
    for (;;)
    {
      return paramParseGeoPoint;
      localObject = this.params.get(paramString);
      if ((localObject != null) && (localObject != JSONObject.NULL)) {
        break;
      }
      paramParseGeoPoint = null;
    }
    if ((localObject instanceof ParseGeoPoint)) {}
    for (ParseGeoPoint localParseGeoPoint = (ParseGeoPoint)localObject;; localParseGeoPoint = paramParseGeoPoint)
    {
      paramParseGeoPoint = localParseGeoPoint;
      break;
    }
  }
  
  public String getString(String paramString)
  {
    return getString(paramString, null);
  }
  
  public String getString(String paramString1, String paramString2)
  {
    if (!this.params.containsKey(paramString1)) {}
    Object localObject;
    for (;;)
    {
      return paramString2;
      localObject = this.params.get(paramString1);
      if ((localObject != null) && (localObject != JSONObject.NULL)) {
        break;
      }
      paramString2 = null;
    }
    if ((localObject instanceof String)) {}
    for (String str = (String)localObject;; str = paramString2)
    {
      paramString2 = str;
      break;
    }
  }
  
  public String toString()
  {
    return "ParseConfig[" + this.params.toString() + "]";
  }
}


/* Location:           C:\Users\dreadiscool\Desktop\tools\classes-dex2jar.jar
 * Qualified Name:     com.parse.ParseConfig
 * JD-Core Version:    0.7.0.1
 */