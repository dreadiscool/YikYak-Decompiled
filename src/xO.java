import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;

class xO
  extends xM
{
  xr h;
  float i;
  private xX j;
  
  public xO(String paramString, float... paramVarArgs)
  {
    super(paramString, null);
    a(paramVarArgs);
  }
  
  public xO(xZ paramxZ, float... paramVarArgs)
  {
    super(paramxZ, null);
    a(paramVarArgs);
    if ((paramxZ instanceof xX)) {
      this.j = ((xX)this.b);
    }
  }
  
  void a(float paramFloat)
  {
    this.i = this.h.b(paramFloat);
  }
  
  void a(Class paramClass)
  {
    if (this.b != null) {}
    for (;;)
    {
      return;
      super.a(paramClass);
    }
  }
  
  public void a(float... paramVarArgs)
  {
    super.a(paramVarArgs);
    this.h = ((xr)this.e);
  }
  
  void b(Object paramObject)
  {
    if (this.j != null) {
      this.j.a(paramObject, this.i);
    }
    for (;;)
    {
      return;
      if (this.b != null) {
        this.b.a(paramObject, Float.valueOf(this.i));
      } else if (this.c != null) {
        try
        {
          this.g[0] = Float.valueOf(this.i);
          this.c.invoke(paramObject, this.g);
        }
        catch (InvocationTargetException localInvocationTargetException)
        {
          localInvocationTargetException.toString();
        }
        catch (IllegalAccessException localIllegalAccessException)
        {
          localIllegalAccessException.toString();
        }
      }
    }
  }
  
  Object d()
  {
    return Float.valueOf(this.i);
  }
  
  public xO e()
  {
    xO localxO = (xO)super.a();
    localxO.h = ((xr)localxO.e);
    return localxO;
  }
}


/* Location:           C:\Users\dreadiscool\Desktop\tools\classes-dex2jar.jar
 * Qualified Name:     xO
 * JD-Core Version:    0.7.0.1
 */