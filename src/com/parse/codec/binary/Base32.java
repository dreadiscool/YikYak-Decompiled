package com.parse.codec.binary;

public class Base32
  extends BaseNCodec
{
  private static final int BITS_PER_ENCODED_BYTE = 5;
  private static final int BYTES_PER_ENCODED_BLOCK = 8;
  private static final int BYTES_PER_UNENCODED_BLOCK = 5;
  private static final byte[] CHUNK_SEPARATOR;
  private static final byte[] DECODE_TABLE;
  private static final byte[] ENCODE_TABLE;
  private static final byte[] HEX_DECODE_TABLE;
  private static final byte[] HEX_ENCODE_TABLE;
  private static final int MASK_5BITS = 31;
  private long bitWorkArea;
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
    byte[] arrayOfByte2 = new byte[91];
    arrayOfByte2[0] = -1;
    arrayOfByte2[1] = -1;
    arrayOfByte2[2] = -1;
    arrayOfByte2[3] = -1;
    arrayOfByte2[4] = -1;
    arrayOfByte2[5] = -1;
    arrayOfByte2[6] = -1;
    arrayOfByte2[7] = -1;
    arrayOfByte2[8] = -1;
    arrayOfByte2[9] = -1;
    arrayOfByte2[10] = -1;
    arrayOfByte2[11] = -1;
    arrayOfByte2[12] = -1;
    arrayOfByte2[13] = -1;
    arrayOfByte2[14] = -1;
    arrayOfByte2[15] = -1;
    arrayOfByte2[16] = -1;
    arrayOfByte2[17] = -1;
    arrayOfByte2[18] = -1;
    arrayOfByte2[19] = -1;
    arrayOfByte2[20] = -1;
    arrayOfByte2[21] = -1;
    arrayOfByte2[22] = -1;
    arrayOfByte2[23] = -1;
    arrayOfByte2[24] = -1;
    arrayOfByte2[25] = -1;
    arrayOfByte2[26] = -1;
    arrayOfByte2[27] = -1;
    arrayOfByte2[28] = -1;
    arrayOfByte2[29] = -1;
    arrayOfByte2[30] = -1;
    arrayOfByte2[31] = -1;
    arrayOfByte2[32] = -1;
    arrayOfByte2[33] = -1;
    arrayOfByte2[34] = -1;
    arrayOfByte2[35] = -1;
    arrayOfByte2[36] = -1;
    arrayOfByte2[37] = -1;
    arrayOfByte2[38] = -1;
    arrayOfByte2[39] = -1;
    arrayOfByte2[40] = -1;
    arrayOfByte2[41] = -1;
    arrayOfByte2[42] = -1;
    arrayOfByte2[43] = -1;
    arrayOfByte2[44] = -1;
    arrayOfByte2[45] = -1;
    arrayOfByte2[46] = -1;
    arrayOfByte2[47] = 63;
    arrayOfByte2[48] = -1;
    arrayOfByte2[49] = -1;
    arrayOfByte2[50] = 26;
    arrayOfByte2[51] = 27;
    arrayOfByte2[52] = 28;
    arrayOfByte2[53] = 29;
    arrayOfByte2[54] = 30;
    arrayOfByte2[55] = 31;
    arrayOfByte2[56] = -1;
    arrayOfByte2[57] = -1;
    arrayOfByte2[58] = -1;
    arrayOfByte2[59] = -1;
    arrayOfByte2[60] = -1;
    arrayOfByte2[61] = -1;
    arrayOfByte2[62] = -1;
    arrayOfByte2[63] = -1;
    arrayOfByte2[64] = -1;
    arrayOfByte2[65] = 0;
    arrayOfByte2[66] = 1;
    arrayOfByte2[67] = 2;
    arrayOfByte2[68] = 3;
    arrayOfByte2[69] = 4;
    arrayOfByte2[70] = 5;
    arrayOfByte2[71] = 6;
    arrayOfByte2[72] = 7;
    arrayOfByte2[73] = 8;
    arrayOfByte2[74] = 9;
    arrayOfByte2[75] = 10;
    arrayOfByte2[76] = 11;
    arrayOfByte2[77] = 12;
    arrayOfByte2[78] = 13;
    arrayOfByte2[79] = 14;
    arrayOfByte2[80] = 15;
    arrayOfByte2[81] = 16;
    arrayOfByte2[82] = 17;
    arrayOfByte2[83] = 18;
    arrayOfByte2[84] = 19;
    arrayOfByte2[85] = 20;
    arrayOfByte2[86] = 21;
    arrayOfByte2[87] = 22;
    arrayOfByte2[88] = 23;
    arrayOfByte2[89] = 24;
    arrayOfByte2[90] = 25;
    DECODE_TABLE = arrayOfByte2;
    byte[] arrayOfByte3 = new byte[32];
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
    arrayOfByte3[26] = 50;
    arrayOfByte3[27] = 51;
    arrayOfByte3[28] = 52;
    arrayOfByte3[29] = 53;
    arrayOfByte3[30] = 54;
    arrayOfByte3[31] = 55;
    ENCODE_TABLE = arrayOfByte3;
    byte[] arrayOfByte4 = new byte[88];
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
    arrayOfByte4[43] = -1;
    arrayOfByte4[44] = -1;
    arrayOfByte4[45] = -1;
    arrayOfByte4[46] = -1;
    arrayOfByte4[47] = 63;
    arrayOfByte4[48] = 0;
    arrayOfByte4[49] = 1;
    arrayOfByte4[50] = 2;
    arrayOfByte4[51] = 3;
    arrayOfByte4[52] = 4;
    arrayOfByte4[53] = 5;
    arrayOfByte4[54] = 6;
    arrayOfByte4[55] = 7;
    arrayOfByte4[56] = 8;
    arrayOfByte4[57] = 9;
    arrayOfByte4[58] = -1;
    arrayOfByte4[59] = -1;
    arrayOfByte4[60] = -1;
    arrayOfByte4[61] = -1;
    arrayOfByte4[62] = -1;
    arrayOfByte4[63] = -1;
    arrayOfByte4[64] = -1;
    arrayOfByte4[65] = 10;
    arrayOfByte4[66] = 11;
    arrayOfByte4[67] = 12;
    arrayOfByte4[68] = 13;
    arrayOfByte4[69] = 14;
    arrayOfByte4[70] = 15;
    arrayOfByte4[71] = 16;
    arrayOfByte4[72] = 17;
    arrayOfByte4[73] = 18;
    arrayOfByte4[74] = 19;
    arrayOfByte4[75] = 20;
    arrayOfByte4[76] = 21;
    arrayOfByte4[77] = 22;
    arrayOfByte4[78] = 23;
    arrayOfByte4[79] = 24;
    arrayOfByte4[80] = 25;
    arrayOfByte4[81] = 26;
    arrayOfByte4[82] = 27;
    arrayOfByte4[83] = 28;
    arrayOfByte4[84] = 29;
    arrayOfByte4[85] = 30;
    arrayOfByte4[86] = 31;
    arrayOfByte4[87] = 32;
    HEX_DECODE_TABLE = arrayOfByte4;
    byte[] arrayOfByte5 = new byte[32];
    arrayOfByte5[0] = 48;
    arrayOfByte5[1] = 49;
    arrayOfByte5[2] = 50;
    arrayOfByte5[3] = 51;
    arrayOfByte5[4] = 52;
    arrayOfByte5[5] = 53;
    arrayOfByte5[6] = 54;
    arrayOfByte5[7] = 55;
    arrayOfByte5[8] = 56;
    arrayOfByte5[9] = 57;
    arrayOfByte5[10] = 65;
    arrayOfByte5[11] = 66;
    arrayOfByte5[12] = 67;
    arrayOfByte5[13] = 68;
    arrayOfByte5[14] = 69;
    arrayOfByte5[15] = 70;
    arrayOfByte5[16] = 71;
    arrayOfByte5[17] = 72;
    arrayOfByte5[18] = 73;
    arrayOfByte5[19] = 74;
    arrayOfByte5[20] = 75;
    arrayOfByte5[21] = 76;
    arrayOfByte5[22] = 77;
    arrayOfByte5[23] = 78;
    arrayOfByte5[24] = 79;
    arrayOfByte5[25] = 80;
    arrayOfByte5[26] = 81;
    arrayOfByte5[27] = 82;
    arrayOfByte5[28] = 83;
    arrayOfByte5[29] = 84;
    arrayOfByte5[30] = 85;
    arrayOfByte5[31] = 86;
    HEX_ENCODE_TABLE = arrayOfByte5;
  }
  
  public Base32()
  {
    this(false);
  }
  
  public Base32(int paramInt)
  {
    this(paramInt, CHUNK_SEPARATOR);
  }
  
  public Base32(int paramInt, byte[] paramArrayOfByte)
  {
    this(paramInt, paramArrayOfByte, false);
  }
  
  public Base32(int paramInt, byte[] paramArrayOfByte, boolean paramBoolean) {}
  
  public Base32(boolean paramBoolean)
  {
    this(0, null, paramBoolean);
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
        int i11;
        int i12;
        if (i < paramInt2)
        {
          i11 = paramInt1 + 1;
          i12 = paramArrayOfByte[paramInt1];
          if (i12 == 61) {
            this.eof = true;
          }
        }
        else
        {
          if ((!this.eof) || (this.modulus < 2)) {
            break;
          }
          ensureBufferSize(this.decodeSize);
        }
        switch (this.modulus)
        {
        default: 
          break;
        case 2: 
          byte[] arrayOfByte14 = this.buffer;
          int i10 = this.pos;
          this.pos = (i10 + 1);
          arrayOfByte14[i10] = ((byte)(int)(0xFF & this.bitWorkArea >> 2));
          break;
          ensureBufferSize(this.decodeSize);
          if ((i12 >= 0) && (i12 < this.decodeTable.length))
          {
            int i13 = this.decodeTable[i12];
            if (i13 >= 0)
            {
              this.modulus = ((1 + this.modulus) % 8);
              this.bitWorkArea = ((this.bitWorkArea << 5) + i13);
              if (this.modulus == 0)
              {
                byte[] arrayOfByte15 = this.buffer;
                int i14 = this.pos;
                this.pos = (i14 + 1);
                arrayOfByte15[i14] = ((byte)(int)(0xFF & this.bitWorkArea >> 32));
                byte[] arrayOfByte16 = this.buffer;
                int i15 = this.pos;
                this.pos = (i15 + 1);
                arrayOfByte16[i15] = ((byte)(int)(0xFF & this.bitWorkArea >> 24));
                byte[] arrayOfByte17 = this.buffer;
                int i16 = this.pos;
                this.pos = (i16 + 1);
                arrayOfByte17[i16] = ((byte)(int)(0xFF & this.bitWorkArea >> 16));
                byte[] arrayOfByte18 = this.buffer;
                int i17 = this.pos;
                this.pos = (i17 + 1);
                arrayOfByte18[i17] = ((byte)(int)(0xFF & this.bitWorkArea >> 8));
                byte[] arrayOfByte19 = this.buffer;
                int i18 = this.pos;
                this.pos = (i18 + 1);
                arrayOfByte19[i18] = ((byte)(int)(0xFF & this.bitWorkArea));
              }
            }
          }
          i++;
          paramInt1 = i11;
        }
      }
      byte[] arrayOfByte13 = this.buffer;
      int i9 = this.pos;
      this.pos = (i9 + 1);
      arrayOfByte13[i9] = ((byte)(int)(0xFF & this.bitWorkArea >> 7));
      continue;
      this.bitWorkArea >>= 4;
      byte[] arrayOfByte11 = this.buffer;
      int i7 = this.pos;
      this.pos = (i7 + 1);
      arrayOfByte11[i7] = ((byte)(int)(0xFF & this.bitWorkArea >> 8));
      byte[] arrayOfByte12 = this.buffer;
      int i8 = this.pos;
      this.pos = (i8 + 1);
      arrayOfByte12[i8] = ((byte)(int)(0xFF & this.bitWorkArea));
      continue;
      this.bitWorkArea >>= 1;
      byte[] arrayOfByte8 = this.buffer;
      int i4 = this.pos;
      this.pos = (i4 + 1);
      arrayOfByte8[i4] = ((byte)(int)(0xFF & this.bitWorkArea >> 16));
      byte[] arrayOfByte9 = this.buffer;
      int i5 = this.pos;
      this.pos = (i5 + 1);
      arrayOfByte9[i5] = ((byte)(int)(0xFF & this.bitWorkArea >> 8));
      byte[] arrayOfByte10 = this.buffer;
      int i6 = this.pos;
      this.pos = (i6 + 1);
      arrayOfByte10[i6] = ((byte)(int)(0xFF & this.bitWorkArea));
      continue;
      this.bitWorkArea >>= 6;
      byte[] arrayOfByte5 = this.buffer;
      int i1 = this.pos;
      this.pos = (i1 + 1);
      arrayOfByte5[i1] = ((byte)(int)(0xFF & this.bitWorkArea >> 16));
      byte[] arrayOfByte6 = this.buffer;
      int i2 = this.pos;
      this.pos = (i2 + 1);
      arrayOfByte6[i2] = ((byte)(int)(0xFF & this.bitWorkArea >> 8));
      byte[] arrayOfByte7 = this.buffer;
      int i3 = this.pos;
      this.pos = (i3 + 1);
      arrayOfByte7[i3] = ((byte)(int)(0xFF & this.bitWorkArea));
      continue;
      this.bitWorkArea >>= 3;
      byte[] arrayOfByte1 = this.buffer;
      int j = this.pos;
      this.pos = (j + 1);
      arrayOfByte1[j] = ((byte)(int)(0xFF & this.bitWorkArea >> 24));
      byte[] arrayOfByte2 = this.buffer;
      int k = this.pos;
      this.pos = (k + 1);
      arrayOfByte2[k] = ((byte)(int)(0xFF & this.bitWorkArea >> 16));
      byte[] arrayOfByte3 = this.buffer;
      int m = this.pos;
      this.pos = (m + 1);
      arrayOfByte3[m] = ((byte)(int)(0xFF & this.bitWorkArea >> 8));
      byte[] arrayOfByte4 = this.buffer;
      int n = this.pos;
      this.pos = (n + 1);
      arrayOfByte4[n] = ((byte)(int)(0xFF & this.bitWorkArea));
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
          int i7 = this.pos;
          switch (this.modulus)
          {
          }
          for (;;)
          {
            this.currentLinePos += this.pos - i7;
            if ((this.lineLength <= 0) || (this.currentLinePos <= 0)) {
              break;
            }
            System.arraycopy(this.lineSeparator, 0, this.buffer, this.pos, this.lineSeparator.length);
            this.pos += this.lineSeparator.length;
            break;
            byte[] arrayOfByte33 = this.buffer;
            int i32 = this.pos;
            this.pos = (i32 + 1);
            arrayOfByte33[i32] = this.encodeTable[(0x1F & (int)(this.bitWorkArea >> 3))];
            byte[] arrayOfByte34 = this.buffer;
            int i33 = this.pos;
            this.pos = (i33 + 1);
            arrayOfByte34[i33] = this.encodeTable[(0x1F & (int)(this.bitWorkArea << 2))];
            byte[] arrayOfByte35 = this.buffer;
            int i34 = this.pos;
            this.pos = (i34 + 1);
            arrayOfByte35[i34] = 61;
            byte[] arrayOfByte36 = this.buffer;
            int i35 = this.pos;
            this.pos = (i35 + 1);
            arrayOfByte36[i35] = 61;
            byte[] arrayOfByte37 = this.buffer;
            int i36 = this.pos;
            this.pos = (i36 + 1);
            arrayOfByte37[i36] = 61;
            byte[] arrayOfByte38 = this.buffer;
            int i37 = this.pos;
            this.pos = (i37 + 1);
            arrayOfByte38[i37] = 61;
            byte[] arrayOfByte39 = this.buffer;
            int i38 = this.pos;
            this.pos = (i38 + 1);
            arrayOfByte39[i38] = 61;
            byte[] arrayOfByte40 = this.buffer;
            int i39 = this.pos;
            this.pos = (i39 + 1);
            arrayOfByte40[i39] = 61;
            continue;
            byte[] arrayOfByte25 = this.buffer;
            int i24 = this.pos;
            this.pos = (i24 + 1);
            arrayOfByte25[i24] = this.encodeTable[(0x1F & (int)(this.bitWorkArea >> 11))];
            byte[] arrayOfByte26 = this.buffer;
            int i25 = this.pos;
            this.pos = (i25 + 1);
            arrayOfByte26[i25] = this.encodeTable[(0x1F & (int)(this.bitWorkArea >> 6))];
            byte[] arrayOfByte27 = this.buffer;
            int i26 = this.pos;
            this.pos = (i26 + 1);
            arrayOfByte27[i26] = this.encodeTable[(0x1F & (int)(this.bitWorkArea >> 1))];
            byte[] arrayOfByte28 = this.buffer;
            int i27 = this.pos;
            this.pos = (i27 + 1);
            arrayOfByte28[i27] = this.encodeTable[(0x1F & (int)(this.bitWorkArea << 4))];
            byte[] arrayOfByte29 = this.buffer;
            int i28 = this.pos;
            this.pos = (i28 + 1);
            arrayOfByte29[i28] = 61;
            byte[] arrayOfByte30 = this.buffer;
            int i29 = this.pos;
            this.pos = (i29 + 1);
            arrayOfByte30[i29] = 61;
            byte[] arrayOfByte31 = this.buffer;
            int i30 = this.pos;
            this.pos = (i30 + 1);
            arrayOfByte31[i30] = 61;
            byte[] arrayOfByte32 = this.buffer;
            int i31 = this.pos;
            this.pos = (i31 + 1);
            arrayOfByte32[i31] = 61;
            continue;
            byte[] arrayOfByte17 = this.buffer;
            int i16 = this.pos;
            this.pos = (i16 + 1);
            arrayOfByte17[i16] = this.encodeTable[(0x1F & (int)(this.bitWorkArea >> 19))];
            byte[] arrayOfByte18 = this.buffer;
            int i17 = this.pos;
            this.pos = (i17 + 1);
            arrayOfByte18[i17] = this.encodeTable[(0x1F & (int)(this.bitWorkArea >> 14))];
            byte[] arrayOfByte19 = this.buffer;
            int i18 = this.pos;
            this.pos = (i18 + 1);
            arrayOfByte19[i18] = this.encodeTable[(0x1F & (int)(this.bitWorkArea >> 9))];
            byte[] arrayOfByte20 = this.buffer;
            int i19 = this.pos;
            this.pos = (i19 + 1);
            arrayOfByte20[i19] = this.encodeTable[(0x1F & (int)(this.bitWorkArea >> 4))];
            byte[] arrayOfByte21 = this.buffer;
            int i20 = this.pos;
            this.pos = (i20 + 1);
            arrayOfByte21[i20] = this.encodeTable[(0x1F & (int)(this.bitWorkArea << 1))];
            byte[] arrayOfByte22 = this.buffer;
            int i21 = this.pos;
            this.pos = (i21 + 1);
            arrayOfByte22[i21] = 61;
            byte[] arrayOfByte23 = this.buffer;
            int i22 = this.pos;
            this.pos = (i22 + 1);
            arrayOfByte23[i22] = 61;
            byte[] arrayOfByte24 = this.buffer;
            int i23 = this.pos;
            this.pos = (i23 + 1);
            arrayOfByte24[i23] = 61;
            continue;
            byte[] arrayOfByte9 = this.buffer;
            int i8 = this.pos;
            this.pos = (i8 + 1);
            arrayOfByte9[i8] = this.encodeTable[(0x1F & (int)(this.bitWorkArea >> 27))];
            byte[] arrayOfByte10 = this.buffer;
            int i9 = this.pos;
            this.pos = (i9 + 1);
            arrayOfByte10[i9] = this.encodeTable[(0x1F & (int)(this.bitWorkArea >> 22))];
            byte[] arrayOfByte11 = this.buffer;
            int i10 = this.pos;
            this.pos = (i10 + 1);
            arrayOfByte11[i10] = this.encodeTable[(0x1F & (int)(this.bitWorkArea >> 17))];
            byte[] arrayOfByte12 = this.buffer;
            int i11 = this.pos;
            this.pos = (i11 + 1);
            arrayOfByte12[i11] = this.encodeTable[(0x1F & (int)(this.bitWorkArea >> 12))];
            byte[] arrayOfByte13 = this.buffer;
            int i12 = this.pos;
            this.pos = (i12 + 1);
            arrayOfByte13[i12] = this.encodeTable[(0x1F & (int)(this.bitWorkArea >> 7))];
            byte[] arrayOfByte14 = this.buffer;
            int i13 = this.pos;
            this.pos = (i13 + 1);
            arrayOfByte14[i13] = this.encodeTable[(0x1F & (int)(this.bitWorkArea >> 2))];
            byte[] arrayOfByte15 = this.buffer;
            int i14 = this.pos;
            this.pos = (i14 + 1);
            arrayOfByte15[i14] = this.encodeTable[(0x1F & (int)(this.bitWorkArea << 3))];
            byte[] arrayOfByte16 = this.buffer;
            int i15 = this.pos;
            this.pos = (i15 + 1);
            arrayOfByte16[i15] = 61;
          }
        }
      }
      else
      {
        int i = 0;
        while (i < paramInt2)
        {
          ensureBufferSize(this.encodeSize);
          this.modulus = ((1 + this.modulus) % 5);
          int j = paramInt1 + 1;
          int k = paramArrayOfByte[paramInt1];
          if (k < 0) {
            k += 256;
          }
          this.bitWorkArea = ((this.bitWorkArea << 8) + k);
          if (this.modulus == 0)
          {
            byte[] arrayOfByte1 = this.buffer;
            int m = this.pos;
            this.pos = (m + 1);
            arrayOfByte1[m] = this.encodeTable[(0x1F & (int)(this.bitWorkArea >> 35))];
            byte[] arrayOfByte2 = this.buffer;
            int n = this.pos;
            this.pos = (n + 1);
            arrayOfByte2[n] = this.encodeTable[(0x1F & (int)(this.bitWorkArea >> 30))];
            byte[] arrayOfByte3 = this.buffer;
            int i1 = this.pos;
            this.pos = (i1 + 1);
            arrayOfByte3[i1] = this.encodeTable[(0x1F & (int)(this.bitWorkArea >> 25))];
            byte[] arrayOfByte4 = this.buffer;
            int i2 = this.pos;
            this.pos = (i2 + 1);
            arrayOfByte4[i2] = this.encodeTable[(0x1F & (int)(this.bitWorkArea >> 20))];
            byte[] arrayOfByte5 = this.buffer;
            int i3 = this.pos;
            this.pos = (i3 + 1);
            arrayOfByte5[i3] = this.encodeTable[(0x1F & (int)(this.bitWorkArea >> 15))];
            byte[] arrayOfByte6 = this.buffer;
            int i4 = this.pos;
            this.pos = (i4 + 1);
            arrayOfByte6[i4] = this.encodeTable[(0x1F & (int)(this.bitWorkArea >> 10))];
            byte[] arrayOfByte7 = this.buffer;
            int i5 = this.pos;
            this.pos = (i5 + 1);
            arrayOfByte7[i5] = this.encodeTable[(0x1F & (int)(this.bitWorkArea >> 5))];
            byte[] arrayOfByte8 = this.buffer;
            int i6 = this.pos;
            this.pos = (i6 + 1);
            arrayOfByte8[i6] = this.encodeTable[(0x1F & (int)this.bitWorkArea)];
            this.currentLinePos = (8 + this.currentLinePos);
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
  
  public boolean isInAlphabet(byte paramByte)
  {
    if ((paramByte >= 0) && (paramByte < this.decodeTable.length) && (this.decodeTable[paramByte] != -1)) {}
    for (boolean bool = true;; bool = false) {
      return bool;
    }
  }
}


/* Location:           C:\Users\dreadiscool\Desktop\tools\classes-dex2jar.jar
 * Qualified Name:     com.parse.codec.binary.Base32
 * JD-Core Version:    0.7.0.1
 */