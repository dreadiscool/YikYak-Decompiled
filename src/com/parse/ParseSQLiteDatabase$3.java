package com.parse;

import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import l;
import m;

class ParseSQLiteDatabase$3
  implements l<Void, m<SQLiteDatabase>>
{
  ParseSQLiteDatabase$3(ParseSQLiteDatabase paramParseSQLiteDatabase, SQLiteOpenHelper paramSQLiteOpenHelper) {}
  
  public m<SQLiteDatabase> then(m<Void> paramm)
  {
    if (ParseSQLiteDatabase.access$400(this.this$0)) {}
    for (SQLiteDatabase localSQLiteDatabase = this.val$helper.getWritableDatabase();; localSQLiteDatabase = this.val$helper.getReadableDatabase()) {
      return m.a(localSQLiteDatabase);
    }
  }
}


/* Location:           C:\Users\dreadiscool\Desktop\tools\classes-dex2jar.jar
 * Qualified Name:     com.parse.ParseSQLiteDatabase.3
 * JD-Core Version:    0.7.0.1
 */