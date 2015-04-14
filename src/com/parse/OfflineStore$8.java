package com.parse;

import android.database.Cursor;
import java.util.List;
import k;
import l;
import m;

class OfflineStore$8
  implements l<Cursor, m<Void>>
{
  OfflineStore$8(OfflineStore paramOfflineStore, OfflineQueryLogic paramOfflineQueryLogic, ParseQuery paramParseQuery, ParseUser paramParseUser, boolean paramBoolean, ParseSQLiteDatabase paramParseSQLiteDatabase, List paramList) {}
  
  public m<Void> then(m<Cursor> paramm)
  {
    Cursor localCursor = (Cursor)paramm.e();
    OfflineQueryLogic.ConstraintMatcher localConstraintMatcher = this.val$queryLogic.createMatcher(this.val$query, this.val$user, this.val$ignoreACLs);
    m localm = m.a(null);
    localCursor.moveToFirst();
    while (!localCursor.isAfterLast())
    {
      String str = localCursor.getString(0);
      k localk = new k();
      localm = localm.d(new OfflineStore.8.4(this, str)).d(new OfflineStore.8.3(this, localk)).d(new OfflineStore.8.2(this, localk, localConstraintMatcher)).c(new OfflineStore.8.1(this, localk));
      localCursor.moveToNext();
    }
    return localm;
  }
}


/* Location:           C:\Users\dreadiscool\Desktop\tools\classes-dex2jar.jar
 * Qualified Name:     com.parse.OfflineStore.8
 * JD-Core Version:    0.7.0.1
 */