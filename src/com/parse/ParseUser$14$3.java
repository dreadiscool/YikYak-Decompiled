package com.parse;

import l;
import m;
import org.json.JSONObject;

class ParseUser$14$3
  implements l<Object, m<Void>>
{
  ParseUser$14$3(ParseUser.14 param14, ParseUser paramParseUser, ParseOperationSet paramParseOperationSet) {}
  
  public m<Void> then(m<Object> paramm)
  {
    return this.val$user.handleSaveResultAsync((JSONObject)paramm.e(), this.val$operations);
  }
}


/* Location:           C:\Users\dreadiscool\Desktop\tools\classes-dex2jar.jar
 * Qualified Name:     com.parse.ParseUser.14.3
 * JD-Core Version:    0.7.0.1
 */