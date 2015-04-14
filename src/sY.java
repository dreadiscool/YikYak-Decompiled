import java.util.AbstractList;
import java.util.Iterator;
import java.util.List;
import java.util.ListIterator;
import java.util.RandomAccess;

public class sY
  extends AbstractList<String>
  implements RandomAccess, sA
{
  private final sA a;
  
  public sY(sA paramsA)
  {
    this.a = paramsA;
  }
  
  public String a(int paramInt)
  {
    return (String)this.a.get(paramInt);
  }
  
  public List<?> a()
  {
    return this.a.a();
  }
  
  public void a(rZ paramrZ)
  {
    throw new UnsupportedOperationException();
  }
  
  public Iterator<String> iterator()
  {
    return new ta(this);
  }
  
  public ListIterator<String> listIterator(int paramInt)
  {
    return new sZ(this, paramInt);
  }
  
  public int size()
  {
    return this.a.size();
  }
}


/* Location:           C:\Users\dreadiscool\Desktop\tools\classes-dex2jar.jar
 * Qualified Name:     sY
 * JD-Core Version:    0.7.0.1
 */