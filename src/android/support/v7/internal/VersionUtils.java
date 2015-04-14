package android.support.v7.internal;

import android.os.Build.VERSION;

public class VersionUtils
{
  public static boolean isAtLeastL()
  {
    if (Build.VERSION.SDK_INT >= 21) {}
    for (boolean bool = true;; bool = false) {
      return bool;
    }
  }
}


/* Location:           C:\Users\dreadiscool\Desktop\tools\classes-dex2jar.jar
 * Qualified Name:     android.support.v7.internal.VersionUtils
 * JD-Core Version:    0.7.0.1
 */