package com.parse;

import k;
import l;
import m;
import org.json.JSONObject;

class ParseObject$10$1
  implements l<Object, m<Void>>
{
  ParseObject$10$1(ParseObject.10 param10) {}
  
  public m<Void> then(m<Object> paramm)
  {
    JSONObject localJSONObject = (JSONObject)paramm.e();
    return this.this$1.this$0.handleSaveResultAsync(localJSONObject, (ParseOperationSet)this.this$1.val$operations.a()).b(new ParseObject.10.1.1(this, paramm));
  }
}


/* Location:           C:\Users\dreadiscool\Desktop\tools\classes-dex2jar.jar
 * Qualified Name:     com.parse.ParseObject.10.1
 * JD-Core Version:    0.7.0.1
 */