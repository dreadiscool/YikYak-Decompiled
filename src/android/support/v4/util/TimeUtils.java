package android.support.v4.util;

import java.io.PrintWriter;

public class TimeUtils
{
  public static final int HUNDRED_DAY_FIELD_LEN = 19;
  private static final int SECONDS_PER_DAY = 86400;
  private static final int SECONDS_PER_HOUR = 3600;
  private static final int SECONDS_PER_MINUTE = 60;
  private static char[] sFormatStr = new char[24];
  private static final Object sFormatSync = new Object();
  
  private static int accumField(int paramInt1, int paramInt2, boolean paramBoolean, int paramInt3)
  {
    int i;
    if ((paramInt1 > 99) || ((paramBoolean) && (paramInt3 >= 3))) {
      i = paramInt2 + 3;
    }
    for (;;)
    {
      return i;
      if ((paramInt1 > 9) || ((paramBoolean) && (paramInt3 >= 2))) {
        i = paramInt2 + 2;
      } else if ((paramBoolean) || (paramInt1 > 0)) {
        i = paramInt2 + 1;
      } else {
        i = 0;
      }
    }
  }
  
  public static void formatDuration(long paramLong1, long paramLong2, PrintWriter paramPrintWriter)
  {
    if (paramLong1 == 0L) {
      paramPrintWriter.print("--");
    }
    for (;;)
    {
      return;
      formatDuration(paramLong1 - paramLong2, paramPrintWriter, 0);
    }
  }
  
  public static void formatDuration(long paramLong, PrintWriter paramPrintWriter)
  {
    formatDuration(paramLong, paramPrintWriter, 0);
  }
  
  public static void formatDuration(long paramLong, PrintWriter paramPrintWriter, int paramInt)
  {
    synchronized (sFormatSync)
    {
      int i = formatDurationLocked(paramLong, paramInt);
      paramPrintWriter.print(new String(sFormatStr, 0, i));
      return;
    }
  }
  
  public static void formatDuration(long paramLong, StringBuilder paramStringBuilder)
  {
    synchronized (sFormatSync)
    {
      int i = formatDurationLocked(paramLong, 0);
      paramStringBuilder.append(sFormatStr, 0, i);
      return;
    }
  }
  
