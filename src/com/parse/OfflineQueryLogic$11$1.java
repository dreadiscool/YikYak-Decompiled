package com.parse;

import l;
import m;

class OfflineQueryLogic$11$1
  implements l<Boolean, m<Boolean>>
{
  OfflineQueryLogic$11$1(OfflineQueryLogic.11 param11, OfflineQueryLogic.ConstraintMatcher paramConstraintMatcher, ParseObject paramParseObject, ParseSQLiteDatabase paramParseSQLiteDatabase) {}
  
  public m<Boolean> then(m<Boolean> paramm)
  {
    if (((Boolean)paramm.e()).booleanValue()) {}
    for (;;)
    {
      return paramm;
      paramm = this.val$matcher.matchesAsync(this.val$object, this.val$db);
    }
  }
}


/* Location:           C:\Users\dreadiscool\Desktop\tools\classes-dex2jar.jar
 * Qualified Name:     com.parse.OfflineQueryLogic.11.1
 * JD-Core Version:    0.7.0.1
 */