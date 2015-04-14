final class qG
  extends pm<Class>
{
  public Class a(ro paramro)
  {
    if (paramro.f() == rq.i)
    {
      paramro.j();
      return null;
    }
    throw new UnsupportedOperationException("Attempted to deserialize a java.lang.Class. Forgot to register a type adapter?");
  }
  
  public void a(rr paramrr, Class paramClass)
  {
    if (paramClass == null)
    {
      paramrr.f();
      return;
    }
    throw new UnsupportedOperationException("Attempted to serialize java.lang.Class: " + paramClass.getName() + ". Forgot to register a type adapter?");
  }
}


/* Location:           C:\Users\dreadiscool\Desktop\tools\classes-dex2jar.jar
 * Qualified Name:     qG
 * JD-Core Version:    0.7.0.1
 */