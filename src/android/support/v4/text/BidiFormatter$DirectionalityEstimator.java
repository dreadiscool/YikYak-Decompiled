package android.support.v4.text;

class BidiFormatter$DirectionalityEstimator
{
  private static final byte[] DIR_TYPE_CACHE = new byte[1792];
  private static final int DIR_TYPE_CACHE_SIZE = 1792;
  private int charIndex;
  private final boolean isHtml;
  private char lastChar;
  private final int length;
  private final String text;
  
  static
  {
    for (int i = 0; i < 1792; i++) {
      DIR_TYPE_CACHE[i] = Character.getDirectionality(i);
    }
  }
  
  BidiFormatter$DirectionalityEstimator(String paramString, boolean paramBoolean)
  {
    this.text = paramString;
    this.isHtml = paramBoolean;
    this.length = paramString.length();
  }
  
  private static byte getCachedDirectionality(char paramChar)
  {
    if (paramChar < '܀') {}
    for (byte b = DIR_TYPE_CACHE[paramChar];; b = Character.getDirectionality(paramChar)) {
      return b;
    }
  }
  
  private byte skipEntityBackward()
  {
    int i = this.charIndex;
    if (this.charIndex > 0)
    {
      String str = this.text;
      int j = -1 + this.charIndex;
      this.charIndex = j;
      this.lastChar = str.charAt(j);
      if (this.lastChar != '&') {}
    }
    for (byte b = 12;; b = 13)
    {
      return b;
      if (this.lastChar != ';') {
        break;
      }
      this.charIndex = i;
      this.lastChar = ';';
    }
  }
  
  private byte skipEntityForward()
  {
    char c;
    do
    {
      if (this.charIndex >= this.length) {
        break;
      }
      String str = this.text;
      int i = this.charIndex;
      this.charIndex = (i + 1);
      c = str.charAt(i);
      this.lastChar = c;
    } while (c != ';');
    return 12;
  }
  
  private byte skipTagBackward()
  {
    int i = this.charIndex;
    label157:
    for (;;)
    {
      if (this.charIndex > 0)
      {
        String str1 = this.text;
        int j = -1 + this.charIndex;
        this.charIndex = j;
        this.lastChar = str1.charAt(j);
        if (this.lastChar != '<') {}
      }
      for (byte b = 12;; b = 13)
      {
        return b;
        if (this.lastChar != '>') {
          break;
        }
        this.charIndex = i;
        this.lastChar = '>';
      }
      if ((this.lastChar == '"') || (this.lastChar == '\''))
      {
        int k = this.lastChar;
        for (;;)
        {
          if (this.charIndex <= 0) {
            break label157;
          }
          String str2 = this.text;
          int m = -1 + this.charIndex;
          this.charIndex = m;
          char c = str2.charAt(m);
          this.lastChar = c;
          if (c == k) {
            break;
          }
        }
      }
    }
  }
  
  private byte skipTagForward()
  {
    int i = this.charIndex;
    if (this.charIndex < this.length)
    {
      String str1 = this.text;
      int j = this.charIndex;
      this.charIndex = (j + 1);
      this.lastChar = str1.charAt(j);
      if (this.lastChar != '>') {}
    }
    for (byte b = 12;; b = 13)
    {
      return b;
      if ((this.lastChar != '"') && (this.lastChar != '\'')) {
        break;
      }
      int k = this.lastChar;
      for (;;)
      {
        if (this.charIndex >= this.length) {
          break label137;
        }
        String str2 = this.text;
        int m = this.charIndex;
        this.charIndex = (m + 1);
        char c = str2.charAt(m);
        this.lastChar = c;
        if (c == k) {
          break;
        }
      }
      label137:
      break;
      this.charIndex = i;
      this.lastChar = '<';
    }
  }
  
