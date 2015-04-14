import java.util.Iterator;

class ta
  implements Iterator<String>
{
  Iterator<String> a = sY.a(this.b).iterator();
  
  ta(sY paramsY) {}
  
  public String a()
  {
    return (String)this.a.next();
  }
  
  public boolean hasNext()
  {
    return this.a.hasNext();
  }
  
  public void remove()
  {
    throw new UnsupportedOperationException();
  }
}


/* Location:           C:\Users\dreadiscool\Desktop\tools\classes-dex2jar.jar
 * Qualified Name:     ta
 * JD-Core Version:    0.7.0.1
 */