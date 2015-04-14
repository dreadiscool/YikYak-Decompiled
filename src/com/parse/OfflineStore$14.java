package com.parse;

import l;
import m;

class OfflineStore$14
  implements l<ParseSQLiteDatabase, m<T>>
{
  OfflineStore$14(OfflineStore paramOfflineStore, ParseObject paramParseObject) {}
  
  public m<T> then(m<ParseSQLiteDatabase> paramm)
  {
    ParseSQLiteDatabase localParseSQLiteDatabase = (ParseSQLiteDatabase)paramm.e();
    return this.this$0.fetchLocallyAsync(this.val$object, localParseSQLiteDatabase).b(new OfflineStore.14.1(this, localParseSQLiteDatabase));
  }
}


/* Location:           C:\Users\dreadiscool\Desktop\tools\classes-dex2jar.jar
 * Qualified Name:     com.parse.OfflineStore.14
 * JD-Core Version:    0.7.0.1
 */