  byte dirTypeBackward()
  {
    this.lastChar = this.text.charAt(-1 + this.charIndex);
    byte b;
    if (Character.isLowSurrogate(this.lastChar))
    {
      int i = Character.codePointBefore(this.text, this.charIndex);
      this.charIndex -= Character.charCount(i);
      b = Character.getDirectionality(i);
    }
    for (;;)
    {
      return b;
      this.charIndex = (-1 + this.charIndex);
      b = getCachedDirectionality(this.lastChar);
      if (this.isHtml) {
        if (this.lastChar == '>') {
          b = skipTagBackward();
        } else if (this.lastChar == ';') {
          b = skipEntityBackward();
        }
      }
    }
  }
  
  byte dirTypeForward()
  {
    this.lastChar = this.text.charAt(this.charIndex);
    byte b;
    if (Character.isHighSurrogate(this.lastChar))
    {
      int i = Character.codePointAt(this.text, this.charIndex);
      this.charIndex += Character.charCount(i);
      b = Character.getDirectionality(i);
    }
    for (;;)
    {
      return b;
      this.charIndex = (1 + this.charIndex);
      b = getCachedDirectionality(this.lastChar);
      if (this.isHtml) {
        if (this.lastChar == '<') {
          b = skipTagForward();
        } else if (this.lastChar == '&') {
          b = skipEntityForward();
        }
      }
    }
  }
  
  int getEntryDir()
  {
    int i = -1;
    this.charIndex = 0;
    int j = 0;
    int k = 0;
    int m = 0;
    for (;;)
    {
      if ((this.charIndex < this.length) && (j == 0)) {
        switch (dirTypeForward())
        {
        case 9: 
        case 3: 
        case 4: 
        case 5: 
        case 6: 
        case 7: 
        case 8: 
        case 10: 
        case 11: 
        case 12: 
        case 13: 
        default: 
          j = m;
          break;
        case 14: 
        case 15: 
          m++;
          k = i;
          break;
        case 16: 
        case 17: 
          m++;
          k = 1;
          break;
        case 18: 
          m--;
          k = 0;
          break;
        case 0: 
          if (m != 0) {}
          break;
        }
      }
    }
    for (;;)
    {
      return i;
      j = m;
      break;
      if (m == 0)
      {
        i = 1;
      }
      else
      {
        j = m;
        break;
        if (j == 0)
        {
          i = 0;
        }
        else if (k != 0)
        {
          i = k;
        }
        else
        {
          for (;;)
          {
            if (this.charIndex <= 0) {
              break label286;
            }
            switch (dirTypeBackward())
            {
            default: 
              break;
            case 14: 
            case 15: 
              if (j == m) {
                break;
              }
              m--;
              break;
            case 16: 
            case 17: 
              if (j == m)
              {
                i = 1;
                break;
              }
              m--;
              break;
            case 18: 
              m++;
            }
          }
          label286:
          i = 0;
        }
      }
    }
  }
  
  int getExitDir()
  {
    int i = 0;
    this.charIndex = this.length;
    int j = 0;
    int k = 0;
    for (;;)
    {
      if (this.charIndex > 0) {}
      switch (dirTypeBackward())
      {
      case 9: 
      case 3: 
      case 4: 
      case 5: 
      case 6: 
      case 7: 
      case 8: 
      case 10: 
      case 11: 
      case 12: 
      case 13: 
      default: 
        if (j == 0) {
          j = k;
        }
        break;
      case 0: 
        if (k == 0) {
          i = -1;
        }
      case 14: 
      case 15: 
      case 1: 
      case 2: 
      case 16: 
      case 17: 
        for (;;)
        {
          return i;
          if (j != 0) {
            break;
          }
          j = k;
          break;
          if (j == k)
          {
            i = -1;
          }
          else
          {
            k--;
            break;
            if (k == 0)
            {
              i = 1;
            }
            else
            {
              if (j != 0) {
                break;
              }
              j = k;
              break;
              if (j != k) {
                break label188;
              }
              i = 1;
            }
          }
        }
        k--;
        break;
      case 18: 
        label188:
        k++;
      }
    }
  }
}


/* Location:           C:\Users\dreadiscool\Desktop\tools\classes-dex2jar.jar
 * Qualified Name:     android.support.v4.text.BidiFormatter.DirectionalityEstimator
 * JD-Core Version:    0.7.0.1
 */