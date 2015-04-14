package com.parse;

import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import l;
import m;

class ParseSQLiteDatabase$13
  implements l<Void, m<Cursor>>
{
  ParseSQLiteDatabase$13(ParseSQLiteDatabase paramParseSQLiteDatabase, String paramString1, String[] paramArrayOfString1, String paramString2, String[] paramArrayOfString2) {}
  
  public m<Cursor> then(m<Void> paramm)
  {
    return m.a(ParseSQLiteDatabase.access$300(this.this$0).query(this.val$table, this.val$select, this.val$where, this.val$args, null, null, null));
  }
}


/* Location:           C:\Users\dreadiscool\Desktop\tools\classes-dex2jar.jar
 * Qualified Name:     com.parse.ParseSQLiteDatabase.13
 * JD-Core Version:    0.7.0.1
 */