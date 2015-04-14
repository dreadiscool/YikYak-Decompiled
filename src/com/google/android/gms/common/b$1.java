package com.google.android.gms.common;

import java.util.Comparator;

final class b$1
  implements Comparator<byte[]>
{
  public int c(byte[] paramArrayOfByte1, byte[] paramArrayOfByte2)
  {
    int i = Math.min(paramArrayOfByte1.length, paramArrayOfByte2.length);
    int j = 0;
    int m;
    int n;
    if (j < i)
    {
      m = 0xFF & paramArrayOfByte1[j];
      n = 0xFF & paramArrayOfByte2[j];
      if (m == n) {}
    }
    for (int k = m - n;; k = paramArrayOfByte1.length - paramArrayOfByte2.length)
    {
      return k;
      j++;
      break;
    }
  }
}


/* Location:           C:\Users\dreadiscool\Desktop\tools\classes-dex2jar.jar
 * Qualified Name:     com.google.android.gms.common.b.1
 * JD-Core Version:    0.7.0.1
 */