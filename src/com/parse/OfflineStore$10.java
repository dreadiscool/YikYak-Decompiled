package com.parse;

import android.database.Cursor;
import k;
import l;
import m;

class OfflineStore$10
  implements l<String, m<Cursor>>
{
  OfflineStore$10(OfflineStore paramOfflineStore, k paramk, ParseSQLiteDatabase paramParseSQLiteDatabase, String[] paramArrayOfString) {}
  
  public m<Cursor> then(m<String> paramm)
  {
    this.val$uuid.a(paramm.e());
    String[] arrayOfString = new String[1];
    arrayOfString[0] = ((String)this.val$uuid.a());
    return this.val$db.queryAsync("ParseObjects", this.val$select, "uuid = ?", arrayOfString);
  }
}


/* Location:           C:\Users\dreadiscool\Desktop\tools\classes-dex2jar.jar
 * Qualified Name:     com.parse.OfflineStore.10
 * JD-Core Version:    0.7.0.1
 */