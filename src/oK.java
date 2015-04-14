public enum oK
  implements oQ
{
  static
  {
    oK[] arrayOfoK = new oK[5];
    arrayOfoK[0] = a;
    arrayOfoK[1] = b;
    arrayOfoK[2] = c;
    arrayOfoK[3] = d;
    arrayOfoK[4] = e;
    f = arrayOfoK;
  }
  
  private oK() {}
  
  private static String a(char paramChar, String paramString, int paramInt)
  {
    if (paramInt < paramString.length()) {}
    for (String str = paramChar + paramString.substring(paramInt);; str = String.valueOf(paramChar)) {
      return str;
    }
  }
  
  private static String b(String paramString)
  {
    StringBuilder localStringBuilder = new StringBuilder();
    int i = 0;
    char c1 = paramString.charAt(0);
    if ((i >= -1 + paramString.length()) || (Character.isLetter(c1)))
    {
      if (i != paramString.length()) {
        break label67;
      }
      paramString = localStringBuilder.toString();
    }
    for (;;)
    {
      return paramString;
      localStringBuilder.append(c1);
      i++;
      c1 = paramString.charAt(i);
      break;
      label67:
      if (!Character.isUpperCase(c1)) {
        paramString = a(Character.toUpperCase(c1), paramString, i + 1);
      }
    }
  }
  
  private static String b(String paramString1, String paramString2)
  {
    StringBuilder localStringBuilder = new StringBuilder();
    for (int i = 0; i < paramString1.length(); i++)
    {
      char c1 = paramString1.charAt(i);
      if ((Character.isUpperCase(c1)) && (localStringBuilder.length() != 0)) {
        localStringBuilder.append(paramString2);
      }
      localStringBuilder.append(c1);
    }
    return localStringBuilder.toString();
  }
}


/* Location:           C:\Users\dreadiscool\Desktop\tools\classes-dex2jar.jar
 * Qualified Name:     oK
 * JD-Core Version:    0.7.0.1
 */