package com.parse;

import android.database.sqlite.SQLiteDatabase;
import l;
import m;

class ParseSQLiteDatabase$21
  implements l<Void, m<Integer>>
{
  ParseSQLiteDatabase$21(ParseSQLiteDatabase paramParseSQLiteDatabase, String paramString1, String paramString2, String[] paramArrayOfString) {}
  
  public m<Integer> then(m<Void> paramm)
  {
    return m.a(Integer.valueOf(ParseSQLiteDatabase.access$300(this.this$0).delete(this.val$table, this.val$where, this.val$args)));
  }
}


/* Location:           C:\Users\dreadiscool\Desktop\tools\classes-dex2jar.jar
 * Qualified Name:     com.parse.ParseSQLiteDatabase.21
 * JD-Core Version:    0.7.0.1
 */