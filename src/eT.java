import android.content.Context;
import android.content.res.Resources;
import android.text.TextUtils;

class eT
  implements eS
{
  private final Context a;
  private String b;
  
  public eT(Context paramContext)
  {
    if (paramContext == null) {
      throw new NullPointerException("Context cannot be null");
    }
    this.a = paramContext.getApplicationContext();
  }
  
  private int a(String paramString1, String paramString2)
  {
    int i;
    if (this.a == null)
    {
      i = 0;
      return i;
    }
    if (this.b != null) {}
    for (String str = this.b;; str = this.a.getPackageName())
    {
      i = this.a.getResources().getIdentifier(paramString1, paramString2, str);
      break;
    }
  }
  
  public int a(String paramString, int paramInt)
  {
    int i = a(paramString, "integer");
    if (i == 0) {}
    for (;;)
    {
      return paramInt;
      try
      {
        int j = Integer.parseInt(this.a.getString(i));
        paramInt = j;
      }
      catch (NumberFormatException localNumberFormatException)
      {
        eO.d("NumberFormatException parsing " + this.a.getString(i));
      }
    }
  }
  
  public String a(String paramString)
  {
    int i = a(paramString, "string");
    if (i == 0) {}
    for (String str = null;; str = this.a.getString(i)) {
      return str;
    }
  }
  
  public Double b(String paramString)
  {
    Object localObject = null;
    String str = a(paramString);
    if (TextUtils.isEmpty(str)) {}
    for (;;)
    {
      return localObject;
      try
      {
        Double localDouble = Double.valueOf(Double.parseDouble(str));
        localObject = localDouble;
      }
      catch (NumberFormatException localNumberFormatException)
      {
        eO.d("NumberFormatException parsing " + str);
      }
    }
  }
  
  public boolean c(String paramString)
  {
    int i = a(paramString, "bool");
    if (i == 0) {}
    for (boolean bool = false;; bool = "true".equalsIgnoreCase(this.a.getString(i))) {
      return bool;
    }
  }
  
  public void d(String paramString)
  {
    this.b = paramString;
  }
}


/* Location:           C:\Users\dreadiscool\Desktop\tools\classes-dex2jar.jar
 * Qualified Name:     eT
 * JD-Core Version:    0.7.0.1
 */