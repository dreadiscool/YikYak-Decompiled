import android.graphics.Bitmap;
import java.lang.reflect.Array;

public class vT
{
  public static void a(Bitmap paramBitmap, int paramInt)
  {
    if (paramInt < 1) {}
    for (;;)
    {
      return;
      int i = paramBitmap.getWidth();
      int j = paramBitmap.getHeight();
      int[] arrayOfInt1 = new int[i * j];
      paramBitmap.getPixels(arrayOfInt1, 0, i, 0, 0, i, j);
      int k = i - 1;
      int m = j - 1;
      int n = i * j;
      int i1 = 1 + (paramInt + paramInt);
      int[] arrayOfInt2 = new int[n];
      int[] arrayOfInt3 = new int[n];
      int[] arrayOfInt4 = new int[n];
      int[] arrayOfInt5 = new int[Math.max(i, j)];
      int i2 = i1 + 1 >> 1;
      int i3 = i2 * i2;
      int[] arrayOfInt6 = new int[i3 * 256];
      for (int i4 = 0; i4 < i3 * 256; i4++) {
        arrayOfInt6[i4] = (i4 / i3);
      }
      int i5 = 0;
      int[] arrayOfInt7 = new int[2];
      arrayOfInt7[0] = i1;
      arrayOfInt7[1] = 3;
      int[][] arrayOfInt = (int[][])Array.newInstance(Integer.TYPE, arrayOfInt7);
      int i6 = paramInt + 1;
      int i7 = 0;
      int i67;
      for (int i8 = 0; i8 < j; i8 = i67)
      {
        int i49 = 0;
        int i50 = -paramInt;
        int i51 = 0;
        int i52 = 0;
        int i53 = 0;
        int i54 = 0;
        int i55 = i50;
        int i56 = 0;
        int i57 = 0;
        int i58 = 0;
        int i59 = 0;
        if (i55 <= paramInt)
        {
          int i78 = arrayOfInt1[(i5 + Math.min(k, Math.max(i55, 0)))];
          int[] arrayOfInt13 = arrayOfInt[(i55 + paramInt)];
          arrayOfInt13[0] = ((0xFF0000 & i78) >> 16);
          arrayOfInt13[1] = ((0xFF00 & i78) >> 8);
          arrayOfInt13[2] = (i78 & 0xFF);
          int i79 = i6 - Math.abs(i55);
          i58 += i79 * arrayOfInt13[0];
          i57 += i79 * arrayOfInt13[1];
          i56 += i79 * arrayOfInt13[2];
          if (i55 > 0)
          {
            i51 += arrayOfInt13[0];
            i59 += arrayOfInt13[1];
            i49 += arrayOfInt13[2];
          }
          for (;;)
          {
            i55++;
            break;
            i54 += arrayOfInt13[0];
            i53 += arrayOfInt13[1];
            i52 += arrayOfInt13[2];
          }
        }
        int i60 = i58;
        int i61 = i57;
        int i62 = i56;
        int i63 = 0;
        int i64 = i5;
        int i65 = paramInt;
        while (i63 < i)
        {
          arrayOfInt2[i64] = arrayOfInt6[i60];
          arrayOfInt3[i64] = arrayOfInt6[i61];
          arrayOfInt4[i64] = arrayOfInt6[i62];
          int i68 = i60 - i54;
          int i69 = i61 - i53;
          int i70 = i62 - i52;
          int[] arrayOfInt11 = arrayOfInt[((i1 + (i65 - paramInt)) % i1)];
          int i71 = i54 - arrayOfInt11[0];
          int i72 = i53 - arrayOfInt11[1];
          int i73 = i52 - arrayOfInt11[2];
          if (i8 == 0) {
            arrayOfInt5[i63] = Math.min(1 + (i63 + paramInt), k);
          }
          int i74 = arrayOfInt1[(i7 + arrayOfInt5[i63])];
          arrayOfInt11[0] = ((0xFF0000 & i74) >> 16);
          arrayOfInt11[1] = ((0xFF00 & i74) >> 8);
          arrayOfInt11[2] = (i74 & 0xFF);
          int i75 = i51 + arrayOfInt11[0];
          int i76 = i59 + arrayOfInt11[1];
          int i77 = i49 + arrayOfInt11[2];
          i60 = i68 + i75;
          i61 = i69 + i76;
          i62 = i70 + i77;
          i65 = (i65 + 1) % i1;
          int[] arrayOfInt12 = arrayOfInt[(i65 % i1)];
          i54 = i71 + arrayOfInt12[0];
          i53 = i72 + arrayOfInt12[1];
          i52 = i73 + arrayOfInt12[2];
          i51 = i75 - arrayOfInt12[0];
          i59 = i76 - arrayOfInt12[1];
          i49 = i77 - arrayOfInt12[2];
          i64++;
          i63++;
        }
        int i66 = i7 + i;
        i67 = i8 + 1;
        i5 = i64;
        i7 = i66;
      }
      for (int i9 = 0; i9 < i; i9++)
      {
        int i10 = 0;
        int i11 = i * -paramInt;
        int i12 = -paramInt;
        int i13 = 0;
        int i14 = 0;
        int i15 = 0;
        int i16 = 0;
        int i17 = i12;
        int i18 = 0;
        int i19 = 0;
        int i20 = 0;
        int i21 = 0;
        if (i17 <= paramInt)
        {
          int i44 = i9 + Math.max(0, i11);
          int[] arrayOfInt10 = arrayOfInt[(i17 + paramInt)];
          arrayOfInt10[0] = arrayOfInt2[i44];
          arrayOfInt10[1] = arrayOfInt3[i44];
          arrayOfInt10[2] = arrayOfInt4[i44];
          int i45 = i6 - Math.abs(i17);
          int i46 = i20 + i45 * arrayOfInt2[i44];
          int i47 = i19 + i45 * arrayOfInt3[i44];
          int i48 = i18 + i45 * arrayOfInt4[i44];
          if (i17 > 0)
          {
            i13 += arrayOfInt10[0];
            i21 += arrayOfInt10[1];
            i10 += arrayOfInt10[2];
          }
          for (;;)
          {
            if (i17 < m) {
              i11 += i;
            }
            i17++;
            i18 = i48;
            i19 = i47;
            i20 = i46;
            break;
            i16 += arrayOfInt10[0];
            i15 += arrayOfInt10[1];
            i14 += arrayOfInt10[2];
          }
        }
        int i22 = i19;
        int i23 = i20;
        int i24 = 0;
        int i25 = i18;
        int i26 = i9;
        int i27 = i10;
        int i28 = i21;
        int i29 = i13;
        int i30 = i14;
        int i31 = i15;
        int i32 = i16;
        int i33 = paramInt;
        while (i24 < j)
        {
          arrayOfInt1[i26] = (0xFF000000 | arrayOfInt6[i23] << 16 | arrayOfInt6[i22] << 8 | arrayOfInt6[i25]);
          int i34 = i23 - i32;
          int i35 = i22 - i31;
          int i36 = i25 - i30;
          int[] arrayOfInt8 = arrayOfInt[((i1 + (i33 - paramInt)) % i1)];
          int i37 = i32 - arrayOfInt8[0];
          int i38 = i31 - arrayOfInt8[1];
          int i39 = i30 - arrayOfInt8[2];
          if (i9 == 0) {
            arrayOfInt5[i24] = (i * Math.min(i24 + i6, m));
          }
          int i40 = i9 + arrayOfInt5[i24];
          arrayOfInt8[0] = arrayOfInt2[i40];
          arrayOfInt8[1] = arrayOfInt3[i40];
          arrayOfInt8[2] = arrayOfInt4[i40];
          int i41 = i29 + arrayOfInt8[0];
          int i42 = i28 + arrayOfInt8[1];
          int i43 = i27 + arrayOfInt8[2];
          i23 = i34 + i41;
          i22 = i35 + i42;
          i25 = i36 + i43;
          i33 = (i33 + 1) % i1;
          int[] arrayOfInt9 = arrayOfInt[i33];
          i32 = i37 + arrayOfInt9[0];
          i31 = i38 + arrayOfInt9[1];
          i30 = i39 + arrayOfInt9[2];
          i29 = i41 - arrayOfInt9[0];
          i28 = i42 - arrayOfInt9[1];
          i27 = i43 - arrayOfInt9[2];
          i26 += i;
          i24++;
        }
      }
      paramBitmap.setPixels(arrayOfInt1, 0, i, 0, 0, i, j);
    }
  }
}


/* Location:           C:\Users\dreadiscool\Desktop\tools\classes-dex2jar.jar
 * Qualified Name:     vT
 * JD-Core Version:    0.7.0.1
 */