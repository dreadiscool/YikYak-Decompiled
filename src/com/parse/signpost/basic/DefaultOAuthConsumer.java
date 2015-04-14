package com.parse.signpost.basic;

import com.parse.signpost.AbstractOAuthConsumer;
import com.parse.signpost.http.HttpRequest;
import java.net.HttpURLConnection;

public class DefaultOAuthConsumer
  extends AbstractOAuthConsumer
{
  private static final long serialVersionUID = 1L;
  
  public DefaultOAuthConsumer(String paramString1, String paramString2)
  {
    super(paramString1, paramString2);
  }
  
  protected HttpRequest wrap(Object paramObject)
  {
    if (!(paramObject instanceof HttpURLConnection)) {
      throw new IllegalArgumentException("The default consumer expects requests of type java.net.HttpURLConnection");
    }
    return new HttpURLConnectionRequestAdapter((HttpURLConnection)paramObject);
  }
}


/* Location:           C:\Users\dreadiscool\Desktop\tools\classes-dex2jar.jar
 * Qualified Name:     com.parse.signpost.basic.DefaultOAuthConsumer
 * JD-Core Version:    0.7.0.1
 */