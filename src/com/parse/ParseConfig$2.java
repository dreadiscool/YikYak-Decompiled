package com.parse;

import l;
import m;
import org.json.JSONObject;

final class ParseConfig$2
  implements l<JSONObject, ParseConfig>
{
  public ParseConfig then(m<JSONObject> paramm)
  {
    ParseConfig localParseConfig1 = new ParseConfig((JSONObject)paramm.e(), new ParseDecoder());
    ParseConfig.access$100(localParseConfig1, Parse.applicationContext, "currentConfig");
    synchronized (ParseConfig.access$200())
    {
      ParseConfig.access$302(localParseConfig1);
      ParseConfig localParseConfig2 = ParseConfig.access$300();
      return localParseConfig2;
    }
  }
}


/* Location:           C:\Users\dreadiscool\Desktop\tools\classes-dex2jar.jar
 * Qualified Name:     com.parse.ParseConfig.2
 * JD-Core Version:    0.7.0.1
 */