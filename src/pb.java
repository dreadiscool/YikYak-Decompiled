import java.io.IOException;
import java.io.StringWriter;

public abstract class pb
{
  public Number a()
  {
    throw new UnsupportedOperationException(getClass().getSimpleName());
  }
  
  public String b()
  {
    throw new UnsupportedOperationException(getClass().getSimpleName());
  }
  
  public double c()
  {
    throw new UnsupportedOperationException(getClass().getSimpleName());
  }
  
  public long d()
  {
    throw new UnsupportedOperationException(getClass().getSimpleName());
  }
  
  public int e()
  {
    throw new UnsupportedOperationException(getClass().getSimpleName());
  }
  
  public boolean f()
  {
    throw new UnsupportedOperationException(getClass().getSimpleName());
  }
  
  public boolean g()
  {
    return this instanceof oZ;
  }
  
  public boolean h()
  {
    return this instanceof pe;
  }
  
  public boolean i()
  {
    return this instanceof pg;
  }
  
  public boolean j()
  {
    return this instanceof pd;
  }
  
  public pe k()
  {
    if (h()) {
      return (pe)this;
    }
    throw new IllegalStateException("Not a JSON Object: " + this);
  }
  
  public oZ l()
  {
    if (g()) {
      return (oZ)this;
    }
    throw new IllegalStateException("This is not a JSON Array.");
  }
  
  public pg m()
  {
    if (i()) {
      return (pg)this;
    }
    throw new IllegalStateException("This is not a JSON Primitive.");
  }
  
  Boolean n()
  {
    throw new UnsupportedOperationException(getClass().getSimpleName());
  }
  
  public String toString()
  {
    try
    {
      StringWriter localStringWriter = new StringWriter();
      rr localrr = new rr(localStringWriter);
      localrr.b(true);
      pY.a(this, localrr);
      String str = localStringWriter.toString();
      return str;
    }
    catch (IOException localIOException)
    {
      throw new AssertionError(localIOException);
    }
  }
}


/* Location:           C:\Users\dreadiscool\Desktop\tools\classes-dex2jar.jar
 * Qualified Name:     pb
 * JD-Core Version:    0.7.0.1
 */