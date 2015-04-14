package com.parse;

import android.content.ContentValues;
import android.database.sqlite.SQLiteDatabase;
import l;
import m;

class ParseSQLiteDatabase$17
  implements l<Void, m<Long>>
{
  ParseSQLiteDatabase$17(ParseSQLiteDatabase paramParseSQLiteDatabase, String paramString, ContentValues paramContentValues) {}
  
  public m<Long> then(m<Void> paramm)
  {
    return m.a(Long.valueOf(ParseSQLiteDatabase.access$300(this.this$0).insertOrThrow(this.val$table, null, this.val$values)));
  }
}


/* Location:           C:\Users\dreadiscool\Desktop\tools\classes-dex2jar.jar
 * Qualified Name:     com.parse.ParseSQLiteDatabase.17
 * JD-Core Version:    0.7.0.1
 */