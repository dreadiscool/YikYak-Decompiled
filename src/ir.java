import java.util.LinkedHashMap;

public class ir<K, V>
{
  private int NA;
  private int NB;
  private int NC;
  private final LinkedHashMap<K, V> Nw;
  private int Nx;
  private int Ny;
  private int Nz;
  private int size;
  
  public ir(int paramInt)
  {
    if (paramInt <= 0) {
      throw new IllegalArgumentException("maxSize <= 0");
    }
    this.Nx = paramInt;
    this.Nw = new LinkedHashMap(0, 0.75F, true);
  }
  
  private int c(K paramK, V paramV)
  {
    int i = sizeOf(paramK, paramV);
    if (i < 0) {
      throw new IllegalStateException("Negative size: " + paramK + "=" + paramV);
    }
    return i;
  }
  
  protected V create(K paramK)
  {
    return null;
  }
  
  public void entryRemoved(boolean paramBoolean, K paramK, V paramV1, V paramV2) {}
  
  public final void evictAll()
  {
    trimToSize(-1);
  }
  
  public final V get(K paramK)
  {
    if (paramK == null) {
      throw new NullPointerException("key == null");
    }
    Object localObject3;
    try
    {
      localObject2 = this.Nw.get(paramK);
      if (localObject2 != null)
      {
        this.NB = (1 + this.NB);
      }
      else
      {
        this.NC = (1 + this.NC);
        localObject3 = create(paramK);
        if (localObject3 == null) {
          localObject2 = null;
        }
      }
    }
    finally {}
    try
    {
      this.Nz = (1 + this.Nz);
      localObject2 = this.Nw.put(paramK, localObject3);
      if (localObject2 != null) {
        this.Nw.put(paramK, localObject2);
      }
      for (;;)
      {
        if (localObject2 == null) {
          break;
        }
        entryRemoved(false, paramK, localObject3, localObject2);
        return localObject2;
        this.size += c(paramK, localObject3);
      }
      trimToSize(this.Nx);
    }
    finally {}
    Object localObject2 = localObject3;
    return localObject2;
  }
  
  public final V put(K paramK, V paramV)
  {
    if ((paramK == null) || (paramV == null)) {
      throw new NullPointerException("key == null || value == null");
    }
    try
    {
      this.Ny = (1 + this.Ny);
      this.size += c(paramK, paramV);
      Object localObject2 = this.Nw.put(paramK, paramV);
      if (localObject2 != null) {
        this.size -= c(paramK, localObject2);
      }
      if (localObject2 != null) {
        entryRemoved(false, paramK, localObject2, paramV);
      }
      trimToSize(this.Nx);
      return localObject2;
    }
    finally {}
  }
  
  public final int size()
  {
    try
    {
      int i = this.size;
      return i;
    }
    finally
    {
      localObject = finally;
      throw localObject;
    }
  }
  
  public int sizeOf(K paramK, V paramV)
  {
    return 1;
  }
  
  public final String toString()
  {
    int i = 0;
    try
    {
      int j = this.NB + this.NC;
      if (j != 0) {
        i = 100 * this.NB / j;
      }
      Object[] arrayOfObject = new Object[4];
      arrayOfObject[0] = Integer.valueOf(this.Nx);
      arrayOfObject[1] = Integer.valueOf(this.NB);
      arrayOfObject[2] = Integer.valueOf(this.NC);
      arrayOfObject[3] = Integer.valueOf(i);
      String str = String.format("LruCache[maxSize=%d,hits=%d,misses=%d,hitRate=%d%%]", arrayOfObject);
      return str;
    }
    finally
    {
      localObject = finally;
      throw localObject;
    }
  }
  
