class ji
{
  private static final jj a = new jj();
  private boolean b = false;
  private int[] c;
  private jj[] d;
  private int e;
  
  public ji()
  {
    this(10);
  }
  
  public ji(int paramInt)
  {
    int i = b(paramInt);
    this.c = new int[i];
    this.d = new jj[i];
    this.e = 0;
  }
  
  private boolean a(int[] paramArrayOfInt1, int[] paramArrayOfInt2, int paramInt)
  {
    boolean bool = false;
    int i = 0;
    if (i < paramInt) {
      if (paramArrayOfInt1[i] == paramArrayOfInt2[i]) {}
    }
    for (;;)
    {
      return bool;
      i++;
      break;
      bool = true;
    }
  }
  
  private boolean a(jj[] paramArrayOfjj1, jj[] paramArrayOfjj2, int paramInt)
  {
    boolean bool = false;
    int i = 0;
    if (i < paramInt) {
      if (paramArrayOfjj1[i].equals(paramArrayOfjj2[i])) {}
    }
    for (;;)
    {
      return bool;
      i++;
      break;
      bool = true;
    }
  }
  
  private int b(int paramInt)
  {
    return c(paramInt * 4) / 4;
  }
  
  private int c(int paramInt)
  {
    for (int i = 4;; i++) {
      if (i < 32)
      {
        if (paramInt <= -12 + (1 << i)) {
          paramInt = -12 + (1 << i);
        }
      }
      else {
        return paramInt;
      }
    }
  }
  
  private void c()
  {
    int i = this.e;
    int[] arrayOfInt = this.c;
    jj[] arrayOfjj = this.d;
    int j = 0;
    int k = 0;
    while (j < i)
    {
      jj localjj = arrayOfjj[j];
      if (localjj != a)
      {
        if (j != k)
        {
          arrayOfInt[k] = arrayOfInt[j];
          arrayOfjj[k] = localjj;
          arrayOfjj[j] = null;
        }
        k++;
      }
      j++;
    }
    this.b = false;
    this.e = k;
  }
  
  public int a()
  {
    if (this.b) {
      c();
    }
    return this.e;
  }
  
  public jj a(int paramInt)
  {
    if (this.b) {
      c();
    }
    return this.d[paramInt];
  }
  
  public boolean b()
  {
    if (a() == 0) {}
    for (boolean bool = true;; bool = false) {
      return bool;
    }
  }
  
  public boolean equals(Object paramObject)
  {
    boolean bool = true;
    if (paramObject == this) {}
    for (;;)
    {
      return bool;
      if (!(paramObject instanceof ji))
      {
        bool = false;
      }
      else
      {
        ji localji = (ji)paramObject;
        if (a() != localji.a()) {
          bool = false;
        } else if ((!a(this.c, localji.c, this.e)) || (!a(this.d, localji.d, this.e))) {
          bool = false;
        }
      }
    }
  }
  
  public int hashCode()
  {
    if (this.b) {
      c();
    }
    int i = 17;
    for (int j = 0; j < this.e; j++) {
      i = 31 * (i * 31 + this.c[j]) + this.d[j].hashCode();
    }
    return i;
  }
}


/* Location:           C:\Users\dreadiscool\Desktop\tools\classes-dex2jar.jar
 * Qualified Name:     ji
 * JD-Core Version:    0.7.0.1
 */