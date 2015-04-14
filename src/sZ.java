import java.util.ListIterator;

class sZ
  implements ListIterator<String>
{
  ListIterator<String> a = sY.a(this.c).listIterator(this.b);
  
  sZ(sY paramsY, int paramInt) {}
  
  public String a()
  {
    return (String)this.a.next();
  }
  
  public void a(String paramString)
  {
    throw new UnsupportedOperationException();
  }
  
  public String b()
  {
    return (String)this.a.previous();
  }
  
  public void b(String paramString)
  {
    throw new UnsupportedOperationException();
  }
  
  public boolean hasNext()
  {
    return this.a.hasNext();
  }
  
  public boolean hasPrevious()
  {
    return this.a.hasPrevious();
  }
  
  public int nextIndex()
  {
    return this.a.nextIndex();
  }
  
  public int previousIndex()
  {
    return this.a.previousIndex();
  }
  
  public void remove()
  {
    throw new UnsupportedOperationException();
  }
}


/* Location:           C:\Users\dreadiscool\Desktop\tools\classes-dex2jar.jar
 * Qualified Name:     sZ
 * JD-Core Version:    0.7.0.1
 */