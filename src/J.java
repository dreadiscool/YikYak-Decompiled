import java.io.File;
import java.util.concurrent.Callable;

class J
  implements Callable<Boolean>
{
  J(G paramG) {}
  
  public Boolean a()
  {
    try
    {
      boolean bool = G.a(this.a).delete();
      IC.g();
      new StringBuilder().append("Initialization marker file removed: ").append(bool).toString();
      Boolean localBoolean2 = Boolean.valueOf(bool);
      localBoolean1 = localBoolean2;
    }
    catch (Exception localException)
    {
      for (;;)
      {
        IC.g();
        Boolean localBoolean1 = Boolean.valueOf(false);
      }
    }
    return localBoolean1;
  }
}


/* Location:           C:\Users\dreadiscool\Desktop\tools\classes-dex2jar.jar
 * Qualified Name:     J
 * JD-Core Version:    0.7.0.1
 */