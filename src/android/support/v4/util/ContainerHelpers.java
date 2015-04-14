package android.support.v4.util;

class ContainerHelpers
{
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
  
  static int binarySearch(long[] paramArrayOfLong, int paramInt, long paramLong)
  {
    int i = 0;
    int j = paramInt - 1;
    int m;
    for (;;)
    {
      if (i > j) {
        break label69;
      }
      m = i + j >>> 1;
      long l = paramArrayOfLong[m];
      if (l < paramLong)
      {
        i = m + 1;
      }
      else
      {
        if (l <= paramLong) {
          break;
        }
        j = m - 1;
      }
    }
    label69:
    for (int k = m;; k = i ^ 0xFFFFFFFF) {
      return k;
    }
  }
  
  public static boolean equal(Object paramObject1, Object paramObject2)
  {
    if ((paramObject1 == paramObject2) || ((paramObject1 != null) && (paramObject1.equals(paramObject2)))) {}
    for (boolean bool = true;; bool = false) {
      return bool;
    }
  }
  
  public static int idealByteArraySize(int paramInt)
  {
    for (int i = 4;; i++) {
      if (i < 32)
      {
        if (paramInt <= -12 + (1 << i)) {
          paramInt = -12 + (1 << i);
        }
      }
      else {
        return paramInt;
      }
    }
  }
  
  public static int idealIntArraySize(int paramInt)
  {
    return idealByteArraySize(paramInt * 4) / 4;
  }
  
  public static int idealLongArraySize(int paramInt)
  {
    return idealByteArraySize(paramInt * 8) / 8;
  }
}


/* Location:           C:\Users\dreadiscool\Desktop\tools\classes-dex2jar.jar
 * Qualified Name:     android.support.v4.util.ContainerHelpers
 * JD-Core Version:    0.7.0.1
 */