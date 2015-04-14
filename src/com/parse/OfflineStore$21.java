package com.parse;

import java.util.ArrayList;

class OfflineStore$21
  extends ParseTraverser
{
  OfflineStore$21(OfflineStore paramOfflineStore, ArrayList paramArrayList) {}
  
  protected boolean visit(Object paramObject)
  {
    if ((paramObject instanceof ParseObject)) {
      this.val$objectsInTree.add((ParseObject)paramObject);
    }
    return true;
  }
}


/* Location:           C:\Users\dreadiscool\Desktop\tools\classes-dex2jar.jar
 * Qualified Name:     com.parse.OfflineStore.21
 * JD-Core Version:    0.7.0.1
 */