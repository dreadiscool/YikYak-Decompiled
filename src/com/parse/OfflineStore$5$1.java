package com.parse;

import java.util.List;
import l;
import m;

class OfflineStore$5$1
  implements l<List<T>, m<List<T>>>
{
  OfflineStore$5$1(OfflineStore.5 param5, ParseSQLiteDatabase paramParseSQLiteDatabase) {}
  
  public m<List<T>> then(m<List<T>> paramm)
  {
    this.val$db.close();
    return paramm;
  }
}


/* Location:           C:\Users\dreadiscool\Desktop\tools\classes-dex2jar.jar
 * Qualified Name:     com.parse.OfflineStore.5.1
 * JD-Core Version:    0.7.0.1
 */