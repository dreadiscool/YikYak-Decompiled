import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteException;
import android.database.sqlite.SQLiteOpenHelper;
import android.os.Build.VERSION;
import com.google.android.gms.common.util.VisibleForTesting;
import java.io.File;
import java.util.HashSet;
import java.util.Set;

@VisibleForTesting
class eW
  extends SQLiteOpenHelper
{
  private boolean b;
  private long c = 0L;
  
  eW(eU parameU, Context paramContext, String paramString)
  {
    super(paramContext, paramString, null, 1);
  }
  
  private void a(SQLiteDatabase paramSQLiteDatabase)
  {
    int i = 0;
    Cursor localCursor = paramSQLiteDatabase.rawQuery("SELECT * FROM hits2 WHERE 0", null);
    HashSet localHashSet = new HashSet();
    try
    {
      String[] arrayOfString = localCursor.getColumnNames();
      for (int j = 0; j < arrayOfString.length; j++) {
        localHashSet.add(arrayOfString[j]);
      }
      localCursor.close();
      if ((!localHashSet.remove("hit_id")) || (!localHashSet.remove("hit_url")) || (!localHashSet.remove("hit_string")) || (!localHashSet.remove("hit_time"))) {
        throw new SQLiteException("Database column missing");
      }
    }
    finally
    {
      localCursor.close();
    }
    if (!localHashSet.remove("hit_app_id")) {
      i = 1;
    }
    if (!localHashSet.isEmpty()) {
      throw new SQLiteException("Database has extra columns");
    }
    if (i != 0) {
      paramSQLiteDatabase.execSQL("ALTER TABLE hits2 ADD COLUMN hit_app_id");
    }
  }
  
  /* Error */
  private boolean a(String paramString, SQLiteDatabase paramSQLiteDatabase)
  {
    // Byte code:
    //   0: aconst_null
    //   1: astore_3
    //   2: iconst_1
    //   3: anewarray 83	java/lang/String
    //   6: astore 9
    //   8: aload 9
    //   10: iconst_0
    //   11: ldc 85
    //   13: aastore
    //   14: iconst_1
    //   15: anewarray 83	java/lang/String
    //   18: astore 10
    //   20: aload 10
    //   22: iconst_0
    //   23: aload_1
    //   24: aastore
    //   25: aload_2
    //   26: ldc 87
    //   28: aload 9
    //   30: ldc 89
    //   32: aload 10
    //   34: aconst_null
    //   35: aconst_null
    //   36: aconst_null
    //   37: invokevirtual 93	android/database/sqlite/SQLiteDatabase:query	(Ljava/lang/String;[Ljava/lang/String;Ljava/lang/String;[Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;)Landroid/database/Cursor;
    //   40: astore 11
    //   42: aload 11
    //   44: invokeinterface 96 1 0
    //   49: istore 13
    //   51: iload 13
    //   53: istore 8
    //   55: aload 11
    //   57: ifnull +10 -> 67
    //   60: aload 11
    //   62: invokeinterface 49 1 0
    //   67: iload 8
    //   69: ireturn
    //   70: astore 5
    //   72: aconst_null
    //   73: astore 6
    //   75: new 98	java/lang/StringBuilder
    //   78: dup
    //   79: invokespecial 99	java/lang/StringBuilder:<init>	()V
    //   82: ldc 101
    //   84: invokevirtual 105	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   87: aload_1
    //   88: invokevirtual 105	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   91: invokevirtual 109	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   94: invokestatic 114	eO:d	(Ljava/lang/String;)V
    //   97: aload 6
    //   99: ifnull +10 -> 109
    //   102: aload 6
    //   104: invokeinterface 49 1 0
    //   109: iconst_0
    //   110: istore 8
    //   112: goto -45 -> 67
    //   115: astore 4
    //   117: aload_3
    //   118: ifnull +9 -> 127
    //   121: aload_3
    //   122: invokeinterface 49 1 0
    //   127: aload 4
    //   129: athrow
    //   130: astore 4
    //   132: aload 11
    //   134: astore_3
    //   135: goto -18 -> 117
    //   138: astore 7
    //   140: aload 6
    //   142: astore_3
    //   143: aload 7
    //   145: astore 4
    //   147: goto -30 -> 117
    //   150: astore 12
    //   152: aload 11
    //   154: astore 6
    //   156: goto -81 -> 75
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	159	0	this	eW
    //   0	159	1	paramString	String
    //   0	159	2	paramSQLiteDatabase	SQLiteDatabase
    //   1	142	3	localObject1	Object
    //   115	13	4	localObject2	Object
    //   130	1	4	localObject3	Object
    //   145	1	4	localObject4	Object
    //   70	1	5	localSQLiteException1	SQLiteException
    //   73	82	6	localCursor1	Cursor
    //   138	6	7	localObject5	Object
    //   53	58	8	bool1	boolean
    //   6	23	9	arrayOfString1	String[]
    //   18	15	10	arrayOfString2	String[]
    //   40	113	11	localCursor2	Cursor
    //   150	1	12	localSQLiteException2	SQLiteException
    //   49	3	13	bool2	boolean
    // Exception table:
    //   from	to	target	type
    //   2	42	70	android/database/sqlite/SQLiteException
    //   2	42	115	finally
    //   42	51	130	finally
    //   75	97	138	finally
    //   42	51	150	android/database/sqlite/SQLiteException
  }
  
  public SQLiteDatabase getWritableDatabase()
  {
    if ((this.b) && (3600000L + this.c > eU.a(this.a).a())) {
      throw new SQLiteException("Database creation failed");
    }
    Object localObject = null;
    this.b = true;
    this.c = eU.a(this.a).a();
    try
    {
      SQLiteDatabase localSQLiteDatabase = super.getWritableDatabase();
      localObject = localSQLiteDatabase;
    }
    catch (SQLiteException localSQLiteException)
    {
      for (;;)
      {
        eU.c(this.a).getDatabasePath(eU.b(this.a)).delete();
      }
    }
    if (localObject == null) {
      localObject = super.getWritableDatabase();
    }
    this.b = false;
    return localObject;
  }
  
  public void onCreate(SQLiteDatabase paramSQLiteDatabase)
  {
    er.a(paramSQLiteDatabase.getPath());
  }
  
  public void onOpen(SQLiteDatabase paramSQLiteDatabase)
  {
    Cursor localCursor;
    if (Build.VERSION.SDK_INT < 15) {
      localCursor = paramSQLiteDatabase.rawQuery("PRAGMA journal_mode=memory", null);
    }
    for (;;)
    {
      try
      {
        localCursor.moveToFirst();
        localCursor.close();
        if (!a("hits2", paramSQLiteDatabase))
        {
          paramSQLiteDatabase.execSQL(eU.e());
          return;
        }
      }
      finally
      {
        localCursor.close();
      }
      a(paramSQLiteDatabase);
    }
  }
  
  public void onUpgrade(SQLiteDatabase paramSQLiteDatabase, int paramInt1, int paramInt2) {}
}


/* Location:           C:\Users\dreadiscool\Desktop\tools\classes-dex2jar.jar
 * Qualified Name:     eW
 * JD-Core Version:    0.7.0.1
 */