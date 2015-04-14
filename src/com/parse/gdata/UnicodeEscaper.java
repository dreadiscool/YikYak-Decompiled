package com.parse.gdata;

public abstract class UnicodeEscaper
  implements Escaper
{
  private static final int DEST_PAD = 32;
  private static final ThreadLocal<char[]> DEST_TL = new UnicodeEscaper.2();
  
  protected static final int codePointAt(CharSequence paramCharSequence, int paramInt1, int paramInt2)
  {
    if (paramInt1 < paramInt2)
    {
      int i = paramInt1 + 1;
      int j = paramCharSequence.charAt(paramInt1);
      if ((j < 55296) || (j > 57343)) {}
      char c;
      int k;
      for (;;)
      {
        return j;
        if (j > 56319) {
          break label131;
        }
        if (i == paramInt2)
        {
          j = -j;
        }
        else
        {
          c = paramCharSequence.charAt(i);
          if (!Character.isLowSurrogate(c)) {
            break;
          }
          k = Character.toCodePoint(j, c);
        }
      }
      throw new IllegalArgumentException("Expected low surrogate but got char '" + c + "' with value " + c + " at index " + i);
      label131:
      throw new IllegalArgumentException("Unexpected low surrogate character '" + k + "' with value " + k + " at index " + (i - 1));
    }
    throw new IndexOutOfBoundsException("Index exceeds specified range");
  }
  
  private static final char[] growBuffer(char[] paramArrayOfChar, int paramInt1, int paramInt2)
  {
    char[] arrayOfChar = new char[paramInt2];
    if (paramInt1 > 0) {
      System.arraycopy(paramArrayOfChar, 0, arrayOfChar, 0, paramInt1);
    }
    return arrayOfChar;
  }
  
  public Appendable escape(Appendable paramAppendable)
  {
    Preconditions.checkNotNull(paramAppendable);
    return new UnicodeEscaper.1(this, paramAppendable);
  }
  
  public String escape(String paramString)
  {
    int i = paramString.length();
    int j = nextEscapeIndex(paramString, 0, i);
    if (j == i) {}
    for (;;)
    {
      return paramString;
      paramString = escapeSlow(paramString, j);
    }
  }
  
  protected abstract char[] escape(int paramInt);
  
  protected final String escapeSlow(String paramString, int paramInt)
  {
    int i = paramString.length();
    char[] arrayOfChar1 = (char[])DEST_TL.get();
    int j = 0;
    char[] arrayOfChar2 = arrayOfChar1;
    int k = 0;
    if (paramInt < i)
    {
      int i1 = codePointAt(paramString, paramInt, i);
      if (i1 < 0) {
        throw new IllegalArgumentException("Trailing high surrogate at end of input");
      }
      char[] arrayOfChar3 = escape(i1);
      if (arrayOfChar3 != null)
      {
        int i4 = paramInt - j;
        int i5 = k + i4 + arrayOfChar3.length;
        if (arrayOfChar2.length < i5) {
          arrayOfChar2 = growBuffer(arrayOfChar2, k, 32 + (i5 + (i - paramInt)));
        }
        if (i4 > 0)
        {
          paramString.getChars(j, paramInt, arrayOfChar2, k);
          k += i4;
        }
        if (arrayOfChar3.length > 0)
        {
          System.arraycopy(arrayOfChar3, 0, arrayOfChar2, k, arrayOfChar3.length);
          k += arrayOfChar3.length;
        }
      }
      if (Character.isSupplementaryCodePoint(i1)) {}
      for (int i2 = 2;; i2 = 1)
      {
        int i3 = i2 + paramInt;
        paramInt = nextEscapeIndex(paramString, i3, i);
        j = i3;
        break;
      }
    }
    int m = i - j;
    if (m > 0)
    {
      int n = m + k;
      if (arrayOfChar2.length < n) {
        arrayOfChar2 = growBuffer(arrayOfChar2, k, n);
      }
      paramString.getChars(j, i, arrayOfChar2, k);
      k = n;
    }
    return new String(arrayOfChar2, 0, k);
  }
  
  protected int nextEscapeIndex(CharSequence paramCharSequence, int paramInt1, int paramInt2)
  {
    int i;
    if (paramInt1 < paramInt2)
    {
      i = codePointAt(paramCharSequence, paramInt1, paramInt2);
      if ((i >= 0) && (escape(i) == null)) {}
    }
    else
    {
      return paramInt1;
    }
    if (Character.isSupplementaryCodePoint(i)) {}
    for (int j = 2;; j = 1)
    {
      paramInt1 += j;
      break;
    }
  }
}


/* Location:           C:\Users\dreadiscool\Desktop\tools\classes-dex2jar.jar
 * Qualified Name:     com.parse.gdata.UnicodeEscaper
 * JD-Core Version:    0.7.0.1
 */