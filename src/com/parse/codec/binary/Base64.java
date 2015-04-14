package com.parse.codec.binary;

import java.math.BigInteger;

public class Base64
  extends BaseNCodec
{
  private static final int BITS_PER_ENCODED_BYTE = 6;
  private static final int BYTES_PER_ENCODED_BLOCK = 4;
  private static final int BYTES_PER_UNENCODED_BLOCK = 3;
  static final byte[] CHUNK_SEPARATOR;
  private static final byte[] DECODE_TABLE;
  private static final int MASK_6BITS = 63;
  private static final byte[] STANDARD_ENCODE_TABLE;
  private static final byte[] URL_SAFE_ENCODE_TABLE;
  private int bitWorkArea;
  private final int decodeSize;
  private final byte[] decodeTable;
  private final int encodeSize;
  private final byte[] encodeTable;
  private final byte[] lineSeparator;
  
  static
  {
    byte[] arrayOfByte1 = new byte[2];
    arrayOfByte1[0] = 13;
    arrayOfByte1[1] = 10;
    CHUNK_SEPARATOR = arrayOfByte1;
    byte[] arrayOfByte2 = new byte[64];
    arrayOfByte2[0] = 65;
    arrayOfByte2[1] = 66;
    arrayOfByte2[2] = 67;
    arrayOfByte2[3] = 68;
    arrayOfByte2[4] = 69;
    arrayOfByte2[5] = 70;
    arrayOfByte2[6] = 71;
    arrayOfByte2[7] = 72;
    arrayOfByte2[8] = 73;
    arrayOfByte2[9] = 74;
    arrayOfByte2[10] = 75;
    arrayOfByte2[11] = 76;
    arrayOfByte2[12] = 77;
    arrayOfByte2[13] = 78;
    arrayOfByte2[14] = 79;
    arrayOfByte2[15] = 80;
    arrayOfByte2[16] = 81;
    arrayOfByte2[17] = 82;
    arrayOfByte2[18] = 83;
    arrayOfByte2[19] = 84;
    arrayOfByte2[20] = 85;
    arrayOfByte2[21] = 86;
    arrayOfByte2[22] = 87;
    arrayOfByte2[23] = 88;
    arrayOfByte2[24] = 89;
    arrayOfByte2[25] = 90;
    arrayOfByte2[26] = 97;
    arrayOfByte2[27] = 98;
    arrayOfByte2[28] = 99;
    arrayOfByte2[29] = 100;
    arrayOfByte2[30] = 101;
    arrayOfByte2[31] = 102;
    arrayOfByte2[32] = 103;
    arrayOfByte2[33] = 104;
    arrayOfByte2[34] = 105;
    arrayOfByte2[35] = 106;
    arrayOfByte2[36] = 107;
    arrayOfByte2[37] = 108;
    arrayOfByte2[38] = 109;
    arrayOfByte2[39] = 110;
    arrayOfByte2[40] = 111;
    arrayOfByte2[41] = 112;
    arrayOfByte2[42] = 113;
    arrayOfByte2[43] = 114;
    arrayOfByte2[44] = 115;
    arrayOfByte2[45] = 116;
    arrayOfByte2[46] = 117;
    arrayOfByte2[47] = 118;
    arrayOfByte2[48] = 119;
    arrayOfByte2[49] = 120;
    arrayOfByte2[50] = 121;
    arrayOfByte2[51] = 122;
    arrayOfByte2[52] = 48;
    arrayOfByte2[53] = 49;
    arrayOfByte2[54] = 50;
    arrayOfByte2[55] = 51;
    arrayOfByte2[56] = 52;
    arrayOfByte2[57] = 53;
    arrayOfByte2[58] = 54;
    arrayOfByte2[59] = 55;
    arrayOfByte2[60] = 56;
    arrayOfByte2[61] = 57;
    arrayOfByte2[62] = 43;
    arrayOfByte2[63] = 47;
    STANDARD_ENCODE_TABLE = arrayOfByte2;
    byte[] arrayOfByte3 = new byte[64];
    arrayOfByte3[0] = 65;
    arrayOfByte3[1] = 66;
    arrayOfByte3[2] = 67;
    arrayOfByte3[3] = 68;
    arrayOfByte3[4] = 69;
    arrayOfByte3[5] = 70;
    arrayOfByte3[6] = 71;
    arrayOfByte3[7] = 72;
    arrayOfByte3[8] = 73;
    arrayOfByte3[9] = 74;
    arrayOfByte3[10] = 75;
    arrayOfByte3[11] = 76;
    arrayOfByte3[12] = 77;
    arrayOfByte3[13] = 78;
    arrayOfByte3[14] = 79;
    arrayOfByte3[15] = 80;
    arrayOfByte3[16] = 81;
    arrayOfByte3[17] = 82;
    arrayOfByte3[18] = 83;
    arrayOfByte3[19] = 84;
    arrayOfByte3[20] = 85;
    arrayOfByte3[21] = 86;
    arrayOfByte3[22] = 87;
    arrayOfByte3[23] = 88;
    arrayOfByte3[24] = 89;
    arrayOfByte3[25] = 90;
    arrayOfByte3[26] = 97;
    arrayOfByte3[27] = 98;
    arrayOfByte3[28] = 99;
    arrayOfByte3[29] = 100;
    arrayOfByte3[30] = 101;
    arrayOfByte3[31] = 102;
    arrayOfByte3[32] = 103;
    arrayOfByte3[33] = 104;
    arrayOfByte3[34] = 105;
    arrayOfByte3[35] = 106;
    arrayOfByte3[36] = 107;
    arrayOfByte3[37] = 108;
    arrayOfByte3[38] = 109;
    arrayOfByte3[39] = 110;
    arrayOfByte3[40] = 111;
    arrayOfByte3[41] = 112;
    arrayOfByte3[42] = 113;
    arrayOfByte3[43] = 114;
    arrayOfByte3[44] = 115;
    arrayOfByte3[45] = 116;
    arrayOfByte3[46] = 117;
    arrayOfByte3[47] = 118;
    arrayOfByte3[48] = 119;
    arrayOfByte3[49] = 120;
    arrayOfByte3[50] = 121;
    arrayOfByte3[51] = 122;
    arrayOfByte3[52] = 48;
    arrayOfByte3[53] = 49;
    arrayOfByte3[54] = 50;
    arrayOfByte3[55] = 51;
    arrayOfByte3[56] = 52;
    arrayOfByte3[57] = 53;
    arrayOfByte3[58] = 54;
    arrayOfByte3[59] = 55;
    arrayOfByte3[60] = 56;
    arrayOfByte3[61] = 57;
    arrayOfByte3[62] = 45;
    arrayOfByte3[63] = 95;
    URL_SAFE_ENCODE_TABLE = arrayOfByte3;
    byte[] arrayOfByte4 = new byte[123];
    arrayOfByte4[0] = -1;
    arrayOfByte4[1] = -1;
    arrayOfByte4[2] = -1;
    arrayOfByte4[3] = -1;
    arrayOfByte4[4] = -1;
    arrayOfByte4[5] = -1;
    arrayOfByte4[6] = -1;
    arrayOfByte4[7] = -1;
    arrayOfByte4[8] = -1;
    arrayOfByte4[9] = -1;
    arrayOfByte4[10] = -1;
    arrayOfByte4[11] = -1;
    arrayOfByte4[12] = -1;
    arrayOfByte4[13] = -1;
    arrayOfByte4[14] = -1;
    arrayOfByte4[15] = -1;
    arrayOfByte4[16] = -1;
    arrayOfByte4[17] = -1;
    arrayOfByte4[18] = -1;
    arrayOfByte4[19] = -1;
    arrayOfByte4[20] = -1;
    arrayOfByte4[21] = -1;
    arrayOfByte4[22] = -1;
    arrayOfByte4[23] = -1;
    arrayOfByte4[24] = -1;
    arrayOfByte4[25] = -1;
    arrayOfByte4[26] = -1;
    arrayOfByte4[27] = -1;
    arrayOfByte4[28] = -1;
    arrayOfByte4[29] = -1;
    arrayOfByte4[30] = -1;
    arrayOfByte4[31] = -1;
    arrayOfByte4[32] = -1;
    arrayOfByte4[33] = -1;
    arrayOfByte4[34] = -1;
    arrayOfByte4[35] = -1;
    arrayOfByte4[36] = -1;
    arrayOfByte4[37] = -1;
    arrayOfByte4[38] = -1;
    arrayOfByte4[39] = -1;
    arrayOfByte4[40] = -1;
    arrayOfByte4[41] = -1;
    arrayOfByte4[42] = -1;
    arrayOfByte4[43] = 62;
    arrayOfByte4[44] = -1;
    arrayOfByte4[45] = 62;
    arrayOfByte4[46] = -1;
    arrayOfByte4[47] = 63;
    arrayOfByte4[48] = 52;
    arrayOfByte4[49] = 53;
    arrayOfByte4[50] = 54;
    arrayOfByte4[51] = 55;
    arrayOfByte4[52] = 56;
    arrayOfByte4[53] = 57;
    arrayOfByte4[54] = 58;
    arrayOfByte4[55] = 59;
    arrayOfByte4[56] = 60;
    arrayOfByte4[57] = 61;
    arrayOfByte4[58] = -1;
    arrayOfByte4[59] = -1;
    arrayOfByte4[60] = -1;
    arrayOfByte4[61] = -1;
    arrayOfByte4[62] = -1;
    arrayOfByte4[63] = -1;
    arrayOfByte4[64] = -1;
    arrayOfByte4[65] = 0;
    arrayOfByte4[66] = 1;
    arrayOfByte4[67] = 2;
    arrayOfByte4[68] = 3;
    arrayOfByte4[69] = 4;
    arrayOfByte4[70] = 5;
    arrayOfByte4[71] = 6;
    arrayOfByte4[72] = 7;
    arrayOfByte4[73] = 8;
    arrayOfByte4[74] = 9;
    arrayOfByte4[75] = 10;
    arrayOfByte4[76] = 11;
    arrayOfByte4[77] = 12;
    arrayOfByte4[78] = 13;
    arrayOfByte4[79] = 14;
    arrayOfByte4[80] = 15;
    arrayOfByte4[81] = 16;
    arrayOfByte4[82] = 17;
    arrayOfByte4[83] = 18;
    arrayOfByte4[84] = 19;
    arrayOfByte4[85] = 20;
    arrayOfByte4[86] = 21;
    arrayOfByte4[87] = 22;
    arrayOfByte4[88] = 23;
    arrayOfByte4[89] = 24;
    arrayOfByte4[90] = 25;
    arrayOfByte4[91] = -1;
    arrayOfByte4[92] = -1;
    arrayOfByte4[93] = -1;
    arrayOfByte4[94] = -1;
    arrayOfByte4[95] = 63;
    arrayOfByte4[96] = -1;
    arrayOfByte4[97] = 26;
    arrayOfByte4[98] = 27;
    arrayOfByte4[99] = 28;
    arrayOfByte4[100] = 29;
    arrayOfByte4[101] = 30;
    arrayOfByte4[102] = 31;
    arrayOfByte4[103] = 32;
    arrayOfByte4[104] = 33;
    arrayOfByte4[105] = 34;
    arrayOfByte4[106] = 35;
    arrayOfByte4[107] = 36;
    arrayOfByte4[108] = 37;
    arrayOfByte4[109] = 38;
    arrayOfByte4[110] = 39;
    arrayOfByte4[111] = 40;
    arrayOfByte4[112] = 41;
    arrayOfByte4[113] = 42;
    arrayOfByte4[114] = 43;
    arrayOfByte4[115] = 44;
    arrayOfByte4[116] = 45;
    arrayOfByte4[117] = 46;
    arrayOfByte4[118] = 47;
    arrayOfByte4[119] = 48;
    arrayOfByte4[120] = 49;
    arrayOfByte4[121] = 50;
    arrayOfByte4[122] = 51;
    DECODE_TABLE = arrayOfByte4;
  }
  
  public Base64()
  {
    this(0);
  }
  
  public Base64(int paramInt)
  {
    this(paramInt, CHUNK_SEPARATOR);
  }
  
  public Base64(int paramInt, byte[] paramArrayOfByte)
  {
    this(paramInt, paramArrayOfByte, false);
  }
  
  public Base64(int paramInt, byte[] paramArrayOfByte, boolean paramBoolean) {}
  
  public Base64(boolean paramBoolean)
  {
    this(76, CHUNK_SEPARATOR, paramBoolean);
  }
  
  public static byte[] decodeBase64(String paramString)
  {
    return new Base64().decode(paramString);
  }
  
  public static byte[] decodeBase64(byte[] paramArrayOfByte)
  {
    return new Base64().decode(paramArrayOfByte);
  }
  
  public static BigInteger decodeInteger(byte[] paramArrayOfByte)
  {
    return new BigInteger(1, decodeBase64(paramArrayOfByte));
  }
  
  public static byte[] encodeBase64(byte[] paramArrayOfByte)
  {
    return encodeBase64(paramArrayOfByte, false);
  }
  
  public static byte[] encodeBase64(byte[] paramArrayOfByte, boolean paramBoolean)
  {
    return encodeBase64(paramArrayOfByte, paramBoolean, false);
  }
  
  public static byte[] encodeBase64(byte[] paramArrayOfByte, boolean paramBoolean1, boolean paramBoolean2)
  {
    return encodeBase64(paramArrayOfByte, paramBoolean1, paramBoolean2, 2147483647);
  }
  
  public static byte[] encodeBase64(byte[] paramArrayOfByte, boolean paramBoolean1, boolean paramBoolean2, int paramInt)
  {
    if ((paramArrayOfByte == null) || (paramArrayOfByte.length == 0)) {}
    for (;;)
    {
      return paramArrayOfByte;
      if (paramBoolean1) {}
      for (Base64 localBase64 = new Base64(paramBoolean2);; localBase64 = new Base64(0, CHUNK_SEPARATOR, paramBoolean2))
      {
        long l = localBase64.getEncodedLength(paramArrayOfByte);
        if (l <= paramInt) {
          break;
        }
        throw new IllegalArgumentException("Input array too big, the output array would be bigger (" + l + ") than the specified maximum size of " + paramInt);
      }
      paramArrayOfByte = localBase64.encode(paramArrayOfByte);
    }
  }
  
  public static byte[] encodeBase64Chunked(byte[] paramArrayOfByte)
  {
    return encodeBase64(paramArrayOfByte, true);
  }
  
  public static String encodeBase64String(byte[] paramArrayOfByte)
  {
    return StringUtils.newStringUtf8(encodeBase64(paramArrayOfByte, false));
  }
  
  public static byte[] encodeBase64URLSafe(byte[] paramArrayOfByte)
  {
    return encodeBase64(paramArrayOfByte, false, true);
  }
  
  public static String encodeBase64URLSafeString(byte[] paramArrayOfByte)
  {
    return StringUtils.newStringUtf8(encodeBase64(paramArrayOfByte, false, true));
  }
  
  public static byte[] encodeInteger(BigInteger paramBigInteger)
  {
    if (paramBigInteger == null) {
      throw new NullPointerException("encodeInteger called with null parameter");
    }
    return encodeBase64(toIntegerBytes(paramBigInteger), false);
  }
  
  public static boolean isArrayByteBase64(byte[] paramArrayOfByte)
  {
    return isBase64(paramArrayOfByte);
  }
  
  public static boolean isBase64(byte paramByte)
  {
    if ((paramByte == 61) || ((paramByte >= 0) && (paramByte < DECODE_TABLE.length) && (DECODE_TABLE[paramByte] != -1))) {}
    for (boolean bool = true;; bool = false) {
      return bool;
    }
  }
  
  public static boolean isBase64(String paramString)
  {
    return isBase64(StringUtils.getBytesUtf8(paramString));
  }
  
  public static boolean isBase64(byte[] paramArrayOfByte)
  {
    boolean bool = false;
    int i = 0;
    if (i < paramArrayOfByte.length) {
      if ((isBase64(paramArrayOfByte[i])) || (isWhiteSpace(paramArrayOfByte[i]))) {}
    }
    for (;;)
    {
      return bool;
      i++;
      break;
      bool = true;
    }
  }
  
  static byte[] toIntegerBytes(BigInteger paramBigInteger)
  {
    int i = 7 + paramBigInteger.bitLength() >> 3 << 3;
    byte[] arrayOfByte1 = paramBigInteger.toByteArray();
    if ((paramBigInteger.bitLength() % 8 != 0) && (1 + paramBigInteger.bitLength() / 8 == i / 8)) {}
    byte[] arrayOfByte2;
    for (Object localObject = arrayOfByte1;; localObject = arrayOfByte2)
    {
      return localObject;
      int j = 0;
      int k = arrayOfByte1.length;
      if (paramBigInteger.bitLength() % 8 == 0)
      {
        j = 1;
        k--;
      }
      int m = i / 8 - k;
      arrayOfByte2 = new byte[i / 8];
      System.arraycopy(arrayOfByte1, j, arrayOfByte2, m, k);
    }
  }
  
  void decode(byte[] paramArrayOfByte, int paramInt1, int paramInt2)
  {
    if (this.eof) {}
    for (;;)
    {
      return;
      if (paramInt2 < 0) {
        this.eof = true;
      }
      int i = 0;
      for (;;)
      {
        int n;
        int i1;
        if (i < paramInt2)
        {
          ensureBufferSize(this.decodeSize);
          n = paramInt1 + 1;
          i1 = paramArrayOfByte[paramInt1];
          if (i1 == 61) {
            this.eof = true;
          }
        }
        else
        {
          if ((!this.eof) || (this.modulus == 0)) {
            break;
          }
          ensureBufferSize(this.decodeSize);
        }
        switch (this.modulus)
        {
        default: 
          break;
        case 2: 
          this.bitWorkArea >>= 4;
          byte[] arrayOfByte3 = this.buffer;
          int m = this.pos;
          this.pos = (m + 1);
          arrayOfByte3[m] = ((byte)(0xFF & this.bitWorkArea));
          break;
          if ((i1 >= 0) && (i1 < DECODE_TABLE.length))
          {
            int i2 = DECODE_TABLE[i1];
            if (i2 >= 0)
            {
              this.modulus = ((1 + this.modulus) % 4);
              this.bitWorkArea = (i2 + (this.bitWorkArea << 6));
              if (this.modulus == 0)
              {
                byte[] arrayOfByte4 = this.buffer;
                int i3 = this.pos;
                this.pos = (i3 + 1);
                arrayOfByte4[i3] = ((byte)(0xFF & this.bitWorkArea >> 16));
                byte[] arrayOfByte5 = this.buffer;
                int i4 = this.pos;
                this.pos = (i4 + 1);
                arrayOfByte5[i4] = ((byte)(0xFF & this.bitWorkArea >> 8));
                byte[] arrayOfByte6 = this.buffer;
                int i5 = this.pos;
                this.pos = (i5 + 1);
                arrayOfByte6[i5] = ((byte)(0xFF & this.bitWorkArea));
              }
            }
          }
          i++;
          paramInt1 = n;
        }
      }
      this.bitWorkArea >>= 2;
      byte[] arrayOfByte1 = this.buffer;
      int j = this.pos;
      this.pos = (j + 1);
      arrayOfByte1[j] = ((byte)(0xFF & this.bitWorkArea >> 8));
      byte[] arrayOfByte2 = this.buffer;
      int k = this.pos;
      this.pos = (k + 1);
      arrayOfByte2[k] = ((byte)(0xFF & this.bitWorkArea));
    }
  }
  
  void encode(byte[] paramArrayOfByte, int paramInt1, int paramInt2)
  {
    if (this.eof) {}
    for (;;)
    {
      return;
      if (paramInt2 < 0)
      {
        this.eof = true;
        if ((this.modulus != 0) || (this.lineLength != 0))
        {
          ensureBufferSize(this.encodeSize);
          int i3 = this.pos;
          switch (this.modulus)
          {
          }
          for (;;)
          {
            this.currentLinePos += this.pos - i3;
            if ((this.lineLength <= 0) || (this.currentLinePos <= 0)) {
              break;
            }
            System.arraycopy(this.lineSeparator, 0, this.buffer, this.pos, this.lineSeparator.length);
            this.pos += this.lineSeparator.length;
            break;
            byte[] arrayOfByte9 = this.buffer;
            int i8 = this.pos;
            this.pos = (i8 + 1);
            arrayOfByte9[i8] = this.encodeTable[(0x3F & this.bitWorkArea >> 2)];
            byte[] arrayOfByte10 = this.buffer;
            int i9 = this.pos;
            this.pos = (i9 + 1);
            arrayOfByte10[i9] = this.encodeTable[(0x3F & this.bitWorkArea << 4)];
            if (this.encodeTable == STANDARD_ENCODE_TABLE)
            {
              byte[] arrayOfByte11 = this.buffer;
              int i10 = this.pos;
              this.pos = (i10 + 1);
              arrayOfByte11[i10] = 61;
              byte[] arrayOfByte12 = this.buffer;
              int i11 = this.pos;
              this.pos = (i11 + 1);
              arrayOfByte12[i11] = 61;
              continue;
              byte[] arrayOfByte5 = this.buffer;
              int i4 = this.pos;
              this.pos = (i4 + 1);
              arrayOfByte5[i4] = this.encodeTable[(0x3F & this.bitWorkArea >> 10)];
              byte[] arrayOfByte6 = this.buffer;
              int i5 = this.pos;
              this.pos = (i5 + 1);
              arrayOfByte6[i5] = this.encodeTable[(0x3F & this.bitWorkArea >> 4)];
              byte[] arrayOfByte7 = this.buffer;
              int i6 = this.pos;
              this.pos = (i6 + 1);
              arrayOfByte7[i6] = this.encodeTable[(0x3F & this.bitWorkArea << 2)];
              if (this.encodeTable == STANDARD_ENCODE_TABLE)
              {
                byte[] arrayOfByte8 = this.buffer;
                int i7 = this.pos;
                this.pos = (i7 + 1);
                arrayOfByte8[i7] = 61;
              }
            }
          }
        }
      }
      else
      {
        int i = 0;
        while (i < paramInt2)
        {
          ensureBufferSize(this.encodeSize);
          this.modulus = ((1 + this.modulus) % 3);
          int j = paramInt1 + 1;
          int k = paramArrayOfByte[paramInt1];
          if (k < 0) {
            k += 256;
          }
          this.bitWorkArea = (k + (this.bitWorkArea << 8));
          if (this.modulus == 0)
          {
            byte[] arrayOfByte1 = this.buffer;
            int m = this.pos;
            this.pos = (m + 1);
            arrayOfByte1[m] = this.encodeTable[(0x3F & this.bitWorkArea >> 18)];
            byte[] arrayOfByte2 = this.buffer;
            int n = this.pos;
            this.pos = (n + 1);
            arrayOfByte2[n] = this.encodeTable[(0x3F & this.bitWorkArea >> 12)];
            byte[] arrayOfByte3 = this.buffer;
            int i1 = this.pos;
            this.pos = (i1 + 1);
            arrayOfByte3[i1] = this.encodeTable[(0x3F & this.bitWorkArea >> 6)];
            byte[] arrayOfByte4 = this.buffer;
            int i2 = this.pos;
            this.pos = (i2 + 1);
            arrayOfByte4[i2] = this.encodeTable[(0x3F & this.bitWorkArea)];
            this.currentLinePos = (4 + this.currentLinePos);
            if ((this.lineLength > 0) && (this.lineLength <= this.currentLinePos))
            {
              System.arraycopy(this.lineSeparator, 0, this.buffer, this.pos, this.lineSeparator.length);
              this.pos += this.lineSeparator.length;
              this.currentLinePos = 0;
            }
          }
          i++;
          paramInt1 = j;
        }
      }
    }
  }
  
  protected boolean isInAlphabet(byte paramByte)
  {
    if ((paramByte >= 0) && (paramByte < this.decodeTable.length) && (this.decodeTable[paramByte] != -1)) {}
    for (boolean bool = true;; bool = false) {
      return bool;
    }
  }
  
  public boolean isUrlSafe()
  {
    if (this.encodeTable == URL_SAFE_ENCODE_TABLE) {}
    for (boolean bool = true;; bool = false) {
      return bool;
    }
  }
}


/* Location:           C:\Users\dreadiscool\Desktop\tools\classes-dex2jar.jar
 * Qualified Name:     com.parse.codec.binary.Base64
 * JD-Core Version:    0.7.0.1
 */