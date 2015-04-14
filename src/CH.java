import android.content.Context;
import android.content.res.Resources;
import java.io.IOException;
import java.io.InputStream;
import java.util.ArrayList;
import java.util.List;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

public class CH
{
  public String a;
  public String b;
  public String c;
  public String d;
  
  public CH() {}
  
  public CH(String paramString1, String paramString2, String paramString3, String paramString4)
  {
    this.a = paramString1;
    this.b = paramString2;
    this.c = paramString3;
    this.d = paramString4;
  }
  
  private JSONObject b(String paramString)
  {
    try
    {
      localJSONObject = new JSONObject(paramString);
      return localJSONObject;
    }
    catch (JSONException localJSONException)
    {
      for (;;)
      {
        JSONObject localJSONObject = new JSONObject();
      }
    }
  }
  
  public List<CH> a(Context paramContext, CI paramCI)
  {
    InputStream localInputStream = null;
    if (paramCI == CI.a) {
      localInputStream = paramContext.getResources().openRawResource(2131165185);
    }
    for (;;)
    {
      arrayOfByte1 = new byte[1];
      try
      {
        arrayOfByte1 = new byte[localInputStream.available()];
        localInputStream.read(arrayOfByte1);
        localInputStream.close();
        arrayOfByte2 = arrayOfByte1;
      }
      catch (IOException localIOException)
      {
        for (;;)
        {
          List localList;
          arrayOfByte2 = arrayOfByte1;
          localIOException.printStackTrace();
        }
      }
      catch (NullPointerException localNullPointerException)
      {
        for (;;)
        {
          byte[] arrayOfByte2 = arrayOfByte1;
        }
      }
      localList = a(new String(arrayOfByte2));
      return localList;
      if (paramCI == CI.b) {
        localInputStream = paramContext.getResources().openRawResource(2131165186);
      }
    }
  }
  
  public List<CH> a(String paramString)
  {
    ArrayList localArrayList = new ArrayList();
    for (;;)
    {
      int i;
      String str4;
      try
      {
        if (!Ik.a(paramString))
        {
          JSONArray localJSONArray = b(paramString).getJSONArray("ListItems");
          i = 0;
          if (i < localJSONArray.length())
          {
            JSONObject localJSONObject = localJSONArray.getJSONObject(i);
            String str1 = localJSONObject.getString("section");
            if (str1.equals("MyDrafts"))
            {
              if (CR.a("drafts", "enabled", false))
              {
                String str5 = localJSONObject.getString("item");
                String str6 = localJSONObject.getString("index");
                if (!localJSONObject.has("url")) {
                  break label274;
                }
                str7 = localJSONObject.getString("url");
                localArrayList.add(new CH(str1, str5, str6, str7));
              }
            }
            else
            {
              String str2 = localJSONObject.getString("item");
              String str3 = localJSONObject.getString("index");
              if (localJSONObject.has("url"))
              {
                str4 = localJSONObject.getString("url");
                localArrayList.add(new CH(str1, str2, str3, str4));
              }
            }
          }
        }
      }
      catch (JSONException localJSONException)
      {
        localArrayList = new ArrayList();
        localArrayList.add(new CH("My Yaks", "My Yaks", "", ""));
      }
      for (;;)
      {
        return localArrayList;
        str4 = "";
        break;
        localArrayList.add(new CH("My Yaks", "My Yaks", "", ""));
      }
      i++;
      continue;
      label274:
      String str7 = "";
    }
  }
  
  public boolean a()
  {
    return this.b.equals(this.a);
  }
}


/* Location:           C:\Users\dreadiscool\Desktop\tools\classes-dex2jar.jar
 * Qualified Name:     CH
 * JD-Core Version:    0.7.0.1
 */