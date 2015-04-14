public enum AP
{
  public final int s;
  public final int t;
  public final int u;
  
  static
  {
    AP[] arrayOfAP = new AP[18];
    arrayOfAP[0] = a;
    arrayOfAP[1] = b;
    arrayOfAP[2] = c;
    arrayOfAP[3] = d;
    arrayOfAP[4] = e;
    arrayOfAP[5] = f;
    arrayOfAP[6] = g;
    arrayOfAP[7] = h;
    arrayOfAP[8] = i;
    arrayOfAP[9] = j;
    arrayOfAP[10] = k;
    arrayOfAP[11] = l;
    arrayOfAP[12] = m;
    arrayOfAP[13] = n;
    arrayOfAP[14] = o;
    arrayOfAP[15] = p;
    arrayOfAP[16] = q;
    arrayOfAP[17] = r;
    v = arrayOfAP;
  }
  
  private AP(int paramInt1, int paramInt2, int paramInt3)
  {
    this.s = paramInt1;
    this.t = paramInt2;
    this.u = paramInt3;
  }
  
  public static AP a(int paramInt)
  {
    AP[] arrayOfAP = a();
    int i1 = arrayOfAP.length;
    int i2 = 0;
    AP localAP;
    if (i2 < i1)
    {
      localAP = arrayOfAP[i2];
      if (localAP.t != paramInt) {}
    }
    for (;;)
    {
      return localAP;
      i2++;
      break;
      localAP = null;
    }
  }
  
  public static AP[] a()
  {
    return (AP[])v.clone();
  }
  
  public static AP b(int paramInt)
  {
    AP[] arrayOfAP = a();
    int i1 = arrayOfAP.length;
    int i2 = 0;
    AP localAP;
    if (i2 < i1)
    {
      localAP = arrayOfAP[i2];
      if (localAP.s != paramInt) {}
    }
    for (;;)
    {
      return localAP;
      i2++;
      break;
      localAP = null;
    }
  }
  
  public static AP c(int paramInt)
  {
    AP[] arrayOfAP = a();
    int i1 = arrayOfAP.length;
    int i2 = 0;
    AP localAP;
    if (i2 < i1)
    {
      localAP = arrayOfAP[i2];
      if (localAP.u != paramInt) {}
    }
    for (;;)
    {
      return localAP;
      i2++;
      break;
      localAP = null;
    }
  }
}


/* Location:           C:\Users\dreadiscool\Desktop\tools\classes-dex2jar.jar
 * Qualified Name:     AP
 * JD-Core Version:    0.7.0.1
 */