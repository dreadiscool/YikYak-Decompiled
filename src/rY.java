import java.util.NoSuchElementException;

class rY
  implements sa
{
  private int b;
  private final int c;
  
  private rY(rW paramrW)
  {
    this.b = paramrW.b();
    this.c = (this.b + paramrW.a());
  }
  
  public Byte a()
  {
    return Byte.valueOf(b());
  }
  
  public byte b()
  {
    if (this.b >= this.c) {
      throw new NoSuchElementException();
    }
    byte[] arrayOfByte = this.a.c;
    int i = this.b;
    this.b = (i + 1);
    return arrayOfByte[i];
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
 * Qualified Name:     rY
 * JD-Core Version:    0.7.0.1
 */