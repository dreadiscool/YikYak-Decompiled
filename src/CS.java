import org.json.JSONObject;

final class CS
  implements Cj
{
  public void a(zF paramzF, Object paramObject)
  {
    CR.b((JSONObject)paramObject);
    CR.a("configuration", CR.m().toString());
    CR.a(true);
    CR.i();
    Object[] arrayOfObject = new Object[1];
    arrayOfObject[0] = "initializeConfiguration() succeeded.";
    Iq.a(CR.class, arrayOfObject);
  }
  
  public void a(zz paramzz, Exception paramException)
  {
    CR.c(CR.a("configuration"));
    CR.a(true);
    CR.i();
    paramException.printStackTrace();
    Object[] arrayOfObject = new Object[1];
    arrayOfObject[0] = ("initializeConfiguration() failed: " + paramException.getMessage());
    Iq.b(CR.class, arrayOfObject);
  }
}


/* Location:           C:\Users\dreadiscool\Desktop\tools\classes-dex2jar.jar
 * Qualified Name:     CS
 * JD-Core Version:    0.7.0.1
 */