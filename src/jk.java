import java.util.Arrays;

public final class jk
{
  public static final Object a = new Object();
  
  public static int a(int[] paramArrayOfInt)
  {
    if ((paramArrayOfInt == null) || (paramArrayOfInt.length == 0)) {}
    for (int i = 0;; i = Arrays.hashCode(paramArrayOfInt)) {
      return i;
    }
  }
  
  public static int a(Object[] paramArrayOfObject)
  {
    int i = 0;
    if (paramArrayOfObject == null) {}
    for (int j = 0;; j = paramArrayOfObject.length) {
      for (int k = 0; k < j; k++)
      {
        Object localObject = paramArrayOfObject[k];
        if (localObject != null) {
          i = i * 31 + localObject.hashCode();
        }
      }
    }
    return i;
  }
  
  public static boolean a(int[] paramArrayOfInt1, int[] paramArrayOfInt2)
  {
    boolean bool;
    if ((paramArrayOfInt1 == null) || (paramArrayOfInt1.length == 0)) {
      if ((paramArrayOfInt2 == null) || (paramArrayOfInt2.length == 0)) {
        bool = true;
      }
    }
    for (;;)
    {
      return bool;
      bool = false;
      continue;
      bool = Arrays.equals(paramArrayOfInt1, paramArrayOfInt2);
    }
  }
  
  public static boolean a(Object[] paramArrayOfObject1, Object[] paramArrayOfObject2)
  {
    boolean bool = false;
    int i;
    if (paramArrayOfObject1 == null)
    {
      i = 0;
      if (paramArrayOfObject2 != null) {
        break label46;
      }
    }
    int k;
    int m;
    label46:
    for (int j = 0;; j = paramArrayOfObject2.length)
    {
      k = 0;
      for (m = 0; (m < i) && (paramArrayOfObject1[m] == null); m++) {}
      i = paramArrayOfObject1.length;
      break;
    }
    for (;;)
    {
      int n;
      if ((n < j) && (paramArrayOfObject2[n] == null))
      {
        n++;
      }
      else
      {
        int i1;
        int i2;
        if (m >= i)
        {
          i1 = 1;
          if (n < j) {
            break label112;
          }
          i2 = 1;
          label92:
          if ((i1 == 0) || (i2 == 0)) {
            break label118;
          }
          bool = true;
        }
        label112:
        label118:
        while ((i1 != i2) || (!paramArrayOfObject1[m].equals(paramArrayOfObject2[n])))
        {
          return bool;
          i1 = 0;
          break;
          i2 = 0;
          break label92;
        }
        int i3 = m + 1;
        k = n + 1;
        m = i3;
        break;
        n = k;
      }
    }
  }
}


/* Location:           C:\Users\dreadiscool\Desktop\tools\classes-dex2jar.jar
 * Qualified Name:     jk
 * JD-Core Version:    0.7.0.1
 */