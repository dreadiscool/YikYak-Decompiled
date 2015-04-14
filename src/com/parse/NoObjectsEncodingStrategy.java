package com.parse;

import org.json.JSONObject;

class NoObjectsEncodingStrategy
  implements ParseObjectEncodingStrategy
{
  private static final NoObjectsEncodingStrategy instance = new NoObjectsEncodingStrategy();
  
  public static NoObjectsEncodingStrategy get()
  {
    return instance;
  }
  
  public JSONObject encodeRelatedObject(ParseObject paramParseObject)
  {
    throw new IllegalArgumentException("ParseObjects not allowed here");
  }
}


/* Location:           C:\Users\dreadiscool\Desktop\tools\classes-dex2jar.jar
 * Qualified Name:     com.parse.NoObjectsEncodingStrategy
 * JD-Core Version:    0.7.0.1
 */