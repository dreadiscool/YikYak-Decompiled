package com.parse;

import android.database.Cursor;
import java.util.List;
import l;
import m;

class OfflineStore$31
  implements l<Cursor, m<Void>>
{
  OfflineStore$31(OfflineStore paramOfflineStore, List paramList, ParseSQLiteDatabase paramParseSQLiteDatabase) {}
  
  public m<Void> then(m<Cursor> paramm)
  {
    Cursor localCursor = (Cursor)paramm.e();
    while (localCursor.moveToNext()) {
      this.val$uuidsToDelete.add(localCursor.getString(0));
    }
    return OfflineStore.access$1100(this.this$0, this.val$uuidsToDelete, this.val$db);
  }
}


/* Location:           C:\Users\dreadiscool\Desktop\tools\classes-dex2jar.jar
 * Qualified Name:     com.parse.OfflineStore.31
 * JD-Core Version:    0.7.0.1
 */