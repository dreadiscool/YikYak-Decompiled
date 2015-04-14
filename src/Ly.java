import java.io.UnsupportedEncodingException;

final class Ly
{
  private static final byte[] a;
  
  static
  {
    byte[] arrayOfByte = new byte[64];
    arrayOfByte[0] = 65;
    arrayOfByte[1] = 66;
    arrayOfByte[2] = 67;
    arrayOfByte[3] = 68;
    arrayOfByte[4] = 69;
    arrayOfByte[5] = 70;
    arrayOfByte[6] = 71;
    arrayOfByte[7] = 72;
    arrayOfByte[8] = 73;
    arrayOfByte[9] = 74;
    arrayOfByte[10] = 75;
    arrayOfByte[11] = 76;
    arrayOfByte[12] = 77;
    arrayOfByte[13] = 78;
    arrayOfByte[14] = 79;
    arrayOfByte[15] = 80;
    arrayOfByte[16] = 81;
    arrayOfByte[17] = 82;
    arrayOfByte[18] = 83;
    arrayOfByte[19] = 84;
    arrayOfByte[20] = 85;
    arrayOfByte[21] = 86;
    arrayOfByte[22] = 87;
    arrayOfByte[23] = 88;
    arrayOfByte[24] = 89;
    arrayOfByte[25] = 90;
    arrayOfByte[26] = 97;
    arrayOfByte[27] = 98;
    arrayOfByte[28] = 99;
    arrayOfByte[29] = 100;
    arrayOfByte[30] = 101;
    arrayOfByte[31] = 102;
    arrayOfByte[32] = 103;
    arrayOfByte[33] = 104;
    arrayOfByte[34] = 105;
    arrayOfByte[35] = 106;
    arrayOfByte[36] = 107;
    arrayOfByte[37] = 108;
    arrayOfByte[38] = 109;
    arrayOfByte[39] = 110;
    arrayOfByte[40] = 111;
    arrayOfByte[41] = 112;
    arrayOfByte[42] = 113;
    arrayOfByte[43] = 114;
    arrayOfByte[44] = 115;
    arrayOfByte[45] = 116;
    arrayOfByte[46] = 117;
    arrayOfByte[47] = 118;
    arrayOfByte[48] = 119;
    arrayOfByte[49] = 120;
    arrayOfByte[50] = 121;
    arrayOfByte[51] = 122;
    arrayOfByte[52] = 48;
    arrayOfByte[53] = 49;
    arrayOfByte[54] = 50;
    arrayOfByte[55] = 51;
    arrayOfByte[56] = 52;
    arrayOfByte[57] = 53;
    arrayOfByte[58] = 54;
    arrayOfByte[59] = 55;
    arrayOfByte[60] = 56;
    arrayOfByte[61] = 57;
    arrayOfByte[62] = 43;
    arrayOfByte[63] = 47;
    a = arrayOfByte;
  }
  
  public static String a(byte[] paramArrayOfByte)
  {
    int i = 0;
    byte[] arrayOfByte = new byte[4 * (2 + paramArrayOfByte.length) / 3];
    int j = paramArrayOfByte.length - paramArrayOfByte.length % 3;
    int k = 0;
    while (k < j)
    {
      int i5 = i + 1;
      arrayOfByte[i] = a[((0xFF & paramArrayOfByte[k]) >> 2)];
      int i6 = i5 + 1;
      arrayOfByte[i5] = a[((0x3 & paramArrayOfByte[k]) << 4 | (0xFF & paramArrayOfByte[(k + 1)]) >> 4)];
      int i7 = i6 + 1;
      arrayOfByte[i6] = a[((0xF & paramArrayOfByte[(k + 1)]) << 2 | (0xFF & paramArrayOfByte[(k + 2)]) >> 6)];
      int i8 = i7 + 1;
      arrayOfByte[i7] = a[(0x3F & paramArrayOfByte[(k + 2)])];
      k += 3;
      i = i8;
    }
    switch (paramArrayOfByte.length % 3)
    {
    }
    for (;;)
    {
      try
      {
        String str = new String(arrayOfByte, 0, i, "US-ASCII");
        return str;
      }
      catch (UnsupportedEncodingException localUnsupportedEncodingException)
      {
        int i2;
        int i3;
        int i4;
        int m;
        int n;
        int i1;
        throw new AssertionError(localUnsupportedEncodingException);
      }
      i2 = i + 1;
      arrayOfByte[i] = a[((0xFF & paramArrayOfByte[j]) >> 2)];
      i3 = i2 + 1;
      arrayOfByte[i2] = a[((0x3 & paramArrayOfByte[j]) << 4)];
      i4 = i3 + 1;
      arrayOfByte[i3] = 61;
      i = i4 + 1;
      arrayOfByte[i4] = 61;
      continue;
      m = i + 1;
      arrayOfByte[i] = a[((0xFF & paramArrayOfByte[j]) >> 2)];
      n = m + 1;
      arrayOfByte[m] = a[((0x3 & paramArrayOfByte[j]) << 4 | (0xFF & paramArrayOfByte[(j + 1)]) >> 4)];
      i1 = n + 1;
      arrayOfByte[n] = a[((0xF & paramArrayOfByte[(j + 1)]) << 2)];
      i = i1 + 1;
      arrayOfByte[i1] = 61;
    }
  }
  
