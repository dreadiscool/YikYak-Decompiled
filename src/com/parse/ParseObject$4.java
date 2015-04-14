package com.parse;

import java.util.Map;

class ParseObject$4
  extends ParseTraverser
{
  ParseObject$4(ParseObject paramParseObject, Map paramMap) {}
  
  protected boolean visit(Object paramObject)
  {
    if ((paramObject instanceof ParseObject))
    {
      ParseObject localParseObject = (ParseObject)paramObject;
      if ((ParseObject.access$000(localParseObject) != null) && (localParseObject.isDataAvailable())) {
        this.val$fetchedObjects.put(ParseObject.access$000(localParseObject), localParseObject);
      }
    }
    return true;
  }
}


/* Location:           C:\Users\dreadiscool\Desktop\tools\classes-dex2jar.jar
 * Qualified Name:     com.parse.ParseObject.4
 * JD-Core Version:    0.7.0.1
 */