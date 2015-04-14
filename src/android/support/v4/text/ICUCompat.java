package android.support.v4.text;

import android.os.Build.VERSION;

public class ICUCompat
{
  private static final ICUCompat.ICUCompatImpl IMPL;
  
  static
  {
    if (Build.VERSION.SDK_INT >= 14) {}
    for (IMPL = new ICUCompat.ICUCompatImplIcs();; IMPL = new ICUCompat.ICUCompatImplBase()) {
      return;
    }
  }
  
  public static String addLikelySubtags(String paramString)
  {
    return IMPL.addLikelySubtags(paramString);
  }
  
  public static String getScript(String paramString)
  {
    return IMPL.getScript(paramString);
  }
}


/* Location:           C:\Users\dreadiscool\Desktop\tools\classes-dex2jar.jar
 * Qualified Name:     android.support.v4.text.ICUCompat
 * JD-Core Version:    0.7.0.1
 */