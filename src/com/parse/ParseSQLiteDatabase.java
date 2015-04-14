package com.parse;

import android.content.ContentValues;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import m;

class ParseSQLiteDatabase
{
  private static final ExecutorService dbExecutor = ;
  private static final TaskQueue taskQueue = new TaskQueue();
  private m<Void> current = null;
  private final Object currentLock = new Object();
  private SQLiteDatabase db;
  private final m<Void>.y tcs = m.a();
  private boolean writable;
  
  ParseSQLiteDatabase(boolean paramBoolean)
  {
    this.writable = paramBoolean;
    taskQueue.enqueue(new ParseSQLiteDatabase.1(this));
  }
  
  public m<Void> beginTransactionAsync()
  {
    synchronized (this.currentLock)
    {
      this.current = this.current.b(new ParseSQLiteDatabase.4(this), dbExecutor);
      m localm = this.current.b(new ParseSQLiteDatabase.5(this), m.a);
      return localm;
    }
  }
  
  public m<Void> close()
  {
    synchronized (this.currentLock)
    {
      this.current = this.current.b(new ParseSQLiteDatabase.10(this), dbExecutor);
      m localm = this.current.b(new ParseSQLiteDatabase.11(this), m.a);
      return localm;
    }
  }
  
  public m<Void> deleteAsync(String paramString1, String paramString2, String[] paramArrayOfString)
  {
    synchronized (this.currentLock)
    {
      m localm1 = this.current.d(new ParseSQLiteDatabase.21(this, paramString1, paramString2, paramArrayOfString), dbExecutor);
      this.current = localm1.j();
      m localm2 = localm1.b(new ParseSQLiteDatabase.22(this), m.a).j();
      return localm2;
    }
  }
  
  public m<Void> endTransactionAsync()
  {
    synchronized (this.currentLock)
    {
      this.current = this.current.b(new ParseSQLiteDatabase.8(this), dbExecutor);
      m localm = this.current.b(new ParseSQLiteDatabase.9(this), m.a);
      return localm;
    }
  }
  
  public boolean inTransaction()
  {
    return this.db.inTransaction();
  }
  
  public m<Void> insertOrThrowAsync(String paramString, ContentValues paramContentValues)
  {
    synchronized (this.currentLock)
    {
      m localm1 = this.current.d(new ParseSQLiteDatabase.17(this, paramString, paramContentValues), dbExecutor);
      this.current = localm1.j();
      m localm2 = localm1.b(new ParseSQLiteDatabase.18(this), m.a).j();
      return localm2;
    }
  }
  
  public m<Void> insertWithOnConflict(String paramString, ContentValues paramContentValues, int paramInt)
  {
    synchronized (this.currentLock)
    {
      m localm1 = this.current.d(new ParseSQLiteDatabase.15(this, paramString, paramContentValues, paramInt), dbExecutor);
      this.current = localm1.j();
      m localm2 = localm1.b(new ParseSQLiteDatabase.16(this), m.a).j();
      return localm2;
    }
  }
  
  public boolean isOpen()
  {
    return this.db.isOpen();
  }
  
  public boolean isWritable()
  {
    return this.writable;
  }
  
  m<Void> open(SQLiteOpenHelper paramSQLiteOpenHelper)
  {
    synchronized (this.currentLock)
    {
      this.current = this.current.b(new ParseSQLiteDatabase.3(this, paramSQLiteOpenHelper), dbExecutor).b(new ParseSQLiteDatabase.2(this), m.a);
      m localm = this.current;
      return localm;
    }
  }
  
  public m<Cursor> queryAsync(String paramString1, String[] paramArrayOfString1, String paramString2, String[] paramArrayOfString2)
  {
    synchronized (this.currentLock)
    {
      m localm1 = this.current.d(new ParseSQLiteDatabase.13(this, paramString1, paramArrayOfString1, paramString2, paramArrayOfString2), dbExecutor).d(new ParseSQLiteDatabase.12(this), dbExecutor);
      this.current = localm1.j();
      m localm2 = localm1.b(new ParseSQLiteDatabase.14(this), m.a);
      return localm2;
    }
  }
  
  public m<Cursor> rawQueryAsync(String paramString, String[] paramArrayOfString)
  {
    synchronized (this.currentLock)
    {
      m localm1 = this.current.d(new ParseSQLiteDatabase.24(this, paramString, paramArrayOfString), dbExecutor).d(new ParseSQLiteDatabase.23(this), dbExecutor);
      this.current = localm1.j();
      m localm2 = localm1.b(new ParseSQLiteDatabase.25(this), m.a);
      return localm2;
    }
  }
  
  public m<Void> setTransactionSuccessfulAsync()
  {
    synchronized (this.currentLock)
    {
      this.current = this.current.d(new ParseSQLiteDatabase.6(this), dbExecutor);
      m localm = this.current.b(new ParseSQLiteDatabase.7(this), m.a);
      return localm;
    }
  }
  
  public m<Integer> updateAsync(String paramString1, ContentValues paramContentValues, String paramString2, String[] paramArrayOfString)
  {
    synchronized (this.currentLock)
    {
      m localm1 = this.current.d(new ParseSQLiteDatabase.19(this, paramString1, paramContentValues, paramString2, paramArrayOfString), dbExecutor);
      this.current = localm1.j();
      m localm2 = localm1.b(new ParseSQLiteDatabase.20(this), m.a);
      return localm2;
    }
  }
}


/* Location:           C:\Users\dreadiscool\Desktop\tools\classes-dex2jar.jar
 * Qualified Name:     com.parse.ParseSQLiteDatabase
 * JD-Core Version:    0.7.0.1
 */