package com.parse;

import java.util.List;

class OfflineQueryLogic$6
  extends OfflineQueryLogic.SubQueryMatcher<T>
{
  OfflineQueryLogic$6(OfflineQueryLogic paramOfflineQueryLogic, ParseQuery paramParseQuery, String paramString)
  {
    super(paramOfflineQueryLogic, paramParseQuery);
  }
  
  protected boolean matches(T paramT, List<T> paramList)
  {
    return OfflineQueryLogic.access$300(paramList, OfflineQueryLogic.access$200(this.this$0, paramT, this.val$key));
  }
}


/* Location:           C:\Users\dreadiscool\Desktop\tools\classes-dex2jar.jar
 * Qualified Name:     com.parse.OfflineQueryLogic.6
 * JD-Core Version:    0.7.0.1
 */