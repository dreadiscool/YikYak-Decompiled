package com.parse;

import android.annotation.TargetApi;
import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteDatabase.CursorFactory;
import android.database.sqlite.SQLiteOpenHelper;

class ParseSQLiteOpenHelper$1
  extends SQLiteOpenHelper
{
  ParseSQLiteOpenHelper$1(ParseSQLiteOpenHelper paramParseSQLiteOpenHelper, Context paramContext, String paramString, SQLiteDatabase.CursorFactory paramCursorFactory, int paramInt)
  {
    super(paramContext, paramString, paramCursorFactory, paramInt);
  }
  
  @TargetApi(16)
  public void onConfigure(SQLiteDatabase paramSQLiteDatabase)
  {
    super.onConfigure(paramSQLiteDatabase);
    this.this$0.onConfigure(paramSQLiteDatabase);
  }
  
  public void onCreate(SQLiteDatabase paramSQLiteDatabase)
  {
    this.this$0.onCreate(paramSQLiteDatabase);
  }
  
  @TargetApi(11)
  public void onDowngrade(SQLiteDatabase paramSQLiteDatabase, int paramInt1, int paramInt2)
  {
    super.onDowngrade(paramSQLiteDatabase, paramInt1, paramInt2);
    this.this$0.onDowngrade(paramSQLiteDatabase);
  }
  
  public void onOpen(SQLiteDatabase paramSQLiteDatabase)
  {
    super.onOpen(paramSQLiteDatabase);
    this.this$0.onOpen(paramSQLiteDatabase);
  }
  
  public void onUpgrade(SQLiteDatabase paramSQLiteDatabase, int paramInt1, int paramInt2)
  {
    this.this$0.onUpgrade(paramSQLiteDatabase, paramInt1, paramInt2);
  }
}


/* Location:           C:\Users\dreadiscool\Desktop\tools\classes-dex2jar.jar
 * Qualified Name:     com.parse.ParseSQLiteOpenHelper.1
 * JD-Core Version:    0.7.0.1
 */