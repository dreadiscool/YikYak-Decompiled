package com.parse;

import l;
import m;

class OfflineStore$20$1
  implements l<Void, m<Void>>
{
  OfflineStore$20$1(OfflineStore.20 param20, ParseSQLiteDatabase paramParseSQLiteDatabase) {}
  
  public m<Void> then(m<Void> paramm)
  {
    this.val$db.endTransactionAsync();
    this.val$db.close();
    return paramm;
  }
}


/* Location:           C:\Users\dreadiscool\Desktop\tools\classes-dex2jar.jar
 * Qualified Name:     com.parse.OfflineStore.20.1
 * JD-Core Version:    0.7.0.1
 */