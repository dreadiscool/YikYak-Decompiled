package com.parse;

import java.util.Map;

class KnownParseObjectDecoder
  extends ParseDecoder
{
  private Map<String, ParseObject> fetchedObjects;
  
  public KnownParseObjectDecoder(Map<String, ParseObject> paramMap)
  {
    this.fetchedObjects = paramMap;
  }
  
  protected ParseObject decodePointer(String paramString1, String paramString2)
  {
    if ((this.fetchedObjects != null) && (this.fetchedObjects.containsKey(paramString2))) {}
    for (ParseObject localParseObject = (ParseObject)this.fetchedObjects.get(paramString2);; localParseObject = super.decodePointer(paramString1, paramString2)) {
      return localParseObject;
    }
  }
}


/* Location:           C:\Users\dreadiscool\Desktop\tools\classes-dex2jar.jar
 * Qualified Name:     com.parse.KnownParseObjectDecoder
 * JD-Core Version:    0.7.0.1
 */