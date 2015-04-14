package com.parse;

import android.database.Cursor;
import k;
import l;
import m;

class OfflineStore$40
  implements l<String, m<Cursor>>
{
  OfflineStore$40(OfflineStore paramOfflineStore, k paramk, ParseSQLiteDatabase paramParseSQLiteDatabase) {}
  
  public m<Cursor> then(m<String> paramm)
  {
    String[] arrayOfString1 = new String[1];
    arrayOfString1[0] = "key";
    String[] arrayOfString2 = new String[1];
    arrayOfString2[0] = ((String)this.val$uuid.a());
    return this.val$db.queryAsync("Dependencies", arrayOfString1, "uuid=?", arrayOfString2);
  }
}


/* Location:           C:\Users\dreadiscool\Desktop\tools\classes-dex2jar.jar
 * Qualified Name:     com.parse.OfflineStore.40
 * JD-Core Version:    0.7.0.1
 */