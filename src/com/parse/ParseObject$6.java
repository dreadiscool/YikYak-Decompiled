package com.parse;

import java.util.Map;
import l;
import m;
import org.json.JSONObject;

class ParseObject$6
  implements l<Void, Void>
{
  ParseObject$6(ParseObject paramParseObject, Map paramMap, JSONObject paramJSONObject, ParseOperationSet paramParseOperationSet) {}
  
  public Void then(m<Void> paramm)
  {
    synchronized (this.this$0.mutex)
    {
      KnownParseObjectDecoder localKnownParseObjectDecoder = new KnownParseObjectDecoder(this.val$fetchedObjects);
      ParseObject.access$100(this.this$0, this.val$result, localKnownParseObjectDecoder, this.val$operationsBeforeSave);
      return null;
    }
  }
}


/* Location:           C:\Users\dreadiscool\Desktop\tools\classes-dex2jar.jar
 * Qualified Name:     com.parse.ParseObject.6
 * JD-Core Version:    0.7.0.1
 */