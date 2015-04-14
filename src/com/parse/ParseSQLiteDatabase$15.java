package com.parse;

import android.content.ContentValues;
import android.database.sqlite.SQLiteDatabase;
import l;
import m;

class ParseSQLiteDatabase$15
  implements l<Void, m<Long>>
{
  ParseSQLiteDatabase$15(ParseSQLiteDatabase paramParseSQLiteDatabase, String paramString, ContentValues paramContentValues, int paramInt) {}
  
  public m<Long> then(m<Void> paramm)
  {
    return m.a(Long.valueOf(ParseSQLiteDatabase.access$300(this.this$0).insertWithOnConflict(this.val$table, null, this.val$values, this.val$conflictAlgorithm)));
  }
}


/* Location:           C:\Users\dreadiscool\Desktop\tools\classes-dex2jar.jar
 * Qualified Name:     com.parse.ParseSQLiteDatabase.15
 * JD-Core Version:    0.7.0.1
 */