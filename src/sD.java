import java.util.NoSuchElementException;

class sD
  implements sa
{
  private int b = 0;
  private final int c;
  
  private sD(sB paramsB)
  {
    this.c = paramsB.a();
  }
  
  public Byte a()
  {
    return Byte.valueOf(b());
  }
  
  public byte b()
  {
    try
    {
      byte[] arrayOfByte = this.a.c;
      int i = this.b;
      this.b = (i + 1);
      byte b1 = arrayOfByte[i];
      return b1;
    }
    catch (ArrayIndexOutOfBoundsException localArrayIndexOutOfBoundsException)
    {
      throw new NoSuchElementException(localArrayIndexOutOfBoundsException.getMessage());
    }
  }
  
  public boolean hasNext()
  {
    if (this.b < this.c) {}
    for (boolean bool = true;; bool = false) {
      return bool;
    }
  }
  
  public void remove()
  {
    throw new UnsupportedOperationException();
  }
}


/* Location:           C:\Users\dreadiscool\Desktop\tools\classes-dex2jar.jar
 * Qualified Name:     sD
 * JD-Core Version:    0.7.0.1
 */