  private static int formatDurationLocked(long paramLong, int paramInt)
  {
    if (sFormatStr.length < paramInt) {
      sFormatStr = new char[paramInt];
    }
    char[] arrayOfChar = sFormatStr;
    int i16;
    if (paramLong == 0L)
    {
      int i29 = paramInt - 1;
      while (i29 < 0) {
        arrayOfChar[0] = ' ';
      }
      arrayOfChar[0] = '0';
      i16 = 1;
      return i16;
    }
    int i;
    int j;
    int k;
    int m;
    int i28;
    int n;
    if (paramLong > 0L)
    {
      i = 43;
      j = (int)(paramLong % 1000L);
      k = (int)Math.floor(paramLong / 1000L);
      m = 0;
      if (k > 86400)
      {
        m = k / 86400;
        k -= 86400 * m;
      }
      if (k <= 3600) {
        break label591;
      }
      int i27 = k / 3600;
      i28 = k - i27 * 3600;
      n = i27;
    }
    for (int i1 = i28;; i1 = k)
    {
      int i26;
      int i2;
      if (i1 > 60)
      {
        int i25 = i1 / 60;
        i26 = i1 - i25 * 60;
        i2 = i25;
      }
      for (int i3 = i26;; i3 = i1)
      {
        if (paramInt != 0)
        {
          int i17 = accumField(m, 1, false, 0);
          boolean bool4;
          label199:
          boolean bool5;
          label221:
          boolean bool6;
          label243:
          int i20;
          if (i17 > 0)
          {
            bool4 = true;
            int i18 = i17 + accumField(n, 1, bool4, 2);
            if (i18 <= 0) {
              break label332;
            }
            bool5 = true;
            int i19 = i18 + accumField(i2, 1, bool5, 2);
            if (i19 <= 0) {
              break label338;
            }
            bool6 = true;
            i20 = i19 + accumField(i3, 1, bool6, 2);
            if (i20 <= 0) {
              break label344;
            }
          }
          label332:
          label338:
          label344:
          for (int i21 = 3;; i21 = 0)
          {
            int i22 = i20 + (1 + accumField(j, 2, true, i21));
            i4 = 0;
            int i23 = i22;
            while (i23 < paramInt)
            {
              arrayOfChar[i4] = ' ';
              int i24 = i4 + 1;
              i23++;
              i4 = i24;
            }
            paramLong = -paramLong;
            i = 45;
            break;
            bool4 = false;
            break label199;
            bool5 = false;
            break label221;
            bool6 = false;
            break label243;
          }
        }
        int i4 = 0;
        arrayOfChar[i4] = i;
        int i5 = i4 + 1;
        int i6;
        label372:
        boolean bool1;
        label396:
        int i8;
        label404:
        boolean bool2;
        label430:
        int i10;
        label438:
        boolean bool3;
        label464:
        int i12;
        label472:
        int i13;
        if (paramInt != 0)
        {
          i6 = 1;
          int i7 = printField(arrayOfChar, m, 'd', i5, false, 0);
          if (i7 == i5) {
            break label539;
          }
          bool1 = true;
          if (i6 == 0) {
            break label545;
          }
          i8 = 2;
          int i9 = printField(arrayOfChar, n, 'h', i7, bool1, i8);
          if (i9 == i5) {
            break label551;
          }
          bool2 = true;
          if (i6 == 0) {
            break label557;
          }
          i10 = 2;
          int i11 = printField(arrayOfChar, i2, 'm', i9, bool2, i10);
          if (i11 == i5) {
            break label563;
          }
          bool3 = true;
          if (i6 == 0) {
            break label569;
          }
          i12 = 2;
          i13 = printField(arrayOfChar, i3, 's', i11, bool3, i12);
          if ((i6 == 0) || (i13 == i5)) {
            break label575;
          }
        }
        label539:
        label545:
        label551:
        label557:
        label563:
        label569:
        label575:
        for (int i14 = 3;; i14 = 0)
        {
          int i15 = printField(arrayOfChar, j, 'm', i13, true, i14);
          arrayOfChar[i15] = 's';
          i16 = i15 + 1;
          break;
          i6 = 0;
          break label372;
          bool1 = false;
          break label396;
          i8 = 0;
          break label404;
          bool2 = false;
          break label430;
          i10 = 0;
          break label438;
          bool3 = false;
          break label464;
          i12 = 0;
          break label472;
        }
        i2 = 0;
      }
      label591:
      n = 0;
    }
  }
  
  private static int printField(char[] paramArrayOfChar, int paramInt1, char paramChar, int paramInt2, boolean paramBoolean, int paramInt3)
  {
    int n;
    int i;
    if ((paramBoolean) || (paramInt1 > 0))
    {
      if (((!paramBoolean) || (paramInt3 < 3)) && (paramInt1 <= 99)) {
        break label137;
      }
      n = paramInt1 / 100;
      paramArrayOfChar[paramInt2] = ((char)(n + 48));
      i = paramInt2 + 1;
    }
    for (int j = paramInt1 - n * 100;; j = paramInt1)
    {
      if (((paramBoolean) && (paramInt3 >= 2)) || (j > 9) || (paramInt2 != i))
      {
        int k = j / 10;
        paramArrayOfChar[i] = ((char)(k + 48));
        i++;
        j -= k * 10;
      }
      paramArrayOfChar[i] = ((char)(j + 48));
      int m = i + 1;
      paramArrayOfChar[m] = paramChar;
      paramInt2 = m + 1;
      return paramInt2;
      label137:
      i = paramInt2;
    }
  }
}


/* Location:           C:\Users\dreadiscool\Desktop\tools\classes-dex2jar.jar
 * Qualified Name:     android.support.v4.util.TimeUtils
 * JD-Core Version:    0.7.0.1
 */