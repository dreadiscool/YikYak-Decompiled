import android.widget.ListView;
import java.util.ArrayList;
import java.util.List;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

class Gi
  implements Runnable
{
  Gi(Gh paramGh, JSONObject paramJSONObject) {}
  
  public void run()
  {
    Gd.a(this.b.c, true);
    try
    {
      Gd.a(this.b.c, 0);
      Gd.a(this.b.c, new ArrayList());
      JSONArray localJSONArray = this.a.getJSONArray("data");
      i = 0;
      if (i < localJSONArray.length())
      {
        JSONObject localJSONObject = localJSONArray.getJSONObject(i);
        if (!localJSONObject.has("_id")) {
          break label628;
        }
        str1 = localJSONObject.getString("_id");
        if (!localJSONObject.has("key")) {
          break label635;
        }
        str2 = localJSONObject.getString("key");
        if (!localJSONObject.has("thingID")) {
          break label642;
        }
        str3 = localJSONObject.getString("thingID");
        if (!localJSONObject.has("thingType")) {
          break label649;
        }
        str4 = localJSONObject.getString("thingType");
        if (!localJSONObject.has("priority")) {
          break label656;
        }
        str5 = localJSONObject.getString("priority");
        if (!localJSONObject.has("userID")) {
          break label663;
        }
        str6 = localJSONObject.getString("userID");
        if (!localJSONObject.has("reason")) {
          break label670;
        }
        str7 = localJSONObject.getString("reason");
        if (!localJSONObject.has("body")) {
          break label677;
        }
        str8 = localJSONObject.getString("body");
        if (!localJSONObject.has("updated")) {
          break label684;
        }
        str9 = localJSONObject.getString("updated");
        if (!localJSONObject.has("status")) {
          break label691;
        }
        str10 = localJSONObject.getString("status");
        if (!localJSONObject.has("subject")) {
          break label698;
        }
        str11 = localJSONObject.getString("subject");
        if (!localJSONObject.has("content")) {
          break label705;
        }
        str12 = localJSONObject.getString("content");
        Cu localCu = new Cu(str1, str2, str3, str4, str5, str6, str7, str8, str9, str10, str11, str12);
        if ((localCu.i().equals("new")) || (localCu.i().equals("unread")) || (!BV.k()))
        {
          if (localCu.i().equals("new")) {
            Gd.e(this.b.c);
          }
          Gd.a(this.b.c).add(localCu);
        }
      }
      else
      {
        if (Gd.a(this.b.c).size() == 0) {
          Gd.f(this.b.c);
        }
        Gd.a(this.b.c, new EH(Gd.c(this.b.c), 2130903127, Gd.a(this.b.c)));
        Gd.h(this.b.c).setAdapter(Gd.g(this.b.c));
        if (Gd.i(this.b.c) == Gn.c)
        {
          if (Gd.a(this.b.c).size() == 0) {
            this.b.c.a(Gn.b, false);
          }
        }
        else
        {
          Gd.b(this.b.c, Gd.j(this.b.c));
          return;
        }
      }
    }
    catch (JSONException localJSONException)
    {
      for (;;)
      {
        int i;
        String str1;
        String str2;
        String str3;
        String str4;
        String str5;
        String str6;
        String str7;
        String str8;
        String str9;
        String str10;
        String str11;
        String str12;
        if (Gd.a(this.b.c).size() == 0)
        {
          Gd.f(this.b.c);
          continue;
          this.b.c.a(Gn.a, false);
          continue;
          i++;
          continue;
          label628:
          str1 = "";
          continue;
          label635:
          str2 = "";
          continue;
          label642:
          str3 = "";
          continue;
          label649:
          str4 = "";
          continue;
          label656:
          str5 = "";
          continue;
          label663:
          str6 = "";
          continue;
          label670:
          str7 = "";
          continue;
          label677:
          str8 = "";
          continue;
          label684:
          str9 = "";
          continue;
          label691:
          str10 = "";
          continue;
          label698:
          str11 = "";
          continue;
          label705:
          str12 = "";
        }
      }
    }
  }
}


/* Location:           C:\Users\dreadiscool\Desktop\tools\classes-dex2jar.jar
 * Qualified Name:     Gi
 * JD-Core Version:    0.7.0.1
 */