import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteException;
import android.text.TextUtils;
import com.google.android.gms.internal.ha;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Set;
import org.apache.http.impl.client.DefaultHttpClient;

class fC
  implements fP
{
  private static final String a;
  private final fD b;
  private volatile gn c;
  private final fQ d;
  private final Context e;
  private final String f;
  private fB g;
  private long h;
  private final int i;
  private it j;
  private gk k;
  private volatile boolean l = true;
  
  static
  {
    Object[] arrayOfObject = new Object[6];
    arrayOfObject[0] = "hits2";
    arrayOfObject[1] = "hit_id";
    arrayOfObject[2] = "hit_time";
    arrayOfObject[3] = "hit_url";
    arrayOfObject[4] = "hit_string";
    arrayOfObject[5] = "hit_app_id";
    a = String.format("CREATE TABLE IF NOT EXISTS %s ( '%s' INTEGER PRIMARY KEY AUTOINCREMENT NOT NULL, '%s' INTEGER NOT NULL, '%s' TEXT NOT NULL, '%s' TEXT NOT NULL, '%s' INTEGER);", arrayOfObject);
  }
  
  fC(fQ paramfQ, Context paramContext, gk paramgk)
  {
    this(paramfQ, paramContext, "google_analytics_v4.db", 2000, paramgk);
  }
  
  fC(fQ paramfQ, Context paramContext, String paramString, int paramInt, gk paramgk)
  {
    this.e = paramContext.getApplicationContext();
    this.k = paramgk;
    this.f = paramString;
    this.d = paramfQ;
    this.j = iu.c();
    this.b = new fD(this, this.e, this.f);
    this.c = new fW(new DefaultHttpClient(), this.e, this.k);
    this.h = 0L;
    this.i = paramInt;
  }
  
  private SQLiteDatabase a(String paramString)
  {
    try
    {
      SQLiteDatabase localSQLiteDatabase2 = this.b.getWritableDatabase();
      localSQLiteDatabase1 = localSQLiteDatabase2;
    }
    catch (SQLiteException localSQLiteException)
    {
      for (;;)
      {
        fA.d(paramString);
        SQLiteDatabase localSQLiteDatabase1 = null;
      }
    }
    return localSQLiteDatabase1;
  }
  
  static String a(Map<String, String> paramMap)
  {
    ArrayList localArrayList = new ArrayList(paramMap.size());
    Iterator localIterator = paramMap.entrySet().iterator();
    while (localIterator.hasNext())
    {
      Map.Entry localEntry = (Map.Entry)localIterator.next();
      localArrayList.add(fy.a((String)localEntry.getKey()) + "=" + fy.a((String)localEntry.getValue()));
    }
    return TextUtils.join("&", localArrayList);
  }
  
  private void a(Map<String, String> paramMap, long paramLong, String paramString)
  {
    SQLiteDatabase localSQLiteDatabase = a("Error opening database for putHit");
    if (localSQLiteDatabase == null) {}
    for (;;)
    {
      return;
      ContentValues localContentValues = new ContentValues();
      localContentValues.put("hit_string", a(paramMap));
      localContentValues.put("hit_time", Long.valueOf(paramLong));
      if (paramMap.containsKey("AppUID")) {}
      for (;;)
      {
        try
        {
          long l2 = Long.parseLong((String)paramMap.get("AppUID"));
          l1 = l2;
          localContentValues.put("hit_app_id", Long.valueOf(l1));
          if (paramString == null) {
            paramString = "http://www.google-analytics.com/collect";
          }
          if (paramString.length() != 0) {
            break label121;
          }
          fA.d("Empty path: not sending hit");
        }
        catch (NumberFormatException localNumberFormatException) {}
        long l1 = 0L;
      }
      label121:
      localContentValues.put("hit_url", paramString);
      try
      {
        localSQLiteDatabase.insert("hits2", null, localContentValues);
        this.d.a(false);
      }
      catch (SQLiteException localSQLiteException)
      {
        fA.d("Error storing hit");
      }
    }
  }
  
  private void a(Map<String, String> paramMap, Collection<ha> paramCollection)
  {
    String str = "&_v".substring(1);
    if (paramCollection != null)
    {
      Iterator localIterator = paramCollection.iterator();
      while (localIterator.hasNext())
      {
        ha localha = (ha)localIterator.next();
        if ("appendVersion".equals(localha.a())) {
          paramMap.put(str, localha.b());
        }
      }
    }
  }
  
  private void f()
  {
    int m = 1 + (b() - this.i);
    if (m > 0)
    {
      List localList = a(m);
      fA.c("Store full, deleting " + localList.size() + " hits to make room.");
      a((String[])localList.toArray(new String[0]));
    }
  }
  
  int a()
  {
    boolean bool = true;
    int m = 0;
    long l1 = this.j.a();
    if (l1 <= 86400000L + this.h) {}
    SQLiteDatabase localSQLiteDatabase;
    do
    {
      return m;
      this.h = l1;
      localSQLiteDatabase = a("Error opening database for deleteStaleHits.");
    } while (localSQLiteDatabase == null);
    long l2 = this.j.a() - 2592000000L;
    String[] arrayOfString = new String[bool];
    arrayOfString[m] = Long.toString(l2);
    int n = localSQLiteDatabase.delete("hits2", "HIT_TIME < ?", arrayOfString);
    fQ localfQ = this.d;
    if (b() == 0) {}
    for (;;)
    {
      localfQ.a(bool);
      m = n;
      break;
      bool = false;
    }
  }
  
  /* Error */
  List<String> a(int paramInt)
  {
    // Byte code:
    //   0: new 122	java/util/ArrayList
    //   3: dup
    //   4: invokespecial 320	java/util/ArrayList:<init>	()V
    //   7: astore_2
    //   8: iload_1
    //   9: ifgt +15 -> 24
    //   12: ldc_w 322
    //   15: invokestatic 118	fA:d	(Ljava/lang/String;)V
    //   18: aload_2
    //   19: astore 7
    //   21: aload 7
    //   23: areturn
    //   24: aload_0
    //   25: ldc_w 324
    //   28: invokespecial 198	fC:a	(Ljava/lang/String;)Landroid/database/sqlite/SQLiteDatabase;
    //   31: astore_3
    //   32: aload_3
    //   33: ifnonnull +9 -> 42
    //   36: aload_2
    //   37: astore 7
    //   39: goto -18 -> 21
    //   42: iconst_1
    //   43: anewarray 47	java/lang/String
    //   46: astore 8
    //   48: aload 8
    //   50: iconst_0
    //   51: ldc 35
    //   53: aastore
    //   54: iconst_1
    //   55: anewarray 4	java/lang/Object
    //   58: astore 9
    //   60: aload 9
    //   62: iconst_0
    //   63: ldc 35
    //   65: aastore
    //   66: aload_3
    //   67: ldc 33
    //   69: aload 8
    //   71: aconst_null
    //   72: aconst_null
    //   73: aconst_null
    //   74: aconst_null
    //   75: ldc_w 326
    //   78: aload 9
    //   80: invokestatic 51	java/lang/String:format	(Ljava/lang/String;[Ljava/lang/Object;)Ljava/lang/String;
    //   83: iload_1
    //   84: invokestatic 330	java/lang/Integer:toString	(I)Ljava/lang/String;
    //   87: invokevirtual 334	android/database/sqlite/SQLiteDatabase:query	(Ljava/lang/String;[Ljava/lang/String;Ljava/lang/String;[Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;)Landroid/database/Cursor;
    //   90: astore 10
    //   92: aload 10
    //   94: astore 5
    //   96: aload 5
    //   98: invokeinterface 339 1 0
    //   103: ifeq +35 -> 138
    //   106: aload_2
    //   107: aload 5
    //   109: iconst_0
    //   110: invokeinterface 343 2 0
    //   115: invokestatic 345	java/lang/String:valueOf	(J)Ljava/lang/String;
    //   118: invokeinterface 183 2 0
    //   123: pop
    //   124: aload 5
    //   126: invokeinterface 348 1 0
    //   131: istore 12
    //   133: iload 12
    //   135: ifne -29 -> 106
    //   138: aload 5
    //   140: ifnull +10 -> 150
    //   143: aload 5
    //   145: invokeinterface 351 1 0
    //   150: aload_2
    //   151: astore 7
    //   153: goto -132 -> 21
    //   156: astore 6
    //   158: aconst_null
    //   159: astore 5
    //   161: new 155	java/lang/StringBuilder
    //   164: dup
    //   165: invokespecial 156	java/lang/StringBuilder:<init>	()V
    //   168: ldc_w 353
    //   171: invokevirtual 168	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   174: aload 6
    //   176: invokevirtual 356	android/database/sqlite/SQLiteException:getMessage	()Ljava/lang/String;
    //   179: invokevirtual 168	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   182: invokevirtual 177	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   185: invokestatic 118	fA:d	(Ljava/lang/String;)V
    //   188: aload 5
    //   190: ifnull -40 -> 150
    //   193: aload 5
    //   195: invokeinterface 351 1 0
    //   200: goto -50 -> 150
    //   203: astore 4
    //   205: aconst_null
    //   206: astore 5
    //   208: aload 5
    //   210: ifnull +10 -> 220
    //   213: aload 5
    //   215: invokeinterface 351 1 0
    //   220: aload 4
    //   222: athrow
    //   223: astore 4
    //   225: goto -17 -> 208
    //   228: astore 6
    //   230: goto -69 -> 161
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	233	0	this	fC
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
  
  public void a(long paramLong)
  {
    boolean bool = true;
    SQLiteDatabase localSQLiteDatabase = a("Error opening database for clearHits");
    fQ localfQ;
    if (localSQLiteDatabase != null)
    {
      if (paramLong != 0L) {
        break label54;
      }
      localSQLiteDatabase.delete("hits2", null, null);
      localfQ = this.d;
      if (b() != 0) {
        break label87;
      }
    }
    for (;;)
    {
      localfQ.a(bool);
      return;
      label54:
      String[] arrayOfString = new String[bool];
      arrayOfString[0] = Long.valueOf(paramLong).toString();
      localSQLiteDatabase.delete("hits2", "hit_app_id = ?", arrayOfString);
      break;
      label87:
      bool = false;
    }
  }
  
  @Deprecated
  void a(Collection<fx> paramCollection)
  {
    if ((paramCollection == null) || (paramCollection.isEmpty())) {
      fA.d("Empty/Null collection passed to deleteHits.");
    }
    for (;;)
    {
      return;
      String[] arrayOfString = new String[paramCollection.size()];
      Iterator localIterator = paramCollection.iterator();
      int n;
      for (int m = 0; localIterator.hasNext(); m = n)
      {
        fx localfx = (fx)localIterator.next();
        n = m + 1;
        arrayOfString[m] = String.valueOf(localfx.b());
      }
      a(arrayOfString);
    }
  }
  
  public void a(Map<String, String> paramMap, long paramLong, String paramString, Collection<ha> paramCollection)
  {
    a();
    f();
    a(paramMap, paramCollection);
    a(paramMap, paramLong, paramString);
  }
  
  public void a(boolean paramBoolean)
  {
    this.l = paramBoolean;
    if (this.c != null) {
      this.c.a(paramBoolean);
    }
  }
  
  void a(String[] paramArrayOfString)
  {
    boolean bool = true;
    if ((paramArrayOfString == null) || (paramArrayOfString.length == 0)) {
      fA.d("Empty hitIds passed to deleteHits.");
    }
    SQLiteDatabase localSQLiteDatabase;
    do
    {
      return;
      localSQLiteDatabase = a("Error opening database for deleteHits.");
    } while (localSQLiteDatabase == null);
    Object[] arrayOfObject = new Object[bool];
    arrayOfObject[0] = TextUtils.join(",", Collections.nCopies(paramArrayOfString.length, "?"));
    String str = String.format("HIT_ID in (%s)", arrayOfObject);
    for (;;)
    {
      try
      {
        localSQLiteDatabase.delete("hits2", str, paramArrayOfString);
        fQ localfQ = this.d;
        if (b() != 0) {
          break label132;
        }
        localfQ.a(bool);
      }
      catch (SQLiteException localSQLiteException)
      {
        fA.d("Error deleting hits " + TextUtils.join(",", paramArrayOfString));
      }
      break;
      label132:
      bool = false;
    }
  }
  
  int b()
  {
    Cursor localCursor = null;
    int m = 0;
    SQLiteDatabase localSQLiteDatabase = a("Error opening database for getNumStoredHits.");
    if (localSQLiteDatabase == null) {}
    for (;;)
    {
      return m;
      try
      {
        localCursor = localSQLiteDatabase.rawQuery("SELECT COUNT(*) from hits2", null);
        if (localCursor.moveToFirst())
        {
          long l1 = localCursor.getLong(0);
          m = (int)l1;
        }
        if (localCursor == null) {
          continue;
        }
        localCursor.close();
      }
      catch (SQLiteException localSQLiteException)
      {
        fA.d("Error getting numStoredHits");
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
  
  /* Error */
  public List<fx> b(int paramInt)
  {
    // Byte code:
    //   0: new 122	java/util/ArrayList
    //   3: dup
    //   4: invokespecial 320	java/util/ArrayList:<init>	()V
    //   7: astore_2
    //   8: aload_0
    //   9: ldc_w 419
    //   12: invokespecial 198	fC:a	(Ljava/lang/String;)Landroid/database/sqlite/SQLiteDatabase;
    //   15: astore_3
    //   16: aload_3
    //   17: ifnonnull +9 -> 26
    //   20: aload_2
    //   21: astore 9
    //   23: aload 9
    //   25: areturn
    //   26: aconst_null
    //   27: astore 4
    //   29: iconst_2
    //   30: anewarray 47	java/lang/String
    //   33: astore 10
    //   35: aload 10
    //   37: iconst_0
    //   38: ldc 35
    //   40: aastore
    //   41: aload 10
    //   43: iconst_1
    //   44: ldc 37
    //   46: aastore
    //   47: iconst_1
    //   48: anewarray 4	java/lang/Object
    //   51: astore 11
    //   53: aload 11
    //   55: iconst_0
    //   56: ldc 35
    //   58: aastore
    //   59: aload_3
    //   60: ldc 33
    //   62: aload 10
    //   64: aconst_null
    //   65: aconst_null
    //   66: aconst_null
    //   67: aconst_null
    //   68: ldc_w 326
    //   71: aload 11
    //   73: invokestatic 51	java/lang/String:format	(Ljava/lang/String;[Ljava/lang/Object;)Ljava/lang/String;
    //   76: iload_1
    //   77: invokestatic 330	java/lang/Integer:toString	(I)Ljava/lang/String;
    //   80: invokevirtual 334	android/database/sqlite/SQLiteDatabase:query	(Ljava/lang/String;[Ljava/lang/String;Ljava/lang/String;[Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;)Landroid/database/Cursor;
    //   83: astore 12
    //   85: aload 12
    //   87: astore 13
    //   89: new 122	java/util/ArrayList
    //   92: dup
    //   93: invokespecial 320	java/util/ArrayList:<init>	()V
    //   96: astore 14
    //   98: aload 13
    //   100: invokeinterface 339 1 0
    //   105: ifeq +52 -> 157
    //   108: aload 14
    //   110: new 372	fx
    //   113: dup
    //   114: aconst_null
    //   115: aload 13
    //   117: iconst_0
    //   118: invokeinterface 343 2 0
    //   123: aload 13
    //   125: iconst_1
    //   126: invokeinterface 343 2 0
    //   131: ldc_w 421
    //   134: invokespecial 424	fx:<init>	(Ljava/lang/String;JJLjava/lang/String;)V
    //   137: invokeinterface 183 2 0
    //   142: pop
    //   143: aload 13
    //   145: invokeinterface 348 1 0
    //   150: istore 32
    //   152: iload 32
    //   154: ifne -46 -> 108
    //   157: aload 13
    //   159: ifnull +10 -> 169
    //   162: aload 13
    //   164: invokeinterface 351 1 0
    //   169: iconst_3
    //   170: anewarray 47	java/lang/String
    //   173: astore 24
    //   175: aload 24
    //   177: iconst_0
    //   178: ldc 35
    //   180: aastore
    //   181: aload 24
    //   183: iconst_1
    //   184: ldc 41
    //   186: aastore
    //   187: aload 24
    //   189: iconst_2
    //   190: ldc 39
    //   192: aastore
    //   193: iconst_1
    //   194: anewarray 4	java/lang/Object
    //   197: astore 25
    //   199: aload 25
    //   201: iconst_0
    //   202: ldc 35
    //   204: aastore
    //   205: aload_3
    //   206: ldc 33
    //   208: aload 24
    //   210: aconst_null
    //   211: aconst_null
    //   212: aconst_null
    //   213: aconst_null
    //   214: ldc_w 326
    //   217: aload 25
    //   219: invokestatic 51	java/lang/String:format	(Ljava/lang/String;[Ljava/lang/Object;)Ljava/lang/String;
    //   222: iload_1
    //   223: invokestatic 330	java/lang/Integer:toString	(I)Ljava/lang/String;
    //   226: invokevirtual 334	android/database/sqlite/SQLiteDatabase:query	(Ljava/lang/String;[Ljava/lang/String;Ljava/lang/String;[Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;)Landroid/database/Cursor;
    //   229: astore 26
    //   231: aload 26
    //   233: invokeinterface 339 1 0
    //   238: ifeq +86 -> 324
    //   241: iconst_0
    //   242: istore 27
    //   244: aload 26
    //   246: checkcast 426	android/database/sqlite/SQLiteCursor
    //   249: invokevirtual 430	android/database/sqlite/SQLiteCursor:getWindow	()Landroid/database/CursorWindow;
    //   252: invokevirtual 435	android/database/CursorWindow:getNumRows	()I
    //   255: ifle +159 -> 414
    //   258: aload 14
    //   260: iload 27
    //   262: invokeinterface 438 2 0
    //   267: checkcast 372	fx
    //   270: aload 26
    //   272: iconst_1
    //   273: invokeinterface 441 2 0
    //   278: invokevirtual 443	fx:a	(Ljava/lang/String;)V
    //   281: aload 14
    //   283: iload 27
    //   285: invokeinterface 438 2 0
    //   290: checkcast 372	fx
    //   293: aload 26
    //   295: iconst_2
    //   296: invokeinterface 441 2 0
    //   301: invokevirtual 445	fx:b	(Ljava/lang/String;)V
    //   304: iload 27
    //   306: iconst_1
    //   307: iadd
    //   308: istore 29
    //   310: aload 26
    //   312: invokeinterface 348 1 0
    //   317: istore 30
    //   319: iload 30
    //   321: ifne +348 -> 669
    //   324: aload 26
    //   326: ifnull +10 -> 336
    //   329: aload 26
    //   331: invokeinterface 351 1 0
    //   336: aload 14
    //   338: astore 9
    //   340: goto -317 -> 23
    //   343: astore 6
    //   345: aload 6
    //   347: astore 7
    //   349: aconst_null
    //   350: astore 8
    //   352: aload_2
    //   353: astore 9
    //   355: new 155	java/lang/StringBuilder
    //   358: dup
    //   359: invokespecial 156	java/lang/StringBuilder:<init>	()V
    //   362: ldc_w 353
    //   365: invokevirtual 168	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   368: aload 7
    //   370: invokevirtual 356	android/database/sqlite/SQLiteException:getMessage	()Ljava/lang/String;
    //   373: invokevirtual 168	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   376: invokevirtual 177	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   379: invokestatic 118	fA:d	(Ljava/lang/String;)V
    //   382: aload 8
    //   384: ifnull -361 -> 23
    //   387: aload 8
    //   389: invokeinterface 351 1 0
    //   394: goto -371 -> 23
    //   397: astore 5
    //   399: aload 4
    //   401: ifnull +10 -> 411
    //   404: aload 4
    //   406: invokeinterface 351 1 0
    //   411: aload 5
    //   413: athrow
    //   414: iconst_1
    //   415: anewarray 4	java/lang/Object
    //   418: astore 28
    //   420: aload 28
    //   422: iconst_0
    //   423: aload 14
    //   425: iload 27
    //   427: invokeinterface 438 2 0
    //   432: checkcast 372	fx
    //   435: invokevirtual 374	fx:b	()J
    //   438: invokestatic 213	java/lang/Long:valueOf	(J)Ljava/lang/Long;
    //   441: aastore
    //   442: ldc_w 447
    //   445: aload 28
    //   447: invokestatic 51	java/lang/String:format	(Ljava/lang/String;[Ljava/lang/Object;)Ljava/lang/String;
    //   450: invokestatic 118	fA:d	(Ljava/lang/String;)V
    //   453: goto -149 -> 304
    //   456: astore 16
    //   458: aload 26
    //   460: astore 13
    //   462: new 155	java/lang/StringBuilder
    //   465: dup
    //   466: invokespecial 156	java/lang/StringBuilder:<init>	()V
    //   469: ldc_w 449
    //   472: invokevirtual 168	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   475: aload 16
    //   477: invokevirtual 356	android/database/sqlite/SQLiteException:getMessage	()Ljava/lang/String;
    //   480: invokevirtual 168	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   483: invokevirtual 177	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   486: invokestatic 118	fA:d	(Ljava/lang/String;)V
    //   489: new 122	java/util/ArrayList
    //   492: dup
    //   493: invokespecial 320	java/util/ArrayList:<init>	()V
    //   496: astore 18
    //   498: iconst_0
    //   499: istore 19
    //   501: aload 14
    //   503: invokeinterface 450 1 0
    //   508: astore 20
    //   510: aload 20
    //   512: invokeinterface 147 1 0
    //   517: ifeq +35 -> 552
    //   520: aload 20
    //   522: invokeinterface 151 1 0
    //   527: checkcast 372	fx
    //   530: astore 21
    //   532: aload 21
    //   534: invokevirtual 451	fx:a	()Ljava/lang/String;
    //   537: invokestatic 454	android/text/TextUtils:isEmpty	(Ljava/lang/CharSequence;)Z
    //   540: istore 22
    //   542: iload 22
    //   544: ifeq +30 -> 574
    //   547: iload 19
    //   549: ifeq +22 -> 571
    //   552: aload 13
    //   554: ifnull +10 -> 564
    //   557: aload 13
    //   559: invokeinterface 351 1 0
    //   564: aload 18
    //   566: astore 9
    //   568: goto -545 -> 23
    //   571: iconst_1
    //   572: istore 19
    //   574: aload 18
    //   576: aload 21
    //   578: invokeinterface 183 2 0
    //   583: pop
    //   584: goto -74 -> 510
    //   587: astore 17
    //   589: aload 13
    //   591: ifnull +10 -> 601
    //   594: aload 13
    //   596: invokeinterface 351 1 0
    //   601: aload 17
    //   603: athrow
    //   604: astore 17
    //   606: aload 26
    //   608: astore 13
    //   610: goto -21 -> 589
    //   613: astore 16
    //   615: goto -153 -> 462
    //   618: astore 5
    //   620: aload 13
    //   622: astore 4
    //   624: goto -225 -> 399
    //   627: astore 5
    //   629: aload 8
    //   631: astore 4
    //   633: goto -234 -> 399
    //   636: astore 33
    //   638: aload 33
    //   640: astore 7
    //   642: aload 13
    //   644: astore 8
    //   646: aload_2
    //   647: astore 9
    //   649: goto -294 -> 355
    //   652: astore 15
    //   654: aload 15
    //   656: astore 7
    //   658: aload 13
    //   660: astore 8
    //   662: aload 14
    //   664: astore 9
    //   666: goto -311 -> 355
    //   669: iload 29
    //   671: istore 27
    //   673: goto -429 -> 244
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	676	0	this	fC
    //   0	676	1	paramInt	int
    //   7	640	2	localArrayList1	ArrayList
    //   15	191	3	localSQLiteDatabase	SQLiteDatabase
    //   27	605	4	localObject1	Object
    //   397	15	5	localObject2	Object
    //   618	1	5	localObject3	Object
    //   627	1	5	localObject4	Object
    //   343	3	6	localSQLiteException1	SQLiteException
    //   347	310	7	localObject5	Object
    //   350	311	8	localObject6	Object
    //   21	644	9	localObject7	Object
    //   33	30	10	arrayOfString1	String[]
    //   51	21	11	arrayOfObject1	Object[]
    //   83	3	12	localCursor1	Cursor
    //   87	572	13	localObject8	Object
    //   96	567	14	localArrayList2	ArrayList
    //   652	3	15	localSQLiteException2	SQLiteException
    //   456	20	16	localSQLiteException3	SQLiteException
    //   613	1	16	localSQLiteException4	SQLiteException
    //   587	15	17	localObject9	Object
    //   604	1	17	localObject10	Object
    //   496	79	18	localArrayList3	ArrayList
    //   499	74	19	m	int
    //   508	13	20	localIterator	Iterator
    //   530	47	21	localfx	fx
    //   540	3	22	bool1	boolean
    //   173	36	24	arrayOfString2	String[]
    //   197	21	25	arrayOfObject2	Object[]
    //   229	378	26	localCursor2	Cursor
    //   242	430	27	n	int
    //   418	28	28	arrayOfObject3	Object[]
    //   308	362	29	i1	int
    //   317	3	30	bool2	boolean
    //   150	3	32	bool3	boolean
    //   636	3	33	localSQLiteException5	SQLiteException
    // Exception table:
    //   from	to	target	type
    //   29	85	343	android/database/sqlite/SQLiteException
    //   29	85	397	finally
    //   231	319	456	android/database/sqlite/SQLiteException
    //   414	453	456	android/database/sqlite/SQLiteException
    //   169	231	587	finally
    //   462	542	587	finally
    //   574	584	587	finally
    //   231	319	604	finally
    //   414	453	604	finally
    //   169	231	613	android/database/sqlite/SQLiteException
    //   89	98	618	finally
    //   98	152	618	finally
    //   355	382	627	finally
    //   89	98	636	android/database/sqlite/SQLiteException
    //   98	152	652	android/database/sqlite/SQLiteException
  }
  
  public void c()
  {
    boolean bool = true;
    fA.c("Dispatch running...");
    if (!this.c.a()) {}
    for (;;)
    {
      return;
      List localList = b(20);
      if (localList.isEmpty())
      {
        fA.c("...nothing to dispatch");
        this.d.a(bool);
      }
      else
      {
        if (this.g == null) {
          this.g = new fB("_t=dispatch&_v=ma4.0.4", false);
        }
        if (b() <= localList.size()) {}
        for (;;)
        {
          int m = this.c.a(localList, this.g, bool);
          fA.c("sent " + m + " of " + localList.size() + " hits");
          a(localList.subList(0, Math.min(m, localList.size())));
          if ((m != localList.size()) || (b() <= 0)) {
            break label207;
          }
          fl.a(this.e).e();
          break;
          bool = false;
        }
        label207:
        this.g = null;
      }
    }
  }
  
  public gn d()
  {
    return this.c;
  }
}


/* Location:           C:\Users\dreadiscool\Desktop\tools\classes-dex2jar.jar
 * Qualified Name:     fC
 * JD-Core Version:    0.7.0.1
 */