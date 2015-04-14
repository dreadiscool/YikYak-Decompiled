package com.parse;

import l;
import m;
import org.json.JSONObject;

class ParseQuery$18
  implements l<Object, Integer>
{
  ParseQuery$18(ParseQuery paramParseQuery) {}
  
  public Integer then(m<Object> paramm)
  {
    return Integer.valueOf(((JSONObject)paramm.e()).optInt("count"));
  }
}


/* Location:           C:\Users\dreadiscool\Desktop\tools\classes-dex2jar.jar
 * Qualified Name:     com.parse.ParseQuery.18
 * JD-Core Version:    0.7.0.1
 */