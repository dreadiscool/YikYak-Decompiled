import java.util.Arrays;

final class jn
{
  final int a;
  final byte[] b;
  
  int a()
  {
    return 0 + je.f(this.a) + this.b.length;
  }
  
  void a(je paramje)
  {
    paramje.e(this.a);
    paramje.b(this.b);
  }
  
  public boolean equals(Object paramObject)
  {
    boolean bool = true;
    if (paramObject == this) {}
    for (;;)
    {
      return bool;
      if (!(paramObject instanceof jn))
      {
        bool = false;
      }
      else
      {
        jn localjn = (jn)paramObject;
        if ((this.a != localjn.a) || (!Arrays.equals(this.b, localjn.b))) {
          bool = false;
        }
      }
    }
  }
  
  public int hashCode()
  {
    return 31 * (527 + this.a) + Arrays.hashCode(this.b);
  }
}


/* Location:           C:\Users\dreadiscool\Desktop\tools\classes-dex2jar.jar
 * Qualified Name:     jn
 * JD-Core Version:    0.7.0.1
 */