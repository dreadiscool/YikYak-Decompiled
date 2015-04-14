import java.io.IOException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Iterator;
import java.util.List;

class jj
{
  private jh<?, ?> a;
  private Object b;
  private List<jn> c = new ArrayList();
  
  private byte[] b()
  {
    byte[] arrayOfByte = new byte[a()];
    a(je.a(arrayOfByte));
    return arrayOfByte;
  }
  
  int a()
  {
    int i;
    if (this.b != null) {
      i = this.a.a(this.b);
    }
    for (;;)
    {
      return i;
      Iterator localIterator = this.c.iterator();
      i = 0;
      while (localIterator.hasNext()) {
        i += ((jn)localIterator.next()).a();
      }
    }
  }
  
  void a(je paramje)
  {
    if (this.b != null) {
      this.a.a(this.b, paramje);
    }
    for (;;)
    {
      return;
      Iterator localIterator = this.c.iterator();
      while (localIterator.hasNext()) {
        ((jn)localIterator.next()).a(paramje);
      }
    }
  }
  
  public boolean equals(Object paramObject)
  {
    boolean bool1 = false;
    if (paramObject == this) {
      bool1 = true;
    }
    for (;;)
    {
      return bool1;
      if (!(paramObject instanceof jj)) {
        continue;
      }
      jj localjj = (jj)paramObject;
      if ((this.b != null) && (localjj.b != null))
      {
        if (this.a != localjj.a) {
          continue;
        }
        if (!this.a.b.isArray())
        {
          bool1 = this.b.equals(localjj.b);
          continue;
        }
        if ((this.b instanceof byte[]))
        {
          bool1 = Arrays.equals((byte[])this.b, (byte[])localjj.b);
          continue;
        }
        if ((this.b instanceof int[]))
        {
          bool1 = Arrays.equals((int[])this.b, (int[])localjj.b);
          continue;
        }
        if ((this.b instanceof long[]))
        {
          bool1 = Arrays.equals((long[])this.b, (long[])localjj.b);
          continue;
        }
        if ((this.b instanceof float[]))
        {
          bool1 = Arrays.equals((float[])this.b, (float[])localjj.b);
          continue;
        }
        if ((this.b instanceof double[]))
        {
          bool1 = Arrays.equals((double[])this.b, (double[])localjj.b);
          continue;
        }
        if ((this.b instanceof boolean[]))
        {
          bool1 = Arrays.equals((boolean[])this.b, (boolean[])localjj.b);
          continue;
        }
        bool1 = Arrays.deepEquals((Object[])this.b, (Object[])localjj.b);
        continue;
      }
      if ((this.c != null) && (localjj.c != null))
      {
        bool1 = this.c.equals(localjj.c);
        continue;
      }
      try
      {
        boolean bool2 = Arrays.equals(b(), localjj.b());
        bool1 = bool2;
      }
      catch (IOException localIOException)
      {
        throw new IllegalStateException(localIOException);
      }
    }
  }
  
  public int hashCode()
  {
    try
    {
      int i = Arrays.hashCode(b());
      return i + 527;
    }
    catch (IOException localIOException)
    {
      throw new IllegalStateException(localIOException);
    }
  }
}


/* Location:           C:\Users\dreadiscool\Desktop\tools\classes-dex2jar.jar
 * Qualified Name:     jj
 * JD-Core Version:    0.7.0.1
 */