  /* Error */
  public void trimToSize(int paramInt)
  {
    // Byte code:
    //   0: aload_0
    //   1: monitorenter
    //   2: aload_0
    //   3: getfield 96	ir:size	I
    //   6: iflt +20 -> 26
    //   9: aload_0
    //   10: getfield 38	ir:Nw	Ljava/util/LinkedHashMap;
    //   13: invokevirtual 121	java/util/LinkedHashMap:isEmpty	()Z
    //   16: ifeq +48 -> 64
    //   19: aload_0
    //   20: getfield 96	ir:size	I
    //   23: ifeq +41 -> 64
    //   26: new 45	java/lang/IllegalStateException
    //   29: dup
    //   30: new 47	java/lang/StringBuilder
    //   33: dup
    //   34: invokespecial 48	java/lang/StringBuilder:<init>	()V
    //   37: aload_0
    //   38: invokevirtual 125	java/lang/Object:getClass	()Ljava/lang/Class;
    //   41: invokevirtual 130	java/lang/Class:getName	()Ljava/lang/String;
    //   44: invokevirtual 54	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   47: ldc 132
    //   49: invokevirtual 54	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   52: invokevirtual 63	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   55: invokespecial 64	java/lang/IllegalStateException:<init>	(Ljava/lang/String;)V
    //   58: athrow
    //   59: astore_2
    //   60: aload_0
    //   61: monitorexit
    //   62: aload_2
    //   63: athrow
    //   64: aload_0
    //   65: getfield 96	ir:size	I
    //   68: iload_1
    //   69: if_icmple +13 -> 82
    //   72: aload_0
    //   73: getfield 38	ir:Nw	Ljava/util/LinkedHashMap;
    //   76: invokevirtual 121	java/util/LinkedHashMap:isEmpty	()Z
    //   79: ifeq +6 -> 85
    //   82: aload_0
    //   83: monitorexit
    //   84: return
    //   85: aload_0
    //   86: getfield 38	ir:Nw	Ljava/util/LinkedHashMap;
    //   89: invokevirtual 136	java/util/LinkedHashMap:entrySet	()Ljava/util/Set;
    //   92: invokeinterface 142 1 0
    //   97: invokeinterface 148 1 0
    //   102: checkcast 150	java/util/Map$Entry
    //   105: astore_3
    //   106: aload_3
    //   107: invokeinterface 153 1 0
    //   112: astore 4
    //   114: aload_3
    //   115: invokeinterface 156 1 0
    //   120: astore 5
    //   122: aload_0
    //   123: getfield 38	ir:Nw	Ljava/util/LinkedHashMap;
    //   126: aload 4
    //   128: invokevirtual 159	java/util/LinkedHashMap:remove	(Ljava/lang/Object;)Ljava/lang/Object;
    //   131: pop
    //   132: aload_0
    //   133: aload_0
    //   134: getfield 96	ir:size	I
    //   137: aload_0
    //   138: aload 4
    //   140: aload 5
    //   142: invokespecial 98	ir:c	(Ljava/lang/Object;Ljava/lang/Object;)I
    //   145: isub
    //   146: putfield 96	ir:size	I
    //   149: aload_0
    //   150: iconst_1
    //   151: aload_0
    //   152: getfield 161	ir:NA	I
    //   155: iadd
    //   156: putfield 161	ir:NA	I
    //   159: aload_0
    //   160: monitorexit
    //   161: aload_0
    //   162: iconst_1
    //   163: aload 4
    //   165: aload 5
    //   167: aconst_null
    //   168: invokevirtual 94	ir:entryRemoved	(ZLjava/lang/Object;Ljava/lang/Object;Ljava/lang/Object;)V
    //   171: goto -171 -> 0
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	174	0	this	ir
    //   0	174	1	paramInt	int
    //   59	4	2	localObject1	Object
    //   105	10	3	localEntry	java.util.Map.Entry
    //   112	52	4	localObject2	Object
    //   120	46	5	localObject3	Object
    // Exception table:
    //   from	to	target	type
    //   2	62	59	finally
    //   64	161	59	finally
  }
}


/* Location:           C:\Users\dreadiscool\Desktop\tools\classes-dex2jar.jar
 * Qualified Name:     ir
 * JD-Core Version:    0.7.0.1
 */