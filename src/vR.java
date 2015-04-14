public class vR
{
  private static char[] a;
  private static byte[] b;
  
  static
  {
    int i = 0;
    a = new char[64];
    int j = 65;
    int i5;
    for (int k = 0; j <= 90; k = i5)
    {
      char[] arrayOfChar4 = a;
      i5 = k + 1;
      arrayOfChar4[k] = j;
      j = (char)(j + 1);
    }
    int m = 97;
    while (m <= 122)
    {
      char[] arrayOfChar3 = a;
      int i4 = k + 1;
      arrayOfChar3[k] = m;
      m = (char)(m + 1);
      k = i4;
    }
    int n = 48;
    while (n <= 57)
    {
      char[] arrayOfChar2 = a;
      int i3 = k + 1;
      arrayOfChar2[k] = n;
      n = (char)(n + 1);
      k = i3;
    }
    char[] arrayOfChar1 = a;
    int i1 = k + 1;
    arrayOfChar1[k] = '+';
    a[i1] = '/';
    b = new byte[''];
    for (int i2 = 0; i2 < b.length; i2++) {
      b[i2] = -1;
    }
    while (i < 64)
    {
      b[a[i]] = ((byte)i);
      i++;
    }
  }
  
  public static String a(String paramString)
  {
    return new String(a(paramString.getBytes()));
  }
  
  public static char[] a(byte[] paramArrayOfByte)
  {
    return a(paramArrayOfByte, paramArrayOfByte.length);
  }
  
  public static char[] a(byte[] paramArrayOfByte, int paramInt)
  {
    int i = (2 + paramInt * 4) / 3;
    char[] arrayOfChar = new char[4 * ((paramInt + 2) / 3)];
    int j = 0;
    int k = 0;
    if (k < paramInt)
    {
      int m = k + 1;
      int n = 0xFF & paramArrayOfByte[k];
      int i1;
      label72:
      int i2;
      label94:
      int i6;
      int i9;
      label181:
      int i10;
      if (m < paramInt)
      {
        int i12 = m + 1;
        i1 = 0xFF & paramArrayOfByte[m];
        m = i12;
        if (m >= paramInt) {
          break label228;
        }
        k = m + 1;
        i2 = 0xFF & paramArrayOfByte[m];
        int i3 = n >>> 2;
        int i4 = (n & 0x3) << 4 | i1 >>> 4;
        int i5 = (i1 & 0xF) << 2 | i2 >>> 6;
        i6 = i2 & 0x3F;
        int i7 = j + 1;
        arrayOfChar[j] = a[i3];
        int i8 = i7 + 1;
        arrayOfChar[i7] = a[i4];
        if (i8 >= i) {
          break label238;
        }
        i9 = a[i5];
        arrayOfChar[i8] = i9;
        i10 = i8 + 1;
        if (i10 >= i) {
          break label245;
        }
      }
      label228:
      label238:
      label245:
      for (int i11 = a[i6];; i11 = 61)
      {
        arrayOfChar[i10] = i11;
        j = i10 + 1;
        break;
        i1 = 0;
        break label72;
        k = m;
        i2 = 0;
        break label94;
        i9 = 61;
        break label181;
      }
    }
    return arrayOfChar;
  }
}


/* Location:           C:\Users\dreadiscool\Desktop\tools\classes-dex2jar.jar
 * Qualified Name:     vR
 * JD-Core Version:    0.7.0.1
 */