import java.io.IOException;
import java.lang.reflect.Array;

public class jh<M extends jg<M>, T>
{
  protected final int a;
  protected final Class<T> b;
  public final int c;
  protected final boolean d;
  
  int a(Object paramObject)
  {
    if (this.d) {}
    for (int i = b(paramObject);; i = c(paramObject)) {
      return i;
    }
  }
  
  void a(Object paramObject, je paramje)
  {
    if (this.d) {
      c(paramObject, paramje);
    }
    for (;;)
    {
      return;
      b(paramObject, paramje);
    }
  }
  
  protected int b(Object paramObject)
  {
    int i = 0;
    int j = Array.getLength(paramObject);
    for (int k = 0; k < j; k++) {
      if (Array.get(paramObject, k) != null) {
        i += c(Array.get(paramObject, k));
      }
    }
    return i;
  }
  
  protected void b(Object paramObject, je paramje)
  {
    try
    {
      paramje.e(this.c);
      switch (this.a)
      {
      default: 
        throw new IllegalArgumentException("Unknown type " + this.a);
      }
    }
    catch (IOException localIOException)
    {
      throw new IllegalStateException(localIOException);
    }
    jl localjl = (jl)paramObject;
    int i = jo.a(this.c);
    paramje.a(localjl);
    paramje.c(i, 4);
    return;
    paramje.b((jl)paramObject);
  }
  
  protected int c(Object paramObject)
  {
    int i = jo.a(this.c);
    switch (this.a)
    {
    default: 
      throw new IllegalArgumentException("Unknown type " + this.a);
    }
    for (int j = je.b(i, (jl)paramObject);; j = je.c(i, (jl)paramObject)) {
      return j;
    }
  }
  
  protected void c(Object paramObject, je paramje)
  {
    int i = Array.getLength(paramObject);
    for (int j = 0; j < i; j++)
    {
      Object localObject = Array.get(paramObject, j);
      if (localObject != null) {
        b(localObject, paramje);
      }
    }
  }
}


/* Location:           C:\Users\dreadiscool\Desktop\tools\classes-dex2jar.jar
 * Qualified Name:     jh
 * JD-Core Version:    0.7.0.1
 */