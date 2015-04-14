package com.google.android.gms.common.api;

class Batch$1
  implements PendingResult.a
{
  Batch$1(Batch paramBatch) {}
  
  /* Error */
  public void m(Status paramStatus)
  {
    // Byte code:
    //   0: aload_0
    //   1: getfield 12	com/google/android/gms/common/api/Batch$1:JD	Lcom/google/android/gms/common/api/Batch;
    //   4: invokestatic 23	com/google/android/gms/common/api/Batch:a	(Lcom/google/android/gms/common/api/Batch;)Ljava/lang/Object;
    //   7: astore_2
    //   8: aload_2
    //   9: monitorenter
    //   10: aload_0
    //   11: getfield 12	com/google/android/gms/common/api/Batch$1:JD	Lcom/google/android/gms/common/api/Batch;
    //   14: invokevirtual 27	com/google/android/gms/common/api/Batch:isCanceled	()Z
    //   17: ifeq +8 -> 25
    //   20: aload_2
    //   21: monitorexit
    //   22: goto +138 -> 160
    //   25: aload_1
    //   26: invokevirtual 30	com/google/android/gms/common/api/Status:isCanceled	()Z
    //   29: ifeq +57 -> 86
    //   32: aload_0
    //   33: getfield 12	com/google/android/gms/common/api/Batch$1:JD	Lcom/google/android/gms/common/api/Batch;
    //   36: iconst_1
    //   37: invokestatic 33	com/google/android/gms/common/api/Batch:a	(Lcom/google/android/gms/common/api/Batch;Z)Z
    //   40: pop
    //   41: aload_0
    //   42: getfield 12	com/google/android/gms/common/api/Batch$1:JD	Lcom/google/android/gms/common/api/Batch;
    //   45: invokestatic 37	com/google/android/gms/common/api/Batch:b	(Lcom/google/android/gms/common/api/Batch;)I
    //   48: pop
    //   49: aload_0
    //   50: getfield 12	com/google/android/gms/common/api/Batch$1:JD	Lcom/google/android/gms/common/api/Batch;
    //   53: invokestatic 40	com/google/android/gms/common/api/Batch:c	(Lcom/google/android/gms/common/api/Batch;)I
    //   56: ifne +20 -> 76
    //   59: aload_0
    //   60: getfield 12	com/google/android/gms/common/api/Batch$1:JD	Lcom/google/android/gms/common/api/Batch;
    //   63: invokestatic 44	com/google/android/gms/common/api/Batch:d	(Lcom/google/android/gms/common/api/Batch;)Z
    //   66: ifeq +39 -> 105
    //   69: aload_0
    //   70: getfield 12	com/google/android/gms/common/api/Batch$1:JD	Lcom/google/android/gms/common/api/Batch;
    //   73: invokestatic 47	com/google/android/gms/common/api/Batch:e	(Lcom/google/android/gms/common/api/Batch;)V
    //   76: aload_2
    //   77: monitorexit
    //   78: goto +82 -> 160
    //   81: astore_3
    //   82: aload_2
    //   83: monitorexit
    //   84: aload_3
    //   85: athrow
    //   86: aload_1
    //   87: invokevirtual 50	com/google/android/gms/common/api/Status:isSuccess	()Z
    //   90: ifne -49 -> 41
    //   93: aload_0
    //   94: getfield 12	com/google/android/gms/common/api/Batch$1:JD	Lcom/google/android/gms/common/api/Batch;
    //   97: iconst_1
    //   98: invokestatic 52	com/google/android/gms/common/api/Batch:b	(Lcom/google/android/gms/common/api/Batch;Z)Z
    //   101: pop
    //   102: goto -61 -> 41
    //   105: aload_0
    //   106: getfield 12	com/google/android/gms/common/api/Batch$1:JD	Lcom/google/android/gms/common/api/Batch;
    //   109: invokestatic 55	com/google/android/gms/common/api/Batch:f	(Lcom/google/android/gms/common/api/Batch;)Z
    //   112: ifeq +40 -> 152
    //   115: new 29	com/google/android/gms/common/api/Status
    //   118: dup
    //   119: bipush 13
    //   121: invokespecial 58	com/google/android/gms/common/api/Status:<init>	(I)V
    //   124: astore 6
    //   126: aload_0
    //   127: getfield 12	com/google/android/gms/common/api/Batch$1:JD	Lcom/google/android/gms/common/api/Batch;
    //   130: new 60	com/google/android/gms/common/api/BatchResult
    //   133: dup
    //   134: aload 6
    //   136: aload_0
    //   137: getfield 12	com/google/android/gms/common/api/Batch$1:JD	Lcom/google/android/gms/common/api/Batch;
    //   140: invokestatic 64	com/google/android/gms/common/api/Batch:g	(Lcom/google/android/gms/common/api/Batch;)[Lcom/google/android/gms/common/api/PendingResult;
    //   143: invokespecial 67	com/google/android/gms/common/api/BatchResult:<init>	(Lcom/google/android/gms/common/api/Status;[Lcom/google/android/gms/common/api/PendingResult;)V
    //   146: invokevirtual 70	com/google/android/gms/common/api/Batch:b	(Lcom/google/android/gms/common/api/Result;)V
    //   149: goto -73 -> 76
    //   152: getstatic 74	com/google/android/gms/common/api/Status:Kw	Lcom/google/android/gms/common/api/Status;
    //   155: astore 6
    //   157: goto -31 -> 126
    //   160: return
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	161	0	this	1
    //   0	161	1	paramStatus	Status
    //   7	76	2	localObject1	Object
    //   81	4	3	localObject2	Object
    //   124	32	6	localStatus	Status
    // Exception table:
    //   from	to	target	type
    //   10	84	81	finally
    //   86	157	81	finally
  }
}


/* Location:           C:\Users\dreadiscool\Desktop\tools\classes-dex2jar.jar
 * Qualified Name:     com.google.android.gms.common.api.Batch.1
 * JD-Core Version:    0.7.0.1
 */