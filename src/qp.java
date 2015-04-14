import java.io.IOException;
import java.io.Writer;
import java.util.ArrayList;
import java.util.List;

public final class qp
  extends rr
{
  private static final Writer a = new qq();
  private static final pg b = new pg("closed");
  private final List<pb> c = new ArrayList();
  private String d;
  private pb e = pd.a;
  
  public qp()
  {
    super(a);
  }
  
  private void a(pb parampb)
  {
    if (this.d != null)
    {
      if ((!parampb.j()) || (i())) {
        ((pe)j()).a(this.d, parampb);
      }
      this.d = null;
    }
    for (;;)
    {
      return;
      if (this.c.isEmpty())
      {
        this.e = parampb;
      }
      else
      {
        pb localpb = j();
        if (!(localpb instanceof oZ)) {
          break;
        }
        ((oZ)localpb).a(parampb);
      }
    }
    throw new IllegalStateException();
  }
  
  private pb j()
  {
    return (pb)this.c.get(-1 + this.c.size());
  }
  
  public pb a()
  {
    if (!this.c.isEmpty()) {
      throw new IllegalStateException("Expected one JSON element but was " + this.c);
    }
    return this.e;
  }
  
  public rr a(long paramLong)
  {
    a(new pg(Long.valueOf(paramLong)));
    return this;
  }
  
  public rr a(Number paramNumber)
  {
    if (paramNumber == null) {
      this = f();
    }
    for (;;)
    {
      return this;
      if (!g())
      {
        double d1 = paramNumber.doubleValue();
        if ((Double.isNaN(d1)) || (Double.isInfinite(d1))) {
          throw new IllegalArgumentException("JSON forbids NaN and infinities: " + paramNumber);
        }
      }
      a(new pg(paramNumber));
    }
  }
  
  public rr a(String paramString)
  {
    if ((this.c.isEmpty()) || (this.d != null)) {
      throw new IllegalStateException();
    }
    if ((j() instanceof pe))
    {
      this.d = paramString;
      return this;
    }
    throw new IllegalStateException();
  }
  
  public rr a(boolean paramBoolean)
  {
    a(new pg(Boolean.valueOf(paramBoolean)));
    return this;
  }
  
  public rr b()
  {
    oZ localoZ = new oZ();
    a(localoZ);
    this.c.add(localoZ);
    return this;
  }
  
  public rr b(String paramString)
  {
    if (paramString == null) {
      this = f();
    }
    for (;;)
    {
      return this;
      a(new pg(paramString));
    }
  }
  
  public rr c()
  {
    if ((this.c.isEmpty()) || (this.d != null)) {
      throw new IllegalStateException();
    }
    if ((j() instanceof oZ))
    {
      this.c.remove(-1 + this.c.size());
      return this;
    }
    throw new IllegalStateException();
  }
  
  public void close()
  {
    if (!this.c.isEmpty()) {
      throw new IOException("Incomplete document");
    }
    this.c.add(b);
  }
  
  public rr d()
  {
    pe localpe = new pe();
    a(localpe);
    this.c.add(localpe);
    return this;
  }
  
  public rr e()
  {
    if ((this.c.isEmpty()) || (this.d != null)) {
      throw new IllegalStateException();
    }
    if ((j() instanceof pe))
    {
      this.c.remove(-1 + this.c.size());
      return this;
    }
    throw new IllegalStateException();
  }
  
  public rr f()
  {
    a(pd.a);
    return this;
  }
  
  public void flush() {}
}


/* Location:           C:\Users\dreadiscool\Desktop\tools\classes-dex2jar.jar
 * Qualified Name:     qp
 * JD-Core Version:    0.7.0.1
 */