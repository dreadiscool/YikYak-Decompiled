package com.parse;

import java.util.Map;
import org.json.JSONObject;

class OfflineStore$13$1
  extends ParseTraverser
{
  OfflineStore$13$1(OfflineStore.13 param13, Map paramMap) {}
  
  protected boolean visit(Object paramObject)
  {
    if (((paramObject instanceof JSONObject)) && (((JSONObject)paramObject).optString("__type").equals("OfflineObject")))
    {
      String str = ((JSONObject)paramObject).optString("uuid");
      this.val$offlineObjects.put(str, OfflineStore.access$600(this.this$1.this$0, str, this.this$1.val$db));
    }
    return true;
  }
}


/* Location:           C:\Users\dreadiscool\Desktop\tools\classes-dex2jar.jar
 * Qualified Name:     com.parse.OfflineStore.13.1
 * JD-Core Version:    0.7.0.1
 */