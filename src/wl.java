import java.io.OutputStream;
import java.nio.ByteBuffer;

class wl
  extends OutputStream
{
  private wl(wg paramwg) {}
  
  public void close()
  {
    try
    {
      wg.c(this.a).a(tR.b, wg.c(), true);
      return;
    }
    catch (tM localtM)
    {
      throw new wk(this.a, localtM);
    }
    catch (tL localtL)
    {
      throw new wk(this.a, localtL);
    }
  }
  
  public void write(int paramInt)
  {
    byte[] arrayOfByte = new byte[1];
    arrayOfByte[0] = ((byte)paramInt);
    write(arrayOfByte, 0, 1);
  }
  
  public void write(byte[] paramArrayOfByte)
  {
    write(paramArrayOfByte, 0, paramArrayOfByte.length);
  }
  
  public void write(byte[] paramArrayOfByte, int paramInt1, int paramInt2)
  {
    ByteBuffer localByteBuffer = ByteBuffer.wrap(paramArrayOfByte, paramInt1, paramInt2);
    try
    {
      wg.c(this.a).a(tR.b, localByteBuffer, false);
      return;
    }
    catch (tM localtM)
    {
      throw new wk(this.a, localtM);
    }
    catch (tL localtL)
    {
      throw new wk(this.a, localtL);
    }
  }
}


/* Location:           C:\Users\dreadiscool\Desktop\tools\classes-dex2jar.jar
 * Qualified Name:     wl
 * JD-Core Version:    0.7.0.1
 */