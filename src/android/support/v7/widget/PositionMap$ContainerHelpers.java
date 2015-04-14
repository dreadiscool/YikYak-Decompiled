package android.support.v7.widget;

class PositionMap$ContainerHelpers
{
  static final boolean[] EMPTY_BOOLEANS = new boolean[0];
  static final int[] EMPTY_INTS = new int[0];
  static final long[] EMPTY_LONGS = new long[0];
  static final Object[] EMPTY_OBJECTS = new Object[0];
  
  static int binarySearch(int[] paramArrayOfInt, int paramInt1, int paramInt2)
  {
    int i = 0;
    int j = paramInt1 - 1;
    int m;
    for (;;)
    {
      if (i > j) {
        break label63;
      }
      m = i + j >>> 1;
      int n = paramArrayOfInt[m];
      if (n < paramInt2)
      {
        i = m + 1;
      }
      else
      {
        if (n <= paramInt2) {
          break;
        }
        j = m - 1;
      }
    }
    label63:
    for (int k = m;; k = i ^ 0xFFFFFFFF) {
      return k;
    }
  }
}


/* Location:           C:\Users\dreadiscool\Desktop\tools\classes-dex2jar.jar
 * Qualified Name:     android.support.v7.widget.PositionMap.ContainerHelpers
 * JD-Core Version:    0.7.0.1
 */