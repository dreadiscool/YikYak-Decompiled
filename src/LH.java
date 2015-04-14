public abstract class LH
  implements LV
{
  private final LV a;
  
  public LH(LV paramLV)
  {
    if (paramLV == null) {
      throw new IllegalArgumentException("delegate == null");
    }
    this.a = paramLV;
  }
  
  public long a(Lz paramLz, long paramLong)
  {
    return this.a.a(paramLz, paramLong);
  }
  
  public LW b()
  {
    return this.a.b();
  }
  
  public void close()
  {
    this.a.close();
  }
  
  public String toString()
  {
    return getClass().getSimpleName() + "(" + this.a.toString() + ")";
  }
}


/* Location:           C:\Users\dreadiscool\Desktop\tools\classes-dex2jar.jar
 * Qualified Name:     LH
 * JD-Core Version:    0.7.0.1
 */