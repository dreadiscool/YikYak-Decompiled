import java.io.InputStream;

final class av
  implements JA
{
  av(byte[] paramArrayOfByte, int[] paramArrayOfInt) {}
  
  public void a(InputStream paramInputStream, int paramInt)
  {
    try
    {
      paramInputStream.read(this.a, this.b[0], paramInt);
      int[] arrayOfInt = this.b;
      arrayOfInt[0] = (paramInt + arrayOfInt[0]);
      return;
    }
    finally
    {
      paramInputStream.close();
    }
  }
}


/* Location:           C:\Users\dreadiscool\Desktop\tools\classes-dex2jar.jar
 * Qualified Name:     av
 * JD-Core Version:    0.7.0.1
 */