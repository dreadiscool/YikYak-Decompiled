class aw
{
  private static final bs a = new bs("", "", 0L);
  private static final aE[] b = new aE[0];
  private static final aH[] c = new aH[0];
  private static final aD[] d = new aD[0];
  private static final ay[] e = new ay[0];
  private static final az[] f = new az[0];
  
  private static aB a(br parambr)
  {
    if (parambr.b != null) {}
    for (bs localbs = parambr.b;; localbs = a)
    {
      ax localax = new ax(new aC(new aG(localbs), a(parambr.c), a(parambr.d)), a(parambr.e));
      aA localaA = new aA();
      return new aB(parambr.a, "ndk-crash", localax, localaA);
    }
  }
  
  private static aF a(bp[] paramArrayOfbp)
  {
    if (paramArrayOfbp != null) {}
    for (ay[] arrayOfay = new ay[paramArrayOfbp.length];; arrayOfay = e) {
      for (int i = 0; i < arrayOfay.length; i++) {
        arrayOfay[i] = new ay(paramArrayOfbp[i]);
      }
    }
    return new aF(arrayOfay);
  }
  
  private static aF a(bq[] paramArrayOfbq)
  {
    if (paramArrayOfbq != null) {}
    for (az[] arrayOfaz = new az[paramArrayOfbq.length];; arrayOfaz = f) {
      for (int i = 0; i < arrayOfaz.length; i++) {
        arrayOfaz[i] = new az(paramArrayOfbq[i]);
      }
    }
    return new aF(arrayOfaz);
  }
  
  private static aF a(bt[] paramArrayOfbt)
  {
    if (paramArrayOfbt != null) {}
    for (aH[] arrayOfaH = new aH[paramArrayOfbt.length];; arrayOfaH = c) {
      for (int i = 0; i < arrayOfaH.length; i++)
      {
        bt localbt = paramArrayOfbt[i];
        arrayOfaH[i] = new aH(localbt, a(localbt.b));
      }
    }
    return new aF(arrayOfaH);
  }
  
  private static aF a(bu[] paramArrayOfbu)
  {
    if (paramArrayOfbu != null) {}
    for (aD[] arrayOfaD = new aD[paramArrayOfbu.length];; arrayOfaD = d) {
      for (int i = 0; i < arrayOfaD.length; i++) {
        arrayOfaD[i] = new aD(paramArrayOfbu[i]);
      }
    }
    return new aF(arrayOfaD);
  }
  
  public static void a(br parambr, E paramE)
  {
    a(parambr).b(paramE);
  }
}


/* Location:           C:\Users\dreadiscool\Desktop\tools\classes-dex2jar.jar
 * Qualified Name:     aw
 * JD-Core Version:    0.7.0.1
 */