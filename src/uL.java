import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import java.io.File;

class uL
  extends SQLiteOpenHelper
{
  private final File a;
  
  uL(Context paramContext, String paramString)
  {
    super(paramContext, paramString, null, 4);
    this.a = paramContext.getDatabasePath(paramString);
  }
  
  public void a()
  {
    close();
    this.a.delete();
  }
  
  public void onCreate(SQLiteDatabase paramSQLiteDatabase)
  {
    paramSQLiteDatabase.execSQL(uK.b());
    paramSQLiteDatabase.execSQL(uK.c());
    paramSQLiteDatabase.execSQL(uK.d());
    paramSQLiteDatabase.execSQL(uK.e());
  }
  
  public void onUpgrade(SQLiteDatabase paramSQLiteDatabase, int paramInt1, int paramInt2)
  {
    paramSQLiteDatabase.execSQL("DROP TABLE IF EXISTS " + uM.a.a());
    paramSQLiteDatabase.execSQL("DROP TABLE IF EXISTS " + uM.b.a());
    paramSQLiteDatabase.execSQL(uK.b());
    paramSQLiteDatabase.execSQL(uK.c());
    paramSQLiteDatabase.execSQL(uK.d());
    paramSQLiteDatabase.execSQL(uK.e());
  }
}


/* Location:           C:\Users\dreadiscool\Desktop\tools\classes-dex2jar.jar
 * Qualified Name:     uL
 * JD-Core Version:    0.7.0.1
 */