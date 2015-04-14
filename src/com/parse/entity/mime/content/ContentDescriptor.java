package com.parse.entity.mime.content;

public abstract interface ContentDescriptor
{
  public abstract String getCharset();
  
  public abstract long getContentLength();
  
  public abstract String getMediaType();
  
  public abstract String getMimeType();
  
  public abstract String getSubType();
  
  public abstract String getTransferEncoding();
}


/* Location:           C:\Users\dreadiscool\Desktop\tools\classes-dex2jar.jar
 * Qualified Name:     com.parse.entity.mime.content.ContentDescriptor
 * JD-Core Version:    0.7.0.1
 */