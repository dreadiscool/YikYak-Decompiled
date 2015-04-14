package com.parse.signpost.basic;

import com.parse.signpost.AbstractOAuthProvider;
import com.parse.signpost.http.HttpRequest;
import com.parse.signpost.http.HttpResponse;
import java.net.HttpURLConnection;
import java.net.URL;

public class DefaultOAuthProvider
  extends AbstractOAuthProvider
{
  private static final long serialVersionUID = 1L;
  
  public DefaultOAuthProvider(String paramString1, String paramString2, String paramString3)
  {
    super(paramString1, paramString2, paramString3);
  }
  
  protected void closeConnection(HttpRequest paramHttpRequest, HttpResponse paramHttpResponse)
  {
    HttpURLConnection localHttpURLConnection = (HttpURLConnection)paramHttpRequest.unwrap();
    if (localHttpURLConnection != null) {
      localHttpURLConnection.disconnect();
    }
  }
  
  protected HttpRequest createRequest(String paramString)
  {
    HttpURLConnection localHttpURLConnection = (HttpURLConnection)new URL(paramString).openConnection();
    localHttpURLConnection.setRequestMethod("POST");
    localHttpURLConnection.setAllowUserInteraction(false);
    localHttpURLConnection.setRequestProperty("Content-Length", "0");
    return new HttpURLConnectionRequestAdapter(localHttpURLConnection);
  }
  
  protected HttpResponse sendRequest(HttpRequest paramHttpRequest)
  {
    HttpURLConnection localHttpURLConnection = (HttpURLConnection)paramHttpRequest.unwrap();
    localHttpURLConnection.connect();
    return new HttpURLConnectionResponseAdapter(localHttpURLConnection);
  }
}


/* Location:           C:\Users\dreadiscool\Desktop\tools\classes-dex2jar.jar
 * Qualified Name:     com.parse.signpost.basic.DefaultOAuthProvider
 * JD-Core Version:    0.7.0.1
 */