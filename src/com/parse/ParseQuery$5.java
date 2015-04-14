package com.parse;

import java.util.List;
import l;
import m;

class ParseQuery$5
  implements l<List<T>, T>
{
  ParseQuery$5(ParseQuery paramParseQuery) {}
  
  public T then(m<List<T>> paramm)
  {
    if (paramm.d()) {
      throw paramm.f();
    }
    if ((paramm.e() != null) && (((List)paramm.e()).size() > 0)) {
      return (ParseObject)((List)paramm.e()).get(0);
    }
    throw new ParseException(101, "no results found for query");
  }
}


/* Location:           C:\Users\dreadiscool\Desktop\tools\classes-dex2jar.jar
 * Qualified Name:     com.parse.ParseQuery.5
 * JD-Core Version:    0.7.0.1
 */