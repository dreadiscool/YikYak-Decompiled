import java.util.Iterator;
import java.util.NoSuchElementException;

final class sS
  implements Iterator<Object>
{
  public boolean hasNext()
  {
    return false;
  }
  
  public Object next()
  {
    throw new NoSuchElementException();
  }
  
  public void remove()
  {
    throw new UnsupportedOperationException();
  }
}


/* Location:           C:\Users\dreadiscool\Desktop\tools\classes-dex2jar.jar
 * Qualified Name:     sS
 * JD-Core Version:    0.7.0.1
 */