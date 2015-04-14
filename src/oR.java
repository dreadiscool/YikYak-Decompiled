import java.io.IOException;
import java.io.Reader;
import java.io.StringReader;
import java.io.StringWriter;
import java.io.Writer;
import java.lang.reflect.Type;
import java.math.BigDecimal;
import java.math.BigInteger;
import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;

public final class oR
{
  final pa a = new oS(this);
  final ph b = new oT(this);
  private final ThreadLocal<Map<rn<?>, oX<?>>> c = new ThreadLocal();
  private final Map<rn<?>, pm<?>> d = Collections.synchronizedMap(new HashMap());
  private final List<pn> e;
  private final px f;
  private final boolean g;
  private final boolean h;
  private final boolean i;
  private final boolean j;
  
  public oR()
  {
    this(pK.a, oK.a, Collections.emptyMap(), false, false, false, true, false, false, pj.a, Collections.emptyList());
  }
  
  oR(pK parampK, oQ paramoQ, Map<Type, oY<?>> paramMap, boolean paramBoolean1, boolean paramBoolean2, boolean paramBoolean3, boolean paramBoolean4, boolean paramBoolean5, boolean paramBoolean6, pj parampj, List<pn> paramList)
  {
    this.f = new px(paramMap);
    this.g = paramBoolean1;
    this.i = paramBoolean3;
    this.h = paramBoolean4;
    this.j = paramBoolean5;
    ArrayList localArrayList = new ArrayList();
    localArrayList.add(qF.Q);
    localArrayList.add(qt.a);
    localArrayList.add(parampK);
    localArrayList.addAll(paramList);
    localArrayList.add(qF.x);
    localArrayList.add(qF.m);
    localArrayList.add(qF.g);
    localArrayList.add(qF.i);
    localArrayList.add(qF.k);
    localArrayList.add(qF.a(Long.TYPE, Long.class, a(parampj)));
    localArrayList.add(qF.a(Double.TYPE, Double.class, a(paramBoolean6)));
    localArrayList.add(qF.a(Float.TYPE, Float.class, b(paramBoolean6)));
    localArrayList.add(qF.r);
    localArrayList.add(qF.t);
    localArrayList.add(qF.z);
    localArrayList.add(qF.B);
    localArrayList.add(qF.a(BigDecimal.class, qF.v));
    localArrayList.add(qF.a(BigInteger.class, qF.w));
    localArrayList.add(qF.D);
    localArrayList.add(qF.F);
    localArrayList.add(qF.J);
    localArrayList.add(qF.O);
    localArrayList.add(qF.H);
    localArrayList.add(qF.d);
    localArrayList.add(ql.a);
    localArrayList.add(qF.M);
    localArrayList.add(qC.a);
    localArrayList.add(qA.a);
    localArrayList.add(qF.K);
    localArrayList.add(qh.a);
    localArrayList.add(qF.R);
    localArrayList.add(qF.b);
    localArrayList.add(new qj(this.f));
    localArrayList.add(new qr(this.f, paramBoolean2));
    localArrayList.add(new qw(this.f, paramoQ, parampK));
    this.e = Collections.unmodifiableList(localArrayList);
  }
  
  private pm<Number> a(pj parampj)
  {
    if (parampj == pj.a) {}
    for (Object localObject = qF.n;; localObject = new oW(this)) {
      return localObject;
    }
  }
  
  private pm<Number> a(boolean paramBoolean)
  {
    if (paramBoolean) {}
    for (Object localObject = qF.p;; localObject = new oU(this)) {
      return localObject;
    }
  }
  
  private rr a(Writer paramWriter)
  {
    if (this.i) {
      paramWriter.write(")]}'\n");
    }
    rr localrr = new rr(paramWriter);
    if (this.j) {
      localrr.c("  ");
    }
    localrr.d(this.g);
    return localrr;
  }
  
