package com.parse;

import l;
import m;

class ParseQuery$10
  implements l<ParsePin, m<Integer>>
{
  ParseQuery$10(ParseQuery paramParseQuery, OfflineStore paramOfflineStore, ParseUser paramParseUser, boolean paramBoolean1, boolean paramBoolean2) {}
  
  public m<Integer> then(m<ParsePin> paramm)
  {
    ParsePin localParsePin = (ParsePin)paramm.e();
    return this.val$store.countAsync(this.this$0, this.val$user, localParsePin, this.val$includeIsDeletingEventually, this.val$ignoreACLs);
  }
}


/* Location:           C:\Users\dreadiscool\Desktop\tools\classes-dex2jar.jar
 * Qualified Name:     com.parse.ParseQuery.10
 * JD-Core Version:    0.7.0.1
 */