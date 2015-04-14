package android.support.v4.text;

import java.util.Locale;

public class TextUtilsCompat
{
  private static String ARAB_SCRIPT_SUBTAG = "Arab";
  private static String HEBR_SCRIPT_SUBTAG = "Hebr";
  public static final Locale ROOT = new Locale("", "");
  
  private static int getLayoutDirectionFromFirstChar(Locale paramLocale)
  {
    int i = 0;
    switch (Character.getDirectionality(paramLocale.getDisplayName(paramLocale).charAt(0)))
    {
    }
    for (;;)
    {
      return i;
      i = 1;
    }
  }
  
  public static int getLayoutDirectionFromLocale(Locale paramLocale)
  {
    String str;
    int i;
    if ((paramLocale != null) && (!paramLocale.equals(ROOT)))
    {
      str = ICUCompat.getScript(ICUCompat.addLikelySubtags(paramLocale.toString()));
      if (str == null) {
        i = getLayoutDirectionFromFirstChar(paramLocale);
      }
    }
    for (;;)
    {
      return i;
      if ((str.equalsIgnoreCase(ARAB_SCRIPT_SUBTAG)) || (str.equalsIgnoreCase(HEBR_SCRIPT_SUBTAG))) {
        i = 1;
      } else {
        i = 0;
      }
    }
  }
  
  public static String htmlEncode(String paramString)
  {
    StringBuilder localStringBuilder = new StringBuilder();
    int i = 0;
    if (i < paramString.length())
    {
      char c = paramString.charAt(i);
      switch (c)
      {
      default: 
        localStringBuilder.append(c);
      }
      for (;;)
      {
        i++;
        break;
        localStringBuilder.append("&lt;");
        continue;
        localStringBuilder.append("&gt;");
        continue;
        localStringBuilder.append("&amp;");
        continue;
        localStringBuilder.append("&#39;");
        continue;
        localStringBuilder.append("&quot;");
      }
    }
    return localStringBuilder.toString();
  }
}


/* Location:           C:\Users\dreadiscool\Desktop\tools\classes-dex2jar.jar
 * Qualified Name:     android.support.v4.text.TextUtilsCompat
 * JD-Core Version:    0.7.0.1
 */