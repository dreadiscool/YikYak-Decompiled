import java.sql.Time;
import java.text.DateFormat;
import java.text.SimpleDateFormat;

public final class qC
  extends pm<Time>
{
  public static final pn a = new qD();
  private final DateFormat b = new SimpleDateFormat("hh:mm:ss a");
  
  /* Error */
  public Time a(ro paramro)
  {
    // Byte code:
    //   0: aload_0
    //   1: monitorenter
    //   2: aload_1
    //   3: invokevirtual 37	ro:f	()Lrq;
    //   6: getstatic 43	rq:i	Lrq;
    //   9: if_acmpne +13 -> 22
    //   12: aload_1
    //   13: invokevirtual 46	ro:j	()V
    //   16: aconst_null
    //   17: astore_3
    //   18: aload_0
    //   19: monitorexit
    //   20: aload_3
    //   21: areturn
    //   22: new 48	java/sql/Time
    //   25: dup
    //   26: aload_0
    //   27: getfield 28	qC:b	Ljava/text/DateFormat;
    //   30: aload_1
    //   31: invokevirtual 52	ro:h	()Ljava/lang/String;
    //   34: invokevirtual 58	java/text/DateFormat:parse	(Ljava/lang/String;)Ljava/util/Date;
    //   37: invokevirtual 64	java/util/Date:getTime	()J
    //   40: invokespecial 67	java/sql/Time:<init>	(J)V
    //   43: astore_3
    //   44: goto -26 -> 18
    //   47: astore 4
    //   49: new 69	pi
    //   52: dup
    //   53: aload 4
    //   55: invokespecial 72	pi:<init>	(Ljava/lang/Throwable;)V
    //   58: athrow
    //   59: astore_2
    //   60: aload_0
    //   61: monitorexit
    //   62: aload_2
    //   63: athrow
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	64	0	this	qC
    //   0	64	1	paramro	ro
    //   59	4	2	localObject	Object
    //   17	27	3	localTime	Time
    //   47	7	4	localParseException	java.text.ParseException
    // Exception table:
    //   from	to	target	type
    //   22	44	47	java/text/ParseException
    //   2	16	59	finally
    //   22	44	59	finally
    //   49	59	59	finally
  }
  
  public void a(rr paramrr, Time paramTime)
  {
    if (paramTime == null) {}
    String str;
    for (Object localObject2 = null;; localObject2 = str)
    {
      try
      {
        paramrr.b((String)localObject2);
        return;
      }
      finally {}
      str = this.b.format(paramTime);
    }
  }
}


/* Location:           C:\Users\dreadiscool\Desktop\tools\classes-dex2jar.jar
 * Qualified Name:     qC
 * JD-Core Version:    0.7.0.1
 */