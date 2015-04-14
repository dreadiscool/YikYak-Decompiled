public class fz
  implements fE
{
  private final long a;
  private final int b;
  private double c;
  private long d;
  private final Object e = new Object();
  private final String f;
  
  public fz(int paramInt, long paramLong, String paramString)
  {
    this.b = paramInt;
    this.c = this.b;
    this.a = paramLong;
    this.f = paramString;
  }
  
  public fz(String paramString)
  {
    this(60, 2000L, paramString);
  }
  
  public boolean a()
  {
    boolean bool;
    synchronized (this.e)
    {
      long l = System.currentTimeMillis();
      if (this.c < this.b)
      {
        double d1 = (l - this.d) / this.a;
        if (d1 > 0.0D) {
          this.c = Math.min(this.b, d1 + this.c);
        }
      }
      this.d = l;
      if (this.c >= 1.0D)
      {
        this.c -= 1.0D;
        bool = true;
      }
      else
      {
        fA.d("Excessive " + this.f + " detected; call ignored.");
        bool = false;
      }
    }
    return bool;
  }
}


/* Location:           C:\Users\dreadiscool\Desktop\tools\classes-dex2jar.jar
 * Qualified Name:     fz
 * JD-Core Version:    0.7.0.1
 */