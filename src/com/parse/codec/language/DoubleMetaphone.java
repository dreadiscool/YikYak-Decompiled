package com.parse.codec.language;

import com.parse.codec.EncoderException;
import com.parse.codec.StringEncoder;
import java.util.Locale;

public class DoubleMetaphone
  implements StringEncoder
{
  private static final String[] ES_EP_EB_EL_EY_IB_IL_IN_IE_EI_ER;
  private static final String[] L_R_N_M_B_H_F_V_W_SPACE;
  private static final String[] L_T_K_S_N_M_B_Z;
  private static final String[] SILENT_START;
  private static final String VOWELS = "AEIOUY";
  private int maxCodeLen = 4;
  
  static
  {
    String[] arrayOfString1 = new String[5];
    arrayOfString1[0] = "GN";
    arrayOfString1[1] = "KN";
    arrayOfString1[2] = "PN";
    arrayOfString1[3] = "WR";
    arrayOfString1[4] = "PS";
    SILENT_START = arrayOfString1;
    String[] arrayOfString2 = new String[10];
    arrayOfString2[0] = "L";
    arrayOfString2[1] = "R";
    arrayOfString2[2] = "N";
    arrayOfString2[3] = "M";
    arrayOfString2[4] = "B";
    arrayOfString2[5] = "H";
    arrayOfString2[6] = "F";
    arrayOfString2[7] = "V";
    arrayOfString2[8] = "W";
    arrayOfString2[9] = " ";
    L_R_N_M_B_H_F_V_W_SPACE = arrayOfString2;
    String[] arrayOfString3 = new String[11];
    arrayOfString3[0] = "ES";
    arrayOfString3[1] = "EP";
    arrayOfString3[2] = "EB";
    arrayOfString3[3] = "EL";
    arrayOfString3[4] = "EY";
    arrayOfString3[5] = "IB";
    arrayOfString3[6] = "IL";
    arrayOfString3[7] = "IN";
    arrayOfString3[8] = "IE";
    arrayOfString3[9] = "EI";
    arrayOfString3[10] = "ER";
    ES_EP_EB_EL_EY_IB_IL_IN_IE_EI_ER = arrayOfString3;
    String[] arrayOfString4 = new String[8];
    arrayOfString4[0] = "L";
    arrayOfString4[1] = "T";
    arrayOfString4[2] = "K";
    arrayOfString4[3] = "S";
    arrayOfString4[4] = "N";
    arrayOfString4[5] = "M";
    arrayOfString4[6] = "B";
    arrayOfString4[7] = "Z";
    L_T_K_S_N_M_B_Z = arrayOfString4;
  }
  
  private String cleanInput(String paramString)
  {
    String str1 = null;
    if (paramString == null) {}
    for (;;)
    {
      return str1;
      String str2 = paramString.trim();
      if (str2.length() != 0) {
        str1 = str2.toUpperCase(Locale.ENGLISH);
      }
    }
  }
  
  private boolean conditionC0(String paramString, int paramInt)
  {
    boolean bool = false;
    if (contains(paramString, paramInt, 4, "CHIA")) {}
    for (bool = true;; bool = true)
    {
      int i;
      do
      {
        do
        {
          return bool;
        } while ((paramInt <= 1) || (isVowel(charAt(paramString, paramInt - 2))) || (!contains(paramString, paramInt - 1, 3, "ACH")));
        i = charAt(paramString, paramInt + 2);
      } while (((i == 73) || (i == 69)) && (!contains(paramString, paramInt - 2, 6, "BACHER", "MACHER")));
    }
  }
  
  private boolean conditionCH0(String paramString, int paramInt)
  {
    boolean bool;
    if (paramInt != 0) {
      bool = false;
    }
    for (;;)
    {
      return bool;
      if ((!contains(paramString, paramInt + 1, 5, "HARAC", "HARIS")) && (!contains(paramString, paramInt + 1, 3, "HOR", "HYM", "HIA", "HEM"))) {
        bool = false;
      } else if (contains(paramString, 0, 5, "CHORE")) {
        bool = false;
      } else {
        bool = true;
      }
    }
  }
  
  private boolean conditionCH1(String paramString, int paramInt)
  {
    if ((contains(paramString, 0, 4, "VAN ", "VON ")) || (contains(paramString, 0, 3, "SCH")) || (contains(paramString, paramInt - 2, 6, "ORCHES", "ARCHIT", "ORCHID")) || (contains(paramString, paramInt + 2, 1, "T", "S")) || (((contains(paramString, paramInt - 1, 1, "A", "O", "U", "E")) || (paramInt == 0)) && ((contains(paramString, paramInt + 2, 1, L_R_N_M_B_H_F_V_W_SPACE)) || (paramInt + 1 == -1 + paramString.length())))) {}
    for (boolean bool = true;; bool = false) {
      return bool;
    }
  }
  
  private boolean conditionL0(String paramString, int paramInt)
  {
    boolean bool;
    if ((paramInt == -3 + paramString.length()) && (contains(paramString, paramInt - 1, 4, "ILLO", "ILLA", "ALLE"))) {
      bool = true;
    }
    for (;;)
    {
      return bool;
      if (((contains(paramString, -2 + paramString.length(), 2, "AS", "OS")) || (contains(paramString, -1 + paramString.length(), 1, "A", "O"))) && (contains(paramString, paramInt - 1, 4, "ALLE"))) {
        bool = true;
      } else {
        bool = false;
      }
    }
  }
  
  private boolean conditionM0(String paramString, int paramInt)
  {
    boolean bool = true;
    if (charAt(paramString, paramInt + 1) == 'M') {}
    for (;;)
    {
      return bool;
      if ((!contains(paramString, paramInt - 1, 3, "UMB")) || ((paramInt + 1 != -1 + paramString.length()) && (!contains(paramString, paramInt + 2, 2, "ER")))) {
        bool = false;
      }
    }
  }
  
  private static boolean contains(String paramString1, int paramInt1, int paramInt2, String paramString2)
  {
    String[] arrayOfString = new String[1];
    arrayOfString[0] = paramString2;
    return contains(paramString1, paramInt1, paramInt2, arrayOfString);
  }
  
  private static boolean contains(String paramString1, int paramInt1, int paramInt2, String paramString2, String paramString3)
  {
    String[] arrayOfString = new String[2];
    arrayOfString[0] = paramString2;
    arrayOfString[1] = paramString3;
    return contains(paramString1, paramInt1, paramInt2, arrayOfString);
  }
  
  private static boolean contains(String paramString1, int paramInt1, int paramInt2, String paramString2, String paramString3, String paramString4)
  {
    String[] arrayOfString = new String[3];
    arrayOfString[0] = paramString2;
    arrayOfString[1] = paramString3;
    arrayOfString[2] = paramString4;
    return contains(paramString1, paramInt1, paramInt2, arrayOfString);
  }
  
  private static boolean contains(String paramString1, int paramInt1, int paramInt2, String paramString2, String paramString3, String paramString4, String paramString5)
  {
    String[] arrayOfString = new String[4];
    arrayOfString[0] = paramString2;
    arrayOfString[1] = paramString3;
    arrayOfString[2] = paramString4;
    arrayOfString[3] = paramString5;
    return contains(paramString1, paramInt1, paramInt2, arrayOfString);
  }
  
  private static boolean contains(String paramString1, int paramInt1, int paramInt2, String paramString2, String paramString3, String paramString4, String paramString5, String paramString6)
  {
    String[] arrayOfString = new String[5];
    arrayOfString[0] = paramString2;
    arrayOfString[1] = paramString3;
    arrayOfString[2] = paramString4;
    arrayOfString[3] = paramString5;
    arrayOfString[4] = paramString6;
    return contains(paramString1, paramInt1, paramInt2, arrayOfString);
  }
  
  private static boolean contains(String paramString1, int paramInt1, int paramInt2, String paramString2, String paramString3, String paramString4, String paramString5, String paramString6, String paramString7)
  {
    String[] arrayOfString = new String[6];
    arrayOfString[0] = paramString2;
    arrayOfString[1] = paramString3;
    arrayOfString[2] = paramString4;
    arrayOfString[3] = paramString5;
    arrayOfString[4] = paramString6;
    arrayOfString[5] = paramString7;
    return contains(paramString1, paramInt1, paramInt2, arrayOfString);
  }
  
  protected static boolean contains(String paramString, int paramInt1, int paramInt2, String[] paramArrayOfString)
  {
    boolean bool = false;
    String str;
    if ((paramInt1 >= 0) && (paramInt1 + paramInt2 <= paramString.length())) {
      str = paramString.substring(paramInt1, paramInt1 + paramInt2);
    }
    for (int i = 0;; i++) {
      if (i < paramArrayOfString.length)
      {
        if (str.equals(paramArrayOfString[i])) {
          bool = true;
        }
      }
      else {
        return bool;
      }
    }
  }
  
  private int handleAEIOUY(DoubleMetaphone.DoubleMetaphoneResult paramDoubleMetaphoneResult, int paramInt)
  {
    if (paramInt == 0) {
      paramDoubleMetaphoneResult.append('A');
    }
    return paramInt + 1;
  }
  
  private int handleC(String paramString, DoubleMetaphone.DoubleMetaphoneResult paramDoubleMetaphoneResult, int paramInt)
  {
    int i;
    if (conditionC0(paramString, paramInt))
    {
      paramDoubleMetaphoneResult.append('K');
      i = paramInt + 2;
    }
    for (;;)
    {
      return i;
      if ((paramInt == 0) && (contains(paramString, paramInt, 6, "CAESAR")))
      {
        paramDoubleMetaphoneResult.append('S');
        i = paramInt + 2;
      }
      else if (contains(paramString, paramInt, 2, "CH"))
      {
        i = handleCH(paramString, paramDoubleMetaphoneResult, paramInt);
      }
      else if ((contains(paramString, paramInt, 2, "CZ")) && (!contains(paramString, paramInt - 2, 4, "WICZ")))
      {
        paramDoubleMetaphoneResult.append('S', 'X');
        i = paramInt + 2;
      }
      else if (contains(paramString, paramInt + 1, 3, "CIA"))
      {
        paramDoubleMetaphoneResult.append('X');
        i = paramInt + 3;
      }
      else if ((contains(paramString, paramInt, 2, "CC")) && ((paramInt != 1) || (charAt(paramString, 0) != 'M')))
      {
        i = handleCC(paramString, paramDoubleMetaphoneResult, paramInt);
      }
      else if (contains(paramString, paramInt, 2, "CK", "CG", "CQ"))
      {
        paramDoubleMetaphoneResult.append('K');
        i = paramInt + 2;
      }
      else
      {
        if (contains(paramString, paramInt, 2, "CI", "CE", "CY"))
        {
          if (contains(paramString, paramInt, 3, "CIO", "CIE", "CIA")) {
            paramDoubleMetaphoneResult.append('S', 'X');
          }
          for (;;)
          {
            i = paramInt + 2;
            break;
            paramDoubleMetaphoneResult.append('S');
          }
        }
        paramDoubleMetaphoneResult.append('K');
        if (contains(paramString, paramInt + 1, 2, " C", " Q", " G")) {
          i = paramInt + 3;
        } else if ((contains(paramString, paramInt + 1, 1, "C", "K", "Q")) && (!contains(paramString, paramInt + 1, 2, "CE", "CI"))) {
          i = paramInt + 2;
        } else {
          i = paramInt + 1;
        }
      }
    }
  }
  
  private int handleCC(String paramString, DoubleMetaphone.DoubleMetaphoneResult paramDoubleMetaphoneResult, int paramInt)
  {
    if ((contains(paramString, paramInt + 2, 1, "I", "E", "H")) && (!contains(paramString, paramInt + 2, 2, "HU"))) {
      if (((paramInt == 1) && (charAt(paramString, paramInt - 1) == 'A')) || (contains(paramString, paramInt - 1, 5, "UCCEE", "UCCES"))) {
        paramDoubleMetaphoneResult.append("KS");
      }
    }
    for (int i = paramInt + 3;; i = paramInt + 2)
    {
      return i;
      paramDoubleMetaphoneResult.append('X');
      break;
      paramDoubleMetaphoneResult.append('K');
    }
  }
  
  private int handleCH(String paramString, DoubleMetaphone.DoubleMetaphoneResult paramDoubleMetaphoneResult, int paramInt)
  {
    int i;
    if ((paramInt > 0) && (contains(paramString, paramInt, 4, "CHAE")))
    {
      paramDoubleMetaphoneResult.append('K', 'X');
      i = paramInt + 2;
    }
    for (;;)
    {
      return i;
      if (conditionCH0(paramString, paramInt))
      {
        paramDoubleMetaphoneResult.append('K');
        i = paramInt + 2;
      }
      else
      {
        if (!conditionCH1(paramString, paramInt)) {
          break;
        }
        paramDoubleMetaphoneResult.append('K');
        i = paramInt + 2;
      }
    }
    if (paramInt > 0) {
      if (contains(paramString, 0, 2, "MC")) {
        paramDoubleMetaphoneResult.append('K');
      }
    }
    for (;;)
    {
      i = paramInt + 2;
      break;
      paramDoubleMetaphoneResult.append('X', 'K');
      continue;
      paramDoubleMetaphoneResult.append('X');
    }
  }
  
  private int handleD(String paramString, DoubleMetaphone.DoubleMetaphoneResult paramDoubleMetaphoneResult, int paramInt)
  {
    int i;
    if (contains(paramString, paramInt, 2, "DG")) {
      if (contains(paramString, paramInt + 2, 1, "I", "E", "Y"))
      {
        paramDoubleMetaphoneResult.append('J');
        i = paramInt + 3;
      }
    }
    for (;;)
    {
      return i;
      paramDoubleMetaphoneResult.append("TK");
      i = paramInt + 2;
      continue;
      if (contains(paramString, paramInt, 2, "DT", "DD"))
      {
        paramDoubleMetaphoneResult.append('T');
        i = paramInt + 2;
      }
      else
      {
        paramDoubleMetaphoneResult.append('T');
        i = paramInt + 1;
      }
    }
  }
  
  private int handleG(String paramString, DoubleMetaphone.DoubleMetaphoneResult paramDoubleMetaphoneResult, int paramInt, boolean paramBoolean)
  {
    int i;
    if (charAt(paramString, paramInt + 1) == 'H') {
      i = handleGH(paramString, paramDoubleMetaphoneResult, paramInt);
    }
    for (;;)
    {
      return i;
      if (charAt(paramString, paramInt + 1) == 'N')
      {
        if ((paramInt == 1) && (isVowel(charAt(paramString, 0))) && (!paramBoolean)) {
          paramDoubleMetaphoneResult.append("KN", "N");
        }
        for (;;)
        {
          i = paramInt + 2;
          break;
          if ((!contains(paramString, paramInt + 2, 2, "EY")) && (charAt(paramString, paramInt + 1) != 'Y') && (!paramBoolean)) {
            paramDoubleMetaphoneResult.append("N", "KN");
          } else {
            paramDoubleMetaphoneResult.append("KN");
          }
        }
      }
      if ((contains(paramString, paramInt + 1, 2, "LI")) && (!paramBoolean))
      {
        paramDoubleMetaphoneResult.append("KL", "L");
        i = paramInt + 2;
      }
      else if ((paramInt == 0) && ((charAt(paramString, paramInt + 1) == 'Y') || (contains(paramString, paramInt + 1, 2, ES_EP_EB_EL_EY_IB_IL_IN_IE_EI_ER))))
      {
        paramDoubleMetaphoneResult.append('K', 'J');
        i = paramInt + 2;
      }
      else if (((contains(paramString, paramInt + 1, 2, "ER")) || (charAt(paramString, paramInt + 1) == 'Y')) && (!contains(paramString, 0, 6, "DANGER", "RANGER", "MANGER")) && (!contains(paramString, paramInt - 1, 1, "E", "I")) && (!contains(paramString, paramInt - 1, 3, "RGY", "OGY")))
      {
        paramDoubleMetaphoneResult.append('K', 'J');
        i = paramInt + 2;
      }
      else
      {
        if ((contains(paramString, paramInt + 1, 1, "E", "I", "Y")) || (contains(paramString, paramInt - 1, 4, "AGGI", "OGGI")))
        {
          if ((contains(paramString, 0, 4, "VAN ", "VON ")) || (contains(paramString, 0, 3, "SCH")) || (contains(paramString, paramInt + 1, 2, "ET"))) {
            paramDoubleMetaphoneResult.append('K');
          }
          for (;;)
          {
            i = paramInt + 2;
            break;
            if (contains(paramString, paramInt + 1, 3, "IER")) {
              paramDoubleMetaphoneResult.append('J');
            } else {
              paramDoubleMetaphoneResult.append('J', 'K');
            }
          }
        }
        if (charAt(paramString, paramInt + 1) == 'G')
        {
          i = paramInt + 2;
          paramDoubleMetaphoneResult.append('K');
        }
        else
        {
          i = paramInt + 1;
          paramDoubleMetaphoneResult.append('K');
        }
      }
    }
  }
  
  private int handleGH(String paramString, DoubleMetaphone.DoubleMetaphoneResult paramDoubleMetaphoneResult, int paramInt)
  {
    int i;
    if ((paramInt > 0) && (!isVowel(charAt(paramString, paramInt - 1))))
    {
      paramDoubleMetaphoneResult.append('K');
      i = paramInt + 2;
    }
    for (;;)
    {
      return i;
      if (paramInt == 0)
      {
        if (charAt(paramString, paramInt + 2) == 'I') {
          paramDoubleMetaphoneResult.append('J');
        }
        for (;;)
        {
          i = paramInt + 2;
          break;
          paramDoubleMetaphoneResult.append('K');
        }
      }
      if (((paramInt <= 1) || (!contains(paramString, paramInt - 2, 1, "B", "H", "D"))) && ((paramInt <= 2) || (!contains(paramString, paramInt - 3, 1, "B", "H", "D"))) && ((paramInt <= 3) || (!contains(paramString, paramInt - 4, 1, "B", "H")))) {
        break;
      }
      i = paramInt + 2;
    }
    if ((paramInt > 2) && (charAt(paramString, paramInt - 1) == 'U') && (contains(paramString, paramInt - 3, 1, "C", "G", "L", "R", "T"))) {
      paramDoubleMetaphoneResult.append('F');
    }
    for (;;)
    {
      i = paramInt + 2;
      break;
      if ((paramInt > 0) && (charAt(paramString, paramInt - 1) != 'I')) {
        paramDoubleMetaphoneResult.append('K');
      }
    }
  }
  
  private int handleH(String paramString, DoubleMetaphone.DoubleMetaphoneResult paramDoubleMetaphoneResult, int paramInt)
  {
    if (((paramInt == 0) || (isVowel(charAt(paramString, paramInt - 1)))) && (isVowel(charAt(paramString, paramInt + 1)))) {
      paramDoubleMetaphoneResult.append('H');
    }
    for (int i = paramInt + 2;; i = paramInt + 1) {
      return i;
    }
  }
  
  private int handleJ(String paramString, DoubleMetaphone.DoubleMetaphoneResult paramDoubleMetaphoneResult, int paramInt, boolean paramBoolean)
  {
    int i;
    if ((contains(paramString, paramInt, 4, "JOSE")) || (contains(paramString, 0, 4, "SAN "))) {
      if (((paramInt == 0) && (charAt(paramString, paramInt + 4) == ' ')) || (paramString.length() == 4) || (contains(paramString, 0, 4, "SAN ")))
      {
        paramDoubleMetaphoneResult.append('H');
        i = paramInt + 1;
      }
    }
    for (;;)
    {
      return i;
      paramDoubleMetaphoneResult.append('J', 'H');
      break;
      if ((paramInt == 0) && (!contains(paramString, paramInt, 4, "JOSE"))) {
        paramDoubleMetaphoneResult.append('J', 'A');
      }
      for (;;)
      {
        if (charAt(paramString, paramInt + 1) != 'J') {
          break label250;
        }
        i = paramInt + 2;
        break;
        if ((isVowel(charAt(paramString, paramInt - 1))) && (!paramBoolean) && ((charAt(paramString, paramInt + 1) == 'A') || (charAt(paramString, paramInt + 1) == 'O'))) {
          paramDoubleMetaphoneResult.append('J', 'H');
        } else if (paramInt == -1 + paramString.length()) {
          paramDoubleMetaphoneResult.append('J', ' ');
        } else if ((!contains(paramString, paramInt + 1, 1, L_T_K_S_N_M_B_Z)) && (!contains(paramString, paramInt - 1, 1, "S", "K", "L"))) {
          paramDoubleMetaphoneResult.append('J');
        }
      }
      label250:
      i = paramInt + 1;
    }
  }
  
  private int handleL(String paramString, DoubleMetaphone.DoubleMetaphoneResult paramDoubleMetaphoneResult, int paramInt)
  {
    int i;
    if (charAt(paramString, paramInt + 1) == 'L') {
      if (conditionL0(paramString, paramInt))
      {
        paramDoubleMetaphoneResult.appendPrimary('L');
        i = paramInt + 2;
      }
    }
    for (;;)
    {
      return i;
      paramDoubleMetaphoneResult.append('L');
      break;
      i = paramInt + 1;
      paramDoubleMetaphoneResult.append('L');
    }
  }
  
  private int handleP(String paramString, DoubleMetaphone.DoubleMetaphoneResult paramDoubleMetaphoneResult, int paramInt)
  {
    int i;
    if (charAt(paramString, paramInt + 1) == 'H')
    {
      paramDoubleMetaphoneResult.append('F');
      i = paramInt + 2;
    }
    for (;;)
    {
      return i;
      paramDoubleMetaphoneResult.append('P');
      if (contains(paramString, paramInt + 1, 1, "P", "B")) {
        i = paramInt + 2;
      } else {
        i = paramInt + 1;
      }
    }
  }
  
  private int handleR(String paramString, DoubleMetaphone.DoubleMetaphoneResult paramDoubleMetaphoneResult, int paramInt, boolean paramBoolean)
  {
    if ((paramInt == -1 + paramString.length()) && (!paramBoolean) && (contains(paramString, paramInt - 2, 2, "IE")) && (!contains(paramString, paramInt - 4, 2, "ME", "MA")))
    {
      paramDoubleMetaphoneResult.appendAlternate('R');
      if (charAt(paramString, paramInt + 1) != 'R') {
        break label82;
      }
    }
    label82:
    for (int i = paramInt + 2;; i = paramInt + 1)
    {
      return i;
      paramDoubleMetaphoneResult.append('R');
      break;
    }
  }
  
  private int handleS(String paramString, DoubleMetaphone.DoubleMetaphoneResult paramDoubleMetaphoneResult, int paramInt, boolean paramBoolean)
  {
    int i;
    if (contains(paramString, paramInt - 1, 3, "ISL", "YSL")) {
      i = paramInt + 1;
    }
    for (;;)
    {
      return i;
      if ((paramInt == 0) && (contains(paramString, paramInt, 5, "SUGAR")))
      {
        paramDoubleMetaphoneResult.append('X', 'S');
        i = paramInt + 1;
      }
      else
      {
        if (contains(paramString, paramInt, 2, "SH"))
        {
          if (contains(paramString, paramInt + 1, 4, "HEIM", "HOEK", "HOLM", "HOLZ")) {
            paramDoubleMetaphoneResult.append('S');
          }
          for (;;)
          {
            i = paramInt + 2;
            break;
            paramDoubleMetaphoneResult.append('X');
          }
        }
        if ((contains(paramString, paramInt, 3, "SIO", "SIA")) || (contains(paramString, paramInt, 4, "SIAN")))
        {
          if (paramBoolean) {
            paramDoubleMetaphoneResult.append('S');
          }
          for (;;)
          {
            i = paramInt + 3;
            break;
            paramDoubleMetaphoneResult.append('S', 'X');
          }
        }
        if (((paramInt == 0) && (contains(paramString, paramInt + 1, 1, "M", "N", "L", "W"))) || (contains(paramString, paramInt + 1, 1, "Z")))
        {
          paramDoubleMetaphoneResult.append('S', 'X');
          if (contains(paramString, paramInt + 1, 1, "Z")) {
            i = paramInt + 2;
          } else {
            i = paramInt + 1;
          }
        }
        else if (contains(paramString, paramInt, 2, "SC"))
        {
          i = handleSC(paramString, paramDoubleMetaphoneResult, paramInt);
        }
        else
        {
          if ((paramInt == -1 + paramString.length()) && (contains(paramString, paramInt - 2, 2, "AI", "OI"))) {
            paramDoubleMetaphoneResult.appendAlternate('S');
          }
          for (;;)
          {
            if (!contains(paramString, paramInt + 1, 1, "S", "Z")) {
              break label335;
            }
            i = paramInt + 2;
            break;
            paramDoubleMetaphoneResult.append('S');
          }
          label335:
          i = paramInt + 1;
        }
      }
    }
  }
  
  private int handleSC(String paramString, DoubleMetaphone.DoubleMetaphoneResult paramDoubleMetaphoneResult, int paramInt)
  {
    if (charAt(paramString, paramInt + 2) == 'H') {
      if (contains(paramString, paramInt + 3, 2, "OO", "ER", "EN", "UY", "ED", "EM")) {
        if (contains(paramString, paramInt + 3, 2, "ER", "EN")) {
          paramDoubleMetaphoneResult.append("X", "SK");
        }
      }
    }
    for (;;)
    {
      return paramInt + 3;
      paramDoubleMetaphoneResult.append("SK");
      continue;
      if ((paramInt == 0) && (!isVowel(charAt(paramString, 3))) && (charAt(paramString, 3) != 'W'))
      {
        paramDoubleMetaphoneResult.append('X', 'S');
      }
      else
      {
        paramDoubleMetaphoneResult.append('X');
        continue;
        if (contains(paramString, paramInt + 2, 1, "I", "E", "Y")) {
          paramDoubleMetaphoneResult.append('S');
        } else {
          paramDoubleMetaphoneResult.append("SK");
        }
      }
    }
  }
  
  private int handleT(String paramString, DoubleMetaphone.DoubleMetaphoneResult paramDoubleMetaphoneResult, int paramInt)
  {
    int i;
    if (contains(paramString, paramInt, 4, "TION"))
    {
      paramDoubleMetaphoneResult.append('X');
      i = paramInt + 3;
    }
    for (;;)
    {
      return i;
      if (contains(paramString, paramInt, 3, "TIA", "TCH"))
      {
        paramDoubleMetaphoneResult.append('X');
        i = paramInt + 3;
      }
      else
      {
        if ((contains(paramString, paramInt, 2, "TH")) || (contains(paramString, paramInt, 3, "TTH")))
        {
          if ((contains(paramString, paramInt + 2, 2, "OM", "AM")) || (contains(paramString, 0, 4, "VAN ", "VON ")) || (contains(paramString, 0, 3, "SCH"))) {
            paramDoubleMetaphoneResult.append('T');
          }
          for (;;)
          {
            i = paramInt + 2;
            break;
            paramDoubleMetaphoneResult.append('0', 'T');
          }
        }
        paramDoubleMetaphoneResult.append('T');
        if (contains(paramString, paramInt + 1, 1, "T", "D")) {
          i = paramInt + 2;
        } else {
          i = paramInt + 1;
        }
      }
    }
  }
  
  private int handleW(String paramString, DoubleMetaphone.DoubleMetaphoneResult paramDoubleMetaphoneResult, int paramInt)
  {
    int i;
    if (contains(paramString, paramInt, 2, "WR"))
    {
      paramDoubleMetaphoneResult.append('R');
      i = paramInt + 2;
    }
    for (;;)
    {
      return i;
      if ((paramInt == 0) && ((isVowel(charAt(paramString, paramInt + 1))) || (contains(paramString, paramInt, 2, "WH"))))
      {
        if (isVowel(charAt(paramString, paramInt + 1))) {
          paramDoubleMetaphoneResult.append('A', 'F');
        }
        for (;;)
        {
          i = paramInt + 1;
          break;
          paramDoubleMetaphoneResult.append('A');
        }
      }
      if (((paramInt == -1 + paramString.length()) && (isVowel(charAt(paramString, paramInt - 1)))) || (contains(paramString, paramInt - 1, 5, "EWSKI", "EWSKY", "OWSKI", "OWSKY")) || (contains(paramString, 0, 3, "SCH")))
      {
        paramDoubleMetaphoneResult.appendAlternate('F');
        i = paramInt + 1;
      }
      else if (contains(paramString, paramInt, 4, "WICZ", "WITZ"))
      {
        paramDoubleMetaphoneResult.append("TS", "FX");
        i = paramInt + 4;
      }
      else
      {
        i = paramInt + 1;
      }
    }
  }
  
  private int handleX(String paramString, DoubleMetaphone.DoubleMetaphoneResult paramDoubleMetaphoneResult, int paramInt)
  {
    int i;
    if (paramInt == 0)
    {
      paramDoubleMetaphoneResult.append('S');
      i = paramInt + 1;
    }
    for (;;)
    {
      return i;
      if ((paramInt != -1 + paramString.length()) || ((!contains(paramString, paramInt - 3, 3, "IAU", "EAU")) && (!contains(paramString, paramInt - 2, 2, "AU", "OU")))) {
        paramDoubleMetaphoneResult.append("KS");
      }
      if (contains(paramString, paramInt + 1, 1, "C", "X")) {
        i = paramInt + 2;
      } else {
        i = paramInt + 1;
      }
    }
  }
  
  private int handleZ(String paramString, DoubleMetaphone.DoubleMetaphoneResult paramDoubleMetaphoneResult, int paramInt, boolean paramBoolean)
  {
    int i;
    if (charAt(paramString, paramInt + 1) == 'H')
    {
      paramDoubleMetaphoneResult.append('J');
      i = paramInt + 2;
    }
    for (;;)
    {
      return i;
      if ((contains(paramString, paramInt + 1, 2, "ZO", "ZI", "ZA")) || ((paramBoolean) && (paramInt > 0) && (charAt(paramString, paramInt - 1) != 'T'))) {
        paramDoubleMetaphoneResult.append("S", "TS");
      }
      for (;;)
      {
        if (charAt(paramString, paramInt + 1) != 'Z') {
          break label108;
        }
        i = paramInt + 2;
        break;
        paramDoubleMetaphoneResult.append('S');
      }
      label108:
      i = paramInt + 1;
    }
  }
  
  private boolean isSilentStart(String paramString)
  {
    boolean bool = false;
    for (int i = 0;; i++) {
      if (i < SILENT_START.length)
      {
        if (paramString.startsWith(SILENT_START[i])) {
          bool = true;
        }
      }
      else {
        return bool;
      }
    }
  }
  
  private boolean isSlavoGermanic(String paramString)
  {
    if ((paramString.indexOf('W') > -1) || (paramString.indexOf('K') > -1) || (paramString.indexOf("CZ") > -1) || (paramString.indexOf("WITZ") > -1)) {}
    for (boolean bool = true;; bool = false) {
      return bool;
    }
  }
  
  private boolean isVowel(char paramChar)
  {
    if ("AEIOUY".indexOf(paramChar) != -1) {}
    for (boolean bool = true;; bool = false) {
      return bool;
    }
  }
  
  protected char charAt(String paramString, int paramInt)
  {
    if ((paramInt < 0) || (paramInt >= paramString.length())) {}
    for (char c = '\000';; c = paramString.charAt(paramInt)) {
      return c;
    }
  }
  
  public String doubleMetaphone(String paramString)
  {
    return doubleMetaphone(paramString, false);
  }
  
  public String doubleMetaphone(String paramString, boolean paramBoolean)
  {
    String str1 = cleanInput(paramString);
    String str2;
    if (str1 == null) {
      str2 = null;
    }
    for (;;)
    {
      return str2;
      boolean bool = isSlavoGermanic(str1);
      int i;
      DoubleMetaphone.DoubleMetaphoneResult localDoubleMetaphoneResult;
      if (isSilentStart(str1))
      {
        i = 1;
        localDoubleMetaphoneResult = new DoubleMetaphone.DoubleMetaphoneResult(this, getMaxCodeLen());
      }
      for (;;)
      {
        if ((localDoubleMetaphoneResult.isComplete()) || (i > -1 + str1.length())) {
          break label778;
        }
        switch (str1.charAt(i))
        {
        default: 
          i++;
          continue;
          i = 0;
          break;
        case 'A': 
        case 'E': 
        case 'I': 
        case 'O': 
        case 'U': 
        case 'Y': 
          i = handleAEIOUY(localDoubleMetaphoneResult, i);
          break;
        case 'B': 
          localDoubleMetaphoneResult.append('P');
          if (charAt(str1, i + 1) == 'B') {
            i += 2;
          } else {
            i++;
          }
          break;
        case 'Ç': 
          localDoubleMetaphoneResult.append('S');
          i++;
          break;
        case 'C': 
          i = handleC(str1, localDoubleMetaphoneResult, i);
          break;
        case 'D': 
          i = handleD(str1, localDoubleMetaphoneResult, i);
          break;
        case 'F': 
          localDoubleMetaphoneResult.append('F');
          if (charAt(str1, i + 1) == 'F') {
            i += 2;
          } else {
            i++;
          }
          break;
        case 'G': 
          i = handleG(str1, localDoubleMetaphoneResult, i, bool);
          break;
        case 'H': 
          i = handleH(str1, localDoubleMetaphoneResult, i);
          break;
        case 'J': 
          i = handleJ(str1, localDoubleMetaphoneResult, i, bool);
          break;
        case 'K': 
          localDoubleMetaphoneResult.append('K');
          if (charAt(str1, i + 1) == 'K') {
            i += 2;
          } else {
            i++;
          }
          break;
        case 'L': 
          i = handleL(str1, localDoubleMetaphoneResult, i);
          break;
        case 'M': 
          localDoubleMetaphoneResult.append('M');
          if (conditionM0(str1, i)) {
            i += 2;
          } else {
            i++;
          }
          break;
        case 'N': 
          localDoubleMetaphoneResult.append('N');
          if (charAt(str1, i + 1) == 'N') {
            i += 2;
          } else {
            i++;
          }
          break;
        case 'Ñ': 
          localDoubleMetaphoneResult.append('N');
          i++;
          break;
        case 'P': 
          i = handleP(str1, localDoubleMetaphoneResult, i);
          break;
        case 'Q': 
          localDoubleMetaphoneResult.append('K');
          if (charAt(str1, i + 1) == 'Q') {
            i += 2;
          } else {
            i++;
          }
          break;
        case 'R': 
          i = handleR(str1, localDoubleMetaphoneResult, i, bool);
          break;
        case 'S': 
          i = handleS(str1, localDoubleMetaphoneResult, i, bool);
          break;
        case 'T': 
          i = handleT(str1, localDoubleMetaphoneResult, i);
          break;
        case 'V': 
          localDoubleMetaphoneResult.append('F');
          if (charAt(str1, i + 1) == 'V') {
            i += 2;
          } else {
            i++;
          }
          break;
        case 'W': 
          i = handleW(str1, localDoubleMetaphoneResult, i);
          break;
        case 'X': 
          i = handleX(str1, localDoubleMetaphoneResult, i);
          break;
        case 'Z': 
          i = handleZ(str1, localDoubleMetaphoneResult, i, bool);
        }
      }
      label778:
      if (paramBoolean) {
        str2 = localDoubleMetaphoneResult.getAlternate();
      } else {
        str2 = localDoubleMetaphoneResult.getPrimary();
      }
    }
  }
  
  public Object encode(Object paramObject)
  {
    if (!(paramObject instanceof String)) {
      throw new EncoderException("DoubleMetaphone encode parameter is not of type String");
    }
    return doubleMetaphone((String)paramObject);
  }
  
  public String encode(String paramString)
  {
    return doubleMetaphone(paramString);
  }
  
  public int getMaxCodeLen()
  {
    return this.maxCodeLen;
  }
  
  public boolean isDoubleMetaphoneEqual(String paramString1, String paramString2)
  {
    return isDoubleMetaphoneEqual(paramString1, paramString2, false);
  }
  
  public boolean isDoubleMetaphoneEqual(String paramString1, String paramString2, boolean paramBoolean)
  {
    return doubleMetaphone(paramString1, paramBoolean).equals(doubleMetaphone(paramString2, paramBoolean));
  }
  
  public void setMaxCodeLen(int paramInt)
  {
    this.maxCodeLen = paramInt;
  }
}


/* Location:           C:\Users\dreadiscool\Desktop\tools\classes-dex2jar.jar
 * Qualified Name:     com.parse.codec.language.DoubleMetaphone
 * JD-Core Version:    0.7.0.1
 */