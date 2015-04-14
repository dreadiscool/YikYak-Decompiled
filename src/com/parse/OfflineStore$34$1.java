package com.parse;

import l;
import m;

class OfflineStore$34$1
  implements l<ParseSQLiteDatabase, m<Void>>
{
  OfflineStore$34$1(OfflineStore.34 param34) {}
  
  public m<Void> then(m<ParseSQLiteDatabase> paramm)
  {
    ParseSQLiteDatabase localParseSQLiteDatabase = (ParseSQLiteDatabase)paramm.e();
    return localParseSQLiteDatabase.beginTransactionAsync().d(new OfflineStore.34.1.1(this, localParseSQLiteDatabase));
  }
}


/* Location:           C:\Users\dreadiscool\Desktop\tools\classes-dex2jar.jar
 * Qualified Name:     com.parse.OfflineStore.34.1
 * JD-Core Version:    0.7.0.1
 */