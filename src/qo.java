import java.io.Reader;

final class qo
  extends Reader
{
  public void close()
  {
    throw new AssertionError();
  }
  
  public int read(char[] paramArrayOfChar, int paramInt1, int paramInt2)
  {
    throw new AssertionError();
  }
}


/* Location:           C:\Users\dreadiscool\Desktop\tools\classes-dex2jar.jar
 * Qualified Name:     qo
 * JD-Core Version:    0.7.0.1
 */