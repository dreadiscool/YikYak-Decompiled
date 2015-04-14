package com.parse.entity.mime.content;

import java.io.ByteArrayInputStream;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.OutputStream;
import java.io.Reader;
import java.io.UnsupportedEncodingException;
import java.nio.charset.Charset;

public class StringBody
  extends AbstractContentBody
{
  private final Charset charset;
  private final byte[] content;
  
  public StringBody(String paramString)
  {
    this(paramString, "text/plain", null);
  }
  
  public StringBody(String paramString1, String paramString2, Charset paramCharset)
  {
    super(paramString2);
    if (paramString1 == null) {
      throw new IllegalArgumentException("Text may not be null");
    }
    if (paramCharset == null) {
      paramCharset = Charset.forName("US-ASCII");
    }
    this.content = paramString1.getBytes(paramCharset.name());
    this.charset = paramCharset;
  }
  
  public StringBody(String paramString, Charset paramCharset)
  {
    this(paramString, "text/plain", paramCharset);
  }
  
  public static StringBody create(String paramString)
  {
    return create(paramString, null, null);
  }
  
  public static StringBody create(String paramString1, String paramString2, Charset paramCharset)
  {
    try
    {
      StringBody localStringBody = new StringBody(paramString1, paramString2, paramCharset);
      return localStringBody;
    }
    catch (UnsupportedEncodingException localUnsupportedEncodingException)
    {
      throw new IllegalArgumentException("Charset " + paramCharset + " is not supported", localUnsupportedEncodingException);
    }
  }
  
  public static StringBody create(String paramString, Charset paramCharset)
  {
    return create(paramString, null, paramCharset);
  }
  
  public String getCharset()
  {
    return this.charset.name();
  }
  
  public long getContentLength()
  {
    return this.content.length;
  }
  
  public String getFilename()
  {
    return null;
  }
  
  public Reader getReader()
  {
    return new InputStreamReader(new ByteArrayInputStream(this.content), this.charset);
  }
  
  public String getTransferEncoding()
  {
    return "8bit";
  }
  
  public void writeTo(OutputStream paramOutputStream)
  {
    if (paramOutputStream == null) {
      throw new IllegalArgumentException("Output stream may not be null");
    }
    ByteArrayInputStream localByteArrayInputStream = new ByteArrayInputStream(this.content);
    byte[] arrayOfByte = new byte[4096];
    for (;;)
    {
      int i = localByteArrayInputStream.read(arrayOfByte);
      if (i == -1) {
        break;
      }
      paramOutputStream.write(arrayOfByte, 0, i);
    }
    paramOutputStream.flush();
  }
  
  @Deprecated
  public void writeTo(OutputStream paramOutputStream, int paramInt)
  {
    writeTo(paramOutputStream);
  }
}


/* Location:           C:\Users\dreadiscool\Desktop\tools\classes-dex2jar.jar
 * Qualified Name:     com.parse.entity.mime.content.StringBody
 * JD-Core Version:    0.7.0.1
 */