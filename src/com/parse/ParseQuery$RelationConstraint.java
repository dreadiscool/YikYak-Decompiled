package com.parse;

import org.json.JSONException;
import org.json.JSONObject;

class ParseQuery$RelationConstraint
{
  private String key;
  private ParseObject object;
  
  public ParseQuery$RelationConstraint(String paramString, ParseObject paramParseObject)
  {
    if ((paramString == null) || (paramParseObject == null)) {
      throw new IllegalArgumentException("Arguments must not be null.");
    }
    this.key = paramString;
    this.object = paramParseObject;
  }
  
  public JSONObject encode(ParseObjectEncodingStrategy paramParseObjectEncodingStrategy)
  {
    JSONObject localJSONObject = new JSONObject();
    try
    {
      localJSONObject.put("key", this.key);
      localJSONObject.put("object", paramParseObjectEncodingStrategy.encodeRelatedObject(this.object));
      return localJSONObject;
    }
    catch (JSONException localJSONException)
    {
      throw new RuntimeException(localJSONException);
    }
  }
  
  public String getKey()
  {
    return this.key;
  }
  
  public ParseObject getObject()
  {
    return this.object;
  }
  
  public ParseRelation<ParseObject> getRelation()
  {
    return this.object.getRelation(this.key);
  }
}


/* Location:           C:\Users\dreadiscool\Desktop\tools\classes-dex2jar.jar
 * Qualified Name:     com.parse.ParseQuery.RelationConstraint
 * JD-Core Version:    0.7.0.1
 */