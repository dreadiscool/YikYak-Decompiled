import android.net.Uri;
import java.io.UnsupportedEncodingException;
import java.net.URLDecoder;

class rF
{
  private static rF a;
  private volatile rG b;
  private volatile String c;
  private volatile String d;
  private volatile String e;
  
  rF()
  {
    e();
  }
  
  private String a(String paramString)
  {
    return paramString.split("&")[0].split("=")[1];
  }
  
  static rF a()
  {
    try
    {
      if (a == null) {
        a = new rF();
      }
      rF localrF = a;
      return localrF;
    }
    finally
    {
      localObject = finally;
      throw localObject;
    }
  }
  
  private String b(Uri paramUri)
  {
    return paramUri.getQuery().replace("&gtm_debug=x", "");
  }
  
  boolean a(Uri paramUri)
  {
    boolean bool = true;
    String str;
    try
    {
      str = URLDecoder.decode(paramUri.toString(), "UTF-8");
      if (!str.matches("^tagmanager.c.\\S+:\\/\\/preview\\/p\\?id=\\S+&gtm_auth=\\S+&gtm_preview=\\d+(&gtm_debug=x)?$")) {
        break label158;
      }
      rB.d("Container preview url: " + str);
      if (!str.matches(".*?&gtm_debug=x$")) {
        break label143;
      }
      this.b = rG.c;
    }
    catch (UnsupportedEncodingException localUnsupportedEncodingException)
    {
      for (;;)
      {
        bool = false;
        continue;
        this.b = rG.b;
      }
    }
    finally {}
    this.e = b(paramUri);
    if ((this.b == rG.b) || (this.b == rG.c)) {
      this.d = ("/r?" + this.e);
    }
    this.c = a(this.e);
    for (;;)
    {
      return bool;
      label143:
      label158:
      if (str.matches("^tagmanager.c.\\S+:\\/\\/preview\\/p\\?id=\\S+&gtm_preview=$"))
      {
        if (a(paramUri.getQuery()).equals(this.c))
        {
          rB.d("Exit preview mode for container: " + this.c);
          this.b = rG.a;
          this.d = null;
        }
      }
      else
      {
        rB.b("Invalid preview uri: " + str);
        bool = false;
        continue;
      }
      bool = false;
    }
  }
  
  rG b()
  {
    return this.b;
  }
  
  String c()
  {
    return this.d;
  }
  
  String d()
  {
    return this.c;
  }
  
  void e()
  {
    this.b = rG.a;
    this.d = null;
    this.c = null;
    this.e = null;
  }
}


/* Location:           C:\Users\dreadiscool\Desktop\tools\classes-dex2jar.jar
 * Qualified Name:     rF
 * JD-Core Version:    0.7.0.1
 */