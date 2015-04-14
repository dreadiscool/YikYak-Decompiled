package com.parse.signpost.commonshttp;

import java.io.InputStream;
import org.apache.http.HttpEntity;
import org.apache.http.StatusLine;

public class HttpResponseAdapter
  implements com.parse.signpost.http.HttpResponse
{
  private org.apache.http.HttpResponse response;
  
  public HttpResponseAdapter(org.apache.http.HttpResponse paramHttpResponse)
  {
    this.response = paramHttpResponse;
  }
  
  public InputStream getContent()
  {
    return this.response.getEntity().getContent();
  }
  
  public String getReasonPhrase()
  {
    return this.response.getStatusLine().getReasonPhrase();
  }
  
  public int getStatusCode()
  {
    return this.response.getStatusLine().getStatusCode();
  }
  
  public Object unwrap()
  {
    return this.response;
  }
}


/* Location:           C:\Users\dreadiscool\Desktop\tools\classes-dex2jar.jar
 * Qualified Name:     com.parse.signpost.commonshttp.HttpResponseAdapter
 * JD-Core Version:    0.7.0.1
 */