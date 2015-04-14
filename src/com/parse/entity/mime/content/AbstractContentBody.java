package com.parse.entity.mime.content;

public abstract class AbstractContentBody
  implements ContentBody
{
  private final String mediaType;
  private final String mimeType;
  private final String subType;
  
  public AbstractContentBody(String paramString)
  {
    if (paramString == null) {
      throw new IllegalArgumentException("MIME type may not be null");
    }
    this.mimeType = paramString;
    int i = paramString.indexOf('/');
    if (i != -1) {
      this.mediaType = paramString.substring(0, i);
    }
    for (this.subType = paramString.substring(i + 1);; this.subType = null)
    {
      return;
      this.mediaType = paramString;
    }
  }
  
  public String getMediaType()
  {
    return this.mediaType;
  }
  
  public String getMimeType()
  {
    return this.mimeType;
  }
  
  public String getSubType()
  {
    return this.subType;
  }
}


/* Location:           C:\Users\dreadiscool\Desktop\tools\classes-dex2jar.jar
 * Qualified Name:     com.parse.entity.mime.content.AbstractContentBody
 * JD-Core Version:    0.7.0.1
 */