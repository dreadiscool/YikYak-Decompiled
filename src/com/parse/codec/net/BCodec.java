package com.parse.codec.net;

import com.parse.codec.DecoderException;
import com.parse.codec.EncoderException;
import com.parse.codec.StringDecoder;
import com.parse.codec.StringEncoder;
import com.parse.codec.binary.Base64;
import java.io.UnsupportedEncodingException;

public class BCodec
  extends RFC1522Codec
  implements StringDecoder, StringEncoder
{
  private final String charset;
  
  public BCodec()
  {
    this("UTF-8");
  }
  
  public BCodec(String paramString)
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
    throw new DecoderException("Objects of type " + paramObject.getClass().getName() + " cannot be decoded using BCodec");
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
    if (paramArrayOfByte == null) {}
    for (byte[] arrayOfByte = null;; arrayOfByte = Base64.decodeBase64(paramArrayOfByte)) {
      return arrayOfByte;
    }
  }
  
  protected byte[] doEncoding(byte[] paramArrayOfByte)
  {
    if (paramArrayOfByte == null) {}
    for (byte[] arrayOfByte = null;; arrayOfByte = Base64.encodeBase64(paramArrayOfByte)) {
      return arrayOfByte;
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
    throw new EncoderException("Objects of type " + paramObject.getClass().getName() + " cannot be encoded using BCodec");
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
    return "B";
  }
}


/* Location:           C:\Users\dreadiscool\Desktop\tools\classes-dex2jar.jar
 * Qualified Name:     com.parse.codec.net.BCodec
 * JD-Core Version:    0.7.0.1
 */