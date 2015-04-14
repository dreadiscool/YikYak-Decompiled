package com.parse;

import l;
import m;

class ParseObject$9
  implements l<Void, m<Void>>
{
  ParseObject$9(ParseObject paramParseObject) {}
  
  public m<Void> then(m<Void> paramm)
  {
    this.this$0.updateBeforeSave();
    return this.this$0.saveAsync(paramm);
  }
}


/* Location:           C:\Users\dreadiscool\Desktop\tools\classes-dex2jar.jar
 * Qualified Name:     com.parse.ParseObject.9
 * JD-Core Version:    0.7.0.1
 */