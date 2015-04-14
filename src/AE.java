import java.util.Comparator;

final class AE
  implements Comparator<String>
{
  public int a(String paramString1, String paramString2)
  {
    int i;
    if (paramString1 == paramString2) {
      i = 0;
    }
    for (;;)
    {
      return i;
      if (paramString1 == null) {
        i = -1;
      } else if (paramString2 == null) {
        i = 1;
      } else {
        i = String.CASE_INSENSITIVE_ORDER.compare(paramString1, paramString2);
      }
    }
  }
}


/* Location:           C:\Users\dreadiscool\Desktop\tools\classes-dex2jar.jar
 * Qualified Name:     AE
 * JD-Core Version:    0.7.0.1
 */