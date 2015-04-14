public final class AB
{
  public static boolean a(String paramString)
  {
    if ((paramString.equals("POST")) || (paramString.equals("PATCH")) || (paramString.equals("PUT")) || (paramString.equals("DELETE"))) {}
    for (boolean bool = true;; bool = false) {
      return bool;
    }
  }
  
  public static boolean b(String paramString)
  {
    if ((paramString.equals("POST")) || (paramString.equals("PUT")) || (paramString.equals("PATCH"))) {}
    for (boolean bool = true;; bool = false) {
      return bool;
    }
  }
  
  public static boolean c(String paramString)
  {
    if ((b(paramString)) || (paramString.equals("DELETE"))) {}
    for (boolean bool = true;; bool = false) {
      return bool;
    }
  }
}


/* Location:           C:\Users\dreadiscool\Desktop\tools\classes-dex2jar.jar
 * Qualified Name:     AB
 * JD-Core Version:    0.7.0.1
 */