import java.io.Closeable;
import java.io.EOFException;
import java.io.File;
import java.io.IOException;
import java.util.Collection;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.concurrent.Executor;
import java.util.concurrent.LinkedBlockingQueue;
import java.util.concurrent.ThreadPoolExecutor;
import java.util.concurrent.TimeUnit;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public final class zL
  implements Closeable
{
  static final Pattern a = Pattern.compile("[a-z0-9_-]{1,120}");
  private static final LU p = new zN();
  private final File b;
  private final File c;
  private final File d;
  private final File e;
  private final int f;
  private long g;
  private final int h;
  private long i = 0L;
  private LC j;
  private final LinkedHashMap<String, zQ> k = new LinkedHashMap(0, 0.75F, true);
  private int l;
  private long m = 0L;
  private final Executor n;
  private final Runnable o = new zM(this);
  
  zL(File paramFile, int paramInt1, int paramInt2, long paramLong, Executor paramExecutor)
  {
    this.b = paramFile;
    this.f = paramInt1;
    this.c = new File(paramFile, "journal");
    this.d = new File(paramFile, "journal.tmp");
    this.e = new File(paramFile, "journal.bkp");
    this.h = paramInt2;
    this.g = paramLong;
    this.n = paramExecutor;
  }
  
  public static zL a(File paramFile, int paramInt1, int paramInt2, long paramLong)
  {
    if (paramLong <= 0L) {
      throw new IllegalArgumentException("maxSize <= 0");
    }
    if (paramInt2 <= 0) {
      throw new IllegalArgumentException("valueCount <= 0");
    }
    zL localzL = new zL(paramFile, paramInt1, paramInt2, paramLong, new ThreadPoolExecutor(0, 1, 60L, TimeUnit.SECONDS, new LinkedBlockingQueue(), Ae.a("OkHttp DiskLruCache", true)));
    localzL.a();
    return localzL;
  }
  
  private zO a(String paramString, long paramLong)
  {
    for (;;)
    {
      zQ localzQ1;
      zO localzO2;
      zQ localzQ2;
      try
      {
        h();
        e(paramString);
        localzQ1 = (zQ)this.k.get(paramString);
        if (paramLong != -1L) {
          if (localzQ1 != null)
          {
            long l1 = zQ.g(localzQ1);
            if (l1 == paramLong) {}
          }
          else
          {
            localzO2 = null;
            return localzO2;
          }
        }
        if (localzQ1 == null)
        {
          zQ localzQ3 = new zQ(this, paramString, null);
          this.k.put(paramString, localzQ3);
          localzQ2 = localzQ3;
          localzO2 = new zO(this, localzQ2, null);
          zQ.a(localzQ2, localzO2);
          this.j.b("DIRTY").g(32).b(paramString).g(10);
          this.j.a();
          continue;
        }
        localzO1 = zQ.a(localzQ1);
      }
      finally {}
      zO localzO1;
      if (localzO1 != null) {
        localzO2 = null;
      } else {
        localzQ2 = localzQ1;
      }
    }
  }
  
  private static void a(File paramFile)
  {
    if ((!paramFile.delete()) && (paramFile.exists())) {
      throw new IOException("failed to delete " + paramFile);
    }
  }
  
  private static void a(File paramFile1, File paramFile2, boolean paramBoolean)
  {
    if (paramBoolean) {
      a(paramFile2);
    }
    if (!paramFile1.renameTo(paramFile2)) {
      throw new IOException();
    }
  }
  
  private void a(zO paramzO, boolean paramBoolean)
  {
    int i1 = 0;
    zQ localzQ;
    try
    {
      localzQ = zO.a(paramzO);
      if (zQ.a(localzQ) != paramzO) {
        throw new IllegalStateException();
      }
    }
    finally {}
    if ((paramBoolean) && (!zQ.f(localzQ))) {
      for (int i2 = 0; i2 < this.h; i2++)
      {
        if (zO.b(paramzO)[i2] == 0)
        {
          paramzO.b();
          throw new IllegalStateException("Newly created entry didn't create value for index " + i2);
        }
        if (!zQ.d(localzQ)[i2].exists())
        {
          paramzO.b();
          return;
        }
      }
    }
    for (;;)
    {
      if (i1 < this.h)
      {
        File localFile1 = zQ.d(localzQ)[i1];
        if (paramBoolean)
        {
          if (localFile1.exists())
          {
            File localFile2 = zQ.c(localzQ)[i1];
            localFile1.renameTo(localFile2);
            long l2 = zQ.b(localzQ)[i1];
            long l3 = localFile2.length();
            zQ.b(localzQ)[i1] = l3;
            this.i = (l3 + (this.i - l2));
          }
        }
        else {
          a(localFile1);
        }
      }
      else
      {
        this.l = (1 + this.l);
        zQ.a(localzQ, null);
        if ((paramBoolean | zQ.f(localzQ)))
        {
          zQ.a(localzQ, true);
          this.j.b("CLEAN").g(32);
          this.j.b(zQ.e(localzQ));
          localzQ.a(this.j);
          this.j.g(10);
          if (paramBoolean)
          {
            long l1 = this.m;
            this.m = (1L + l1);
            zQ.a(localzQ, l1);
          }
        }
        for (;;)
        {
          this.j.a();
          if ((this.i <= this.g) && (!g())) {
            break;
          }
          this.n.execute(this.o);
          break;
          this.k.remove(zQ.e(localzQ));
          this.j.b("REMOVE").g(32);
          this.j.b(zQ.e(localzQ));
          this.j.g(10);
        }
      }
      i1++;
    }
  }
  
  private boolean a(zQ paramzQ)
  {
    if (zQ.a(paramzQ) != null) {
      zO.a(zQ.a(paramzQ), true);
    }
    for (int i1 = 0; i1 < this.h; i1++)
    {
      a(zQ.c(paramzQ)[i1]);
      this.i -= zQ.b(paramzQ)[i1];
      zQ.b(paramzQ)[i1] = 0L;
    }
    this.l = (1 + this.l);
    this.j.b("REMOVE").g(32).b(zQ.e(paramzQ)).g(10);
    this.k.remove(zQ.e(paramzQ));
    if (g()) {
      this.n.execute(this.o);
    }
    return true;
  }
  
  private void d()
  {
    LD localLD = LK.a(LK.a(this.c));
    try
    {
      String str1 = localLD.q();
      String str2 = localLD.q();
      String str3 = localLD.q();
      String str4 = localLD.q();
      String str5 = localLD.q();
      if ((!"libcore.io.DiskLruCache".equals(str1)) || (!"1".equals(str2)) || (!Integer.toString(this.f).equals(str3)) || (!Integer.toString(this.h).equals(str4)) || (!"".equals(str5))) {
        throw new IOException("unexpected journal header: [" + str1 + ", " + str2 + ", " + str4 + ", " + str5 + "]");
      }
    }
    finally
    {
      Ae.a(localLD);
    }
    int i1 = 0;
    try
    {
      for (;;)
      {
        d(localLD.q());
        i1++;
      }
      f();
    }
    catch (EOFException localEOFException)
    {
      this.l = (i1 - this.k.size());
      if (localLD.h()) {}
    }
    for (;;)
    {
      Ae.a(localLD);
      return;
      this.j = LK.a(LK.c(this.c));
    }
  }
  
  private void d(String paramString)
  {
    int i1 = paramString.indexOf(' ');
    if (i1 == -1) {
      throw new IOException("unexpected journal line: " + paramString);
    }
    int i2 = i1 + 1;
    int i3 = paramString.indexOf(' ', i2);
    String str2;
    if (i3 == -1)
    {
      str2 = paramString.substring(i2);
      if ((i1 != "REMOVE".length()) || (!paramString.startsWith("REMOVE"))) {
        break label319;
      }
      this.k.remove(str2);
    }
    label319:
    for (String str1 = paramString.substring(i2, i3);; str1 = str2)
    {
      zQ localzQ = (zQ)this.k.get(str1);
      if (localzQ == null)
      {
        localzQ = new zQ(this, str1, null);
        this.k.put(str1, localzQ);
      }
      if ((i3 != -1) && (i1 == "CLEAN".length()) && (paramString.startsWith("CLEAN")))
      {
        String[] arrayOfString = paramString.substring(i3 + 1).split(" ");
        zQ.a(localzQ, true);
        zQ.a(localzQ, null);
        zQ.a(localzQ, arrayOfString);
        break;
      }
      if ((i3 == -1) && (i1 == "DIRTY".length()) && (paramString.startsWith("DIRTY")))
      {
        zQ.a(localzQ, new zO(this, localzQ, null));
        break;
      }
      if ((i3 == -1) && (i1 == "READ".length()) && (paramString.startsWith("READ"))) {
        break;
      }
      throw new IOException("unexpected journal line: " + paramString);
    }
  }
  
  private void e()
  {
    a(this.d);
    Iterator localIterator = this.k.values().iterator();
    while (localIterator.hasNext())
    {
      zQ localzQ = (zQ)localIterator.next();
      if (zQ.a(localzQ) == null)
      {
        for (int i2 = 0; i2 < this.h; i2++) {
          this.i += zQ.b(localzQ)[i2];
        }
      }
      else
      {
        zQ.a(localzQ, null);
        for (int i1 = 0; i1 < this.h; i1++)
        {
          a(zQ.c(localzQ)[i1]);
          a(zQ.d(localzQ)[i1]);
        }
        localIterator.remove();
      }
    }
  }
  
  private void e(String paramString)
  {
    if (!a.matcher(paramString).matches()) {
      throw new IllegalArgumentException("keys must match regex [a-z0-9_-]{1,120}: \"" + paramString + "\"");
    }
  }
  
  private void f()
  {
    LC localLC;
    for (;;)
    {
      zQ localzQ;
      try
      {
        if (this.j != null) {
          this.j.close();
        }
        localLC = LK.a(LK.b(this.d));
        try
        {
          localLC.b("libcore.io.DiskLruCache").g(10);
          localLC.b("1").g(10);
          localLC.b(Integer.toString(this.f)).g(10);
          localLC.b(Integer.toString(this.h)).g(10);
          localLC.g(10);
          Iterator localIterator = this.k.values().iterator();
          if (!localIterator.hasNext()) {
            break;
          }
          localzQ = (zQ)localIterator.next();
          if (zQ.a(localzQ) != null)
          {
            localLC.b("DIRTY").g(32);
            localLC.b(zQ.e(localzQ));
            localLC.g(10);
            continue;
            localObject1 = finally;
          }
        }
        finally
        {
          localLC.close();
        }
        localLC.b("CLEAN").g(32);
      }
      finally {}
      localLC.b(zQ.e(localzQ));
      localzQ.a(localLC);
      localLC.g(10);
    }
    localLC.close();
    if (this.c.exists()) {
      a(this.c, this.e, true);
    }
    a(this.d, this.c, false);
    this.e.delete();
    this.j = LK.a(LK.c(this.c));
  }
  
  private boolean g()
  {
    if ((this.l >= 2000) && (this.l >= this.k.size())) {}
    for (boolean bool = true;; bool = false) {
      return bool;
    }
  }
  
  private void h()
  {
    if (this.j == null) {
      throw new IllegalStateException("cache is closed");
    }
  }
  
  private void i()
  {
    while (this.i > this.g) {
      a((zQ)this.k.values().iterator().next());
    }
  }
  
  /* Error */
  public zR a(String paramString)
  {
    // Byte code:
    //   0: aload_0
    //   1: monitorenter
    //   2: aload_0
    //   3: invokespecial 145	zL:h	()V
    //   6: aload_0
    //   7: aload_1
    //   8: invokespecial 147	zL:e	(Ljava/lang/String;)V
    //   11: aload_0
    //   12: getfield 63	zL:k	Ljava/util/LinkedHashMap;
    //   15: aload_1
    //   16: invokevirtual 151	java/util/LinkedHashMap:get	(Ljava/lang/Object;)Ljava/lang/Object;
    //   19: checkcast 153	zQ
    //   22: astore_3
    //   23: aload_3
    //   24: ifnull +14 -> 38
    //   27: aload_3
    //   28: invokestatic 238	zQ:f	(LzQ;)Z
    //   31: istore 5
    //   33: iload 5
    //   35: ifne +11 -> 46
    //   38: aconst_null
    //   39: astore 4
    //   41: aload_0
    //   42: monitorexit
    //   43: aload 4
    //   45: areturn
    //   46: aload_3
    //   47: invokevirtual 436	zQ:a	()LzR;
    //   50: astore 4
    //   52: aload 4
    //   54: ifnonnull +9 -> 63
    //   57: aconst_null
    //   58: astore 4
    //   60: goto -19 -> 41
    //   63: aload_0
    //   64: iconst_1
    //   65: aload_0
    //   66: getfield 102	zL:l	I
    //   69: iadd
    //   70: putfield 102	zL:l	I
    //   73: aload_0
    //   74: getfield 105	zL:j	LLC;
    //   77: ldc_w 387
    //   80: invokeinterface 180 2 0
    //   85: bipush 32
    //   87: invokeinterface 183 2 0
    //   92: aload_1
    //   93: invokeinterface 180 2 0
    //   98: bipush 10
    //   100: invokeinterface 183 2 0
    //   105: pop
    //   106: aload_0
    //   107: invokespecial 277	zL:g	()Z
    //   110: ifeq -69 -> 41
    //   113: aload_0
    //   114: getfield 99	zL:n	Ljava/util/concurrent/Executor;
    //   117: aload_0
    //   118: getfield 72	zL:o	Ljava/lang/Runnable;
    //   121: invokeinterface 283 2 0
    //   126: goto -85 -> 41
    //   129: astore_2
    //   130: aload_0
    //   131: monitorexit
    //   132: aload_2
    //   133: athrow
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	134	0	this	zL
    //   0	134	1	paramString	String
    //   129	4	2	localObject	Object
    //   22	25	3	localzQ	zQ
    //   39	20	4	localzR	zR
    //   31	3	5	bool	boolean
    // Exception table:
    //   from	to	target	type
    //   2	33	129	finally
    //   46	126	129	finally
  }
  
  void a()
  {
    if (this.e.exists())
    {
      if (this.c.exists()) {
        this.e.delete();
      }
    }
    else {
      if (!this.c.exists()) {
        break label115;
      }
    }
    for (;;)
    {
      try
      {
        d();
        e();
        return;
      }
      catch (IOException localIOException)
      {
        zY.a().a("DiskLruCache " + this.b + " is corrupt: " + localIOException.getMessage() + ", removing");
        b();
      }
      a(this.e, this.c, false);
      break;
      label115:
      this.b.mkdirs();
      f();
    }
  }
  
  public zO b(String paramString)
  {
    return a(paramString, -1L);
  }
  
  public void b()
  {
    close();
    Ae.a(this.b);
  }
  
  /* Error */
  public boolean c(String paramString)
  {
    // Byte code:
    //   0: aload_0
    //   1: monitorenter
    //   2: aload_0
    //   3: invokespecial 145	zL:h	()V
    //   6: aload_0
    //   7: aload_1
    //   8: invokespecial 147	zL:e	(Ljava/lang/String;)V
    //   11: aload_0
    //   12: getfield 63	zL:k	Ljava/util/LinkedHashMap;
    //   15: aload_1
    //   16: invokevirtual 151	java/util/LinkedHashMap:get	(Ljava/lang/Object;)Ljava/lang/Object;
    //   19: checkcast 153	zQ
    //   22: astore_3
    //   23: aload_3
    //   24: ifnonnull +11 -> 35
    //   27: iconst_0
    //   28: istore 5
    //   30: aload_0
    //   31: monitorexit
    //   32: iload 5
    //   34: ireturn
    //   35: aload_0
    //   36: aload_3
    //   37: invokespecial 291	zL:a	(LzQ;)Z
    //   40: istore 4
    //   42: iload 4
    //   44: istore 5
    //   46: goto -16 -> 30
    //   49: astore_2
    //   50: aload_0
    //   51: monitorexit
    //   52: aload_2
    //   53: athrow
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	54	0	this	zL
    //   0	54	1	paramString	String
    //   49	4	2	localObject	Object
    //   22	15	3	localzQ	zQ
    //   40	3	4	bool1	boolean
    //   28	17	5	bool2	boolean
    // Exception table:
    //   from	to	target	type
    //   2	23	49	finally
    //   35	42	49	finally
  }
  
  public void close()
  {
    for (;;)
    {
      try
      {
        LC localLC = this.j;
        if (localLC == null) {
          return;
        }
        zQ[] arrayOfzQ = (zQ[])this.k.values().toArray(new zQ[this.k.size()]);
        int i1 = arrayOfzQ.length;
        int i2 = 0;
        if (i2 < i1)
        {
          zQ localzQ = arrayOfzQ[i2];
          if (zQ.a(localzQ) != null) {
            zQ.a(localzQ).b();
          }
        }
        else
        {
          i();
          this.j.close();
          this.j = null;
          continue;
        }
        i2++;
      }
      finally {}
    }
  }
}


/* Location:           C:\Users\dreadiscool\Desktop\tools\classes-dex2jar.jar
 * Qualified Name:     zL
 * JD-Core Version:    0.7.0.1
 */