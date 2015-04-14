package com.parse;

import com.parse.codec.digest.DigestUtils;
import org.json.JSONException;
import org.json.JSONObject;

class ParseJSONCacheItem
{
  private String hashValue;
  private JSONObject json = new JSONObject();
  
  public ParseJSONCacheItem(Object paramObject)
  {
    this.json.put("object", Parse.encode(paramObject, PointerOrLocalIdEncodingStrategy.get()));
    this.hashValue = DigestUtils.md5Hex(this.json.toString());
  }
  
  public boolean equals(ParseJSONCacheItem paramParseJSONCacheItem)
  {
    return this.hashValue.equals(paramParseJSONCacheItem.getHashValue());
  }
  
  public String getHashValue()
  {
    return this.hashValue;
  }
  
  public Object getJSONObject()
  {
    try
    {
      Object localObject2 = this.json.get("object");
      localObject1 = localObject2;
    }
    catch (JSONException localJSONException)
    {
      for (;;)
      {
        Object localObject1 = null;
      }
    }
    return localObject1;
  }
}


/* Location:           C:\Users\dreadiscool\Desktop\tools\classes-dex2jar.jar
 * Qualified Name:     com.parse.ParseJSONCacheItem
 * JD-Core Version:    0.7.0.1
 */