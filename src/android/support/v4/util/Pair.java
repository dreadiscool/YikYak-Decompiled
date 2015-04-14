package android.support.v4.util;

public class Pair<F, S>
{
  public final F first;
  public final S second;
  
  public Pair(F paramF, S paramS)
  {
    this.first = paramF;
    this.second = paramS;
  }
  
  public static <A, B> Pair<A, B> create(A paramA, B paramB)
  {
    return new Pair(paramA, paramB);
  }
  
  private static boolean objectsEqual(Object paramObject1, Object paramObject2)
  {
    if ((paramObject1 == paramObject2) || ((paramObject1 != null) && (paramObject1.equals(paramObject2)))) {}
    for (boolean bool = true;; bool = false) {
      return bool;
    }
  }
  
  public boolean equals(Object paramObject)
  {
    boolean bool = false;
    if (!(paramObject instanceof Pair)) {}
    for (;;)
    {
      return bool;
      Pair localPair = (Pair)paramObject;
      if ((objectsEqual(localPair.first, this.first)) && (objectsEqual(localPair.second, this.second))) {
        bool = true;
      }
    }
  }
  
  public int hashCode()
  {
    int i = 0;
    int j;
    if (this.first == null)
    {
      j = 0;
      if (this.second != null) {
        break label33;
      }
    }
    for (;;)
    {
      return j ^ i;
      j = this.first.hashCode();
      break;
      label33:
      i = this.second.hashCode();
    }
  }
}


/* Location:           C:\Users\dreadiscool\Desktop\tools\classes-dex2jar.jar
 * Qualified Name:     android.support.v4.util.Pair
 * JD-Core Version:    0.7.0.1
 */