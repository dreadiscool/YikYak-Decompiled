package android.support.v4.text;

import java.nio.CharBuffer;

abstract class TextDirectionHeuristicsCompat$TextDirectionHeuristicImpl
  implements TextDirectionHeuristicCompat
{
  private final TextDirectionHeuristicsCompat.TextDirectionAlgorithm mAlgorithm;
  
  public TextDirectionHeuristicsCompat$TextDirectionHeuristicImpl(TextDirectionHeuristicsCompat.TextDirectionAlgorithm paramTextDirectionAlgorithm)
  {
    this.mAlgorithm = paramTextDirectionAlgorithm;
  }
  
  private boolean doCheck(CharSequence paramCharSequence, int paramInt1, int paramInt2)
  {
    boolean bool;
    switch (this.mAlgorithm.checkRtl(paramCharSequence, paramInt1, paramInt2))
    {
    default: 
      bool = defaultIsRtl();
    }
    for (;;)
    {
      return bool;
      bool = true;
      continue;
      bool = false;
    }
  }
  
  protected abstract boolean defaultIsRtl();
  
  public boolean isRtl(CharSequence paramCharSequence, int paramInt1, int paramInt2)
  {
    if ((paramCharSequence == null) || (paramInt1 < 0) || (paramInt2 < 0) || (paramCharSequence.length() - paramInt2 < paramInt1)) {
      throw new IllegalArgumentException();
    }
    if (this.mAlgorithm == null) {}
    for (boolean bool = defaultIsRtl();; bool = doCheck(paramCharSequence, paramInt1, paramInt2)) {
      return bool;
    }
  }
  
  public boolean isRtl(char[] paramArrayOfChar, int paramInt1, int paramInt2)
  {
    return isRtl(CharBuffer.wrap(paramArrayOfChar), paramInt1, paramInt2);
  }
}


/* Location:           C:\Users\dreadiscool\Desktop\tools\classes-dex2jar.jar
 * Qualified Name:     android.support.v4.text.TextDirectionHeuristicsCompat.TextDirectionHeuristicImpl
 * JD-Core Version:    0.7.0.1
 */