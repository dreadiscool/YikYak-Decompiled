public final class tc
{
  static final int a = a(1, 3);
  static final int b = a(1, 4);
  static final int c = a(2, 0);
  static final int d = a(3, 2);
  
  static int a(int paramInt)
  {
    return paramInt & 0x7;
  }
  
  static int a(int paramInt1, int paramInt2)
  {
    return paramInt2 | paramInt1 << 3;
  }
  
  public static int b(int paramInt)
  {
    return paramInt >>> 3;
  }
}


/* Location:           C:\Users\dreadiscool\Desktop\tools\classes-dex2jar.jar
 * Qualified Name:     tc
 * JD-Core Version:    0.7.0.1
 */