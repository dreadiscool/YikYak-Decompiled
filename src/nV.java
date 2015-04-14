import android.net.Uri;
import java.io.UnsupportedEncodingException;
import java.net.URLDecoder;

class nV
{
  private static nV a;
  private volatile nW b;
  private volatile String c;
  private volatile String d;
  private volatile String e;
  
  nV()
  {
    e();
  }
  
  private String a(String paramString)
  {
    return paramString.split("&")[0].split("=")[1];
  }
  
  static nV a()
  {
    try
    {
      if (a == null) {
        a = new nV();
      }
      nV localnV = a;
      return localnV;
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
      nK.d("Container preview url: " + str);
      if (!str.matches(".*?&gtm_debug=x$")) {
        break label143;
      }
      this.b = nW.c;
    }
    catch (UnsupportedEncodingException localUnsupportedEncodingException)
    {
      for (;;)
      {
        bool = false;
        continue;
        this.b = nW.b;
      }
    }
    finally {}
    this.e = b(paramUri);
    if ((this.b == nW.b) || (this.b == nW.c)) {
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
          nK.d("Exit preview mode for container: " + this.c);
          this.b = nW.a;
          this.d = null;
        }
      }
      else
      {
        nK.b("Invalid preview uri: " + str);
        bool = false;
        continue;
      }
      bool = false;
    }
  }
  
  nW b()
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
    this.b = nW.a;
    this.d = null;
    this.c = null;
    this.e = null;
  }
}


/* Location:           C:\Users\dreadiscool\Desktop\tools\classes-dex2jar.jar
 * Qualified Name:     nV
 * JD-Core Version:    0.7.0.1
 */