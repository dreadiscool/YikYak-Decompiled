import com.mixpanel.android.mpmetrics.Survey;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import org.json.JSONArray;
import org.json.JSONObject;

public class vm
{
  private final int b;
  private final String c;
  private final String d;
  private final List<String> e;
  
  private vm(Survey paramSurvey, JSONObject paramJSONObject)
  {
    this.b = paramJSONObject.getInt("id");
    this.c = paramJSONObject.getString("type");
    this.d = paramJSONObject.getString("prompt");
    Object localObject = Collections.emptyList();
    if (paramJSONObject.has("extra_data"))
    {
      JSONObject localJSONObject = paramJSONObject.getJSONObject("extra_data");
      if (localJSONObject.has("$choices"))
      {
        JSONArray localJSONArray = localJSONObject.getJSONArray("$choices");
        ArrayList localArrayList = new ArrayList(localJSONArray.length());
        for (int i = 0; i < localJSONArray.length(); i++) {
          localArrayList.add(localJSONArray.getString(i));
        }
        localObject = localArrayList;
      }
    }
    this.e = Collections.unmodifiableList((List)localObject);
    if ((d() == vn.b) && (this.e.size() == 0)) {
      throw new uo("Question is multiple choice but has no answers:" + paramJSONObject.toString());
    }
  }
  
  public int a()
  {
    return this.b;
  }
  
  public String b()
  {
    return this.d;
  }
  
  public List<String> c()
  {
    return this.e;
  }
  
  public vn d()
  {
    vn localvn;
    if (vn.b.toString().equals(this.c)) {
      localvn = vn.b;
    }
    for (;;)
    {
      return localvn;
      if (vn.c.toString().equals(this.c)) {
        localvn = vn.c;
      } else {
        localvn = vn.a;
      }
    }
  }
}


/* Location:           C:\Users\dreadiscool\Desktop\tools\classes-dex2jar.jar
 * Qualified Name:     vm
 * JD-Core Version:    0.7.0.1
 */