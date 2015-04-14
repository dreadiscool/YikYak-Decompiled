import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;

public class Cb
{
  public static void a(CJ[] paramArrayOfCJ)
  {
    SQLiteDatabase localSQLiteDatabase = BZ.a().getWritableDatabase();
    localSQLiteDatabase.beginTransaction();
    try
    {
      int i = paramArrayOfCJ.length;
      for (int j = 0; j < i; j++)
      {
        CJ localCJ = paramArrayOfCJ[j];
        localSQLiteDatabase.insert(Cd.class.getSimpleName(), null, localCJ.b());
      }
      localSQLiteDatabase.setTransactionSuccessful();
      return;
    }
    catch (Exception localException)
    {
      for (;;)
      {
        localException.printStackTrace();
        localSQLiteDatabase.endTransaction();
      }
    }
    finally
    {
      localSQLiteDatabase.endTransaction();
    }
  }
  
  public static CJ[] a()
  {
    Cursor localCursor = BZ.a().getWritableDatabase().query(Cd.class.getSimpleName(), null, null, null, null, null, "name ASC");
    CJ[] arrayOfCJ = new CJ[localCursor.getCount()];
    if (localCursor.moveToFirst())
    {
      int i = 0;
      do
      {
        arrayOfCJ[i] = new CJ(localCursor);
        i++;
      } while (localCursor.moveToNext());
    }
    localCursor.close();
    return arrayOfCJ;
  }
}


/* Location:           C:\Users\dreadiscool\Desktop\tools\classes-dex2jar.jar
 * Qualified Name:     Cb
 * JD-Core Version:    0.7.0.1
 */