  private void a(double paramDouble)
  {
    if ((Double.isNaN(paramDouble)) || (Double.isInfinite(paramDouble))) {
      throw new IllegalArgumentException(paramDouble + " is not a valid double value as per JSON specification. To override this" + " behavior, use GsonBuilder.serializeSpecialFloatingPointValues() method.");
    }
  }
  
  private static void a(Object paramObject, ro paramro)
  {
    if (paramObject != null) {
      try
      {
        if (paramro.f() != rq.j) {
          throw new pc("JSON document was not fully consumed.");
        }
      }
      catch (rs localrs)
      {
        throw new pi(localrs);
      }
      catch (IOException localIOException)
      {
        throw new pc(localIOException);
      }
    }
  }
  
  private pm<Number> b(boolean paramBoolean)
  {
    if (paramBoolean) {}
    for (Object localObject = qF.o;; localObject = new oV(this)) {
      return localObject;
    }
  }
  
  public <T> T a(Reader paramReader, Type paramType)
  {
    ro localro = new ro(paramReader);
    Object localObject = a(localro, paramType);
    a(localObject, localro);
    return localObject;
  }
  
  public <T> T a(String paramString, Class<T> paramClass)
  {
    Object localObject = a(paramString, paramClass);
    return pX.a(paramClass).cast(localObject);
  }
  
  public <T> T a(String paramString, Type paramType)
  {
    if (paramString == null) {}
    for (Object localObject = null;; localObject = a(new StringReader(paramString), paramType)) {
      return localObject;
    }
  }
  
  /* Error */
  public <T> T a(ro paramro, Type paramType)
  {
    // Byte code:
    //   0: iconst_1
    //   1: istore_3
    //   2: aload_1
    //   3: invokevirtual 377	ro:p	()Z
    //   6: istore 4
    //   8: aload_1
    //   9: iload_3
    //   10: invokevirtual 379	ro:a	(Z)V
    //   13: aload_1
    //   14: invokevirtual 316	ro:f	()Lrq;
    //   17: pop
    //   18: iconst_0
    //   19: istore_3
    //   20: aload_0
    //   21: aload_2
    //   22: invokestatic 384	rn:a	(Ljava/lang/reflect/Type;)Lrn;
    //   25: invokevirtual 387	oR:a	(Lrn;)Lpm;
    //   28: aload_1
    //   29: invokevirtual 392	pm:b	(Lro;)Ljava/lang/Object;
    //   32: astore 11
    //   34: aload 11
    //   36: astore 9
    //   38: aload_1
    //   39: iload 4
    //   41: invokevirtual 379	ro:a	(Z)V
    //   44: aload 9
    //   46: areturn
    //   47: astore 8
    //   49: iload_3
    //   50: ifeq +15 -> 65
    //   53: aconst_null
    //   54: astore 9
    //   56: aload_1
    //   57: iload 4
    //   59: invokevirtual 379	ro:a	(Z)V
    //   62: goto -18 -> 44
    //   65: new 328	pi
    //   68: dup
    //   69: aload 8
    //   71: invokespecial 331	pi:<init>	(Ljava/lang/Throwable;)V
    //   74: athrow
    //   75: astore 6
    //   77: aload_1
    //   78: iload 4
    //   80: invokevirtual 379	ro:a	(Z)V
    //   83: aload 6
    //   85: athrow
    //   86: astore 7
    //   88: new 328	pi
    //   91: dup
    //   92: aload 7
    //   94: invokespecial 331	pi:<init>	(Ljava/lang/Throwable;)V
    //   97: athrow
    //   98: astore 5
    //   100: new 328	pi
    //   103: dup
    //   104: aload 5
    //   106: invokespecial 331	pi:<init>	(Ljava/lang/Throwable;)V
    //   109: athrow
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	110	0	this	oR
    //   0	110	1	paramro	ro
    //   0	110	2	paramType	Type
    //   1	49	3	bool1	boolean
    //   6	73	4	bool2	boolean
    //   98	7	5	localIOException	IOException
    //   75	9	6	localObject1	Object
    //   86	7	7	localIllegalStateException	java.lang.IllegalStateException
    //   47	23	8	localEOFException	java.io.EOFException
    //   36	19	9	localObject2	Object
    //   32	3	11	localObject3	Object
    // Exception table:
    //   from	to	target	type
    //   13	34	47	java/io/EOFException
    //   13	34	75	finally
    //   65	75	75	finally
    //   88	110	75	finally
    //   13	34	86	java/lang/IllegalStateException
    //   13	34	98	java/io/IOException
  }
  
