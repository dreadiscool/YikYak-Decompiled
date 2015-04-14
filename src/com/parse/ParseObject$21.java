package com.parse;

import java.util.Map;
import l;
import m;
import org.json.JSONObject;

class ParseObject$21
  implements l<Void, m<Void>>
{
  ParseObject$21(ParseObject paramParseObject, Map paramMap, JSONObject paramJSONObject) {}
  
  public m<Void> then(m<Void> paramm)
  {
    synchronized (this.this$0.mutex)
    {
      ParseObject.access$700(this.this$0).clear();
      ParseObject.access$800(this.this$0).clear();
      KnownParseObjectDecoder localKnownParseObjectDecoder = new KnownParseObjectDecoder(this.val$fetchedObjects);
      this.this$0.mergeAfterFetch(this.val$result, localKnownParseObjectDecoder, true);
      return null;
    }
  }
}


/* Location:           C:\Users\dreadiscool\Desktop\tools\classes-dex2jar.jar
 * Qualified Name:     com.parse.ParseObject.21
 * JD-Core Version:    0.7.0.1
 */