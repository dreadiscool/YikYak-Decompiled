package android.support.v4.text;

class TextDirectionHeuristicsCompat$FirstStrong
  implements TextDirectionHeuristicsCompat.TextDirectionAlgorithm
{
  public static final FirstStrong INSTANCE = new FirstStrong();
  
  public int checkRtl(CharSequence paramCharSequence, int paramInt1, int paramInt2)
  {
    int i = paramInt1 + paramInt2;
    int j = 2;
    while ((paramInt1 < i) && (j == 2))
    {
      j = TextDirectionHeuristicsCompat.access$100(Character.getDirectionality(paramCharSequence.charAt(paramInt1)));
      paramInt1++;
    }
    return j;
  }
}


/* Location:           C:\Users\dreadiscool\Desktop\tools\classes-dex2jar.jar
 * Qualified Name:     android.support.v4.text.TextDirectionHeuristicsCompat.FirstStrong
 * JD-Core Version:    0.7.0.1
 */