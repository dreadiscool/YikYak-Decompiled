public enum rq
{
  static
  {
    rq[] arrayOfrq = new rq[10];
    arrayOfrq[0] = a;
    arrayOfrq[1] = b;
    arrayOfrq[2] = c;
    arrayOfrq[3] = d;
    arrayOfrq[4] = e;
    arrayOfrq[5] = f;
    arrayOfrq[6] = g;
    arrayOfrq[7] = h;
    arrayOfrq[8] = i;
    arrayOfrq[9] = j;
    k = arrayOfrq;
  }
  
  private rq() {}
  
  public static rq[] a()
  {
    return (rq[])k.clone();
  }
}


/* Location:           C:\Users\dreadiscool\Desktop\tools\classes-dex2jar.jar
 * Qualified Name:     rq
 * JD-Core Version:    0.7.0.1
 */