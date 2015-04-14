import java.io.InputStream;
import java.io.RandomAccessFile;

final class Jz
  extends InputStream
{
  private int b;
  private int c;
  
  private Jz(Jw paramJw, Jy paramJy)
  {
    this.b = Jw.a(paramJw, 4 + paramJy.b);
    this.c = paramJy.c;
  }
  
  public int read()
  {
    int i;
    if (this.c == 0) {
      i = -1;
    }
    for (;;)
    {
      return i;
      Jw.a(this.a).seek(this.b);
      i = Jw.a(this.a).read();
      this.b = Jw.a(this.a, 1 + this.b);
      this.c = (-1 + this.c);
    }
  }
  
  public int read(byte[] paramArrayOfByte, int paramInt1, int paramInt2)
  {
    Jw.a(paramArrayOfByte, "buffer");
    if (((paramInt1 | paramInt2) < 0) || (paramInt2 > paramArrayOfByte.length - paramInt1)) {
      throw new ArrayIndexOutOfBoundsException();
    }
    if (this.c > 0)
    {
      if (paramInt2 > this.c) {
        paramInt2 = this.c;
      }
      Jw.a(this.a, this.b, paramArrayOfByte, paramInt1, paramInt2);
      this.b = Jw.a(this.a, paramInt2 + this.b);
      this.c -= paramInt2;
    }
    for (;;)
    {
      return paramInt2;
      paramInt2 = -1;
    }
  }
}


/* Location:           C:\Users\dreadiscool\Desktop\tools\classes-dex2jar.jar
 * Qualified Name:     Jz
 * JD-Core Version:    0.7.0.1
 */