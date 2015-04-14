import java.io.File;
import java.util.concurrent.Callable;

class K
  implements Callable<Boolean>
{
  K(G paramG) {}
  
  public Boolean a()
  {
    return Boolean.valueOf(G.a(this.a).exists());
  }
}


/* Location:           C:\Users\dreadiscool\Desktop\tools\classes-dex2jar.jar
 * Qualified Name:     K
 * JD-Core Version:    0.7.0.1
 */