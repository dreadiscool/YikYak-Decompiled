import org.json.JSONObject;

final class CT
  implements Cj
{
  public void a(zF paramzF, Object paramObject)
  {
    CR.c((JSONObject)paramObject);
    Object[] arrayOfObject = new Object[1];
    arrayOfObject[0] = "initializeThreatWords() request succeeded.";
    Iq.a(CR.class, arrayOfObject);
  }
  
  public void a(zz paramzz, Exception paramException)
  {
    CR.d(CR.a("threatwords"));
    paramException.printStackTrace();
    Object[] arrayOfObject = new Object[1];
    arrayOfObject[0] = "initializeThreatWords() request failed.";
    Iq.b(CR.class, arrayOfObject);
  }
}


/* Location:           C:\Users\dreadiscool\Desktop\tools\classes-dex2jar.jar
 * Qualified Name:     CT
 * JD-Core Version:    0.7.0.1
 */