package com.parse;

import java.util.Iterator;
import java.util.List;
import l;
import m;

class ParseObject$37$2$3$1
  implements l<Void, m<Void>>
{
  ParseObject$37$2$3$1(ParseObject.37.2.3 param3) {}
  
  public m<Void> then(m<Void> paramm)
  {
    Iterator localIterator = this.this$2.val$current.iterator();
    while (localIterator.hasNext())
    {
      ParseObject localParseObject = (ParseObject)localIterator.next();
      synchronized (localParseObject.mutex)
      {
        localParseObject.validateSave();
        this.this$2.val$operations.add(localParseObject.startSave());
      }
    }
    return paramm.b(new ParseObject.37.2.3.1.1(this));
  }
}


/* Location:           C:\Users\dreadiscool\Desktop\tools\classes-dex2jar.jar
 * Qualified Name:     com.parse.ParseObject.37.2.3.1
 * JD-Core Version:    0.7.0.1
 */