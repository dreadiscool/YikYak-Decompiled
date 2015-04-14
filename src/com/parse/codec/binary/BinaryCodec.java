package com.parse.codec.binary;

import com.parse.codec.BinaryDecoder;
import com.parse.codec.BinaryEncoder;
import com.parse.codec.DecoderException;
import com.parse.codec.EncoderException;

public class BinaryCodec
  implements BinaryDecoder, BinaryEncoder
{
  private static final int[] BITS;
  private static final int BIT_0 = 1;
  private static final int BIT_1 = 2;
  private static final int BIT_2 = 4;
  private static final int BIT_3 = 8;
  private static final int BIT_4 = 16;
  private static final int BIT_5 = 32;
  private static final int BIT_6 = 64;
  private static final int BIT_7 = 128;
  private static final byte[] EMPTY_BYTE_ARRAY;
  private static final char[] EMPTY_CHAR_ARRAY = new char[0];
  
  static
  {
    EMPTY_BYTE_ARRAY = new byte[0];
    int[] arrayOfInt = new int[8];
    arrayOfInt[0] = 1;
    arrayOfInt[1] = 2;
    arrayOfInt[2] = 4;
    arrayOfInt[3] = 8;
    arrayOfInt[4] = 16;
    arrayOfInt[5] = 32;
    arrayOfInt[6] = 64;
    arrayOfInt[7] = 128;
    BITS = arrayOfInt;
  }
  
  public static byte[] fromAscii(byte[] paramArrayOfByte)
  {
    if (isEmpty(paramArrayOfByte)) {}
    byte[] arrayOfByte;
    for (Object localObject = EMPTY_BYTE_ARRAY;; localObject = arrayOfByte)
    {
      return localObject;
      arrayOfByte = new byte[paramArrayOfByte.length >> 3];
      int i = -1 + paramArrayOfByte.length;
      int j = 0;
      while (j < arrayOfByte.length)
      {
        for (int k = 0; k < BITS.length; k++) {
          if (paramArrayOfByte[(i - k)] == 49) {
            arrayOfByte[j] = ((byte)(arrayOfByte[j] | BITS[k]));
          }
        }
        j++;
        i -= 8;
      }
    }
  }
  
  public static byte[] fromAscii(char[] paramArrayOfChar)
  {
    if ((paramArrayOfChar == null) || (paramArrayOfChar.length == 0)) {}
    byte[] arrayOfByte;
    for (Object localObject = EMPTY_BYTE_ARRAY;; localObject = arrayOfByte)
    {
      return localObject;
      arrayOfByte = new byte[paramArrayOfChar.length >> 3];
      int i = -1 + paramArrayOfChar.length;
      int j = 0;
      while (j < arrayOfByte.length)
      {
        for (int k = 0; k < BITS.length; k++) {
          if (paramArrayOfChar[(i - k)] == '1') {
            arrayOfByte[j] = ((byte)(arrayOfByte[j] | BITS[k]));
          }
        }
        j++;
        i -= 8;
      }
    }
  }
  
  private static boolean isEmpty(byte[] paramArrayOfByte)
  {
    if ((paramArrayOfByte == null) || (paramArrayOfByte.length == 0)) {}
    for (boolean bool = true;; bool = false) {
      return bool;
    }
  }
  
  public static byte[] toAsciiBytes(byte[] paramArrayOfByte)
  {
    if (isEmpty(paramArrayOfByte)) {}
    byte[] arrayOfByte;
    for (Object localObject = EMPTY_BYTE_ARRAY;; localObject = arrayOfByte)
    {
      return localObject;
      arrayOfByte = new byte[paramArrayOfByte.length << 3];
      int i = -1 + arrayOfByte.length;
      int j = 0;
      while (j < paramArrayOfByte.length)
      {
        int k = 0;
        if (k < BITS.length)
        {
          if ((paramArrayOfByte[j] & BITS[k]) == 0) {
            arrayOfByte[(i - k)] = 48;
          }
          for (;;)
          {
            k++;
            break;
            arrayOfByte[(i - k)] = 49;
          }
        }
        j++;
        i -= 8;
      }
    }
  }
  
  public static char[] toAsciiChars(byte[] paramArrayOfByte)
  {
    if (isEmpty(paramArrayOfByte)) {}
    char[] arrayOfChar;
    for (Object localObject = EMPTY_CHAR_ARRAY;; localObject = arrayOfChar)
    {
      return localObject;
      arrayOfChar = new char[paramArrayOfByte.length << 3];
      int i = -1 + arrayOfChar.length;
      int j = 0;
      while (j < paramArrayOfByte.length)
      {
        int k = 0;
        if (k < BITS.length)
        {
          if ((paramArrayOfByte[j] & BITS[k]) == 0) {
            arrayOfChar[(i - k)] = '0';
          }
          for (;;)
          {
            k++;
            break;
            arrayOfChar[(i - k)] = '1';
          }
        }
        j++;
        i -= 8;
      }
    }
  }
  
  public static String toAsciiString(byte[] paramArrayOfByte)
  {
    return new String(toAsciiChars(paramArrayOfByte));
  }
  
  public Object decode(Object paramObject)
  {
    byte[] arrayOfByte;
    if (paramObject == null) {
      arrayOfByte = EMPTY_BYTE_ARRAY;
    }
    for (;;)
    {
      return arrayOfByte;
      if ((paramObject instanceof byte[]))
      {
        arrayOfByte = fromAscii((byte[])paramObject);
      }
      else if ((paramObject instanceof char[]))
      {
        arrayOfByte = fromAscii((char[])paramObject);
      }
      else
      {
        if (!(paramObject instanceof String)) {
          break;
        }
        arrayOfByte = fromAscii(((String)paramObject).toCharArray());
      }
    }
    throw new DecoderException("argument not a byte array");
  }
  
  public byte[] decode(byte[] paramArrayOfByte)
  {
    return fromAscii(paramArrayOfByte);
  }
  
  public Object encode(Object paramObject)
  {
    if (!(paramObject instanceof byte[])) {
      throw new EncoderException("argument not a byte array");
    }
    return toAsciiChars((byte[])paramObject);
  }
  
  public byte[] encode(byte[] paramArrayOfByte)
  {
    return toAsciiBytes(paramArrayOfByte);
  }
  
  public byte[] toByteArray(String paramString)
  {
    if (paramString == null) {}
    for (byte[] arrayOfByte = EMPTY_BYTE_ARRAY;; arrayOfByte = fromAscii(paramString.toCharArray())) {
      return arrayOfByte;
    }
  }
}


/* Location:           C:\Users\dreadiscool\Desktop\tools\classes-dex2jar.jar
 * Qualified Name:     com.parse.codec.binary.BinaryCodec
 * JD-Core Version:    0.7.0.1
 */