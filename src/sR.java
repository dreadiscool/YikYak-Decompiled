import java.util.Iterator;

class sR
{
  private static final Iterator<Object> a = new sS();
  private static final Iterable<Object> b = new sT();
  
  static <T> Iterable<T> a()
  {
    return b;
  }
}


/* Location:           C:\Users\dreadiscool\Desktop\tools\classes-dex2jar.jar
 * Qualified Name:     sR
 * JD-Core Version:    0.7.0.1
 */