package com.parse;

import l;
import m;

class ParseObject$16
  implements l<Void, m<Object>>
{
  ParseObject$16(ParseObject paramParseObject, ParseCommand paramParseCommand) {}
  
  public m<Object> then(m<Void> paramm)
  {
    return Parse.getEventuallyQueue().enqueueEventuallyAsync(this.val$command, this.this$0);
  }
}


/* Location:           C:\Users\dreadiscool\Desktop\tools\classes-dex2jar.jar
 * Qualified Name:     com.parse.ParseObject.16
 * JD-Core Version:    0.7.0.1
 */