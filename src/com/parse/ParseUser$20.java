package com.parse;

import k;
import l;
import m;

class ParseUser$20
  implements l<ParseOperationSet, m<Object>>
{
  ParseUser$20(ParseUser paramParseUser, k paramk) {}
  
  public m<Object> then(m<ParseOperationSet> paramm)
  {
    this.val$operations.a(paramm.e());
    return ParseUser.access$900(this.this$0, (ParseOperationSet)this.val$operations.a()).executeAsync();
  }
}


/* Location:           C:\Users\dreadiscool\Desktop\tools\classes-dex2jar.jar
 * Qualified Name:     com.parse.ParseUser.20
 * JD-Core Version:    0.7.0.1
 */