package com.parse;

import org.json.JSONObject;

abstract interface ParseObjectEncodingStrategy
{
  public abstract JSONObject encodeRelatedObject(ParseObject paramParseObject);
}


/* Location:           C:\Users\dreadiscool\Desktop\tools\classes-dex2jar.jar
 * Qualified Name:     com.parse.ParseObjectEncodingStrategy
 * JD-Core Version:    0.7.0.1
 */