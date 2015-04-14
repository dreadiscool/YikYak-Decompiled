package com.parse.codec.language;

import com.parse.codec.EncoderException;
import com.parse.codec.StringEncoder;
import java.util.Locale;

public class ColognePhonetic
  implements StringEncoder
{
  private static final char[][] PREPROCESS_MAP;
  
  static
  {
    char[][] arrayOfChar = new char[4][];
    char[] arrayOfChar1 = new char[2];
    arrayOfChar1[0] = 196;
    arrayOfChar1[1] = 65;
    arrayOfChar[0] = arrayOfChar1;
    char[] arrayOfChar2 = new char[2];
    arrayOfChar2[0] = 220;
    arrayOfChar2[1] = 85;
    arrayOfChar[1] = arrayOfChar2;
    char[] arrayOfChar3 = new char[2];
    arrayOfChar3[0] = 214;
    arrayOfChar3[1] = 79;
    arrayOfChar[2] = arrayOfChar3;
    char[] arrayOfChar4 = new char[2];
    arrayOfChar4[0] = 223;
    arrayOfChar4[1] = 83;
    arrayOfChar[3] = arrayOfChar4;
    PREPROCESS_MAP = arrayOfChar;
  }
  
  private static boolean arrayContains(char[] paramArrayOfChar, char paramChar)
  {
    boolean bool = false;
    for (int i = 0;; i++) {
      if (i < paramArrayOfChar.length)
      {
        if (paramArrayOfChar[i] == paramChar) {
          bool = true;
        }
      }
      else {
        return bool;
      }
    }
  }
  
  private String preprocess(String paramString)
  {
    char[] arrayOfChar = paramString.toUpperCase(Locale.GERMAN).toCharArray();
    int i = 0;
    if (i < arrayOfChar.length)
    {
      if (arrayOfChar[i] > 'Z') {}
      for (int j = 0;; j++) {
        if (j < PREPROCESS_MAP.length)
        {
          if (arrayOfChar[i] == PREPROCESS_MAP[j][0]) {
            arrayOfChar[i] = PREPROCESS_MAP[j][1];
          }
        }
        else
        {
          i++;
          break;
        }
      }
    }
    return new String(arrayOfChar);
  }
  
  public String colognePhonetic(String paramString)
  {
    if (paramString == null) {}
    ColognePhonetic.CologneOutputBuffer localCologneOutputBuffer;
    for (String str2 = null;; str2 = localCologneOutputBuffer.toString())
    {
      return str2;
      String str1 = preprocess(paramString);
      localCologneOutputBuffer = new ColognePhonetic.CologneOutputBuffer(this, 2 * str1.length());
      ColognePhonetic.CologneInputBuffer localCologneInputBuffer = new ColognePhonetic.CologneInputBuffer(this, str1.toCharArray());
      int i = localCologneInputBuffer.length();
      int j = 47;
      char c1 = '-';
      if (i > 0)
      {
        char c2 = localCologneInputBuffer.removeNext();
        i = localCologneInputBuffer.length();
        char c3;
        label91:
        char c4;
        int k;
        if (i > 0)
        {
          c3 = localCologneInputBuffer.getNextChar();
          char[] arrayOfChar1 = new char[7];
          arrayOfChar1[0] = 65;
          arrayOfChar1[1] = 69;
          arrayOfChar1[2] = 73;
          arrayOfChar1[3] = 74;
          arrayOfChar1[4] = 79;
          arrayOfChar1[5] = 85;
          arrayOfChar1[6] = 89;
          if (!arrayContains(arrayOfChar1, c2)) {
            break label232;
          }
          int i5 = i;
          c4 = '0';
          k = i5;
        }
        for (;;)
        {
          if ((c4 != '-') && (((j != c4) && ((c4 != '0') || (j == 47))) || (c4 < '0') || (c4 > '8'))) {
            localCologneOutputBuffer.addRight(c4);
          }
          j = c4;
          c1 = c2;
          i = k;
          break;
          c3 = '-';
          break label91;
          label232:
          if ((c2 == 'H') || (c2 < 'A') || (c2 > 'Z'))
          {
            if (j == 47) {
              break;
            }
            k = i;
            c4 = '-';
            continue;
          }
          if ((c2 == 'B') || ((c2 == 'P') && (c3 != 'H')))
          {
            int m = i;
            c4 = '1';
            k = m;
          }
          else
          {
            if ((c2 == 'D') || (c2 == 'T'))
            {
              char[] arrayOfChar2 = new char[3];
              arrayOfChar2[0] = 83;
              arrayOfChar2[1] = 67;
              arrayOfChar2[2] = 90;
              if (!arrayContains(arrayOfChar2, c3))
              {
                int i4 = i;
                c4 = '2';
                k = i4;
                continue;
              }
            }
            char[] arrayOfChar3 = new char[4];
            arrayOfChar3[0] = 87;
            arrayOfChar3[1] = 70;
            arrayOfChar3[2] = 80;
            arrayOfChar3[3] = 86;
            if (arrayContains(arrayOfChar3, c2))
            {
              int i3 = i;
              c4 = '3';
              k = i3;
            }
            else
            {
              char[] arrayOfChar4 = new char[3];
              arrayOfChar4[0] = 71;
              arrayOfChar4[1] = 75;
              arrayOfChar4[2] = 81;
              if (arrayContains(arrayOfChar4, c2))
              {
                k = i;
                c4 = '4';
              }
              else
              {
                if (c2 == 'X')
                {
                  char[] arrayOfChar9 = new char[3];
                  arrayOfChar9[0] = 67;
                  arrayOfChar9[1] = 75;
                  arrayOfChar9[2] = 81;
                  if (!arrayContains(arrayOfChar9, c1))
                  {
                    localCologneInputBuffer.addLeft('S');
                    k = i + 1;
                    c4 = '4';
                    continue;
                  }
                }
                if ((c2 == 'S') || (c2 == 'Z'))
                {
                  k = i;
                  c4 = '8';
                }
                else if (c2 == 'C')
                {
                  if (j == 47)
                  {
                    char[] arrayOfChar8 = new char[9];
                    arrayOfChar8[0] = 65;
                    arrayOfChar8[1] = 72;
                    arrayOfChar8[2] = 75;
                    arrayOfChar8[3] = 76;
                    arrayOfChar8[4] = 79;
                    arrayOfChar8[5] = 81;
                    arrayOfChar8[6] = 82;
                    arrayOfChar8[7] = 85;
                    arrayOfChar8[8] = 88;
                    if (arrayContains(arrayOfChar8, c3))
                    {
                      k = i;
                      c4 = '4';
                    }
                    else
                    {
                      k = i;
                      c4 = '8';
                    }
                  }
                  else
                  {
                    char[] arrayOfChar6 = new char[2];
                    arrayOfChar6[0] = 83;
                    arrayOfChar6[1] = 90;
                    if (!arrayContains(arrayOfChar6, c1))
                    {
                      char[] arrayOfChar7 = new char[7];
                      arrayOfChar7[0] = 65;
                      arrayOfChar7[1] = 72;
                      arrayOfChar7[2] = 79;
                      arrayOfChar7[3] = 85;
                      arrayOfChar7[4] = 75;
                      arrayOfChar7[5] = 81;
                      arrayOfChar7[6] = 88;
                      if (arrayContains(arrayOfChar7, c3)) {}
                    }
                    else
                    {
                      k = i;
                      c4 = '8';
                      continue;
                    }
                    k = i;
                    c4 = '4';
                  }
                }
                else
                {
                  char[] arrayOfChar5 = new char[3];
                  arrayOfChar5[0] = 84;
                  arrayOfChar5[1] = 68;
                  arrayOfChar5[2] = 88;
                  if (arrayContains(arrayOfChar5, c2))
                  {
                    k = i;
                    c4 = '8';
                  }
                  else if (c2 == 'R')
                  {
                    int i2 = i;
                    c4 = '7';
                    k = i2;
                  }
                  else if (c2 == 'L')
                  {
                    int i1 = i;
                    c4 = '5';
                    k = i1;
                  }
                  else if ((c2 == 'M') || (c2 == 'N'))
                  {
                    int n = i;
                    c4 = '6';
                    k = n;
                  }
                  else
                  {
                    k = i;
                    c4 = c2;
                  }
                }
              }
            }
          }
        }
      }
    }
  }
  
  public Object encode(Object paramObject)
  {
    if (!(paramObject instanceof String)) {
      throw new EncoderException("This method’s parameter was expected to be of the type " + String.class.getName() + ". But actually it was of the type " + paramObject.getClass().getName() + ".");
    }
    return encode((String)paramObject);
  }
  
  public String encode(String paramString)
  {
    return colognePhonetic(paramString);
  }
  
  public boolean isEncodeEqual(String paramString1, String paramString2)
  {
    return colognePhonetic(paramString1).equals(colognePhonetic(paramString2));
  }
}


/* Location:           C:\Users\dreadiscool\Desktop\tools\classes-dex2jar.jar
 * Qualified Name:     com.parse.codec.language.ColognePhonetic
 * JD-Core Version:    0.7.0.1
 */