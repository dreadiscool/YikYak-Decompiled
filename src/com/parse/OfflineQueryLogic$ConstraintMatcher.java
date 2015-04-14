package com.parse;

import m;

abstract interface OfflineQueryLogic$ConstraintMatcher<T extends ParseObject>
{
  public abstract m<Boolean> matchesAsync(T paramT, ParseSQLiteDatabase paramParseSQLiteDatabase);
}


/* Location:           C:\Users\dreadiscool\Desktop\tools\classes-dex2jar.jar
 * Qualified Name:     com.parse.OfflineQueryLogic.ConstraintMatcher
 * JD-Core Version:    0.7.0.1
 */