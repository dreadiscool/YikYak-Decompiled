package com.parse;

import java.util.List;
import l;
import m;

class ParseQuery$8
  implements l<ParsePin, m<List<T>>>
{
  ParseQuery$8(ParseQuery paramParseQuery, OfflineStore paramOfflineStore, ParseUser paramParseUser, boolean paramBoolean1, boolean paramBoolean2) {}
  
  public m<List<T>> then(m<ParsePin> paramm)
  {
    ParsePin localParsePin = (ParsePin)paramm.e();
    return this.val$store.findAsync(this.this$0, this.val$user, localParsePin, this.val$includeIsDeletingEventually, this.val$ignoreACLs);
  }
}


/* Location:           C:\Users\dreadiscool\Desktop\tools\classes-dex2jar.jar
 * Qualified Name:     com.parse.ParseQuery.8
 * JD-Core Version:    0.7.0.1
 */