import java.io.InputStream;

class LB
  extends InputStream
{
  LB(Lz paramLz) {}
  
  public int available()
  {
    return (int)Math.min(this.a.b, 2147483647L);
  }
  
  public void close() {}
  
  public int read()
  {
    if (this.a.b > 0L) {}
    for (int i = 0xFF & this.a.k();; i = -1) {
      return i;
    }
  }
  
  public int read(byte[] paramArrayOfByte, int paramInt1, int paramInt2)
  {
    return this.a.a(paramArrayOfByte, paramInt1, paramInt2);
  }
  
  public String toString()
  {
    return this.a + ".inputStream()";
  }
}


/* Location:           C:\Users\dreadiscool\Desktop\tools\classes-dex2jar.jar
 * Qualified Name:     LB
 * JD-Core Version:    0.7.0.1
 */