import java.io.Closeable;
import java.io.Flushable;
import java.io.IOException;
import java.io.Writer;

public class rr
  implements Closeable, Flushable
{
  private static final String[] a = new String[''];
  private static final String[] b;
  private final Writer c;
  private int[] d = new int[32];
  private int e = 0;
  private String f;
  private String g;
  private boolean h;
  private boolean i;
  private String j;
  private boolean k;
  
  static
  {
    for (int m = 0; m <= 31; m++)
    {
      String[] arrayOfString = a;
      Object[] arrayOfObject = new Object[1];
      arrayOfObject[0] = Integer.valueOf(m);
      arrayOfString[m] = String.format("\\u%04x", arrayOfObject);
    }
    a[34] = "\\\"";
    a[92] = "\\\\";
    a[9] = "\\t";
    a[8] = "\\b";
    a[10] = "\\n";
    a[13] = "\\r";
    a[12] = "\\f";
    b = (String[])a.clone();
    b[60] = "\\u003c";
    b[62] = "\\u003e";
    b[38] = "\\u0026";
    b[61] = "\\u003d";
    b[39] = "\\u0027";
  }
  
  public rr(Writer paramWriter)
  {
    a(6);
    this.g = ":";
    this.k = true;
    if (paramWriter == null) {
      throw new NullPointerException("out == null");
    }
    this.c = paramWriter;
  }
  
  private int a()
  {
    if (this.e == 0) {
      throw new IllegalStateException("JsonWriter is closed.");
    }
    return this.d[(-1 + this.e)];
  }
  
  private rr a(int paramInt1, int paramInt2, String paramString)
  {
    int m = a();
    if ((m != paramInt2) && (m != paramInt1)) {
      throw new IllegalStateException("Nesting problem.");
    }
    if (this.j != null) {
      throw new IllegalStateException("Dangling name: " + this.j);
    }
    this.e = (-1 + this.e);
    if (m == paramInt2) {
      k();
    }
    this.c.write(paramString);
    return this;
  }
  
  private rr a(int paramInt, String paramString)
  {
    e(true);
    a(paramInt);
    this.c.write(paramString);
    return this;
  }
  
  private void a(int paramInt)
  {
    if (this.e == this.d.length)
    {
      int[] arrayOfInt2 = new int[2 * this.e];
      System.arraycopy(this.d, 0, arrayOfInt2, 0, this.e);
      this.d = arrayOfInt2;
    }
    int[] arrayOfInt1 = this.d;
    int m = this.e;
    this.e = (m + 1);
    arrayOfInt1[m] = paramInt;
  }
  
  private void b(int paramInt)
  {
    this.d[(-1 + this.e)] = paramInt;
  }
  
  private void d(String paramString)
  {
    int m = 0;
    if (this.i) {}
    int n;
    int i1;
    int i2;
    for (String[] arrayOfString = b;; arrayOfString = a)
    {
      this.c.write("\"");
      n = paramString.length();
      for (i1 = 0;; i1++)
      {
        if (i1 >= n) {
          break label141;
        }
        i2 = paramString.charAt(i1);
        if (i2 >= 128) {
          break;
        }
        str = arrayOfString[i2];
        if (str != null) {
          break label90;
        }
      }
    }
    if (i2 == 8232) {}
    for (String str = "\\u2028";; str = "\\u2029")
    {
      label90:
      if (m < i1) {
        this.c.write(paramString, m, i1 - m);
      }
      this.c.write(str);
      m = i1 + 1;
      break;
      if (i2 != 8233) {
        break;
      }
    }
    label141:
    if (m < n) {
      this.c.write(paramString, m, n - m);
    }
    this.c.write("\"");
  }
  
  private void e(boolean paramBoolean)
  {
    switch (a())
    {
    case 3: 
    case 5: 
    default: 
      throw new IllegalStateException("Nesting problem.");
    case 7: 
      if (!this.h) {
        throw new IllegalStateException("JSON must have only one top-level value.");
      }
    case 6: 
      if ((!this.h) && (!paramBoolean)) {
        throw new IllegalStateException("JSON must start with an array or an object.");
      }
      b(7);
    }
    for (;;)
    {
      return;
      b(2);
      k();
      continue;
      this.c.append(',');
      k();
      continue;
      this.c.append(this.g);
      b(5);
    }
  }
  
  private void j()
  {
    if (this.j != null)
    {
      l();
      d(this.j);
      this.j = null;
    }
  }
  
  private void k()
  {
    if (this.f == null) {}
    for (;;)
    {
      return;
      this.c.write("\n");
      int m = 1;
      int n = this.e;
      while (m < n)
      {
        this.c.write(this.f);
        m++;
      }
    }
  }
  
  private void l()
  {
    int m = a();
    if (m == 5) {
      this.c.write(44);
    }
    while (m == 3)
    {
      k();
      b(4);
      return;
    }
    throw new IllegalStateException("Nesting problem.");
  }
  
  public rr a(long paramLong)
  {
    j();
    e(false);
    this.c.write(Long.toString(paramLong));
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
      j();
      String str = paramNumber.toString();
      if ((!this.h) && ((str.equals("-Infinity")) || (str.equals("Infinity")) || (str.equals("NaN")))) {
        throw new IllegalArgumentException("Numeric values must be finite, but was " + paramNumber);
      }
      e(false);
      this.c.append(str);
    }
  }
  
  public rr a(String paramString)
  {
    if (paramString == null) {
      throw new NullPointerException("name == null");
    }
    if (this.j != null) {
      throw new IllegalStateException();
    }
    if (this.e == 0) {
      throw new IllegalStateException("JsonWriter is closed.");
    }
    this.j = paramString;
    return this;
  }
  
  public rr a(boolean paramBoolean)
  {
    j();
    e(false);
    Writer localWriter = this.c;
    if (paramBoolean) {}
    for (String str = "true";; str = "false")
    {
      localWriter.write(str);
      return this;
    }
  }
  
  public rr b()
  {
    j();
    return a(1, "[");
  }
  
  public rr b(String paramString)
  {
    if (paramString == null) {
      this = f();
    }
    for (;;)
    {
      return this;
      j();
      e(false);
      d(paramString);
    }
  }
  
  public final void b(boolean paramBoolean)
  {
    this.h = paramBoolean;
  }
  
  public rr c()
  {
    return a(1, 2, "]");
  }
  
  public final void c(String paramString)
  {
    if (paramString.length() == 0) {
      this.f = null;
    }
    for (this.g = ":";; this.g = ": ")
    {
      return;
      this.f = paramString;
    }
  }
  
  public final void c(boolean paramBoolean)
  {
    this.i = paramBoolean;
  }
  
  public void close()
  {
    this.c.close();
    int m = this.e;
    if ((m > 1) || ((m == 1) && (this.d[(m - 1)] != 7))) {
      throw new IOException("Incomplete document");
    }
    this.e = 0;
  }
  
  public rr d()
  {
    j();
    return a(3, "{");
  }
  
  public final void d(boolean paramBoolean)
  {
    this.k = paramBoolean;
  }
  
  public rr e()
  {
    return a(3, 5, "}");
  }
  
  public rr f()
  {
    if (this.j != null)
    {
      if (this.k) {
        j();
      }
    }
    else
    {
      e(false);
      this.c.write("null");
    }
    for (;;)
    {
      return this;
      this.j = null;
    }
  }
  
  public void flush()
  {
    if (this.e == 0) {
      throw new IllegalStateException("JsonWriter is closed.");
    }
    this.c.flush();
  }
  
  public boolean g()
  {
    return this.h;
  }
  
  public final boolean h()
  {
    return this.i;
  }
  
  public final boolean i()
  {
    return this.k;
  }
}


/* Location:           C:\Users\dreadiscool\Desktop\tools\classes-dex2jar.jar
 * Qualified Name:     rr
 * JD-Core Version:    0.7.0.1
 */