package com.parse.signpost.signature;

import com.parse.signpost.OAuth;
import com.parse.signpost.exception.OAuthMessageSignerException;
import com.parse.signpost.http.HttpParameters;
import com.parse.signpost.http.HttpRequest;
import java.net.URI;
import java.util.Iterator;
import java.util.Set;

public class SignatureBaseString
{
  private HttpRequest request;
  private HttpParameters requestParameters;
  
  public SignatureBaseString(HttpRequest paramHttpRequest, HttpParameters paramHttpParameters)
  {
    this.request = paramHttpRequest;
    this.requestParameters = paramHttpParameters;
  }
  
  public String generate()
  {
    try
    {
      String str1 = normalizeRequestUrl();
      String str2 = normalizeRequestParameters();
      String str3 = this.request.getMethod() + '&' + OAuth.percentEncode(str1) + '&' + OAuth.percentEncode(str2);
      return str3;
    }
    catch (Exception localException)
    {
      throw new OAuthMessageSignerException(localException);
    }
  }
  
  public String normalizeRequestParameters()
  {
    if (this.requestParameters == null) {}
    StringBuilder localStringBuilder;
    for (String str1 = "";; str1 = localStringBuilder.toString())
    {
      return str1;
      localStringBuilder = new StringBuilder();
      Iterator localIterator = this.requestParameters.keySet().iterator();
      int i = 0;
      if (localIterator.hasNext())
      {
        String str2 = (String)localIterator.next();
        if (("oauth_signature".equals(str2)) || ("realm".equals(str2))) {}
        for (;;)
        {
          i++;
          break;
          if (i > 0) {
            localStringBuilder.append("&");
          }
          localStringBuilder.append(this.requestParameters.getAsQueryString(str2));
        }
      }
    }
  }
  
  public String normalizeRequestUrl()
  {
    URI localURI = new URI(this.request.getRequestUrl());
    String str1 = localURI.getScheme().toLowerCase();
    String str2 = localURI.getAuthority().toLowerCase();
    if (((str1.equals("http")) && (localURI.getPort() == 80)) || ((str1.equals("https")) && (localURI.getPort() == 443))) {}
    for (int i = 1;; i = 0)
    {
      if (i != 0)
      {
        int j = str2.lastIndexOf(":");
        if (j >= 0) {
          str2 = str2.substring(0, j);
        }
      }
      String str3 = localURI.getRawPath();
      if ((str3 == null) || (str3.length() <= 0)) {
        str3 = "/";
      }
      return str1 + "://" + str2 + str3;
    }
  }
}


/* Location:           C:\Users\dreadiscool\Desktop\tools\classes-dex2jar.jar
 * Qualified Name:     com.parse.signpost.signature.SignatureBaseString
 * JD-Core Version:    0.7.0.1
 */