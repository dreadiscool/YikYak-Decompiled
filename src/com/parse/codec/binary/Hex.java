package com.parse.codec.binary;

import com.parse.codec.BinaryDecoder;
import com.parse.codec.BinaryEncoder;
import com.parse.codec.DecoderException;
import java.io.UnsupportedEncodingException;

public class Hex
  implements BinaryDecoder, BinaryEncoder
{
  public static final String DEFAULT_CHARSET_NAME = "UTF-8";
  private static final char[] DIGITS_LOWER;
  private static final char[] DIGITS_UPPER;
  private final String charsetName;
  
  static
  {
    char[] arrayOfChar1 = new char[16];
    arrayOfChar1[0] = 48;
    arrayOfChar1[1] = 49;
    arrayOfChar1[2] = 50;
    arrayOfChar1[3] = 51;
    arrayOfChar1[4] = 52;
    arrayOfChar1[5] = 53;
    arrayOfChar1[6] = 54;
    arrayOfChar1[7] = 55;
    arrayOfChar1[8] = 56;
    arrayOfChar1[9] = 57;
    arrayOfChar1[10] = 97;
    arrayOfChar1[11] = 98;
    arrayOfChar1[12] = 99;
    arrayOfChar1[13] = 100;
    arrayOfChar1[14] = 101;
    arrayOfChar1[15] = 102;
    DIGITS_LOWER = arrayOfChar1;
    char[] arrayOfChar2 = new char[16];
    arrayOfChar2[0] = 48;
    arrayOfChar2[1] = 49;
    arrayOfChar2[2] = 50;
    arrayOfChar2[3] = 51;
    arrayOfChar2[4] = 52;
    arrayOfChar2[5] = 53;
    arrayOfChar2[6] = 54;
    arrayOfChar2[7] = 55;
    arrayOfChar2[8] = 56;
    arrayOfChar2[9] = 57;
    arrayOfChar2[10] = 65;
    arrayOfChar2[11] = 66;
    arrayOfChar2[12] = 67;
    arrayOfChar2[13] = 68;
    arrayOfChar2[14] = 69;
    arrayOfChar2[15] = 70;
    DIGITS_UPPER = arrayOfChar2;
  }
  
  public Hex()
  {
    this.charsetName = "UTF-8";
  }
  
  public Hex(String paramString)
  {
    this.charsetName = paramString;
  }
  
  public static byte[] decodeHex(char[] paramArrayOfChar)
  {
    int i = 0;
    int j = paramArrayOfChar.length;
    if ((j & 0x1) != 0) {
      throw new DecoderException("Odd number of characters.");
    }
    byte[] arrayOfByte = new byte[j >> 1];
    for (int k = 0; i < j; k++)
    {
      int m = toDigit(paramArrayOfChar[i], i) << 4;
      int n = i + 1;
      int i1 = m | toDigit(paramArrayOfChar[n], n);
      i = n + 1;
      arrayOfByte[k] = ((byte)(i1 & 0xFF));
    }
    return arrayOfByte;
  }
  
  public static char[] encodeHex(byte[] paramArrayOfByte)
  {
    return encodeHex(paramArrayOfByte, true);
  }
  
  public static char[] encodeHex(byte[] paramArrayOfByte, boolean paramBoolean)
  {
    if (paramBoolean) {}
    for (char[] arrayOfChar = DIGITS_LOWER;; arrayOfChar = DIGITS_UPPER) {
      return encodeHex(paramArrayOfByte, arrayOfChar);
    }
  }
  
  protected static char[] encodeHex(byte[] paramArrayOfByte, char[] paramArrayOfChar)
  {
    int i = 0;
    int j = paramArrayOfByte.length;
    char[] arrayOfChar = new char[j << 1];
    for (int k = 0; k < j; k++)
    {
      int m = i + 1;
      arrayOfChar[i] = paramArrayOfChar[((0xF0 & paramArrayOfByte[k]) >>> 4)];
      i = m + 1;
      arrayOfChar[m] = paramArrayOfChar[(0xF & paramArrayOfByte[k])];
    }
    return arrayOfChar;
  }
  
  public static String encodeHexString(byte[] paramArrayOfByte)
  {
    return new String(encodeHex(paramArrayOfByte));
  }
  
  protected static int toDigit(char paramChar, int paramInt)
  {
    int i = Character.digit(paramChar, 16);
    if (i == -1) {
      throw new DecoderException("Illegal hexadecimal character " + paramChar + " at index " + paramInt);
    }
    return i;
  }
  
  /* Error */
  public Object decode(Object paramObject)
  {
    // Byte code:
    //   0: aload_1
    //   1: instanceof 74
    //   4: ifeq +16 -> 20
    //   7: aload_1
    //   8: checkcast 74	java/lang/String
    //   11: invokevirtual 113	java/lang/String:toCharArray	()[C
    //   14: astore_3
    //   15: aload_3
    //   16: invokestatic 115	com/parse/codec/binary/Hex:decodeHex	([C)[B
    //   19: areturn
    //   20: aload_1
    //   21: checkcast 116	[C
    //   24: checkcast 116	[C
    //   27: astore_3
    //   28: goto -13 -> 15
    //   31: astore_2
    //   32: new 54	com/parse/codec/DecoderException
    //   35: dup
    //   36: aload_2
    //   37: invokevirtual 119	java/lang/ClassCastException:getMessage	()Ljava/lang/String;
    //   40: aload_2
    //   41: invokespecial 122	com/parse/codec/DecoderException:<init>	(Ljava/lang/String;Ljava/lang/Throwable;)V
    //   44: athrow
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	45	0	this	Hex
    //   0	45	1	paramObject	Object
    //   31	10	2	localClassCastException	java.lang.ClassCastException
    //   14	14	3	arrayOfChar	char[]
    // Exception table:
    //   from	to	target	type
    //   0	28	31	java/lang/ClassCastException
  }
  
  public byte[] decode(byte[] paramArrayOfByte)
  {
    try
    {
      byte[] arrayOfByte = decodeHex(new String(paramArrayOfByte, getCharsetName()).toCharArray());
      return arrayOfByte;
    }
    catch (UnsupportedEncodingException localUnsupportedEncodingException)
    {
      throw new DecoderException(localUnsupportedEncodingException.getMessage(), localUnsupportedEncodingException);
    }
  }
  
  /* Error */
  public Object encode(Object paramObject)
  {
    // Byte code:
    //   0: aload_1
    //   1: instanceof 74
    //   4: ifeq +22 -> 26
    //   7: aload_1
    //   8: checkcast 74	java/lang/String
    //   11: aload_0
    //   12: invokevirtual 128	com/parse/codec/binary/Hex:getCharsetName	()Ljava/lang/String;
    //   15: invokevirtual 137	java/lang/String:getBytes	(Ljava/lang/String;)[B
    //   18: astore 4
    //   20: aload 4
    //   22: invokestatic 76	com/parse/codec/binary/Hex:encodeHex	([B)[C
    //   25: areturn
    //   26: aload_1
    //   27: checkcast 139	[B
    //   30: checkcast 139	[B
    //   33: astore 4
    //   35: goto -15 -> 20
    //   38: astore_3
    //   39: new 141	com/parse/codec/EncoderException
    //   42: dup
    //   43: aload_3
    //   44: invokevirtual 119	java/lang/ClassCastException:getMessage	()Ljava/lang/String;
    //   47: aload_3
    //   48: invokespecial 142	com/parse/codec/EncoderException:<init>	(Ljava/lang/String;Ljava/lang/Throwable;)V
    //   51: athrow
    //   52: astore_2
    //   53: new 141	com/parse/codec/EncoderException
    //   56: dup
    //   57: aload_2
    //   58: invokevirtual 132	java/io/UnsupportedEncodingException:getMessage	()Ljava/lang/String;
    //   61: aload_2
    //   62: invokespecial 142	com/parse/codec/EncoderException:<init>	(Ljava/lang/String;Ljava/lang/Throwable;)V
    //   65: athrow
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	66	0	this	Hex
    //   0	66	1	paramObject	Object
    //   52	10	2	localUnsupportedEncodingException	UnsupportedEncodingException
    //   38	10	3	localClassCastException	java.lang.ClassCastException
    //   18	16	4	arrayOfByte	byte[]
    // Exception table:
    //   from	to	target	type
    //   0	35	38	java/lang/ClassCastException
    //   0	35	52	java/io/UnsupportedEncodingException
  }
  
  public byte[] encode(byte[] paramArrayOfByte)
  {
    return StringUtils.getBytesUnchecked(encodeHexString(paramArrayOfByte), getCharsetName());
  }
  
  public String getCharsetName()
  {
    return this.charsetName;
  }
  
  public String toString()
  {
    return super.toString() + "[charsetName=" + this.charsetName + "]";
  }
}


/* Location:           C:\Users\dreadiscool\Desktop\tools\classes-dex2jar.jar
 * Qualified Name:     com.parse.codec.binary.Hex
 * JD-Core Version:    0.7.0.1
 */