package com.parse;

import l;
import m;

class ParseQuery$2
  implements l<TResult, m<TResult>>
{
  ParseQuery$2(ParseQuery paramParseQuery, ParseQuery.CommandDelegate paramCommandDelegate) {}
  
  public m<TResult> then(m<TResult> paramm)
  {
    if ((paramm.d()) && ((paramm.f() instanceof ParseException)) && (((ParseException)paramm.f()).getCode() == 100)) {
      paramm = this.val$c.runFromCacheAsync();
    }
    return paramm;
  }
}


/* Location:           C:\Users\dreadiscool\Desktop\tools\classes-dex2jar.jar
 * Qualified Name:     com.parse.ParseQuery.2
 * JD-Core Version:    0.7.0.1
 */