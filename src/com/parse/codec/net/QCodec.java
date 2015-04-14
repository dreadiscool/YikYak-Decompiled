package com.parse.codec.net;

import com.parse.codec.DecoderException;
import com.parse.codec.EncoderException;
import com.parse.codec.StringDecoder;
import com.parse.codec.StringEncoder;
import java.io.UnsupportedEncodingException;
import java.util.BitSet;

public class QCodec
  extends RFC1522Codec
  implements StringDecoder, StringEncoder
{
  private static final byte BLANK = 32;
  private static final BitSet PRINTABLE_CHARS = new BitSet(256);
  private static final byte UNDERSCORE = 95;
  private final String charset;
  private boolean encodeBlanks = false;
  
  static
  {
    PRINTABLE_CHARS.set(32);
    PRINTABLE_CHARS.set(33);
    PRINTABLE_CHARS.set(34);
    PRINTABLE_CHARS.set(35);
    PRINTABLE_CHARS.set(36);
    PRINTABLE_CHARS.set(37);
    PRINTABLE_CHARS.set(38);
    PRINTABLE_CHARS.set(39);
    PRINTABLE_CHARS.set(40);
    PRINTABLE_CHARS.set(41);
    PRINTABLE_CHARS.set(42);
    PRINTABLE_CHARS.set(43);
    PRINTABLE_CHARS.set(44);
    PRINTABLE_CHARS.set(45);
    PRINTABLE_CHARS.set(46);
    PRINTABLE_CHARS.set(47);
    for (int i = 48; i <= 57; i++) {
      PRINTABLE_CHARS.set(i);
    }
    PRINTABLE_CHARS.set(58);
    PRINTABLE_CHARS.set(59);
    PRINTABLE_CHARS.set(60);
    PRINTABLE_CHARS.set(62);
    PRINTABLE_CHARS.set(64);
    for (int j = 65; j <= 90; j++) {
      PRINTABLE_CHARS.set(j);
    }
    PRINTABLE_CHARS.set(91);
    PRINTABLE_CHARS.set(92);
    PRINTABLE_CHARS.set(93);
    PRINTABLE_CHARS.set(94);
    PRINTABLE_CHARS.set(96);
    for (int k = 97; k <= 122; k++) {
      PRINTABLE_CHARS.set(k);
    }
    PRINTABLE_CHARS.set(123);
    PRINTABLE_CHARS.set(124);
    PRINTABLE_CHARS.set(125);
    PRINTABLE_CHARS.set(126);
  }
  
  public QCodec()
  {
    this("UTF-8");
  }
  
  public QCodec(String paramString)
  {
    this.charset = paramString;
  }
  
  public Object decode(Object paramObject)
  {
    if (paramObject == null) {}
    for (Object localObject = null;; localObject = decode((String)paramObject))
    {
      return localObject;
      if (!(paramObject instanceof String)) {
        break;
      }
    }
    throw new DecoderException("Objects of type " + paramObject.getClass().getName() + " cannot be decoded using Q codec");
  }
  
  public String decode(String paramString)
  {
    Object localObject;
    if (paramString == null) {
      localObject = null;
    }
    for (;;)
    {
      return localObject;
      try
      {
        String str = decodeText(paramString);
        localObject = str;
      }
      catch (UnsupportedEncodingException localUnsupportedEncodingException)
      {
        throw new DecoderException(localUnsupportedEncodingException.getMessage(), localUnsupportedEncodingException);
      }
    }
  }
  
  protected byte[] doDecoding(byte[] paramArrayOfByte)
  {
    int i = 0;
    byte[] arrayOfByte1;
    if (paramArrayOfByte == null)
    {
      arrayOfByte1 = null;
      return arrayOfByte1;
    }
    int j = 0;
    if (j < paramArrayOfByte.length) {
      if (paramArrayOfByte[j] != 95) {}
    }
    for (int k = 1;; k = 0)
    {
      if (k != 0)
      {
        byte[] arrayOfByte2 = new byte[paramArrayOfByte.length];
        label42:
        if (i < paramArrayOfByte.length)
        {
          int m = paramArrayOfByte[i];
          if (m != 95) {
            arrayOfByte2[i] = m;
          }
          for (;;)
          {
            i++;
            break label42;
            j++;
            break;
            arrayOfByte2[i] = 32;
          }
        }
        arrayOfByte1 = QuotedPrintableCodec.decodeQuotedPrintable(arrayOfByte2);
        break;
      }
      arrayOfByte1 = QuotedPrintableCodec.decodeQuotedPrintable(paramArrayOfByte);
      break;
    }
  }
  
  protected byte[] doEncoding(byte[] paramArrayOfByte)
  {
    if (paramArrayOfByte == null) {}
    byte[] arrayOfByte;
    for (Object localObject = null;; localObject = arrayOfByte)
    {
      return localObject;
      arrayOfByte = QuotedPrintableCodec.encodeQuotedPrintable(PRINTABLE_CHARS, paramArrayOfByte);
      if (this.encodeBlanks) {
        for (int i = 0; i < arrayOfByte.length; i++) {
          if (arrayOfByte[i] == 32) {
            arrayOfByte[i] = 95;
          }
        }
      }
    }
  }
  
  public Object encode(Object paramObject)
  {
    if (paramObject == null) {}
    for (Object localObject = null;; localObject = encode((String)paramObject))
    {
      return localObject;
      if (!(paramObject instanceof String)) {
        break;
      }
    }
    throw new EncoderException("Objects of type " + paramObject.getClass().getName() + " cannot be encoded using Q codec");
  }
  
  public String encode(String paramString)
  {
    if (paramString == null) {}
    for (String str = null;; str = encode(paramString, getDefaultCharset())) {
      return str;
    }
  }
  
  public String encode(String paramString1, String paramString2)
  {
    Object localObject;
    if (paramString1 == null) {
      localObject = null;
    }
    for (;;)
    {
      return localObject;
      try
      {
        String str = encodeText(paramString1, paramString2);
        localObject = str;
      }
      catch (UnsupportedEncodingException localUnsupportedEncodingException)
      {
        throw new EncoderException(localUnsupportedEncodingException.getMessage(), localUnsupportedEncodingException);
      }
    }
  }
  
  public String getDefaultCharset()
  {
    return this.charset;
  }
  
  protected String getEncoding()
  {
    return "Q";
  }
  
  public boolean isEncodeBlanks()
  {
    return this.encodeBlanks;
  }
  
  public void setEncodeBlanks(boolean paramBoolean)
  {
    this.encodeBlanks = paramBoolean;
  }
}


/* Location:           C:\Users\dreadiscool\Desktop\tools\classes-dex2jar.jar
 * Qualified Name:     com.parse.codec.net.QCodec
 * JD-Core Version:    0.7.0.1
 */