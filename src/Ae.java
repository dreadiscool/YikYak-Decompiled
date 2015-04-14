import java.io.Closeable;
import java.io.File;
import java.io.IOException;
import java.io.UnsupportedEncodingException;
import java.net.Socket;
import java.net.URI;
import java.net.URL;
import java.nio.charset.Charset;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import java.util.concurrent.ThreadFactory;
import java.util.concurrent.TimeUnit;

public final class Ae
{
  public static final byte[] a = new byte[0];
  public static final String[] b = new String[0];
  public static final Charset c = Charset.forName("US-ASCII");
  public static final Charset d = Charset.forName("UTF-8");
  
  public static int a(String paramString)
  {
    int i;
    if ("http".equals(paramString)) {
      i = 80;
    }
    for (;;)
    {
      return i;
      if ("https".equals(paramString)) {
        i = 443;
      } else {
        i = -1;
      }
    }
  }
  
  private static int a(String paramString, int paramInt)
  {
    if (paramInt != -1) {}
    for (;;)
    {
      return paramInt;
      paramInt = a(paramString);
    }
  }
  
  public static int a(URI paramURI)
  {
    return a(paramURI.getScheme(), paramURI.getPort());
  }
  
  public static int a(URL paramURL)
  {
    return a(paramURL.getProtocol(), paramURL.getPort());
  }
  
  public static LE a(LE paramLE)
  {
    try
    {
      LE localLE = LE.a(MessageDigest.getInstance("SHA-1").digest(paramLE.f()));
      return localLE;
    }
    catch (NoSuchAlgorithmException localNoSuchAlgorithmException)
    {
      throw new AssertionError(localNoSuchAlgorithmException);
    }
  }
  
  public static <T> List<T> a(List<T> paramList)
  {
    return Collections.unmodifiableList(new ArrayList(paramList));
  }
  
  public static <T> List<T> a(T... paramVarArgs)
  {
    return Collections.unmodifiableList(Arrays.asList((Object[])paramVarArgs.clone()));
  }
  
  public static <T> List<T> a(T[] paramArrayOfT1, T[] paramArrayOfT2)
  {
    ArrayList localArrayList = new ArrayList();
    int i = paramArrayOfT1.length;
    int j = 0;
    if (j < i)
    {
      T ? = paramArrayOfT1[j];
      int k = paramArrayOfT2.length;
      for (int m = 0;; m++) {
        if (m < k)
        {
          T ? = paramArrayOfT2[m];
          if (?.equals(?)) {
            localArrayList.add(?);
          }
        }
        else
        {
          j++;
          break;
        }
      }
    }
    return localArrayList;
  }
  
  public static <K, V> Map<K, V> a(Map<K, V> paramMap)
  {
    return Collections.unmodifiableMap(new LinkedHashMap(paramMap));
  }
  
  public static ThreadFactory a(String paramString, boolean paramBoolean)
  {
    return new Af(paramString, paramBoolean);
  }
  
  public static void a(long paramLong1, long paramLong2, long paramLong3)
  {
    if (((paramLong2 | paramLong3) < 0L) || (paramLong2 > paramLong1) || (paramLong1 - paramLong2 < paramLong3)) {
      throw new ArrayIndexOutOfBoundsException();
    }
  }
  
  public static void a(Closeable paramCloseable)
  {
    if (paramCloseable != null) {}
    try
    {
      paramCloseable.close();
      label10:
      return;
    }
    catch (RuntimeException localRuntimeException)
    {
      throw localRuntimeException;
    }
    catch (Exception localException)
    {
      break label10;
    }
  }
  
  public static void a(Closeable paramCloseable1, Closeable paramCloseable2)
  {
    Object localObject = null;
    try
    {
      paramCloseable1.close();
      try
      {
        label8:
        paramCloseable2.close();
        if (localObject == null) {
          return;
        }
      }
      catch (Throwable localThrowable2)
      {
        for (;;)
        {
          if (localObject == null) {
            localObject = localThrowable2;
          }
        }
        if ((localObject instanceof IOException)) {
          throw ((IOException)localObject);
        }
        if ((localObject instanceof RuntimeException)) {
          throw ((RuntimeException)localObject);
        }
        if ((localObject instanceof Error)) {
          throw ((Error)localObject);
        }
        throw new AssertionError(localObject);
      }
    }
    catch (Throwable localThrowable1)
    {
      break label8;
    }
  }
  
  public static void a(File paramFile)
  {
    File[] arrayOfFile = paramFile.listFiles();
    if (arrayOfFile == null) {
      throw new IOException("not a readable directory: " + paramFile);
    }
    int i = arrayOfFile.length;
    for (int j = 0; j < i; j++)
    {
      File localFile = arrayOfFile[j];
      if (localFile.isDirectory()) {
        a(localFile);
      }
      if (!localFile.delete()) {
        throw new IOException("failed to delete file: " + localFile);
      }
    }
  }
  
  public static void a(Socket paramSocket)
  {
    if (paramSocket != null) {}
    try
    {
      paramSocket.close();
      label8:
      return;
    }
    catch (RuntimeException localRuntimeException)
    {
      throw localRuntimeException;
    }
    catch (Exception localException)
    {
      break label8;
    }
  }
  
