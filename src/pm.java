import java.io.IOException;

public abstract class pm<T>
{
  public final pb a(T paramT)
  {
    try
    {
      qp localqp = new qp();
      a(localqp, paramT);
      pb localpb = localqp.a();
      return localpb;
    }
    catch (IOException localIOException)
    {
      throw new pc(localIOException);
    }
  }
  
  public abstract void a(rr paramrr, T paramT);
  
  public abstract T b(ro paramro);
}


/* Location:           C:\Users\dreadiscool\Desktop\tools\classes-dex2jar.jar
 * Qualified Name:     pm
 * JD-Core Version:    0.7.0.1
 */