import java.io.Writer;

final class qq
  extends Writer
{
  public void close()
  {
    throw new AssertionError();
  }
  
  public void flush()
  {
    throw new AssertionError();
  }
  
  public void write(char[] paramArrayOfChar, int paramInt1, int paramInt2)
  {
    throw new AssertionError();
  }
}


/* Location:           C:\Users\dreadiscool\Desktop\tools\classes-dex2jar.jar
 * Qualified Name:     qq
 * JD-Core Version:    0.7.0.1
 */