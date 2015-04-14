import java.util.concurrent.TimeUnit;

public final class yS
{
  public static final yS a = new yU().a().c();
  public static final yS b = new yU().b().a(2147483647, TimeUnit.SECONDS).c();
  private final boolean c;
  private final boolean d;
  private final int e;
  private final int f;
  private final boolean g;
  private final boolean h;
  private final int i;
  private final int j;
  private final boolean k;
  private final boolean l;
  
  private yS(yU paramyU)
  {
    this.c = paramyU.a;
    this.d = paramyU.b;
    this.e = paramyU.c;
    this.f = -1;
    this.g = false;
    this.h = false;
    this.i = paramyU.d;
    this.j = paramyU.e;
    this.k = paramyU.f;
    this.l = paramyU.g;
  }
  
  private yS(boolean paramBoolean1, boolean paramBoolean2, int paramInt1, int paramInt2, boolean paramBoolean3, boolean paramBoolean4, int paramInt3, int paramInt4, boolean paramBoolean5, boolean paramBoolean6)
  {
    this.c = paramBoolean1;
    this.d = paramBoolean2;
    this.e = paramInt1;
    this.f = paramInt2;
    this.g = paramBoolean3;
    this.h = paramBoolean4;
    this.i = paramInt3;
    this.j = paramInt4;
    this.k = paramBoolean5;
    this.l = paramBoolean6;
  }
  
  public static yS a(zo paramzo)
  {
    boolean bool1 = false;
    boolean bool2 = false;
    int m = -1;
    int n = -1;
    boolean bool3 = false;
    boolean bool4 = false;
    int i1 = -1;
    int i2 = -1;
    boolean bool5 = false;
    boolean bool6 = false;
    int i3 = paramzo.a();
    int i4 = 0;
    if (i4 < i3)
    {
      if ((!paramzo.a(i4).equalsIgnoreCase("Cache-Control")) && (!paramzo.a(i4).equalsIgnoreCase("Pragma"))) {}
      for (;;)
      {
        i4++;
        break;
        String str1 = paramzo.b(i4);
        int i5 = 0;
        while (i5 < str1.length())
        {
          int i6 = Am.a(str1, i5, "=,;");
          String str2 = str1.substring(i5, i6).trim();
          Object localObject;
          if ((i6 == str1.length()) || (str1.charAt(i6) == ',') || (str1.charAt(i6) == ';'))
          {
            i5 = i6 + 1;
            localObject = null;
          }
          for (;;)
          {
            if (!"no-cache".equalsIgnoreCase(str2)) {
              break label295;
            }
            bool1 = true;
            break;
            int i7 = Am.a(str1, i6 + 1);
            if ((i7 < str1.length()) && (str1.charAt(i7) == '"'))
            {
              int i9 = i7 + 1;
              int i10 = Am.a(str1, i9, "\"");
              String str4 = str1.substring(i9, i10);
              i5 = i10 + 1;
              localObject = str4;
            }
            else
            {
              int i8 = Am.a(str1, i7, ",;");
              String str3 = str1.substring(i7, i8).trim();
              i5 = i8;
              localObject = str3;
            }
          }
          label295:
          if ("no-store".equalsIgnoreCase(str2)) {
            bool2 = true;
          } else if ("max-age".equalsIgnoreCase(str2)) {
            m = Am.b(localObject, -1);
          } else if ("s-maxage".equalsIgnoreCase(str2)) {
            n = Am.b(localObject, -1);
          } else if ("public".equalsIgnoreCase(str2)) {
            bool3 = true;
          } else if ("must-revalidate".equalsIgnoreCase(str2)) {
            bool4 = true;
          } else if ("max-stale".equalsIgnoreCase(str2)) {
            i1 = Am.b(localObject, 2147483647);
          } else if ("min-fresh".equalsIgnoreCase(str2)) {
            i2 = Am.b(localObject, -1);
          } else if ("only-if-cached".equalsIgnoreCase(str2)) {
            bool5 = true;
          } else if ("no-transform".equalsIgnoreCase(str2)) {
            bool6 = true;
          }
        }
      }
    }
    return new yS(bool1, bool2, m, n, bool3, bool4, i1, i2, bool5, bool6);
  }
  
  public boolean a()
  {
    return this.c;
  }
  
  public boolean b()
  {
    return this.d;
  }
  
  public int c()
  {
    return this.e;
  }
  
  public int d()
  {
    return this.f;
  }
  
  public boolean e()
  {
    return this.g;
  }
  
  public boolean f()
  {
    return this.h;
  }
  
  public int g()
  {
    return this.i;
  }
  
  public int h()
  {
    return this.j;
  }
  
  public boolean i()
  {
    return this.k;
  }
  
  public String toString()
  {
    StringBuilder localStringBuilder = new StringBuilder();
    if (this.c) {
      localStringBuilder.append("no-cache, ");
    }
    if (this.d) {
      localStringBuilder.append("no-store, ");
    }
    if (this.e != -1) {
      localStringBuilder.append("max-age=").append(this.e).append(", ");
    }
    if (this.f != -1) {
      localStringBuilder.append("s-maxage=").append(this.f).append(", ");
    }
    if (this.g) {
      localStringBuilder.append("public, ");
    }
    if (this.h) {
      localStringBuilder.append("must-revalidate, ");
    }
    if (this.i != -1) {
      localStringBuilder.append("max-stale=").append(this.i).append(", ");
    }
    if (this.j != -1) {
      localStringBuilder.append("min-fresh=").append(this.j).append(", ");
    }
    if (this.k) {
      localStringBuilder.append("only-if-cached, ");
    }
    if (this.l) {
      localStringBuilder.append("no-transform, ");
    }
    if (localStringBuilder.length() == 0) {}
    for (String str = "";; str = localStringBuilder.toString())
    {
      return str;
      localStringBuilder.delete(-2 + localStringBuilder.length(), localStringBuilder.length());
    }
  }
}


/* Location:           C:\Users\dreadiscool\Desktop\tools\classes-dex2jar.jar
 * Qualified Name:     yS
 * JD-Core Version:    0.7.0.1
 */