import java.io.IOException;

class BB
  extends zU
{
  BB(BA paramBA, String paramString, Object[] paramArrayOfObject, BD paramVarArgs)
  {
    super(paramString, paramArrayOfObject);
  }
  
  public void b()
  {
    try
    {
      Br.f(this.c.c).a(this.a);
      return;
    }
    catch (IOException localIOException)
    {
      throw new RuntimeException(localIOException);
    }
  }
}


/* Location:           C:\Users\dreadiscool\Desktop\tools\classes-dex2jar.jar
 * Qualified Name:     BB
 * JD-Core Version:    0.7.0.1
 */