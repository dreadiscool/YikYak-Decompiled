package com.parse;

import m;

class OfflineQueryLogic$12
  implements OfflineQueryLogic.ConstraintMatcher<T>
{
  OfflineQueryLogic$12(OfflineQueryLogic paramOfflineQueryLogic, ParseQuery.RelationConstraint paramRelationConstraint) {}
  
  public m<Boolean> matchesAsync(T paramT, ParseSQLiteDatabase paramParseSQLiteDatabase)
  {
    return m.a(Boolean.valueOf(this.val$relation.getRelation().hasKnownObject(paramT)));
  }
}


/* Location:           C:\Users\dreadiscool\Desktop\tools\classes-dex2jar.jar
 * Qualified Name:     com.parse.OfflineQueryLogic.12
 * JD-Core Version:    0.7.0.1
 */