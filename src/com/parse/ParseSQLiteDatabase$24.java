package com.parse;

import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import l;
import m;

class ParseSQLiteDatabase$24
  implements l<Void, m<Cursor>>
{
  ParseSQLiteDatabase$24(ParseSQLiteDatabase paramParseSQLiteDatabase, String paramString, String[] paramArrayOfString) {}
  
  public m<Cursor> then(m<Void> paramm)
  {
    return m.a(ParseSQLiteDatabase.access$300(this.this$0).rawQuery(this.val$sql, this.val$args));
  }
}


/* Location:           C:\Users\dreadiscool\Desktop\tools\classes-dex2jar.jar
 * Qualified Name:     com.parse.ParseSQLiteDatabase.24
 * JD-Core Version:    0.7.0.1
 */