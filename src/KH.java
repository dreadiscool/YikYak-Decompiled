import java.io.IOException;

public class KH
  extends RuntimeException
{
  protected KH(IOException paramIOException)
  {
    super(paramIOException);
  }
  
  public IOException a()
  {
    return (IOException)super.getCause();
  }
}


/* Location:           C:\Users\dreadiscool\Desktop\tools\classes-dex2jar.jar
 * Qualified Name:     KH
 * JD-Core Version:    0.7.0.1
 */