package com.parse;

import com.parse.entity.mime.HttpMultipartMode;
import com.parse.entity.mime.MultipartEntity;
import java.io.OutputStream;
import java.nio.charset.Charset;

class CountingMultipartEntity
  extends MultipartEntity
{
  private final ProgressCallback progressCallback;
  
  public CountingMultipartEntity(ProgressCallback paramProgressCallback)
  {
    this.progressCallback = paramProgressCallback;
  }
  
  public CountingMultipartEntity(HttpMultipartMode paramHttpMultipartMode, ProgressCallback paramProgressCallback)
  {
    super(paramHttpMultipartMode);
    this.progressCallback = paramProgressCallback;
  }
  
  public CountingMultipartEntity(HttpMultipartMode paramHttpMultipartMode, String paramString, Charset paramCharset, ProgressCallback paramProgressCallback)
  {
    super(paramHttpMultipartMode, paramString, paramCharset);
    this.progressCallback = paramProgressCallback;
  }
  
  public void writeTo(OutputStream paramOutputStream)
  {
    super.writeTo(new CountingMultipartEntity.CountingOutputStream(paramOutputStream, this.progressCallback, getContentLength()));
  }
}


/* Location:           C:\Users\dreadiscool\Desktop\tools\classes-dex2jar.jar
 * Qualified Name:     com.parse.CountingMultipartEntity
 * JD-Core Version:    0.7.0.1
 */