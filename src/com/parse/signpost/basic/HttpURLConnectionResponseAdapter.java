package com.parse.signpost.basic;

import com.parse.signpost.http.HttpResponse;
import java.io.InputStream;
import java.net.HttpURLConnection;

public class HttpURLConnectionResponseAdapter
  implements HttpResponse
{
  private HttpURLConnection connection;
  
  public HttpURLConnectionResponseAdapter(HttpURLConnection paramHttpURLConnection)
  {
    this.connection = paramHttpURLConnection;
  }
  
  public InputStream getContent()
  {
    return this.connection.getInputStream();
  }
  
  public String getReasonPhrase()
  {
    return this.connection.getResponseMessage();
  }
  
  public int getStatusCode()
  {
    return this.connection.getResponseCode();
  }
  
  public Object unwrap()
  {
    return this.connection;
  }
}


/* Location:           C:\Users\dreadiscool\Desktop\tools\classes-dex2jar.jar
 * Qualified Name:     com.parse.signpost.basic.HttpURLConnectionResponseAdapter
 * JD-Core Version:    0.7.0.1
 */