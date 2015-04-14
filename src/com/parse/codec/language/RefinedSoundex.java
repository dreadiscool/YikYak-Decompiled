package com.parse.codec.language;

import com.parse.codec.EncoderException;
import com.parse.codec.StringEncoder;

public class RefinedSoundex
  implements StringEncoder
{
  public static final RefinedSoundex US_ENGLISH = new RefinedSoundex();
  private static final char[] US_ENGLISH_MAPPING = "01360240043788015936020505".toCharArray();
  public static final String US_ENGLISH_MAPPING_STRING = "01360240043788015936020505";
  private final char[] soundexMapping;
  
  public RefinedSoundex()
  {
    this.soundexMapping = US_ENGLISH_MAPPING;
  }
  
  public RefinedSoundex(String paramString)
  {
    this.soundexMapping = paramString.toCharArray();
  }
  
  public RefinedSoundex(char[] paramArrayOfChar)
  {
    this.soundexMapping = new char[paramArrayOfChar.length];
    System.arraycopy(paramArrayOfChar, 0, this.soundexMapping, 0, paramArrayOfChar.length);
  }
  
  public int difference(String paramString1, String paramString2)
  {
    return SoundexUtils.difference(this, paramString1, paramString2);
  }
  
  public Object encode(Object paramObject)
  {
    if (!(paramObject instanceof String)) {
      throw new EncoderException("Parameter supplied to RefinedSoundex encode is not of type java.lang.String");
    }
    return soundex((String)paramObject);
  }
  
  public String encode(String paramString)
  {
    return soundex(paramString);
  }
  
  char getMappingCode(char paramChar)
  {
    if (!Character.isLetter(paramChar)) {}
    for (char c = '\000';; c = this.soundexMapping[('﾿' + Character.toUpperCase(paramChar))]) {
      return c;
    }
  }
  
  public String soundex(String paramString)
  {
    int i = 0;
    Object localObject;
    if (paramString == null) {
      localObject = null;
    }
    for (;;)
    {
      return localObject;
      String str = SoundexUtils.clean(paramString);
      if (str.length() == 0)
      {
        localObject = str;
      }
      else
      {
        StringBuffer localStringBuffer = new StringBuffer();
        localStringBuffer.append(str.charAt(0));
        int j = 42;
        if (i < str.length())
        {
          char c = getMappingCode(str.charAt(i));
          if (c == j) {}
          for (;;)
          {
            i++;
            break;
            if (c != 0) {
              localStringBuffer.append(c);
            }
            j = c;
          }
        }
        localObject = localStringBuffer.toString();
      }
    }
  }
}


/* Location:           C:\Users\dreadiscool\Desktop\tools\classes-dex2jar.jar
 * Qualified Name:     com.parse.codec.language.RefinedSoundex
 * JD-Core Version:    0.7.0.1
 */