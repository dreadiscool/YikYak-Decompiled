package com.parse;

import m;

class ParseQuery$3
  implements ParseQuery.CommandDelegate<Integer>
{
  ParseQuery$3(ParseQuery paramParseQuery, ParseUser paramParseUser) {}
  
  public m<Integer> runFromCacheAsync()
  {
    return ParseQuery.access$200(this.this$0, this.val$user, false, ParseQuery.access$100(this.this$0));
  }
  
  public m<Integer> runOnNetworkAsync(boolean paramBoolean)
  {
    return ParseQuery.access$000(this.this$0);
  }
}


/* Location:           C:\Users\dreadiscool\Desktop\tools\classes-dex2jar.jar
 * Qualified Name:     com.parse.ParseQuery.3
 * JD-Core Version:    0.7.0.1
 */