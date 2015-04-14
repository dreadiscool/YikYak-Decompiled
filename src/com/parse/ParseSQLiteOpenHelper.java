package com.parse;

import android.annotation.TargetApi;
import android.content.Context;
import android.database.DatabaseErrorHandler;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteDatabase.CursorFactory;
import android.database.sqlite.SQLiteOpenHelper;
import m;

abstract class ParseSQLiteOpenHelper
{
  private final SQLiteOpenHelper helper;
  
  public ParseSQLiteOpenHelper(Context paramContext, String paramString, SQLiteDatabase.CursorFactory paramCursorFactory, int paramInt)
  {
    this(paramContext, paramString, paramCursorFactory, paramInt, null);
  }
  
  public ParseSQLiteOpenHelper(Context paramContext, String paramString, SQLiteDatabase.CursorFactory paramCursorFactory, int paramInt, DatabaseErrorHandler paramDatabaseErrorHandler)
  {
    this.helper = new ParseSQLiteOpenHelper.1(this, paramContext, paramString, paramCursorFactory, paramInt);
  }
  
  private m<ParseSQLiteDatabase> getDatabaseAsync(boolean paramBoolean)
  {
    ParseSQLiteDatabase localParseSQLiteDatabase = new ParseSQLiteDatabase(paramBoolean);
    return m.a(null).b(new ParseSQLiteOpenHelper.3(this, localParseSQLiteDatabase)).b(new ParseSQLiteOpenHelper.2(this, localParseSQLiteDatabase));
  }
  
  @TargetApi(14)
  public String getDatabaseName()
  {
    return this.helper.getDatabaseName();
  }
  
  public m<ParseSQLiteDatabase> getReadableDatabaseAsync()
  {
    return getDatabaseAsync(false);
  }
  
  public m<ParseSQLiteDatabase> getWritableDatabaseAsync()
  {
    return getDatabaseAsync(true);
  }
  
  public void onConfigure(SQLiteDatabase paramSQLiteDatabase) {}
  
  public abstract void onCreate(SQLiteDatabase paramSQLiteDatabase);
  
  public void onDowngrade(SQLiteDatabase paramSQLiteDatabase) {}
  
  public void onOpen(SQLiteDatabase paramSQLiteDatabase) {}
  
  public abstract void onUpgrade(SQLiteDatabase paramSQLiteDatabase, int paramInt1, int paramInt2);
}


/* Location:           C:\Users\dreadiscool\Desktop\tools\classes-dex2jar.jar
 * Qualified Name:     com.parse.ParseSQLiteOpenHelper
 * JD-Core Version:    0.7.0.1
 */