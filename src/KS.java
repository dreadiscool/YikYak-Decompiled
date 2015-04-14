abstract class KS
  extends IU
{
  public KS(IM paramIM, String paramString1, String paramString2, KK paramKK, KB paramKB)
  {
    super(paramIM, paramString1, paramString2, paramKK, paramKB);
  }
  
  private KC a(KC paramKC, KV paramKV)
  {
    return paramKC.a("X-CRASHLYTICS-API-KEY", paramKV.a).a("X-CRASHLYTICS-API-CLIENT-TYPE", "android").a("X-CRASHLYTICS-API-CLIENT-VERSION", this.a.d());
  }
  
  /* Error */
  private KC b(KC paramKC, KV paramKV)
  {
    // Byte code:
    //   0: aload_1
    //   1: ldc 42
    //   3: aload_2
    //   4: getfield 44	KV:b	Ljava/lang/String;
    //   7: invokevirtual 47	KC:e	(Ljava/lang/String;Ljava/lang/String;)LKC;
    //   10: ldc 49
    //   12: aload_2
    //   13: getfield 52	KV:f	Ljava/lang/String;
    //   16: invokevirtual 47	KC:e	(Ljava/lang/String;Ljava/lang/String;)LKC;
    //   19: ldc 54
    //   21: aload_2
    //   22: getfield 57	KV:c	Ljava/lang/String;
    //   25: invokevirtual 47	KC:e	(Ljava/lang/String;Ljava/lang/String;)LKC;
    //   28: ldc 59
    //   30: aload_2
    //   31: getfield 61	KV:d	Ljava/lang/String;
    //   34: invokevirtual 47	KC:e	(Ljava/lang/String;Ljava/lang/String;)LKC;
    //   37: ldc 63
    //   39: aload_2
    //   40: getfield 67	KV:g	I
    //   43: invokestatic 73	java/lang/Integer:valueOf	(I)Ljava/lang/Integer;
    //   46: invokevirtual 76	KC:a	(Ljava/lang/String;Ljava/lang/Number;)LKC;
    //   49: ldc 78
    //   51: aload_2
    //   52: getfield 81	KV:h	Ljava/lang/String;
    //   55: invokevirtual 47	KC:e	(Ljava/lang/String;Ljava/lang/String;)LKC;
    //   58: ldc 83
    //   60: aload_2
    //   61: getfield 86	KV:i	Ljava/lang/String;
    //   64: invokevirtual 47	KC:e	(Ljava/lang/String;Ljava/lang/String;)LKC;
    //   67: astore_3
    //   68: aload_2
    //   69: getfield 88	KV:e	Ljava/lang/String;
    //   72: invokestatic 93	Jg:c	(Ljava/lang/String;)Z
    //   75: ifne +14 -> 89
    //   78: aload_3
    //   79: ldc 95
    //   81: aload_2
    //   82: getfield 88	KV:e	Ljava/lang/String;
    //   85: invokevirtual 47	KC:e	(Ljava/lang/String;Ljava/lang/String;)LKC;
    //   88: pop
    //   89: aload_2
    //   90: getfield 99	KV:j	LLf;
    //   93: ifnull +94 -> 187
    //   96: aconst_null
    //   97: astore 8
    //   99: aload_0
    //   100: getfield 31	KS:a	LIM;
    //   103: invokevirtual 103	IM:C	()Landroid/content/Context;
    //   106: invokevirtual 109	android/content/Context:getResources	()Landroid/content/res/Resources;
    //   109: aload_2
    //   110: getfield 99	KV:j	LLf;
    //   113: getfield 113	Lf:b	I
    //   116: invokevirtual 119	android/content/res/Resources:openRawResource	(I)Ljava/io/InputStream;
    //   119: astore 16
    //   121: aload 16
    //   123: astore 8
    //   125: aload_3
    //   126: ldc 121
    //   128: aload_2
    //   129: getfield 99	KV:j	LLf;
    //   132: getfield 122	Lf:a	Ljava/lang/String;
    //   135: invokevirtual 47	KC:e	(Ljava/lang/String;Ljava/lang/String;)LKC;
    //   138: ldc 124
    //   140: ldc 126
    //   142: ldc 128
    //   144: aload 8
    //   146: invokevirtual 131	KC:a	(Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/io/InputStream;)LKC;
    //   149: ldc 133
    //   151: aload_2
    //   152: getfield 99	KV:j	LLf;
    //   155: getfield 135	Lf:c	I
    //   158: invokestatic 73	java/lang/Integer:valueOf	(I)Ljava/lang/Integer;
    //   161: invokevirtual 76	KC:a	(Ljava/lang/String;Ljava/lang/Number;)LKC;
    //   164: ldc 137
    //   166: aload_2
    //   167: getfield 99	KV:j	LLf;
    //   170: getfield 139	Lf:d	I
    //   173: invokestatic 73	java/lang/Integer:valueOf	(I)Ljava/lang/Integer;
    //   176: invokevirtual 76	KC:a	(Ljava/lang/String;Ljava/lang/Number;)LKC;
    //   179: pop
    //   180: aload 8
    //   182: ldc 141
    //   184: invokestatic 144	Jg:a	(Ljava/io/Closeable;Ljava/lang/String;)V
    //   187: aload_2
    //   188: getfield 148	KV:k	Ljava/util/Collection;
    //   191: ifnull +135 -> 326
    //   194: aload_2
    //   195: getfield 148	KV:k	Ljava/util/Collection;
    //   198: invokeinterface 154 1 0
    //   203: astore 4
    //   205: aload 4
    //   207: invokeinterface 160 1 0
    //   212: ifeq +114 -> 326
    //   215: aload 4
    //   217: invokeinterface 164 1 0
    //   222: checkcast 33	IM
    //   225: astore 5
    //   227: aload 5
    //   229: invokevirtual 37	IM:d	()Ljava/lang/String;
    //   232: ifnonnull +84 -> 316
    //   235: ldc 166
    //   237: astore 6
    //   239: aload_3
    //   240: aload_0
    //   241: aload 5
    //   243: invokevirtual 169	KS:a	(LIM;)Ljava/lang/String;
    //   246: aload 6
    //   248: invokevirtual 47	KC:e	(Ljava/lang/String;Ljava/lang/String;)LKC;
    //   251: pop
    //   252: goto -47 -> 205
    //   255: astore 12
    //   257: invokestatic 174	IC:g	()LIO;
    //   260: pop
    //   261: new 176	java/lang/StringBuilder
    //   264: dup
    //   265: invokespecial 179	java/lang/StringBuilder:<init>	()V
    //   268: ldc 181
    //   270: invokevirtual 185	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   273: aload_2
    //   274: getfield 99	KV:j	LLf;
    //   277: getfield 113	Lf:b	I
    //   280: invokevirtual 188	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   283: invokevirtual 191	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   286: pop
    //   287: aload 8
    //   289: ldc 141
    //   291: invokestatic 144	Jg:a	(Ljava/io/Closeable;Ljava/lang/String;)V
    //   294: goto -107 -> 187
    //   297: astore 9
    //   299: aconst_null
    //   300: astore 10
    //   302: aload 9
    //   304: astore 11
    //   306: aload 10
    //   308: ldc 141
    //   310: invokestatic 144	Jg:a	(Ljava/io/Closeable;Ljava/lang/String;)V
    //   313: aload 11
    //   315: athrow
    //   316: aload 5
    //   318: invokevirtual 37	IM:d	()Ljava/lang/String;
    //   321: astore 6
    //   323: goto -84 -> 239
    //   326: aload_3
    //   327: areturn
    //   328: astore 13
    //   330: aload 8
    //   332: astore 10
    //   334: aload 13
    //   336: astore 11
    //   338: goto -32 -> 306
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	341	0	this	KS
    //   0	341	1	paramKC	KC
    //   0	341	2	paramKV	KV
    //   67	260	3	localKC	KC
    //   203	13	4	localIterator	java.util.Iterator
    //   225	92	5	localIM	IM
    //   237	85	6	str	String
    //   97	234	8	localObject1	java.lang.Object
    //   297	6	9	localObject2	java.lang.Object
    //   300	33	10	localObject3	java.lang.Object
    //   304	33	11	localObject4	java.lang.Object
    //   255	1	12	localNotFoundException	android.content.res.Resources.NotFoundException
    //   328	7	13	localObject5	java.lang.Object
    //   119	3	16	localInputStream	java.io.InputStream
    // Exception table:
    //   from	to	target	type
    //   99	121	255	android/content/res/Resources$NotFoundException
    //   125	180	255	android/content/res/Resources$NotFoundException
    //   99	121	297	finally
    //   125	180	328	finally
    //   257	287	328	finally
  }
  
  String a(IM paramIM)
  {
    if (paramIM.c() == null) {}
    for (String str = "";; str = paramIM.c()) {
      return "app[build][libraries][" + str + "]";
    }
  }
  
  public boolean a(KV paramKV)
  {
    KC localKC = b(a(b(), paramKV), paramKV);
    IC.g();
    new StringBuilder().append("Sending app info to ").append(a()).toString();
    if (paramKV.j != null)
    {
      IC.g();
      new StringBuilder().append("App icon hash is ").append(paramKV.j.a).toString();
      IC.g();
      new StringBuilder().append("App icon size is ").append(paramKV.j.c).append("x").append(paramKV.j.d).toString();
    }
    int i = localKC.b();
    String str;
    if ("POST".equals(localKC.p()))
    {
      str = "Create";
      IC.g();
      new StringBuilder().append(str).append(" app request ID: ").append(localKC.b("X-REQUEST-ID")).toString();
      IC.g();
      new StringBuilder().append("Result was ").append(i).toString();
      if (JB.a(i) != 0) {
        break label226;
      }
    }
    label226:
    for (boolean bool = true;; bool = false)
    {
      return bool;
      str = "Update";
      break;
    }
  }
}


/* Location:           C:\Users\dreadiscool\Desktop\tools\classes-dex2jar.jar
 * Qualified Name:     KS
 * JD-Core Version:    0.7.0.1
 */