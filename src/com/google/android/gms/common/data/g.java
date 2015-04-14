package com.google.android.gms.common.data;

import java.util.ArrayList;

public abstract class g<T>
  extends DataBuffer<T>
{
  private boolean Lr = false;
  private ArrayList<Integer> Ls;
  
  protected g(DataHolder paramDataHolder)
  {
    super(paramDataHolder);
  }
  
  /* Error */
  private void hb()
  {
    // Byte code:
    //   0: aload_0
    //   1: monitorenter
    //   2: aload_0
    //   3: getfield 16	com/google/android/gms/common/data/g:Lr	Z
    //   6: ifne +192 -> 198
    //   9: aload_0
    //   10: getfield 22	com/google/android/gms/common/data/g:JG	Lcom/google/android/gms/common/data/DataHolder;
    //   13: invokevirtual 28	com/google/android/gms/common/data/DataHolder:getCount	()I
    //   16: istore_2
    //   17: aload_0
    //   18: new 30	java/util/ArrayList
    //   21: dup
    //   22: invokespecial 32	java/util/ArrayList:<init>	()V
    //   25: putfield 34	com/google/android/gms/common/data/g:Ls	Ljava/util/ArrayList;
    //   28: iload_2
    //   29: ifle +164 -> 193
    //   32: aload_0
    //   33: getfield 34	com/google/android/gms/common/data/g:Ls	Ljava/util/ArrayList;
    //   36: iconst_0
    //   37: invokestatic 40	java/lang/Integer:valueOf	(I)Ljava/lang/Integer;
    //   40: invokevirtual 44	java/util/ArrayList:add	(Ljava/lang/Object;)Z
    //   43: pop
    //   44: aload_0
    //   45: invokevirtual 48	com/google/android/gms/common/data/g:ha	()Ljava/lang/String;
    //   48: astore 4
    //   50: aload_0
    //   51: getfield 22	com/google/android/gms/common/data/g:JG	Lcom/google/android/gms/common/data/DataHolder;
    //   54: iconst_0
    //   55: invokevirtual 52	com/google/android/gms/common/data/DataHolder:au	(I)I
    //   58: istore 5
    //   60: aload_0
    //   61: getfield 22	com/google/android/gms/common/data/g:JG	Lcom/google/android/gms/common/data/DataHolder;
    //   64: aload 4
    //   66: iconst_0
    //   67: iload 5
    //   69: invokevirtual 56	com/google/android/gms/common/data/DataHolder:c	(Ljava/lang/String;II)Ljava/lang/String;
    //   72: astore 6
    //   74: iconst_1
    //   75: istore 7
    //   77: iload 7
    //   79: iload_2
    //   80: if_icmpge +113 -> 193
    //   83: aload_0
    //   84: getfield 22	com/google/android/gms/common/data/g:JG	Lcom/google/android/gms/common/data/DataHolder;
    //   87: iload 7
    //   89: invokevirtual 52	com/google/android/gms/common/data/DataHolder:au	(I)I
    //   92: istore 8
    //   94: aload_0
    //   95: getfield 22	com/google/android/gms/common/data/g:JG	Lcom/google/android/gms/common/data/DataHolder;
    //   98: aload 4
    //   100: iload 7
    //   102: iload 8
    //   104: invokevirtual 56	com/google/android/gms/common/data/DataHolder:c	(Ljava/lang/String;II)Ljava/lang/String;
    //   107: astore 9
    //   109: aload 9
    //   111: ifnonnull +56 -> 167
    //   114: new 58	java/lang/NullPointerException
    //   117: dup
    //   118: new 60	java/lang/StringBuilder
    //   121: dup
    //   122: invokespecial 61	java/lang/StringBuilder:<init>	()V
    //   125: ldc 63
    //   127: invokevirtual 67	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   130: aload 4
    //   132: invokevirtual 67	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   135: ldc 69
    //   137: invokevirtual 67	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   140: iload 7
    //   142: invokevirtual 72	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   145: ldc 74
    //   147: invokevirtual 67	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   150: iload 8
    //   152: invokevirtual 72	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   155: invokevirtual 77	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   158: invokespecial 80	java/lang/NullPointerException:<init>	(Ljava/lang/String;)V
    //   161: athrow
    //   162: astore_1
    //   163: aload_0
    //   164: monitorexit
    //   165: aload_1
    //   166: athrow
    //   167: aload 9
    //   169: aload 6
    //   171: invokevirtual 85	java/lang/String:equals	(Ljava/lang/Object;)Z
    //   174: ifne +27 -> 201
    //   177: aload_0
    //   178: getfield 34	com/google/android/gms/common/data/g:Ls	Ljava/util/ArrayList;
    //   181: iload 7
    //   183: invokestatic 40	java/lang/Integer:valueOf	(I)Ljava/lang/Integer;
    //   186: invokevirtual 44	java/util/ArrayList:add	(Ljava/lang/Object;)Z
    //   189: pop
    //   190: goto +15 -> 205
    //   193: aload_0
    //   194: iconst_1
    //   195: putfield 16	com/google/android/gms/common/data/g:Lr	Z
    //   198: aload_0
    //   199: monitorexit
    //   200: return
    //   201: aload 6
    //   203: astore 9
    //   205: iinc 7 1
    //   208: aload 9
    //   210: astore 6
    //   212: goto -135 -> 77
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	215	0	this	g
    //   162	4	1	localObject1	Object
    //   16	65	2	i	int
    //   48	83	4	str	String
    //   58	10	5	j	int
    //   72	139	6	localObject2	Object
    //   75	131	7	k	int
    //   92	59	8	m	int
    //   107	102	9	localObject3	Object
    // Exception table:
    //   from	to	target	type
    //   2	165	162	finally
    //   167	200	162	finally
  }
  
  int ax(int paramInt)
  {
    if ((paramInt < 0) || (paramInt >= this.Ls.size())) {
      throw new IllegalArgumentException("Position " + paramInt + " is out of bounds for this buffer");
    }
    return ((Integer)this.Ls.get(paramInt)).intValue();
  }
  
  protected int ay(int paramInt)
  {
    int i;
    if ((paramInt < 0) || (paramInt == this.Ls.size())) {
      i = 0;
    }
    label141:
    for (;;)
    {
      return i;
      if (paramInt == -1 + this.Ls.size()) {}
      for (i = this.JG.getCount() - ((Integer)this.Ls.get(paramInt)).intValue();; i = ((Integer)this.Ls.get(paramInt + 1)).intValue() - ((Integer)this.Ls.get(paramInt)).intValue())
      {
        if (i != 1) {
          break label141;
        }
        int j = ax(paramInt);
        int k = this.JG.au(j);
        String str = hc();
        if ((str == null) || (this.JG.c(str, j, k) != null)) {
          break;
        }
        i = 0;
        break;
      }
    }
  }
  
  protected abstract T f(int paramInt1, int paramInt2);
  
  public final T get(int paramInt)
  {
    hb();
    return f(ax(paramInt), ay(paramInt));
  }
  
  public int getCount()
  {
    hb();
    return this.Ls.size();
  }
  
  protected abstract String ha();
  
  protected String hc()
  {
    return null;
  }
}


/* Location:           C:\Users\dreadiscool\Desktop\tools\classes-dex2jar.jar
 * Qualified Name:     com.google.android.gms.common.data.g
 * JD-Core Version:    0.7.0.1
 */