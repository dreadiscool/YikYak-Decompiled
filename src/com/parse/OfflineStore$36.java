package com.parse;

import k;
import l;
import m;

class OfflineStore$36
  implements l<String, m<Void>>
{
  OfflineStore$36(OfflineStore paramOfflineStore, k paramk1, ParseSQLiteDatabase paramParseSQLiteDatabase, k paramk2, ParseObject paramParseObject) {}
  
  public m<Void> then(m<String> paramm)
  {
    this.val$uuid.a(paramm.e());
    OfflineStore.OfflineEncodingStrategy localOfflineEncodingStrategy = new OfflineStore.OfflineEncodingStrategy(this.this$0, this.val$db);
    this.val$jsonObject.a(this.val$object.toRest(localOfflineEncodingStrategy));
    return localOfflineEncodingStrategy.whenFinished();
  }
}


/* Location:           C:\Users\dreadiscool\Desktop\tools\classes-dex2jar.jar
 * Qualified Name:     com.parse.OfflineStore.36
 * JD-Core Version:    0.7.0.1
 */