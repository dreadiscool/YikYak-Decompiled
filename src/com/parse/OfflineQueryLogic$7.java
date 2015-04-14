package com.parse;

import m;

class OfflineQueryLogic$7
  implements OfflineQueryLogic.ConstraintMatcher<T>
{
  OfflineQueryLogic$7(OfflineQueryLogic paramOfflineQueryLogic, OfflineQueryLogic.ConstraintMatcher paramConstraintMatcher) {}
  
  public m<Boolean> matchesAsync(T paramT, ParseSQLiteDatabase paramParseSQLiteDatabase)
  {
    return this.val$inQueryMatcher.matchesAsync(paramT, paramParseSQLiteDatabase).c(new OfflineQueryLogic.7.1(this));
  }
}


/* Location:           C:\Users\dreadiscool\Desktop\tools\classes-dex2jar.jar
 * Qualified Name:     com.parse.OfflineQueryLogic.7
 * JD-Core Version:    0.7.0.1
 */