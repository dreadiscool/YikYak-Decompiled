import java.io.PrintStream;
import java.net.InetSocketAddress;
import java.nio.ByteBuffer;
import java.nio.channels.ByteChannel;
import java.nio.channels.SelectionKey;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;
import java.util.List;
import java.util.concurrent.BlockingQueue;
import java.util.concurrent.LinkedBlockingQueue;

public class tt
  implements tp
{
  public static int a;
  public static boolean b;
  public static final List<ty> c;
  public SelectionKey d;
  public ByteChannel e;
  public final BlockingQueue<ByteBuffer> f;
  public final BlockingQueue<ByteBuffer> g;
  private volatile boolean i = false;
  private tq j = tq.a;
  private final tu k;
  private List<ty> l;
  private ty m = null;
  private tr n;
  private tR o = null;
  private ByteBuffer p = ByteBuffer.allocate(0);
  private tT q = null;
  private String r = null;
  private Integer s = null;
  private Boolean t = null;
  private String u = null;
  
  static
  {
    if (!tt.class.desiredAssertionStatus()) {}
    for (boolean bool = true;; bool = false)
    {
      h = bool;
      a = 16384;
      b = false;
      c = new ArrayList(4);
      c.add(new tD());
      c.add(new tB());
      c.add(new tF());
      c.add(new tE());
      return;
    }
  }
  
  public tt(tu paramtu, ty paramty)
  {
    if ((paramtu == null) || ((paramty == null) && (this.n == tr.b))) {
      throw new IllegalArgumentException("parameters must not be null");
    }
    this.f = new LinkedBlockingQueue();
    this.g = new LinkedBlockingQueue();
    this.k = paramtu;
    this.n = tr.a;
    if (paramty != null) {
      this.m = paramty.c();
    }
  }
  
  private void a(Collection<tQ> paramCollection)
  {
    if (!c()) {
      throw new tM();
    }
    Iterator localIterator = paramCollection.iterator();
    while (localIterator.hasNext()) {
      a((tQ)localIterator.next());
    }
  }
  
  private void a(List<ByteBuffer> paramList)
  {
    Iterator localIterator = paramList.iterator();
    while (localIterator.hasNext()) {
      e((ByteBuffer)localIterator.next());
    }
  }
  
  private void a(tY paramtY)
  {
    if (b) {
      System.out.println("open using draft: " + this.m.getClass().getSimpleName());
    }
    this.j = tq.c;
    try
    {
      this.k.a(this, paramtY);
      return;
    }
    catch (RuntimeException localRuntimeException)
    {
      for (;;)
      {
        this.k.a(this, localRuntimeException);
      }
    }
  }
  
  private boolean b(ByteBuffer paramByteBuffer)
  {
    if (this.p.capacity() == 0) {
      localByteBuffer1 = paramByteBuffer;
    }
    for (;;)
    {
      localByteBuffer1.mark();
      for (;;)
      {
        try
        {
          if (this.m != null) {
            continue;
          }
          tA localtA1 = d(localByteBuffer1);
          tA localtA2 = tA.a;
          if (localtA1 != localtA2) {
            continue;
          }
        }
        catch (tG localtG)
        {
          if (this.p.capacity() != 0) {
            continue;
          }
          localByteBuffer1.reset();
          int i1 = localtG.a();
          if (i1 != 0) {
            continue;
          }
          i1 = 16 + localByteBuffer1.capacity();
          this.p = ByteBuffer.allocate(i1);
          this.p.put(paramByteBuffer);
          boolean bool = false;
          continue;
          try
          {
            if (this.n == tr.b) {
              if (this.m == null)
              {
                Iterator localIterator = this.l.iterator();
                if (localIterator.hasNext()) {
                  localty = ((ty)localIterator.next()).c();
                }
              }
            }
          }
          catch (tJ localtJ1)
          {
            ty localty;
            tY localtY3;
            tT localtT2;
            tY localtY2;
            tT localtT1;
            tY localtY1;
            ua localua;
            a(localtJ1);
          }
          try
          {
            localty.a(this.n);
            localByteBuffer1.reset();
            localtY3 = localty.d(localByteBuffer1);
            if (!(localtY3 instanceof tT))
            {
              b(1002, "wrong http function", false);
              bool = false;
              continue;
            }
            localtT2 = (tT)localtY3;
            if (localty.a(localtT2) != tA.a) {
              continue;
            }
            this.u = localtT2.a();
            try
            {
              ub localub = this.k.a(this, localty, localtT2);
              a(localty.a(localty.a(localtT2, localub), this.n));
              this.m = localty;
              a(localtT2);
              bool = true;
            }
            catch (tH localtH1)
            {
              b(localtH1.a(), localtH1.getMessage(), false);
              bool = false;
            }
            catch (RuntimeException localRuntimeException)
            {
              this.k.a(this, localRuntimeException);
              b(-1, localRuntimeException.getMessage(), false);
              bool = false;
            }
          }
          catch (tJ localtJ2) {}
          if (this.m != null) {
            continue;
          }
          a(1002, "no draft matches");
          continue;
          localtY2 = this.m.d(localByteBuffer1);
          if ((localtY2 instanceof tT)) {
            continue;
          }
          b(1002, "wrong http function", false);
          bool = false;
          continue;
          localtT1 = (tT)localtY2;
          if (this.m.a(localtT1) != tA.a) {
            continue;
          }
          a(localtT1);
          bool = true;
          continue;
          a(1002, "the handshake did finaly not match");
          bool = false;
          continue;
          if (this.n != tr.a) {
            continue;
          }
          this.m.a(this.n);
          localtY1 = this.m.d(localByteBuffer1);
          if ((localtY1 instanceof ua)) {
            continue;
          }
          b(1002, "wrong http function", false);
          bool = false;
          continue;
          localua = (ua)localtY1;
          if (this.m.a(this.q, localua) != tA.a) {
            continue;
          }
          a(localua);
          bool = true;
          continue;
          a(1002, "draft " + this.m + " refuses handshake");
          continue;
          continue;
          if ((h) || (localtG.a() >= localByteBuffer1.remaining())) {
            continue;
          }
          throw new AssertionError();
          this.p.position(this.p.limit());
          this.p.limit(this.p.capacity());
          continue;
          continue;
          bool = false;
          continue;
        }
        try
        {
          e(ByteBuffer.wrap(ue.a(this.k.a(this))));
          a(-3, "");
          bool = false;
          return bool;
          if (this.p.remaining() < paramByteBuffer.remaining())
          {
            ByteBuffer localByteBuffer2 = ByteBuffer.allocate(this.p.capacity() + paramByteBuffer.remaining());
            this.p.flip();
            localByteBuffer2.put(this.p);
            this.p = localByteBuffer2;
          }
          this.p.put(paramByteBuffer);
          this.p.flip();
          localByteBuffer1 = this.p;
        }
        catch (tH localtH2)
        {
          c(1006, "remote peer closed connection before flashpolicy could be transmitted", true);
        }
      }
    }
  }
  
  private void c(int paramInt, String paramString, boolean paramBoolean)
  {
    if ((this.j != tq.d) && (this.j != tq.e))
    {
      if (this.j != tq.c) {
        break label160;
      }
      if (paramInt == 1006)
      {
        if ((!h) && (paramBoolean)) {
          throw new AssertionError();
        }
        this.j = tq.d;
        b(paramInt, paramString, false);
      }
    }
    else
    {
      return;
    }
    if (this.m.b() != tz.a) {}
    for (;;)
    {
      try
      {
        a(new tO(paramInt, paramString));
        b(paramInt, paramString, paramBoolean);
        if (paramInt == 1002) {
          b(paramInt, paramString, paramBoolean);
        }
        this.j = tq.d;
        this.p = null;
      }
      catch (tH localtH)
      {
        this.k.a(this, localtH);
        b(1006, "generated frame is invalid", false);
        continue;
      }
      label160:
      if (paramInt == -3)
      {
        if ((!h) && (!paramBoolean)) {
          throw new AssertionError();
        }
        b(-3, paramString, true);
      }
      else
      {
        b(-1, paramString, false);
      }
    }
  }
  
  private void c(ByteBuffer paramByteBuffer)
  {
    for (;;)
    {
      tQ localtQ;
      tR localtR1;
      boolean bool;
      int i1;
      String str;
      try
      {
        Iterator localIterator = this.m.c(paramByteBuffer).iterator();
        if (localIterator.hasNext())
        {
          localtQ = (tQ)localIterator.next();
          if (b) {
            System.out.println("matched frame: " + localtQ);
          }
          localtR1 = localtQ.f();
          bool = localtQ.d();
          if (localtR1 != tR.f) {
            break label203;
          }
          if (!(localtQ instanceof tN)) {
            break label435;
          }
          tN localtN = (tN)localtQ;
          i1 = localtN.a();
          str = localtN.b();
          if (this.j == tq.d) {
            a(i1, str, true);
          }
        }
        else
        {
          return;
        }
      }
      catch (tH localtH)
      {
        this.k.a(this, localtH);
        a(localtH);
      }
      label435:
      if (this.m.b() == tz.c)
      {
        c(i1, str, true);
      }
      else
      {
        b(i1, str, false);
        continue;
        label203:
        if (localtR1 == tR.d) {
          this.k.a(this, localtQ);
        } else if (localtR1 != tR.e) {
          if ((!bool) || (localtR1 == tR.a))
          {
            if (localtR1 != tR.a)
            {
              if (this.o != null) {
                throw new tH(1002, "Previous continuous frame sequence not completed.");
              }
              this.o = localtR1;
            }
            else if (bool)
            {
              if (this.o == null) {
                throw new tH(1002, "Continuous frame sequence was not started.");
              }
              this.o = null;
            }
            else if (this.o == null)
            {
              throw new tH(1002, "Continuous frame sequence was not started.");
            }
          }
          else
          {
            if (this.o != null) {
              throw new tH(1002, "Continuous frame sequence not completed.");
            }
            tR localtR2 = tR.b;
            if (localtR1 == localtR2)
            {
              try
              {
                this.k.a(this, ue.a(localtQ.c()));
              }
              catch (RuntimeException localRuntimeException)
              {
                this.k.a(this, localRuntimeException);
              }
            }
            else if (localtR1 != tR.c)
            {
              throw new tH(1002, "non control or continious frame expected");
              str = "";
              i1 = 1005;
            }
          }
        }
      }
    }
  }
  
  private tA d(ByteBuffer paramByteBuffer)
  {
    paramByteBuffer.mark();
    tA localtA;
    if (paramByteBuffer.limit() > ty.c.length) {
      localtA = tA.b;
    }
    for (;;)
    {
      return localtA;
      if (paramByteBuffer.limit() < ty.c.length) {
        throw new tG(ty.c.length);
      }
      for (int i1 = 0;; i1++)
      {
        if (!paramByteBuffer.hasRemaining()) {
          break label87;
        }
        if (ty.c[i1] != paramByteBuffer.get())
        {
          paramByteBuffer.reset();
          localtA = tA.b;
          break;
        }
      }
      label87:
      localtA = tA.a;
    }
  }
  
  private void e(ByteBuffer paramByteBuffer)
  {
    PrintStream localPrintStream;
    StringBuilder localStringBuilder;
    if (b)
    {
      localPrintStream = System.out;
      localStringBuilder = new StringBuilder().append("write(").append(paramByteBuffer.remaining()).append("): {");
      if (paramByteBuffer.remaining() <= 1000) {
        break label85;
      }
    }
    label85:
    for (String str = "too big to display";; str = new String(paramByteBuffer.array()))
    {
      localPrintStream.println(str + "}");
      this.f.add(paramByteBuffer);
      return;
    }
  }
  
  public InetSocketAddress a()
  {
    return this.k.b(this);
  }
  
  public void a(int paramInt, String paramString)
  {
    c(paramInt, paramString, false);
  }
  
  /* Error */
  protected void a(int paramInt, String paramString, boolean paramBoolean)
  {
    // Byte code:
    //   0: aload_0
    //   1: monitorenter
    //   2: aload_0
    //   3: getfield 96	tt:j	Ltq;
    //   6: astore 5
    //   8: getstatic 354	tq:e	Ltq;
    //   11: astore 6
    //   13: aload 5
    //   15: aload 6
    //   17: if_acmpne +6 -> 23
    //   20: aload_0
    //   21: monitorexit
    //   22: return
    //   23: aload_0
    //   24: getfield 466	tt:d	Ljava/nio/channels/SelectionKey;
    //   27: ifnull +10 -> 37
    //   30: aload_0
    //   31: getfield 466	tt:d	Ljava/nio/channels/SelectionKey;
    //   34: invokevirtual 471	java/nio/channels/SelectionKey:cancel	()V
    //   37: aload_0
    //   38: getfield 473	tt:e	Ljava/nio/channels/ByteChannel;
    //   41: astore 7
    //   43: aload 7
    //   45: ifnull +12 -> 57
    //   48: aload_0
    //   49: getfield 473	tt:e	Ljava/nio/channels/ByteChannel;
    //   52: invokeinterface 478 1 0
    //   57: aload_0
    //   58: getfield 140	tt:k	Ltu;
    //   61: aload_0
    //   62: iload_1
    //   63: aload_2
    //   64: iload_3
    //   65: invokeinterface 481 5 0
    //   70: aload_0
    //   71: getfield 98	tt:m	Lty;
    //   74: ifnull +10 -> 84
    //   77: aload_0
    //   78: getfield 98	tt:m	Lty;
    //   81: invokevirtual 483	ty:a	()V
    //   84: aload_0
    //   85: aconst_null
    //   86: putfield 110	tt:q	LtT;
    //   89: aload_0
    //   90: getstatic 354	tq:e	Ltq;
    //   93: putfield 96	tt:j	Ltq;
    //   96: aload_0
    //   97: getfield 136	tt:f	Ljava/util/concurrent/BlockingQueue;
    //   100: invokeinterface 486 1 0
    //   105: goto -85 -> 20
    //   108: astore 4
    //   110: aload_0
    //   111: monitorexit
    //   112: aload 4
    //   114: athrow
    //   115: astore 9
    //   117: aload_0
    //   118: getfield 140	tt:k	Ltu;
    //   121: aload_0
    //   122: aload 9
    //   124: invokeinterface 222 3 0
    //   129: goto -72 -> 57
    //   132: astore 8
    //   134: aload_0
    //   135: getfield 140	tt:k	Ltu;
    //   138: aload_0
    //   139: aload 8
    //   141: invokeinterface 222 3 0
    //   146: goto -76 -> 70
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	149	0	this	tt
    //   0	149	1	paramInt	int
    //   0	149	2	paramString	String
    //   0	149	3	paramBoolean	boolean
    //   108	5	4	localObject	Object
    //   6	8	5	localtq1	tq
    //   11	5	6	localtq2	tq
    //   41	3	7	localByteChannel	ByteChannel
    //   132	8	8	localRuntimeException	RuntimeException
    //   115	8	9	localIOException	java.io.IOException
    // Exception table:
    //   from	to	target	type
    //   2	13	108	finally
    //   23	43	108	finally
    //   48	57	108	finally
    //   57	70	108	finally
    //   70	105	108	finally
    //   117	146	108	finally
    //   48	57	115	java/io/IOException
    //   57	70	132	java/lang/RuntimeException
  }
  
  protected void a(int paramInt, boolean paramBoolean)
  {
    a(paramInt, "", paramBoolean);
  }
  
  public void a(ByteBuffer paramByteBuffer)
  {
    if ((!h) && (!paramByteBuffer.hasRemaining())) {
      throw new AssertionError();
    }
    String str;
    if (b)
    {
      PrintStream localPrintStream = System.out;
      StringBuilder localStringBuilder = new StringBuilder().append("process(").append(paramByteBuffer.remaining()).append("): {");
      if (paramByteBuffer.remaining() > 1000)
      {
        str = "too big to display";
        localPrintStream.println(str + "}");
      }
    }
    else
    {
      if (this.j == tq.a) {
        break label166;
      }
      c(paramByteBuffer);
    }
    for (;;)
    {
      if ((h) || (d()) || (e()) || (!paramByteBuffer.hasRemaining())) {
        return;
      }
      throw new AssertionError();
      str = new String(paramByteBuffer.array(), paramByteBuffer.position(), paramByteBuffer.remaining());
      break;
      label166:
      if (b(paramByteBuffer))
      {
        if ((!h) && (this.p.hasRemaining() == paramByteBuffer.hasRemaining()) && (paramByteBuffer.hasRemaining())) {
          throw new AssertionError();
        }
        if (paramByteBuffer.hasRemaining()) {
          c(paramByteBuffer);
        } else if (this.p.hasRemaining()) {
          c(this.p);
        }
      }
    }
  }
  
  public void a(tH paramtH)
  {
    c(paramtH.a(), paramtH.getMessage(), false);
  }
  
  public void a(tQ paramtQ)
  {
    if (b) {
      System.out.println("send frame: " + paramtQ);
    }
    e(this.m.a(paramtQ));
  }
  
  public void a(tR paramtR, ByteBuffer paramByteBuffer, boolean paramBoolean)
  {
    a(this.m.a(paramtR, paramByteBuffer, paramBoolean));
  }
  
  public void a(tU paramtU)
  {
    if ((!h) && (this.j == tq.b)) {
      throw new AssertionError("shall only be called once");
    }
    this.q = this.m.a(paramtU);
    this.u = paramtU.a();
    if ((!h) && (this.u == null)) {
      throw new AssertionError();
    }
    a(this.m.a(this.q, this.n));
  }
  
  public void b()
  {
    if (g() == tq.a) {
      a(-1, true);
    }
    for (;;)
    {
      return;
      if (this.i) {
        a(this.s.intValue(), this.r, this.t.booleanValue());
      } else if (this.m.b() == tz.a) {
        a(1000, true);
      } else if (this.m.b() == tz.b)
      {
        if (this.n == tr.b) {
          a(1006, true);
        } else {
          a(1000, true);
        }
      }
      else {
        a(1006, true);
      }
    }
  }
  
  public void b(int paramInt, String paramString)
  {
    a(paramInt, paramString, false);
  }
  
  /* Error */
  protected void b(int paramInt, String paramString, boolean paramBoolean)
  {
    // Byte code:
    //   0: aload_0
    //   1: monitorenter
    //   2: aload_0
    //   3: getfield 90	tt:i	Z
    //   6: istore 5
    //   8: iload 5
    //   10: ifeq +6 -> 16
    //   13: aload_0
    //   14: monitorexit
    //   15: return
    //   16: aload_0
    //   17: iload_1
    //   18: invokestatic 547	java/lang/Integer:valueOf	(I)Ljava/lang/Integer;
    //   21: putfield 114	tt:s	Ljava/lang/Integer;
    //   24: aload_0
    //   25: aload_2
    //   26: putfield 112	tt:r	Ljava/lang/String;
    //   29: aload_0
    //   30: iload_3
    //   31: invokestatic 550	java/lang/Boolean:valueOf	(Z)Ljava/lang/Boolean;
    //   34: putfield 116	tt:t	Ljava/lang/Boolean;
    //   37: aload_0
    //   38: iconst_1
    //   39: putfield 90	tt:i	Z
    //   42: aload_0
    //   43: getfield 98	tt:m	Lty;
    //   46: ifnull +10 -> 56
    //   49: aload_0
    //   50: getfield 98	tt:m	Lty;
    //   53: invokevirtual 483	ty:a	()V
    //   56: aload_0
    //   57: aconst_null
    //   58: putfield 110	tt:q	LtT;
    //   61: goto -48 -> 13
    //   64: astore 4
    //   66: aload_0
    //   67: monitorexit
    //   68: aload 4
    //   70: athrow
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	71	0	this	tt
    //   0	71	1	paramInt	int
    //   0	71	2	paramString	String
    //   0	71	3	paramBoolean	boolean
    //   64	5	4	localObject	Object
    //   6	3	5	bool	boolean
    // Exception table:
    //   from	to	target	type
    //   2	8	64	finally
    //   16	61	64	finally
  }
  
  public boolean c()
  {
    if ((h) || (this.j != tq.c) || (!this.i)) {
      if (this.j != tq.c) {
        break label45;
      }
    }
    label45:
    for (boolean bool = true;; bool = false)
    {
      return bool;
      throw new AssertionError();
    }
  }
  
  public boolean d()
  {
    if (this.j == tq.d) {}
    for (boolean bool = true;; bool = false) {
      return bool;
    }
  }
  
  public boolean e()
  {
    return this.i;
  }
  
  public boolean f()
  {
    if (this.j == tq.e) {}
    for (boolean bool = true;; bool = false) {
      return bool;
    }
  }
  
  public tq g()
  {
    return this.j;
  }
  
  public int hashCode()
  {
    return super.hashCode();
  }
  
  public String toString()
  {
    return super.toString();
  }
}


/* Location:           C:\Users\dreadiscool\Desktop\tools\classes-dex2jar.jar
 * Qualified Name:     tt
 * JD-Core Version:    0.7.0.1
 */