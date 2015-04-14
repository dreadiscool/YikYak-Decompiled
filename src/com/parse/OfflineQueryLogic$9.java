package com.parse;

import m;

class OfflineQueryLogic$9
  implements OfflineQueryLogic.ConstraintMatcher<T>
{
  OfflineQueryLogic$9(OfflineQueryLogic paramOfflineQueryLogic, OfflineQueryLogic.ConstraintMatcher paramConstraintMatcher) {}
  
  public m<Boolean> matchesAsync(T paramT, ParseSQLiteDatabase paramParseSQLiteDatabase)
  {
    return this.val$selectMatcher.matchesAsync(paramT, paramParseSQLiteDatabase).c(new OfflineQueryLogic.9.1(this));
  }
}


/* Location:           C:\Users\dreadiscool\Desktop\tools\classes-dex2jar.jar
 * Qualified Name:     com.parse.OfflineQueryLogic.9
 * JD-Core Version:    0.7.0.1
 */