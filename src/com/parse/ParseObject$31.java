package com.parse;

import l;
import m;

class ParseObject$31
  implements l<Void, m<Void>>
{
  ParseObject$31(ParseObject paramParseObject) {}
  
  public m<Void> then(m<Void> paramm)
  {
    synchronized (this.this$0.mutex)
    {
      this.this$0.validateDelete();
      if (ParseObject.access$000(this.this$0) == null) {
        paramm = null;
      }
    }
    return paramm;
  }
}


/* Location:           C:\Users\dreadiscool\Desktop\tools\classes-dex2jar.jar
 * Qualified Name:     com.parse.ParseObject.31
 * JD-Core Version:    0.7.0.1
 */