import java.lang.reflect.Type;

class pB
  implements pW<T>
{
  private final qc d = qc.a();
  
  pB(px parampx, Class paramClass, Type paramType) {}
  
  public T a()
  {
    try
    {
      Object localObject = this.d.a(this.a);
      return localObject;
    }
    catch (Exception localException)
    {
      throw new RuntimeException("Unable to invoke no-args constructor for " + this.b + ". " + "Register an InstanceCreator with Gson for this type may fix this problem.", localException);
    }
  }
}


/* Location:           C:\Users\dreadiscool\Desktop\tools\classes-dex2jar.jar
 * Qualified Name:     pB
 * JD-Core Version:    0.7.0.1
 */