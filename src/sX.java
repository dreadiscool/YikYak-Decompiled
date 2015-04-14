import java.util.List;

public class sX
  extends RuntimeException
{
  private final List<String> a = null;
  
  public sX(sE paramsE)
  {
    super("Message was missing required fields.  (Lite runtime could not determine which fields were missing).");
  }
  
  public sx a()
  {
    return new sx(getMessage());
  }
}


/* Location:           C:\Users\dreadiscool\Desktop\tools\classes-dex2jar.jar
 * Qualified Name:     sX
 * JD-Core Version:    0.7.0.1
 */