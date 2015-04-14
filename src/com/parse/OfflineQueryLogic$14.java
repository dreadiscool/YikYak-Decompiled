package com.parse;

import java.util.ArrayList;
import java.util.Iterator;
import m;

class OfflineQueryLogic$14
  implements OfflineQueryLogic.ConstraintMatcher<T>
{
  OfflineQueryLogic$14(OfflineQueryLogic paramOfflineQueryLogic, ArrayList paramArrayList) {}
  
  public m<Boolean> matchesAsync(T paramT, ParseSQLiteDatabase paramParseSQLiteDatabase)
  {
    m localm1 = m.a(Boolean.valueOf(true));
    Iterator localIterator = this.val$matchers.iterator();
    for (m localm2 = localm1; localIterator.hasNext(); localm2 = localm2.d(new OfflineQueryLogic.14.1(this, (OfflineQueryLogic.ConstraintMatcher)localIterator.next(), paramT, paramParseSQLiteDatabase))) {}
    return localm2;
  }
}


/* Location:           C:\Users\dreadiscool\Desktop\tools\classes-dex2jar.jar
 * Qualified Name:     com.parse.OfflineQueryLogic.14
 * JD-Core Version:    0.7.0.1
 */