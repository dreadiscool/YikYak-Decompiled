package com.amplitude.api;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteDoneException;
import android.database.sqlite.SQLiteException;
import android.database.sqlite.SQLiteOpenHelper;
import android.database.sqlite.SQLiteStatement;
import java.io.File;

class DatabaseHelper
  extends SQLiteOpenHelper
{
  private static final String CREATE_EVENTS_TABLE = "CREATE TABLE IF NOT EXISTS events (id INTEGER PRIMARY KEY AUTOINCREMENT, event TEXT);";
  private static final String EVENT_FIELD = "event";
  private static final String EVENT_TABLE_NAME = "events";
  private static final String ID_FIELD = "id";
  private static final String TAG = "com.amplitude.api.DatabaseHelper";
  private static DatabaseHelper instance;
  private File file;
  
  private DatabaseHelper(Context paramContext)
  {
    super(paramContext, Constants.DATABASE_NAME, null, 1);
    this.file = paramContext.getDatabasePath(Constants.DATABASE_NAME);
  }
  
  private void delete()
  {
    try
    {
      close();
      this.file.delete();
      label12:
      return;
    }
    catch (SecurityException localSecurityException)
    {
      break label12;
    }
  }
  
  static DatabaseHelper getDatabaseHelper(Context paramContext)
  {
    try
    {
      if (instance == null) {
        instance = new DatabaseHelper(paramContext.getApplicationContext());
      }
      DatabaseHelper localDatabaseHelper = instance;
      return localDatabaseHelper;
    }
    finally
    {
      localObject = finally;
      throw localObject;
    }
  }
  
  /* Error */
  long addEvent(String paramString)
  {
    // Byte code:
    //   0: aload_0
    //   1: monitorenter
    //   2: ldc2_w 69
    //   5: lstore_2
    //   6: aload_0
    //   7: invokevirtual 74	com/amplitude/api/DatabaseHelper:getWritableDatabase	()Landroid/database/sqlite/SQLiteDatabase;
    //   10: astore 7
    //   12: new 76	android/content/ContentValues
    //   15: dup
    //   16: invokespecial 78	android/content/ContentValues:<init>	()V
    //   19: astore 8
    //   21: aload 8
    //   23: ldc 11
    //   25: aload_1
    //   26: invokevirtual 82	android/content/ContentValues:put	(Ljava/lang/String;Ljava/lang/String;)V
    //   29: aload 7
    //   31: ldc 14
    //   33: aconst_null
    //   34: aload 8
    //   36: invokevirtual 88	android/database/sqlite/SQLiteDatabase:insert	(Ljava/lang/String;Ljava/lang/String;Landroid/content/ContentValues;)J
    //   39: lstore 9
    //   41: lload 9
    //   43: lstore_2
    //   44: aload_0
    //   45: invokevirtual 49	com/amplitude/api/DatabaseHelper:close	()V
    //   48: aload_0
    //   49: monitorexit
    //   50: lload_2
    //   51: lreturn
    //   52: astore 6
    //   54: aload_0
    //   55: invokespecial 90	com/amplitude/api/DatabaseHelper:delete	()V
    //   58: aload_0
    //   59: invokevirtual 49	com/amplitude/api/DatabaseHelper:close	()V
    //   62: goto -14 -> 48
    //   65: astore 5
    //   67: aload_0
    //   68: monitorexit
    //   69: aload 5
    //   71: athrow
    //   72: astore 4
    //   74: aload_0
    //   75: invokevirtual 49	com/amplitude/api/DatabaseHelper:close	()V
    //   78: aload 4
    //   80: athrow
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	81	0	this	DatabaseHelper
    //   0	81	1	paramString	String
    //   5	46	2	l1	long
    //   72	7	4	localObject1	Object
    //   65	5	5	localObject2	Object
    //   52	1	6	localSQLiteException	SQLiteException
    //   10	20	7	localSQLiteDatabase	SQLiteDatabase
    //   19	16	8	localContentValues	android.content.ContentValues
    //   39	3	9	l2	long
    // Exception table:
    //   from	to	target	type
    //   6	41	52	android/database/sqlite/SQLiteException
    //   44	48	65	finally
    //   58	62	65	finally
    //   74	81	65	finally
    //   6	41	72	finally
    //   54	58	72	finally
  }
  
  /* Error */
  long getEventCount()
  {
    // Byte code:
    //   0: aload_0
    //   1: monitorenter
    //   2: lconst_0
    //   3: lstore_1
    //   4: aconst_null
    //   5: astore_3
    //   6: aload_0
    //   7: invokevirtual 95	com/amplitude/api/DatabaseHelper:getReadableDatabase	()Landroid/database/sqlite/SQLiteDatabase;
    //   10: ldc 97
    //   12: invokevirtual 101	android/database/sqlite/SQLiteDatabase:compileStatement	(Ljava/lang/String;)Landroid/database/sqlite/SQLiteStatement;
    //   15: astore_3
    //   16: aload_3
    //   17: invokevirtual 106	android/database/sqlite/SQLiteStatement:simpleQueryForLong	()J
    //   20: lstore 7
    //   22: lload 7
    //   24: lstore_1
    //   25: aload_3
    //   26: ifnull +7 -> 33
    //   29: aload_3
    //   30: invokevirtual 107	android/database/sqlite/SQLiteStatement:close	()V
    //   33: aload_0
    //   34: invokevirtual 49	com/amplitude/api/DatabaseHelper:close	()V
    //   37: aload_0
    //   38: monitorexit
    //   39: lload_1
    //   40: lreturn
    //   41: astore 6
    //   43: aload_3
    //   44: ifnull +7 -> 51
    //   47: aload_3
    //   48: invokevirtual 107	android/database/sqlite/SQLiteStatement:close	()V
    //   51: aload_0
    //   52: invokevirtual 49	com/amplitude/api/DatabaseHelper:close	()V
    //   55: goto -18 -> 37
    //   58: astore 5
    //   60: aload_0
    //   61: monitorexit
    //   62: aload 5
    //   64: athrow
    //   65: astore 4
    //   67: aload_3
    //   68: ifnull +7 -> 75
    //   71: aload_3
    //   72: invokevirtual 107	android/database/sqlite/SQLiteStatement:close	()V
    //   75: aload_0
    //   76: invokevirtual 49	com/amplitude/api/DatabaseHelper:close	()V
    //   79: aload 4
    //   81: athrow
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	82	0	this	DatabaseHelper
    //   3	37	1	l1	long
    //   5	67	3	localSQLiteStatement	SQLiteStatement
    //   65	15	4	localObject1	Object
    //   58	5	5	localObject2	Object
    //   41	1	6	localSQLiteException	SQLiteException
    //   20	3	7	l2	long
    // Exception table:
    //   from	to	target	type
    //   6	22	41	android/database/sqlite/SQLiteException
    //   29	37	58	finally
    //   47	55	58	finally
    //   71	82	58	finally
    //   6	22	65	finally
  }
  
  /* Error */
  android.util.Pair<java.lang.Long, org.json.JSONArray> getEvents(long paramLong, int paramInt)
  {
    // Byte code:
    //   0: aload_0
    //   1: monitorenter
    //   2: new 111	org/json/JSONArray
    //   5: dup
    //   6: invokespecial 112	org/json/JSONArray:<init>	()V
    //   9: astore 4
    //   11: aconst_null
    //   12: astore 5
    //   14: aload_0
    //   15: invokevirtual 95	com/amplitude/api/DatabaseHelper:getReadableDatabase	()Landroid/database/sqlite/SQLiteDatabase;
    //   18: astore 13
    //   20: iconst_2
    //   21: anewarray 114	java/lang/String
    //   24: astore 14
    //   26: aload 14
    //   28: iconst_0
    //   29: ldc 17
    //   31: aastore
    //   32: aload 14
    //   34: iconst_1
    //   35: ldc 11
    //   37: aastore
    //   38: lload_1
    //   39: lconst_0
    //   40: lcmp
    //   41: iflt +140 -> 181
    //   44: new 116	java/lang/StringBuilder
    //   47: dup
    //   48: invokespecial 117	java/lang/StringBuilder:<init>	()V
    //   51: ldc 119
    //   53: invokevirtual 123	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   56: lload_1
    //   57: invokevirtual 126	java/lang/StringBuilder:append	(J)Ljava/lang/StringBuilder;
    //   60: invokevirtual 130	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   63: astore 15
    //   65: iload_3
    //   66: iflt +121 -> 187
    //   69: new 116	java/lang/StringBuilder
    //   72: dup
    //   73: invokespecial 117	java/lang/StringBuilder:<init>	()V
    //   76: ldc 132
    //   78: invokevirtual 123	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   81: iload_3
    //   82: invokevirtual 135	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   85: invokevirtual 130	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   88: astore 16
    //   90: aload 13
    //   92: ldc 14
    //   94: aload 14
    //   96: aload 15
    //   98: aconst_null
    //   99: aconst_null
    //   100: aconst_null
    //   101: ldc 137
    //   103: aload 16
    //   105: invokevirtual 141	android/database/sqlite/SQLiteDatabase:query	(Ljava/lang/String;[Ljava/lang/String;Ljava/lang/String;[Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;)Landroid/database/Cursor;
    //   108: astore 17
    //   110: aload 17
    //   112: astore 9
    //   114: ldc2_w 69
    //   117: lstore 10
    //   119: aload 9
    //   121: invokeinterface 146 1 0
    //   126: ifeq +67 -> 193
    //   129: aload 9
    //   131: iconst_0
    //   132: invokeinterface 150 2 0
    //   137: lstore 20
    //   139: new 152	org/json/JSONObject
    //   142: dup
    //   143: aload 9
    //   145: iconst_1
    //   146: invokeinterface 156 2 0
    //   151: invokespecial 159	org/json/JSONObject:<init>	(Ljava/lang/String;)V
    //   154: astore 22
    //   156: aload 22
    //   158: ldc 161
    //   160: lload 20
    //   162: invokevirtual 164	org/json/JSONObject:put	(Ljava/lang/String;J)Lorg/json/JSONObject;
    //   165: pop
    //   166: aload 4
    //   168: aload 22
    //   170: invokevirtual 167	org/json/JSONArray:put	(Ljava/lang/Object;)Lorg/json/JSONArray;
    //   173: pop
    //   174: lload 20
    //   176: lstore 10
    //   178: goto -59 -> 119
    //   181: aconst_null
    //   182: astore 15
    //   184: goto -119 -> 65
    //   187: aconst_null
    //   188: astore 16
    //   190: goto -100 -> 90
    //   193: aload 9
    //   195: ifnull +10 -> 205
    //   198: aload 9
    //   200: invokeinterface 168 1 0
    //   205: aload_0
    //   206: invokevirtual 49	com/amplitude/api/DatabaseHelper:close	()V
    //   209: new 170	android/util/Pair
    //   212: dup
    //   213: lload 10
    //   215: invokestatic 176	java/lang/Long:valueOf	(J)Ljava/lang/Long;
    //   218: aload 4
    //   220: invokespecial 179	android/util/Pair:<init>	(Ljava/lang/Object;Ljava/lang/Object;)V
    //   223: astore 12
    //   225: aload_0
    //   226: monitorexit
    //   227: aload 12
    //   229: areturn
    //   230: astore 8
    //   232: aconst_null
    //   233: astore 9
    //   235: ldc2_w 69
    //   238: lstore 10
    //   240: aload 9
    //   242: ifnull +10 -> 252
    //   245: aload 9
    //   247: invokeinterface 168 1 0
    //   252: aload_0
    //   253: invokevirtual 49	com/amplitude/api/DatabaseHelper:close	()V
    //   256: goto -47 -> 209
    //   259: astore 7
    //   261: aload_0
    //   262: monitorexit
    //   263: aload 7
    //   265: athrow
    //   266: astore 6
    //   268: aload 5
    //   270: ifnull +10 -> 280
    //   273: aload 5
    //   275: invokeinterface 168 1 0
    //   280: aload_0
    //   281: invokevirtual 49	com/amplitude/api/DatabaseHelper:close	()V
    //   284: aload 6
    //   286: athrow
    //   287: astore 19
    //   289: aload 9
    //   291: astore 5
    //   293: aload 19
    //   295: astore 6
    //   297: goto -29 -> 268
    //   300: astore 18
    //   302: goto -62 -> 240
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	305	0	this	DatabaseHelper
    //   0	305	1	paramLong	long
    //   0	305	3	paramInt	int
    //   9	210	4	localJSONArray	org.json.JSONArray
    //   12	280	5	localObject1	Object
    //   266	19	6	localObject2	Object
    //   295	1	6	localObject3	Object
    //   259	5	7	localObject4	Object
    //   230	1	8	localSQLiteException1	SQLiteException
    //   112	178	9	localCursor1	android.database.Cursor
    //   117	122	10	l1	long
    //   223	5	12	localPair	android.util.Pair
    //   18	73	13	localSQLiteDatabase	SQLiteDatabase
    //   24	71	14	arrayOfString	String[]
    //   63	120	15	str1	String
    //   88	101	16	str2	String
    //   108	3	17	localCursor2	android.database.Cursor
    //   300	1	18	localSQLiteException2	SQLiteException
    //   287	7	19	localObject5	Object
    //   137	38	20	l2	long
    //   154	15	22	localJSONObject	org.json.JSONObject
    // Exception table:
    //   from	to	target	type
    //   14	110	230	android/database/sqlite/SQLiteException
    //   2	11	259	finally
    //   198	225	259	finally
    //   245	256	259	finally
    //   273	287	259	finally
    //   14	110	266	finally
    //   119	174	287	finally
    //   119	174	300	android/database/sqlite/SQLiteException
  }
  
  long getNthEventId(long paramLong)
  {
    l1 = -1L;
    localObject1 = null;
    try
    {
      SQLiteStatement localSQLiteStatement = getReadableDatabase().compileStatement("SELECT id FROM events LIMIT 1 OFFSET " + (paramLong - 1L));
      localObject1 = localSQLiteStatement;
    }
    catch (SQLiteException localSQLiteException)
    {
      for (;;)
      {
        long l2;
        label53:
        localSQLiteException = localSQLiteException;
        if (localObject1 != null) {
          localObject1.close();
        }
        close();
      }
    }
    finally
    {
      if (localObject1 != null) {
        localObject1.close();
      }
      close();
    }
    try
    {
      l2 = localObject1.simpleQueryForLong();
      l1 = l2;
    }
    catch (SQLiteDoneException localSQLiteDoneException)
    {
      break label53;
    }
    if (localObject1 == null) {}
  }
  
  public void onCreate(SQLiteDatabase paramSQLiteDatabase)
  {
    paramSQLiteDatabase.execSQL("CREATE TABLE IF NOT EXISTS events (id INTEGER PRIMARY KEY AUTOINCREMENT, event TEXT);");
  }
  
  public void onUpgrade(SQLiteDatabase paramSQLiteDatabase, int paramInt1, int paramInt2)
  {
    paramSQLiteDatabase.execSQL("DROP TABLE IF EXISTS events");
    paramSQLiteDatabase.execSQL("CREATE TABLE IF NOT EXISTS events (id INTEGER PRIMARY KEY AUTOINCREMENT, event TEXT);");
  }
  
  /* Error */
  void removeEvent(long paramLong)
  {
    // Byte code:
    //   0: aload_0
    //   1: monitorenter
    //   2: aload_0
    //   3: invokevirtual 74	com/amplitude/api/DatabaseHelper:getWritableDatabase	()Landroid/database/sqlite/SQLiteDatabase;
    //   6: ldc 14
    //   8: new 116	java/lang/StringBuilder
    //   11: dup
    //   12: invokespecial 117	java/lang/StringBuilder:<init>	()V
    //   15: ldc 198
    //   17: invokevirtual 123	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   20: lload_1
    //   21: invokevirtual 126	java/lang/StringBuilder:append	(J)Ljava/lang/StringBuilder;
    //   24: invokevirtual 130	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   27: aconst_null
    //   28: invokevirtual 201	android/database/sqlite/SQLiteDatabase:delete	(Ljava/lang/String;Ljava/lang/String;[Ljava/lang/String;)I
    //   31: pop
    //   32: aload_0
    //   33: invokevirtual 49	com/amplitude/api/DatabaseHelper:close	()V
    //   36: aload_0
    //   37: monitorexit
    //   38: return
    //   39: astore 5
    //   41: aload_0
    //   42: invokevirtual 49	com/amplitude/api/DatabaseHelper:close	()V
    //   45: goto -9 -> 36
    //   48: astore 4
    //   50: aload_0
    //   51: monitorexit
    //   52: aload 4
    //   54: athrow
    //   55: astore_3
    //   56: aload_0
    //   57: invokevirtual 49	com/amplitude/api/DatabaseHelper:close	()V
    //   60: aload_3
    //   61: athrow
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	62	0	this	DatabaseHelper
    //   0	62	1	paramLong	long
    //   55	6	3	localObject1	Object
    //   48	5	4	localObject2	Object
    //   39	1	5	localSQLiteException	SQLiteException
    // Exception table:
    //   from	to	target	type
    //   2	32	39	android/database/sqlite/SQLiteException
    //   32	36	48	finally
    //   41	45	48	finally
    //   56	62	48	finally
    //   2	32	55	finally
  }
  
  /* Error */
  void removeEvents(long paramLong)
  {
    // Byte code:
    //   0: aload_0
    //   1: monitorenter
    //   2: aload_0
    //   3: invokevirtual 74	com/amplitude/api/DatabaseHelper:getWritableDatabase	()Landroid/database/sqlite/SQLiteDatabase;
    //   6: ldc 14
    //   8: new 116	java/lang/StringBuilder
    //   11: dup
    //   12: invokespecial 117	java/lang/StringBuilder:<init>	()V
    //   15: ldc 204
    //   17: invokevirtual 123	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   20: lload_1
    //   21: invokevirtual 126	java/lang/StringBuilder:append	(J)Ljava/lang/StringBuilder;
    //   24: invokevirtual 130	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   27: aconst_null
    //   28: invokevirtual 201	android/database/sqlite/SQLiteDatabase:delete	(Ljava/lang/String;Ljava/lang/String;[Ljava/lang/String;)I
    //   31: pop
    //   32: aload_0
    //   33: invokevirtual 49	com/amplitude/api/DatabaseHelper:close	()V
    //   36: aload_0
    //   37: monitorexit
    //   38: return
    //   39: astore 5
    //   41: aload_0
    //   42: invokevirtual 49	com/amplitude/api/DatabaseHelper:close	()V
    //   45: goto -9 -> 36
    //   48: astore 4
    //   50: aload_0
    //   51: monitorexit
    //   52: aload 4
    //   54: athrow
    //   55: astore_3
    //   56: aload_0
    //   57: invokevirtual 49	com/amplitude/api/DatabaseHelper:close	()V
    //   60: aload_3
    //   61: athrow
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	62	0	this	DatabaseHelper
    //   0	62	1	paramLong	long
    //   55	6	3	localObject1	Object
    //   48	5	4	localObject2	Object
    //   39	1	5	localSQLiteException	SQLiteException
    // Exception table:
    //   from	to	target	type
    //   2	32	39	android/database/sqlite/SQLiteException
    //   32	36	48	finally
    //   41	45	48	finally
    //   56	62	48	finally
    //   2	32	55	finally
  }
}


/* Location:           C:\Users\dreadiscool\Desktop\tools\classes-dex2jar.jar
 * Qualified Name:     com.amplitude.api.DatabaseHelper
 * JD-Core Version:    0.7.0.1
 */