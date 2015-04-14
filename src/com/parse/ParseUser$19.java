package com.parse;

import k;
import l;
import m;
import org.json.JSONObject;

class ParseUser$19
  implements l<Object, m<JSONObject>>
{
  ParseUser$19(ParseUser paramParseUser, k paramk) {}
  
  public m<JSONObject> then(m<Object> paramm)
  {
    JSONObject localJSONObject = (JSONObject)paramm.e();
    return this.this$0.handleSaveResultAsync(localJSONObject, (ParseOperationSet)this.val$operations.a()).c(new ParseUser.19.1(this, localJSONObject));
  }
}


/* Location:           C:\Users\dreadiscool\Desktop\tools\classes-dex2jar.jar
 * Qualified Name:     com.parse.ParseUser.19
 * JD-Core Version:    0.7.0.1
 */