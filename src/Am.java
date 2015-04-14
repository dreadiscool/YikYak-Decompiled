public final class Am
{
  public static int a(String paramString, int paramInt)
  {
    for (;;)
    {
      if (paramInt < paramString.length())
      {
        int i = paramString.charAt(paramInt);
        if ((i == 32) || (i == 9)) {}
      }
      else
      {
        return paramInt;
      }
      paramInt++;
    }
  }
  
  public static int a(String paramString1, int paramInt, String paramString2)
  {
    for (;;)
    {
      if ((paramInt >= paramString1.length()) || (paramString2.indexOf(paramString1.charAt(paramInt)) != -1)) {
        return paramInt;
      }
      paramInt++;
    }
  }
  
  public static int b(String paramString, int paramInt)
  {
    for (;;)
    {
      try
      {
        l = Long.parseLong(paramString);
        if (l <= 2147483647L) {
          continue;
        }
        paramInt = 2147483647;
      }
      catch (NumberFormatException localNumberFormatException)
      {
        long l;
        continue;
      }
      return paramInt;
      if (l < 0L) {
        paramInt = 0;
      } else {
        paramInt = (int)l;
      }
    }
  }
}


/* Location:           C:\Users\dreadiscool\Desktop\tools\classes-dex2jar.jar
 * Qualified Name:     Am
 * JD-Core Version:    0.7.0.1
 */