package android.support.v4.text;

public class TextDirectionHeuristicsCompat
{
  public static final TextDirectionHeuristicCompat ANYRTL_LTR = new TextDirectionHeuristicsCompat.TextDirectionHeuristicInternal(TextDirectionHeuristicsCompat.AnyStrong.INSTANCE_RTL, false, null);
  public static final TextDirectionHeuristicCompat FIRSTSTRONG_LTR;
  public static final TextDirectionHeuristicCompat FIRSTSTRONG_RTL;
  public static final TextDirectionHeuristicCompat LOCALE = TextDirectionHeuristicsCompat.TextDirectionHeuristicLocale.INSTANCE;
  public static final TextDirectionHeuristicCompat LTR = new TextDirectionHeuristicsCompat.TextDirectionHeuristicInternal(null, false, null);
  public static final TextDirectionHeuristicCompat RTL = new TextDirectionHeuristicsCompat.TextDirectionHeuristicInternal(null, true, null);
  private static final int STATE_FALSE = 1;
  private static final int STATE_TRUE = 0;
  private static final int STATE_UNKNOWN = 2;
  
  static
  {
    FIRSTSTRONG_LTR = new TextDirectionHeuristicsCompat.TextDirectionHeuristicInternal(TextDirectionHeuristicsCompat.FirstStrong.INSTANCE, false, null);
    FIRSTSTRONG_RTL = new TextDirectionHeuristicsCompat.TextDirectionHeuristicInternal(TextDirectionHeuristicsCompat.FirstStrong.INSTANCE, true, null);
  }
  
  private static int isRtlText(int paramInt)
  {
    int i;
    switch (paramInt)
    {
    default: 
      i = 2;
    }
    for (;;)
    {
      return i;
      i = 1;
      continue;
      i = 0;
    }
  }
  
  private static int isRtlTextOrFormat(int paramInt)
  {
    int i;
    switch (paramInt)
    {
    default: 
      i = 2;
    }
    for (;;)
    {
      return i;
      i = 1;
      continue;
      i = 0;
    }
  }
}


/* Location:           C:\Users\dreadiscool\Desktop\tools\classes-dex2jar.jar
 * Qualified Name:     android.support.v4.text.TextDirectionHeuristicsCompat
 * JD-Core Version:    0.7.0.1
 */