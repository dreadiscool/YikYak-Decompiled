import java.util.Arrays;

public final class Bn
{
  private int a;
  private int b;
  private int c;
  private final int[] d = new int[10];
  
  Bn a(int paramInt1, int paramInt2, int paramInt3)
  {
    if (paramInt1 >= this.d.length) {
      return this;
    }
    int i = 1 << paramInt1;
    this.a = (i | this.a);
    if ((paramInt2 & 0x1) != 0)
    {
      this.b = (i | this.b);
      label44:
      if ((paramInt2 & 0x2) == 0) {
        break label88;
      }
    }
    label88:
    for (this.c = (i | this.c);; this.c &= (i ^ 0xFFFFFFFF))
    {
      this.d[paramInt1] = paramInt3;
      break;
      this.b &= (i ^ 0xFFFFFFFF);
      break label44;
    }
  }
  
  void a()
  {
    this.c = 0;
    this.b = 0;
    this.a = 0;
    Arrays.fill(this.d, 0);
  }
  
  void a(Bn paramBn)
  {
    int i = 0;
    if (i < 10)
    {
      if (!paramBn.a(i)) {}
      for (;;)
      {
        i++;
        break;
        a(i, paramBn.c(i), paramBn.b(i));
      }
    }
  }
  
  boolean a(int paramInt)
  {
    int i = 1;
    if ((i << paramInt & this.a) != 0) {}
    for (;;)
    {
      return i;
      i = 0;
    }
  }
  
  int b()
  {
    return Integer.bitCount(this.a);
  }
  
  int b(int paramInt)
  {
    return this.d[paramInt];
  }
  
  int c()
  {
    if ((0x2 & this.a) != 0) {}
    for (int i = this.d[1];; i = -1) {
      return i;
    }
  }
  
  int c(int paramInt)
  {
    int i = 0;
    if (g(paramInt)) {
      i = 2;
    }
    if (f(paramInt)) {
      i |= 0x1;
    }
    return i;
  }
  
  int d(int paramInt)
  {
    if ((0x20 & this.a) != 0) {
      paramInt = this.d[5];
    }
    return paramInt;
  }
  
  int e(int paramInt)
  {
    if ((0x80 & this.a) != 0) {
      paramInt = this.d[7];
    }
    return paramInt;
  }
  
  boolean f(int paramInt)
  {
    int i = 1;
    if ((i << paramInt & this.b) != 0) {}
    for (;;)
    {
      return i;
      i = 0;
    }
  }
  
  boolean g(int paramInt)
  {
    int i = 1;
    if ((i << paramInt & this.c) != 0) {}
    for (;;)
    {
      return i;
      i = 0;
    }
  }
}


/* Location:           C:\Users\dreadiscool\Desktop\tools\classes-dex2jar.jar
 * Qualified Name:     Bn
 * JD-Core Version:    0.7.0.1
 */