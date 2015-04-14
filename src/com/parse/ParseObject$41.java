package com.parse;

import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import l;
import m;

final class ParseObject$41
  implements l<List<T>, List<T>>
{
  ParseObject$41(List paramList) {}
  
  public List<T> then(m<List<T>> paramm)
  {
    HashMap localHashMap = new HashMap();
    Iterator localIterator1 = ((List)paramm.e()).iterator();
    while (localIterator1.hasNext())
    {
      ParseObject localParseObject3 = (ParseObject)localIterator1.next();
      localHashMap.put(localParseObject3.getObjectId(), localParseObject3);
    }
    Iterator localIterator2 = this.val$objects.iterator();
    while (localIterator2.hasNext())
    {
      ParseObject localParseObject1 = (ParseObject)localIterator2.next();
      ParseObject localParseObject2 = (ParseObject)localHashMap.get(localParseObject1.getObjectId());
      if (localParseObject2 == null) {
        throw new RuntimeException("Object id " + localParseObject1.getObjectId() + " does not exist");
      }
      localParseObject1.mergeFromObject(localParseObject2);
      localParseObject1.hasBeenFetched = true;
    }
    return this.val$objects;
  }
}


/* Location:           C:\Users\dreadiscool\Desktop\tools\classes-dex2jar.jar
 * Qualified Name:     com.parse.ParseObject.41
 * JD-Core Version:    0.7.0.1
 */