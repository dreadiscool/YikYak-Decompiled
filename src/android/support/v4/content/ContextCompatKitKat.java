package android.support.v4.content;

import android.content.Context;
import java.io.File;

class ContextCompatKitKat
{
  public static File[] getExternalCacheDirs(Context paramContext)
  {
    return paramContext.getExternalCacheDirs();
  }
  
  public static File[] getExternalFilesDirs(Context paramContext, String paramString)
  {
    return paramContext.getExternalFilesDirs(paramString);
  }
  
  public static File[] getObbDirs(Context paramContext)
  {
    return paramContext.getObbDirs();
  }
}


/* Location:           C:\Users\dreadiscool\Desktop\tools\classes-dex2jar.jar
 * Qualified Name:     android.support.v4.content.ContextCompatKitKat
 * JD-Core Version:    0.7.0.1
 */