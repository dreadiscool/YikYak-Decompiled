package com.parse;

import m;

class OfflineQueryLogic$15
  implements OfflineQueryLogic.ConstraintMatcher<T>
{
  OfflineQueryLogic$15(OfflineQueryLogic paramOfflineQueryLogic, boolean paramBoolean, ParseUser paramParseUser, OfflineQueryLogic.ConstraintMatcher paramConstraintMatcher) {}
  
  public m<Boolean> matchesAsync(T paramT, ParseSQLiteDatabase paramParseSQLiteDatabase)
  {
    if ((!this.val$ignoreACLs) && (!OfflineQueryLogic.hasReadAccess(this.val$user, paramT))) {}
    for (m localm = m.a(Boolean.valueOf(false));; localm = this.val$constraintMatcher.matchesAsync(paramT, paramParseSQLiteDatabase)) {
      return localm;
    }
  }
}


/* Location:           C:\Users\dreadiscool\Desktop\tools\classes-dex2jar.jar
 * Qualified Name:     com.parse.OfflineQueryLogic.15
 * JD-Core Version:    0.7.0.1
 */