package com.parse;

import l;
import m;

class OfflineStore$28
  implements l<ParseSQLiteDatabase, m<Void>>
{
  OfflineStore$28(OfflineStore paramOfflineStore, String paramString) {}
  
  public m<Void> then(m<ParseSQLiteDatabase> paramm)
  {
    ParseSQLiteDatabase localParseSQLiteDatabase = (ParseSQLiteDatabase)paramm.e();
    return localParseSQLiteDatabase.beginTransactionAsync().d(new OfflineStore.28.1(this, localParseSQLiteDatabase));
  }
}


/* Location:           C:\Users\dreadiscool\Desktop\tools\classes-dex2jar.jar
 * Qualified Name:     com.parse.OfflineStore.28
 * JD-Core Version:    0.7.0.1
 */