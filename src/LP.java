import java.io.IOException;
import java.io.OutputStream;

class LP
  extends OutputStream
{
  LP(LO paramLO) {}
  
  public void close()
  {
    this.a.close();
  }
  
  public void flush()
  {
    if (!LO.a(this.a)) {
      this.a.a();
    }
  }
  
  public String toString()
  {
    return this.a + ".outputStream()";
  }
  
  public void write(int paramInt)
  {
    if (LO.a(this.a)) {
      throw new IOException("closed");
    }
    this.a.a.a((byte)paramInt);
    this.a.u();
  }
  
  public void write(byte[] paramArrayOfByte, int paramInt1, int paramInt2)
  {
    if (LO.a(this.a)) {
      throw new IOException("closed");
    }
    this.a.a.b(paramArrayOfByte, paramInt1, paramInt2);
    this.a.u();
  }
}


/* Location:           C:\Users\dreadiscool\Desktop\tools\classes-dex2jar.jar
 * Qualified Name:     LP
 * JD-Core Version:    0.7.0.1
 */