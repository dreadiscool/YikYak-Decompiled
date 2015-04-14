import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteException;

class uK
{
  private static final String a = "CREATE TABLE " + uM.a.a() + " (_id INTEGER PRIMARY KEY AUTOINCREMENT, " + "data" + " STRING NOT NULL, " + "created_at" + " INTEGER NOT NULL);";
  private static final String b = "CREATE TABLE " + uM.b.a() + " (_id INTEGER PRIMARY KEY AUTOINCREMENT, " + "data" + " STRING NOT NULL, " + "created_at" + " INTEGER NOT NULL);";
  private static final String c = "CREATE INDEX IF NOT EXISTS time_idx ON " + uM.a.a() + " (" + "created_at" + ");";
  private static final String d = "CREATE INDEX IF NOT EXISTS time_idx ON " + uM.b.a() + " (" + "created_at" + ");";
  private final uL e;
  
  public uK(Context paramContext)
  {
    this(paramContext, "mixpanel");
  }
  
  public uK(Context paramContext, String paramString)
  {
    this.e = new uL(paramContext, paramString);
  }
  
  /* Error */
  public int a(org.json.JSONObject paramJSONObject, uM paramuM)
  {
    // Byte code:
    //   0: aconst_null
    //   1: astore_3
    //   2: aload_2
    //   3: invokevirtual 32	uM:a	()Ljava/lang/String;
    //   6: astore 4
    //   8: bipush 255
    //   10: istore 5
    //   12: aload_0
    //   13: getfield 73	uK:e	LuL;
    //   16: invokevirtual 80	uL:getWritableDatabase	()Landroid/database/sqlite/SQLiteDatabase;
    //   19: astore 10
    //   21: new 82	android/content/ContentValues
    //   24: dup
    //   25: invokespecial 83	android/content/ContentValues:<init>	()V
    //   28: astore 11
    //   30: aload 11
    //   32: ldc 36
    //   34: aload_1
    //   35: invokevirtual 86	org/json/JSONObject:toString	()Ljava/lang/String;
    //   38: invokevirtual 90	android/content/ContentValues:put	(Ljava/lang/String;Ljava/lang/String;)V
    //   41: aload 11
    //   43: ldc 40
    //   45: invokestatic 96	java/lang/System:currentTimeMillis	()J
    //   48: invokestatic 102	java/lang/Long:valueOf	(J)Ljava/lang/Long;
    //   51: invokevirtual 105	android/content/ContentValues:put	(Ljava/lang/String;Ljava/lang/Long;)V
    //   54: aload 10
    //   56: aload 4
    //   58: aconst_null
    //   59: aload 11
    //   61: invokevirtual 111	android/database/sqlite/SQLiteDatabase:insert	(Ljava/lang/String;Ljava/lang/String;Landroid/content/ContentValues;)J
    //   64: pop2
    //   65: aload 10
    //   67: new 15	java/lang/StringBuilder
    //   70: dup
    //   71: invokespecial 18	java/lang/StringBuilder:<init>	()V
    //   74: ldc 113
    //   76: invokevirtual 24	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   79: aload 4
    //   81: invokevirtual 24	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   84: invokevirtual 45	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   87: aconst_null
    //   88: invokevirtual 117	android/database/sqlite/SQLiteDatabase:rawQuery	(Ljava/lang/String;[Ljava/lang/String;)Landroid/database/Cursor;
    //   91: astore 14
    //   93: aload 14
    //   95: astore 8
    //   97: aload 8
    //   99: invokeinterface 123 1 0
    //   104: pop
    //   105: aload 8
    //   107: iconst_0
    //   108: invokeinterface 127 2 0
    //   113: istore 17
    //   115: iload 17
    //   117: istore 5
    //   119: aload 8
    //   121: ifnull +10 -> 131
    //   124: aload 8
    //   126: invokeinterface 130 1 0
    //   131: aload_0
    //   132: getfield 73	uK:e	LuL;
    //   135: invokevirtual 131	uL:close	()V
    //   138: iload 5
    //   140: ireturn
    //   141: astore 7
    //   143: aconst_null
    //   144: astore 8
    //   146: new 15	java/lang/StringBuilder
    //   149: dup
    //   150: invokespecial 18	java/lang/StringBuilder:<init>	()V
    //   153: ldc 133
    //   155: invokevirtual 24	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   158: aload 4
    //   160: invokevirtual 24	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   163: ldc 135
    //   165: invokevirtual 24	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   168: invokevirtual 45	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   171: pop
    //   172: aload 8
    //   174: ifnull +72 -> 246
    //   177: aload 8
    //   179: invokeinterface 130 1 0
    //   184: aload_0
    //   185: getfield 73	uK:e	LuL;
    //   188: invokevirtual 137	uL:a	()V
    //   191: aload_3
    //   192: ifnull +9 -> 201
    //   195: aload_3
    //   196: invokeinterface 130 1 0
    //   201: aload_0
    //   202: getfield 73	uK:e	LuL;
    //   205: invokevirtual 131	uL:close	()V
    //   208: goto -70 -> 138
    //   211: astore 6
    //   213: aload_3
    //   214: ifnull +9 -> 223
    //   217: aload_3
    //   218: invokeinterface 130 1 0
    //   223: aload_0
    //   224: getfield 73	uK:e	LuL;
    //   227: invokevirtual 131	uL:close	()V
    //   230: aload 6
    //   232: athrow
    //   233: astore 6
    //   235: aload 8
    //   237: astore_3
    //   238: goto -25 -> 213
    //   241: astore 15
    //   243: goto -97 -> 146
    //   246: aload 8
    //   248: astore_3
    //   249: goto -65 -> 184
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	252	0	this	uK
    //   0	252	1	paramJSONObject	org.json.JSONObject
    //   0	252	2	paramuM	uM
    //   1	248	3	localObject1	Object
    //   6	153	4	str	String
    //   10	129	5	i	int
    //   211	20	6	localObject2	Object
    //   233	1	6	localObject3	Object
    //   141	1	7	localSQLiteException1	SQLiteException
    //   95	152	8	localCursor1	android.database.Cursor
    //   19	47	10	localSQLiteDatabase	SQLiteDatabase
    //   28	32	11	localContentValues	android.content.ContentValues
    //   91	3	14	localCursor2	android.database.Cursor
    //   241	1	15	localSQLiteException2	SQLiteException
    //   113	3	17	j	int
    // Exception table:
    //   from	to	target	type
    //   12	93	141	android/database/sqlite/SQLiteException
    //   12	93	211	finally
    //   184	191	211	finally
    //   97	115	233	finally
    //   146	184	233	finally
    //   97	115	241	android/database/sqlite/SQLiteException
  }
  
