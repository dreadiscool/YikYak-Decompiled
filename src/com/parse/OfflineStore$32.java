package com.parse;

import android.database.Cursor;
import l;
import m;

class OfflineStore$32
  implements l<Void, m<Cursor>>
{
  OfflineStore$32(OfflineStore paramOfflineStore, String paramString, ParseSQLiteDatabase paramParseSQLiteDatabase) {}
  
  public m<Cursor> then(m<Void> paramm)
  {
    String[] arrayOfString = new String[1];
    arrayOfString[0] = this.val$key;
    return this.val$db.rawQueryAsync("SELECT uuid FROM Dependencies WHERE key=? AND uuid IN ( SELECT uuid FROM Dependencies GROUP BY uuid HAVING COUNT(uuid)=1)", arrayOfString);
  }
}



/* Location:           C:\Users\dreadiscool\Desktop\tools\classes-dex2jar.jar

 * Qualified Name:     com.parse.OfflineStore.32

 * JD-Core Version:    0.7.0.1

 */