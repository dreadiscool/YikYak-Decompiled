package com.parse.entity.mime.content;

import java.io.InputStream;
import java.io.OutputStream;

public class InputStreamBody
  extends AbstractContentBody
{
  private final String filename;
  private final InputStream in;
  
  public InputStreamBody(InputStream paramInputStream, String paramString)
  {
    this(paramInputStream, "application/octet-stream", paramString);
  }
  
  public InputStreamBody(InputStream paramInputStream, String paramString1, String paramString2)
  {
    super(paramString1);
    if (paramInputStream == null) {
      throw new IllegalArgumentException("Input stream may not be null");
    }
    this.in = paramInputStream;
    this.filename = paramString2;
  }
  
  public String getCharset()
  {
    return null;
  }
  
  public long getContentLength()
  {
    return -1L;
  }
  
  public String getFilename()
  {
    return this.filename;
  }
  
  public InputStream getInputStream()
  {
    return this.in;
  }
  
  public String getTransferEncoding()
  {
    return "binary";
  }
  
  public void writeTo(OutputStream paramOutputStream)
  {
    if (paramOutputStream == null) {
      throw new IllegalArgumentException("Output stream may not be null");
    }
    try
    {
      byte[] arrayOfByte = new byte[4096];
      for (;;)
      {
        int i = this.in.read(arrayOfByte);
        if (i == -1) {
          break;
        }
        paramOutputStream.write(arrayOfByte, 0, i);
      }
      paramOutputStream.flush();
    }
    finally
    {
      this.in.close();
    }
    this.in.close();
  }
  
  @Deprecated
  public void writeTo(OutputStream paramOutputStream, int paramInt)
  {
    writeTo(paramOutputStream);
  }
}


/* Location:           C:\Users\dreadiscool\Desktop\tools\classes-dex2jar.jar
 * Qualified Name:     com.parse.entity.mime.content.InputStreamBody
 * JD-Core Version:    0.7.0.1
 */