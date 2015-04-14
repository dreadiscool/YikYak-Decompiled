package com.parse;

import java.util.Iterator;
import java.util.List;

class OfflineQueryLogic$8
  extends OfflineQueryLogic.SubQueryMatcher<T>
{
  OfflineQueryLogic$8(OfflineQueryLogic paramOfflineQueryLogic, ParseQuery paramParseQuery, String paramString1, String paramString2)
  {
    super(paramOfflineQueryLogic, paramParseQuery);
  }
  
  protected boolean matches(T paramT, List<T> paramList)
  {
    Object localObject = OfflineQueryLogic.access$200(this.this$0, paramT, this.val$key);
    Iterator localIterator = paramList.iterator();
    ParseObject localParseObject;
    do
    {
      if (!localIterator.hasNext()) {
        break;
      }
      localParseObject = (ParseObject)localIterator.next();
    } while (!OfflineQueryLogic.access$400(localObject, OfflineQueryLogic.access$200(this.this$0, localParseObject, this.val$resultKey)));
    for (boolean bool = true;; bool = false) {
      return bool;
    }
  }
}


/* Location:           C:\Users\dreadiscool\Desktop\tools\classes-dex2jar.jar
 * Qualified Name:     com.parse.OfflineQueryLogic.8
 * JD-Core Version:    0.7.0.1
 */