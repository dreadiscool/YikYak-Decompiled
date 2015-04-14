package com.parse;

import java.util.List;
import m;

abstract class OfflineQueryLogic$SubQueryMatcher<T extends ParseObject>
  implements OfflineQueryLogic.ConstraintMatcher<T>
{
  private final ParseQuery<T> subQuery;
  private m<List<T>> subQueryResults = null;
  
  public OfflineQueryLogic$SubQueryMatcher(ParseQuery<T> paramParseQuery)
  {
    Object localObject;
    this.subQuery = localObject;
  }
  
  protected abstract boolean matches(T paramT, List<T> paramList);
  
  public m<Boolean> matchesAsync(T paramT, ParseSQLiteDatabase paramParseSQLiteDatabase)
  {
    if (this.subQueryResults == null)
    {
      ParseUser localParseUser = ParseUser.getCurrentUser();
      this.subQueryResults = OfflineQueryLogic.access$100(this.this$0).findAsync(this.subQuery, localParseUser, null, false, false, false, paramParseSQLiteDatabase);
    }
    return this.subQueryResults.c(new OfflineQueryLogic.SubQueryMatcher.1(this, paramT));
  }
}


/* Location:           C:\Users\dreadiscool\Desktop\tools\classes-dex2jar.jar
 * Qualified Name:     com.parse.OfflineQueryLogic.SubQueryMatcher
 * JD-Core Version:    0.7.0.1
 */