package com.parse;

import com.parse.codec.binary.Base64;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

class ParseDecoder
{
  List<Object> convertJSONArrayToList(JSONArray paramJSONArray)
  {
    ArrayList localArrayList = new ArrayList();
    for (int i = 0; i < paramJSONArray.length(); i++) {
      localArrayList.add(decode(paramJSONArray.opt(i)));
    }
    return localArrayList;
  }
  
  Map<String, Object> convertJSONObjectToMap(JSONObject paramJSONObject)
  {
    HashMap localHashMap = new HashMap();
    Iterator localIterator = paramJSONObject.keys();
    while (localIterator.hasNext())
    {
      String str = (String)localIterator.next();
      localHashMap.put(str, decode(paramJSONObject.opt(str)));
    }
    return localHashMap;
  }
  
  public Object decode(Object paramObject)
  {
    if ((paramObject instanceof JSONArray)) {
      paramObject = convertJSONArrayToList((JSONArray)paramObject);
    }
    for (;;)
    {
      return paramObject;
      if ((paramObject instanceof JSONObject))
      {
        JSONObject localJSONObject1 = (JSONObject)paramObject;
        if (localJSONObject1.optString("__op", null) != null)
        {
          try
          {
            ParseFieldOperation localParseFieldOperation = ParseFieldOperations.decode(localJSONObject1, this);
            paramObject = localParseFieldOperation;
          }
          catch (JSONException localJSONException3)
          {
            throw new RuntimeException(localJSONException3);
          }
        }
        else
        {
          String str = localJSONObject1.optString("__type", null);
          if (str == null)
          {
            paramObject = convertJSONObjectToMap(localJSONObject1);
          }
          else if (str.equals("Date"))
          {
            paramObject = Parse.stringToDate(localJSONObject1.optString("iso"));
          }
          else if (str.equals("Bytes"))
          {
            paramObject = Base64.decodeBase64(localJSONObject1.optString("base64"));
          }
          else if (str.equals("Pointer"))
          {
            paramObject = decodePointer(localJSONObject1.optString("className"), localJSONObject1.optString("objectId"));
          }
          else if (str.equals("File"))
          {
            paramObject = new ParseFile(localJSONObject1, this);
          }
          else if (str.equals("GeoPoint"))
          {
            try
            {
              double d1 = localJSONObject1.getDouble("latitude");
              double d2 = localJSONObject1.getDouble("longitude");
              paramObject = new ParseGeoPoint(d1, d2);
            }
            catch (JSONException localJSONException2)
            {
              throw new RuntimeException(localJSONException2);
            }
          }
          else if (str.equals("Object"))
          {
            JSONObject localJSONObject2 = new JSONObject();
            try
            {
              localJSONObject2.put("data", localJSONObject1);
              paramObject = ParseObject.createWithoutData(localJSONObject1.optString("className", null), localJSONObject1.optString("objectId", null));
              paramObject.mergeAfterFetch(localJSONObject2, this, true);
            }
            catch (JSONException localJSONException1)
            {
              throw new RuntimeException(localJSONException1);
            }
          }
          else if (str.equals("Relation"))
          {
            paramObject = new ParseRelation(localJSONObject1, this);
          }
          else
          {
            if (str.equals("OfflineObject")) {
              throw new RuntimeException("An unexpected offline pointer was encountered.");
            }
            paramObject = null;
          }
        }
      }
    }
  }
  
  protected ParseObject decodePointer(String paramString1, String paramString2)
  {
    return ParseObject.createWithoutData(paramString1, paramString2);
  }
}


/* Location:           C:\Users\dreadiscool\Desktop\tools\classes-dex2jar.jar
 * Qualified Name:     com.parse.ParseDecoder
 * JD-Core Version:    0.7.0.1
 */