  public String a(Object paramObject, Type paramType)
  {
    StringWriter localStringWriter = new StringWriter();
    a(paramObject, paramType, localStringWriter);
    return localStringWriter.toString();
  }
  
  public <T> pm<T> a(Class<T> paramClass)
  {
    return a(rn.b(paramClass));
  }
  
  public <T> pm<T> a(pn parampn, rn<T> paramrn)
  {
    Iterator localIterator = this.e.iterator();
    int k = 0;
    while (localIterator.hasNext())
    {
      pn localpn = (pn)localIterator.next();
      if (k == 0)
      {
        if (localpn == parampn) {
          k = 1;
        }
      }
      else
      {
        pm localpm = localpn.a(this, paramrn);
        if (localpm != null) {
          return localpm;
        }
      }
    }
    throw new IllegalArgumentException("GSON cannot serialize " + paramrn);
  }
  
  public <T> pm<T> a(rn<T> paramrn)
  {
    Object localObject1 = (pm)this.d.get(paramrn);
    if (localObject1 != null) {
      return localObject1;
    }
    Map localMap = (Map)this.c.get();
    int k = 0;
    Object localObject2;
    if (localMap == null)
    {
      HashMap localHashMap = new HashMap();
      this.c.set(localHashMap);
      localObject2 = localHashMap;
      k = 1;
    }
    for (;;)
    {
      for (;;)
      {
        localObject1 = (oX)((Map)localObject2).get(paramrn);
        if (localObject1 != null) {
          break;
        }
        try
        {
          oX localoX = new oX();
          ((Map)localObject2).put(paramrn, localoX);
          Iterator localIterator = this.e.iterator();
          for (;;)
          {
            if (localIterator.hasNext())
            {
              localObject1 = ((pn)localIterator.next()).a(this, paramrn);
              if (localObject1 != null)
              {
                localoX.a((pm)localObject1);
                this.d.put(paramrn, localObject1);
                ((Map)localObject2).remove(paramrn);
                if (k == 0) {
                  break;
                }
                this.c.remove();
                break;
              }
            }
          }
          throw new IllegalArgumentException("GSON cannot handle " + paramrn);
        }
        finally
        {
          ((Map)localObject2).remove(paramrn);
          if (k != 0) {
            this.c.remove();
          }
        }
      }
      localObject2 = localMap;
    }
  }
  
  public void a(Object paramObject, Type paramType, Appendable paramAppendable)
  {
    try
    {
      a(paramObject, paramType, a(pY.a(paramAppendable)));
      return;
    }
    catch (IOException localIOException)
    {
      throw new pc(localIOException);
    }
  }
  
  public void a(Object paramObject, Type paramType, rr paramrr)
  {
    pm localpm = a(rn.a(paramType));
    boolean bool1 = paramrr.g();
    paramrr.b(true);
    boolean bool2 = paramrr.h();
    paramrr.c(this.h);
    boolean bool3 = paramrr.i();
    paramrr.d(this.g);
    try
    {
      localpm.a(paramrr, paramObject);
      return;
    }
    catch (IOException localIOException)
    {
      throw new pc(localIOException);
    }
    finally
    {
      paramrr.b(bool1);
      paramrr.c(bool2);
      paramrr.d(bool3);
    }
  }
  
  public String toString()
  {
    return "{serializeNulls:" + this.g + "factories:" + this.e + ",instanceCreators:" + this.f + "}";
  }
}


/* Location:           C:\Users\dreadiscool\Desktop\tools\classes-dex2jar.jar
 * Qualified Name:     oR
 * JD-Core Version:    0.7.0.1
 */