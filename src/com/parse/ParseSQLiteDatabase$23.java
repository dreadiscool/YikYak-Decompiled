package com.parse;

import android.database.Cursor;
import l;
import m;

class ParseSQLiteDatabase$23
  implements l<Cursor, m<Cursor>>
{
  ParseSQLiteDatabase$23(ParseSQLiteDatabase paramParseSQLiteDatabase) {}
  
  public m<Cursor> then(m<Cursor> paramm)
  {
    Cursor localCursor = (Cursor)paramm.e();
    return m.a(Integer.valueOf(localCursor.getCount())).b(new ParseSQLiteDatabase.23.1(this, localCursor));
  }
}


/* Location:           C:\Users\dreadiscool\Desktop\tools\classes-dex2jar.jar
 * Qualified Name:     com.parse.ParseSQLiteDatabase.23
 * JD-Core Version:    0.7.0.1
 */