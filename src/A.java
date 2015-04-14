java.io.ByteArrayInputStream
java.io.InputStream
java.io.UnsupportedEncodingException

A

  a = 0
  []b
  c = 0
  
  A[]
  
    b = paramArrayOfByte;
  }
  
  public static A a(String paramString)
  {
    try
    {
      A localA = new A(paramString.getBytes("UTF-8"));
      return localA;
    }
    catch (UnsupportedEncodingException localUnsupportedEncodingException)
    {
      throw new RuntimeException("UTF-8 not supported.", localUnsupportedEncodingException);
    }
  }
  
  public static A a(byte[] paramArrayOfByte, int paramInt1, int paramInt2)
  {
    byte[] arrayOfByte = new byte[paramInt2];
    System.arraycopy(paramArrayOfByte, paramInt1, arrayOfByte, 0, paramInt2);
    return new A(arrayOfByte);
  }
  
  public int a()
  {
    return this.b.length;
  }
  
  public void a(byte[] paramArrayOfByte, int paramInt1, int paramInt2, int paramInt3)
  {
    System.arraycopy(this.b, paramInt1, paramArrayOfByte, paramInt2, paramInt3);
  }
  
  public InputStream b()
  {
    return new ByteArrayInputStream(this.b);
  }
  
  public boolean equals(Object paramObject)
  {
    boolean bool = true;
    if (paramObject == this) {}
    label92:
    for (;;)
    {
      return bool;
      if (!(paramObject instanceof A))
      {
        bool = false;
      }
      else
      {
        A localA = (A)paramObject;
        int i = this.b.length;
        if (i != localA.b.length)
        {
          bool = false;
        }
        else
        {
          byte[] arrayOfByte1 = this.b;
          byte[] arrayOfByte2 = localA.b;
          for (int j = 0;; j++)
          {
            if (j >= i) {
              break label92;
            }
            if (arrayOfByte1[j] != arrayOfByte2[j])
            {
              bool = false;
              break;
            }
          }
        }
      }
    }
  }
  
  public int hashCode()
  {
    int i = this.c;
    if (i == 0)
    {
      byte[] arrayOfByte = this.b;
      int j = this.b.length;
      int k = 0;
      int m;
      for (i = j; k < j; i = m)
      {
        m = i * 31 + arrayOfByte[k];
        k++;
      }
      if (i == 0) {
        i = 1;
      }
      this.c = i;
    }
    return i;
  }
}


/* Location:           C:\Users\dreadiscool\Desktop\tools\classes-dex2jar.jar
 * Qualified Name:     A
 * JD-Core Version:    0.7.0.1
 */