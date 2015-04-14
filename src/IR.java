import android.content.Context;

public class IR<T>
  extends IQ<T>
{
  private T a;
  
  public IR()
  {
    this(null);
  }
  
  public IR(IS<T> paramIS)
  {
    super(paramIS);
  }
  
  protected T a(Context paramContext)
  {
    return this.a;
  }
  
  protected void a(Context paramContext, T paramT)
  {
    this.a = paramT;
  }
}


/* Location:           C:\Users\dreadiscool\Desktop\tools\classes-dex2jar.jar
 * Qualified Name:     IR
 * JD-Core Version:    0.7.0.1
 */