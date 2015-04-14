import java.util.concurrent.TimeUnit;

public final class yU
{
  boolean a;
  boolean b;
  int c = -1;
  int d = -1;
  int e = -1;
  boolean f;
  boolean g;
  
  public yU a()
  {
    this.a = true;
    return this;
  }
  
  public yU a(int paramInt, TimeUnit paramTimeUnit)
  {
    if (paramInt < 0) {
      throw new IllegalArgumentException("maxStale < 0: " + paramInt);
    }
    long l = paramTimeUnit.toSeconds(paramInt);
    if (l > 2147483647L) {}
    for (int i = 2147483647;; i = (int)l)
    {
      this.d = i;
      return this;
    }
  }
  
  public yU b()
  {
    this.f = true;
    return this;
  }
  
  public yS c()
  {
    return new yS(this, null);
  }
}


/* Location:           C:\Users\dreadiscool\Desktop\tools\classes-dex2jar.jar
 * Qualified Name:     yU
 * JD-Core Version:    0.7.0.1
 */