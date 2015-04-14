package com.parse;

import k;
import l;
import m;

class OfflineStore$42
  implements l<Void, m<Void>>
{
  OfflineStore$42(OfflineStore paramOfflineStore, k paramk, ParseSQLiteDatabase paramParseSQLiteDatabase) {}
  
  public m<Void> then(m<Void> paramm)
  {
    String[] arrayOfString = new String[1];
    arrayOfString[0] = ((String)this.val$uuid.a());
    return this.val$db.deleteAsync("Dependencies", "uuid=?", arrayOfString);
  }
}


/* Location:           C:\Users\dreadiscool\Desktop\tools\classes-dex2jar.jar
 * Qualified Name:     com.parse.OfflineStore.42
 * JD-Core Version:    0.7.0.1
 */