  public static boolean a(LV paramLV, int paramInt, TimeUnit paramTimeUnit)
  {
    try
    {
      boolean bool2 = b(paramLV, paramInt, paramTimeUnit);
      bool1 = bool2;
    }
    catch (IOException localIOException)
    {
      for (;;)
      {
        boolean bool1 = false;
      }
    }
    return bool1;
  }
  
  public static boolean a(Object paramObject1, Object paramObject2)
  {
    if ((paramObject1 == paramObject2) || ((paramObject1 != null) && (paramObject1.equals(paramObject2)))) {}
    for (boolean bool = true;; bool = false) {
      return bool;
    }
  }
  
  public static String b(String paramString)
  {
    try
    {
      String str = LE.a(MessageDigest.getInstance("MD5").digest(paramString.getBytes("UTF-8"))).c();
      return str;
    }
    catch (NoSuchAlgorithmException localNoSuchAlgorithmException)
    {
      throw new AssertionError(localNoSuchAlgorithmException);
    }
    catch (UnsupportedEncodingException localUnsupportedEncodingException)
    {
      label24:
      break label24;
    }
  }
  
  /* Error */
  public static boolean b(LV paramLV, int paramInt, TimeUnit paramTimeUnit)
  {
    // Byte code:
    //   0: invokestatic 226	java/lang/System:nanoTime	()J
    //   3: lstore_3
    //   4: aload_0
    //   5: invokeinterface 231 1 0
    //   10: invokevirtual 236	LW:g	()Z
    //   13: ifeq +101 -> 114
    //   16: aload_0
    //   17: invokeinterface 231 1 0
    //   22: invokevirtual 239	LW:h	()J
    //   25: lload_3
    //   26: lsub
    //   27: lstore 5
    //   29: aload_0
    //   30: invokeinterface 231 1 0
    //   35: lload_3
    //   36: lload 5
    //   38: aload_2
    //   39: iload_1
    //   40: i2l
    //   41: invokevirtual 245	java/util/concurrent/TimeUnit:toNanos	(J)J
    //   44: invokestatic 251	java/lang/Math:min	(JJ)J
    //   47: ladd
    //   48: invokevirtual 254	LW:a	(J)LLW;
    //   51: pop
    //   52: new 256	Lz
    //   55: dup
    //   56: invokespecial 257	Lz:<init>	()V
    //   59: astore 8
    //   61: aload_0
    //   62: aload 8
    //   64: ldc2_w 258
    //   67: invokeinterface 262 4 0
    //   72: ldc2_w 263
    //   75: lcmp
    //   76: ifeq +46 -> 122
    //   79: aload 8
    //   81: invokevirtual 267	Lz:s	()V
    //   84: goto -23 -> 61
    //   87: astore 12
    //   89: lload 5
    //   91: ldc2_w 268
    //   94: lcmp
    //   95: ifne +69 -> 164
    //   98: aload_0
    //   99: invokeinterface 231 1 0
    //   104: invokevirtual 272	LW:i	()LLW;
    //   107: pop
    //   108: iconst_0
    //   109: istore 14
    //   111: iload 14
    //   113: ireturn
    //   114: ldc2_w 268
    //   117: lstore 5
    //   119: goto -90 -> 29
    //   122: lload 5
    //   124: ldc2_w 268
    //   127: lcmp
    //   128: ifne +19 -> 147
    //   131: aload_0
    //   132: invokeinterface 231 1 0
    //   137: invokevirtual 272	LW:i	()LLW;
    //   140: pop
    //   141: iconst_1
    //   142: istore 14
    //   144: goto -33 -> 111
    //   147: aload_0
    //   148: invokeinterface 231 1 0
    //   153: lload 5
    //   155: lload_3
    //   156: ladd
    //   157: invokevirtual 254	LW:a	(J)LLW;
    //   160: pop
    //   161: goto -20 -> 141
    //   164: aload_0
    //   165: invokeinterface 231 1 0
    //   170: lload 5
    //   172: lload_3
    //   173: ladd
    //   174: invokevirtual 254	LW:a	(J)LLW;
    //   177: pop
    //   178: goto -70 -> 108
    //   181: astore 9
    //   183: lload 5
    //   185: ldc2_w 268
    //   188: lcmp
    //   189: ifne +16 -> 205
    //   192: aload_0
    //   193: invokeinterface 231 1 0
    //   198: invokevirtual 272	LW:i	()LLW;
    //   201: pop
    //   202: aload 9
    //   204: athrow
    //   205: aload_0
    //   206: invokeinterface 231 1 0
    //   211: lload 5
    //   213: lload_3
    //   214: ladd
    //   215: invokevirtual 254	LW:a	(J)LLW;
    //   218: pop
    //   219: goto -17 -> 202
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	222	0	paramLV	LV
    //   0	222	1	paramInt	int
    //   0	222	2	paramTimeUnit	TimeUnit
    //   3	211	3	l1	long
    //   27	185	5	l2	long
    //   59	21	8	localLz	Lz
    //   181	22	9	localObject	Object
    //   87	1	12	localInterruptedIOException	java.io.InterruptedIOException
    //   109	34	14	bool	boolean
    // Exception table:
    //   from	to	target	type
    //   52	84	87	java/io/InterruptedIOException
    //   52	84	181	finally
  }
}


/* Location:           C:\Users\dreadiscool\Desktop\tools\classes-dex2jar.jar
 * Qualified Name:     Ae
 * JD-Core Version:    0.7.0.1
 */