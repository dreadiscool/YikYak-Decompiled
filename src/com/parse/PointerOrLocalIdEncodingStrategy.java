package com.parse;

import org.json.JSONException;
import org.json.JSONObject;

class PointerOrLocalIdEncodingStrategy
  implements ParseObjectEncodingStrategy
{
  private static final PointerOrLocalIdEncodingStrategy instance = new PointerOrLocalIdEncodingStrategy();
  
  public static PointerOrLocalIdEncodingStrategy get()
  {
    return instance;
  }
  
  public JSONObject encodeRelatedObject(ParseObject paramParseObject)
  {
    JSONObject localJSONObject = new JSONObject();
    try
    {
      if (paramParseObject.getObjectId() != null)
      {
        localJSONObject.put("__type", "Pointer");
        localJSONObject.put("className", paramParseObject.getClassName());
        localJSONObject.put("objectId", paramParseObject.getObjectId());
      }
      else
      {
        localJSONObject.put("__type", "Pointer");
        localJSONObject.put("className", paramParseObject.getClassName());
        localJSONObject.put("localId", paramParseObject.getOrCreateLocalId());
      }
    }
    catch (JSONException localJSONException)
    {
      throw new RuntimeException(localJSONException);
    }
    return localJSONObject;
  }
}


/* Location:           C:\Users\dreadiscool\Desktop\tools\classes-dex2jar.jar
 * Qualified Name:     com.parse.PointerOrLocalIdEncodingStrategy
 * JD-Core Version:    0.7.0.1
 */