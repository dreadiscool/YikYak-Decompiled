package com.parse;

import l;
import m;
import org.json.JSONObject;

class ParseObject$26
  implements l<ParseCommand, m<JSONObject>>
{
  ParseObject$26(ParseObject paramParseObject) {}
  
  public m<JSONObject> then(m<ParseCommand> paramm)
  {
    return ((ParseCommand)paramm.e()).executeAsync().i();
  }
}


/* Location:           C:\Users\dreadiscool\Desktop\tools\classes-dex2jar.jar
 * Qualified Name:     com.parse.ParseObject.26
 * JD-Core Version:    0.7.0.1
 */