  public static byte[] a(String paramString)
  {
    int i = paramString.length();
    byte[] arrayOfByte1;
    int j;
    int k;
    int m;
    int n;
    label78:
    int i6;
    int i10;
    label111:
    int i7;
    int i8;
    int i9;
    if (i > 0)
    {
      int i13 = paramString.charAt(i - 1);
      if ((i13 == 61) || (i13 == 10) || (i13 == 13) || (i13 == 32) || (i13 == 9)) {}
    }
    else
    {
      arrayOfByte1 = new byte[(int)(6L * i / 8L)];
      j = 0;
      k = 0;
      m = 0;
      n = 0;
      if (j >= i) {
        break label325;
      }
      i6 = paramString.charAt(j);
      if ((i6 < 65) || (i6 > 90)) {
        break label201;
      }
      i10 = i6 + -65;
      i7 = k << 6 | (byte)i10;
      i8 = m + 1;
      if (i8 % 4 != 0) {
        break label453;
      }
      int i11 = n + 1;
      arrayOfByte1[n] = (i7 >> 16);
      int i12 = i11 + 1;
      arrayOfByte1[i11] = (i7 >> 8);
      i9 = i12 + 1;
      arrayOfByte1[i12] = i7;
    }
    for (;;)
    {
      j++;
      n = i9;
      m = i8;
      k = i7;
      break label78;
      i--;
      break;
      label201:
      if ((i6 >= 97) && (i6 <= 122))
      {
        i10 = i6 + -71;
        break label111;
      }
      if ((i6 >= 48) && (i6 <= 57))
      {
        i10 = i6 + 4;
        break label111;
      }
      if (i6 == 43)
      {
        i10 = 62;
        break label111;
      }
      if (i6 == 47)
      {
        i10 = 63;
        break label111;
      }
      if ((i6 != 10) && (i6 != 13) && (i6 != 32))
      {
        if (i6 == 9)
        {
          i7 = k;
          i8 = m;
          i9 = n;
        }
        else
        {
          byte[] arrayOfByte2 = null;
          for (;;)
          {
            return arrayOfByte2;
            label325:
            int i1 = m % 4;
            if (i1 == 1)
            {
              arrayOfByte2 = null;
            }
            else
            {
              if (i1 == 2)
              {
                int i4 = k << 12;
                int i5 = n + 1;
                arrayOfByte1[n] = (i4 >> 16);
                n = i5;
              }
              for (;;)
              {
                if (n != arrayOfByte1.length) {
                  break label434;
                }
                arrayOfByte2 = arrayOfByte1;
                break;
                if (i1 == 3)
                {
                  int i2 = k << 6;
                  int i3 = n + 1;
                  arrayOfByte1[n] = (i2 >> 16);
                  n = i3 + 1;
                  arrayOfByte1[i3] = (i2 >> 8);
                }
              }
              label434:
              arrayOfByte2 = new byte[n];
              System.arraycopy(arrayOfByte1, 0, arrayOfByte2, 0, n);
            }
          }
          label453:
          i9 = n;
        }
      }
      else
      {
        i7 = k;
        i8 = m;
        i9 = n;
      }
    }
  }
}


/* Location:           C:\Users\dreadiscool\Desktop\tools\classes-dex2jar.jar
 * Qualified Name:     Ly
 * JD-Core Version:    0.7.0.1
 */