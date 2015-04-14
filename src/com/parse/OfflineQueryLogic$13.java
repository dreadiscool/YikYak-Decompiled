package com.parse;

import m;

class OfflineQueryLogic$13
  implements OfflineQueryLogic.ConstraintMatcher<T>
{
  OfflineQueryLogic$13(OfflineQueryLogic paramOfflineQueryLogic, String paramString, Object paramObject) {}
  
  public m<Boolean> matchesAsync(T paramT, ParseSQLiteDatabase paramParseSQLiteDatabase)
  {
    try
    {
      Object localObject = OfflineQueryLogic.access$200(this.this$0, paramT, this.val$key);
      localm = m.a(Boolean.valueOf(OfflineQueryLogic.access$400(this.val$queryConstraintValue, localObject)));
    }
    catch (ParseException localParseException)
    {
      for (;;)
      {
        m localm = m.a(localParseException);
      }
    }
    return localm;
  }
}


/* Location:           C:\Users\dreadiscool\Desktop\tools\classes-dex2jar.jar
 * Qualified Name:     com.parse.OfflineQueryLogic.13
 * JD-Core Version:    0.7.0.1
 */