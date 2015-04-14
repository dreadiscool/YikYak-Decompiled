package com.parse;

import l;
import m;
import org.json.JSONObject;

final class ParseConfig$3
  implements l<Void, m<JSONObject>>
{
  ParseConfig$3(ParseCommand paramParseCommand) {}
  
  public m<JSONObject> then(m<Void> paramm)
  {
    return this.val$command.executeAsync().i();
  }
}


/* Location:           C:\Users\dreadiscool\Desktop\tools\classes-dex2jar.jar
 * Qualified Name:     com.parse.ParseConfig.3
 * JD-Core Version:    0.7.0.1
 */