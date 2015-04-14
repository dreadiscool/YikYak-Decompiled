public enum zK
{
  final String e;
  
  static
  {
    zK[] arrayOfzK = new zK[4];
    arrayOfzK[0] = a;
    arrayOfzK[1] = b;
    arrayOfzK[2] = c;
    arrayOfzK[3] = d;
    f = arrayOfzK;
  }
  
  private zK(String paramString)
  {
    this.e = paramString;
  }
  
  static zK a(String paramString)
  {
    int i = -1;
    switch (paramString.hashCode())
    {
    }
    for (;;)
    {
      switch (i)
      {
      default: 
        throw new IllegalArgumentException("Unexpected TLS version: " + paramString);
        if (paramString.equals("TLSv1.2"))
        {
          i = 0;
          continue;
          if (paramString.equals("TLSv1.1"))
          {
            i = 1;
            continue;
            if (paramString.equals("TLSv1"))
            {
              i = 2;
              continue;
              if (paramString.equals("SSLv3")) {
                i = 3;
              }
            }
          }
        }
        break;
      }
    }
    zK localzK = a;
    for (;;)
    {
      return localzK;
      localzK = b;
      continue;
      localzK = c;
      continue;
      localzK = d;
    }
  }
}


/* Location:           C:\Users\dreadiscool\Desktop\tools\classes-dex2jar.jar
 * Qualified Name:     zK
 * JD-Core Version:    0.7.0.1
 */