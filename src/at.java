import java.io.OutputStream;
import java.io.Writer;

final class at
{
  private static String a(Throwable paramThrowable)
  {
    String str1 = paramThrowable.getLocalizedMessage();
    if (str1 == null) {}
    for (String str2 = null;; str2 = str1.replaceAll("(\r\n|\n|\f)", " ")) {
      return str2;
    }
  }
  
  public static void a(Throwable paramThrowable, OutputStream paramOutputStream)
  {
    if (paramOutputStream != null) {
      b(paramThrowable, paramOutputStream);
    }
  }
  
  private static void a(Throwable paramThrowable, Writer paramWriter)
  {
    int i = 1;
    if (paramThrowable != null) {}
    for (;;)
    {
      String str2;
      String str3;
      try
      {
        String str1 = a(paramThrowable);
        if (str1 == null) {
          break label165;
        }
        str2 = str1;
      }
      catch (Exception localException)
      {
        StackTraceElement[] arrayOfStackTraceElement;
        int j;
        int k;
        StackTraceElement localStackTraceElement;
        Throwable localThrowable;
        IC.g();
      }
      paramWriter.write(str3 + paramThrowable.getClass().getName() + ": " + str2 + "\n");
      arrayOfStackTraceElement = paramThrowable.getStackTrace();
      j = arrayOfStackTraceElement.length;
      k = 0;
      if (k < j)
      {
        localStackTraceElement = arrayOfStackTraceElement[k];
        paramWriter.write("\tat " + localStackTraceElement.toString() + "\n");
        k++;
      }
      else
      {
        localThrowable = paramThrowable.getCause();
        paramThrowable = localThrowable;
        i = 0;
        break;
        return;
        for (;;)
        {
          if (i == 0) {
            break label172;
          }
          str3 = "";
          break;
          label165:
          str2 = "";
        }
        label172:
        str3 = "Caused by: ";
      }
    }
  }
  
  /* Error */
  private static void b(Throwable paramThrowable, OutputStream paramOutputStream)
  {
    // Byte code:
    //   0: aconst_null
    //   1: astore_2
    //   2: new 88	java/io/PrintWriter
    //   5: dup
    //   6: aload_1
    //   7: invokespecial 91	java/io/PrintWriter:<init>	(Ljava/io/OutputStream;)V
    //   10: astore_3
    //   11: aload_0
    //   12: aload_3
    //   13: invokestatic 93	at:a	(Ljava/lang/Throwable;Ljava/io/Writer;)V
    //   16: aload_3
    //   17: ldc 95
    //   19: invokestatic 100	Jg:a	(Ljava/io/Closeable;Ljava/lang/String;)V
    //   22: return
    //   23: astore 8
    //   25: aconst_null
    //   26: astore_3
    //   27: invokestatic 82	IC:g	()LIO;
    //   30: pop
    //   31: aload_3
    //   32: ldc 95
    //   34: invokestatic 100	Jg:a	(Ljava/io/Closeable;Ljava/lang/String;)V
    //   37: goto -15 -> 22
    //   40: astore 6
    //   42: aload_2
    //   43: ldc 95
    //   45: invokestatic 100	Jg:a	(Ljava/io/Closeable;Ljava/lang/String;)V
    //   48: aload 6
    //   50: athrow
    //   51: astore 5
    //   53: aload_3
    //   54: astore_2
    //   55: aload 5
    //   57: astore 6
    //   59: goto -17 -> 42
    //   62: astore 4
    //   64: goto -37 -> 27
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	67	0	paramThrowable	Throwable
    //   0	67	1	paramOutputStream	OutputStream
    //   1	54	2	localObject1	Object
    //   10	44	3	localPrintWriter	java.io.PrintWriter
    //   62	1	4	localException1	Exception
    //   51	5	5	localObject2	Object
    //   40	9	6	localObject3	Object
    //   57	1	6	localObject4	Object
    //   23	1	8	localException2	Exception
    // Exception table:
    //   from	to	target	type
    //   2	11	23	java/lang/Exception
    //   2	11	40	finally
    //   11	16	51	finally
    //   27	31	51	finally
    //   11	16	62	java/lang/Exception
  }
}


/* Location:           C:\Users\dreadiscool\Desktop\tools\classes-dex2jar.jar
 * Qualified Name:     at
 * JD-Core Version:    0.7.0.1
 */