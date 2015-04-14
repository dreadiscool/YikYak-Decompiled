package com.parse.entity.mime;

public enum HttpMultipartMode
{
  static
  {
    BROWSER_COMPATIBLE = new HttpMultipartMode("BROWSER_COMPATIBLE", 1);
    HttpMultipartMode[] arrayOfHttpMultipartMode = new HttpMultipartMode[2];
    arrayOfHttpMultipartMode[0] = STRICT;
    arrayOfHttpMultipartMode[1] = BROWSER_COMPATIBLE;
    $VALUES = arrayOfHttpMultipartMode;
  }
  
  private HttpMultipartMode() {}
}


/* Location:           C:\Users\dreadiscool\Desktop\tools\classes-dex2jar.jar
 * Qualified Name:     com.parse.entity.mime.HttpMultipartMode
 * JD-Core Version:    0.7.0.1
 */