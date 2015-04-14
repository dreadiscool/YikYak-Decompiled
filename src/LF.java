import java.util.zip.Deflater;
import org.codehaus.mojo.animal_sniffer.IgnoreJRERequirement;

public final class LF
  implements LU
{
  private final LC a;
  private final Deflater b;
  private boolean c;
  
  LF(LC paramLC, Deflater paramDeflater)
  {
    if (paramLC == null) {
      throw new IllegalArgumentException("source == null");
    }
    if (paramDeflater == null) {
      throw new IllegalArgumentException("inflater == null");
    }
    this.a = paramLC;
    this.b = paramDeflater;
  }
  
  public LF(LU paramLU, Deflater paramDeflater)
  {
    this(LK.a(paramLU), paramDeflater);
  }
  
  @IgnoreJRERequirement
  private void a(boolean paramBoolean)
  {
    Lz localLz = this.a.d();
    label115:
    do
    {
      LS localLS = localLz.d(1);
      if (paramBoolean) {}
      for (int i = this.b.deflate(localLS.a, localLS.c, 2048 - localLS.c, 2);; i = this.b.deflate(localLS.a, localLS.c, 2048 - localLS.c))
      {
        if (i <= 0) {
          break label115;
        }
        localLS.c = (i + localLS.c);
        localLz.b += i;
        this.a.u();
        break;
      }
    } while (!this.b.needsInput());
  }
  
  public void a()
  {
    a(true);
    this.a.a();
  }
  
  public void a_(Lz paramLz, long paramLong)
  {
    LY.a(paramLz.b, 0L, paramLong);
    while (paramLong > 0L)
    {
      LS localLS = paramLz.a;
      int i = (int)Math.min(paramLong, localLS.c - localLS.b);
      this.b.setInput(localLS.a, localLS.b, i);
      a(false);
      paramLz.b -= i;
      localLS.b = (i + localLS.b);
      if (localLS.b == localLS.c)
      {
        paramLz.a = localLS.a();
        LT.a.a(localLS);
      }
      paramLong -= i;
    }
  }
  
  public LW b()
  {
    return this.a.b();
  }
  
  void c()
  {
    this.b.finish();
    a(false);
  }
  
  public void close()
  {
    if (this.c) {}
    for (;;)
    {
      return;
      Object localObject1 = null;
      try
      {
        c();
        try
        {
          label14:
          this.b.end();
          localObject2 = localObject1;
        }
        catch (Throwable localThrowable2)
        {
          try
          {
            for (;;)
            {
              Object localObject2;
              this.a.close();
              this.c = true;
              if (localObject2 == null) {
                break;
              }
              LY.a(localObject2);
              break;
              localThrowable2 = localThrowable2;
              if (localObject1 != null) {
                localObject3 = localObject1;
              }
            }
          }
          catch (Throwable localThrowable3)
          {
            for (;;)
            {
              Object localObject3;
              if (localObject3 == null) {
                localObject3 = localThrowable3;
              }
            }
          }
        }
      }
      catch (Throwable localThrowable1)
      {
        break label14;
      }
    }
  }
  
  public String toString()
  {
    return "DeflaterSink(" + this.a + ")";
  }
}


/* Location:           C:\Users\dreadiscool\Desktop\tools\classes-dex2jar.jar
 * Qualified Name:     LF
 * JD-Core Version:    0.7.0.1
 */