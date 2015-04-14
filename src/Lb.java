import android.annotation.SuppressLint;
import android.content.SharedPreferences;
import android.content.SharedPreferences.Editor;
import org.json.JSONObject;

class Lb
  implements Ln
{
  private final Lr a;
  private final Lq b;
  private final Jl c;
  private final KY d;
  private final Ls e;
  private final IM f;
  private final KQ g;
  
  public Lb(IM paramIM, Lr paramLr, Jl paramJl, Lq paramLq, KY paramKY, Ls paramLs)
  {
    this.f = paramIM;
    this.a = paramLr;
    this.c = paramJl;
    this.b = paramLq;
    this.d = paramKY;
    this.e = paramLs;
    this.g = new KR(this.f);
  }
  
  private void a(JSONObject paramJSONObject, String paramString)
  {
    if (!Jg.e(this.f.C())) {
      paramJSONObject = this.b.a(paramJSONObject);
    }
    IC.g();
    new StringBuilder().append(paramString).append(paramJSONObject.toString()).toString();
  }
  
  private Lo b(Lm paramLm)
  {
    localObject = null;
    for (;;)
    {
      try
      {
        if (!Lm.b.equals(paramLm))
        {
          JSONObject localJSONObject = this.d.a();
          if (localJSONObject == null) {
            break label124;
          }
          localLo = this.b.a(this.c, localJSONObject);
          if (localLo == null) {
            break label117;
          }
          a(localJSONObject, "Loaded cached settings: ");
          long l = this.c.a();
          if (!Lm.c.equals(paramLm))
          {
            boolean bool = localLo.a(l);
            if (bool) {
              continue;
            }
          }
        }
      }
      catch (Exception localException1) {}
      try
      {
        IC.g();
        localObject = localLo;
        return localObject;
      }
      catch (Exception localException2)
      {
        for (;;)
        {
          localObject = localLo;
        }
      }
      IC.g();
      continue;
      IC.g();
      continue;
      label117:
      IC.g();
      continue;
      label124:
      IC.g();
    }
  }
  
  public Lo a()
  {
    return a(Lm.a);
  }
  
  public Lo a(Lm paramLm)
  {
    Object localObject = null;
    try
    {
      if ((!IC.h()) && (!d())) {
        localObject = b(paramLm);
      }
      if (localObject == null)
      {
        JSONObject localJSONObject = this.e.a(this.a);
        if (localJSONObject != null)
        {
          localObject = this.b.a(this.c, localJSONObject);
          this.d.a(((Lo)localObject).g, localJSONObject);
          a(localJSONObject, "Loaded settings: ");
          a(b());
        }
      }
      if (localObject == null)
      {
        Lo localLo = b(Lm.c);
        localObject = localLo;
      }
    }
    catch (Exception localException)
    {
      for (;;)
      {
        IC.g();
      }
    }
    return localObject;
  }
  
  @SuppressLint({"CommitPrefEdits"})
  boolean a(String paramString)
  {
    SharedPreferences.Editor localEditor = this.g.b();
    localEditor.putString("existing_instance_identifier", paramString);
    return this.g.a(localEditor);
  }
  
  String b()
  {
    String[] arrayOfString = new String[1];
    arrayOfString[0] = Jg.m(this.f.C());
    return Jg.a(arrayOfString);
  }
  
  String c()
  {
    return this.g.a().getString("existing_instance_identifier", "");
  }
  
  boolean d()
  {
    if (!c().equals(b())) {}
    for (boolean bool = true;; bool = false) {
      return bool;
    }
  }
}


/* Location:           C:\Users\dreadiscool\Desktop\tools\classes-dex2jar.jar
 * Qualified Name:     Lb
 * JD-Core Version:    0.7.0.1
 */