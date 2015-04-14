package com.parse;

import java.util.Map;
import m;
import org.json.JSONObject;

class OfflineStore$OfflineDecoder
  extends ParseDecoder
{
  private Map<String, m<ParseObject>> offlineObjects;
  
  private OfflineStore$OfflineDecoder(Map<String, m<ParseObject>> paramMap)
  {
    Object localObject;
    this.offlineObjects = localObject;
  }
  
  public Object decode(Object paramObject)
  {
    String str;
    if (((paramObject instanceof JSONObject)) && (((JSONObject)paramObject).optString("__type").equals("OfflineObject"))) {
      str = ((JSONObject)paramObject).optString("uuid");
    }
    for (Object localObject = ((m)this.offlineObjects.get(str)).e();; localObject = super.decode(paramObject)) {
      return localObject;
    }
  }
}


/* Location:           C:\Users\dreadiscool\Desktop\tools\classes-dex2jar.jar
 * Qualified Name:     com.parse.OfflineStore.OfflineDecoder
 * JD-Core Version:    0.7.0.1
 */