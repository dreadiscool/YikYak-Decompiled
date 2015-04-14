import java.io.OutputStream;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

class sJ
  extends rZ
{
  private static final int[] c;
  private final int d;
  private final rZ e;
  private final rZ f;
  private final int g;
  private final int h;
  private int i = 0;
  
  static
  {
    int j = 1;
    ArrayList localArrayList = new ArrayList();
    int k = j;
    while (j > 0)
    {
      localArrayList.add(Integer.valueOf(j));
      int n = k + j;
      k = j;
      j = n;
    }
    localArrayList.add(Integer.valueOf(2147483647));
    c = new int[localArrayList.size()];
    for (int m = 0; m < c.length; m++) {
      c[m] = ((Integer)localArrayList.get(m)).intValue();
    }
  }
  
  private sJ(rZ paramrZ1, rZ paramrZ2)
  {
    this.e = paramrZ1;
    this.f = paramrZ2;
    this.g = paramrZ1.a();
    this.d = (this.g + paramrZ2.a());
    this.h = (1 + Math.max(paramrZ1.j(), paramrZ2.j()));
  }
  
  static rZ a(rZ paramrZ1, rZ paramrZ2)
  {
    sJ localsJ1;
    if ((paramrZ1 instanceof sJ))
    {
      localsJ1 = (sJ)paramrZ1;
      if (paramrZ2.a() != 0) {
        break label26;
      }
    }
    for (;;)
    {
      return paramrZ1;
      localsJ1 = null;
      break;
      label26:
      if (paramrZ1.a() == 0)
      {
        paramrZ1 = paramrZ2;
      }
      else
      {
        int j = paramrZ1.a() + paramrZ2.a();
        if (j < 128)
        {
          paramrZ1 = b(paramrZ1, paramrZ2);
        }
        else if ((localsJ1 != null) && (localsJ1.f.a() + paramrZ2.a() < 128))
        {
          sB localsB = b(localsJ1.f, paramrZ2);
          paramrZ1 = new sJ(localsJ1.e, localsB);
        }
        else if ((localsJ1 != null) && (localsJ1.e.j() > localsJ1.f.j()) && (localsJ1.j() > paramrZ2.j()))
        {
          sJ localsJ2 = new sJ(localsJ1.f, paramrZ2);
          paramrZ1 = new sJ(localsJ1.e, localsJ2);
        }
        else
        {
          int k = 1 + Math.max(paramrZ1.j(), paramrZ2.j());
          if (j >= c[k]) {
            paramrZ1 = new sJ(paramrZ1, paramrZ2);
          } else {
            paramrZ1 = sL.a(new sL(null), paramrZ1, paramrZ2);
          }
        }
      }
    }
  }
  
  private static sB b(rZ paramrZ1, rZ paramrZ2)
  {
    int j = paramrZ1.a();
    int k = paramrZ2.a();
    byte[] arrayOfByte = new byte[j + k];
    paramrZ1.b(arrayOfByte, 0, 0, j);
    paramrZ2.b(arrayOfByte, 0, j, k);
    return new sB(arrayOfByte);
  }
  
  private boolean b(rZ paramrZ)
  {
    boolean bool1 = false;
    sM localsM1 = new sM(this, null);
    sB localsB1 = (sB)localsM1.next();
    sM localsM2 = new sM(paramrZ, null);
    Object localObject1 = (sB)localsM2.next();
    int j = 0;
    sB localsB2 = localsB1;
    int k = 0;
    int m = 0;
    int n = localsB2.a() - k;
    int i1 = ((sB)localObject1).a() - j;
    int i2 = Math.min(n, i1);
    boolean bool2;
    if (k == 0)
    {
      bool2 = localsB2.a((sB)localObject1, j, i2);
      if (bool2) {
        break label129;
      }
    }
    label129:
    int i3;
    for (;;)
    {
      return bool1;
      bool2 = ((sB)localObject1).a(localsB2, k, i2);
      break;
      i3 = m + i2;
      if (i3 < this.d) {
        break label167;
      }
      if (i3 != this.d) {
        break label159;
      }
      bool1 = true;
    }
    label159:
    throw new IllegalStateException();
    label167:
    label188:
    Object localObject3;
    int i5;
    if (i2 == n)
    {
      localsB2 = (sB)localsM1.next();
      k = 0;
      if (i2 != i1) {
        break label235;
      }
      localObject3 = (sB)localsM2.next();
      i5 = 0;
    }
    for (;;)
    {
      j = i5;
      localObject1 = localObject3;
      m = i3;
      break;
      k += i2;
      break label188;
      label235:
      int i4 = j + i2;
      Object localObject2 = localObject1;
      i5 = i4;
      localObject3 = localObject2;
    }
  }
  
  public int a()
  {
    return this.d;
  }
  
  protected int a(int paramInt1, int paramInt2, int paramInt3)
  {
    int m;
    if (paramInt2 + paramInt3 <= this.g) {
      m = this.e.a(paramInt1, paramInt2, paramInt3);
    }
    for (;;)
    {
      return m;
      if (paramInt2 >= this.g)
      {
        m = this.f.a(paramInt1, paramInt2 - this.g, paramInt3);
      }
      else
      {
        int j = this.g - paramInt2;
        int k = this.e.a(paramInt1, paramInt2, j);
        m = this.f.a(k, 0, paramInt3 - j);
      }
    }
  }
  
  public String a(String paramString)
  {
    return new String(e(), paramString);
  }
  
  protected void a(byte[] paramArrayOfByte, int paramInt1, int paramInt2, int paramInt3)
  {
    if (paramInt1 + paramInt3 <= this.g) {
      this.e.a(paramArrayOfByte, paramInt1, paramInt2, paramInt3);
    }
    for (;;)
    {
      return;
      if (paramInt1 >= this.g)
      {
        this.f.a(paramArrayOfByte, paramInt1 - this.g, paramInt2, paramInt3);
      }
      else
      {
        int j = this.g - paramInt1;
        this.e.a(paramArrayOfByte, paramInt1, paramInt2, j);
        this.f.a(paramArrayOfByte, 0, paramInt2 + j, paramInt3 - j);
      }
    }
  }
  
  protected int b(int paramInt1, int paramInt2, int paramInt3)
  {
    int m;
    if (paramInt2 + paramInt3 <= this.g) {
      m = this.e.b(paramInt1, paramInt2, paramInt3);
    }
    for (;;)
    {
      return m;
      if (paramInt2 >= this.g)
      {
        m = this.f.b(paramInt1, paramInt2 - this.g, paramInt3);
      }
      else
      {
        int j = this.g - paramInt2;
        int k = this.e.b(paramInt1, paramInt2, j);
        m = this.f.b(k, 0, paramInt3 - j);
      }
    }
  }
  
  void b(OutputStream paramOutputStream, int paramInt1, int paramInt2)
  {
    if (paramInt1 + paramInt2 <= this.g) {
      this.e.b(paramOutputStream, paramInt1, paramInt2);
    }
    for (;;)
    {
      return;
      if (paramInt1 >= this.g)
      {
        this.f.b(paramOutputStream, paramInt1 - this.g, paramInt2);
      }
      else
      {
        int j = this.g - paramInt1;
        this.e.b(paramOutputStream, paramInt1, j);
        this.f.b(paramOutputStream, 0, paramInt2 - j);
      }
    }
  }
  
  public sa c()
  {
    return new sN(this, null);
  }
  
  public boolean equals(Object paramObject)
  {
    boolean bool = true;
    if (paramObject == this) {}
    for (;;)
    {
      return bool;
      if (!(paramObject instanceof rZ))
      {
        bool = false;
      }
      else
      {
        rZ localrZ = (rZ)paramObject;
        if (this.d != localrZ.a())
        {
          bool = false;
        }
        else if (this.d != 0)
        {
          if (this.i != 0)
          {
            int j = localrZ.l();
            if ((j != 0) && (this.i != j))
            {
              bool = false;
              continue;
            }
          }
          bool = b(localrZ);
        }
      }
    }
  }
  
  public boolean g()
  {
    boolean bool = false;
    int j = this.e.a(0, 0, this.g);
    if (this.f.a(j, 0, this.f.a()) == 0) {
      bool = true;
    }
    return bool;
  }
  
  public sc h()
  {
    return sc.a(new sO(this));
  }
  
  public int hashCode()
  {
    int j = this.i;
    if (j == 0)
    {
      j = b(this.d, 0, this.d);
      if (j == 0) {
        j = 1;
      }
      this.i = j;
    }
    return j;
  }
  
  protected int j()
  {
    return this.h;
  }
  
  protected boolean k()
  {
    if (this.d >= c[this.h]) {}
    for (boolean bool = true;; bool = false) {
      return bool;
    }
  }
  
  protected int l()
  {
    return this.i;
  }
}


/* Location:           C:\Users\dreadiscool\Desktop\tools\classes-dex2jar.jar
 * Qualified Name:     sJ
 * JD-Core Version:    0.7.0.1
 */