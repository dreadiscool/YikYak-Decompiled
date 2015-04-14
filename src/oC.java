import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteException;
import android.text.TextUtils;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.Iterator;
import java.util.List;
import java.util.concurrent.Executor;
import java.util.concurrent.Executors;

class oC
  implements nt
{
  private static final String a;
  private final Executor b;
  private final Context c;
  private oF d;
  private it e;
  private int f;
  
  static
  {
    Object[] arrayOfObject = new Object[5];
    arrayOfObject[0] = "datalayer";
    arrayOfObject[1] = "ID";
    arrayOfObject[2] = "key";
    arrayOfObject[3] = "value";
    arrayOfObject[4] = "expires";
    a = String.format("CREATE TABLE IF NOT EXISTS %s ( '%s' INTEGER PRIMARY KEY AUTOINCREMENT NOT NULL, '%s' STRING NOT NULL, '%s' BLOB NOT NULL, '%s' INTEGER NOT NULL);", arrayOfObject);
  }
  
  public oC(Context paramContext)
  {
    this(paramContext, iu.c(), "google_tagmanager.db", 2000, Executors.newSingleThreadExecutor());
  }
  
  oC(Context paramContext, it paramit, String paramString, int paramInt, Executor paramExecutor)
  {
    this.c = paramContext;
    this.e = paramit;
    this.f = paramInt;
    this.b = paramExecutor;
    this.d = new oF(this, this.c, paramString);
  }
  
  private SQLiteDatabase a(String paramString)
  {
    try
    {
      SQLiteDatabase localSQLiteDatabase2 = this.d.getWritableDatabase();
      localSQLiteDatabase1 = localSQLiteDatabase2;
    }
    catch (SQLiteException localSQLiteException)
    {
      for (;;)
      {
        nK.b(paramString);
        SQLiteDatabase localSQLiteDatabase1 = null;
      }
    }
    return localSQLiteDatabase1;
  }
  
  /* Error */
  private Object a(byte[] paramArrayOfByte)
  {
    // Byte code:
    //   0: aconst_null
    //   1: astore_2
    //   2: new 94	java/io/ByteArrayInputStream
    //   5: dup
    //   6: aload_1
    //   7: invokespecial 97	java/io/ByteArrayInputStream:<init>	([B)V
    //   10: astore_3
    //   11: new 99	java/io/ObjectInputStream
    //   14: dup
    //   15: aload_3
    //   16: invokespecial 102	java/io/ObjectInputStream:<init>	(Ljava/io/InputStream;)V
    //   19: astore 4
    //   21: aload 4
    //   23: invokevirtual 106	java/io/ObjectInputStream:readObject	()Ljava/lang/Object;
    //   26: astore 11
    //   28: aload 11
    //   30: astore_2
    //   31: aload 4
    //   33: ifnull +8 -> 41
    //   36: aload 4
    //   38: invokevirtual 109	java/io/ObjectInputStream:close	()V
    //   41: aload_3
    //   42: invokevirtual 110	java/io/ByteArrayInputStream:close	()V
    //   45: aload_2
    //   46: areturn
    //   47: astore 15
    //   49: aconst_null
    //   50: astore 4
    //   52: aload 4
    //   54: ifnull +8 -> 62
    //   57: aload 4
    //   59: invokevirtual 109	java/io/ObjectInputStream:close	()V
    //   62: aload_3
    //   63: invokevirtual 110	java/io/ByteArrayInputStream:close	()V
    //   66: goto -21 -> 45
    //   69: astore 6
    //   71: goto -26 -> 45
    //   74: astore 14
    //   76: aconst_null
    //   77: astore 4
    //   79: aload 4
    //   81: ifnull +8 -> 89
    //   84: aload 4
    //   86: invokevirtual 109	java/io/ObjectInputStream:close	()V
    //   89: aload_3
    //   90: invokevirtual 110	java/io/ByteArrayInputStream:close	()V
    //   93: goto -48 -> 45
    //   96: astore 8
    //   98: goto -53 -> 45
    //   101: astore 13
    //   103: aconst_null
    //   104: astore 4
    //   106: aload 13
    //   108: astore 9
    //   110: aload 4
    //   112: ifnull +8 -> 120
    //   115: aload 4
    //   117: invokevirtual 109	java/io/ObjectInputStream:close	()V
    //   120: aload_3
    //   121: invokevirtual 110	java/io/ByteArrayInputStream:close	()V
    //   124: aload 9
    //   126: athrow
    //   127: astore 10
    //   129: goto -5 -> 124
    //   132: astore 9
    //   134: goto -24 -> 110
    //   137: astore 7
    //   139: goto -60 -> 79
    //   142: astore 5
    //   144: goto -92 -> 52
    //   147: astore 12
    //   149: goto -104 -> 45
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	152	0	this	oC
    //   0	152	1	paramArrayOfByte	byte[]
    //   1	45	2	localObject1	Object
    //   10	111	3	localByteArrayInputStream	java.io.ByteArrayInputStream
    //   19	97	4	localObjectInputStream	java.io.ObjectInputStream
    //   142	1	5	localIOException1	java.io.IOException
    //   69	1	6	localIOException2	java.io.IOException
    //   137	1	7	localClassNotFoundException1	java.lang.ClassNotFoundException
    //   96	1	8	localIOException3	java.io.IOException
    //   108	17	9	localObject2	Object
    //   132	1	9	localObject3	Object
    //   127	1	10	localIOException4	java.io.IOException
    //   26	3	11	localObject4	Object
    //   147	1	12	localIOException5	java.io.IOException
    //   101	6	13	localObject5	Object
    //   74	1	14	localClassNotFoundException2	java.lang.ClassNotFoundException
    //   47	1	15	localIOException6	java.io.IOException
    // Exception table:
    //   from	to	target	type
    //   11	21	47	java/io/IOException
    //   57	66	69	java/io/IOException
    //   11	21	74	java/lang/ClassNotFoundException
    //   84	93	96	java/io/IOException
    //   11	21	101	finally
    //   115	124	127	java/io/IOException
    //   21	28	132	finally
    //   21	28	137	java/lang/ClassNotFoundException
    //   21	28	142	java/io/IOException
    //   36	45	147	java/io/IOException
  }
  
  private List<nr> a(List<oG> paramList)
  {
    ArrayList localArrayList = new ArrayList();
    Iterator localIterator = paramList.iterator();
    while (localIterator.hasNext())
    {
      oG localoG = (oG)localIterator.next();
      localArrayList.add(new nr(localoG.a, a(localoG.b)));
    }
    return localArrayList;
  }
  
  private void a(int paramInt)
  {
    int i = paramInt + (d() - this.f);
    if (i > 0)
    {
      List localList = b(i);
      nK.c("DataLayer store full, deleting " + localList.size() + " entries to make room.");
      a((String[])localList.toArray(new String[0]));
    }
  }
  
  private void a(long paramLong)
  {
    SQLiteDatabase localSQLiteDatabase = a("Error opening database for deleteOlderThan.");
    if (localSQLiteDatabase == null) {}
    for (;;)
    {
      return;
      try
      {
        String[] arrayOfString = new String[1];
        arrayOfString[0] = Long.toString(paramLong);
        int i = localSQLiteDatabase.delete("datalayer", "expires <= ?", arrayOfString);
        nK.d("Deleted " + i + " expired items");
      }
      catch (SQLiteException localSQLiteException)
      {
        nK.b("Error deleting old entries.");
      }
    }
  }
  
  private void a(String[] paramArrayOfString)
  {
    if ((paramArrayOfString == null) || (paramArrayOfString.length == 0)) {}
    for (;;)
    {
      return;
      SQLiteDatabase localSQLiteDatabase = a("Error opening database for deleteEntries.");
      if (localSQLiteDatabase != null)
      {
        Object[] arrayOfObject = new Object[2];
        arrayOfObject[0] = "ID";
        arrayOfObject[1] = TextUtils.join(",", Collections.nCopies(paramArrayOfString.length, "?"));
        String str = String.format("%s in (%s)", arrayOfObject);
        try
        {
          localSQLiteDatabase.delete("datalayer", str, paramArrayOfString);
        }
        catch (SQLiteException localSQLiteException)
        {
          nK.b("Error deleting entries " + Arrays.toString(paramArrayOfString));
        }
      }
    }
  }
  
  /* Error */
  private byte[] a(Object paramObject)
  {
    // Byte code:
    //   0: aconst_null
    //   1: astore_2
    //   2: new 249	java/io/ByteArrayOutputStream
    //   5: dup
    //   6: invokespecial 250	java/io/ByteArrayOutputStream:<init>	()V
    //   9: astore_3
    //   10: new 252	java/io/ObjectOutputStream
    //   13: dup
    //   14: aload_3
    //   15: invokespecial 255	java/io/ObjectOutputStream:<init>	(Ljava/io/OutputStream;)V
    //   18: astore 4
    //   20: aload 4
    //   22: aload_1
    //   23: invokevirtual 259	java/io/ObjectOutputStream:writeObject	(Ljava/lang/Object;)V
    //   26: aload_3
    //   27: invokevirtual 263	java/io/ByteArrayOutputStream:toByteArray	()[B
    //   30: astore 9
    //   32: aload 9
    //   34: astore_2
    //   35: aload 4
    //   37: ifnull +8 -> 45
    //   40: aload 4
    //   42: invokevirtual 264	java/io/ObjectOutputStream:close	()V
    //   45: aload_3
    //   46: invokevirtual 265	java/io/ByteArrayOutputStream:close	()V
    //   49: aload_2
    //   50: areturn
    //   51: astore 12
    //   53: aconst_null
    //   54: astore 4
    //   56: aload 4
    //   58: ifnull +8 -> 66
    //   61: aload 4
    //   63: invokevirtual 264	java/io/ObjectOutputStream:close	()V
    //   66: aload_3
    //   67: invokevirtual 265	java/io/ByteArrayOutputStream:close	()V
    //   70: goto -21 -> 49
    //   73: astore 6
    //   75: goto -26 -> 49
    //   78: astore 11
    //   80: aconst_null
    //   81: astore 4
    //   83: aload 11
    //   85: astore 7
    //   87: aload 4
    //   89: ifnull +8 -> 97
    //   92: aload 4
    //   94: invokevirtual 264	java/io/ObjectOutputStream:close	()V
    //   97: aload_3
    //   98: invokevirtual 265	java/io/ByteArrayOutputStream:close	()V
    //   101: aload 7
    //   103: athrow
    //   104: astore 8
    //   106: goto -5 -> 101
    //   109: astore 7
    //   111: goto -24 -> 87
    //   114: astore 5
    //   116: goto -60 -> 56
    //   119: astore 10
    //   121: goto -72 -> 49
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	124	0	this	oC
    //   0	124	1	paramObject	Object
    //   1	49	2	localObject1	Object
    //   9	89	3	localByteArrayOutputStream	java.io.ByteArrayOutputStream
    //   18	75	4	localObjectOutputStream	java.io.ObjectOutputStream
    //   114	1	5	localIOException1	java.io.IOException
    //   73	1	6	localIOException2	java.io.IOException
    //   85	17	7	localObject2	Object
    //   109	1	7	localObject3	Object
    //   104	1	8	localIOException3	java.io.IOException
    //   30	3	9	arrayOfByte	byte[]
    //   119	1	10	localIOException4	java.io.IOException
    //   78	6	11	localObject4	Object
    //   51	1	12	localIOException5	java.io.IOException
    // Exception table:
    //   from	to	target	type
    //   10	20	51	java/io/IOException
    //   61	70	73	java/io/IOException
    //   10	20	78	finally
    //   92	101	104	java/io/IOException
    //   20	32	109	finally
    //   20	32	114	java/io/IOException
    //   40	49	119	java/io/IOException
  }
  
  private List<nr> b()
  {
    try
    {
      a(this.e.a());
      List localList = a(c());
      return localList;
    }
    finally
    {
      e();
    }
  }
  
  /* Error */
  private List<String> b(int paramInt)
  {
    // Byte code:
    //   0: new 114	java/util/ArrayList
    //   3: dup
    //   4: invokespecial 115	java/util/ArrayList:<init>	()V
    //   7: astore_2
    //   8: iload_1
    //   9: ifgt +15 -> 24
    //   12: ldc_w 281
    //   15: invokestatic 87	nK:b	(Ljava/lang/String;)V
    //   18: aload_2
    //   19: astore 7
    //   21: aload 7
    //   23: areturn
    //   24: aload_0
    //   25: ldc_w 283
    //   28: invokespecial 194	oC:a	(Ljava/lang/String;)Landroid/database/sqlite/SQLiteDatabase;
    //   31: astore_3
    //   32: aload_3
    //   33: ifnonnull +9 -> 42
    //   36: aload_2
    //   37: astore 7
    //   39: goto -18 -> 21
    //   42: iconst_1
    //   43: anewarray 34	java/lang/String
    //   46: astore 8
    //   48: aload 8
    //   50: iconst_0
    //   51: ldc 24
    //   53: aastore
    //   54: iconst_1
    //   55: anewarray 4	java/lang/Object
    //   58: astore 9
    //   60: aload 9
    //   62: iconst_0
    //   63: ldc 24
    //   65: aastore
    //   66: aload_3
    //   67: ldc 22
    //   69: aload 8
    //   71: aconst_null
    //   72: aconst_null
    //   73: aconst_null
    //   74: aconst_null
    //   75: ldc_w 285
    //   78: aload 9
    //   80: invokestatic 38	java/lang/String:format	(Ljava/lang/String;[Ljava/lang/Object;)Ljava/lang/String;
    //   83: iload_1
    //   84: invokestatic 290	java/lang/Integer:toString	(I)Ljava/lang/String;
    //   87: invokevirtual 294	android/database/sqlite/SQLiteDatabase:query	(Ljava/lang/String;[Ljava/lang/String;Ljava/lang/String;[Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;)Landroid/database/Cursor;
    //   90: astore 10
    //   92: aload 10
    //   94: astore 5
    //   96: aload 5
    //   98: invokeinterface 299 1 0
    //   103: ifeq +35 -> 138
    //   106: aload_2
    //   107: aload 5
    //   109: iconst_0
    //   110: invokeinterface 303 2 0
    //   115: invokestatic 306	java/lang/String:valueOf	(J)Ljava/lang/String;
    //   118: invokeinterface 147 2 0
    //   123: pop
    //   124: aload 5
    //   126: invokeinterface 309 1 0
    //   131: istore 12
    //   133: iload 12
    //   135: ifne -29 -> 106
    //   138: aload 5
    //   140: ifnull +10 -> 150
    //   143: aload 5
    //   145: invokeinterface 310 1 0
    //   150: aload_2
    //   151: astore 7
    //   153: goto -132 -> 21
    //   156: astore 6
    //   158: aconst_null
    //   159: astore 5
    //   161: new 160	java/lang/StringBuilder
    //   164: dup
    //   165: invokespecial 161	java/lang/StringBuilder:<init>	()V
    //   168: ldc_w 312
    //   171: invokevirtual 167	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   174: aload 6
    //   176: invokevirtual 315	android/database/sqlite/SQLiteException:getMessage	()Ljava/lang/String;
    //   179: invokevirtual 167	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   182: invokevirtual 178	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   185: invokestatic 87	nK:b	(Ljava/lang/String;)V
    //   188: aload 5
    //   190: ifnull -40 -> 150
    //   193: aload 5
    //   195: invokeinterface 310 1 0
    //   200: goto -50 -> 150
    //   203: astore 4
    //   205: aconst_null
    //   206: astore 5
    //   208: aload 5
    //   210: ifnull +10 -> 220
    //   213: aload 5
    //   215: invokeinterface 310 1 0
    //   220: aload 4
    //   222: athrow
    //   223: astore 4
    //   225: goto -17 -> 208
    //   228: astore 6
    //   230: goto -69 -> 161
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	233	0	this	oC
    //   0	233	1	paramInt	int
    //   7	144	2	localArrayList1	ArrayList
    //   31	36	3	localSQLiteDatabase	SQLiteDatabase
    //   203	18	4	localObject1	Object
    //   223	1	4	localObject2	Object
    //   94	120	5	localCursor1	Cursor
    //   156	19	6	localSQLiteException1	SQLiteException
    //   228	1	6	localSQLiteException2	SQLiteException
    //   19	133	7	localArrayList2	ArrayList
    //   46	24	8	arrayOfString	String[]
    //   58	21	9	arrayOfObject	Object[]
    //   90	3	10	localCursor2	Cursor
    //   131	3	12	bool	boolean
    // Exception table:
    //   from	to	target	type
    //   42	92	156	android/database/sqlite/SQLiteException
    //   42	92	203	finally
    //   96	133	223	finally
    //   161	188	223	finally
    //   96	133	228	android/database/sqlite/SQLiteException
  }
  
  private List<oG> b(List<nr> paramList)
  {
    ArrayList localArrayList = new ArrayList();
    Iterator localIterator = paramList.iterator();
    while (localIterator.hasNext())
    {
      nr localnr = (nr)localIterator.next();
      localArrayList.add(new oG(localnr.a, a(localnr.b)));
    }
    return localArrayList;
  }
  
  /* Error */
  private void b(List<oG> paramList, long paramLong)
  {
    // Byte code:
    //   0: aload_0
    //   1: monitorenter
    //   2: aload_0
    //   3: getfield 64	oC:e	Lit;
    //   6: invokeinterface 271 1 0
    //   11: lstore 6
    //   13: aload_0
    //   14: lload 6
    //   16: invokespecial 273	oC:a	(J)V
    //   19: aload_0
    //   20: aload_1
    //   21: invokeinterface 170 1 0
    //   26: invokespecial 326	oC:a	(I)V
    //   29: aload_0
    //   30: aload_1
    //   31: lload 6
    //   33: lload_2
    //   34: ladd
    //   35: invokespecial 328	oC:c	(Ljava/util/List;J)V
    //   38: aload_0
    //   39: invokespecial 279	oC:e	()V
    //   42: aload_0
    //   43: monitorexit
    //   44: return
    //   45: astore 4
    //   47: aload_0
    //   48: invokespecial 279	oC:e	()V
    //   51: aload 4
    //   53: athrow
    //   54: astore 5
    //   56: aload_0
    //   57: monitorexit
    //   58: aload 5
    //   60: athrow
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	61	0	this	oC
    //   0	61	1	paramList	List<oG>
    //   0	61	2	paramLong	long
    //   45	7	4	localObject1	Object
    //   54	5	5	localObject2	Object
    //   11	21	6	l	long
    // Exception table:
    //   from	to	target	type
    //   2	38	45	finally
    //   38	42	54	finally
    //   47	54	54	finally
  }
  
  private List<oG> c()
  {
    SQLiteDatabase localSQLiteDatabase = a("Error opening database for loadSerialized.");
    ArrayList localArrayList1 = new ArrayList();
    ArrayList localArrayList2;
    if (localSQLiteDatabase == null) {
      localArrayList2 = localArrayList1;
    }
    for (;;)
    {
      return localArrayList2;
      String[] arrayOfString = new String[2];
      arrayOfString[0] = "key";
      arrayOfString[1] = "value";
      Cursor localCursor = localSQLiteDatabase.query("datalayer", arrayOfString, null, null, null, null, "ID", null);
      try
      {
        while (localCursor.moveToNext()) {
          localArrayList1.add(new oG(localCursor.getString(0), localCursor.getBlob(1)));
        }
        localArrayList2 = localArrayList1;
      }
      finally
      {
        localCursor.close();
      }
    }
  }
  
  private void c(List<oG> paramList, long paramLong)
  {
    SQLiteDatabase localSQLiteDatabase = a("Error opening database for writeEntryToDatabase.");
    if (localSQLiteDatabase == null) {}
    for (;;)
    {
      return;
      Iterator localIterator = paramList.iterator();
      while (localIterator.hasNext())
      {
        oG localoG = (oG)localIterator.next();
        ContentValues localContentValues = new ContentValues();
        localContentValues.put("expires", Long.valueOf(paramLong));
        localContentValues.put("key", localoG.a);
        localContentValues.put("value", localoG.b);
        localSQLiteDatabase.insert("datalayer", null, localContentValues);
      }
    }
  }
  
  private int d()
  {
    Cursor localCursor = null;
    int i = 0;
    SQLiteDatabase localSQLiteDatabase = a("Error opening database for getNumStoredEntries.");
    if (localSQLiteDatabase == null) {}
    for (;;)
    {
      return i;
      try
      {
        localCursor = localSQLiteDatabase.rawQuery("SELECT COUNT(*) from datalayer", null);
        if (localCursor.moveToFirst())
        {
          long l = localCursor.getLong(0);
          i = (int)l;
        }
        if (localCursor == null) {
          continue;
        }
        localCursor.close();
      }
      catch (SQLiteException localSQLiteException)
      {
        nK.b("Error getting numStoredEntries");
        if (localCursor == null) {
          continue;
        }
        localCursor.close();
      }
      finally
      {
        if (localCursor != null) {
          localCursor.close();
        }
      }
    }
  }
  
  private void e()
  {
    try
    {
      this.d.close();
      label7:
      return;
    }
    catch (SQLiteException localSQLiteException)
    {
      break label7;
    }
  }
  
  public void a(List<nr> paramList, long paramLong)
  {
    List localList = b(paramList);
    this.b.execute(new oD(this, localList, paramLong));
  }
  
  public void a(nu paramnu)
  {
    this.b.execute(new oE(this, paramnu));
  }
}


/* Location:           C:\Users\dreadiscool\Desktop\tools\classes-dex2jar.jar
 * Qualified Name:     oC
 * JD-Core Version:    0.7.0.1
 */