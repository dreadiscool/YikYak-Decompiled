import java.io.Closeable;
import java.io.InputStream;
import java.io.OutputStream;

class KD
  extends KE<KC>
{
  KD(KC paramKC, Closeable paramCloseable, boolean paramBoolean, InputStream paramInputStream, OutputStream paramOutputStream)
  {
    super(paramCloseable, paramBoolean);
  }
  
  public KC a()
  {
    byte[] arrayOfByte = new byte[KC.a(this.c)];
    for (;;)
    {
      int i = this.a.read(arrayOfByte);
      if (i == -1) {
        break;
      }
      this.b.write(arrayOfByte, 0, i);
    }
    return this.c;
  }
}


/* Location:           C:\Users\dreadiscool\Desktop\tools\classes-dex2jar.jar
 * Qualified Name:     KD
 * JD-Core Version:    0.7.0.1
 */