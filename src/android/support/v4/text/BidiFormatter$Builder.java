package android.support.v4.text;

import java.util.Locale;

public final class BidiFormatter$Builder
{
  private int mFlags;
  private boolean mIsRtlContext;
  private TextDirectionHeuristicCompat mTextDirectionHeuristicCompat;
  
  public BidiFormatter$Builder()
  {
    initialize(BidiFormatter.access$000(Locale.getDefault()));
  }
  
  public BidiFormatter$Builder(Locale paramLocale)
  {
    initialize(BidiFormatter.access$000(paramLocale));
  }
  
  public BidiFormatter$Builder(boolean paramBoolean)
  {
    initialize(paramBoolean);
  }
  
  private static BidiFormatter getDefaultInstanceFromContext(boolean paramBoolean)
  {
    if (paramBoolean) {}
    for (BidiFormatter localBidiFormatter = BidiFormatter.access$200();; localBidiFormatter = BidiFormatter.access$300()) {
      return localBidiFormatter;
    }
  }
  
  private void initialize(boolean paramBoolean)
  {
    this.mIsRtlContext = paramBoolean;
    this.mTextDirectionHeuristicCompat = BidiFormatter.access$100();
    this.mFlags = 2;
  }
  
  public BidiFormatter build()
  {
    if ((this.mFlags == 2) && (this.mTextDirectionHeuristicCompat == BidiFormatter.access$100())) {}
    for (BidiFormatter localBidiFormatter = getDefaultInstanceFromContext(this.mIsRtlContext);; localBidiFormatter = new BidiFormatter(this.mIsRtlContext, this.mFlags, this.mTextDirectionHeuristicCompat, null)) {
      return localBidiFormatter;
    }
  }
  
  public Builder setTextDirectionHeuristic(TextDirectionHeuristicCompat paramTextDirectionHeuristicCompat)
  {
    this.mTextDirectionHeuristicCompat = paramTextDirectionHeuristicCompat;
    return this;
  }
  
  public Builder stereoReset(boolean paramBoolean)
  {
    if (paramBoolean) {}
    for (this.mFlags = (0x2 | this.mFlags);; this.mFlags = (0xFFFFFFFD & this.mFlags)) {
      return this;
    }
  }
}


/* Location:           C:\Users\dreadiscool\Desktop\tools\classes-dex2jar.jar
 * Qualified Name:     android.support.v4.text.BidiFormatter.Builder
 * JD-Core Version:    0.7.0.1
 */