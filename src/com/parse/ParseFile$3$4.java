package com.parse;

import l;
import m;

class ParseFile$3$4
  implements l<ParseCommand, m<Object>>
{
  ParseFile$3$4(ParseFile.3 param3) {}
  
  public m<Object> then(m<ParseCommand> paramm)
  {
    return ((ParseCommand)paramm.e()).executeAsync();
  }
}


/* Location:           C:\Users\dreadiscool\Desktop\tools\classes-dex2jar.jar
 * Qualified Name:     com.parse.ParseFile.3.4
 * JD-Core Version:    0.7.0.1
 */