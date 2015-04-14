package com.parse;

import android.database.Cursor;
import l;
import m;

class ParseSQLiteDatabase$12
  implements l<Cursor, m<Cursor>>
{
  ParseSQLiteDatabase$12(ParseSQLiteDatabase paramParseSQLiteDatabase) {}
  
  public m<Cursor> then(m<Cursor> paramm)
  {
    Cursor localCursor = (Cursor)paramm.e();
    return m.a(Integer.valueOf(localCursor.getCount())).b(new ParseSQLiteDatabase.12.1(this, localCursor));
  }
}


/* Location:           C:\Users\dreadiscool\Desktop\tools\classes-dex2jar.jar
 * Qualified Name:     com.parse.ParseSQLiteDatabase.12
 * JD-Core Version:    0.7.0.1
 */