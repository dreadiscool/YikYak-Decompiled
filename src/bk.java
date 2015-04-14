import java.util.HashMap;
import java.util.Map;

class bk
  extends IU
{
  private final bm b;
  
  public bk(IM paramIM, String paramString1, String paramString2, KK paramKK, bm parambm)
  {
    super(paramIM, paramString1, paramString2, paramKK, KB.a);
    this.b = parambm;
  }
  
  private KC a(KC paramKC, String paramString1, String paramString2)
  {
    return paramKC.a("Accept", "application/json").a("User-Agent", "Crashlytics Android SDK/" + this.a.d()).a("X-CRASHLYTICS-DEVELOPER-TOKEN", "bca6990fc3c15a8105800c0673517a4b579634a1").a("X-CRASHLYTICS-API-CLIENT-TYPE", "android").a("X-CRASHLYTICS-API-CLIENT-VERSION", this.a.d()).a("X-CRASHLYTICS-API-KEY", paramString1).a("X-CRASHLYTICS-D", paramString2);
  }
  
  private Map<String, String> a(bi parambi)
  {
    HashMap localHashMap = new HashMap();
    localHashMap.put("build_version", parambi.a);
    localHashMap.put("display_version", parambi.b);
    localHashMap.put("instance", parambi.c);
    localHashMap.put("source", "3");
    return localHashMap;
  }
  
  /* Error */
  public bl a(String paramString1, String paramString2, bi parambi)
  {
    // Byte code:
    //   0: aconst_null
    //   1: astore 4
    //   3: aload_0
    //   4: aload_3
    //   5: invokespecial 103	bk:a	(Lbi;)Ljava/util/Map;
    //   8: astore 17
    //   10: aload_0
    //   11: aload 17
    //   13: invokevirtual 106	bk:a	(Ljava/util/Map;)LKC;
    //   16: astore 18
    //   18: aload 18
    //   20: astore 6
    //   22: aload_0
    //   23: aload 6
    //   25: aload_1
    //   26: aload_2
    //   27: invokespecial 108	bk:a	(LKC;Ljava/lang/String;Ljava/lang/String;)LKC;
    //   30: astore 6
    //   32: invokestatic 114	IC:g	()LIO;
    //   35: pop
    //   36: new 33	java/lang/StringBuilder
    //   39: dup
    //   40: invokespecial 36	java/lang/StringBuilder:<init>	()V
    //   43: ldc 116
    //   45: invokevirtual 42	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   48: aload_0
    //   49: invokevirtual 118	bk:a	()Ljava/lang/String;
    //   52: invokevirtual 42	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   55: invokevirtual 54	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   58: pop
    //   59: invokestatic 114	IC:g	()LIO;
    //   62: pop
    //   63: new 33	java/lang/StringBuilder
    //   66: dup
    //   67: invokespecial 36	java/lang/StringBuilder:<init>	()V
    //   70: ldc 120
    //   72: invokevirtual 42	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   75: aload 17
    //   77: invokevirtual 123	java/lang/StringBuilder:append	(Ljava/lang/Object;)Ljava/lang/StringBuilder;
    //   80: invokevirtual 54	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   83: pop
    //   84: aload 6
    //   86: invokevirtual 126	KC:c	()Z
    //   89: ifeq +78 -> 167
    //   92: invokestatic 114	IC:g	()LIO;
    //   95: pop
    //   96: new 128	org/json/JSONObject
    //   99: dup
    //   100: aload 6
    //   102: invokevirtual 131	KC:e	()Ljava/lang/String;
    //   105: invokespecial 134	org/json/JSONObject:<init>	(Ljava/lang/String;)V
    //   108: astore 30
    //   110: aload_0
    //   111: getfield 19	bk:b	Lbm;
    //   114: aload 30
    //   116: invokevirtual 139	bm:a	(Lorg/json/JSONObject;)Lbl;
    //   119: astore 31
    //   121: aload 31
    //   123: astore 4
    //   125: aload 6
    //   127: ifnull +37 -> 164
    //   130: aload 6
    //   132: ldc 141
    //   134: invokevirtual 144	KC:b	(Ljava/lang/String;)Ljava/lang/String;
    //   137: astore 32
    //   139: invokestatic 114	IC:g	()LIO;
    //   142: pop
    //   143: new 33	java/lang/StringBuilder
    //   146: dup
    //   147: invokespecial 36	java/lang/StringBuilder:<init>	()V
    //   150: ldc 146
    //   152: invokevirtual 42	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   155: aload 32
    //   157: invokevirtual 42	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   160: invokevirtual 54	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   163: pop
    //   164: aload 4
    //   166: areturn
    //   167: invokestatic 114	IC:g	()LIO;
    //   170: pop
    //   171: new 33	java/lang/StringBuilder
    //   174: dup
    //   175: invokespecial 36	java/lang/StringBuilder:<init>	()V
    //   178: ldc 148
    //   180: invokevirtual 42	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   183: aload 6
    //   185: invokevirtual 151	KC:b	()I
    //   188: invokevirtual 154	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   191: invokevirtual 54	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   194: pop
    //   195: aload 6
    //   197: ifnull -33 -> 164
    //   200: aload 6
    //   202: ldc 141
    //   204: invokevirtual 144	KC:b	(Ljava/lang/String;)Ljava/lang/String;
    //   207: astore 26
    //   209: invokestatic 114	IC:g	()LIO;
    //   212: pop
    //   213: new 33	java/lang/StringBuilder
    //   216: dup
    //   217: invokespecial 36	java/lang/StringBuilder:<init>	()V
    //   220: ldc 146
    //   222: invokevirtual 42	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   225: aload 26
    //   227: invokevirtual 42	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   230: invokevirtual 54	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   233: pop
    //   234: goto -70 -> 164
    //   237: astore 11
    //   239: aconst_null
    //   240: astore 6
    //   242: invokestatic 114	IC:g	()LIO;
    //   245: pop
    //   246: new 33	java/lang/StringBuilder
    //   249: dup
    //   250: invokespecial 36	java/lang/StringBuilder:<init>	()V
    //   253: ldc 156
    //   255: invokevirtual 42	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   258: aload_0
    //   259: invokevirtual 118	bk:a	()Ljava/lang/String;
    //   262: invokevirtual 42	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   265: invokevirtual 54	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   268: pop
    //   269: aload 6
    //   271: ifnull -107 -> 164
    //   274: aload 6
    //   276: ldc 141
    //   278: invokevirtual 144	KC:b	(Ljava/lang/String;)Ljava/lang/String;
    //   281: astore 14
    //   283: invokestatic 114	IC:g	()LIO;
    //   286: pop
    //   287: new 33	java/lang/StringBuilder
    //   290: dup
    //   291: invokespecial 36	java/lang/StringBuilder:<init>	()V
    //   294: ldc 146
    //   296: invokevirtual 42	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   299: aload 14
    //   301: invokevirtual 42	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   304: invokevirtual 54	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   307: pop
    //   308: goto -144 -> 164
    //   311: astore 5
    //   313: aconst_null
    //   314: astore 6
    //   316: aload 5
    //   318: astore 7
    //   320: aload 6
    //   322: ifnull +37 -> 359
    //   325: aload 6
    //   327: ldc 141
    //   329: invokevirtual 144	KC:b	(Ljava/lang/String;)Ljava/lang/String;
    //   332: astore 8
    //   334: invokestatic 114	IC:g	()LIO;
    //   337: pop
    //   338: new 33	java/lang/StringBuilder
    //   341: dup
    //   342: invokespecial 36	java/lang/StringBuilder:<init>	()V
    //   345: ldc 146
    //   347: invokevirtual 42	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   350: aload 8
    //   352: invokevirtual 42	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   355: invokevirtual 54	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   358: pop
    //   359: aload 7
    //   361: athrow
    //   362: astore 7
    //   364: goto -44 -> 320
    //   367: astore 19
    //   369: goto -127 -> 242
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	372	0	this	bk
    //   0	372	1	paramString1	String
    //   0	372	2	paramString2	String
    //   0	372	3	parambi	bi
    //   1	164	4	localObject1	java.lang.Object
    //   311	6	5	localObject2	java.lang.Object
    //   20	306	6	localKC1	KC
    //   318	42	7	localObject3	java.lang.Object
    //   362	1	7	localObject4	java.lang.Object
    //   332	19	8	str1	String
    //   237	1	11	localException1	java.lang.Exception
    //   281	19	14	str2	String
    //   8	68	17	localMap	Map
    //   16	3	18	localKC2	KC
    //   367	1	19	localException2	java.lang.Exception
    //   207	19	26	str3	String
    //   108	7	30	localJSONObject	org.json.JSONObject
    //   119	3	31	localbl	bl
    //   137	19	32	str4	String
    // Exception table:
    //   from	to	target	type
    //   3	18	237	java/lang/Exception
    //   3	18	311	finally
    //   22	121	362	finally
    //   167	195	362	finally
    //   242	269	362	finally
    //   22	121	367	java/lang/Exception
    //   167	195	367	java/lang/Exception
  }
}


/* Location:           C:\Users\dreadiscool\Desktop\tools\classes-dex2jar.jar
 * Qualified Name:     bk
 * JD-Core Version:    0.7.0.1
 */