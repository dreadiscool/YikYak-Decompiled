package com.parse;

import android.content.ContentValues;
import k;
import l;
import m;

class OfflineStore$15
  implements l<Void, m<Void>>
{
  OfflineStore$15(OfflineStore paramOfflineStore, String paramString, k paramk, ParseSQLiteDatabase paramParseSQLiteDatabase) {}
  
  public m<Void> then(m<Void> paramm)
  {
    ContentValues localContentValues = new ContentValues();
    localContentValues.put("key", this.val$key);
    localContentValues.put("uuid", (String)this.val$uuid.a());
    return this.val$db.insertWithOnConflict("Dependencies", localContentValues, 4);
  }
}


/* Location:           C:\Users\dreadiscool\Desktop\tools\classes-dex2jar.jar
 * Qualified Name:     com.parse.OfflineStore.15
 * JD-Core Version:    0.7.0.1
 */