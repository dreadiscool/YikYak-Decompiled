public abstract class rV<MessageType extends sE>
  implements sI<MessageType>
{
  private static final sg a = ;
  
  private sX a(MessageType paramMessageType)
  {
    sX localsX;
    if ((paramMessageType instanceof rS)) {
      localsX = ((rS)paramMessageType).Q();
    }
    for (;;)
    {
      return localsX;
      if ((paramMessageType instanceof rU)) {
        localsX = ((rU)paramMessageType).b();
      } else {
        localsX = new sX(paramMessageType);
      }
    }
  }
  
  private MessageType b(MessageType paramMessageType)
  {
    if ((paramMessageType != null) && (!paramMessageType.j())) {
      throw a(paramMessageType).a().a(paramMessageType);
    }
    return paramMessageType;
  }
  
  /* Error */
  public MessageType a(rZ paramrZ, sg paramsg)
  {
    // Byte code:
    //   0: aload_1
    //   1: invokevirtual 64	rZ:h	()Lsc;
    //   4: astore 5
    //   6: aload_0
    //   7: aload 5
    //   9: aload_2
    //   10: invokevirtual 67	rV:b	(Lsc;Lsg;)Ljava/lang/Object;
    //   13: checkcast 41	sE
    //   16: astore 6
    //   18: aload 5
    //   20: iconst_0
    //   21: invokevirtual 72	sc:a	(I)V
    //   24: aload 6
    //   26: areturn
    //   27: astore 7
    //   29: aload 7
    //   31: aload 6
    //   33: invokevirtual 55	sx:a	(LsE;)Lsx;
    //   36: athrow
    //   37: astore 4
    //   39: aload 4
    //   41: athrow
    //   42: astore_3
    //   43: new 74	java/lang/RuntimeException
    //   46: dup
    //   47: ldc 76
    //   49: aload_3
    //   50: invokespecial 79	java/lang/RuntimeException:<init>	(Ljava/lang/String;Ljava/lang/Throwable;)V
    //   53: athrow
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	54	0	this	rV
    //   0	54	1	paramrZ	rZ
    //   0	54	2	paramsg	sg
    //   42	8	3	localIOException	java.io.IOException
    //   37	3	4	localsx1	sx
    //   4	15	5	localsc	sc
    //   16	16	6	localsE	sE
    //   27	3	7	localsx2	sx
    // Exception table:
    //   from	to	target	type
    //   18	24	27	sx
    //   0	18	37	sx
    //   29	37	37	sx
    //   0	18	42	java/io/IOException
    //   18	24	42	java/io/IOException
    //   29	37	42	java/io/IOException
  }
  
  public MessageType b(rZ paramrZ, sg paramsg)
  {
    return b(a(paramrZ, paramsg));
  }
}


/* Location:           C:\Users\dreadiscool\Desktop\tools\classes-dex2jar.jar
 * Qualified Name:     rV
 * JD-Core Version:    0.7.0.1
 */