import java.text.DateFormat;
import java.util.Date;
import java.util.TimeZone;

public final class Av
{
  private static final TimeZone a = TimeZone.getTimeZone("GMT");
  private static final ThreadLocal<DateFormat> b = new Aw();
  private static final String[] c;
  private static final DateFormat[] d = new DateFormat[c.length];
  
  static
  {
    String[] arrayOfString = new String[15];
    arrayOfString[0] = "EEE, dd MMM yyyy HH:mm:ss zzz";
    arrayOfString[1] = "EEEE, dd-MMM-yy HH:mm:ss zzz";
    arrayOfString[2] = "EEE MMM d HH:mm:ss yyyy";
    arrayOfString[3] = "EEE, dd-MMM-yyyy HH:mm:ss z";
    arrayOfString[4] = "EEE, dd-MMM-yyyy HH-mm-ss z";
    arrayOfString[5] = "EEE, dd MMM yy HH:mm:ss z";
    arrayOfString[6] = "EEE dd-MMM-yyyy HH:mm:ss z";
    arrayOfString[7] = "EEE dd MMM yyyy HH:mm:ss z";
    arrayOfString[8] = "EEE dd-MMM-yyyy HH-mm-ss z";
    arrayOfString[9] = "EEE dd-MMM-yy HH:mm:ss z";
    arrayOfString[10] = "EEE dd MMM yy HH:mm:ss z";
    arrayOfString[11] = "EEE,dd-MMM-yy HH:mm:ss z";
    arrayOfString[12] = "EEE,dd-MMM-yyyy HH:mm:ss z";
    arrayOfString[13] = "EEE, dd-MM-yyyy HH:mm:ss z";
    arrayOfString[14] = "EEE MMM d yyyy HH:mm:ss z";
    c = arrayOfString;
  }
  
  public static String a(Date paramDate)
  {
    return ((DateFormat)b.get()).format(paramDate);
  }
  
  /* Error */
  public static Date a(String paramString)
  {
    // Byte code:
    //   0: iconst_0
    //   1: istore_1
    //   2: aload_0
    //   3: invokevirtual 85	java/lang/String:length	()I
    //   6: ifne +7 -> 13
    //   9: aconst_null
    //   10: astore_3
    //   11: aload_3
    //   12: areturn
    //   13: new 87	java/text/ParsePosition
    //   16: dup
    //   17: iconst_0
    //   18: invokespecial 90	java/text/ParsePosition:<init>	(I)V
    //   21: astore_2
    //   22: getstatic 32	Av:b	Ljava/lang/ThreadLocal;
    //   25: invokevirtual 77	java/lang/ThreadLocal:get	()Ljava/lang/Object;
    //   28: checkcast 68	java/text/DateFormat
    //   31: aload_0
    //   32: aload_2
    //   33: invokevirtual 94	java/text/DateFormat:parse	(Ljava/lang/String;Ljava/text/ParsePosition;)Ljava/util/Date;
    //   36: astore_3
    //   37: aload_2
    //   38: invokevirtual 97	java/text/ParsePosition:getIndex	()I
    //   41: aload_0
    //   42: invokevirtual 85	java/lang/String:length	()I
    //   45: if_icmpeq -34 -> 11
    //   48: getstatic 66	Av:c	[Ljava/lang/String;
    //   51: astore 4
    //   53: aload 4
    //   55: monitorenter
    //   56: getstatic 66	Av:c	[Ljava/lang/String;
    //   59: arraylength
    //   60: istore 6
    //   62: iload_1
    //   63: iload 6
    //   65: if_icmpge +87 -> 152
    //   68: getstatic 70	Av:d	[Ljava/text/DateFormat;
    //   71: iload_1
    //   72: aaload
    //   73: astore 7
    //   75: aload 7
    //   77: ifnonnull +35 -> 112
    //   80: new 99	java/text/SimpleDateFormat
    //   83: dup
    //   84: getstatic 66	Av:c	[Ljava/lang/String;
    //   87: iload_1
    //   88: aaload
    //   89: getstatic 105	java/util/Locale:US	Ljava/util/Locale;
    //   92: invokespecial 108	java/text/SimpleDateFormat:<init>	(Ljava/lang/String;Ljava/util/Locale;)V
    //   95: astore 7
    //   97: aload 7
    //   99: getstatic 25	Av:a	Ljava/util/TimeZone;
    //   102: invokevirtual 112	java/text/DateFormat:setTimeZone	(Ljava/util/TimeZone;)V
    //   105: getstatic 70	Av:d	[Ljava/text/DateFormat;
    //   108: iload_1
    //   109: aload 7
    //   111: aastore
    //   112: aload_2
    //   113: iconst_0
    //   114: invokevirtual 115	java/text/ParsePosition:setIndex	(I)V
    //   117: aload 7
    //   119: aload_0
    //   120: aload_2
    //   121: invokevirtual 94	java/text/DateFormat:parse	(Ljava/lang/String;Ljava/text/ParsePosition;)Ljava/util/Date;
    //   124: astore_3
    //   125: aload_2
    //   126: invokevirtual 97	java/text/ParsePosition:getIndex	()I
    //   129: ifeq +17 -> 146
    //   132: aload 4
    //   134: monitorexit
    //   135: goto -124 -> 11
    //   138: astore 5
    //   140: aload 4
    //   142: monitorexit
    //   143: aload 5
    //   145: athrow
    //   146: iinc 1 1
    //   149: goto -87 -> 62
    //   152: aload 4
    //   154: monitorexit
    //   155: aconst_null
    //   156: astore_3
    //   157: goto -146 -> 11
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	160	0	paramString	String
    //   1	146	1	i	int
    //   21	105	2	localParsePosition	java.text.ParsePosition
    //   10	147	3	localDate	Date
    //   51	102	4	arrayOfString	String[]
    //   138	6	5	localObject1	Object
    //   60	6	6	j	int
    //   73	45	7	localObject2	Object
    // Exception table:
    //   from	to	target	type
    //   56	143	138	finally
    //   152	155	138	finally
  }
}


/* Location:           C:\Users\dreadiscool\Desktop\tools\classes-dex2jar.jar
 * Qualified Name:     Av
 * JD-Core Version:    0.7.0.1
 */