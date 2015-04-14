package com.parse;

import l;
import m;

class OfflineStore$19
  implements l<Void, m<ParseObject>>
{
  OfflineStore$19(OfflineStore paramOfflineStore, ParseObject paramParseObject, ParseSQLiteDatabase paramParseSQLiteDatabase) {}
  
  public m<ParseObject> then(m<Void> paramm)
  {
    return this.this$0.fetchLocallyAsync(this.val$object, this.val$db).b(new OfflineStore.19.1(this));
  }
}


/* Location:           C:\Users\dreadiscool\Desktop\tools\classes-dex2jar.jar
 * Qualified Name:     com.parse.OfflineStore.19
 * JD-Core Version:    0.7.0.1
 */