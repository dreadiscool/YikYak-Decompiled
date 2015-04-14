import java.net.Socket;
import java.util.logging.Level;
import java.util.logging.Logger;

final class LN
  extends Lu
{
  LN(Socket paramSocket) {}
  
  protected void a()
  {
    try
    {
      this.a.close();
      return;
    }
    catch (Exception localException)
    {
      for (;;)
      {
        LK.a().log(Level.WARNING, "Failed to close timed out socket " + this.a, localException);
      }
    }
  }
}


/* Location:           C:\Users\dreadiscool\Desktop\tools\classes-dex2jar.jar
 * Qualified Name:     LN
 * JD-Core Version:    0.7.0.1
 */