final class Ba
{
  private static final String[] a;
  private static final String[] b;
  private static final String[] c;
  
  static
  {
    int i = 0;
    String[] arrayOfString1 = new String[10];
    arrayOfString1[i] = "DATA";
    arrayOfString1[1] = "HEADERS";
    arrayOfString1[2] = "PRIORITY";
    arrayOfString1[3] = "RST_STREAM";
    arrayOfString1[4] = "SETTINGS";
    arrayOfString1[5] = "PUSH_PROMISE";
    arrayOfString1[6] = "PING";
    arrayOfString1[7] = "GOAWAY";
    arrayOfString1[8] = "WINDOW_UPDATE";
    arrayOfString1[9] = "CONTINUATION";
    a = arrayOfString1;
    b = new String[64];
    c = new String[256];
    for (int j = 0; j < c.length; j++)
    {
      String[] arrayOfString2 = c;
      Object[] arrayOfObject = new Object[1];
      arrayOfObject[i] = Integer.toBinaryString(j);
      arrayOfString2[j] = String.format("%8s", arrayOfObject).replace(' ', '0');
    }
    b[i] = "";
    b[1] = "END_STREAM";
    int[] arrayOfInt1 = new int[1];
    arrayOfInt1[i] = 1;
    b[8] = "PADDED";
    int k = arrayOfInt1.length;
    for (int m = 0; m < k; m++)
    {
      int i6 = arrayOfInt1[m];
      b[(i6 | 0x8)] = (b[i6] + "|PADDED");
    }
    b[4] = "END_HEADERS";
    b[32] = "PRIORITY";
    b[36] = "END_HEADERS|PRIORITY";
    int[] arrayOfInt2 = new int[3];
    arrayOfInt2[0] = 4;
    arrayOfInt2[1] = 32;
    arrayOfInt2[2] = 36;
    int n = arrayOfInt2.length;
    for (int i1 = 0; i1 < n; i1++)
    {
      int i2 = arrayOfInt2[i1];
      int i3 = arrayOfInt1.length;
      for (int i4 = 0; i4 < i3; i4++)
      {
        int i5 = arrayOfInt1[i4];
        b[(i5 | i2)] = (b[i5] + '|' + b[i2]);
        b[(0x8 | i5 | i2)] = (b[i5] + '|' + b[i2] + "|PADDED");
      }
    }
    while (i < b.length)
    {
      if (b[i] == null) {
        b[i] = c[i];
      }
      i++;
    }
  }
  
  static String a(byte paramByte1, byte paramByte2)
  {
    String str;
    if (paramByte2 == 0) {
      str = "";
    }
    for (;;)
    {
      return str;
      switch (paramByte1)
      {
      case 5: 
      default: 
        if (paramByte2 >= b.length) {
          break;
        }
      }
      for (str = b[paramByte2];; str = c[paramByte2])
      {
        if ((paramByte1 != 5) || ((paramByte2 & 0x4) == 0)) {
          break label127;
        }
        str = str.replace("HEADERS", "PUSH_PROMISE");
        break;
        if (paramByte2 == 1)
        {
          str = "ACK";
          break;
        }
        str = c[paramByte2];
        break;
        str = c[paramByte2];
        break;
      }
      label127:
      if ((paramByte1 == 0) && ((paramByte2 & 0x20) != 0)) {
        str = str.replace("PRIORITY", "COMPRESSED");
      }
    }
  }
  
  static String a(boolean paramBoolean, int paramInt1, int paramInt2, byte paramByte1, byte paramByte2)
  {
    String str1;
    String str2;
    Object[] arrayOfObject2;
    if (paramByte1 < a.length)
    {
      str1 = a[paramByte1];
      str2 = a(paramByte1, paramByte2);
      arrayOfObject2 = new Object[5];
      if (!paramBoolean) {
        break label105;
      }
    }
    label105:
    for (String str3 = "<<";; str3 = ">>")
    {
      arrayOfObject2[0] = str3;
      arrayOfObject2[1] = Integer.valueOf(paramInt1);
      arrayOfObject2[2] = Integer.valueOf(paramInt2);
      arrayOfObject2[3] = str1;
      arrayOfObject2[4] = str2;
      return String.format("%s 0x%08x %5d %-13s %s", arrayOfObject2);
      Object[] arrayOfObject1 = new Object[1];
      arrayOfObject1[0] = Byte.valueOf(paramByte1);
      str1 = String.format("0x%02x", arrayOfObject1);
      break;
    }
  }
}


/* Location:           C:\Users\dreadiscool\Desktop\tools\classes-dex2jar.jar
 * Qualified Name:     Ba
 * JD-Core Version:    0.7.0.1
 */