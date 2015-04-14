package com.parse;

import l;
import m;
import org.json.JSONObject;

class ParseObject$13
  implements l<Object, m<Void>>
{
  ParseObject$13(ParseObject paramParseObject, ParseOperationSet paramParseOperationSet) {}
  
  public m<Void> then(m<Object> paramm)
  {
    JSONObject localJSONObject = (JSONObject)paramm.e();
    return this.this$0.handleSaveEventuallyResultAsync(localJSONObject, this.val$operationSet);
  }
}


/* Location:           C:\Users\dreadiscool\Desktop\tools\classes-dex2jar.jar
 * Qualified Name:     com.parse.ParseObject.13
 * JD-Core Version:    0.7.0.1
 */