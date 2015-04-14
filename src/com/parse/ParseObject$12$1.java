package com.parse;

import l;
import m;

class ParseObject$12$1
  implements l<Void, Void>
{
  ParseObject$12$1(ParseObject.12 param12) {}
  
  public Void then(m<Void> paramm)
  {
    if (ParseObject.access$600(this.this$1.this$0, false).hasUnresolvedUser()) {
      throw new IllegalStateException("ACL has an unresolved ParseUser. Save or sign up before attempting to serialize the ACL.");
    }
    return null;
  }
}


/* Location:           C:\Users\dreadiscool\Desktop\tools\classes-dex2jar.jar
 * Qualified Name:     com.parse.ParseObject.12.1
 * JD-Core Version:    0.7.0.1
 */