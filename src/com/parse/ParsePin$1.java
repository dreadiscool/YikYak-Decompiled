package com.parse;

import java.util.List;
import l;
import m;

final class ParsePin$1
  implements l<List<ParsePin>, ParsePin>
{
  ParsePin$1(String paramString) {}
  
  public ParsePin then(m<List<ParsePin>> paramm)
  {
    if ((paramm.e() != null) && (((List)paramm.e()).size() > 0)) {}
    for (ParsePin localParsePin = (ParsePin)((List)paramm.e()).get(0);; localParsePin = null)
    {
      if (localParsePin == null)
      {
        localParsePin = (ParsePin)ParseObject.create(ParsePin.class);
        localParsePin.setName(this.val$name);
      }
      return localParsePin;
    }
  }
}


/* Location:           C:\Users\dreadiscool\Desktop\tools\classes-dex2jar.jar
 * Qualified Name:     com.parse.ParsePin.1
 * JD-Core Version:    0.7.0.1
 */