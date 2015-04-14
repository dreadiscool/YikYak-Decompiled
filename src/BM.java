public enum BM
{
  static
  {
    BM[] arrayOfBM = new BM[5];
    arrayOfBM[0] = a;
    arrayOfBM[1] = b;
    arrayOfBM[2] = c;
    arrayOfBM[3] = d;
    arrayOfBM[4] = e;
    f = arrayOfBM;
  }
  
  public static BM[] a()
  {
    BM[] arrayOfBM1 = f;
    int i = arrayOfBM1.length;
    BM[] arrayOfBM2 = new BM[i];
    System.arraycopy(arrayOfBM1, 0, arrayOfBM2, 0, i);
    return arrayOfBM2;
  }
}


/* Location:           C:\Users\dreadiscool\Desktop\tools\classes-dex2jar.jar
 * Qualified Name:     BM
 * JD-Core Version:    0.7.0.1
 */