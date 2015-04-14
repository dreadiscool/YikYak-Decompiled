import java.io.PrintStream;
import java.net.InetSocketAddress;
import java.net.Socket;
import java.net.URI;
import java.net.URL;
import java.util.List;
import javax.net.ssl.SSLSocket;

public class zY
{
  private static final zY a = ;
  
  public static zY a()
  {
    return a;
  }
  
  static byte[] a(List<zy> paramList)
  {
    Lz localLz = new Lz();
    int i = paramList.size();
    int j = 0;
    if (j < i)
    {
      zy localzy = (zy)paramList.get(j);
      if (localzy == zy.a) {}
      for (;;)
      {
        j++;
        break;
        localLz.a(localzy.toString().length());
        localLz.a(localzy.toString());
      }
    }
    return localLz.r();
  }
  
  /* Error */
  private static zY c()
  {
    // Byte code:
    //   0: aconst_null
    //   1: astore_0
    //   2: ldc 61
    //   4: invokestatic 67	java/lang/Class:forName	(Ljava/lang/String;)Ljava/lang/Class;
    //   7: pop
    //   8: ldc 69
    //   10: invokestatic 67	java/lang/Class:forName	(Ljava/lang/String;)Ljava/lang/Class;
    //   13: astore 20
    //   15: iconst_1
    //   16: anewarray 63	java/lang/Class
    //   19: astore 21
    //   21: aload 21
    //   23: iconst_0
    //   24: ldc 71
    //   26: aastore
    //   27: aload 20
    //   29: ldc 73
    //   31: aload 21
    //   33: invokevirtual 77	java/lang/Class:getMethod	(Ljava/lang/String;[Ljava/lang/Class;)Ljava/lang/reflect/Method;
    //   36: astore 22
    //   38: aload 22
    //   40: astore 17
    //   42: iconst_1
    //   43: anewarray 63	java/lang/Class
    //   46: astore 25
    //   48: aload 25
    //   50: iconst_0
    //   51: ldc 71
    //   53: aastore
    //   54: aload 20
    //   56: ldc 79
    //   58: aload 25
    //   60: invokevirtual 77	java/lang/Class:getMethod	(Ljava/lang/String;[Ljava/lang/Class;)Ljava/lang/reflect/Method;
    //   63: astore 26
    //   65: aload 26
    //   67: astore_0
    //   68: aload 17
    //   70: astore 18
    //   72: new 81	Aa
    //   75: dup
    //   76: aload 18
    //   78: aload_0
    //   79: aconst_null
    //   80: invokespecial 84	Aa:<init>	(Ljava/lang/reflect/Method;Ljava/lang/reflect/Method;LzZ;)V
    //   83: astore 4
    //   85: goto +241 -> 326
    //   88: astore_1
    //   89: ldc 86
    //   91: invokestatic 67	java/lang/Class:forName	(Ljava/lang/String;)Ljava/lang/Class;
    //   94: pop
    //   95: goto -87 -> 8
    //   98: astore_2
    //   99: ldc 88
    //   101: invokestatic 67	java/lang/Class:forName	(Ljava/lang/String;)Ljava/lang/Class;
    //   104: astore 6
    //   106: new 90	java/lang/StringBuilder
    //   109: dup
    //   110: invokespecial 91	java/lang/StringBuilder:<init>	()V
    //   113: ldc 88
    //   115: invokevirtual 95	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   118: ldc 97
    //   120: invokevirtual 95	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   123: invokevirtual 98	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   126: invokestatic 67	java/lang/Class:forName	(Ljava/lang/String;)Ljava/lang/Class;
    //   129: astore 7
    //   131: new 90	java/lang/StringBuilder
    //   134: dup
    //   135: invokespecial 91	java/lang/StringBuilder:<init>	()V
    //   138: ldc 88
    //   140: invokevirtual 95	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   143: ldc 100
    //   145: invokevirtual 95	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   148: invokevirtual 98	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   151: invokestatic 67	java/lang/Class:forName	(Ljava/lang/String;)Ljava/lang/Class;
    //   154: astore 8
    //   156: new 90	java/lang/StringBuilder
    //   159: dup
    //   160: invokespecial 91	java/lang/StringBuilder:<init>	()V
    //   163: ldc 88
    //   165: invokevirtual 95	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   168: ldc 102
    //   170: invokevirtual 95	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   173: invokevirtual 98	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   176: invokestatic 67	java/lang/Class:forName	(Ljava/lang/String;)Ljava/lang/Class;
    //   179: astore 9
    //   181: iconst_2
    //   182: anewarray 63	java/lang/Class
    //   185: astore 10
    //   187: aload 10
    //   189: iconst_0
    //   190: ldc 104
    //   192: aastore
    //   193: aload 10
    //   195: iconst_1
    //   196: aload 7
    //   198: aastore
    //   199: aload 6
    //   201: ldc 106
    //   203: aload 10
    //   205: invokevirtual 77	java/lang/Class:getMethod	(Ljava/lang/String;[Ljava/lang/Class;)Ljava/lang/reflect/Method;
    //   208: astore 11
    //   210: iconst_1
    //   211: anewarray 63	java/lang/Class
    //   214: astore 12
    //   216: aload 12
    //   218: iconst_0
    //   219: ldc 104
    //   221: aastore
    //   222: aload 6
    //   224: ldc 107
    //   226: aload 12
    //   228: invokevirtual 77	java/lang/Class:getMethod	(Ljava/lang/String;[Ljava/lang/Class;)Ljava/lang/reflect/Method;
    //   231: astore 13
    //   233: iconst_1
    //   234: anewarray 63	java/lang/Class
    //   237: astore 14
    //   239: aload 14
    //   241: iconst_0
    //   242: ldc 104
    //   244: aastore
    //   245: new 109	Ab
    //   248: dup
    //   249: aload 11
    //   251: aload 13
    //   253: aload 6
    //   255: ldc 111
    //   257: aload 14
    //   259: invokevirtual 77	java/lang/Class:getMethod	(Ljava/lang/String;[Ljava/lang/Class;)Ljava/lang/reflect/Method;
    //   262: aload 8
    //   264: aload 9
    //   266: invokespecial 114	Ab:<init>	(Ljava/lang/reflect/Method;Ljava/lang/reflect/Method;Ljava/lang/reflect/Method;Ljava/lang/Class;Ljava/lang/Class;)V
    //   269: astore 4
    //   271: goto +55 -> 326
    //   274: astore 5
    //   276: new 2	zY
    //   279: dup
    //   280: invokespecial 115	zY:<init>	()V
    //   283: astore 4
    //   285: goto +41 -> 326
    //   288: astore 19
    //   290: aconst_null
    //   291: astore 17
    //   293: aload 17
    //   295: astore 18
    //   297: goto -225 -> 72
    //   300: astore 16
    //   302: aconst_null
    //   303: astore 17
    //   305: aload 17
    //   307: astore 18
    //   309: goto -237 -> 72
    //   312: astore_3
    //   313: goto -37 -> 276
    //   316: astore 24
    //   318: goto -13 -> 305
    //   321: astore 23
    //   323: goto -30 -> 293
    //   326: aload 4
    //   328: areturn
    // Local variable table:
    //   start	length	slot	name	signature
    //   1	78	0	localObject1	Object
    //   88	1	1	localClassNotFoundException1	java.lang.ClassNotFoundException
    //   98	1	2	localClassNotFoundException2	java.lang.ClassNotFoundException
    //   312	1	3	localNoSuchMethodException1	java.lang.NoSuchMethodException
    //   83	244	4	localObject2	Object
    //   274	1	5	localClassNotFoundException3	java.lang.ClassNotFoundException
    //   104	150	6	localClass1	java.lang.Class
    //   129	68	7	localClass2	java.lang.Class
    //   154	109	8	localClass3	java.lang.Class
    //   179	86	9	localClass4	java.lang.Class
    //   185	19	10	arrayOfClass1	java.lang.Class[]
    //   208	42	11	localMethod1	java.lang.reflect.Method
    //   214	13	12	arrayOfClass2	java.lang.Class[]
    //   231	21	13	localMethod2	java.lang.reflect.Method
    //   237	21	14	arrayOfClass3	java.lang.Class[]
    //   300	1	16	localNoSuchMethodException2	java.lang.NoSuchMethodException
    //   40	266	17	localMethod3	java.lang.reflect.Method
    //   70	238	18	localMethod4	java.lang.reflect.Method
    //   288	1	19	localClassNotFoundException4	java.lang.ClassNotFoundException
    //   13	42	20	localClass5	java.lang.Class
    //   19	13	21	arrayOfClass4	java.lang.Class[]
    //   36	3	22	localMethod5	java.lang.reflect.Method
    //   321	1	23	localClassNotFoundException5	java.lang.ClassNotFoundException
    //   316	1	24	localNoSuchMethodException3	java.lang.NoSuchMethodException
    //   46	13	25	arrayOfClass5	java.lang.Class[]
    //   63	3	26	localMethod6	java.lang.reflect.Method
    // Exception table:
    //   from	to	target	type
    //   2	8	88	java/lang/ClassNotFoundException
    //   72	95	98	java/lang/ClassNotFoundException
    //   99	271	274	java/lang/ClassNotFoundException
    //   8	38	288	java/lang/ClassNotFoundException
    //   8	38	300	java/lang/NoSuchMethodException
    //   99	271	312	java/lang/NoSuchMethodException
    //   42	65	316	java/lang/NoSuchMethodException
    //   42	65	321	java/lang/ClassNotFoundException
  }
  
  public URI a(URL paramURL)
  {
    return paramURL.toURI();
  }
  
  public void a(String paramString)
  {
    System.out.println(paramString);
  }
  
  public void a(Socket paramSocket) {}
  
  public void a(Socket paramSocket, InetSocketAddress paramInetSocketAddress, int paramInt)
  {
    paramSocket.connect(paramInetSocketAddress, paramInt);
  }
  
  public void a(SSLSocket paramSSLSocket) {}
  
  public void a(SSLSocket paramSSLSocket, String paramString, List<zy> paramList) {}
  
  public String b()
  {
    return "OkHttp";
  }
  
  public String b(SSLSocket paramSSLSocket)
  {
    return null;
  }
  
  public void b(Socket paramSocket) {}
}


/* Location:           C:\Users\dreadiscool\Desktop\tools\classes-dex2jar.jar
 * Qualified Name:     zY
 * JD-Core Version:    0.7.0.1
 */