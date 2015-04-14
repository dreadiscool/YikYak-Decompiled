final class sh
{
  private final Object a;
  private final int b;
  
  sh(Object paramObject, int paramInt)
  {
    this.a = paramObject;
    this.b = paramInt;
  }
  
  public boolean equals(Object paramObject)
  {
    boolean bool = false;
    if (!(paramObject instanceof sh)) {}
    for (;;)
    {
      return bool;
      sh localsh = (sh)paramObject;
      if ((this.a == localsh.a) && (this.b == localsh.b)) {
        bool = true;
      }
    }
  }
  
  public int hashCode()
  {
    return 65535 * System.identityHashCode(this.a) + this.b;
  }
}


/* Location:           C:\Users\dreadiscool\Desktop\tools\classes-dex2jar.jar
 * Qualified Name:     sh
 * JD-Core Version:    0.7.0.1
 */