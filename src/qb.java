class qb
  implements CharSequence
{
  char[] a;
  
  public char charAt(int paramInt)
  {
    return this.a[paramInt];
  }
  
  public int length()
  {
    return this.a.length;
  }
  
  public CharSequence subSequence(int paramInt1, int paramInt2)
  {
    return new String(this.a, paramInt1, paramInt2 - paramInt1);
  }
}


/* Location:           C:\Users\dreadiscool\Desktop\tools\classes-dex2jar.jar
 * Qualified Name:     qb
 * JD-Core Version:    0.7.0.1
 */