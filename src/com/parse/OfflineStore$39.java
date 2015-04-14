package com.parse;

import android.database.Cursor;
import java.util.ArrayList;
import java.util.List;
import l;
import m;

class OfflineStore$39
  implements l<Cursor, m<Void>>
{
  OfflineStore$39(OfflineStore paramOfflineStore, ParseSQLiteDatabase paramParseSQLiteDatabase, ParseObject paramParseObject) {}
  
  public m<Void> then(m<Cursor> paramm)
  {
    Cursor localCursor = (Cursor)paramm.e();
    ArrayList localArrayList = new ArrayList();
    localCursor.moveToFirst();
    while (!localCursor.isAfterLast())
    {
      String str = localCursor.getString(0);
      localArrayList.add(OfflineStore.access$600(this.this$0, str, this.val$db).d(new OfflineStore.39.2(this)).b(new OfflineStore.39.1(this, str)));
      localCursor.moveToNext();
    }
    return m.a(localArrayList);
  }
}


/* Location:           C:\Users\dreadiscool\Desktop\tools\classes-dex2jar.jar
 * Qualified Name:     com.parse.OfflineStore.39
 * JD-Core Version:    0.7.0.1
 */