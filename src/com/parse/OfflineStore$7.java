package com.parse;

import java.util.Iterator;
import java.util.List;
import l;
import m;

class OfflineStore$7
  implements l<Void, m<List<T>>>
{
  OfflineStore$7(OfflineStore paramOfflineStore, OfflineQueryLogic paramOfflineQueryLogic, List paramList, ParseQuery paramParseQuery, boolean paramBoolean, ParseSQLiteDatabase paramParseSQLiteDatabase) {}
  
  public m<List<T>> then(m<Void> paramm)
  {
    this.val$queryLogic.sort(this.val$results, this.val$query);
    List localList1 = this.val$results;
    int i = this.val$query.getSkip();
    if ((!this.val$isCount) && (i >= 0)) {
      localList1 = localList1.subList(Math.min(this.val$query.getSkip(), localList1.size()), localList1.size());
    }
    int j = this.val$query.getLimit();
    if ((!this.val$isCount) && (j >= 0) && (localList1.size() > j)) {}
    for (List localList2 = localList1.subList(0, j);; localList2 = localList1)
    {
      m localm1 = m.a(null);
      Iterator localIterator = localList2.iterator();
      for (m localm2 = localm1; localIterator.hasNext(); localm2 = localm2.d(new OfflineStore.7.1(this, (ParseObject)localIterator.next()))) {}
      return localm2.c(new OfflineStore.7.2(this, localList2));
    }
  }
}


/* Location:           C:\Users\dreadiscool\Desktop\tools\classes-dex2jar.jar
 * Qualified Name:     com.parse.OfflineStore.7
 * JD-Core Version:    0.7.0.1
 */