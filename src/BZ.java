import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

public class BZ
  extends SQLiteOpenHelper
{
  private static Context a;
  private static BZ b;
  
  private BZ(Context paramContext)
  {
    super(paramContext, "YikYakDatabase", null, 2);
  }
  
  public static BZ a()
  {
    try
    {
      if (b == null)
      {
        Object[] arrayOfObject = new Object[1];
        arrayOfObject[0] = "YikYakSQLiteOpenHelper.init() has not been called! The application context needs to be passed!";
        Iq.b(BZ.class, arrayOfObject);
      }
      BZ localBZ = b;
      return localBZ;
    }
    finally
    {
      localObject = finally;
      throw localObject;
    }
  }
  
  /* Error */
  public static void a(Context paramContext)
  {
    // Byte code:
    //   0: ldc 2
    //   2: monitorenter
    //   3: aload_0
    //   4: putstatic 29	BZ:a	Landroid/content/Context;
    //   7: getstatic 18	BZ:b	LBZ;
    //   10: ifnonnull +20 -> 30
    //   13: new 2	BZ
    //   16: dup
    //   17: getstatic 29	BZ:a	Landroid/content/Context;
    //   20: invokespecial 31	BZ:<init>	(Landroid/content/Context;)V
    //   23: putstatic 18	BZ:b	LBZ;
    //   26: ldc 2
    //   28: monitorexit
    //   29: return
    //   30: iconst_1
    //   31: anewarray 20	java/lang/Object
    //   34: astore_2
    //   35: aload_2
    //   36: iconst_0
    //   37: ldc 33
    //   39: aastore
    //   40: ldc 2
    //   42: aload_2
    //   43: invokestatic 36	Iq:c	(Ljava/lang/Object;[Ljava/lang/Object;)V
    //   46: goto -20 -> 26
    //   49: astore_1
    //   50: ldc 2
    //   52: monitorexit
    //   53: aload_1
    //   54: athrow
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	55	0	paramContext	Context
    //   49	5	1	localObject	Object
    //   34	9	2	arrayOfObject	Object[]
    // Exception table:
    //   from	to	target	type
    //   3	26	49	finally
    //   30	46	49	finally
  }
  
  private void b(SQLiteDatabase paramSQLiteDatabase)
  {
    Cursor localCursor = paramSQLiteDatabase.rawQuery("SELECT * FROM sqlite_master WHERE type='table'", null);
    if (localCursor.moveToFirst()) {
      do
      {
        String str = localCursor.getString(1);
        if ((!str.equalsIgnoreCase("android_metadata")) && (!str.equalsIgnoreCase("sqlite_sequence"))) {
          b(paramSQLiteDatabase, str);
        }
      } while (localCursor.moveToNext());
    }
    localCursor.close();
  }
  
  public void a(SQLiteDatabase paramSQLiteDatabase)
  {
    b(paramSQLiteDatabase);
    onCreate(paramSQLiteDatabase);
  }
  
  public void a(SQLiteDatabase paramSQLiteDatabase, String paramString)
  {
    paramSQLiteDatabase.execSQL("DELETE FROM " + paramString + ";");
  }
  
  public void a(String paramString)
  {
    a(getWritableDatabase(), paramString);
  }
  
  public void b(SQLiteDatabase paramSQLiteDatabase, String paramString)
  {
    paramSQLiteDatabase.execSQL("DROP TABLE IF EXISTS " + paramString);
  }
  
  public void onCreate(SQLiteDatabase paramSQLiteDatabase)
  {
    paramSQLiteDatabase.execSQL(new Cc().a());
    paramSQLiteDatabase.execSQL(new Cd().a());
  }
  
  public void onUpgrade(SQLiteDatabase paramSQLiteDatabase, int paramInt1, int paramInt2)
  {
    a(paramSQLiteDatabase);
  }
}


/* Location:           C:\Users\dreadiscool\Desktop\tools\classes-dex2jar.jar
 * Qualified Name:     BZ
 * JD-Core Version:    0.7.0.1
 */