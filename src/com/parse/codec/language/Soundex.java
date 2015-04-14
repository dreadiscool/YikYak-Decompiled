package com.parse.codec.language;

import com.parse.codec.EncoderException;
import com.parse.codec.StringEncoder;

public class Soundex
  implements StringEncoder
{
  public static final Soundex US_ENGLISH = new Soundex();
  private static final char[] US_ENGLISH_MAPPING = "01230120022455012623010202".toCharArray();
  public static final String US_ENGLISH_MAPPING_STRING = "01230120022455012623010202";
  private int maxLength = 4;
  private final char[] soundexMapping;
  
  public Soundex()
  {
    this.soundexMapping = US_ENGLISH_MAPPING;
  }
  
  public Soundex(String paramString)
  {
    this.soundexMapping = paramString.toCharArray();
  }
  
  public Soundex(char[] paramArrayOfChar)
  {
    this.soundexMapping = new char[paramArrayOfChar.length];
    System.arraycopy(paramArrayOfChar, 0, this.soundexMapping, 0, paramArrayOfChar.length);
  }
  
  private char getMappingCode(String paramString, int paramInt)
  {
    char c1 = map(paramString.charAt(paramInt));
    if ((paramInt > 1) && (c1 != '0'))
    {
      int i = paramString.charAt(paramInt - 1);
      if ((72 == i) || (87 == i))
      {
        char c2 = paramString.charAt(paramInt - 2);
        if ((map(c2) == c1) || ('H' == c2) || ('W' == c2)) {
          c1 = '\000';
        }
      }
    }
    return c1;
  }
  
  private char[] getSoundexMapping()
  {
    return this.soundexMapping;
  }
  
  private char map(char paramChar)
  {
    int i = paramChar + '﾿';
    if ((i < 0) || (i >= getSoundexMapping().length)) {
      throw new IllegalArgumentException("The character is not mapped: " + paramChar);
    }
    return getSoundexMapping()[i];
  }
  
  public int difference(String paramString1, String paramString2)
  {
    return SoundexUtils.difference(this, paramString1, paramString2);
  }
  
  public Object encode(Object paramObject)
  {
    if (!(paramObject instanceof String)) {
      throw new EncoderException("Parameter supplied to Soundex encode is not of type java.lang.String");
    }
    return soundex((String)paramObject);
  }
  
  public String encode(String paramString)
  {
    return soundex(paramString);
  }
  
  public int getMaxLength()
  {
    return this.maxLength;
  }
  
  public void setMaxLength(int paramInt)
  {
    this.maxLength = paramInt;
  }
  
  public String soundex(String paramString)
  {
    int i = 1;
    if (paramString == null) {}
    String str;
    for (Object localObject = null;; localObject = str)
    {
      return localObject;
      str = SoundexUtils.clean(paramString);
      if (str.length() != 0) {
        break;
      }
    }
    char[] arrayOfChar = new char[4];
    arrayOfChar[0] = 48;
    arrayOfChar[1] = 48;
    arrayOfChar[2] = 48;
    arrayOfChar[3] = 48;
    arrayOfChar[0] = str.charAt(0);
    int j = getMappingCode(str, 0);
    int k = i;
    for (;;)
    {
      int m;
      if ((k < str.length()) && (i < arrayOfChar.length))
      {
        m = k + 1;
        int n = getMappingCode(str, k);
        if (n != 0)
        {
          if ((n != 48) && (n != j))
          {
            int i1 = i + 1;
            arrayOfChar[i] = n;
            i = i1;
          }
          j = n;
          k = m;
        }
      }
      else
      {
        localObject = new String(arrayOfChar);
        break;
      }
      k = m;
    }
  }
}


/* Location:           C:\Users\dreadiscool\Desktop\tools\classes-dex2jar.jar
 * Qualified Name:     com.parse.codec.language.Soundex
 * JD-Core Version:    0.7.0.1
 */