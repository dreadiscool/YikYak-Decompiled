package com.parse;

import m;

class OfflineQueryLogic$10
  implements OfflineQueryLogic.ConstraintMatcher<T>
{
  OfflineQueryLogic$10(OfflineQueryLogic paramOfflineQueryLogic, String paramString1, String paramString2, Object paramObject, ParseQuery.KeyConstraints paramKeyConstraints) {}
  
  public m<Boolean> matchesAsync(T paramT, ParseSQLiteDatabase paramParseSQLiteDatabase)
  {
    try
    {
      Object localObject = OfflineQueryLogic.access$200(this.this$0, paramT, this.val$key);
      m localm2 = m.a(Boolean.valueOf(OfflineQueryLogic.access$500(this.val$operator, this.val$constraint, localObject, this.val$allKeyConstraints)));
      localm1 = localm2;
    }
    catch (ParseException localParseException)
    {
      for (;;)
      {
        m localm1 = m.a(localParseException);
      }
    }
    return localm1;
  }
}


/* Location:           C:\Users\dreadiscool\Desktop\tools\classes-dex2jar.jar
 * Qualified Name:     com.parse.OfflineQueryLogic.10
 * JD-Core Version:    0.7.0.1
 */