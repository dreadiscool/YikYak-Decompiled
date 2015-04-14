import java.io.IOException;
import java.io.InputStream;

class LR
  extends InputStream
{
  LR(LQ paramLQ) {}
  
  public int available()
  {
    if (LQ.a(this.a)) {
      throw new IOException("closed");
    }
    return (int)Math.min(this.a.a.b, 2147483647L);
  }
  
  public void close()
  {
    this.a.close();
  }
  
  public int read()
  {
    if (LQ.a(this.a)) {
      throw new IOException("closed");
    }
    if ((this.a.a.b == 0L) && (this.a.b.a(this.a.a, 2048L) == -1L)) {}
    for (int i = -1;; i = 0xFF & this.a.a.k()) {
      return i;
    }
  }
  
  public int read(byte[] paramArrayOfByte, int paramInt1, int paramInt2)
  {
    if (LQ.a(this.a)) {
      throw new IOException("closed");
    }
    LY.a(paramArrayOfByte.length, paramInt1, paramInt2);
    if ((this.a.a.b == 0L) && (this.a.b.a(this.a.a, 2048L) == -1L)) {}
    for (int i = -1;; i = this.a.a.a(paramArrayOfByte, paramInt1, paramInt2)) {
      return i;
    }
  }
  
  public String toString()
  {
    return this.a + ".inputStream()";
  }
}


/* Location:           C:\Users\dreadiscool\Desktop\tools\classes-dex2jar.jar
 * Qualified Name:     LR
 * JD-Core Version:    0.7.0.1
 */