import com.yik.yak.ui.activity.SendAYak;
import org.json.JSONException;
import org.json.JSONObject;

public class Eh
  implements Cj
{
  public Eh(SendAYak paramSendAYak) {}
  
  public void a(zF paramzF, Object paramObject)
  {
    JSONObject localJSONObject = (JSONObject)paramObject;
    try
    {
      str = localJSONObject.getString("status_message");
      i = -1;
      switch (str.hashCode())
      {
      }
    }
    catch (JSONException localJSONException)
    {
      for (;;)
      {
        String str;
        int i;
        localJSONException.printStackTrace();
        continue;
        if (str.equals("Not Whitelisted"))
        {
          i = 0;
          continue;
          if (str.equals("success"))
          {
            i = 1;
            continue;
            SendAYak.j(this.a);
            continue;
            SendAYak.k(this.a);
          }
        }
      }
    }
    switch (i)
    {
    default: 
      SendAYak.b(this.a, false);
      return;
    }
  }
  
  public void a(zz paramzz, Exception paramException)
  {
    paramException.printStackTrace();
    SendAYak.b(this.a, false);
  }
}


/* Location:           C:\Users\dreadiscool\Desktop\tools\classes-dex2jar.jar
 * Qualified Name:     Eh
 * JD-Core Version:    0.7.0.1
 */