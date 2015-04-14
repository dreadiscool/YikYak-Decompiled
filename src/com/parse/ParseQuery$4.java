package com.parse;

import java.util.List;
import m;

class ParseQuery$4
  implements ParseQuery.CommandDelegate<List<T>>
{
  ParseQuery$4(ParseQuery paramParseQuery, ParseUser paramParseUser) {}
  
  public m<List<T>> runFromCacheAsync()
  {
    return this.this$0.findFromCacheAsync(this.val$user, false, ParseQuery.access$100(this.this$0));
  }
  
  public m<List<T>> runOnNetworkAsync(boolean paramBoolean)
  {
    return ParseQuery.access$300(this.this$0, paramBoolean);
  }
}


/* Location:           C:\Users\dreadiscool\Desktop\tools\classes-dex2jar.jar
 * Qualified Name:     com.parse.ParseQuery.4
 * JD-Core Version:    0.7.0.1
 */