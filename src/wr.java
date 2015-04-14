import org.json.JSONException;
import org.json.JSONObject;

public class wr
{
  public final int a;
  public final String b;
  public final int c;
  public final int d;
  public final String e;
  public final String f;
  
  public wr(int paramInt1, String paramString1, int paramInt2, int paramInt3, String paramString2, String paramString3)
  {
    this.a = paramInt1;
    this.b = paramString1;
    this.c = paramInt2;
    this.d = paramInt3;
    this.e = paramString2;
    this.f = paramString3;
  }
  
  public String toString()
  {
    try
    {
      JSONObject localJSONObject = new JSONObject();
      if (this.a == 1) {
        localJSONObject.put("prefix", "shortest");
      }
      if (this.b != null) {
        localJSONObject.put("view_class", this.b);
      }
      if (this.c > -1) {
        localJSONObject.put("index", this.c);
      }
      if (this.d > -1) {
        localJSONObject.put("id", this.d);
      }
      if (this.e != null) {
        localJSONObject.put("contentDescription", this.e);
      }
      if (this.f != null) {
        localJSONObject.put("tag", this.f);
      }
      String str = localJSONObject.toString();
      return str;
    }
    catch (JSONException localJSONException)
    {
      throw new RuntimeException("Can't serialize PathElement to String", localJSONException);
    }
  }
}


/* Location:           C:\Users\dreadiscool\Desktop\tools\classes-dex2jar.jar
 * Qualified Name:     wr
 * JD-Core Version:    0.7.0.1
 */