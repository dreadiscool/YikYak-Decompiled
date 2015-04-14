package com.parse;

import android.database.sqlite.SQLiteDatabase;
import l;
import m;
import y;

class ParseSQLiteDatabase$10
  implements l<Void, m<Void>>
{
  ParseSQLiteDatabase$10(ParseSQLiteDatabase paramParseSQLiteDatabase) {}
  
  public m<Void> then(m<Void> paramm)
  {
    try
    {
      ParseSQLiteDatabase.access$300(this.this$0).close();
      return ParseSQLiteDatabase.access$200(this.this$0).a();
    }
    finally
    {
      ParseSQLiteDatabase.access$200(this.this$0).b(null);
    }
  }
}


/* Location:           C:\Users\dreadiscool\Desktop\tools\classes-dex2jar.jar
 * Qualified Name:     com.parse.ParseSQLiteDatabase.10
 * JD-Core Version:    0.7.0.1
 */