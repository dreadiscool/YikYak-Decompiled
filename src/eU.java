import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteException;
import android.text.TextUtils;
import com.google.android.gms.analytics.internal.Command;
import com.google.android.gms.common.util.VisibleForTesting;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Set;
import org.apache.http.impl.client.DefaultHttpClient;

class eU
  implements ed
{
  private static final String a;
  private final eW b;
  private volatile em c;
  private final ee d;
  private final Context e;
  private final String f;
  private long g;
  private ej h;
  
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
  
  eU(ee paramee, Context paramContext)
  {
    this(paramee, paramContext, "google_analytics_v2.db");
  }
  
  @VisibleForTesting
  eU(ee paramee, Context paramContext, String paramString)
  {
    this.e = paramContext.getApplicationContext();
    this.f = paramString;
    this.d = paramee;
    this.h = new eV(this);
    this.b = new eW(this, this.e, this.f);
    this.c = new fa(new DefaultHttpClient(), this.e);
    this.g = 0L;
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
        eO.d(paramString);
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
      localArrayList.add(eN.a((String)localEntry.getKey()) + "=" + eN.a((String)localEntry.getValue()));
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
          eO.d("Empty path: not sending hit");
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
        eO.d("Error storing hit");
      }
    }
  }
  
  private void a(Map<String, String> paramMap, Collection<Command> paramCollection)
  {
    String str = "&_v".substring(1);
    if (paramCollection != null)
    {
      Iterator localIterator = paramCollection.iterator();
      while (localIterator.hasNext())
      {
        Command localCommand = (Command)localIterator.next();
        if ("appendVersion".equals(localCommand.a())) {
          paramMap.put(str, localCommand.b());
        }
      }
    }
  }
  
  private void f()
  {
    int i = 1 + (-2000 + d());
    if (i > 0)
    {
      List localList = a(i);
      eO.c("Store full, deleting " + localList.size() + " hits to make room.");
      a((String[])localList.toArray(new String[0]));
    }
  }
  
  /* Error */
  List<String> a(int paramInt)
  {
    // Byte code:
    //   0: new 109	java/util/ArrayList
    //   3: dup
    //   4: invokespecial 287	java/util/ArrayList:<init>	()V
    //   7: astore_2
    //   8: iload_1
    //   9: ifgt +15 -> 24
    //   12: ldc_w 289
    //   15: invokestatic 105	eO:d	(Ljava/lang/String;)V
    //   18: aload_2
    //   19: astore 7
    //   21: aload 7
    //   23: areturn
    //   24: aload_0
    //   25: ldc_w 291
    //   28: invokespecial 185	eU:a	(Ljava/lang/String;)Landroid/database/sqlite/SQLiteDatabase;
    //   31: astore_3
    //   32: aload_3
    //   33: ifnonnull +9 -> 42
    //   36: aload_2
    //   37: astore 7
    //   39: goto -18 -> 21
    //   42: iconst_1
    //   43: anewarray 39	java/lang/String
    //   46: astore 8
    //   48: aload 8
    //   50: iconst_0
    //   51: ldc 27
    //   53: aastore
    //   54: iconst_1
    //   55: anewarray 4	java/lang/Object
    //   58: astore 9
    //   60: aload 9
    //   62: iconst_0
    //   63: ldc 27
    //   65: aastore
    //   66: aload_3
    //   67: ldc 25
    //   69: aload 8
    //   71: aconst_null
    //   72: aconst_null
    //   73: aconst_null
    //   74: aconst_null
    //   75: ldc_w 293
    //   78: aload 9
    //   80: invokestatic 43	java/lang/String:format	(Ljava/lang/String;[Ljava/lang/Object;)Ljava/lang/String;
    //   83: iload_1
    //   84: invokestatic 297	java/lang/Integer:toString	(I)Ljava/lang/String;
    //   87: invokevirtual 301	android/database/sqlite/SQLiteDatabase:query	(Ljava/lang/String;[Ljava/lang/String;Ljava/lang/String;[Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;)Landroid/database/Cursor;
    //   90: astore 10
    //   92: aload 10
    //   94: astore 5
    //   96: aload 5
    //   98: invokeinterface 306 1 0
    //   103: ifeq +35 -> 138
    //   106: aload_2
    //   107: aload 5
    //   109: iconst_0
    //   110: invokeinterface 310 2 0
    //   115: invokestatic 313	java/lang/String:valueOf	(J)Ljava/lang/String;
    //   118: invokeinterface 170 2 0
    //   123: pop
    //   124: aload 5
    //   126: invokeinterface 316 1 0
    //   131: istore 12
    //   133: iload 12
    //   135: ifne -29 -> 106
    //   138: aload 5
    //   140: ifnull +10 -> 150
    //   143: aload 5
    //   145: invokeinterface 319 1 0
    //   150: aload_2
    //   151: astore 7
    //   153: goto -132 -> 21
    //   156: astore 6
    //   158: aconst_null
    //   159: astore 5
    //   161: new 142	java/lang/StringBuilder
    //   164: dup
    //   165: invokespecial 143	java/lang/StringBuilder:<init>	()V
    //   168: ldc_w 321
    //   171: invokevirtual 155	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   174: aload 6
    //   176: invokevirtual 324	android/database/sqlite/SQLiteException:getMessage	()Ljava/lang/String;
    //   179: invokevirtual 155	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   182: invokevirtual 164	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   185: invokestatic 105	eO:d	(Ljava/lang/String;)V
    //   188: aload 5
    //   190: ifnull -40 -> 150
    //   193: aload 5
    //   195: invokeinterface 319 1 0
    //   200: goto -50 -> 150
    //   203: astore 4
    //   205: aconst_null
    //   206: astore 5
    //   208: aload 5
    //   210: ifnull +10 -> 220
    //   213: aload 5
    //   215: invokeinterface 319 1 0
    //   220: aload 4
    //   222: athrow
    //   223: astore 4
    //   225: goto -17 -> 208
    //   228: astore 6
    //   230: goto -69 -> 161
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	233	0	this	eU
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
  
  public void a()
  {
    eO.c("Dispatch running...");
    if (!this.c.a()) {}
    for (;;)
    {
      return;
      List localList = b(40);
      if (localList.isEmpty())
      {
        eO.c("...nothing to dispatch");
        this.d.a(true);
      }
      else
      {
        int i = this.c.a(localList);
        eO.c("sent " + i + " of " + localList.size() + " hits");
        a(localList.subList(0, Math.min(i, localList.size())));
        if ((i == localList.size()) && (d() > 0)) {
          et.a().c();
        }
      }
    }
  }
  
  public void a(long paramLong)
  {
    boolean bool = true;
    SQLiteDatabase localSQLiteDatabase = a("Error opening database for clearHits");
    ee localee;
    if (localSQLiteDatabase != null)
    {
      if (paramLong != 0L) {
        break label54;
      }
      localSQLiteDatabase.delete("hits2", null, null);
      localee = this.d;
      if (d() != 0) {
        break label87;
      }
    }
    for (;;)
    {
      localee.a(bool);
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
  void a(Collection<eM> paramCollection)
  {
    if ((paramCollection == null) || (paramCollection.isEmpty())) {
      eO.d("Empty/Null collection passed to deleteHits.");
    }
    for (;;)
    {
      return;
      String[] arrayOfString = new String[paramCollection.size()];
      Iterator localIterator = paramCollection.iterator();
      int j;
      for (int i = 0; localIterator.hasNext(); i = j)
      {
        eM localeM = (eM)localIterator.next();
        j = i + 1;
        arrayOfString[i] = String.valueOf(localeM.b());
      }
      a(arrayOfString);
    }
  }
  
  public void a(Map<String, String> paramMap, long paramLong, String paramString, Collection<Command> paramCollection)
  {
    c();
    f();
    a(paramMap, paramCollection);
    a(paramMap, paramLong, paramString);
  }
  
  void a(String[] paramArrayOfString)
  {
    boolean bool = true;
    if ((paramArrayOfString == null) || (paramArrayOfString.length == 0)) {
      eO.d("Empty hitIds passed to deleteHits.");
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
        ee localee = this.d;
        if (d() != 0) {
          break label126;
        }
        localee.a(bool);
      }
      catch (SQLiteException localSQLiteException)
      {
        eO.d("Error deleting hits " + paramArrayOfString);
      }
      break;
      label126:
      bool = false;
    }
  }
  
  public em b()
  {
    return this.c;
  }
  
  /* Error */
  public List<eM> b(int paramInt)
  {
    // Byte code:
    //   0: new 109	java/util/ArrayList
    //   3: dup
    //   4: invokespecial 287	java/util/ArrayList:<init>	()V
    //   7: astore_2
    //   8: aload_0
    //   9: ldc_w 419
    //   12: invokespecial 185	eU:a	(Ljava/lang/String;)Landroid/database/sqlite/SQLiteDatabase;
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
    //   30: anewarray 39	java/lang/String
    //   33: astore 10
    //   35: aload 10
    //   37: iconst_0
    //   38: ldc 27
    //   40: aastore
    //   41: aload 10
    //   43: iconst_1
    //   44: ldc 29
    //   46: aastore
    //   47: iconst_1
    //   48: anewarray 4	java/lang/Object
    //   51: astore 11
    //   53: aload 11
    //   55: iconst_0
    //   56: ldc 27
    //   58: aastore
    //   59: aload_3
    //   60: ldc 25
    //   62: aload 10
    //   64: aconst_null
    //   65: aconst_null
    //   66: aconst_null
    //   67: aconst_null
    //   68: ldc_w 293
    //   71: aload 11
    //   73: invokestatic 43	java/lang/String:format	(Ljava/lang/String;[Ljava/lang/Object;)Ljava/lang/String;
    //   76: iload_1
    //   77: invokestatic 297	java/lang/Integer:toString	(I)Ljava/lang/String;
    //   80: invokevirtual 301	android/database/sqlite/SQLiteDatabase:query	(Ljava/lang/String;[Ljava/lang/String;Ljava/lang/String;[Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;)Landroid/database/Cursor;
    //   83: astore 12
    //   85: aload 12
    //   87: astore 13
    //   89: new 109	java/util/ArrayList
    //   92: dup
    //   93: invokespecial 287	java/util/ArrayList:<init>	()V
    //   96: astore 14
    //   98: aload 13
    //   100: invokeinterface 306 1 0
    //   105: ifeq +49 -> 154
    //   108: aload 14
    //   110: new 383	eM
    //   113: dup
    //   114: aconst_null
    //   115: aload 13
    //   117: iconst_0
    //   118: invokeinterface 310 2 0
    //   123: aload 13
    //   125: iconst_1
    //   126: invokeinterface 310 2 0
    //   131: invokespecial 422	eM:<init>	(Ljava/lang/String;JJ)V
    //   134: invokeinterface 170 2 0
    //   139: pop
    //   140: aload 13
    //   142: invokeinterface 316 1 0
    //   147: istore 32
    //   149: iload 32
    //   151: ifne -43 -> 108
    //   154: aload 13
    //   156: ifnull +10 -> 166
    //   159: aload 13
    //   161: invokeinterface 319 1 0
    //   166: iconst_3
    //   167: anewarray 39	java/lang/String
    //   170: astore 24
    //   172: aload 24
    //   174: iconst_0
    //   175: ldc 27
    //   177: aastore
    //   178: aload 24
    //   180: iconst_1
    //   181: ldc 33
    //   183: aastore
    //   184: aload 24
    //   186: iconst_2
    //   187: ldc 31
    //   189: aastore
    //   190: iconst_1
    //   191: anewarray 4	java/lang/Object
    //   194: astore 25
    //   196: aload 25
    //   198: iconst_0
    //   199: ldc 27
    //   201: aastore
    //   202: aload_3
    //   203: ldc 25
    //   205: aload 24
    //   207: aconst_null
    //   208: aconst_null
    //   209: aconst_null
    //   210: aconst_null
    //   211: ldc_w 293
    //   214: aload 25
    //   216: invokestatic 43	java/lang/String:format	(Ljava/lang/String;[Ljava/lang/Object;)Ljava/lang/String;
    //   219: iload_1
    //   220: invokestatic 297	java/lang/Integer:toString	(I)Ljava/lang/String;
    //   223: invokevirtual 301	android/database/sqlite/SQLiteDatabase:query	(Ljava/lang/String;[Ljava/lang/String;Ljava/lang/String;[Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;)Landroid/database/Cursor;
    //   226: astore 26
    //   228: aload 26
    //   230: invokeinterface 306 1 0
    //   235: ifeq +86 -> 321
    //   238: iconst_0
    //   239: istore 27
    //   241: aload 26
    //   243: checkcast 424	android/database/sqlite/SQLiteCursor
    //   246: invokevirtual 428	android/database/sqlite/SQLiteCursor:getWindow	()Landroid/database/CursorWindow;
    //   249: invokevirtual 433	android/database/CursorWindow:getNumRows	()I
    //   252: ifle +159 -> 411
    //   255: aload 14
    //   257: iload 27
    //   259: invokeinterface 436 2 0
    //   264: checkcast 383	eM
    //   267: aload 26
    //   269: iconst_1
    //   270: invokeinterface 439 2 0
    //   275: invokevirtual 441	eM:a	(Ljava/lang/String;)V
    //   278: aload 14
    //   280: iload 27
    //   282: invokeinterface 436 2 0
    //   287: checkcast 383	eM
    //   290: aload 26
    //   292: iconst_2
    //   293: invokeinterface 439 2 0
    //   298: invokevirtual 443	eM:b	(Ljava/lang/String;)V
    //   301: iload 27
    //   303: iconst_1
    //   304: iadd
    //   305: istore 29
    //   307: aload 26
    //   309: invokeinterface 316 1 0
    //   314: istore 30
    //   316: iload 30
    //   318: ifne +348 -> 666
    //   321: aload 26
    //   323: ifnull +10 -> 333
    //   326: aload 26
    //   328: invokeinterface 319 1 0
    //   333: aload 14
    //   335: astore 9
    //   337: goto -314 -> 23
    //   340: astore 6
    //   342: aload 6
    //   344: astore 7
    //   346: aconst_null
    //   347: astore 8
    //   349: aload_2
    //   350: astore 9
    //   352: new 142	java/lang/StringBuilder
    //   355: dup
    //   356: invokespecial 143	java/lang/StringBuilder:<init>	()V
    //   359: ldc_w 321
    //   362: invokevirtual 155	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   365: aload 7
    //   367: invokevirtual 324	android/database/sqlite/SQLiteException:getMessage	()Ljava/lang/String;
    //   370: invokevirtual 155	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   373: invokevirtual 164	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   376: invokestatic 105	eO:d	(Ljava/lang/String;)V
    //   379: aload 8
    //   381: ifnull -358 -> 23
    //   384: aload 8
    //   386: invokeinterface 319 1 0
    //   391: goto -368 -> 23
    //   394: astore 5
    //   396: aload 4
    //   398: ifnull +10 -> 408
    //   401: aload 4
    //   403: invokeinterface 319 1 0
    //   408: aload 5
    //   410: athrow
    //   411: iconst_1
    //   412: anewarray 4	java/lang/Object
    //   415: astore 28
    //   417: aload 28
    //   419: iconst_0
    //   420: aload 14
    //   422: iload 27
    //   424: invokeinterface 436 2 0
    //   429: checkcast 383	eM
    //   432: invokevirtual 386	eM:b	()J
    //   435: invokestatic 200	java/lang/Long:valueOf	(J)Ljava/lang/Long;
    //   438: aastore
    //   439: ldc_w 445
    //   442: aload 28
    //   444: invokestatic 43	java/lang/String:format	(Ljava/lang/String;[Ljava/lang/Object;)Ljava/lang/String;
    //   447: invokestatic 105	eO:d	(Ljava/lang/String;)V
    //   450: goto -149 -> 301
    //   453: astore 16
    //   455: aload 26
    //   457: astore 13
    //   459: new 142	java/lang/StringBuilder
    //   462: dup
    //   463: invokespecial 143	java/lang/StringBuilder:<init>	()V
    //   466: ldc_w 447
    //   469: invokevirtual 155	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   472: aload 16
    //   474: invokevirtual 324	android/database/sqlite/SQLiteException:getMessage	()Ljava/lang/String;
    //   477: invokevirtual 155	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   480: invokevirtual 164	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   483: invokestatic 105	eO:d	(Ljava/lang/String;)V
    //   486: new 109	java/util/ArrayList
    //   489: dup
    //   490: invokespecial 287	java/util/ArrayList:<init>	()V
    //   493: astore 18
    //   495: iconst_0
    //   496: istore 19
    //   498: aload 14
    //   500: invokeinterface 448 1 0
    //   505: astore 20
    //   507: aload 20
    //   509: invokeinterface 134 1 0
    //   514: ifeq +35 -> 549
    //   517: aload 20
    //   519: invokeinterface 138 1 0
    //   524: checkcast 383	eM
    //   527: astore 21
    //   529: aload 21
    //   531: invokevirtual 449	eM:a	()Ljava/lang/String;
    //   534: invokestatic 452	android/text/TextUtils:isEmpty	(Ljava/lang/CharSequence;)Z
    //   537: istore 22
    //   539: iload 22
    //   541: ifeq +30 -> 571
    //   544: iload 19
    //   546: ifeq +22 -> 568
    //   549: aload 13
    //   551: ifnull +10 -> 561
    //   554: aload 13
    //   556: invokeinterface 319 1 0
    //   561: aload 18
    //   563: astore 9
    //   565: goto -542 -> 23
    //   568: iconst_1
    //   569: istore 19
    //   571: aload 18
    //   573: aload 21
    //   575: invokeinterface 170 2 0
    //   580: pop
    //   581: goto -74 -> 507
    //   584: astore 17
    //   586: aload 13
    //   588: ifnull +10 -> 598
    //   591: aload 13
    //   593: invokeinterface 319 1 0
    //   598: aload 17
    //   600: athrow
    //   601: astore 17
    //   603: aload 26
    //   605: astore 13
    //   607: goto -21 -> 586
    //   610: astore 16
    //   612: goto -153 -> 459
    //   615: astore 5
    //   617: aload 13
    //   619: astore 4
    //   621: goto -225 -> 396
    //   624: astore 5
    //   626: aload 8
    //   628: astore 4
    //   630: goto -234 -> 396
    //   633: astore 33
    //   635: aload 33
    //   637: astore 7
    //   639: aload 13
    //   641: astore 8
    //   643: aload_2
    //   644: astore 9
    //   646: goto -294 -> 352
    //   649: astore 15
    //   651: aload 15
    //   653: astore 7
    //   655: aload 13
    //   657: astore 8
    //   659: aload 14
    //   661: astore 9
    //   663: goto -311 -> 352
    //   666: iload 29
    //   668: istore 27
    //   670: goto -429 -> 241
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	673	0	this	eU
    //   0	673	1	paramInt	int
    //   7	637	2	localArrayList1	ArrayList
    //   15	188	3	localSQLiteDatabase	SQLiteDatabase
    //   27	602	4	localObject1	Object
    //   394	15	5	localObject2	Object
    //   615	1	5	localObject3	Object
    //   624	1	5	localObject4	Object
    //   340	3	6	localSQLiteException1	SQLiteException
    //   344	310	7	localObject5	Object
    //   347	311	8	localObject6	Object
    //   21	641	9	localObject7	Object
    //   33	30	10	arrayOfString1	String[]
    //   51	21	11	arrayOfObject1	Object[]
    //   83	3	12	localCursor1	Cursor
    //   87	569	13	localObject8	Object
    //   96	564	14	localArrayList2	ArrayList
    //   649	3	15	localSQLiteException2	SQLiteException
    //   453	20	16	localSQLiteException3	SQLiteException
    //   610	1	16	localSQLiteException4	SQLiteException
    //   584	15	17	localObject9	Object
    //   601	1	17	localObject10	Object
    //   493	79	18	localArrayList3	ArrayList
    //   496	74	19	i	int
    //   505	13	20	localIterator	Iterator
    //   527	47	21	localeM	eM
    //   537	3	22	bool1	boolean
    //   170	36	24	arrayOfString2	String[]
    //   194	21	25	arrayOfObject2	Object[]
    //   226	378	26	localCursor2	Cursor
    //   239	430	27	j	int
    //   415	28	28	arrayOfObject3	Object[]
    //   305	362	29	k	int
    //   314	3	30	bool2	boolean
    //   147	3	32	bool3	boolean
    //   633	3	33	localSQLiteException5	SQLiteException
    // Exception table:
    //   from	to	target	type
    //   29	85	340	android/database/sqlite/SQLiteException
    //   29	85	394	finally
    //   228	316	453	android/database/sqlite/SQLiteException
    //   411	450	453	android/database/sqlite/SQLiteException
    //   166	228	584	finally
    //   459	539	584	finally
    //   571	581	584	finally
    //   228	316	601	finally
    //   411	450	601	finally
    //   166	228	610	android/database/sqlite/SQLiteException
    //   89	98	615	finally
    //   98	149	615	finally
    //   352	379	624	finally
    //   89	98	633	android/database/sqlite/SQLiteException
    //   98	149	649	android/database/sqlite/SQLiteException
  }
  
  int c()
  {
    boolean bool = true;
    int i = 0;
    long l1 = this.h.a();
    if (l1 <= 86400000L + this.g) {}
    SQLiteDatabase localSQLiteDatabase;
    do
    {
      return i;
      this.g = l1;
      localSQLiteDatabase = a("Error opening database for deleteStaleHits.");
    } while (localSQLiteDatabase == null);
    long l2 = this.h.a() - 2592000000L;
    String[] arrayOfString = new String[bool];
    arrayOfString[i] = Long.toString(l2);
    int j = localSQLiteDatabase.delete("hits2", "HIT_TIME < ?", arrayOfString);
    ee localee = this.d;
    if (d() == 0) {}
    for (;;)
    {
      localee.a(bool);
      i = j;
      break;
      bool = false;
    }
  }
  
  int d()
  {
    Cursor localCursor = null;
    int i = 0;
    SQLiteDatabase localSQLiteDatabase = a("Error opening database for getNumStoredHits.");
    if (localSQLiteDatabase == null) {}
    for (;;)
    {
      return i;
      try
      {
        localCursor = localSQLiteDatabase.rawQuery("SELECT COUNT(*) from hits2", null);
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
        eO.d("Error getting numStoredHits");
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
}


/* Location:           C:\Users\dreadiscool\Desktop\tools\classes-dex2jar.jar
 * Qualified Name:     eU
 * JD-Core Version:    0.7.0.1
 */