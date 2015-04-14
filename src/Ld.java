import java.util.HashMap;
import java.util.Map;

class Ld
  extends IU
  implements Ls
{
  public Ld(IM paramIM, String paramString1, String paramString2, KK paramKK)
  {
    this(paramIM, paramString1, paramString2, paramKK, KB.a);
  }
  
  Ld(IM paramIM, String paramString1, String paramString2, KK paramKK, KB paramKB)
  {
    super(paramIM, paramString1, paramString2, paramKK, paramKB);
  }
  
  private KC a(KC paramKC, Lr paramLr)
  {
    return paramKC.a("X-CRASHLYTICS-API-KEY", paramLr.a).a("X-CRASHLYTICS-API-CLIENT-TYPE", "android").a("X-CRASHLYTICS-D", paramLr.b).a("X-CRASHLYTICS-API-CLIENT-VERSION", this.a.d()).a("Accept", "application/json");
  }
  
  private Map<String, String> b(Lr paramLr)
  {
    HashMap localHashMap = new HashMap();
    localHashMap.put("build_version", paramLr.e);
    localHashMap.put("display_version", paramLr.d);
    localHashMap.put("source", Integer.toString(paramLr.f));
    if (paramLr.g != null) {
      localHashMap.put("icon_hash", paramLr.g);
    }
    String str = paramLr.c;
    if (!Jg.c(str)) {
      localHashMap.put("instance", str);
    }
    return localHashMap;
  }
  
  /* Error */
  public org.json.JSONObject a(Lr paramLr)
  {
    // Byte code:
    //   0: aload_0
    //   1: aload_1
    //   2: invokespecial 108	Ld:b	(LLr;)Ljava/util/Map;
    //   5: astore 16
    //   7: aload_0
    //   8: aload 16
    //   10: invokevirtual 111	Ld:a	(Ljava/util/Map;)LKC;
    //   13: astore 17
    //   15: aload_0
    //   16: aload 17
    //   18: aload_1
    //   19: invokespecial 113	Ld:a	(LKC;LLr;)LKC;
    //   22: astore 20
    //   24: aload 20
    //   26: astore_3
    //   27: invokestatic 118	IC:g	()LIO;
    //   30: pop
    //   31: new 120	java/lang/StringBuilder
    //   34: dup
    //   35: invokespecial 121	java/lang/StringBuilder:<init>	()V
    //   38: ldc 123
    //   40: invokevirtual 127	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   43: aload_0
    //   44: invokevirtual 129	Ld:a	()Ljava/lang/String;
    //   47: invokevirtual 127	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   50: invokevirtual 131	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   53: pop
    //   54: invokestatic 118	IC:g	()LIO;
    //   57: pop
    //   58: new 120	java/lang/StringBuilder
    //   61: dup
    //   62: invokespecial 121	java/lang/StringBuilder:<init>	()V
    //   65: ldc 133
    //   67: invokevirtual 127	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   70: aload 16
    //   72: invokevirtual 136	java/lang/StringBuilder:append	(Ljava/lang/Object;)Ljava/lang/StringBuilder;
    //   75: invokevirtual 131	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   78: pop
    //   79: aload_3
    //   80: invokevirtual 139	KC:b	()I
    //   83: istore 26
    //   85: invokestatic 118	IC:g	()LIO;
    //   88: pop
    //   89: new 120	java/lang/StringBuilder
    //   92: dup
    //   93: invokespecial 121	java/lang/StringBuilder:<init>	()V
    //   96: ldc 141
    //   98: invokevirtual 127	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   101: iload 26
    //   103: invokevirtual 144	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   106: invokevirtual 131	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   109: pop
    //   110: aload_3
    //   111: invokevirtual 146	KC:e	()Ljava/lang/String;
    //   114: astore 29
    //   116: new 148	org/json/JSONObject
    //   119: dup
    //   120: aload 29
    //   122: invokespecial 151	org/json/JSONObject:<init>	(Ljava/lang/String;)V
    //   125: astore 13
    //   127: aload_3
    //   128: ifnull +32 -> 160
    //   131: invokestatic 118	IC:g	()LIO;
    //   134: pop
    //   135: new 120	java/lang/StringBuilder
    //   138: dup
    //   139: invokespecial 121	java/lang/StringBuilder:<init>	()V
    //   142: ldc 153
    //   144: invokevirtual 127	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   147: aload_3
    //   148: ldc 155
    //   150: invokevirtual 158	KC:b	(Ljava/lang/String;)Ljava/lang/String;
    //   153: invokevirtual 127	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   156: invokevirtual 131	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   159: pop
    //   160: aload 13
    //   162: areturn
    //   163: astore 6
    //   165: aconst_null
    //   166: astore 7
    //   168: aconst_null
    //   169: astore 8
    //   171: invokestatic 118	IC:g	()LIO;
    //   174: pop
    //   175: new 120	java/lang/StringBuilder
    //   178: dup
    //   179: invokespecial 121	java/lang/StringBuilder:<init>	()V
    //   182: ldc 160
    //   184: invokevirtual 127	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   187: aload_0
    //   188: invokevirtual 129	Ld:a	()Ljava/lang/String;
    //   191: invokevirtual 127	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   194: invokevirtual 131	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   197: pop
    //   198: invokestatic 118	IC:g	()LIO;
    //   201: pop
    //   202: new 120	java/lang/StringBuilder
    //   205: dup
    //   206: invokespecial 121	java/lang/StringBuilder:<init>	()V
    //   209: ldc 162
    //   211: invokevirtual 127	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   214: aload 7
    //   216: invokevirtual 127	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   219: invokevirtual 131	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   222: pop
    //   223: aload 8
    //   225: ifnull +134 -> 359
    //   228: invokestatic 118	IC:g	()LIO;
    //   231: pop
    //   232: new 120	java/lang/StringBuilder
    //   235: dup
    //   236: invokespecial 121	java/lang/StringBuilder:<init>	()V
    //   239: ldc 153
    //   241: invokevirtual 127	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   244: aload 8
    //   246: ldc 155
    //   248: invokevirtual 158	KC:b	(Ljava/lang/String;)Ljava/lang/String;
    //   251: invokevirtual 127	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   254: invokevirtual 131	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   257: pop
    //   258: aconst_null
    //   259: astore 13
    //   261: goto -101 -> 160
    //   264: astore_2
    //   265: aconst_null
    //   266: astore_3
    //   267: aload_3
    //   268: ifnull +32 -> 300
    //   271: invokestatic 118	IC:g	()LIO;
    //   274: pop
    //   275: new 120	java/lang/StringBuilder
    //   278: dup
    //   279: invokespecial 121	java/lang/StringBuilder:<init>	()V
    //   282: ldc 153
    //   284: invokevirtual 127	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   287: aload_3
    //   288: ldc 155
    //   290: invokevirtual 158	KC:b	(Ljava/lang/String;)Ljava/lang/String;
    //   293: invokevirtual 127	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   296: invokevirtual 131	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   299: pop
    //   300: aload_2
    //   301: athrow
    //   302: astore 19
    //   304: aload 17
    //   306: astore_3
    //   307: aload 19
    //   309: astore_2
    //   310: goto -43 -> 267
    //   313: astore_2
    //   314: goto -47 -> 267
    //   317: astore_2
    //   318: aload 8
    //   320: astore_3
    //   321: goto -54 -> 267
    //   324: astore 18
    //   326: aload 17
    //   328: astore 8
    //   330: aconst_null
    //   331: astore 7
    //   333: goto -162 -> 171
    //   336: astore 21
    //   338: aconst_null
    //   339: astore 7
    //   341: aload_3
    //   342: astore 8
    //   344: goto -173 -> 171
    //   347: astore 32
    //   349: aload 29
    //   351: astore 7
    //   353: aload_3
    //   354: astore 8
    //   356: goto -185 -> 171
    //   359: aconst_null
    //   360: astore 13
    //   362: goto -202 -> 160
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	365	0	this	Ld
    //   0	365	1	paramLr	Lr
    //   264	37	2	localObject1	java.lang.Object
    //   309	1	2	localObject2	java.lang.Object
    //   313	1	2	localObject3	java.lang.Object
    //   317	1	2	localObject4	java.lang.Object
    //   26	328	3	localObject5	java.lang.Object
    //   163	1	6	localException1	java.lang.Exception
    //   166	186	7	str1	String
    //   169	186	8	localObject6	java.lang.Object
    //   125	236	13	localJSONObject	org.json.JSONObject
    //   5	66	16	localMap	Map
    //   13	314	17	localKC1	KC
    //   324	1	18	localException2	java.lang.Exception
    //   302	6	19	localObject7	java.lang.Object
    //   22	3	20	localKC2	KC
    //   336	1	21	localException3	java.lang.Exception
    //   83	19	26	i	int
    //   114	236	29	str2	String
    //   347	1	32	localException4	java.lang.Exception
    // Exception table:
    //   from	to	target	type
    //   0	15	163	java/lang/Exception
    //   0	15	264	finally
    //   15	24	302	finally
    //   27	116	313	finally
    //   116	127	313	finally
    //   171	223	317	finally
    //   15	24	324	java/lang/Exception
    //   27	116	336	java/lang/Exception
    //   116	127	347	java/lang/Exception
  }
}


/* Location:           C:\Users\dreadiscool\Desktop\tools\classes-dex2jar.jar
 * Qualified Name:     Ld
 * JD-Core Version:    0.7.0.1
 */