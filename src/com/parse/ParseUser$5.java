package com.parse;

import l;
import m;

class ParseUser$5
  implements l<ParseOperationSet, m<Void>>
{
  ParseUser$5(ParseUser paramParseUser, String paramString) {}
  
  public m<Void> then(m<ParseOperationSet> paramm)
  {
    ParseOperationSet localParseOperationSet = (ParseOperationSet)paramm.e();
    ParseCommand localParseCommand = ParseUser.access$200(this.this$0, localParseOperationSet, this.val$sessionToken);
    if (localParseCommand == null) {}
    for (m localm = m.a(null);; localm = localParseCommand.executeAsync().b(new ParseUser.5.1(this, localParseOperationSet))) {
      return localm;
    }
  }
}


/* Location:           C:\Users\dreadiscool\Desktop\tools\classes-dex2jar.jar
 * Qualified Name:     com.parse.ParseUser.5
 * JD-Core Version:    0.7.0.1
 */