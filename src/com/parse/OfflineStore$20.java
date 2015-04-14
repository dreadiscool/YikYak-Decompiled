package com.parse;

import l;
import m;

class OfflineStore$20
  implements l<ParseSQLiteDatabase, m<Void>>
{
  OfflineStore$20(OfflineStore paramOfflineStore, ParseObject paramParseObject, boolean paramBoolean) {}
  
  public m<Void> then(m<ParseSQLiteDatabase> paramm)
  {
    ParseSQLiteDatabase localParseSQLiteDatabase = (ParseSQLiteDatabase)paramm.e();
    return localParseSQLiteDatabase.beginTransactionAsync().d(new OfflineStore.20.3(this, localParseSQLiteDatabase)).d(new OfflineStore.20.2(this, localParseSQLiteDatabase)).b(new OfflineStore.20.1(this, localParseSQLiteDatabase));
  }
}


/* Location:           C:\Users\dreadiscool\Desktop\tools\classes-dex2jar.jar
 * Qualified Name:     com.parse.OfflineStore.20
 * JD-Core Version:    0.7.0.1
 */