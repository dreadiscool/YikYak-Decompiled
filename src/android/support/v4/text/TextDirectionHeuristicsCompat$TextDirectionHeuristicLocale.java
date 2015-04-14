package android.support.v4.text;

import java.util.Locale;

class TextDirectionHeuristicsCompat$TextDirectionHeuristicLocale
  extends TextDirectionHeuristicsCompat.TextDirectionHeuristicImpl
{
  public static final TextDirectionHeuristicLocale INSTANCE = new TextDirectionHeuristicLocale();
  
  public TextDirectionHeuristicsCompat$TextDirectionHeuristicLocale()
  {
    super(null);
  }
  
  protected boolean defaultIsRtl()
  {
    int i = 1;
    if (TextUtilsCompat.getLayoutDirectionFromLocale(Locale.getDefault()) == i) {}
    for (;;)
    {
      return i;
      int j = 0;
    }
  }
}


/* Location:           C:\Users\dreadiscool\Desktop\tools\classes-dex2jar.jar
 * Qualified Name:     android.support.v4.text.TextDirectionHeuristicsCompat.TextDirectionHeuristicLocale
 * JD-Core Version:    0.7.0.1
 */