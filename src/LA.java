import java.io.OutputStream;

class LA
  extends OutputStream
{
  LA(Lz paramLz) {}
  
  public void close() {}
  
  public void flush() {}
  
  public String toString()
  {
    return this + ".outputStream()";
  }
  
  public void write(int paramInt)
  {
    this.a.a((byte)paramInt);
  }
  
  public void write(byte[] paramArrayOfByte, int paramInt1, int paramInt2)
  {
    this.a.b(paramArrayOfByte, paramInt1, paramInt2);
  }
}


/* Location:           C:\Users\dreadiscool\Desktop\tools\classes-dex2jar.jar
 * Qualified Name:     LA
 * JD-Core Version:    0.7.0.1
 */