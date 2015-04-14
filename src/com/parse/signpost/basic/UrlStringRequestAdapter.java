package com.parse.signpost.basic;

import com.parse.signpost.http.HttpRequest;
import java.io.InputStream;
import java.util.Collections;
import java.util.Map;

public class UrlStringRequestAdapter
  implements HttpRequest
{
  private String url;
  
  public UrlStringRequestAdapter(String paramString)
  {
    this.url = paramString;
  }
  
  public Map<String, String> getAllHeaders()
  {
    return Collections.emptyMap();
  }
  
  public String getContentType()
  {
    return null;
  }
  
  public String getHeader(String paramString)
  {
    return null;
  }
  
  public InputStream getMessagePayload()
  {
    return null;
  }
  
  public String getMethod()
  {
    return "GET";
  }
  
  public String getRequestUrl()
  {
    return this.url;
  }
  
  public void setHeader(String paramString1, String paramString2) {}
  
  public void setRequestUrl(String paramString)
  {
    this.url = paramString;
  }
  
  public Object unwrap()
  {
    return this.url;
  }
}


/* Location:           C:\Users\dreadiscool\Desktop\tools\classes-dex2jar.jar
 * Qualified Name:     com.parse.signpost.basic.UrlStringRequestAdapter
 * JD-Core Version:    0.7.0.1
 */