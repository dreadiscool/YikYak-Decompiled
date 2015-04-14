package com.parse;

import l;
import m;

class OfflineStore$37
  implements l<ParseSQLiteDatabase, m<Void>>
{
  OfflineStore$37(OfflineStore paramOfflineStore, ParseObject paramParseObject) {}
  
  public m<Void> then(m<ParseSQLiteDatabase> paramm)
  {
    ParseSQLiteDatabase localParseSQLiteDatabase = (ParseSQLiteDatabase)paramm.e();
    return localParseSQLiteDatabase.beginTransactionAsync().d(new OfflineStore.37.1(this, localParseSQLiteDatabase));
  }
}


/* Location:           C:\Users\dreadiscool\Desktop\tools\classes-dex2jar.jar
 * Qualified Name:     com.parse.OfflineStore.37
 * JD-Core Version:    0.7.0.1
 */