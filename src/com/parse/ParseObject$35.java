package com.parse;

import java.util.IdentityHashMap;
import java.util.List;

final class ParseObject$35
  extends ParseTraverser
{
  ParseObject$35(List paramList1, IdentityHashMap paramIdentityHashMap1, IdentityHashMap paramIdentityHashMap2, List paramList2) {}
  
  protected boolean visit(Object paramObject)
  {
    if ((paramObject instanceof ParseFile))
    {
      ParseFile localParseFile = (ParseFile)paramObject;
      if (localParseFile.getUrl() == null) {
        this.val$dirtyFiles.add(localParseFile);
      }
    }
    label180:
    for (;;)
    {
      return true;
      if ((paramObject instanceof ParseObject))
      {
        ParseObject localParseObject = (ParseObject)paramObject;
        IdentityHashMap localIdentityHashMap1 = this.val$alreadySeen;
        IdentityHashMap localIdentityHashMap2 = this.val$alreadySeenNew;
        IdentityHashMap localIdentityHashMap3;
        if (localParseObject.getObjectId() != null) {
          localIdentityHashMap3 = new IdentityHashMap();
        }
        for (;;)
        {
          if (localIdentityHashMap1.containsKey(localParseObject)) {
            break label180;
          }
          IdentityHashMap localIdentityHashMap4 = new IdentityHashMap(localIdentityHashMap1);
          localIdentityHashMap4.put(localParseObject, localParseObject);
          ParseObject.access$1300(ParseObject.access$300(localParseObject), this.val$dirtyChildren, this.val$dirtyFiles, localIdentityHashMap4, localIdentityHashMap3);
          if (!localParseObject.isDirty(false)) {
            break;
          }
          this.val$dirtyChildren.add(localParseObject);
          break;
          if (localIdentityHashMap2.containsKey(localParseObject)) {
            throw new RuntimeException("Found a circular dependency while saving.");
          }
          localIdentityHashMap3 = new IdentityHashMap(localIdentityHashMap2);
          localIdentityHashMap3.put(localParseObject, localParseObject);
        }
      }
    }
  }
}


/* Location:           C:\Users\dreadiscool\Desktop\tools\classes-dex2jar.jar
 * Qualified Name:     com.parse.ParseObject.35
 * JD-Core Version:    0.7.0.1
 */