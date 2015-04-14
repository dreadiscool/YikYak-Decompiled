package android.support.v4.text;

import java.util.Locale;

public final class BidiFormatter
{
  private static final int DEFAULT_FLAGS = 2;
  private static final BidiFormatter DEFAULT_LTR_INSTANCE = new BidiFormatter(false, 2, DEFAULT_TEXT_DIRECTION_HEURISTIC);
  private static final BidiFormatter DEFAULT_RTL_INSTANCE = new BidiFormatter(true, 2, DEFAULT_TEXT_DIRECTION_HEURISTIC);
  private static TextDirectionHeuristicCompat DEFAULT_TEXT_DIRECTION_HEURISTIC = TextDirectionHeuristicsCompat.FIRSTSTRONG_LTR;
  private static final int DIR_LTR = -1;
  private static final int DIR_RTL = 1;
  private static final int DIR_UNKNOWN = 0;
  private static final String EMPTY_STRING = "";
  private static final int FLAG_STEREO_RESET = 2;
  private static final char LRE = '‪';
  private static final char LRM = '‎';
  private static final String LRM_STRING = Character.toString('‎');
  private static final char PDF = '‬';
  private static final char RLE = '‫';
  private static final char RLM = '‏';
  private static final String RLM_STRING = Character.toString('‏');
  private final TextDirectionHeuristicCompat mDefaultTextDirectionHeuristicCompat;
  private final int mFlags;
  private final boolean mIsRtlContext;
  
  private BidiFormatter(boolean paramBoolean, int paramInt, TextDirectionHeuristicCompat paramTextDirectionHeuristicCompat)
  {
    this.mIsRtlContext = paramBoolean;
    this.mFlags = paramInt;
    this.mDefaultTextDirectionHeuristicCompat = paramTextDirectionHeuristicCompat;
  }
  
  private static int getEntryDir(String paramString)
  {
    return new BidiFormatter.DirectionalityEstimator(paramString, false).getEntryDir();
  }
  
  private static int getExitDir(String paramString)
  {
    return new BidiFormatter.DirectionalityEstimator(paramString, false).getExitDir();
  }
  
  public static BidiFormatter getInstance()
  {
    return new BidiFormatter.Builder().build();
  }
  
  public static BidiFormatter getInstance(Locale paramLocale)
  {
    return new BidiFormatter.Builder(paramLocale).build();
  }
  
  public static BidiFormatter getInstance(boolean paramBoolean)
  {
    return new BidiFormatter.Builder(paramBoolean).build();
  }
  
  private static boolean isRtlLocale(Locale paramLocale)
  {
    int i = 1;
    if (TextUtilsCompat.getLayoutDirectionFromLocale(paramLocale) == i) {}
    for (;;)
    {
      return i;
      int j = 0;
    }
  }
  
  private String markAfter(String paramString, TextDirectionHeuristicCompat paramTextDirectionHeuristicCompat)
  {
    boolean bool = paramTextDirectionHeuristicCompat.isRtl(paramString, 0, paramString.length());
    String str;
    if ((!this.mIsRtlContext) && ((bool) || (getExitDir(paramString) == 1))) {
      str = LRM_STRING;
    }
    for (;;)
    {
      return str;
      if ((this.mIsRtlContext) && ((!bool) || (getExitDir(paramString) == -1))) {
        str = RLM_STRING;
      } else {
        str = "";
      }
    }
  }
  
  private String markBefore(String paramString, TextDirectionHeuristicCompat paramTextDirectionHeuristicCompat)
  {
    boolean bool = paramTextDirectionHeuristicCompat.isRtl(paramString, 0, paramString.length());
    String str;
    if ((!this.mIsRtlContext) && ((bool) || (getEntryDir(paramString) == 1))) {
      str = LRM_STRING;
    }
    for (;;)
    {
      return str;
      if ((this.mIsRtlContext) && ((!bool) || (getEntryDir(paramString) == -1))) {
        str = RLM_STRING;
      } else {
        str = "";
      }
    }
  }
  
  public boolean getStereoReset()
  {
    if ((0x2 & this.mFlags) != 0) {}
    for (boolean bool = true;; bool = false) {
      return bool;
    }
  }
  
  public boolean isRtl(String paramString)
  {
    return this.mDefaultTextDirectionHeuristicCompat.isRtl(paramString, 0, paramString.length());
  }
  
  public boolean isRtlContext()
  {
    return this.mIsRtlContext;
  }
  
  public String unicodeWrap(String paramString)
  {
    return unicodeWrap(paramString, this.mDefaultTextDirectionHeuristicCompat, true);
  }
  
  public String unicodeWrap(String paramString, TextDirectionHeuristicCompat paramTextDirectionHeuristicCompat)
  {
    return unicodeWrap(paramString, paramTextDirectionHeuristicCompat, true);
  }
  
  public String unicodeWrap(String paramString, TextDirectionHeuristicCompat paramTextDirectionHeuristicCompat, boolean paramBoolean)
  {
    boolean bool = paramTextDirectionHeuristicCompat.isRtl(paramString, 0, paramString.length());
    StringBuilder localStringBuilder = new StringBuilder();
    TextDirectionHeuristicCompat localTextDirectionHeuristicCompat2;
    if ((getStereoReset()) && (paramBoolean))
    {
      if (bool)
      {
        localTextDirectionHeuristicCompat2 = TextDirectionHeuristicsCompat.RTL;
        localStringBuilder.append(markBefore(paramString, localTextDirectionHeuristicCompat2));
      }
    }
    else
    {
      if (bool == this.mIsRtlContext) {
        break label149;
      }
      if (!bool) {
        break label141;
      }
      int i = 8235;
      label76:
      localStringBuilder.append(i);
      localStringBuilder.append(paramString);
      localStringBuilder.append('‬');
      label100:
      if (paramBoolean) {
        if (!bool) {
          break label159;
        }
      }
    }
    label141:
    label149:
    label159:
    for (TextDirectionHeuristicCompat localTextDirectionHeuristicCompat1 = TextDirectionHeuristicsCompat.RTL;; localTextDirectionHeuristicCompat1 = TextDirectionHeuristicsCompat.LTR)
    {
      localStringBuilder.append(markAfter(paramString, localTextDirectionHeuristicCompat1));
      return localStringBuilder.toString();
      localTextDirectionHeuristicCompat2 = TextDirectionHeuristicsCompat.LTR;
      break;
      int j = 8234;
      break label76;
      localStringBuilder.append(paramString);
      break label100;
    }
  }
  
  public String unicodeWrap(String paramString, boolean paramBoolean)
  {
    return unicodeWrap(paramString, this.mDefaultTextDirectionHeuristicCompat, paramBoolean);
  }
}


/* Location:           C:\Users\dreadiscool\Desktop\tools\classes-dex2jar.jar
 * Qualified Name:     android.support.v4.text.BidiFormatter
 * JD-Core Version:    0.7.0.1
 */