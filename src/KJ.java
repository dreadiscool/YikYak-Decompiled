import java.io.BufferedOutputStream;
import java.io.OutputStream;
import java.nio.ByteBuffer;
import java.nio.CharBuffer;
import java.nio.charset.Charset;
import java.nio.charset.CharsetEncoder;

public class KJ
  extends BufferedOutputStream
{
  private final CharsetEncoder a;
  
  public KJ(OutputStream paramOutputStream, String paramString, int paramInt)
  {
    super(paramOutputStream, paramInt);
    this.a = Charset.forName(KC.e(paramString)).newEncoder();
  }
  
  public KJ a(String paramString)
  {
    ByteBuffer localByteBuffer = this.a.encode(CharBuffer.wrap(paramString));
    super.write(localByteBuffer.array(), 0, localByteBuffer.limit());
    return this;
  }
}


/* Location:           C:\Users\dreadiscool\Desktop\tools\classes-dex2jar.jar
 * Qualified Name:     KJ
 * JD-Core Version:    0.7.0.1
 */