package com.parse;

import org.json.JSONObject;

class PointerEncodingStrategy
  extends PointerOrLocalIdEncodingStrategy
{
  private static final PointerEncodingStrategy instance = new PointerEncodingStrategy();
  
  public static PointerEncodingStrategy get()
  {
    return instance;
  }
  
  public JSONObject encodeRelatedObject(ParseObject paramParseObject)
  {
    if (paramParseObject.getObjectId() == null) {
      throw new IllegalStateException("unable to encode an association with an unsaved ParseObject");
    }
    return super.encodeRelatedObject(paramParseObject);
  }
}


/* Location:           C:\Users\dreadiscool\Desktop\tools\classes-dex2jar.jar
 * Qualified Name:     com.parse.PointerEncodingStrategy
 * JD-Core Version:    0.7.0.1
 */