  public void a()
  {
    this.e.a();
  }
  
  public void a(long paramLong, uM paramuM)
  {
    String str = paramuM.a();
    try
    {
      this.e.getWritableDatabase().delete(str, "created_at <= " + paramLong, null);
      return;
    }
    catch (SQLiteException localSQLiteException)
    {
      for (;;)
      {
        new StringBuilder().append("Could not clean timed-out Mixpanel records from ").append(str).append(". Re-initializing database.").toString();
        this.e.a();
        this.e.close();
      }
    }
    finally
    {
      this.e.close();
    }
  }
  
  public void a(String paramString, uM paramuM)
  {
    String str = paramuM.a();
    try
    {
      this.e.getWritableDatabase().delete(str, "_id <= " + paramString, null);
      return;
    }
    catch (SQLiteException localSQLiteException)
    {
      for (;;)
      {
        new StringBuilder().append("Could not clean sent Mixpanel records from ").append(str).append(". Re-initializing database.").toString();
        this.e.a();
        this.e.close();
      }
    }
    finally
    {
      this.e.close();
    }
  }
  
  /* Error */
  public String[] a(uM paramuM)
  {
    // Byte code:
    //   0: aconst_null
    //   1: astore_2
    //   2: aload_1
    //   3: invokevirtual 32	uM:a	()Ljava/lang/String;
    //   6: astore_3
    //   7: aload_0
    //   8: getfield 73	uK:e	LuL;
    //   11: invokevirtual 160	uL:getReadableDatabase	()Landroid/database/sqlite/SQLiteDatabase;
    //   14: new 15	java/lang/StringBuilder
    //   17: dup
    //   18: invokespecial 18	java/lang/StringBuilder:<init>	()V
    //   21: ldc 162
    //   23: invokevirtual 24	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   26: aload_3
    //   27: invokevirtual 24	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   30: ldc 164
    //   32: invokevirtual 24	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   35: ldc 40
    //   37: invokevirtual 24	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   40: ldc 166
    //   42: invokevirtual 24	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   45: invokevirtual 45	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   48: aconst_null
    //   49: invokevirtual 117	android/database/sqlite/SQLiteDatabase:rawQuery	(Ljava/lang/String;[Ljava/lang/String;)Landroid/database/Cursor;
    //   52: astore 12
    //   54: aload 12
    //   56: astore 5
    //   58: new 168	org/json/JSONArray
    //   61: dup
    //   62: invokespecial 169	org/json/JSONArray:<init>	()V
    //   65: astore 13
    //   67: aconst_null
    //   68: astore 14
    //   70: aload 5
    //   72: invokeinterface 172 1 0
    //   77: ifeq +72 -> 149
    //   80: aload 5
    //   82: invokeinterface 175 1 0
    //   87: ifeq +25 -> 112
    //   90: aload 5
    //   92: aload 5
    //   94: ldc 177
    //   96: invokeinterface 181 2 0
    //   101: invokeinterface 185 2 0
    //   106: astore 20
    //   108: aload 20
    //   110: astore 14
    //   112: aload 13
    //   114: new 85	org/json/JSONObject
    //   117: dup
    //   118: aload 5
    //   120: aload 5
    //   122: ldc 36
    //   124: invokeinterface 181 2 0
    //   129: invokeinterface 185 2 0
    //   134: invokespecial 188	org/json/JSONObject:<init>	(Ljava/lang/String;)V
    //   137: invokevirtual 191	org/json/JSONArray:put	(Ljava/lang/Object;)Lorg/json/JSONArray;
    //   140: pop
    //   141: goto -71 -> 70
    //   144: astore 18
    //   146: goto -76 -> 70
    //   149: aload 13
    //   151: invokevirtual 195	org/json/JSONArray:length	()I
    //   154: ifle +200 -> 354
    //   157: aload 13
    //   159: invokevirtual 196	org/json/JSONArray:toString	()Ljava/lang/String;
    //   162: astore 17
    //   164: aload 17
    //   166: astore 16
    //   168: aload_0
    //   169: getfield 73	uK:e	LuL;
    //   172: invokevirtual 131	uL:close	()V
    //   175: aload 5
    //   177: ifnull +166 -> 343
    //   180: aload 5
    //   182: invokeinterface 130 1 0
    //   187: aload 16
    //   189: astore 11
    //   191: aload 14
    //   193: astore 10
    //   195: aload 10
    //   197: ifnull +23 -> 220
    //   200: aload 11
    //   202: ifnull +18 -> 220
    //   205: iconst_2
    //   206: anewarray 198	java/lang/String
    //   209: astore_2
    //   210: aload_2
    //   211: iconst_0
    //   212: aload 10
    //   214: aastore
    //   215: aload_2
    //   216: iconst_1
    //   217: aload 11
    //   219: aastore
    //   220: aload_2
    //   221: areturn
    //   222: astore 6
    //   224: aconst_null
    //   225: astore 7
    //   227: new 15	java/lang/StringBuilder
    //   230: dup
    //   231: invokespecial 18	java/lang/StringBuilder:<init>	()V
    //   234: ldc 200
    //   236: invokevirtual 24	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   239: aload_3
    //   240: invokevirtual 24	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   243: ldc 202
    //   245: invokevirtual 24	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   248: invokevirtual 45	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   251: pop
    //   252: aload_0
    //   253: getfield 73	uK:e	LuL;
    //   256: invokevirtual 131	uL:close	()V
    //   259: aload 7
    //   261: ifnull +73 -> 334
    //   264: aload 7
    //   266: invokeinterface 130 1 0
    //   271: aconst_null
    //   272: astore 10
    //   274: aconst_null
    //   275: astore 11
    //   277: goto -82 -> 195
    //   280: astore 4
    //   282: aconst_null
    //   283: astore 5
    //   285: aload_0
    //   286: getfield 73	uK:e	LuL;
    //   289: invokevirtual 131	uL:close	()V
    //   292: aload 5
    //   294: ifnull +10 -> 304
    //   297: aload 5
    //   299: invokeinterface 130 1 0
    //   304: aload 4
    //   306: athrow
    //   307: astore 4
    //   309: goto -24 -> 285
    //   312: astore 8
    //   314: aload 7
    //   316: astore 5
    //   318: aload 8
    //   320: astore 4
    //   322: goto -37 -> 285
    //   325: astore 15
    //   327: aload 5
    //   329: astore 7
    //   331: goto -104 -> 227
    //   334: aconst_null
    //   335: astore 10
    //   337: aconst_null
    //   338: astore 11
    //   340: goto -145 -> 195
    //   343: aload 16
    //   345: astore 11
    //   347: aload 14
    //   349: astore 10
    //   351: goto -156 -> 195
    //   354: aconst_null
    //   355: astore 16
    //   357: goto -189 -> 168
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	360	0	this	uK
    //   0	360	1	paramuM	uM
    //   1	220	2	arrayOfString	String[]
    //   6	234	3	str1	String
    //   280	25	4	localObject1	Object
    //   307	1	4	localObject2	Object
    //   320	1	4	localObject3	Object
    //   56	272	5	localObject4	Object
    //   222	1	6	localSQLiteException1	SQLiteException
    //   225	105	7	localObject5	Object
    //   312	7	8	localObject6	Object
    //   193	157	10	localObject7	Object
    //   189	157	11	str2	String
    //   52	3	12	localCursor	android.database.Cursor
    //   65	93	13	localJSONArray	org.json.JSONArray
    //   68	280	14	localObject8	Object
    //   325	1	15	localSQLiteException2	SQLiteException
    //   166	190	16	str3	String
    //   162	3	17	str4	String
    //   144	1	18	localJSONException	org.json.JSONException
    //   106	3	20	str5	String
    // Exception table:
    //   from	to	target	type
    //   112	141	144	org/json/JSONException
    //   7	54	222	android/database/sqlite/SQLiteException
    //   7	54	280	finally
    //   58	108	307	finally
    //   112	141	307	finally
    //   149	164	307	finally
    //   227	252	312	finally
    //   58	108	325	android/database/sqlite/SQLiteException
    //   112	141	325	android/database/sqlite/SQLiteException
    //   149	164	325	android/database/sqlite/SQLiteException
  }
}


/* Location:           C:\Users\dreadiscool\Desktop\tools\classes-dex2jar.jar
 * Qualified Name:     uK
 * JD-Core Version:    0.7.0.1
 */