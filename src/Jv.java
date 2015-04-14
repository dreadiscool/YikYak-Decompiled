import android.content.Context;
import android.content.pm.PackageManager;

class Jv
  implements IT<String>
{
  Jv(Ju paramJu) {}
  
  public String a(Context paramContext)
  {
    String str = paramContext.getPackageManager().getInstallerPackageName(paramContext.getPackageName());
    if (str == null) {
      str = "";
    }
    return str;
  }
}


/* Location:           C:\Users\dreadiscool\Desktop\tools\classes-dex2jar.jar
 * Qualified Name:     Jv
 * JD-Core Version:    0.7.0.1
 */