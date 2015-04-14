package com.parse.gdata;

class UnicodeEscaper$1
  implements Appendable
{
  char[] decodedChars = new char[2];
  int pendingHighSurrogate = -1;
  
  UnicodeEscaper$1(UnicodeEscaper paramUnicodeEscaper, Appendable paramAppendable) {}
  
  private void outputChars(char[] paramArrayOfChar, int paramInt)
  {
    for (int i = 0; i < paramInt; i++) {
      this.val$out.append(paramArrayOfChar[i]);
    }
  }
  
  public Appendable append(char paramChar)
  {
    if (this.pendingHighSurrogate != -1)
    {
      if (!Character.isLowSurrogate(paramChar)) {
        throw new IllegalArgumentException("Expected low surrogate character but got '" + paramChar + "' with value " + paramChar);
      }
      char[] arrayOfChar2 = this.this$0.escape(Character.toCodePoint((char)this.pendingHighSurrogate, paramChar));
      if (arrayOfChar2 != null)
      {
        outputChars(arrayOfChar2, arrayOfChar2.length);
        this.pendingHighSurrogate = -1;
      }
    }
    for (;;)
    {
      return this;
      this.val$out.append((char)this.pendingHighSurrogate);
      this.val$out.append(paramChar);
      break;
      if (Character.isHighSurrogate(paramChar))
      {
        this.pendingHighSurrogate = paramChar;
      }
      else
      {
        if (Character.isLowSurrogate(paramChar)) {
          throw new IllegalArgumentException("Unexpected low surrogate character '" + paramChar + "' with value " + paramChar);
        }
        char[] arrayOfChar1 = this.this$0.escape(paramChar);
        if (arrayOfChar1 != null) {
          outputChars(arrayOfChar1, arrayOfChar1.length);
        } else {
          this.val$out.append(paramChar);
        }
      }
    }
  }
  
  public Appendable append(CharSequence paramCharSequence)
  {
    return append(paramCharSequence, 0, paramCharSequence.length());
  }
  
  public Appendable append(CharSequence paramCharSequence, int paramInt1, int paramInt2)
  {
    int i;
    if (paramInt1 < paramInt2)
    {
      if (this.pendingHighSurrogate == -1) {
        break label268;
      }
      i = paramInt1 + 1;
      char c = paramCharSequence.charAt(paramInt1);
      if (!Character.isLowSurrogate(c)) {
        throw new IllegalArgumentException("Expected low surrogate character but got " + c);
      }
      char[] arrayOfChar2 = this.this$0.escape(Character.toCodePoint((char)this.pendingHighSurrogate, c));
      if (arrayOfChar2 == null) {
        break label147;
      }
      outputChars(arrayOfChar2, arrayOfChar2.length);
      paramInt1++;
      this.pendingHighSurrogate = -1;
    }
    for (;;)
    {
      int j = this.this$0.nextEscapeIndex(paramCharSequence, i, paramInt2);
      if (j > paramInt1) {
        this.val$out.append(paramCharSequence, paramInt1, j);
      }
      if (j == paramInt2) {}
      label147:
      int k;
      for (;;)
      {
        return this;
        this.val$out.append((char)this.pendingHighSurrogate);
        break;
        k = UnicodeEscaper.codePointAt(paramCharSequence, j, paramInt2);
        if (k >= 0) {
          break label189;
        }
        this.pendingHighSurrogate = (-k);
      }
      label189:
      char[] arrayOfChar1 = this.this$0.escape(k);
      if (arrayOfChar1 != null)
      {
        outputChars(arrayOfChar1, arrayOfChar1.length);
        label214:
        if (!Character.isSupplementaryCodePoint(k)) {
          break label262;
        }
      }
      label262:
      for (int n = 2;; n = 1)
      {
        paramInt1 = j + n;
        i = paramInt1;
        break;
        int m = Character.toChars(k, this.decodedChars, 0);
        outputChars(this.decodedChars, m);
        break label214;
      }
      label268:
      i = paramInt1;
    }
  }
}


/* Location:           C:\Users\dreadiscool\Desktop\tools\classes-dex2jar.jar
 * Qualified Name:     com.parse.gdata.UnicodeEscaper.1
 * JD-Core Version:    0.7.0.1
 */