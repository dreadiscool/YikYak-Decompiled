package com.parse;

import l;
import m;

class ParseQuery$1
  implements l<TResult, m<TResult>>
{
  ParseQuery$1(ParseQuery paramParseQuery, ParseQuery.CommandDelegate paramCommandDelegate) {}
  
  public m<TResult> then(m<TResult> paramm)
  {
    if ((paramm.d()) && ((paramm.f() instanceof ParseException))) {
      paramm = this.val$c.runOnNetworkAsync(true);
    }
    return paramm;
  }
}


/* Location:           C:\Users\dreadiscool\Desktop\tools\classes-dex2jar.jar
 * Qualified Name:     com.parse.ParseQuery.1
 * JD-Core Version:    0.7.0.1
 */