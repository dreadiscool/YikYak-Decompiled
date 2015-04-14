package com.parse;

import k;
import l;
import m;

class ParseObject$12
  implements l<Void, m<Void>>
{
  ParseObject$12(ParseObject paramParseObject, k paramk) {}
  
  public m<Void> then(m<Void> paramm)
  {
    synchronized (this.this$0.mutex)
    {
      this.this$0.validateSave();
      this.val$operations.a(this.this$0.startSave());
      if ((ParseObject.access$500(this.this$0, "ACL")) && (ParseObject.access$600(this.this$0, false) != null) && (ParseObject.access$600(this.this$0, false).hasUnresolvedUser())) {
        paramm = ParseUser.getCurrentUser().saveInBackground().c(new ParseObject.12.1(this));
      }
    }
    return paramm;
  }
}


/* Location:           C:\Users\dreadiscool\Desktop\tools\classes-dex2jar.jar
 * Qualified Name:     com.parse.ParseObject.12
 * JD-Core Version:    0.7.0.1
 */