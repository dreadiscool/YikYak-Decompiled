package com.parse;

import android.content.ContentValues;
import android.database.sqlite.SQLiteDatabase;
import l;
import m;

class ParseSQLiteDatabase$19
  implements l<Void, m<Integer>>
{
  ParseSQLiteDatabase$19(ParseSQLiteDatabase paramParseSQLiteDatabase, String paramString1, ContentValues paramContentValues, String paramString2, String[] paramArrayOfString) {}
  
  public m<Integer> then(m<Void> paramm)
  {
    return m.a(Integer.valueOf(ParseSQLiteDatabase.access$300(this.this$0).update(this.val$table, this.val$values, this.val$where, this.val$args)));
  }
}


/* Location:           C:\Users\dreadiscool\Desktop\tools\classes-dex2jar.jar
 * Qualified Name:     com.parse.ParseSQLiteDatabase.19
 * JD-Core Version:    0.7.0.1
 */