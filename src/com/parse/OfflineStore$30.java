package com.parse;

import l;
import m;

class OfflineStore$30
  implements l<Void, m<Void>>
{
  OfflineStore$30(OfflineStore paramOfflineStore, String paramString, ParseSQLiteDatabase paramParseSQLiteDatabase) {}
  
  public m<Void> then(m<Void> paramm)
  {
    String[] arrayOfString = new String[1];
    arrayOfString[0] = this.val$key;
    return this.val$db.deleteAsync("Dependencies", "key=?", arrayOfString);
  }
}


/* Location:           C:\Users\dreadiscool\Desktop\tools\classes-dex2jar.jar
 * Qualified Name:     com.parse.OfflineStore.30
 * JD-Core Version:    0.7.0.1
 */