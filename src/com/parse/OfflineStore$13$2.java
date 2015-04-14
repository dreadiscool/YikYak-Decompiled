package com.parse;

import java.util.Map;
import l;
import m;
import org.json.JSONObject;

class OfflineStore$13$2
  implements l<Void, Void>
{
  OfflineStore$13$2(OfflineStore.13 param13, JSONObject paramJSONObject, Map paramMap) {}
  
  public Void then(m<Void> paramm)
  {
    this.this$1.val$object.mergeREST(this.val$json, new OfflineStore.OfflineDecoder(this.this$1.this$0, this.val$offlineObjects, null));
    return null;
  }
}


/* Location:           C:\Users\dreadiscool\Desktop\tools\classes-dex2jar.jar
 * Qualified Name:     com.parse.OfflineStore.13.2
 * JD-Core Version:    0.7.0.1
 */